package net.hour.rancher.util;

import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.hour.rancher.effect.ModEffects;
import net.minecraft.client.MinecraftClient;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.biome.Biome;

import static net.hour.rancher.util.FrostbiteHandler.MAX_FROZEN_TICKS;

public class FrostbiteClientHandler {

    public static void register(){
        ClientTickEvents.END_CLIENT_TICK.register(client -> {
            PlayerEntity player = MinecraftClient.getInstance().player;
            if (player == null || player.isSpectator() || player.isCreative()) return;

            BlockPos pos = player.getBlockPos();
            RegistryEntry<Biome> biomeEntry = player.getWorld().getBiome(pos);
            Biome biome = biomeEntry.value();

            float temperature = biome.getTemperature();
            boolean isCold = temperature <= 0.15f;
            boolean hasWarmth = player.hasStatusEffect(ModEffects.WARMTH);

            int frozen = player.getFrozenTicks();

            if (isCold && !hasWarmth) {
                if (frozen < MAX_FROZEN_TICKS)
                    if (player.age % 2 == 0) {
                        player.setFrozenTicks(Math.min(frozen + 1, MAX_FROZEN_TICKS));
                    }
            } else {
                if (frozen > 0)
                    player.setFrozenTicks(Math.max(frozen - 3, 0));
            }
        });
    }
}
