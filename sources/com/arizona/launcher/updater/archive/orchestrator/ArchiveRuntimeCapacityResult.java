package com.arizona.launcher.updater.archive.orchestrator;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: ArchiveDownloadAheadPolicy.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bp\u0018\u00002\u00020\u0001:\u0003\u0006\u0007\bR\u0014\u0010\u0002\u001a\u0004\u0018\u00010\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005\u0082\u0001\u0003\t\n\u000b¨\u0006\fÀ\u0006\u0003"}, d2 = {"Lcom/arizona/launcher/updater/archive/orchestrator/ArchiveRuntimeCapacityResult;", "", "requiredFreeSpaceBytes", "", "getRequiredFreeSpaceBytes", "()Ljava/lang/Long;", "Sufficient", "Insufficient", "Unavailable", "Lcom/arizona/launcher/updater/archive/orchestrator/ArchiveRuntimeCapacityResult$Insufficient;", "Lcom/arizona/launcher/updater/archive/orchestrator/ArchiveRuntimeCapacityResult$Sufficient;", "Lcom/arizona/launcher/updater/archive/orchestrator/ArchiveRuntimeCapacityResult$Unavailable;", "app"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes3.dex */
public interface ArchiveRuntimeCapacityResult {
    Long getRequiredFreeSpaceBytes();

    /* compiled from: ArchiveDownloadAheadPolicy.kt */
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0014\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0083\u0004J\n\u0010\u000e\u001a\u00020\u000fHÖ\u0081\u0004J\n\u0010\u0010\u001a\u00020\u0011HÖ\u0081\u0004R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007Ê\u0001\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\u0003\u0010\u0002¨\u0006\u0012"}, d2 = {"Lcom/arizona/launcher/updater/archive/orchestrator/ArchiveRuntimeCapacityResult$Sufficient;", "Lcom/arizona/launcher/updater/archive/orchestrator/ArchiveRuntimeCapacityResult;", "requiredFreeSpaceBytes", "", "<init>", "(J)V", "getRequiredFreeSpaceBytes", "()Ljava/lang/Long;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "app", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class Sufficient implements ArchiveRuntimeCapacityResult {
        public static final int $stable = 0;
        private final long requiredFreeSpaceBytes;

        public static /* synthetic */ Sufficient copy$default(Sufficient sufficient, long j, int i, Object obj) {
            if ((i & 1) != 0) {
                j = sufficient.requiredFreeSpaceBytes;
            }
            return sufficient.copy(j);
        }

        public final long component1() {
            return this.requiredFreeSpaceBytes;
        }

        public final Sufficient copy(long j) {
            return new Sufficient(j);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof Sufficient) && this.requiredFreeSpaceBytes == ((Sufficient) obj).requiredFreeSpaceBytes;
        }

        public int hashCode() {
            return Long.hashCode(this.requiredFreeSpaceBytes);
        }

        public String toString() {
            return "Sufficient(requiredFreeSpaceBytes=" + this.requiredFreeSpaceBytes + ")";
        }

        public Sufficient(long j) {
            this.requiredFreeSpaceBytes = j;
        }

        @Override // com.arizona.launcher.updater.archive.orchestrator.ArchiveRuntimeCapacityResult
        public Long getRequiredFreeSpaceBytes() {
            return Long.valueOf(this.requiredFreeSpaceBytes);
        }
    }

    /* compiled from: ArchiveDownloadAheadPolicy.kt */
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0014\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011HÖ\u0083\u0004J\n\u0010\u0012\u001a\u00020\u0013HÖ\u0081\u0004J\n\u0010\u0014\u001a\u00020\u0015HÖ\u0081\u0004R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nÊ\u0001\f\b\u0017\u0012\b\b\u0018\u0012\u0004\b\u0003\u0010\u0002¨\u0006\u0016"}, d2 = {"Lcom/arizona/launcher/updater/archive/orchestrator/ArchiveRuntimeCapacityResult$Insufficient;", "Lcom/arizona/launcher/updater/archive/orchestrator/ArchiveRuntimeCapacityResult;", "requiredFreeSpaceBytes", "", "availableBytes", "<init>", "(JJ)V", "getRequiredFreeSpaceBytes", "()Ljava/lang/Long;", "getAvailableBytes", "()J", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "app", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class Insufficient implements ArchiveRuntimeCapacityResult {
        public static final int $stable = 0;
        private final long availableBytes;
        private final long requiredFreeSpaceBytes;

        public static /* synthetic */ Insufficient copy$default(Insufficient insufficient, long j, long j2, int i, Object obj) {
            if ((i & 1) != 0) {
                j = insufficient.requiredFreeSpaceBytes;
            }
            if ((i & 2) != 0) {
                j2 = insufficient.availableBytes;
            }
            return insufficient.copy(j, j2);
        }

        public final long component1() {
            return this.requiredFreeSpaceBytes;
        }

        public final long component2() {
            return this.availableBytes;
        }

        public final Insufficient copy(long j, long j2) {
            return new Insufficient(j, j2);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof Insufficient) {
                Insufficient insufficient = (Insufficient) obj;
                return this.requiredFreeSpaceBytes == insufficient.requiredFreeSpaceBytes && this.availableBytes == insufficient.availableBytes;
            }
            return false;
        }

        public int hashCode() {
            return (Long.hashCode(this.requiredFreeSpaceBytes) * 31) + Long.hashCode(this.availableBytes);
        }

        public String toString() {
            long j = this.requiredFreeSpaceBytes;
            return "Insufficient(requiredFreeSpaceBytes=" + j + ", availableBytes=" + this.availableBytes + ")";
        }

        public Insufficient(long j, long j2) {
            this.requiredFreeSpaceBytes = j;
            this.availableBytes = j2;
        }

        @Override // com.arizona.launcher.updater.archive.orchestrator.ArchiveRuntimeCapacityResult
        public Long getRequiredFreeSpaceBytes() {
            return Long.valueOf(this.requiredFreeSpaceBytes);
        }

        public final long getAvailableBytes() {
            return this.availableBytes;
        }
    }

    /* compiled from: ArchiveDownloadAheadPolicy.kt */
    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u001f\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u000bJ&\u0010\u000f\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u0010\u0010J\u0014\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014HÖ\u0083\u0004J\n\u0010\u0015\u001a\u00020\u0016HÖ\u0081\u0004J\n\u0010\u0017\u001a\u00020\u0003HÖ\u0081\u0004R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0096\u0004¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\n\u0010\u000bÊ\u0001\f\b\u0019\u0012\b\b\u001a\u0012\u0004\b\u0003\u0010\u0002¨\u0006\u0018"}, d2 = {"Lcom/arizona/launcher/updater/archive/orchestrator/ArchiveRuntimeCapacityResult$Unavailable;", "Lcom/arizona/launcher/updater/archive/orchestrator/ArchiveRuntimeCapacityResult;", "detail", "", "requiredFreeSpaceBytes", "", "<init>", "(Ljava/lang/String;Ljava/lang/Long;)V", "getDetail", "()Ljava/lang/String;", "getRequiredFreeSpaceBytes", "()Ljava/lang/Long;", "Ljava/lang/Long;", "component1", "component2", "copy", "(Ljava/lang/String;Ljava/lang/Long;)Lcom/arizona/launcher/updater/archive/orchestrator/ArchiveRuntimeCapacityResult$Unavailable;", "equals", "", "other", "", "hashCode", "", "toString", "app", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class Unavailable implements ArchiveRuntimeCapacityResult {
        public static final int $stable = 0;
        private final String detail;
        private final Long requiredFreeSpaceBytes;

        public Unavailable() {
            this(null, null, 3, null);
        }

        public static /* synthetic */ Unavailable copy$default(Unavailable unavailable, String str, Long l, int i, Object obj) {
            if ((i & 1) != 0) {
                str = unavailable.detail;
            }
            if ((i & 2) != 0) {
                l = unavailable.requiredFreeSpaceBytes;
            }
            return unavailable.copy(str, l);
        }

        public final String component1() {
            return this.detail;
        }

        public final Long component2() {
            return this.requiredFreeSpaceBytes;
        }

        public final Unavailable copy(String str, Long l) {
            return new Unavailable(str, l);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof Unavailable) {
                Unavailable unavailable = (Unavailable) obj;
                return Intrinsics.areEqual(this.detail, unavailable.detail) && Intrinsics.areEqual(this.requiredFreeSpaceBytes, unavailable.requiredFreeSpaceBytes);
            }
            return false;
        }

        public int hashCode() {
            String str = this.detail;
            int hashCode = (str == null ? 0 : str.hashCode()) * 31;
            Long l = this.requiredFreeSpaceBytes;
            return hashCode + (l != null ? l.hashCode() : 0);
        }

        public String toString() {
            String str = this.detail;
            return "Unavailable(detail=" + str + ", requiredFreeSpaceBytes=" + this.requiredFreeSpaceBytes + ")";
        }

        public Unavailable(String str, Long l) {
            this.detail = str;
            this.requiredFreeSpaceBytes = l;
        }

        public /* synthetic */ Unavailable(String str, Long l, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : l);
        }

        public final String getDetail() {
            return this.detail;
        }

        @Override // com.arizona.launcher.updater.archive.orchestrator.ArchiveRuntimeCapacityResult
        public Long getRequiredFreeSpaceBytes() {
            return this.requiredFreeSpaceBytes;
        }
    }
}
