package com.deflatedpickle.picklelib.tabs;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;

public class TabBase extends CreativeTabs {
    private ItemStack icon;
    private Boolean searchBar;

    public TabBase(String nameSpace, String label, ItemStack icon, Boolean searchBar) {
        super("tab_"+ nameSpace + "_" + label);
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