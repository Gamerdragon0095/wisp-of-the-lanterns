package net.gamerdragon525.wisp_of_the_lanterns.global_triggers.files.reeder;

import net.gamerdragon525.wisp_of_the_lanterns.item.ModItems;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.neoforged.fml.loading.FMLPaths;

import net.gamerdragon525.wisp_of_the_lanterns.actions.GetPumpkinMaskDesignFromEntityAction;
import javax.swing.text.html.parser.Entity;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.DecimalFormat;

public class ReadScareGollumEntityScareListReader {
    public static String execute (LivingEntity entity) {
        File file1 = new File("");
        com.google.gson.JsonObject object0 = new com.google.gson.JsonObject();
        com.google.gson.JsonObject object1 = new com.google.gson.JsonObject();
        String list = "";
        Integer maskIntID = (int) GetPumpkinMaskDesignFromEntityAction.execute(entity);

        file1 = new File((FMLPaths.GAMEDIR.get().toString() + "/config/wisp_of_the_lanterns"), File.separator + "scareGollumEntitiesList.json");
        if (file1.exists() && maskIntID > 0) {
            try {
                BufferedReader bufferedReader = new BufferedReader(new FileReader(file1));
                StringBuilder jsonstringbuilder = new StringBuilder();
                String line;
                while ((line = bufferedReader.readLine()) != null) {
                    jsonstringbuilder.append(line);
                }
                bufferedReader.close();
                object0 = new com.google.gson.Gson().fromJson(jsonstringbuilder.toString(), com.google.gson.JsonObject.class);
                object1 = object0.get("mask" + new DecimalFormat("##").format(maskIntID)).getAsJsonObject();
                list = object1.get("value").getAsString();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return list;
        }
        return "";
    }

}
