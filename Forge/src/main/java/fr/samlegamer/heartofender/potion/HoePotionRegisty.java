package fr.samlegamer.heartofender.potion;

import fr.samlegamer.heartofender.core.HeartofEnder;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.item.alchemy.Potion;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class HoePotionRegisty
{
	public static final DeferredRegister<Potion> REGISTRY_POTIONS = DeferredRegister.create(ForgeRegistries.POTIONS, HeartofEnder.MODID);

	public static final RegistryObject<Potion> HEAL_BOOST_III = REGISTRY_POTIONS.register("heal_boost_iii", () -> new Potion(new MobEffectInstance(MobEffects.HEAL, 1, 2)));
	public static final RegistryObject<Potion> SPEED_III = REGISTRY_POTIONS.register("speed_iii", () -> new Potion(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 3600, 2)));
	public static final RegistryObject<Potion> REGENERATION_III = REGISTRY_POTIONS.register("regeneration_iii", () -> new Potion(new MobEffectInstance(MobEffects.REGENERATION, 3600, 2)));
	public static final RegistryObject<Potion> STRENGH_III = REGISTRY_POTIONS.register("strength_iii", () -> new Potion(new MobEffectInstance(MobEffects.DAMAGE_BOOST, 3600, 2)));
	public static final RegistryObject<Potion> SLOWNESS_III = REGISTRY_POTIONS.register("slowness_iii", () -> new Potion(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 3600, 2)));
	public static final RegistryObject<Potion> JUMP_III = REGISTRY_POTIONS.register("jump_boost_iii", () -> new Potion(new MobEffectInstance(MobEffects.JUMP, 3600, 2)));
	public static final RegistryObject<Potion> POISON_III = REGISTRY_POTIONS.register("poison_iii", () -> new Potion(new MobEffectInstance(MobEffects.POISON, 3600, 2)));
}