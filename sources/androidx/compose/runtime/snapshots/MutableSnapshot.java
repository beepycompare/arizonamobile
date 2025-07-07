package androidx.compose.runtime.snapshots;

import androidx.collection.MutableScatterSet;
import androidx.collection.ScatterSetKt;
import androidx.compose.runtime.PreconditionsKt;
import androidx.compose.runtime.collection.ScatterSetWrapperKt;
import androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentList;
import androidx.compose.runtime.snapshots.SnapshotApplyResult;
import androidx.compose.runtime.snapshots.tooling.SnapshotInstanceObservers;
import androidx.compose.runtime.snapshots.tooling.SnapshotObserver;
import androidx.compose.runtime.snapshots.tooling.SnapshotObserverKt;
import androidx.exifinterface.media.ExifInterface;
import com.google.firebase.remoteconfig.RemoteConfigConstants;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: Snapshot.kt */
@Metadata(d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u0015\n\u0002\b\f\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u001f\b\u0017\u0018\u0000 j2\u00020\u0001:\u0001jBG\b\u0000\u0012\n\u0010\u0002\u001a\u00060\u0003j\u0002`\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0014\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n\u0018\u00010\b\u0012\u0014\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n\u0018\u00010\b¢\u0006\u0002\u0010\fJ\b\u0010;\u001a\u00020\nH\u0002J\r\u0010<\u001a\u00020\nH\u0000¢\u0006\u0002\b=J$\u0010<\u001a\u0002H>\"\u0004\b\u0000\u0010>2\f\u0010?\u001a\b\u0012\u0004\u0012\u0002H>0@H\u0080\b¢\u0006\u0004\b=\u0010AJ\b\u0010B\u001a\u00020CH\u0016J\r\u0010D\u001a\u00020\nH\u0010¢\u0006\u0002\bEJ\b\u0010F\u001a\u00020\nH\u0016J\b\u0010G\u001a\u00020\u000eH\u0016JE\u0010H\u001a\u00020C2\n\u0010I\u001a\u00060\u0003j\u0002`\u00042\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00150\u001b2\u0014\u0010J\u001a\u0010\u0012\u0004\u0012\u00020L\u0012\u0004\u0012\u00020L\u0018\u00010K2\u0006\u0010M\u001a\u00020\u0006H\u0000¢\u0006\u0002\bNJ\u0015\u0010O\u001a\u00020\n2\u0006\u0010P\u001a\u00020\u0001H\u0010¢\u0006\u0002\bQJ\u0015\u0010R\u001a\u00020\n2\u0006\u0010P\u001a\u00020\u0001H\u0010¢\u0006\u0002\bSJ\r\u0010T\u001a\u00020\nH\u0010¢\u0006\u0002\bUJ\u0015\u0010V\u001a\u00020\n2\u0006\u0010W\u001a\u00020\u0015H\u0010¢\u0006\u0002\bXJ\u0019\u0010Y\u001a\u00020\n2\n\u0010Z\u001a\u00060\u0003j\u0002`\u0004H\u0000¢\u0006\u0002\b[J\u0015\u0010\\\u001a\u00020\n2\u0006\u00103\u001a\u00020\u0006H\u0000¢\u0006\u0002\b]J\u0015\u0010^\u001a\u00020\n2\u0006\u0010Z\u001a\u000204H\u0000¢\u0006\u0002\b_J\u0015\u0010`\u001a\u00020\n2\u0006\u0010a\u001a\u00020'H\u0000¢\u0006\u0002\bbJ\r\u0010c\u001a\u00020\nH\u0010¢\u0006\u0002\bdJ\b\u0010e\u001a\u00020\nH\u0002J8\u0010f\u001a\u00020\u00002\u0016\b\u0002\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n\u0018\u00010\b2\u0016\b\u0002\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n\u0018\u00010\bH\u0016J\u001e\u0010g\u001a\u00020\u00012\u0014\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n\u0018\u00010\bH\u0016J\b\u0010h\u001a\u00020\nH\u0002J\b\u0010i\u001a\u00020\nH\u0002R\u001a\u0010\r\u001a\u00020\u000eX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\"\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u0014X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R4\u0010\u001c\u001a\n\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u001b2\u000e\u0010\u001a\u001a\n\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u001b@VX\u0090\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u001a\u0010!\u001a\u00020\u0006X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R\u001a\u0010&\u001a\u00020'X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R\"\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n\u0018\u00010\bX\u0090\u0004¢\u0006\b\n\u0000\u001a\u0004\b,\u0010-R\u0014\u0010.\u001a\u00020\u000e8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b/\u0010\u0010R\u0014\u00100\u001a\u00020\u00018VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b1\u00102R\u000e\u00103\u001a\u000204X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u00105\u001a\u000204X\u0090\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b6\u00107\"\u0004\b8\u00109R\"\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n\u0018\u00010\bX\u0090\u0004¢\u0006\b\n\u0000\u001a\u0004\b:\u0010-¨\u0006k"}, d2 = {"Landroidx/compose/runtime/snapshots/MutableSnapshot;", "Landroidx/compose/runtime/snapshots/Snapshot;", "snapshotId", "", "Landroidx/compose/runtime/snapshots/SnapshotId;", "invalid", "Landroidx/compose/runtime/snapshots/SnapshotIdSet;", "readObserver", "Lkotlin/Function1;", "", "", "writeObserver", "(JLandroidx/compose/runtime/snapshots/SnapshotIdSet;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)V", "applied", "", "getApplied$runtime_release", "()Z", "setApplied$runtime_release", "(Z)V", "merged", "", "Landroidx/compose/runtime/snapshots/StateObject;", "getMerged$runtime_release", "()Ljava/util/List;", "setMerged$runtime_release", "(Ljava/util/List;)V", "<set-?>", "Landroidx/collection/MutableScatterSet;", "modified", "getModified$runtime_release", "()Landroidx/collection/MutableScatterSet;", "setModified", "(Landroidx/collection/MutableScatterSet;)V", "previousIds", "getPreviousIds$runtime_release", "()Landroidx/compose/runtime/snapshots/SnapshotIdSet;", "setPreviousIds$runtime_release", "(Landroidx/compose/runtime/snapshots/SnapshotIdSet;)V", "previousPinnedSnapshots", "", "getPreviousPinnedSnapshots$runtime_release", "()[I", "setPreviousPinnedSnapshots$runtime_release", "([I)V", "getReadObserver$runtime_release", "()Lkotlin/jvm/functions/Function1;", "readOnly", "getReadOnly", "root", "getRoot", "()Landroidx/compose/runtime/snapshots/Snapshot;", "snapshots", "", "writeCount", "getWriteCount$runtime_release", "()I", "setWriteCount$runtime_release", "(I)V", "getWriteObserver$runtime_release", "abandon", "advance", "advance$runtime_release", ExifInterface.GPS_DIRECTION_TRUE, "block", "Lkotlin/Function0;", "(Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "apply", "Landroidx/compose/runtime/snapshots/SnapshotApplyResult;", "closeLocked", "closeLocked$runtime_release", "dispose", "hasPendingChanges", "innerApplyLocked", "nextId", "optimisticMerges", "", "Landroidx/compose/runtime/snapshots/StateRecord;", "invalidSnapshots", "innerApplyLocked$runtime_release", "nestedActivated", "snapshot", "nestedActivated$runtime_release", "nestedDeactivated", "nestedDeactivated$runtime_release", "notifyObjectsInitialized", "notifyObjectsInitialized$runtime_release", "recordModified", RemoteConfigConstants.ResponseFieldKey.STATE, "recordModified$runtime_release", "recordPrevious", "id", "recordPrevious$runtime_release", "recordPreviousList", "recordPreviousList$runtime_release", "recordPreviousPinnedSnapshot", "recordPreviousPinnedSnapshot$runtime_release", "recordPreviousPinnedSnapshots", "handles", "recordPreviousPinnedSnapshots$runtime_release", "releasePinnedSnapshotsForCloseLocked", "releasePinnedSnapshotsForCloseLocked$runtime_release", "releasePreviouslyPinnedSnapshotsLocked", "takeNestedMutableSnapshot", "takeNestedSnapshot", "validateNotApplied", "validateNotAppliedOrPinned", "Companion", "runtime_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes.dex */
public class MutableSnapshot extends Snapshot {
    private boolean applied;
    private List<? extends StateObject> merged;
    private MutableScatterSet<StateObject> modified;
    private SnapshotIdSet previousIds;
    private int[] previousPinnedSnapshots;
    private final Function1<Object, Unit> readObserver;
    private int snapshots;
    private int writeCount;
    private final Function1<Object, Unit> writeObserver;
    private static final Companion Companion = new Companion(null);
    public static final int $stable = 8;
    private static final int[] EmptyIntArray = new int[0];

    @Override // androidx.compose.runtime.snapshots.Snapshot
    public boolean getReadOnly() {
        return false;
    }

    @Override // androidx.compose.runtime.snapshots.Snapshot
    /* renamed from: getReadObserver$runtime_release */
    public Function1<Object, Unit> getReadObserver() {
        return this.readObserver;
    }

    @Override // androidx.compose.runtime.snapshots.Snapshot
    public Function1<Object, Unit> getWriteObserver$runtime_release() {
        return this.writeObserver;
    }

    public MutableSnapshot(long j, SnapshotIdSet snapshotIdSet, Function1<Object, Unit> function1, Function1<Object, Unit> function12) {
        super(j, snapshotIdSet, (DefaultConstructorMarker) null);
        this.readObserver = function1;
        this.writeObserver = function12;
        this.previousIds = SnapshotIdSet.Companion.getEMPTY();
        this.previousPinnedSnapshots = EmptyIntArray;
        this.snapshots = 1;
    }

    @Override // androidx.compose.runtime.snapshots.Snapshot
    public boolean hasPendingChanges() {
        MutableScatterSet<StateObject> modified$runtime_release = getModified$runtime_release();
        return modified$runtime_release != null && modified$runtime_release.isNotEmpty();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ MutableSnapshot takeNestedMutableSnapshot$default(MutableSnapshot mutableSnapshot, Function1 function1, Function1 function12, int i, Object obj) {
        if (obj == null) {
            if ((i & 1) != 0) {
                function1 = null;
            }
            if ((i & 2) != 0) {
                function12 = null;
            }
            return mutableSnapshot.takeNestedMutableSnapshot(function1, function12);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: takeNestedMutableSnapshot");
    }

    public MutableSnapshot takeNestedMutableSnapshot(Function1<Object, Unit> function1, Function1<Object, Unit> function12) {
        Function1<Object, Unit> function13;
        Function1<Object, Unit> function14;
        Map<SnapshotObserver, SnapshotInstanceObservers> map;
        long j;
        long j2;
        SnapshotIdSet snapshotIdSet;
        NestedMutableSnapshot nestedMutableSnapshot;
        Function1 mergedWriteObserver;
        long j3;
        long j4;
        SnapshotIdSet snapshotIdSet2;
        validateNotDisposed$runtime_release();
        validateNotAppliedOrPinned();
        PersistentList access$getObservers$p = SnapshotObserverKt.access$getObservers$p();
        if (access$getObservers$p != null) {
            Pair<SnapshotInstanceObservers, Map<SnapshotObserver, SnapshotInstanceObservers>> mergeObservers = SnapshotObserverKt.mergeObservers(access$getObservers$p, this, false, function1, function12);
            SnapshotInstanceObservers first = mergeObservers.getFirst();
            Function1<Object, Unit> readObserver = first.getReadObserver();
            function14 = first.getWriteObserver();
            function13 = readObserver;
            map = mergeObservers.getSecond();
        } else {
            function13 = function1;
            function14 = function12;
            map = null;
        }
        recordPrevious$runtime_release(getSnapshotId());
        synchronized (SnapshotKt.getLock()) {
            j = SnapshotKt.nextSnapshotId;
            j2 = SnapshotKt.nextSnapshotId;
            SnapshotKt.nextSnapshotId = j2 + 1;
            snapshotIdSet = SnapshotKt.openSnapshots;
            SnapshotKt.openSnapshots = snapshotIdSet.set(j);
            SnapshotIdSet invalid$runtime_release = getInvalid$runtime_release();
            setInvalid$runtime_release(invalid$runtime_release.set(j));
            SnapshotIdSet addRange = SnapshotKt.addRange(invalid$runtime_release, getSnapshotId() + 1, j);
            Function1 mergedReadObserver$default = SnapshotKt.mergedReadObserver$default(function13, getReadObserver(), false, 4, null);
            mergedWriteObserver = SnapshotKt.mergedWriteObserver(function14, getWriteObserver$runtime_release());
            nestedMutableSnapshot = new NestedMutableSnapshot(j, addRange, mergedReadObserver$default, mergedWriteObserver, this);
        }
        if (!getApplied$runtime_release() && !getDisposed$runtime_release()) {
            long snapshotId = getSnapshotId();
            synchronized (SnapshotKt.getLock()) {
                j3 = SnapshotKt.nextSnapshotId;
                j4 = SnapshotKt.nextSnapshotId;
                SnapshotKt.nextSnapshotId = j4 + 1;
                setSnapshotId$runtime_release(j3);
                snapshotIdSet2 = SnapshotKt.openSnapshots;
                SnapshotKt.openSnapshots = snapshotIdSet2.set(getSnapshotId());
                Unit unit = Unit.INSTANCE;
            }
            setInvalid$runtime_release(SnapshotKt.addRange(getInvalid$runtime_release(), snapshotId + 1, getSnapshotId()));
        }
        NestedMutableSnapshot nestedMutableSnapshot2 = nestedMutableSnapshot;
        if (access$getObservers$p != null) {
            SnapshotObserverKt.dispatchCreatedObservers(access$getObservers$p, this, nestedMutableSnapshot2, map);
        }
        return nestedMutableSnapshot2;
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x00a2  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00e1 A[LOOP:1: B:37:0x00df->B:38:0x00e1, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:59:0x0151 A[Catch: all -> 0x01b0, TryCatch #0 {, blocks: (B:41:0x00fb, B:43:0x010b, B:46:0x0119, B:48:0x0125, B:50:0x012f, B:52:0x0135, B:53:0x0140, B:59:0x0151, B:62:0x015d, B:64:0x0167, B:66:0x0171, B:68:0x0177, B:69:0x0181, B:72:0x0189, B:73:0x018c, B:75:0x0190, B:77:0x019a, B:78:0x01a6, B:56:0x0148), top: B:88:0x00fb }] */
    /* JADX WARN: Removed duplicated region for block: B:75:0x0190 A[Catch: all -> 0x01b0, TryCatch #0 {, blocks: (B:41:0x00fb, B:43:0x010b, B:46:0x0119, B:48:0x0125, B:50:0x012f, B:52:0x0135, B:53:0x0140, B:59:0x0151, B:62:0x015d, B:64:0x0167, B:66:0x0171, B:68:0x0177, B:69:0x0181, B:72:0x0189, B:73:0x018c, B:75:0x0190, B:77:0x019a, B:78:0x01a6, B:56:0x0148), top: B:88:0x00fb }] */
    /* JADX WARN: Removed duplicated region for block: B:88:0x00fb A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public SnapshotApplyResult apply() {
        Map<StateRecord, ? extends StateRecord> map;
        GlobalSnapshot globalSnapshot;
        Function1 function1;
        List list;
        MutableScatterSet<StateObject> mutableScatterSet;
        List list2;
        long j;
        long j2;
        List<? extends StateObject> list3;
        int size;
        int i;
        GlobalSnapshot globalSnapshot2;
        long j3;
        SnapshotIdSet snapshotIdSet;
        Function1 function12;
        GlobalSnapshot globalSnapshot3;
        SnapshotIdSet snapshotIdSet2;
        Map<StateRecord, ? extends StateRecord> optimisticMerges;
        MutableScatterSet<StateObject> modified$runtime_release = getModified$runtime_release();
        if (modified$runtime_release != null) {
            globalSnapshot3 = SnapshotKt.globalSnapshot;
            long snapshotId = globalSnapshot3.getSnapshotId();
            snapshotIdSet2 = SnapshotKt.openSnapshots;
            optimisticMerges = SnapshotKt.optimisticMerges(snapshotId, this, snapshotIdSet2.clear(globalSnapshot3.getSnapshotId()));
            map = optimisticMerges;
        } else {
            map = null;
        }
        List emptyList = CollectionsKt.emptyList();
        synchronized (SnapshotKt.getLock()) {
            SnapshotKt.validateOpen(this);
            if (modified$runtime_release != null && modified$runtime_release.getSize() != 0) {
                globalSnapshot2 = SnapshotKt.globalSnapshot;
                j3 = SnapshotKt.nextSnapshotId;
                snapshotIdSet = SnapshotKt.openSnapshots;
                SnapshotApplyResult innerApplyLocked$runtime_release = innerApplyLocked$runtime_release(j3, modified$runtime_release, map, snapshotIdSet.clear(globalSnapshot2.getSnapshotId()));
                if (Intrinsics.areEqual(innerApplyLocked$runtime_release, SnapshotApplyResult.Success.INSTANCE)) {
                    closeLocked$runtime_release();
                    mutableScatterSet = globalSnapshot2.getModified$runtime_release();
                    function12 = SnapshotKt.emptyLambda;
                    SnapshotKt.resetGlobalSnapshotLocked(globalSnapshot2, function12);
                    setModified(null);
                    globalSnapshot2.setModified(null);
                    list = SnapshotKt.applyObservers;
                    Unit unit = Unit.INSTANCE;
                    this.applied = true;
                    if (mutableScatterSet != null) {
                        Set wrapIntoSet = ScatterSetWrapperKt.wrapIntoSet(mutableScatterSet);
                        if (!wrapIntoSet.isEmpty()) {
                            int size2 = list.size();
                            for (int i2 = 0; i2 < size2; i2++) {
                                ((Function2) list.get(i2)).invoke(wrapIntoSet, this);
                            }
                        }
                    }
                    if (modified$runtime_release != null && modified$runtime_release.isNotEmpty()) {
                        Set wrapIntoSet2 = ScatterSetWrapperKt.wrapIntoSet(modified$runtime_release);
                        size = list.size();
                        for (i = 0; i < size; i++) {
                            ((Function2) list.get(i)).invoke(wrapIntoSet2, this);
                        }
                    }
                    SnapshotObserverKt.dispatchObserverOnApplied(this, modified$runtime_release);
                    synchronized (SnapshotKt.getLock()) {
                        releasePinnedSnapshotsForCloseLocked$runtime_release();
                        SnapshotKt.checkAndOverwriteUnusedRecordsLocked();
                        if (mutableScatterSet != null) {
                            MutableScatterSet<StateObject> mutableScatterSet2 = mutableScatterSet;
                            Object[] objArr = mutableScatterSet2.elements;
                            long[] jArr = mutableScatterSet2.metadata;
                            int length = jArr.length - 2;
                            if (length >= 0) {
                                int i3 = 0;
                                j = 128;
                                while (true) {
                                    long j4 = jArr[i3];
                                    j2 = 255;
                                    if ((((~j4) << 7) & j4 & (-9187201950435737472L)) != -9187201950435737472L) {
                                        int i4 = 8 - ((~(i3 - length)) >>> 31);
                                        for (int i5 = 0; i5 < i4; i5++) {
                                            if ((j4 & 255) < 128) {
                                                SnapshotKt.processForUnusedRecordsLocked((StateObject) objArr[(i3 << 3) + i5]);
                                            }
                                            j4 >>= 8;
                                        }
                                        if (i4 != 8) {
                                            break;
                                        }
                                    }
                                    if (i3 == length) {
                                        break;
                                    }
                                    i3++;
                                }
                                if (modified$runtime_release != null) {
                                    MutableScatterSet<StateObject> mutableScatterSet3 = modified$runtime_release;
                                    Object[] objArr2 = mutableScatterSet3.elements;
                                    long[] jArr2 = mutableScatterSet3.metadata;
                                    int length2 = jArr2.length - 2;
                                    if (length2 >= 0) {
                                        int i6 = 0;
                                        while (true) {
                                            long j5 = jArr2[i6];
                                            if ((((~j5) << 7) & j5 & (-9187201950435737472L)) != -9187201950435737472L) {
                                                int i7 = 8 - ((~(i6 - length2)) >>> 31);
                                                for (int i8 = 0; i8 < i7; i8++) {
                                                    if ((j5 & j2) < j) {
                                                        SnapshotKt.processForUnusedRecordsLocked((StateObject) objArr2[(i6 << 3) + i8]);
                                                    }
                                                    j5 >>= 8;
                                                }
                                                if (i7 != 8) {
                                                    break;
                                                }
                                            }
                                            if (i6 == length2) {
                                                break;
                                            }
                                            i6++;
                                        }
                                    }
                                }
                                list3 = this.merged;
                                if (list3 != null) {
                                    int size3 = list3.size();
                                    for (int i9 = 0; i9 < size3; i9++) {
                                        SnapshotKt.processForUnusedRecordsLocked(list3.get(i9));
                                    }
                                }
                                this.merged = null;
                                Unit unit2 = Unit.INSTANCE;
                            }
                        }
                        j = 128;
                        j2 = 255;
                        if (modified$runtime_release != null) {
                        }
                        list3 = this.merged;
                        if (list3 != null) {
                        }
                        this.merged = null;
                        Unit unit22 = Unit.INSTANCE;
                    }
                    return SnapshotApplyResult.Success.INSTANCE;
                }
                return innerApplyLocked$runtime_release;
            }
            closeLocked$runtime_release();
            globalSnapshot = SnapshotKt.globalSnapshot;
            MutableScatterSet<StateObject> modified$runtime_release2 = globalSnapshot.getModified$runtime_release();
            function1 = SnapshotKt.emptyLambda;
            SnapshotKt.resetGlobalSnapshotLocked(globalSnapshot, function1);
            if (modified$runtime_release2 == null || !modified$runtime_release2.isNotEmpty()) {
                list = emptyList;
                mutableScatterSet = null;
            } else {
                list2 = SnapshotKt.applyObservers;
                list = list2;
                mutableScatterSet = modified$runtime_release2;
            }
            Unit unit3 = Unit.INSTANCE;
            this.applied = true;
            if (mutableScatterSet != null) {
            }
            if (modified$runtime_release != null) {
                Set wrapIntoSet22 = ScatterSetWrapperKt.wrapIntoSet(modified$runtime_release);
                size = list.size();
                while (i < size) {
                }
            }
            SnapshotObserverKt.dispatchObserverOnApplied(this, modified$runtime_release);
            synchronized (SnapshotKt.getLock()) {
            }
        }
    }

    @Override // androidx.compose.runtime.snapshots.Snapshot
    public Snapshot getRoot() {
        return this;
    }

    @Override // androidx.compose.runtime.snapshots.Snapshot
    public void dispose() {
        if (getDisposed$runtime_release()) {
            return;
        }
        super.dispose();
        MutableSnapshot mutableSnapshot = this;
        mo3637nestedDeactivated$runtime_release(mutableSnapshot);
        SnapshotObserverKt.dispatchObserverOnPreDispose(mutableSnapshot);
    }

    @Override // androidx.compose.runtime.snapshots.Snapshot
    public Snapshot takeNestedSnapshot(Function1<Object, Unit> function1) {
        Function1<Object, Unit> function12;
        Map<SnapshotObserver, SnapshotInstanceObservers> map;
        long j;
        long j2;
        SnapshotIdSet snapshotIdSet;
        NestedReadonlySnapshot nestedReadonlySnapshot;
        long j3;
        long j4;
        SnapshotIdSet snapshotIdSet2;
        validateNotDisposed$runtime_release();
        validateNotAppliedOrPinned();
        long snapshotId = getSnapshotId();
        MutableSnapshot mutableSnapshot = this instanceof GlobalSnapshot ? null : this;
        PersistentList access$getObservers$p = SnapshotObserverKt.access$getObservers$p();
        if (access$getObservers$p != null) {
            Pair<SnapshotInstanceObservers, Map<SnapshotObserver, SnapshotInstanceObservers>> mergeObservers = SnapshotObserverKt.mergeObservers(access$getObservers$p, mutableSnapshot, true, function1, null);
            SnapshotInstanceObservers first = mergeObservers.getFirst();
            Function1<Object, Unit> readObserver = first.getReadObserver();
            first.getWriteObserver();
            map = mergeObservers.getSecond();
            function12 = readObserver;
        } else {
            function12 = function1;
            map = null;
        }
        recordPrevious$runtime_release(getSnapshotId());
        synchronized (SnapshotKt.getLock()) {
            j = SnapshotKt.nextSnapshotId;
            j2 = SnapshotKt.nextSnapshotId;
            SnapshotKt.nextSnapshotId = j2 + 1;
            snapshotIdSet = SnapshotKt.openSnapshots;
            SnapshotKt.openSnapshots = snapshotIdSet.set(j);
            nestedReadonlySnapshot = new NestedReadonlySnapshot(j, SnapshotKt.addRange(getInvalid$runtime_release(), snapshotId + 1, j), SnapshotKt.mergedReadObserver$default(function12, getReadObserver(), false, 4, null), this);
        }
        if (!getApplied$runtime_release() && !getDisposed$runtime_release()) {
            long snapshotId2 = getSnapshotId();
            synchronized (SnapshotKt.getLock()) {
                j3 = SnapshotKt.nextSnapshotId;
                j4 = SnapshotKt.nextSnapshotId;
                SnapshotKt.nextSnapshotId = j4 + 1;
                setSnapshotId$runtime_release(j3);
                snapshotIdSet2 = SnapshotKt.openSnapshots;
                SnapshotKt.openSnapshots = snapshotIdSet2.set(getSnapshotId());
                Unit unit = Unit.INSTANCE;
            }
            setInvalid$runtime_release(SnapshotKt.addRange(getInvalid$runtime_release(), snapshotId2 + 1, getSnapshotId()));
        }
        NestedReadonlySnapshot nestedReadonlySnapshot2 = nestedReadonlySnapshot;
        if (access$getObservers$p != null) {
            SnapshotObserverKt.dispatchCreatedObservers(access$getObservers$p, mutableSnapshot, nestedReadonlySnapshot2, map);
        }
        return nestedReadonlySnapshot2;
    }

    @Override // androidx.compose.runtime.snapshots.Snapshot
    /* renamed from: nestedActivated$runtime_release */
    public void mo3636nestedActivated$runtime_release(Snapshot snapshot) {
        this.snapshots++;
    }

    @Override // androidx.compose.runtime.snapshots.Snapshot
    /* renamed from: nestedDeactivated$runtime_release */
    public void mo3637nestedDeactivated$runtime_release(Snapshot snapshot) {
        if (!(this.snapshots > 0)) {
            PreconditionsKt.throwIllegalArgumentException("no pending nested snapshots");
        }
        int i = this.snapshots - 1;
        this.snapshots = i;
        if (i != 0 || this.applied) {
            return;
        }
        abandon();
    }

    @Override // androidx.compose.runtime.snapshots.Snapshot
    public void notifyObjectsInitialized$runtime_release() {
        if (this.applied || getDisposed$runtime_release()) {
            return;
        }
        advance$runtime_release();
    }

    @Override // androidx.compose.runtime.snapshots.Snapshot
    public void closeLocked$runtime_release() {
        SnapshotIdSet snapshotIdSet;
        snapshotIdSet = SnapshotKt.openSnapshots;
        SnapshotKt.openSnapshots = snapshotIdSet.clear(getSnapshotId()).andNot(this.previousIds);
    }

    @Override // androidx.compose.runtime.snapshots.Snapshot
    public void releasePinnedSnapshotsForCloseLocked$runtime_release() {
        releasePreviouslyPinnedSnapshotsLocked();
        super.releasePinnedSnapshotsForCloseLocked$runtime_release();
    }

    private final void validateNotApplied() {
        if (this.applied) {
            PreconditionsKt.throwIllegalStateException("Unsupported operation on a snapshot that has been applied");
        }
    }

    private final void validateNotAppliedOrPinned() {
        if (!this.applied || ((Snapshot) this).pinningTrackingHandle >= 0) {
            return;
        }
        PreconditionsKt.throwIllegalStateException("Unsupported operation on a disposed or applied snapshot");
    }

    private final void abandon() {
        long j;
        MutableScatterSet<StateObject> modified$runtime_release = getModified$runtime_release();
        if (modified$runtime_release != null) {
            validateNotApplied();
            setModified(null);
            long snapshotId = getSnapshotId();
            MutableScatterSet<StateObject> mutableScatterSet = modified$runtime_release;
            Object[] objArr = mutableScatterSet.elements;
            long[] jArr = mutableScatterSet.metadata;
            int length = jArr.length - 2;
            if (length >= 0) {
                int i = 0;
                while (true) {
                    long j2 = jArr[i];
                    if ((((~j2) << 7) & j2 & (-9187201950435737472L)) != -9187201950435737472L) {
                        int i2 = 8 - ((~(i - length)) >>> 31);
                        for (int i3 = 0; i3 < i2; i3++) {
                            if ((255 & j2) < 128) {
                                for (StateRecord firstStateRecord = ((StateObject) objArr[(i << 3) + i3]).getFirstStateRecord(); firstStateRecord != null; firstStateRecord = firstStateRecord.getNext$runtime_release()) {
                                    if (firstStateRecord.getSnapshotId$runtime_release() == snapshotId || CollectionsKt.contains(this.previousIds, Long.valueOf(firstStateRecord.getSnapshotId$runtime_release()))) {
                                        j = SnapshotKt.INVALID_SNAPSHOT;
                                        firstStateRecord.setSnapshotId$runtime_release(j);
                                    }
                                }
                            }
                            j2 >>= 8;
                        }
                        if (i2 != 8) {
                            break;
                        }
                    }
                    if (i == length) {
                        break;
                    }
                    i++;
                }
            }
        }
        closeAndReleasePinning$runtime_release();
    }

    public final SnapshotApplyResult innerApplyLocked$runtime_release(long j, MutableScatterSet<StateObject> mutableScatterSet, Map<StateRecord, ? extends StateRecord> map, SnapshotIdSet snapshotIdSet) {
        SnapshotIdSet snapshotIdSet2;
        long[] jArr;
        Object[] objArr;
        SnapshotIdSet snapshotIdSet3;
        long[] jArr2;
        Object[] objArr2;
        int i;
        long j2;
        int i2;
        StateRecord readable;
        StateRecord readable2;
        StateRecord readable3;
        StateRecord mergeRecords;
        SnapshotIdSet or = getInvalid$runtime_release().set(getSnapshotId()).or(this.previousIds);
        MutableScatterSet<StateObject> mutableScatterSet2 = mutableScatterSet;
        Object[] objArr3 = mutableScatterSet2.elements;
        long[] jArr3 = mutableScatterSet2.metadata;
        int length = jArr3.length - 2;
        ArrayList arrayList = null;
        List<? extends StateObject> list = null;
        if (length >= 0) {
            int i3 = 0;
            while (true) {
                long j3 = jArr3[i3];
                ArrayList arrayList2 = list;
                if ((((~j3) << 7) & j3 & (-9187201950435737472L)) != -9187201950435737472L) {
                    int i4 = 8;
                    int i5 = 8 - ((~(i3 - length)) >>> 31);
                    int i6 = 0;
                    while (i6 < i5) {
                        if ((j3 & 255) < 128) {
                            i = i4;
                            StateObject stateObject = (StateObject) objArr3[(i3 << 3) + i6];
                            jArr2 = jArr3;
                            StateRecord firstStateRecord = stateObject.getFirstStateRecord();
                            objArr2 = objArr3;
                            ArrayList arrayList3 = arrayList;
                            readable = SnapshotKt.readable(firstStateRecord, j, snapshotIdSet);
                            if (readable == null) {
                                j2 = j3;
                            } else {
                                j2 = j3;
                                readable2 = SnapshotKt.readable(firstStateRecord, getSnapshotId(), or);
                                if (readable2 != null && readable2.getSnapshotId$runtime_release() != SnapshotId_jvmKt.toSnapshotId(1) && !Intrinsics.areEqual(readable, readable2)) {
                                    i2 = i6;
                                    snapshotIdSet3 = or;
                                    readable3 = SnapshotKt.readable(firstStateRecord, getSnapshotId(), getInvalid$runtime_release());
                                    if (readable3 == null) {
                                        SnapshotKt.readError();
                                        throw new KotlinNothingValueException();
                                    }
                                    if (map == null || (mergeRecords = map.get(readable)) == null) {
                                        mergeRecords = stateObject.mergeRecords(readable2, readable, readable3);
                                    }
                                    if (mergeRecords == null) {
                                        return new SnapshotApplyResult.Failure(this);
                                    }
                                    if (!Intrinsics.areEqual(mergeRecords, readable3)) {
                                        if (Intrinsics.areEqual(mergeRecords, readable)) {
                                            ArrayList arrayList4 = arrayList3 == null ? new ArrayList() : arrayList3;
                                            arrayList4.add(TuplesKt.to(stateObject, readable.create(getSnapshotId())));
                                            if (arrayList2 == null) {
                                                arrayList2 = new ArrayList();
                                            }
                                            List<? extends StateObject> list2 = arrayList2;
                                            list2.add(stateObject);
                                            arrayList = arrayList4;
                                            arrayList2 = list2;
                                        } else {
                                            arrayList = arrayList3 == null ? new ArrayList() : arrayList3;
                                            arrayList.add(!Intrinsics.areEqual(mergeRecords, readable2) ? TuplesKt.to(stateObject, mergeRecords) : TuplesKt.to(stateObject, readable2.create(getSnapshotId())));
                                        }
                                    }
                                    arrayList = arrayList3;
                                }
                            }
                            snapshotIdSet3 = or;
                            i2 = i6;
                            arrayList = arrayList3;
                        } else {
                            snapshotIdSet3 = or;
                            jArr2 = jArr3;
                            objArr2 = objArr3;
                            i = i4;
                            j2 = j3;
                            i2 = i6;
                        }
                        j3 = j2 >> i;
                        i6 = i2 + 1;
                        jArr3 = jArr2;
                        i4 = i;
                        objArr3 = objArr2;
                        or = snapshotIdSet3;
                    }
                    snapshotIdSet2 = or;
                    jArr = jArr3;
                    objArr = objArr3;
                    ArrayList arrayList5 = arrayList;
                    if (i5 != i4) {
                        list = arrayList2;
                        arrayList = arrayList5;
                        break;
                    }
                    arrayList = arrayList5;
                } else {
                    snapshotIdSet2 = or;
                    jArr = jArr3;
                    objArr = objArr3;
                }
                list = arrayList2;
                if (i3 == length) {
                    break;
                }
                i3++;
                jArr3 = jArr;
                objArr3 = objArr;
                or = snapshotIdSet2;
            }
        }
        if (arrayList != null) {
            advance$runtime_release();
            int size = arrayList.size();
            for (int i7 = 0; i7 < size; i7++) {
                Pair pair = (Pair) arrayList.get(i7);
                StateObject stateObject2 = (StateObject) pair.component1();
                StateRecord stateRecord = (StateRecord) pair.component2();
                stateRecord.setSnapshotId$runtime_release(j);
                synchronized (SnapshotKt.getLock()) {
                    stateRecord.setNext$runtime_release(stateObject2.getFirstStateRecord());
                    stateObject2.prependStateRecord(stateRecord);
                    Unit unit = Unit.INSTANCE;
                }
            }
        }
        if (list != null) {
            int size2 = list.size();
            for (int i8 = 0; i8 < size2; i8++) {
                mutableScatterSet.remove(list.get(i8));
            }
            List<? extends StateObject> list3 = this.merged;
            if (list3 != null) {
                list = CollectionsKt.plus((Collection) list3, (Iterable) list);
            }
            this.merged = list;
        }
        return SnapshotApplyResult.Success.INSTANCE;
    }

    public final <T> T advance$runtime_release(Function0<? extends T> function0) {
        long j;
        long j2;
        SnapshotIdSet snapshotIdSet;
        recordPrevious$runtime_release(getSnapshotId());
        T invoke = function0.invoke();
        if (getApplied$runtime_release() || getDisposed$runtime_release()) {
            return invoke;
        }
        long snapshotId = getSnapshotId();
        synchronized (SnapshotKt.getLock()) {
            j = SnapshotKt.nextSnapshotId;
            j2 = SnapshotKt.nextSnapshotId;
            SnapshotKt.nextSnapshotId = j2 + 1;
            setSnapshotId$runtime_release(j);
            snapshotIdSet = SnapshotKt.openSnapshots;
            SnapshotKt.openSnapshots = snapshotIdSet.set(getSnapshotId());
            Unit unit = Unit.INSTANCE;
        }
        setInvalid$runtime_release(SnapshotKt.addRange(getInvalid$runtime_release(), snapshotId + 1, getSnapshotId()));
        return invoke;
    }

    public final void recordPreviousPinnedSnapshot$runtime_release(int i) {
        if (i >= 0) {
            this.previousPinnedSnapshots = ArraysKt.plus(this.previousPinnedSnapshots, i);
        }
    }

    public final void recordPreviousPinnedSnapshots$runtime_release(int[] iArr) {
        if (iArr.length == 0) {
            return;
        }
        int[] iArr2 = this.previousPinnedSnapshots;
        if (iArr2.length != 0) {
            iArr = ArraysKt.plus(iArr2, iArr);
        }
        this.previousPinnedSnapshots = iArr;
    }

    private final void releasePreviouslyPinnedSnapshotsLocked() {
        int length = this.previousPinnedSnapshots.length;
        for (int i = 0; i < length; i++) {
            SnapshotKt.releasePinningLocked(this.previousPinnedSnapshots[i]);
        }
    }

    @Override // androidx.compose.runtime.snapshots.Snapshot
    /* renamed from: recordModified$runtime_release */
    public void mo3638recordModified$runtime_release(StateObject stateObject) {
        MutableScatterSet<StateObject> modified$runtime_release = getModified$runtime_release();
        if (modified$runtime_release == null) {
            modified$runtime_release = ScatterSetKt.mutableScatterSetOf();
            setModified(modified$runtime_release);
        }
        modified$runtime_release.add(stateObject);
    }

    @Override // androidx.compose.runtime.snapshots.Snapshot
    public int getWriteCount$runtime_release() {
        return this.writeCount;
    }

    @Override // androidx.compose.runtime.snapshots.Snapshot
    public void setWriteCount$runtime_release(int i) {
        this.writeCount = i;
    }

    @Override // androidx.compose.runtime.snapshots.Snapshot
    public MutableScatterSet<StateObject> getModified$runtime_release() {
        return this.modified;
    }

    public void setModified(MutableScatterSet<StateObject> mutableScatterSet) {
        this.modified = mutableScatterSet;
    }

    public final List<StateObject> getMerged$runtime_release() {
        return this.merged;
    }

    public final void setMerged$runtime_release(List<? extends StateObject> list) {
        this.merged = list;
    }

    public final SnapshotIdSet getPreviousIds$runtime_release() {
        return this.previousIds;
    }

    public final void setPreviousIds$runtime_release(SnapshotIdSet snapshotIdSet) {
        this.previousIds = snapshotIdSet;
    }

    public final int[] getPreviousPinnedSnapshots$runtime_release() {
        return this.previousPinnedSnapshots;
    }

    public final void setPreviousPinnedSnapshots$runtime_release(int[] iArr) {
        this.previousPinnedSnapshots = iArr;
    }

    public final boolean getApplied$runtime_release() {
        return this.applied;
    }

    public final void setApplied$runtime_release(boolean z) {
        this.applied = z;
    }

    /* compiled from: Snapshot.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0000\b\u0082\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Landroidx/compose/runtime/snapshots/MutableSnapshot$Companion;", "", "()V", "EmptyIntArray", "", "runtime_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* loaded from: classes.dex */
    private static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    public final void advance$runtime_release() {
        long j;
        long j2;
        SnapshotIdSet snapshotIdSet;
        recordPrevious$runtime_release(getSnapshotId());
        Unit unit = Unit.INSTANCE;
        if (getApplied$runtime_release() || getDisposed$runtime_release()) {
            return;
        }
        long snapshotId = getSnapshotId();
        synchronized (SnapshotKt.getLock()) {
            j = SnapshotKt.nextSnapshotId;
            j2 = SnapshotKt.nextSnapshotId;
            SnapshotKt.nextSnapshotId = j2 + 1;
            setSnapshotId$runtime_release(j);
            snapshotIdSet = SnapshotKt.openSnapshots;
            SnapshotKt.openSnapshots = snapshotIdSet.set(getSnapshotId());
            Unit unit2 = Unit.INSTANCE;
        }
        setInvalid$runtime_release(SnapshotKt.addRange(getInvalid$runtime_release(), snapshotId + 1, getSnapshotId()));
    }

    public final void recordPrevious$runtime_release(long j) {
        synchronized (SnapshotKt.getLock()) {
            this.previousIds = this.previousIds.set(j);
            Unit unit = Unit.INSTANCE;
        }
    }

    public final void recordPreviousList$runtime_release(SnapshotIdSet snapshotIdSet) {
        synchronized (SnapshotKt.getLock()) {
            this.previousIds = this.previousIds.or(snapshotIdSet);
            Unit unit = Unit.INSTANCE;
        }
    }
}
