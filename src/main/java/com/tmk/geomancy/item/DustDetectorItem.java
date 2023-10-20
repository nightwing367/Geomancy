package com.tmk.geomancy.item;

import com.tmk.geomancy.block.ModBlocks;
import com.tmk.geomancy.util.ModTags;
import net.minecraft.client.resources.language.I18n;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class DustDetectorItem extends Item {
    public DustDetectorItem(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public InteractionResult useOn(UseOnContext pContext) {

        if(!pContext.getLevel().isClientSide()){
            BlockPos positionClicked = pContext.getClickedPos();
            Player player = pContext.getPlayer();
            boolean foundBlock = false;

            for (int i = 0; i < positionClicked.getY() + 64; i++) {
                BlockPos positionChecked = positionClicked.below(i);
                BlockState state = pContext.getLevel().getBlockState(positionChecked);

                if (isValuableBlock(state)){
                    outputValuableCoordinates(positionChecked, player, state.getBlock());
                    foundBlock = true;
                    break;
                }
            }
            if (!foundBlock){
                player.sendSystemMessage(Component.literal("Yo, ya rien icitte!"));
            }
        }

        //Reduce durability
        pContext.getItemInHand().hurtAndBreak(1, pContext.getPlayer(),
                player -> player.broadcastBreakEvent(player.getUsedItemHand()));

        return InteractionResult.SUCCESS;
    }

    private void outputValuableCoordinates(BlockPos position, Player player, Block block) {
        String translatedItemDesc = I18n.get(block.getDescriptionId());
        player.sendSystemMessage(Component.literal("Found " + translatedItemDesc + " at (X:" + position.getX() + " Y:" + position.getY() + " Z:" + position.getZ() + ")."));
    }

    private boolean isValuableBlock(BlockState state) {

        //return state.is(ModBlocks.DUST_ORE.get()) ||
        //        state.is(ModBlocks.DEEPSLATE_DUST_ORE.get()) ||
        //        state.is(ModBlocks.NETHER_DUST_ORE.get()) ||
        //        state.is(ModBlocks.END_STONE_DUST_ORE.get()) ||
        //        state.is(Blocks.DIAMOND_ORE);
        return state.is(ModTags.Blocks.DUST_DETECTOR_VALUABLES);
    }

    @Override
    public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> pTooltipComponents, TooltipFlag pIsAdvanced) {
        pTooltipComponents.add(Component.translatable("tooltip.geomancy.dust_detector"));
        super.appendHoverText(pStack, pLevel, pTooltipComponents, pIsAdvanced);
    }
}
