package androidx.room.coroutines;

import android.database.SQLException;
import androidx.room.Transactor;
import androidx.room.concurrent.ThreadLocal_jvmAndroidKt;
import androidx.sqlite.SQLite;
import androidx.sqlite.SQLiteConnection;
import androidx.sqlite.SQLiteDriver;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.ExceptionsKt;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.time.Duration;
import kotlin.time.DurationKt;
import kotlin.time.DurationUnit;
import kotlinx.coroutines.BuildersKt;
/* compiled from: ConnectionPoolImpl.kt */
@Metadata(d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\u0019\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007B)\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u0006\u0010\u000bJ@\u0010&\u001a\u0002H'\"\u0004\b\u0000\u0010'2\u0006\u0010(\u001a\u00020\u00192\"\u0010)\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020+\u0012\n\u0012\b\u0012\u0004\u0012\u0002H'0,\u0012\u0006\u0012\u0004\u0018\u00010-0*H\u0096@¢\u0006\u0002\u0010.J\u0010\u0010/\u001a\u0002002\u0006\u00101\u001a\u00020\u0011H\u0002J\u0010\u00102\u001a\u0002032\u0006\u0010(\u001a\u00020\u0019H\u0002J\b\u00104\u001a\u000203H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R \u0010\u000f\u001a\u0012\u0012\u0004\u0012\u00020\u00110\u0010j\b\u0012\u0004\u0012\u00020\u0011`\u0012X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0013R\u0014\u0010\u0014\u001a\u00060\u0015j\u0002`\u0016X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0017R\u0014\u0010\u0018\u001a\u00020\u00198BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u001aR\u001c\u0010\u001b\u001a\u00020\u001cX\u0080\u000e¢\u0006\u0010\n\u0002\u0010!\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u001a\u0010\"\u001a\u00020\u0019X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\u001a\"\u0004\b$\u0010%¨\u00065"}, d2 = {"Landroidx/room/coroutines/ConnectionPoolImpl;", "Landroidx/room/coroutines/ConnectionPool;", "driver", "Landroidx/sqlite/SQLiteDriver;", "fileName", "", "<init>", "(Landroidx/sqlite/SQLiteDriver;Ljava/lang/String;)V", "maxNumOfReaders", "", "maxNumOfWriters", "(Landroidx/sqlite/SQLiteDriver;Ljava/lang/String;II)V", "readers", "Landroidx/room/coroutines/Pool;", "writers", "threadLocal", "Ljava/lang/ThreadLocal;", "Landroidx/room/coroutines/PooledConnectionImpl;", "Landroidx/room/concurrent/ThreadLocal;", "Ljava/lang/ThreadLocal;", "_isClosed", "Ljava/util/concurrent/atomic/AtomicBoolean;", "Landroidx/room/concurrent/AtomicBoolean;", "Ljava/util/concurrent/atomic/AtomicBoolean;", "isClosed", "", "()Z", "timeout", "Lkotlin/time/Duration;", "getTimeout-UwyO8pc$room_runtime_release", "()J", "setTimeout-LRDsOJo$room_runtime_release", "(J)V", "J", "throwOnTimeout", "getThrowOnTimeout$room_runtime_release", "setThrowOnTimeout$room_runtime_release", "(Z)V", "useConnection", "R", "isReadOnly", "block", "Lkotlin/Function2;", "Landroidx/room/Transactor;", "Lkotlin/coroutines/Continuation;", "", "(ZLkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "createConnectionContext", "Lkotlin/coroutines/CoroutineContext;", "connection", "onTimeout", "", "close", "room-runtime_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class ConnectionPoolImpl implements ConnectionPool {
    private final AtomicBoolean _isClosed;
    private final SQLiteDriver driver;
    private final Pool readers;
    private final ThreadLocal<PooledConnectionImpl> threadLocal;
    private boolean throwOnTimeout;
    private long timeout;
    private final Pool writers;

    private final boolean isClosed() {
        return this._isClosed.get();
    }

    /* renamed from: getTimeout-UwyO8pc$room_runtime_release  reason: not valid java name */
    public final long m7563getTimeoutUwyO8pc$room_runtime_release() {
        return this.timeout;
    }

    /* renamed from: setTimeout-LRDsOJo$room_runtime_release  reason: not valid java name */
    public final void m7564setTimeoutLRDsOJo$room_runtime_release(long j) {
        this.timeout = j;
    }

    public final boolean getThrowOnTimeout$room_runtime_release() {
        return this.throwOnTimeout;
    }

    public final void setThrowOnTimeout$room_runtime_release(boolean z) {
        this.throwOnTimeout = z;
    }

    public ConnectionPoolImpl(final SQLiteDriver driver, final String fileName) {
        Intrinsics.checkNotNullParameter(driver, "driver");
        Intrinsics.checkNotNullParameter(fileName, "fileName");
        this.threadLocal = new ThreadLocal<>();
        this._isClosed = new AtomicBoolean(false);
        Duration.Companion companion = Duration.Companion;
        this.timeout = DurationKt.toDuration(30, DurationUnit.SECONDS);
        this.driver = driver;
        Pool pool = new Pool(1, new Function0() { // from class: androidx.room.coroutines.ConnectionPoolImpl$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                SQLiteConnection open;
                open = SQLiteDriver.this.open(fileName);
                return open;
            }
        });
        this.readers = pool;
        this.writers = pool;
    }

    public ConnectionPoolImpl(final SQLiteDriver driver, final String fileName, int i, int i2) {
        Intrinsics.checkNotNullParameter(driver, "driver");
        Intrinsics.checkNotNullParameter(fileName, "fileName");
        this.threadLocal = new ThreadLocal<>();
        this._isClosed = new AtomicBoolean(false);
        Duration.Companion companion = Duration.Companion;
        this.timeout = DurationKt.toDuration(30, DurationUnit.SECONDS);
        if (i <= 0) {
            throw new IllegalArgumentException("Maximum number of readers must be greater than 0".toString());
        }
        if (i2 <= 0) {
            throw new IllegalArgumentException("Maximum number of writers must be greater than 0".toString());
        }
        this.driver = driver;
        this.readers = new Pool(i, new Function0() { // from class: androidx.room.coroutines.ConnectionPoolImpl$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                SQLiteConnection _init_$lambda$4;
                _init_$lambda$4 = ConnectionPoolImpl._init_$lambda$4(SQLiteDriver.this, fileName);
                return _init_$lambda$4;
            }
        });
        this.writers = new Pool(i2, new Function0() { // from class: androidx.room.coroutines.ConnectionPoolImpl$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                SQLiteConnection open;
                open = SQLiteDriver.this.open(fileName);
                return open;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final SQLiteConnection _init_$lambda$4(SQLiteDriver sQLiteDriver, String str) {
        SQLiteConnection open = sQLiteDriver.open(str);
        SQLite.execSQL(open, "PRAGMA query_only = 1");
        return open;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0028  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0079  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x0133 A[Catch: all -> 0x017e, TRY_LEAVE, TryCatch #5 {all -> 0x017e, blocks: (B:63:0x0118, B:68:0x0128, B:70:0x0133, B:78:0x0172, B:79:0x017d, B:59:0x00f3), top: B:104:0x00f3 }] */
    /* JADX WARN: Removed duplicated region for block: B:76:0x0160 A[Catch: all -> 0x0171, TRY_LEAVE, TryCatch #0 {all -> 0x0171, blocks: (B:74:0x015a, B:76:0x0160), top: B:94:0x015a }] */
    /* JADX WARN: Removed duplicated region for block: B:78:0x0172 A[Catch: all -> 0x017e, TRY_ENTER, TryCatch #5 {all -> 0x017e, blocks: (B:63:0x0118, B:68:0x0128, B:70:0x0133, B:78:0x0172, B:79:0x017d, B:59:0x00f3), top: B:104:0x00f3 }] */
    /* JADX WARN: Type inference failed for: r13v14, types: [androidx.room.coroutines.PooledConnectionImpl, T] */
    @Override // androidx.room.coroutines.ConnectionPool
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public <R> Object useConnection(final boolean z, Function2<? super Transactor, ? super Continuation<? super R>, ? extends Object> function2, Continuation<? super R> continuation) {
        ConnectionPoolImpl$useConnection$1 connectionPoolImpl$useConnection$1;
        int i;
        Pool pool;
        Ref.ObjectRef objectRef;
        Pool pool2;
        Throwable th;
        Ref.ObjectRef objectRef2;
        CoroutineContext context;
        Object m7565acquireWithTimeoutKLykuaI;
        ConnectionPoolImpl connectionPoolImpl;
        Function2<? super Transactor, ? super Continuation<? super R>, ? extends Object> function22;
        Ref.ObjectRef objectRef3;
        PooledConnectionImpl pooledConnectionImpl;
        if (continuation instanceof ConnectionPoolImpl$useConnection$1) {
            connectionPoolImpl$useConnection$1 = (ConnectionPoolImpl$useConnection$1) continuation;
            if ((connectionPoolImpl$useConnection$1.label & Integer.MIN_VALUE) != 0) {
                connectionPoolImpl$useConnection$1.label -= Integer.MIN_VALUE;
                Object obj = connectionPoolImpl$useConnection$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = connectionPoolImpl$useConnection$1.label;
                boolean z2 = true;
                if (i == 0) {
                    if (i == 1) {
                        ResultKt.throwOnFailure(obj);
                        return obj;
                    } else if (i == 2) {
                        ResultKt.throwOnFailure(obj);
                        return obj;
                    } else {
                        if (i == 3) {
                            z = connectionPoolImpl$useConnection$1.Z$0;
                            objectRef3 = (Ref.ObjectRef) connectionPoolImpl$useConnection$1.L$5;
                            CoroutineContext coroutineContext = (CoroutineContext) connectionPoolImpl$useConnection$1.L$4;
                            Ref.ObjectRef objectRef4 = (Ref.ObjectRef) connectionPoolImpl$useConnection$1.L$3;
                            Pool pool3 = (Pool) connectionPoolImpl$useConnection$1.L$2;
                            function22 = (Function2) connectionPoolImpl$useConnection$1.L$1;
                            connectionPoolImpl = (ConnectionPoolImpl) connectionPoolImpl$useConnection$1.L$0;
                            try {
                                ResultKt.throwOnFailure(obj);
                                m7565acquireWithTimeoutKLykuaI = obj;
                                pool = pool3;
                                context = coroutineContext;
                                objectRef = objectRef4;
                            } catch (Throwable th2) {
                                th = th2;
                                objectRef2 = objectRef4;
                                pool2 = pool3;
                            }
                        } else if (i != 4) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        } else {
                            objectRef2 = (Ref.ObjectRef) connectionPoolImpl$useConnection$1.L$1;
                            pool2 = (Pool) connectionPoolImpl$useConnection$1.L$0;
                            try {
                                ResultKt.throwOnFailure(obj);
                                try {
                                    pooledConnectionImpl = (PooledConnectionImpl) objectRef2.element;
                                    if (pooledConnectionImpl != null) {
                                        pooledConnectionImpl.markRecycled();
                                        pooledConnectionImpl.getDelegate().markReleased();
                                        pool2.recycle(pooledConnectionImpl.getDelegate());
                                    }
                                } catch (Throwable unused) {
                                }
                                return obj;
                            } catch (Throwable th3) {
                                th = th3;
                            }
                        }
                        try {
                            throw th;
                        } catch (Throwable th4) {
                            try {
                                PooledConnectionImpl pooledConnectionImpl2 = (PooledConnectionImpl) objectRef2.element;
                                if (pooledConnectionImpl2 != null) {
                                    pooledConnectionImpl2.markRecycled();
                                    pooledConnectionImpl2.getDelegate().markReleased();
                                    pool2.recycle(pooledConnectionImpl2.getDelegate());
                                }
                            } catch (Throwable th5) {
                                ExceptionsKt.addSuppressed(th, th5);
                            }
                            throw th4;
                        }
                    }
                }
                ResultKt.throwOnFailure(obj);
                if (isClosed()) {
                    SQLite.throwSQLiteException(21, "Connection pool is closed");
                    throw new KotlinNothingValueException();
                }
                PooledConnectionImpl pooledConnectionImpl3 = this.threadLocal.get();
                if (pooledConnectionImpl3 == null) {
                    ConnectionElement connectionElement = (ConnectionElement) connectionPoolImpl$useConnection$1.getContext().get(ConnectionElement.Key);
                    pooledConnectionImpl3 = connectionElement != null ? connectionElement.getConnectionWrapper() : null;
                }
                if (pooledConnectionImpl3 != null) {
                    if (!z && pooledConnectionImpl3.isReadOnly()) {
                        SQLite.throwSQLiteException(1, "Cannot upgrade connection from reader to writer");
                        throw new KotlinNothingValueException();
                    } else if (connectionPoolImpl$useConnection$1.getContext().get(ConnectionElement.Key) == null) {
                        connectionPoolImpl$useConnection$1.label = 1;
                        Object withContext = BuildersKt.withContext(createConnectionContext(pooledConnectionImpl3), new ConnectionPoolImpl$useConnection$2(function2, pooledConnectionImpl3, null), connectionPoolImpl$useConnection$1);
                        if (withContext != coroutine_suspended) {
                            return withContext;
                        }
                    } else {
                        connectionPoolImpl$useConnection$1.label = 2;
                        Object invoke = function2.invoke(pooledConnectionImpl3, connectionPoolImpl$useConnection$1);
                        if (invoke != coroutine_suspended) {
                            return invoke;
                        }
                    }
                } else {
                    if (z) {
                        pool = this.readers;
                    } else {
                        pool = this.writers;
                    }
                    objectRef = new Ref.ObjectRef();
                    try {
                        context = connectionPoolImpl$useConnection$1.getContext();
                        long j = this.timeout;
                        Function0<Unit> function0 = new Function0() { // from class: androidx.room.coroutines.ConnectionPoolImpl$$ExternalSyntheticLambda3
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                Unit useConnection$lambda$6;
                                useConnection$lambda$6 = ConnectionPoolImpl.useConnection$lambda$6(ConnectionPoolImpl.this, z);
                                return useConnection$lambda$6;
                            }
                        };
                        connectionPoolImpl$useConnection$1.L$0 = this;
                        connectionPoolImpl$useConnection$1.L$1 = function2;
                        connectionPoolImpl$useConnection$1.L$2 = pool;
                        connectionPoolImpl$useConnection$1.L$3 = objectRef;
                        connectionPoolImpl$useConnection$1.L$4 = context;
                        connectionPoolImpl$useConnection$1.L$5 = objectRef;
                        connectionPoolImpl$useConnection$1.Z$0 = z;
                        connectionPoolImpl$useConnection$1.label = 3;
                        m7565acquireWithTimeoutKLykuaI = pool.m7565acquireWithTimeoutKLykuaI(j, function0, connectionPoolImpl$useConnection$1);
                        if (m7565acquireWithTimeoutKLykuaI != coroutine_suspended) {
                            connectionPoolImpl = this;
                            function22 = function2;
                            objectRef3 = objectRef;
                        }
                    } catch (Throwable th6) {
                        pool2 = pool;
                        th = th6;
                        objectRef2 = objectRef;
                    }
                }
                return coroutine_suspended;
                ConnectionWithLock markAcquired = ((ConnectionWithLock) m7565acquireWithTimeoutKLykuaI).markAcquired(context);
                if (connectionPoolImpl.readers != connectionPoolImpl.writers || !z) {
                    z2 = false;
                }
                objectRef3.element = new PooledConnectionImpl(markAcquired, z2);
                if (objectRef.element != 0) {
                    throw new IllegalArgumentException("Required value was null.".toString());
                }
                connectionPoolImpl$useConnection$1.L$0 = pool;
                connectionPoolImpl$useConnection$1.L$1 = objectRef;
                connectionPoolImpl$useConnection$1.L$2 = null;
                connectionPoolImpl$useConnection$1.L$3 = null;
                connectionPoolImpl$useConnection$1.L$4 = null;
                connectionPoolImpl$useConnection$1.L$5 = null;
                connectionPoolImpl$useConnection$1.label = 4;
                Object withContext2 = BuildersKt.withContext(connectionPoolImpl.createConnectionContext((PooledConnectionImpl) objectRef.element), new ConnectionPoolImpl$useConnection$4(function22, objectRef, null), connectionPoolImpl$useConnection$1);
                if (withContext2 != coroutine_suspended) {
                    pool2 = pool;
                    obj = withContext2;
                    objectRef2 = objectRef;
                    pooledConnectionImpl = (PooledConnectionImpl) objectRef2.element;
                    if (pooledConnectionImpl != null) {
                    }
                    return obj;
                }
                return coroutine_suspended;
            }
        }
        connectionPoolImpl$useConnection$1 = new ConnectionPoolImpl$useConnection$1(this, continuation);
        Object obj2 = connectionPoolImpl$useConnection$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = connectionPoolImpl$useConnection$1.label;
        boolean z22 = true;
        if (i == 0) {
        }
        ConnectionWithLock markAcquired2 = ((ConnectionWithLock) m7565acquireWithTimeoutKLykuaI).markAcquired(context);
        if (connectionPoolImpl.readers != connectionPoolImpl.writers) {
        }
        z22 = false;
        objectRef3.element = new PooledConnectionImpl(markAcquired2, z22);
        if (objectRef.element != 0) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit useConnection$lambda$6(ConnectionPoolImpl connectionPoolImpl, boolean z) {
        connectionPoolImpl.onTimeout(z);
        return Unit.INSTANCE;
    }

    private final CoroutineContext createConnectionContext(PooledConnectionImpl pooledConnectionImpl) {
        return new ConnectionElement(pooledConnectionImpl).plus(ThreadLocal_jvmAndroidKt.asContextElement(this.threadLocal, pooledConnectionImpl));
    }

    private final void onTimeout(boolean z) {
        String str = z ? "reader" : "writer";
        StringBuilder sb = new StringBuilder();
        sb.append("Timed out attempting to acquire a " + str + " connection.").append("\n\nWriter pool:\n");
        this.writers.dump(sb);
        sb.append("Reader pool:").append('\n');
        this.readers.dump(sb);
        try {
            SQLite.throwSQLiteException(5, sb.toString());
            throw new KotlinNothingValueException();
        } catch (SQLException e) {
            if (this.throwOnTimeout) {
                throw e;
            }
            e.printStackTrace();
        }
    }

    @Override // androidx.room.coroutines.ConnectionPool, java.lang.AutoCloseable
    public void close() {
        if (this._isClosed.compareAndSet(false, true)) {
            this.readers.close();
            this.writers.close();
        }
    }
}
