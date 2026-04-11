package net.razetka.scguns_oregunized.common.entity.mobs;// Made with Blockbench 5.1.3
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports


import com.mojang.math.Axis;
import net.minecraft.client.model.ArmedModel;
import net.minecraft.client.model.HierarchicalModel;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.HumanoidArm;
import top.ribs.scguns.item.GunItem;

public class ArgonautModel<T extends ArgonautEntity> extends HierarchicalModel<T> implements ArmedModel {
	// This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation("modid", "argonautmodel"), "main");
	public final ModelPart root;
	private final ModelPart head;
	private final ModelPart body;
	private final ModelPart rightArm;
	private final ModelPart leftArm;
	private final ModelPart right_leg;
	private final ModelPart left_leg;

	private final PartPose headDefault;
	private final PartPose leftArmDefault;
	private final PartPose rightArmDefault;
	private final PartPose leftLegDefault;
	private final PartPose rightLegDefault;

	public ArgonautModel(ModelPart root) {
		this.root = root;
		this.head = root.getChild("head");
		this.body = root.getChild("body");
		this.rightArm = root.getChild("right_arm");
		this.leftArm = root.getChild("left_arm");
		this.right_leg = root.getChild("right_leg");
		this.left_leg = root.getChild("left_leg");

		this.headDefault = this.head.storePose();
		this.leftArmDefault = this.leftArm.storePose();
		this.rightArmDefault = this.rightArm.storePose();
		this.leftLegDefault = this.left_leg.storePose();
		this.rightLegDefault = this.right_leg.storePose();
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition head = partdefinition.addOrReplaceChild("head", CubeListBuilder.create().texOffs(0, 11).addBox(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F))
		.texOffs(0, 0).addBox(-5.0F, -6.0F, -5.0F, 10.0F, 1.0F, 10.0F, new CubeDeformation(0.0F))
		.texOffs(12, 5).addBox(4.0F, -5.0F, -2.0F, 1.0F, 3.0F, 3.0F, new CubeDeformation(0.0F))
		.texOffs(12, 5).addBox(-5.0F, -5.0F, -2.0F, 1.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition head_r1 = head.addOrReplaceChild("head_r1", CubeListBuilder.create().texOffs(12, 5).addBox(-0.5F, 0.0F, -3.0F, 1.0F, 3.0F, 3.0F, new CubeDeformation(0.0F))
		.texOffs(12, 5).addBox(8.25F, 0.0F, -3.0F, 1.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.375F, -2.0F, 1.0F, -0.7854F, 0.0F, 0.0F));

		PartDefinition head_r2 = head.addOrReplaceChild("head_r2", CubeListBuilder.create().texOffs(32, 18).addBox(-1.5F, -3.0F, 0.0F, 3.0F, 6.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.7071F, -2.0F, -4.5F, 0.0F, -0.7854F, 0.0F));

		PartDefinition head_r3 = head.addOrReplaceChild("head_r3", CubeListBuilder.create().texOffs(32, 11).addBox(-1.0F, -0.5F, 0.375F, 3.0F, 6.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-5.0F, -4.5F, -4.5F, 0.0F, 0.7854F, 0.0F));

		PartDefinition head_r4 = head.addOrReplaceChild("head_r4", CubeListBuilder.create().texOffs(16, 55).addBox(-1.0F, -1.0F, -1.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -9.0F, 0.0F, 0.0F, -0.7854F, 0.0F));

		PartDefinition head_r5 = head.addOrReplaceChild("head_r5", CubeListBuilder.create().texOffs(40, 46).addBox(-5.0F, -2.0F, 0.0F, 9.0F, 6.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.5F, -0.5F, 3.5F, 0.7854F, 0.0F, 0.0F));

		PartDefinition body = partdefinition.addOrReplaceChild("body", CubeListBuilder.create().texOffs(0, 27).addBox(-4.0F, 0.0F, -2.0F, 8.0F, 14.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(0, 55).addBox(-4.0F, 7.0F, -3.0F, 3.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(8, 55).addBox(1.0F, 7.0F, -3.0F, 3.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition right_arm = partdefinition.addOrReplaceChild("right_arm", CubeListBuilder.create().texOffs(24, 27).addBox(-3.0F, -2.0F, -2.0F, 4.0F, 14.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(0, 45).addBox(-2.0F, -3.0F, -2.5F, 5.0F, 5.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(-5.0F, 2.0F, 0.0F));

		PartDefinition left_arm = partdefinition.addOrReplaceChild("left_arm", CubeListBuilder.create().texOffs(40, 0).addBox(-1.0F, -2.0F, -2.0F, 4.0F, 14.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(20, 45).addBox(-3.0F, -3.0F, -2.5F, 5.0F, 5.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(5.0F, 2.0F, 0.0F));

		PartDefinition right_leg = partdefinition.addOrReplaceChild("right_leg", CubeListBuilder.create().texOffs(40, 18).addBox(-2.1F, 2.0F, -2.0F, 4.0F, 10.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(50, 53).addBox(-2.1F, 9.0F, -3.0F, 4.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(-1.9F, 12.0F, 0.0F));

		PartDefinition left_leg = partdefinition.addOrReplaceChild("left_leg", CubeListBuilder.create().texOffs(40, 32).addBox(-1.9F, 2.0F, -2.0F, 4.0F, 10.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(40, 53).addBox(-1.9F, 9.0F, -3.0F, 4.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(1.9F, 12.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 64, 64);
	}


	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
//		this.root.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		right_leg.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		left_leg.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		body.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		head.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		leftArm.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		rightArm.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}


	@Override
	public void translateToHand(HumanoidArm pSide, PoseStack pPoseStack) {
		if (pSide == HumanoidArm.RIGHT) {
			this.rightArm.translateAndRotate(pPoseStack);

			pPoseStack.mulPose(com.mojang.math.Axis.XP.rotation(-0.3927F));

			pPoseStack.translate(-0.05, 0.55, 0.05);
			pPoseStack.scale(0.8F, 0.8F, 0.8F);
		}
	}

	@Override
	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float pAgeInTicks, float netHeadYaw, float headPitch) {
		head.loadPose(headDefault);
		leftArm.loadPose(leftArmDefault);
		rightArm.loadPose(rightArmDefault);
		left_leg.loadPose(leftLegDefault);
		right_leg.loadPose(rightLegDefault);

		float legSwing = Mth.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
		float armSwing = Mth.cos(limbSwing * 0.6662F + (float)Math.PI) * 1.0F * limbSwingAmount;

		this.right_leg.xRot += legSwing;
		this.left_leg.xRot -= legSwing;

		this.rightArm.xRot += armSwing;
		this.leftArm.xRot -= armSwing;

		float clampedYaw = Mth.clamp(netHeadYaw, -60.0F, 60.0F);
		float clampedPitch = Mth.clamp(headPitch, -25.0F, 25.0F);
		this.head.yRot += clampedYaw * ((float)Math.PI / 180F);
		this.head.xRot += clampedPitch * ((float)Math.PI / 180F) * 0.5F;

		boolean holdingGun = entity.getMainHandItem().getItem() instanceof GunItem;

		if (holdingGun) {
			this.rightArm.xRot = -1.5708F + 0.3927F;
			this.rightArm.yRot = 0.0F;
			this.rightArm.zRot = 0.0F;
		}
	}

	@Override
	public ModelPart root() {
		return root;
	}
}