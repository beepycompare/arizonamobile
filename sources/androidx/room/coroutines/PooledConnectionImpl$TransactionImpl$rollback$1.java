package androidx.room.coroutines;

import androidx.room.coroutines.PooledConnectionImpl;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ConnectionPoolImpl.kt */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "androidx.room.coroutines.PooledConnectionImpl$TransactionImpl", f = "ConnectionPoolImpl.kt", i = {0, 0}, l = {554}, m = "rollback", n = {"result", "$this$withLock_u24default$iv"}, s = {"L$0", "L$2"})
/* loaded from: classes3.dex */
public final class PooledConnectionImpl$TransactionImpl$rollback$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ PooledConnectionImpl.TransactionImpl<T> this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PooledConnectionImpl$TransactionImpl$rollback$1(PooledConnectionImpl.TransactionImpl<T> transactionImpl, Continuation<? super PooledConnectionImpl$TransactionImpl$rollback$1> continuation) {
        super(continuation);
        this.this$0 = transactionImpl;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.rollback(null, this);
    }
}
