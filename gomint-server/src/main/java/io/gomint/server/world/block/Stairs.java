package io.gomint.server.world.block;

import io.gomint.math.AxisAlignedBB;
import io.gomint.server.world.block.state.BooleanBlockState;
import io.gomint.server.world.block.state.FacingBlockState;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Collections;
import java.util.List;

/**
 * @author geNAZt
 * @version 1.0
 */
public abstract class Stairs extends Block {

    private final FacingBlockState facing = new FacingBlockState( this, (short) 1 );
    private final BooleanBlockState top = new BooleanBlockState( this, states -> true, 2 );

    @Override
    public boolean isTransparent() {
        return true;
    }

    @Override
    public List<AxisAlignedBB> getBoundingBox() {
        //LOGGER.info( "Position: {} - Data: {}", this.location, this.getBlockData() );

        return Collections.singletonList( new AxisAlignedBB(
            this.location.getX(),
            this.location.getY(),
            this.location.getZ(),
            this.location.getX() + 1,
            this.location.getY() + .5f,
            this.location.getZ() + 1
        ) );
    }

}
