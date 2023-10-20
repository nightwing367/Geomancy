package com.tmk.geomancy.item;

import com.tmk.geomancy.Geomancy;
import com.tmk.geomancy.block.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModCreativeModTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, Geomancy.MOD_ID);

    public static void register(IEventBus eventBus){
        CREATIVE_MODE_TABS.register(eventBus);
    }

    public static final RegistryObject<CreativeModeTab> GEOMANCY_TAB = CREATIVE_MODE_TABS.register("geomancy_tab",
            () ->CreativeModeTab.builder().icon( () -> new ItemStack(ModItems.DUST.get()))
                    .title(Component.translatable("creativetab.geomancy_tab"))
                    .displayItems(((pParameters, pOutput) -> {
                        //Items
                        pOutput.accept(ModItems.DUST.get());
                        pOutput.accept(ModItems.RAW_DUST.get());
                        pOutput.accept(ModItems.DUST_DETECTOR.get());

                        //Block
                        pOutput.accept(ModBlocks.DUST_BLOCK.get());
                        pOutput.accept(ModBlocks.RAW_DUST_BLOCK.get());
                        pOutput.accept(ModBlocks.SOUND_BLOCK.get());

                        //Ore
                        pOutput.accept(ModBlocks.DUST_ORE.get());
                        pOutput.accept(ModBlocks.DEEPSLATE_DUST_ORE.get());
                        pOutput.accept(ModBlocks.NETHER_DUST_ORE.get());
                        pOutput.accept(ModBlocks.END_STONE_DUST_ORE.get());

                        //Food
                        pOutput.accept(ModItems.STRAWBERRY.get());

                        //Fuel
                        pOutput.accept(ModItems.PINE_CONE.get());
                    }))
                    .build());
}
