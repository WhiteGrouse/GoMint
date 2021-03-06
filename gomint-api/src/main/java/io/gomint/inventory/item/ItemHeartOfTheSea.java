package io.gomint.inventory.item;

import io.gomint.GoMint;

public interface ItemHeartOfTheSea extends ItemStack {

    /**
     * Creates a new item stack with given class and amount
     *
     * @param amount which is used for the creation
     */
    static ItemHeartOfTheSea create( int amount ) {
        return GoMint.instance().createItemStack( ItemHeartOfTheSea.class, amount );
    }
}
