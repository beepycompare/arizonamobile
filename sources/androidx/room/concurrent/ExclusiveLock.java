package androidx.room.concurrent;

import androidx.exifinterface.media.ExifInterface;
import com.liulishuo.okdownload.core.breakpoint.BreakpointSQLiteKey;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: ExclusiveLock.kt */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\u0010\u0001\n\u0002\b\u0003\b\u0000\u0018\u0000 \u00172\u00020\u0001:\u0001\u0017B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J3\u0010\u000e\u001a\u0002H\u000f\"\u0004\b\u0000\u0010\u000f2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u0002H\u000f0\u00112\u0012\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00150\u0013¢\u0006\u0002\u0010\u0016R\u0014\u0010\b\u001a\u00060\tj\u0002`\nX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u000bR\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Landroidx/room/concurrent/ExclusiveLock;", "", BreakpointSQLiteKey.FILENAME, "", "useFileLock", "", "<init>", "(Ljava/lang/String;Z)V", "threadLock", "Ljava/util/concurrent/locks/ReentrantLock;", "Landroidx/room/concurrent/ReentrantLock;", "Ljava/util/concurrent/locks/ReentrantLock;", "fileLock", "Landroidx/room/concurrent/FileLock;", "withLock", ExifInterface.GPS_DIRECTION_TRUE, "onLocked", "Lkotlin/Function0;", "onLockError", "Lkotlin/Function1;", "", "", "(Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "Companion", "room-runtime_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class ExclusiveLock {
    public static final Companion Companion = new Companion(null);
    private static final Map<String, ReentrantLock> threadLocksMap = new LinkedHashMap();
    private final FileLock fileLock;
    private final ReentrantLock threadLock;

    public ExclusiveLock(String filename, boolean z) {
        Intrinsics.checkNotNullParameter(filename, "filename");
        Companion companion = Companion;
        this.threadLock = companion.getThreadLock(filename);
        this.fileLock = z ? companion.getFileLock(filename) : null;
    }

    public final <T> T withLock(Function0<? extends T> onLocked, Function1 onLockError) {
        Intrinsics.checkNotNullParameter(onLocked, "onLocked");
        Intrinsics.checkNotNullParameter(onLockError, "onLockError");
        this.threadLock.lock();
        boolean z = false;
        try {
            FileLock fileLock = this.fileLock;
            if (fileLock != null) {
                fileLock.lock();
            }
            z = true;
            T invoke = onLocked.invoke();
            FileLock fileLock2 = this.fileLock;
            if (fileLock2 != null) {
                fileLock2.unlock();
            }
            return invoke;
        } catch (Throwable th) {
            try {
                if (z) {
                    throw th;
                }
                onLockError.invoke(th);
                throw new KotlinNothingValueException();
            } finally {
                this.threadLock.unlock();
            }
        }
    }

    /* compiled from: ExclusiveLock.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00060\u0001j\u0002`\u0002B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0019\u0010\n\u001a\u00060\bj\u0002`\t2\u0006\u0010\u000b\u001a\u00020\u0007H\u0002¢\u0006\u0002\u0010\fJ\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000b\u001a\u00020\u0007H\u0002R\u001e\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u0007\u0012\b\u0012\u00060\bj\u0002`\t0\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Landroidx/room/concurrent/ExclusiveLock$Companion;", "", "Landroidx/room/concurrent/SynchronizedObject;", "<init>", "()V", "threadLocksMap", "", "", "Ljava/util/concurrent/locks/ReentrantLock;", "Landroidx/room/concurrent/ReentrantLock;", "getThreadLock", "key", "(Ljava/lang/String;)Ljava/util/concurrent/locks/ReentrantLock;", "getFileLock", "Landroidx/room/concurrent/FileLock;", "room-runtime_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final FileLock getFileLock(String str) {
            return new FileLock(str);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final ReentrantLock getThreadLock(String str) {
            ReentrantLock reentrantLock;
            synchronized (this) {
                Map map = ExclusiveLock.threadLocksMap;
                Object obj = map.get(str);
                if (obj == null) {
                    obj = new ReentrantLock();
                    map.put(str, obj);
                }
                reentrantLock = (ReentrantLock) obj;
            }
            return reentrantLock;
        }
    }
}
