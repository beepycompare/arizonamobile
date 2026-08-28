package com.arizona.launcher;

import com.arizona.launcher.updater.archive.download.ArchiveNetworkMonitorKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
/* compiled from: DownloadRetryPolicy.kt */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0013\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0087\b\u0018\u0000 \u001c2\u00020\u0001:\u0001\u001cB/\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\t\u0010\nJ\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0007HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0007HÆ\u0003J1\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u0007HÆ\u0001J\u0014\u0010\u0017\u001a\u00020\u00032\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0019\u001a\u00020\u0005HÖ\u0081\u0004J\n\u0010\u001a\u001a\u00020\u001bHÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\b\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010Ê\u0001\f\b\u001e\u0012\b\b\u001f\u0012\u0004\b\u0003\u0010\u0002¨\u0006\u001d"}, d2 = {"Lcom/arizona/launcher/DownloadRetryConfig;", "", "enabled", "", "maxRetries", "", "baseDelayMs", "", "capDelayMs", "<init>", "(ZIJJ)V", "getEnabled", "()Z", "getMaxRetries", "()I", "getBaseDelayMs", "()J", "getCapDelayMs", "component1", "component2", "component3", "component4", "copy", "equals", "other", "hashCode", "toString", "", "Companion", "app", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class DownloadRetryConfig {
    public static final int $stable = 0;
    public static final Companion Companion = new Companion(null);
    private static final DownloadRetryConfig DEFAULT = new DownloadRetryConfig(false, 0, 0, 0, 15, null);
    private final long baseDelayMs;
    private final long capDelayMs;
    private final boolean enabled;
    private final int maxRetries;

    public DownloadRetryConfig() {
        this(false, 0, 0L, 0L, 15, null);
    }

    public static /* synthetic */ DownloadRetryConfig copy$default(DownloadRetryConfig downloadRetryConfig, boolean z, int i, long j, long j2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            z = downloadRetryConfig.enabled;
        }
        if ((i2 & 2) != 0) {
            i = downloadRetryConfig.maxRetries;
        }
        if ((i2 & 4) != 0) {
            j = downloadRetryConfig.baseDelayMs;
        }
        if ((i2 & 8) != 0) {
            j2 = downloadRetryConfig.capDelayMs;
        }
        long j3 = j2;
        return downloadRetryConfig.copy(z, i, j, j3);
    }

    public final boolean component1() {
        return this.enabled;
    }

    public final int component2() {
        return this.maxRetries;
    }

    public final long component3() {
        return this.baseDelayMs;
    }

    public final long component4() {
        return this.capDelayMs;
    }

    public final DownloadRetryConfig copy(boolean z, int i, long j, long j2) {
        return new DownloadRetryConfig(z, i, j, j2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof DownloadRetryConfig) {
            DownloadRetryConfig downloadRetryConfig = (DownloadRetryConfig) obj;
            return this.enabled == downloadRetryConfig.enabled && this.maxRetries == downloadRetryConfig.maxRetries && this.baseDelayMs == downloadRetryConfig.baseDelayMs && this.capDelayMs == downloadRetryConfig.capDelayMs;
        }
        return false;
    }

    public int hashCode() {
        return (((((Boolean.hashCode(this.enabled) * 31) + Integer.hashCode(this.maxRetries)) * 31) + Long.hashCode(this.baseDelayMs)) * 31) + Long.hashCode(this.capDelayMs);
    }

    public String toString() {
        boolean z = this.enabled;
        int i = this.maxRetries;
        long j = this.baseDelayMs;
        return "DownloadRetryConfig(enabled=" + z + ", maxRetries=" + i + ", baseDelayMs=" + j + ", capDelayMs=" + this.capDelayMs + ")";
    }

    public DownloadRetryConfig(boolean z, int i, long j, long j2) {
        this.enabled = z;
        this.maxRetries = i;
        this.baseDelayMs = j;
        this.capDelayMs = j2;
        if (i < 0) {
            throw new IllegalArgumentException(("maxRetries must be >= 0, was " + i).toString());
        }
        if (j < 0) {
            throw new IllegalArgumentException(("baseDelayMs must be >= 0, was " + j).toString());
        }
        if (j2 < 0) {
            throw new IllegalArgumentException(("capDelayMs must be >= 0, was " + j2).toString());
        }
    }

    public /* synthetic */ DownloadRetryConfig(boolean z, int i, long j, long j2, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? true : z, (i2 & 2) != 0 ? 3 : i, (i2 & 4) != 0 ? 2000L : j, (i2 & 8) != 0 ? ArchiveNetworkMonitorKt.ARCHIVE_NETWORK_RECONNECT_TIMEOUT_MS : j2);
    }

    public final boolean getEnabled() {
        return this.enabled;
    }

    public final int getMaxRetries() {
        return this.maxRetries;
    }

    public final long getBaseDelayMs() {
        return this.baseDelayMs;
    }

    public final long getCapDelayMs() {
        return this.capDelayMs;
    }

    /* compiled from: DownloadRetryPolicy.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/arizona/launcher/DownloadRetryConfig$Companion;", "", "<init>", "()V", "DEFAULT", "Lcom/arizona/launcher/DownloadRetryConfig;", "getDEFAULT", "()Lcom/arizona/launcher/DownloadRetryConfig;", "app"}, k = 1, mv = {2, 4, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final DownloadRetryConfig getDEFAULT() {
            return DownloadRetryConfig.DEFAULT;
        }
    }
}
