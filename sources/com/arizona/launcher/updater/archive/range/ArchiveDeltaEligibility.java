package com.arizona.launcher.updater.archive.range;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: ArchiveRepresentationFencePolicy.kt */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bp\u0018\u00002\u00020\u0001:\u0002\u0002\u0003\u0082\u0001\u0002\u0004\u0005¨\u0006\u0006À\u0006\u0003"}, d2 = {"Lcom/arizona/launcher/updater/archive/range/ArchiveDeltaEligibility;", "", "Eligible", "Ineligible", "Lcom/arizona/launcher/updater/archive/range/ArchiveDeltaEligibility$Eligible;", "Lcom/arizona/launcher/updater/archive/range/ArchiveDeltaEligibility$Ineligible;", "app"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes3.dex */
public interface ArchiveDeltaEligibility {

    /* compiled from: ArchiveRepresentationFencePolicy.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0014\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0083\u0004J\n\u0010\b\u001a\u00020\tHÖ\u0081\u0004J\n\u0010\n\u001a\u00020\u000bHÖ\u0081\u0004Ê\u0001\f\b\r\u0012\b\b\u000e\u0012\u0004\b\u0003\u0010\u0002¨\u0006\f"}, d2 = {"Lcom/arizona/launcher/updater/archive/range/ArchiveDeltaEligibility$Eligible;", "Lcom/arizona/launcher/updater/archive/range/ArchiveDeltaEligibility;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "app", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class Eligible implements ArchiveDeltaEligibility {
        public static final int $stable = 0;
        public static final Eligible INSTANCE = new Eligible();

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof Eligible) {
                Eligible eligible = (Eligible) obj;
                return true;
            }
            return false;
        }

        public int hashCode() {
            return -1214196669;
        }

        public String toString() {
            return "Eligible";
        }

        private Eligible() {
        }
    }

    /* compiled from: ArchiveRepresentationFencePolicy.kt */
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0014\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0083\u0004J\n\u0010\u000e\u001a\u00020\u000fHÖ\u0081\u0004J\n\u0010\u0010\u001a\u00020\u0011HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007Ê\u0001\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\u0003\u0010\u0002¨\u0006\u0012"}, d2 = {"Lcom/arizona/launcher/updater/archive/range/ArchiveDeltaEligibility$Ineligible;", "Lcom/arizona/launcher/updater/archive/range/ArchiveDeltaEligibility;", "reason", "Lcom/arizona/launcher/updater/archive/range/ArchiveDeltaIneligibilityReason;", "<init>", "(Lcom/arizona/launcher/updater/archive/range/ArchiveDeltaIneligibilityReason;)V", "getReason", "()Lcom/arizona/launcher/updater/archive/range/ArchiveDeltaIneligibilityReason;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "app", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class Ineligible implements ArchiveDeltaEligibility {
        public static final int $stable = 0;
        private final ArchiveDeltaIneligibilityReason reason;

        public static /* synthetic */ Ineligible copy$default(Ineligible ineligible, ArchiveDeltaIneligibilityReason archiveDeltaIneligibilityReason, int i, Object obj) {
            if ((i & 1) != 0) {
                archiveDeltaIneligibilityReason = ineligible.reason;
            }
            return ineligible.copy(archiveDeltaIneligibilityReason);
        }

        public final ArchiveDeltaIneligibilityReason component1() {
            return this.reason;
        }

        public final Ineligible copy(ArchiveDeltaIneligibilityReason reason) {
            Intrinsics.checkNotNullParameter(reason, "reason");
            return new Ineligible(reason);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof Ineligible) && this.reason == ((Ineligible) obj).reason;
        }

        public int hashCode() {
            return this.reason.hashCode();
        }

        public String toString() {
            return "Ineligible(reason=" + this.reason + ")";
        }

        public Ineligible(ArchiveDeltaIneligibilityReason reason) {
            Intrinsics.checkNotNullParameter(reason, "reason");
            this.reason = reason;
        }

        public final ArchiveDeltaIneligibilityReason getReason() {
            return this.reason;
        }
    }
}
