package com.deflatedpickle.picklelib.water;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import java.util.concurrent.atomic.AtomicInteger;

public class WaterBody {
    private World _world;
    private BlockPos _startingPoint;

    public WaterBody(World world, BlockPos startingPoint) {
        _world = world;
        _startingPoint = startingPoint;
    }

    public int getSimpleVolume() {
        int width = getSimpleWidth();
        int height = getSimpleHeight();
        int length = getSimpleLength();

        return length * width * height;
    }

    public int getSimplePerimeter() {
        int width = getSimpleWidth();
        int length = getSimpleLength();

        return (width * 2) + (length * 2);
    }

    public int getSimpleArea() {
        int width = getSimpleWidth();
        int length = getSimpleLength();

        return length * width;
    }

    public int getSimpleWidth() {
        int east = getSimpleDimension(EnumFacing.EAST);
        int west = getSimpleDimension(EnumFacing.WEST);

        return east + west - 1;
    }

    public int getSimpleHeight() {
        int up = getSimpleDimension(EnumFacing.UP);
        int down = getSimpleDimension(EnumFacing.DOWN);

        return up + down - 1;
    }

    public int getSimpleLength() {
        int north = getSimpleDimension(EnumFacing.NORTH);
        int south = getSimpleDimension(EnumFacing.SOUTH);

        return north + south - 1;
    }

    private int getSimpleDimension(EnumFacing direction) {
        AtomicInteger height = new AtomicInteger();

        Block currentUpBlock = _world.getBlockState(_startingPoint).getBlock();
        BlockPos referencePoint = _startingPoint;

        while (currentUpBlock == Blocks.WATER) {
            referencePoint = referencePoint.offset(direction);

            currentUpBlock = _world.getBlockState(referencePoint).getBlock();
            height.getAndIncrement();
        }

        return height.get();
    }
}
