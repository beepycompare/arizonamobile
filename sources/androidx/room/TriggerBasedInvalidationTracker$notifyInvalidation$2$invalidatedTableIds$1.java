package androidx.room;

import android.database.SQLException;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.room.Transactor;
import java.util.Set;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.SetsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: InvalidationTracker.kt */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\"\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0004H\n"}, d2 = {"<anonymous>", "", "", "connection", "Landroidx/room/Transactor;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "androidx.room.TriggerBasedInvalidationTracker$notifyInvalidation$2$invalidatedTableIds$1", f = "InvalidationTracker.kt", i = {0}, l = {413, TypedValues.CycleType.TYPE_EASING}, m = "invokeSuspend", n = {"connection"}, s = {"L$0"})
/* loaded from: classes3.dex */
public final class TriggerBasedInvalidationTracker$notifyInvalidation$2$invalidatedTableIds$1 extends SuspendLambda implements Function2<Transactor, Continuation<? super Set<? extends Integer>>, Object> {
    /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ TriggerBasedInvalidationTracker this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TriggerBasedInvalidationTracker$notifyInvalidation$2$invalidatedTableIds$1(TriggerBasedInvalidationTracker triggerBasedInvalidationTracker, Continuation<? super TriggerBasedInvalidationTracker$notifyInvalidation$2$invalidatedTableIds$1> continuation) {
        super(2, continuation);
        this.this$0 = triggerBasedInvalidationTracker;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        TriggerBasedInvalidationTracker$notifyInvalidation$2$invalidatedTableIds$1 triggerBasedInvalidationTracker$notifyInvalidation$2$invalidatedTableIds$1 = new TriggerBasedInvalidationTracker$notifyInvalidation$2$invalidatedTableIds$1(this.this$0, continuation);
        triggerBasedInvalidationTracker$notifyInvalidation$2$invalidatedTableIds$1.L$0 = obj;
        return triggerBasedInvalidationTracker$notifyInvalidation$2$invalidatedTableIds$1;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final Object invoke2(Transactor transactor, Continuation<? super Set<Integer>> continuation) {
        return ((TriggerBasedInvalidationTracker$notifyInvalidation$2$invalidatedTableIds$1) create(transactor, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(Transactor transactor, Continuation<? super Set<? extends Integer>> continuation) {
        return invoke2(transactor, (Continuation<? super Set<Integer>>) continuation);
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x0035, code lost:
        if (r7 == r0) goto L20;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x005c, code lost:
        if (r7 == r0) goto L20;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x005e, code lost:
        return r0;
     */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        Transactor transactor;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        try {
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                transactor = (Transactor) this.L$0;
                this.L$0 = transactor;
                this.label = 1;
                obj = transactor.inTransaction(this);
            } else if (i != 1) {
                if (i == 2) {
                    ResultKt.throwOnFailure(obj);
                    return (Set) obj;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            } else {
                transactor = (Transactor) this.L$0;
                ResultKt.throwOnFailure(obj);
            }
            if (((Boolean) obj).booleanValue()) {
                return SetsKt.emptySet();
            }
            this.L$0 = null;
            this.label = 2;
            obj = transactor.withTransaction(Transactor.SQLiteTransactionType.IMMEDIATE, new AnonymousClass1(this.this$0, null), this);
        } catch (SQLException unused) {
            return SetsKt.emptySet();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: InvalidationTracker.kt */
    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\"\n\u0002\u0010\b\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u00010\u0003H\n"}, d2 = {"<anonymous>", "", "", "Landroidx/room/TransactionScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "androidx.room.TriggerBasedInvalidationTracker$notifyInvalidation$2$invalidatedTableIds$1$1", f = "InvalidationTracker.kt", i = {}, l = {421}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: androidx.room.TriggerBasedInvalidationTracker$notifyInvalidation$2$invalidatedTableIds$1$1  reason: invalid class name */
    /* loaded from: classes3.dex */
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<TransactionScope<Set<? extends Integer>>, Continuation<? super Set<? extends Integer>>, Object> {
        private /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ TriggerBasedInvalidationTracker this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(TriggerBasedInvalidationTracker triggerBasedInvalidationTracker, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.this$0 = triggerBasedInvalidationTracker;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.this$0, continuation);
            anonymousClass1.L$0 = obj;
            return anonymousClass1;
        }

        /* renamed from: invoke  reason: avoid collision after fix types in other method */
        public final Object invoke2(TransactionScope<Set<Integer>> transactionScope, Continuation<? super Set<Integer>> continuation) {
            return ((AnonymousClass1) create(transactionScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(TransactionScope<Set<? extends Integer>> transactionScope, Continuation<? super Set<? extends Integer>> continuation) {
            return invoke2((TransactionScope<Set<Integer>>) transactionScope, (Continuation<? super Set<Integer>>) continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object checkInvalidatedTables;
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
            this.label = 1;
            checkInvalidatedTables = this.this$0.checkInvalidatedTables((TransactionScope) this.L$0, this);
            return checkInvalidatedTables == coroutine_suspended ? coroutine_suspended : checkInvalidatedTables;
        }
    }
}
