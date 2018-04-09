package com.deflatedpickle.picklelib.util;

import com.deflatedpickle.picklelib.block.BlockBase;
import com.deflatedpickle.picklelib.item.ItemBase;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import org.apache.commons.lang3.tuple.ImmutablePair;

import java.util.Arrays;
import java.util.List;

public class AutomaticGeneration {
    public List<Object> genMineralResources(String name, CreativeTabs creativeTab, String nameSpace) {
        // Generates; Ore, Ingot and a Nugget for the mineral.
        BlockBase ore = new BlockBase(name + "_ore", Material.ROCK, 3.0f, 15.0f, new ImmutablePair<>("pickaxe", 1), creativeTab, nameSpace);
        ItemBase ingot = new ItemBase(name + "_ingot", 64, creativeTab, nameSpace);
        ItemBase nugget = new ItemBase(name + "_nugget", 64, creativeTab, nameSpace);

        return Arrays.asList(ore, ingot, nugget);
    }

    public List<Object> genBeastResources(String name, CreativeTabs creativeTab, String nameSpace) {
        // Generates; Hide, Raw Meat and Cooked Meat for the beast.
        ItemBase hide = new ItemBase(name + "_hide", 64, creativeTab, nameSpace);
        ItemBase meatRaw = new ItemBase(name + "_meatRaw", 64, creativeTab, nameSpace);
        ItemBase meatCooked = new ItemBase(name + "_meatCooked", 64, creativeTab, nameSpace);

        return Arrays.asList(hide, meatRaw, meatCooked);
    }
}
