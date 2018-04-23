package com.deflatedpickle.picklelib;

import com.deflatedpickle.picklelib.init.ModCrafting;
import com.deflatedpickle.picklelib.init.ModSmelting;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;

@Mod(modid = Reference.MOD_ID, name = Reference.NAME, version = Reference.VERSION, acceptedMinecraftVersions = Reference.ACCEPTED_VERSIONS)
public class PickleLib {
    @Instance
    public static PickleLib instance;
    private static String _nameSpace = Reference.MOD_ID;

    @EventHandler
    public void init(FMLInitializationEvent event) {
        ModCrafting.init();
        ModSmelting.init();
    }

    public static void setNameSpace(String nameSpace) {
        _nameSpace = nameSpace;
    }

    public static String getNameSpace() {
        return _nameSpace;
    }
}
