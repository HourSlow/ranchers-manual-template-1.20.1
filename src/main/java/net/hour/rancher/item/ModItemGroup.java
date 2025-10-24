package net.hour.rancher.item;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.hour.rancher.RanchersManual;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModItemGroup {
    public static final ItemGroup RANCHER_TAB = Registry.register(Registries.ITEM_GROUP,
            new Identifier(RanchersManual.MOD_ID, "rancher_tab"),
            FabricItemGroup.builder().displayName(Text.translatable("itemGroup.rancher_tab"))
                    .icon(() -> new ItemStack(ModItems.TOAST)).entries((displayContext, entries) -> {

                        entries.add(ModItems.TOAST);
                        entries.add(ModItems.FRIED_EGG);
                        entries.add(ModItems.CORN);
                        entries.add(ModItems.CORN_SEEDS);
                        entries.add(ModItems.CORN_STEW);

                    }).build());



    public static void registerItemGroup() {
        RanchersManual.LOGGER.debug(RanchersManual.MOD_ID + " - ModItemGroup");
    }
}
