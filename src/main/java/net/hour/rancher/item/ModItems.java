package net.hour.rancher.item;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.hour.rancher.RanchersManual;
import net.hour.rancher.block.ModBlocks;
import net.minecraft.item.AliasedBlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.StewItem;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModItems {


    public static final Item TOAST = registerItem("toast",
            new Item(new FabricItemSettings().food(ModFoodComponents.TOAST)));

    public static final Item FRIED_EGG = registerItem("fried_egg",
            new Item(new FabricItemSettings().food(ModFoodComponents.EGG)));

    public static final Item CORN_SEEDS = registerItem("corn_seeds",
            new AliasedBlockItem(ModBlocks.CORN_CROP, new FabricItemSettings()));

    public static final Item CORN = registerItem("corn",
            new Item(new FabricItemSettings().food(ModFoodComponents.CORN_UNPROCESSED)));

    public static final Item CORN_STEW = registerItem("corn_stew",
            new StewItem(new FabricItemSettings().food(ModFoodComponents.CORN_PROCESSED)));


    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, new Identifier(RanchersManual.MOD_ID, name), item);
    }

    public static void registerModItems() {
        RanchersManual.LOGGER.debug(RanchersManual.MOD_ID, " - ModItems");
    }
}
