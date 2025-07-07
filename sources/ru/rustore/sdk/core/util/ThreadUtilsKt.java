package ru.rustore.sdk.core.util;

import java.util.concurrent.Executor;
import kotlin.Metadata;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.ExecutorsKt;
/* compiled from: ThreadUtils.kt */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\f\u0010\u0000\u001a\u00020\u0001*\u0004\u0018\u00010\u0002¨\u0006\u0003"}, d2 = {"asCoroutineDispatcherOrMain", "Lkotlinx/coroutines/CoroutineDispatcher;", "Ljava/util/concurrent/Executor;", "sdk-public-core_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class ThreadUtilsKt {
    public static final CoroutineDispatcher asCoroutineDispatcherOrMain(Executor executor) {
        CoroutineDispatcher from;
        return (executor == null || (from = ExecutorsKt.from(executor)) == null) ? Dispatchers.getMain() : from;
    }
}
