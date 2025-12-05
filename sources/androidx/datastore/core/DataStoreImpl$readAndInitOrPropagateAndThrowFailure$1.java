package androidx.datastore.core;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: DataStoreImpl.kt */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "androidx.datastore.core.DataStoreImpl", f = "DataStoreImpl.kt", i = {1}, l = {284, 286}, m = "readAndInitOrPropagateAndThrowFailure", n = {"preReadVersion"}, s = {"I$0"}, v = 1)
/* loaded from: classes2.dex */
public final class DataStoreImpl$readAndInitOrPropagateAndThrowFailure$1 extends ContinuationImpl {
    int I$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ DataStoreImpl<T> this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DataStoreImpl$readAndInitOrPropagateAndThrowFailure$1(DataStoreImpl<T> dataStoreImpl, Continuation<? super DataStoreImpl$readAndInitOrPropagateAndThrowFailure$1> continuation) {
        super(continuation);
        this.this$0 = dataStoreImpl;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object readAndInitOrPropagateAndThrowFailure;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        readAndInitOrPropagateAndThrowFailure = this.this$0.readAndInitOrPropagateAndThrowFailure(this);
        return readAndInitOrPropagateAndThrowFailure;
    }
}
