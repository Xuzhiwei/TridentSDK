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

package net.tridentsdk.event.player;

import net.tridentsdk.event.Cancellable;
import net.tridentsdk.event.Event;
import net.tridentsdk.inventory.Inventory;

/**
 * Called when a player clicks an item inside a inventory
 *
 * @author The TridentSDK Team
 * @since 0.3-alpha-DP
 */
public class PlayerClickItemEvent extends Event implements Cancellable {
    private final Inventory window;
    private final short clickedSlot;
    private final int actionId;

    private boolean cancelled;

    public PlayerClickItemEvent(Inventory window, short clickedSlot, int actionId) {
        this.window = window;
        this.clickedSlot = clickedSlot;
        this.actionId = actionId;
        this.cancelled = false;
    }

    public Inventory window() {
        return this.window;
    }

    public short clickedSlot() {
        return this.clickedSlot;
    }

    public int actionId() {
        return this.actionId;
    }

    @Override
    public boolean isIgnored() {
        return cancelled;
    }

    @Override
    public void cancel(boolean cancelled) {
        this.cancelled = cancelled;
    }
}
