package androidx.room;

import java.util.concurrent.locks.ReentrantLock;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: InvalidationTracker.kt */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0016\n\u0000\n\u0002\u0010\u0018\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0015\n\u0002\b\t\b\u0000\u0018\u00002\u00020\u0001:\u0001#B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J+\u0010\u0012\u001a\u00020\u00132\u0018\u0010\u0014\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00170\u0016\u0012\u0004\u0012\u00020\u00130\u0015H\u0080\bø\u0001\u0000¢\u0006\u0002\b\u0018J\u0015\u0010\u0019\u001a\u00020\u000f2\u0006\u0010\u001a\u001a\u00020\u001bH\u0000¢\u0006\u0002\b\u001cJ\u0015\u0010\u001d\u001a\u00020\u000f2\u0006\u0010\u001a\u001a\u00020\u001bH\u0000¢\u0006\u0002\b\u001eJ\r\u0010\u001f\u001a\u00020\u0013H\u0000¢\u0006\u0002\b J\r\u0010!\u001a\u00020\u0013H\u0000¢\u0006\u0002\b\"R\u0014\u0010\u0006\u001a\u00060\u0007j\u0002`\bX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\tR\u0010\u0010\n\u001a\u00020\u000b8\u0002X\u0083\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u00020\r8\u0002X\u0083\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u000e\u001a\u00020\u000f8\u0002@\u0002X\u0083\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0010\u001a\u00060\u0007j\u0002`\bX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\tR\u0012\u0010\u0011\u001a\u00020\u000f8\u0002@\u0002X\u0083\u000e¢\u0006\u0002\n\u0000\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006$"}, d2 = {"Landroidx/room/ObservedTableStates;", "", "size", "", "<init>", "(I)V", "lock", "Ljava/util/concurrent/locks/ReentrantLock;", "Landroidx/room/concurrent/ReentrantLock;", "Ljava/util/concurrent/locks/ReentrantLock;", "tableObserversCount", "", "tableObservedState", "", "needsSync", "", "onSyncLock", "inProgressSync", "onSync", "", "action", "Lkotlin/Function1;", "", "Landroidx/room/ObservedTableStates$ObserveOp;", "onSync$room_runtime", "onObserverAdded", "tableIds", "", "onObserverAdded$room_runtime", "onObserverRemoved", "onObserverRemoved$room_runtime", "resetTriggerState", "resetTriggerState$room_runtime", "forceNeedSync", "forceNeedSync$room_runtime", "ObserveOp", "room-runtime"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class ObservedTableStates {
    private volatile boolean inProgressSync;
    private volatile boolean needsSync;
    private final boolean[] tableObservedState;
    private final long[] tableObserversCount;
    private final ReentrantLock lock = new ReentrantLock();
    private final ReentrantLock onSyncLock = new ReentrantLock();

    public ObservedTableStates(int i) {
        this.tableObserversCount = new long[i];
        this.tableObservedState = new boolean[i];
    }

    /* JADX WARN: Type inference failed for: r6v0 */
    /* JADX WARN: Type inference failed for: r6v1 */
    /* JADX WARN: Type inference failed for: r6v2, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r6v3 */
    public final void onSync$room_runtime(Function1<? super ObserveOp[], Unit> action) {
        Object[] objArr;
        ObserveOp observeOp;
        Intrinsics.checkNotNullParameter(action, "action");
        ReentrantLock reentrantLock = this.onSyncLock;
        reentrantLock.lock();
        try {
            this.inProgressSync = true;
            ReentrantLock reentrantLock2 = this.lock;
            reentrantLock2.lock();
            ?? r6 = 0;
            r6 = 0;
            if (this.needsSync) {
                this.needsSync = false;
                int length = this.tableObserversCount.length;
                ObserveOp[] observeOpArr = new ObserveOp[length];
                int i = 0;
                Object[] objArr2 = null;
                while (i < length) {
                    boolean z = this.tableObserversCount[i] > 0;
                    if (z != this.tableObservedState[i]) {
                        this.tableObservedState[i] = z;
                        observeOp = z ? ObserveOp.ADD : ObserveOp.REMOVE;
                        objArr = 1;
                    } else {
                        objArr = objArr2;
                        observeOp = ObserveOp.NO_OP;
                    }
                    observeOpArr[i] = observeOp;
                    i++;
                    objArr2 = objArr;
                }
                if (objArr2 != null) {
                    r6 = observeOpArr;
                }
            }
            reentrantLock2.unlock();
            if (r6 != 0 && r6.length != 0) {
                action.invoke(r6);
            }
            this.inProgressSync = false;
            Unit unit = Unit.INSTANCE;
        } finally {
            reentrantLock.unlock();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x0031, code lost:
        if (r12.inProgressSync != false) goto L22;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean onObserverAdded$room_runtime(int[] tableIds) {
        Intrinsics.checkNotNullParameter(tableIds, "tableIds");
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            boolean z = false;
            boolean z2 = false;
            for (int i : tableIds) {
                long[] jArr = this.tableObserversCount;
                long j = jArr[i];
                jArr[i] = 1 + j;
                if (j == 0) {
                    this.needsSync = true;
                    z2 = true;
                }
            }
            if (!z2 && !this.needsSync) {
            }
            z = true;
            return z;
        } finally {
            reentrantLock.unlock();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x0030, code lost:
        if (r14.inProgressSync != false) goto L22;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean onObserverRemoved$room_runtime(int[] tableIds) {
        Intrinsics.checkNotNullParameter(tableIds, "tableIds");
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            boolean z = false;
            boolean z2 = false;
            for (int i : tableIds) {
                long[] jArr = this.tableObserversCount;
                long j = jArr[i];
                jArr[i] = j - 1;
                if (j == 1) {
                    this.needsSync = true;
                    z2 = true;
                }
            }
            if (!z2 && !this.needsSync) {
            }
            z = true;
            return z;
        } finally {
            reentrantLock.unlock();
        }
    }

    public final void resetTriggerState$room_runtime() {
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            ArraysKt.fill$default(this.tableObservedState, false, 0, 0, 6, (Object) null);
            this.needsSync = true;
            Unit unit = Unit.INSTANCE;
        } finally {
            reentrantLock.unlock();
        }
    }

    public final void forceNeedSync$room_runtime() {
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            this.needsSync = true;
            Unit unit = Unit.INSTANCE;
        } finally {
            reentrantLock.unlock();
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* compiled from: InvalidationTracker.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Landroidx/room/ObservedTableStates$ObserveOp;", "", "<init>", "(Ljava/lang/String;I)V", "NO_OP", "ADD", "REMOVE", "room-runtime"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class ObserveOp {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ ObserveOp[] $VALUES;
        public static final ObserveOp NO_OP = new ObserveOp("NO_OP", 0);
        public static final ObserveOp ADD = new ObserveOp("ADD", 1);
        public static final ObserveOp REMOVE = new ObserveOp("REMOVE", 2);

        private static final /* synthetic */ ObserveOp[] $values() {
            return new ObserveOp[]{NO_OP, ADD, REMOVE};
        }

        public static EnumEntries<ObserveOp> getEntries() {
            return $ENTRIES;
        }

        public static ObserveOp valueOf(String str) {
            return (ObserveOp) Enum.valueOf(ObserveOp.class, str);
        }

        public static ObserveOp[] values() {
            return (ObserveOp[]) $VALUES.clone();
        }

        private ObserveOp(String str, int i) {
        }

        static {
            ObserveOp[] $values = $values();
            $VALUES = $values;
            $ENTRIES = EnumEntriesKt.enumEntries($values);
        }
    }
}
