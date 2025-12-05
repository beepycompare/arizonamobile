package androidx.datastore.core;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: DataStoreImpl.kt */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "androidx.datastore.core.DataStoreImpl", f = "DataStoreImpl.kt", i = {0}, l = {566}, m = "incrementCollector", n = {"$this$withLock_u24default$iv"}, s = {"L$0"}, v = 1)
/* loaded from: classes2.dex */
public final class DataStoreImpl$incrementCollector$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ DataStoreImpl<T> this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DataStoreImpl$incrementCollector$1(DataStoreImpl<T> dataStoreImpl, Continuation<? super DataStoreImpl$incrementCollector$1> continuation) {
        super(continuation);
        this.this$0 = dataStoreImpl;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object incrementCollector;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        incrementCollector = this.this$0.incrementCollector(this);
        return incrementCollector;
    }
}
