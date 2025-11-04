package net.hour.rancher.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricAdvancementProvider;
import net.hour.rancher.RanchersManual;
import net.hour.rancher.item.ModItems;
import net.minecraft.advancement.Advancement;
import net.minecraft.advancement.AdvancementFrame;
import net.minecraft.advancement.CriterionMerger;
import net.minecraft.advancement.criterion.InventoryChangedCriterion;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import java.util.function.Consumer;

public class ModAdvancementProvidor extends FabricAdvancementProvider {

    public ModAdvancementProvidor(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateAdvancement(Consumer<Advancement> consumer) {

        Advancement rootRancherManual = Advancement.Builder.create()
                .display(

                        ModItems.CORN_SEEDS, // Display icon
                        Text.literal("Rancher's Manual"), // Title
                        Text.literal("The world is a tasty place!"), // Description
                        new Identifier(RanchersManual.MOD_ID, "textures/gui/advancements/backgrounds/root_rm_bg.png"), // Background (only used if root, otherwise null)
                        AdvancementFrame.GOAL, // TASK, CHALLENGE, or GOAL
                        false, // Show toast
                        false, // Announce to chat
                        true // Hidden until unlocked
                )
                .criterion("got_corn_root", InventoryChangedCriterion.Conditions.items(ModItems.CORN))
                .criterion("got_corn_seeds_root", InventoryChangedCriterion.Conditions.items(ModItems.CORN_SEEDS))
                .criteriaMerger(CriterionMerger.OR)
                .build(consumer, "root");


        Advancement getCorn = Advancement.Builder.create()
                .parent(rootRancherManual)
                .display(

                        ModItems.CORN,
                        Text.literal("A Corny Joke"),
                        Text.literal("Obtain corn from a fully grown corn plant."),
                        null,
                        AdvancementFrame.TASK,
                        true,
                        true,
                        false
                )
                .criterion("got_corn", InventoryChangedCriterion.Conditions.items(ModItems.CORN))
                .build(consumer, "get_corn");

        Advancement cookEgg = Advancement.Builder.create()
                .parent(rootRancherManual)
                .display(

                        ModItems.FRIED_EGG,
                        Text.literal("Egghead's Task"),
                        Text.literal("Cook an egg in a furnace or on a campfire."),
                        null,
                        AdvancementFrame.TASK,
                        true,
                        true,
                        false
                )
                .criterion("got_egg", InventoryChangedCriterion.Conditions.items(ModItems.FRIED_EGG))
                .build(consumer, "cook_egg");

        Advancement fullBreakfast = Advancement.Builder.create()
                .parent(cookEgg)
                .display(

                        ModItems.TOAST,
                        Text.literal("Breakfast Time!"),
                        Text.literal("Obtain a fried egg, toast and orange juice."),
                        null,
                        AdvancementFrame.TASK,
                        true,
                        true,
                        true
                )
                .criterion("got_egg", InventoryChangedCriterion.Conditions.items(ModItems.FRIED_EGG))
                .criterion("got_toast", InventoryChangedCriterion.Conditions.items(ModItems.TOAST))
                .build(consumer, "full_breakfast");
    }
}
