package androidx.room.coroutines;

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
/* compiled from: ConnectionPoolImpl.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "androidx.room.coroutines.Pool$acquireWithTimeout$2", f = "ConnectionPoolImpl.kt", i = {}, l = {209}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes3.dex */
public final class Pool$acquireWithTimeout$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Ref.ObjectRef<ConnectionWithLock> $connection;
    Object L$0;
    int label;
    final /* synthetic */ Pool this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Pool$acquireWithTimeout$2(Ref.ObjectRef<ConnectionWithLock> objectRef, Pool pool, Continuation<? super Pool$acquireWithTimeout$2> continuation) {
        super(2, continuation);
        this.$connection = objectRef;
        this.this$0 = pool;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new Pool$acquireWithTimeout$2(this.$connection, this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((Pool$acquireWithTimeout$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Ref.ObjectRef<ConnectionWithLock> objectRef;
        T t;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            Ref.ObjectRef<ConnectionWithLock> objectRef2 = this.$connection;
            this.L$0 = objectRef2;
            this.label = 1;
            Object acquire = this.this$0.acquire(this);
            if (acquire == coroutine_suspended) {
                return coroutine_suspended;
            }
            objectRef = objectRef2;
            t = acquire;
        } else if (i != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        } else {
            objectRef = (Ref.ObjectRef) this.L$0;
            ResultKt.throwOnFailure(obj);
            t = obj;
        }
        objectRef.element = t;
        return Unit.INSTANCE;
    }
}
