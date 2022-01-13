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
	
	public static int BlueMagmaCubeExp = 8;
	public static double BlueMagmaCubeMovementSpeed = 0.4;
	public static double BlueMagmaCubeMaxHealth = 40.0;
	public static double BlueMagmaCubeAttackDamage = 12.0;	
	public static int EnderKidExp = 6;
	public static double EnderKidMovementSpeed = 0.30000001192092898;
	public static double EnderKidMaxHealth = 50.0;
	public static double EnderKidAttackDamage = 8.0;
	public static int HeartBlazeExp = 20;
	public static double HeartBlazeMaxHealth = 35.0;
	public static double HeartBlazeArmor = 20.0;
	public static double HeartBlazeAttackDamage = 17.0;
	public static double HeartBlazeMovementSpeed = 0.24000000917232513;
	public static int HeartGhastExp = 20;
	public static double HeartGhastMaxHealth = 35.0;
	public static int HeartSkeletonExp = 16;
	public static double HeartSkeletonMaxHealth = 35.0;
	public static double HeartSkeletonArmor = 13.0;
	public static double HeartSkeletonAttackDamage = 15.0;
	public static double HeartSkeletonMovementSpeed = 0.30000003192092898;
	public static int HerobrineExp = 2000;
	public static double HerobrineMaxHealth = 1000.0;
	public static double HerobrineAttackDamage = 26.0;
	public static double HerobrineMovementSpeed = 0.50000001192092898;

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
			BlueMagmaCubeExp = HoeConfigsRegistry.SERVER.BlueMagmaCubeExp.get();
			BlueMagmaCubeMovementSpeed = HoeConfigsRegistry.SERVER.BlueMagmaCubeMovementSpeed.get();
			BlueMagmaCubeMaxHealth = HoeConfigsRegistry.SERVER.BlueMagmaCubeMaxHealth.get();
			BlueMagmaCubeAttackDamage = HoeConfigsRegistry.SERVER.BlueMagmaCubeAttackDamage.get();
			EnderKidExp = HoeConfigsRegistry.SERVER.EnderKidExp.get();
			EnderKidMovementSpeed = HoeConfigsRegistry.SERVER.EnderKidMovementSpeed.get();
			EnderKidMaxHealth = HoeConfigsRegistry.SERVER.EnderKidMaxHealth.get();
			EnderKidAttackDamage = HoeConfigsRegistry.SERVER.EnderKidAttackDamage.get();
			HeartBlazeExp = HoeConfigsRegistry.SERVER.HeartBlazeExp.get();
			HeartBlazeMaxHealth = HoeConfigsRegistry.SERVER.HeartBlazeMaxHealth.get();
			HeartBlazeArmor = HoeConfigsRegistry.SERVER.HeartBlazeArmor.get();
			HeartBlazeAttackDamage = HoeConfigsRegistry.SERVER.HeartBlazeAttackDamage.get();
			HeartBlazeMovementSpeed = HoeConfigsRegistry.SERVER.HeartBlazeMovementSpeed.get();
			HeartGhastExp = HoeConfigsRegistry.SERVER.HeartGhastExp.get();
			HeartGhastMaxHealth = HoeConfigsRegistry.SERVER.HeartGhastMaxHealth.get();
			HeartSkeletonExp = HoeConfigsRegistry.SERVER.HeartSkeletonExp.get();
			HeartSkeletonMaxHealth = HoeConfigsRegistry.SERVER.HeartSkeletonMaxHealth.get();
			HeartSkeletonArmor = HoeConfigsRegistry.SERVER.HeartSkeletonArmor.get();
			HeartSkeletonAttackDamage = HoeConfigsRegistry.SERVER.HeartSkeletonAttackDamage.get();
			HeartSkeletonMovementSpeed = HoeConfigsRegistry.SERVER.HeartSkeletonMovementSpeed.get();
			HerobrineExp = HoeConfigsRegistry.SERVER.HerobrineExp.get();
			HerobrineMaxHealth = HoeConfigsRegistry.SERVER.HerobrineMaxHealth.get();
			HerobrineAttackDamage = HoeConfigsRegistry.SERVER.HerobrineAttackDamage.get();
			HerobrineMovementSpeed = HoeConfigsRegistry.SERVER.HerobrineMovementSpeed.get();

		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}