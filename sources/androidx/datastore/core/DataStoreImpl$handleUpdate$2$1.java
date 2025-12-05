package androidx.datastore.core;

import androidx.datastore.core.Message;
import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
/* JADX INFO: Access modifiers changed from: package-private */
/* JADX INFO: Add missing generic type declarations: [T] */
/* compiled from: DataStoreImpl.kt */
@Metadata(d1 = {"\u0000\b\n\u0002\b\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "androidx.datastore.core.DataStoreImpl$handleUpdate$2$1", f = "DataStoreImpl.kt", i = {}, l = {256, 262, 265}, m = "invokeSuspend", n = {}, s = {}, v = 1)
/* loaded from: classes2.dex */
public final class DataStoreImpl$handleUpdate$2$1<T> extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super T>, Object> {
    final /* synthetic */ DataStoreImpl<T> $this_runCatching;
    final /* synthetic */ Message.Update<T> $update;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DataStoreImpl$handleUpdate$2$1(DataStoreImpl<T> dataStoreImpl, Message.Update<T> update, Continuation<? super DataStoreImpl$handleUpdate$2$1> continuation) {
        super(2, continuation);
        this.$this_runCatching = dataStoreImpl;
        this.$update = update;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new DataStoreImpl$handleUpdate$2$1(this.$this_runCatching, this.$update, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope coroutineScope, Object obj) {
        return invoke(coroutineScope, (Continuation) ((Continuation) obj));
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super T> continuation) {
        return ((DataStoreImpl$handleUpdate$2$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code restructure failed: missing block: B:38:0x008f, code lost:
        if (r6 == r0) goto L14;
     */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        Object readAndInitOrPropagateAndThrowFailure;
        Object transformAndWrite;
        Object transformAndWrite2;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            State<T> currentState = ((DataStoreImpl) this.$this_runCatching).inMemoryCache.getCurrentState();
            if (currentState instanceof Data) {
                this.label = 1;
                transformAndWrite = this.$this_runCatching.transformAndWrite(this.$update.getTransform(), this.$update.getCallerContext(), this);
                if (transformAndWrite != coroutine_suspended) {
                    return transformAndWrite;
                }
            } else if ((currentState instanceof ReadException) || (currentState instanceof UnInitialized)) {
                if (currentState == this.$update.getLastState()) {
                    this.label = 2;
                    readAndInitOrPropagateAndThrowFailure = this.$this_runCatching.readAndInitOrPropagateAndThrowFailure(this);
                } else {
                    throw ((ReadException) currentState).getReadException();
                }
            } else if (currentState instanceof Final) {
                throw ((Final) currentState).getFinalException();
            } else {
                if (currentState instanceof NoValueDataState) {
                    throw new IllegalStateException(DataStoreImpl.BUG_MESSAGE.toString());
                }
                throw new NoWhenBranchMatchedException();
            }
        } else if (i == 1) {
            ResultKt.throwOnFailure(obj);
            return obj;
        } else if (i != 2) {
            if (i == 3) {
                ResultKt.throwOnFailure(obj);
                return obj;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        } else {
            ResultKt.throwOnFailure(obj);
        }
        this.label = 3;
        transformAndWrite2 = this.$this_runCatching.transformAndWrite(this.$update.getTransform(), this.$update.getCallerContext(), this);
        return transformAndWrite2 == coroutine_suspended ? coroutine_suspended : transformAndWrite2;
    }
}
