package com.tmk.geomancy.datagen;

import com.tmk.geomancy.Geomancy;
import com.tmk.geomancy.item.ModItems;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;

public class ModItemModelProvider extends ItemModelProvider {
    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, Geomancy.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        simpleItem(ModItems.DUST);
        simpleItem(ModItems.RAW_DUST);

        simpleItem(ModItems.DUST_DETECTOR);

        simpleItem(ModItems.PINE_CONE);
        simpleItem(ModItems.STRAWBERRY);
    }

    private ItemModelBuilder simpleItem(RegistryObject<Item> item){
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/generated")).texture("layer0",
                new ResourceLocation(Geomancy.MOD_ID, "item/"+item.getId().getPath()));
    }
}
