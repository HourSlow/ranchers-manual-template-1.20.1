package net.hour.rancher.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.hour.rancher.item.ModItems;
import net.minecraft.data.server.recipe.RecipeJsonProvider;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.Items;
import net.minecraft.recipe.RecipeSerializer;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.util.Identifier;

import java.util.List;
import java.util.function.Consumer;

public class ModRecipeProvidor extends FabricRecipeProvider {

    private static final List<ItemConvertible> LIST_EGGS = List.of(Items.EGG);

    public ModRecipeProvidor(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generate(Consumer<RecipeJsonProvider> exporter) {
        offerFoodCookingRecipe(exporter, "campfire_cooking", RecipeSerializer.CAMPFIRE_COOKING,70, Items.BREAD, ModItems.TOAST, 0.2f);
        offerSmelting(exporter, LIST_EGGS, RecipeCategory.FOOD, ModItems.FRIED_EGG, 0.2f, 90, "rancher");

        ShapedRecipeJsonBuilder.create(RecipeCategory.FOOD, ModItems.CORN_STEW, 1)
                .pattern("CCC")
                .pattern("-B-")
                .input('B', Items.BOWL)
                .input('C', ModItems.CORN)
                .criterion(hasItem(ModItems.CORN), conditionsFromItem(ModItems.CORN))
                .criterion(hasItem(ModItems.CORN_SEEDS), conditionsFromItem(ModItems.CORN_SEEDS))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.CORN_STEW)));
    }
}
