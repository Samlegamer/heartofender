package fr.samlegamer.heartofender.utils.config;

import net.minecraftforge.common.config.Configuration;

public class HoeConfig
{
	//world
	public static boolean azuriumGen = true;
	public static int azuriumDens = 5;
	public static int azuriumminY = 5;
	public static int azuriummaxY = 12;
	
	//entity
	public static boolean enableEnderKid = true;
	public static boolean enableHerobrine = true;
	public static boolean enableHeartGhast = true;
	public static boolean enableHeartBlaze = true;
	public static boolean enableBlueMagmaBlock = true;
	public static boolean enableHeartSkeleton = true;
	
	//misc
	public static boolean enableAzuriumFurnaceRecipe = true;
	public static boolean enableMilathiumFurnaceRecipe = true;
	public static boolean enableDiamondApple = true;
	public static boolean enableIronApple = true;
	public static boolean enableLapisApple = true;
	public static boolean enableRedstoneApple = true;
	public static int azuriumArmorDurability = 250;
	public static int milathiumArmorDurability = 500;
	public static int azuriumToolDurability = 3000;
	public static int milathiumToolDurability = 6000;
 
	//dimension
	public static int heartofenderDimID = 2;
	
	public void init(Configuration config)
	{
		//world
		this.azuriumGen = config.getBoolean("Generate Azurium", "world", true, "Generate azurium ore in the world");
		this.azuriumDens = config.getInt("Azurium Density", "world", 5, 1, Integer.MAX_VALUE, "Percent of chance generate Azurium (require enable azurium)");
		this.azuriumminY = config.getInt("Azurium Gen min Y", "world", 5, 1, Integer.MAX_VALUE, "Min Y to generate azurium ore");
		this.azuriummaxY = config.getInt("Azurium Gen max Y", "world", 12, 1, Integer.MAX_VALUE, "Max Y to generate azurium ore");

		//entity
		this.enableEnderKid = config.getBoolean("Ender Kid", "entity", true, "Enable Ender Kid Entity");
		this.enableHerobrine = config.getBoolean("Herobrine", "entity", true, "Enable Herobrine Entity (altar and entity)");
		this.enableHeartGhast = config.getBoolean("Heart Ghast", "entity", true, "Enable Heart Ghast Entity");
		this.enableHeartBlaze = config.getBoolean("Heart Blaze", "entity", true, "Enable Heart Blaze Entity");
		this.enableBlueMagmaBlock = config.getBoolean("Blue Magma Block", "entity", true, "Enable Blue Magma Block Entity");
		this.enableHeartSkeleton = config.getBoolean("Heart Skeleton", "entity", true, "Enable Heart Skeleton Entity");

		//misc
		this.enableAzuriumFurnaceRecipe = config.getBoolean("Azurium Furnace Recipe", "misc", true, "Enable Furnace Recipe with Azurium Ore");
		this.enableMilathiumFurnaceRecipe = config.getBoolean("Milathium Furnace Recipe", "misc", true, "Enable Furnace Recipe with Milathium Ore");
		this.enableDiamondApple = config.getBoolean("Diamond Apple", "misc", true, "Enable Diamond Apple ?");
		this.enableIronApple = config.getBoolean("Iron Apple", "misc", true, "Enable Iron Apple ?");
		this.enableLapisApple = config.getBoolean("Lapis Apple", "misc", true, "Enable Lapis Apple ?");
		this.enableRedstoneApple = config.getBoolean("Redstone Apple", "misc", true, "Enable Redstone Apple ?");
		this.azuriumArmorDurability = config.getInt("Armor Azurium Durability", "misc", 250, 1, Integer.MAX_VALUE, "Durability of Azurium Armors");
		this.milathiumArmorDurability = config.getInt("Armor Milathium Durability", "misc", 500, 1, Integer.MAX_VALUE, "Durability of Milathium Armors");
		this.azuriumToolDurability = config.getInt("Tools Azurium Durability", "misc", 3000, 1, Integer.MAX_VALUE, "Durability of Azurium Tools");
		this.milathiumToolDurability = config.getInt("Tools Milathium Durability", "misc", 6000, 1, Integer.MAX_VALUE, "Durability of Milathium Tools");
		
		//dimension
		this.heartofenderDimID = config.getInt("Heart of Ender Dim ID", "dimension", 2, 1, Integer.MAX_VALUE, "ID of the Heart of Ender Dimension");

	}
}