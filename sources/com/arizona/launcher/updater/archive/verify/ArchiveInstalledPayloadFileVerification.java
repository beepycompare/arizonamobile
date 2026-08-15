package com.arizona.launcher.updater.archive.verify;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: ArchiveInstalledPayloadAuditor.kt */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bp\u0018\u00002\u00020\u0001:\u0002\u0002\u0003\u0082\u0001\u0002\u0004\u0005¨\u0006\u0006À\u0006\u0003"}, d2 = {"Lcom/arizona/launcher/updater/archive/verify/ArchiveInstalledPayloadFileVerification;", "", "Match", "Mismatch", "Lcom/arizona/launcher/updater/archive/verify/ArchiveInstalledPayloadFileVerification$Match;", "Lcom/arizona/launcher/updater/archive/verify/ArchiveInstalledPayloadFileVerification$Mismatch;", "app"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes3.dex */
public interface ArchiveInstalledPayloadFileVerification {

    /* compiled from: ArchiveInstalledPayloadAuditor.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0014\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0083\u0004J\n\u0010\b\u001a\u00020\tHÖ\u0081\u0004J\n\u0010\n\u001a\u00020\u000bHÖ\u0081\u0004Ê\u0001\f\b\r\u0012\b\b\u000e\u0012\u0004\b\u0003\u0010\u0002¨\u0006\f"}, d2 = {"Lcom/arizona/launcher/updater/archive/verify/ArchiveInstalledPayloadFileVerification$Match;", "Lcom/arizona/launcher/updater/archive/verify/ArchiveInstalledPayloadFileVerification;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "app", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class Match implements ArchiveInstalledPayloadFileVerification {
        public static final int $stable = 0;
        public static final Match INSTANCE = new Match();

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof Match) {
                Match match = (Match) obj;
                return true;
            }
            return false;
        }

        public int hashCode() {
            return 2027695411;
        }

        public String toString() {
            return "Match";
        }

        private Match() {
        }
    }

    /* compiled from: ArchiveInstalledPayloadAuditor.kt */
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0014\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0083\u0004J\n\u0010\u000e\u001a\u00020\u000fHÖ\u0081\u0004J\n\u0010\u0010\u001a\u00020\u0011HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007Ê\u0001\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\u0003\u0010\u0002¨\u0006\u0012"}, d2 = {"Lcom/arizona/launcher/updater/archive/verify/ArchiveInstalledPayloadFileVerification$Mismatch;", "Lcom/arizona/launcher/updater/archive/verify/ArchiveInstalledPayloadFileVerification;", "reason", "Lcom/arizona/launcher/updater/archive/verify/ArchiveInstalledPayloadMismatchReason;", "<init>", "(Lcom/arizona/launcher/updater/archive/verify/ArchiveInstalledPayloadMismatchReason;)V", "getReason", "()Lcom/arizona/launcher/updater/archive/verify/ArchiveInstalledPayloadMismatchReason;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "app", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class Mismatch implements ArchiveInstalledPayloadFileVerification {
        public static final int $stable = 0;
        private final ArchiveInstalledPayloadMismatchReason reason;

        public static /* synthetic */ Mismatch copy$default(Mismatch mismatch, ArchiveInstalledPayloadMismatchReason archiveInstalledPayloadMismatchReason, int i, Object obj) {
            if ((i & 1) != 0) {
                archiveInstalledPayloadMismatchReason = mismatch.reason;
            }
            return mismatch.copy(archiveInstalledPayloadMismatchReason);
        }

        public final ArchiveInstalledPayloadMismatchReason component1() {
            return this.reason;
        }

        public final Mismatch copy(ArchiveInstalledPayloadMismatchReason reason) {
            Intrinsics.checkNotNullParameter(reason, "reason");
            return new Mismatch(reason);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof Mismatch) && this.reason == ((Mismatch) obj).reason;
        }

        public int hashCode() {
            return this.reason.hashCode();
        }

        public String toString() {
            return "Mismatch(reason=" + this.reason + ")";
        }

        public Mismatch(ArchiveInstalledPayloadMismatchReason reason) {
            Intrinsics.checkNotNullParameter(reason, "reason");
            this.reason = reason;
        }

        public final ArchiveInstalledPayloadMismatchReason getReason() {
            return this.reason;
        }
    }
}
