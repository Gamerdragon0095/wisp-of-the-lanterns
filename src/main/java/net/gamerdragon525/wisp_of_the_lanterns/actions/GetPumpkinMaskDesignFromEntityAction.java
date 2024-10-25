package net.gamerdragon525.wisp_of_the_lanterns.actions;

import net.gamerdragon525.wisp_of_the_lanterns.item.ModItems;
import net.minecraft.core.component.DataComponents;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.component.CustomData;
import net.minecraft.world.entity.EquipmentSlot;



public class GetPumpkinMaskDesignFromEntityAction {
    public static double execute(LivingEntity entity) {
        if (entity == null) {
            return 0;
        }
        ItemStack helmet = ItemStack.EMPTY;
        helmet = (entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.HEAD) : ItemStack.EMPTY);
        if (helmet.getItem() == ModItems.PUMPKIN_MASK.get()) {
            return helmet.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("design");
        }
        return 0;
    }

}
