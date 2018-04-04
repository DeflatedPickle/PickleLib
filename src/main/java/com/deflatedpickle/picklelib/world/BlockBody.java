package com.deflatedpickle.picklelib.world;

import net.minecraft.block.Block;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import java.util.concurrent.atomic.AtomicInteger;

public class BlockBody {
    private World _world;
    private BlockPos _startingPoint;
    private Block _blockType;

    public BlockBody(World world, BlockPos startingPoint, Block blockType) {
        _world = world;
        _startingPoint = startingPoint;
        _blockType = blockType;
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

        while (currentUpBlock == _blockType) {
            referencePoint = referencePoint.offset(direction);

            currentUpBlock = _world.getBlockState(referencePoint).getBlock();
            height.getAndIncrement();
        }

        return height.get();
    }

    public int getBlockCount(int accuracy, int limit, String searchType) {
        int blocks = 0;

        while (blocks < limit) {
            if (searchType.equals("cubes")) {

            }
            else if (searchType.equals("conical ring")) {

            }
        }

        return blocks;
    }
}
