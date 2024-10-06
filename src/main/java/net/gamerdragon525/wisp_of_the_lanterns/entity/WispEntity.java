package net.gamerdragon525.wisp_of_the_lanterns.entity;


import net.gamerdragon525.wisp_of_the_lanterns.block.ModBlocks;
import net.gamerdragon525.wisp_of_the_lanterns.entity.goal.InfestPumpkinGoal;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Blocks;
import net.neoforged.neoforge.event.entity.RegisterSpawnPlacementsEvent;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.ai.navigation.PathNavigation;
import net.minecraft.world.entity.ai.navigation.FlyingPathNavigation;
import net.minecraft.world.entity.ai.control.FlyingMoveControl;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.SpawnPlacementTypes;
import net.minecraft.world.entity.Pose;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.EntityDimensions;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.Difficulty;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.BlockPos;

import javax.annotation.Nullable;

public class WispEntity extends PathfinderMob {
    public static final EntityDataAccessor<Boolean> DATA_test = SynchedEntityData.defineId(WispEntity.class, EntityDataSerializers.BOOLEAN);

    public WispEntity(EntityType<WispEntity> type, Level world) {
        super(type, world);
        xpReward = 0;
        setNoAi(false);
        this.moveControl = new FlyingMoveControl(this, 10, true);
        refreshDimensions();
    }

    @Override
    protected void defineSynchedData(SynchedEntityData.Builder builder) {
        super.defineSynchedData(builder);
        builder.define(DATA_test, false);
    }

    @Override
    protected PathNavigation createNavigation(Level world) {
        return new FlyingPathNavigation(this, world);
    }

    @Override
    protected void registerGoals() {
        super.registerGoals();
        /*this.goalSelector.addGoal(1, new MeleeAttackGoal(this, 1.2, false) {
            @Override
            protected boolean canPerformAttack(LivingEntity entity) {
                return this.isTimeToAttack() && this.mob.distanceToSqr(entity) < (this.mob.getBbWidth() * this.mob.getBbWidth() + entity.getBbWidth()) && this.mob.getSensing().hasLineOfSight(entity);
            }
        });*/
        //this.goalSelector.addGoal(2, new WaterAvoidingRandomFlyingGoal(this, 1));
        //this.targetSelector.addGoal(3, new HurtByTargetGoal(this));
        this.goalSelector.addGoal(1, new MoveToBlockGoal(this, 3, 25, 25) {
            @Override
            protected boolean isValidTarget(LevelReader level, BlockPos pos) {
                    if ((level.getBlockState(pos)).getBlock() == Blocks.PUMPKIN || (level.getBlockState(pos)).getBlock() == Blocks.CARVED_PUMPKIN) {
                        return true;
                    }
                    else {
                        return false;
                    }
                //return false;
            }
            @Override
            public void tick() {
                super.tick();
                Level level = this.mob.level();
                BlockPos blockpos = this.mob.blockPosition();
                BlockPos blockpos1 = this.getPosWithBlock(blockpos, level);

                if (this.isReachedTarget() && blockpos1 != null) {
                    InfestPumpkinGoal.execute(level(), blockpos1.getX(), blockpos1.getY(), blockpos1.getZ(), blockpos1, mob);

                }
            }

            @Nullable
            private BlockPos getPosWithBlock(BlockPos pos, BlockGetter level) {
                if (level.getBlockState(pos).is(Blocks.PUMPKIN) || level.getBlockState(pos).is(Blocks.CARVED_PUMPKIN)) {
                    return pos;
                } else {
                    BlockPos[] ablockpos = new BlockPos[]{
                            pos.below(), pos.west(), pos.east(), pos.north(), pos.south(), pos.below().below()
                    };

                    for (BlockPos blockpos : ablockpos) {
                        if (level.getBlockState(blockpos).is(Blocks.PUMPKIN) || level.getBlockState(blockpos).is(Blocks.CARVED_PUMPKIN)) {
                            return blockpos;
                        }
                    }

                    return null;
                }
            }
        });
        //this.goalSelector.addGoal(4, new RandomLookAroundGoal(this));
        //this.goalSelector.addGoal(5, new FloatGoal(this));
    }

    @Override
    public Vec3 getPassengerRidingPosition(Entity entity) {
        return super.getPassengerRidingPosition(entity).add(0, -0.35F, 0);
    }

    @Override
    public SoundEvent getAmbientSound() {
        return BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.soul_sand.break"));
    }

    @Override
    public SoundEvent getHurtSound(DamageSource ds) {
        return BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.generic.hurt"));
    }

    @Override
    public SoundEvent getDeathSound() {
        return BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.generic.death"));
    }

    @Override
    public boolean causeFallDamage(float l, float d, DamageSource source) {
        return false;
    }

    @Override
    public boolean hurt(DamageSource damagesource, float amount) {
        if (damagesource.is(DamageTypes.WITHER) || damagesource.is(DamageTypes.WITHER_SKULL))
            return false;
        return super.hurt(damagesource, amount);
    }

    @Override
    public void addAdditionalSaveData(CompoundTag compound) {
        super.addAdditionalSaveData(compound);
        compound.putBoolean("Datatest", this.entityData.get(DATA_test));
    }

    @Override
    public void readAdditionalSaveData(CompoundTag compound) {
        super.readAdditionalSaveData(compound);
        if (compound.contains("Datatest"))
            this.entityData.set(DATA_test, compound.getBoolean("Datatest"));
    }

    @Override
    public EntityDimensions getDefaultDimensions(Pose pose) {
        return super.getDefaultDimensions(pose).scale(0.5f);
    }

    @Override
    protected void checkFallDamage(double y, boolean onGroundIn, BlockState state, BlockPos pos) {
    }

    @Override
    public void setNoGravity(boolean ignored) {
        super.setNoGravity(true);
    }

    public void aiStep() {
        super.aiStep();
        this.setNoGravity(true);
        if (this.level().isClientSide) {
            for (int i = 0; i < 2; i++) {
                this.level()
                        .addParticle(
                                ParticleTypes.SOUL_FIRE_FLAME,
                                this.getRandomX(0.9),
                                this.getRandomY() - 0.25,
                                this.getRandomZ(0.9),
                                (this.random.nextDouble() - 0.5) / 30,
                                ((this.random.nextDouble() - 0.5) / 30) + 0.05,
                                (this.random.nextDouble() - 0.5) / 30
                        );
            }
            for (int i = 0; i < 2; i++) {
                this.level()
                        .addParticle(
                                ParticleTypes.SOUL,
                                this.getRandomX(0.9),
                                this.getRandomY() - 0.25,
                                this.getRandomZ(0.9),
                                (this.random.nextDouble() - 0.5) / 30,
                                ((this.random.nextDouble() - 0.5) / 30) + 0.05,
                                (this.random.nextDouble() - 0.5) / 30
                        );
            }
        }
    }

    public static void init(RegisterSpawnPlacementsEvent event) {
        event.register(ModEntities.WISP.get(), SpawnPlacementTypes.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
                (entityType, world, reason, pos, random) -> (world.getDifficulty() != Difficulty.PEACEFUL && Monster.isDarkEnoughToSpawn(world, pos, random) && Mob.checkMobSpawnRules(entityType, world, reason, pos, random)),
                RegisterSpawnPlacementsEvent.Operation.REPLACE);
    }

    public static AttributeSupplier.Builder createAttributes() {
        AttributeSupplier.Builder builder = Mob.createMobAttributes();
        builder = builder.add(Attributes.MOVEMENT_SPEED, 0.3);
        builder = builder.add(Attributes.MAX_HEALTH, 10);
        builder = builder.add(Attributes.ARMOR, 0);
        builder = builder.add(Attributes.ATTACK_DAMAGE, 3);
        builder = builder.add(Attributes.FOLLOW_RANGE, 16);
        builder = builder.add(Attributes.STEP_HEIGHT, 0.6);
        builder = builder.add(Attributes.FLYING_SPEED, 0.3);
        return builder;
    }
}

