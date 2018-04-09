package com.deflatedpickle.picklelib.item;

import net.minecraft.creativetab.CreativeTabs;
import vazkii.arl.item.ItemMod;

public class ItemBase extends ItemMod {
    private String _nameSpace;

    public ItemBase(String name, Integer stackSize, CreativeTabs creativeTab, String nameSpace) {
        super(name);
        _nameSpace = nameSpace;

        setMaxStackSize(stackSize);
        setCreativeTab(creativeTab);
    }

    @Override
    public String getModNamespace() {
        return _nameSpace;
    }
}