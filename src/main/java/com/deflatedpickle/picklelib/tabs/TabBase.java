package com.deflatedpickle.picklelib.tabs;

import com.deflatedpickle.picklelib.PickleLib;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;

public class TabBase extends CreativeTabs {
    private String label;
    private ItemStack icon;
    private Boolean searchBar;

    public TabBase(String label, ItemStack icon, Boolean searchBar) {
        super("tab_"+ PickleLib.getNameSpace() + "_" + label);
        this.label = label;
        this.icon = icon;
        this.searchBar = searchBar;
    }

    @Override
    public boolean hasSearchBar(){
        return searchBar;
    }

    @Override
    public ItemStack getTabIconItem(){
        return icon;
    }
}