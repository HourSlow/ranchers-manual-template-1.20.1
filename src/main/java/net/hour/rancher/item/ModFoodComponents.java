package net.hour.rancher.item;

import net.minecraft.item.FoodComponent;
import net.minecraft.item.FoodComponents;

public class ModFoodComponents {

    //.statusEffect(new StatusEffectInstance(StatusEffect.LUCK, 200), 0.25f)

    public static final FoodComponent TOAST = new FoodComponent.Builder().hunger(5).saturationModifier(0.6f).build();
    public static final FoodComponent EGG = new FoodComponent.Builder().hunger(5).saturationModifier(0.6F).meat().build();
    public static final FoodComponent CORN_UNPROCESSED = new FoodComponent.Builder().hunger(1).saturationModifier(0.6F).build();
    public static final FoodComponent CORN_PROCESSED = new FoodComponent.Builder().hunger(7).saturationModifier(0.7F).meat().build();
}
