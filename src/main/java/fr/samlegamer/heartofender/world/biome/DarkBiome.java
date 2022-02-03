package fr.samlegamer.heartofender.world.biome;

import fr.samlegamer.heartofender.core.References;
import fr.samlegamer.heartofender.entity.*;
import fr.samlegamer.heartofender.inits.BlocksMod;
import fr.samlegamer.heartofender.utils.config.HoeConfig;
import net.minecraft.world.biome.Biome;

public class DarkBiome extends Biome
{
	public DarkBiome()
	{
		super(new BiomeProperties("dark").setBaseHeight(1.0F).setHeightVariation(1.0F).setRainDisabled().setTemperature(18.0F));
		this.spawnableMonsterList.clear();
        this.spawnableCreatureList.clear();
        this.spawnableWaterCreatureList.clear();
        this.spawnableCaveCreatureList.clear();
        this.topBlock = BlocksMod.dark_end_stone.getDefaultState();
		this.fillerBlock = BlocksMod.dark_end_stone.getDefaultState();
        this.spawnableMonsterList.add(new Biome.SpawnListEntry(EntityEnderKid.class, HoeConfig.enderkid_spawn_chance, HoeConfig.enderkid_spawn_min, HoeConfig.enderkid_spawn_max));
        this.spawnableMonsterList.add(new Biome.SpawnListEntry(EntityHeartGhast.class, HoeConfig.heart_ghast_spawn_chance, HoeConfig.heart_ghast_spawn_min, HoeConfig.heart_ghast_spawn_max));
        this.spawnableMonsterList.add(new Biome.SpawnListEntry(EntityBlueMagmaBlock.class, HoeConfig.blue_magma_block_spawn_chance, HoeConfig.blue_magma_block_spawn_min, HoeConfig.blue_magma_block_spawn_max));
        this.spawnableMonsterList.add(new Biome.SpawnListEntry(EntityHeartBlaze.class, HoeConfig.heart_blaze_spawn_chance, HoeConfig.heart_blaze_spawn_min, HoeConfig.heart_blaze_spawn_max));
        this.spawnableMonsterList.add(new Biome.SpawnListEntry(EntityHeartSkeleton.class, HoeConfig.heart_skeleton_spawn_chance, HoeConfig.heart_skeleton_spawn_min, HoeConfig.heart_skeleton_spawn_max));

		this.setRegistryName(References.MODID, "dark");
	}
	
	@Override
	public int getSkyColorByTemp(float currentTemperature)
	{
		return 0x00ff00;
	}
}