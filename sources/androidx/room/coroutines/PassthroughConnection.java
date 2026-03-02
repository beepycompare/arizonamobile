package androidx.room.coroutines;

import android.database.SQLException;
import androidx.exifinterface.media.ExifInterface;
import androidx.room.TransactionScope;
import androidx.room.Transactor;
import androidx.room.coroutines.ConnectionPool;
import androidx.sqlite.SQLite;
import androidx.sqlite.SQLiteConnection;
import androidx.sqlite.SQLiteStatement;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.ExceptionsKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jdk7.AutoCloseableKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: PassthroughConnectionPool.kt */
@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002:\u0001*BQ\u0012@\u0010\u0003\u001a<\b\u0001\u0012\u0018\u0012\u0016\b\u0001\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0005\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0018\u00010\u0004j\b\u0012\u0002\b\u0003\u0018\u0001`\b\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u000b\u0010\fJ0\u0010\u001a\u001a\u0002H\u001b\"\u0004\b\u0000\u0010\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\u0012\u0010\u001e\u001a\u000e\u0012\u0004\u0012\u00020\u001f\u0012\u0004\u0012\u0002H\u001b0\u0005H\u0096@¢\u0006\u0002\u0010 JK\u0010!\u001a\u0002H\u001b\"\u0004\b\u0000\u0010\u001b2\u0006\u0010\"\u001a\u00020\u00172-\u0010\u001e\u001a)\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u001b0#\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u001b0\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0004¢\u0006\u0002\b$H\u0096@¢\u0006\u0002\u0010%JK\u0010&\u001a\u0002H\u001b\"\u0004\b\u0000\u0010\u001b2\u0006\u0010\"\u001a\u00020\u00172-\u0010\u001e\u001a)\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u001b0#\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u001b0\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0004¢\u0006\u0002\b$H\u0082@¢\u0006\u0002\u0010%J\u000e\u0010'\u001a\u00020(H\u0096@¢\u0006\u0002\u0010)RM\u0010\u0003\u001a<\b\u0001\u0012\u0018\u0012\u0016\b\u0001\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0005\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0018\u00010\u0004j\b\u0012\u0002\b\u0003\u0018\u0001`\b¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0012\u001a\u00060\u0013j\u0002`\u0014X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0015R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0018\u001a\u00020\n8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u0011¨\u0006+"}, d2 = {"Landroidx/room/coroutines/PassthroughConnection;", "Landroidx/room/Transactor;", "Landroidx/room/coroutines/RawConnectionAccessor;", "transactionWrapper", "Lkotlin/Function2;", "Lkotlin/Function1;", "Lkotlin/coroutines/Continuation;", "", "Landroidx/room/coroutines/TransactionWrapper;", "delegate", "Landroidx/sqlite/SQLiteConnection;", "<init>", "(Lkotlin/jvm/functions/Function2;Landroidx/sqlite/SQLiteConnection;)V", "getTransactionWrapper", "()Lkotlin/jvm/functions/Function2;", "Lkotlin/jvm/functions/Function2;", "getDelegate", "()Landroidx/sqlite/SQLiteConnection;", "nestedTransactionCount", "Ljava/util/concurrent/atomic/AtomicInteger;", "Landroidx/room/concurrent/AtomicInt;", "Ljava/util/concurrent/atomic/AtomicInteger;", "currentTransactionType", "Landroidx/room/Transactor$SQLiteTransactionType;", "rawConnection", "getRawConnection", "usePrepared", "R", "sql", "", "block", "Landroidx/sqlite/SQLiteStatement;", "(Ljava/lang/String;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "withTransaction", "type", "Landroidx/room/TransactionScope;", "Lkotlin/ExtensionFunctionType;", "(Landroidx/room/Transactor$SQLiteTransactionType;Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "transaction", "inTransaction", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "PassthroughTransactor", "room-runtime"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class PassthroughConnection implements Transactor, RawConnectionAccessor {
    private Transactor.SQLiteTransactionType currentTransactionType;
    private final SQLiteConnection delegate;
    private AtomicInteger nestedTransactionCount;
    private final Function2<Function1<? super Continuation<Object>, ? extends Object>, Continuation<Object>, Object> transactionWrapper;

    /* compiled from: PassthroughConnectionPool.kt */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[Transactor.SQLiteTransactionType.values().length];
            try {
                iArr[Transactor.SQLiteTransactionType.DEFERRED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[Transactor.SQLiteTransactionType.IMMEDIATE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[Transactor.SQLiteTransactionType.EXCLUSIVE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public PassthroughConnection(Function2<? super Function1<? super Continuation<Object>, ? extends Object>, ? super Continuation<Object>, ? extends Object> function2, SQLiteConnection delegate) {
        Intrinsics.checkNotNullParameter(delegate, "delegate");
        this.transactionWrapper = function2;
        this.delegate = delegate;
        this.nestedTransactionCount = new AtomicInteger(0);
    }

    public final Function2<Function1<? super Continuation<Object>, ? extends Object>, Continuation<Object>, Object> getTransactionWrapper() {
        return this.transactionWrapper;
    }

    public final SQLiteConnection getDelegate() {
        return this.delegate;
    }

    @Override // androidx.room.coroutines.RawConnectionAccessor
    public SQLiteConnection getRawConnection() {
        return this.delegate;
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x004f, code lost:
        if (r8 == r1) goto L22;
     */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0025  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0042  */
    @Override // androidx.room.PooledConnection
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public <R> Object usePrepared(String str, Function1<? super SQLiteStatement, ? extends R> function1, Continuation<? super R> continuation) {
        PassthroughConnection$usePrepared$1 passthroughConnection$usePrepared$1;
        Object obj;
        int i;
        Function2<Function1<? super Continuation<Object>, ? extends Object>, Continuation<Object>, Object> function2;
        try {
            if (continuation instanceof PassthroughConnection$usePrepared$1) {
                passthroughConnection$usePrepared$1 = (PassthroughConnection$usePrepared$1) continuation;
                if ((passthroughConnection$usePrepared$1.label & Integer.MIN_VALUE) != 0) {
                    passthroughConnection$usePrepared$1.label -= Integer.MIN_VALUE;
                    obj = passthroughConnection$usePrepared$1.result;
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    i = passthroughConnection$usePrepared$1.label;
                    if (i != 0) {
                        ResultKt.throwOnFailure(obj);
                        passthroughConnection$usePrepared$1.L$0 = str;
                        passthroughConnection$usePrepared$1.L$1 = function1;
                        passthroughConnection$usePrepared$1.label = 1;
                        obj = inTransaction(passthroughConnection$usePrepared$1);
                    } else if (i != 1) {
                        if (i == 2) {
                            ResultKt.throwOnFailure(obj);
                            return obj;
                        }
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    } else {
                        function1 = (Function1) passthroughConnection$usePrepared$1.L$1;
                        str = (String) passthroughConnection$usePrepared$1.L$0;
                        ResultKt.throwOnFailure(obj);
                    }
                    if (!((Boolean) obj).booleanValue() && (function2 = this.transactionWrapper) != null) {
                        PassthroughConnection$usePrepared$2 passthroughConnection$usePrepared$2 = new PassthroughConnection$usePrepared$2(this, str, function1, null);
                        passthroughConnection$usePrepared$1.L$0 = null;
                        passthroughConnection$usePrepared$1.L$1 = null;
                        passthroughConnection$usePrepared$1.label = 2;
                        Object invoke = function2.invoke(passthroughConnection$usePrepared$2, passthroughConnection$usePrepared$1);
                        return invoke == coroutine_suspended ? coroutine_suspended : invoke;
                    }
                    SQLiteStatement prepare = this.delegate.prepare(str);
                    R invoke2 = function1.invoke(prepare);
                    AutoCloseableKt.closeFinally(prepare, null);
                    return invoke2;
                }
            }
            R invoke22 = function1.invoke(prepare);
            AutoCloseableKt.closeFinally(prepare, null);
            return invoke22;
        } finally {
        }
        passthroughConnection$usePrepared$1 = new PassthroughConnection$usePrepared$1(this, continuation);
        obj = passthroughConnection$usePrepared$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = passthroughConnection$usePrepared$1.label;
        if (i != 0) {
        }
        if (!((Boolean) obj).booleanValue()) {
        }
        SQLiteStatement prepare2 = this.delegate.prepare(str);
    }

    @Override // androidx.room.Transactor
    public <R> Object withTransaction(Transactor.SQLiteTransactionType sQLiteTransactionType, Function2<? super TransactionScope<R>, ? super Continuation<? super R>, ? extends Object> function2, Continuation<? super R> continuation) {
        Function2<Function1<? super Continuation<Object>, ? extends Object>, Continuation<Object>, Object> function22 = this.transactionWrapper;
        if (function22 != null) {
            Object invoke = function22.invoke(new PassthroughConnection$withTransaction$2(this, sQLiteTransactionType, function2, null), continuation);
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            return invoke;
        }
        return transaction(sQLiteTransactionType, function2, continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0027  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0039  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x008b  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0091  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0097  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final <R> Object transaction(Transactor.SQLiteTransactionType sQLiteTransactionType, Function2<? super TransactionScope<R>, ? super Continuation<? super R>, ? extends Object> function2, Continuation<? super R> continuation) {
        PassthroughConnection$transaction$1 passthroughConnection$transaction$1;
        int i;
        int i2;
        ConnectionPool.RollbackException rollbackException;
        try {
            if (continuation instanceof PassthroughConnection$transaction$1) {
                passthroughConnection$transaction$1 = (PassthroughConnection$transaction$1) continuation;
                if ((passthroughConnection$transaction$1.label & Integer.MIN_VALUE) != 0) {
                    passthroughConnection$transaction$1.label -= Integer.MIN_VALUE;
                    Object obj = passthroughConnection$transaction$1.result;
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    i = passthroughConnection$transaction$1.label;
                    i2 = 1;
                    if (i != 0) {
                        ResultKt.throwOnFailure(obj);
                        int i3 = WhenMappings.$EnumSwitchMapping$0[sQLiteTransactionType.ordinal()];
                        if (i3 == 1) {
                            SQLite.execSQL(this.delegate, "BEGIN DEFERRED TRANSACTION");
                        } else if (i3 == 2) {
                            SQLite.execSQL(this.delegate, "BEGIN IMMEDIATE TRANSACTION");
                        } else if (i3 != 3) {
                            throw new NoWhenBranchMatchedException();
                        } else {
                            SQLite.execSQL(this.delegate, "BEGIN EXCLUSIVE TRANSACTION");
                        }
                        if (this.nestedTransactionCount.incrementAndGet() > 0) {
                            this.currentTransactionType = sQLiteTransactionType;
                        }
                        PassthroughTransactor passthroughTransactor = new PassthroughTransactor();
                        passthroughConnection$transaction$1.I$0 = 1;
                        passthroughConnection$transaction$1.label = 1;
                        obj = function2.invoke(passthroughTransactor, passthroughConnection$transaction$1);
                        if (obj == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    } else if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    } else {
                        i2 = passthroughConnection$transaction$1.I$0;
                        ResultKt.throwOnFailure(obj);
                    }
                    if (this.nestedTransactionCount.decrementAndGet() == 0) {
                        this.currentTransactionType = null;
                    }
                    SQLiteConnection sQLiteConnection = this.delegate;
                    if (i2 == 0) {
                        SQLite.execSQL(sQLiteConnection, "END TRANSACTION");
                        return obj;
                    }
                    SQLite.execSQL(sQLiteConnection, "ROLLBACK TRANSACTION");
                    return obj;
                }
            }
            if (i != 0) {
            }
            if (this.nestedTransactionCount.decrementAndGet() == 0) {
            }
            SQLiteConnection sQLiteConnection2 = this.delegate;
            if (i2 == 0) {
            }
        } catch (Throwable th) {
            try {
                if (th instanceof ConnectionPool.RollbackException) {
                    Object result = th.getResult();
                    if (this.nestedTransactionCount.decrementAndGet() == 0) {
                        this.currentTransactionType = null;
                    }
                    SQLite.execSQL(this.delegate, "ROLLBACK TRANSACTION");
                    return result;
                }
                try {
                    throw th;
                } catch (Throwable th2) {
                    rollbackException = th;
                    th = th2;
                    try {
                        if (this.nestedTransactionCount.decrementAndGet() == 0) {
                            this.currentTransactionType = null;
                        }
                        SQLite.execSQL(this.delegate, "ROLLBACK TRANSACTION");
                    } catch (SQLException e) {
                        if (rollbackException == null) {
                            throw e;
                        }
                        ExceptionsKt.addSuppressed(rollbackException, e);
                    }
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                rollbackException = null;
            }
        }
        passthroughConnection$transaction$1 = new PassthroughConnection$transaction$1(this, continuation);
        Object obj2 = passthroughConnection$transaction$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = passthroughConnection$transaction$1.label;
        i2 = 1;
    }

    @Override // androidx.room.Transactor
    public Object inTransaction(Continuation<? super Boolean> continuation) {
        return Boxing.boxBoolean(this.currentTransactionType != null || this.delegate.inTransaction());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: PassthroughConnectionPool.kt */
    @Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0001\n\u0002\b\u0003\b\u0082\u0004\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u00022\u00020\u0003B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J0\u0010\n\u001a\u0002H\u000b\"\u0004\b\u0001\u0010\u000b2\u0006\u0010\f\u001a\u00020\r2\u0012\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u0002H\u000b0\u000fH\u0096@¢\u0006\u0002\u0010\u0011J>\u0010\u0012\u001a\u0002H\u000b\"\u0004\b\u0001\u0010\u000b2(\u0010\u000e\u001a$\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u000b0\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u000b0\u0014\u0012\u0006\u0012\u0004\u0018\u00010\u00150\u0013H\u0096@¢\u0006\u0002\u0010\u0016J\u0016\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00028\u0000H\u0096@¢\u0006\u0002\u0010\u001aR\u0014\u0010\u0006\u001a\u00020\u00078VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\t¨\u0006\u001b"}, d2 = {"Landroidx/room/coroutines/PassthroughConnection$PassthroughTransactor;", ExifInterface.GPS_DIRECTION_TRUE, "Landroidx/room/TransactionScope;", "Landroidx/room/coroutines/RawConnectionAccessor;", "<init>", "(Landroidx/room/coroutines/PassthroughConnection;)V", "rawConnection", "Landroidx/sqlite/SQLiteConnection;", "getRawConnection", "()Landroidx/sqlite/SQLiteConnection;", "usePrepared", "R", "sql", "", "block", "Lkotlin/Function1;", "Landroidx/sqlite/SQLiteStatement;", "(Ljava/lang/String;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "withNestedTransaction", "Lkotlin/Function2;", "Lkotlin/coroutines/Continuation;", "", "(Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "rollback", "", "result", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "room-runtime"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public final class PassthroughTransactor<T> implements TransactionScope<T>, RawConnectionAccessor {
        public PassthroughTransactor() {
        }

        @Override // androidx.room.coroutines.RawConnectionAccessor
        public SQLiteConnection getRawConnection() {
            return PassthroughConnection.this.getRawConnection();
        }

        @Override // androidx.room.PooledConnection
        public <R> Object usePrepared(String str, Function1<? super SQLiteStatement, ? extends R> function1, Continuation<? super R> continuation) {
            return PassthroughConnection.this.usePrepared(str, function1, continuation);
        }

        @Override // androidx.room.TransactionScope
        public <R> Object withNestedTransaction(Function2<? super TransactionScope<R>, ? super Continuation<? super R>, ? extends Object> function2, Continuation<? super R> continuation) {
            PassthroughConnection passthroughConnection = PassthroughConnection.this;
            Transactor.SQLiteTransactionType sQLiteTransactionType = passthroughConnection.currentTransactionType;
            if (sQLiteTransactionType != null) {
                return passthroughConnection.transaction(sQLiteTransactionType, function2, continuation);
            }
            throw new IllegalStateException("Required value was null.".toString());
        }

        @Override // androidx.room.TransactionScope
        public Object rollback(T t, Continuation<?> continuation) {
            throw new ConnectionPool.RollbackException(t);
        }
    }
}
