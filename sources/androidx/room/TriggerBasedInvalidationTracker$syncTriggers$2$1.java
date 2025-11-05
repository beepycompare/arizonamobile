package androidx.room;

import androidx.room.ObservedTableStates;
import androidx.room.Transactor;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: InvalidationTracker.kt */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "connection", "Landroidx/room/Transactor;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "androidx.room.TriggerBasedInvalidationTracker$syncTriggers$2$1", f = "InvalidationTracker.kt", i = {0, 1, 1}, l = {307, 314}, m = "invokeSuspend", n = {"connection", "this_$iv", "$this$withLock$iv$iv"}, s = {"L$0", "L$0", "L$1"})
/* loaded from: classes3.dex */
public final class TriggerBasedInvalidationTracker$syncTriggers$2$1 extends SuspendLambda implements Function2<Transactor, Continuation<? super Unit>, Object> {
    /* synthetic */ Object L$0;
    Object L$1;
    int label;
    final /* synthetic */ TriggerBasedInvalidationTracker this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TriggerBasedInvalidationTracker$syncTriggers$2$1(TriggerBasedInvalidationTracker triggerBasedInvalidationTracker, Continuation<? super TriggerBasedInvalidationTracker$syncTriggers$2$1> continuation) {
        super(2, continuation);
        this.this$0 = triggerBasedInvalidationTracker;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        TriggerBasedInvalidationTracker$syncTriggers$2$1 triggerBasedInvalidationTracker$syncTriggers$2$1 = new TriggerBasedInvalidationTracker$syncTriggers$2$1(this.this$0, continuation);
        triggerBasedInvalidationTracker$syncTriggers$2$1.L$0 = obj;
        return triggerBasedInvalidationTracker$syncTriggers$2$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Transactor transactor, Continuation<? super Unit> continuation) {
        return ((TriggerBasedInvalidationTracker$syncTriggers$2$1) create(transactor, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x0047, code lost:
        if (r6 == r0) goto L46;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x00b4, code lost:
        if (r14 != false) goto L38;
     */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        Transactor transactor;
        Object inTransaction;
        ObservedTableStates observedTableStates;
        ReentrantLock reentrantLock;
        ObservedTableStates.ObserveOp[] observeOpArr;
        ObservedTableStates.ObserveOp observeOp;
        ObservedTableStates observedTableStates2;
        ReentrantLock reentrantLock2;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        boolean z = true;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            transactor = (Transactor) this.L$0;
            this.L$0 = transactor;
            this.label = 1;
            inTransaction = transactor.inTransaction(this);
        } else if (i != 1) {
            if (i == 2) {
                reentrantLock2 = (ReentrantLock) this.L$1;
                observedTableStates2 = (ObservedTableStates) this.L$0;
                try {
                    ResultKt.throwOnFailure(obj);
                    reentrantLock = reentrantLock2;
                    observedTableStates = observedTableStates2;
                    observedTableStates.inProgressSync = false;
                    Unit unit = Unit.INSTANCE;
                    reentrantLock.unlock();
                    return Unit.INSTANCE;
                } catch (Throwable th) {
                    th = th;
                    try {
                        observedTableStates2.inProgressSync = false;
                        throw th;
                    } catch (Throwable th2) {
                        th = th2;
                        reentrantLock = reentrantLock2;
                        reentrantLock.unlock();
                        throw th;
                    }
                }
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        } else {
            transactor = (Transactor) this.L$0;
            ResultKt.throwOnFailure(obj);
            inTransaction = obj;
        }
        if (!((Boolean) inTransaction).booleanValue()) {
            observedTableStates = this.this$0.observedTableStates;
            TriggerBasedInvalidationTracker triggerBasedInvalidationTracker = this.this$0;
            reentrantLock = observedTableStates.onSyncLock;
            reentrantLock.lock();
            try {
                observedTableStates.inProgressSync = true;
                ReentrantLock reentrantLock3 = observedTableStates.lock;
                reentrantLock3.lock();
                if (observedTableStates.needsSync) {
                    observedTableStates.needsSync = false;
                    int length = observedTableStates.tableObserversCount.length;
                    observeOpArr = new ObservedTableStates.ObserveOp[length];
                    int i2 = 0;
                    boolean z2 = false;
                    while (i2 < length) {
                        boolean z3 = observedTableStates.tableObserversCount[i2] > 0 ? z : false;
                        if (z3 != observedTableStates.tableObservedState[i2]) {
                            observedTableStates.tableObservedState[i2] = z3;
                            observeOp = z3 ? ObservedTableStates.ObserveOp.ADD : ObservedTableStates.ObserveOp.REMOVE;
                            z2 = true;
                        } else {
                            observeOp = ObservedTableStates.ObserveOp.NO_OP;
                        }
                        observeOpArr[i2] = observeOp;
                        i2++;
                        z = true;
                    }
                }
                observeOpArr = null;
                reentrantLock3.unlock();
                if (observeOpArr != null) {
                    try {
                        if (observeOpArr.length != 0) {
                            this.L$0 = observedTableStates;
                            this.L$1 = reentrantLock;
                            this.label = 2;
                            if (transactor.withTransaction(Transactor.SQLiteTransactionType.IMMEDIATE, new TriggerBasedInvalidationTracker$syncTriggers$2$1$1$1(observeOpArr, triggerBasedInvalidationTracker, transactor, null), this) != coroutine_suspended) {
                                observedTableStates2 = observedTableStates;
                                reentrantLock2 = reentrantLock;
                                reentrantLock = reentrantLock2;
                                observedTableStates = observedTableStates2;
                            }
                            return coroutine_suspended;
                        }
                    } catch (Throwable th3) {
                        th = th3;
                        observedTableStates2 = observedTableStates;
                        reentrantLock2 = reentrantLock;
                        observedTableStates2.inProgressSync = false;
                        throw th;
                    }
                }
                observedTableStates.inProgressSync = false;
                Unit unit2 = Unit.INSTANCE;
                reentrantLock.unlock();
                return Unit.INSTANCE;
            } catch (Throwable th4) {
                th = th4;
                reentrantLock.unlock();
                throw th;
            }
        }
        return Unit.INSTANCE;
    }
}
