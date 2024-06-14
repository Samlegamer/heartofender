package fr.samlegamer.heartofender.config;

import com.legacy.structure_gel.util.ConfigTemplates.StructureConfig;

import fr.samlegamer.heartofender.inits.ModDimension;
import net.minecraft.util.RegistryKey;
import net.minecraft.world.World;
import net.minecraftforge.common.ForgeConfigSpec;

public class ServerConfig
{
	//Overworld
	public final ForgeConfigSpec.BooleanValue generateAzuriumOre;
	public final ForgeConfigSpec.IntValue YmaxAzuriumOre;
	public final ForgeConfigSpec.IntValue YminAzuriumOre;
	public final ForgeConfigSpec.IntValue AzuriumOreMax;
	public final ForgeConfigSpec.IntValue AzuriumOreChance;
	
	//Misc
	public final ForgeConfigSpec.IntValue UseCountFlintAndAzurium;
	public final ForgeConfigSpec.IntValue AzuriumArmorDurability;
	public final ForgeConfigSpec.IntValue AzuriumArmorEnchantability;
	public final ForgeConfigSpec.IntValue AzuriumToolDurability;
	public final ForgeConfigSpec.IntValue AzuriumToolEnchantability;
	public final ForgeConfigSpec.IntValue MilathiumArmorDurability;
	public final ForgeConfigSpec.IntValue MilathiumArmorEnchantability;
	public final ForgeConfigSpec.IntValue MilathiumToolDurability;
	public final ForgeConfigSpec.IntValue MilathiumToolEnchantability;

	//Blue Magma Cube
	public final ForgeConfigSpec.IntValue BlueMagmaCubeExp;
	public final ForgeConfigSpec.DoubleValue BlueMagmaCubeMovementSpeed;
	public final ForgeConfigSpec.DoubleValue BlueMagmaCubeMaxHealth;
	public final ForgeConfigSpec.DoubleValue BlueMagmaCubeAttackDamage;	
	
	//Ender Kid
	public final ForgeConfigSpec.IntValue EnderKidExp;
	public final ForgeConfigSpec.DoubleValue EnderKidMovementSpeed;
	public final ForgeConfigSpec.DoubleValue EnderKidMaxHealth;
	public final ForgeConfigSpec.DoubleValue EnderKidAttackDamage;	

	//Heart Blaze
	public final ForgeConfigSpec.IntValue HeartBlazeExp;
	public final ForgeConfigSpec.DoubleValue HeartBlazeMaxHealth;
	public final ForgeConfigSpec.DoubleValue HeartBlazeArmor;
	public final ForgeConfigSpec.DoubleValue HeartBlazeAttackDamage;	
	public final ForgeConfigSpec.DoubleValue HeartBlazeMovementSpeed;

	//Heart Ghast
	public final ForgeConfigSpec.IntValue HeartGhastExp;
	public final ForgeConfigSpec.DoubleValue HeartGhastMaxHealth;

	//Heart Skeleton
	public final ForgeConfigSpec.IntValue HeartSkeletonExp;
	public final ForgeConfigSpec.DoubleValue HeartSkeletonMaxHealth;
	public final ForgeConfigSpec.DoubleValue HeartSkeletonArmor;
	public final ForgeConfigSpec.DoubleValue HeartSkeletonAttackDamage;	
	public final ForgeConfigSpec.DoubleValue HeartSkeletonMovementSpeed;
	
	//Herobrine
	public final ForgeConfigSpec.IntValue HerobrineExp;
	public final ForgeConfigSpec.DoubleValue HerobrineMaxHealth;
	public final ForgeConfigSpec.DoubleValue HerobrineAttackDamage;	
	public final ForgeConfigSpec.DoubleValue HerobrineMovementSpeed;	
	
    public final StructureConfig HeartEnderShip;
    
	public ServerConfig(final ForgeConfigSpec.Builder build)
	{
		build.comment("Heart of Ender Config File !");
		
		build.push("Overworld");
		this.generateAzuriumOre = boolBuilder(build, "Generate Azurium Ore", "Overworld", true, "Activate or deactivate the generation of Azurium in the world.");
		this.YmaxAzuriumOre = intBuilder(build, "Azurium Ore Y Max", "Overworld", 10, 1, Integer.MAX_VALUE, "Maximal layer or Azurium Ore can be generated.");
		this.YminAzuriumOre = intBuilder(build, "Azurium Ore Y Min", "Overworld", 6, 1, Integer.MAX_VALUE, "Minimal layer or Azurium Ore can be generated.");
		this.AzuriumOreMax = intBuilder(build, "Azurium Max Density",  "Overworld", 5, 1, Integer.MAX_VALUE, "Maximum number of Azurium Minerals in one generation.");
		this.AzuriumOreChance = intBuilder(build, "Azurium Ore Chance",  "Overworld", 4, 1, Integer.MAX_VALUE, "Chance to generate Azurium in the World.");
		
		build.pop();
		build.push("Misc");
		this.UseCountFlintAndAzurium = intBuilder(build, "Flint and Azurium Use Max", "Misc", 64, 1, Integer.MAX_VALUE, "Maximum number of uses for the Flint and Azurium.");
		this.AzuriumArmorDurability = intBuilder(build, "Azurium Armor Durability", "Misc", 250, 1, Integer.MAX_VALUE, "Durability of Azurium Armor.");
		this.AzuriumArmorEnchantability = intBuilder(build, "Azurium Armor Enchantability", "Misc", 50, 1, Integer.MAX_VALUE, "Enchantability of Azurium Armor.");
		this.AzuriumToolDurability = intBuilder(build, "Azurium Tools Durability", "Misc", 3000, 1, Integer.MAX_VALUE, "Durability of Azurium Tools.");
		this.AzuriumToolEnchantability = intBuilder(build, "Azurium Tools Enchantability", "Misc", 50, 1, Integer.MAX_VALUE, "Enchantability of Azurium Tools.");
		this.MilathiumArmorDurability = intBuilder(build, "Milathium Armor Durability", "Misc", 500, 1, Integer.MAX_VALUE, "Durability of Milathium Armor.");
		this.MilathiumArmorEnchantability = intBuilder(build, "Milathium Armor Enchantability", "Misc", 20, 1, Integer.MAX_VALUE, "Enchantability of Milathium Armor.");
		this.MilathiumToolDurability = intBuilder(build, "Milathium Tools Durability", "Misc", 6000, 1, Integer.MAX_VALUE, "Durability of Milathium Tools.");
		this.MilathiumToolEnchantability = intBuilder(build, "Milathium Tools Enchantability", "Misc", 20, 1, Integer.MAX_VALUE, "Enchantability of Milathium Tools.");

		build.pop();
		build.push("Entities");
		
		build.pop();
		build.push("Blue Magma Cube");
		this.BlueMagmaCubeExp = intBuilder(build, "Blue Magma Cube Experience", "Entities", 8, 1, Integer.MAX_VALUE, "Number of experience that the Blue Magma Cube leaves at its death.");
		this.BlueMagmaCubeMovementSpeed = doubleBuilder(build, "Blue Magma Cube Movement Speed", "Entities", 0.4, 1, Double.MAX_VALUE, "The maximum speed of the Blue Magma Cube.");
		this.BlueMagmaCubeMaxHealth = doubleBuilder(build, "Blue Magma Cube Max Health", "Entities", 40.0, 1, Double.MAX_VALUE, "The max life of the Blue Magma Cube.");
		this.BlueMagmaCubeAttackDamage = doubleBuilder(build, "Blue Magma Cube Attack Damage", "Entities", 12.0, 1, Double.MAX_VALUE, "The max attack of the Blue Magma Cube.");
		
		build.pop();
		build.push("Ender Kid");
		this.EnderKidExp = intBuilder(build, "Ender Kid Experience", "Entities", 6, 1, Integer.MAX_VALUE, "Number of experience that the Ender Kid leaves at its death.");
		this.EnderKidMovementSpeed = doubleBuilder(build, "Ender Kid Movement Speed", "Entities", 0.30000001192092898, 1, Double.MAX_VALUE, "The maximum speed of the Ender Kid.");
		this.EnderKidMaxHealth = doubleBuilder(build, "Ender Kid Max Health", "Entities", 50.0, 1, Double.MAX_VALUE, "The max life of the Ender Kid.");
		this.EnderKidAttackDamage = doubleBuilder(build, "Ender Kid Attack Damage", "Entities", 8.0, 1, Double.MAX_VALUE, "The max attack of the Ender Kid.");
		
		build.pop();
		build.push("Heart Blaze");
		this.HeartBlazeExp = intBuilder(build, "Heart Blaze Experience", "Entities", 20, 1, Integer.MAX_VALUE, "Number of experience that the Heart Blaze leaves at its death.");
		this.HeartBlazeMaxHealth = doubleBuilder(build, "Heart Blaze Max Health", "Entities", 35.0, 1, Double.MAX_VALUE, "The max life of the Heart Blaze.");
		this.HeartBlazeArmor = doubleBuilder(build, "Heart Blaze Armor", "Entities", 20.0, 1, Double.MAX_VALUE, "The max armor of the Heart Blaze.");
		this.HeartBlazeAttackDamage = doubleBuilder(build, "Heart Blaze Attack Damage", "Entities", 17.0, 1, Double.MAX_VALUE, "The max attack of the Heart Blaze.");
		this.HeartBlazeMovementSpeed = doubleBuilder(build, "Heart Blaze Movement Speed", "Entities", 0.24000000917232513, 1, Double.MAX_VALUE, "The maximum speed of the Heart Blaze.");
		
		build.pop();
		build.push("Heart Ghast");
		this.HeartGhastExp = intBuilder(build, "Heart Ghast Experience", "Entities", 20, 1, Integer.MAX_VALUE, "Number of experience that the Heart Ghast leaves at its death.");
		this.HeartGhastMaxHealth = doubleBuilder(build, "Heart Ghast Max Health", "Entities", 35.0, 1, Double.MAX_VALUE, "The max life of the Heart Ghast.");

		build.pop();
		build.push("Heart Skeleton");
		this.HeartSkeletonExp = intBuilder(build, "Heart Skeleton Experience", "Entities", 16, 1, Integer.MAX_VALUE, "Number of experience that the Heart Skeleton leaves at its death.");
		this.HeartSkeletonMaxHealth = doubleBuilder(build, "Heart Skeleton Max Health", "Entities", 35.0, 1, Double.MAX_VALUE, "The max life of the Heart Skeleton.");
		this.HeartSkeletonArmor = doubleBuilder(build, "Heart Skeleton Armor", "Entities", 13.0, 1, Double.MAX_VALUE, "The max armor of the Heart Skeleton.");
		this.HeartSkeletonAttackDamage = doubleBuilder(build, "Heart Skeleton Attack Damage", "Entities", 15.0, 1, Double.MAX_VALUE, "The max attack of the Heart Skeleton.");
		this.HeartSkeletonMovementSpeed = doubleBuilder(build, "Heart Skeleton Movement Speed", "Entities", 0.30000003192092898, 1, Double.MAX_VALUE, "The maximum speed of the Heart Skeleton.");

		build.pop();
		build.push("Herobrine");
		this.HerobrineExp = intBuilder(build, "Herobrine Experience", "Entities", 2000, 1, Integer.MAX_VALUE, "Number of experience that the Herobrine leaves at its death.");
		this.HerobrineMaxHealth = doubleBuilder(build, "Herobrine Max Health", "Entities", 1000.0, 1, Double.MAX_VALUE, "The max life of the Herobrine.");
		this.HerobrineAttackDamage = doubleBuilder(build, "Herobrine Attack Damage", "Entities", 26.0, 1, Double.MAX_VALUE, "The max attack of the Herobrine.");
		this.HerobrineMovementSpeed = doubleBuilder(build, "Herobrine Movement Speed", "Entities", 0.50000001192092898, 1, Double.MAX_VALUE, "The maximum speed of the Herobrine.");

		
		build.pop();
		build.push("Structures");
		this.HeartEnderShip = structureBuilder(build, "Heart of Ender Ship", 25, 6, 0.5, true, "heartofender:heartofender_wastes", ModDimension.HEART_OF_ENDER);
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
	
	public StructureConfig structureBuilder(ForgeConfigSpec.Builder builder, String name, int spacing, int off, double prob, boolean isWhite, String biomes, RegistryKey<World> heartOfEnder){
        return new StructureConfig(builder, name).probability(prob).spacing(spacing).offset(off).biomes(isWhite, biomes).validDimensions(heartOfEnder.location().toString());//.location().toString());
    }
}