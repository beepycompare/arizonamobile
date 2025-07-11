package androidx.room.coroutines;

import android.database.SQLException;
import androidx.exifinterface.media.ExifInterface;
import androidx.room.TransactionScope;
import androidx.room.Transactor;
import androidx.room.concurrent.ThreadLocal_jvmAndroidKt;
import androidx.room.coroutines.ConnectionPool;
import androidx.sqlite.SQLite;
import androidx.sqlite.SQLiteConnection;
import androidx.sqlite.SQLiteStatement;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.ArrayDeque;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jdk7.AutoCloseableKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.sync.Mutex;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ConnectionPoolImpl.kt */
@Metadata(d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002:\u0003678B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ0\u0010\u0018\u001a\u0002H\u0019\"\u0004\b\u0000\u0010\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\u0012\u0010\u001c\u001a\u000e\u0012\u0004\u0012\u00020\u001e\u0012\u0004\u0012\u0002H\u00190\u001dH\u0096@¢\u0006\u0002\u0010\u001fJK\u0010 \u001a\u0002H\u0019\"\u0004\b\u0000\u0010\u00192\u0006\u0010!\u001a\u00020\"2-\u0010\u001c\u001a)\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00190$\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00190%\u0012\u0006\u0012\u0004\u0018\u00010&0#¢\u0006\u0002\b'H\u0096@¢\u0006\u0002\u0010(J\u000e\u0010)\u001a\u00020\u0006H\u0096@¢\u0006\u0002\u0010*J\u0006\u0010+\u001a\u00020,JM\u0010-\u001a\u0002H\u0019\"\u0004\b\u0000\u0010\u00192\b\u0010!\u001a\u0004\u0018\u00010\"2-\u0010\u001c\u001a)\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00190$\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00190%\u0012\u0006\u0012\u0004\u0018\u00010&0#¢\u0006\u0002\b'H\u0082@¢\u0006\u0002\u0010(J\u0016\u0010.\u001a\u00020,2\u0006\u0010!\u001a\u00020\"H\u0082@¢\u0006\u0002\u0010/J\u0016\u00100\u001a\u00020,2\u0006\u00101\u001a\u00020\u0006H\u0082@¢\u0006\u0002\u00102J\"\u00103\u001a\u0002H\u0019\"\u0004\b\u0000\u0010\u00192\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u0002H\u001904H\u0082H¢\u0006\u0002\u00105R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u000bR\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000f\u001a\u00060\u0010j\u0002`\u0011X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0012R\u0014\u0010\u0013\u001a\u00020\u00068BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u000bR\u0014\u0010\u0014\u001a\u00020\u00158VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017¨\u00069"}, d2 = {"Landroidx/room/coroutines/PooledConnectionImpl;", "Landroidx/room/Transactor;", "Landroidx/room/coroutines/RawConnectionAccessor;", "delegate", "Landroidx/room/coroutines/ConnectionWithLock;", "isReadOnly", "", "<init>", "(Landroidx/room/coroutines/ConnectionWithLock;Z)V", "getDelegate", "()Landroidx/room/coroutines/ConnectionWithLock;", "()Z", "transactionStack", "Lkotlin/collections/ArrayDeque;", "Landroidx/room/coroutines/PooledConnectionImpl$TransactionItem;", "_isRecycled", "Ljava/util/concurrent/atomic/AtomicBoolean;", "Landroidx/room/concurrent/AtomicBoolean;", "Ljava/util/concurrent/atomic/AtomicBoolean;", "isRecycled", "rawConnection", "Landroidx/sqlite/SQLiteConnection;", "getRawConnection", "()Landroidx/sqlite/SQLiteConnection;", "usePrepared", "R", "sql", "", "block", "Lkotlin/Function1;", "Landroidx/sqlite/SQLiteStatement;", "(Ljava/lang/String;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "withTransaction", "type", "Landroidx/room/Transactor$SQLiteTransactionType;", "Lkotlin/Function2;", "Landroidx/room/TransactionScope;", "Lkotlin/coroutines/Continuation;", "", "Lkotlin/ExtensionFunctionType;", "(Landroidx/room/Transactor$SQLiteTransactionType;Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "inTransaction", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "markRecycled", "", "transaction", "beginTransaction", "(Landroidx/room/Transactor$SQLiteTransactionType;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "endTransaction", FirebaseAnalytics.Param.SUCCESS, "(ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "withStateCheck", "Lkotlin/Function0;", "(Lkotlin/jvm/functions/Function0;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "TransactionItem", "TransactionImpl", "StatementWrapper", "room-runtime_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class PooledConnectionImpl implements Transactor, RawConnectionAccessor {
    private final AtomicBoolean _isRecycled;
    private final ConnectionWithLock delegate;
    private final boolean isReadOnly;
    private final ArrayDeque<TransactionItem> transactionStack;

    /* compiled from: ConnectionPoolImpl.kt */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public /* synthetic */ class WhenMappings {
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

    public PooledConnectionImpl(ConnectionWithLock delegate, boolean z) {
        Intrinsics.checkNotNullParameter(delegate, "delegate");
        this.delegate = delegate;
        this.isReadOnly = z;
        this.transactionStack = new ArrayDeque<>();
        this._isRecycled = new AtomicBoolean(false);
    }

    public final ConnectionWithLock getDelegate() {
        return this.delegate;
    }

    public final boolean isReadOnly() {
        return this.isReadOnly;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean isRecycled() {
        return this._isRecycled.get();
    }

    @Override // androidx.room.coroutines.RawConnectionAccessor
    public SQLiteConnection getRawConnection() {
        return this.delegate;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0025  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0045  */
    /* JADX WARN: Type inference failed for: r7v13, types: [kotlinx.coroutines.sync.Mutex] */
    @Override // androidx.room.PooledConnection
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public <R> Object usePrepared(String str, Function1<? super SQLiteStatement, ? extends R> function1, Continuation<? super R> continuation) {
        PooledConnectionImpl$usePrepared$1 pooledConnectionImpl$usePrepared$1;
        int i;
        ConnectionWithLock connectionWithLock;
        PooledConnectionImpl pooledConnectionImpl;
        try {
            if (continuation instanceof PooledConnectionImpl$usePrepared$1) {
                pooledConnectionImpl$usePrepared$1 = (PooledConnectionImpl$usePrepared$1) continuation;
                if ((pooledConnectionImpl$usePrepared$1.label & Integer.MIN_VALUE) != 0) {
                    pooledConnectionImpl$usePrepared$1.label -= Integer.MIN_VALUE;
                    Object obj = pooledConnectionImpl$usePrepared$1.result;
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    i = pooledConnectionImpl$usePrepared$1.label;
                    if (i != 0) {
                        ResultKt.throwOnFailure(obj);
                        if (isRecycled()) {
                            SQLite.throwSQLiteException(21, "Connection is recycled");
                            throw new KotlinNothingValueException();
                        }
                        ConnectionElement connectionElement = (ConnectionElement) pooledConnectionImpl$usePrepared$1.getContext().get(ConnectionElement.Key);
                        if (connectionElement != null && connectionElement.getConnectionWrapper() == this) {
                            connectionWithLock = this.delegate;
                            pooledConnectionImpl$usePrepared$1.L$0 = this;
                            pooledConnectionImpl$usePrepared$1.L$1 = str;
                            pooledConnectionImpl$usePrepared$1.L$2 = function1;
                            pooledConnectionImpl$usePrepared$1.L$3 = connectionWithLock;
                            pooledConnectionImpl$usePrepared$1.label = 1;
                            if (connectionWithLock.lock(null, pooledConnectionImpl$usePrepared$1) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            pooledConnectionImpl = this;
                        } else {
                            SQLite.throwSQLiteException(21, "Attempted to use connection on a different coroutine");
                            throw new KotlinNothingValueException();
                        }
                    } else if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    } else {
                        function1 = (Function1) pooledConnectionImpl$usePrepared$1.L$2;
                        pooledConnectionImpl = (PooledConnectionImpl) pooledConnectionImpl$usePrepared$1.L$0;
                        ResultKt.throwOnFailure(obj);
                        connectionWithLock = (Mutex) pooledConnectionImpl$usePrepared$1.L$3;
                        str = (String) pooledConnectionImpl$usePrepared$1.L$1;
                    }
                    StatementWrapper statementWrapper = new StatementWrapper(pooledConnectionImpl, pooledConnectionImpl.delegate.prepare(str));
                    R invoke = function1.invoke(statementWrapper);
                    AutoCloseableKt.closeFinally(statementWrapper, null);
                    return invoke;
                }
            }
            StatementWrapper statementWrapper2 = new StatementWrapper(pooledConnectionImpl, pooledConnectionImpl.delegate.prepare(str));
            R invoke2 = function1.invoke(statementWrapper2);
            AutoCloseableKt.closeFinally(statementWrapper2, null);
            return invoke2;
        } finally {
            connectionWithLock.unlock(null);
        }
        pooledConnectionImpl$usePrepared$1 = new PooledConnectionImpl$usePrepared$1(this, continuation);
        Object obj2 = pooledConnectionImpl$usePrepared$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = pooledConnectionImpl$usePrepared$1.label;
        if (i != 0) {
        }
    }

    public final void markRecycled() {
        if (this._isRecycled.compareAndSet(false, true)) {
            try {
                SQLite.execSQL(this.delegate, "ROLLBACK TRANSACTION");
            } catch (SQLException unused) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Can't wrap try/catch for region: R(10:1|(2:3|(7:5|6|(1:(1:(1:(2:25|26)(1:(2:13|14)(4:16|17|18|19)))(6:27|28|29|(1:31)|32|(1:35)(1:34)))(1:58))(5:66|(1:68)|69|(1:71)|35)|59|60|(4:62|(0)|32|(0))|35))|72|6|(0)(0)|59|60|(0)|35|(2:(1:54)|(0))) */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x00a5, code lost:
        r13 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x00a6, code lost:
        r13 = r12;
        r12 = r13;
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x00ad, code lost:
        r12 = r12.getResult();
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x00b3, code lost:
        r0.L$0 = r12;
        r0.L$1 = null;
        r0.label = 4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x00bd, code lost:
        if (r13.endTransaction(false, r0) == r1) goto L35;
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x00c0, code lost:
        return r12;
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x00c1, code lost:
        throw r12;
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x00c2, code lost:
        r14 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x00c3, code lost:
        r8 = r12;
        r12 = r14;
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x00c7, code lost:
        r0.L$0 = r8;
        r0.L$1 = r12;
        r0.label = 5;
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x00d1, code lost:
        if (r13.endTransaction(false, r0) != r1) goto L19;
     */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x00d4, code lost:
        r14 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x00d5, code lost:
        r13 = r8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:66:0x00d8, code lost:
        kotlin.ExceptionsKt.addSuppressed(r13, r14);
     */
    /* JADX WARN: Code restructure failed: missing block: B:68:0x00de, code lost:
        throw r14;
     */
    /* JADX WARN: Removed duplicated region for block: B:10:0x002a  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x006b  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0094  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0098  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00a4 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:51:0x00ad A[Catch: all -> 0x00c6, TRY_LEAVE, TryCatch #3 {all -> 0x00c6, blocks: (B:49:0x00a9, B:51:0x00ad), top: B:75:0x00a9 }] */
    /* JADX WARN: Removed duplicated region for block: B:62:0x00d3 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:66:0x00d8  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x00de  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x00c1 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final <R> Object transaction(Transactor.SQLiteTransactionType sQLiteTransactionType, Function2<? super TransactionScope<R>, ? super Continuation<? super R>, ? extends Object> function2, Continuation<? super R> continuation) {
        PooledConnectionImpl$transaction$1 pooledConnectionImpl$transaction$1;
        Object obj;
        Object coroutine_suspended;
        int i;
        PooledConnectionImpl pooledConnectionImpl;
        PooledConnectionImpl pooledConnectionImpl2;
        int i2;
        boolean z;
        if (continuation instanceof PooledConnectionImpl$transaction$1) {
            pooledConnectionImpl$transaction$1 = (PooledConnectionImpl$transaction$1) continuation;
            if ((pooledConnectionImpl$transaction$1.label & Integer.MIN_VALUE) != 0) {
                pooledConnectionImpl$transaction$1.label -= Integer.MIN_VALUE;
                obj = pooledConnectionImpl$transaction$1.result;
                coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = pooledConnectionImpl$transaction$1.label;
                ConnectionPool.RollbackException rollbackException = null;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    if (sQLiteTransactionType == null) {
                        sQLiteTransactionType = Transactor.SQLiteTransactionType.DEFERRED;
                    }
                    pooledConnectionImpl$transaction$1.L$0 = this;
                    pooledConnectionImpl$transaction$1.L$1 = function2;
                    pooledConnectionImpl$transaction$1.label = 1;
                    if (beginTransaction(sQLiteTransactionType, pooledConnectionImpl$transaction$1) != coroutine_suspended) {
                        pooledConnectionImpl = this;
                    }
                } else if (i != 1) {
                    if (i == 2) {
                        i2 = pooledConnectionImpl$transaction$1.I$0;
                        pooledConnectionImpl2 = (PooledConnectionImpl) pooledConnectionImpl$transaction$1.L$0;
                        try {
                            ResultKt.throwOnFailure(obj);
                            z = i2 != 0;
                            pooledConnectionImpl$transaction$1.L$0 = obj;
                            pooledConnectionImpl$transaction$1.label = 3;
                        } catch (Throwable th) {
                            ConnectionPool.RollbackException th2 = th;
                            try {
                                if (!(th2 instanceof ConnectionPool.RollbackException)) {
                                }
                            } catch (Throwable th3) {
                                th = th3;
                            }
                        }
                        return pooledConnectionImpl2.endTransaction(z, pooledConnectionImpl$transaction$1) != coroutine_suspended ? coroutine_suspended : obj;
                    } else if (i == 3 || i == 4) {
                        Object obj2 = pooledConnectionImpl$transaction$1.L$0;
                        ResultKt.throwOnFailure(obj);
                        return obj2;
                    } else if (i != 5) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    } else {
                        th = (Throwable) pooledConnectionImpl$transaction$1.L$1;
                        Throwable th4 = (Throwable) pooledConnectionImpl$transaction$1.L$0;
                        try {
                            ResultKt.throwOnFailure(obj);
                        } catch (SQLException e) {
                            e = e;
                            if (th4 == null) {
                            }
                        }
                        throw th;
                    }
                } else {
                    function2 = (Function2) pooledConnectionImpl$transaction$1.L$1;
                    pooledConnectionImpl = (PooledConnectionImpl) pooledConnectionImpl$transaction$1.L$0;
                    ResultKt.throwOnFailure(obj);
                }
                TransactionImpl transactionImpl = new TransactionImpl();
                pooledConnectionImpl$transaction$1.L$0 = pooledConnectionImpl;
                pooledConnectionImpl$transaction$1.L$1 = null;
                pooledConnectionImpl$transaction$1.I$0 = 1;
                pooledConnectionImpl$transaction$1.label = 2;
                obj = function2.invoke(transactionImpl, pooledConnectionImpl$transaction$1);
                if (obj != coroutine_suspended) {
                    pooledConnectionImpl2 = pooledConnectionImpl;
                    i2 = 1;
                    if (i2 != 0) {
                    }
                    pooledConnectionImpl$transaction$1.L$0 = obj;
                    pooledConnectionImpl$transaction$1.label = 3;
                    if (pooledConnectionImpl2.endTransaction(z, pooledConnectionImpl$transaction$1) != coroutine_suspended) {
                    }
                }
            }
        }
        pooledConnectionImpl$transaction$1 = new PooledConnectionImpl$transaction$1(this, continuation);
        obj = pooledConnectionImpl$transaction$1.result;
        coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = pooledConnectionImpl$transaction$1.label;
        ConnectionPool.RollbackException rollbackException2 = null;
        if (i != 0) {
        }
        TransactionImpl transactionImpl2 = new TransactionImpl();
        pooledConnectionImpl$transaction$1.L$0 = pooledConnectionImpl;
        pooledConnectionImpl$transaction$1.L$1 = null;
        pooledConnectionImpl$transaction$1.I$0 = 1;
        pooledConnectionImpl$transaction$1.label = 2;
        obj = function2.invoke(transactionImpl2, pooledConnectionImpl$transaction$1);
        if (obj != coroutine_suspended) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0027  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0043  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0068 A[Catch: all -> 0x00c7, TryCatch #0 {all -> 0x00c7, blocks: (B:18:0x005a, B:20:0x0068, B:26:0x0078, B:32:0x00b6, B:27:0x0082, B:28:0x0087, B:29:0x0088, B:30:0x0092, B:31:0x009c), top: B:38:0x005a }] */
    /* JADX WARN: Removed duplicated region for block: B:31:0x009c A[Catch: all -> 0x00c7, TryCatch #0 {all -> 0x00c7, blocks: (B:18:0x005a, B:20:0x0068, B:26:0x0078, B:32:0x00b6, B:27:0x0082, B:28:0x0087, B:29:0x0088, B:30:0x0092, B:31:0x009c), top: B:38:0x005a }] */
    /* JADX WARN: Type inference failed for: r7v18, types: [kotlinx.coroutines.sync.Mutex] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object beginTransaction(Transactor.SQLiteTransactionType sQLiteTransactionType, Continuation<? super Unit> continuation) {
        PooledConnectionImpl$beginTransaction$1 pooledConnectionImpl$beginTransaction$1;
        int i;
        ConnectionWithLock connectionWithLock;
        PooledConnectionImpl pooledConnectionImpl;
        try {
            if (continuation instanceof PooledConnectionImpl$beginTransaction$1) {
                pooledConnectionImpl$beginTransaction$1 = (PooledConnectionImpl$beginTransaction$1) continuation;
                if ((pooledConnectionImpl$beginTransaction$1.label & Integer.MIN_VALUE) != 0) {
                    pooledConnectionImpl$beginTransaction$1.label -= Integer.MIN_VALUE;
                    Object obj = pooledConnectionImpl$beginTransaction$1.result;
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    i = pooledConnectionImpl$beginTransaction$1.label;
                    if (i != 0) {
                        ResultKt.throwOnFailure(obj);
                        connectionWithLock = this.delegate;
                        pooledConnectionImpl$beginTransaction$1.L$0 = this;
                        pooledConnectionImpl$beginTransaction$1.L$1 = sQLiteTransactionType;
                        pooledConnectionImpl$beginTransaction$1.L$2 = connectionWithLock;
                        pooledConnectionImpl$beginTransaction$1.label = 1;
                        if (connectionWithLock.lock(null, pooledConnectionImpl$beginTransaction$1) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        pooledConnectionImpl = this;
                    } else if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    } else {
                        pooledConnectionImpl = (PooledConnectionImpl) pooledConnectionImpl$beginTransaction$1.L$0;
                        ResultKt.throwOnFailure(obj);
                        connectionWithLock = (Mutex) pooledConnectionImpl$beginTransaction$1.L$2;
                        sQLiteTransactionType = (Transactor.SQLiteTransactionType) pooledConnectionImpl$beginTransaction$1.L$1;
                    }
                    int size = pooledConnectionImpl.transactionStack.size();
                    if (!pooledConnectionImpl.transactionStack.isEmpty()) {
                        int i2 = WhenMappings.$EnumSwitchMapping$0[sQLiteTransactionType.ordinal()];
                        if (i2 == 1) {
                            SQLite.execSQL(pooledConnectionImpl.delegate, "BEGIN DEFERRED TRANSACTION");
                        } else if (i2 == 2) {
                            SQLite.execSQL(pooledConnectionImpl.delegate, "BEGIN IMMEDIATE TRANSACTION");
                        } else if (i2 != 3) {
                            throw new NoWhenBranchMatchedException();
                        } else {
                            SQLite.execSQL(pooledConnectionImpl.delegate, "BEGIN EXCLUSIVE TRANSACTION");
                        }
                    } else {
                        SQLite.execSQL(pooledConnectionImpl.delegate, "SAVEPOINT '" + size + '\'');
                    }
                    pooledConnectionImpl.transactionStack.addLast(new TransactionItem(size, false));
                    return Unit.INSTANCE;
                }
            }
            int size2 = pooledConnectionImpl.transactionStack.size();
            if (!pooledConnectionImpl.transactionStack.isEmpty()) {
            }
            pooledConnectionImpl.transactionStack.addLast(new TransactionItem(size2, false));
            return Unit.INSTANCE;
        } finally {
            connectionWithLock.unlock(null);
        }
        pooledConnectionImpl$beginTransaction$1 = new PooledConnectionImpl$beginTransaction$1(this, continuation);
        Object obj2 = pooledConnectionImpl$beginTransaction$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = pooledConnectionImpl$beginTransaction$1.label;
        if (i != 0) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0029  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0041  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0061 A[Catch: all -> 0x00e4, TryCatch #0 {all -> 0x00e4, blocks: (B:18:0x0059, B:20:0x0061, B:22:0x006f, B:24:0x0075, B:26:0x007d, B:32:0x00d2, B:27:0x0087, B:28:0x00a4, B:30:0x00ac, B:31:0x00b6, B:35:0x00d8, B:36:0x00e3), top: B:40:0x0059 }] */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00d8 A[Catch: all -> 0x00e4, TRY_ENTER, TryCatch #0 {all -> 0x00e4, blocks: (B:18:0x0059, B:20:0x0061, B:22:0x006f, B:24:0x0075, B:26:0x007d, B:32:0x00d2, B:27:0x0087, B:28:0x00a4, B:30:0x00ac, B:31:0x00b6, B:35:0x00d8, B:36:0x00e3), top: B:40:0x0059 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object endTransaction(boolean z, Continuation<? super Unit> continuation) {
        PooledConnectionImpl$endTransaction$1 pooledConnectionImpl$endTransaction$1;
        int i;
        PooledConnectionImpl pooledConnectionImpl;
        Mutex mutex;
        try {
            if (continuation instanceof PooledConnectionImpl$endTransaction$1) {
                pooledConnectionImpl$endTransaction$1 = (PooledConnectionImpl$endTransaction$1) continuation;
                if ((pooledConnectionImpl$endTransaction$1.label & Integer.MIN_VALUE) != 0) {
                    pooledConnectionImpl$endTransaction$1.label -= Integer.MIN_VALUE;
                    Object obj = pooledConnectionImpl$endTransaction$1.result;
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    i = pooledConnectionImpl$endTransaction$1.label;
                    if (i != 0) {
                        ResultKt.throwOnFailure(obj);
                        ConnectionWithLock connectionWithLock = this.delegate;
                        pooledConnectionImpl$endTransaction$1.L$0 = this;
                        pooledConnectionImpl$endTransaction$1.L$1 = connectionWithLock;
                        pooledConnectionImpl$endTransaction$1.Z$0 = z;
                        pooledConnectionImpl$endTransaction$1.label = 1;
                        if (connectionWithLock.lock(null, pooledConnectionImpl$endTransaction$1) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        pooledConnectionImpl = this;
                        mutex = connectionWithLock;
                    } else if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    } else {
                        z = pooledConnectionImpl$endTransaction$1.Z$0;
                        mutex = (Mutex) pooledConnectionImpl$endTransaction$1.L$1;
                        pooledConnectionImpl = (PooledConnectionImpl) pooledConnectionImpl$endTransaction$1.L$0;
                        ResultKt.throwOnFailure(obj);
                    }
                    if (!pooledConnectionImpl.transactionStack.isEmpty()) {
                        throw new IllegalStateException("Not in a transaction".toString());
                    }
                    TransactionItem transactionItem = (TransactionItem) CollectionsKt.removeLast(pooledConnectionImpl.transactionStack);
                    if (z && !transactionItem.getShouldRollback()) {
                        if (pooledConnectionImpl.transactionStack.isEmpty()) {
                            SQLite.execSQL(pooledConnectionImpl.delegate, "END TRANSACTION");
                        } else {
                            SQLite.execSQL(pooledConnectionImpl.delegate, "RELEASE SAVEPOINT '" + transactionItem.getId() + '\'');
                        }
                    } else if (pooledConnectionImpl.transactionStack.isEmpty()) {
                        SQLite.execSQL(pooledConnectionImpl.delegate, "ROLLBACK TRANSACTION");
                    } else {
                        SQLite.execSQL(pooledConnectionImpl.delegate, "ROLLBACK TRANSACTION TO SAVEPOINT '" + transactionItem.getId() + '\'');
                    }
                    return Unit.INSTANCE;
                }
            }
            if (!pooledConnectionImpl.transactionStack.isEmpty()) {
            }
        } finally {
            mutex.unlock(null);
        }
        pooledConnectionImpl$endTransaction$1 = new PooledConnectionImpl$endTransaction$1(this, continuation);
        Object obj2 = pooledConnectionImpl$endTransaction$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = pooledConnectionImpl$endTransaction$1.label;
        if (i != 0) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: ConnectionPoolImpl.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\b\u0002\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"Landroidx/room/coroutines/PooledConnectionImpl$TransactionItem;", "", "id", "", "shouldRollback", "", "<init>", "(IZ)V", "getId", "()I", "getShouldRollback", "()Z", "setShouldRollback", "(Z)V", "room-runtime_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class TransactionItem {
        private final int id;
        private boolean shouldRollback;

        public TransactionItem(int i, boolean z) {
            this.id = i;
            this.shouldRollback = z;
        }

        public final int getId() {
            return this.id;
        }

        public final boolean getShouldRollback() {
            return this.shouldRollback;
        }

        public final void setShouldRollback(boolean z) {
            this.shouldRollback = z;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: ConnectionPoolImpl.kt */
    @Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0001\n\u0002\b\u0003\b\u0082\u0004\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u00022\u00020\u0003B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J0\u0010\n\u001a\u0002H\u000b\"\u0004\b\u0001\u0010\u000b2\u0006\u0010\f\u001a\u00020\r2\u0012\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u0002H\u000b0\u000fH\u0096@¢\u0006\u0002\u0010\u0011J>\u0010\u0012\u001a\u0002H\u000b\"\u0004\b\u0001\u0010\u000b2(\u0010\u000e\u001a$\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u000b0\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u000b0\u0014\u0012\u0006\u0012\u0004\u0018\u00010\u00150\u0013H\u0096@¢\u0006\u0002\u0010\u0016J\u0016\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00028\u0000H\u0096@¢\u0006\u0002\u0010\u001aR\u0014\u0010\u0006\u001a\u00020\u00078VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\t¨\u0006\u001b"}, d2 = {"Landroidx/room/coroutines/PooledConnectionImpl$TransactionImpl;", ExifInterface.GPS_DIRECTION_TRUE, "Landroidx/room/TransactionScope;", "Landroidx/room/coroutines/RawConnectionAccessor;", "<init>", "(Landroidx/room/coroutines/PooledConnectionImpl;)V", "rawConnection", "Landroidx/sqlite/SQLiteConnection;", "getRawConnection", "()Landroidx/sqlite/SQLiteConnection;", "usePrepared", "R", "sql", "", "block", "Lkotlin/Function1;", "Landroidx/sqlite/SQLiteStatement;", "(Ljava/lang/String;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "withNestedTransaction", "Lkotlin/Function2;", "Lkotlin/coroutines/Continuation;", "", "(Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "rollback", "", "result", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "room-runtime_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public final class TransactionImpl<T> implements TransactionScope<T>, RawConnectionAccessor {
        public TransactionImpl() {
        }

        @Override // androidx.room.coroutines.RawConnectionAccessor
        public SQLiteConnection getRawConnection() {
            return PooledConnectionImpl.this.getRawConnection();
        }

        @Override // androidx.room.PooledConnection
        public <R> Object usePrepared(String str, Function1<? super SQLiteStatement, ? extends R> function1, Continuation<? super R> continuation) {
            return PooledConnectionImpl.this.usePrepared(str, function1, continuation);
        }

        @Override // androidx.room.TransactionScope
        public <R> Object withNestedTransaction(Function2<? super TransactionScope<R>, ? super Continuation<? super R>, ? extends Object> function2, Continuation<? super R> continuation) {
            PooledConnectionImpl pooledConnectionImpl = PooledConnectionImpl.this;
            if (pooledConnectionImpl.isRecycled()) {
                SQLite.throwSQLiteException(21, "Connection is recycled");
                throw new KotlinNothingValueException();
            }
            ConnectionElement connectionElement = (ConnectionElement) continuation.getContext().get(ConnectionElement.Key);
            if (connectionElement != null && connectionElement.getConnectionWrapper() == pooledConnectionImpl) {
                return pooledConnectionImpl.transaction(null, function2, continuation);
            }
            SQLite.throwSQLiteException(21, "Attempted to use connection on a different coroutine");
            throw new KotlinNothingValueException();
        }

        /* JADX WARN: Removed duplicated region for block: B:10:0x0025  */
        /* JADX WARN: Removed duplicated region for block: B:14:0x003d  */
        @Override // androidx.room.TransactionScope
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public Object rollback(T t, Continuation<?> continuation) {
            PooledConnectionImpl$TransactionImpl$rollback$1 pooledConnectionImpl$TransactionImpl$rollback$1;
            int i;
            Object obj;
            PooledConnectionImpl pooledConnectionImpl;
            Mutex mutex;
            try {
                if (continuation instanceof PooledConnectionImpl$TransactionImpl$rollback$1) {
                    pooledConnectionImpl$TransactionImpl$rollback$1 = (PooledConnectionImpl$TransactionImpl$rollback$1) continuation;
                    if ((pooledConnectionImpl$TransactionImpl$rollback$1.label & Integer.MIN_VALUE) != 0) {
                        pooledConnectionImpl$TransactionImpl$rollback$1.label -= Integer.MIN_VALUE;
                        Object obj2 = pooledConnectionImpl$TransactionImpl$rollback$1.result;
                        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                        i = pooledConnectionImpl$TransactionImpl$rollback$1.label;
                        if (i != 0) {
                            ResultKt.throwOnFailure(obj2);
                            PooledConnectionImpl pooledConnectionImpl2 = PooledConnectionImpl.this;
                            if (pooledConnectionImpl2.isRecycled()) {
                                SQLite.throwSQLiteException(21, "Connection is recycled");
                                throw new KotlinNothingValueException();
                            }
                            ConnectionElement connectionElement = (ConnectionElement) pooledConnectionImpl$TransactionImpl$rollback$1.getContext().get(ConnectionElement.Key);
                            if (connectionElement != null && connectionElement.getConnectionWrapper() == pooledConnectionImpl2) {
                                if (pooledConnectionImpl2.transactionStack.isEmpty()) {
                                    throw new IllegalStateException("Not in a transaction".toString());
                                }
                                ConnectionWithLock delegate = pooledConnectionImpl2.getDelegate();
                                pooledConnectionImpl$TransactionImpl$rollback$1.L$0 = t;
                                pooledConnectionImpl$TransactionImpl$rollback$1.L$1 = pooledConnectionImpl2;
                                pooledConnectionImpl$TransactionImpl$rollback$1.L$2 = delegate;
                                pooledConnectionImpl$TransactionImpl$rollback$1.label = 1;
                                if (delegate.lock(null, pooledConnectionImpl$TransactionImpl$rollback$1) == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                                obj = t;
                                pooledConnectionImpl = pooledConnectionImpl2;
                                mutex = delegate;
                            } else {
                                SQLite.throwSQLiteException(21, "Attempted to use connection on a different coroutine");
                                throw new KotlinNothingValueException();
                            }
                        } else if (i != 1) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        } else {
                            mutex = (Mutex) pooledConnectionImpl$TransactionImpl$rollback$1.L$2;
                            pooledConnectionImpl = (PooledConnectionImpl) pooledConnectionImpl$TransactionImpl$rollback$1.L$1;
                            obj = pooledConnectionImpl$TransactionImpl$rollback$1.L$0;
                            ResultKt.throwOnFailure(obj2);
                        }
                        ((TransactionItem) pooledConnectionImpl.transactionStack.last()).setShouldRollback(true);
                        Unit unit = Unit.INSTANCE;
                        mutex.unlock(null);
                        throw new ConnectionPool.RollbackException(obj);
                    }
                }
                ((TransactionItem) pooledConnectionImpl.transactionStack.last()).setShouldRollback(true);
                Unit unit2 = Unit.INSTANCE;
                mutex.unlock(null);
                throw new ConnectionPool.RollbackException(obj);
            } catch (Throwable th) {
                mutex.unlock(null);
                throw th;
            }
            pooledConnectionImpl$TransactionImpl$rollback$1 = new PooledConnectionImpl$TransactionImpl$rollback$1(this, continuation);
            Object obj22 = pooledConnectionImpl$TransactionImpl$rollback$1.result;
            Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            i = pooledConnectionImpl$TransactionImpl$rollback$1.label;
            if (i != 0) {
            }
        }
    }

    private final <R> Object withStateCheck(Function0<? extends R> function0, Continuation<? super R> continuation) {
        if (isRecycled()) {
            SQLite.throwSQLiteException(21, "Connection is recycled");
            throw new KotlinNothingValueException();
        }
        Continuation continuation2 = null;
        continuation2.getContext();
        throw null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: ConnectionPoolImpl.kt */
    @Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0082\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0004\b\u0003\u0010\u0004J\u0018\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u0018\u0010\r\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u000eH\u0016J\u0018\u0010\u000f\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0006H\u0016J\u0018\u0010\u0010\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0011H\u0016J\u0010\u0010\u0012\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016J\u0010\u0010\u0013\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\nH\u0016J\u0010\u0010\u0014\u001a\u00020\u000e2\u0006\u0010\t\u001a\u00020\nH\u0016J\u0010\u0010\u0015\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\nH\u0016J\u0010\u0010\u0016\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\nH\u0016J\u0010\u0010\u0017\u001a\u00020\u00182\u0006\u0010\t\u001a\u00020\nH\u0016J\b\u0010\u0019\u001a\u00020\nH\u0016J\u0010\u0010\u001a\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\nH\u0016J\u0010\u0010\u001b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\nH\u0016J\b\u0010\u001c\u001a\u00020\u0018H\u0016J\b\u0010\u001d\u001a\u00020\bH\u0016J\b\u0010\u001e\u001a\u00020\bH\u0016J\b\u0010\u001f\u001a\u00020\bH\u0016J\"\u0010 \u001a\u0002H!\"\u0004\b\u0000\u0010!2\f\u0010\"\u001a\b\u0012\u0004\u0012\u0002H!0#H\u0082\b¢\u0006\u0002\u0010$R\u000e\u0010\u0002\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006%"}, d2 = {"Landroidx/room/coroutines/PooledConnectionImpl$StatementWrapper;", "Landroidx/sqlite/SQLiteStatement;", "delegate", "<init>", "(Landroidx/room/coroutines/PooledConnectionImpl;Landroidx/sqlite/SQLiteStatement;)V", "threadId", "", "bindBlob", "", FirebaseAnalytics.Param.INDEX, "", "value", "", "bindDouble", "", "bindLong", "bindText", "", "bindNull", "getBlob", "getDouble", "getLong", "getText", "isNull", "", "getColumnCount", "getColumnName", "getColumnType", "step", "reset", "clearBindings", "close", "withStateCheck", "R", "block", "Lkotlin/Function0;", "(Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "room-runtime_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public final class StatementWrapper implements SQLiteStatement {
        private final SQLiteStatement delegate;
        final /* synthetic */ PooledConnectionImpl this$0;
        private final long threadId;

        public StatementWrapper(PooledConnectionImpl pooledConnectionImpl, SQLiteStatement delegate) {
            Intrinsics.checkNotNullParameter(delegate, "delegate");
            this.this$0 = pooledConnectionImpl;
            this.delegate = delegate;
            this.threadId = ThreadLocal_jvmAndroidKt.currentThreadId();
        }

        private final <R> R withStateCheck(Function0<? extends R> function0) {
            if (this.this$0.isRecycled()) {
                SQLite.throwSQLiteException(21, "Statement is recycled");
                throw new KotlinNothingValueException();
            } else if (this.threadId != ThreadLocal_jvmAndroidKt.currentThreadId()) {
                SQLite.throwSQLiteException(21, "Attempted to use statement on a different thread");
                throw new KotlinNothingValueException();
            } else {
                return function0.invoke();
            }
        }

        @Override // androidx.sqlite.SQLiteStatement
        /* renamed from: bindBlob */
        public void mo7566bindBlob(int i, byte[] value) {
            Intrinsics.checkNotNullParameter(value, "value");
            if (this.this$0.isRecycled()) {
                SQLite.throwSQLiteException(21, "Statement is recycled");
                throw new KotlinNothingValueException();
            } else if (this.threadId == ThreadLocal_jvmAndroidKt.currentThreadId()) {
                this.delegate.mo7566bindBlob(i, value);
            } else {
                SQLite.throwSQLiteException(21, "Attempted to use statement on a different thread");
                throw new KotlinNothingValueException();
            }
        }

        @Override // androidx.sqlite.SQLiteStatement
        /* renamed from: bindDouble */
        public void mo7567bindDouble(int i, double d) {
            if (this.this$0.isRecycled()) {
                SQLite.throwSQLiteException(21, "Statement is recycled");
                throw new KotlinNothingValueException();
            } else if (this.threadId == ThreadLocal_jvmAndroidKt.currentThreadId()) {
                this.delegate.mo7567bindDouble(i, d);
            } else {
                SQLite.throwSQLiteException(21, "Attempted to use statement on a different thread");
                throw new KotlinNothingValueException();
            }
        }

        @Override // androidx.sqlite.SQLiteStatement
        /* renamed from: bindLong */
        public void mo7568bindLong(int i, long j) {
            if (this.this$0.isRecycled()) {
                SQLite.throwSQLiteException(21, "Statement is recycled");
                throw new KotlinNothingValueException();
            } else if (this.threadId == ThreadLocal_jvmAndroidKt.currentThreadId()) {
                this.delegate.mo7568bindLong(i, j);
            } else {
                SQLite.throwSQLiteException(21, "Attempted to use statement on a different thread");
                throw new KotlinNothingValueException();
            }
        }

        @Override // androidx.sqlite.SQLiteStatement
        /* renamed from: bindText */
        public void mo7570bindText(int i, String value) {
            Intrinsics.checkNotNullParameter(value, "value");
            if (this.this$0.isRecycled()) {
                SQLite.throwSQLiteException(21, "Statement is recycled");
                throw new KotlinNothingValueException();
            } else if (this.threadId == ThreadLocal_jvmAndroidKt.currentThreadId()) {
                this.delegate.mo7570bindText(i, value);
            } else {
                SQLite.throwSQLiteException(21, "Attempted to use statement on a different thread");
                throw new KotlinNothingValueException();
            }
        }

        @Override // androidx.sqlite.SQLiteStatement
        /* renamed from: bindNull */
        public void mo7569bindNull(int i) {
            if (this.this$0.isRecycled()) {
                SQLite.throwSQLiteException(21, "Statement is recycled");
                throw new KotlinNothingValueException();
            } else if (this.threadId == ThreadLocal_jvmAndroidKt.currentThreadId()) {
                this.delegate.mo7569bindNull(i);
            } else {
                SQLite.throwSQLiteException(21, "Attempted to use statement on a different thread");
                throw new KotlinNothingValueException();
            }
        }

        @Override // androidx.sqlite.SQLiteStatement
        public byte[] getBlob(int i) {
            if (this.this$0.isRecycled()) {
                SQLite.throwSQLiteException(21, "Statement is recycled");
                throw new KotlinNothingValueException();
            } else if (this.threadId == ThreadLocal_jvmAndroidKt.currentThreadId()) {
                return this.delegate.getBlob(i);
            } else {
                SQLite.throwSQLiteException(21, "Attempted to use statement on a different thread");
                throw new KotlinNothingValueException();
            }
        }

        @Override // androidx.sqlite.SQLiteStatement
        public double getDouble(int i) {
            if (this.this$0.isRecycled()) {
                SQLite.throwSQLiteException(21, "Statement is recycled");
                throw new KotlinNothingValueException();
            } else if (this.threadId == ThreadLocal_jvmAndroidKt.currentThreadId()) {
                return this.delegate.getDouble(i);
            } else {
                SQLite.throwSQLiteException(21, "Attempted to use statement on a different thread");
                throw new KotlinNothingValueException();
            }
        }

        @Override // androidx.sqlite.SQLiteStatement
        public long getLong(int i) {
            if (this.this$0.isRecycled()) {
                SQLite.throwSQLiteException(21, "Statement is recycled");
                throw new KotlinNothingValueException();
            } else if (this.threadId == ThreadLocal_jvmAndroidKt.currentThreadId()) {
                return this.delegate.getLong(i);
            } else {
                SQLite.throwSQLiteException(21, "Attempted to use statement on a different thread");
                throw new KotlinNothingValueException();
            }
        }

        @Override // androidx.sqlite.SQLiteStatement
        public String getText(int i) {
            if (this.this$0.isRecycled()) {
                SQLite.throwSQLiteException(21, "Statement is recycled");
                throw new KotlinNothingValueException();
            } else if (this.threadId == ThreadLocal_jvmAndroidKt.currentThreadId()) {
                return this.delegate.getText(i);
            } else {
                SQLite.throwSQLiteException(21, "Attempted to use statement on a different thread");
                throw new KotlinNothingValueException();
            }
        }

        @Override // androidx.sqlite.SQLiteStatement
        public boolean isNull(int i) {
            if (this.this$0.isRecycled()) {
                SQLite.throwSQLiteException(21, "Statement is recycled");
                throw new KotlinNothingValueException();
            } else if (this.threadId == ThreadLocal_jvmAndroidKt.currentThreadId()) {
                return this.delegate.isNull(i);
            } else {
                SQLite.throwSQLiteException(21, "Attempted to use statement on a different thread");
                throw new KotlinNothingValueException();
            }
        }

        @Override // androidx.sqlite.SQLiteStatement
        public int getColumnCount() {
            if (this.this$0.isRecycled()) {
                SQLite.throwSQLiteException(21, "Statement is recycled");
                throw new KotlinNothingValueException();
            } else if (this.threadId == ThreadLocal_jvmAndroidKt.currentThreadId()) {
                return this.delegate.getColumnCount();
            } else {
                SQLite.throwSQLiteException(21, "Attempted to use statement on a different thread");
                throw new KotlinNothingValueException();
            }
        }

        @Override // androidx.sqlite.SQLiteStatement
        public String getColumnName(int i) {
            if (this.this$0.isRecycled()) {
                SQLite.throwSQLiteException(21, "Statement is recycled");
                throw new KotlinNothingValueException();
            } else if (this.threadId == ThreadLocal_jvmAndroidKt.currentThreadId()) {
                return this.delegate.getColumnName(i);
            } else {
                SQLite.throwSQLiteException(21, "Attempted to use statement on a different thread");
                throw new KotlinNothingValueException();
            }
        }

        @Override // androidx.sqlite.SQLiteStatement
        public int getColumnType(int i) {
            if (this.this$0.isRecycled()) {
                SQLite.throwSQLiteException(21, "Statement is recycled");
                throw new KotlinNothingValueException();
            } else if (this.threadId == ThreadLocal_jvmAndroidKt.currentThreadId()) {
                return this.delegate.getColumnType(i);
            } else {
                SQLite.throwSQLiteException(21, "Attempted to use statement on a different thread");
                throw new KotlinNothingValueException();
            }
        }

        @Override // androidx.sqlite.SQLiteStatement
        public boolean step() {
            if (this.this$0.isRecycled()) {
                SQLite.throwSQLiteException(21, "Statement is recycled");
                throw new KotlinNothingValueException();
            } else if (this.threadId == ThreadLocal_jvmAndroidKt.currentThreadId()) {
                return this.delegate.step();
            } else {
                SQLite.throwSQLiteException(21, "Attempted to use statement on a different thread");
                throw new KotlinNothingValueException();
            }
        }

        @Override // androidx.sqlite.SQLiteStatement
        public void reset() {
            if (this.this$0.isRecycled()) {
                SQLite.throwSQLiteException(21, "Statement is recycled");
                throw new KotlinNothingValueException();
            } else if (this.threadId == ThreadLocal_jvmAndroidKt.currentThreadId()) {
                this.delegate.reset();
            } else {
                SQLite.throwSQLiteException(21, "Attempted to use statement on a different thread");
                throw new KotlinNothingValueException();
            }
        }

        @Override // androidx.sqlite.SQLiteStatement
        /* renamed from: clearBindings */
        public void mo7571clearBindings() {
            if (this.this$0.isRecycled()) {
                SQLite.throwSQLiteException(21, "Statement is recycled");
                throw new KotlinNothingValueException();
            } else if (this.threadId == ThreadLocal_jvmAndroidKt.currentThreadId()) {
                this.delegate.mo7571clearBindings();
            } else {
                SQLite.throwSQLiteException(21, "Attempted to use statement on a different thread");
                throw new KotlinNothingValueException();
            }
        }

        @Override // androidx.sqlite.SQLiteStatement, java.lang.AutoCloseable
        public void close() {
            if (this.this$0.isRecycled()) {
                SQLite.throwSQLiteException(21, "Statement is recycled");
                throw new KotlinNothingValueException();
            } else if (this.threadId == ThreadLocal_jvmAndroidKt.currentThreadId()) {
                this.delegate.close();
            } else {
                SQLite.throwSQLiteException(21, "Attempted to use statement on a different thread");
                throw new KotlinNothingValueException();
            }
        }
    }

    @Override // androidx.room.Transactor
    public <R> Object withTransaction(Transactor.SQLiteTransactionType sQLiteTransactionType, Function2<? super TransactionScope<R>, ? super Continuation<? super R>, ? extends Object> function2, Continuation<? super R> continuation) {
        if (isRecycled()) {
            SQLite.throwSQLiteException(21, "Connection is recycled");
            throw new KotlinNothingValueException();
        }
        ConnectionElement connectionElement = (ConnectionElement) continuation.getContext().get(ConnectionElement.Key);
        if (connectionElement != null && connectionElement.getConnectionWrapper() == this) {
            return transaction(sQLiteTransactionType, function2, continuation);
        }
        SQLite.throwSQLiteException(21, "Attempted to use connection on a different coroutine");
        throw new KotlinNothingValueException();
    }

    @Override // androidx.room.Transactor
    public Object inTransaction(Continuation<? super Boolean> continuation) {
        if (isRecycled()) {
            SQLite.throwSQLiteException(21, "Connection is recycled");
            throw new KotlinNothingValueException();
        }
        ConnectionElement connectionElement = (ConnectionElement) continuation.getContext().get(ConnectionElement.Key);
        if (connectionElement != null && connectionElement.getConnectionWrapper() == this) {
            return Boxing.boxBoolean(!this.transactionStack.isEmpty());
        }
        SQLite.throwSQLiteException(21, "Attempted to use connection on a different coroutine");
        throw new KotlinNothingValueException();
    }
}
