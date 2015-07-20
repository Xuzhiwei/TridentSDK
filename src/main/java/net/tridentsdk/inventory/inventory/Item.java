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

package net.tridentsdk.inventory.inventory;

import net.tridentsdk.base.Substance;

/**
 * Inventory item, holding all properties of the item
 *
 * @author The TridentSDK Team
 * @since 0.3-alpha-DP
 */
public class Item {
    private final int id;
    private final Substance substance;

    private volatile byte meta;
    private volatile short quantity;
    private volatile short damageValue;

    /**
     * Creates a new item with the specified substance and quantity 1, 0 data
     *
     * @param substance the substance for the item
     */
    public Item(Substance substance) {
        this(substance, (short) 1, (byte) 0);
    }

    /**
     * Creates a new item with the specified properties
     *
     * @param substance the substance
     * @param quantity the quantity
     * @param meta the meta
     */
    public Item(Substance substance, int quantity, byte meta) {
        if (substance == null) {
            substance = Substance.AIR;
            // The item is clicked on in the inventory
        }

        this.id = substance.id();
        this.substance = substance;

        this.meta = meta;
        this.quantity = (short) quantity;
        this.damageValue = (short) 100; // psudeo-value
    }

    public int id() {
        return this.id;
    }

    public Substance type() {
        return this.substance;
    }

    public byte meta() {
        return this.meta;
    }

    public void setMeta(byte meta) {
        this.meta = meta;
    }

    public short quantity() {
        return this.quantity;
    }

    public void setQuantity(short quantity) {
        this.quantity = quantity;
    }

    public short damageValue() {
        return this.damageValue;
    }

    public void setDamageValue(short damageValue) {
        this.damageValue = damageValue;
    }

    public boolean isSimilar(Item i) {
        if (id != i.id) {
            return false;
        } else if (substance != i.substance) {
            return false;
        } else if (quantity != i.quantity) {
            return false;
        } else if (damageValue != i.damageValue) {
            return false;
        }

        return true;
    }
}