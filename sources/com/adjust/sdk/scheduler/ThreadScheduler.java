package com.adjust.sdk.scheduler;
/* loaded from: classes3.dex */
public interface ThreadScheduler extends ThreadExecutor {
    void schedule(Runnable runnable, long j);
}
