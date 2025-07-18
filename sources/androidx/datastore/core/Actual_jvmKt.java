package androidx.datastore.core;

import kotlin.Metadata;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.Dispatchers;
/* compiled from: Actual.jvm.kt */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\b\u0010\u0000\u001a\u00020\u0001H\u0000*\n\u0010\u0002\"\u00020\u00032\u00020\u0003¨\u0006\u0004"}, d2 = {"ioDispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "IOException", "Ljava/io/IOException;", "datastore-core_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class Actual_jvmKt {
    public static final CoroutineDispatcher ioDispatcher() {
        return Dispatchers.getIO();
    }
}
