package com.arizona.launcher.updater.apk;

import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.ranges.RangesKt;
/* compiled from: LauncherApkModels.kt */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0081\b\u0018\u00002\u00020\u0001B/\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ\u000e\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0017\u001a\u00020\bHÆ\u0003J1\u0010\u0018\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\bHÆ\u0001J\u0014\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u001c\u001a\u00020\u0003HÖ\u0081\u0004J\n\u0010\u001d\u001a\u00020\u001eHÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011Ê\u0001\f\b \u0012\b\b!\u0012\u0004\b\u0003\u0010\u0002¨\u0006\u001f"}, d2 = {"Lcom/arizona/launcher/updater/apk/LauncherApkRetryPolicy;", "", "maxAttempts", "", "initialDelayMs", "", "maxDelayMs", "multiplier", "", "<init>", "(IJJD)V", "getMaxAttempts", "()I", "getInitialDelayMs", "()J", "getMaxDelayMs", "getMultiplier", "()D", "delayBeforeAttempt", "nextAttempt", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "toString", "", "app", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class LauncherApkRetryPolicy {
    public static final int $stable = 0;
    private final long initialDelayMs;
    private final int maxAttempts;
    private final long maxDelayMs;
    private final double multiplier;

    public LauncherApkRetryPolicy() {
        this(0, 0L, 0L, FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE, 15, null);
    }

    public static /* synthetic */ LauncherApkRetryPolicy copy$default(LauncherApkRetryPolicy launcherApkRetryPolicy, int i, long j, long j2, double d, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = launcherApkRetryPolicy.maxAttempts;
        }
        if ((i2 & 2) != 0) {
            j = launcherApkRetryPolicy.initialDelayMs;
        }
        if ((i2 & 4) != 0) {
            j2 = launcherApkRetryPolicy.maxDelayMs;
        }
        if ((i2 & 8) != 0) {
            d = launcherApkRetryPolicy.multiplier;
        }
        double d2 = d;
        return launcherApkRetryPolicy.copy(i, j, j2, d2);
    }

    public final int component1() {
        return this.maxAttempts;
    }

    public final long component2() {
        return this.initialDelayMs;
    }

    public final long component3() {
        return this.maxDelayMs;
    }

    public final double component4() {
        return this.multiplier;
    }

    public final LauncherApkRetryPolicy copy(int i, long j, long j2, double d) {
        return new LauncherApkRetryPolicy(i, j, j2, d);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof LauncherApkRetryPolicy) {
            LauncherApkRetryPolicy launcherApkRetryPolicy = (LauncherApkRetryPolicy) obj;
            return this.maxAttempts == launcherApkRetryPolicy.maxAttempts && this.initialDelayMs == launcherApkRetryPolicy.initialDelayMs && this.maxDelayMs == launcherApkRetryPolicy.maxDelayMs && Double.compare(this.multiplier, launcherApkRetryPolicy.multiplier) == 0;
        }
        return false;
    }

    public int hashCode() {
        return (((((Integer.hashCode(this.maxAttempts) * 31) + Long.hashCode(this.initialDelayMs)) * 31) + Long.hashCode(this.maxDelayMs)) * 31) + Double.hashCode(this.multiplier);
    }

    public String toString() {
        int i = this.maxAttempts;
        long j = this.initialDelayMs;
        long j2 = this.maxDelayMs;
        return "LauncherApkRetryPolicy(maxAttempts=" + i + ", initialDelayMs=" + j + ", maxDelayMs=" + j2 + ", multiplier=" + this.multiplier + ")";
    }

    public LauncherApkRetryPolicy(int i, long j, long j2, double d) {
        this.maxAttempts = i;
        this.initialDelayMs = j;
        this.maxDelayMs = j2;
        this.multiplier = d;
        if (i <= 0) {
            throw new IllegalArgumentException("maxAttempts must be positive".toString());
        }
        if (j < 0) {
            throw new IllegalArgumentException("initialDelayMs must not be negative".toString());
        }
        if (j2 < j) {
            throw new IllegalArgumentException("maxDelayMs must be at least initialDelayMs".toString());
        }
        if (d < 1.0d) {
            throw new IllegalArgumentException("multiplier must be at least 1".toString());
        }
    }

    public /* synthetic */ LauncherApkRetryPolicy(int i, long j, long j2, double d, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? 3 : i, (i2 & 2) != 0 ? 1000L : j, (i2 & 4) != 0 ? 8000L : j2, (i2 & 8) != 0 ? 2.0d : d);
    }

    public final int getMaxAttempts() {
        return this.maxAttempts;
    }

    public final long getInitialDelayMs() {
        return this.initialDelayMs;
    }

    public final long getMaxDelayMs() {
        return this.maxDelayMs;
    }

    public final double getMultiplier() {
        return this.multiplier;
    }

    public final long delayBeforeAttempt(int i) {
        if (2 > i || i > this.maxAttempts) {
            throw new IllegalArgumentException("nextAttempt is outside the retry policy".toString());
        }
        double d = this.initialDelayMs;
        int i2 = i - 2;
        for (int i3 = 0; i3 < i2; i3++) {
            d = RangesKt.coerceAtMost(d * this.multiplier, this.maxDelayMs);
        }
        return RangesKt.coerceAtMost((long) d, this.maxDelayMs);
    }
}
