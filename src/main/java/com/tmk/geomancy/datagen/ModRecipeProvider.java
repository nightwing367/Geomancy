package com.tmk.geomancy.datagen;
/*

///////////////// PRESENTEMENT LES RECETTES SEMBLENT BUGGER AVEC LA VERSION DE FORGE DE 1.20.2 ///////////////////

import com.tmk.geomancy.Geomancy;
import com.tmk.geomancy.block.ModBlocks;
import com.tmk.geomancy.item.ModItems;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.world.item.crafting.AbstractCookingRecipe;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.ShapedRecipe;
import net.minecraft.world.level.ItemLike;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;

import java.util.List;

public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder {
    private static final List<ItemLike> DUST_SMELTABLES = List.of(ModItems.RAW_DUST.get(),
            ModBlocks.DUST_ORE.get(),
            ModBlocks.DEEPSLATE_DUST_ORE.get(),
            ModBlocks.NETHER_DUST_ORE.get(),
            ModBlocks.END_STONE_DUST_ORE.get());

    public ModRecipeProvider(PackOutput pOutput) {
        super(pOutput);
    }

    @Override
    protected void buildRecipes(RecipeOutput recipe) {
        oreBlasting(recipe, DUST_SMELTABLES, RecipeCategory.MISC, ModItems.DUST.get(), 0.25f, 100, "dust");
        oreSmelting(recipe, DUST_SMELTABLES, RecipeCategory.MISC, ModItems.DUST.get(), 0.25f, 100, "dust");
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.DUST_BLOCK.get())
                .pattern("XXX")
                .pattern("XXX")
                .pattern("XXX")
                .define("X", ModItems.DUST.get().it)
                .unlockedBy(getHasName(ModItems.DUST.get(), has(ModItems.DUST.get())))
                .save(recipe);
    }


    protected static void oreSmelting(RecipeOutput recipe, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTIme, String pGroup) {
        oreCooking(recipe, RecipeSerializer.SMELTING_RECIPE, pIngredients, pCategory, pResult, pExperience, pCookingTIme, pGroup, "_from_smelting");
    }

    protected static void oreBlasting(RecipeOutput recipe, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTime, String pGroup) {
        oreCooking(recipe, RecipeSerializer.BLASTING_RECIPE, pIngredients, pCategory, pResult, pExperience, pCookingTime, pGroup, "_from_blasting");
    }

    private static void oreCooking(RecipeOutput recipe, RecipeSerializer<? extends AbstractCookingRecipe> pCookingSerializer, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTime, String pGroup, String pRecipeName) {
        for(ItemLike itemlike : pIngredients) {
            SimpleCookingRecipeBuilder.generic(Ingredient.of(itemlike), pCategory, pResult, pExperience, pCookingTime, pCookingSerializer)
                    .group(pGroup).unlockedBy(getHasName(itemlike), has(itemlike))
                    .save(recipe, Geomancy.MOD_ID + ":" + getItemName(pResult) + pRecipeName + "_" + getItemName(itemlike));
        }

    }
}
*/
