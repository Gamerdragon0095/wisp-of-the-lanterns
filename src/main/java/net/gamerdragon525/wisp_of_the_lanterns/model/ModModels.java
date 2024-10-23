
package net.gamerdragon525.wisp_of_the_lanterns.model;

import net.neoforged.neoforge.client.event.EntityRenderersEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.api.distmarker.Dist;

@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD, value = {Dist.CLIENT})
public class ModModels {
	@SubscribeEvent
	public static void registerLayerDefinitions(EntityRenderersEvent.RegisterLayerDefinitions event) {
		event.registerLayerDefinition(ModelWisp.LAYER_LOCATION, ModelWisp::createBodyLayer);
		event.registerLayerDefinition(ModelPumpkinMask.LAYER_LOCATION, ModelPumpkinMask::createBodyLayer);
		event.registerLayerDefinition(ModelScareGollum.LAYER_LOCATION, ModelScareGollum::createBodyLayer);
	}
}
