package com.deflatedpickle.picklelib.util;

import com.deflatedpickle.picklelib.PickleLib;
import com.deflatedpickle.picklelib.block.BlockBase;
import com.deflatedpickle.picklelib.init.ModSmelting;
import com.deflatedpickle.picklelib.item.ItemBase;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.oredict.OreDictionary;
import org.apache.commons.lang3.tuple.ImmutablePair;
import vazkii.arl.recipe.RecipeHandler;
import vazkii.arl.util.ProxyRegistry;

import java.util.Arrays;
import java.util.List;

public class AutomaticGeneration {
    public static List<Object> genMineralResources(String name, CreativeTabs creativeTab) {
        // Generates; Ore, Ingot and a Nugget for the mineral.
        BlockBase ore = new BlockBase(name + "_ore", Material.ROCK, 3.0f, 15.0f, ImmutablePair.of("pickaxe", 1), creativeTab);
        BlockBase block = new BlockBase(name + "_block", Material.IRON, 5.0f, 30.0f, ImmutablePair.of("pickaxe", 1), creativeTab);
        ItemBase ingot = new ItemBase(name + "_ingot", 64, creativeTab);
        ItemBase nugget = new ItemBase(name + "_nugget", 64, creativeTab);

        // Register to the ore dictionary
        String oreName = "ore" + name.toUpperCase();
        String blockName = "block" + name.toUpperCase();
        String ingotName = "ingot" + name.toUpperCase();
        String nuggetName = "nugget" + name.toUpperCase();

        OreDictionary.registerOre(oreName, ore);
        OreDictionary.registerOre(blockName, ore);
        OreDictionary.registerOre(ingotName, ingot);
        OreDictionary.registerOre(nuggetName, nugget);

        ItemStack stack;

        // Crafting recipes
            // Craft the block into ingots
        RecipeHandler.addShapelessOreDictRecipe(ProxyRegistry.newStack(ingot, 9), ProxyRegistry.newStack(block));
            // Craft the ingot into nuggets
        RecipeHandler.addShapelessOreDictRecipe(ProxyRegistry.newStack(nugget, 9), ProxyRegistry.newStack(ingot));
            // Craft the ingots into the block
        stack = ProxyRegistry.newStack(ingot);
        RecipeHandler.addShapelessOreDictRecipe(ProxyRegistry.newStack(block), stack, stack, stack, stack, stack, stack, stack, stack, stack);
            // Craft the nuggets into the ingot
        stack = ProxyRegistry.newStack(nugget);
        RecipeHandler.addShapelessOreDictRecipe(ProxyRegistry.newStack(ingot), stack, stack, stack, stack, stack, stack, stack, stack, stack);

        // Smelt ore into the ingot
        ModSmelting.blockList.add(ImmutablePair.of(ore, ingot));

        return Arrays.asList(ore, block, ingot, nugget);
    }

    public static List<Object> genBeastResources(String name, CreativeTabs creativeTab) {
        // Generates; Hide, Raw Meat and Cooked Meat for the beast.
        ItemBase hide = new ItemBase(name + "_hide", 64, creativeTab);
        ItemBase meatRaw = new ItemBase(name + "_meatRaw", 64, creativeTab);
        ItemBase meatCooked = new ItemBase(name + "_meatCooked", 64, creativeTab);

        ModSmelting.itemList.add(ImmutablePair.of(meatRaw, meatCooked));

        return Arrays.asList(hide, meatRaw, meatCooked);
    }

    public static List<Object> genWoodResources(String name, CreativeTabs creativeTab) {
        BlockBase log = new BlockBase(name + "_log", Material.WOOD, 2f, 10f, ImmutablePair.of("axe", 0), creativeTab);
        BlockBase leaves = new BlockBase(name + "_leaves", Material.LEAVES, 0.2f, 1f, ImmutablePair.of("shears", 0), creativeTab);
        BlockBase planks = new BlockBase(name + "_planks", Material.WOOD, 2f, 15f, ImmutablePair.of("axe", 0), creativeTab);

        return Arrays.asList(log, leaves, planks);
    }

/*    public static List<Object> genFurniture(String name, Block block, CreativeTabs creativeTab, String nameSpace) {
        // Generates; Stairs, Slabs, Fence

        // return Arrays.asList(stairs, slabs, fence);
    }*/
}
