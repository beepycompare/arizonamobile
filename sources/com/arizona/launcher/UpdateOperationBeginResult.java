package com.arizona.launcher;

import com.google.android.gms.measurement.api.AppMeasurementSdk;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: UpdateOperationCoordinator.kt */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bp\u0018\u00002\u00020\u0001:\u0002\u0002\u0003\u0082\u0001\u0002\u0004\u0005¨\u0006\u0006À\u0006\u0003"}, d2 = {"Lcom/arizona/launcher/UpdateOperationBeginResult;", "", "Started", "Busy", "Lcom/arizona/launcher/UpdateOperationBeginResult$Busy;", "Lcom/arizona/launcher/UpdateOperationBeginResult$Started;", "app"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes3.dex */
public interface UpdateOperationBeginResult {

    /* compiled from: UpdateOperationCoordinator.kt */
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0014\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0083\u0004J\n\u0010\u000e\u001a\u00020\u000fHÖ\u0081\u0004J\n\u0010\u0010\u001a\u00020\u0011HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007Ê\u0001\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\u0003\u0010\u0002¨\u0006\u0012"}, d2 = {"Lcom/arizona/launcher/UpdateOperationBeginResult$Started;", "Lcom/arizona/launcher/UpdateOperationBeginResult;", "operation", "Lcom/arizona/launcher/UpdateOperationSnapshot;", "<init>", "(Lcom/arizona/launcher/UpdateOperationSnapshot;)V", "getOperation", "()Lcom/arizona/launcher/UpdateOperationSnapshot;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "app", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class Started implements UpdateOperationBeginResult {
        public static final int $stable = 0;
        private final UpdateOperationSnapshot operation;

        public static /* synthetic */ Started copy$default(Started started, UpdateOperationSnapshot updateOperationSnapshot, int i, Object obj) {
            if ((i & 1) != 0) {
                updateOperationSnapshot = started.operation;
            }
            return started.copy(updateOperationSnapshot);
        }

        public final UpdateOperationSnapshot component1() {
            return this.operation;
        }

        public final Started copy(UpdateOperationSnapshot operation) {
            Intrinsics.checkNotNullParameter(operation, "operation");
            return new Started(operation);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof Started) && Intrinsics.areEqual(this.operation, ((Started) obj).operation);
        }

        public int hashCode() {
            return this.operation.hashCode();
        }

        public String toString() {
            return "Started(operation=" + this.operation + ")";
        }

        public Started(UpdateOperationSnapshot operation) {
            Intrinsics.checkNotNullParameter(operation, "operation");
            this.operation = operation;
        }

        public final UpdateOperationSnapshot getOperation() {
            return this.operation;
        }
    }

    /* compiled from: UpdateOperationCoordinator.kt */
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0014\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0083\u0004J\n\u0010\u000e\u001a\u00020\u000fHÖ\u0081\u0004J\n\u0010\u0010\u001a\u00020\u0011HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007Ê\u0001\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\u0003\u0010\u0002¨\u0006\u0012"}, d2 = {"Lcom/arizona/launcher/UpdateOperationBeginResult$Busy;", "Lcom/arizona/launcher/UpdateOperationBeginResult;", AppMeasurementSdk.ConditionalUserProperty.ACTIVE, "Lcom/arizona/launcher/UpdateOperationSnapshot;", "<init>", "(Lcom/arizona/launcher/UpdateOperationSnapshot;)V", "getActive", "()Lcom/arizona/launcher/UpdateOperationSnapshot;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "app", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class Busy implements UpdateOperationBeginResult {
        public static final int $stable = 0;
        private final UpdateOperationSnapshot active;

        public static /* synthetic */ Busy copy$default(Busy busy, UpdateOperationSnapshot updateOperationSnapshot, int i, Object obj) {
            if ((i & 1) != 0) {
                updateOperationSnapshot = busy.active;
            }
            return busy.copy(updateOperationSnapshot);
        }

        public final UpdateOperationSnapshot component1() {
            return this.active;
        }

        public final Busy copy(UpdateOperationSnapshot active) {
            Intrinsics.checkNotNullParameter(active, "active");
            return new Busy(active);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof Busy) && Intrinsics.areEqual(this.active, ((Busy) obj).active);
        }

        public int hashCode() {
            return this.active.hashCode();
        }

        public String toString() {
            return "Busy(active=" + this.active + ")";
        }

        public Busy(UpdateOperationSnapshot active) {
            Intrinsics.checkNotNullParameter(active, "active");
            this.active = active;
        }

        public final UpdateOperationSnapshot getActive() {
            return this.active;
        }
    }
}
