package fr.samlegamer.heartofender.structures.ship;

import fr.samlegamer.heartofender.config.ConfigFileHeartofEnder;
import fr.samlegamer.heartofender.core.HeartofEnder;
import fr.samlegamer.heartofender.structures.SimpleStructure;

/*  //Loot Tables
 * /give @p chest{BlockEntityTag:{LootTable:"modid:chests/test_table"}} 1
 */
public class HeartEnderShipStructure extends SimpleStructure
{
	public HeartEnderShipStructure()
	{
        super(ConfigFileHeartofEnder.SERVER.HeartEnderShip);
        MainPiece = HeartofEnder.location("heart_ender_ship");
    }

    @Override
    public int getSeed()
    {
        return 567990;
    }   
}