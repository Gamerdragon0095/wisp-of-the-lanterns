// Made with Blockbench 4.10.4
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports
package net.gamerdragon525.wisp_of_the_lanterns.model;

import net.minecraft.world.entity.Entity;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.model.geom.builders.PartDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.CubeDeformation;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.EntityModel;

import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.blaze3d.vertex.PoseStack;

// Made with Blockbench 4.10.4
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports
public class ModelPumpkinMask<T extends Entity> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in
	// the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(ResourceLocation.fromNamespaceAndPath("test_environment_1_21_1_3", "modelpumpkin_mask"), "main");
	public final ModelPart mask;

	public ModelPumpkinMask(ModelPart root) {
		this.mask = root.getChild("mask");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();
		PartDefinition mask = partdefinition.addOrReplaceChild("mask", CubeListBuilder.create().texOffs(0, 4).addBox(-4.0F, -5.25F, -5.1F, 8.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(2, 0).addBox(-2.0F, -9.25F, -5.1F, 4.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(6, 1).addBox(2.0F, -8.25F, -5.1F, 2.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(1, 0).addBox(-3.0F, -8.25F, -5.1F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(0, 1).addBox(-4.0F, -7.25F, -5.1F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(0, 7).addBox(-4.0F, -2.25F, -5.1F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(1, 7).addBox(-3.0F, -2.25F, -5.1F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(3, 7).addBox(-1.0F, -2.25F, -5.1F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(4, 7).addBox(0.0F, -2.25F, -5.1F, 2.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(6, 7).addBox(2.0F, -2.25F, -5.1F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(7, 8).addBox(3.0F, -2.25F, -5.1F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));
		PartDefinition cube_r1 = mask.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(0, 11).mirror().addBox(-1.0F, -2.0F, -1.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false),
				PartPose.offsetAndRotation(-1.4F, -4.85F, -3.0F, 0.6728F, -0.582F, -0.437F));
		PartDefinition cube_r2 = mask.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(0, 11).addBox(-1.0F, -2.0F, -1.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(1.4F, -4.85F, -3.0F, 0.6728F, 0.582F, 0.437F));
		return LayerDefinition.create(meshdefinition, 32, 32);
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, int rgb) {
		mask.render(poseStack, vertexConsumer, packedLight, packedOverlay, rgb);
	}

	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
	}
}
