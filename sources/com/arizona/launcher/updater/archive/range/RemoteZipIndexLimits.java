package com.arizona.launcher.updater.archive.range;

import com.arizona.launcher.updater.archive.orchestrator.OkHttpArchiveByteRangeSource;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
/* compiled from: RemoteZipIndexModels.kt */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0081\b\u0018\u00002\u00020\u0001B9\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0005\u0012\b\b\u0002\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0018\u001a\u00020\tHÆ\u0003J;\u0010\u0019\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\tHÆ\u0001J\u0014\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u001d\u001a\u00020\u0003HÖ\u0081\u0004J\n\u0010\u001e\u001a\u00020\u001fHÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000fR\u0011\u0010\u0007\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000fR\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013Ê\u0001\f\b!\u0012\b\b\"\u0012\u0004\b\u0003\u0010\u0002¨\u0006 "}, d2 = {"Lcom/arizona/launcher/updater/archive/range/RemoteZipIndexLimits;", "", "maxEntryCount", "", "maxCentralDirectoryBytes", "", "maxEntryUncompressedBytes", "maxTotalUncompressedBytes", "maxCompressionRatio", "", "<init>", "(IJJJD)V", "getMaxEntryCount", "()I", "getMaxCentralDirectoryBytes", "()J", "getMaxEntryUncompressedBytes", "getMaxTotalUncompressedBytes", "getMaxCompressionRatio", "()D", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "toString", "", "app", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class RemoteZipIndexLimits {
    public static final int $stable = 0;
    private final long maxCentralDirectoryBytes;
    private final double maxCompressionRatio;
    private final int maxEntryCount;
    private final long maxEntryUncompressedBytes;
    private final long maxTotalUncompressedBytes;

    public RemoteZipIndexLimits() {
        this(0, 0L, 0L, 0L, FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE, 31, null);
    }

    public static /* synthetic */ RemoteZipIndexLimits copy$default(RemoteZipIndexLimits remoteZipIndexLimits, int i, long j, long j2, long j3, double d, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = remoteZipIndexLimits.maxEntryCount;
        }
        if ((i2 & 2) != 0) {
            j = remoteZipIndexLimits.maxCentralDirectoryBytes;
        }
        if ((i2 & 4) != 0) {
            j2 = remoteZipIndexLimits.maxEntryUncompressedBytes;
        }
        if ((i2 & 8) != 0) {
            j3 = remoteZipIndexLimits.maxTotalUncompressedBytes;
        }
        if ((i2 & 16) != 0) {
            d = remoteZipIndexLimits.maxCompressionRatio;
        }
        double d2 = d;
        long j4 = j3;
        return remoteZipIndexLimits.copy(i, j, j2, j4, d2);
    }

    public final int component1() {
        return this.maxEntryCount;
    }

    public final long component2() {
        return this.maxCentralDirectoryBytes;
    }

    public final long component3() {
        return this.maxEntryUncompressedBytes;
    }

    public final long component4() {
        return this.maxTotalUncompressedBytes;
    }

    public final double component5() {
        return this.maxCompressionRatio;
    }

    public final RemoteZipIndexLimits copy(int i, long j, long j2, long j3, double d) {
        return new RemoteZipIndexLimits(i, j, j2, j3, d);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof RemoteZipIndexLimits) {
            RemoteZipIndexLimits remoteZipIndexLimits = (RemoteZipIndexLimits) obj;
            return this.maxEntryCount == remoteZipIndexLimits.maxEntryCount && this.maxCentralDirectoryBytes == remoteZipIndexLimits.maxCentralDirectoryBytes && this.maxEntryUncompressedBytes == remoteZipIndexLimits.maxEntryUncompressedBytes && this.maxTotalUncompressedBytes == remoteZipIndexLimits.maxTotalUncompressedBytes && Double.compare(this.maxCompressionRatio, remoteZipIndexLimits.maxCompressionRatio) == 0;
        }
        return false;
    }

    public int hashCode() {
        return (((((((Integer.hashCode(this.maxEntryCount) * 31) + Long.hashCode(this.maxCentralDirectoryBytes)) * 31) + Long.hashCode(this.maxEntryUncompressedBytes)) * 31) + Long.hashCode(this.maxTotalUncompressedBytes)) * 31) + Double.hashCode(this.maxCompressionRatio);
    }

    public String toString() {
        int i = this.maxEntryCount;
        long j = this.maxCentralDirectoryBytes;
        long j2 = this.maxEntryUncompressedBytes;
        long j3 = this.maxTotalUncompressedBytes;
        return "RemoteZipIndexLimits(maxEntryCount=" + i + ", maxCentralDirectoryBytes=" + j + ", maxEntryUncompressedBytes=" + j2 + ", maxTotalUncompressedBytes=" + j3 + ", maxCompressionRatio=" + this.maxCompressionRatio + ")";
    }

    public RemoteZipIndexLimits(int i, long j, long j2, long j3, double d) {
        this.maxEntryCount = i;
        this.maxCentralDirectoryBytes = j;
        this.maxEntryUncompressedBytes = j2;
        this.maxTotalUncompressedBytes = j3;
        this.maxCompressionRatio = d;
        if (i <= 0) {
            throw new IllegalArgumentException("maxEntryCount must be positive".toString());
        }
        if (j < 0) {
            throw new IllegalArgumentException("maxCentralDirectoryBytes must not be negative".toString());
        }
        if (j2 < 0) {
            throw new IllegalArgumentException("maxEntryUncompressedBytes must not be negative".toString());
        }
        if (j3 < 0) {
            throw new IllegalArgumentException("maxTotalUncompressedBytes must not be negative".toString());
        }
        if (Math.abs(d) > Double.MAX_VALUE || d <= FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE) {
            throw new IllegalArgumentException("maxCompressionRatio must be finite and positive".toString());
        }
    }

    public /* synthetic */ RemoteZipIndexLimits(int i, long j, long j2, long j3, double d, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? 250000 : i, (i2 & 2) != 0 ? OkHttpArchiveByteRangeSource.MAX_RANGE_BODY_BYTES : j, (i2 & 4) != 0 ? 8589934592L : j2, (i2 & 8) != 0 ? 34359738368L : j3, (i2 & 16) != 0 ? 500.0d : d);
    }

    public final int getMaxEntryCount() {
        return this.maxEntryCount;
    }

    public final long getMaxCentralDirectoryBytes() {
        return this.maxCentralDirectoryBytes;
    }

    public final long getMaxEntryUncompressedBytes() {
        return this.maxEntryUncompressedBytes;
    }

    public final long getMaxTotalUncompressedBytes() {
        return this.maxTotalUncompressedBytes;
    }

    public final double getMaxCompressionRatio() {
        return this.maxCompressionRatio;
    }
}
