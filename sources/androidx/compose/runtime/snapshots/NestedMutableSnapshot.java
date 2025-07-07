package androidx.compose.runtime.snapshots;

import androidx.collection.MutableScatterSet;
import androidx.compose.runtime.snapshots.SnapshotApplyResult;
import androidx.compose.runtime.snapshots.tooling.SnapshotObserverKt;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: Snapshot.kt */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001BM\u0012\n\u0010\u0002\u001a\u00060\u0003j\u0002`\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0014\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n\u0018\u00010\b\u0012\u0014\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n\u0018\u00010\b\u0012\u0006\u0010\f\u001a\u00020\u0001¢\u0006\u0002\u0010\rJ\b\u0010\u0016\u001a\u00020\u0017H\u0016J\b\u0010\u0018\u001a\u00020\nH\u0002J\b\u0010\u0019\u001a\u00020\nH\u0016R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\f\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0012\u001a\u00020\u00138VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015¨\u0006\u001a"}, d2 = {"Landroidx/compose/runtime/snapshots/NestedMutableSnapshot;", "Landroidx/compose/runtime/snapshots/MutableSnapshot;", "snapshotId", "", "Landroidx/compose/runtime/snapshots/SnapshotId;", "invalid", "Landroidx/compose/runtime/snapshots/SnapshotIdSet;", "readObserver", "Lkotlin/Function1;", "", "", "writeObserver", "parent", "(JLandroidx/compose/runtime/snapshots/SnapshotIdSet;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/snapshots/MutableSnapshot;)V", "deactivated", "", "getParent", "()Landroidx/compose/runtime/snapshots/MutableSnapshot;", "root", "Landroidx/compose/runtime/snapshots/Snapshot;", "getRoot", "()Landroidx/compose/runtime/snapshots/Snapshot;", "apply", "Landroidx/compose/runtime/snapshots/SnapshotApplyResult;", "deactivate", "dispose", "runtime_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes.dex */
public final class NestedMutableSnapshot extends MutableSnapshot {
    public static final int $stable = 8;
    private boolean deactivated;
    private final MutableSnapshot parent;

    public final MutableSnapshot getParent() {
        return this.parent;
    }

    public NestedMutableSnapshot(long j, SnapshotIdSet snapshotIdSet, Function1<Object, Unit> function1, Function1<Object, Unit> function12, MutableSnapshot mutableSnapshot) {
        super(j, snapshotIdSet, function1, function12);
        this.parent = mutableSnapshot;
        mutableSnapshot.mo3636nestedActivated$runtime_release(this);
    }

    @Override // androidx.compose.runtime.snapshots.MutableSnapshot, androidx.compose.runtime.snapshots.Snapshot
    public Snapshot getRoot() {
        return this.parent.getRoot();
    }

    @Override // androidx.compose.runtime.snapshots.MutableSnapshot, androidx.compose.runtime.snapshots.Snapshot
    public void dispose() {
        if (getDisposed$runtime_release()) {
            return;
        }
        super.dispose();
        deactivate();
    }

    /* JADX WARN: Code restructure failed: missing block: B:27:0x0070, code lost:
        if (r2 == null) goto L36;
     */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0089 A[Catch: all -> 0x00da, TryCatch #0 {all -> 0x00da, blocks: (B:20:0x0054, B:24:0x0062, B:26:0x006a, B:30:0x007f, B:32:0x0089, B:33:0x008e, B:28:0x0072, B:29:0x007b), top: B:45:0x003e }] */
    @Override // androidx.compose.runtime.snapshots.MutableSnapshot
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public SnapshotApplyResult apply() {
        Map<StateRecord, ? extends StateRecord> map;
        NestedMutableSnapshot nestedMutableSnapshot;
        Map<StateRecord, ? extends StateRecord> optimisticMerges;
        if (this.parent.getApplied$runtime_release() || this.parent.getDisposed$runtime_release()) {
            return new SnapshotApplyResult.Failure(this);
        }
        MutableScatterSet<StateObject> modified$runtime_release = getModified$runtime_release();
        long snapshotId = getSnapshotId();
        if (modified$runtime_release != null) {
            optimisticMerges = SnapshotKt.optimisticMerges(this.parent.getSnapshotId(), this, this.parent.getInvalid$runtime_release());
            map = optimisticMerges;
        } else {
            map = null;
        }
        synchronized (SnapshotKt.getLock()) {
            try {
                SnapshotKt.validateOpen(this);
                try {
                    if (modified$runtime_release != null && modified$runtime_release.getSize() != 0) {
                        nestedMutableSnapshot = this;
                        SnapshotApplyResult innerApplyLocked$runtime_release = nestedMutableSnapshot.innerApplyLocked$runtime_release(this.parent.getSnapshotId(), modified$runtime_release, map, this.parent.getInvalid$runtime_release());
                        if (Intrinsics.areEqual(innerApplyLocked$runtime_release, SnapshotApplyResult.Success.INSTANCE)) {
                            MutableScatterSet<StateObject> modified$runtime_release2 = nestedMutableSnapshot.parent.getModified$runtime_release();
                            if (modified$runtime_release2 != null) {
                                modified$runtime_release2.addAll(modified$runtime_release);
                            }
                            nestedMutableSnapshot.parent.setModified(modified$runtime_release);
                            setModified(null);
                            if (nestedMutableSnapshot.parent.getSnapshotId() < snapshotId) {
                                nestedMutableSnapshot.parent.advance$runtime_release();
                            }
                            MutableSnapshot mutableSnapshot = nestedMutableSnapshot.parent;
                            mutableSnapshot.setInvalid$runtime_release(mutableSnapshot.getInvalid$runtime_release().clear(snapshotId).andNot(getPreviousIds$runtime_release()));
                            nestedMutableSnapshot.parent.recordPrevious$runtime_release(snapshotId);
                            nestedMutableSnapshot.parent.recordPreviousPinnedSnapshot$runtime_release(takeoverPinnedSnapshot$runtime_release());
                            nestedMutableSnapshot.parent.recordPreviousList$runtime_release(getPreviousIds$runtime_release());
                            nestedMutableSnapshot.parent.recordPreviousPinnedSnapshots$runtime_release(getPreviousPinnedSnapshots$runtime_release());
                            Unit unit = Unit.INSTANCE;
                            setApplied$runtime_release(true);
                            deactivate();
                            SnapshotObserverKt.dispatchObserverOnApplied(nestedMutableSnapshot, modified$runtime_release);
                            return SnapshotApplyResult.Success.INSTANCE;
                        }
                        return innerApplyLocked$runtime_release;
                    }
                    nestedMutableSnapshot = this;
                    closeAndReleasePinning$runtime_release();
                    if (nestedMutableSnapshot.parent.getSnapshotId() < snapshotId) {
                    }
                    MutableSnapshot mutableSnapshot2 = nestedMutableSnapshot.parent;
                    mutableSnapshot2.setInvalid$runtime_release(mutableSnapshot2.getInvalid$runtime_release().clear(snapshotId).andNot(getPreviousIds$runtime_release()));
                    nestedMutableSnapshot.parent.recordPrevious$runtime_release(snapshotId);
                    nestedMutableSnapshot.parent.recordPreviousPinnedSnapshot$runtime_release(takeoverPinnedSnapshot$runtime_release());
                    nestedMutableSnapshot.parent.recordPreviousList$runtime_release(getPreviousIds$runtime_release());
                    nestedMutableSnapshot.parent.recordPreviousPinnedSnapshots$runtime_release(getPreviousPinnedSnapshots$runtime_release());
                    Unit unit2 = Unit.INSTANCE;
                    setApplied$runtime_release(true);
                    deactivate();
                    SnapshotObserverKt.dispatchObserverOnApplied(nestedMutableSnapshot, modified$runtime_release);
                    return SnapshotApplyResult.Success.INSTANCE;
                } catch (Throwable th) {
                    th = th;
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        }
    }

    private final void deactivate() {
        if (this.deactivated) {
            return;
        }
        this.deactivated = true;
        this.parent.mo3637nestedDeactivated$runtime_release(this);
    }
}
