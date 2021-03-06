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
package net.tridentsdk.effect.particle;

import net.tridentsdk.effect.RemoteEffect;
import net.tridentsdk.util.Vector;

/**
 * Represents a particle effect
 *
 * @author The TridentSDK Team
 * @since 0.4-alpha
 */
public interface ParticleEffect extends RemoteEffect<ParticleEffectType> {
    /**
     * Set the count how many of the effects should be spawned
     *
     * @param count The count how many should be spawned
     */
    void setCount(int count);

    /**
     * Set the particle to be long distance<br>
     * Increases distance from 256 to 65536
     *
     * @param longDistance Whether the particle should be long distance
     */
    void setLongDistance(boolean longDistance);

    /**
     * Set the data of the particle<br>
     * Only used for ICON_CRACK, BLOCK_CRACK and BLOCK_DUST<br>
     * ICON_CRACK requires array of two integers<br>
     * BLOCK_CRACK and BLOCK_DUST requires an array of a single integer
     *
     * @param data Data of the particle
     */
    void setData(int[] data);

    /**
     * The randomized offset for each particle<br>
     * If multiple particles are spawned, this will be re-run for each
     *
     * @param offset The offset for each particle
     */
    void setOffset(Vector offset);

    /**
     * Returns the count of how many particles will be spawned
     *
     * @return The count of how many particles will be spawned
     */
    int count();

    /**
     * Returns whether the particle should be long distance
     *
     * @return Whether the particle should be long distance
     */
    boolean longDistance();

    /**
     * Returns the data of the particle
     *
     * @return The data of the particle
     */
    int[] data();

    /**
     * Returns the offset for each particle
     *
     * @return The offset for each particle
     */
    Vector offset();
}
