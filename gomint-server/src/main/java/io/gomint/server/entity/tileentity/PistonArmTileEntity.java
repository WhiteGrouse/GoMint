/*
 * Copyright (c) 2017, GoMint, BlackyPaw and geNAZt
 *
 * This code is licensed under the BSD license found in the
 * LICENSE file in the root directory of this source tree.
 */

package io.gomint.server.entity.tileentity;

import io.gomint.server.util.Things;
import io.gomint.server.world.block.Air;
import io.gomint.server.world.block.Block;
import io.gomint.server.world.block.PistonHead;
import io.gomint.taglib.NBTTagCompound;
import io.gomint.world.block.BlockFace;
import io.gomint.world.block.BlockType;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

/**
 * @author geNAZt
 * @version 1.0
 */
@ToString
public class PistonArmTileEntity extends TileEntity {

    // States
    private byte state;
    private byte newState;

    // Progress
    private float progess;
    private float lastProgress;

    // Block tracker
    private List<Object> attachedBlocks = new ArrayList<>();
    private List<Object> breakBlocks = new ArrayList<>();

    // Sticky
    private byte sticky;

    /**
     * Construct new tile entity from position and world data
     *
     * @param block which created this tile
     */
    public PistonArmTileEntity( Block block ) {
        super( block );
    }


    @Override
    public void fromCompound( NBTTagCompound compound ) {
        super.fromCompound( compound );

        this.state = compound.getByte( "State", (byte) 0 );
        this.newState = compound.getByte( "NewState", (byte) 0 );

        this.progess = compound.getFloat( "Progress", 0f );
        this.lastProgress = compound.getFloat( "LastProgress", 0f );

        this.attachedBlocks = compound.getList( "AttachedBlocks", false );
        this.breakBlocks = compound.getList( "BreakBlocks", false );

        this.sticky = compound.getByte( "Sticky", (byte) 0 );
    }

    @Override
    public void update( long currentMillis ) {
        Block piston = this.getBlock();
        BlockFace facing = Things.convertFromDataToBlockFace( piston.getBlockData() );

        if ( this.isExtended() ) {
            // We need a PistonHead
            Block above = piston.getSide( facing );
            if ( above.getType() != BlockType.PISTON_HEAD ) {
                PistonHead head = above.setType( PistonHead.class );
                head.setBlockData( piston.getBlockData() );
            }
        } else if ( !this.isExtended() ) {
            // We need air above
            Block above = piston.getSide( facing );
            if ( above.getType() == BlockType.PISTON_HEAD ) {
                above.setType( Air.class );
            }
        }
    }

    @Override
    public void toCompound( NBTTagCompound compound, SerializationReason reason ) {
        super.toCompound( compound, reason );

        compound.addValue( "id", "PistonArm" );

        // States
        compound.addValue( "State", this.state );
        compound.addValue( "NewState", this.newState );

        // Progress
        compound.addValue( "Progress", this.progess );
        compound.addValue( "LastProgress", this.lastProgress );

        // Sticky
        compound.addValue( "Sticky", this.sticky );

        // Blocks
        if ( this.breakBlocks != null ) {
            compound.addValue( "BreakBlocks", this.breakBlocks );
        }

        if ( this.attachedBlocks != null ) {
            compound.addValue( "AttachedBlocks", this.attachedBlocks );
        }
    }

    /**
     * Check if this piston is extended
     *
     * @return true when extended, false when not
     */
    public boolean isExtended() {
        return this.state > 0;
    }

    public void setExtended( boolean state ) {
        this.state = (byte) ( state ? 2 : 0 );
        this.newState = this.state;
        this.progess = state ? 1.0f : 0.0f;
        this.lastProgress = this.progess;
    }

}
