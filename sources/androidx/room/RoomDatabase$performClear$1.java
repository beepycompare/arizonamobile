package androidx.room;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.core.view.InputDeviceCompat;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: RoomDatabase.android.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "androidx.room.RoomDatabase$performClear$1", f = "RoomDatabase.android.kt", i = {}, l = {TypedValues.PositionType.TYPE_PERCENT_Y}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes3.dex */
public final class RoomDatabase$performClear$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ boolean $hasForeignKeys;
    final /* synthetic */ String[] $tableNames;
    int label;
    final /* synthetic */ RoomDatabase this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RoomDatabase$performClear$1(RoomDatabase roomDatabase, boolean z, String[] strArr, Continuation<? super RoomDatabase$performClear$1> continuation) {
        super(2, continuation);
        this.this$0 = roomDatabase;
        this.$hasForeignKeys = z;
        this.$tableNames = strArr;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new RoomDatabase$performClear$1(this.this$0, this.$hasForeignKeys, this.$tableNames, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((RoomDatabase$performClear$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: RoomDatabase.android.kt */
    @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "connection", "Landroidx/room/Transactor;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "androidx.room.RoomDatabase$performClear$1$1", f = "RoomDatabase.android.kt", i = {0, 1, 2, 3, 4}, l = {TypedValues.PositionType.TYPE_CURVE_FIT, 509, 511, 517, 518, 519}, m = "invokeSuspend", n = {"connection", "connection", "connection", "connection", "connection"}, s = {"L$0", "L$0", "L$0", "L$0", "L$0"})
    /* renamed from: androidx.room.RoomDatabase$performClear$1$1  reason: invalid class name */
    /* loaded from: classes3.dex */
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<Transactor, Continuation<? super Unit>, Object> {
        final /* synthetic */ boolean $hasForeignKeys;
        final /* synthetic */ String[] $tableNames;
        /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ RoomDatabase this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(RoomDatabase roomDatabase, boolean z, String[] strArr, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.this$0 = roomDatabase;
            this.$hasForeignKeys = z;
            this.$tableNames = strArr;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.this$0, this.$hasForeignKeys, this.$tableNames, continuation);
            anonymousClass1.L$0 = obj;
            return anonymousClass1;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Transactor transactor, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(transactor, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code restructure failed: missing block: B:19:0x0075, code lost:
            if (r7.this$0.getInvalidationTracker().sync$room_runtime_release(r7) == r0) goto L13;
         */
        /* JADX WARN: Code restructure failed: missing block: B:22:0x0091, code lost:
            if (r1.withTransaction(androidx.room.Transactor.SQLiteTransactionType.IMMEDIATE, new androidx.room.RoomDatabase$performClear$1.AnonymousClass1.C00611(r7.$hasForeignKeys, r7.$tableNames, null), r7) == r0) goto L13;
         */
        /* JADX WARN: Code restructure failed: missing block: B:25:0x00a0, code lost:
            if (r8 == r0) goto L13;
         */
        /* JADX WARN: Code restructure failed: missing block: B:30:0x00bc, code lost:
            if (androidx.room.TransactorKt.execSQL(r1, "PRAGMA wal_checkpoint(FULL)", r7) == r0) goto L13;
         */
        /* JADX WARN: Code restructure failed: missing block: B:33:0x00cf, code lost:
            if (androidx.room.TransactorKt.execSQL(r1, "VACUUM", r7) == r0) goto L13;
         */
        /* JADX WARN: Removed duplicated region for block: B:18:0x0063  */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object invokeSuspend(Object obj) {
            Transactor transactor;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure(obj);
                    Transactor transactor2 = (Transactor) this.L$0;
                    this.L$0 = transactor2;
                    this.label = 1;
                    Object inTransaction = transactor2.inTransaction(this);
                    if (inTransaction != coroutine_suspended) {
                        transactor = transactor2;
                        obj = inTransaction;
                        if (!((Boolean) obj).booleanValue()) {
                            this.L$0 = transactor;
                            this.label = 2;
                            break;
                        }
                        this.L$0 = transactor;
                        this.label = 3;
                        break;
                    }
                    break;
                case 1:
                    transactor = (Transactor) this.L$0;
                    ResultKt.throwOnFailure(obj);
                    if (!((Boolean) obj).booleanValue()) {
                    }
                    this.L$0 = transactor;
                    this.label = 3;
                    break;
                case 2:
                    transactor = (Transactor) this.L$0;
                    ResultKt.throwOnFailure(obj);
                    this.L$0 = transactor;
                    this.label = 3;
                    break;
                case 3:
                    transactor = (Transactor) this.L$0;
                    ResultKt.throwOnFailure(obj);
                    this.L$0 = transactor;
                    this.label = 4;
                    obj = transactor.inTransaction(this);
                    break;
                case 4:
                    transactor = (Transactor) this.L$0;
                    ResultKt.throwOnFailure(obj);
                    if (!((Boolean) obj).booleanValue()) {
                        this.L$0 = transactor;
                        this.label = 5;
                        break;
                    }
                    return Unit.INSTANCE;
                case 5:
                    transactor = (Transactor) this.L$0;
                    ResultKt.throwOnFailure(obj);
                    this.L$0 = null;
                    this.label = 6;
                    break;
                case 6:
                    ResultKt.throwOnFailure(obj);
                    this.this$0.getInvalidationTracker().refreshAsync();
                    return Unit.INSTANCE;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            return coroutine_suspended;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: RoomDatabase.android.kt */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00010\u0002H\n"}, d2 = {"<anonymous>", "", "Landroidx/room/TransactionScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
        @DebugMetadata(c = "androidx.room.RoomDatabase$performClear$1$1$1", f = "RoomDatabase.android.kt", i = {0, 1, 1}, l = {InputDeviceCompat.SOURCE_DPAD, 515}, m = "invokeSuspend", n = {"$this$withTransaction", "$this$withTransaction", "$this$forEach$iv"}, s = {"L$0", "L$0", "L$1"})
        /* renamed from: androidx.room.RoomDatabase$performClear$1$1$1  reason: invalid class name and collision with other inner class name */
        /* loaded from: classes3.dex */
        public static final class C00611 extends SuspendLambda implements Function2<TransactionScope<Unit>, Continuation<? super Unit>, Object> {
            final /* synthetic */ boolean $hasForeignKeys;
            final /* synthetic */ String[] $tableNames;
            int I$0;
            int I$1;
            private /* synthetic */ Object L$0;
            Object L$1;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C00611(boolean z, String[] strArr, Continuation<? super C00611> continuation) {
                super(2, continuation);
                this.$hasForeignKeys = z;
                this.$tableNames = strArr;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                C00611 c00611 = new C00611(this.$hasForeignKeys, this.$tableNames, continuation);
                c00611.L$0 = obj;
                return c00611;
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(TransactionScope<Unit> transactionScope, Continuation<? super Unit> continuation) {
                return ((C00611) create(transactionScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            /* JADX WARN: Code restructure failed: missing block: B:13:0x004a, code lost:
                if (androidx.room.TransactorKt.execSQL(r1, "PRAGMA defer_foreign_keys = TRUE", r10) == r0) goto L10;
             */
            /* JADX WARN: Code restructure failed: missing block: B:18:0x007f, code lost:
                if (androidx.room.TransactorKt.execSQL(r6, r11, r10) == r0) goto L10;
             */
            /* JADX WARN: Code restructure failed: missing block: B:19:0x0081, code lost:
                return r0;
             */
            /* JADX WARN: Removed duplicated region for block: B:17:0x0057  */
            /* JADX WARN: Removed duplicated region for block: B:21:0x0084  */
            /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:18:0x007f -> B:20:0x0082). Please submit an issue!!! */
            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public final Object invokeSuspend(Object obj) {
                TransactionScope transactionScope;
                TransactionScope transactionScope2;
                int length;
                int i;
                String[] strArr;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int i2 = this.label;
                if (i2 == 0) {
                    ResultKt.throwOnFailure(obj);
                    transactionScope = (TransactionScope) this.L$0;
                    if (this.$hasForeignKeys) {
                        this.L$0 = transactionScope;
                        this.label = 1;
                    }
                } else if (i2 == 1) {
                    transactionScope = (TransactionScope) this.L$0;
                    ResultKt.throwOnFailure(obj);
                } else if (i2 != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                } else {
                    length = this.I$1;
                    i = this.I$0;
                    strArr = (String[]) this.L$1;
                    transactionScope2 = (TransactionScope) this.L$0;
                    ResultKt.throwOnFailure(obj);
                    i++;
                    if (i < length) {
                        return Unit.INSTANCE;
                    }
                    String str = "DELETE FROM `" + strArr[i] + '`';
                    this.L$0 = transactionScope2;
                    this.L$1 = strArr;
                    this.I$0 = i;
                    this.I$1 = length;
                    this.label = 2;
                }
                String[] strArr2 = this.$tableNames;
                transactionScope2 = transactionScope;
                length = strArr2.length;
                i = 0;
                strArr = strArr2;
                if (i < length) {
                }
            }
        }
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        RoomConnectionManager roomConnectionManager;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            roomConnectionManager = this.this$0.connectionManager;
            if (roomConnectionManager == null) {
                Intrinsics.throwUninitializedPropertyAccessException("connectionManager");
                roomConnectionManager = null;
            }
            this.label = 1;
            if (roomConnectionManager.useConnection(false, new AnonymousClass1(this.this$0, this.$hasForeignKeys, this.$tableNames, null), this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        } else {
            ResultKt.throwOnFailure(obj);
        }
        return Unit.INSTANCE;
    }
}
