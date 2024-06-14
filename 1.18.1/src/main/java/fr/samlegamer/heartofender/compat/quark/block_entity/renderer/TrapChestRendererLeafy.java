package fr.samlegamer.heartofender.compat.quark.block_entity.renderer;

import java.util.Calendar;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.math.Vector3f;

import fr.samlegamer.heartofender.compat.HoeCompats;
import fr.samlegamer.heartofender.core.HoeClient;
import it.unimi.dsi.fastutil.floats.Float2FloatFunction;
import it.unimi.dsi.fastutil.ints.Int2IntFunction;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.Sheets;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.client.renderer.blockentity.BrightnessCombiner;
import net.minecraft.client.resources.model.Material;
import net.minecraft.core.Direction;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.AbstractChestBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.ChestBlock;
import net.minecraft.world.level.block.DoubleBlockCombiner;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.ChestBlockEntity;
import net.minecraft.world.level.block.entity.LidBlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.ChestType;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class TrapChestRendererLeafy<T extends BlockEntity & LidBlockEntity> implements BlockEntityRenderer<T>
{
	   private final ModelPart lid;
	   private final ModelPart bottom;
	   private final ModelPart lock;
	   private final ModelPart doubleLeftLid;
	   private final ModelPart doubleLeftBottom;
	   private final ModelPart doubleLeftLock;
	   private final ModelPart doubleRightLid;
	   private final ModelPart doubleRightBottom;
	   private final ModelPart doubleRightLock;
	   private boolean xmasTextures;

	   public TrapChestRendererLeafy(BlockEntityRendererProvider.Context p_173607_)
	   {
	      Calendar calendar = Calendar.getInstance();
	      if (calendar.get(2) + 1 == 12 && calendar.get(5) >= 24 && calendar.get(5) <= 26) {
	         this.xmasTextures = true;
	      }
	      
	      ModelPart modelpart = p_173607_.bakeLayer(HoeClient.TRAP_LEAFY_CHEST);
	      this.bottom = modelpart.getChild("bottom");
	      this.lid = modelpart.getChild("lid");
	      this.lock = modelpart.getChild("lock");
	      ModelPart modelpart1 = p_173607_.bakeLayer(HoeClient.TRAP_LEAFY_CHEST_LEFT);
	      this.doubleLeftBottom = modelpart1.getChild("bottom");
	      this.doubleLeftLid = modelpart1.getChild("lid");
	      this.doubleLeftLock = modelpart1.getChild("lock");
	      ModelPart modelpart2 = p_173607_.bakeLayer(HoeClient.TRAP_LEAFY_CHEST_RIGHT);
	      this.doubleRightBottom = modelpart2.getChild("bottom");
	      this.doubleRightLid = modelpart2.getChild("lid");
	      this.doubleRightLock = modelpart2.getChild("lock");
	   }

	   public static LayerDefinition createSingleBodyLayer() {
	      MeshDefinition meshdefinition = new MeshDefinition();
	      PartDefinition partdefinition = meshdefinition.getRoot();
	      partdefinition.addOrReplaceChild("bottom", CubeListBuilder.create().texOffs(0, 19).addBox(1.0F, 0.0F, 1.0F, 14.0F, 10.0F, 14.0F), PartPose.ZERO);
	      partdefinition.addOrReplaceChild("lid", CubeListBuilder.create().texOffs(0, 0).addBox(1.0F, 0.0F, 0.0F, 14.0F, 5.0F, 14.0F), PartPose.offset(0.0F, 9.0F, 1.0F));
	      partdefinition.addOrReplaceChild("lock", CubeListBuilder.create().texOffs(0, 0).addBox(7.0F, -1.0F, 15.0F, 2.0F, 4.0F, 1.0F), PartPose.offset(0.0F, 8.0F, 0.0F));
	      return LayerDefinition.create(meshdefinition, 64, 64);
	   }

	   public static LayerDefinition createDoubleBodyRightLayer() {
	      MeshDefinition meshdefinition = new MeshDefinition();
	      PartDefinition partdefinition = meshdefinition.getRoot();
	      partdefinition.addOrReplaceChild("bottom", CubeListBuilder.create().texOffs(0, 19).addBox(1.0F, 0.0F, 1.0F, 15.0F, 10.0F, 14.0F), PartPose.ZERO);
	      partdefinition.addOrReplaceChild("lid", CubeListBuilder.create().texOffs(0, 0).addBox(1.0F, 0.0F, 0.0F, 15.0F, 5.0F, 14.0F), PartPose.offset(0.0F, 9.0F, 1.0F));
	      partdefinition.addOrReplaceChild("lock", CubeListBuilder.create().texOffs(0, 0).addBox(15.0F, -1.0F, 15.0F, 1.0F, 4.0F, 1.0F), PartPose.offset(0.0F, 8.0F, 0.0F));
	      return LayerDefinition.create(meshdefinition, 64, 64);
	   }

	   public static LayerDefinition createDoubleBodyLeftLayer() {
	      MeshDefinition meshdefinition = new MeshDefinition();
	      PartDefinition partdefinition = meshdefinition.getRoot();
	      partdefinition.addOrReplaceChild("bottom", CubeListBuilder.create().texOffs(0, 19).addBox(0.0F, 0.0F, 1.0F, 15.0F, 10.0F, 14.0F), PartPose.ZERO);
	      partdefinition.addOrReplaceChild("lid", CubeListBuilder.create().texOffs(0, 0).addBox(0.0F, 0.0F, 0.0F, 15.0F, 5.0F, 14.0F), PartPose.offset(0.0F, 9.0F, 1.0F));
	      partdefinition.addOrReplaceChild("lock", CubeListBuilder.create().texOffs(0, 0).addBox(0.0F, -1.0F, 15.0F, 1.0F, 4.0F, 1.0F), PartPose.offset(0.0F, 8.0F, 0.0F));
	      return LayerDefinition.create(meshdefinition, 64, 64);
	   }

	   public void render(T p_112363_, float p_112364_, PoseStack p_112365_, MultiBufferSource buff, int p_112367_, int p_112368_) {
	      Level level = p_112363_.getLevel();
	      boolean flag = level != null;
	      BlockState blockstate = flag ? p_112363_.getBlockState() : HoeCompats.Quark.leafy_chest.get().defaultBlockState().setValue(ChestBlock.FACING, Direction.SOUTH);
	      ChestType chesttype = blockstate.hasProperty(ChestBlock.TYPE) ? blockstate.getValue(ChestBlock.TYPE) : ChestType.SINGLE;
	      Block block = blockstate.getBlock();
	      if (block instanceof AbstractChestBlock) {
	         AbstractChestBlock<?> abstractchestblock = (AbstractChestBlock)block;
	         boolean flag1 = chesttype != ChestType.SINGLE;
	         p_112365_.pushPose();
	         float f = blockstate.getValue(ChestBlock.FACING).toYRot();
	         p_112365_.translate(0.5D, 0.5D, 0.5D);
	         p_112365_.mulPose(Vector3f.YP.rotationDegrees(-f));
	         p_112365_.translate(-0.5D, -0.5D, -0.5D);
	         DoubleBlockCombiner.NeighborCombineResult<? extends ChestBlockEntity> neighborcombineresult;
	         if (flag) {
	            neighborcombineresult = abstractchestblock.combine(blockstate, level, p_112363_.getBlockPos(), true);
	         } else {
	            neighborcombineresult = DoubleBlockCombiner.Combiner::acceptNone;
	         }
	         
	         float f1 = neighborcombineresult.<Float2FloatFunction>apply(ChestBlock.opennessCombiner(p_112363_)).get(p_112364_);
	         f1 = 1.0F - f1;
	         f1 = 1.0F - f1 * f1 * f1;
	         int i = neighborcombineresult.<Int2IntFunction>apply(new BrightnessCombiner<>()).applyAsInt(p_112367_);
	         
	         Material material = null;
	         
	       //this.getMaterial(p_112363_, chesttype);
	         switch(chesttype)
	         {
	         case SINGLE:
	        	 material = new Material(Sheets.CHEST_SHEET, ModelsChests.chooseChestTexture(EnumChestsTypes.TLEAFY, true));
	        	 break;
	         case LEFT:
	        	 material = new Material(Sheets.CHEST_SHEET, ModelsChests.chooseChestTexture(EnumChestsTypes.TLEAFY_LEFT, true));
	        	 break;
	         case RIGHT:
	        	 material = new Material(Sheets.CHEST_SHEET, ModelsChests.chooseChestTexture(EnumChestsTypes.TLEAFY_RIGHT, true));
	        	 break;
        	 default:
	        	 material = new Material(Sheets.CHEST_SHEET, ModelsChests.chooseChestTexture(EnumChestsTypes.TLEAFY, true));
        		 break;
	         }
	        

	         VertexConsumer vertexconsumer = material.buffer(buff, RenderType::entityCutout);
	         if (flag1) {
	            if (chesttype == ChestType.LEFT) {
	               this.render(p_112365_, vertexconsumer, this.doubleLeftLid, this.doubleLeftLock, this.doubleLeftBottom, f1, i, p_112368_);
	            } else {
	               this.render(p_112365_, vertexconsumer, this.doubleRightLid, this.doubleRightLock, this.doubleRightBottom, f1, i, p_112368_);
	            }
	         } else {
	            this.render(p_112365_, vertexconsumer, this.lid, this.lock, this.bottom, f1, i, p_112368_);
	         }

	         p_112365_.popPose();
	      }
	   }

	   private void render(PoseStack p_112370_, VertexConsumer p_112371_, ModelPart p_112372_, ModelPart p_112373_, ModelPart p_112374_, float p_112375_, int p_112376_, int p_112377_) {
	      p_112372_.xRot = -(p_112375_ * ((float)Math.PI / 2F));
	      p_112373_.xRot = p_112372_.xRot;
	      p_112372_.render(p_112370_, p_112371_, p_112376_, p_112377_);
	      p_112373_.render(p_112370_, p_112371_, p_112376_, p_112377_);
	      p_112374_.render(p_112370_, p_112371_, p_112376_, p_112377_);
	   }
}