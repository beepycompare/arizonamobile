package androidx.datastore.core;

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
@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\f\b\u0000\u0018\u0000 52\u00020\u0001:\u00015B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J2\u0010\u000f\u001a\u0002H\u0010\"\u0004\b\u0000\u0010\u00102\u001c\u0010\u0011\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00100\u0013\u0012\u0006\u0012\u0004\u0018\u00010\u00140\u0012H\u0096@¢\u0006\u0002\u0010\u0015J8\u0010\u0016\u001a\u0002H\u0010\"\u0004\b\u0000\u0010\u00102\"\u0010\u0011\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020\u0018\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00100\u0013\u0012\u0006\u0012\u0004\u0018\u00010\u00140\u0017H\u0096@¢\u0006\u0002\u0010\u0019J\u000e\u0010\u001a\u001a\u00020\u001bH\u0096@¢\u0006\u0002\u0010\u001cJ\u000e\u0010\u001d\u001a\u00020\u001bH\u0096@¢\u0006\u0002\u0010\u001cJ\u0010\u00100\u001a\u00020\u00052\u0006\u00101\u001a\u00020\u001fH\u0002J\f\u00102\u001a\u00020\f*\u00020\u0005H\u0002J\f\u00103\u001a\u00020\f*\u00020\u0005H\u0002J:\u00104\u001a\u0002H\u0010\"\u0004\b\u0000\u0010\u00102$\b\u0004\u0010\u0011\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020*\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00100\u0013\u0012\u0006\u0012\u0004\u0018\u00010\u00140\u0017H\u0082H¢\u0006\u0002\u0010\u0019R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0004\u001a\u00020\u0005X\u0084\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u000e\u0010\u001e\u001a\u00020\u001fX\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\u001fX\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\u001fX\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020#X\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010$\u001a\u00020\u00058BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b&\u0010'\u001a\u0004\b%\u0010\tR\u0014\u0010(\u001a\b\u0012\u0004\u0012\u00020*0)X\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010+\u001a\u00020*8BX\u0082\u0084\u0002¢\u0006\f\u001a\u0004\b.\u0010/*\u0004\b,\u0010-¨\u00066"}, d2 = {"Landroidx/datastore/core/MultiProcessCoordinator;", "Landroidx/datastore/core/InterProcessCoordinator;", "context", "Lkotlin/coroutines/CoroutineContext;", "file", "Ljava/io/File;", "<init>", "(Lkotlin/coroutines/CoroutineContext;Ljava/io/File;)V", "getFile", "()Ljava/io/File;", "updateNotifications", "Lkotlinx/coroutines/flow/Flow;", "", "getUpdateNotifications", "()Lkotlinx/coroutines/flow/Flow;", "lock", ExifInterface.GPS_DIRECTION_TRUE, "block", "Lkotlin/Function1;", "Lkotlin/coroutines/Continuation;", "", "(Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "tryLock", "Lkotlin/Function2;", "", "(Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getVersion", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "incrementAndGetVersion", "LOCK_SUFFIX", "", "VERSION_SUFFIX", "LOCK_ERROR_MESSAGE", "inMemoryMutex", "Lkotlinx/coroutines/sync/Mutex;", "lockFile", "getLockFile", "lockFile$delegate", "Lkotlin/Lazy;", "lazySharedCounter", "Lkotlin/Lazy;", "Landroidx/datastore/core/SharedCounter;", "sharedCounter", "getSharedCounter$delegate", "(Landroidx/datastore/core/MultiProcessCoordinator;)Ljava/lang/Object;", "getSharedCounter", "()Landroidx/datastore/core/SharedCounter;", "fileWithSuffix", "suffix", "createIfNotExists", "createParentDirectories", "withLazyCounter", "Companion", "datastore-core"}, k = 1, mv = {2, 0, 0}, xi = 48)
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
        this.lockFile$delegate = LazyKt.lazy(new Function0() { // from class: androidx.datastore.core.MultiProcessCoordinator$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return MultiProcessCoordinator.lockFile_delegate$lambda$0(MultiProcessCoordinator.this);
            }
        });
        this.lazySharedCounter = LazyKt.lazy(new Function0() { // from class: androidx.datastore.core.MultiProcessCoordinator$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                SharedCounter create$datastore_core;
                create$datastore_core = SharedCounter.Factory.create$datastore_core(new Function0() { // from class: androidx.datastore.core.MultiProcessCoordinator$$ExternalSyntheticLambda2
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        File lazySharedCounter$lambda$0$0;
                        lazySharedCounter$lambda$0$0 = MultiProcessCoordinator.lazySharedCounter$lambda$0$0(MultiProcessCoordinator.this);
                        return lazySharedCounter$lambda$0$0;
                    }
                });
                return create$datastore_core;
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

    /* JADX WARN: Can't wrap try/catch for region: R(8:1|(3:(5:(2:3|(11:5|6|7|(1:(1:(1:(8:12|13|14|(1:16)|17|18|19|20)(2:32|33))(8:34|35|36|37|38|39|(6:42|(0)|17|18|19|20)|41))(1:50))(1:65)|51|52|53|55|56|(5:58|37|38|39|(0))|41))|55|56|(0)|41)|52|53)|70|6|7|(0)(0)|51|(1:(0))) */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x007c, code lost:
        if (r10.lock(null, r0) == r1) goto L41;
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x00d9, code lost:
        r8 = th;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0027  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x006d  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x009f  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00b5  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00bb A[Catch: all -> 0x00d9, TRY_ENTER, TRY_LEAVE, TryCatch #4 {all -> 0x00d9, blocks: (B:42:0x00bb, B:53:0x00d5, B:56:0x00dc), top: B:68:0x0025 }] */
    /* JADX WARN: Removed duplicated region for block: B:53:0x00d5 A[Catch: all -> 0x00d9, TRY_ENTER, TryCatch #4 {all -> 0x00d9, blocks: (B:42:0x00bb, B:53:0x00d5, B:56:0x00dc), top: B:68:0x0025 }] */
    /* JADX WARN: Type inference failed for: r10v1, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r10v16 */
    /* JADX WARN: Type inference failed for: r10v3, types: [kotlinx.coroutines.sync.Mutex] */
    @Override // androidx.datastore.core.InterProcessCoordinator
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public <T> Object lock(Function1<? super Continuation<? super T>, ? extends Object> function1, Continuation<? super T> continuation) {
        MultiProcessCoordinator$lock$1 multiProcessCoordinator$lock$1;
        Object coroutine_suspended;
        int i;
        Mutex mutex;
        Throwable th;
        Object exclusiveFileLockWithRetryIfDeadlock;
        java.io.Closeable closeable;
        Mutex mutex2;
        Object obj;
        Function1<? super Continuation<? super T>, ? extends Object> function12;
        FileLock fileLock;
        FileLock fileLock2;
        Object invoke;
        Mutex mutex3;
        Object obj2;
        try {
            try {
                try {
                    if (continuation instanceof MultiProcessCoordinator$lock$1) {
                        multiProcessCoordinator$lock$1 = (MultiProcessCoordinator$lock$1) continuation;
                        if ((multiProcessCoordinator$lock$1.label & Integer.MIN_VALUE) != 0) {
                            multiProcessCoordinator$lock$1.label -= Integer.MIN_VALUE;
                            ?? r10 = multiProcessCoordinator$lock$1.result;
                            coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                            i = multiProcessCoordinator$lock$1.label;
                            if (i != 0) {
                                ResultKt.throwOnFailure(r10);
                                mutex = this.inMemoryMutex;
                                multiProcessCoordinator$lock$1.L$0 = function1;
                                multiProcessCoordinator$lock$1.L$1 = mutex;
                                multiProcessCoordinator$lock$1.label = 1;
                            } else if (i != 1) {
                                if (i != 2) {
                                    if (i == 3) {
                                        fileLock = (FileLock) multiProcessCoordinator$lock$1.L$2;
                                        closeable = (java.io.Closeable) multiProcessCoordinator$lock$1.L$1;
                                        mutex3 = (Mutex) multiProcessCoordinator$lock$1.L$0;
                                        try {
                                            ResultKt.throwOnFailure(r10);
                                            obj2 = r10;
                                            if (fileLock != null) {
                                                fileLock.release();
                                            }
                                            try {
                                                kotlin.io.CloseableKt.closeFinally(closeable, null);
                                                mutex3.unlock(null);
                                                return obj2;
                                            } catch (Throwable th2) {
                                                th = th2;
                                                r10 = mutex3;
                                                r10.unlock(null);
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
                                    ResultKt.throwOnFailure(r10);
                                    obj = r10;
                                    fileLock2 = (FileLock) obj;
                                    try {
                                        multiProcessCoordinator$lock$1.L$0 = mutex2;
                                        multiProcessCoordinator$lock$1.L$1 = closeable;
                                        multiProcessCoordinator$lock$1.L$2 = fileLock2;
                                        multiProcessCoordinator$lock$1.label = 3;
                                        invoke = function12.invoke(multiProcessCoordinator$lock$1);
                                        if (invoke != coroutine_suspended) {
                                            mutex3 = mutex2;
                                            fileLock = fileLock2;
                                            obj2 = invoke;
                                            if (fileLock != null) {
                                            }
                                            kotlin.io.CloseableKt.closeFinally(closeable, null);
                                            mutex3.unlock(null);
                                            return obj2;
                                        }
                                        return coroutine_suspended;
                                    } catch (Throwable th4) {
                                        fileLock = fileLock2;
                                        th = th4;
                                        if (fileLock != null) {
                                            fileLock.release();
                                        }
                                        throw th;
                                    }
                                } catch (Throwable th5) {
                                    th = th5;
                                    fileLock = null;
                                    if (fileLock != null) {
                                    }
                                    throw th;
                                }
                            } else {
                                ResultKt.throwOnFailure(r10);
                                mutex = (Mutex) multiProcessCoordinator$lock$1.L$1;
                                function1 = (Function1) multiProcessCoordinator$lock$1.L$0;
                            }
                            FileOutputStream fileOutputStream = new FileOutputStream(getLockFile());
                            FileOutputStream fileOutputStream2 = fileOutputStream;
                            Companion companion = Companion;
                            multiProcessCoordinator$lock$1.L$0 = function1;
                            multiProcessCoordinator$lock$1.L$1 = mutex;
                            multiProcessCoordinator$lock$1.L$2 = fileOutputStream;
                            multiProcessCoordinator$lock$1.label = 2;
                            exclusiveFileLockWithRetryIfDeadlock = companion.getExclusiveFileLockWithRetryIfDeadlock(fileOutputStream2, multiProcessCoordinator$lock$1);
                            if (exclusiveFileLockWithRetryIfDeadlock != coroutine_suspended) {
                                Function1<? super Continuation<? super T>, ? extends Object> function13 = function1;
                                closeable = fileOutputStream;
                                mutex2 = mutex;
                                obj = exclusiveFileLockWithRetryIfDeadlock;
                                function12 = function13;
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
                    }
                    throw th;
                }
                FileOutputStream fileOutputStream22 = fileOutputStream;
            } catch (Throwable th7) {
                th = th7;
                throw th;
            }
            if (i != 0) {
            }
            FileOutputStream fileOutputStream3 = new FileOutputStream(getLockFile());
        } catch (Throwable th8) {
            th = th8;
        }
        multiProcessCoordinator$lock$1 = new MultiProcessCoordinator$lock$1(this, continuation);
        ?? r102 = multiProcessCoordinator$lock$1.result;
        coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = multiProcessCoordinator$lock$1.label;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:10:0x002c  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x005b  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x007d  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00e7 A[Catch: all -> 0x0101, TRY_ENTER, TRY_LEAVE, TryCatch #2 {all -> 0x0101, blocks: (B:59:0x00e7, B:70:0x00fd, B:73:0x0107), top: B:92:0x002a }] */
    /* JADX WARN: Removed duplicated region for block: B:62:0x00ef  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00fd A[Catch: all -> 0x0101, TRY_ENTER, TryCatch #2 {all -> 0x0101, blocks: (B:59:0x00e7, B:70:0x00fd, B:73:0x0107), top: B:92:0x002a }] */
    /* JADX WARN: Removed duplicated region for block: B:86:0x0118  */
    /* JADX WARN: Type inference failed for: r11v0 */
    /* JADX WARN: Type inference failed for: r11v1, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r2v2 */
    /* JADX WARN: Type inference failed for: r2v3 */
    /* JADX WARN: Type inference failed for: r2v4, types: [kotlinx.coroutines.sync.Mutex] */
    /* JADX WARN: Type inference failed for: r9v1 */
    /* JADX WARN: Type inference failed for: r9v2 */
    /* JADX WARN: Type inference failed for: r9v4 */
    @Override // androidx.datastore.core.InterProcessCoordinator
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public <T> Object tryLock(Function2<? super Boolean, ? super Continuation<? super T>, ? extends Object> function2, Continuation<? super T> continuation) {
        MultiProcessCoordinator$tryLock$1 multiProcessCoordinator$tryLock$1;
        Object coroutine_suspended;
        int i;
        boolean z;
        Mutex mutex;
        FileInputStream fileInputStream;
        Throwable th;
        Throwable th2;
        boolean z2;
        FileLock fileLock;
        String message;
        FileLock fileLock2;
        Mutex mutex2;
        java.io.Closeable closeable;
        try {
            if (continuation instanceof MultiProcessCoordinator$tryLock$1) {
                multiProcessCoordinator$tryLock$1 = (MultiProcessCoordinator$tryLock$1) continuation;
                if ((multiProcessCoordinator$tryLock$1.label & Integer.MIN_VALUE) != 0) {
                    multiProcessCoordinator$tryLock$1.label -= Integer.MIN_VALUE;
                    Object obj = multiProcessCoordinator$tryLock$1.result;
                    coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    i = multiProcessCoordinator$tryLock$1.label;
                    if (i == 0) {
                        if (i == 1) {
                            z2 = multiProcessCoordinator$tryLock$1.Z$0;
                            mutex = (Mutex) multiProcessCoordinator$tryLock$1.L$0;
                            try {
                                ResultKt.throwOnFailure(obj);
                                if (z2) {
                                    mutex.unlock(null);
                                }
                                return obj;
                            } catch (Throwable th3) {
                                th2 = th3;
                                if (z2) {
                                }
                                throw th2;
                            }
                        } else if (i == 2) {
                            z2 = multiProcessCoordinator$tryLock$1.Z$0;
                            fileLock = (FileLock) multiProcessCoordinator$tryLock$1.L$2;
                            closeable = (java.io.Closeable) multiProcessCoordinator$tryLock$1.L$1;
                            mutex2 = (Mutex) multiProcessCoordinator$tryLock$1.L$0;
                            try {
                                ResultKt.throwOnFailure(obj);
                                if (fileLock != null) {
                                    fileLock.release();
                                }
                                try {
                                    kotlin.io.CloseableKt.closeFinally(closeable, null);
                                    if (z2) {
                                        mutex2.unlock(null);
                                    }
                                    return obj;
                                } catch (Throwable th4) {
                                    th2 = th4;
                                    mutex = mutex2;
                                    if (z2) {
                                    }
                                    throw th2;
                                }
                            } catch (Throwable th5) {
                                th = th5;
                                if (fileLock != null) {
                                }
                                throw th;
                            }
                        } else {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                    }
                    ResultKt.throwOnFailure(obj);
                    Mutex mutex3 = this.inMemoryMutex;
                    z = mutex3.tryLock(null);
                    try {
                        if (z == 0) {
                            Boolean boxBoolean = Boxing.boxBoolean(false);
                            multiProcessCoordinator$tryLock$1.L$0 = mutex3;
                            multiProcessCoordinator$tryLock$1.Z$0 = z;
                            multiProcessCoordinator$tryLock$1.label = 1;
                            obj = function2.invoke(boxBoolean, multiProcessCoordinator$tryLock$1);
                            if (obj != coroutine_suspended) {
                                mutex = mutex3;
                                z2 = z;
                                if (z2) {
                                }
                                return obj;
                            }
                        } else {
                            FileInputStream fileInputStream2 = new FileInputStream(getLockFile());
                            try {
                                try {
                                    try {
                                        fileLock2 = fileInputStream2.getChannel().tryLock(0L, Long.MAX_VALUE, true);
                                    } catch (IOException e) {
                                        String message2 = e.getMessage();
                                        if ((message2 == null || !StringsKt.startsWith$default(message2, this.LOCK_ERROR_MESSAGE, false, 2, (Object) null)) && ((message = e.getMessage()) == null || !StringsKt.startsWith$default(message, DEADLOCK_ERROR_MESSAGE, false, 2, (Object) null))) {
                                            throw e;
                                        }
                                        fileLock2 = null;
                                    }
                                } catch (Throwable th6) {
                                    th = th6;
                                    fileLock = null;
                                    if (fileLock != null) {
                                        fileLock.release();
                                    }
                                    throw th;
                                }
                                try {
                                    Boolean boxBoolean2 = Boxing.boxBoolean(fileLock2 != null);
                                    multiProcessCoordinator$tryLock$1.L$0 = mutex3;
                                    multiProcessCoordinator$tryLock$1.L$1 = fileInputStream2;
                                    multiProcessCoordinator$tryLock$1.L$2 = fileLock2;
                                    multiProcessCoordinator$tryLock$1.Z$0 = z;
                                    multiProcessCoordinator$tryLock$1.label = 2;
                                    obj = function2.invoke(boxBoolean2, multiProcessCoordinator$tryLock$1);
                                    if (obj != coroutine_suspended) {
                                        fileLock = fileLock2;
                                        mutex2 = mutex3;
                                        z2 = z;
                                        closeable = fileInputStream2;
                                        if (fileLock != null) {
                                        }
                                        kotlin.io.CloseableKt.closeFinally(closeable, null);
                                        if (z2) {
                                        }
                                        return obj;
                                    }
                                } catch (Throwable th7) {
                                    th = th7;
                                    fileLock = fileLock2;
                                    if (fileLock != null) {
                                    }
                                    throw th;
                                }
                            } catch (Throwable th8) {
                                th = th8;
                                mutex = mutex3;
                                z = z;
                                fileInputStream = fileInputStream2;
                                try {
                                    throw th;
                                } catch (Throwable th9) {
                                    try {
                                        kotlin.io.CloseableKt.closeFinally(fileInputStream, th);
                                        throw th9;
                                    } catch (Throwable th10) {
                                        th2 = th10;
                                        z2 = z;
                                        if (z2) {
                                            mutex.unlock(null);
                                        }
                                        throw th2;
                                    }
                                }
                            }
                        }
                        return coroutine_suspended;
                    } catch (Throwable th11) {
                        th2 = th11;
                        mutex = mutex3;
                        z2 = z;
                        if (z2) {
                        }
                        throw th2;
                    }
                }
            }
            if (i == 0) {
            }
        } catch (Throwable th12) {
            z = this;
            mutex = multiProcessCoordinator$tryLock$1;
            fileInputStream = coroutine_suspended;
            th = th12;
        }
        multiProcessCoordinator$tryLock$1 = new MultiProcessCoordinator$tryLock$1(this, continuation);
        Object obj2 = multiProcessCoordinator$tryLock$1.result;
        coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = multiProcessCoordinator$tryLock$1.label;
    }

    private final File getLockFile() {
        return (File) this.lockFile$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final File lockFile_delegate$lambda$0(MultiProcessCoordinator multiProcessCoordinator) {
        File fileWithSuffix = multiProcessCoordinator.fileWithSuffix(multiProcessCoordinator.LOCK_SUFFIX);
        multiProcessCoordinator.createIfNotExists(fileWithSuffix);
        return fileWithSuffix;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final File lazySharedCounter$lambda$0$0(MultiProcessCoordinator multiProcessCoordinator) {
        File fileWithSuffix = multiProcessCoordinator.fileWithSuffix(multiProcessCoordinator.VERSION_SUFFIX);
        multiProcessCoordinator.createIfNotExists(fileWithSuffix);
        return fileWithSuffix;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final SharedCounter getSharedCounter() {
        return this.lazySharedCounter.getValue();
    }

    private final File fileWithSuffix(String str) {
        return new File(this.file.getAbsolutePath() + str);
    }

    private final void createIfNotExists(File file) {
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
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0082@¢\u0006\u0002\u0010\bR\u000e\u0010\t\u001a\u00020\nX\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\fX\u0082D¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Landroidx/datastore/core/MultiProcessCoordinator$Companion;", "", "<init>", "()V", "getExclusiveFileLockWithRetryIfDeadlock", "Ljava/nio/channels/FileLock;", "lockFileStream", "Ljava/io/FileOutputStream;", "(Ljava/io/FileOutputStream;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "DEADLOCK_ERROR_MESSAGE", "", "INITIAL_WAIT_MILLIS", "", "MAX_WAIT_MILLIS", "datastore-core"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
        /* JADX WARN: Removed duplicated region for block: B:14:0x0039  */
        /* JADX WARN: Removed duplicated region for block: B:29:0x0089  */
        /* JADX WARN: Removed duplicated region for block: B:31:0x004b A[EXC_TOP_SPLITTER, SYNTHETIC] */
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
                                Intrinsics.checkNotNullExpressionValue(lock, "lock(...)");
                                return lock;
                            }
                            FileLock lock2 = fileOutputStream.getChannel().lock(0L, Long.MAX_VALUE, false);
                            Intrinsics.checkNotNullExpressionValue(lock2, "lock(...)");
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
