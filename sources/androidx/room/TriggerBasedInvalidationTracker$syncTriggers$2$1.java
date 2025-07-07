package androidx.room;

import androidx.room.ObservedTableStates;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: InvalidationTracker.kt */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "connection", "Landroidx/room/Transactor;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "androidx.room.TriggerBasedInvalidationTracker$syncTriggers$2$1", f = "InvalidationTracker.kt", i = {0}, l = {301, 309}, m = "invokeSuspend", n = {"connection"}, s = {"L$0"})
/* loaded from: classes3.dex */
public final class TriggerBasedInvalidationTracker$syncTriggers$2$1 extends SuspendLambda implements Function2<Transactor, Continuation<? super Unit>, Object> {
    /* synthetic */ Object L$0;
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

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0035, code lost:
        if (r8 == r0) goto L20;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0066, code lost:
        if (r1.withTransaction(androidx.room.Transactor.SQLiteTransactionType.IMMEDIATE, new androidx.room.TriggerBasedInvalidationTracker$syncTriggers$2$1.AnonymousClass1(r8, r7.this$0, r1, null), r7) == r0) goto L20;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0068, code lost:
        return r0;
     */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        Transactor transactor;
        ObservedTableStates observedTableStates;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            transactor = (Transactor) this.L$0;
            this.L$0 = transactor;
            this.label = 1;
            obj = transactor.inTransaction(this);
        } else if (i != 1) {
            if (i == 2) {
                ResultKt.throwOnFailure(obj);
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        } else {
            transactor = (Transactor) this.L$0;
            ResultKt.throwOnFailure(obj);
        }
        if (!((Boolean) obj).booleanValue()) {
            observedTableStates = this.this$0.observedTableStates;
            ObservedTableStates.ObserveOp[] tablesToSync$room_runtime_release = observedTableStates.getTablesToSync$room_runtime_release();
            if (tablesToSync$room_runtime_release != null) {
                this.L$0 = null;
                this.label = 2;
            }
            return Unit.INSTANCE;
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: InvalidationTracker.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00010\u0002H\n"}, d2 = {"<anonymous>", "", "Landroidx/room/TransactionScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "androidx.room.TriggerBasedInvalidationTracker$syncTriggers$2$1$1", f = "InvalidationTracker.kt", i = {0, 0, 1, 1}, l = {313, 314}, m = "invokeSuspend", n = {"$this$forEachIndexed$iv", "index$iv", "$this$forEachIndexed$iv", "index$iv"}, s = {"L$0", "I$0", "L$0", "I$0"})
    /* renamed from: androidx.room.TriggerBasedInvalidationTracker$syncTriggers$2$1$1  reason: invalid class name */
    /* loaded from: classes3.dex */
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<TransactionScope<Unit>, Continuation<? super Unit>, Object> {
        final /* synthetic */ Transactor $connection;
        final /* synthetic */ ObservedTableStates.ObserveOp[] $tablesToSync;
        int I$0;
        int I$1;
        int I$2;
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        final /* synthetic */ TriggerBasedInvalidationTracker this$0;

        /* compiled from: InvalidationTracker.kt */
        @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
        /* renamed from: androidx.room.TriggerBasedInvalidationTracker$syncTriggers$2$1$1$WhenMappings */
        /* loaded from: classes3.dex */
        public /* synthetic */ class WhenMappings {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0;

            static {
                int[] iArr = new int[ObservedTableStates.ObserveOp.values().length];
                try {
                    iArr[ObservedTableStates.ObserveOp.NO_OP.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    iArr[ObservedTableStates.ObserveOp.ADD.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                try {
                    iArr[ObservedTableStates.ObserveOp.REMOVE.ordinal()] = 3;
                } catch (NoSuchFieldError unused3) {
                }
                $EnumSwitchMapping$0 = iArr;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(ObservedTableStates.ObserveOp[] observeOpArr, TriggerBasedInvalidationTracker triggerBasedInvalidationTracker, Transactor transactor, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$tablesToSync = observeOpArr;
            this.this$0 = triggerBasedInvalidationTracker;
            this.$connection = transactor;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.$tablesToSync, this.this$0, this.$connection, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(TransactionScope<Unit> transactionScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(transactionScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code restructure failed: missing block: B:18:0x0067, code lost:
            if (r5 == r0) goto L20;
         */
        /* JADX WARN: Code restructure failed: missing block: B:23:0x0085, code lost:
            if (r5 == r0) goto L20;
         */
        /* JADX WARN: Code restructure failed: missing block: B:24:0x0087, code lost:
            return r0;
         */
        /* JADX WARN: Code restructure failed: missing block: B:25:0x0088, code lost:
            r6 = r12;
            r5 = r9;
         */
        /* JADX WARN: Removed duplicated region for block: B:12:0x003f  */
        /* JADX WARN: Removed duplicated region for block: B:29:0x0090  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:25:0x0088 -> B:26:0x008a). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:27:0x008d -> B:28:0x008e). Please submit an issue!!! */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object invokeSuspend(Object obj) {
            int i;
            ObservedTableStates.ObserveOp[] observeOpArr;
            TriggerBasedInvalidationTracker triggerBasedInvalidationTracker;
            Transactor transactor;
            int i2;
            int i3;
            Object startTrackingTable;
            Object stopTrackingTable;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i4 = this.label;
            if (i4 == 0) {
                ResultKt.throwOnFailure(obj);
                ObservedTableStates.ObserveOp[] observeOpArr2 = this.$tablesToSync;
                TriggerBasedInvalidationTracker triggerBasedInvalidationTracker2 = this.this$0;
                Transactor transactor2 = this.$connection;
                int length = observeOpArr2.length;
                i = 0;
                observeOpArr = observeOpArr2;
                triggerBasedInvalidationTracker = triggerBasedInvalidationTracker2;
                transactor = transactor2;
                i2 = length;
                i3 = 0;
                if (i3 >= i2) {
                }
            } else if (i4 != 1 && i4 != 2) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            } else {
                i2 = this.I$2;
                i3 = this.I$1;
                int i5 = this.I$0;
                Transactor transactor3 = (Transactor) this.L$2;
                triggerBasedInvalidationTracker = (TriggerBasedInvalidationTracker) this.L$1;
                observeOpArr = (ObservedTableStates.ObserveOp[]) this.L$0;
                ResultKt.throwOnFailure(obj);
                transactor = transactor3;
                i = i5;
                i3++;
                if (i3 >= i2) {
                    int i6 = i + 1;
                    int i7 = WhenMappings.$EnumSwitchMapping$0[observeOpArr[i3].ordinal()];
                    if (i7 == 1) {
                        i = i6;
                        i3++;
                        if (i3 >= i2) {
                            return Unit.INSTANCE;
                        }
                    } else {
                        if (i7 == 2) {
                            this.L$0 = observeOpArr;
                            this.L$1 = triggerBasedInvalidationTracker;
                            this.L$2 = transactor;
                            this.I$0 = i6;
                            this.I$1 = i3;
                            this.I$2 = i2;
                            this.label = 1;
                            startTrackingTable = triggerBasedInvalidationTracker.startTrackingTable(transactor, i, this);
                        } else if (i7 == 3) {
                            this.L$0 = observeOpArr;
                            this.L$1 = triggerBasedInvalidationTracker;
                            this.L$2 = transactor;
                            this.I$0 = i6;
                            this.I$1 = i3;
                            this.I$2 = i2;
                            this.label = 2;
                            stopTrackingTable = triggerBasedInvalidationTracker.stopTrackingTable(transactor, i, this);
                        } else {
                            throw new NoWhenBranchMatchedException();
                        }
                        transactor = transactor3;
                        i = i5;
                        i3++;
                        if (i3 >= i2) {
                        }
                    }
                }
            }
        }
    }
}
