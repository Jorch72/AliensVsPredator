package org.avp.block;

import java.util.List;
import java.util.Random;

import org.avp.world.dimension.varda.gen.VardaTallTreeGenerator;
import org.avp.world.dimension.varda.gen.VardaTree2Generator;
import org.avp.world.dimension.varda.gen.VardaTree3Generator;
import org.avp.world.dimension.varda.gen.VardaTreeGenerator;

import com.google.common.base.Optional;
import com.google.common.collect.ImmutableMap;

import net.minecraft.block.Block;
import net.minecraft.block.BlockBush;
import net.minecraft.block.IGrowable;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraftforge.common.property.IUnlistedProperty;

public class BlockUnidentifiedTreeSapling extends BlockBush implements IGrowable
{
    public BlockUnidentifiedTreeSapling()
    {
        this.setCreativeTab(CreativeTabs.DECORATIONS);
    }

    @Override
    protected BlockStateContainer createBlockState()
    {
        return new BlockStateContainer(this, new IProperty[0])
        {
            @Override
            protected StateImplementation createState(Block block, ImmutableMap<IProperty<?>, Comparable<?>> properties, ImmutableMap<IUnlistedProperty<?>, Optional<?>> unlistedProperties)
            {
                return new StateImplementation(block, properties)
                {
                    @Override
                    public boolean isOpaqueCube()
                    {
                        return false;
                    }
                };
            }
        };
    }

    @SuppressWarnings("unchecked")
    @Override
    public void getSubBlocks(Item itemIn, CreativeTabs tab, List list)
    {
        list.add(new ItemStack(itemIn, 1, 0));
    }

    public boolean isSapling(World world, BlockPos pos)
    {
        return world.getBlockState(pos).getBlock() == this;
    }

    public void generateTree(World world, BlockPos pos, IBlockState state, Random rand)
    {
        WorldGenerator tree = null;
        boolean largeTree = false;

        int rX = 0;
        int rZ = 0;

        for (rX = 0; rX >= -1; --rX)
        {
            for (rZ = 0; rZ >= -1; --rZ)
            {
                BlockPos posTree = pos.add(rX, 0, rZ);

                if (this.isSapling(world, posTree) && this.isSapling(world, posTree.add(1, 0, 0)) && this.isSapling(world, posTree.add(0, 0, 1)) && this.isSapling(world, posTree.add(1, 0, 1)))
                {
                    largeTree = true;
                }
            }
        }

        if (largeTree)
        {
            tree = new VardaTallTreeGenerator(true);
        }
        else
        {
            switch (rand.nextInt(3))
            {
                case 0:
                    tree = new VardaTreeGenerator(true);
                    break;
                case 1:
                    tree = new VardaTree2Generator(true);
                    break;
                case 2:
                    tree = new VardaTree3Generator(true);
                    break;
            }
        }

        Block block = Blocks.AIR;
        BlockPos posTree = pos.add(rX, 0, rZ);

        if (largeTree)
        {
            world.setBlockState(posTree.add(0, 0, 0), block.getDefaultState());
            world.setBlockState(posTree.add(1, 0, 0), block.getDefaultState());
            world.setBlockState(posTree.add(0, 0, 1), block.getDefaultState());
            world.setBlockState(posTree.add(1, 0, 1), block.getDefaultState());
        }
        else
        {
            world.setBlockState(pos, block.getDefaultState());
        }

        if (!tree.generate(world, rand, pos))
        {
            if (largeTree)
            {
                world.setBlockState(posTree.add(0, 0, 0), this.getDefaultState());
                world.setBlockState(posTree.add(1, 0, 0), this.getDefaultState());
                world.setBlockState(posTree.add(0, 0, 1), this.getDefaultState());
                world.setBlockState(posTree.add(1, 0, 1), this.getDefaultState());
            }
            else
            {
                world.setBlockState(pos, this.getDefaultState());
            }
        }
    }

    @Override
    public boolean canGrow(World worldIn, BlockPos pos, IBlockState state, boolean isClient)
    {
        return true;
    }

    @Override
    public boolean canUseBonemeal(World worldIn, Random rand, BlockPos pos, IBlockState state)
    {
        return (double) worldIn.rand.nextFloat() < 0.45D;
    }

    @Override
    public void grow(World worldIn, Random rand, BlockPos pos, IBlockState state)
    {
        this.generateTree(worldIn, pos, state, rand);
    }
}
