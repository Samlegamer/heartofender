package fr.samlegamer.heartofender.world.biomes;

import fr.samlegamer.heartofender.core.References;
import fr.samlegamer.heartofender.entity.EntityBlueMagmaBlock;
import fr.samlegamer.heartofender.entity.EntityEnderKid;
import fr.samlegamer.heartofender.entity.EntityHeartGhast;
import fr.samlegamer.heartofender.inits.BlocksMod;
import net.minecraft.entity.monster.EntityGhast;
import net.minecraft.world.biome.Biome;

public class DarkBiome extends Biome
{
	public DarkBiome()
	{
		super(new BiomeProperties("Dark").setBaseHeight(1.0F).setHeightVariation(1.0F).setRainDisabled().setTemperature(18.0F));
		this.spawnableMonsterList.clear();
        this.spawnableCreatureList.clear();
        this.spawnableWaterCreatureList.clear();
        this.spawnableCaveCreatureList.clear();
        this.topBlock = BlocksMod.dark_end_stone.getDefaultState();
		this.fillerBlock = BlocksMod.dark_end_stone.getDefaultState();
        this.spawnableMonsterList.add(new Biome.SpawnListEntry(EntityEnderKid.class, 60, 4, 8));
        this.spawnableMonsterList.add(new Biome.SpawnListEntry(EntityHeartGhast.class, 8, 1, 2));
        this.spawnableMonsterList.add(new Biome.SpawnListEntry(EntityBlueMagmaBlock.class, 8, 1, 2));
		
		this.setRegistryName(References.MODID, "Dark Biome");
	}
	
	@Override
	public int getSkyColorByTemp(float currentTemperature)
	{
		return 0x00ff00;
	}
}