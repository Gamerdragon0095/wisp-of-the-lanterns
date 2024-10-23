package net.gamerdragon525.wisp_of_the_lanterns.animations;

import net.neoforged.neoforge.event.tick.EntityTickEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;

import net.gamerdragon525.wisp_of_the_lanterns.entity.ScareGollumEntity;

@EventBusSubscriber
public class EntityAnimationFactory {
    @SubscribeEvent
    public static void onEntityTick(EntityTickEvent.Pre event) {
        if (event != null && event.getEntity() != null) {
            if (event.getEntity() instanceof ScareGollumEntity syncable) {
                String animation = syncable.getSyncedAnimation();
                if (!animation.equals("undefined")) {
                    syncable.setAnimation("undefined");
                    syncable.animationprocedure = animation;
                }
            }
        }
    }
}

