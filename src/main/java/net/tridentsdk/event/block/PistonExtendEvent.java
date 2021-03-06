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

package net.tridentsdk.event.block;

import com.google.common.collect.ImmutableList;
import net.tridentsdk.base.Block;
import net.tridentsdk.base.BlockDirection;

import java.util.List;

/**
 * This event occurs when a piston becomes extended
 *
 * @author The TridentSDK Team
 * @since 0.3-alpha-DP
 */
public class PistonExtendEvent extends BlockPistonEvent {
    private final ImmutableList<Block> blocksInfluenced;
    private boolean cancelled;

    public PistonExtendEvent(Block block, BlockDirection direction, List<Block> influenced) {
        super(block, direction, false, influenced.get(0));

        this.blocksInfluenced = ImmutableList.copyOf(influenced);
    }

    @Override
    public boolean isIgnored() {
        return cancelled;
    }

    @Override
    public void cancel(boolean cancelled) {
        this.cancelled = cancelled;
    }

    /**
     * Returns an ImmutableList of the blocks that are being pushed by this piston, may be empty
     */
    public List<Block> blocksInfluenced() {
        return this.blocksInfluenced;
    }
}
