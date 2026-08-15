package com.arizona.launcher;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: UpdateOperationCoordinator.kt */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0081\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0014\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0012\u001a\u00020\u0013HÖ\u0081\u0004J\n\u0010\u0014\u001a\u00020\u0015HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bÊ\u0001\f\b\u0017\u0012\b\b\u0018\u0012\u0004\b\u0003\u0010\u0002¨\u0006\u0016"}, d2 = {"Lcom/arizona/launcher/UpdateOperationSnapshot;", "", "kind", "Lcom/arizona/launcher/UpdateOperationKind;", "token", "", "<init>", "(Lcom/arizona/launcher/UpdateOperationKind;J)V", "getKind", "()Lcom/arizona/launcher/UpdateOperationKind;", "getToken", "()J", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "app", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class UpdateOperationSnapshot {
    public static final int $stable = 0;
    private final UpdateOperationKind kind;
    private final long token;

    public static /* synthetic */ UpdateOperationSnapshot copy$default(UpdateOperationSnapshot updateOperationSnapshot, UpdateOperationKind updateOperationKind, long j, int i, Object obj) {
        if ((i & 1) != 0) {
            updateOperationKind = updateOperationSnapshot.kind;
        }
        if ((i & 2) != 0) {
            j = updateOperationSnapshot.token;
        }
        return updateOperationSnapshot.copy(updateOperationKind, j);
    }

    public final UpdateOperationKind component1() {
        return this.kind;
    }

    public final long component2() {
        return this.token;
    }

    public final UpdateOperationSnapshot copy(UpdateOperationKind kind, long j) {
        Intrinsics.checkNotNullParameter(kind, "kind");
        return new UpdateOperationSnapshot(kind, j);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof UpdateOperationSnapshot) {
            UpdateOperationSnapshot updateOperationSnapshot = (UpdateOperationSnapshot) obj;
            return this.kind == updateOperationSnapshot.kind && this.token == updateOperationSnapshot.token;
        }
        return false;
    }

    public int hashCode() {
        return (this.kind.hashCode() * 31) + Long.hashCode(this.token);
    }

    public String toString() {
        UpdateOperationKind updateOperationKind = this.kind;
        return "UpdateOperationSnapshot(kind=" + updateOperationKind + ", token=" + this.token + ")";
    }

    public UpdateOperationSnapshot(UpdateOperationKind kind, long j) {
        Intrinsics.checkNotNullParameter(kind, "kind");
        this.kind = kind;
        this.token = j;
    }

    public final UpdateOperationKind getKind() {
        return this.kind;
    }

    public final long getToken() {
        return this.token;
    }
}
