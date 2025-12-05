package androidx.datastore.core;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlinx.coroutines.CompletableDeferred;
import kotlinx.coroutines.CompletableDeferredKt;
import kotlinx.coroutines.sync.Mutex;
import kotlinx.coroutines.sync.MutexKt;
/* compiled from: DataStoreImpl.kt */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\b \u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\t\u001a\u00020\bH¤@¢\u0006\u0002\u0010\nJ\u000e\u0010\u000b\u001a\u00020\bH\u0086@¢\u0006\u0002\u0010\nJ\u000e\u0010\f\u001a\u00020\bH\u0086@¢\u0006\u0002\u0010\nR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Landroidx/datastore/core/RunOnce;", "", "<init>", "()V", "runMutex", "Lkotlinx/coroutines/sync/Mutex;", "didRun", "Lkotlinx/coroutines/CompletableDeferred;", "", "doRun", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "awaitComplete", "runIfNeeded", "datastore-core"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes2.dex */
public abstract class RunOnce {
    private final Mutex runMutex = MutexKt.Mutex$default(false, 1, null);
    private final CompletableDeferred<Unit> didRun = CompletableDeferredKt.CompletableDeferred$default(null, 1, null);

    protected abstract Object doRun(Continuation<? super Unit> continuation);

    public final Object awaitComplete(Continuation<? super Unit> continuation) {
        Object await = this.didRun.await(continuation);
        return await == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? await : Unit.INSTANCE;
    }

    /* JADX WARN: Code restructure failed: missing block: B:25:0x005d, code lost:
        if (r8.lock(null, r0) == r1) goto L32;
     */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0026  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0045  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0068 A[Catch: all -> 0x0087, TRY_LEAVE, TryCatch #1 {all -> 0x0087, blocks: (B:27:0x0060, B:29:0x0068, B:32:0x006e), top: B:45:0x0060 }] */
    /* JADX WARN: Removed duplicated region for block: B:32:0x006e A[Catch: all -> 0x0087, TRY_ENTER, TRY_LEAVE, TryCatch #1 {all -> 0x0087, blocks: (B:27:0x0060, B:29:0x0068, B:32:0x006e), top: B:45:0x0060 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object runIfNeeded(Continuation<? super Unit> continuation) {
        RunOnce$runIfNeeded$1 runOnce$runIfNeeded$1;
        int i;
        Mutex mutex;
        Mutex mutex2;
        Throwable th;
        try {
            if (continuation instanceof RunOnce$runIfNeeded$1) {
                runOnce$runIfNeeded$1 = (RunOnce$runIfNeeded$1) continuation;
                if ((runOnce$runIfNeeded$1.label & Integer.MIN_VALUE) != 0) {
                    runOnce$runIfNeeded$1.label -= Integer.MIN_VALUE;
                    Object obj = runOnce$runIfNeeded$1.result;
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    i = runOnce$runIfNeeded$1.label;
                    if (i != 0) {
                        ResultKt.throwOnFailure(obj);
                        if (this.didRun.isCompleted()) {
                            return Unit.INSTANCE;
                        }
                        mutex = this.runMutex;
                        runOnce$runIfNeeded$1.L$0 = mutex;
                        runOnce$runIfNeeded$1.label = 1;
                    } else if (i != 1) {
                        if (i == 2) {
                            mutex2 = (Mutex) runOnce$runIfNeeded$1.L$0;
                            try {
                                ResultKt.throwOnFailure(obj);
                                this.didRun.complete(Unit.INSTANCE);
                                mutex2.unlock(null);
                                return Unit.INSTANCE;
                            } catch (Throwable th2) {
                                th = th2;
                                mutex2.unlock(null);
                                throw th;
                            }
                        }
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    } else {
                        ResultKt.throwOnFailure(obj);
                        mutex = (Mutex) runOnce$runIfNeeded$1.L$0;
                    }
                    if (this.didRun.isCompleted()) {
                        runOnce$runIfNeeded$1.L$0 = mutex;
                        runOnce$runIfNeeded$1.label = 2;
                        if (doRun(runOnce$runIfNeeded$1) != coroutine_suspended) {
                            mutex2 = mutex;
                            this.didRun.complete(Unit.INSTANCE);
                            mutex2.unlock(null);
                            return Unit.INSTANCE;
                        }
                        return coroutine_suspended;
                    }
                    Unit unit = Unit.INSTANCE;
                    mutex.unlock(null);
                    return unit;
                }
            }
            if (this.didRun.isCompleted()) {
            }
        } catch (Throwable th3) {
            mutex2 = mutex;
            th = th3;
            mutex2.unlock(null);
            throw th;
        }
        runOnce$runIfNeeded$1 = new RunOnce$runIfNeeded$1(this, continuation);
        Object obj2 = runOnce$runIfNeeded$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = runOnce$runIfNeeded$1.label;
        if (i != 0) {
        }
    }
}
