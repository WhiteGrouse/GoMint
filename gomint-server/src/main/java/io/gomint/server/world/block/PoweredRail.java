package io.gomint.server.world.block;

import io.gomint.world.block.BlockType;

import io.gomint.server.registry.RegisterInfo;

/**
 * @author geNAZt
 * @version 1.0
 */
@RegisterInfo( id = 27 )
public class PoweredRail extends Block implements io.gomint.world.block.BlockPoweredRail {

    @Override
    public int getBlockId() {
        return 27;
    }

    @Override
    public long getBreakTime() {
        return 1050;
    }

    @Override
    public boolean isTransparent() {
        return true;
    }

    @Override
    public boolean isSolid() {
        return false;
    }

    @Override
    public float getBlastResistance() {
        return 3.5f;
    }

    @Override
    public BlockType getType() {
        return BlockType.POWERED_RAIL;
    }

    @Override
    public boolean canBeBrokenWithHand() {
        return true;
    }

}
