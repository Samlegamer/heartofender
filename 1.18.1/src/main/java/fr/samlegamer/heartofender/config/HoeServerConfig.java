package fr.samlegamer.heartofender.config;

import com.legacy.structure_gel.api.config.StructureConfig;

import fr.samlegamer.heartofender.dimension.HoeDimensionRegistry;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.Level;
import net.minecraftforge.common.ForgeConfigSpec;

public class HoeServerConfig
{
	//Overworld
	public final ForgeConfigSpec.BooleanValue generateAzuriumOre;
	public final ForgeConfigSpec.IntValue YmaxAzuriumOre;
	public final ForgeConfigSpec.IntValue AzuriumOreMax;
	public final ForgeConfigSpec.IntValue AzuriumOreChance;
	
	//Misc
	public final ForgeConfigSpec.IntValue UseCountFlintAndAzurium;
	public final ForgeConfigSpec.BooleanValue FoilDiamondApple;
	public final ForgeConfigSpec.IntValue AzuriumArmorDurability;
	public final ForgeConfigSpec.IntValue AzuriumArmorEnchantability;
	public final ForgeConfigSpec.IntValue AzuriumToolDurability;
	public final ForgeConfigSpec.IntValue AzuriumToolEnchantability;
	public final ForgeConfigSpec.IntValue MilathiumArmorDurability;
	public final ForgeConfigSpec.IntValue MilathiumArmorEnchantability;
	public final ForgeConfigSpec.IntValue MilathiumToolDurability;
	public final ForgeConfigSpec.IntValue MilathiumToolEnchantability;
	public final ForgeConfigSpec.IntValue UseCountFlintAndMilathium;
	
    public final StructureConfig HeartEnderShip;
    public final StructureConfig HeartofEnderFortress;

    //Quark
	public final ForgeConfigSpec.BooleanValue quarkCompat;
	public final ForgeConfigSpec.BooleanValue quarkChestModule;

    //Charm
	public final ForgeConfigSpec.BooleanValue charmCompat;
	public final ForgeConfigSpec.BooleanValue charmBarrelModule;

    //Aquaculture
	public final ForgeConfigSpec.BooleanValue aquacultureCompat;
	
	public final ForgeConfigSpec.BooleanValue MoreCraftingTablesCompat;
	
	public final ForgeConfigSpec.BooleanValue NoTreePunchingCompat;

	public HoeServerConfig(final ForgeConfigSpec.Builder build)
	{
		build.comment("Heart of Ender Config File !");
		
		build.push("Overworld");
		this.generateAzuriumOre = boolBuilder(build, "Generate Azurium Ore", "Overworld", true, "Activate or deactivate the generation of Azurium in the world.");
		this.YmaxAzuriumOre = intBuilder(build, "Azurium Ore Y Max", "Overworld", 20, 1, Integer.MAX_VALUE, "Maximal layer or Azurium Ore can be generated.");
		this.AzuriumOreMax = intBuilder(build, "Azurium Max Density",  "Overworld", 5, 1, Integer.MAX_VALUE, "Maximum number of Azurium Minerals in one generation.");
		this.AzuriumOreChance = intBuilder(build, "Azurium Ore Chance",  "Overworld", 8, 1, Integer.MAX_VALUE, "Chance to generate Azurium in the World.");
		
		build.pop();
		build.push("Misc");
		this.UseCountFlintAndAzurium = intBuilder(build, "Flint and Azurium Use Max", "Misc", 64, 1, Integer.MAX_VALUE, "Maximum number of uses for the Flint and Azurium.");
		this.FoilDiamondApple = boolBuilder(build, "Foil Diamand Apple ?", "Misc", true, "Enable or Disable the effects of enchantments on the Diamond Apple.");
		this.AzuriumArmorDurability = intBuilder(build, "Azurium Armor Durability", "Misc", 250, 1, Integer.MAX_VALUE, "Durability of Azurium Armor.");
		this.AzuriumArmorEnchantability = intBuilder(build, "Azurium Armor Enchantability", "Misc", 50, 1, Integer.MAX_VALUE, "Enchantability of Azurium Armor.");
		this.AzuriumToolDurability = intBuilder(build, "Azurium Tools Durability", "Misc", 3000, 1, Integer.MAX_VALUE, "Durability of Azurium Tools.");
		this.AzuriumToolEnchantability = intBuilder(build, "Azurium Tools Enchantability", "Misc", 50, 1, Integer.MAX_VALUE, "Enchantability of Azurium Tools.");
		this.MilathiumArmorDurability = intBuilder(build, "Milathium Armor Durability", "Misc", 500, 1, Integer.MAX_VALUE, "Durability of Milathium Armor.");
		this.MilathiumArmorEnchantability = intBuilder(build, "Milathium Armor Enchantability", "Misc", 20, 1, Integer.MAX_VALUE, "Enchantability of Milathium Armor.");
		this.MilathiumToolDurability = intBuilder(build, "Milathium Tools Durability", "Misc", 6000, 1, Integer.MAX_VALUE, "Durability of Milathium Tools.");
		this.MilathiumToolEnchantability = intBuilder(build, "Milathium Tools Enchantability", "Misc", 20, 1, Integer.MAX_VALUE, "Enchantability of Milathium Tools.");
		this.UseCountFlintAndMilathium = intBuilder(build, "Flint and Milathium Use Max", "Misc", 128, 1, Integer.MAX_VALUE, "Maximum number of uses for the Flint and Milathium.");

		build.pop();
		build.push("Structures");
		this.HeartEnderShip = structureBuilder(build, "Heart of Ender Ship", 25, 6, 2, true, "heartofender:heartofender_wastes", HoeDimensionRegistry.HEART_OF_ENDER);
		this.HeartofEnderFortress = structureBuilder(build, "Heart of Ender Fortress", 50, 6, 15, true, "heartofender:heartofender_wastes", HoeDimensionRegistry.HEART_OF_ENDER);

		build.pop();
		build.push("Compats");
		
		build.pop();
		build.push("Quark");
		this.quarkCompat = boolBuilder(build, "Quark Compat", "Quark", true, "Set to false if you want to disable all Quark compatibility blocks.");
		this.quarkChestModule = boolBuilder(build, "Quark Chest Module", "Quark", true, "Set to false if you want to disable the lilac and leafy chests.");
		
		build.pop();
		build.push("Charm");
		this.charmCompat = boolBuilder(build, "Charm Compat", "Charm", true, "Set to false if you want to disable all Charm compatibility blocks.");
		this.charmBarrelModule = boolBuilder(build, "Charm Barrel Module", "Charm", true, "Set to false if you want to disable the lilac and leafy barrels.");

		build.pop();
		build.push("Aquaculture");
		this.aquacultureCompat = boolBuilder(build, "Aquaculture Compat", "Aquaculture", true, "Set to false if you want to disable all Aquaculture compatibility items.");
		
		build.pop();
		build.push("More Crafting Tables");
		this.MoreCraftingTablesCompat = boolBuilder(build, "More Crafting Tables Compat", "More Crafting Tables", true, "Set to false if you want to disable all More Crafting Tables compatibility blocks.");
		
		build.pop();
		build.push("No Tree Punching (not available in 1.18.1)");
		this.NoTreePunchingCompat = boolBuilder(build, "No Tree Punching Compat", "No Tree Punching", true, "Set to false if you want to disable all No Tree Punching compatibility items.");
	
		build.pop();
		build.pop();
		build.push("To modify the generation data of the dimensions go through the Datapacks!");
	}
	
	public static ForgeConfigSpec.BooleanValue boolBuilder(ForgeConfigSpec.Builder build, String name, String chapter, boolean valueDefault, String desc)
	{
		return build.comment(desc).translation(name).define(name, valueDefault);
	}
	
	public static ForgeConfigSpec.IntValue intBuilder(ForgeConfigSpec.Builder builder, String name, String catagory, int defaultValue, int min, int max, String desc)
	{
        return builder.comment(desc).translation(name).defineInRange(name, defaultValue, min, max);
	}
	
	public static ForgeConfigSpec.DoubleValue doubleBuilder(ForgeConfigSpec.Builder builder, String name, String catagory, double defaultValue, double min, double max, String desc)
	{
        return builder.comment(desc).translation(name).defineInRange(name, defaultValue, min, max);
	}
	
	public StructureConfig structureBuilder(ForgeConfigSpec.Builder builder, String name, int spacing, int off, int prob, boolean isWhite, String biomes, ResourceKey<Level> heartOfEnder)
	{
        return new StructureConfig(builder, name).probability(prob).spacing(spacing).offset(off).biomes(isWhite, biomes).validDimensions(heartOfEnder.location().toString());
    }
}