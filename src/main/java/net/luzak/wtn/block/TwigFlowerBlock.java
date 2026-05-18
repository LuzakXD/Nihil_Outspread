package net.luzak.wtn.block;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;

import net.minecraft.tags.BlockTags;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.BlockPlaceContext;

import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SoundType;

import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;

import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.EnumProperty;

import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.material.PushReaction;

public class TwigFlowerBlock extends Block {

	public static final EnumProperty<PlantPart> PART =
		EnumProperty.create("part", PlantPart.class);

	public TwigFlowerBlock() {

		super(BlockBehaviour.Properties.of()
			.mapColor(MapColor.PLANT)
			.sound(SoundType.GRASS)
			.instabreak()
			.noCollission()
			.offsetType(BlockBehaviour.OffsetType.XZ)
			.pushReaction(PushReaction.DESTROY));

		this.registerDefaultState(
			this.stateDefinition.any()
				.setValue(PART, PlantPart.BOTTOM)
		);
	}

	@Override
	protected void createBlockStateDefinition(
		StateDefinition.Builder<Block, BlockState> builder
	) {
		builder.add(PART);
	}

	@Override
	public BlockState getStateForPlacement(BlockPlaceContext context) {

		BlockPos pos = context.getClickedPos();
		Level level = context.getLevel();

		if (
			level.getBlockState(pos.above()).canBeReplaced(context)
			&& level.getBlockState(pos.above(2)).canBeReplaced(context)
		) {

			return this.defaultBlockState()
				.setValue(PART, PlantPart.BOTTOM);
		}

		return null;
	}

	@Override
	public void setPlacedBy(
		Level level,
		BlockPos pos,
		BlockState state,
		LivingEntity placer,
		ItemStack stack
	) {

		level.setBlock(
			pos.above(),
			this.defaultBlockState()
				.setValue(PART, PlantPart.MIDDLE),
			3
		);

		level.setBlock(
			pos.above(2),
			this.defaultBlockState()
				.setValue(PART, PlantPart.TOP),
			3
		);
	}

	private boolean canPlantTypeSurvive(
		BlockState state,
		LevelReader world,
		BlockPos pos
	) {

		return state.is(BlockTags.DIRT)
			|| state.getBlock() == Blocks.FARMLAND;
	}

	@Override
	public boolean canSurvive(
		BlockState state,
		LevelReader level,
		BlockPos pos
	) {

		PlantPart part = state.getValue(PART);

		BlockState below = level.getBlockState(pos.below());
		BlockState above = level.getBlockState(pos.above());

		if (part == PlantPart.BOTTOM) {

			return canPlantTypeSurvive(
				below,
				level,
				pos.below()
			);

		}

		if (part == PlantPart.MIDDLE) {

			return below.is(this)
				&& above.is(this);

		}

		if (part == PlantPart.TOP) {

			return below.is(this);

		}

		return false;
	}

	@Override
	public BlockState playerWillDestroy(
		Level level,
		BlockPos pos,
		BlockState state,
		Player player
	) {

		if (!level.isClientSide) {
				if (part == PlantPart.TOP) {
					level.destroyBlock(pos.below(), false);
					level.destroyBlock(pos.below(2), false);

					return super.playerWillDestroy(level, pos, state, player);

				} else if (part == PlantPart.MIDDLE) {
					level.destroyBlock(pos.above(), false);
					level.destroyBlock(pos.below(), false);	

					return super.playerWillDestroy(level, pos, state, player);
				} else if (part == PlantPart.BOTTOM) {
					level.destroyBlock(pos.above(), false);
					level.destroyBlock(pos.above(2), false);

					return super.playerWillDestroy(level, pos, state, player);
			}
		}
	}

	@Override
	public int getFlammability(
		BlockState state,
		BlockGetter world,
		BlockPos pos,
		Direction face
	) {
		return 100;
	}

	@Override
	public int getFireSpreadSpeed(
		BlockState state,
		BlockGetter world,
		BlockPos pos,
		Direction face
	) {
		return 60;
	}
}