package com.arizona.launcher.updater.archive.adoption;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: ArchiveInstallAdopter.kt */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bp\u0018\u00002\u00020\u0001:\u0002\u0006\u0007R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005\u0082\u0001\u0002\b\t¨\u0006\nÀ\u0006\u0003"}, d2 = {"Lcom/arizona/launcher/updater/archive/adoption/ArchiveAdoptionFileVerification;", "", "scannedBytes", "", "getScannedBytes", "()J", "Match", "Mismatch", "Lcom/arizona/launcher/updater/archive/adoption/ArchiveAdoptionFileVerification$Match;", "Lcom/arizona/launcher/updater/archive/adoption/ArchiveAdoptionFileVerification$Mismatch;", "app"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes3.dex */
public interface ArchiveAdoptionFileVerification {
    long getScannedBytes();

    /* compiled from: ArchiveInstallAdopter.kt */
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\r\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J'\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0003HÆ\u0001J\u0014\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013HÖ\u0083\u0004J\n\u0010\u0014\u001a\u00020\u0015HÖ\u0081\u0004J\n\u0010\u0016\u001a\u00020\u0017HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0014\u0010\u0005\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\tÊ\u0001\f\b\u0019\u0012\b\b\u001a\u0012\u0004\b\u0003\u0010\u0002¨\u0006\u0018"}, d2 = {"Lcom/arizona/launcher/updater/archive/adoption/ArchiveAdoptionFileVerification$Match;", "Lcom/arizona/launcher/updater/archive/adoption/ArchiveAdoptionFileVerification;", "size", "", "crc32", "scannedBytes", "<init>", "(JJJ)V", "getSize", "()J", "getCrc32", "getScannedBytes", "component1", "component2", "component3", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "app", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class Match implements ArchiveAdoptionFileVerification {
        public static final int $stable = 0;
        private final long crc32;
        private final long scannedBytes;
        private final long size;

        public static /* synthetic */ Match copy$default(Match match, long j, long j2, long j3, int i, Object obj) {
            if ((i & 1) != 0) {
                j = match.size;
            }
            long j4 = j;
            if ((i & 2) != 0) {
                j2 = match.crc32;
            }
            long j5 = j2;
            if ((i & 4) != 0) {
                j3 = match.scannedBytes;
            }
            return match.copy(j4, j5, j3);
        }

        public final long component1() {
            return this.size;
        }

        public final long component2() {
            return this.crc32;
        }

        public final long component3() {
            return this.scannedBytes;
        }

        public final Match copy(long j, long j2, long j3) {
            return new Match(j, j2, j3);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof Match) {
                Match match = (Match) obj;
                return this.size == match.size && this.crc32 == match.crc32 && this.scannedBytes == match.scannedBytes;
            }
            return false;
        }

        public int hashCode() {
            return (((Long.hashCode(this.size) * 31) + Long.hashCode(this.crc32)) * 31) + Long.hashCode(this.scannedBytes);
        }

        public String toString() {
            long j = this.size;
            long j2 = this.crc32;
            return "Match(size=" + j + ", crc32=" + j2 + ", scannedBytes=" + this.scannedBytes + ")";
        }

        public Match(long j, long j2, long j3) {
            this.size = j;
            this.crc32 = j2;
            this.scannedBytes = j3;
        }

        public /* synthetic */ Match(long j, long j2, long j3, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(j, j2, (i & 4) != 0 ? j : j3);
        }

        public final long getSize() {
            return this.size;
        }

        public final long getCrc32() {
            return this.crc32;
        }

        @Override // com.arizona.launcher.updater.archive.adoption.ArchiveAdoptionFileVerification
        public long getScannedBytes() {
            return this.scannedBytes;
        }
    }

    /* compiled from: ArchiveInstallAdopter.kt */
    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0014\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012HÖ\u0083\u0004J\n\u0010\u0013\u001a\u00020\u0014HÖ\u0081\u0004J\n\u0010\u0015\u001a\u00020\u0016HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bÊ\u0001\f\b\u0018\u0012\b\b\u0019\u0012\u0004\b\u0003\u0010\u0002¨\u0006\u0017"}, d2 = {"Lcom/arizona/launcher/updater/archive/adoption/ArchiveAdoptionFileVerification$Mismatch;", "Lcom/arizona/launcher/updater/archive/adoption/ArchiveAdoptionFileVerification;", "reason", "Lcom/arizona/launcher/updater/archive/adoption/ArchiveAdoptionMismatchReason;", "scannedBytes", "", "<init>", "(Lcom/arizona/launcher/updater/archive/adoption/ArchiveAdoptionMismatchReason;J)V", "getReason", "()Lcom/arizona/launcher/updater/archive/adoption/ArchiveAdoptionMismatchReason;", "getScannedBytes", "()J", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "app", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class Mismatch implements ArchiveAdoptionFileVerification {
        public static final int $stable = 0;
        private final ArchiveAdoptionMismatchReason reason;
        private final long scannedBytes;

        public static /* synthetic */ Mismatch copy$default(Mismatch mismatch, ArchiveAdoptionMismatchReason archiveAdoptionMismatchReason, long j, int i, Object obj) {
            if ((i & 1) != 0) {
                archiveAdoptionMismatchReason = mismatch.reason;
            }
            if ((i & 2) != 0) {
                j = mismatch.scannedBytes;
            }
            return mismatch.copy(archiveAdoptionMismatchReason, j);
        }

        public final ArchiveAdoptionMismatchReason component1() {
            return this.reason;
        }

        public final long component2() {
            return this.scannedBytes;
        }

        public final Mismatch copy(ArchiveAdoptionMismatchReason reason, long j) {
            Intrinsics.checkNotNullParameter(reason, "reason");
            return new Mismatch(reason, j);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof Mismatch) {
                Mismatch mismatch = (Mismatch) obj;
                return this.reason == mismatch.reason && this.scannedBytes == mismatch.scannedBytes;
            }
            return false;
        }

        public int hashCode() {
            return (this.reason.hashCode() * 31) + Long.hashCode(this.scannedBytes);
        }

        public String toString() {
            ArchiveAdoptionMismatchReason archiveAdoptionMismatchReason = this.reason;
            return "Mismatch(reason=" + archiveAdoptionMismatchReason + ", scannedBytes=" + this.scannedBytes + ")";
        }

        public Mismatch(ArchiveAdoptionMismatchReason reason, long j) {
            Intrinsics.checkNotNullParameter(reason, "reason");
            this.reason = reason;
            this.scannedBytes = j;
        }

        public /* synthetic */ Mismatch(ArchiveAdoptionMismatchReason archiveAdoptionMismatchReason, long j, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(archiveAdoptionMismatchReason, (i & 2) != 0 ? 0L : j);
        }

        public final ArchiveAdoptionMismatchReason getReason() {
            return this.reason;
        }

        @Override // com.arizona.launcher.updater.archive.adoption.ArchiveAdoptionFileVerification
        public long getScannedBytes() {
            return this.scannedBytes;
        }
    }
}
