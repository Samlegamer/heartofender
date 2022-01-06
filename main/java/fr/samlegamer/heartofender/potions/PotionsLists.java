package fr.samlegamer.heartofender.potions;

import fr.samlegamer.heartofender.core.HeartofEnder;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.potion.Potion;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class PotionsLists
{
	public static final DeferredRegister<Potion> POTIONS_REGISTRY = DeferredRegister.create(ForgeRegistries.POTION_TYPES, HeartofEnder.MODID);

	public static final RegistryObject<Potion> HEAL_BOOST_III = POTIONS_REGISTRY.register("heal_boost_iii", () -> new Potion(new EffectInstance(Effects.HEAL, 1, 2)));
	public static final RegistryObject<Potion> SPEED_III = POTIONS_REGISTRY.register("speed_iii", () -> new Potion(new EffectInstance(Effects.MOVEMENT_SPEED, 3600, 2)));
	public static final RegistryObject<Potion> REGENERATION_III = POTIONS_REGISTRY.register("regeneration_iii", () -> new Potion(new EffectInstance(Effects.REGENERATION, 3600, 2)));
	public static final RegistryObject<Potion> STRENGH_III = POTIONS_REGISTRY.register("strength_iii", () -> new Potion(new EffectInstance(Effects.DAMAGE_BOOST, 3600, 2)));
	public static final RegistryObject<Potion> SLOWNESS_III = POTIONS_REGISTRY.register("slowness_iii", () -> new Potion(new EffectInstance(Effects.MOVEMENT_SLOWDOWN, 3600, 2)));
	public static final RegistryObject<Potion> JUMP_III = POTIONS_REGISTRY.register("jump_boost_iii", () -> new Potion(new EffectInstance(Effects.JUMP, 3600, 2)));
	public static final RegistryObject<Potion> POISON_III = POTIONS_REGISTRY.register("poison_iii", () -> new Potion(new EffectInstance(Effects.POISON, 3600, 2)));
}