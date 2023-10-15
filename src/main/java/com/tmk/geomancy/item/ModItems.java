package com.tmk.geomancy.item;

import com.tmk.geomancy.Geomancy;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, Geomancy.MOD_ID);

    public static void register(IEventBus eventBus){
        ITEMS.register(eventBus);
    }
    public static final RegistryObject<Item> DUST = ITEMS.register("dust",
            ()-> new Item(new Item.Properties()));
    public static final RegistryObject<Item> RAW_DUST = ITEMS.register("raw_dust",
            ()-> new Item(new Item.Properties()));
}