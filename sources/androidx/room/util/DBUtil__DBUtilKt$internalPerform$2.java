package androidx.room.util;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.room.PooledConnection;
import androidx.room.RoomDatabase;
import androidx.room.Transactor;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
/* JADX INFO: Add missing generic type declarations: [R] */
/* compiled from: DBUtil.kt */
@Metadata(d1 = {"\u0000\b\n\u0002\b\u0003\n\u0002\u0018\u0002\u0010\u0000\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "R", "transactor", "Landroidx/room/Transactor;"}, k = 3, mv = {2, 0, 0}, xi = 176)
@DebugMetadata(c = "androidx.room.util.DBUtil__DBUtilKt$internalPerform$2", f = "DBUtil.kt", i = {0, 0, 1, 1, 2, 3}, l = {56, 57, 59, 60, ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_HEIGHT}, m = "invokeSuspend", n = {"transactor", "type", "transactor", "type", "transactor", "result"}, s = {"L$0", "L$1", "L$0", "L$1", "L$0", "L$0"})
/* loaded from: classes3.dex */
public final class DBUtil__DBUtilKt$internalPerform$2<R> extends SuspendLambda implements Function2<Transactor, Continuation<? super R>, Object> {
    final /* synthetic */ Function2<PooledConnection, Continuation<? super R>, Object> $block;
    final /* synthetic */ boolean $inTransaction;
    final /* synthetic */ boolean $isReadOnly;
    final /* synthetic */ RoomDatabase $this_internalPerform;
    /* synthetic */ Object L$0;
    Object L$1;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public DBUtil__DBUtilKt$internalPerform$2(boolean z, boolean z2, RoomDatabase roomDatabase, Function2<? super PooledConnection, ? super Continuation<? super R>, ? extends Object> function2, Continuation<? super DBUtil__DBUtilKt$internalPerform$2> continuation) {
        super(2, continuation);
        this.$inTransaction = z;
        this.$isReadOnly = z2;
        this.$this_internalPerform = roomDatabase;
        this.$block = function2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        DBUtil__DBUtilKt$internalPerform$2 dBUtil__DBUtilKt$internalPerform$2 = new DBUtil__DBUtilKt$internalPerform$2(this.$inTransaction, this.$isReadOnly, this.$this_internalPerform, this.$block, continuation);
        dBUtil__DBUtilKt$internalPerform$2.L$0 = obj;
        return dBUtil__DBUtilKt$internalPerform$2;
    }

    public final Object invoke(Transactor transactor, Continuation<? super R> continuation) {
        return ((DBUtil__DBUtilKt$internalPerform$2) create(transactor, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(Transactor transactor, Object obj) {
        return invoke(transactor, (Continuation) ((Continuation) obj));
    }

    /* JADX WARN: Code restructure failed: missing block: B:32:0x0092, code lost:
        if (r8.$this_internalPerform.getInvalidationTracker().sync$room_runtime_release(r8) == r0) goto L24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x00b2, code lost:
        if (r9 == r0) goto L24;
     */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00d1  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        Transactor.SQLiteTransactionType sQLiteTransactionType;
        Transactor transactor;
        Transactor.SQLiteTransactionType sQLiteTransactionType2;
        Transactor transactor2;
        Object obj2;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            Transactor transactor3 = (Transactor) this.L$0;
            if (this.$inTransaction) {
                if (this.$isReadOnly) {
                    sQLiteTransactionType = Transactor.SQLiteTransactionType.DEFERRED;
                } else {
                    sQLiteTransactionType = Transactor.SQLiteTransactionType.IMMEDIATE;
                }
                if (this.$isReadOnly) {
                    Transactor.SQLiteTransactionType sQLiteTransactionType3 = sQLiteTransactionType;
                    transactor = transactor3;
                    sQLiteTransactionType2 = sQLiteTransactionType3;
                    this.L$0 = transactor;
                    this.L$1 = null;
                    this.label = 3;
                    obj = transactor.withTransaction(sQLiteTransactionType2, new DBUtil__DBUtilKt$internalPerform$2$result$1(this.$block, null), this);
                } else {
                    this.L$0 = transactor3;
                    this.L$1 = sQLiteTransactionType;
                    this.label = 1;
                    Object inTransaction = transactor3.inTransaction(this);
                    if (inTransaction != coroutine_suspended) {
                        transactor2 = transactor3;
                        obj = inTransaction;
                    }
                }
            } else {
                Function2<PooledConnection, Continuation<? super R>, Object> function2 = this.$block;
                this.label = 5;
                Object invoke = function2.invoke(transactor3, this);
                if (invoke != coroutine_suspended) {
                    return invoke;
                }
            }
            return coroutine_suspended;
        } else if (i == 1) {
            sQLiteTransactionType = (Transactor.SQLiteTransactionType) this.L$1;
            transactor2 = (Transactor) this.L$0;
            ResultKt.throwOnFailure(obj);
        } else if (i != 2) {
            if (i != 3) {
                if (i != 4) {
                    if (i == 5) {
                        ResultKt.throwOnFailure(obj);
                        return obj;
                    }
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                obj2 = this.L$0;
                ResultKt.throwOnFailure(obj);
                if (!((Boolean) obj).booleanValue()) {
                    this.$this_internalPerform.getInvalidationTracker().refreshAsync();
                }
                return obj2;
            }
            transactor = (Transactor) this.L$0;
            ResultKt.throwOnFailure(obj);
            if (this.$isReadOnly) {
                return obj;
            }
            this.L$0 = obj;
            this.label = 4;
            Object inTransaction2 = transactor.inTransaction(this);
            if (inTransaction2 != coroutine_suspended) {
                obj2 = obj;
                obj = inTransaction2;
                if (!((Boolean) obj).booleanValue()) {
                }
                return obj2;
            }
            return coroutine_suspended;
        } else {
            sQLiteTransactionType = (Transactor.SQLiteTransactionType) this.L$1;
            transactor2 = (Transactor) this.L$0;
            ResultKt.throwOnFailure(obj);
            sQLiteTransactionType2 = sQLiteTransactionType;
            transactor = transactor2;
            this.L$0 = transactor;
            this.L$1 = null;
            this.label = 3;
            obj = transactor.withTransaction(sQLiteTransactionType2, new DBUtil__DBUtilKt$internalPerform$2$result$1(this.$block, null), this);
        }
        if (!((Boolean) obj).booleanValue()) {
            this.L$0 = transactor2;
            this.L$1 = sQLiteTransactionType;
            this.label = 2;
        }
        sQLiteTransactionType2 = sQLiteTransactionType;
        transactor = transactor2;
        this.L$0 = transactor;
        this.L$1 = null;
        this.label = 3;
        obj = transactor.withTransaction(sQLiteTransactionType2, new DBUtil__DBUtilKt$internalPerform$2$result$1(this.$block, null), this);
    }

    public final Object invokeSuspend$$forInline(Object obj) {
        Transactor.SQLiteTransactionType sQLiteTransactionType;
        Transactor transactor = (Transactor) this.L$0;
        if (this.$inTransaction) {
            if (this.$isReadOnly) {
                sQLiteTransactionType = Transactor.SQLiteTransactionType.DEFERRED;
            } else {
                sQLiteTransactionType = Transactor.SQLiteTransactionType.IMMEDIATE;
            }
            if (!this.$isReadOnly) {
                DBUtil__DBUtilKt$internalPerform$2<R> dBUtil__DBUtilKt$internalPerform$2 = this;
                if (!((Boolean) transactor.inTransaction(dBUtil__DBUtilKt$internalPerform$2)).booleanValue()) {
                    this.$this_internalPerform.getInvalidationTracker().sync$room_runtime_release(dBUtil__DBUtilKt$internalPerform$2);
                }
            }
            DBUtil__DBUtilKt$internalPerform$2<R> dBUtil__DBUtilKt$internalPerform$22 = this;
            Object withTransaction = transactor.withTransaction(sQLiteTransactionType, new DBUtil__DBUtilKt$internalPerform$2$result$1(this.$block, null), dBUtil__DBUtilKt$internalPerform$22);
            if (!this.$isReadOnly && !((Boolean) transactor.inTransaction(dBUtil__DBUtilKt$internalPerform$22)).booleanValue()) {
                this.$this_internalPerform.getInvalidationTracker().refreshAsync();
            }
            return withTransaction;
        }
        return this.$block.invoke(transactor, this);
    }
}
