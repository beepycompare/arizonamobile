package androidx.room;

import com.facebook.internal.NativeProtocol;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: InvalidationTracker.kt */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0016\n\u0000\n\u0002\u0010\u0018\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0015\n\u0002\b\n\b\u0000\u0018\u00002\u00020\u0001:\u0002\"#B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J+\u0010\u0011\u001a\u00020\u00122\u0018\u0010\u0013\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00160\u0015\u0012\u0004\u0012\u00020\u00100\u0014H\u0080\bø\u0001\u0000¢\u0006\u0002\b\u0017J\u0015\u0010\u0018\u001a\u00020\u00102\u0006\u0010\u0019\u001a\u00020\u001aH\u0000¢\u0006\u0002\b\u001bJ\u0015\u0010\u001c\u001a\u00020\u00102\u0006\u0010\u0019\u001a\u00020\u001aH\u0000¢\u0006\u0002\b\u001dJ\r\u0010\u001e\u001a\u00020\u0012H\u0000¢\u0006\u0002\b\u001fJ\r\u0010 \u001a\u00020\u0012H\u0000¢\u0006\u0002\b!R\u0014\u0010\u0006\u001a\u00060\u0007j\u0002`\bX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\tR\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006$"}, d2 = {"Landroidx/room/ObservedTableStates;", "", "size", "", "<init>", "(I)V", "lock", "Ljava/util/concurrent/locks/ReentrantLock;", "Landroidx/room/concurrent/ReentrantLock;", "Ljava/util/concurrent/locks/ReentrantLock;", "tableObserversCount", "", "tableObservedState", "", NativeProtocol.PLATFORM_PROVIDER_VERSION_COLUMN, "needsSync", "", "onSync", "", "action", "Lkotlin/Function1;", "", "Landroidx/room/ObservedTableStates$ObserveOp;", "onSync$room_runtime", "onObserverAdded", "tableIds", "", "onObserverAdded$room_runtime", "onObserverRemoved", "onObserverRemoved$room_runtime", "resetTriggerState", "resetTriggerState$room_runtime", "forceNeedSync", "forceNeedSync$room_runtime", "ObserveOp", "SyncState", "room-runtime"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class ObservedTableStates {
    private final ReentrantLock lock = new ReentrantLock();
    private volatile boolean needsSync;
    private final boolean[] tableObservedState;
    private final long[] tableObserversCount;
    private volatile int version;

    public ObservedTableStates(int i) {
        this.tableObserversCount = new long[i];
        this.tableObservedState = new boolean[i];
    }

    public final void onSync$room_runtime(Function1<? super ObserveOp[], Boolean> action) {
        ObserveOp observeOp;
        Intrinsics.checkNotNullParameter(action, "action");
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            if (this.needsSync) {
                int i = this.version;
                boolean[] zArr = new boolean[this.tableObserversCount.length];
                int length = this.tableObserversCount.length;
                ObserveOp[] observeOpArr = new ObserveOp[length];
                int i2 = 0;
                boolean z = false;
                while (i2 < length) {
                    boolean z2 = true;
                    boolean z3 = this.tableObserversCount[i2] > 0;
                    if (z3 != this.tableObservedState[i2]) {
                        zArr[i2] = z3;
                        observeOp = z3 ? ObserveOp.ADD : ObserveOp.REMOVE;
                    } else {
                        z2 = z;
                        observeOp = ObserveOp.NO_OP;
                    }
                    observeOpArr[i2] = observeOp;
                    i2++;
                    z = z2;
                }
                if (z) {
                    SyncState syncState = new SyncState(i, observeOpArr, zArr);
                    reentrantLock.unlock();
                    if (action.invoke(syncState.getOps()).booleanValue()) {
                        this.lock.lock();
                        try {
                            if (this.needsSync && syncState.getVersion() == this.version) {
                                ArraysKt.copyInto$default(syncState.getNewStates(), this.tableObservedState, 0, 0, 0, 14, (Object) null);
                                this.needsSync = false;
                            }
                            Unit unit = Unit.INSTANCE;
                        } finally {
                        }
                    }
                }
            }
        } finally {
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x0032, code lost:
        if (r12.needsSync != false) goto L20;
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
                    this.version++;
                    this.needsSync = true;
                    z2 = true;
                }
            }
            if (!z2) {
            }
            z = true;
            return z;
        } finally {
            reentrantLock.unlock();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x0031, code lost:
        if (r14.needsSync != false) goto L20;
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
                    this.version++;
                    this.needsSync = true;
                    z2 = true;
                }
            }
            if (!z2) {
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

    /* compiled from: InvalidationTracker.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0018\n\u0002\b\n\b\u0000\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0019\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u0012"}, d2 = {"Landroidx/room/ObservedTableStates$SyncState;", "", NativeProtocol.PLATFORM_PROVIDER_VERSION_COLUMN, "", "ops", "", "Landroidx/room/ObservedTableStates$ObserveOp;", "newStates", "", "<init>", "(I[Landroidx/room/ObservedTableStates$ObserveOp;[Z)V", "getVersion", "()I", "getOps", "()[Landroidx/room/ObservedTableStates$ObserveOp;", "[Landroidx/room/ObservedTableStates$ObserveOp;", "getNewStates", "()[Z", "room-runtime"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class SyncState {
        private final boolean[] newStates;
        private final ObserveOp[] ops;
        private final int version;

        public SyncState(int i, ObserveOp[] ops, boolean[] newStates) {
            Intrinsics.checkNotNullParameter(ops, "ops");
            Intrinsics.checkNotNullParameter(newStates, "newStates");
            this.version = i;
            this.ops = ops;
            this.newStates = newStates;
        }

        public final int getVersion() {
            return this.version;
        }

        public final ObserveOp[] getOps() {
            return this.ops;
        }

        public final boolean[] getNewStates() {
            return this.newStates;
        }
    }
}
