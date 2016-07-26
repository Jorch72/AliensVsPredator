package org.avp;

import org.avp.block.BlockAmpule;
import org.avp.block.BlockAssembler;
import org.avp.block.BlockBlackGoo;
import org.avp.block.BlockBlastdoor;
import org.avp.block.BlockCryostasisTube;
import org.avp.block.BlockCustomSlab;
import org.avp.block.BlockCustomStairs;
import org.avp.block.BlockGenerator;
import org.avp.block.BlockGunLocker;
import org.avp.block.BlockHiveResin;
import org.avp.block.BlockLightPanel;
import org.avp.block.BlockLocker;
import org.avp.block.BlockMedpod;
import org.avp.block.BlockMist;
import org.avp.block.BlockNegativeTransformer;
import org.avp.block.BlockP2RConverter;
import org.avp.block.BlockPortal;
import org.avp.block.BlockPowercell;
import org.avp.block.BlockPowerline;
import org.avp.block.BlockR2PConverter;
import org.avp.block.BlockSatelliteDish;
import org.avp.block.BlockSatelliteModem;
import org.avp.block.BlockSolarPanel;
import org.avp.block.BlockStalagmite;
import org.avp.block.BlockStasisMechanism;
import org.avp.block.BlockSupplyCrate;
import org.avp.block.BlockTempleSpawner;
import org.avp.block.BlockTransformer;
import org.avp.block.BlockTurret;
import org.avp.block.BlockUnidentifiedDirt;
import org.avp.block.BlockUnidentifiedLog;
import org.avp.block.BlockUnidentifiedTreeLeaves;
import org.avp.block.BlockUnidentifiedTreeSapling;
import org.avp.block.BlockUnidentifiedTreeTendon;
import org.avp.block.BlockWall;
import org.avp.block.BlockWorkstation;

import com.arisux.airi.lib.BlockTypes.BlockMaterial;
import com.arisux.airi.lib.ModUtil.IBHandler;
import com.arisux.airi.lib.interfaces.IInitializable;

import cpw.mods.fml.common.event.FMLInitializationEvent;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;

public class BlockHandler extends IBHandler implements IInitializable
{
    public static BlockHandler instance                   = new BlockHandler();

    public Block               terrainHiveResin           = (new BlockHiveResin(Material.wood)).setHardness(5F).setResistance(10.0F).setLightOpacity(255);
    public Block               blockOvamorph              = (new BlockMaterial(Material.rock));
    public Block               blockShipMetal1            = (new BlockMaterial(Material.iron).setHardness(5F).setResistance(30.0F).setLightOpacity(255));
    public Block               blockShipMetal2            = (new BlockMaterial(Material.iron).setHardness(5F).setResistance(30.0F).setLightOpacity(255));
    public Block               blockFacehuggerRelic       = (new BlockMaterial(Material.rock).setHardness(5F).setResistance(30.0F).setLightOpacity(255));
    public Block               blockAlienRelic            = (new BlockMaterial(Material.rock).setHardness(5F).setResistance(30.0F).setLightOpacity(255));
    public Block               blockShipDecor1            = (new BlockMaterial(Material.iron).setHardness(5F).setResistance(30.0F).setLightOpacity(255));
    public Block               blockShipDecor2            = (new BlockMaterial(Material.iron).setHardness(5F).setResistance(30.0F).setLightOpacity(255));
    public Block               blockShipDecor3            = (new BlockMaterial(Material.iron).setHardness(5F).setResistance(30.0F).setLightOpacity(255));
    public Block               blockShipDecor4            = (new BlockMaterial(Material.iron).setHardness(5F).setResistance(30.0F).setLightOpacity(255));
    public Block               blockShipDecor5            = (new BlockMaterial(Material.iron).setHardness(5F).setResistance(30.0F).setLightOpacity(255));
    public Block               blockShipDecor6            = (new BlockMaterial(Material.iron).setHardness(5F).setResistance(30.0F).setLightOpacity(255));
    public Block               blockTempleBrick           = (new BlockMaterial(Material.rock).setHardness(5F).setResistance(30.0F).setLightOpacity(255));
    public Block               blockTempleTile            = (new BlockMaterial(Material.rock).setHardness(5F).setResistance(30.0F).setLightOpacity(255));
    public Block               blockTempleWall1           = (new BlockMaterial(Material.rock).setHardness(5F).setResistance(30.0F).setLightOpacity(255));
    public Block               blockTempleWall2           = (new BlockMaterial(Material.rock).setHardness(5F).setResistance(30.0F).setLightOpacity(255));
    public Block               blockWall                  = (new BlockMaterial(Material.iron)).setHardness(5F).setResistance(30.0F).setLightOpacity(255);
    public Block               blockCeiling               = (new BlockMaterial(Material.iron)).setHardness(5F).setResistance(30.0F).setLightOpacity(0);
    public Block               blockCeilingFan            = (new BlockMaterial(Material.iron)).setHardness(5F).setResistance(30.0F);
    public Block               blockCeiliingVent          = (new BlockMaterial(Material.iron)).setHardness(5F).setResistance(30.0F).setLightOpacity(0);
    public Block               blockCeilingGrill          = ((new BlockMaterial(Material.iron)).setHardness(5F).setResistance(30.0F)).setLightOpacity(4);
    public Block               blockSkulls                = (new BlockMaterial(Material.rock));
    public Block               blockFloorGrill            = ((new BlockMaterial(Material.iron)).setHardness(5F).setResistance(30.0F)).setLightOpacity(4);
    public Block               blockIronBricks            = (new BlockMaterial(Material.iron).setHardness(5F).setResistance(30.0F).setLightOpacity(255));
    public Block               blockVerticalMetal         = (new BlockMaterial(Material.iron).setHardness(5F).setResistance(30.0F).setLightOpacity(255));
    public Block               blockColumnMetal1          = (new BlockMaterial(Material.iron).setHardness(5F).setResistance(30.0F).setLightOpacity(255));
    public Block               blockColumnMetal2          = (new BlockMaterial(Material.iron).setHardness(5F).setResistance(30.0F).setLightOpacity(255));
    public Block               blockPlasticCircle         = (new BlockMaterial(Material.clay)).setHardness(10F).setResistance(30.0F).setLightOpacity(0);
    public Block               blockPlastic               = (new BlockMaterial(Material.clay)).setHardness(10F).setResistance(30.0F).setLightOpacity(0);
    public Block               blockPlasticTri            = (new BlockMaterial(Material.clay)).setHardness(10F).setResistance(30.0F).setLightOpacity(0);
    public Block               blockPlasticTile           = (new BlockMaterial(Material.clay)).setHardness(10F).setResistance(30.0F).setLightOpacity(0);
    public Block               oreSilicon                 = (new BlockMaterial(Material.rock)).setHardness(2.2F).setResistance(1.4F).setLightOpacity(255);
    public Block               oreLithium                 = (new BlockMaterial(Material.iron)).setHardness(4.2F).setResistance(5.4F).setLightOpacity(255);
    public Block               oreCopper                  = (new BlockMaterial(Material.iron)).setHardness(3.2F).setResistance(2.6F).setLightOpacity(255);
    public Block               oreBauxite                 = (new BlockMaterial(Material.iron)).setHardness(3.2F).setResistance(2.6F).setLightOpacity(255);
    public Block               mainframePanelShimmer      = (new BlockMaterial(Material.iron).setHardness(5F).setResistance(1F).setLightLevel(0.5F));
    public Block               mainframePanelFlicker      = (new BlockMaterial(Material.iron).setHardness(5F).setResistance(10F).setLightLevel(0.5F));
    public Block               blockVent0                 = (new BlockMaterial(Material.iron)).setHardness(5F).setResistance(30.0F).setLightOpacity(0);
    public Block               blockVent1                 = (new BlockMaterial(Material.iron)).setHardness(5F).setResistance(30.0F).setLightOpacity(0);
    public Block               blockVent2                 = (new BlockMaterial(Material.iron)).setHardness(5F).setResistance(30.0F).setLightOpacity(0);
    public Block               blockEngineerShipFloor     = (new BlockMaterial(Material.iron).setHardness(10F).setResistance(30.0F).setLightOpacity(255));
    public Block               blockEngineerShipBrick0    = (new BlockMaterial(Material.iron).setHardness(10F).setResistance(30.0F).setLightOpacity(255));
    public Block               blockEngineerShipBrick1    = (new BlockMaterial(Material.iron).setHardness(10F).setResistance(30.0F).setLightOpacity(255));
    public Block               blockEngineerShipBrick2    = (new BlockMaterial(Material.iron).setHardness(10F).setResistance(30.0F).setLightOpacity(255));
    public Block               blockEngineerShipBrick3    = (new BlockMaterial(Material.iron).setHardness(10F).setResistance(30.0F).setLightOpacity(255));
    public Block               blockEngineerShipGravel    = (new BlockMaterial(Material.iron).setHardness(10F).setResistance(30.0F).setLightOpacity(255));
    public Block               blockEngineerShipWall0     = (new BlockMaterial(Material.iron).setHardness(10F).setResistance(30.0F).setLightOpacity(255));
    public Block               blockEngineerShipWall1     = (new BlockMaterial(Material.iron).setHardness(10F).setResistance(30.0F).setLightOpacity(255));
    public Block               blockEngineerShipWall2     = (new BlockMaterial(Material.iron).setHardness(10F).setResistance(30.0F).setLightOpacity(255));
    public Block               blockEngineerShipWall3     = (new BlockMaterial(Material.iron).setHardness(10F).setResistance(30.0F).setLightOpacity(255));
    public Block               blockEngineerShipWall4     = (new BlockMaterial(Material.iron).setHardness(10F).setResistance(30.0F).setLightOpacity(255));
    public Block               blockEngineerShipRock0     = (new BlockMaterial(Material.iron).setHardness(10F).setResistance(30.0F).setLightOpacity(255));
    public Block               blockEngineerShipRock1     = (new BlockMaterial(Material.iron).setHardness(10F).setResistance(30.0F).setLightOpacity(255));
    public Block               blockEngineerShipRock2     = (new BlockMaterial(Material.iron).setHardness(10F).setResistance(30.0F).setLightOpacity(255));
    public Block               blockEngineerShipRock3     = (new BlockMaterial(Material.iron).setHardness(10F).setResistance(30.0F).setLightOpacity(255));
    public Block               blockEngineerShipColumn1   = (new BlockMaterial(Material.iron).setHardness(10F).setResistance(30.0F).setLightOpacity(255));
    public Block               blockEngineerShipColumn2   = (new BlockMaterial(Material.iron).setHardness(10F).setResistance(30.0F).setLightOpacity(255));
    public Block               blockEngineerShipMaterial1 = (new BlockMaterial(Material.iron).setHardness(10F).setResistance(30.0F).setLightOpacity(255));
    public Block               blockEngineerShipMaterial2 = (new BlockMaterial(Material.iron).setHardness(10F).setResistance(30.0F).setLightOpacity(255));
    public Block               terrainUniStone            = (new BlockMaterial(Material.rock)).setHardness(1.3F).setResistance(2.0F).setLightOpacity(255);
    public Block               terrainUniSand             = (new BlockMaterial(Material.sand)).setHardness(3.5F).setResistance(2.0F).setLightOpacity(255);
    public Block               terrainUniGravel           = (new BlockMaterial(Material.sand)).setHardness(3.0F).setLightOpacity(255);
    public Block               blockSatelliteDish         = (new BlockSatelliteDish()).setHardness(3.2F).setResistance(2.6F);
    public Block               blockEngineerShipMaterial0 = (new BlockMaterial(Material.iron).setHardness(10F).setResistance(30.0F).setLightOpacity(255));
    public Block               blockSacrificialSpawner    = (new BlockTempleSpawner(Material.rock, false));
    public Block               blockSpawnerCreative       = (new BlockTempleSpawner(Material.rock, true));
    public Block               blockPortalVarda           = (new BlockPortal(AliensVsPredator.settings().dimensionIdVarda()).setHardness(-1.0F).setLightLevel(2.0F));
    public Block               blockPortalAcheron         = (new BlockPortal(AliensVsPredator.settings().dimensionIdAcheron()).setHardness(-1.0F).setLightLevel(2.0F));
    public Block               blockAssembler             = (new BlockAssembler(Material.iron).setHardness(1.5F).setResistance(10.0F));
    public Block               blockFloorGrillStairs      = (new BlockCustomStairs(blockFloorGrill)).setHardness(5F).setResistance(30.0F).setLightOpacity(4);
    public Block               blockCeilingGrillStairs    = (new BlockCustomStairs(blockCeilingGrill)).setHardness(5F).setResistance(30.0F).setLightOpacity(4);
    public Block               blockIronBricksStairs      = (new BlockCustomStairs(blockIronBricks)).setHardness(5F).setResistance(30.0F).setLightOpacity(255);
    public Block               blockWallStairs            = (new BlockCustomStairs(blockWall)).setHardness(5F).setResistance(30.0F).setLightOpacity(255);
    public Block               terrainUniDirt             = (new BlockUnidentifiedDirt()).setHardness(0.5F).setResistance(2.0F).setLightOpacity(255);
    public Block               terrainStalagmite          = (new BlockStalagmite(Material.plants)).setHardness(0.0F).setLightOpacity(0);
    public Block               terrainUniTreeLog          = (new BlockUnidentifiedLog()).setHardness(0.0F).setLightOpacity(0);
    public Block               terrainUniTreeTendon       = (new BlockUnidentifiedTreeTendon()).setHardness(0.0F).setLightOpacity(0);
    public Block               terrainUniTreeLeaves       = (new BlockUnidentifiedTreeLeaves()).setHardness(0.0F).setLightOpacity(0);
    public Block               terrainUniTreeSapling      = (new BlockUnidentifiedTreeSapling()).setHardness(0.0F).setLightOpacity(0);
    public Block               blockTurret                = (new BlockTurret(Material.iron)).setHardness(3.2F).setResistance(2.6F);
    public Block               blockWorkstation           = (new BlockWorkstation(Material.iron)).setHardness(3.2F).setResistance(2.6F);
    public Block               blockStasisMechanism       = (new BlockStasisMechanism(Material.iron)).setHardness(5.0F).setResistance(10.0F);
    public Block               blockRepulsionGenerator    = (new BlockGenerator(Material.iron)).setHardness(5.0F).setResistance(10.0F);
    public Block               blockPowerline             = (new BlockPowerline(Material.iron)).setHardness(3.2F).setResistance(2.6F);
    public Block               blockBlastdoor             = (new BlockBlastdoor(Material.iron)).setHardness(10F).setResistance(30.0F).setLightOpacity(0);
    public Block               blockCryostasisTube        = (new BlockCryostasisTube(Material.iron)).setHardness(10F).setResistance(30.0F).setLightOpacity(4);
    public Block               blockLightPanel            = (new BlockLightPanel(Material.iron, true)).setHardness(1.5F).setResistance(2.0F);
    public Block               blockSatelliteModem        = (new BlockSatelliteModem(Material.iron)).setHardness(3.2F).setResistance(2.6F);
    public Block               blockPowercell             = (new BlockPowercell(Material.iron)).setHardness(3.2F).setResistance(2.6F);
    public Block               blockR2PConvertor          = (new BlockR2PConverter(Material.iron)).setHardness(3.2F).setResistance(2.6F);
    public Block               blockP2RConvertor          = (new BlockP2RConverter(Material.iron)).setHardness(3.2F).setResistance(2.6F);
    public Block               blockBlackGoo              = (new BlockBlackGoo());
    public Block               blockMist                  = (new BlockMist());
    public Block               blockTransformer           = (new BlockTransformer(Material.iron)).setHardness(5.0F).setResistance(10.0F);
    public Block               blockNegativeTransformer   = (new BlockNegativeTransformer(Material.iron)).setHardness(5.0F).setResistance(10.0F);
    public Block               blockSupplyCrate           = (new BlockSupplyCrate());
    public Block               blockSolarPanel            = (new BlockSolarPanel(Material.iron)).setHardness(5.0F).setResistance(10.0F);
    public Block               blockLocker                = (new BlockLocker(Material.iron).setHardness(1.5F).setResistance(10.0F));
    public Block               blockMedpod                = (new BlockMedpod(Material.iron).setHardness(1.5F).setResistance(10.0F));
    public Block               blockGunLocker             = (new BlockGunLocker(Material.iron).setHardness(1.5F).setResistance(10.0F));
    public Block               blockAmpule                = (new BlockAmpule().setHardness(5.0F).setResistance(10.0F));
    public Block               blockWallW                 = (new BlockWall(Material.iron).setHardness(5F).setResistance(30.0F).setLightOpacity(255));
    public Block               blockRelicTile             = (new BlockMaterial(Material.rock)
                                                          {
                                                              @Override
                                                              public void registerIcons(IIconRegister register)
                                                              {
                                                                  this.blockIcon = register.registerIcon("avp:spawner");
                                                              };
                                                          }.setHardness(5F).setResistance(30.0F).setLightOpacity(255));
    public Block               blockIndustrialGlass       = (new BlockMaterial(Material.iron)
                                                          {
                                                              @Override
                                                              public boolean renderAsNormalBlock()
                                                              {
                                                                  return false;
                                                              }

                                                              @Override
                                                              public boolean isOpaqueCube()
                                                              {
                                                                  return false;
                                                              }
                                                          }).setHardness(5F).setResistance(30.0F).setLightOpacity(0);
    public Block               blockFloorGrillSlab        = (new BlockCustomSlab(Material.iron)
                                                          {
                                                              @Override
                                                              public void registerIcons(IIconRegister register)
                                                              {
                                                                  this.blockIcon = register.registerIcon("avp:floorgrill");
                                                              };
                                                          }).setHardness(5F).setResistance(30.0F).setLightOpacity(4);
    public Block               blockCeilingGrillSlab      = (new BlockCustomSlab(Material.iron)
                                                          {
                                                              @Override
                                                              public void registerIcons(IIconRegister register)
                                                              {
                                                                  this.blockIcon = register.registerIcon("avp:ceilinggrill");
                                                              };
                                                          }).setHardness(5F).setResistance(30.0F).setLightOpacity(4);
    public Block               blockWallSlab              = (new BlockCustomSlab(Material.iron)
                                                          {
                                                              @Override
                                                              public void registerIcons(IIconRegister register)
                                                              {
                                                                  this.blockIcon = register.registerIcon("avp:wall_top");
                                                              };
                                                          }).setHardness(5F).setResistance(30.0F).setLightOpacity(255);
    public Block               blockIronBricksSlab        = (new BlockCustomSlab(Material.iron)
                                                          {
                                                              @Override
                                                              public void registerIcons(IIconRegister register)
                                                              {
                                                                  this.blockIcon = register.registerIcon("avp:industrialbricks");
                                                              };
                                                          }).setHardness(5F).setResistance(30.0F).setLightOpacity(255);
    public Block               blockIndustrialGlassSlab   = (new BlockCustomSlab(Material.iron)
                                                          {
                                                              @Override
                                                              public void registerIcons(IIconRegister register)
                                                              {
                                                                  this.blockIcon = register.registerIcon("avp:industrialglass");
                                                              };
                                                          }).setHardness(5F).setResistance(30.0F).setLightOpacity(0);
    public Block               blockIndustrialGlassStairs = (new BlockCustomStairs(blockIndustrialGlass)).setHardness(5F).setResistance(30.0F).setLightOpacity(0);

    public BlockHandler()
    {
        super(AliensVsPredator.instance());
    }

    @Override
    public void initialize(FMLInitializationEvent event)
    {
        ShapedBlockUtil.registerBlock(this, terrainUniDirt, "unidirt");
        ShapedBlockUtil.registerBlock(this, terrainUniStone, "unistone");
        ShapedBlockUtil.registerBlock(this, terrainUniSand, "unisand");
        ShapedBlockUtil.registerBlock(this, terrainUniGravel, "unigravel");
        registerBlock(terrainUniTreeLog, "unitree.wood");
        registerBlock(terrainUniTreeTendon, "unitree.tendons");
        registerBlock(terrainUniTreeLeaves, "unitree.leaves");
        registerBlock(terrainUniTreeSapling, "unitree.sapling");
        registerBlock(terrainStalagmite, "stalagmite");
        registerBlock(oreSilicon, "oresilicon");
        registerBlock(oreCopper, "orecopper");
        registerBlock(oreLithium, "orelithium");
        registerBlock(oreBauxite, "orebauxite");
        registerBlock(blockSolarPanel, "solarpanel");
        registerBlock(blockSatelliteModem, "satellitemodem");
        registerBlock(blockSatelliteDish, "satellitedish");
        registerBlock(blockPowercell, "powercell");
        ShapedBlockUtil.registerBlock(this, blockCeiling, "ceilingpanel");
        ShapedBlockUtil.registerBlock(this, blockCeilingFan, "ceilingfan");
        ShapedBlockUtil.registerBlock(this, blockCeiliingVent, "ceilingvent");
        registerBlock(blockTransformer, "transformer");
        registerBlock(blockNegativeTransformer, "transformernegative");
        ShapedBlockUtil.registerBlock(this, blockCeilingGrill, "ceilinggrill");
        registerBlock(blockCeilingGrillStairs, "ceilinggrillstairs", AliensVsPredator.instance().tabBlocks());
        registerBlock(blockCeilingGrillSlab, "ceilinggrillslab", AliensVsPredator.instance().tabBlocks());
        ShapedBlockUtil.registerBlock(this, blockFloorGrill, "floorgrill");
        registerBlock(blockFloorGrillStairs, "floorgrillstairs", AliensVsPredator.instance().tabBlocks());
        registerBlock(blockFloorGrillSlab, "floorgrillslab", AliensVsPredator.instance().tabBlocks());
        ShapedBlockUtil.registerBlock(this, blockWall, "industrialwall");
        ShapedBlockUtil.registerBlock(this, blockWallW, "industrialwall2");
        registerBlock(blockR2PConvertor, "r2pconverter");
        registerBlock(blockP2RConvertor, "p2rconverter");
        registerBlock(blockWallStairs, "industrialwallstairs", AliensVsPredator.instance().tabBlocks());
        registerBlock(blockWallSlab, "industrialslab", AliensVsPredator.instance().tabBlocks());
        ShapedBlockUtil.registerBlock(this, blockVent0, "industrialvent");
        ShapedBlockUtil.registerBlock(this, blockVent1, "vent.wall");
        ShapedBlockUtil.registerBlock(this, blockVent2, "vent.ceiling");
        ShapedBlockUtil.registerBlock(this, blockIronBricks, "industrialbricks");
        registerBlock(blockIronBricksStairs, "industrialbrickstairs", AliensVsPredator.instance().tabBlocks());
        registerBlock(blockIronBricksSlab, "industrialbrickslab", AliensVsPredator.instance().tabBlocks());
        ShapedBlockUtil.registerBlock(this, blockIndustrialGlass, "industrialglass");
        registerBlock(blockIndustrialGlassStairs, "industrialglassstairs", AliensVsPredator.instance().tabBlocks());
        registerBlock(blockIndustrialGlassSlab, "industrialglassslab", AliensVsPredator.instance().tabBlocks());
        ShapedBlockUtil.registerBlock(this, blockVerticalMetal, "metalpanel1");
        ShapedBlockUtil.registerBlock(this, blockColumnMetal1, "metalpanel2");
        ShapedBlockUtil.registerBlock(this, blockColumnMetal2, "metalpanel3");
        ShapedBlockUtil.registerBlock(this, terrainHiveResin, "hiveresin");
        ShapedBlockUtil.registerBlock(this, blockShipMetal1, "shippanel");
        ShapedBlockUtil.registerBlock(this, blockShipMetal2, "shippannelyautja");
        ShapedBlockUtil.registerBlock(this, blockOvamorph, "tileovamorphdesign");
        ShapedBlockUtil.registerBlock(this, blockFacehuggerRelic, "tilefacehuggerdesign");
        ShapedBlockUtil.registerBlock(this, blockAlienRelic, "tilealiendesign");
        ShapedBlockUtil.registerBlock(this, blockShipDecor1, "shipwallbase");
        ShapedBlockUtil.registerBlock(this, blockShipDecor2, "shipsupportpillar");
        ShapedBlockUtil.registerBlock(this, blockShipDecor3, "shipdecor1");
        ShapedBlockUtil.registerBlock(this, blockShipDecor5, "shipdecor2");
        ShapedBlockUtil.registerBlock(this, blockShipDecor6, "shipdecor3");
        ShapedBlockUtil.registerBlock(this, blockShipDecor4, "shipbrick");
        registerBlock(blockSacrificialSpawner, "spawner");
        registerBlock(blockSpawnerCreative, "spawnerc");
        ShapedBlockUtil.registerBlock(this, blockRelicTile, "templebricksingle", 0, blockSacrificialSpawner);
        ShapedBlockUtil.registerBlock(this, blockTempleBrick, "templebrick");
        ShapedBlockUtil.registerBlock(this, blockTempleTile, "templetile");
        ShapedBlockUtil.registerBlock(this, blockTempleWall1, "templewallbase");
        ShapedBlockUtil.registerBlock(this, blockTempleWall2, "templefloor");
        ShapedBlockUtil.registerBlock(this, blockSkulls, "skulls");
        registerBlock(blockPortalVarda, "portal.varda");
        registerBlock(blockPortalAcheron, "portal.acheron");
        registerBlock(blockAssembler, "assembler");
        registerBlock(blockTurret, "turret");
        registerBlock(blockWorkstation, "terminal");
        registerBlock(blockStasisMechanism, "stasismechanism");
        registerBlock(blockRepulsionGenerator, "generator");
        registerBlock(blockPowerline, "powerline");
        registerBlock(blockBlastdoor, "blastdoor");
        registerBlock(blockSupplyCrate, "supplychuteblock", null);
        registerBlock(blockBlackGoo, "blackgoo");
        registerBlock(blockMist, "mist");
        registerBlock(blockCryostasisTube, "cryostasistube");
        ShapedBlockUtil.registerBlock(this, blockPlastic, "plasticblock");
        ShapedBlockUtil.registerBlock(this, blockPlasticTile, "plastictile");
        ShapedBlockUtil.registerBlock(this, blockPlasticTri, "plastictiletri");
        ShapedBlockUtil.registerBlock(this, blockPlasticCircle, "plastictilecircle");
        registerBlock(blockLightPanel, "lightpanel");
        registerBlock(mainframePanelShimmer, "mainframepanel.shimmer");
        registerBlock(mainframePanelFlicker, "mainframepanel.flicker");
        ShapedBlockUtil.registerBlock(this, blockEngineerShipFloor, "engineershipfloor");
        ShapedBlockUtil.registerBlock(this, blockEngineerShipBrick0, "engineershipbrick");
        ShapedBlockUtil.registerBlock(this, blockEngineerShipBrick1, "engineershipbrick1");
        ShapedBlockUtil.registerBlock(this, blockEngineerShipBrick2, "engineershipbrick2");
        ShapedBlockUtil.registerBlock(this, blockEngineerShipBrick3, "engineershipbrick3");
        ShapedBlockUtil.registerBlock(this, blockEngineerShipGravel, "engineershipgravel");
        ShapedBlockUtil.registerBlock(this, blockEngineerShipWall0, "engineershipwall");
        ShapedBlockUtil.registerBlock(this, blockEngineerShipWall1, "engineershipwall1");
        ShapedBlockUtil.registerBlock(this, blockEngineerShipWall2, "engineershipwall2");
        ShapedBlockUtil.registerBlock(this, blockEngineerShipWall3, "engineershipwall3");
        ShapedBlockUtil.registerBlock(this, blockEngineerShipWall4, "engineershipwall4");
        ShapedBlockUtil.registerBlock(this, blockEngineerShipRock0, "engineershiprock");
        ShapedBlockUtil.registerBlock(this, blockEngineerShipRock1, "engineershiprock1");
        ShapedBlockUtil.registerBlock(this, blockEngineerShipRock2, "engineershiprock2");
        ShapedBlockUtil.registerBlock(this, blockEngineerShipRock3, "engineershiprock3");
        ShapedBlockUtil.registerBlock(this, blockEngineerShipColumn1, "engineershipcolumn1");
        ShapedBlockUtil.registerBlock(this, blockEngineerShipColumn2, "engineershipcolumn2");
        ShapedBlockUtil.registerBlock(this, blockEngineerShipMaterial0, "engineershipmaterial0");
        ShapedBlockUtil.registerBlock(this, blockEngineerShipMaterial1, "engineershipmaterial1");
        ShapedBlockUtil.registerBlock(this, blockEngineerShipMaterial2, "engineershipmaterial2");
        registerBlock(blockAmpule, "engineership.ampule");
        registerBlock(blockLocker, "locker");
        registerBlock(blockGunLocker, "gunlocker");
        registerBlock(blockMedpod, "medpod");
    }
}
