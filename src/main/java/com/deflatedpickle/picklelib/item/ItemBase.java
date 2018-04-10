package com.deflatedpickle.picklelib.item;

import com.deflatedpickle.picklelib.PickleLib;
import net.minecraft.creativetab.CreativeTabs;
import vazkii.arl.item.ItemMod;

public class ItemBase extends ItemMod {
    public ItemBase(String name, Integer stackSize, CreativeTabs creativeTab) {
        super(name);

        setMaxStackSize(stackSize);
        setCreativeTab(creativeTab);
    }

    @Override
    public String getModNamespace() {
        return PickleLib.getNameSpace();
    }
}
