package com.deflatedpickle.picklelib.block;

import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import org.apache.commons.lang3.tuple.Pair;
import vazkii.arl.block.BlockMod;

public class BlockBase extends BlockMod {
    private String _nameSpace;

    public BlockBase(String name, Material materialIn, Float hardness, Float resistance, Pair<String, Integer> harvestLevel, CreativeTabs creativeTab, String nameSpace, String... variants) {
        super(name, materialIn, variants);
        _nameSpace = nameSpace;

        setHardness(hardness);
        setResistance(resistance);
        setHarvestLevel(harvestLevel.getLeft(), harvestLevel.getRight());
        setCreativeTab(creativeTab);
    }

    @Override
    public String getModNamespace() {
        return _nameSpace;
    }
}
