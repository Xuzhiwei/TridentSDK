package net.tridentsdk.api.scheduling;

import net.tridentsdk.api.Trident;
import net.tridentsdk.plugin.TridentPlugin;

import java.util.concurrent.atomic.AtomicLong;

public abstract class TridentRunnable implements Runnable {

    /**
     * Id of this runnable, unique to this runtime
     */
    private int id;

    private AtomicLong interval = new AtomicLong();

    /**
     * Guaranteed to be run before this Runnable on the main thread, even if this runnable
     * is going to be run asynchronously, useful for collecting resources to work on.
     */
    public void prerunSync() {};

    /**
     * Runs after this runnable has finished, asynchronously
     */
    public void runAfterAsync() {};

    /**
     * Runs after this runnable has finished, synchronously
     */
    public void runAfterSync() {};

    public final synchronized TridentRunnable runTaskSynchronously(TridentPlugin plugin) {
        checkState();
        return Trident.getServer().getScheduler().runTaskSynchronously(plugin, this);
    }

    public final synchronized TridentRunnable runTaskAsynchronously(TridentPlugin plugin) {
        checkState();

        return Trident.getServer().getScheduler().runTaskAsynchronously(plugin, this);
    }

    public final synchronized TridentRunnable runTaskSyncLater(TridentPlugin plugin, long delay) {
        checkState();
        return Trident.getServer().getScheduler().runTaskSyncLater(plugin, this, delay);
    }

    public final synchronized TridentRunnable runTaskAsyncLater(TridentPlugin plugin, long delay) {
        checkState();
        return Trident.getServer().getScheduler().runTaskAsyncLater(plugin, this, delay);
    }

    public final synchronized TridentRunnable runTaskSyncRepeating(TridentPlugin plugin, long delay, long interval) {
        checkState();
        Trident.getServer().getScheduler().runTaskSyncRepeating(plugin, this, delay,interval);
        this.interval.set(interval);
        return this;
    }

    public final synchronized TridentRunnable runTaskAsyncRepeating(TridentPlugin plugin, long delay, long interval) {
        checkState();
        Trident.getServer().getScheduler().runTaskAsyncRepeating(plugin, this, delay,interval);
        this.interval.set(interval);
        return this;
    }

    private void checkState() {
        if(this.id != -1) {
            throw new IllegalStateException("This runnable has already been scheduled!");
        }
    }

    public final void cancel() {
        Trident.getServer().getScheduler().cancel(this.id);
    }

    /**
     * Gets how long between runs this is supposed to wait if it is a repeating task
     * @return
     */
    public final synchronized long getInterval() {
        return interval.get();
    }

    /**
     * Sets how long this runnable should wait between executions if this is a repeating task
     * @param interval
     */
    public final synchronized void setInterval(long interval) {
        this.interval.set(interval);
    }


    /**
     * Used internally to refer to this runnable, probably shouldn't be used by plugins
     * @return
     */
    public final int getId() {
        return id;
    }


}
