package org.avp.world;

import java.util.Random;

import org.avp.AliensVsPredator;

import com.arisux.mdxlib.lib.world.CoordData;
import com.arisux.mdxlib.lib.world.Worlds;

import cpw.mods.fml.common.IWorldGenerator;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.chunk.IChunkProvider;

public class WorldGenerator implements IWorldGenerator
{
    @Override
    public void generate(Random seed, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator, IChunkProvider chunkProvider)
    {
        this.generateSurface(world, seed, chunkX * 16, chunkZ * 16);
    }

    private void generateSurface(World world, Random rand, int chunkX, int chunkZ)
    {
        CoordData chunkCoords = new CoordData(chunkX, 0, chunkZ);
        BiomeGenBase[] overworldBiomes = new BiomeGenBase[] { BiomeGenBase.beach, BiomeGenBase.birchForest, BiomeGenBase.birchForestHills, BiomeGenBase.coldBeach, BiomeGenBase.coldTaiga, BiomeGenBase.coldTaigaHills, BiomeGenBase.desert, BiomeGenBase.desertHills, BiomeGenBase.extremeHills, BiomeGenBase.extremeHillsEdge, BiomeGenBase.extremeHillsPlus, BiomeGenBase.forest, BiomeGenBase.forestHills, BiomeGenBase.frozenOcean, BiomeGenBase.frozenRiver, BiomeGenBase.iceMountains, BiomeGenBase.icePlains, BiomeGenBase.jungle, BiomeGenBase.jungleEdge, BiomeGenBase.jungleHills, BiomeGenBase.plains, BiomeGenBase.river, BiomeGenBase.roofedForest, BiomeGenBase.swampland, BiomeGenBase.taiga, BiomeGenBase.taigaHills, BiomeGenBase.ocean, BiomeGenBase.deepOcean
        };
        Worlds.generateBlockInChunk(world, AliensVsPredator.blocks().oreCopper, rand, 50, 4, 16, 96, chunkCoords, overworldBiomes);
        Worlds.generateBlockInChunk(world, AliensVsPredator.blocks().oreSilicon, rand, 40, 3, 5, 48, chunkCoords, overworldBiomes);
        Worlds.generateBlockInChunk(world, AliensVsPredator.blocks().oreLithium, rand, 40, 3, 5, 48, chunkCoords, overworldBiomes);
        Worlds.generateBlockInChunk(world, AliensVsPredator.blocks().oreBauxite, rand, 50, 4, 16, 128, chunkCoords, overworldBiomes);
    }
}
