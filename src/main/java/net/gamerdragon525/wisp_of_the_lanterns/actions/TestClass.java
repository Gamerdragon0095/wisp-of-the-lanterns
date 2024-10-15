package net.gamerdragon525.wisp_of_the_lanterns.actions;

import net.minecraft.commands.arguments.NbtPathArgument;
import net.minecraft.core.HolderLookup;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.NbtAccounter;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializer;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.network.chat.Component;

import java.io.DataInput;

public class TestClass {
    public static void execute(Entity entity, Entity sourceentity) {
       /* if (entity == null || sourceentity == null)
            return;
        String data = "";
        if (sourceentity instanceof Player _player && !_player.level().isClientSide())
            _player.displayClientMessage((Component.literal(entity.getEntityData().getNonDefaultValues().toArray().toString())), false);
    }*/
       /* String data = "";
        String dataHold = "";
        double dataLength = 0;
        double loop = 0;
        double index = 0;
        dataHold = "[effect.minecraft.fire_resistance, Duration: 9361, effect.minecraft.regeneration, Duration: 1544]";
        dataLength = (dataHold).length();
        index = dataHold.indexOf("effect.", 0);
        while (index < dataLength) {
            if (index <= 0) {
                dataHold = "[effect.minecraft.fire_resistance, Duration: 9361, effect.minecraft.regeneration, Duration: 1544]";
                dataLength = (dataHold).length();
                index = dataHold.indexOf("effect.", 0);
            } else {
                data = (dataHold.substring((int) dataHold.indexOf(".", index), (int) dataHold.indexOf(",", index))).toUpperCase();
                if (entity instanceof Player _player && !_player.level().isClientSide())
                    _player.displayClientMessage(Component.literal(data), false);
                if ((dataHold.substring((int) dataHold.indexOf(",", index))).contains("effect.")) {
                    index = dataHold.indexOf("effect.", dataHold.indexOf(",", index));
                } else {
                    index = dataHold.indexOf("]", dataHold.indexOf(",", index));
                }
            }
        }*/

    }

}
