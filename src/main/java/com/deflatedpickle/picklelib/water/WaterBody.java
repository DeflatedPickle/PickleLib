package com.deflatedpickle.picklelib.water;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

public class WaterBody {
    private World _world;
    private BlockPos _startingPoint;

    public WaterBody(World world, BlockPos startingPoint) {
        _world = world;
        _startingPoint = startingPoint;
    }

    public int getSimpleHeight() {
        AtomicInteger height = new AtomicInteger();

        IntStream.range(0, 1).forEachOrdered(i -> {
            Block currentBlock = _world.getBlockState(_startingPoint).getBlock();
            BlockPos referencePoint = _startingPoint;

            while (currentBlock == Blocks.WATER) {
                if (i == 0) {
                    referencePoint = referencePoint.up();
                }
                else if (i == 1) {
                    referencePoint = referencePoint.down();
                }

                currentBlock = _world.getBlockState(referencePoint).getBlock();
                height.getAndIncrement();
            }
        });

        return height.get();
    }
}
