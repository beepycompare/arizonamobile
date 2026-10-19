package com.arizona.launcher.updater.archive.orchestrator;

import com.google.firebase.remoteconfig.RemoteConfigConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: EngineResourceGenerationStore.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bp\u0018\u00002\u00020\u0001:\u0003\u0002\u0003\u0004\u0082\u0001\u0003\u0005\u0006\u0007¨\u0006\bÀ\u0006\u0003"}, d2 = {"Lcom/arizona/launcher/updater/archive/orchestrator/EngineResourceGenerationLoadResult;", "", "Missing", "Loaded", "Corrupt", "Lcom/arizona/launcher/updater/archive/orchestrator/EngineResourceGenerationLoadResult$Corrupt;", "Lcom/arizona/launcher/updater/archive/orchestrator/EngineResourceGenerationLoadResult$Loaded;", "Lcom/arizona/launcher/updater/archive/orchestrator/EngineResourceGenerationLoadResult$Missing;", "app"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes3.dex */
public interface EngineResourceGenerationLoadResult {

    /* compiled from: EngineResourceGenerationStore.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0014\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0083\u0004J\n\u0010\b\u001a\u00020\tHÖ\u0081\u0004J\n\u0010\n\u001a\u00020\u000bHÖ\u0081\u0004Ê\u0001\f\b\r\u0012\b\b\u000e\u0012\u0004\b\u0003\u0010\u0002¨\u0006\f"}, d2 = {"Lcom/arizona/launcher/updater/archive/orchestrator/EngineResourceGenerationLoadResult$Missing;", "Lcom/arizona/launcher/updater/archive/orchestrator/EngineResourceGenerationLoadResult;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "app", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class Missing implements EngineResourceGenerationLoadResult {
        public static final int $stable = 0;
        public static final Missing INSTANCE = new Missing();

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof Missing) {
                Missing missing = (Missing) obj;
                return true;
            }
            return false;
        }

        public int hashCode() {
            return -1434154461;
        }

        public String toString() {
            return "Missing";
        }

        private Missing() {
        }
    }

    /* compiled from: EngineResourceGenerationStore.kt */
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0014\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0083\u0004J\n\u0010\u000e\u001a\u00020\u000fHÖ\u0081\u0004J\n\u0010\u0010\u001a\u00020\u0011HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007Ê\u0001\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\u0003\u0010\u0002¨\u0006\u0012"}, d2 = {"Lcom/arizona/launcher/updater/archive/orchestrator/EngineResourceGenerationLoadResult$Loaded;", "Lcom/arizona/launcher/updater/archive/orchestrator/EngineResourceGenerationLoadResult;", RemoteConfigConstants.ResponseFieldKey.STATE, "Lcom/arizona/launcher/updater/archive/orchestrator/EngineResourceGenerationState;", "<init>", "(Lcom/arizona/launcher/updater/archive/orchestrator/EngineResourceGenerationState;)V", "getState", "()Lcom/arizona/launcher/updater/archive/orchestrator/EngineResourceGenerationState;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "app", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class Loaded implements EngineResourceGenerationLoadResult {
        public static final int $stable = 0;
        private final EngineResourceGenerationState state;

        public static /* synthetic */ Loaded copy$default(Loaded loaded, EngineResourceGenerationState engineResourceGenerationState, int i, Object obj) {
            if ((i & 1) != 0) {
                engineResourceGenerationState = loaded.state;
            }
            return loaded.copy(engineResourceGenerationState);
        }

        public final EngineResourceGenerationState component1() {
            return this.state;
        }

        public final Loaded copy(EngineResourceGenerationState state) {
            Intrinsics.checkNotNullParameter(state, "state");
            return new Loaded(state);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof Loaded) && Intrinsics.areEqual(this.state, ((Loaded) obj).state);
        }

        public int hashCode() {
            return this.state.hashCode();
        }

        public String toString() {
            return "Loaded(state=" + this.state + ")";
        }

        public Loaded(EngineResourceGenerationState state) {
            Intrinsics.checkNotNullParameter(state, "state");
            this.state = state;
        }

        public final EngineResourceGenerationState getState() {
            return this.state;
        }
    }

    /* compiled from: EngineResourceGenerationStore.kt */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0014\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0083\u0004J\n\u0010\u000e\u001a\u00020\u000fHÖ\u0081\u0004J\n\u0010\u0010\u001a\u00020\u0003HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007Ê\u0001\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\u0003\u0010\u0002¨\u0006\u0011"}, d2 = {"Lcom/arizona/launcher/updater/archive/orchestrator/EngineResourceGenerationLoadResult$Corrupt;", "Lcom/arizona/launcher/updater/archive/orchestrator/EngineResourceGenerationLoadResult;", "reason", "", "<init>", "(Ljava/lang/String;)V", "getReason", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "app", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class Corrupt implements EngineResourceGenerationLoadResult {
        public static final int $stable = 0;
        private final String reason;

        public static /* synthetic */ Corrupt copy$default(Corrupt corrupt, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = corrupt.reason;
            }
            return corrupt.copy(str);
        }

        public final String component1() {
            return this.reason;
        }

        public final Corrupt copy(String reason) {
            Intrinsics.checkNotNullParameter(reason, "reason");
            return new Corrupt(reason);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof Corrupt) && Intrinsics.areEqual(this.reason, ((Corrupt) obj).reason);
        }

        public int hashCode() {
            return this.reason.hashCode();
        }

        public String toString() {
            return "Corrupt(reason=" + this.reason + ")";
        }

        public Corrupt(String reason) {
            Intrinsics.checkNotNullParameter(reason, "reason");
            this.reason = reason;
        }

        public final String getReason() {
            return this.reason;
        }
    }
}
