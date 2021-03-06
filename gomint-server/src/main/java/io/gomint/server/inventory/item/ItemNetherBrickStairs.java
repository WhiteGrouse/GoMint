package io.gomint.server.inventory.item;
import io.gomint.inventory.item.ItemType;

import io.gomint.server.registry.RegisterInfo;
import io.gomint.taglib.NBTTagCompound;

/**
 * @author geNAZt
 * @version 1.0
 */
@RegisterInfo( id = 114 )
 public class ItemNetherBrickStairs extends ItemStack implements io.gomint.inventory.item.ItemNetherBrickStairs {



    @Override
    public String getBlockId() {
        return "minecraft:nether_brick_stairs";
    }

    @Override
    public ItemType getType() {
        return ItemType.NETHER_BRICK_STAIRS;
    }

}
