package net.gamerdragon525.wisp_of_the_lanterns.entity;

import net.gamerdragon525.wisp_of_the_lanterns.entity.TempEntity;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.layers.RenderLayer;
import net.minecraft.client.renderer.entity.layers.HumanoidArmorLayer;
import net.minecraft.client.renderer.entity.LivingEntityRenderer;
import net.minecraft.client.renderer.entity.HumanoidMobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.Minecraft;

import net.gamerdragon525.wisp_of_the_lanterns.model.ModelWisp;

import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.blaze3d.vertex.PoseStack;

public class TempRenderer extends HumanoidMobRenderer<TempEntity, HumanoidModel<TempEntity>> {
    public TempRenderer(EntityRendererProvider.Context context) {
        super(context, new HumanoidModel(context.bakeLayer(ModelLayers.PLAYER)), 0.0f);
        this.addLayer(new HumanoidArmorLayer(this, new HumanoidModel(context.bakeLayer(ModelLayers.PLAYER_INNER_ARMOR)), new HumanoidModel(context.bakeLayer(ModelLayers.PLAYER_OUTER_ARMOR)), context.getModelManager()));
        this.addLayer(new RenderLayer<TempEntity, HumanoidModel<TempEntity>>(this) {
            final ResourceLocation LAYER_TEXTURE = ResourceLocation.parse("wisp_of_the_lanterns:textures/entities/wisp.png");

            @Override
            public void render(PoseStack poseStack, MultiBufferSource bufferSource, int light, TempEntity entity, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {
                VertexConsumer vertexConsumer = bufferSource.getBuffer(RenderType.entityTranslucentEmissive(LAYER_TEXTURE));
                EntityModel model = new ModelWisp(Minecraft.getInstance().getEntityModels().bakeLayer(ModelWisp.LAYER_LOCATION));
                this.getParentModel().copyPropertiesTo(model);
                model.prepareMobModel(entity, limbSwing, limbSwingAmount, partialTicks);
                model.setupAnim(entity, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch);
                model.renderToBuffer(poseStack, vertexConsumer, light, LivingEntityRenderer.getOverlayCoords(entity, 0));
                //super.render(entity, entityYww, partialTicks, poseStack, buffer, packedLight);
            }
        });
    }

    @Override
    protected void scale(TempEntity entity, PoseStack poseStack, float f) {
        poseStack.scale(0.5f, 0.5f, 0.5f);
    }

    @Override
    public ResourceLocation getTextureLocation(TempEntity entity) {
        return ResourceLocation.parse("wisp_of_the_lanterns:textures/entities/test_inviz.png");
    }
}




