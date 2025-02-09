//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "F:\rusherhack"!

//Decompiled by Procyon!

package com.memphis.revenge.module.modules.combat;

import com.memphis.revenge.module.*;
import net.minecraft.block.*;
import com.memphis.revenge.setting.settings.*;
import net.minecraft.init.*;
import java.util.*;
import com.memphis.revenge.util.*;
import net.minecraft.entity.*;
import com.memphis.revenge.*;
import net.minecraft.item.*;
import net.minecraft.entity.item.*;
import java.util.stream.*;
import net.minecraft.network.*;
import net.minecraft.util.*;
import net.minecraft.client.multiplayer.*;
import net.minecraft.block.state.*;
import net.minecraft.network.play.client.*;
import net.minecraft.util.math.*;

public class Surround extends Module
{
    List<Block> whiteList;
    private BlockPos startPos;
    SettingBoolean sneak;
    SettingBoolean rotate;
    SettingBoolean center;
    SettingInteger bpt;
    
    public Surround() {
        super("Surround", "", 0, Module.Category.COMBAT);
        this.whiteList = Arrays.asList(Blocks.OBSIDIAN, Blocks.ENDER_CHEST);
        this.sneak = this.register("SneakOnly", false);
        this.rotate = this.register("Rotate", false);
        this.center = this.register("Center", true);
        this.bpt = this.register("BPT", 4, 1, 20);
    }
    
    public void onEnable() {
        this.startPos = EntityUtil.getRoundedBlockPos((Entity)Surround.mc.player);
        if (this.center.getValue()) {
            Revenge.positionManager.setPositionPacket(this.startPos.getX() + 0.5, (double)this.startPos.getY(), this.startPos.getZ() + 0.5, true, true, true);
        }
    }
    
    public void update() {
        if (Surround.mc.player == null) {
            return;
        }
        if (this.sneak.getValue() && !Surround.mc.gameSettings.keyBindSneak.isKeyDown()) {
            return;
        }
        final Vec3d vec3d = getInterpolatedPos((Entity)Surround.mc.player, 0.0f);
        BlockPos northBlockPos = new BlockPos(vec3d).north();
        BlockPos southBlockPos = new BlockPos(vec3d).south();
        BlockPos eastBlockPos = new BlockPos(vec3d).east();
        BlockPos westBlockPos = new BlockPos(vec3d).west();
        int blocksPlaced = 0;
        int newSlot = -1;
        for (int i = 0; i < 9; ++i) {
            final ItemStack stack = Surround.mc.player.inventory.getStackInSlot(i);
            if (stack != ItemStack.EMPTY) {
                if (stack.getItem() instanceof ItemBlock) {
                    final Block block = ((ItemBlock)stack.getItem()).getBlock();
                    if (this.whiteList.contains(block)) {
                        newSlot = i;
                        break;
                    }
                }
            }
        }
        if (newSlot == -1) {
            return;
        }
        final int oldSlot = Surround.mc.player.inventory.currentItem;
        Surround.mc.player.inventory.currentItem = newSlot;
        Label_0292: {
            if (!hasNeighbour(northBlockPos)) {
                for (final EnumFacing side : EnumFacing.values()) {
                    final BlockPos neighbour = northBlockPos.offset(side);
                    if (hasNeighbour(neighbour)) {
                        northBlockPos = neighbour;
                        break Label_0292;
                    }
                }
                return;
            }
        }
        Label_0355: {
            if (!hasNeighbour(southBlockPos)) {
                for (final EnumFacing side : EnumFacing.values()) {
                    final BlockPos neighbour = southBlockPos.offset(side);
                    if (hasNeighbour(neighbour)) {
                        southBlockPos = neighbour;
                        break Label_0355;
                    }
                }
                return;
            }
        }
        Label_0421: {
            if (!hasNeighbour(eastBlockPos)) {
                for (final EnumFacing side : EnumFacing.values()) {
                    final BlockPos neighbour = eastBlockPos.offset(side);
                    if (hasNeighbour(neighbour)) {
                        eastBlockPos = neighbour;
                        break Label_0421;
                    }
                }
                return;
            }
        }
        Label_0487: {
            if (!hasNeighbour(westBlockPos)) {
                for (final EnumFacing side : EnumFacing.values()) {
                    final BlockPos neighbour = westBlockPos.offset(side);
                    if (hasNeighbour(neighbour)) {
                        westBlockPos = neighbour;
                        break Label_0487;
                    }
                }
                return;
            }
        }
        if (Surround.mc.world.getBlockState(northBlockPos).getMaterial().isReplaceable()) {
            if (this.isEntitiesEmpty(northBlockPos)) {
                placeBlockScaffold(northBlockPos, this.rotate.getValue());
                ++blocksPlaced;
            }
            else if (this.isEntitiesEmpty(northBlockPos.north()) && Surround.mc.world.getBlockState(northBlockPos).getMaterial().isReplaceable()) {
                placeBlockScaffold(northBlockPos.north(), this.rotate.getValue());
                ++blocksPlaced;
            }
        }
        if (blocksPlaced >= this.bpt.getValue()) {
            Surround.mc.player.inventory.currentItem = oldSlot;
            return;
        }
        if (Surround.mc.world.getBlockState(southBlockPos).getMaterial().isReplaceable()) {
            if (this.isEntitiesEmpty(southBlockPos)) {
                placeBlockScaffold(southBlockPos, this.rotate.getValue());
                ++blocksPlaced;
            }
            else if (this.isEntitiesEmpty(southBlockPos.south()) && Surround.mc.world.getBlockState(southBlockPos.south()).getMaterial().isReplaceable()) {
                placeBlockScaffold(southBlockPos.south(), this.rotate.getValue());
                ++blocksPlaced;
            }
        }
        if (blocksPlaced >= this.bpt.getValue()) {
            Surround.mc.player.inventory.currentItem = oldSlot;
            return;
        }
        if (Surround.mc.world.getBlockState(eastBlockPos).getMaterial().isReplaceable()) {
            if (this.isEntitiesEmpty(eastBlockPos)) {
                placeBlockScaffold(eastBlockPos, this.rotate.getValue());
                ++blocksPlaced;
            }
            else if (this.isEntitiesEmpty(eastBlockPos.east()) && Surround.mc.world.getBlockState(eastBlockPos.east()).getMaterial().isReplaceable()) {
                placeBlockScaffold(eastBlockPos.east(), this.rotate.getValue());
                ++blocksPlaced;
            }
        }
        if (blocksPlaced >= this.bpt.getValue()) {
            Surround.mc.player.inventory.currentItem = oldSlot;
            return;
        }
        if (Surround.mc.world.getBlockState(westBlockPos).getMaterial().isReplaceable()) {
            if (this.isEntitiesEmpty(westBlockPos)) {
                placeBlockScaffold(westBlockPos, this.rotate.getValue());
            }
            else if (this.isEntitiesEmpty(westBlockPos.west()) && Surround.mc.world.getBlockState(westBlockPos.west()).getMaterial().isReplaceable()) {
                placeBlockScaffold(westBlockPos.west(), this.rotate.getValue());
            }
        }
        Surround.mc.player.inventory.currentItem = oldSlot;
    }
    
    public static boolean hasNeighbour(final BlockPos blockPos) {
        for (final EnumFacing side : EnumFacing.values()) {
            final BlockPos neighbour = blockPos.offset(side);
            if (!Surround.mc.world.getBlockState(neighbour).getMaterial().isReplaceable()) {
                return true;
            }
        }
        return false;
    }
    
    private boolean isEntitiesEmpty(final BlockPos pos) {
        final List<Entity> entities = (List<Entity>)Surround.mc.world.getEntitiesWithinAABBExcludingEntity((Entity)null, new AxisAlignedBB(pos)).stream().filter(e -> !(e instanceof EntityItem)).filter(e -> !(e instanceof EntityXPOrb)).collect(Collectors.toList());
        return entities.isEmpty();
    }
    
    public static boolean placeBlockScaffold(final BlockPos pos, final boolean rotate) {
        for (final EnumFacing side : EnumFacing.values()) {
            final BlockPos neighbor = pos.offset(side);
            final EnumFacing side2 = side.getOpposite();
            if (canBeClicked(neighbor)) {
                final Vec3d hitVec = new Vec3d((Vec3i)neighbor).add(0.5, 0.5, 0.5).add(new Vec3d(side2.getDirectionVec()).scale(0.5));
                if (rotate) {
                    Revenge.rotationManager.rotate(hitVec.x, hitVec.y, hitVec.z);
                }
                Surround.mc.player.connection.sendPacket((Packet)new CPacketEntityAction((Entity)Surround.mc.player, CPacketEntityAction.Action.START_SNEAKING));
                processRightClickBlock(neighbor, side2, hitVec);
                Surround.mc.player.swingArm(EnumHand.MAIN_HAND);
                Surround.mc.player.connection.sendPacket((Packet)new CPacketEntityAction((Entity)Surround.mc.player, CPacketEntityAction.Action.STOP_SNEAKING));
                if (rotate) {
                    Revenge.rotationManager.reset();
                }
                return true;
            }
        }
        return false;
    }
    
    private static PlayerControllerMP getPlayerController() {
        return Surround.mc.playerController;
    }
    
    private static void processRightClickBlock(final BlockPos pos, final EnumFacing side, final Vec3d hitVec) {
        getPlayerController().processRightClickBlock(Surround.mc.player, Surround.mc.world, pos, side, hitVec, EnumHand.MAIN_HAND);
    }
    
    private static IBlockState getState(final BlockPos pos) {
        return Surround.mc.world.getBlockState(pos);
    }
    
    private static Block getBlock(final BlockPos pos) {
        return getState(pos).getBlock();
    }
    
    private static boolean canBeClicked(final BlockPos pos) {
        return getBlock(pos).canCollideCheck(getState(pos), false);
    }
    
    public static void faceVectorPacketInstant(final Vec3d vec) {
        final float[] rotations = getNeededRotations2(vec);
        Surround.mc.player.connection.sendPacket((Packet)new CPacketPlayer.Rotation(rotations[0], rotations[1], Surround.mc.player.onGround));
    }
    
    private static float[] getNeededRotations2(final Vec3d vec) {
        final Vec3d eyesPos = getEyesPos();
        final double diffX = vec.x - eyesPos.x;
        final double diffY = vec.y - eyesPos.y;
        final double diffZ = vec.z - eyesPos.z;
        final double diffXZ = Math.sqrt(diffX * diffX + diffZ * diffZ);
        final float yaw = (float)Math.toDegrees(Math.atan2(diffZ, diffX)) - 90.0f;
        final float pitch = (float)(-Math.toDegrees(Math.atan2(diffY, diffXZ)));
        return new float[] { Surround.mc.player.rotationYaw + MathHelper.wrapDegrees(yaw - Surround.mc.player.rotationYaw), Surround.mc.player.rotationPitch + MathHelper.wrapDegrees(pitch - Surround.mc.player.rotationPitch) };
    }
    
    private static Vec3d getEyesPos() {
        return new Vec3d(Surround.mc.player.posX, Surround.mc.player.posY + Surround.mc.player.getEyeHeight(), Surround.mc.player.posZ);
    }
    
    public static Vec3d getInterpolatedPos(final Entity entity, final float ticks) {
        return new Vec3d(entity.lastTickPosX, entity.lastTickPosY, entity.lastTickPosZ).add(getInterpolatedAmount(entity, ticks));
    }
    
    private static Vec3d getInterpolatedAmount(final Entity entity, final double ticks) {
        return getInterpolatedAmount(entity, ticks, ticks, ticks);
    }
    
    private static Vec3d getInterpolatedAmount(final Entity entity, final double x, final double y, final double z) {
        return new Vec3d((entity.posX - entity.lastTickPosX) * x, (entity.posY - entity.lastTickPosY) * y, (entity.posZ - entity.lastTickPosZ) * z);
    }
}
