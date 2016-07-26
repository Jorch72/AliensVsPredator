/** AliensVsPredator Minecraft Mod - Copyright (C) 2012-2016 Arisux Technology Group **/
package org.avp;

import org.avp.api.AssemblerAPI;
import org.avp.api.WristbracerAPI;

import com.arisux.airi.AIRI;
import com.arisux.airi.lib.ModUtil;
import com.arisux.airi.lib.interfaces.IMod;

import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.ModContainer;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.event.FMLServerStartingEvent;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@Mod(modid = AliensVsPredator.ID, acceptedMinecraftVersions = "1.7.10", canBeDeactivated = true, dependencies = "required-after:AIRI")
public class AliensVsPredator implements IMod
{
    protected static final String ID = "avp";

    @Mod.Instance(AliensVsPredator.ID)
    private static AliensVsPredator instance;
    private ModContainer container;

    public static AliensVsPredator instance()
    {
        return AliensVsPredator.instance;
    }

    public static ItemHandler items()
    {
        return ItemHandler.instance;
    }

    public static BlockHandler blocks()
    {
        return BlockHandler.instance;
    }

    public static OreHandler ores()
    {
        return OreHandler.instance;
    }

    public static FluidHandler fluids()
    {
        return FluidHandler.instance;
    }

    public static MaterialHandler materials()
    {
        return MaterialHandler.instance;
    }

    public static LocalEventHandler events()
    {
        return LocalEventHandler.instance;
    }

    public static NetworkHandler network()
    {
        return NetworkHandler.instance;
    }

    public static DimensionHandler dimensions()
    {
        return DimensionHandler.instance;
    }

    public static WorldHandler worldgen()
    {
        return WorldHandler.instance;
    }

    public static EntityHandler entities()
    {
        return EntityHandler.instance;
    }

    public static RenderTypes renderTypes()
    {
        return RenderTypes.instance;
    }

    @SideOnly(Side.CLIENT)
    public static Renderers renderers()
    {
        return Renderers.instance;
    }

    @SideOnly(Side.CLIENT)
    public static KeybindHandler keybinds()
    {
        return KeybindHandler.instance;
    }

    @SideOnly(Side.CLIENT)
    public static Resources resources()
    {
        return Resources.instance;
    }

    public static GuiHandler interfaces()
    {
        return GuiHandler.instance;
    }

    public static Properties properties()
    {
        return Properties.instance;
    }

    public static CraftingHandler crafting()
    {
        return CraftingHandler.instance;
    }

    public static PlayerModeHandler playermodehandler()
    {
        return PlayerModeHandler.instance;
    }

    public static AssemblerAPI assembler()
    {
        return AssemblerAPI.instance;
    }

    @SideOnly(Side.CLIENT)
    public static WristbracerAPI wristbracer()
    {
        return WristbracerAPI.instance;
    }

    public static Schematics schematics()
    {
        return Schematics.instance;
    }

    public static CommandHandler commands()
    {
        return CommandHandler.instance;
    }

    public static Settings settings()
    {
        return Settings.instance;
    }

    @Override
    public ModContainer container()
    {
        return this.container == null ? this.container = ModUtil.getModContainerForId(AliensVsPredator.ID) : this.container;
    }

    @Override
    public String domain()
    {
        return container().getModId() + ":";
    }

    @Override
    public CreativeTab tab()
    {
        return CreativeTab.tabMain;
    }

    public CreativeTab tabBlocks()
    {
        return CreativeTab.tabBlocks;
    }

    @Override
    @Mod.EventHandler
    public void preInitialize(FMLPreInitializationEvent event)
    {
        AIRI.logger.info("[AliensVsPredator] Copyright(C) 2012-2016 Arisux Technology Group");
        AIRI.logger.info("[AliensVsPredator] Pre-Initialization");

        AIRI.remappingApi().registerRemappedMod("AliensVsPredator", AliensVsPredator.ID, "com.arisux.avp.AliensVsPredator");
        AIRI.remappingApi().registerMappingInfo("lv426portal", "portal.acheron", "avp");
        AIRI.remappingApi().registerMappingInfo("lv223portal", "portal.varda", "avp");

        settings().preInitialize(event);
        renderTypes().preInitialize(event);
    }

    @Override
    @Mod.EventHandler
    public void initialize(FMLInitializationEvent event)
    {
        AIRI.logger.info("[AliensVsPredator] Initialization");

        fluids().initialize(event);
        network().initialize(event);
        materials().initialize(event);
        items().initialize(event);
        blocks().initialize(event);
        ores().initialize(event);
        dimensions().initialize(event);
        worldgen().initialize(event);
        crafting().initialize(event);
        interfaces().initialize(event);
        events().initialize(event);
        commands().initialize(event);
        playermodehandler().initialize(event);
        schematics().initialize(event);
        assembler().initialize(event);
        entities().initialize(event);

        if (FMLCommonHandler.instance().getSide() == Side.CLIENT)
        {
            wristbracer().initialize(event);
        }
    }

    @Override
    @Mod.EventHandler
    public void postInitialize(FMLPostInitializationEvent event)
    {
        AIRI.logger.info("[AliensVsPredator] Post-Initialization");

        if (FMLCommonHandler.instance().getSide() == Side.CLIENT)
        {
            renderers().postInitialize(event);
            keybinds().postInitialize(event);

            if (settings().isUpdaterEnabled())
            {
                UpdateHandler.instance.postInitialize(event);
            }
        }
    }

    @EventHandler
    public void onServerStarting(FMLServerStartingEvent event)
    {
        commands().onServerStarting(event);
    }

    public boolean isDevCopy()
    {
        return true;
    }
}
