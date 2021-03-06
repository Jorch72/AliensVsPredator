package org.avp;

import org.avp.item.crafting.AssemblyManager;
import org.avp.item.crafting.Schematic;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.init.PotionTypes;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.potion.PotionUtils;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.oredict.OreDictionary;

@EventBusSubscriber
public class CraftingHandler
{
    public static final CraftingHandler instance = new CraftingHandler();
    private static final ItemStack      CHARCOAL = new ItemStack(Items.COAL, 1, 1);

    @SubscribeEvent
    public static void registerOres(RegistryEvent.Register<Item> event)
    {
        OreDictionary.registerOre("copper", ItemHandler.itemIngotCopper);
        OreDictionary.registerOre("ingotCopper", ItemHandler.itemIngotCopper);
        OreDictionary.registerOre("lithium", ItemHandler.itemIngotLithium);
        OreDictionary.registerOre("itemLithium", ItemHandler.itemIngotLithium);
        OreDictionary.registerOre("aluminum", ItemHandler.itemIngotAluminum);
        OreDictionary.registerOre("ingotAluminum", ItemHandler.itemIngotAluminum);
        OreDictionary.registerOre("aluminium", ItemHandler.itemIngotAluminum);
        OreDictionary.registerOre("ingotAluminium", ItemHandler.itemIngotAluminum);
        OreDictionary.registerOre("oreCopper", BlockHandler.oreCopper);
        OreDictionary.registerOre("oreLithium", BlockHandler.oreLithium);
        OreDictionary.registerOre("oreAluminum", BlockHandler.oreBauxite);
        OreDictionary.registerOre("oreAluminium", BlockHandler.oreBauxite);
        OreDictionary.registerOre("oreSilicon", BlockHandler.oreSilicon);
        OreDictionary.registerOre("silicon", ItemHandler.itemSilicon);
        OreDictionary.registerOre("itemSilicon", ItemHandler.itemSilicon);
        OreDictionary.registerOre("polycarbonate", ItemHandler.itemPolycarbonate);
        OreDictionary.registerOre("itemPolycarbonate", ItemHandler.itemPolycarbonate);
        OreDictionary.registerOre("plastic", ItemHandler.itemPolycarbonate);
        OreDictionary.registerOre("itemPlastic", ItemHandler.itemPolycarbonate);
        OreDictionary.registerOre("logWood", BlockHandler.gigerLog);
        OreDictionary.registerOre("log", BlockHandler.gigerLog);
        OreDictionary.registerOre("neodymium", ItemHandler.neodymium);
        OreDictionary.registerOre("oreMonazite", BlockHandler.oreMonazite);
        OreDictionary.registerOre("cobalt", ItemHandler.cobalt);
        OreDictionary.registerOre("oreCobalt", BlockHandler.oreCobalt);
    }

    @SubscribeEvent
    public static void registerRecipes(RegistryEvent.Register<IRecipe> event)
    {
        addSmelting();
        addSchematics();
    }

    private static void addSmelting()
    {
        GameRegistry.addSmelting(BlockHandler.oreCopper, new ItemStack(ItemHandler.itemIngotCopper), 1.0F);
        GameRegistry.addSmelting(BlockHandler.oreLithium, new ItemStack(ItemHandler.itemIngotLithium), 1.0F);
        GameRegistry.addSmelting(BlockHandler.oreBauxite, new ItemStack(ItemHandler.itemIngotAluminum), 1.0F);
        GameRegistry.addSmelting(BlockHandler.oreSilicon, new ItemStack(ItemHandler.itemSilicon), 1.0F);
        GameRegistry.addSmelting(BlockHandler.gigerLog, CHARCOAL, 1.0F);
    }

    private static void addSchematics()
    {
        AssemblyManager.register(new Schematic("medpod", new ItemStack(BlockHandler.medpod, 1)) {
            @Override
            public ItemStack[] getItemsRequired()
            {
                return new ItemStack[] {
                        new ItemStack(BlockHandler.terminal, 1),
                        new ItemStack(BlockHandler.lightPanel, 2),
                        new ItemStack(BlockHandler.industrialglass, 4),
                        new ItemStack(Blocks.IRON_BLOCK, 1),
                        new ItemStack(BlockHandler.paddingSquareWhite, 3),
                        new ItemStack(BlockHandler.transformer, 1),
                        new ItemStack(ItemHandler.itemChargePack, 1),
                        new ItemStack(ItemHandler.itemIngotAluminum, 8),
                        PotionUtils.addPotionToItemStack(new ItemStack(Items.POTIONITEM), PotionTypes.HEALING)
                };
            }
        });
        AssemblyManager.register(new Schematic("turret", new ItemStack(BlockHandler.turret, 1)) {
            @Override
            public ItemStack[] getItemsRequired()
            {
                return new ItemStack[] {
                        new ItemStack(ItemHandler.itemM41A, 1),
                        new ItemStack(ItemHandler.itemPolycarbonate, 4),
                        new ItemStack(ItemHandler.itemIngotAluminum, 4),
                        new ItemStack(ItemHandler.itemIngotCopper, 4),
                        new ItemStack(ItemHandler.itemLedDisplay, 1)
                };
            }
        });
        AssemblyManager.register(new Schematic("redstonefluxGenerator", new ItemStack(BlockHandler.universalGenerator, 1)) {
            @Override
            public ItemStack[] getItemsRequired()
            {
                return new ItemStack[] {
                        new ItemStack(BlockHandler.transformer, 4),
                        new ItemStack(BlockHandler.stepdownTransformer, 4),
                        new ItemStack(ItemHandler.itemPolycarbonate, 4),
                        new ItemStack(ItemHandler.itemIngotAluminum, 4),
                        new ItemStack(Items.DIAMOND, 4) };
            }
        });
        AssemblyManager.register(new Schematic("cryostasisTube", new ItemStack(BlockHandler.cryoTube, 1)) {
            @Override
            public ItemStack[] getItemsRequired()
            {
                return new ItemStack[] {
                        new ItemStack(ItemHandler.itemPolycarbonate, 4),
                        new ItemStack(ItemHandler.itemIngotAluminum, 4),
                        new ItemStack(BlockHandler.industrialglass, 4),
                        new ItemStack(BlockHandler.lightPanel, 1) };
            }
        });
        AssemblyManager.register(new Schematic("lightPanel", new ItemStack(BlockHandler.lightPanel, 1)) {
            @Override
            public ItemStack[] getItemsRequired()
            {
                return new ItemStack[] {
                        new ItemStack(ItemHandler.itemPolycarbonate, 2),
                        new ItemStack(ItemHandler.itemIngotAluminum, 2),
                        new ItemStack(BlockHandler.industrialglass, 2),
                        new ItemStack(Items.GLOWSTONE_DUST, 2) };
            }
        });
        AssemblyManager.register(new Schematic("pulserifle", new ItemStack(ItemHandler.itemM41A, 1)) {
            @Override
            public ItemStack[] getItemsRequired()
            {
                return new ItemStack[] {
                        new ItemStack(ItemHandler.itemPolycarbonate, 8),
                        new ItemStack(Items.IRON_INGOT, 8),
                        new ItemStack(ItemHandler.itemIngotAluminum, 6),
                        new ItemStack(ItemHandler.itemIngotCopper, 6),
                        new ItemStack(Items.GOLD_INGOT, 4),
                        new ItemStack(ItemHandler.itemIntegratedCircuit, 2),
                        new ItemStack(ItemHandler.itemLedDisplay, 1) };
            }
        });
        AssemblyManager.register(new Schematic("grenade", new ItemStack(ItemHandler.itemGrenade, 2)) {
            @Override
            public ItemStack[] getItemsRequired()
            {
                return new ItemStack[] {
                        new ItemStack(Items.IRON_INGOT, 2),
                        new ItemStack(ItemHandler.itemIngotAluminum, 1),
                        new ItemStack(Items.GUNPOWDER, 1),
                        new ItemStack(ItemHandler.itemIngotCopper, 1) };
            }
        });
        AssemblyManager.register(new Schematic("fire_grenade", new ItemStack(ItemHandler.itemIncendiaryGrenade, 2)) {
            @Override
            public ItemStack[] getItemsRequired()
            {
                return new ItemStack[] {
                        new ItemStack(Items.IRON_INGOT, 2),
                        new ItemStack(ItemHandler.itemIngotAluminum, 1),
                        new ItemStack(Items.BLAZE_POWDER, 1),
                        new ItemStack(ItemHandler.itemIngotCopper, 1) };
            }
        });
        AssemblyManager.register(new Schematic("marineHelm", new ItemStack(ItemHandler.helmMarine, 1)) {
            @Override
            public ItemStack[] getItemsRequired()
            {
                return new ItemStack[] {
                        new ItemStack(Blocks.WOOL, 3),
                        new ItemStack(ItemHandler.itemIngotAluminum, 2),
                        new ItemStack(ItemHandler.itemLedDisplay, 2),
                        new ItemStack(ItemHandler.itemPolycarbonate, 2),
                        new ItemStack(ItemHandler.itemProcessor, 1) };
            }
        });
        AssemblyManager.register(new Schematic("marinePlate", new ItemStack(ItemHandler.plateMarine, 1)) {
            @Override
            public ItemStack[] getItemsRequired()
            {
                return new ItemStack[] {
                        new ItemStack(Blocks.WOOL, 3),
                        new ItemStack(ItemHandler.itemIngotAluminum, 2) };
            }
        });
        AssemblyManager.register(new Schematic("marineLeggings", new ItemStack(ItemHandler.legsMarine, 1)) {
            @Override
            public ItemStack[] getItemsRequired()
            {
                return new ItemStack[] {
                        new ItemStack(Blocks.WOOL, 3),
                        new ItemStack(ItemHandler.itemIngotAluminum, 2) };
            }
        });
        AssemblyManager.register(new Schematic("marineBoots", new ItemStack(ItemHandler.bootsMarine, 1)) {
            @Override
            public ItemStack[] getItemsRequired()
            {
                return new ItemStack[] {
                        new ItemStack(Blocks.WOOL, 1),
                        new ItemStack(ItemHandler.itemIngotAluminum, 1) };
            }
        });
        AssemblyManager.register(new Schematic("sniperMagazine", new ItemStack(ItemHandler.itemAmmoSniper, 1)) {
            @Override
            public ItemStack[] getItemsRequired()
            {
                return new ItemStack[] {
                        new ItemStack(ItemHandler.itemIngotAluminum, 5),
                        new ItemStack(Items.GUNPOWDER, 1) };
            }
        });
        AssemblyManager.register(new Schematic("pistolMagazine", new ItemStack(ItemHandler.itemAmmoPistol, 3)) {
            @Override
            public ItemStack[] getItemsRequired()
            {
                return new ItemStack[] {
                        new ItemStack(ItemHandler.itemIngotAluminum, 4),
                        new ItemStack(Items.GUNPOWDER, 2),
                        new ItemStack(ItemHandler.itemIngotCopper, 1) };
            }
        });
        AssemblyManager.register(new Schematic("ARAmmo", new ItemStack(ItemHandler.itemAmmoAR, 1)) {
            @Override
            public ItemStack[] getItemsRequired()
            {
                return new ItemStack[] {
                        new ItemStack(ItemHandler.itemIngotAluminum, 5),
                        new ItemStack(Items.IRON_INGOT, 1),
                        new ItemStack(Items.GUNPOWDER, 1) };
            }
        });
        AssemblyManager.register(new Schematic("SMGAmmo", new ItemStack(ItemHandler.itemAmmoSMG, 1)) {
            @Override
            public ItemStack[] getItemsRequired()
            {
                return new ItemStack[] {
                        new ItemStack(ItemHandler.itemIngotAluminum, 4),
                        new ItemStack(Items.IRON_INGOT, 4),
                        new ItemStack(Items.GUNPOWDER, 1) };
            }
        });
        AssemblyManager.register(new Schematic("m56sg", new ItemStack(ItemHandler.itemM56SG, 1)) {
            @Override
            public ItemStack[] getItemsRequired()
            {
                return new ItemStack[] {
                        new ItemStack(ItemHandler.itemM56SGAimingModule, 1),
                        new ItemStack(ItemHandler.itemM56SGStock, 1),
                        new ItemStack(ItemHandler.itemM56SGBarrel, 1),
                        new ItemStack(ItemHandler.itemM56SGSupportFrame, 1) };
            }
        });
        AssemblyManager.register(new Schematic("sniper", new ItemStack(ItemHandler.itemSniper, 1)) {
            @Override
            public ItemStack[] getItemsRequired()
            {
                return new ItemStack[] {
                        new ItemStack(ItemHandler.itemSniperScope, 1),
                        new ItemStack(ItemHandler.itemSniperAction, 1),
                        new ItemStack(ItemHandler.itemSniperPeripherals, 1),
                        new ItemStack(ItemHandler.itemSniperBarrel, 1),
                        new ItemStack(ItemHandler.itemSniperStock, 1) };
            }
        });
        AssemblyManager.register(new Schematic("pistol", new ItemStack(ItemHandler.itemPistol, 1)) {
            @Override
            public ItemStack[] getItemsRequired()
            {
                return new ItemStack[] {
                        new ItemStack(ItemHandler.itemPistolStock, 1),
                        new ItemStack(ItemHandler.itemPistolBarrel, 1),
                        new ItemStack(ItemHandler.itemPistolAction, 1) };
            }
        });
        AssemblyManager.register(new Schematic("m4", new ItemStack(ItemHandler.itemM4, 1)) {
            @Override
            public ItemStack[] getItemsRequired()
            {
                return new ItemStack[] {
                        new ItemStack(ItemHandler.itemM4Stock, 1),
                        new ItemStack(ItemHandler.itemM4Barrel, 1),
                        new ItemStack(ItemHandler.itemM4Action, 1) };
            }
        });
        AssemblyManager.register(new Schematic("ak47", new ItemStack(ItemHandler.itemAK47, 1)) {
            @Override
            public ItemStack[] getItemsRequired()
            {
                return new ItemStack[] {
                        new ItemStack(ItemHandler.itemAK47Action, 1),
                        new ItemStack(ItemHandler.itemAK47Barrel, 1),
                        new ItemStack(ItemHandler.itemAK47Stock, 1) };
            }
        });
        AssemblyManager.register(new Schematic("doritos", new ItemStack(ItemHandler.itemDoritos, 4)) {
            @Override
            public ItemStack[] getItemsRequired()
            {
                return new ItemStack[] {
                        new ItemStack(Items.WHEAT, 4),
                        new ItemStack(Items.BAKED_POTATO, 4) };
            }
        });
        AssemblyManager.register(new Schematic("doritosCoolRanch", new ItemStack(ItemHandler.itemDoritosCoolRanch, 4)) {
            @Override
            public ItemStack[] getItemsRequired()
            {
                return new ItemStack[] {
                        new ItemStack(ItemHandler.itemDoritos, 4),
                        new ItemStack(Items.WHEAT, 3) };
            }
        });
        AssemblyManager.register(new Schematic("motionTracker", new ItemStack(ItemHandler.itemMotionTracker, 1)) {
            @Override
            public ItemStack[] getItemsRequired()
            {
                return new ItemStack[] {
                        new ItemStack(ItemHandler.itemPolycarbonate, 6),
                        new ItemStack(ItemHandler.itemIngotAluminum, 8),
                        new ItemStack(ItemHandler.itemIngotCopper, 6),
                        new ItemStack(ItemHandler.itemLedDisplay, 2),
                        new ItemStack(ItemHandler.itemProcessor, 2),
                        new ItemStack(Items.DIAMOND, 1),
                        new ItemStack(Items.IRON_INGOT, 8) };
            }
        });
        AssemblyManager.register(new Schematic("flamethrower", new ItemStack(ItemHandler.itemM240ICU, 1)) {
            @Override
            public ItemStack[] getItemsRequired()
            {
                return new ItemStack[] {
                        new ItemStack(ItemHandler.itemPolycarbonate, 4),
                        new ItemStack(ItemHandler.itemIngotAluminum, 4),
                        new ItemStack(ItemHandler.itemIngotCopper, 3),
                        new ItemStack(Items.BLAZE_ROD, 1),
                        new ItemStack(Items.IRON_INGOT, 6) };
            }
        });
        AssemblyManager.register(new Schematic("nbtDrive", new ItemStack(ItemHandler.itemFlashDrive, 1)) {
            @Override
            public ItemStack[] getItemsRequired()
            {
                return new ItemStack[] {
                        new ItemStack(ItemHandler.itemPolycarbonate, 1),
                        new ItemStack(ItemHandler.itemRAM, 4),
                        new ItemStack(ItemHandler.itemIngotLithium, 1) };
            }
        });
        AssemblyManager.register(new Schematic("celticBiomask", new ItemStack(ItemHandler.helmTitanium, 1)) {
            @Override
            public ItemStack[] getItemsRequired()
            {
                return new ItemStack[] {
                        new ItemStack(ItemHandler.itemArtifactTech, 2),
                        new ItemStack(Items.DIAMOND_HELMET, 1),
                        new ItemStack(ItemHandler.itemIngotAluminum, 2),
                        new ItemStack(ItemHandler.itemLedDisplay, 2),
                        new ItemStack(ItemHandler.itemPolycarbonate, 2),
                        new ItemStack(ItemHandler.itemProcessor, 1) };
            }
        });
        AssemblyManager.register(new Schematic("celticPlate", new ItemStack(ItemHandler.plateTitanium, 1)) {
            @Override
            public ItemStack[] getItemsRequired()
            {
                return new ItemStack[] {
                        new ItemStack(ItemHandler.itemArtifactTech, 1),
                        new ItemStack(Items.DIAMOND_CHESTPLATE, 1),
                        new ItemStack(ItemHandler.itemIngotAluminum, 3),
                        new ItemStack(ItemHandler.itemPolycarbonate, 3) };
            }
        });
        AssemblyManager.register(new Schematic("celticLegs", new ItemStack(ItemHandler.legsTitanium, 1)) {
            @Override
            public ItemStack[] getItemsRequired()
            {
                return new ItemStack[] {
                        new ItemStack(ItemHandler.itemArtifactTech, 1),
                        new ItemStack(Items.DIAMOND_LEGGINGS, 1),
                        new ItemStack(ItemHandler.itemIngotAluminum, 2),
                        new ItemStack(ItemHandler.itemPolycarbonate, 2) };
            }
        });
        AssemblyManager.register(new Schematic("celticBoots", new ItemStack(ItemHandler.bootsTitanium, 1)) {
            @Override
            public ItemStack[] getItemsRequired()
            {
                return new ItemStack[] {
                        new ItemStack(ItemHandler.itemArtifactTech, 1),
                        new ItemStack(Items.DIAMOND_BOOTS, 1),
                        new ItemStack(ItemHandler.itemIngotAluminum, 1),
                        new ItemStack(ItemHandler.itemPolycarbonate, 1) };
            }
        });
        AssemblyManager.register(new Schematic("celticAxe", new ItemStack(ItemHandler.axeTitanium, 1)) {
            @Override
            public ItemStack[] getItemsRequired()
            {
                return new ItemStack[] {
                        new ItemStack(ItemHandler.itemArtifactTech, 1),
                        new ItemStack(Items.DIAMOND_AXE, 1),
                        new ItemStack(ItemHandler.itemIngotAluminum, 1),
                        new ItemStack(ItemHandler.itemPolycarbonate, 1) };
            }
        });
        AssemblyManager.register(new Schematic("celticPickaxe", new ItemStack(ItemHandler.pickaxeTitanium, 1)) {
            @Override
            public ItemStack[] getItemsRequired()
            {
                return new ItemStack[] {
                        new ItemStack(ItemHandler.itemArtifactTech, 1),
                        new ItemStack(Items.DIAMOND_PICKAXE, 1),
                        new ItemStack(ItemHandler.itemIngotAluminum, 1),
                        new ItemStack(ItemHandler.itemPolycarbonate, 1) };
            }
        });
        AssemblyManager.register(new Schematic("celticHoe", new ItemStack(ItemHandler.hoeTitanium, 1)) {
            @Override
            public ItemStack[] getItemsRequired()
            {
                return new ItemStack[] {
                        new ItemStack(ItemHandler.itemArtifactTech, 1),
                        new ItemStack(Items.DIAMOND_HOE, 1),
                        new ItemStack(ItemHandler.itemIngotAluminum, 1),
                        new ItemStack(ItemHandler.itemPolycarbonate, 1) };
            }
        });
        AssemblyManager.register(new Schematic("celticShovel", new ItemStack(ItemHandler.shovelTitanium, 1)) {
            @Override
            public ItemStack[] getItemsRequired()
            {
                return new ItemStack[] {
                        new ItemStack(ItemHandler.itemArtifactTech, 1),
                        new ItemStack(Items.DIAMOND_SHOVEL, 1),
                        new ItemStack(ItemHandler.itemIngotAluminum, 1),
                        new ItemStack(ItemHandler.itemPolycarbonate, 1) };
            }
        });
        AssemblyManager.register(new Schematic("celticSword", new ItemStack(ItemHandler.swordTitanium, 1)) {
            @Override
            public ItemStack[] getItemsRequired()
            {
                return new ItemStack[] {
                        new ItemStack(ItemHandler.itemArtifactTech, 1),
                        new ItemStack(Items.DIAMOND_SWORD, 1),
                        new ItemStack(ItemHandler.itemIngotAluminum, 1),
                        new ItemStack(ItemHandler.itemPolycarbonate, 1) };
            }
        });
        AssemblyManager.register(new Schematic("wristBlade", new ItemStack(ItemHandler.itemWristbracer, 1)) {
            @Override
            public ItemStack[] getItemsRequired()
            {
                return new ItemStack[] {
                        new ItemStack(ItemHandler.itemArtifactTech, 2),
                        new ItemStack(Items.DIAMOND, 4),
                        new ItemStack(ItemHandler.itemLedDisplay, 2),
                        new ItemStack(ItemHandler.itemIngotAluminum, 2),
                        new ItemStack(ItemHandler.itemPolycarbonate, 2) };
            }
        });
        AssemblyManager.register(new Schematic("wristbracerBlades", new ItemStack(ItemHandler.itemWristbracerBlades, 1)) {
            @Override
            public ItemStack[] getItemsRequired()
            {
                return new ItemStack[] {
                        new ItemStack(ItemHandler.itemArtifactTech, 2),
                        new ItemStack(Items.SHEARS, 1),
                        new ItemStack(Items.DIAMOND, 2),
                        new ItemStack(ItemHandler.itemIngotAluminum, 2),
                        new ItemStack(ItemHandler.itemPolycarbonate, 2) };
            }
        });
        AssemblyManager.register(new Schematic("proximityMine", new ItemStack(ItemHandler.itemProximityMine, 3)) {
            @Override
            public ItemStack[] getItemsRequired()
            {
                return new ItemStack[] {
                        new ItemStack(ItemHandler.itemArtifactTech, 1),
                        new ItemStack(Blocks.TNT, 2),
                        new ItemStack(ItemHandler.itemIngotAluminum, 1),
                        new ItemStack(ItemHandler.itemPolycarbonate, 1) };
            }
        });
        AssemblyManager.register(new Schematic("celticDisc", new ItemStack(ItemHandler.itemDisc, 1)) {
            @Override
            public ItemStack[] getItemsRequired()
            {
                return new ItemStack[] {
                        new ItemStack(ItemHandler.itemArtifactTech, 1),
                        new ItemStack(ItemHandler.itemIngotAluminum, 1),
                        new ItemStack(Items.DIAMOND, 1),
                        new ItemStack(ItemHandler.itemPolycarbonate, 2) };
            }
        });
        AssemblyManager.register(new Schematic("celticShuriken", new ItemStack(ItemHandler.itemShuriken, 2)) {
            @Override
            public ItemStack[] getItemsRequired()
            {
                return new ItemStack[] {
                        new ItemStack(ItemHandler.itemArtifactTech, 1),
                        new ItemStack(ItemHandler.itemIngotAluminum, 2),
                        new ItemStack(ItemHandler.itemPolycarbonate, 2) };
            }
        });
        AssemblyManager.register(new Schematic("celticSpear", new ItemStack(ItemHandler.itemSpear, 1)) {
            @Override
            public ItemStack[] getItemsRequired()
            {
                return new ItemStack[] {
                        new ItemStack(ItemHandler.itemArtifactTech, 1),
                        new ItemStack(ItemHandler.itemIngotAluminum, 1),
                        new ItemStack(ItemHandler.itemPolycarbonate, 2),
                        new ItemStack(Items.DIAMOND, 1) };
            }
        });
        AssemblyManager.register(new Schematic("polycarbonate", new ItemStack(ItemHandler.itemPolycarbonate, 4)) {
            @Override
            public ItemStack[] getItemsRequired()
            {
                return new ItemStack[] {
                        new ItemStack(ItemHandler.itemCarbon, 6),
                        new ItemStack(ItemHandler.itemSilicon, 3) };
            }
        });
        AssemblyManager.register(new Schematic("carbon", new ItemStack(ItemHandler.itemCarbon, 3)) {
            @Override
            public ItemStack[] getItemsRequired()
            {
                return new ItemStack[] {
                        new ItemStack(Items.COAL, 4) };
            }
        });
        AssemblyManager.register(new Schematic("resistor", new ItemStack(ItemHandler.itemResistor, 2)) {
            @Override
            public ItemStack[] getItemsRequired()
            {
                return new ItemStack[] {
                        new ItemStack(ItemHandler.itemIngotCopper, 2),
                        new ItemStack(ItemHandler.itemCarbon, 1) };
            }
        });
        AssemblyManager.register(new Schematic("capacitor", new ItemStack(ItemHandler.itemCapacitor, 2)) {
            @Override
            public ItemStack[] getItemsRequired()
            {
                return new ItemStack[] {
                        new ItemStack(ItemHandler.itemIngotCopper, 2),
                        new ItemStack(ItemHandler.itemIngotLithium, 1) };
            }
        });
        AssemblyManager.register(new Schematic("diode", new ItemStack(ItemHandler.itemDiode, 2)) {
            @Override
            public ItemStack[] getItemsRequired()
            {
                return new ItemStack[] {
                        new ItemStack(ItemHandler.itemIngotCopper, 1),
                        new ItemStack(ItemHandler.itemCarbon, 1),
                        new ItemStack(ItemHandler.itemSilicon, 1) };
            }
        });
        AssemblyManager.register(new Schematic("led", new ItemStack(ItemHandler.itemLed, 2)) {
            @Override
            public ItemStack[] getItemsRequired()
            {
                return new ItemStack[] {
                        new ItemStack(ItemHandler.itemPolycarbonate, 1),
                        new ItemStack(ItemHandler.itemDiode, 1),
                        new ItemStack(Items.REDSTONE, 1) };
            }
        });
        AssemblyManager.register(new Schematic("regulator", new ItemStack(ItemHandler.itemVoltageRegulator, 2)) {
            @Override
            public ItemStack[] getItemsRequired()
            {
                return new ItemStack[] {
                        new ItemStack(ItemHandler.itemDiode, 1),
                        new ItemStack(ItemHandler.itemIngotCopper, 1),
                        new ItemStack(ItemHandler.itemResistor, 1) };
            }
        });
        AssemblyManager.register(new Schematic("transistor", new ItemStack(ItemHandler.itemTransistor, 2)) {
            @Override
            public ItemStack[] getItemsRequired()
            {
                return new ItemStack[] {
                        new ItemStack(ItemHandler.itemIngotAluminum, 2),
                        new ItemStack(ItemHandler.itemSilicon, 1),
                        new ItemStack(Item.getItemFromBlock(Blocks.LEVER), 1) };
            }
        });
        AssemblyManager.register(new Schematic("ic", new ItemStack(ItemHandler.itemIntegratedCircuit, 2)) {
            @Override
            public ItemStack[] getItemsRequired()
            {
                return new ItemStack[] {
                        new ItemStack(ItemHandler.itemPolycarbonate, 1),
                        new ItemStack(ItemHandler.itemIngotAluminum, 2),
                        new ItemStack(ItemHandler.itemIngotCopper, 2),
                        new ItemStack(ItemHandler.itemSilicon, 1),
                        new ItemStack(ItemHandler.itemTransistor, 1),
                        new ItemStack(ItemHandler.itemResistor, 1),
                        new ItemStack(ItemHandler.itemVoltageRegulator, 1),
                        new ItemStack(ItemHandler.itemDiode, 1) };
            }
        });
        AssemblyManager.register(new Schematic("processor", new ItemStack(ItemHandler.itemProcessor, 1)) {
            @Override
            public ItemStack[] getItemsRequired()
            {
                return new ItemStack[] {
                        new ItemStack(ItemHandler.itemPolycarbonate, 1),
                        new ItemStack(ItemHandler.itemIntegratedCircuit, 5),
                        new ItemStack(ItemHandler.itemIngotLithium, 1) };
            }
        });
        AssemblyManager.register(new Schematic("motherboard", new ItemStack(ItemHandler.itemMotherboard, 1)) {
            @Override
            public ItemStack[] getItemsRequired()
            {
                return new ItemStack[] {
                        new ItemStack(ItemHandler.itemPolycarbonate, 1),
                        new ItemStack(ItemHandler.itemIntegratedCircuit, 1),
                        new ItemStack(ItemHandler.itemSilicon, 1),
                        new ItemStack(ItemHandler.itemTransistor, 1),
                        new ItemStack(ItemHandler.itemVoltageRegulator, 1),
                        new ItemStack(ItemHandler.itemDiode, 1) };
            }
        });
        AssemblyManager.register(new Schematic("powerline", new ItemStack(BlockHandler.powerline, 4)) {
            @Override
            public ItemStack[] getItemsRequired()
            {
                return new ItemStack[] {
                        new ItemStack(ItemHandler.itemPolycarbonate, 4),
                        new ItemStack(ItemHandler.itemIngotCopper, 1) };
            }
        });
        AssemblyManager.register(new Schematic("powersupply", new ItemStack(ItemHandler.itemPowerSupply, 1)) {
            @Override
            public ItemStack[] getItemsRequired()
            {
                return new ItemStack[] {
                        new ItemStack(ItemHandler.itemDiode, 1),
                        new ItemStack(ItemHandler.itemVoltageRegulator, 1),
                        new ItemStack(ItemHandler.itemIngotAluminum, 2),
                        new ItemStack(BlockHandler.transformer, 1) };
            }
        });
        AssemblyManager.register(new Schematic("ledDisplay", new ItemStack(ItemHandler.itemLedDisplay, 2)) {
            @Override
            public ItemStack[] getItemsRequired()
            {
                return new ItemStack[] {
                        new ItemStack(ItemHandler.itemPolycarbonate, 1),
                        new ItemStack(ItemHandler.itemLed, 6),
                        new ItemStack(ItemHandler.itemIntegratedCircuit, 1),
                        new ItemStack(ItemHandler.itemIngotLithium, 1) };
            }
        });
        AssemblyManager.register(new Schematic("ram", new ItemStack(ItemHandler.itemRAM, 2)) {
            @Override
            public ItemStack[] getItemsRequired()
            {
                return new ItemStack[] {
                        new ItemStack(ItemHandler.itemIntegratedCircuit, 3),
                        new ItemStack(ItemHandler.itemVoltageRegulator, 1),
                        new ItemStack(ItemHandler.itemIngotCopper, 2),
                        new ItemStack(ItemHandler.itemSilicon, 2),
                        new ItemStack(ItemHandler.itemPolycarbonate, 1) };
            }
        });
        AssemblyManager.register(new Schematic("solidstatedrive", new ItemStack(ItemHandler.itemSolidStateDrive, 1)) {
            @Override
            public ItemStack[] getItemsRequired()
            {
                return new ItemStack[] {
                        new ItemStack(ItemHandler.itemRAM, 2),
                        new ItemStack(ItemHandler.itemVoltageRegulator, 1),
                        new ItemStack(ItemHandler.itemIntegratedCircuit, 1),
                        new ItemStack(ItemHandler.itemIngotLithium, 1),
                        new ItemStack(ItemHandler.itemPolycarbonate, 1) };
            }
        });
    }
}
