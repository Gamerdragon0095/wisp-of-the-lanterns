package net.gamerdragon525.wisp_of_the_lanterns.actions;

import net.gamerdragon525.wisp_of_the_lanterns.global_triggers.files.reeder.ReadScareGollumEntityScareListReader;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;

public class IsEntityInScareListForGivenMaskIDAction {
    public static Boolean execute(LivingEntity sourceEntity, LivingEntity entity) {
        if (sourceEntity != null && entity != null) {
            String list = ReadScareGollumEntityScareListReader.execute(sourceEntity);
            if (list.contains(((BuiltInRegistries.ENTITY_TYPE.getKey(entity.getType()).toString())))) {
                return true;
            } else {
                return false;
            }
        }
        return false;
    }
}
