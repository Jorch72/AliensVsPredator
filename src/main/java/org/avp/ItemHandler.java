package org.avp;

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
import org.avp.item.ItemAPC;
import org.avp.item.ItemArmorMK50;
import org.avp.item.ItemArmorMarine;
import org.avp.item.ItemArmorPressureSuit;
import org.avp.item.ItemArmorTitanium;
import org.avp.item.ItemArmorXeno;
import org.avp.item.ItemDisc;
import org.avp.item.ItemEntitySummoner;
import org.avp.item.ItemFirearm;
import org.avp.item.ItemFirearm.Classification;
import org.avp.item.ItemFirearm.ItemAmmunition;
import org.avp.item.ItemGrenade;
import org.avp.item.ItemIngotLithium;
import org.avp.item.ItemLaserMine;
import org.avp.item.ItemM240IncineratorUnit;
import org.avp.item.ItemMaintenanceJack;
import org.avp.item.ItemPlasmaCannon;
import org.avp.item.ItemSevastopolFlamethrower;
import org.avp.item.ItemShuriken;
import org.avp.item.ItemSpear;
import org.avp.item.ItemStorageDevice;
import org.avp.item.ItemStunBaton;
import org.avp.item.ItemSupplyChute;
import org.avp.item.ItemSupplyChute.SupplyChuteType;
import org.avp.item.ItemWristbracer;
import org.avp.item.expansion.ItemLedDisplay;
import org.avp.item.expansion.ItemProcessor;
import org.avp.item.expansion.ItemSMGAmmo;
import org.avp.item.firearms.FirearmProfiles;
import org.avp.item.rackmodules.ItemNetworkRackModule1;
import org.avp.item.rackmodules.ItemNetworkRackModule2;
import org.avp.item.rackmodules.ItemNetworkRackModule3;
import org.avp.item.rackmodules.ItemNetworkRackModule4;
import org.avp.item.rackmodules.ItemNetworkRackModule5;
import org.avp.item.rackmodules.ItemNetworkRackModule6;
import org.avp.item.rackmodules.ItemNetworkRackModule7;
import org.avp.item.rackmodules.ItemNetworkRackModule8;

import com.arisux.mdx.lib.game.Renderers;
import com.arisux.mdx.lib.world.item.HookedItem;
import com.arisux.mdx.lib.world.item.ItemToolMaterialAxe;
import com.arisux.mdx.lib.world.item.ItemToolMaterialPickaxe;

import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBucket;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemHoe;
import net.minecraft.item.ItemSpade;
import net.minecraft.item.ItemSword;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.GameRegistry.ObjectHolder;
import net.minecraftforge.fml.relauncher.Side;

@ObjectHolder(AliensVsPredator.Properties.ID)
public class ItemHandler
{
    public static final Item helmXeno                   = new ItemArmorXeno(0, EntityEquipmentSlot.HEAD).setCreativeTab(Tab.MAIN).setRegistryName("helm.xeno");
    public static final Item plateXeno                  = new ItemArmorXeno(0, EntityEquipmentSlot.CHEST).setCreativeTab(Tab.MAIN).setRegistryName("body.xeno");
    public static final Item legsXeno                   = new ItemArmorXeno(0, EntityEquipmentSlot.LEGS).setCreativeTab(Tab.MAIN).setRegistryName("legwear.xeno");
    public static final Item bootsXeno                  = new ItemArmorXeno(0, EntityEquipmentSlot.FEET).setCreativeTab(Tab.MAIN).setRegistryName("boots.xeno");
    public static final Item pressureMask               = new ItemArmorPressureSuit(0, EntityEquipmentSlot.HEAD).setCreativeTab(Tab.MAIN).setRegistryName("helm.pressure");
    public static final Item pressureChest              = new ItemArmorPressureSuit(0, EntityEquipmentSlot.CHEST).setCreativeTab(Tab.MAIN).setRegistryName("body.pressure");
    public static final Item pressurePants              = new ItemArmorPressureSuit(0, EntityEquipmentSlot.LEGS).setCreativeTab(Tab.MAIN).setRegistryName("legwear.pressure");
    public static final Item pressureBoots              = new ItemArmorPressureSuit(0, EntityEquipmentSlot.FEET).setCreativeTab(Tab.MAIN).setRegistryName("boots.pressure");
    public static final Item mk50helmet                 = new ItemArmorMK50(0, EntityEquipmentSlot.HEAD).setCreativeTab(Tab.MAIN).setRegistryName("helm.mk50");
    public static final Item mk50body                   = new ItemArmorMK50(0, EntityEquipmentSlot.CHEST).setCreativeTab(Tab.MAIN).setRegistryName("body.mk50");
    public static final Item mk50pants                  = new ItemArmorMK50(0, EntityEquipmentSlot.LEGS).setCreativeTab(Tab.MAIN).setRegistryName("legwear.mk50");
    public static final Item mk50boots                  = new ItemArmorMK50(0, EntityEquipmentSlot.FEET).setCreativeTab(Tab.MAIN).setRegistryName("boots.mk50");
    public static final Item helmMarine                 = new ItemArmorMarine(0, EntityEquipmentSlot.HEAD).setCreativeTab(Tab.MAIN).setRegistryName("helm.tactical");
    public static final Item plateMarine                = new ItemArmorMarine(0, EntityEquipmentSlot.CHEST).setCreativeTab(Tab.MAIN).setRegistryName("body.tactical");
    public static final Item legsMarine                 = new ItemArmorMarine(0, EntityEquipmentSlot.LEGS).setCreativeTab(Tab.MAIN).setRegistryName("legwear.tactical");
    public static final Item bootsMarine                = new ItemArmorMarine(0, EntityEquipmentSlot.FEET).setCreativeTab(Tab.MAIN).setRegistryName("boots.tactical");
    public static final Item helmTitanium               = new ItemArmorTitanium(0, EntityEquipmentSlot.HEAD).setCreativeTab(Tab.MAIN).setRegistryName("helm.celtic");
    public static final Item plateTitanium              = new ItemArmorTitanium(0, EntityEquipmentSlot.CHEST).setCreativeTab(Tab.MAIN).setRegistryName("body.celtic");
    public static final Item legsTitanium               = new ItemArmorTitanium(0, EntityEquipmentSlot.LEGS).setCreativeTab(Tab.MAIN).setRegistryName("legwear.celtic");
    public static final Item bootsTitanium              = new ItemArmorTitanium(0, EntityEquipmentSlot.FEET).setCreativeTab(Tab.MAIN).setRegistryName("boots.celtic");
    public static final Item shovelTitanium             = new ItemSpade(AliensVsPredator.materials().tools().celtic).setCreativeTab(Tab.MAIN).setRegistryName("tool.celtic.shovel");
    public static final Item pickaxeTitanium            = new ItemToolMaterialPickaxe(AliensVsPredator.materials().tools().celtic).setCreativeTab(Tab.MAIN).setRegistryName("tool.celtic.pick");
    public static final Item axeTitanium                = new ItemToolMaterialAxe(AliensVsPredator.materials().tools().celtic).setCreativeTab(Tab.MAIN).setRegistryName("tool.celtic.axe");
    public static final Item swordTitanium              = new ItemSword(AliensVsPredator.materials().tools().celtic).setCreativeTab(Tab.MAIN).setRegistryName("tool.celtic.sword");
    public static final Item hoeTitanium                = new ItemHoe(AliensVsPredator.materials().tools().celtic).setCreativeTab(Tab.MAIN).setRegistryName("tool.celtic.hoe");
    public static final Item itemSpear                  = new ItemSpear(AliensVsPredator.materials().tools().celtic).setCreativeTab(Tab.MAIN).setRegistryName("tool.celtic.spear");
    public static final Item itemWristbracer            = new ItemWristbracer().setMaxStackSize(1).setCreativeTab(Tab.MAIN).setRegistryName("wristblade");
    public static final Item itemWristbracerBlades      = new HookedItem().setMaxStackSize(1).setMaxDamage(AliensVsPredator.materials().tools().celtic.getMaxUses()).setCreativeTab(Tab.MAIN).setRegistryName("wristbracer.blades");
    public static final Item itemStunBaton              = new ItemStunBaton().setCreativeTab(Tab.MAIN).setRegistryName("stun.baton");
    public static final Item itemPlasmaCannon           = new ItemPlasmaCannon().setFull3D().setCreativeTab(Tab.MAIN).setRegistryName("plasmacannon");
    public static final Item itemProximityMine          = new ItemLaserMine().setCreativeTab(Tab.MAIN).setRegistryName("mine.laser");
    public static final Item itemDisc                   = new ItemDisc().setCreativeTab(Tab.MAIN).setRegistryName("smartdisc");
    public static final Item itemShuriken               = new ItemShuriken().setCreativeTab(Tab.MAIN).setRegistryName("shuriken");
    public static final Item itemGrenade                = new ItemGrenade(false).setCreativeTab(Tab.MAIN).setRegistryName("grenade.m40");
    public static final Item itemIncendiaryGrenade      = new ItemGrenade(true).setCreativeTab(Tab.MAIN).setRegistryName("grenade.incindiary");
    public static final Item itemAmmoPistol             = new ItemAmmunition(Classification.PISTOL).setCreativeTab(Tab.MAIN).setRegistryName("ammo.pistol");
    public static final Item itemAmmoAR                 = new ItemAmmunition(Classification.ASSAULT_RIFLE).setCreativeTab(Tab.MAIN).setRegistryName("ammo.ar");
    public static final Item itemAmmoSMG                = new ItemSMGAmmo().setCreativeTab(Tab.MAIN).setRegistryName("ammo.smg");
    public static final Item itemAmmoSniper             = new ItemAmmunition(Classification.RIFLE).setCreativeTab(Tab.MAIN).setRegistryName("ammo.sniper");
    public static final Item itemPropaneTank            = new HookedItem().setMaxStackSize(1).setMaxDamage(64).setCreativeTab(Tab.MAIN).setRegistryName("ammo.flamethrower");
    public static final Item itemM240ICU                = new ItemM240IncineratorUnit(itemPropaneTank).setCreativeTab(Tab.MAIN).setRegistryName("gun.m240icu");
    public static final Item itemSevastopolFlamethrower = new ItemSevastopolFlamethrower(itemPropaneTank).setCreativeTab(Tab.MAIN).setRegistryName("gun.flamethrower.nostromo");
    public static final Item itemPistol                 = new ItemFirearm(FirearmProfiles.PISTOL).setCreativeTab(Tab.MAIN).setRegistryName("gun.pistol");
    public static final Item itemM4                     = new ItemFirearm(FirearmProfiles.M4).setFull3D().setCreativeTab(Tab.MAIN).setRegistryName("gun.m4");
    public static final Item itemSniper                 = new ItemFirearm(FirearmProfiles.SNIPER).setFull3D().setCreativeTab(Tab.MAIN).setRegistryName("gun.sniper");
    public static final Item itemM41A                   = new ItemFirearm(FirearmProfiles.M41A).setFull3D().setCreativeTab(Tab.MAIN).setRegistryName("gun.m41a");
    public static final Item itemM56SG                  = new ItemFirearm(FirearmProfiles.M56SG).setFull3D().setCreativeTab(Tab.MAIN).setRegistryName("gun.m56sg");
    public static final Item itemAK47                   = new ItemFirearm(FirearmProfiles.AK47).setFull3D().setCreativeTab(Tab.MAIN).setRegistryName("gun.ak47");
    public static final Item itemPistolStock            = new HookedItem().setMaxStackSize(64).setCreativeTab(Tab.GUN_PARTS).setRegistryName("part.pistol.stock");
    public static final Item itemPistolBarrel           = new HookedItem().setMaxStackSize(64).setCreativeTab(Tab.GUN_PARTS).setRegistryName("part.pistol.barrel");
    public static final Item itemPistolAction           = new HookedItem().setMaxStackSize(64).setCreativeTab(Tab.GUN_PARTS).setRegistryName("part.pistol.action");
    public static final Item itemM4Stock                = new HookedItem().setMaxStackSize(64).setCreativeTab(Tab.GUN_PARTS).setRegistryName("part.m4.stock");
    public static final Item itemM4Barrel               = new HookedItem().setMaxStackSize(64).setCreativeTab(Tab.GUN_PARTS).setRegistryName("part.m4.barrel");
    public static final Item itemM4Action               = new HookedItem().setMaxStackSize(64).setCreativeTab(Tab.GUN_PARTS).setRegistryName("part.m4.action");
    public static final Item itemSniperStock            = new HookedItem().setMaxStackSize(64).setCreativeTab(Tab.GUN_PARTS).setRegistryName("part.sniper.stock");
    public static final Item itemSniperBarrel           = new HookedItem().setMaxStackSize(64).setCreativeTab(Tab.GUN_PARTS).setRegistryName("part.sniper.barrel");
    public static final Item itemSniperAction           = new HookedItem().setMaxStackSize(64).setCreativeTab(Tab.GUN_PARTS).setRegistryName("part.sniper.action");
    public static final Item itemSniperScope            = new HookedItem().setMaxStackSize(64).setCreativeTab(Tab.GUN_PARTS).setRegistryName("part.sniper.scope");
    public static final Item itemSniperPeripherals      = new HookedItem().setMaxStackSize(64).setCreativeTab(Tab.GUN_PARTS).setRegistryName("part.sniper.peripherals");
    public static final Item itemM41AStock              = new HookedItem().setMaxStackSize(64).setCreativeTab(Tab.GUN_PARTS).setRegistryName("part.m41a.stock");
    public static final Item itemM41ABarrel             = new HookedItem().setMaxStackSize(64).setCreativeTab(Tab.GUN_PARTS).setRegistryName("part.m41a.barrel");
    public static final Item itemM41AAction             = new HookedItem().setMaxStackSize(64).setCreativeTab(Tab.GUN_PARTS).setRegistryName("part.m41a.action");
    public static final Item itemM41APeripherals        = new HookedItem().setMaxStackSize(64).setCreativeTab(Tab.GUN_PARTS).setRegistryName("part.m41a.peripherals");
    public static final Item itemM56SGStock             = new HookedItem().setMaxStackSize(64).setCreativeTab(Tab.GUN_PARTS).setRegistryName("part.m56sg.stock");
    public static final Item itemM56SGBarrel            = new HookedItem().setMaxStackSize(64).setCreativeTab(Tab.GUN_PARTS).setRegistryName("part.m56sg.barrel");
    public static final Item itemM56SGAction            = new HookedItem().setMaxStackSize(64).setCreativeTab(Tab.GUN_PARTS).setRegistryName("part.m56sg.action");
    public static final Item itemM56SGSupportFrame      = new HookedItem().setMaxStackSize(64).setCreativeTab(Tab.GUN_PARTS).setRegistryName("part.m56sg.supportframe");
    public static final Item itemM56SGAimingModule      = new HookedItem().setMaxStackSize(64).setCreativeTab(Tab.GUN_PARTS).setRegistryName("part.m56sg.aimingmodule");
    public static final Item itemAK47Stock              = new HookedItem().setMaxStackSize(64).setCreativeTab(Tab.GUN_PARTS).setRegistryName("part.ak47.stock");
    public static final Item itemAK47Barrel             = new HookedItem().setMaxStackSize(64).setCreativeTab(Tab.GUN_PARTS).setRegistryName("part.ak47.barrel");
    public static final Item itemAK47Action             = new HookedItem().setMaxStackSize(64).setCreativeTab(Tab.GUN_PARTS).setRegistryName("part.ak47.action");
    public static final Item itemDoritos                = new ItemFood(8, true).setAlwaysEdible().setCreativeTab(Tab.MAIN).setRegistryName("food.doritos");
    public static final Item itemDoritosCoolRanch       = new ItemFood(8, true).setAlwaysEdible().setCreativeTab(Tab.MAIN).setRegistryName("food.doritos.coolranch");
    public static final Item itemFlashDrive             = new ItemStorageDevice().setMaxStackSize(64).setCreativeTab(Tab.MAIN).setRegistryName("device.nbtdrive");
    public static final Item itemCapacitor              = new HookedItem().setMaxStackSize(64).setCreativeTab(Tab.CRAFTING).setRegistryName("part.capacitor");
    public static final Item itemTransistor             = new HookedItem().setMaxStackSize(64).setCreativeTab(Tab.CRAFTING).setRegistryName("part.transistor");
    public static final Item itemRAM                    = new HookedItem().setMaxStackSize(64).setCreativeTab(Tab.CRAFTING).setRegistryName("part.ram");
    public static final Item itemResistor               = new HookedItem().setMaxStackSize(64).setCreativeTab(Tab.CRAFTING).setRegistryName("part.resistor");
    public static final Item itemArtifactTech           = new HookedItem().setMaxStackSize(64).setCreativeTab(Tab.CRAFTING).setRegistryName("artifact.tech");
    public static final Item itemProcessor              = new ItemProcessor().setCreativeTab(Tab.CRAFTING).setRegistryName("part.processor");
    public static final Item itemSolidStateDrive        = new ItemStorageDevice().setCreativeTab(Tab.CRAFTING).setRegistryName("part.solidstatedrive");
    public static final Item itemDiode                  = new HookedItem().setMaxStackSize(64).setCreativeTab(Tab.CRAFTING).setRegistryName("part.diode");
    public static final Item itemMotherboard            = new HookedItem().setCreativeTab(Tab.CRAFTING).setRegistryName("part.motherboard");
    public static final Item itemPowerSupply            = new HookedItem().setCreativeTab(Tab.CRAFTING).setRegistryName("part.powersupply");
    public static final Item itemLedDisplay             = new ItemLedDisplay().setCreativeTab(Tab.CRAFTING).setRegistryName("part.led.display");
    public static final Item itemVoltageRegulator       = new HookedItem().setMaxStackSize(64).setCreativeTab(Tab.CRAFTING).setRegistryName("part.regulator");
    public static final Item itemLed                    = new HookedItem().setMaxStackSize(64).setCreativeTab(Tab.CRAFTING).setRegistryName("part.led");
    public static final Item itemIntegratedCircuit      = new HookedItem().setCreativeTab(Tab.CRAFTING).setRegistryName("part.ic");
    public static final Item itemSupplyChute            = new ItemSupplyChute(SupplyChuteType.UNBRANDED).setCreativeTab(Tab.MAIN).setRegistryName("device.supplychute");
    public static final Item itemSupplyChuteMarines     = new ItemSupplyChute(SupplyChuteType.MARINES).setCreativeTab(Tab.MAIN).setRegistryName("device.supplychute.marines");
    public static final Item itemSupplyChuteSeegson     = new ItemSupplyChute(SupplyChuteType.SEEGSON).setCreativeTab(Tab.MAIN).setRegistryName("device.supplychute.seegson");
    public static final Item itemAPC                    = new ItemAPC().setCreativeTab(Tab.MAIN).setCreativeTab(Tab.MAIN).setRegistryName("apc");
    public static final Item itemCarbon                 = new HookedItem().setMaxStackSize(64).setCreativeTab(Tab.CRAFTING).setRegistryName("carbon");
    public static final Item cobalt                     = new HookedItem().setCreativeTab(Tab.CRAFTING).setRegistryName("cobalt");
    public static final Item neodymium                  = new HookedItem().setCreativeTab(Tab.CRAFTING).setRegistryName("neodymium");
    public static final Item neodymiumMagnet            = new HookedItem().setMaxStackSize(16).setCreativeTab(Tab.CRAFTING).setRegistryName("neodymium.magnet");
    public static final Item itemSilicon                = new HookedItem().setCreativeTab(Tab.CRAFTING).setRegistryName("silicon");
    public static final Item itemIngotAluminum          = new HookedItem().setCreativeTab(Tab.CRAFTING).setRegistryName("ingot.aluminum");
    public static final Item itemIngotCopper            = new HookedItem().setCreativeTab(Tab.CRAFTING).setRegistryName("ingot.copper");
    public static final Item itemPolycarbonate          = new HookedItem().setCreativeTab(Tab.CRAFTING).setRegistryName("polycarbonate");
    public static final Item itemIngotLithium           = new ItemIngotLithium().setCreativeTab(Tab.CRAFTING).setRegistryName("ingot.lithium");
    public static final Item itemMotionTracker          = new HookedItem().setCreativeTab(Tab.MAIN).setRegistryName("motiontracker");
    public static final Item itemRoyalJelly             = new HookedItem().setMaxStackSize(64).setCreativeTab(Tab.MAIN).setRegistryName("royaljelly");
    public static final Item itemBlackGoo               = new HookedItem().setCreativeTab(Tab.MAIN).setRegistryName("blackgoo.item");
    public static final Item itemPhial                  = new HookedItem().setCreativeTab(Tab.MAIN).setRegistryName("phial.goo");
    public static final Item itemPhialEmpty             = new HookedItem().setCreativeTab(Tab.MAIN).setRegistryName("phial.empty");
    public static final Item itemChargePack             = new HookedItem().setMaxDamage(64).setMaxStackSize(1).setCreativeTab(Tab.MAIN).setRegistryName("chargepack");
    public static final Item itemMaintenanceJack        = new ItemMaintenanceJack().setCreativeTab(Tab.MAIN).setRegistryName("tool.maintenancejack");
    public static final Item blackGooBucket             = new ItemBucket(BlockHandler.blackgoo).setCreativeTab(Tab.MAIN).setRegistryName("bucket.blackgoo");
    public static final Item mistBucket                 = new ItemBucket(BlockHandler.mist).setCreativeTab(Tab.MAIN).setRegistryName("bucket.mist");
    public static final Item securityTuner              = new HookedItem().setMaxStackSize(1).setCreativeTab(Tab.MAIN).setRegistryName("tool.securitytuner");
    public static final Item rackModule1                = new ItemNetworkRackModule1().setCreativeTab(Tab.MAIN).setRegistryName("rackmodule1");
    public static final Item rackModule2                = new ItemNetworkRackModule2().setCreativeTab(Tab.MAIN).setRegistryName("rackmodule2");
    public static final Item rackModule3                = new ItemNetworkRackModule3().setCreativeTab(Tab.MAIN).setRegistryName("rackmodule3");
    public static final Item rackModule4                = new ItemNetworkRackModule4().setCreativeTab(Tab.MAIN).setRegistryName("rackmodule4");
    public static final Item rackModule5                = new ItemNetworkRackModule5().setCreativeTab(Tab.MAIN).setRegistryName("rackmodule5");
    public static final Item rackModule6                = new ItemNetworkRackModule6().setCreativeTab(Tab.MAIN).setRegistryName("rackmodule6");
    public static final Item rackModule7                = new ItemNetworkRackModule7().setCreativeTab(Tab.MAIN).setRegistryName("rackmodule7");
    public static final Item rackModule8                = new ItemNetworkRackModule8().setCreativeTab(Tab.MAIN).setRegistryName("rackmodule8");
    public static final Item summonerDrone              = new ItemEntitySummoner(EntityDrone.class).setCreativeTab(Tab.ENTITIES).setRegistryName("summon.drone");
    public static final Item summonerAqua               = new ItemEntitySummoner(EntityAqua.class).setCreativeTab(Tab.ENTITIES).setRegistryName("summon.aqua");
    public static final Item summonerWarrior            = new ItemEntitySummoner(EntityWarrior.class).setCreativeTab(Tab.ENTITIES).setRegistryName("summon.warrior");
    public static final Item summonerCrusher            = new ItemEntitySummoner(EntityCrusher.class).setCreativeTab(Tab.ENTITIES).setRegistryName("summon.crusher");
    public static final Item summonerSpitter            = new ItemEntitySummoner(EntitySpitter.class).setCreativeTab(Tab.ENTITIES).setRegistryName("summon.spitter");
    public static final Item summonerPraetorian         = new ItemEntitySummoner(EntityPraetorian.class).setCreativeTab(Tab.ENTITIES).setRegistryName("summon.praetorian");
    public static final Item summonerQueen              = new ItemEntitySummoner(EntityMatriarch.class).setCreativeTab(Tab.ENTITIES).setRegistryName("summon.queen");
    public static final Item summonerChestburster       = new ItemEntitySummoner(EntityChestburster.class).setCreativeTab(Tab.ENTITIES).setRegistryName("summon.chestburster");
    public static final Item summonerFacehugger         = new ItemEntitySummoner(EntityFacehugger.class).setCreativeTab(Tab.ENTITIES).setRegistryName("summon.facehugger");
    public static final Item summonerMarine             = new ItemEntitySummoner(EntityMarine.class).setCreativeTab(Tab.ENTITIES).setRegistryName("summon.marine");
    public static final Item summonerOvamorph           = new ItemEntitySummoner(EntityOvamorph.class).setCreativeTab(Tab.ENTITIES).setRegistryName("summon.ovamorph");
    public static final Item summonerRoyalFacehugger    = new ItemEntitySummoner(EntityRoyalFacehugger.class).setCreativeTab(Tab.ENTITIES).setRegistryName("summon.royalfacehugger");
    public static final Item summonerYautjaWarrior      = new ItemEntitySummoner(EntityYautjaWarrior.class).setCreativeTab(Tab.ENTITIES).setRegistryName("summon.yautja.warrior");
    public static final Item summonerPredalien          = new ItemEntitySummoner(EntityPredalien.class).setCreativeTab(Tab.ENTITIES).setRegistryName("summon.predalien");
    public static final Item summonerCombatSynthetic    = new ItemEntitySummoner(EntityCombatSynthetic.class).setCreativeTab(Tab.ENTITIES).setRegistryName("summon.synthetic.combat");
    public static final Item summonerDeacon             = new ItemEntitySummoner(EntityDeacon.class).setCreativeTab(Tab.ENTITIES).setRegistryName("summon.deacon");
    public static final Item summonerDeaconAdult        = new ItemEntitySummoner(EntityDeaconAdult.class).setCreativeTab(Tab.ENTITIES).setRegistryName("summon.deacon.adult");
    public static final Item summonerHammerpede         = new ItemEntitySummoner(EntityHammerpede.class).setCreativeTab(Tab.ENTITIES).setRegistryName("summon.hammerpede");
    public static final Item summonerTrilobite          = new ItemEntitySummoner(EntityTrilobite.class).setCreativeTab(Tab.ENTITIES).setRegistryName("summon.trilobite");
    public static final Item summonerYautjaBerserker    = new ItemEntitySummoner(EntityYautjaBerserker.class).setCreativeTab(Tab.ENTITIES).setRegistryName("summon.yautja.berserker");
    public static final Item summonerSpaceJockey        = new ItemEntitySummoner(EntitySpaceJockey.class).setCreativeTab(Tab.ENTITIES).setRegistryName("summon.spacejockey");
    public static final Item summonerEngineer           = new ItemEntitySummoner(EntityEngineer.class).setCreativeTab(Tab.ENTITIES).setRegistryName("summon.engineer");
    public static final Item summonerDeaconShark        = new ItemEntitySummoner(EntityDeaconShark.class).setCreativeTab(Tab.ENTITIES).setRegistryName("summon.deaconshark");
    public static final Item summonerRunnerDrone        = new ItemEntitySummoner(EntityRunnerDrone.class).setCreativeTab(Tab.ENTITIES).setRegistryName("summon.runner.drone");
    public static final Item summonerRunnerWarrior      = new ItemEntitySummoner(EntityRunnerWarrior.class).setCreativeTab(Tab.ENTITIES).setRegistryName("summon.runner.warrior");
    public static final Item summonerUltramorph         = new ItemEntitySummoner(EntityUltramorph.class).setCreativeTab(Tab.ENTITIES).setRegistryName("summon.ultramorph");
    public static final Item summonerGooMutant          = new ItemEntitySummoner(EntityGooMutant.class).setCreativeTab(Tab.ENTITIES).setRegistryName("summon.goomutant");
    public static final Item summonerAethon             = new ItemEntitySummoner(EntityAethon.class).setCreativeTab(Tab.ENTITIES).setRegistryName("summon.aethon");
    public static final Item summonerOctohugger         = new ItemEntitySummoner(EntityOctohugger.class).setCreativeTab(Tab.ENTITIES).setRegistryName("summon.octohugger");
    public static final Item summonerBelugaburster      = new ItemEntitySummoner(EntityBelugaburster.class).setCreativeTab(Tab.ENTITIES).setRegistryName("summon.belugaburster");
    public static final Item summonerBelugamorph        = new ItemEntitySummoner(EntityBelugamorph.class).setCreativeTab(Tab.ENTITIES).setRegistryName("summon.belugamorph");
    public static final Item summonerPredalienBurster   = new ItemEntitySummoner(EntityPredalienChestburster.class).setCreativeTab(Tab.ENTITIES).setRegistryName("summon.chestburster.predalien");
    public static final Item summonerQueenBurster       = new ItemEntitySummoner(EntityQueenChestburster.class).setCreativeTab(Tab.ENTITIES).setRegistryName("summon.chestburster.queen");
    public static final Item summonerRunnerBurster      = new ItemEntitySummoner(EntityRunnerChestburster.class).setCreativeTab(Tab.ENTITIES).setRegistryName("summon.chestburster.runner");
    public static final Item summonerBabyhead           = new ItemEntitySummoner(EntityBabyhead.class).setCreativeTab(Tab.ENTITIES_WIP).setRegistryName("summon.babyhead");
    public static final Item summonerBatXeno            = new ItemEntitySummoner(EntityBatXeno.class).setCreativeTab(Tab.ENTITIES_WIP).setRegistryName("summon.batxeno");
    public static final Item summonerBoiler             = new ItemEntitySummoner(EntityBoiler.class).setCreativeTab(Tab.ENTITIES_WIP).setRegistryName("summon.boiler");
    public static final Item summonerDracoburster       = new ItemEntitySummoner(EntityDracoburster.class).setCreativeTab(Tab.ENTITIES_WIP).setRegistryName("summon.dracoburster");
    public static final Item summonerDracoEgg           = new ItemEntitySummoner(EntityDracoEgg.class).setCreativeTab(Tab.ENTITIES_WIP).setRegistryName("summon.dracoegg");
    public static final Item summonerDracomorph         = new ItemEntitySummoner(EntityDracomorph.class).setCreativeTab(Tab.ENTITIES_WIP).setRegistryName("summon.dracomorph");
    public static final Item summonerMyceliomorph       = new ItemEntitySummoner(EntityMyceliomorph.class).setCreativeTab(Tab.ENTITIES_WIP).setRegistryName("summon.myceliomorph");
    public static final Item summonerPantheramorph      = new ItemEntitySummoner(EntityPantheramorph.class).setCreativeTab(Tab.ENTITIES_WIP).setRegistryName("summon.pantheramorph");
    public static final Item summonerPredatorHound      = new ItemEntitySummoner(EntityPredatorHound.class).setCreativeTab(Tab.ENTITIES_WIP).setRegistryName("summon.predatorhound");
    public static final Item summonerUrsuidae           = new ItemEntitySummoner(EntityUrsuidae.class).setCreativeTab(Tab.ENTITIES_WIP).setRegistryName("summon.ursuidae");
    public static final Item summonerVardaMonkey        = new ItemEntitySummoner(EntityScelemur.class).setCreativeTab(Tab.ENTITIES_WIP).setRegistryName("summon.vardamonkey");
    public static final Item summonerYautjaMutant       = new ItemEntitySummoner(EntityYautjaMutant.class).setCreativeTab(Tab.ENTITIES_WIP).setRegistryName("summon.yautjamutant");


    @Mod.EventBusSubscriber(modid = AliensVsPredator.Properties.ID)
    public static class RegistrationHandler
    {
        @SubscribeEvent
        public static void registerItems(RegistryEvent.Register<Item> event)
        {
            event.getRegistry().registerAll();

            for (java.lang.reflect.Field field : AliensVsPredator.items().getClass().getDeclaredFields())
            {
                try
                {
                    field.setAccessible(true);

                    Object obj = field.get(AliensVsPredator.items());

                    if (obj instanceof Item)
                    {
                        Item item = (Item) obj;
                        item.setTranslationKey(item.getRegistryName().getNamespace() + ":" + item.getRegistryName().getPath());
                        event.getRegistry().register(item);
                        registerIcon(item);
                    }
                }
                catch (Exception e)
                {
                    e.printStackTrace();
                }

            }
        }
    }

    private static Item registerIcon(Item item)
    {
        if (FMLCommonHandler.instance().getSide() == Side.CLIENT)
        {
            Renderers.registerIcon(item);
        }

        return item;
    }
}
