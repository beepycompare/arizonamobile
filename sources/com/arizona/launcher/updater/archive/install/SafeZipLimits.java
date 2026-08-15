package com.arizona.launcher.updater.archive.install;

import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
/* compiled from: SafeZipExtractor.kt */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0081\b\u0018\u00002\u00020\u0001B/\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0015\u001a\u00020\bHÆ\u0003J1\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\bHÆ\u0001J\u0014\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u001a\u001a\u00020\u0003HÖ\u0081\u0004J\n\u0010\u001b\u001a\u00020\u001cHÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011Ê\u0001\f\b\u001e\u0012\b\b\u001f\u0012\u0004\b\u0003\u0010\u0002¨\u0006\u001d"}, d2 = {"Lcom/arizona/launcher/updater/archive/install/SafeZipLimits;", "", "maxEntryCount", "", "maxEntryUncompressedBytes", "", "maxTotalUncompressedBytes", "maxCompressionRatio", "", "<init>", "(IJJD)V", "getMaxEntryCount", "()I", "getMaxEntryUncompressedBytes", "()J", "getMaxTotalUncompressedBytes", "getMaxCompressionRatio", "()D", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "toString", "", "app", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class SafeZipLimits {
    public static final int $stable = 0;
    private final double maxCompressionRatio;
    private final int maxEntryCount;
    private final long maxEntryUncompressedBytes;
    private final long maxTotalUncompressedBytes;

    public SafeZipLimits() {
        this(0, 0L, 0L, FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE, 15, null);
    }

    public static /* synthetic */ SafeZipLimits copy$default(SafeZipLimits safeZipLimits, int i, long j, long j2, double d, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = safeZipLimits.maxEntryCount;
        }
        if ((i2 & 2) != 0) {
            j = safeZipLimits.maxEntryUncompressedBytes;
        }
        if ((i2 & 4) != 0) {
            j2 = safeZipLimits.maxTotalUncompressedBytes;
        }
        if ((i2 & 8) != 0) {
            d = safeZipLimits.maxCompressionRatio;
        }
        double d2 = d;
        return safeZipLimits.copy(i, j, j2, d2);
    }

    public final int component1() {
        return this.maxEntryCount;
    }

    public final long component2() {
        return this.maxEntryUncompressedBytes;
    }

    public final long component3() {
        return this.maxTotalUncompressedBytes;
    }

    public final double component4() {
        return this.maxCompressionRatio;
    }

    public final SafeZipLimits copy(int i, long j, long j2, double d) {
        return new SafeZipLimits(i, j, j2, d);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof SafeZipLimits) {
            SafeZipLimits safeZipLimits = (SafeZipLimits) obj;
            return this.maxEntryCount == safeZipLimits.maxEntryCount && this.maxEntryUncompressedBytes == safeZipLimits.maxEntryUncompressedBytes && this.maxTotalUncompressedBytes == safeZipLimits.maxTotalUncompressedBytes && Double.compare(this.maxCompressionRatio, safeZipLimits.maxCompressionRatio) == 0;
        }
        return false;
    }

    public int hashCode() {
        return (((((Integer.hashCode(this.maxEntryCount) * 31) + Long.hashCode(this.maxEntryUncompressedBytes)) * 31) + Long.hashCode(this.maxTotalUncompressedBytes)) * 31) + Double.hashCode(this.maxCompressionRatio);
    }

    public String toString() {
        int i = this.maxEntryCount;
        long j = this.maxEntryUncompressedBytes;
        long j2 = this.maxTotalUncompressedBytes;
        return "SafeZipLimits(maxEntryCount=" + i + ", maxEntryUncompressedBytes=" + j + ", maxTotalUncompressedBytes=" + j2 + ", maxCompressionRatio=" + this.maxCompressionRatio + ")";
    }

    public SafeZipLimits(int i, long j, long j2, double d) {
        this.maxEntryCount = i;
        this.maxEntryUncompressedBytes = j;
        this.maxTotalUncompressedBytes = j2;
        this.maxCompressionRatio = d;
        if (i <= 0) {
            throw new IllegalArgumentException("maxEntryCount must be positive".toString());
        }
        if (j < 0) {
            throw new IllegalArgumentException("maxEntryUncompressedBytes must not be negative".toString());
        }
        if (j2 < 0) {
            throw new IllegalArgumentException("maxTotalUncompressedBytes must not be negative".toString());
        }
        if (Math.abs(d) > Double.MAX_VALUE || d <= FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE) {
            throw new IllegalArgumentException("maxCompressionRatio must be finite and positive".toString());
        }
    }

    public /* synthetic */ SafeZipLimits(int i, long j, long j2, double d, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? 250000 : i, (i2 & 2) != 0 ? 8589934592L : j, (i2 & 4) != 0 ? 34359738368L : j2, (i2 & 8) != 0 ? 500.0d : d);
    }

    public final int getMaxEntryCount() {
        return this.maxEntryCount;
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
