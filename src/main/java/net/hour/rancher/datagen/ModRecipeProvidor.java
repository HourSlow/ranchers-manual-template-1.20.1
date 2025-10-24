package net.hour.rancher.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.data.server.recipe.RecipeJsonProvider;
import net.minecraft.item.Items;
import net.minecraft.recipe.RecipeSerializer;

import java.util.function.Consumer;

public class ModRecipeProvidor extends FabricRecipeProvider {

    public ModRecipeProvidor(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generate(Consumer<RecipeJsonProvider> consumer) {
        offerFoodCookingRecipe(consumer, "player", RecipeSerializer.CAMPFIRE_COOKING,50, Items.BREAD, Items.DRIED_KELP, 0.7f);
    }
}
