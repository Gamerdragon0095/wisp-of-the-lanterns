package net.gamerdragon525.wisp_of_the_lanterns.entity;

import software.bernie.geckolib.renderer.GeoEntityRenderer;
import software.bernie.geckolib.cache.object.BakedGeoModel;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import net.gamerdragon525.wisp_of_the_lanterns.entity.model.ScareGollumModel;
import net.gamerdragon525.wisp_of_the_lanterns.entity.ScareGollumEntity;

import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.blaze3d.vertex.PoseStack;

public class ScareGollumRenderer extends GeoEntityRenderer<ScareGollumEntity> {
    public ScareGollumRenderer(EntityRendererProvider.Context renderManager) {
        super(renderManager, new ScareGollumModel());
        this.shadowRadius = 0.5f;
    }

    @Override
    public RenderType getRenderType(ScareGollumEntity animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
        return RenderType.entityTranslucent(getTextureLocation(animatable));
    }

    @Override
    public void preRender(PoseStack poseStack, ScareGollumEntity entity, BakedGeoModel model, MultiBufferSource bufferSource, VertexConsumer buffer, boolean isReRender, float partialTick, int packedLight, int packedOverlay, int color) {
        float scale = 1f;
        this.scaleHeight = scale;
        this.scaleWidth = scale;
        super.preRender(poseStack, entity, model, bufferSource, buffer, isReRender, partialTick, packedLight, packedOverlay, color);
    }
}