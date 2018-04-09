package com.deflatedpickle.picklelib.util;

import com.deflatedpickle.picklelib.block.BlockBase;
import com.deflatedpickle.picklelib.init.ModSmelting;
import com.deflatedpickle.picklelib.item.ItemBase;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.oredict.OreDictionary;
import org.apache.commons.lang3.tuple.ImmutablePair;

import java.util.Arrays;
import java.util.List;

public class AutomaticGeneration {
    public static List<Object> genMineralResources(String name, CreativeTabs creativeTab, String nameSpace, String group) {
        // Generates; Ore, Ingot and a Nugget for the mineral.
        BlockBase ore = new BlockBase(name + "_ore", Material.ROCK, 3.0f, 15.0f, ImmutablePair.of("pickaxe", 1), creativeTab, nameSpace);
        ItemBase ingot = new ItemBase(name + "_ingot", 64, creativeTab, nameSpace);
        ItemBase nugget = new ItemBase(name + "_nugget", 64, creativeTab, nameSpace);

        GameRegistry.addShapelessRecipe(new ResourceLocation(nameSpace + ":" + name + "_ingot"), new ResourceLocation(group), new ItemStack(nugget, 9), Ingredient.fromStacks(new ItemStack(ingot)));
        Ingredient stack = Ingredient.fromStacks(new ItemStack(nugget, 9));
        GameRegistry.addShapelessRecipe(new ResourceLocation(nameSpace + ":" + name + "_nugget"), new ResourceLocation(group), new ItemStack(ingot), stack, stack, stack, stack, stack, stack, stack, stack, stack);
        ModSmelting.blocksList.add(new ImmutablePair<>(ore, ingot));

        OreDictionary.registerOre("ore" + name.toUpperCase(), ore);
        OreDictionary.registerOre("ingot" + name.toUpperCase(), ingot);
        OreDictionary.registerOre("nugget" + name.toUpperCase(), nugget);

        return Arrays.asList(ore, ingot, nugget);
    }

    public static List<Object> genBeastResources(String name, CreativeTabs creativeTab, String nameSpace) {
        // Generates; Hide, Raw Meat and Cooked Meat for the beast.
        ItemBase hide = new ItemBase(name + "_hide", 64, creativeTab, nameSpace);
        ItemBase meatRaw = new ItemBase(name + "_meatRaw", 64, creativeTab, nameSpace);
        ItemBase meatCooked = new ItemBase(name + "_meatCooked", 64, creativeTab, nameSpace);

        ModSmelting.itemList.add(new ImmutablePair<>(meatRaw, meatCooked));

        return Arrays.asList(hide, meatRaw, meatCooked);
    }

    public static List<Object> genWoodResources(String name, CreativeTabs creativeTab, String nameSpace, String group) {
        BlockBase log = new BlockBase(name + "_log", Material.WOOD, 2f, 10f, ImmutablePair.of("axe", 0), creativeTab, nameSpace);
        BlockBase leaves = new BlockBase(name + "_leaves", Material.WOOD, 0.2f, 1f, ImmutablePair.of("shears", 0), creativeTab, nameSpace);
        BlockBase planks = new BlockBase(name + "_planks", Material.WOOD, 2f, 15f, ImmutablePair.of("axe", 0), creativeTab, nameSpace);

        GameRegistry.addShapelessRecipe(new ResourceLocation(nameSpace + ":" + name + "_ingot"), new ResourceLocation(group), new ItemStack(planks, 4), Ingredient.fromStacks(new ItemStack(log)));

        return Arrays.asList(log, leaves, planks);
    }

/*    public static List<Object> genFurniture(String name, Block block, CreativeTabs creativeTab, String nameSpace) {
        // Generates; Stairs, Slabs, Fence

        // return Arrays.asList(stairs, slabs, fence);
    }*/
}
