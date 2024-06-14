package fr.samlegamer.heartofender.config;

import net.minecraftforge.fml.config.ModConfig;

public class HoeConfig
{
	public static boolean generateAzuriumOre = true;
	public static int YmaxAzuriumOre = 10;
	public static int YminAzuriumOre = 6;
	public static int AzuriumOreMax = 5;
	public static int AzuriumOreChance = 4;
	
	public static int UseCountFlintAndAzurium = 64;
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
			generateAzuriumOre = ConfigFileHeartofEnder.SERVER.generateAzuriumOre.get();
			YmaxAzuriumOre = ConfigFileHeartofEnder.SERVER.YmaxAzuriumOre.get();
			YminAzuriumOre = ConfigFileHeartofEnder.SERVER.YminAzuriumOre.get();
			YmaxAzuriumOre = ConfigFileHeartofEnder.SERVER.AzuriumOreMax.get();
			YminAzuriumOre = ConfigFileHeartofEnder.SERVER.AzuriumOreChance.get();
			UseCountFlintAndAzurium = ConfigFileHeartofEnder.SERVER.UseCountFlintAndAzurium.get();
			AzuriumArmorDurability = ConfigFileHeartofEnder.SERVER.AzuriumArmorDurability.get();
			AzuriumArmorEnchantability = ConfigFileHeartofEnder.SERVER.AzuriumArmorEnchantability.get();
			AzuriumToolDurability = ConfigFileHeartofEnder.SERVER.AzuriumToolDurability.get();
			AzuriumToolEnchantability = ConfigFileHeartofEnder.SERVER.AzuriumToolEnchantability.get();
			MilathiumArmorDurability = ConfigFileHeartofEnder.SERVER.MilathiumArmorDurability.get();
			MilathiumArmorEnchantability = ConfigFileHeartofEnder.SERVER.MilathiumArmorEnchantability.get();
			MilathiumToolDurability = ConfigFileHeartofEnder.SERVER.MilathiumToolDurability.get();
			MilathiumToolEnchantability = ConfigFileHeartofEnder.SERVER.MilathiumToolEnchantability.get();
			BlueMagmaCubeExp = ConfigFileHeartofEnder.SERVER.BlueMagmaCubeExp.get();
			BlueMagmaCubeMovementSpeed = ConfigFileHeartofEnder.SERVER.BlueMagmaCubeMovementSpeed.get();
			BlueMagmaCubeMaxHealth = ConfigFileHeartofEnder.SERVER.BlueMagmaCubeMaxHealth.get();
			BlueMagmaCubeAttackDamage = ConfigFileHeartofEnder.SERVER.BlueMagmaCubeAttackDamage.get();
			EnderKidExp = ConfigFileHeartofEnder.SERVER.EnderKidExp.get();
			EnderKidMovementSpeed = ConfigFileHeartofEnder.SERVER.EnderKidMovementSpeed.get();
			EnderKidMaxHealth = ConfigFileHeartofEnder.SERVER.EnderKidMaxHealth.get();
			EnderKidAttackDamage = ConfigFileHeartofEnder.SERVER.EnderKidAttackDamage.get();
			HeartBlazeExp = ConfigFileHeartofEnder.SERVER.HeartBlazeExp.get();
			HeartBlazeMaxHealth = ConfigFileHeartofEnder.SERVER.HeartBlazeMaxHealth.get();
			HeartBlazeArmor = ConfigFileHeartofEnder.SERVER.HeartBlazeArmor.get();
			HeartBlazeAttackDamage = ConfigFileHeartofEnder.SERVER.HeartBlazeAttackDamage.get();
			HeartBlazeMovementSpeed = ConfigFileHeartofEnder.SERVER.HeartBlazeMovementSpeed.get();
			HeartGhastExp = ConfigFileHeartofEnder.SERVER.HeartGhastExp.get();
			HeartGhastMaxHealth = ConfigFileHeartofEnder.SERVER.HeartGhastMaxHealth.get();
			HeartSkeletonExp = ConfigFileHeartofEnder.SERVER.HeartSkeletonExp.get();
			HeartSkeletonMaxHealth = ConfigFileHeartofEnder.SERVER.HeartSkeletonMaxHealth.get();
			HeartSkeletonArmor = ConfigFileHeartofEnder.SERVER.HeartSkeletonArmor.get();
			HeartSkeletonAttackDamage = ConfigFileHeartofEnder.SERVER.HeartSkeletonAttackDamage.get();
			HeartSkeletonMovementSpeed = ConfigFileHeartofEnder.SERVER.HeartSkeletonMovementSpeed.get();
			HerobrineExp = ConfigFileHeartofEnder.SERVER.HerobrineExp.get();
			HerobrineMaxHealth = ConfigFileHeartofEnder.SERVER.HerobrineMaxHealth.get();
			HerobrineAttackDamage = ConfigFileHeartofEnder.SERVER.HerobrineAttackDamage.get();
			HerobrineMovementSpeed = ConfigFileHeartofEnder.SERVER.HerobrineMovementSpeed.get();

		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}