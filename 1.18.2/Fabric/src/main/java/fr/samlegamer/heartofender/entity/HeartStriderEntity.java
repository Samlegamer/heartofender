package fr.samlegamer.heartofender.entity;

import fr.samlegamer.heartofender.cfg.HoeConfig;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.data.DataTracker;
import net.minecraft.entity.data.TrackedData;
import net.minecraft.entity.data.TrackedDataHandlerRegistry;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.passive.StriderEntity;
import net.minecraft.world.World;

public class HeartStriderEntity extends StriderEntity
{
    private static final TrackedData<Boolean> COLD = DataTracker.registerData(StriderEntity.class, TrackedDataHandlerRegistry.BOOLEAN);

	public HeartStriderEntity(EntityType<? extends StriderEntity> entityType, World world)
	{
		super(entityType, world);
		this.experiencePoints = HoeConfig.HeartStriderExp;
	}
	
    public static DefaultAttributeContainer.Builder createStriderAttributes()
    {
         return MobEntity.createMobAttributes()
        .add(EntityAttributes.GENERIC_MOVEMENT_SPEED, HoeConfig.HeartStriderMovementSpeed)
        .add(EntityAttributes.GENERIC_MAX_HEALTH, HoeConfig.HeartStriderMaxHealth)
        .add(EntityAttributes.GENERIC_FOLLOW_RANGE, 16.0);
    }
    
    public boolean isCold() {
        if (this.getVehicle() instanceof StriderEntity) {
            return ((HeartStriderEntity)this.getVehicle()).isCold();
        }
        return this.dataTracker.get(COLD);
    }
}