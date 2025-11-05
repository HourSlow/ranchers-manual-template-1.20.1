package net.hour.rancher.world;

import net.hour.rancher.RanchersManual;
import net.hour.rancher.block.ModBlocks;
import net.minecraft.block.Blocks;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.stateprovider.BlockStateProvider;

import java.util.List;

public class ModConfiguredFeatures {

    public static final RegistryKey<ConfiguredFeature<?, ?>> WILD_CORN_CROP_KEY = registerKey("wild_corn_crop");

    public static void bootstrap(Registerable<ConfiguredFeature<?, ?>> context) {
        register(context, WILD_CORN_CROP_KEY,
                Feature.RANDOM_PATCH,
                ConfiguredFeatures.createRandomPatchFeatureConfig(
                        Feature.SIMPLE_BLOCK,
                        new SimpleBlockFeatureConfig(BlockStateProvider.of(ModBlocks.WILD_CORN.getDefaultState())),
                        List.of(Blocks.GRASS_BLOCK)
                )
        );

    }

    public static RegistryKey<ConfiguredFeature<?, ?>> registerKey(String name) {
        return RegistryKey.of(RegistryKeys.CONFIGURED_FEATURE, Identifier.of(RanchersManual.MOD_ID, name));
    }

    private static <FC extends FeatureConfig, F extends Feature<FC>> void register(Registerable<ConfiguredFeature<?, ?>> context,
                                                                                   RegistryKey<ConfiguredFeature<?, ?>> key, F feature, FC configured) {
        context.register(key, new ConfiguredFeature<>(feature, configured));
    }

}
