package net.hour.rancher.util;

import net.fabricmc.fabric.api.event.lifecycle.v1.ServerTickEvents;
import net.hour.rancher.effect.ModEffects;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;

public class FrostbiteHandler {

    public static final int MAX_FROZEN_TICKS = 140;

    public static void register() {
        ServerTickEvents.END_SERVER_TICK.register(server -> {
            for (ServerPlayerEntity player : server.getPlayerManager().getPlayerList()) {
                if (player.isCreative() || player.isSpectator()) continue;

                World world = player.getWorld();
                BlockPos pos = player.getBlockPos();
                RegistryEntry<Biome> biomeEntry = world.getBiome(pos);
                Biome biome = biomeEntry.value();

                float temperature = biome.getTemperature();
                boolean isCold = temperature <= 0.15f;
                boolean hasWarmth = player.hasStatusEffect(ModEffects.WARMTH);

                int frozen = player.getFrozenTicks();

                if (isCold && !hasWarmth) {
                    if (frozen >= MAX_FROZEN_TICKS - 1) {
                        if (player.age % 20 == 0) {
                            player.damage(world.getDamageSources().freeze(), 1.0F);
                        }
                    }
                } else {
                    if (frozen > 0) player.setFrozenTicks(Math.max(frozen - 4, 0));
                }
            }
        });
    }
}
