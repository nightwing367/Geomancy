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
    public static final RegistryObject<Item> DUST_DETECTOR = ITEMS.register("dust_detector",
            ()-> new DustDetectorItem(new Item.Properties().durability(100)));

    //Foods
    public static final RegistryObject<Item> STRAWBERRY = ITEMS.register("strawberry",
            ()-> new Item(new Item.Properties().food(ModFoods.STRAWBERRY)));

    //Fuel
    public static final RegistryObject<Item> PINE_CONE = ITEMS.register("pine_cone",
            ()-> new FuelItem(new Item.Properties(), 400));
    }