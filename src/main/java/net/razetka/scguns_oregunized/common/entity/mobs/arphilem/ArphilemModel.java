package net.razetka.scguns_oregunized.common.entity.mobs.arphilem;// Made with Blockbench 5.1.3
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports

import net.minecraft.client.model.ArmedModel;
import net.minecraft.client.model.HierarchicalModel;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.util.Mth;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.HumanoidArm;
import top.ribs.scguns.item.GunItem;

public class ArphilemModel<T extends ArphilemEntity> extends HierarchicalModel<T> implements ArmedModel {
	public final ModelPart root;
	private final ModelPart head;
	private final ModelPart body;
	private final ModelPart right_arm;
	private final ModelPart left_arm;
	private final ModelPart right_leg;
	private final ModelPart left_leg;

	private final PartPose headDefault;
	private final PartPose leftArmDefault;
	private final PartPose rightArmDefault;
	private final PartPose leftLegDefault;
	private final PartPose rightLegDefault;

	public ArphilemModel(ModelPart root) {
		this.root = root;
		this.head = root.getChild("head");
		this.body = root.getChild("body");
		this.right_arm = root.getChild("right_arm");
		this.left_arm = root.getChild("left_arm");
		this.right_leg = root.getChild("right_leg");
		this.left_leg = root.getChild("left_leg");

		this.headDefault = this.head.storePose();
		this.leftArmDefault = this.left_arm.storePose();
		this.rightArmDefault = this.right_arm.storePose();
		this.leftLegDefault = this.left_leg.storePose();
		this.rightLegDefault = this.right_leg.storePose();
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition head = partdefinition.addOrReplaceChild("head", CubeListBuilder.create().texOffs(40, 16).addBox(-5.75F, -11.0F, -1.0F, 0.0F, 6.0F, 8.0F, new CubeDeformation(0.0F))
		.texOffs(40, 30).addBox(5.75F, -11.0F, -1.0F, 0.0F, 6.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition head_r1 = head.addOrReplaceChild("head_r1", CubeListBuilder.create().texOffs(1, 1).addBox(-4.625F, 2.0F, -4.5F, 9.0F, 2.0F, 9.0F, new CubeDeformation(0.0F))
		.texOffs(0, 12).addBox(-4.0F, -4.0F, -4.0F, 8.0F, 6.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -4.0F, 0.0F, 0.0F, 0.7854F, 0.0F));

		PartDefinition body = partdefinition.addOrReplaceChild("body", CubeListBuilder.create().texOffs(0, 26).addBox(-4.0F, 0.0F, -2.0F, 8.0F, 12.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(0, 63).addBox(-4.0F, 0.5F, -2.0F, 8.0F, 11.0F, 4.0F, new CubeDeformation(0.5F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition right_arm = partdefinition.addOrReplaceChild("right_arm", CubeListBuilder.create().texOffs(36, 44).addBox(-2.0F, 3.0F, -2.0F, 3.0F, 8.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(0, 52).addBox(-3.0F, 5.5F, -2.5F, 2.0F, 6.0F, 5.0F, new CubeDeformation(0.0F))
		.texOffs(0, 42).addBox(-3.0F, -2.0F, -2.625F, 4.0F, 5.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(-5.0F, 2.0F, 0.0F));

		PartDefinition left_arm = partdefinition.addOrReplaceChild("left_arm", CubeListBuilder.create().texOffs(50, 44).addBox(-1.0F, 3.0F, -2.0F, 3.0F, 8.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(14, 52).addBox(1.0F, 5.5F, -2.5F, 2.0F, 6.0F, 5.0F, new CubeDeformation(0.0F))
		.texOffs(18, 42).addBox(-1.0F, -2.0F, -2.625F, 4.0F, 5.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(5.0F, 2.0F, 0.0F));

		PartDefinition right_leg = partdefinition.addOrReplaceChild("right_leg", CubeListBuilder.create().texOffs(24, 26).addBox(-2.1F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(56, 0).addBox(-2.1F, 9.0F, -3.0F, 4.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(-1.9F, 12.0F, 0.0F));

		PartDefinition left_leg = partdefinition.addOrReplaceChild("left_leg", CubeListBuilder.create().texOffs(40, 0).addBox(-1.9F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(56, 4).addBox(-1.9F, 9.0F, -3.0F, 4.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(1.9F, 12.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 128, 128);
	}


	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		right_leg.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		left_leg.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		body.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		head.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		left_arm.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		right_arm.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}


	@Override
	public void translateToHand(HumanoidArm pSide, PoseStack pPoseStack) {
		if (pSide == HumanoidArm.RIGHT) {
			this.right_arm.translateAndRotate(pPoseStack);

			pPoseStack.translate(-0.05, 0.0, -0.0);
			pPoseStack.scale(1.0F, 1.0F, 1.0F);
		}
	}

	@Override
	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float pAgeInTicks, float netHeadYaw, float headPitch) {
		head.loadPose(headDefault);
		left_arm.loadPose(leftArmDefault);
		right_arm.loadPose(rightArmDefault);
		left_leg.loadPose(leftLegDefault);
		right_leg.loadPose(rightLegDefault);

		this.setupAttackAnimation(entity, pAgeInTicks);
		float legSwing = Mth.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
		float armSwing = Mth.cos(limbSwing * 0.6662F + (float)Math.PI) * 1.0F * limbSwingAmount;

		this.right_leg.xRot += legSwing;
		this.left_leg.xRot -= legSwing;

		this.right_arm.xRot += armSwing;
		this.left_arm.xRot -= armSwing;

		float clampedYaw = Mth.clamp(netHeadYaw, -60.0F, 60.0F);
		float clampedPitch = Mth.clamp(headPitch, -25.0F, 25.0F);
		this.head.yRot += clampedYaw * ((float)Math.PI / 180F);
		this.head.xRot += clampedPitch * ((float)Math.PI / 180F) * 0.5F;

		boolean holdingGun = entity.getMainHandItem().getItem() instanceof GunItem;

		if (holdingGun) {
			this.right_arm.xRot = -1.5708F;
			this.right_arm.yRot = 0.0F;
			this.right_arm.zRot = 0.0F;

			this.left_arm.xRot = -1.3F;
			this.left_arm.yRot = 0.6F;
			this.left_arm.zRot = 0.3F;
		}

	}
	protected ModelPart getArm(HumanoidArm pSide) {
		return pSide == HumanoidArm.LEFT ? this.left_arm : this.right_arm;
	}


	private HumanoidArm getAttackArm(T pEntity) {
		HumanoidArm humanoidarm = pEntity.getMainArm();
		return pEntity.swingingArm == InteractionHand.MAIN_HAND ? humanoidarm : humanoidarm.getOpposite();
	}

	protected void setupAttackAnimation(T pLivingEntity, float pAgeInTicks) {
		if (!(this.attackTime <= 0.0F)) {
			HumanoidArm humanoidarm = this.getAttackArm(pLivingEntity);
			ModelPart modelpart = this.getArm(humanoidarm);
			float f = this.attackTime;
			this.body.yRot = Mth.sin(Mth.sqrt(f) * ((float)Math.PI * 2F)) * 0.2F;
			if (humanoidarm == HumanoidArm.LEFT) {
				this.body.yRot *= -1.0F;
			}

			this.right_arm.z = Mth.sin(this.body.yRot) * 5.0F;
			this.right_arm.x = -Mth.cos(this.body.yRot) * 5.0F;
			this.left_arm.z = -Mth.sin(this.body.yRot) * 5.0F;
			this.left_arm.x = Mth.cos(this.body.yRot) * 5.0F;
			this.right_arm.yRot += this.body.yRot;
			this.left_arm.yRot += this.body.yRot;
			this.left_arm.xRot += this.body.yRot;
			f = 1.0F - this.attackTime;
			f *= f;
			f *= f;
			f = 1.0F - f;
			float f1 = Mth.sin(f * (float)Math.PI);
			float f2 = Mth.sin(this.attackTime * (float)Math.PI) * -(this.head.xRot - 0.7F) * 0.75F;
			modelpart.xRot -= f1 * 1.2F + f2;
			modelpart.yRot += this.body.yRot * 2.0F;
			modelpart.zRot += Mth.sin(this.attackTime * (float)Math.PI) * -0.4F;
		}
	}

	@Override
	public ModelPart root() {
		return root;
	}
}