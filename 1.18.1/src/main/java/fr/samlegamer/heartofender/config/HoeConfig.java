package fr.samlegamer.heartofender.config;

import net.minecraftforge.fml.config.ModConfig;

public class HoeConfig
{
	public static boolean generateAzuriumOre = true;
	public static int YmaxAzuriumOre = 20;
	public static int AzuriumOreMax = 5;
	public static int AzuriumOreChance = 8;
	
	public static int UseCountFlintAndAzurium = 64;
	public static boolean FoilDiamondApple = true;
	public static int AzuriumArmorDurability = 250;
	public static int AzuriumArmorEnchantability = 50;
	public static int AzuriumToolDurability = 3000;
	public static int AzuriumToolEnchantability = 50;
	public static int MilathiumArmorDurability = 500;
	public static int MilathiumArmorEnchantability = 20;
	public static int MilathiumToolDurability = 6000;
	public static int MilathiumToolEnchantability = 20;
	public static int UseCountFlintAndMilathium = 128;

	//Quark
	public static boolean quarkCompat = true;
	public static boolean quarkChestModule = true;
	
	//Charm
	public static boolean charmCompat = true;
	public static boolean charmBarrelModule = true;

    //Aquaculture
	public static boolean aquacultureCompat = true;

	//MoreCraftingTables
	public static boolean MoreCraftingTablesCompat = true;
	
	//NTP
	public static boolean NoTreePunchingCompat = true;

	public static void serverInit(final ModConfig config)
	{
		try
		{
			generateAzuriumOre = HoeConfigsRegistry.SERVER.generateAzuriumOre.get();
			YmaxAzuriumOre = HoeConfigsRegistry.SERVER.YmaxAzuriumOre.get();
			AzuriumOreMax = HoeConfigsRegistry.SERVER.AzuriumOreMax.get();
			AzuriumOreChance = HoeConfigsRegistry.SERVER.AzuriumOreChance.get();
			UseCountFlintAndAzurium = HoeConfigsRegistry.SERVER.UseCountFlintAndAzurium.get();
			FoilDiamondApple = HoeConfigsRegistry.SERVER.FoilDiamondApple.get();
			AzuriumArmorDurability = HoeConfigsRegistry.SERVER.AzuriumArmorDurability.get();
			AzuriumArmorEnchantability = HoeConfigsRegistry.SERVER.AzuriumArmorEnchantability.get();
			AzuriumToolDurability = HoeConfigsRegistry.SERVER.AzuriumToolDurability.get();
			AzuriumToolEnchantability = HoeConfigsRegistry.SERVER.AzuriumToolEnchantability.get();
			MilathiumArmorDurability = HoeConfigsRegistry.SERVER.MilathiumArmorDurability.get();
			MilathiumArmorEnchantability = HoeConfigsRegistry.SERVER.MilathiumArmorEnchantability.get();
			MilathiumToolDurability = HoeConfigsRegistry.SERVER.MilathiumToolDurability.get();
			MilathiumToolEnchantability = HoeConfigsRegistry.SERVER.MilathiumToolEnchantability.get();
			UseCountFlintAndMilathium = HoeConfigsRegistry.SERVER.UseCountFlintAndMilathium.get();
			
			//Quark
			quarkCompat = HoeConfigsRegistry.SERVER.quarkCompat.get();
			quarkChestModule = HoeConfigsRegistry.SERVER.quarkChestModule.get();
			
			//Charm
			charmCompat = HoeConfigsRegistry.SERVER.charmCompat.get();
			charmBarrelModule = HoeConfigsRegistry.SERVER.charmBarrelModule.get();

			//Aquaculture
			aquacultureCompat = HoeConfigsRegistry.SERVER.aquacultureCompat.get();

			MoreCraftingTablesCompat = HoeConfigsRegistry.SERVER.MoreCraftingTablesCompat.get();
			
			NoTreePunchingCompat = HoeConfigsRegistry.SERVER.NoTreePunchingCompat.get();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}