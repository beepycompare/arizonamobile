package androidx.datastore.core;

import kotlin.Metadata;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.Dispatchers;
/* compiled from: Actual.jvm.kt */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\b\u0010\u0002\u001a\u00020\u0003H\u0000*\n\u0010\u0000\"\u00020\u00012\u00020\u0001¨\u0006\u0004"}, d2 = {"IOException", "Ljava/io/IOException;", "ioDispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "datastore-core"}, k = 2, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class Actual_jvmKt {
    public static final CoroutineDispatcher ioDispatcher() {
        return Dispatchers.getIO();
    }
}
