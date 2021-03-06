package org.avp;

import java.util.ArrayList;
import java.util.Arrays;

import org.avp.entities.EntityAPC;
import org.avp.entities.EntityAcidPool;
import org.avp.entities.EntityAcidProjectile;
import org.avp.entities.EntityFlame;
import org.avp.entities.EntityGrenade;
import org.avp.entities.EntityLaserMine;
import org.avp.entities.EntityLiquidLatexPool;
import org.avp.entities.EntityMechanism;
import org.avp.entities.EntityMedpod;
import org.avp.entities.EntityPlasma;
import org.avp.entities.EntityShuriken;
import org.avp.entities.EntitySmartDisc;
import org.avp.entities.EntitySpear;
import org.avp.entities.EntitySupplyChute;
import org.avp.entities.EntitySupplyChuteMarines;
import org.avp.entities.EntitySupplyChuteSeegson;
import org.avp.entities.EntityTurret;
import org.avp.entities.EntityWristbracer;
import org.avp.entities.living.EntityAethon;
import org.avp.entities.living.EntityAqua;
import org.avp.entities.living.EntityBabyhead;
import org.avp.entities.living.EntityBatXeno;
import org.avp.entities.living.EntityBelugaburster;
import org.avp.entities.living.EntityBelugamorph;
import org.avp.entities.living.EntityBoiler;
import org.avp.entities.living.EntityChestburster;
import org.avp.entities.living.EntityCombatSynthetic;
import org.avp.entities.living.EntityCrusher;
import org.avp.entities.living.EntityDeacon;
import org.avp.entities.living.EntityDeaconAdult;
import org.avp.entities.living.EntityDeaconShark;
import org.avp.entities.living.EntityDracoEgg;
import org.avp.entities.living.EntityDracoburster;
import org.avp.entities.living.EntityDracomorph;
import org.avp.entities.living.EntityDrone;
import org.avp.entities.living.EntityEngineer;
import org.avp.entities.living.EntityFacehugger;
import org.avp.entities.living.EntityGooMutant;
import org.avp.entities.living.EntityHammerpede;
import org.avp.entities.living.EntityMarine;
import org.avp.entities.living.EntityMatriarch;
import org.avp.entities.living.EntityMyceliomorph;
import org.avp.entities.living.EntityOctohugger;
import org.avp.entities.living.EntityOvamorph;
import org.avp.entities.living.EntityPantheramorph;
import org.avp.entities.living.EntityPraetorian;
import org.avp.entities.living.EntityPredalien;
import org.avp.entities.living.EntityPredalienChestburster;
import org.avp.entities.living.EntityPredatorHound;
import org.avp.entities.living.EntityQueenChestburster;
import org.avp.entities.living.EntityRoyalFacehugger;
import org.avp.entities.living.EntityRunnerChestburster;
import org.avp.entities.living.EntityRunnerDrone;
import org.avp.entities.living.EntityRunnerWarrior;
import org.avp.entities.living.EntityScelemur;
import org.avp.entities.living.EntitySpaceJockey;
import org.avp.entities.living.EntitySpitter;
import org.avp.entities.living.EntityTrilobite;
import org.avp.entities.living.EntityUltramorph;
import org.avp.entities.living.EntityUrsuidae;
import org.avp.entities.living.EntityWarrior;
import org.avp.entities.living.EntityYautjaBerserker;
import org.avp.entities.living.EntityYautjaMutant;
import org.avp.entities.living.EntityYautjaWarrior;
import org.avp.tile.TileEntityAmpule;
import org.avp.tile.TileEntityAssembler;
import org.avp.tile.TileEntityBlastdoor;
import org.avp.tile.TileEntityCCFLTube;
import org.avp.tile.TileEntityCryostasisTube;
import org.avp.tile.TileEntityGunLocker;
import org.avp.tile.TileEntityHiveResin;
import org.avp.tile.TileEntityLightPanel;
import org.avp.tile.TileEntityLocker;
import org.avp.tile.TileEntityMedpod;
import org.avp.tile.TileEntityNegativeTransformer;
import org.avp.tile.TileEntityNetworkRack;
import org.avp.tile.TileEntityPowercell;
import org.avp.tile.TileEntityPowerline;
import org.avp.tile.TileEntityRedstoneEmitter;
import org.avp.tile.TileEntityRedstoneFluxGenerator;
import org.avp.tile.TileEntityRedstoneSensor;
import org.avp.tile.TileEntityReflective;
import org.avp.tile.TileEntityRepulsionGenerator;
import org.avp.tile.TileEntitySatelliteDish;
import org.avp.tile.TileEntitySevastopolBlastDoor;
import org.avp.tile.TileEntitySkull;
import org.avp.tile.TileEntitySolarPanel;
import org.avp.tile.TileEntityStasisMechanism;
import org.avp.tile.TileEntitySupplyCrate;
import org.avp.tile.TileEntityTransformer;
import org.avp.tile.TileEntityTurret;
import org.avp.tile.TileEntityWorkstation;
import org.avp.world.dimension.BiomeGenLV;
import org.avp.world.dimension.acheron.BiomeAcheron;
import org.avp.world.dimension.varda.BiomeVarda;

import com.arisux.mdx.lib.game.IInitEvent;

import net.minecraft.block.material.Material;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.init.Biomes;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.EntityEntry;
import net.minecraftforge.fml.common.registry.EntityEntryBuilder;
import net.minecraftforge.fml.common.registry.EntityRegistry;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class EntityHandler implements IInitEvent
{
    public static final EntityHandler     instance       = new EntityHandler();
    private static int                    entityId       = 0;

    private static ArrayList<EntityEntry> entities       = new ArrayList<EntityEntry>();
    private static ArrayList<EntityEntry> livingEntities = new ArrayList<EntityEntry>();

    @Mod.EventBusSubscriber(modid = AliensVsPredator.Properties.ID)
    public static class RegistrationHandler
    {
        static
        {
            entities.add(EntityEntryBuilder.create().entity(EntitySpear.class).id("Spear", entityId++).name("Spear").tracker(250, 4, true).build());
            entities.add(EntityEntryBuilder.create().entity(EntityLaserMine.class).id("ProximityMine", entityId++).name("ProximityMine").tracker(250, 4, true).build());
            entities.add(EntityEntryBuilder.create().entity(EntityPlasma.class).id("Plasma", entityId++).name("Plasma").tracker(250, 4, true).build());
            entities.add(EntityEntryBuilder.create().entity(EntityGrenade.class).id("Grenade", entityId++).name("Grenade").tracker(250, 4, true).build());
            entities.add(EntityEntryBuilder.create().entity(EntityFlame.class).id("Flamethrower", entityId++).name("Flamethrower").tracker(250, 4, true).build());
            entities.add(EntityEntryBuilder.create().entity(EntityAcidPool.class).id("AcidPool", entityId++).name("AcidPool").tracker(250, 4, true).build());
            entities.add(EntityEntryBuilder.create().entity(EntityLiquidLatexPool.class).id("LiquidLatexPool", entityId++).name("LiquidLatexPool").tracker(250, 4, true).build());
            entities.add(EntityEntryBuilder.create().entity(EntityAcidProjectile.class).id("AcidSpit", entityId++).name("AcidSpit").tracker(250, 4, true).build());
            entities.add(EntityEntryBuilder.create().entity(EntitySmartDisc.class).id("EntityDisc", entityId++).name("EntityDisc").tracker(250, 4, true).build());
            entities.add(EntityEntryBuilder.create().entity(EntityShuriken.class).id("EntityShuriken", entityId++).name("EntityShuriken").tracker(250, 4, true).build());
            entities.add(EntityEntryBuilder.create().entity(EntityTurret.class).id("EntityTurret", entityId++).name("EntityTurret").tracker(250, 4, true).build());
            entities.add(EntityEntryBuilder.create().entity(EntityWristbracer.class).id("Nuke", entityId++).name("Nuke").tracker(250, 4, true).build());
            entities.add(EntityEntryBuilder.create().entity(EntityAPC.class).id("APC", entityId++).name("APC").tracker(250, 4, true).build());
            entities.add(EntityEntryBuilder.create().entity(EntityMechanism.class).id("MECHANISM", entityId++).name("MECHANISM").tracker(250, 4, true).build());
            entities.add(EntityEntryBuilder.create().entity(EntityMedpod.class).id("Medpod", entityId++).name("Medpod").tracker(250, 4, true).build());
            entities.add(EntityEntryBuilder.create().entity(EntitySupplyChute.class).id("SupplyChute", entityId++).name("SupplyChute").tracker(250, 4, true).build());
            entities.add(EntityEntryBuilder.create().entity(EntitySupplyChuteMarines.class).id("SupplyChuteMarines", entityId++).name("SupplyChuteMarines").tracker(250, 4, true).build());
            entities.add(EntityEntryBuilder.create().entity(EntitySupplyChuteSeegson.class).id("SupplyChuteSeegson", entityId++).name("SupplyChuteSeegson").tracker(250, 4, true).build());

            livingEntities.add(EntityEntryBuilder.create().entity(EntityRunnerDrone.class).id("RunnerDrone", entityId++).name("RunnerDrone").tracker(250, 4, true).build());
            livingEntities.add(EntityEntryBuilder.create().entity(EntityRunnerWarrior.class).id("RunnerWarrior", entityId++).name("RunnerWarrior").tracker(250, 4, true).build());
            livingEntities.add(EntityEntryBuilder.create().entity(EntityDrone.class).id("Drone", entityId++).name("Drone").tracker(250, 4, true).build());
            livingEntities.add(EntityEntryBuilder.create().entity(EntityWarrior.class).id("Warrior", entityId++).name("Warrior").tracker(250, 4, true).build());
            livingEntities.add(EntityEntryBuilder.create().entity(EntitySpitter.class).id("Spitter", entityId++).name("Spitter").tracker(250, 4, true).build());
            livingEntities.add(EntityEntryBuilder.create().entity(EntityCrusher.class).id("Crusher", entityId++).name("Crusher").tracker(250, 4, true).build());
            livingEntities.add(EntityEntryBuilder.create().entity(EntityPraetorian.class).id("Praetorian", entityId++).name("Praetorian").tracker(250, 4, true).build());
            livingEntities.add(EntityEntryBuilder.create().entity(EntityMarine.class).id("Marine", entityId++).name("Marine").tracker(250, 4, true).build());
            livingEntities.add(EntityEntryBuilder.create().entity(EntityYautjaWarrior.class).id("Yautja", entityId++).name("Yautja").tracker(250, 4, true).build());
            livingEntities.add(EntityEntryBuilder.create().entity(EntityMatriarch.class).id("Queen", entityId++).name("Queen").tracker(250, 4, true).build());
            livingEntities.add(EntityEntryBuilder.create().entity(EntityFacehugger.class).id("Facehugger", entityId++).name("Facehugger").tracker(250, 4, true).build());
            livingEntities.add(EntityEntryBuilder.create().entity(EntityChestburster.class).id("Chestbuster", entityId++).name("Chestbuster").tracker(250, 4, true).build());
            livingEntities.add(EntityEntryBuilder.create().entity(EntityOvamorph.class).id("Ovamorph", entityId++).name("Ovamorph").tracker(250, 4, true).build());
            livingEntities.add(EntityEntryBuilder.create().entity(EntityRoyalFacehugger.class).id("RoyalFacehugger", entityId++).name("RoyalFacehugger").tracker(250, 4, true).build());
            livingEntities.add(EntityEntryBuilder.create().entity(EntityAqua.class).id("AquaAlien", entityId++).name("AquaAlien").tracker(250, 4, true).build());
            livingEntities.add(EntityEntryBuilder.create().entity(EntityPredalien.class).id("Predalien", entityId++).name("Predalien").tracker(250, 4, true).build());
            livingEntities.add(EntityEntryBuilder.create().entity(EntityCombatSynthetic.class).id("CombatSynthetic", entityId++).name("CombatSynthetic").tracker(250, 4, true).build());
            livingEntities.add(EntityEntryBuilder.create().entity(EntityDeacon.class).id("Deacon", entityId++).name("Deacon").tracker(250, 4, true).build());
            livingEntities.add(EntityEntryBuilder.create().entity(EntityHammerpede.class).id("Hammerpede", entityId++).name("Hammerpede").tracker(250, 4, true).build());
            livingEntities.add(EntityEntryBuilder.create().entity(EntityTrilobite.class).id("Trilobite", entityId++).name("Trilobite").tracker(250, 4, true).build());
            livingEntities.add(EntityEntryBuilder.create().entity(EntitySpaceJockey.class).id("SpaceJockey", entityId++).name("SpaceJockey").tracker(250, 4, true).build());
            livingEntities.add(EntityEntryBuilder.create().entity(EntityEngineer.class).id("Engineer", entityId++).name("Engineer").tracker(250, 4, true).build());
            livingEntities.add(EntityEntryBuilder.create().entity(EntityYautjaBerserker.class).id("YautjaBerserker", entityId++).name("YautjaBerserker").tracker(250, 4, true).build());
            livingEntities.add(EntityEntryBuilder.create().entity(EntityDeaconShark.class).id("DeaconShark", entityId++).name("DeaconShark").tracker(250, 4, true).build());
            livingEntities.add(EntityEntryBuilder.create().entity(EntityUltramorph.class).id("Ultramorph", entityId++).name("Ultramorph").tracker(250, 4, true).build());
            livingEntities.add(EntityEntryBuilder.create().entity(EntityGooMutant.class).id("GooMutant", entityId++).name("GooMutant").tracker(250, 4, true).build());
            livingEntities.add(EntityEntryBuilder.create().entity(EntityAethon.class).id("Aethon", entityId++).name("Aethon").tracker(250, 4, true).build());
            livingEntities.add(EntityEntryBuilder.create().entity(EntityOctohugger.class).id("Octohugger", entityId++).name("Octohugger").tracker(250, 4, true).build());
            livingEntities.add(EntityEntryBuilder.create().entity(EntityBelugaburster.class).id("Belugaburster", entityId++).name("Belugaburster").tracker(250, 4, true).build());
            livingEntities.add(EntityEntryBuilder.create().entity(EntityBelugamorph.class).id("Belugamorph", entityId++).name("Belugamorph").tracker(250, 4, true).build());
            livingEntities.add(EntityEntryBuilder.create().entity(EntityPredalienChestburster.class).id("PredalienChestburster", entityId++).name("PredalienChestburster").tracker(250, 4, true).build());
            livingEntities.add(EntityEntryBuilder.create().entity(EntityQueenChestburster.class).id("QueenChestburster", entityId++).name("QueenChestburster").tracker(250, 4, true).build());
            livingEntities.add(EntityEntryBuilder.create().entity(EntityRunnerChestburster.class).id("RunnerChestburster", entityId++).name("RunnerChestburster").tracker(250, 4, true).build());
            livingEntities.add(EntityEntryBuilder.create().entity(EntityBabyhead.class).id("Babyhead", entityId++).name("Babyhead").tracker(250, 4, true).build());
            livingEntities.add(EntityEntryBuilder.create().entity(EntityBatXeno.class).id("BatXeno", entityId++).name("BatXeno").tracker(250, 4, true).build());
            livingEntities.add(EntityEntryBuilder.create().entity(EntityBoiler.class).id("Boiler", entityId++).name("Boiler").tracker(250, 4, true).build());
            livingEntities.add(EntityEntryBuilder.create().entity(EntityDracoburster.class).id("Dracoburster", entityId++).name("Dracoburster").tracker(250, 4, true).build());
            livingEntities.add(EntityEntryBuilder.create().entity(EntityDracoEgg.class).id("DracoOvamorph", entityId++).name("DracoOvamorph").tracker(250, 4, true).build());
            livingEntities.add(EntityEntryBuilder.create().entity(EntityDracomorph.class).id("Dracomorph", entityId++).name("Dracomorph").tracker(250, 4, true).build());
            livingEntities.add(EntityEntryBuilder.create().entity(EntityMyceliomorph.class).id("Myceliomorph", entityId++).name("Myceliomorph").tracker(250, 4, true).build());
            livingEntities.add(EntityEntryBuilder.create().entity(EntityPantheramorph.class).id("Pantheramorph", entityId++).name("Pantheramorph").tracker(250, 4, true).build());
            livingEntities.add(EntityEntryBuilder.create().entity(EntityPredatorHound.class).id("HellHound", entityId++).name("HellHound").tracker(250, 4, true).build());
            livingEntities.add(EntityEntryBuilder.create().entity(EntityUrsuidae.class).id("Ursuidae", entityId++).name("Ursuidae").tracker(250, 4, true).build());
            livingEntities.add(EntityEntryBuilder.create().entity(EntityScelemur.class).id("VardaMonkey", entityId++).name("VardaMonkey").tracker(250, 4, true).build());
            livingEntities.add(EntityEntryBuilder.create().entity(EntityYautjaMutant.class).id("YautjaMutant", entityId++).name("YautjaMutant").tracker(250, 4, true).build());
            livingEntities.add(EntityEntryBuilder.create().entity(EntityDeaconAdult.class).id("DeaconAdult", entityId++).name("DeaconAdult").tracker(250, 4, true).build());

        }

        @SubscribeEvent
        public static void registerEntities(final RegistryEvent.Register<EntityEntry> event)
        {
            for (EntityEntry ee : entities)
            {
                event.getRegistry().register(ee);
            }
            
            for (EntityEntry ee : livingEntities)
            {
                event.getRegistry().register(ee);
            }
        }
    }

    @Override
    public void init(FMLInitializationEvent event)
    {
        this.registerTileEntities();
        this.registerSpawns();
    }

    public void registerTileEntities()
    {
        GameRegistry.registerTileEntity(TileEntityTurret.class, new ResourceLocation(AliensVsPredator.Properties.ID, "tileEntityTurret"));
        GameRegistry.registerTileEntity(TileEntityWorkstation.class, new ResourceLocation(AliensVsPredator.Properties.ID, "tileEntityWorkstation"));
        GameRegistry.registerTileEntity(TileEntityHiveResin.class, new ResourceLocation(AliensVsPredator.Properties.ID, "tileEntityBlockHive"));
        GameRegistry.registerTileEntity(TileEntityAssembler.class, new ResourceLocation(AliensVsPredator.Properties.ID, "tileEntityAssembler"));
        GameRegistry.registerTileEntity(TileEntityStasisMechanism.class, new ResourceLocation(AliensVsPredator.Properties.ID, "tileStasisMechanism"));
        GameRegistry.registerTileEntity(TileEntityRepulsionGenerator.class, new ResourceLocation(AliensVsPredator.Properties.ID, "tileEntityGenerator"));
        GameRegistry.registerTileEntity(TileEntityPowerline.class, new ResourceLocation(AliensVsPredator.Properties.ID, "tileEntityPowerline"));
        GameRegistry.registerTileEntity(TileEntityBlastdoor.class, new ResourceLocation(AliensVsPredator.Properties.ID, "tileEntityBlastdoor"));
        GameRegistry.registerTileEntity(TileEntitySevastopolBlastDoor.class, new ResourceLocation(AliensVsPredator.Properties.ID, "tileEntitySevastopolBlastdoor"));
        GameRegistry.registerTileEntity(TileEntityCryostasisTube.class, new ResourceLocation(AliensVsPredator.Properties.ID, "tileEntityCryostasisTube"));
        GameRegistry.registerTileEntity(TileEntityLightPanel.class, new ResourceLocation(AliensVsPredator.Properties.ID, "tileEntityLightPanel"));
        GameRegistry.registerTileEntity(TileEntityCCFLTube.class, new ResourceLocation(AliensVsPredator.Properties.ID, "tileEntityCCFLTube"));
        GameRegistry.registerTileEntity(TileEntityNetworkRack.class, new ResourceLocation(AliensVsPredator.Properties.ID, "tileEntitySatelliteModem"));
        GameRegistry.registerTileEntity(TileEntitySatelliteDish.class, new ResourceLocation(AliensVsPredator.Properties.ID, "tileEntitySatelliteDish"));
        GameRegistry.registerTileEntity(TileEntityTransformer.class, new ResourceLocation(AliensVsPredator.Properties.ID, "tileEntityTransformer"));
        GameRegistry.registerTileEntity(TileEntityNegativeTransformer.class, new ResourceLocation(AliensVsPredator.Properties.ID, "tileEntityNegativeTransformer"));
        GameRegistry.registerTileEntity(TileEntityRedstoneSensor.class, new ResourceLocation(AliensVsPredator.Properties.ID, "tileEntityR2PConverter"));
        GameRegistry.registerTileEntity(TileEntityRedstoneEmitter.class, new ResourceLocation(AliensVsPredator.Properties.ID, "tileEntityP2RConverter"));
        GameRegistry.registerTileEntity(TileEntityPowercell.class, new ResourceLocation(AliensVsPredator.Properties.ID, "tileEntityPowercell"));
        GameRegistry.registerTileEntity(TileEntityAmpule.class, new ResourceLocation(AliensVsPredator.Properties.ID, "tileEntityAmpule"));
        GameRegistry.registerTileEntity(TileEntityLocker.class, new ResourceLocation(AliensVsPredator.Properties.ID, "tileEntityLocker"));
        GameRegistry.registerTileEntity(TileEntityGunLocker.class, new ResourceLocation(AliensVsPredator.Properties.ID, "tileEntityGunLocker"));
        GameRegistry.registerTileEntity(TileEntityMedpod.class, new ResourceLocation(AliensVsPredator.Properties.ID, "tileEntityMedpod"));
        GameRegistry.registerTileEntity(TileEntitySupplyCrate.class, new ResourceLocation(AliensVsPredator.Properties.ID, "tileEntitySupplyCrate"));
        GameRegistry.registerTileEntity(TileEntitySolarPanel.class, new ResourceLocation(AliensVsPredator.Properties.ID, "tile.avp.solarpanel"));
        GameRegistry.registerTileEntity(TileEntitySkull.class, new ResourceLocation(AliensVsPredator.Properties.ID, "tile.avp.skull"));
        GameRegistry.registerTileEntity(TileEntityRedstoneFluxGenerator.class, new ResourceLocation(AliensVsPredator.Properties.ID, "tile.avp.redstonefluxgenerator"));
        GameRegistry.registerTileEntity(TileEntityReflective.class, new ResourceLocation(AliensVsPredator.Properties.ID, "tile.avp.reflective"));
    }

    private static final Class<?>[][] PARAM_TYPES = new Class[][] { { EnumCreatureType.class, Class.class, int.class, Material.class, boolean.class, boolean.class } };
    // public static final EnumCreatureType WATER_MONSTER = EnumHelper.addEnum(PARAM_TYPES,
    // EnumCreatureType.class, "water_monster", IMob.class, 20, Material.WATER, false, false);

    private void registerSpawns()
    {
        if (AliensVsPredator.settings().areAutoSpawnsEnabled())
        {
            Biome[] xenomorphBiomes = this.getFilteredBiomeArray(Biomes.BIRCH_FOREST, Biomes.BIRCH_FOREST_HILLS, Biomes.COLD_BEACH, Biomes.COLD_TAIGA, Biomes.COLD_TAIGA_HILLS, Biomes.DESERT_HILLS, Biomes.EXTREME_HILLS, Biomes.EXTREME_HILLS_EDGE, Biomes.EXTREME_HILLS_WITH_TREES, Biomes.FOREST, Biomes.FOREST_HILLS, Biomes.ICE_MOUNTAINS, Biomes.ICE_PLAINS, Biomes.JUNGLE, Biomes.JUNGLE_EDGE, Biomes.JUNGLE_HILLS, Biomes.PLAINS, Biomes.ROOFED_FOREST, Biomes.SWAMPLAND, Biomes.TAIGA, Biomes.TAIGA_HILLS, BiomeAcheron.acheron);

            Biome[] predatorBiomes = this.getFilteredBiomeArray(Biomes.BIRCH_FOREST, Biomes.BIRCH_FOREST_HILLS, Biomes.DESERT, Biomes.DESERT_HILLS, Biomes.EXTREME_HILLS, Biomes.EXTREME_HILLS_EDGE, Biomes.EXTREME_HILLS_WITH_TREES, Biomes.FOREST, Biomes.FOREST_HILLS, Biomes.FROZEN_OCEAN, Biomes.FROZEN_RIVER, Biomes.ICE_PLAINS, Biomes.JUNGLE, Biomes.JUNGLE_EDGE, Biomes.JUNGLE_HILLS, Biomes.TAIGA, Biomes.TAIGA_HILLS);

            Biome[] vardaBiomes = this.getFilteredBiomeArray(BiomeVarda.vardaBadlands, BiomeVarda.vardaForest);

            Biome[] aquaXenomorphBiomes = this.getFilteredBiomeArray(Biomes.RIVER, Biomes.BEACH, Biomes.STONE_BEACH);

            if (AliensVsPredator.settings().shouldEvolvedXenomorphsSpawn())
            {
                EntityRegistry.addSpawn(EntityAqua.class, 5, 1, 2, EnumCreatureType.MONSTER, aquaXenomorphBiomes);
                EntityRegistry.addSpawn(EntityDrone.class, 50, 1, 3, EnumCreatureType.MONSTER, xenomorphBiomes);
                EntityRegistry.addSpawn(EntityWarrior.class, 20, 1, 3, EnumCreatureType.MONSTER, xenomorphBiomes);
                EntityRegistry.addSpawn(EntityPraetorian.class, 5, 1, 2, EnumCreatureType.MONSTER, xenomorphBiomes);
                EntityRegistry.addSpawn(EntityChestburster.class, 5, 1, 3, EnumCreatureType.MONSTER, xenomorphBiomes);
                EntityRegistry.addSpawn(EntityFacehugger.class, 5, 1, 2, EnumCreatureType.MONSTER, xenomorphBiomes);
            }
            else
            {
                EntityRegistry.addSpawn(EntityFacehugger.class, 30, 1, 2, EnumCreatureType.MONSTER, xenomorphBiomes);
            }

            EntityRegistry.addSpawn(EntityYautjaWarrior.class, 1, 0, 1, EnumCreatureType.MONSTER, predatorBiomes);
            EntityRegistry.addSpawn(EntityYautjaBerserker.class, 1, 0, 1, EnumCreatureType.MONSTER, predatorBiomes);
            EntityRegistry.addSpawn(EntityMarine.class, 2, 1, 1, EnumCreatureType.CREATURE, new Biome[] { Biomes.SWAMPLAND, Biomes.FOREST, Biomes.FOREST_HILLS, Biomes.TAIGA, Biomes.TAIGA_HILLS, Biomes.PLAINS
            });
            EntityRegistry.addSpawn(EntityEngineer.class, 5, 1, 1, EnumCreatureType.MONSTER, vardaBiomes);
            EntityRegistry.addSpawn(EntitySpaceJockey.class, 2, 1, 1, EnumCreatureType.MONSTER, vardaBiomes);

            EntityRegistry.addSpawn(EntityHammerpede.class, 1, 0, 3, EnumCreatureType.MONSTER, vardaBiomes);
            EntityRegistry.addSpawn(EntityOctohugger.class, 20, 0, 3, EnumCreatureType.MONSTER, vardaBiomes);
            EntityRegistry.addSpawn(EntityDeacon.class, 1, 0, 1, EnumCreatureType.MONSTER, vardaBiomes);
            EntityRegistry.addSpawn(EntityEngineer.class, 1, 0, 1, EnumCreatureType.MONSTER, vardaBiomes);
            EntityRegistry.addSpawn(EntityTrilobite.class, 1, 0, 1, EnumCreatureType.MONSTER, vardaBiomes);
        }
    }

    public Biome[] getFilteredBiomeArray(Biome... biomes)
    {
        ArrayList<Biome> biomeList = new ArrayList<Biome>(Arrays.asList(biomes));

        if (!AliensVsPredator.settings().areOverworldSpawnsEnabled())
        {
            biomeList = this.clearVanillaBiomes(biomeList);
        }

        return (Biome[]) Arrays.copyOf(biomeList.toArray(), biomeList.toArray().length, Biome[].class);
    }

    private ArrayList<Biome> clearVanillaBiomes(ArrayList<Biome> biomeList)
    {
        ArrayList<Biome> newList = new ArrayList<Biome>(biomeList);

        for (Biome biome : biomeList)
        {
            if (!(biome instanceof BiomeGenLV))
            {
                newList.remove(biome);
            }
        }

        return newList;
    }
}
