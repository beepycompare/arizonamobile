package androidx.room.coroutines;

import android.database.SQLException;
import androidx.room.Transactor;
import androidx.room.concurrent.ThreadLocal_jvmAndroidKt;
import androidx.sqlite.SQLite;
import androidx.sqlite.SQLiteConnection;
import androidx.sqlite.SQLiteDriver;
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
@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B!\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tB1\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\n\u001a\u00020\u0007\u0012\u0006\u0010\u000b\u001a\u00020\u0007\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\fJ@\u0010%\u001a\u0002H&\"\u0004\b\u0000\u0010&2\u0006\u0010'\u001a\u00020\u00182\"\u0010(\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020*\u0012\n\u0012\b\u0012\u0004\u0012\u0002H&0+\u0012\u0006\u0012\u0004\u0018\u00010,0)H\u0096@¢\u0006\u0002\u0010-J\u0010\u0010.\u001a\u00020/2\u0006\u00100\u001a\u00020\u0014H\u0002J\u0010\u0010 \u001a\u0002012\u0006\u0010'\u001a\u00020\u0018H\u0002J\b\u00102\u001a\u000201H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R \u0010\u0012\u001a\u0012\u0012\u0004\u0012\u00020\u00140\u0013j\b\u0012\u0004\u0012\u00020\u0014`\u0015X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0016R\u000e\u0010\u0017\u001a\u00020\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u0019\u001a\u00020\u001aX\u0080\u000e¢\u0006\u0010\n\u0002\u0010\u001f\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u001a\u0010 \u001a\u00020\u0007X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$¨\u00063"}, d2 = {"Landroidx/room/coroutines/ConnectionPoolImpl;", "Landroidx/room/coroutines/ConnectionPool;", "driver", "Landroidx/sqlite/SQLiteDriver;", "fileName", "", "preparedStatementCacheSize", "", "<init>", "(Landroidx/sqlite/SQLiteDriver;Ljava/lang/String;I)V", "maxNumOfReaders", "maxNumOfWriters", "(Landroidx/sqlite/SQLiteDriver;Ljava/lang/String;III)V", "readers", "Landroidx/room/coroutines/Pool;", "writers", "connectionElementKey", "Landroidx/room/coroutines/ConnectionElementKey;", "connectionThreadLocal", "Ljava/lang/ThreadLocal;", "Landroidx/room/coroutines/PooledConnectionImpl;", "Landroidx/room/concurrent/ThreadLocal;", "Ljava/lang/ThreadLocal;", "isClosed", "", "timeout", "Lkotlin/time/Duration;", "getTimeout-UwyO8pc$room_runtime", "()J", "setTimeout-LRDsOJo$room_runtime", "(J)V", "J", "onTimeout", "getOnTimeout$room_runtime", "()I", "setOnTimeout$room_runtime", "(I)V", "useConnection", "R", "isReadOnly", "block", "Lkotlin/Function2;", "Landroidx/room/Transactor;", "Lkotlin/coroutines/Continuation;", "", "(ZLkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "createConnectionContext", "Lkotlin/coroutines/CoroutineContext;", "connection", "", "close", "room-runtime"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class ConnectionPoolImpl implements ConnectionPool {
    private final ConnectionElementKey connectionElementKey;
    private final ThreadLocal<PooledConnectionImpl> connectionThreadLocal;
    private final SQLiteDriver driver;
    private volatile boolean isClosed;
    private int onTimeout;
    private final Pool readers;
    private long timeout;
    private final Pool writers;

    /* renamed from: getTimeout-UwyO8pc$room_runtime  reason: not valid java name */
    public final long m8897getTimeoutUwyO8pc$room_runtime() {
        return this.timeout;
    }

    /* renamed from: setTimeout-LRDsOJo$room_runtime  reason: not valid java name */
    public final void m8898setTimeoutLRDsOJo$room_runtime(long j) {
        this.timeout = j;
    }

    public final int getOnTimeout$room_runtime() {
        return this.onTimeout;
    }

    public final void setOnTimeout$room_runtime(int i) {
        this.onTimeout = i;
    }

    public ConnectionPoolImpl(final SQLiteDriver driver, final String fileName, int i) {
        Intrinsics.checkNotNullParameter(driver, "driver");
        Intrinsics.checkNotNullParameter(fileName, "fileName");
        this.connectionElementKey = new ConnectionElementKey();
        this.connectionThreadLocal = new ThreadLocal<>();
        Duration.Companion companion = Duration.Companion;
        this.timeout = DurationKt.toDuration(30, DurationUnit.SECONDS);
        this.onTimeout = 2;
        this.driver = driver;
        Pool pool = new Pool(1, new Function0() { // from class: androidx.room.coroutines.ConnectionPoolImpl$$ExternalSyntheticLambda3
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                SQLiteConnection open;
                open = SQLiteDriver.this.open(fileName);
                return open;
            }
        }, i);
        this.readers = pool;
        this.writers = pool;
    }

    public ConnectionPoolImpl(final SQLiteDriver driver, final String fileName, int i, int i2, int i3) {
        Intrinsics.checkNotNullParameter(driver, "driver");
        Intrinsics.checkNotNullParameter(fileName, "fileName");
        this.connectionElementKey = new ConnectionElementKey();
        this.connectionThreadLocal = new ThreadLocal<>();
        Duration.Companion companion = Duration.Companion;
        this.timeout = DurationKt.toDuration(30, DurationUnit.SECONDS);
        this.onTimeout = 2;
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
        }, i3);
        this.writers = new Pool(i2, new Function0() { // from class: androidx.room.coroutines.ConnectionPoolImpl$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                SQLiteConnection open;
                open = SQLiteDriver.this.open(fileName);
                return open;
            }
        }, i3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final SQLiteConnection _init_$lambda$4(SQLiteDriver sQLiteDriver, String str) {
        SQLiteConnection open = sQLiteDriver.open(str);
        SQLite.execSQL(open, "PRAGMA query_only = 1");
        return open;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0030  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0087  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x0143 A[Catch: all -> 0x018d, TRY_LEAVE, TryCatch #4 {all -> 0x018d, blocks: (B:64:0x0128, B:69:0x0138, B:71:0x0143, B:79:0x0181, B:80:0x018c), top: B:105:0x0128 }] */
    /* JADX WARN: Removed duplicated region for block: B:77:0x016f  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x0181 A[Catch: all -> 0x018d, TRY_ENTER, TryCatch #4 {all -> 0x018d, blocks: (B:64:0x0128, B:69:0x0138, B:71:0x0143, B:79:0x0181, B:80:0x018c), top: B:105:0x0128 }] */
    /* JADX WARN: Type inference failed for: r0v14, types: [androidx.room.coroutines.PooledConnectionImpl, T] */
    @Override // androidx.room.coroutines.ConnectionPool
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public <R> Object useConnection(boolean z, Function2<? super Transactor, ? super Continuation<? super R>, ? extends Object> function2, Continuation<? super R> continuation) {
        ConnectionPoolImpl$useConnection$1 connectionPoolImpl$useConnection$1;
        int i;
        boolean z2;
        Pool pool;
        Ref.ObjectRef objectRef;
        Throwable th;
        Pool pool2;
        CoroutineContext context;
        Function2<? super Transactor, ? super Continuation<? super R>, ? extends Object> function22;
        ConnectionElementKey connectionElementKey;
        Pool pool3;
        Ref.ObjectRef objectRef2;
        Ref.ObjectRef objectRef3;
        PooledConnectionImpl pooledConnectionImpl;
        final boolean z3 = z;
        try {
            if (continuation instanceof ConnectionPoolImpl$useConnection$1) {
                connectionPoolImpl$useConnection$1 = (ConnectionPoolImpl$useConnection$1) continuation;
                if ((connectionPoolImpl$useConnection$1.label & Integer.MIN_VALUE) != 0) {
                    connectionPoolImpl$useConnection$1.label -= Integer.MIN_VALUE;
                    Object obj = connectionPoolImpl$useConnection$1.result;
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    i = connectionPoolImpl$useConnection$1.label;
                    z2 = true;
                    if (i != 0) {
                        ResultKt.throwOnFailure(obj);
                        if (this.isClosed) {
                            SQLite.throwSQLiteException(21, "Connection pool is closed");
                            throw new KotlinNothingValueException();
                        }
                        PooledConnectionImpl pooledConnectionImpl2 = this.connectionThreadLocal.get();
                        if (pooledConnectionImpl2 == null) {
                            ConnectionElement connectionElement = (ConnectionElement) connectionPoolImpl$useConnection$1.getContext().get(this.connectionElementKey);
                            pooledConnectionImpl2 = connectionElement != null ? connectionElement.getConnectionWrapper() : null;
                        }
                        if (pooledConnectionImpl2 != null) {
                            if (!z3 && pooledConnectionImpl2.isReadOnly()) {
                                SQLite.throwSQLiteException(1, "Cannot upgrade connection from reader to writer");
                                throw new KotlinNothingValueException();
                            } else if (connectionPoolImpl$useConnection$1.getContext().get(this.connectionElementKey) == null) {
                                connectionPoolImpl$useConnection$1.label = 1;
                                Object withContext = BuildersKt.withContext(createConnectionContext(pooledConnectionImpl2), new ConnectionPoolImpl$useConnection$2(function2, pooledConnectionImpl2, null), connectionPoolImpl$useConnection$1);
                                if (withContext != coroutine_suspended) {
                                    return withContext;
                                }
                            } else {
                                connectionPoolImpl$useConnection$1.label = 2;
                                Object invoke = function2.invoke(pooledConnectionImpl2, connectionPoolImpl$useConnection$1);
                                if (invoke != coroutine_suspended) {
                                    return invoke;
                                }
                            }
                        } else {
                            if (z3) {
                                pool = this.readers;
                            } else {
                                pool = this.writers;
                            }
                            objectRef = new Ref.ObjectRef();
                            try {
                                context = connectionPoolImpl$useConnection$1.getContext();
                                ConnectionElementKey connectionElementKey2 = this.connectionElementKey;
                                long j = this.timeout;
                                Function0<Unit> function0 = new Function0() { // from class: androidx.room.coroutines.ConnectionPoolImpl$$ExternalSyntheticLambda2
                                    @Override // kotlin.jvm.functions.Function0
                                    public final Object invoke() {
                                        Unit useConnection$lambda$6;
                                        useConnection$lambda$6 = ConnectionPoolImpl.useConnection$lambda$6(ConnectionPoolImpl.this, z3);
                                        return useConnection$lambda$6;
                                    }
                                };
                                connectionPoolImpl$useConnection$1.L$0 = function2;
                                connectionPoolImpl$useConnection$1.L$1 = pool;
                                connectionPoolImpl$useConnection$1.L$2 = objectRef;
                                connectionPoolImpl$useConnection$1.L$3 = context;
                                connectionPoolImpl$useConnection$1.L$4 = objectRef;
                                connectionPoolImpl$useConnection$1.L$5 = connectionElementKey2;
                                connectionPoolImpl$useConnection$1.Z$0 = z3;
                                connectionPoolImpl$useConnection$1.label = 3;
                                Object m8899acquireWithTimeoutKLykuaI = pool.m8899acquireWithTimeoutKLykuaI(j, function0, connectionPoolImpl$useConnection$1);
                                if (m8899acquireWithTimeoutKLykuaI != coroutine_suspended) {
                                    function22 = function2;
                                    connectionElementKey = connectionElementKey2;
                                    pool3 = pool;
                                    obj = m8899acquireWithTimeoutKLykuaI;
                                    objectRef2 = objectRef;
                                }
                            } catch (Throwable th2) {
                                th = th2;
                                pool2 = pool;
                                throw th;
                            }
                        }
                        return coroutine_suspended;
                    } else if (i == 1) {
                        ResultKt.throwOnFailure(obj);
                        return obj;
                    } else if (i == 2) {
                        ResultKt.throwOnFailure(obj);
                        return obj;
                    } else if (i != 3) {
                        if (i == 4) {
                            objectRef3 = (Ref.ObjectRef) connectionPoolImpl$useConnection$1.L$1;
                            pool2 = (Pool) connectionPoolImpl$useConnection$1.L$0;
                            try {
                                ResultKt.throwOnFailure(obj);
                                pooledConnectionImpl = (PooledConnectionImpl) objectRef3.element;
                                if (pooledConnectionImpl != null) {
                                    pooledConnectionImpl.markRecycled();
                                    pooledConnectionImpl.getDelegate().markReleased();
                                    pool2.recycle(pooledConnectionImpl.getDelegate());
                                }
                                return obj;
                            } catch (Throwable th3) {
                                objectRef = objectRef3;
                                th = th3;
                                try {
                                    throw th;
                                } catch (Throwable th4) {
                                    try {
                                        PooledConnectionImpl pooledConnectionImpl3 = (PooledConnectionImpl) objectRef.element;
                                        if (pooledConnectionImpl3 != null) {
                                            pooledConnectionImpl3.markRecycled();
                                            pooledConnectionImpl3.getDelegate().markReleased();
                                            pool2.recycle(pooledConnectionImpl3.getDelegate());
                                        }
                                    } catch (Throwable th5) {
                                        ExceptionsKt.addSuppressed(th, th5);
                                    }
                                    throw th4;
                                }
                            }
                        }
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    } else {
                        z3 = connectionPoolImpl$useConnection$1.Z$0;
                        connectionElementKey = (ConnectionElementKey) connectionPoolImpl$useConnection$1.L$5;
                        Ref.ObjectRef objectRef4 = (Ref.ObjectRef) connectionPoolImpl$useConnection$1.L$4;
                        CoroutineContext coroutineContext = (CoroutineContext) connectionPoolImpl$useConnection$1.L$3;
                        Ref.ObjectRef objectRef5 = (Ref.ObjectRef) connectionPoolImpl$useConnection$1.L$2;
                        pool3 = (Pool) connectionPoolImpl$useConnection$1.L$1;
                        function22 = (Function2) connectionPoolImpl$useConnection$1.L$0;
                        try {
                            ResultKt.throwOnFailure(obj);
                            objectRef2 = objectRef4;
                            objectRef = objectRef5;
                            context = coroutineContext;
                        } catch (Throwable th6) {
                            th = th6;
                            objectRef = objectRef5;
                            pool2 = pool3;
                            throw th;
                        }
                    }
                    ConnectionWithLock markAcquired = ((ConnectionWithLock) obj).markAcquired(context);
                    if (this.readers != this.writers || !z3) {
                        z2 = false;
                    }
                    objectRef2.element = new PooledConnectionImpl(connectionElementKey, markAcquired, z2);
                    if (objectRef.element != 0) {
                        throw new IllegalArgumentException("Required value was null.".toString());
                    }
                    connectionPoolImpl$useConnection$1.L$0 = pool3;
                    connectionPoolImpl$useConnection$1.L$1 = objectRef;
                    connectionPoolImpl$useConnection$1.L$2 = null;
                    connectionPoolImpl$useConnection$1.L$3 = null;
                    connectionPoolImpl$useConnection$1.L$4 = null;
                    connectionPoolImpl$useConnection$1.L$5 = null;
                    connectionPoolImpl$useConnection$1.label = 4;
                    obj = BuildersKt.withContext(createConnectionContext((PooledConnectionImpl) objectRef.element), new ConnectionPoolImpl$useConnection$4(function22, objectRef, null), connectionPoolImpl$useConnection$1);
                    if (obj != coroutine_suspended) {
                        objectRef3 = objectRef;
                        pool2 = pool3;
                        pooledConnectionImpl = (PooledConnectionImpl) objectRef3.element;
                        if (pooledConnectionImpl != null) {
                        }
                        return obj;
                    }
                    return coroutine_suspended;
                }
            }
            ConnectionWithLock markAcquired2 = ((ConnectionWithLock) obj).markAcquired(context);
            if (this.readers != this.writers) {
            }
            z2 = false;
            objectRef2.element = new PooledConnectionImpl(connectionElementKey, markAcquired2, z2);
            if (objectRef.element != 0) {
            }
        } catch (Throwable th7) {
            th = th7;
            pool2 = pool3;
            throw th;
        }
        connectionPoolImpl$useConnection$1 = new ConnectionPoolImpl$useConnection$1(this, continuation);
        Object obj2 = connectionPoolImpl$useConnection$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = connectionPoolImpl$useConnection$1.label;
        z2 = true;
        if (i != 0) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit useConnection$lambda$6(ConnectionPoolImpl connectionPoolImpl, boolean z) {
        connectionPoolImpl.onTimeout(z);
        return Unit.INSTANCE;
    }

    private final CoroutineContext createConnectionContext(PooledConnectionImpl pooledConnectionImpl) {
        return new ConnectionElement(this.connectionElementKey, pooledConnectionImpl).plus(ThreadLocal_jvmAndroidKt.asContextElement(this.connectionThreadLocal, pooledConnectionImpl));
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
            int i = this.onTimeout;
            if (i == 1) {
                throw e;
            }
            if (i != 2) {
                return;
            }
            e.printStackTrace();
        }
    }

    @Override // androidx.room.coroutines.ConnectionPool, java.lang.AutoCloseable
    public void close() {
        if (this.isClosed) {
            return;
        }
        this.isClosed = true;
        this.readers.close();
        this.writers.close();
    }
}
