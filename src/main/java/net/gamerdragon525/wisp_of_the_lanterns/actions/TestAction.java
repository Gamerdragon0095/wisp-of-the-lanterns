package net.gamerdragon525.wisp_of_the_lanterns.actions;

import net.gamerdragon525.wisp_of_the_lanterns.entity.ModEntities;
import net.gamerdragon525.wisp_of_the_lanterns.entity.ScareGollumEntity;
import net.minecraft.core.component.DataComponents;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.component.CustomData;
import net.minecraft.world.entity.EquipmentSlot;

public class TestAction {
    public static void execute(Entity entity, ItemStack itemstack, Player sourceEntity) {
        int design = 0;
        if (entity instanceof LivingEntity) {
            design = (entity instanceof ScareGollumEntity _entity ? _entity.maskDesign() : 0);
        }
        if (entity == null)
            return;
        ItemStack helmet = ItemStack.EMPTY;
        LivingEntity livingEntity = null;
        if (entity instanceof LivingEntity _entity) {
            livingEntity = _entity;
        }
        helmet = (entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.HEAD) : ItemStack.EMPTY);
        if (helmet.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("design") != 3) {
            {
                final String _tagName = "design";
                final double _tagValue = (helmet.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("design") + 1);
                CustomData.update(DataComponents.CUSTOM_DATA, helmet, tag -> tag.putDouble(_tagName, _tagValue));
            }
        } else {

            final String _tagName = "design";
            final double _tagValue = 0;
            CustomData.update(DataComponents.CUSTOM_DATA, helmet, tag -> tag.putDouble(_tagName, _tagValue));
        }
        livingEntity.setItemSlot(EquipmentSlot.HEAD, helmet);
        //sourceEntity.displayClientMessage((Component.literal("" + design)), false);
    }
       /* if (entity == null || sourceEntity == null)
            return;
        ItemStack helmet = ItemStack.EMPTY;
        helmet = ((sourceEntity instanceof LivingEntity _entUseItem0 ? _entUseItem0.getUseItem() : ItemStack.EMPTY).copy());
        {
            final String _tagName = "design";
            final double _tagValue = ((sourceEntity instanceof LivingEntity _entUseItem2 ? _entUseItem2.getUseItem() : ItemStack.EMPTY).getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("design"));
            CustomData.update(DataComponents.CUSTOM_DATA, helmet, tag -> tag.putDouble(_tagName, _tagValue));
        }
        {
            Entity _entity = entity;
            if (_entity instanceof Player _player) {
                _player.getInventory().armor.set(3, helmet);
                _player.getInventory().setChanged();
            } else if (_entity instanceof LivingEntity _living) {
                _living.setItemSlot(EquipmentSlot.HEAD, helmet);
            }
        }*/

    }


