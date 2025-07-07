package com.miami.game.core.downloader.sync;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: DownloaderState.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B%\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0007HÆ\u0003J'\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00072\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u000e¨\u0006\u0018"}, d2 = {"Lcom/miami/game/core/downloader/sync/DownloaderState;", "", "namesLastDownloads", "", "lastDuration", "", "isAllDownloadsDone", "", "<init>", "(Ljava/lang/String;JZ)V", "getNamesLastDownloads", "()Ljava/lang/String;", "getLastDuration", "()J", "()Z", "component1", "component2", "component3", "copy", "equals", "other", "hashCode", "", "toString", "downloader-sync_release_web"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class DownloaderState {
    private final boolean isAllDownloadsDone;
    private final long lastDuration;
    private final String namesLastDownloads;

    public DownloaderState() {
        this(null, 0L, false, 7, null);
    }

    public static /* synthetic */ DownloaderState copy$default(DownloaderState downloaderState, String str, long j, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            str = downloaderState.namesLastDownloads;
        }
        if ((i & 2) != 0) {
            j = downloaderState.lastDuration;
        }
        if ((i & 4) != 0) {
            z = downloaderState.isAllDownloadsDone;
        }
        return downloaderState.copy(str, j, z);
    }

    public final String component1() {
        return this.namesLastDownloads;
    }

    public final long component2() {
        return this.lastDuration;
    }

    public final boolean component3() {
        return this.isAllDownloadsDone;
    }

    public final DownloaderState copy(String namesLastDownloads, long j, boolean z) {
        Intrinsics.checkNotNullParameter(namesLastDownloads, "namesLastDownloads");
        return new DownloaderState(namesLastDownloads, j, z);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof DownloaderState) {
            DownloaderState downloaderState = (DownloaderState) obj;
            return Intrinsics.areEqual(this.namesLastDownloads, downloaderState.namesLastDownloads) && this.lastDuration == downloaderState.lastDuration && this.isAllDownloadsDone == downloaderState.isAllDownloadsDone;
        }
        return false;
    }

    public int hashCode() {
        return (((this.namesLastDownloads.hashCode() * 31) + Long.hashCode(this.lastDuration)) * 31) + Boolean.hashCode(this.isAllDownloadsDone);
    }

    public String toString() {
        String str = this.namesLastDownloads;
        long j = this.lastDuration;
        return "DownloaderState(namesLastDownloads=" + str + ", lastDuration=" + j + ", isAllDownloadsDone=" + this.isAllDownloadsDone + ")";
    }

    public DownloaderState(String namesLastDownloads, long j, boolean z) {
        Intrinsics.checkNotNullParameter(namesLastDownloads, "namesLastDownloads");
        this.namesLastDownloads = namesLastDownloads;
        this.lastDuration = j;
        this.isAllDownloadsDone = z;
    }

    public /* synthetic */ DownloaderState(String str, long j, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "" : str, (i & 2) != 0 ? 0L : j, (i & 4) != 0 ? false : z);
    }

    public final String getNamesLastDownloads() {
        return this.namesLastDownloads;
    }

    public final long getLastDuration() {
        return this.lastDuration;
    }

    public final boolean isAllDownloadsDone() {
        return this.isAllDownloadsDone;
    }
}
