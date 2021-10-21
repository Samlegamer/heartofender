package fr.samlegamer.heartofender.utils.config;

import net.minecraftforge.common.config.Configuration;

public class HoeConfig
{
	//world
	public static boolean azuriumGen = true;
	public static int azuriumDens = 5;
	public static int azuriumminY = 5;
	public static int azuriummaxY = 12;
	
	//misc
	public static int azuriumArmorDurability = 250;
	public static int milathiumArmorDurability = 500;
	public static int azuriumToolDurability = 3000;
	public static int milathiumToolDurability = 6000;
	public static int heartBonesToolDurability = 1000;
 
	//dimension
	//public static int heartofenderDimID = 2;
	
	public static int enderkid_spawn_chance = 60;
	public static int enderkid_spawn_min = 4;
	public static int enderkid_spawn_max = 8;
	
	public static int heart_ghast_spawn_chance = 8;
	public static int heart_ghast_spawn_min = 1;
	public static int heart_ghast_spawn_max = 3;

	public static int blue_magma_block_spawn_chance = 8;
	public static int blue_magma_block_spawn_min = 1;
	public static int blue_magma_block_spawn_max = 2;
	
	public static int heart_blaze_spawn_chance = 13;
	public static int heart_blaze_spawn_min = 2;
	public static int heart_blaze_spawn_max = 5;

	public static int heart_skeleton_spawn_chance = 4;
	public static int heart_skeleton_spawn_min = 1;
	public static int heart_skeleton_spawn_max = 3;
	
	public static int milathium_ore_density = 5;
	public static int blue_magma_density = 33;

	public void init(Configuration config)
	{
		//world
		this.azuriumGen = config.getBoolean("Generate Azurium", "world", true, "Generate azurium ore in the world");
		this.azuriumDens = config.getInt("Azurium Density", "world", 5, 1, Integer.MAX_VALUE, "Percent of chance generate Azurium (require enable azurium)");
		this.azuriumminY = config.getInt("Azurium Gen min Y", "world", 5, 1, Integer.MAX_VALUE, "Min Y to generate azurium ore");
		this.azuriummaxY = config.getInt("Azurium Gen max Y", "world", 12, 1, Integer.MAX_VALUE, "Max Y to generate azurium ore");
		
		//misc
		this.azuriumArmorDurability = config.getInt("Armor Azurium Durability", "misc", 250, 1, Integer.MAX_VALUE, "Durability of Azurium Armors");
		this.milathiumArmorDurability = config.getInt("Armor Milathium Durability", "misc", 500, 1, Integer.MAX_VALUE, "Durability of Milathium Armors");
		this.azuriumToolDurability = config.getInt("Tools Azurium Durability", "misc", 3000, 1, Integer.MAX_VALUE, "Durability of Azurium Tools");
		this.milathiumToolDurability = config.getInt("Tools Milathium Durability", "misc", 6000, 1, Integer.MAX_VALUE, "Durability of Milathium Tools");
		this.milathiumToolDurability = config.getInt("Tools Heart Bone Durability", "misc", 1000, 1, Integer.MAX_VALUE, "Durability of Heart Bone Tools");
		
		//dimension
		//this.heartofenderDimID = config.getInt("Heart of Ender Dim ID", "dimension", 2, 1, Integer.MAX_VALUE, "ID of the Heart of Ender Dimension");
		
		this.enderkid_spawn_chance = config.getInt("Ender Kid Spawn Chance", "dimension", 60, 1, Integer.MAX_VALUE, "Spawn Ender Kid in Heart of Ender");
		this.enderkid_spawn_min = config.getInt("Ender Kid Group Spawn min", "dimension", 4, 1, Integer.MAX_VALUE, "Spawn of minimum groups of Ender Kid");
		this.enderkid_spawn_max = config.getInt("Ender Kid Group Spawn max", "dimension", 8, 1, Integer.MAX_VALUE, "Spawn of maximum groups of Ender Kid");
		
		this.heart_ghast_spawn_chance = config.getInt("Heart Ghast Spawn Chance", "dimension", 8, 1, Integer.MAX_VALUE, "Spawn Heart Ghast in Heart of Ender");
		this.heart_ghast_spawn_min = config.getInt("Heart Ghast Group Spawn min", "dimension", 1, 1, Integer.MAX_VALUE, "Spawn of minimum groups of Heart Ghast");
		this.heart_ghast_spawn_max = config.getInt("Heart Ghast Group Spawn max", "dimension", 3, 1, Integer.MAX_VALUE, "Spawn of maximum groups of Heart Ghast");
		
		this.blue_magma_block_spawn_chance = config.getInt("Blue Magma Block Spawn Chance", "dimension", 8, 1, Integer.MAX_VALUE, "Spawn Blue Magma Block in Heart of Ender");
		this.blue_magma_block_spawn_min = config.getInt("Blue Magma Block Group Spawn min", "dimension", 1, 1, Integer.MAX_VALUE, "Spawn of minimum groups of Blue Magma Block");
		this.blue_magma_block_spawn_max = config.getInt("Blue Magma Block Group Spawn max", "dimension", 2, 1, Integer.MAX_VALUE, "Spawn of maximum groups of Blue Magma Block");

		this.heart_blaze_spawn_chance = config.getInt("Heart Blaze Spawn Chance", "dimension", 13, 1, Integer.MAX_VALUE, "Spawn Heart Blaze in Heart of Ender");
		this.heart_blaze_spawn_min = config.getInt("Heart Blaze Group Spawn min", "dimension", 2, 1, Integer.MAX_VALUE, "Spawn of minimum groups of Heart Blaze");
		this.heart_blaze_spawn_max = config.getInt("Heart Blaze Group Spawn max", "dimension", 5, 1, Integer.MAX_VALUE, "Spawn of maximum groups of Heart Blaze");

		this.heart_skeleton_spawn_chance = config.getInt("Heart Skeleton Spawn Chance", "dimension", 4, 1, Integer.MAX_VALUE, "Spawn Heart Skeleton in Heart of Ender");
		this.heart_skeleton_spawn_min = config.getInt("Heart Skeleton Group Spawn min", "dimension", 1, 1, Integer.MAX_VALUE, "Spawn of minimum groups of Heart Skeleton");
		this.heart_skeleton_spawn_max = config.getInt("Heart Skeleton Group Spawn max", "dimension", 3, 1, Integer.MAX_VALUE, "Spawn of maximum groups of Heart Skeleton");
		
		this.milathium_ore_density = config.getInt("Milathium Ore Density", "dimension", 5, 1, Integer.MAX_VALUE, "Chance to generate the Milathium Ore in Heart of Ender");
		this.blue_magma_density = config.getInt("Blue Magma Density", "dimension", 33, 1, Integer.MAX_VALUE, "Chance to generate the Blue Magma Block in Heart of Ender");
	}
}