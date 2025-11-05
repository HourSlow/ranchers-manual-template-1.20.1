package net.hour.rancher.block;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.hour.rancher.RanchersManual;
import net.hour.rancher.block.custom.CornCropBlock;
import net.hour.rancher.block.custom.WildCropBlock;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.piston.PistonBehavior;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModBlocks {

    public static final Block CORN_CROP = Registry.register(Registries.BLOCK, new Identifier(RanchersManual.MOD_ID, "corn_crop"),
            new CornCropBlock(FabricBlockSettings.copyOf(Blocks.WHEAT).noCollision()
                    .breakInstantly().pistonBehavior(PistonBehavior.DESTROY)));

    public static final Block WILD_CORN = registerBlock("wild_corn",
            new WildCropBlock(FabricBlockSettings.copyOf(Blocks.GRASS).nonOpaque().noCollision()));




    private static Block registerBlock(String name, Block block) {
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, new Identifier(RanchersManual.MOD_ID, name),block);
    }

    private static Item registerBlockItem(String name, Block block) {
        return Registry.register(Registries.ITEM, new Identifier(RanchersManual.MOD_ID, name),
                new BlockItem(block, new FabricItemSettings()));
    }

    public static void registerModBlocks() {
        RanchersManual.LOGGER.debug(RanchersManual.MOD_ID + " - ModBlocks");
    }
}
