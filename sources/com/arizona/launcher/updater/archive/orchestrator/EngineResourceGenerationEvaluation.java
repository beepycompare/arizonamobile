package com.arizona.launcher.updater.archive.orchestrator;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: EngineResourceGenerationController.kt */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bp\u0018\u00002\u00020\u0001:\u0002\u0006\u0007R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005\u0082\u0001\u0002\b\t¨\u0006\nÀ\u0006\u0003"}, d2 = {"Lcom/arizona/launcher/updater/archive/orchestrator/EngineResourceGenerationEvaluation;", "", "operationToken", "", "getOperationToken", "()J", "Corrupt", "Ready", "Lcom/arizona/launcher/updater/archive/orchestrator/EngineResourceGenerationEvaluation$Corrupt;", "Lcom/arizona/launcher/updater/archive/orchestrator/EngineResourceGenerationEvaluation$Ready;", "app"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes3.dex */
public interface EngineResourceGenerationEvaluation {
    long getOperationToken();

    /* compiled from: EngineResourceGenerationController.kt */
    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0014\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012HÖ\u0083\u0004J\n\u0010\u0013\u001a\u00020\u0014HÖ\u0081\u0004J\n\u0010\u0015\u001a\u00020\u0005HÖ\u0081\u0004R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bÊ\u0001\f\b\u0017\u0012\b\b\u0018\u0012\u0004\b\u0003\u0010\u0002¨\u0006\u0016"}, d2 = {"Lcom/arizona/launcher/updater/archive/orchestrator/EngineResourceGenerationEvaluation$Corrupt;", "Lcom/arizona/launcher/updater/archive/orchestrator/EngineResourceGenerationEvaluation;", "operationToken", "", "reason", "", "<init>", "(JLjava/lang/String;)V", "getOperationToken", "()J", "getReason", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "app", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class Corrupt implements EngineResourceGenerationEvaluation {
        public static final int $stable = 0;
        private final long operationToken;
        private final String reason;

        public static /* synthetic */ Corrupt copy$default(Corrupt corrupt, long j, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                j = corrupt.operationToken;
            }
            if ((i & 2) != 0) {
                str = corrupt.reason;
            }
            return corrupt.copy(j, str);
        }

        public final long component1() {
            return this.operationToken;
        }

        public final String component2() {
            return this.reason;
        }

        public final Corrupt copy(long j, String reason) {
            Intrinsics.checkNotNullParameter(reason, "reason");
            return new Corrupt(j, reason);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof Corrupt) {
                Corrupt corrupt = (Corrupt) obj;
                return this.operationToken == corrupt.operationToken && Intrinsics.areEqual(this.reason, corrupt.reason);
            }
            return false;
        }

        public int hashCode() {
            return (Long.hashCode(this.operationToken) * 31) + this.reason.hashCode();
        }

        public String toString() {
            long j = this.operationToken;
            return "Corrupt(operationToken=" + j + ", reason=" + this.reason + ")";
        }

        public Corrupt(long j, String reason) {
            Intrinsics.checkNotNullParameter(reason, "reason");
            this.operationToken = j;
            this.reason = reason;
        }

        @Override // com.arizona.launcher.updater.archive.orchestrator.EngineResourceGenerationEvaluation
        public long getOperationToken() {
            return this.operationToken;
        }

        public final String getReason() {
            return this.reason;
        }
    }

    /* compiled from: EngineResourceGenerationController.kt */
    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0014\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B7\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u000b\u0010\fJ\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001b\u001a\u00020\nHÆ\u0003JE\u0010\u001c\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\nHÆ\u0001J\u0014\u0010\u001d\u001a\u00020\n2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fHÖ\u0083\u0004J\n\u0010 \u001a\u00020!HÖ\u0081\u0004J\n\u0010\"\u001a\u00020#HÖ\u0081\u0004R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000eR\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000eR\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015Ê\u0001\f\b%\u0012\b\b&\u0012\u0004\b\u0003\u0010\u0002¨\u0006$"}, d2 = {"Lcom/arizona/launcher/updater/archive/orchestrator/EngineResourceGenerationEvaluation$Ready;", "Lcom/arizona/launcher/updater/archive/orchestrator/EngineResourceGenerationEvaluation;", "operationToken", "", TypedValues.AttributesType.S_TARGET, "action", "Lcom/arizona/launcher/updater/archive/orchestrator/EngineResourceGenerationAction;", "preparedGeneration", "completedGeneration", "markerPresent", "", "<init>", "(JJLcom/arizona/launcher/updater/archive/orchestrator/EngineResourceGenerationAction;JJZ)V", "getOperationToken", "()J", "getTarget", "getAction", "()Lcom/arizona/launcher/updater/archive/orchestrator/EngineResourceGenerationAction;", "getPreparedGeneration", "getCompletedGeneration", "getMarkerPresent", "()Z", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "other", "", "hashCode", "", "toString", "", "app", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class Ready implements EngineResourceGenerationEvaluation {
        public static final int $stable = 0;
        private final EngineResourceGenerationAction action;
        private final long completedGeneration;
        private final boolean markerPresent;
        private final long operationToken;
        private final long preparedGeneration;
        private final long target;

        public static /* synthetic */ Ready copy$default(Ready ready, long j, long j2, EngineResourceGenerationAction engineResourceGenerationAction, long j3, long j4, boolean z, int i, Object obj) {
            if ((i & 1) != 0) {
                j = ready.operationToken;
            }
            long j5 = j;
            if ((i & 2) != 0) {
                j2 = ready.target;
            }
            return ready.copy(j5, j2, (i & 4) != 0 ? ready.action : engineResourceGenerationAction, (i & 8) != 0 ? ready.preparedGeneration : j3, (i & 16) != 0 ? ready.completedGeneration : j4, (i & 32) != 0 ? ready.markerPresent : z);
        }

        public final long component1() {
            return this.operationToken;
        }

        public final long component2() {
            return this.target;
        }

        public final EngineResourceGenerationAction component3() {
            return this.action;
        }

        public final long component4() {
            return this.preparedGeneration;
        }

        public final long component5() {
            return this.completedGeneration;
        }

        public final boolean component6() {
            return this.markerPresent;
        }

        public final Ready copy(long j, long j2, EngineResourceGenerationAction action, long j3, long j4, boolean z) {
            Intrinsics.checkNotNullParameter(action, "action");
            return new Ready(j, j2, action, j3, j4, z);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof Ready) {
                Ready ready = (Ready) obj;
                return this.operationToken == ready.operationToken && this.target == ready.target && this.action == ready.action && this.preparedGeneration == ready.preparedGeneration && this.completedGeneration == ready.completedGeneration && this.markerPresent == ready.markerPresent;
            }
            return false;
        }

        public int hashCode() {
            return (((((((((Long.hashCode(this.operationToken) * 31) + Long.hashCode(this.target)) * 31) + this.action.hashCode()) * 31) + Long.hashCode(this.preparedGeneration)) * 31) + Long.hashCode(this.completedGeneration)) * 31) + Boolean.hashCode(this.markerPresent);
        }

        public String toString() {
            long j = this.operationToken;
            long j2 = this.target;
            EngineResourceGenerationAction engineResourceGenerationAction = this.action;
            long j3 = this.preparedGeneration;
            long j4 = this.completedGeneration;
            return "Ready(operationToken=" + j + ", target=" + j2 + ", action=" + engineResourceGenerationAction + ", preparedGeneration=" + j3 + ", completedGeneration=" + j4 + ", markerPresent=" + this.markerPresent + ")";
        }

        public Ready(long j, long j2, EngineResourceGenerationAction action, long j3, long j4, boolean z) {
            Intrinsics.checkNotNullParameter(action, "action");
            this.operationToken = j;
            this.target = j2;
            this.action = action;
            this.preparedGeneration = j3;
            this.completedGeneration = j4;
            this.markerPresent = z;
        }

        @Override // com.arizona.launcher.updater.archive.orchestrator.EngineResourceGenerationEvaluation
        public long getOperationToken() {
            return this.operationToken;
        }

        public final long getTarget() {
            return this.target;
        }

        public final EngineResourceGenerationAction getAction() {
            return this.action;
        }

        public final long getPreparedGeneration() {
            return this.preparedGeneration;
        }

        public final long getCompletedGeneration() {
            return this.completedGeneration;
        }

        public final boolean getMarkerPresent() {
            return this.markerPresent;
        }
    }
}
