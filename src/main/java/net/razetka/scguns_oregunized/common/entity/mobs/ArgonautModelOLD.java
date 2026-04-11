// Made with Blockbench 5.1.3
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports
package net.razetka.scguns_oregunized.common.entity.mobs;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.ArmedModel;
import net.minecraft.client.model.HierarchicalModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.HumanoidArm;
import org.jetbrains.annotations.NotNull;
import top.ribs.scguns.item.GunItem;

public class ArgonautModelOLD<T extends ArgonautEntity> extends HierarchicalModel<T> implements ArmedModel {
	// This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation("modid", "custommodel"), "main");
	public final ModelPart root;
	public final ModelPart waist;
	public final ModelPart head;
	public final ModelPart body;
	public final ModelPart right_arm;
	public final ModelPart left_arm;
	public final ModelPart right_leg;
	public final ModelPart left_leg;

	private final PartPose headDefault;
	private final PartPose waistDefault;
	private final PartPose leftArmDefault;
	private final PartPose rightArmDefault;
	private final PartPose leftLegDefault;
	private final PartPose rightLegDefault;


	public ArgonautModelOLD(ModelPart root) {
		this.root = root;
		this.waist = root.getChild("Waist");
		this.head = this.waist.getChild("Head");
		this.body = this.waist.getChild("Body");
		this.right_arm = this.waist.getChild("right_arm");
		this.left_arm = this.waist.getChild("left_arm");
		this.right_leg = root.getChild("Right Leg");
		this.left_leg = root.getChild("Left Leg");

		this.headDefault = this.head.storePose();
		this.waistDefault = this.waist.storePose();
		this.leftArmDefault = this.left_arm.storePose();
		this.rightArmDefault = this.right_arm.storePose();
		this.leftLegDefault = this.left_leg.storePose();
		this.rightLegDefault = this.right_leg.storePose();
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition Waist = partdefinition.addOrReplaceChild("Waist", CubeListBuilder.create(), PartPose.offset(0.0F, 12.0F, 0.0F));

		PartDefinition Head = Waist.addOrReplaceChild("Head", CubeListBuilder.create().texOffs(0, 11).addBox(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F))
				.texOffs(16, 55).addBox(-1.0F, -10.0F, -1.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
				.texOffs(0, 0).addBox(-5.0F, -6.0F, -5.0F, 10.0F, 1.0F, 10.0F, new CubeDeformation(0.0F))
				.texOffs(12, 5).addBox(4.0F, -5.0F, -2.0F, 1.0F, 3.0F, 3.0F, new CubeDeformation(0.0F))
				.texOffs(12, 5).addBox(-5.0F, -5.0F, -2.0F, 1.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -12.0F, 0.0F));

		PartDefinition Head_r1 = Head.addOrReplaceChild("Head_r1", CubeListBuilder.create().texOffs(12, 5).addBox(-0.5F, 0.0F, -3.0F, 1.0F, 3.0F, 3.0F, new CubeDeformation(0.0F))
				.texOffs(12, 5).addBox(8.25F, 0.0F, -3.0F, 1.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.375F, -2.0F, 1.0F, -0.7854F, 0.0F, 0.0F));

		PartDefinition Head_r2 = Head.addOrReplaceChild("Head_r2", CubeListBuilder.create().texOffs(32, 18).addBox(-1.5F, -3.0F, 0.0F, 3.0F, 6.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.7071F, -2.0F, -4.5F, 0.0F, -0.7854F, 0.0F));

		PartDefinition Head_r3 = Head.addOrReplaceChild("Head_r3", CubeListBuilder.create().texOffs(32, 11).addBox(-1.0F, -0.5F, 0.375F, 3.0F, 6.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-5.0F, -4.5F, -4.5F, 0.0F, 0.7854F, 0.0F));

		PartDefinition Head_r4 = Head.addOrReplaceChild("Head_r4", CubeListBuilder.create().texOffs(40, 46).addBox(-5.0F, -2.0F, 0.0F, 9.0F, 6.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.5F, -0.5F, 3.5F, 0.7854F, 0.0F, 0.0F));

		PartDefinition Body = Waist.addOrReplaceChild("Body", CubeListBuilder.create().texOffs(0, 27).addBox(-4.0F, 0.0F, -2.0F, 8.0F, 14.0F, 4.0F, new CubeDeformation(0.0F))
				.texOffs(0, 55).addBox(-4.0F, 7.0F, -3.0F, 3.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(8, 55).addBox(1.0F, 7.0F, -3.0F, 3.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -12.0F, 0.0F));

		PartDefinition right_arm = Waist.addOrReplaceChild("right_arm", CubeListBuilder.create().texOffs(24, 27).addBox(-3.0F, -2.0F, -2.0F, 4.0F, 14.0F, 4.0F, new CubeDeformation(0.0F))
				.texOffs(0, 45).addBox(-2.0F, -3.0F, -2.5F, 5.0F, 5.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(-5.0F, -10.0F, 0.0F));

		PartDefinition left_arm = Waist.addOrReplaceChild("left_arm", CubeListBuilder.create().texOffs(40, 0).addBox(-1.0F, -2.0F, -2.0F, 4.0F, 14.0F, 4.0F, new CubeDeformation(0.0F))
				.texOffs(20, 45).addBox(-3.0F, -3.0F, -2.5F, 5.0F, 5.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(5.0F, -10.0F, 0.0F));

		PartDefinition Right_Leg = partdefinition.addOrReplaceChild("Right Leg", CubeListBuilder.create().texOffs(40, 18).addBox(-2.1F, 2.0F, -2.0F, 4.0F, 10.0F, 4.0F, new CubeDeformation(0.0F))
				.texOffs(50, 53).addBox(-2.1F, 9.0F, -3.0F, 4.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(-1.9F, 12.0F, 0.0F));

		PartDefinition Left_Leg = partdefinition.addOrReplaceChild("Left Leg", CubeListBuilder.create().texOffs(40, 32).addBox(-1.9F, 2.0F, -2.0F, 4.0F, 10.0F, 4.0F, new CubeDeformation(0.0F))
				.texOffs(40, 53).addBox(-1.9F, 9.0F, -3.0F, 4.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(1.9F, 12.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 64, 64);
	}

	@Override
	public void setupAnim(@NotNull T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		head.loadPose(headDefault);
		waist.loadPose(waistDefault);
		left_arm.loadPose(leftArmDefault);
		right_arm.loadPose(rightArmDefault);
		left_leg.loadPose(leftLegDefault);
		right_leg.loadPose(rightLegDefault);

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
			this.right_arm.xRot = -1.5708F + 0.3927F;
			this.right_arm.yRot = 0.0F;
			this.right_arm.zRot = 0.0F;
		}
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		waist.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		right_leg.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		left_leg.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}

	@Override
	public void translateToHand(HumanoidArm pSide, PoseStack pPoseStack) {
		this.root.translateAndRotate(pPoseStack);
		this.waist.translateAndRotate(pPoseStack);
		if (pSide == HumanoidArm.RIGHT) {
			this.right_arm.translateAndRotate(pPoseStack);
			pPoseStack.translate(-0.05, 0.25, -0.0);
			pPoseStack.scale(1.0F, 1.0F, 1.0F);
		}
	}

	@Override
	public ModelPart root() {
		return root;
	}
}