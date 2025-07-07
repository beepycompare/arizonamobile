package androidx.room.coroutines;

import androidx.room.Transactor;
import androidx.room.concurrent.ThreadLocal_jvmAndroidKt;
import androidx.sqlite.SQLite;
import androidx.sqlite.SQLiteConnection;
import androidx.sqlite.SQLiteDriver;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.ExceptionsKt;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
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
import kotlinx.coroutines.TimeoutCancellationException;
import kotlinx.coroutines.TimeoutKt;
/* compiled from: ConnectionPoolImpl.kt */
@Metadata(d1 = {"\u0000\u008c\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0001\n\u0000\n\u0002\u0010\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u0019\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007B)\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u0006\u0010\u000bJ@\u0010\"\u001a\u0002H#\"\u0004\b\u0000\u0010#2\u0006\u0010$\u001a\u00020\u00192\"\u0010%\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020'\u0012\n\u0012\b\u0012\u0004\u0012\u0002H#0(\u0012\u0006\u0012\u0004\u0018\u00010)0&H\u0096@¢\u0006\u0002\u0010*J\"\u0010+\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00010-\u0012\u0006\u0012\u0004\u0018\u00010.0,*\u00020\rH\u0082H¢\u0006\u0002\u0010/J\u0010\u00100\u001a\u0002012\u0006\u00102\u001a\u00020\u0011H\u0002J\u0010\u00103\u001a\u0002042\u0006\u0010$\u001a\u00020\u0019H\u0002J\b\u00105\u001a\u000206H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R \u0010\u000f\u001a\u0012\u0012\u0004\u0012\u00020\u00110\u0010j\b\u0012\u0004\u0012\u00020\u0011`\u0012X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0013R\u0014\u0010\u0014\u001a\u00060\u0015j\u0002`\u0016X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0017R\u0014\u0010\u0018\u001a\u00020\u00198BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u001aR\u001c\u0010\u001b\u001a\u00020\u001cX\u0080\u000e¢\u0006\u0010\n\u0002\u0010!\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 ¨\u00067"}, d2 = {"Landroidx/room/coroutines/ConnectionPoolImpl;", "Landroidx/room/coroutines/ConnectionPool;", "driver", "Landroidx/sqlite/SQLiteDriver;", "fileName", "", "<init>", "(Landroidx/sqlite/SQLiteDriver;Ljava/lang/String;)V", "maxNumOfReaders", "", "maxNumOfWriters", "(Landroidx/sqlite/SQLiteDriver;Ljava/lang/String;II)V", "readers", "Landroidx/room/coroutines/Pool;", "writers", "threadLocal", "Ljava/lang/ThreadLocal;", "Landroidx/room/coroutines/PooledConnectionImpl;", "Landroidx/room/concurrent/ThreadLocal;", "Ljava/lang/ThreadLocal;", "_isClosed", "Ljava/util/concurrent/atomic/AtomicBoolean;", "Landroidx/room/concurrent/AtomicBoolean;", "Ljava/util/concurrent/atomic/AtomicBoolean;", "isClosed", "", "()Z", "timeout", "Lkotlin/time/Duration;", "getTimeout-UwyO8pc$room_runtime_release", "()J", "setTimeout-LRDsOJo$room_runtime_release", "(J)V", "J", "useConnection", "R", "isReadOnly", "block", "Lkotlin/Function2;", "Landroidx/room/Transactor;", "Lkotlin/coroutines/Continuation;", "", "(ZLkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "acquireWithTimeout", "Lkotlin/Pair;", "Landroidx/room/coroutines/ConnectionWithLock;", "", "(Landroidx/room/coroutines/Pool;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "createConnectionContext", "Lkotlin/coroutines/CoroutineContext;", "connection", "throwTimeoutException", "", "close", "", "room-runtime_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class ConnectionPoolImpl implements ConnectionPool {
    private final AtomicBoolean _isClosed;
    private final SQLiteDriver driver;
    private final Pool readers;
    private final ThreadLocal<PooledConnectionImpl> threadLocal;
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

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0030  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0082  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x0155 A[Catch: all -> 0x01ca, TryCatch #5 {all -> 0x01ca, blocks: (B:68:0x0140, B:70:0x0155, B:75:0x0166, B:77:0x016b, B:80:0x0173, B:82:0x0177, B:90:0x01b4, B:91:0x01bf, B:92:0x01c0, B:93:0x01c1, B:94:0x01c9), top: B:122:0x0140 }] */
    /* JADX WARN: Removed duplicated region for block: B:76:0x016a  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x0171  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x01a2 A[Catch: all -> 0x01b3, TRY_LEAVE, TryCatch #2 {all -> 0x01b3, blocks: (B:86:0x019c, B:88:0x01a2), top: B:116:0x019c }] */
    /* JADX WARN: Removed duplicated region for block: B:93:0x01c1 A[Catch: all -> 0x01ca, TryCatch #5 {all -> 0x01ca, blocks: (B:68:0x0140, B:70:0x0155, B:75:0x0166, B:77:0x016b, B:80:0x0173, B:82:0x0177, B:90:0x01b4, B:91:0x01bf, B:92:0x01c0, B:93:0x01c1, B:94:0x01c9), top: B:122:0x0140 }] */
    @Override // androidx.room.coroutines.ConnectionPool
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public <R> Object useConnection(boolean z, Function2<? super Transactor, ? super Continuation<? super R>, ? extends Object> function2, Continuation<? super R> continuation) {
        ConnectionPoolImpl$useConnection$1 connectionPoolImpl$useConnection$1;
        int i;
        Pool pool;
        Ref.ObjectRef objectRef;
        Throwable th;
        Pool pool2;
        Ref.ObjectRef objectRef2;
        Ref.ObjectRef objectRef3;
        Pool pool3;
        CoroutineContext coroutineContext;
        ConnectionPoolImpl connectionPoolImpl;
        Function2<? super Transactor, ? super Continuation<? super R>, ? extends Object> function22;
        Ref.ObjectRef objectRef4;
        ConnectionPoolImpl connectionPoolImpl2;
        boolean z2;
        Ref.ObjectRef objectRef5;
        ConnectionPoolImpl connectionPoolImpl3;
        ConnectionWithLock connectionWithLock;
        Throwable th2;
        T t;
        PooledConnectionImpl pooledConnectionImpl;
        boolean z3 = z;
        Function2<? super Transactor, ? super Continuation<? super R>, ? extends Object> function23 = function2;
        try {
            if (continuation instanceof ConnectionPoolImpl$useConnection$1) {
                connectionPoolImpl$useConnection$1 = (ConnectionPoolImpl$useConnection$1) continuation;
                if ((connectionPoolImpl$useConnection$1.label & Integer.MIN_VALUE) != 0) {
                    connectionPoolImpl$useConnection$1.label -= Integer.MIN_VALUE;
                    Object obj = connectionPoolImpl$useConnection$1.result;
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    i = connectionPoolImpl$useConnection$1.label;
                    if (i != 0) {
                        ResultKt.throwOnFailure(obj);
                        if (isClosed()) {
                            SQLite.throwSQLiteException(21, "Connection pool is closed");
                            throw new KotlinNothingValueException();
                        }
                        PooledConnectionImpl pooledConnectionImpl2 = this.threadLocal.get();
                        if (pooledConnectionImpl2 == null) {
                            ConnectionElement connectionElement = (ConnectionElement) connectionPoolImpl$useConnection$1.getContext().get(ConnectionElement.Key);
                            pooledConnectionImpl2 = connectionElement != null ? connectionElement.getConnectionWrapper() : null;
                        }
                        if (pooledConnectionImpl2 != null) {
                            if (!z3 && pooledConnectionImpl2.isReadOnly()) {
                                SQLite.throwSQLiteException(1, "Cannot upgrade connection from reader to writer");
                                throw new KotlinNothingValueException();
                            } else if (connectionPoolImpl$useConnection$1.getContext().get(ConnectionElement.Key) == null) {
                                connectionPoolImpl$useConnection$1.label = 1;
                                Object withContext = BuildersKt.withContext(createConnectionContext(pooledConnectionImpl2), new ConnectionPoolImpl$useConnection$2(function23, pooledConnectionImpl2, null), connectionPoolImpl$useConnection$1);
                                if (withContext != coroutine_suspended) {
                                    return withContext;
                                }
                            } else {
                                connectionPoolImpl$useConnection$1.label = 2;
                                Object invoke = function23.invoke(pooledConnectionImpl2, connectionPoolImpl$useConnection$1);
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
                            Pool pool4 = pool;
                            objectRef = new Ref.ObjectRef();
                            try {
                                CoroutineContext context = connectionPoolImpl$useConnection$1.getContext();
                                objectRef2 = new Ref.ObjectRef();
                                try {
                                    connectionPoolImpl$useConnection$1.L$0 = this;
                                    connectionPoolImpl$useConnection$1.L$1 = function23;
                                    connectionPoolImpl$useConnection$1.L$2 = pool4;
                                    connectionPoolImpl$useConnection$1.L$3 = objectRef;
                                    connectionPoolImpl$useConnection$1.L$4 = context;
                                    connectionPoolImpl$useConnection$1.L$5 = objectRef2;
                                    connectionPoolImpl$useConnection$1.Z$0 = z3;
                                    connectionPoolImpl$useConnection$1.label = 3;
                                    if (TimeoutKt.m9949withTimeoutKLykuaI(this.timeout, new ConnectionPoolImpl$acquireWithTimeout$2(objectRef2, pool4, null), connectionPoolImpl$useConnection$1) != coroutine_suspended) {
                                        objectRef3 = objectRef;
                                        pool3 = pool4;
                                        coroutineContext = context;
                                        function22 = function23;
                                        objectRef4 = objectRef2;
                                        connectionPoolImpl2 = this;
                                    }
                                } catch (Throwable th3) {
                                    th = th3;
                                    objectRef3 = objectRef;
                                    pool3 = pool4;
                                    coroutineContext = context;
                                    connectionPoolImpl = this;
                                    Function2<? super Transactor, ? super Continuation<? super R>, ? extends Object> function24 = function23;
                                    z2 = z3;
                                    objectRef5 = objectRef3;
                                    connectionPoolImpl3 = connectionPoolImpl;
                                    function22 = function24;
                                    Pair pair = TuplesKt.to(objectRef2.element, th);
                                    connectionWithLock = (ConnectionWithLock) pair.component1();
                                    th2 = (Throwable) pair.component2();
                                    if (connectionWithLock == null) {
                                    }
                                    objectRef5.element = t;
                                    if (!(th2 instanceof TimeoutCancellationException)) {
                                    }
                                }
                            } catch (Throwable th4) {
                                th = th4;
                                pool2 = pool4;
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
                            objectRef5 = (Ref.ObjectRef) connectionPoolImpl$useConnection$1.L$1;
                            pool2 = (Pool) connectionPoolImpl$useConnection$1.L$0;
                            try {
                                ResultKt.throwOnFailure(obj);
                                try {
                                    pooledConnectionImpl = (PooledConnectionImpl) objectRef5.element;
                                    if (pooledConnectionImpl != null) {
                                        pooledConnectionImpl.markRecycled();
                                        pooledConnectionImpl.getDelegate().markReleased();
                                        pool2.recycle(pooledConnectionImpl.getDelegate());
                                    }
                                } catch (Throwable unused) {
                                }
                                return obj;
                            } catch (Throwable th5) {
                                th = th5;
                                objectRef = objectRef5;
                                th = th;
                                try {
                                    throw th;
                                } catch (Throwable th6) {
                                    try {
                                        PooledConnectionImpl pooledConnectionImpl3 = (PooledConnectionImpl) objectRef.element;
                                        if (pooledConnectionImpl3 != null) {
                                            pooledConnectionImpl3.markRecycled();
                                            pooledConnectionImpl3.getDelegate().markReleased();
                                            pool2.recycle(pooledConnectionImpl3.getDelegate());
                                        }
                                    } catch (Throwable th7) {
                                        ExceptionsKt.addSuppressed(th, th7);
                                    }
                                    throw th6;
                                }
                            }
                        }
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    } else {
                        z3 = connectionPoolImpl$useConnection$1.Z$0;
                        objectRef4 = (Ref.ObjectRef) connectionPoolImpl$useConnection$1.L$5;
                        coroutineContext = (CoroutineContext) connectionPoolImpl$useConnection$1.L$4;
                        objectRef3 = (Ref.ObjectRef) connectionPoolImpl$useConnection$1.L$3;
                        pool3 = (Pool) connectionPoolImpl$useConnection$1.L$2;
                        function22 = (Function2) connectionPoolImpl$useConnection$1.L$1;
                        connectionPoolImpl2 = (ConnectionPoolImpl) connectionPoolImpl$useConnection$1.L$0;
                        try {
                            ResultKt.throwOnFailure(obj);
                        } catch (Throwable th8) {
                            th = th8;
                            objectRef2 = objectRef4;
                            function23 = function22;
                            connectionPoolImpl = connectionPoolImpl2;
                            Function2<? super Transactor, ? super Continuation<? super R>, ? extends Object> function242 = function23;
                            z2 = z3;
                            objectRef5 = objectRef3;
                            connectionPoolImpl3 = connectionPoolImpl;
                            function22 = function242;
                            Pair pair2 = TuplesKt.to(objectRef2.element, th);
                            connectionWithLock = (ConnectionWithLock) pair2.component1();
                            th2 = (Throwable) pair2.component2();
                            if (connectionWithLock == null) {
                            }
                            objectRef5.element = t;
                            if (!(th2 instanceof TimeoutCancellationException)) {
                            }
                        }
                    }
                    Ref.ObjectRef objectRef6 = objectRef4;
                    z2 = z3;
                    objectRef5 = objectRef3;
                    connectionPoolImpl3 = connectionPoolImpl2;
                    objectRef2 = objectRef6;
                    th = null;
                    Pair pair22 = TuplesKt.to(objectRef2.element, th);
                    connectionWithLock = (ConnectionWithLock) pair22.component1();
                    th2 = (Throwable) pair22.component2();
                    if (connectionWithLock == null) {
                        t = new PooledConnectionImpl(connectionWithLock.markAcquired(coroutineContext), connectionPoolImpl3.readers != connectionPoolImpl3.writers && z2);
                    } else {
                        t = 0;
                    }
                    objectRef5.element = t;
                    if (!(th2 instanceof TimeoutCancellationException)) {
                        connectionPoolImpl3.throwTimeoutException(z2);
                        throw new KotlinNothingValueException();
                    } else if (th2 != null) {
                        throw th2;
                    } else {
                        if (objectRef5.element == 0) {
                            throw new IllegalArgumentException("Required value was null.".toString());
                        }
                        connectionPoolImpl$useConnection$1.L$0 = pool3;
                        connectionPoolImpl$useConnection$1.L$1 = objectRef5;
                        connectionPoolImpl$useConnection$1.L$2 = null;
                        connectionPoolImpl$useConnection$1.L$3 = null;
                        connectionPoolImpl$useConnection$1.L$4 = null;
                        connectionPoolImpl$useConnection$1.L$5 = null;
                        connectionPoolImpl$useConnection$1.label = 4;
                        obj = BuildersKt.withContext(connectionPoolImpl3.createConnectionContext((PooledConnectionImpl) objectRef5.element), new ConnectionPoolImpl$useConnection$4(function22, objectRef5, null), connectionPoolImpl$useConnection$1);
                        if (obj != coroutine_suspended) {
                            pool2 = pool3;
                            pooledConnectionImpl = (PooledConnectionImpl) objectRef5.element;
                            if (pooledConnectionImpl != null) {
                            }
                            return obj;
                        }
                        return coroutine_suspended;
                    }
                }
            }
            Pair pair222 = TuplesKt.to(objectRef2.element, th);
            connectionWithLock = (ConnectionWithLock) pair222.component1();
            th2 = (Throwable) pair222.component2();
            if (connectionWithLock == null) {
            }
            objectRef5.element = t;
            if (!(th2 instanceof TimeoutCancellationException)) {
            }
        } catch (Throwable th9) {
            th = th9;
            pool2 = pool3;
            objectRef = objectRef5;
            th = th;
            throw th;
        }
        connectionPoolImpl$useConnection$1 = new ConnectionPoolImpl$useConnection$1(this, continuation);
        Object obj2 = connectionPoolImpl$useConnection$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = connectionPoolImpl$useConnection$1.label;
        if (i != 0) {
        }
        Ref.ObjectRef objectRef62 = objectRef4;
        z2 = z3;
        objectRef5 = objectRef3;
        connectionPoolImpl3 = connectionPoolImpl2;
        objectRef2 = objectRef62;
        th = null;
    }

    private final Object acquireWithTimeout(Pool pool, Continuation<? super Pair<ConnectionWithLock, ? extends Throwable>> continuation) {
        Object obj;
        Ref.ObjectRef objectRef = new Ref.ObjectRef();
        try {
            obj = null;
            TimeoutKt.m9949withTimeoutKLykuaI(this.timeout, new ConnectionPoolImpl$acquireWithTimeout$2(objectRef, pool, null), continuation);
        } catch (Throwable th) {
            obj = th;
        }
        return TuplesKt.to(objectRef.element, obj);
    }

    private final CoroutineContext createConnectionContext(PooledConnectionImpl pooledConnectionImpl) {
        return new ConnectionElement(pooledConnectionImpl).plus(ThreadLocal_jvmAndroidKt.asContextElement(this.threadLocal, pooledConnectionImpl));
    }

    private final Void throwTimeoutException(boolean z) {
        String str = z ? "reader" : "writer";
        StringBuilder sb = new StringBuilder();
        sb.append("Timed out attempting to acquire a " + str + " connection.").append("\n\nWriter pool:\n");
        this.writers.dump(sb);
        sb.append("Reader pool:").append('\n');
        this.readers.dump(sb);
        SQLite.throwSQLiteException(5, sb.toString());
        throw new KotlinNothingValueException();
    }

    @Override // androidx.room.coroutines.ConnectionPool, java.lang.AutoCloseable
    public void close() {
        if (this._isClosed.compareAndSet(false, true)) {
            this.readers.close();
            this.writers.close();
        }
    }
}
