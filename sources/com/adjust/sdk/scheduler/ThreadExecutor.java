package com.adjust.sdk.scheduler;
/* loaded from: classes3.dex */
public interface ThreadExecutor {
    void submit(Runnable runnable);

    void teardown();
}
