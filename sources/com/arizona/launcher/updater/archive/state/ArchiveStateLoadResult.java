package com.arizona.launcher.updater.archive.state;

import com.google.firebase.remoteconfig.RemoteConfigConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: ArchiveStateLoadResult.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b7\u0018\u00002\u00020\u0001:\u0003\u0004\u0005\u0006B\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0003\u0007\b\tÊ\u0001\f\b\u000b\u0012\b\b\f\u0012\u0004\b\u0003\u0010\u0000¨\u0006\n"}, d2 = {"Lcom/arizona/launcher/updater/archive/state/ArchiveStateLoadResult;", "", "<init>", "()V", "Missing", "Loaded", "Corrupt", "Lcom/arizona/launcher/updater/archive/state/ArchiveStateLoadResult$Corrupt;", "Lcom/arizona/launcher/updater/archive/state/ArchiveStateLoadResult$Loaded;", "Lcom/arizona/launcher/updater/archive/state/ArchiveStateLoadResult$Missing;", "app", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes3.dex */
public abstract class ArchiveStateLoadResult {
    public static final int $stable = 8;

    public /* synthetic */ ArchiveStateLoadResult(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    private ArchiveStateLoadResult() {
    }

    /* compiled from: ArchiveStateLoadResult.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0014\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0083\u0004J\n\u0010\b\u001a\u00020\tHÖ\u0081\u0004J\n\u0010\n\u001a\u00020\u000bHÖ\u0081\u0004Ê\u0001\f\b\r\u0012\b\b\u000e\u0012\u0004\b\u0003\u0010\u0002¨\u0006\f"}, d2 = {"Lcom/arizona/launcher/updater/archive/state/ArchiveStateLoadResult$Missing;", "Lcom/arizona/launcher/updater/archive/state/ArchiveStateLoadResult;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "app", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class Missing extends ArchiveStateLoadResult {
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
            return 1768241547;
        }

        public String toString() {
            return "Missing";
        }

        private Missing() {
            super(null);
        }
    }

    /* compiled from: ArchiveStateLoadResult.kt */
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0014\u0010\u000f\u001a\u00020\u00052\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011HÖ\u0083\u0004J\n\u0010\u0012\u001a\u00020\u0013HÖ\u0081\u0004J\n\u0010\u0014\u001a\u00020\u0015HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bÊ\u0001\f\b\u0017\u0012\b\b\u0018\u0012\u0004\b\u0003\u0010\u0000¨\u0006\u0016"}, d2 = {"Lcom/arizona/launcher/updater/archive/state/ArchiveStateLoadResult$Loaded;", "Lcom/arizona/launcher/updater/archive/state/ArchiveStateLoadResult;", RemoteConfigConstants.ResponseFieldKey.STATE, "Lcom/arizona/launcher/updater/archive/state/ArchiveUpdaterState;", "recoveredFromBackup", "", "<init>", "(Lcom/arizona/launcher/updater/archive/state/ArchiveUpdaterState;Z)V", "getState", "()Lcom/arizona/launcher/updater/archive/state/ArchiveUpdaterState;", "getRecoveredFromBackup", "()Z", "component1", "component2", "copy", "equals", "other", "", "hashCode", "", "toString", "", "app", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class Loaded extends ArchiveStateLoadResult {
        public static final int $stable = ArchiveUpdaterState.$stable;
        private final boolean recoveredFromBackup;
        private final ArchiveUpdaterState state;

        public static /* synthetic */ Loaded copy$default(Loaded loaded, ArchiveUpdaterState archiveUpdaterState, boolean z, int i, Object obj) {
            if ((i & 1) != 0) {
                archiveUpdaterState = loaded.state;
            }
            if ((i & 2) != 0) {
                z = loaded.recoveredFromBackup;
            }
            return loaded.copy(archiveUpdaterState, z);
        }

        public final ArchiveUpdaterState component1() {
            return this.state;
        }

        public final boolean component2() {
            return this.recoveredFromBackup;
        }

        public final Loaded copy(ArchiveUpdaterState state, boolean z) {
            Intrinsics.checkNotNullParameter(state, "state");
            return new Loaded(state, z);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof Loaded) {
                Loaded loaded = (Loaded) obj;
                return Intrinsics.areEqual(this.state, loaded.state) && this.recoveredFromBackup == loaded.recoveredFromBackup;
            }
            return false;
        }

        public int hashCode() {
            return (this.state.hashCode() * 31) + Boolean.hashCode(this.recoveredFromBackup);
        }

        public String toString() {
            ArchiveUpdaterState archiveUpdaterState = this.state;
            return "Loaded(state=" + archiveUpdaterState + ", recoveredFromBackup=" + this.recoveredFromBackup + ")";
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Loaded(ArchiveUpdaterState state, boolean z) {
            super(null);
            Intrinsics.checkNotNullParameter(state, "state");
            this.state = state;
            this.recoveredFromBackup = z;
        }

        public /* synthetic */ Loaded(ArchiveUpdaterState archiveUpdaterState, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(archiveUpdaterState, (i & 2) != 0 ? false : z);
        }

        public final ArchiveUpdaterState getState() {
            return this.state;
        }

        public final boolean getRecoveredFromBackup() {
            return this.recoveredFromBackup;
        }
    }

    /* compiled from: ArchiveStateLoadResult.kt */
    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0003\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u001f\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0014\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012HÖ\u0083\u0004J\n\u0010\u0013\u001a\u00020\u0014HÖ\u0081\u0004J\n\u0010\u0015\u001a\u00020\u0003HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bÊ\u0001\f\b\u0017\u0012\b\b\u0018\u0012\u0004\b\u0003\u0010\u0000¨\u0006\u0016"}, d2 = {"Lcom/arizona/launcher/updater/archive/state/ArchiveStateLoadResult$Corrupt;", "Lcom/arizona/launcher/updater/archive/state/ArchiveStateLoadResult;", "reason", "", "cause", "", "<init>", "(Ljava/lang/String;Ljava/lang/Throwable;)V", "getReason", "()Ljava/lang/String;", "getCause", "()Ljava/lang/Throwable;", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "app", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class Corrupt extends ArchiveStateLoadResult {
        public static final int $stable = 8;
        private final Throwable cause;
        private final String reason;

        public static /* synthetic */ Corrupt copy$default(Corrupt corrupt, String str, Throwable th, int i, Object obj) {
            if ((i & 1) != 0) {
                str = corrupt.reason;
            }
            if ((i & 2) != 0) {
                th = corrupt.cause;
            }
            return corrupt.copy(str, th);
        }

        public final String component1() {
            return this.reason;
        }

        public final Throwable component2() {
            return this.cause;
        }

        public final Corrupt copy(String reason, Throwable th) {
            Intrinsics.checkNotNullParameter(reason, "reason");
            return new Corrupt(reason, th);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof Corrupt) {
                Corrupt corrupt = (Corrupt) obj;
                return Intrinsics.areEqual(this.reason, corrupt.reason) && Intrinsics.areEqual(this.cause, corrupt.cause);
            }
            return false;
        }

        public int hashCode() {
            int hashCode = this.reason.hashCode() * 31;
            Throwable th = this.cause;
            return hashCode + (th == null ? 0 : th.hashCode());
        }

        public String toString() {
            String str = this.reason;
            return "Corrupt(reason=" + str + ", cause=" + this.cause + ")";
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Corrupt(String reason, Throwable th) {
            super(null);
            Intrinsics.checkNotNullParameter(reason, "reason");
            this.reason = reason;
            this.cause = th;
        }

        public /* synthetic */ Corrupt(String str, Throwable th, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, (i & 2) != 0 ? null : th);
        }

        public final String getReason() {
            return this.reason;
        }

        public final Throwable getCause() {
            return this.cause;
        }
    }
}
