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

package net.tridentsdk.event.weather;

import net.tridentsdk.event.Cancellable;
import net.tridentsdk.event.Event;
import net.tridentsdk.world.World;

/**
 * Called when an event relating to the world occurs
 *
 * <p>This is an umbrella event, do not listen to it</p>
 *
 * @author The TridentSDK Team
 * @since 0.3-alpha-DP
 */
public class WeatherEvent extends Event implements Cancellable {
    public final World world;
    private boolean cancelled;

    public WeatherEvent(World world) {
        this.world = world;
    }

    public World world() {
        return this.world;
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
