package net.hour.rancher;

import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.hour.rancher.datagen.ModAdvancementProvidor;
import net.hour.rancher.datagen.ModLootTableProvidor;
import net.hour.rancher.datagen.ModModelProvidor;
import net.hour.rancher.datagen.ModRecipeProvidor;

public class RanchersManualDataGenerator implements DataGeneratorEntrypoint {
	@Override
	public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
       FabricDataGenerator.Pack pack = fabricDataGenerator.createPack();

        pack.addProvider(ModModelProvidor::new);
        pack.addProvider(ModRecipeProvidor::new);
        pack.addProvider(ModLootTableProvidor::new);
        pack.addProvider(ModAdvancementProvidor::new);
	}
}
