package androidx.room.coroutines;

import androidx.room.Transactor;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.CoroutineScope;
/* JADX INFO: Access modifiers changed from: package-private */
/* JADX INFO: Add missing generic type declarations: [R] */
/* compiled from: ConnectionPoolImpl.kt */
@Metadata(d1 = {"\u0000\b\n\u0002\b\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "R", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "androidx.room.coroutines.ConnectionPoolImpl$useConnection$4", f = "ConnectionPoolImpl.kt", i = {}, l = {143}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes3.dex */
public final class ConnectionPoolImpl$useConnection$4<R> extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super R>, Object> {
    final /* synthetic */ Function2<Transactor, Continuation<? super R>, Object> $block;
    final /* synthetic */ Ref.ObjectRef<PooledConnectionImpl> $connection;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public ConnectionPoolImpl$useConnection$4(Function2<? super Transactor, ? super Continuation<? super R>, ? extends Object> function2, Ref.ObjectRef<PooledConnectionImpl> objectRef, Continuation<? super ConnectionPoolImpl$useConnection$4> continuation) {
        super(2, continuation);
        this.$block = function2;
        this.$connection = objectRef;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ConnectionPoolImpl$useConnection$4(this.$block, this.$connection, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope coroutineScope, Object obj) {
        return invoke(coroutineScope, (Continuation) ((Continuation) obj));
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super R> continuation) {
        return ((ConnectionPoolImpl$useConnection$4) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i != 0) {
            if (i == 1) {
                ResultKt.throwOnFailure(obj);
                return obj;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        PooledConnectionImpl pooledConnectionImpl = this.$connection.element;
        this.label = 1;
        Object invoke = this.$block.invoke(pooledConnectionImpl, this);
        return invoke == coroutine_suspended ? coroutine_suspended : invoke;
    }
}
