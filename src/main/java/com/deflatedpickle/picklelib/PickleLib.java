package com.deflatedpickle.picklelib;

import com.deflatedpickle.picklelib.init.ModSmelting;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;

@Mod(modid = Reference.MOD_ID, name = Reference.NAME, version = Reference.VERSION, acceptedMinecraftVersions = Reference.ACCEPTED_VERSIONS)
public class PickleLib {
    @Instance
    public static PickleLib instance;

    @Mod.EventHandler
    public void init(FMLInitializationEvent event) {
        ModSmelting.init();
    }
}
