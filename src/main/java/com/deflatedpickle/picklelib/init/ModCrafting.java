package com.deflatedpickle.picklelib.init;

import com.deflatedpickle.picklelib.PickleLib;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.registry.GameRegistry;
import org.apache.commons.lang3.tuple.Triple;

import java.util.ArrayList;
import java.util.List;

public class ModCrafting {
    private static final ArrayList<Triple<String, ItemStack, List<Ingredient>>> craftingList = new ArrayList<>();

    public static void init() {
        for (Triple<String, ItemStack, List<Ingredient>> triplet : craftingList) {
            GameRegistry.addShapelessRecipe(new ResourceLocation(triplet.getLeft()), new ResourceLocation(PickleLib.getNameSpace()), triplet.getMiddle(), triplet.getRight().toArray(new Ingredient[triplet.getRight().size()]));
        }
    }

    public static void addRecipe(String resourceName, ItemStack output, List<Ingredient> input) {
        craftingList.add(Triple.of(resourceName, output, input));
    }
}
