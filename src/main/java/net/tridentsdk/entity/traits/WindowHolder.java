/*
 * Trident - A Multithreaded Server Alternative
 * Copyright 2014 The TridentSDK Team
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package net.tridentsdk.entity.traits;

import net.tridentsdk.entity.Entity;
import net.tridentsdk.inventory.Inventory;
import net.tridentsdk.inventory.Item;

/**
 * Represents an Entity that holds an Inventory
 *
 * @author TridentSDK Team
 */
public interface WindowHolder extends Entity {
    /**
     * The Inventory that this entity holds
     *
     * @return the Inventory that this entity holds
     */
    Inventory window();

    /**
     * Returns the ItemStack in the Player's hand
     *
     * @return ItemStack current ItemStack in the Player's hand
     */
    Item heldItem();

    /**
     * Sets the item held in the selected slot
     *
     * @param item the item to set
     */
    void setHeldItem(Item item);
}
