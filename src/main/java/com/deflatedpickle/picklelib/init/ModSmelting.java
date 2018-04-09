package com.deflatedpickle.picklelib.init;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;
import org.apache.commons.lang3.tuple.Pair;

import java.util.ArrayList;

public class ModSmelting {
    public static final ArrayList<Pair<Block, Item>> blocksList = new ArrayList<>();
    public static final ArrayList<Pair<Item, Item>> itemList = new ArrayList<>();

    public static void init() {
        for (Pair<Block, Item> pair : blocksList) {
            GameRegistry.addSmelting(pair.getLeft(), new ItemStack(pair.getRight()), 1f);
        }

        for (Pair<Item, Item> pair : itemList) {
            GameRegistry.addSmelting(pair.getLeft(), new ItemStack(pair.getRight()), 1f);
        }
    }
}
