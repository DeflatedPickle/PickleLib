package com.deflatedpickle.picklelib.init;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.Ingredient;
import net.minecraftforge.fml.common.registry.GameRegistry;
import org.apache.commons.lang3.tuple.ImmutablePair;
import org.apache.commons.lang3.tuple.Pair;
import org.apache.commons.lang3.tuple.Triple;

import java.util.ArrayList;
import java.util.List;

public class ModSmelting {
    public static final ArrayList<Pair<Block, Item>> blockList = new ArrayList<>();
    public static final ArrayList<Pair<Item, Item>> itemList = new ArrayList<>();

    public static void init() {
        for (Pair<Block, Item> pair : blockList) {
            GameRegistry.addSmelting(pair.getLeft(), new ItemStack(pair.getRight()), 1f);
        }

        for (Pair<Item, Item> pair : itemList) {
            GameRegistry.addSmelting(pair.getLeft(), new ItemStack(pair.getRight()), 1f);
        }
    }
}
