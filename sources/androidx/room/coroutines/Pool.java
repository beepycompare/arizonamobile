package androidx.room.coroutines;

import androidx.sqlite.SQLite;
import androidx.sqlite.SQLiteConnection;
import java.util.List;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.ArrayDeque;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.TimeoutCancellationException;
import kotlinx.coroutines.TimeoutKt;
import kotlinx.coroutines.sync.Semaphore;
import kotlinx.coroutines.sync.SemaphoreKt;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ConnectionPoolImpl.kt */
@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0003¢\u0006\u0004\b\b\u0010\tJ&\u0010\u001e\u001a\u00020\u00182\u0006\u0010\u001f\u001a\u00020 2\f\u0010!\u001a\b\u0012\u0004\u0012\u00020\"0\u0005H\u0086@¢\u0006\u0004\b#\u0010$J\u000e\u0010%\u001a\u00020\u0018H\u0086@¢\u0006\u0002\u0010&J\b\u0010'\u001a\u00020\"H\u0002J\u000e\u0010(\u001a\u00020\"2\u0006\u0010)\u001a\u00020\u0018J\u0006\u0010*\u001a\u00020\"J\u0012\u0010+\u001a\u00020\"2\n\u0010,\u001a\u00060-j\u0002`.R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000bR\u0014\u0010\u000f\u001a\u00060\u0010j\u0002`\u0011X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0012R\u000e\u0010\u0013\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u0018\u0010\u0016\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00180\u0017X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0019R\u000e\u0010\u001a\u001a\u00020\u001bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00180\u001dX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006/"}, d2 = {"Landroidx/room/coroutines/Pool;", "", "capacity", "", "connectionFactory", "Lkotlin/Function0;", "Landroidx/sqlite/SQLiteConnection;", "preparedStatementCacheSize", "<init>", "(ILkotlin/jvm/functions/Function0;I)V", "getCapacity", "()I", "getConnectionFactory", "()Lkotlin/jvm/functions/Function0;", "getPreparedStatementCacheSize", "lock", "Ljava/util/concurrent/locks/ReentrantLock;", "Landroidx/room/concurrent/ReentrantLock;", "Ljava/util/concurrent/locks/ReentrantLock;", "size", "isClosed", "", "connections", "", "Landroidx/room/coroutines/ConnectionWithLock;", "[Landroidx/room/coroutines/ConnectionWithLock;", "connectionPermits", "Lkotlinx/coroutines/sync/Semaphore;", "availableConnections", "Lkotlin/collections/ArrayDeque;", "acquireWithTimeout", "timeout", "Lkotlin/time/Duration;", "onTimeout", "", "acquireWithTimeout-KLykuaI", "(JLkotlin/jvm/functions/Function0;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "acquire", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "tryOpenNewConnectionLocked", "recycle", "connection", "close", "dump", "builder", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "room-runtime"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class Pool {
    private final ArrayDeque<ConnectionWithLock> availableConnections;
    private final int capacity;
    private final Function0<SQLiteConnection> connectionFactory;
    private final Semaphore connectionPermits;
    private final ConnectionWithLock[] connections;
    private boolean isClosed;
    private final ReentrantLock lock;
    private final int preparedStatementCacheSize;
    private int size;

    /* JADX WARN: Multi-variable type inference failed */
    public Pool(int i, Function0<? extends SQLiteConnection> connectionFactory, int i2) {
        Intrinsics.checkNotNullParameter(connectionFactory, "connectionFactory");
        this.capacity = i;
        this.connectionFactory = connectionFactory;
        this.preparedStatementCacheSize = i2;
        this.lock = new ReentrantLock();
        this.connections = new ConnectionWithLock[i];
        this.connectionPermits = SemaphoreKt.Semaphore$default(i, 0, 2, null);
        this.availableConnections = new ArrayDeque<>(i);
    }

    public final int getCapacity() {
        return this.capacity;
    }

    public final Function0<SQLiteConnection> getConnectionFactory() {
        return this.connectionFactory;
    }

    public final int getPreparedStatementCacheSize() {
        return this.preparedStatementCacheSize;
    }

    /* JADX WARN: Can't wrap try/catch for region: R(11:9|(2:10|11)|12|13|14|(1:(1:34)(2:30|(2:32|33)))(1:16)|17|18|19|20|(1:22)(10:24|12|13|14|(0)(0)|17|18|19|20|(0)(0))) */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0064, code lost:
        r2 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0065, code lost:
        r2 = r10;
        r10 = r11;
        r11 = r2;
     */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0025  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x003f  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x005c A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:23:0x005d  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0072 A[Catch: all -> 0x0082, TryCatch #0 {all -> 0x0082, blocks: (B:28:0x006e, B:30:0x0072, B:32:0x0078, B:34:0x007c, B:37:0x0081), top: B:43:0x006e }] */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0076  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:23:0x005d -> B:24:0x005f). Please submit an issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:27:0x0069 -> B:43:0x006e). Please submit an issue!!! */
    /* renamed from: acquireWithTimeout-KLykuaI  reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object m9179acquireWithTimeoutKLykuaI(long j, Function0<Unit> function0, Continuation<? super ConnectionWithLock> continuation) {
        Pool$acquireWithTimeout$1 pool$acquireWithTimeout$1;
        int i;
        Ref.ObjectRef objectRef;
        Pool$acquireWithTimeout$1 pool$acquireWithTimeout$12;
        Throwable th;
        Ref.ObjectRef objectRef2;
        if (continuation instanceof Pool$acquireWithTimeout$1) {
            pool$acquireWithTimeout$1 = (Pool$acquireWithTimeout$1) continuation;
            if ((pool$acquireWithTimeout$1.label & Integer.MIN_VALUE) != 0) {
                pool$acquireWithTimeout$1.label -= Integer.MIN_VALUE;
                Object obj = pool$acquireWithTimeout$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = pool$acquireWithTimeout$1.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    objectRef2 = new Ref.ObjectRef();
                    pool$acquireWithTimeout$1.L$0 = function0;
                    pool$acquireWithTimeout$1.L$1 = objectRef2;
                    pool$acquireWithTimeout$1.J$0 = j;
                    pool$acquireWithTimeout$1.label = 1;
                    if (TimeoutKt.m11729withTimeoutKLykuaI(j, new Pool$acquireWithTimeout$2(objectRef2, this, null), pool$acquireWithTimeout$1) == coroutine_suspended) {
                    }
                } else if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                } else {
                    j = pool$acquireWithTimeout$1.J$0;
                    Ref.ObjectRef objectRef3 = (Ref.ObjectRef) pool$acquireWithTimeout$1.L$1;
                    Function0<Unit> function02 = (Function0) pool$acquireWithTimeout$1.L$0;
                    try {
                        try {
                            ResultKt.throwOnFailure(obj);
                        } catch (Throwable th2) {
                            Throwable th3 = th2;
                            Throwable th4 = th3;
                            objectRef = objectRef3;
                            function0 = function02;
                            pool$acquireWithTimeout$12 = pool$acquireWithTimeout$1;
                            th = th4;
                            if (th instanceof TimeoutCancellationException) {
                            }
                            pool$acquireWithTimeout$1 = pool$acquireWithTimeout$12;
                            objectRef2 = new Ref.ObjectRef();
                            pool$acquireWithTimeout$1.L$0 = function0;
                            pool$acquireWithTimeout$1.L$1 = objectRef2;
                            pool$acquireWithTimeout$1.J$0 = j;
                            pool$acquireWithTimeout$1.label = 1;
                            if (TimeoutKt.m11729withTimeoutKLykuaI(j, new Pool$acquireWithTimeout$2(objectRef2, this, null), pool$acquireWithTimeout$1) == coroutine_suspended) {
                            }
                        }
                        if (th instanceof TimeoutCancellationException) {
                            function0.invoke();
                        } else if (th != null) {
                            throw th;
                        } else {
                            if (objectRef.element != 0) {
                                return objectRef.element;
                            }
                        }
                        pool$acquireWithTimeout$1 = pool$acquireWithTimeout$12;
                        objectRef2 = new Ref.ObjectRef();
                        pool$acquireWithTimeout$1.L$0 = function0;
                        pool$acquireWithTimeout$1.L$1 = objectRef2;
                        pool$acquireWithTimeout$1.J$0 = j;
                        pool$acquireWithTimeout$1.label = 1;
                        if (TimeoutKt.m11729withTimeoutKLykuaI(j, new Pool$acquireWithTimeout$2(objectRef2, this, null), pool$acquireWithTimeout$1) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        function02 = function0;
                        objectRef3 = objectRef2;
                        objectRef = objectRef3;
                        function0 = function02;
                        pool$acquireWithTimeout$12 = pool$acquireWithTimeout$1;
                        th = null;
                        if (th instanceof TimeoutCancellationException) {
                        }
                        pool$acquireWithTimeout$1 = pool$acquireWithTimeout$12;
                        objectRef2 = new Ref.ObjectRef();
                        pool$acquireWithTimeout$1.L$0 = function0;
                        pool$acquireWithTimeout$1.L$1 = objectRef2;
                        pool$acquireWithTimeout$1.J$0 = j;
                        pool$acquireWithTimeout$1.label = 1;
                        if (TimeoutKt.m11729withTimeoutKLykuaI(j, new Pool$acquireWithTimeout$2(objectRef2, this, null), pool$acquireWithTimeout$1) == coroutine_suspended) {
                        }
                    } catch (Throwable th5) {
                        ConnectionWithLock connectionWithLock = (ConnectionWithLock) objectRef.element;
                        if (connectionWithLock != null) {
                            recycle(connectionWithLock);
                        }
                        throw th5;
                    }
                    objectRef = objectRef3;
                    function0 = function02;
                    pool$acquireWithTimeout$12 = pool$acquireWithTimeout$1;
                    th = null;
                }
            }
        }
        pool$acquireWithTimeout$1 = new Pool$acquireWithTimeout$1(this, continuation);
        Object obj2 = pool$acquireWithTimeout$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = pool$acquireWithTimeout$1.label;
        if (i != 0) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0032  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0049 A[Catch: all -> 0x006d, TryCatch #2 {all -> 0x0072, blocks: (B:17:0x0040, B:24:0x005c, B:18:0x0045, B:20:0x0049, B:22:0x0051, B:23:0x0054, B:26:0x0060, B:27:0x006c), top: B:34:0x0040 }] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0060 A[Catch: all -> 0x006d, TRY_ENTER, TryCatch #2 {all -> 0x0072, blocks: (B:17:0x0040, B:24:0x005c, B:18:0x0045, B:20:0x0049, B:22:0x0051, B:23:0x0054, B:26:0x0060, B:27:0x006c), top: B:34:0x0040 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object acquire(Continuation<? super ConnectionWithLock> continuation) {
        Pool$acquire$1 pool$acquire$1;
        int i;
        try {
            if (continuation instanceof Pool$acquire$1) {
                pool$acquire$1 = (Pool$acquire$1) continuation;
                if ((pool$acquire$1.label & Integer.MIN_VALUE) != 0) {
                    pool$acquire$1.label -= Integer.MIN_VALUE;
                    Object obj = pool$acquire$1.result;
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    i = pool$acquire$1.label;
                    if (i != 0) {
                        ResultKt.throwOnFailure(obj);
                        Semaphore semaphore = this.connectionPermits;
                        pool$acquire$1.label = 1;
                        if (semaphore.acquire(pool$acquire$1) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    } else if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    } else {
                        ResultKt.throwOnFailure(obj);
                    }
                    ReentrantLock reentrantLock = this.lock;
                    reentrantLock.lock();
                    if (!this.isClosed) {
                        SQLite.throwSQLiteException(21, "Connection pool is closed");
                        throw new KotlinNothingValueException();
                    }
                    if (this.availableConnections.isEmpty()) {
                        tryOpenNewConnectionLocked();
                    }
                    ConnectionWithLock removeLast = this.availableConnections.removeLast();
                    reentrantLock.unlock();
                    return removeLast;
                }
            }
            ReentrantLock reentrantLock2 = this.lock;
            reentrantLock2.lock();
            if (!this.isClosed) {
            }
        } catch (Throwable th) {
            this.connectionPermits.release();
            throw th;
        }
        pool$acquire$1 = new Pool$acquire$1(this, continuation);
        Object obj2 = pool$acquire$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = pool$acquire$1.label;
        if (i != 0) {
        }
    }

    private final void tryOpenNewConnectionLocked() {
        if (this.size >= this.capacity) {
            return;
        }
        ConnectionWithLock connectionWithLock = new ConnectionWithLock(this.connectionFactory.invoke(), null, this.preparedStatementCacheSize, 2, null);
        ConnectionWithLock[] connectionWithLockArr = this.connections;
        int i = this.size;
        this.size = i + 1;
        connectionWithLockArr[i] = connectionWithLock;
        this.availableConnections.addLast(connectionWithLock);
    }

    public final void recycle(ConnectionWithLock connection) {
        Intrinsics.checkNotNullParameter(connection, "connection");
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            this.availableConnections.addLast(connection);
            Unit unit = Unit.INSTANCE;
            reentrantLock.unlock();
            this.connectionPermits.release();
        } catch (Throwable th) {
            reentrantLock.unlock();
            throw th;
        }
    }

    public final void close() {
        ConnectionWithLock[] connectionWithLockArr;
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            this.isClosed = true;
            for (ConnectionWithLock connectionWithLock : this.connections) {
                if (connectionWithLock != null) {
                    connectionWithLock.close();
                }
            }
            Unit unit = Unit.INSTANCE;
        } finally {
            reentrantLock.unlock();
        }
    }

    public final void dump(StringBuilder builder) {
        Intrinsics.checkNotNullParameter(builder, "builder");
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            List createListBuilder = CollectionsKt.createListBuilder();
            int size = this.availableConnections.size();
            for (int i = 0; i < size; i++) {
                createListBuilder.add(this.availableConnections.get(i));
            }
            List build = CollectionsKt.build(createListBuilder);
            builder.append('\t' + super.toString() + " (");
            builder.append("capacity=" + this.capacity + ", ");
            builder.append("permits=" + this.connectionPermits.getAvailablePermits() + ", ");
            builder.append("queue=(size=" + build.size() + ")[" + CollectionsKt.joinToString$default(build, null, null, null, 0, null, null, 63, null) + AbstractJsonLexerKt.END_LIST);
            builder.append(")").append('\n');
            ConnectionWithLock[] connectionWithLockArr = this.connections;
            int length = connectionWithLockArr.length;
            int i2 = 0;
            for (int i3 = 0; i3 < length; i3++) {
                ConnectionWithLock connectionWithLock = connectionWithLockArr[i3];
                i2++;
                builder.append("\t\t[" + i2 + "] - " + (connectionWithLock != null ? connectionWithLock.toString() : null)).append('\n');
                if (connectionWithLock != null) {
                    connectionWithLock.dump(builder);
                }
            }
            Unit unit = Unit.INSTANCE;
        } finally {
            reentrantLock.unlock();
        }
    }
}
