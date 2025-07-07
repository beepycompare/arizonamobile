package androidx.datastore.core.okio;

import androidx.datastore.core.Closeable;
import androidx.datastore.core.InterProcessCoordinator;
import androidx.datastore.core.ReadScope;
import androidx.datastore.core.StorageConnection;
import androidx.datastore.core.WriteScope;
import androidx.exifinterface.media.ExifInterface;
import java.io.IOException;
import kotlin.ExceptionsKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.sync.Mutex;
import kotlinx.coroutines.sync.MutexKt;
import okio.FileSystem;
import okio.Path;
/* compiled from: OkioStorage.kt */
@Metadata(d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B9\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\f¢\u0006\u0002\u0010\u000eJ\b\u0010\u0015\u001a\u00020\rH\u0002J\b\u0010\u0016\u001a\u00020\rH\u0016JX\u0010\u0017\u001a\u0002H\u0018\"\u0004\b\u0001\u0010\u00182B\u0010\u0019\u001a>\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u001b\u0012\u0013\u0012\u00110\u001c¢\u0006\f\b\u001d\u0012\b\b\u001e\u0012\u0004\b\b(\u001f\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00180 \u0012\u0006\u0012\u0004\u0018\u00010!0\u001a¢\u0006\u0002\b\"H\u0096@¢\u0006\u0002\u0010#J=\u0010$\u001a\u00020\r2-\u0010\u0019\u001a)\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000&\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0 \u0012\u0006\u0012\u0004\u0018\u00010!0%¢\u0006\u0002\b\"H\u0096@¢\u0006\u0002\u0010'R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\u00020\nX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006("}, d2 = {"Landroidx/datastore/core/okio/OkioStorageConnection;", ExifInterface.GPS_DIRECTION_TRUE, "Landroidx/datastore/core/StorageConnection;", "fileSystem", "Lokio/FileSystem;", "path", "Lokio/Path;", "serializer", "Landroidx/datastore/core/okio/OkioSerializer;", "coordinator", "Landroidx/datastore/core/InterProcessCoordinator;", "onClose", "Lkotlin/Function0;", "", "(Lokio/FileSystem;Lokio/Path;Landroidx/datastore/core/okio/OkioSerializer;Landroidx/datastore/core/InterProcessCoordinator;Lkotlin/jvm/functions/Function0;)V", "closed", "Landroidx/datastore/core/okio/AtomicBoolean;", "getCoordinator", "()Landroidx/datastore/core/InterProcessCoordinator;", "transactionMutex", "Lkotlinx/coroutines/sync/Mutex;", "checkNotClosed", "close", "readScope", "R", "block", "Lkotlin/Function3;", "Landroidx/datastore/core/ReadScope;", "", "Lkotlin/ParameterName;", "name", "locked", "Lkotlin/coroutines/Continuation;", "", "Lkotlin/ExtensionFunctionType;", "(Lkotlin/jvm/functions/Function3;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "writeScope", "Lkotlin/Function2;", "Landroidx/datastore/core/WriteScope;", "(Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "datastore-core-okio"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class OkioStorageConnection<T> implements StorageConnection<T> {
    private final AtomicBoolean closed;
    private final InterProcessCoordinator coordinator;
    private final FileSystem fileSystem;
    private final Function0<Unit> onClose;
    private final Path path;
    private final OkioSerializer<T> serializer;
    private final Mutex transactionMutex;

    public OkioStorageConnection(FileSystem fileSystem, Path path, OkioSerializer<T> serializer, InterProcessCoordinator coordinator, Function0<Unit> onClose) {
        Intrinsics.checkNotNullParameter(fileSystem, "fileSystem");
        Intrinsics.checkNotNullParameter(path, "path");
        Intrinsics.checkNotNullParameter(serializer, "serializer");
        Intrinsics.checkNotNullParameter(coordinator, "coordinator");
        Intrinsics.checkNotNullParameter(onClose, "onClose");
        this.fileSystem = fileSystem;
        this.path = path;
        this.serializer = serializer;
        this.coordinator = coordinator;
        this.onClose = onClose;
        this.closed = new AtomicBoolean(false);
        this.transactionMutex = MutexKt.Mutex$default(false, 1, null);
    }

    @Override // androidx.datastore.core.StorageConnection
    public InterProcessCoordinator getCoordinator() {
        return this.coordinator;
    }

    /* JADX WARN: Can't wrap try/catch for region: R(7:(2:3|(8:5|6|7|(1:(3:10|11|12)(2:28|29))(6:30|31|32|33|34|(1:36)(1:37))|14|15|16|(2:(1:19)|20)(1:22)))|7|(0)(0)|14|15|16|(0)(0)) */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0078, code lost:
        r1 = th;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0025  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x003f  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x007b  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0083 A[Catch: all -> 0x0093, TRY_ENTER, TRY_LEAVE, TryCatch #6 {all -> 0x0093, blocks: (B:31:0x0083, B:38:0x0092, B:34:0x008a), top: B:54:0x0023 }] */
    /* JADX WARN: Type inference failed for: r0v1, types: [androidx.datastore.core.okio.OkioStorageConnection$readScope$1] */
    /* JADX WARN: Type inference failed for: r0v14, types: [androidx.datastore.core.okio.OkioStorageConnection$readScope$1] */
    @Override // androidx.datastore.core.StorageConnection
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public <R> Object readScope(Function3<? super ReadScope<T>, ? super Boolean, ? super Continuation<? super R>, ? extends Object> function3, Continuation<? super R> continuation) {
        OkioStorageConnection<T> okioStorageConnection;
        int i;
        Throwable th;
        Closeable closeable;
        boolean z;
        OkioStorageConnection<T> okioStorageConnection2;
        try {
            if (continuation instanceof OkioStorageConnection$readScope$1) {
                OkioStorageConnection$readScope$1 okioStorageConnection$readScope$1 = (OkioStorageConnection$readScope$1) continuation;
                if ((okioStorageConnection$readScope$1.label & Integer.MIN_VALUE) != 0) {
                    okioStorageConnection$readScope$1.label -= Integer.MIN_VALUE;
                    okioStorageConnection = okioStorageConnection$readScope$1;
                    Object obj = ((OkioStorageConnection$readScope$1) okioStorageConnection).result;
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    i = ((OkioStorageConnection$readScope$1) okioStorageConnection).label;
                    if (i != 0) {
                        ResultKt.throwOnFailure(obj);
                        checkNotClosed();
                        boolean tryLock$default = Mutex.DefaultImpls.tryLock$default(this.transactionMutex, null, 1, null);
                        try {
                            OkioReadScope okioReadScope = new OkioReadScope(this.fileSystem, this.path, this.serializer);
                            try {
                                Boolean boxBoolean = Boxing.boxBoolean(tryLock$default);
                                ((OkioStorageConnection$readScope$1) okioStorageConnection).L$0 = this;
                                ((OkioStorageConnection$readScope$1) okioStorageConnection).L$1 = okioReadScope;
                                ((OkioStorageConnection$readScope$1) okioStorageConnection).Z$0 = tryLock$default;
                                ((OkioStorageConnection$readScope$1) okioStorageConnection).label = 1;
                                Object invoke = function3.invoke(okioReadScope, boxBoolean, okioStorageConnection);
                                if (invoke == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                                obj = invoke;
                                z = tryLock$default;
                                okioStorageConnection2 = this;
                                closeable = okioReadScope;
                            } catch (Throwable th2) {
                                th = th2;
                                closeable = okioReadScope;
                                closeable.close();
                                throw th;
                            }
                        } catch (Throwable th3) {
                            th = th3;
                            function3 = tryLock$default;
                            okioStorageConnection = this;
                            if (function3 != null) {
                                Mutex.DefaultImpls.unlock$default(okioStorageConnection.transactionMutex, null, 1, null);
                            }
                            throw th;
                        }
                    } else if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    } else {
                        z = ((OkioStorageConnection$readScope$1) okioStorageConnection).Z$0;
                        closeable = (Closeable) ((OkioStorageConnection$readScope$1) okioStorageConnection).L$1;
                        okioStorageConnection2 = (OkioStorageConnection) ((OkioStorageConnection$readScope$1) okioStorageConnection).L$0;
                        try {
                            ResultKt.throwOnFailure(obj);
                        } catch (Throwable th4) {
                            th = th4;
                            closeable.close();
                            throw th;
                        }
                    }
                    closeable.close();
                    th = null;
                    if (th != null) {
                        if (z) {
                            Mutex.DefaultImpls.unlock$default(okioStorageConnection2.transactionMutex, null, 1, null);
                        }
                        return obj;
                    }
                    throw th;
                }
            }
            if (i != 0) {
            }
            closeable.close();
            th = null;
            if (th != null) {
            }
        } catch (Throwable th5) {
            th = th5;
        }
        okioStorageConnection = new OkioStorageConnection$readScope$1(this, continuation);
        Object obj2 = ((OkioStorageConnection$readScope$1) okioStorageConnection).result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = ((OkioStorageConnection$readScope$1) okioStorageConnection).label;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0027  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0061  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00c9  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00d7 A[Catch: all -> 0x00fe, IOException -> 0x0101, TRY_ENTER, TryCatch #5 {IOException -> 0x0101, blocks: (B:37:0x00d7, B:39:0x00df, B:43:0x00ee, B:49:0x00fa, B:50:0x00fd), top: B:76:0x0025 }] */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00ee A[Catch: all -> 0x00fe, IOException -> 0x0101, TRY_ENTER, TRY_LEAVE, TryCatch #5 {IOException -> 0x0101, blocks: (B:37:0x00d7, B:39:0x00df, B:43:0x00ee, B:49:0x00fa, B:50:0x00fd), top: B:76:0x0025 }] */
    /* JADX WARN: Type inference failed for: r0v3, types: [okio.FileSystem] */
    /* JADX WARN: Type inference failed for: r0v5, types: [okio.FileSystem] */
    /* JADX WARN: Type inference failed for: r10v13, types: [androidx.datastore.core.Closeable] */
    /* JADX WARN: Type inference failed for: r10v15 */
    /* JADX WARN: Type inference failed for: r10v16, types: [androidx.datastore.core.Closeable] */
    /* JADX WARN: Type inference failed for: r10v30, types: [androidx.datastore.core.Closeable] */
    /* JADX WARN: Type inference failed for: r10v31 */
    /* JADX WARN: Type inference failed for: r2v0, types: [int] */
    /* JADX WARN: Type inference failed for: r2v1 */
    /* JADX WARN: Type inference failed for: r2v2, types: [okio.Path] */
    @Override // androidx.datastore.core.StorageConnection
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object writeScope(Function2<? super WriteScope<T>, ? super Continuation<? super Unit>, ? extends Object> function2, Continuation<? super Unit> continuation) {
        OkioStorageConnection$writeScope$1 okioStorageConnection$writeScope$1;
        Object coroutine_suspended;
        ?? r2;
        Mutex mutex;
        OkioStorageConnection<T> okioStorageConnection;
        Path path;
        Path parent;
        OkioWriteScope okioWriteScope;
        Throwable th;
        OkioWriteScope okioWriteScope2;
        Path path2;
        OkioStorageConnection<T> okioStorageConnection2;
        Mutex mutex2;
        try {
            try {
                try {
                    try {
                        try {
                            if (continuation instanceof OkioStorageConnection$writeScope$1) {
                                OkioStorageConnection$writeScope$1 okioStorageConnection$writeScope$12 = (OkioStorageConnection$writeScope$1) continuation;
                                if ((okioStorageConnection$writeScope$12.label & Integer.MIN_VALUE) != 0) {
                                    okioStorageConnection$writeScope$12.label -= Integer.MIN_VALUE;
                                    okioStorageConnection$writeScope$1 = okioStorageConnection$writeScope$12;
                                    Object obj = okioStorageConnection$writeScope$1.result;
                                    coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                                    r2 = okioStorageConnection$writeScope$1.label;
                                    if (r2 != 0) {
                                        ResultKt.throwOnFailure(obj);
                                        checkNotClosed();
                                        parent = this.path.parent();
                                        if (parent == null) {
                                            throw new IllegalStateException("must have a parent path".toString());
                                        }
                                        this.fileSystem.createDirectories(parent, false);
                                        mutex = this.transactionMutex;
                                        okioStorageConnection$writeScope$1.L$0 = this;
                                        okioStorageConnection$writeScope$1.L$1 = function2;
                                        okioStorageConnection$writeScope$1.L$2 = parent;
                                        okioStorageConnection$writeScope$1.L$3 = mutex;
                                        okioStorageConnection$writeScope$1.label = 1;
                                        if (mutex.lock(null, okioStorageConnection$writeScope$1) != coroutine_suspended) {
                                            okioStorageConnection = this;
                                        }
                                        return coroutine_suspended;
                                    } else if (r2 != 1) {
                                        if (r2 == 2) {
                                            okioWriteScope2 = (Closeable) okioStorageConnection$writeScope$1.L$3;
                                            path2 = (Path) okioStorageConnection$writeScope$1.L$2;
                                            mutex2 = (Mutex) okioStorageConnection$writeScope$1.L$1;
                                            okioStorageConnection2 = (OkioStorageConnection) okioStorageConnection$writeScope$1.L$0;
                                            try {
                                                ResultKt.throwOnFailure(obj);
                                                okioWriteScope2 = okioWriteScope2;
                                                Unit unit = Unit.INSTANCE;
                                                try {
                                                    okioWriteScope2.close();
                                                    th = null;
                                                } catch (Throwable th2) {
                                                    th = th2;
                                                }
                                                if (th != null) {
                                                    if (okioStorageConnection2.fileSystem.exists(path2)) {
                                                        okioStorageConnection2.fileSystem.atomicMove(path2, okioStorageConnection2.path);
                                                    }
                                                    Unit unit2 = Unit.INSTANCE;
                                                    mutex2.unlock(null);
                                                    return Unit.INSTANCE;
                                                }
                                                throw th;
                                            } catch (Throwable th3) {
                                                th = th3;
                                                try {
                                                    okioWriteScope2.close();
                                                } catch (Throwable th4) {
                                                    ExceptionsKt.addSuppressed(th, th4);
                                                }
                                                throw th;
                                            }
                                        }
                                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                    } else {
                                        parent = (Path) okioStorageConnection$writeScope$1.L$2;
                                        okioStorageConnection = (OkioStorageConnection) okioStorageConnection$writeScope$1.L$0;
                                        ResultKt.throwOnFailure(obj);
                                        mutex = (Mutex) okioStorageConnection$writeScope$1.L$3;
                                        function2 = (Function2) okioStorageConnection$writeScope$1.L$1;
                                    }
                                    path = parent.resolve(okioStorageConnection.path.name() + ".tmp");
                                    okioStorageConnection.fileSystem.delete(path, false);
                                    okioWriteScope = new OkioWriteScope(okioStorageConnection.fileSystem, path, okioStorageConnection.serializer);
                                    okioStorageConnection$writeScope$1.L$0 = okioStorageConnection;
                                    okioStorageConnection$writeScope$1.L$1 = mutex;
                                    okioStorageConnection$writeScope$1.L$2 = path;
                                    okioStorageConnection$writeScope$1.L$3 = okioWriteScope;
                                    okioStorageConnection$writeScope$1.label = 2;
                                    if (function2.invoke(okioWriteScope, okioStorageConnection$writeScope$1) != coroutine_suspended) {
                                        path2 = path;
                                        okioWriteScope2 = okioWriteScope;
                                        okioStorageConnection2 = okioStorageConnection;
                                        mutex2 = mutex;
                                        Unit unit3 = Unit.INSTANCE;
                                        okioWriteScope2.close();
                                        th = null;
                                        if (th != null) {
                                        }
                                    }
                                    return coroutine_suspended;
                                }
                            }
                            okioStorageConnection$writeScope$1.L$0 = okioStorageConnection;
                            okioStorageConnection$writeScope$1.L$1 = mutex;
                            okioStorageConnection$writeScope$1.L$2 = path;
                            okioStorageConnection$writeScope$1.L$3 = okioWriteScope;
                            okioStorageConnection$writeScope$1.label = 2;
                            if (function2.invoke(okioWriteScope, okioStorageConnection$writeScope$1) != coroutine_suspended) {
                            }
                            return coroutine_suspended;
                        } catch (Throwable th5) {
                            th = th5;
                            okioWriteScope2 = okioWriteScope;
                            okioWriteScope2.close();
                            throw th;
                        }
                        okioStorageConnection.fileSystem.delete(path, false);
                        okioWriteScope = new OkioWriteScope(okioStorageConnection.fileSystem, path, okioStorageConnection.serializer);
                    } catch (IOException e) {
                        e = e;
                        if (okioStorageConnection.fileSystem.exists(path)) {
                            try {
                                okioStorageConnection.fileSystem.delete(path);
                            } catch (IOException unused) {
                            }
                        }
                        throw e;
                    }
                    path = parent.resolve(okioStorageConnection.path.name() + ".tmp");
                } catch (Throwable th6) {
                    th = th6;
                    mutex.unlock(null);
                    throw th;
                }
                if (r2 != 0) {
                }
            } catch (IOException e2) {
                e = e2;
                okioStorageConnection = okioStorageConnection$writeScope$1;
                mutex = r2;
                path = coroutine_suspended;
            }
        } catch (Throwable th7) {
            th = th7;
            mutex = r2;
            mutex.unlock(null);
            throw th;
        }
        okioStorageConnection$writeScope$1 = new OkioStorageConnection$writeScope$1(this, continuation);
        Object obj2 = okioStorageConnection$writeScope$1.result;
        coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        r2 = okioStorageConnection$writeScope$1.label;
    }

    private final void checkNotClosed() {
        if (this.closed.get()) {
            throw new IllegalStateException("StorageConnection has already been disposed.".toString());
        }
    }

    @Override // androidx.datastore.core.Closeable
    public void close() {
        this.closed.set(true);
        this.onClose.invoke();
    }
}
