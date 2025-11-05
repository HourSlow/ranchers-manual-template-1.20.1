package net.hour.rancher.effect;

import net.hour.rancher.RanchersManual;
import net.hour.rancher.effect.custom.WarmthEffect;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModEffects {

    public static StatusEffect WARMTH;


    private static StatusEffect registerWarmthEffect(String name) {
        return Registry.register(Registries.STATUS_EFFECT, Identifier.of(RanchersManual.MOD_ID, name),
                new WarmthEffect(StatusEffectCategory.BENEFICIAL, 0xFFD37F));
    }

    public static void registerEffects() {
        RanchersManual.LOGGER.debug(RanchersManual.MOD_ID + " - ModEffects");

        WARMTH = registerWarmthEffect("warmth");
    }
}
