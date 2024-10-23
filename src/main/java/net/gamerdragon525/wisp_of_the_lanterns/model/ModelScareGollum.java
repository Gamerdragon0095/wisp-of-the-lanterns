package net.gamerdragon525.wisp_of_the_lanterns.model;// Made with Blockbench 4.10.4
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports

import java.util.List;

import net.gamerdragon525.wisp_of_the_lanterns.animations.ScareGollumAnimations;
import net.minecraft.client.animation.AnimationDefinition;
import net.minecraft.client.model.HierarchicalModel;
import net.minecraft.world.entity.AnimationState;
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
import net.minecraft.util.Mth;

import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.blaze3d.vertex.PoseStack;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class ModelScareGollum<T extends Entity> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(ResourceLocation.fromNamespaceAndPath("test_environment_1_21_1_3", "modelscare_golem"), "main");
	public final ModelPart fullModel;
	public final ModelPart head;
	public final ModelPart right_arm;
	public final ModelPart bottom_ra;
	public final ModelPart left_arm;
	public final ModelPart bottom_la;
	public final ModelPart body;
	public final ModelPart right_leg;
	public final ModelPart bottom_rl;
	public final ModelPart left_leg;
	public final ModelPart bottom_ll;

	public ModelScareGollum(ModelPart root) {
		this.fullModel = root.getChild("fullModel");
		this.head = root.getChild("fullModel").getChild("head");
		this.right_arm = root.getChild("fullModel").getChild("right_arm");
		this.bottom_ra = root.getChild("fullModel").getChild("right_arm").getChild("bottom_ra");
		this.left_arm = root.getChild("fullModel").getChild("left_arm");
		this.bottom_la = root.getChild("fullModel").getChild("left_arm").getChild("bottom_la");
		this.body = root.getChild("fullModel").getChild("body");
		this.left_leg = root.getChild("fullModel").getChild("left_leg");
		this.bottom_ll = root.getChild("fullModel").getChild("left_leg").getChild("bottom_ll");
		this.right_leg = root.getChild("fullModel").getChild("right_leg");
		this.bottom_rl = root.getChild("fullModel").getChild("right_leg").getChild("bottom_rl");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition fullModel = partdefinition.addOrReplaceChild("fullModel", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.5F));

		PartDefinition head = fullModel.addOrReplaceChild("head", CubeListBuilder.create().texOffs(0, 0).addBox(-3.0F, -7.0F, -3.5F, 6.0F, 7.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -36.0F, 0.0F));

		PartDefinition right_arm = fullModel.addOrReplaceChild("right_arm", CubeListBuilder.create().texOffs(0, 47).addBox(0.0F, 0.0F, -0.5F, 1.0F, 11.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(5.0F, -33.5F, 0.0F));

		PartDefinition cube_r1 = right_arm.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(22, 11).addBox(-4.0F, -2.0F, -1.0F, 12.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.5F, 3.5F, 0.0F, 0.0F, 0.0F, 1.5708F));

		PartDefinition bottom_ra = right_arm.addOrReplaceChild("bottom_ra", CubeListBuilder.create().texOffs(0, 35).addBox(0.0F, 0.0F, -0.5F, 1.0F, 11.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 11.0F, 0.0F));

		PartDefinition cube_r2 = bottom_ra.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(30, 11).addBox(-4.0F, -2.0F, -1.0F, 8.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.5F, 4.5F, 0.0F, 0.0F, 0.0F, 1.5708F));

		PartDefinition left_arm = fullModel.addOrReplaceChild("left_arm", CubeListBuilder.create().texOffs(0, 47).addBox(-1.0F, 0.0F, -0.5F, 1.0F, 11.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(-5.0F, -33.5F, 0.0F));

		PartDefinition cube_r3 = left_arm.addOrReplaceChild("cube_r3", CubeListBuilder.create().texOffs(22, 11).mirror().addBox(-8.0F, -2.0F, -1.0F, 12.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.5F, 3.5F, 0.0F, 0.0F, 0.0F, -1.5708F));

		PartDefinition bottom_la = left_arm.addOrReplaceChild("bottom_la", CubeListBuilder.create().texOffs(0, 35).addBox(-1.0F, 0.0F, -0.5F, 1.0F, 11.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 11.0F, 0.0F));

		PartDefinition cube_r4 = bottom_la.addOrReplaceChild("cube_r4", CubeListBuilder.create().texOffs(30, 11).mirror().addBox(-4.0F, -2.0F, -1.0F, 8.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.5F, 4.5F, 0.0F, 0.0F, 0.0F, -1.5708F));

		PartDefinition body = fullModel.addOrReplaceChild("body", CubeListBuilder.create().texOffs(0, 19).addBox(-2.5F, 4.0F, -1.0F, 5.0F, 14.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(23, 26).addBox(-3.0F, 9.5F, -1.5F, 6.0F, 4.0F, 3.0F, new CubeDeformation(0.0F))
		.texOffs(0, 13).addBox(-4.5F, 3.0F, -2.0F, 9.0F, 2.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(0, 0).addBox(-0.5F, 1.0F, -0.5F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(0, 35).addBox(4.0F, 3.5F, -0.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(0, 35).addBox(-5.0F, 3.5F, -0.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -37.0F, 0.0F));

		PartDefinition cube_r5 = body.addOrReplaceChild("cube_r5", CubeListBuilder.create().texOffs(11, 33).addBox(0.0F, -1.0F, -1.0F, 1.0F, 6.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.0F, 5.0F, -0.5F, 0.0F, 0.0F, 0.2182F));

		PartDefinition cube_r6 = body.addOrReplaceChild("cube_r6", CubeListBuilder.create().texOffs(14, 19).addBox(-3.0F, -1.0F, -1.0F, 6.0F, 6.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 5.0F, 2.5F, -0.2182F, 0.0F, 0.0F));

		PartDefinition cube_r7 = body.addOrReplaceChild("cube_r7", CubeListBuilder.create().texOffs(11, 33).addBox(-1.0F, -1.0F, -1.0F, 1.0F, 6.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.0F, 5.0F, -0.5F, 0.0F, 0.0F, -0.2182F));

		PartDefinition cube_r8 = body.addOrReplaceChild("cube_r8", CubeListBuilder.create().texOffs(14, 19).mirror().addBox(-3.0F, -1.0F, 0.0F, 6.0F, 6.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 5.0F, -2.5F, 0.2182F, 0.0F, 0.0F));

		PartDefinition cube_r9 = body.addOrReplaceChild("cube_r9", CubeListBuilder.create().texOffs(11, 33).addBox(0.0F, -5.0F, -1.0F, 1.0F, 6.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.0F, 18.0F, -0.5F, 0.0F, 0.0F, -0.2182F));

		PartDefinition cube_r10 = body.addOrReplaceChild("cube_r10", CubeListBuilder.create().texOffs(11, 33).addBox(-1.0F, -5.0F, -1.0F, 1.0F, 6.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.0F, 18.0F, -0.5F, 0.0F, 0.0F, 0.2182F));

		PartDefinition cube_r11 = body.addOrReplaceChild("cube_r11", CubeListBuilder.create().texOffs(14, 19).mirror().addBox(-3.0F, -5.0F, -1.0F, 6.0F, 6.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 18.0F, 2.5F, 0.2182F, 0.0F, 0.0F));

		PartDefinition cube_r12 = body.addOrReplaceChild("cube_r12", CubeListBuilder.create().texOffs(14, 19).addBox(-3.0F, -5.0F, 0.0F, 6.0F, 6.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 18.0F, -2.5F, -0.2182F, 0.0F, 0.0F));

		PartDefinition left_leg = fullModel.addOrReplaceChild("left_leg", CubeListBuilder.create().texOffs(19, 38).addBox(-0.5F, 0.0F, -0.5F, 1.0F, 8.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(-2.5F, -19.0F, 0.0F));

		PartDefinition cube_r13 = left_leg.addOrReplaceChild("cube_r13", CubeListBuilder.create().texOffs(22, 11).mirror().addBox(-6.0F, -2.0F, -1.0F, 10.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(1.0F, 4.0F, 0.0F, 0.0F, 0.0F, -1.5708F));

		PartDefinition bottom_ll = left_leg.addOrReplaceChild("bottom_ll", CubeListBuilder.create().texOffs(19, 26).addBox(-0.5F, 0.0F, -0.5F, 1.0F, 11.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 8.0F, 0.0F));

		PartDefinition right_leg = fullModel.addOrReplaceChild("right_leg", CubeListBuilder.create().texOffs(19, 38).addBox(-0.5F, 0.0F, -0.5F, 1.0F, 8.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(2.5F, -19.0F, 0.0F));

		PartDefinition cube_r14 = right_leg.addOrReplaceChild("cube_r14", CubeListBuilder.create().texOffs(22, 11).addBox(-4.0F, -2.0F, -1.0F, 10.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.0F, 4.0F, 0.0F, 0.0F, 0.0F, 1.5708F));

		PartDefinition bottom_rl = right_leg.addOrReplaceChild("bottom_rl", CubeListBuilder.create().texOffs(19, 26).addBox(-0.5F, 0.0F, -0.5F, 1.0F, 11.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 8.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 64, 64);
	}


	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, int rgb) {
		fullModel.render(poseStack, vertexConsumer, packedLight, packedOverlay, rgb);

	}

	private void animateHeadLookTarget(float yaw, float pitch) {
		this.head.xRot = pitch / (180F / (float) Math.PI);
		this.head.yRot = yaw / (180F / (float) Math.PI);
	}

	@Override
	public void setupAnim(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.animateHeadLookTarget(netHeadYaw, headPitch);

		/*while (!(entity.moveDist <= 0)){
			ScareGollumAnimations.walking.boneAnimations();
		}*/

		ScareGollumAnimations.idle.boneAnimations();
		//ScareGollumAnimations.running.boneAnimations();
	}
}