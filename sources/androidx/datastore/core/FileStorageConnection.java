package androidx.datastore.core;

import androidx.exifinterface.media.ExifInterface;
import java.io.File;
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
/* compiled from: FileStorage.kt */
@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B1\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n¢\u0006\u0002\u0010\fJ\b\u0010\u0013\u001a\u00020\u000bH\u0002J\b\u0010\u0014\u001a\u00020\u000bH\u0016JX\u0010\u0015\u001a\u0002H\u0016\"\u0004\b\u0001\u0010\u00162B\u0010\u0017\u001a>\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0019\u0012\u0013\u0012\u00110\u001a¢\u0006\f\b\u001b\u0012\b\b\u001c\u0012\u0004\b\b(\u001d\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00160\u001e\u0012\u0006\u0012\u0004\u0018\u00010\u001f0\u0018¢\u0006\u0002\b H\u0096@¢\u0006\u0002\u0010!J=\u0010\"\u001a\u00020\u000b2-\u0010\u0017\u001a)\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000$\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\u001e\u0012\u0006\u0012\u0004\u0018\u00010\u001f0#¢\u0006\u0002\b H\u0096@¢\u0006\u0002\u0010%J\f\u0010&\u001a\u00020\u000b*\u00020\u0004H\u0002R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\u00020\bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006'"}, d2 = {"Landroidx/datastore/core/FileStorageConnection;", ExifInterface.GPS_DIRECTION_TRUE, "Landroidx/datastore/core/StorageConnection;", "file", "Ljava/io/File;", "serializer", "Landroidx/datastore/core/Serializer;", "coordinator", "Landroidx/datastore/core/InterProcessCoordinator;", "onClose", "Lkotlin/Function0;", "", "(Ljava/io/File;Landroidx/datastore/core/Serializer;Landroidx/datastore/core/InterProcessCoordinator;Lkotlin/jvm/functions/Function0;)V", "closed", "Ljava/util/concurrent/atomic/AtomicBoolean;", "getCoordinator", "()Landroidx/datastore/core/InterProcessCoordinator;", "transactionMutex", "Lkotlinx/coroutines/sync/Mutex;", "checkNotClosed", "close", "readScope", "R", "block", "Lkotlin/Function3;", "Landroidx/datastore/core/ReadScope;", "", "Lkotlin/ParameterName;", "name", "locked", "Lkotlin/coroutines/Continuation;", "", "Lkotlin/ExtensionFunctionType;", "(Lkotlin/jvm/functions/Function3;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "writeScope", "Lkotlin/Function2;", "Landroidx/datastore/core/WriteScope;", "(Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "createParentDirectories", "datastore-core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class FileStorageConnection<T> implements StorageConnection<T> {
    private final java.util.concurrent.atomic.AtomicBoolean closed;
    private final InterProcessCoordinator coordinator;
    private final File file;
    private final Function0<Unit> onClose;
    private final Serializer<T> serializer;
    private final Mutex transactionMutex;

    public FileStorageConnection(File file, Serializer<T> serializer, InterProcessCoordinator coordinator, Function0<Unit> onClose) {
        Intrinsics.checkNotNullParameter(file, "file");
        Intrinsics.checkNotNullParameter(serializer, "serializer");
        Intrinsics.checkNotNullParameter(coordinator, "coordinator");
        Intrinsics.checkNotNullParameter(onClose, "onClose");
        this.file = file;
        this.serializer = serializer;
        this.coordinator = coordinator;
        this.onClose = onClose;
        this.closed = new java.util.concurrent.atomic.AtomicBoolean(false);
        this.transactionMutex = MutexKt.Mutex$default(false, 1, null);
    }

    @Override // androidx.datastore.core.StorageConnection
    public InterProcessCoordinator getCoordinator() {
        return this.coordinator;
    }

    /* JADX WARN: Can't wrap try/catch for region: R(7:(2:3|(8:5|6|7|(1:(3:10|11|12)(2:28|29))(6:30|31|32|33|34|(1:36)(1:37))|14|15|16|(2:(1:19)|20)(1:22)))|7|(0)(0)|14|15|16|(0)(0)) */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0076, code lost:
        r1 = th;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0025  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x003f  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0079  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0081 A[Catch: all -> 0x0091, TRY_ENTER, TRY_LEAVE, TryCatch #6 {all -> 0x0091, blocks: (B:31:0x0081, B:38:0x0090, B:34:0x0088), top: B:54:0x0023 }] */
    /* JADX WARN: Type inference failed for: r0v1, types: [androidx.datastore.core.FileStorageConnection$readScope$1] */
    /* JADX WARN: Type inference failed for: r0v14, types: [androidx.datastore.core.FileStorageConnection$readScope$1] */
    @Override // androidx.datastore.core.StorageConnection
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public <R> Object readScope(Function3<? super ReadScope<T>, ? super Boolean, ? super Continuation<? super R>, ? extends Object> function3, Continuation<? super R> continuation) {
        FileStorageConnection<T> fileStorageConnection;
        int i;
        Throwable th;
        Closeable closeable;
        boolean z;
        FileStorageConnection<T> fileStorageConnection2;
        try {
            if (continuation instanceof FileStorageConnection$readScope$1) {
                FileStorageConnection$readScope$1 fileStorageConnection$readScope$1 = (FileStorageConnection$readScope$1) continuation;
                if ((fileStorageConnection$readScope$1.label & Integer.MIN_VALUE) != 0) {
                    fileStorageConnection$readScope$1.label -= Integer.MIN_VALUE;
                    fileStorageConnection = fileStorageConnection$readScope$1;
                    Object obj = ((FileStorageConnection$readScope$1) fileStorageConnection).result;
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    i = ((FileStorageConnection$readScope$1) fileStorageConnection).label;
                    if (i != 0) {
                        ResultKt.throwOnFailure(obj);
                        checkNotClosed();
                        boolean tryLock$default = Mutex.DefaultImpls.tryLock$default(this.transactionMutex, null, 1, null);
                        try {
                            FileReadScope fileReadScope = new FileReadScope(this.file, this.serializer);
                            try {
                                Boolean boxBoolean = Boxing.boxBoolean(tryLock$default);
                                ((FileStorageConnection$readScope$1) fileStorageConnection).L$0 = this;
                                ((FileStorageConnection$readScope$1) fileStorageConnection).L$1 = fileReadScope;
                                ((FileStorageConnection$readScope$1) fileStorageConnection).Z$0 = tryLock$default;
                                ((FileStorageConnection$readScope$1) fileStorageConnection).label = 1;
                                Object invoke = function3.invoke(fileReadScope, boxBoolean, fileStorageConnection);
                                if (invoke == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                                obj = invoke;
                                z = tryLock$default;
                                fileStorageConnection2 = this;
                                closeable = fileReadScope;
                            } catch (Throwable th2) {
                                th = th2;
                                closeable = fileReadScope;
                                closeable.close();
                                throw th;
                            }
                        } catch (Throwable th3) {
                            th = th3;
                            function3 = tryLock$default;
                            fileStorageConnection = this;
                            if (function3 != null) {
                                Mutex.DefaultImpls.unlock$default(fileStorageConnection.transactionMutex, null, 1, null);
                            }
                            throw th;
                        }
                    } else if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    } else {
                        z = ((FileStorageConnection$readScope$1) fileStorageConnection).Z$0;
                        closeable = (Closeable) ((FileStorageConnection$readScope$1) fileStorageConnection).L$1;
                        fileStorageConnection2 = (FileStorageConnection) ((FileStorageConnection$readScope$1) fileStorageConnection).L$0;
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
                            Mutex.DefaultImpls.unlock$default(fileStorageConnection2.transactionMutex, null, 1, null);
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
        fileStorageConnection = new FileStorageConnection$readScope$1(this, continuation);
        Object obj2 = ((FileStorageConnection$readScope$1) fileStorageConnection).result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = ((FileStorageConnection$readScope$1) fileStorageConnection).label;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0028  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x005f  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00b8  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00c5 A[Catch: IOException -> 0x010f, all -> 0x011d, TRY_ENTER, TryCatch #5 {IOException -> 0x010f, blocks: (B:35:0x00c5, B:37:0x00cb, B:40:0x00d4, B:41:0x00f8, B:45:0x0101, B:51:0x010b, B:52:0x010e), top: B:73:0x0026 }] */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0101 A[Catch: IOException -> 0x010f, all -> 0x011d, TRY_ENTER, TRY_LEAVE, TryCatch #5 {IOException -> 0x010f, blocks: (B:35:0x00c5, B:37:0x00cb, B:40:0x00d4, B:41:0x00f8, B:45:0x0101, B:51:0x010b, B:52:0x010e), top: B:73:0x0026 }] */
    /* JADX WARN: Type inference failed for: r11v10, types: [androidx.datastore.core.Closeable] */
    /* JADX WARN: Type inference failed for: r11v12 */
    /* JADX WARN: Type inference failed for: r11v13, types: [androidx.datastore.core.Closeable] */
    /* JADX WARN: Type inference failed for: r11v28, types: [androidx.datastore.core.Closeable] */
    /* JADX WARN: Type inference failed for: r11v29 */
    /* JADX WARN: Type inference failed for: r12v2 */
    /* JADX WARN: Type inference failed for: r12v3, types: [java.io.File] */
    @Override // androidx.datastore.core.StorageConnection
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object writeScope(Function2<? super WriteScope<T>, ? super Continuation<? super Unit>, ? extends Object> function2, Continuation<? super Unit> continuation) {
        FileStorageConnection$writeScope$1 fileStorageConnection$writeScope$1;
        Object coroutine_suspended;
        int i;
        File file;
        FileStorageConnection<T> fileStorageConnection;
        Mutex mutex;
        FileWriteScope fileWriteScope;
        Throwable th;
        FileWriteScope fileWriteScope2;
        File file2;
        FileStorageConnection<T> fileStorageConnection2;
        try {
            try {
                try {
                    try {
                        if (continuation instanceof FileStorageConnection$writeScope$1) {
                            fileStorageConnection$writeScope$1 = (FileStorageConnection$writeScope$1) continuation;
                            if ((fileStorageConnection$writeScope$1.label & Integer.MIN_VALUE) != 0) {
                                fileStorageConnection$writeScope$1.label -= Integer.MIN_VALUE;
                                Object obj = fileStorageConnection$writeScope$1.result;
                                coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                                i = fileStorageConnection$writeScope$1.label;
                                if (i != 0) {
                                    ResultKt.throwOnFailure(obj);
                                    checkNotClosed();
                                    createParentDirectories(this.file);
                                    Mutex mutex2 = this.transactionMutex;
                                    fileStorageConnection$writeScope$1.L$0 = this;
                                    fileStorageConnection$writeScope$1.L$1 = function2;
                                    fileStorageConnection$writeScope$1.L$2 = mutex2;
                                    fileStorageConnection$writeScope$1.label = 1;
                                    if (mutex2.lock(null, fileStorageConnection$writeScope$1) != coroutine_suspended) {
                                        fileStorageConnection = this;
                                        mutex = mutex2;
                                    }
                                    return coroutine_suspended;
                                } else if (i != 1) {
                                    if (i == 2) {
                                        fileWriteScope2 = (Closeable) fileStorageConnection$writeScope$1.L$3;
                                        file2 = (File) fileStorageConnection$writeScope$1.L$2;
                                        mutex = (Mutex) fileStorageConnection$writeScope$1.L$1;
                                        fileStorageConnection2 = (FileStorageConnection) fileStorageConnection$writeScope$1.L$0;
                                        try {
                                            ResultKt.throwOnFailure(obj);
                                            fileWriteScope2 = fileWriteScope2;
                                            Unit unit = Unit.INSTANCE;
                                            try {
                                                fileWriteScope2.close();
                                                th = null;
                                            } catch (Throwable th2) {
                                                th = th2;
                                            }
                                            if (th != null) {
                                                if (file2.exists() && !FileMoves_androidKt.atomicMoveTo(file2, fileStorageConnection2.file)) {
                                                    throw new IOException("Unable to rename " + file2 + " to " + fileStorageConnection2.file + ". This likely means that there are multiple instances of DataStore for this file. Ensure that you are only creating a single instance of datastore for this file.");
                                                }
                                                Unit unit2 = Unit.INSTANCE;
                                                mutex.unlock(null);
                                                return Unit.INSTANCE;
                                            }
                                            throw th;
                                        } catch (Throwable th3) {
                                            th = th3;
                                            try {
                                                fileWriteScope2.close();
                                            } catch (Throwable th4) {
                                                ExceptionsKt.addSuppressed(th, th4);
                                            }
                                            throw th;
                                        }
                                    }
                                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                } else {
                                    Function2<? super WriteScope<T>, ? super Continuation<? super Unit>, ? extends Object> function22 = (Function2) fileStorageConnection$writeScope$1.L$1;
                                    fileStorageConnection = (FileStorageConnection) fileStorageConnection$writeScope$1.L$0;
                                    ResultKt.throwOnFailure(obj);
                                    mutex = (Mutex) fileStorageConnection$writeScope$1.L$2;
                                    function2 = function22;
                                }
                                file = new File(fileStorageConnection.file.getAbsolutePath() + ".tmp");
                                fileWriteScope = new FileWriteScope(file, fileStorageConnection.serializer);
                                fileStorageConnection$writeScope$1.L$0 = fileStorageConnection;
                                fileStorageConnection$writeScope$1.L$1 = mutex;
                                fileStorageConnection$writeScope$1.L$2 = file;
                                fileStorageConnection$writeScope$1.L$3 = fileWriteScope;
                                fileStorageConnection$writeScope$1.label = 2;
                                if (function2.invoke(fileWriteScope, fileStorageConnection$writeScope$1) != coroutine_suspended) {
                                    file2 = file;
                                    fileStorageConnection2 = fileStorageConnection;
                                    fileWriteScope2 = fileWriteScope;
                                    Unit unit3 = Unit.INSTANCE;
                                    fileWriteScope2.close();
                                    th = null;
                                    if (th != null) {
                                    }
                                }
                                return coroutine_suspended;
                            }
                        }
                        fileStorageConnection$writeScope$1.L$0 = fileStorageConnection;
                        fileStorageConnection$writeScope$1.L$1 = mutex;
                        fileStorageConnection$writeScope$1.L$2 = file;
                        fileStorageConnection$writeScope$1.L$3 = fileWriteScope;
                        fileStorageConnection$writeScope$1.label = 2;
                        if (function2.invoke(fileWriteScope, fileStorageConnection$writeScope$1) != coroutine_suspended) {
                        }
                        return coroutine_suspended;
                    } catch (Throwable th5) {
                        th = th5;
                        fileWriteScope2 = fileWriteScope;
                        fileWriteScope2.close();
                        throw th;
                    }
                    fileWriteScope = new FileWriteScope(file, fileStorageConnection.serializer);
                } catch (IOException e) {
                    e = e;
                    if (file.exists()) {
                        file.delete();
                    }
                    throw e;
                }
                file = new File(fileStorageConnection.file.getAbsolutePath() + ".tmp");
            } catch (Throwable th6) {
                mutex.unlock(null);
                throw th6;
            }
            if (i != 0) {
            }
        } catch (IOException e2) {
            e = e2;
            file = coroutine_suspended;
        }
        fileStorageConnection$writeScope$1 = new FileStorageConnection$writeScope$1(this, continuation);
        Object obj2 = fileStorageConnection$writeScope$1.result;
        coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = fileStorageConnection$writeScope$1.label;
    }

    @Override // androidx.datastore.core.Closeable
    public void close() {
        this.closed.set(true);
        this.onClose.invoke();
    }

    private final void checkNotClosed() {
        if (this.closed.get()) {
            throw new IllegalStateException("StorageConnection has already been disposed.".toString());
        }
    }

    private final void createParentDirectories(File file) {
        File parentFile = file.getCanonicalFile().getParentFile();
        if (parentFile != null) {
            parentFile.mkdirs();
            if (!parentFile.isDirectory()) {
                throw new IOException("Unable to create parent directories of " + file);
            }
        }
    }
}
