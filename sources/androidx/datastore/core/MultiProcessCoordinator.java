package androidx.datastore.core;

import androidx.datastore.core.SharedCounter;
import androidx.exifinterface.media.ExifInterface;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileLock;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.sync.Mutex;
import kotlinx.coroutines.sync.MutexKt;
/* compiled from: MultiProcessCoordinator.android.kt */
@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\b\u0000\u0018\u0000 42\u00020\u0001:\u00014B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010 \u001a\u00020\u00052\u0006\u0010!\u001a\u00020\bH\u0002J\u000e\u0010\"\u001a\u00020#H\u0096@¢\u0006\u0002\u0010$J\u000e\u0010%\u001a\u00020#H\u0096@¢\u0006\u0002\u0010$J2\u0010&\u001a\u0002H'\"\u0004\b\u0000\u0010'2\u001c\u0010(\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u0002H'0*\u0012\u0006\u0012\u0004\u0018\u00010+0)H\u0096@¢\u0006\u0002\u0010,J8\u0010-\u001a\u0002H'\"\u0004\b\u0000\u0010'2\"\u0010(\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020/\u0012\n\u0012\b\u0012\u0004\u0012\u0002H'0*\u0012\u0006\u0012\u0004\u0018\u00010+0.H\u0096@¢\u0006\u0002\u00100J:\u00101\u001a\u0002H'\"\u0004\b\u0000\u0010'2$\b\u0004\u0010(\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020\u0011\u0012\n\u0012\b\u0012\u0004\u0012\u0002H'0*\u0012\u0006\u0012\u0004\u0018\u00010+0.H\u0082H¢\u0006\u0002\u00100J\f\u00102\u001a\u00020\u001d*\u00020\u0005H\u0002J\f\u00103\u001a\u00020\u001d*\u00020\u0005H\u0002R\u000e\u0010\u0007\u001a\u00020\bX\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bX\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\bX\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0004\u001a\u00020\u0005X\u0084\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\u0012\u001a\u00020\u00058BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0013\u0010\fR\u001b\u0010\u0016\u001a\u00020\u00118BX\u0082\u0084\u0002¢\u0006\f\u001a\u0004\b\u0019\u0010\u001a*\u0004\b\u0017\u0010\u0018R\u001a\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001d0\u001cX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001f¨\u00065"}, d2 = {"Landroidx/datastore/core/MultiProcessCoordinator;", "Landroidx/datastore/core/InterProcessCoordinator;", "context", "Lkotlin/coroutines/CoroutineContext;", "file", "Ljava/io/File;", "(Lkotlin/coroutines/CoroutineContext;Ljava/io/File;)V", "LOCK_ERROR_MESSAGE", "", "LOCK_SUFFIX", "VERSION_SUFFIX", "getFile", "()Ljava/io/File;", "inMemoryMutex", "Lkotlinx/coroutines/sync/Mutex;", "lazySharedCounter", "Lkotlin/Lazy;", "Landroidx/datastore/core/SharedCounter;", "lockFile", "getLockFile", "lockFile$delegate", "Lkotlin/Lazy;", "sharedCounter", "getSharedCounter$delegate", "(Landroidx/datastore/core/MultiProcessCoordinator;)Ljava/lang/Object;", "getSharedCounter", "()Landroidx/datastore/core/SharedCounter;", "updateNotifications", "Lkotlinx/coroutines/flow/Flow;", "", "getUpdateNotifications", "()Lkotlinx/coroutines/flow/Flow;", "fileWithSuffix", "suffix", "getVersion", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "incrementAndGetVersion", "lock", ExifInterface.GPS_DIRECTION_TRUE, "block", "Lkotlin/Function1;", "Lkotlin/coroutines/Continuation;", "", "(Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "tryLock", "Lkotlin/Function2;", "", "(Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "withLazyCounter", "createIfNotExists", "createParentDirectories", "Companion", "datastore-core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class MultiProcessCoordinator implements InterProcessCoordinator {
    public static final Companion Companion = new Companion(null);
    private static final String DEADLOCK_ERROR_MESSAGE = "Resource deadlock would occur";
    private static final long INITIAL_WAIT_MILLIS = 10;
    private static final long MAX_WAIT_MILLIS = 60000;
    private final String LOCK_ERROR_MESSAGE;
    private final String LOCK_SUFFIX;
    private final String VERSION_SUFFIX;
    private final CoroutineContext context;
    private final File file;
    private final Mutex inMemoryMutex;
    private final Lazy<SharedCounter> lazySharedCounter;
    private final Lazy lockFile$delegate;
    private final Flow<Unit> updateNotifications;

    public MultiProcessCoordinator(CoroutineContext context, File file) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(file, "file");
        this.context = context;
        this.file = file;
        this.updateNotifications = MulticastFileObserver.Companion.observe(file);
        this.LOCK_SUFFIX = ".lock";
        this.VERSION_SUFFIX = ".version";
        this.LOCK_ERROR_MESSAGE = "fcntl failed: EAGAIN";
        this.inMemoryMutex = MutexKt.Mutex$default(false, 1, null);
        this.lockFile$delegate = LazyKt.lazy(new Function0<File>() { // from class: androidx.datastore.core.MultiProcessCoordinator$lockFile$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final File invoke() {
                String str;
                File fileWithSuffix;
                MultiProcessCoordinator multiProcessCoordinator = MultiProcessCoordinator.this;
                str = multiProcessCoordinator.LOCK_SUFFIX;
                fileWithSuffix = multiProcessCoordinator.fileWithSuffix(str);
                MultiProcessCoordinator.this.createIfNotExists(fileWithSuffix);
                return fileWithSuffix;
            }
        });
        this.lazySharedCounter = LazyKt.lazy(new Function0<SharedCounter>() { // from class: androidx.datastore.core.MultiProcessCoordinator$lazySharedCounter$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final SharedCounter invoke() {
                SharedCounter.Factory.loadLib();
                SharedCounter.Factory factory = SharedCounter.Factory;
                final MultiProcessCoordinator multiProcessCoordinator = MultiProcessCoordinator.this;
                return factory.create$datastore_core_release(new Function0<File>() { // from class: androidx.datastore.core.MultiProcessCoordinator$lazySharedCounter$1.1
                    {
                        super(0);
                    }

                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // kotlin.jvm.functions.Function0
                    public final File invoke() {
                        String str;
                        File fileWithSuffix;
                        MultiProcessCoordinator multiProcessCoordinator2 = MultiProcessCoordinator.this;
                        str = multiProcessCoordinator2.VERSION_SUFFIX;
                        fileWithSuffix = multiProcessCoordinator2.fileWithSuffix(str);
                        MultiProcessCoordinator.this.createIfNotExists(fileWithSuffix);
                        return fileWithSuffix;
                    }
                });
            }
        });
    }

    protected final File getFile() {
        return this.file;
    }

    @Override // androidx.datastore.core.InterProcessCoordinator
    public Flow<Unit> getUpdateNotifications() {
        return this.updateNotifications;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0027  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0071  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00a5  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00bb  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00c1 A[Catch: all -> 0x00df, TRY_ENTER, TRY_LEAVE, TryCatch #8 {all -> 0x00df, blocks: (B:43:0x00c1, B:54:0x00db, B:57:0x00e3), top: B:80:0x0025 }] */
    /* JADX WARN: Removed duplicated region for block: B:54:0x00db A[Catch: all -> 0x00df, TRY_ENTER, TryCatch #8 {all -> 0x00df, blocks: (B:43:0x00c1, B:54:0x00db, B:57:0x00e3), top: B:80:0x0025 }] */
    /* JADX WARN: Type inference failed for: r11v3 */
    /* JADX WARN: Type inference failed for: r11v4 */
    /* JADX WARN: Type inference failed for: r11v5, types: [kotlinx.coroutines.sync.Mutex] */
    @Override // androidx.datastore.core.InterProcessCoordinator
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public <T> Object lock(Function1<? super Continuation<? super T>, ? extends Object> function1, Continuation<? super T> continuation) {
        MultiProcessCoordinator$lock$1 multiProcessCoordinator$lock$1;
        Object coroutine_suspended;
        int i;
        Mutex mutex;
        MultiProcessCoordinator multiProcessCoordinator;
        Throwable th;
        Object exclusiveFileLockWithRetryIfDeadlock;
        Function1<? super Continuation<? super T>, ? extends Object> function12;
        java.io.Closeable closeable;
        Mutex mutex2;
        FileLock fileLock;
        FileLock fileLock2;
        Object invoke;
        java.io.Closeable closeable2;
        Mutex mutex3;
        try {
            try {
                try {
                    try {
                        if (continuation instanceof MultiProcessCoordinator$lock$1) {
                            multiProcessCoordinator$lock$1 = (MultiProcessCoordinator$lock$1) continuation;
                            if ((multiProcessCoordinator$lock$1.label & Integer.MIN_VALUE) != 0) {
                                multiProcessCoordinator$lock$1.label -= Integer.MIN_VALUE;
                                Object obj = multiProcessCoordinator$lock$1.result;
                                coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                                i = multiProcessCoordinator$lock$1.label;
                                if (i != 0) {
                                    ResultKt.throwOnFailure(obj);
                                    mutex = this.inMemoryMutex;
                                    multiProcessCoordinator$lock$1.L$0 = this;
                                    multiProcessCoordinator$lock$1.L$1 = function1;
                                    multiProcessCoordinator$lock$1.L$2 = mutex;
                                    multiProcessCoordinator$lock$1.label = 1;
                                    if (mutex.lock(null, multiProcessCoordinator$lock$1) != coroutine_suspended) {
                                        multiProcessCoordinator = this;
                                    }
                                    return coroutine_suspended;
                                } else if (i != 1) {
                                    if (i != 2) {
                                        if (i == 3) {
                                            fileLock = (FileLock) multiProcessCoordinator$lock$1.L$2;
                                            closeable2 = (java.io.Closeable) multiProcessCoordinator$lock$1.L$1;
                                            mutex3 = (Mutex) multiProcessCoordinator$lock$1.L$0;
                                            try {
                                                ResultKt.throwOnFailure(obj);
                                                if (fileLock != null) {
                                                    fileLock.release();
                                                }
                                                try {
                                                    kotlin.io.CloseableKt.closeFinally(closeable2, null);
                                                    mutex3.unlock(null);
                                                    return obj;
                                                } catch (Throwable th2) {
                                                    th = th2;
                                                    mutex = mutex3;
                                                    mutex.unlock(null);
                                                    throw th;
                                                }
                                            } catch (Throwable th3) {
                                                th = th3;
                                                if (fileLock != null) {
                                                }
                                                throw th;
                                            }
                                        }
                                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                    }
                                    closeable = (java.io.Closeable) multiProcessCoordinator$lock$1.L$2;
                                    mutex2 = (Mutex) multiProcessCoordinator$lock$1.L$1;
                                    function12 = (Function1) multiProcessCoordinator$lock$1.L$0;
                                    try {
                                        ResultKt.throwOnFailure(obj);
                                        fileLock2 = (FileLock) obj;
                                    } catch (Throwable th4) {
                                        th = th4;
                                        fileLock = null;
                                        if (fileLock != null) {
                                        }
                                        throw th;
                                    }
                                    try {
                                        multiProcessCoordinator$lock$1.L$0 = mutex2;
                                        multiProcessCoordinator$lock$1.L$1 = closeable;
                                        multiProcessCoordinator$lock$1.L$2 = fileLock2;
                                        multiProcessCoordinator$lock$1.label = 3;
                                        invoke = function12.invoke(multiProcessCoordinator$lock$1);
                                        if (invoke != coroutine_suspended) {
                                            closeable2 = closeable;
                                            fileLock = fileLock2;
                                            obj = invoke;
                                            mutex3 = mutex2;
                                            if (fileLock != null) {
                                            }
                                            kotlin.io.CloseableKt.closeFinally(closeable2, null);
                                            mutex3.unlock(null);
                                            return obj;
                                        }
                                        return coroutine_suspended;
                                    } catch (Throwable th5) {
                                        fileLock = fileLock2;
                                        th = th5;
                                        if (fileLock != null) {
                                        }
                                        throw th;
                                    }
                                } else {
                                    multiProcessCoordinator = (MultiProcessCoordinator) multiProcessCoordinator$lock$1.L$0;
                                    ResultKt.throwOnFailure(obj);
                                    mutex = (Mutex) multiProcessCoordinator$lock$1.L$2;
                                    function1 = (Function1) multiProcessCoordinator$lock$1.L$1;
                                }
                                FileOutputStream fileOutputStream = new FileOutputStream(multiProcessCoordinator.getLockFile());
                                FileOutputStream fileOutputStream2 = fileOutputStream;
                                Companion companion = Companion;
                                multiProcessCoordinator$lock$1.L$0 = function1;
                                multiProcessCoordinator$lock$1.L$1 = mutex;
                                multiProcessCoordinator$lock$1.L$2 = fileOutputStream;
                                multiProcessCoordinator$lock$1.label = 2;
                                exclusiveFileLockWithRetryIfDeadlock = companion.getExclusiveFileLockWithRetryIfDeadlock(fileOutputStream2, multiProcessCoordinator$lock$1);
                                if (exclusiveFileLockWithRetryIfDeadlock != coroutine_suspended) {
                                    function12 = function1;
                                    closeable = fileOutputStream;
                                    mutex2 = mutex;
                                    obj = exclusiveFileLockWithRetryIfDeadlock;
                                    fileLock2 = (FileLock) obj;
                                    multiProcessCoordinator$lock$1.L$0 = mutex2;
                                    multiProcessCoordinator$lock$1.L$1 = closeable;
                                    multiProcessCoordinator$lock$1.L$2 = fileLock2;
                                    multiProcessCoordinator$lock$1.label = 3;
                                    invoke = function12.invoke(multiProcessCoordinator$lock$1);
                                    if (invoke != coroutine_suspended) {
                                    }
                                }
                                return coroutine_suspended;
                            }
                        }
                        Companion companion2 = Companion;
                        multiProcessCoordinator$lock$1.L$0 = function1;
                        multiProcessCoordinator$lock$1.L$1 = mutex;
                        multiProcessCoordinator$lock$1.L$2 = fileOutputStream;
                        multiProcessCoordinator$lock$1.label = 2;
                        exclusiveFileLockWithRetryIfDeadlock = companion2.getExclusiveFileLockWithRetryIfDeadlock(fileOutputStream2, multiProcessCoordinator$lock$1);
                        if (exclusiveFileLockWithRetryIfDeadlock != coroutine_suspended) {
                        }
                        return coroutine_suspended;
                    } catch (Throwable th6) {
                        th = th6;
                        fileLock = null;
                        if (fileLock != null) {
                            fileLock.release();
                        }
                        throw th;
                    }
                    FileOutputStream fileOutputStream22 = fileOutputStream;
                } catch (Throwable th7) {
                    th = th7;
                    throw th;
                }
                FileOutputStream fileOutputStream3 = new FileOutputStream(multiProcessCoordinator.getLockFile());
            } catch (Throwable th8) {
                th = th8;
                mutex.unlock(null);
                throw th;
            }
            if (i != 0) {
            }
        } catch (Throwable th9) {
            th = th9;
            mutex = multiProcessCoordinator$lock$1;
        }
        multiProcessCoordinator$lock$1 = new MultiProcessCoordinator$lock$1(this, continuation);
        Object obj2 = multiProcessCoordinator$lock$1.result;
        coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = multiProcessCoordinator$lock$1.label;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:10:0x002c  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x005b  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x007d  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00e7 A[Catch: all -> 0x0100, TRY_ENTER, TRY_LEAVE, TryCatch #1 {all -> 0x0100, blocks: (B:58:0x00e7, B:67:0x00fc, B:70:0x0105), top: B:87:0x002a }] */
    /* JADX WARN: Removed duplicated region for block: B:61:0x00ef  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x00fc A[Catch: all -> 0x0100, TRY_ENTER, TryCatch #1 {all -> 0x0100, blocks: (B:58:0x00e7, B:67:0x00fc, B:70:0x0105), top: B:87:0x002a }] */
    /* JADX WARN: Removed duplicated region for block: B:83:0x0116  */
    /* JADX WARN: Type inference failed for: r3v1, types: [androidx.datastore.core.MultiProcessCoordinator$tryLock$1] */
    /* JADX WARN: Type inference failed for: r3v19, types: [androidx.datastore.core.MultiProcessCoordinator$tryLock$1] */
    /* JADX WARN: Type inference failed for: r5v0, types: [int] */
    /* JADX WARN: Type inference failed for: r9v1 */
    /* JADX WARN: Type inference failed for: r9v2 */
    /* JADX WARN: Type inference failed for: r9v4 */
    @Override // androidx.datastore.core.InterProcessCoordinator
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public <T> Object tryLock(Function2<? super Boolean, ? super Continuation<? super T>, ? extends Object> function2, Continuation<? super T> continuation) {
        Mutex mutex;
        ?? r5;
        boolean z;
        FileInputStream fileInputStream;
        Throwable th;
        FileLock fileLock;
        String message;
        FileLock fileLock2;
        Mutex mutex2;
        boolean z2;
        java.io.Closeable closeable;
        Mutex mutex3;
        boolean z3;
        Function2<? super Boolean, ? super Continuation<? super T>, ? extends Object> function22 = function2;
        try {
            try {
                if (continuation instanceof MultiProcessCoordinator$tryLock$1) {
                    MultiProcessCoordinator$tryLock$1 multiProcessCoordinator$tryLock$1 = (MultiProcessCoordinator$tryLock$1) continuation;
                    if ((multiProcessCoordinator$tryLock$1.label & Integer.MIN_VALUE) != 0) {
                        multiProcessCoordinator$tryLock$1.label -= Integer.MIN_VALUE;
                        mutex = multiProcessCoordinator$tryLock$1;
                        Object obj = ((MultiProcessCoordinator$tryLock$1) mutex).result;
                        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                        r5 = ((MultiProcessCoordinator$tryLock$1) mutex).label;
                        if (r5 == 0) {
                            if (r5 == 1) {
                                z3 = ((MultiProcessCoordinator$tryLock$1) mutex).Z$0;
                                mutex3 = (Mutex) ((MultiProcessCoordinator$tryLock$1) mutex).L$0;
                                ResultKt.throwOnFailure(obj);
                                if (z3) {
                                    mutex3.unlock(null);
                                }
                                return obj;
                            } else if (r5 == 2) {
                                z2 = ((MultiProcessCoordinator$tryLock$1) mutex).Z$0;
                                fileLock = (FileLock) ((MultiProcessCoordinator$tryLock$1) mutex).L$2;
                                closeable = (java.io.Closeable) ((MultiProcessCoordinator$tryLock$1) mutex).L$1;
                                mutex2 = (Mutex) ((MultiProcessCoordinator$tryLock$1) mutex).L$0;
                                try {
                                    ResultKt.throwOnFailure(obj);
                                    if (fileLock != null) {
                                        fileLock.release();
                                    }
                                    kotlin.io.CloseableKt.closeFinally(closeable, null);
                                    if (z2) {
                                        mutex2.unlock(null);
                                    }
                                    return obj;
                                } catch (Throwable th2) {
                                    th = th2;
                                    if (fileLock != null) {
                                    }
                                    throw th;
                                }
                            } else {
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            }
                        }
                        ResultKt.throwOnFailure(obj);
                        Mutex mutex4 = this.inMemoryMutex;
                        z = mutex4.tryLock(null);
                        try {
                            if (z == 0) {
                                Boolean boxBoolean = Boxing.boxBoolean(false);
                                ((MultiProcessCoordinator$tryLock$1) mutex).L$0 = mutex4;
                                ((MultiProcessCoordinator$tryLock$1) mutex).Z$0 = z;
                                ((MultiProcessCoordinator$tryLock$1) mutex).label = 1;
                                obj = function22.invoke(boxBoolean, mutex);
                                if (obj != coroutine_suspended) {
                                    mutex3 = mutex4;
                                    z3 = z;
                                    if (z3) {
                                    }
                                    return obj;
                                }
                            } else {
                                fileInputStream = new FileInputStream(getLockFile());
                                try {
                                    try {
                                        try {
                                            fileLock2 = fileInputStream.getChannel().tryLock(0L, Long.MAX_VALUE, true);
                                        } catch (IOException e) {
                                            String message2 = e.getMessage();
                                            if ((message2 == null || !StringsKt.startsWith$default(message2, this.LOCK_ERROR_MESSAGE, false, 2, (Object) null)) && ((message = e.getMessage()) == null || !StringsKt.startsWith$default(message, DEADLOCK_ERROR_MESSAGE, false, 2, (Object) null))) {
                                                throw e;
                                            }
                                            fileLock2 = null;
                                        }
                                        try {
                                            Boolean boxBoolean2 = Boxing.boxBoolean(fileLock2 != null);
                                            ((MultiProcessCoordinator$tryLock$1) mutex).L$0 = mutex4;
                                            ((MultiProcessCoordinator$tryLock$1) mutex).L$1 = fileInputStream;
                                            ((MultiProcessCoordinator$tryLock$1) mutex).L$2 = fileLock2;
                                            ((MultiProcessCoordinator$tryLock$1) mutex).Z$0 = z;
                                            ((MultiProcessCoordinator$tryLock$1) mutex).label = 2;
                                            obj = function22.invoke(boxBoolean2, mutex);
                                            if (obj != coroutine_suspended) {
                                                mutex2 = mutex4;
                                                z2 = z;
                                                closeable = fileInputStream;
                                                fileLock = fileLock2;
                                                if (fileLock != null) {
                                                }
                                                kotlin.io.CloseableKt.closeFinally(closeable, null);
                                                if (z2) {
                                                }
                                                return obj;
                                            }
                                        } catch (Throwable th3) {
                                            th = th3;
                                            fileLock = fileLock2;
                                            if (fileLock != null) {
                                                fileLock.release();
                                            }
                                            throw th;
                                        }
                                    } catch (Throwable th4) {
                                        th = th4;
                                        fileLock = null;
                                        if (fileLock != null) {
                                        }
                                        throw th;
                                    }
                                } catch (Throwable th5) {
                                    th = th5;
                                    mutex = mutex4;
                                    z = z;
                                    try {
                                        throw th;
                                    } catch (Throwable th6) {
                                        try {
                                            kotlin.io.CloseableKt.closeFinally(fileInputStream, th);
                                            throw th6;
                                        } catch (Throwable th7) {
                                            th = th7;
                                            function22 = z;
                                            if (function22 != null) {
                                            }
                                            throw th;
                                        }
                                    }
                                }
                            }
                            return coroutine_suspended;
                        } catch (Throwable th8) {
                            th = th8;
                            mutex = mutex4;
                            function22 = z;
                            if (function22 != null) {
                                mutex.unlock(null);
                            }
                            throw th;
                        }
                    }
                }
                if (r5 == 0) {
                }
            } catch (Throwable th9) {
                z = function22;
                fileInputStream = r5;
                th = th9;
                mutex = mutex;
            }
        } catch (Throwable th10) {
            th = th10;
            if (function22 != null) {
            }
            throw th;
        }
        mutex = new MultiProcessCoordinator$tryLock$1(this, continuation);
        Object obj2 = ((MultiProcessCoordinator$tryLock$1) mutex).result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        r5 = ((MultiProcessCoordinator$tryLock$1) mutex).label;
    }

    private final File getLockFile() {
        return (File) this.lockFile$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final SharedCounter getSharedCounter() {
        return this.lazySharedCounter.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final File fileWithSuffix(String str) {
        return new File(this.file.getAbsolutePath() + str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void createIfNotExists(File file) {
        createParentDirectories(file);
        if (file.exists()) {
            return;
        }
        file.createNewFile();
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

    private final <T> Object withLazyCounter(Function2<? super SharedCounter, ? super Continuation<? super T>, ? extends Object> function2, Continuation<? super T> continuation) {
        if (this.lazySharedCounter.isInitialized()) {
            return function2.invoke(getSharedCounter(), continuation);
        }
        return BuildersKt.withContext(this.context, new MultiProcessCoordinator$withLazyCounter$2(function2, this, null), continuation);
    }

    /* compiled from: MultiProcessCoordinator.android.kt */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0082@¢\u0006\u0002\u0010\fR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u0082D¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Landroidx/datastore/core/MultiProcessCoordinator$Companion;", "", "()V", "DEADLOCK_ERROR_MESSAGE", "", "INITIAL_WAIT_MILLIS", "", "MAX_WAIT_MILLIS", "getExclusiveFileLockWithRetryIfDeadlock", "Ljava/nio/channels/FileLock;", "lockFileStream", "Ljava/io/FileOutputStream;", "(Ljava/io/FileOutputStream;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "datastore-core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Removed duplicated region for block: B:10:0x0025  */
        /* JADX WARN: Removed duplicated region for block: B:14:0x003a  */
        /* JADX WARN: Removed duplicated region for block: B:29:0x0088  */
        /* JADX WARN: Removed duplicated region for block: B:31:0x004c A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:25:0x0081 -> B:27:0x0084). Please submit an issue!!! */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object getExclusiveFileLockWithRetryIfDeadlock(FileOutputStream fileOutputStream, Continuation<? super FileLock> continuation) {
            MultiProcessCoordinator$Companion$getExclusiveFileLockWithRetryIfDeadlock$1 multiProcessCoordinator$Companion$getExclusiveFileLockWithRetryIfDeadlock$1;
            int i;
            long j;
            MultiProcessCoordinator$Companion$getExclusiveFileLockWithRetryIfDeadlock$1 multiProcessCoordinator$Companion$getExclusiveFileLockWithRetryIfDeadlock$12;
            if (continuation instanceof MultiProcessCoordinator$Companion$getExclusiveFileLockWithRetryIfDeadlock$1) {
                multiProcessCoordinator$Companion$getExclusiveFileLockWithRetryIfDeadlock$1 = (MultiProcessCoordinator$Companion$getExclusiveFileLockWithRetryIfDeadlock$1) continuation;
                if ((multiProcessCoordinator$Companion$getExclusiveFileLockWithRetryIfDeadlock$1.label & Integer.MIN_VALUE) != 0) {
                    multiProcessCoordinator$Companion$getExclusiveFileLockWithRetryIfDeadlock$1.label -= Integer.MIN_VALUE;
                    Object obj = multiProcessCoordinator$Companion$getExclusiveFileLockWithRetryIfDeadlock$1.result;
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    i = multiProcessCoordinator$Companion$getExclusiveFileLockWithRetryIfDeadlock$1.label;
                    if (i == 0) {
                        if (i == 1) {
                            j = multiProcessCoordinator$Companion$getExclusiveFileLockWithRetryIfDeadlock$1.J$0;
                            fileOutputStream = (FileOutputStream) multiProcessCoordinator$Companion$getExclusiveFileLockWithRetryIfDeadlock$1.L$0;
                            ResultKt.throwOnFailure(obj);
                            multiProcessCoordinator$Companion$getExclusiveFileLockWithRetryIfDeadlock$12 = multiProcessCoordinator$Companion$getExclusiveFileLockWithRetryIfDeadlock$1;
                            j *= 2;
                            if (j > MultiProcessCoordinator.MAX_WAIT_MILLIS) {
                                try {
                                } catch (IOException e) {
                                    String message = e.getMessage();
                                    if (message == null || !StringsKt.contains$default((CharSequence) message, (CharSequence) MultiProcessCoordinator.DEADLOCK_ERROR_MESSAGE, false, 2, (Object) null)) {
                                        throw e;
                                    }
                                    multiProcessCoordinator$Companion$getExclusiveFileLockWithRetryIfDeadlock$12.L$0 = fileOutputStream;
                                    multiProcessCoordinator$Companion$getExclusiveFileLockWithRetryIfDeadlock$12.J$0 = j;
                                    multiProcessCoordinator$Companion$getExclusiveFileLockWithRetryIfDeadlock$12.label = 1;
                                    if (DelayKt.delay(j, multiProcessCoordinator$Companion$getExclusiveFileLockWithRetryIfDeadlock$12) == coroutine_suspended) {
                                        return coroutine_suspended;
                                    }
                                }
                                FileLock lock = fileOutputStream.getChannel().lock(0L, Long.MAX_VALUE, false);
                                Intrinsics.checkNotNullExpressionValue(lock, "lockFileStream.getChanne…LUE, /* shared= */ false)");
                                return lock;
                            }
                            FileLock lock2 = fileOutputStream.getChannel().lock(0L, Long.MAX_VALUE, false);
                            Intrinsics.checkNotNullExpressionValue(lock2, "lockFileStream.getChanne…LUE, /* shared= */ false)");
                            return lock2;
                        }
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                    j = MultiProcessCoordinator.INITIAL_WAIT_MILLIS;
                    multiProcessCoordinator$Companion$getExclusiveFileLockWithRetryIfDeadlock$12 = multiProcessCoordinator$Companion$getExclusiveFileLockWithRetryIfDeadlock$1;
                    if (j > MultiProcessCoordinator.MAX_WAIT_MILLIS) {
                    }
                }
            }
            multiProcessCoordinator$Companion$getExclusiveFileLockWithRetryIfDeadlock$1 = new MultiProcessCoordinator$Companion$getExclusiveFileLockWithRetryIfDeadlock$1(this, continuation);
            Object obj2 = multiProcessCoordinator$Companion$getExclusiveFileLockWithRetryIfDeadlock$1.result;
            Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            i = multiProcessCoordinator$Companion$getExclusiveFileLockWithRetryIfDeadlock$1.label;
            if (i == 0) {
            }
        }
    }

    @Override // androidx.datastore.core.InterProcessCoordinator
    public Object getVersion(Continuation<? super Integer> continuation) {
        if (this.lazySharedCounter.isInitialized()) {
            return Boxing.boxInt(getSharedCounter().getValue());
        }
        return BuildersKt.withContext(this.context, new MultiProcessCoordinator$getVersion$$inlined$withLazyCounter$1(this, null), continuation);
    }

    @Override // androidx.datastore.core.InterProcessCoordinator
    public Object incrementAndGetVersion(Continuation<? super Integer> continuation) {
        if (this.lazySharedCounter.isInitialized()) {
            return Boxing.boxInt(getSharedCounter().incrementAndGetValue());
        }
        return BuildersKt.withContext(this.context, new MultiProcessCoordinator$incrementAndGetVersion$$inlined$withLazyCounter$1(this, null), continuation);
    }
}
