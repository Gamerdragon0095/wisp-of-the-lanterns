package net.gamerdragon525.wisp_of_the_lanterns.actions;

import net.gamerdragon525.wisp_of_the_lanterns.entity.ScareGollumEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.Level;

public class SetScareGollumTextureAction {
    public static void execute(Entity entity, int index) {
        if (entity == null)
            return;
        if (entity instanceof ScareGollumEntity animatable)
            animatable.setTexture("scare_gollum" + index);
    }
}

