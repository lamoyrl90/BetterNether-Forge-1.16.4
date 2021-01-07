package redd90.betternether;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.RenderTypeLookup;
import net.minecraft.entity.EntityType;
import net.minecraft.item.Item;
import net.minecraft.tileentity.TileEntityType;
import net.minecraft.util.SoundEvent;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.ForgeRegistries;
import redd90.betternether.biomes.NetherBiome;
import redd90.betternether.blocks.BNRenderLayer;
import redd90.betternether.client.IRenderTypeable;
import redd90.betternether.config.Config;
import redd90.betternether.config.Configs;
import redd90.betternether.datagen.DataGenerators;
import redd90.betternether.recipes.ItemRecipes;
import redd90.betternether.registry.BlocksRegistry;
import redd90.betternether.registry.BrewingRegistry;
import redd90.betternether.registry.EntityRegistry;
import redd90.betternether.registry.EntityRenderRegistry;
import redd90.betternether.registry.FuelRegistry;
import redd90.betternether.registry.ItemsRegistry;
import redd90.betternether.registry.NetherBiomesRegistry;
import redd90.betternether.registry.SoundsRegistry;
import redd90.betternether.registry.TileEntitiesRegistry;
import redd90.betternether.registry.TileEntityRenderRegistry;
import redd90.betternether.world.BNWorldGenerator;
import redd90.betternether.world.NetherBiomeProvider;
import redd90.betternether.world.structures.piece.StructureTypes;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod(BetterNether.MOD_ID)
public class BetterNether
{
    // Directly reference a log4j logger.
    public static final Logger LOGGER = LogManager.getLogger();
    public static final String MOD_ID = "betternether";
	private static boolean thinArmor = true;
	private static boolean lavafallParticles = true;
	private static float fogStart = 0.05F;
	private static float fogEnd = 0.5F;
    
    public BetterNether() {
    	IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
    	IEventBus forgeEventBus = MinecraftForge.EVENT_BUS;
    	
    	initOptions();
    	
    	modEventBus.addListener(this::commonSetup);
    	modEventBus.addListener(this::clientSetup);
    	
    	modEventBus.addListener(DataGenerators::gatherData);
    	forgeEventBus.addListener(FuelRegistry::onFuelBurnTimeEvent);
    	modEventBus.addListener(NetherBiomesRegistry::createRegistry);
    	modEventBus.addGenericListener(SoundEvent.class, SoundsRegistry::registerAll);
    	modEventBus.addGenericListener(EntityType.class, EntityRegistry::registerAll);
    	modEventBus.addGenericListener(Block.class, BlocksRegistry::registerAll);
    	modEventBus.addGenericListener(Item.class, ItemsRegistry::registerAll);
    	modEventBus.addGenericListener(TileEntityType.class, TileEntitiesRegistry::registerAll);
    	modEventBus.addGenericListener(NetherBiome.class, NetherBiomesRegistry::registerNetherBiomes);
    	modEventBus.addGenericListener(Biome.class, NetherBiomesRegistry::registerBiomes);
    	
    	//StructureRegistry.DEFERRED_FEATURES.register(modEventBus);
    	//StructureRegistry.DEFERRED_STRUCTURES.register(modEventBus);
    	NetherBiomesRegistry.init();
    	EntityRegistry.registerNetherEntities();
    	StructureTypes.init();
    	BNWorldGenerator.onModInit();
    	BrewingRegistry.register();
    	Config.save();
    	
    	NetherTags.init();
    	
    	NetherBiomeProvider.register();
    }
    
    private void clientSetup(FMLClientSetupEvent e) {
		registerRenderLayers();
		EntityRenderRegistry.register();
		TileEntityRenderRegistry.register();
    }
    
    private void commonSetup(FMLCommonSetupEvent e) {
    	ItemRecipes.register();
    }
    
	private void initOptions() {
		thinArmor = Configs.MAIN.getBoolean("improvement", "smaller_armor_offset", true);
		lavafallParticles = Configs.MAIN.getBoolean("improvement", "lavafall_particles", true);
		float density = Configs.MAIN.getFloat("improvement", "fog_density[vanilla: 1.0]", 0.75F);
		changeFogDensity(density);
	}
	
	private void registerRenderLayers() {
		RenderType cutout = RenderType.getCutout();
		RenderType translucent = RenderType.getTranslucent();
		ForgeRegistries.BLOCKS.forEach(block -> {
			if (block instanceof IRenderTypeable) {
				BNRenderLayer layer = ((IRenderTypeable) block).getRenderLayer();
				if (layer == BNRenderLayer.CUTOUT)
					RenderTypeLookup.setRenderLayer(block, cutout);
				else if (layer == BNRenderLayer.TRANSLUCENT)
					RenderTypeLookup.setRenderLayer(block, translucent);
			}
		});
	}
	
	public static boolean hasThinArmor() {
		return thinArmor;
	}

	public static void setThinArmor(boolean value) {
		thinArmor = value;
	}

	public static boolean hasLavafallParticles() {
		return lavafallParticles;
	}
	
	public static void changeFogDensity(float density) {
		fogStart = -0.45F * density + 0.5F;
		fogEnd = -0.5F * density + 1;
	}

	public static float getFogStart() {
		return fogStart;
	}

	public static float getFogEnd() {
		return fogEnd;
	}
}
