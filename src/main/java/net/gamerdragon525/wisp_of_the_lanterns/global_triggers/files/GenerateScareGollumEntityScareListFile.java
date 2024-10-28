package net.gamerdragon525.wisp_of_the_lanterns.global_triggers.files;

import net.minecraft.world.level.LevelAccessor;
import net.neoforged.bus.api.Event;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.fml.loading.FMLPaths;

import javax.annotation.Nullable;
import java.io.FileWriter;
import java.io.IOException;
import java.io.File;
import java.io.Writer;
import java.text.DecimalFormat;

@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD)
public class GenerateScareGollumEntityScareListFile {
    @SubscribeEvent
    public static void init(FMLCommonSetupEvent event) {
        execute();
    }

    public static void execute(LevelAccessor world, double x, double y, double z) {
        execute(null, world, x, y, z);
    }

    private static void execute(@Nullable Event event, LevelAccessor world, double x, double y, double z) {

    }

    public static void execute() {
        File file1 = new File("");
        com.google.gson.JsonObject object0 = new com.google.gson.JsonObject();
        com.google.gson.JsonObject object1 = new com.google.gson.JsonObject();
        com.google.gson.JsonObject object2 = new com.google.gson.JsonObject();
        com.google.gson.JsonObject object3 = new com.google.gson.JsonObject();
        com.google.gson.JsonObject object4 = new com.google.gson.JsonObject();
        com.google.gson.JsonObject object5 = new com.google.gson.JsonObject();
        com.google.gson.JsonObject object6 = new com.google.gson.JsonObject();
        com.google.gson.JsonObject object7 = new com.google.gson.JsonObject();
        com.google.gson.JsonObject object8 = new com.google.gson.JsonObject();
        com.google.gson.JsonObject object9 = new com.google.gson.JsonObject();
        com.google.gson.JsonObject object10 = new com.google.gson.JsonObject();
        com.google.gson.JsonObject object11 = new com.google.gson.JsonObject();
        String list = "";
        String nameSpaceID = "";
        String mobID = "";
        Integer maskIntID = 0;
        file1 = new File((FMLPaths.GAMEDIR.get().toString() + "/config/wisp_of_the_lanterns"), File.separator + "scareGollumEntitiesList.json");
        if (file1.exists() == false) {
            try {
                file1.getParentFile().mkdirs();
                file1.createNewFile();
            } catch (IOException exception) {
                exception.printStackTrace();
            }

            {
                maskIntID = 1;
                nameSpaceID = "minecraft";
                mobID = "cat";
                list = "(" + (nameSpaceID + ":" + mobID) + ")";

                mobID = "ocelot";
                list = list + "" + (". (" + (nameSpaceID + ":" + mobID) + ")");

                mobID = "wolf";
                list = list + "" + (". (" + (nameSpaceID + ":" + mobID) + ")");

                mobID = "iron_gollum";
                list = list + "" + (". (" + (nameSpaceID + ":" + mobID) + ")");

                mobID = "snow_gollum";
                list = list + "" + (". (" + (nameSpaceID + ":" + mobID) + ")");

                mobID = "allay";
                list = list + "" + (". (" + (nameSpaceID + ":" + mobID) + ")");

                object1.addProperty("note", "list of entities the scare gollum will try and scare when wearing mask with design of: " + new DecimalFormat("##").format(maskIntID));
                object1.addProperty("value", list);
                object0.add("mask" + new DecimalFormat("##").format(maskIntID), object1);
            }

            {
                maskIntID = 2;
                nameSpaceID = "minecraft";
                mobID = "zombie";
                list = "(" + (nameSpaceID + ":" + mobID) + ")";

                mobID = "husk";
                list = list + "" + (". (" + (nameSpaceID + ":" + mobID) + ")");

                mobID = "drowned";
                list = list + "" + (". (" + (nameSpaceID + ":" + mobID) + ")");

                mobID = "zombie_villager";
                list = list + "" + (". (" + (nameSpaceID + ":" + mobID) + ")");

                object2.addProperty("note", "list of entities the scare gollum will try and scare when wearing mask with design of: " + new DecimalFormat("##").format(maskIntID));
                object2.addProperty("value", list);
                object0.add("mask" + new DecimalFormat("##").format(maskIntID), object2);
            }

            {
                maskIntID = 3;
                nameSpaceID = "minecraft";
                mobID = "player";
                list = "(" + (nameSpaceID + ":" + mobID) + ")";

                object3.addProperty("note", "list of entities the scare gollum will try and scare when wearing mask with design of: " + new DecimalFormat("##").format(maskIntID));
                object3.addProperty("value", list);
                object0.add("mask" + new DecimalFormat("##").format(maskIntID), object3);
            }

            {
                maskIntID = 4;
                nameSpaceID = "minecraft";
                mobID = "skeleton";
                list = "(" + (nameSpaceID + ":" + mobID) + ")";

                mobID = "stray";
                list = list + "" + (". (" + (nameSpaceID + ":" + mobID) + ")");

                mobID = "bogged";
                list = list + "" + (". (" + (nameSpaceID + ":" + mobID) + ")");

                mobID = "wither_skeleton";
                list = list + "" + (". (" + (nameSpaceID + ":" + mobID) + ")");

                mobID = "sheep";
                list = list + "" + (". (" + (nameSpaceID + ":" + mobID) + ")");

                mobID = "fox";
                list = list + "" + (". (" + (nameSpaceID + ":" + mobID) + ")");

                mobID = "rabbit";
                list = list + "" + (". (" + (nameSpaceID + ":" + mobID) + ")");

                object4.addProperty("note", "list of entities the scare gollum will try and scare when wearing mask with design of: " + new DecimalFormat("##").format(maskIntID));
                object4.addProperty("value", list);
                object0.add("mask" + new DecimalFormat("##").format(maskIntID), object4);
            }

            {
                maskIntID = 5;
                nameSpaceID = "minecraft";
                mobID = "pillager";
                list = "(" + (nameSpaceID + ":" + mobID) + ")";

                mobID = "vindicator";
                list = list + "" + (". (" + (nameSpaceID + ":" + mobID) + ")");

                mobID = "evoker";
                list = list + "" + (". (" + (nameSpaceID + ":" + mobID) + ")");

                mobID = "illusioner";
                list = list + "" + (". (" + (nameSpaceID + ":" + mobID) + ")");

                mobID = "vex";
                list = list + "" + (". (" + (nameSpaceID + ":" + mobID) + ")");

                object5.addProperty("note", "list of entities the scare gollum will try and scare when wearing mask with design of: " + new DecimalFormat("##").format(maskIntID));
                object5.addProperty("value", list);
                object0.add("mask" + new DecimalFormat("##").format(maskIntID), object5);
            }

            {
                maskIntID = 6;
                nameSpaceID = "minecraft";
                mobID = "creeper";
                list = "(" + (nameSpaceID + ":" + mobID) + ")";

                object6.addProperty("note", "list of entities the scare gollum will try and scare when wearing mask with design of: " + new DecimalFormat("##").format(maskIntID));
                object6.addProperty("value", list);
                object0.add("mask" + new DecimalFormat("##").format(maskIntID), object6);
            }

            {
                maskIntID = 7;
                nameSpaceID = "minecraft";
                mobID = "villager";
                list = "(" + (nameSpaceID + ":" + mobID) + ")";

                mobID = "pig";
                list = list + "" + (". (" + (nameSpaceID + ":" + mobID) + ")");

                mobID = "cow";
                list = list + "" + (". (" + (nameSpaceID + ":" + mobID) + ")");

                mobID = "sheep";
                list = list + "" + (". (" + (nameSpaceID + ":" + mobID) + ")");

                mobID = "horse";
                list = list + "" + (". (" + (nameSpaceID + ":" + mobID) + ")");

                mobID = "chicken";
                list = list + "" + (". (" + (nameSpaceID + ":" + mobID) + ")");

                mobID = "goat";
                list = list + "" + (". (" + (nameSpaceID + ":" + mobID) + ")");

                object7.addProperty("note", "list of entities the scare gollum will try and scare when wearing mask with design of: " + new DecimalFormat("##").format(maskIntID));
                object7.addProperty("value", list);
                object0.add("mask" + new DecimalFormat("##").format(maskIntID), object7);
            }

            {
                maskIntID = 8;
                nameSpaceID = "minecraft";
                mobID = "witch";
                list = "(" + (nameSpaceID + ":" + mobID) + ")";

                mobID = "enderman";
                list = list + "" + (". (" + (nameSpaceID + ":" + mobID) + ")");

                mobID = "ravager";
                list = list + "" + (". (" + (nameSpaceID + ":" + mobID) + ")");

                mobID = "vex";
                list = list + "" + (". (" + (nameSpaceID + ":" + mobID) + ")");

                object8.addProperty("note", "list of entities the scare gollum will try and scare when wearing mask with design of: " + new DecimalFormat("##").format(maskIntID));
                object8.addProperty("value", list);
                object0.add("mask" + new DecimalFormat("##").format(maskIntID), object8);
            }

            {
                maskIntID = 9;
                nameSpaceID = "minecraft";
                mobID = "spider";
                list = "(" + (nameSpaceID + ":" + mobID) + ")";

                mobID = "cave_spider";
                list = list + "" + (". (" + (nameSpaceID + ":" + mobID) + ")");

                mobID = "silverfish";
                list = list + "" + (". (" + (nameSpaceID + ":" + mobID) + ")");

                mobID = "enermite";
                list = list + "" + (". (" + (nameSpaceID + ":" + mobID) + ")");

                object9.addProperty("note", "list of entities the scare gollum will try and scare when wearing mask with design of: " + new DecimalFormat("##").format(maskIntID));
                object9.addProperty("value", list);
                object0.add("mask" + new DecimalFormat("##").format(maskIntID), object9);
            }

            {
                maskIntID = 10;
                nameSpaceID = "minecraft";
                mobID = "slime";
                list = "(" + (nameSpaceID + ":" + mobID) + ")";

                mobID = "magma_cube";
                list = list + "" + (". (" + (nameSpaceID + ":" + mobID) + ")");

                object10.addProperty("note", "list of entities the scare gollum will try and scare when wearing mask with design of: " + new DecimalFormat("##").format(maskIntID));
                object10.addProperty("value", list);
                object0.add("mask" + new DecimalFormat("##").format(maskIntID), object10);
            }

            {
                maskIntID = 11;
                nameSpaceID = "minecraft";
                mobID = "bee";
                list = "(" + (nameSpaceID + ":" + mobID) + ")";

                mobID = "parrot";
                list = list + "" + (". (" + (nameSpaceID + ":" + mobID) + ")");

                object11.addProperty("note", "list of entities the scare gollum will try and scare when wearing mask with design of: " + new DecimalFormat("##").format(maskIntID));
                object11.addProperty("value", list);
                object0.add("mask" + new DecimalFormat("##").format(maskIntID), object11);
            }

            {
                com.google.gson.Gson mainGSONBuilderVariable = new com.google.gson.GsonBuilder().setPrettyPrinting().create();
                try {
                    FileWriter fileWriter = new FileWriter(file1);
                    fileWriter.write(mainGSONBuilderVariable.toJson(object0));
                    fileWriter.close();
                } catch (IOException exception) {
                    exception.printStackTrace();
                }
            }
        } else {
            return;
        }

    }
}



