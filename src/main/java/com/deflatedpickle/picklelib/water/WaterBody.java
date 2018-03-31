package com.deflatedpickle.picklelib.water;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

import java.util.concurrent.atomic.AtomicInteger;

public class WaterBody {
    private World _world;
    private BlockPos _startingPoint;

    public WaterBody(World world, BlockPos startingPoint) {
        _world = world;
        _startingPoint = startingPoint;
    }

    public int getSimpleHeight() {
        AtomicInteger height = new AtomicInteger();

        Block currentUpBlock = _world.getBlockState(_startingPoint).getBlock();
        BlockPos referenceUpPoint = _startingPoint;

        while (currentUpBlock == Blocks.WATER) {
            referenceUpPoint = referenceUpPoint.up();

            currentUpBlock = _world.getBlockState(referenceUpPoint).getBlock();
            height.getAndIncrement();
        }

        Block currentDownBlock = _world.getBlockState(_startingPoint).getBlock();
        BlockPos referenceDownPoint = _startingPoint;

        while (currentDownBlock == Blocks.WATER) {
            referenceDownPoint = referenceDownPoint.down();

            currentDownBlock = _world.getBlockState(referenceDownPoint).getBlock();
            height.getAndIncrement();
        }

        return height.get() - 1;
    }
}
