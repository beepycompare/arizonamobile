package com.arizona.launcher;

import com.arizona.launcher.UpdateOperationBeginResult;
import com.arizona.launcher.UpdateServiceContract;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: UpdateOperationCoordinator.kt */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\b\u0001\u0018\u00002\u00020\u0001B\u0011\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000e\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rJ\b\u0010\u000e\u001a\u0004\u0018\u00010\tJ\u0016\u0010\u000f\u001a\u00020\u00102\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\u0003J\u0016\u0010\u0012\u001a\u00020\u00102\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\u0003J\u0016\u0010\u0013\u001a\u00020\u00102\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\u0003J\b\u0010\u0013\u001a\u0004\u0018\u00010\tJ\b\u0010\u0014\u001a\u00020\u0003H\u0002J\u001e\u0010\u0015\u001a\u00020\u0010*\u0004\u0018\u00010\t2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\u0003H\u0002R\u000e\u0010\u0006\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000Ê\u0001\f\b\u0017\u0012\b\b\u0018\u0012\u0004\b\u0003\u0010\u0000¨\u0006\u0016"}, d2 = {"Lcom/arizona/launcher/UpdateOperationCoordinator;", "", "initialEpoch", "", "<init>", "(J)V", "lock", "epoch", AppMeasurementSdk.ConditionalUserProperty.ACTIVE, "Lcom/arizona/launcher/UpdateOperationSnapshot;", "begin", "Lcom/arizona/launcher/UpdateOperationBeginResult;", "kind", "Lcom/arizona/launcher/UpdateOperationKind;", UpdateServiceContract.BundleKey.CURRENT, "isCurrent", "", "token", "finish", "invalidate", "advanceEpochLocked", "matches", "app", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class UpdateOperationCoordinator {
    public static final int $stable = 8;
    private UpdateOperationSnapshot active;
    private long epoch;
    private final Object lock;

    public UpdateOperationCoordinator() {
        this(0L, 1, null);
    }

    public UpdateOperationCoordinator(long j) {
        this.lock = new Object();
        this.epoch = j;
        if (j < 0) {
            throw new IllegalArgumentException("initialEpoch must be non-negative".toString());
        }
    }

    public /* synthetic */ UpdateOperationCoordinator(long j, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? 0L : j);
    }

    public final UpdateOperationBeginResult begin(UpdateOperationKind kind) {
        UpdateOperationBeginResult.Started started;
        Intrinsics.checkNotNullParameter(kind, "kind");
        synchronized (this.lock) {
            UpdateOperationSnapshot updateOperationSnapshot = this.active;
            if (updateOperationSnapshot != null) {
                started = new UpdateOperationBeginResult.Busy(updateOperationSnapshot);
            } else {
                UpdateOperationSnapshot updateOperationSnapshot2 = new UpdateOperationSnapshot(kind, advanceEpochLocked());
                this.active = updateOperationSnapshot2;
                started = new UpdateOperationBeginResult.Started(updateOperationSnapshot2);
            }
        }
        return started;
    }

    public final UpdateOperationSnapshot current() {
        UpdateOperationSnapshot updateOperationSnapshot;
        synchronized (this.lock) {
            updateOperationSnapshot = this.active;
        }
        return updateOperationSnapshot;
    }

    public final boolean isCurrent(UpdateOperationKind kind, long j) {
        boolean matches;
        Intrinsics.checkNotNullParameter(kind, "kind");
        synchronized (this.lock) {
            matches = matches(this.active, kind, j);
        }
        return matches;
    }

    public final boolean finish(UpdateOperationKind kind, long j) {
        boolean z;
        Intrinsics.checkNotNullParameter(kind, "kind");
        synchronized (this.lock) {
            if (matches(this.active, kind, j)) {
                this.active = null;
                z = true;
            } else {
                z = false;
            }
        }
        return z;
    }

    public final boolean invalidate(UpdateOperationKind kind, long j) {
        boolean z;
        Intrinsics.checkNotNullParameter(kind, "kind");
        synchronized (this.lock) {
            if (matches(this.active, kind, j)) {
                advanceEpochLocked();
                this.active = null;
                z = true;
            } else {
                z = false;
            }
        }
        return z;
    }

    public final UpdateOperationSnapshot invalidate() {
        UpdateOperationSnapshot updateOperationSnapshot;
        synchronized (this.lock) {
            updateOperationSnapshot = this.active;
            advanceEpochLocked();
            this.active = null;
        }
        return updateOperationSnapshot;
    }

    private final long advanceEpochLocked() {
        long j = this.epoch;
        if (j >= Long.MAX_VALUE) {
            throw new IllegalStateException("update operation token space exhausted".toString());
        }
        long j2 = j + 1;
        this.epoch = j2;
        return j2;
    }

    private final boolean matches(UpdateOperationSnapshot updateOperationSnapshot, UpdateOperationKind updateOperationKind, long j) {
        return (updateOperationSnapshot != null ? updateOperationSnapshot.getKind() : null) == updateOperationKind && updateOperationSnapshot.getToken() == j;
    }
}
