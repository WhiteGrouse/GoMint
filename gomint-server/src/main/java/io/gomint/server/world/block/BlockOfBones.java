/*
 * Copyright (c) 2017, GoMint, BlackyPaw and geNAZt
 *
 * This code is licensed under the BSD license found in the
 * LICENSE file in the root directory of this source tree.
 */

package io.gomint.server.world.block;

import io.gomint.server.registry.RegisterInfo;
import io.gomint.world.block.BlockType;

/**
 * @author geNAZt
 * @version 1.0
 */
@RegisterInfo( id = 216 )
public class BlockOfBones extends Block implements io.gomint.world.block.BlockOfBones {

    @Override
    public int getBlockId() {
        return 216;
    }

    @Override
    public long getBreakTime() {
        return 3000;
    }

    @Override
    public float getBlastResistance() {
        return 10f;
    }

    @Override
    public BlockType getType() {
        return BlockType.BLOCK_OF_BONES;
    }

    @Override
    public boolean canBeBrokenWithHand() {
        return true;
    }

}
