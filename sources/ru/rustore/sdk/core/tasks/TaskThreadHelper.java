package ru.rustore.sdk.core.tasks;

import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
/* compiled from: TaskThreadHelper.kt */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u001b\u0010\u0003\u001a\u00020\u00048FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006R\u001b\u0010\t\u001a\u00020\n8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\r\u0010\b\u001a\u0004\b\u000b\u0010\f¨\u0006\u000e"}, d2 = {"Lru/rustore/sdk/core/tasks/TaskThreadHelper;", "", "()V", "executorService", "Ljava/util/concurrent/ScheduledThreadPoolExecutor;", "getExecutorService", "()Ljava/util/concurrent/ScheduledThreadPoolExecutor;", "executorService$delegate", "Lkotlin/Lazy;", "mainHandler", "Landroid/os/Handler;", "getMainHandler", "()Landroid/os/Handler;", "mainHandler$delegate", "sdk-public-core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class TaskThreadHelper {
    public static final TaskThreadHelper INSTANCE = new TaskThreadHelper();
    private static final Lazy executorService$delegate = LazyKt.lazy(new Function0<ScheduledThreadPoolExecutor>() { // from class: ru.rustore.sdk.core.tasks.TaskThreadHelper$executorService$2
        @Override // kotlin.jvm.functions.Function0
        public final ScheduledThreadPoolExecutor invoke() {
            return new ScheduledThreadPoolExecutor(1);
        }
    });
    private static final Lazy mainHandler$delegate = LazyKt.lazy(new Function0<Handler>() { // from class: ru.rustore.sdk.core.tasks.TaskThreadHelper$mainHandler$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final Handler invoke() {
            return new Handler(Looper.getMainLooper());
        }
    });

    private TaskThreadHelper() {
    }

    public final ScheduledThreadPoolExecutor getExecutorService() {
        return (ScheduledThreadPoolExecutor) executorService$delegate.getValue();
    }

    public final Handler getMainHandler() {
        return (Handler) mainHandler$delegate.getValue();
    }
}
