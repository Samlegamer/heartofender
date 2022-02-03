package fr.samlegamer.heartofender.entity;

import java.util.Random;
import javax.annotation.Nullable;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.*;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.entity.projectile.EntityFireball;
import net.minecraft.entity.projectile.EntityLargeFireball;
import net.minecraft.init.SoundEvents;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.datasync.*;
import net.minecraft.util.*;
import net.minecraft.util.datafix.DataFixer;
import net.minecraft.util.math.*;
import net.minecraft.world.*;

public class EntityHerobrine extends EntityMob
{
    protected static final DataParameter<Byte> HEROBRINE_FLAGS = EntityDataManager.<Byte>createKey(EntityHerobrine.class, DataSerializers.BYTE);
    private final BossInfoServer bossInfo = (BossInfoServer)(new BossInfoServer(this.getDisplayName(), BossInfo.Color.WHITE, BossInfo.Overlay.PROGRESS)).setDarkenSky(true);
    private EntityLiving owner;    
    
    @Nullable
    private BlockPos boundOrigin;

	public EntityHerobrine(World worldIn)
	{
		super(worldIn);
		this.isImmuneToFire = true;
        this.moveHelper = new EntityHerobrine.AIMoveControl(this);
		this.setSize(0.6F, 1.95F);
		this.experienceValue = 2000;
	}
	
	public void onUpdate()
    {
        this.noClip = true;
        super.onUpdate();
        this.noClip = false;
        this.setNoGravity(true);
    }
	
	protected void initEntityAI()
	{
		/*
        this.tasks.addTask(0, new AIDoNothing());
		this.tasks.addTask(1, new EntityAISwimming(this));
        this.tasks.addTask(3, new EntityAIAttackMelee(this, 1.0D, true));
        this.tasks.addTask(7, new EntityAIWanderAvoidWater(this, 1.0D));
        this.tasks.addTask(4, new EntityHerobrine.AIChargeAttack());
        this.tasks.addTask(8, new EntityHerobrine.AIMoveRandom());
        this.tasks.addTask(9, new EntityAIWatchClosest(this, EntityPlayer.class, 3.0F, 1.0F));
        this.tasks.addTask(10, new EntityAIWatchClosest(this, EntityLiving.class, 8.0F));
        this.targetTasks.addTask(1, new EntityAIHurtByTarget(this, true, new Class[] {EntityHerobrine.class}));
        this.targetTasks.addTask(3, new EntityAINearestAttackableTarget(this, EntityPlayer.class, true));
*/
		
		this.tasks.addTask(0, new EntityAISwimming(this));
        this.tasks.addTask(4, new EntityHerobrine.AIChargeAttack());
        this.tasks.addTask(8, new EntityHerobrine.AIMoveRandom());
        this.tasks.addTask(9, new EntityAIWatchClosest(this, EntityPlayer.class, 3.0F, 1.0F));
        this.tasks.addTask(10, new EntityAIWatchClosest(this, EntityLiving.class, 8.0F));
        this.targetTasks.addTask(1, new EntityAIHurtByTarget(this, true, new Class[] {EntityHerobrine.class}));
        this.targetTasks.addTask(2, new EntityHerobrine.AICopyOwnerTarget(this));
        this.targetTasks.addTask(3, new EntityAINearestAttackableTarget(this, EntityPlayer.class, true));
    }
    
    public void updateAITasks()
    {
    	super.updateAITasks();
        
		this.bossInfo.setPercent(this.getHealth() / this.getMaxHealth());
    }
    
    protected void entityInit()
    {
        super.entityInit();
        dataManager.register(HEROBRINE_FLAGS, (byte)0);
    }
    
    public void updateTask()
    {
        EntityLivingBase entitylivingbase = EntityHerobrine.this.getAttackTarget();

        if (EntityHerobrine.this.getEntityBoundingBox().intersects(entitylivingbase.getEntityBoundingBox()))
        {
        	EntityHerobrine.this.attackEntityAsMob(entitylivingbase);
        	EntityHerobrine.this.setCharging(false);
        }
        else
        {
            double d0 = EntityHerobrine.this.getDistanceSq(entitylivingbase);

            if (d0 < 9.0D)
            {
                Vec3d vec3d = entitylivingbase.getPositionEyes(1.0F);
                EntityHerobrine.this.moveHelper.setMoveTo(vec3d.x, vec3d.y, vec3d.z, 1.0D);
            }
        }
    }
    
    class AICopyOwnerTarget extends EntityAITarget
    {
        public AICopyOwnerTarget(EntityCreature creature)
        {
            super(creature, false);
        }

        /**
         * Returns whether the EntityAIBase should begin execution.
         */
        public boolean shouldExecute()
        {
            return EntityHerobrine.this.owner != null && EntityHerobrine.this.owner.getAttackTarget() != null && this.isSuitableTarget(EntityHerobrine.this.owner.getAttackTarget(), false);
        }

        /**
         * Execute a one shot task or start executing a continuous task
         */
        public void startExecuting()
        {
        	EntityHerobrine.this.setAttackTarget(EntityHerobrine.this.owner.getAttackTarget());
            super.startExecuting();
        }
    }
    
    @Nullable
    public BlockPos getBoundOrigin()
    {
        return this.boundOrigin;
    }

    public void setBoundOrigin(@Nullable BlockPos boundOriginIn)
    {
        this.boundOrigin = boundOriginIn;
    }
    
    class AIChargeAttack extends EntityAIBase
    {
        public AIChargeAttack()
        {
            this.setMutexBits(1);
        }

        /**
         * Returns whether the EntityAIBase should begin execution.
         */
        public boolean shouldExecute()
        {
            if (EntityHerobrine.this.getAttackTarget() != null && !EntityHerobrine.this.getMoveHelper().isUpdating() && EntityHerobrine.this.rand.nextInt(3) == 0)
            {
                return EntityHerobrine.this.getDistanceSq(EntityHerobrine.this.getAttackTarget()) > 0.5D;
            }
            else
            {
                return false;
            }
        }

        /**
         * Returns whether an in-progress EntityAIBase should continue executing
         */
        public boolean shouldContinueExecuting()
        {
            return EntityHerobrine.this.getMoveHelper().isUpdating() && EntityHerobrine.this.isCharging() && EntityHerobrine.this.getAttackTarget() != null && EntityHerobrine.this.getAttackTarget().isEntityAlive();
        }

        /**
         * Execute a one shot task or start executing a continuous task
         */
        public void startExecuting()
        {
            EntityLivingBase entitylivingbase = EntityHerobrine.this.getAttackTarget();
            Vec3d vec3d = entitylivingbase.getPositionEyes(1.0F);
            EntityHerobrine.this.moveHelper.setMoveTo(vec3d.x, vec3d.y, vec3d.z, 1.0D);
            EntityHerobrine.this.setCharging(true);
            EntityHerobrine.this.playSound(SoundEvents.ENTITY_VEX_CHARGE, 1.0F, 1.0F);
        }

        /**
         * Reset the task's internal state. Called when this task is interrupted by another one
         */
        public void resetTask()
        {
        	EntityHerobrine.this.setCharging(false);
        }

        /**
         * Keep ticking a continuous task that has already been started
         */
        public void updateTask()
        {
            EntityLivingBase entitylivingbase = EntityHerobrine.this.getAttackTarget();

            if (EntityHerobrine.this.getEntityBoundingBox().intersects(entitylivingbase.getEntityBoundingBox()))
            {
            	EntityHerobrine.this.attackEntityAsMob(entitylivingbase);
            	EntityHerobrine.this.setCharging(false);
            }
            else
            {
                double d0 = EntityHerobrine.this.getDistanceSq(entitylivingbase);

                if (d0 < 9.0D)
                {
                    Vec3d vec3d = entitylivingbase.getPositionEyes(1.0F);
                    EntityHerobrine.this.moveHelper.setMoveTo(vec3d.x, vec3d.y, vec3d.z, 1.0D);
                }
            }
        }
    }
    
    public void setCharging(boolean charging)
    {
        this.setVexFlag(1, charging);
    }
    
    public boolean getVexFlag(int mask)
    {
        int i = ((Byte)this.dataManager.get(HEROBRINE_FLAGS)).byteValue();
        return (i & mask) != 0;
    }

    public void setVexFlag(int mask, boolean value)
    {
        int i = ((Byte)this.dataManager.get(HEROBRINE_FLAGS)).byteValue();

        if (value)
        {
            i = i | mask;
        }
        else
        {
            i = i & ~mask;
        }

        this.dataManager.set(HEROBRINE_FLAGS, Byte.valueOf((byte)(i & 255)));
    }

    public boolean isCharging()
    {
        return this.getVexFlag(1);
    }
    
    public void addTrackingPlayer(EntityPlayerMP player)
    {
        super.addTrackingPlayer(player);
        this.bossInfo.addPlayer(player);
    }

    
    public void removeTrackingPlayer(EntityPlayerMP player)
    {
        super.removeTrackingPlayer(player);
        this.bossInfo.removePlayer(player);
    }
    
    public void writeEntityToNBT(NBTTagCompound compound)
    {
        super.writeEntityToNBT(compound);
    }

    /**
     * (abstract) Protected helper method to read subclass entity data from NBT.
     */
    public void readEntityFromNBT(NBTTagCompound compound)
    {
        super.readEntityFromNBT(compound);

        if (this.hasCustomName())
        {
            this.bossInfo.setName(this.getDisplayName());
        }
    }
    
    public void setCustomNameTag(String name)
    {
        super.setCustomNameTag(name);
        this.bossInfo.setName(this.getDisplayName());
    }
    
	protected void applyEntityAttributes()
    {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(1000.0D);
        this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.50000001192092898D);
        this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(26.0D);
        this.getEntityAttribute(SharedMonsterAttributes.FOLLOW_RANGE).setBaseValue(64.0D);
    }
	
	class AIMoveControl extends EntityMoveHelper
    {
        public AIMoveControl(EntityHerobrine vex)
        {
            super(vex);
        }

        public void onUpdateMoveHelper()
        {
            if (this.action == EntityMoveHelper.Action.MOVE_TO)
            {
                double d0 = this.posX - EntityHerobrine.this.posX;
                double d1 = this.posY - EntityHerobrine.this.posY;
                double d2 = this.posZ - EntityHerobrine.this.posZ;
                double d3 = d0 * d0 + d1 * d1 + d2 * d2;
                d3 = (double)MathHelper.sqrt(d3);

                if (d3 < EntityHerobrine.this.getEntityBoundingBox().getAverageEdgeLength())
                {
                    this.action = EntityMoveHelper.Action.WAIT;
                    EntityHerobrine.this.motionX *= 0.5D;
                    EntityHerobrine.this.motionY *= 0.5D;
                    EntityHerobrine.this.motionZ *= 0.5D;
                }
                else if (d3 >= 20 && ((EntityHerobrine) entity).attemptTeleportAir(posX, posY, posZ))
                {
                	entity.world.playSound((EntityPlayer)null, entity.prevPosX, entity.prevPosY, entity.prevPosZ, SoundEvents.ENTITY_ENDERMEN_TELEPORT, entity.getSoundCategory(), 1.0F, 1.0F);
                    entity.playSound(SoundEvents.ENTITY_ENDERMEN_TELEPORT, 1.0F, 1.0F);
                }
                else
                {
                	EntityHerobrine.this.motionX += d0 / d3 * 0.05D * this.speed;
                	EntityHerobrine.this.motionY += d1 / d3 * 0.05D * this.speed;
                	EntityHerobrine.this.motionZ += d2 / d3 * 0.05D * this.speed;

                    if (EntityHerobrine.this.getAttackTarget() == null)
                    {
                    	EntityHerobrine.this.rotationYaw = -((float)MathHelper.atan2(EntityHerobrine.this.motionX, EntityHerobrine.this.motionZ)) * (180F / (float)Math.PI);
                    	EntityHerobrine.this.renderYawOffset = EntityHerobrine.this.rotationYaw;
                    }
                    else
                    {
                        double d4 = EntityHerobrine.this.getAttackTarget().posX - EntityHerobrine.this.posX;
                        double d5 = EntityHerobrine.this.getAttackTarget().posZ - EntityHerobrine.this.posZ;
                        EntityHerobrine.this.rotationYaw = -((float)MathHelper.atan2(d4, d5)) * (180F / (float)Math.PI);
                        EntityHerobrine.this.renderYawOffset = EntityHerobrine.this.rotationYaw;
                    }
                }
            }
        }
    }
	
	public boolean attemptTeleportAir(double x, double y, double z) {
        double d0 = this.posX;
        double d1 = this.posY;
        double d2 = this.posZ;
        this.posX = x;
        this.posY = y;
        this.posZ = z;
        boolean flag = false;
        BlockPos blockpos = new BlockPos(this);
        World world = this.world;
        Random random = this.getRNG();

        if (world.isBlockLoaded(blockpos))
        {
            this.setPositionAndUpdate(this.posX, this.posY, this.posZ);

            if (world.getCollisionBoxes(this, this.getEntityBoundingBox()).isEmpty() && !world.containsAnyLiquid(this.getEntityBoundingBox())) flag = true;
        }

        if (!flag)
        {
            this.setPositionAndUpdate(d0, d1, d2);
            return false;
        }
        else
        {
            for (int j = 0; j < 128; ++j)
            {
                double d6 = (double)j / 127.0D;
                float f = (random.nextFloat() - 0.5F) * 0.2F;
                float f1 = (random.nextFloat() - 0.5F) * 0.2F;
                float f2 = (random.nextFloat() - 0.5F) * 0.2F;
                double d3 = d0 + (this.posX - d0) * d6 + (random.nextDouble() - 0.5D) * (double)this.width * 2.0D;
                double d4 = d1 + (this.posY - d1) * d6 + random.nextDouble() * (double)this.height;
                double d5 = d2 + (this.posZ - d2) * d6 + (random.nextDouble() - 0.5D) * (double)this.width * 2.0D;
                world.spawnParticle(EnumParticleTypes.PORTAL, d3, d4, d5, (double)f, (double)f1, (double)f2);
            }

            if (this instanceof EntityCreature)
            {
                ((EntityCreature)this).getNavigator().clearPath();
            }

            return true;
        }
    }

	class AIMoveRandom extends EntityAIBase
    {
        public AIMoveRandom()
        {
            this.setMutexBits(1);
        }

        /**
         * Returns whether the EntityAIBase should begin execution.
         */
        public boolean shouldExecute()
        {
            return !EntityHerobrine.this.getMoveHelper().isUpdating() && EntityHerobrine.this.rand.nextInt(7) == 0;
        }

        /**
         * Returns whether an in-progress EntityAIBase should continue executing
         */
        public boolean shouldContinueExecuting()
        {
            return false;
        }

        /**
         * Keep ticking a continuous task that has already been started
         */
        public void updateTask()
        {
            BlockPos blockpos = EntityHerobrine.this.getBoundOrigin();

            if (blockpos == null)
            {
                blockpos = new BlockPos(EntityHerobrine.this);
            }

            for (int i = 0; i < 3; ++i)
            {
                BlockPos blockpos1 = blockpos.add(EntityHerobrine.this.rand.nextInt(15) - 7, EntityHerobrine.this.rand.nextInt(11) - 5, EntityHerobrine.this.rand.nextInt(15) - 7);

                if (EntityHerobrine.this.world.isAirBlock(blockpos1))
                {
                	EntityHerobrine.this.moveHelper.setMoveTo((double)blockpos1.getX() + 0.5D, (double)blockpos1.getY() + 0.5D, (double)blockpos1.getZ() + 0.5D, 0.25D);

                    if (EntityHerobrine.this.getAttackTarget() == null)
                    {
                    	EntityHerobrine.this.getLookHelper().setLookPosition((double)blockpos1.getX() + 0.5D, (double)blockpos1.getY() + 0.5D, (double)blockpos1.getZ() + 0.5D, 180.0F, 20.0F);
                    }

                    break;
                }
            }
        }
    }
	
	public void move(MoverType type, double x, double y, double z)
	{
        super.move(type, x, y, z);
        this.doBlockCollisions();
    }
	
	class AIDoNothing extends EntityAIBase
    {
        public AIDoNothing()
        {
            this.setMutexBits(7);
        }

		@Override
		public boolean shouldExecute()
		{
			return false;
		}

        
    }
	
	protected SoundEvent getAmbientSound()
    {
        return SoundEvents.ENTITY_VEX_AMBIENT;
    }

    protected SoundEvent getHurtSound(DamageSource damageSourceIn)
    {
        return SoundEvents.ENTITY_PLAYER_ATTACK_CRIT;
    }

    protected SoundEvent getDeathSound()
    {
        return SoundEvents.ENTITY_ENDERDRAGON_DEATH;
    }
}