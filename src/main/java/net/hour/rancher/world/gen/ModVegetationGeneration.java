package net.hour.rancher.world.gen;

import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.hour.rancher.world.ModPlacedFeatures;
import net.minecraft.world.biome.BiomeKeys;
import net.minecraft.world.gen.GenerationStep;

public class ModVegetationGeneration {

    public static void generateVegetation() {
        BiomeModifications.addFeature(BiomeSelectors.includeByKey(
                        BiomeKeys.PLAINS,
                        BiomeKeys.MEADOW,
                        BiomeKeys.SAVANNA,
                        BiomeKeys.SUNFLOWER_PLAINS,
                        BiomeKeys.SPARSE_JUNGLE),
                GenerationStep.Feature.VEGETAL_DECORATION, ModPlacedFeatures.WILD_CORN_CROP_KEY);
    }
}
