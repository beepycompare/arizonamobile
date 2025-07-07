package io.appmetrica.analytics.coreutils.internal.executors;

import java.util.concurrent.Executor;
/* loaded from: classes4.dex */
public class BlockingExecutor implements Executor {
    @Override // java.util.concurrent.Executor
    public void execute(Runnable runnable) {
        if (runnable != null) {
            runnable.run();
        }
    }
}
