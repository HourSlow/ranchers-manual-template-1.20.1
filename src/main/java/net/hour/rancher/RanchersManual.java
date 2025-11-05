package net.hour.rancher;

import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.registry.CompostingChanceRegistry;
import net.hour.rancher.block.ModBlocks;
import net.hour.rancher.item.ModItemGroup;
import net.hour.rancher.item.ModItems;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RanchersManual implements ModInitializer {

	public static final String MOD_ID = "rancher";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
        ModItems.registerModItems();
        ModItemGroup.registerItemGroup();

        ModBlocks.registerModBlocks();

        CompostingChanceRegistry.INSTANCE.add(ModItems.CORN, 0.3f);
        CompostingChanceRegistry.INSTANCE.add(ModItems.CORN_SEEDS, 0.15f);
        CompostingChanceRegistry.INSTANCE.add(ModBlocks.WILD_CORN, 0.2f);
	}
}