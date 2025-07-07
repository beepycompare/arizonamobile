package com.liulishuo.okdownload.kotlin;

import com.liulishuo.okdownload.DownloadTask;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: DownloadProgress.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0086\b\u0018\u0000 \u001b2\u00020\u0001:\u0001\u001bB\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0002\u0010\u0007J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0005HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0005HÆ\u0003J'\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J\u0006\u0010\u0016\u001a\u00020\u0017J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001J\u0006\u0010\u001a\u001a\u00020\u0012R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\t¨\u0006\u001c"}, d2 = {"Lcom/liulishuo/okdownload/kotlin/DownloadProgress;", "", "task", "Lcom/liulishuo/okdownload/DownloadTask;", "currentOffset", "", "totalOffset", "(Lcom/liulishuo/okdownload/DownloadTask;JJ)V", "getCurrentOffset", "()J", "getTask", "()Lcom/liulishuo/okdownload/DownloadTask;", "getTotalOffset", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "progress", "", "toString", "", "totalUnknown", "Companion", "kotlin_release"}, k = 1, mv = {1, 1, 15})
/* loaded from: classes4.dex */
public final class DownloadProgress {
    public static final Companion Companion = new Companion(null);
    public static final float UNKNOWN_PROGRESS = 0.0f;
    private static final long UNKNOWN_TOTAL_OFFSET = -1;
    private final long currentOffset;
    private final DownloadTask task;
    private final long totalOffset;

    public static /* synthetic */ DownloadProgress copy$default(DownloadProgress downloadProgress, DownloadTask downloadTask, long j, long j2, int i, Object obj) {
        if ((i & 1) != 0) {
            downloadTask = downloadProgress.task;
        }
        if ((i & 2) != 0) {
            j = downloadProgress.currentOffset;
        }
        if ((i & 4) != 0) {
            j2 = downloadProgress.totalOffset;
        }
        return downloadProgress.copy(downloadTask, j, j2);
    }

    public final DownloadTask component1() {
        return this.task;
    }

    public final long component2() {
        return this.currentOffset;
    }

    public final long component3() {
        return this.totalOffset;
    }

    public final DownloadProgress copy(DownloadTask task, long j, long j2) {
        Intrinsics.checkParameterIsNotNull(task, "task");
        return new DownloadProgress(task, j, j2);
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            if (obj instanceof DownloadProgress) {
                DownloadProgress downloadProgress = (DownloadProgress) obj;
                return Intrinsics.areEqual(this.task, downloadProgress.task) && this.currentOffset == downloadProgress.currentOffset && this.totalOffset == downloadProgress.totalOffset;
            }
            return false;
        }
        return true;
    }

    public int hashCode() {
        DownloadTask downloadTask = this.task;
        int hashCode = downloadTask != null ? downloadTask.hashCode() : 0;
        long j = this.currentOffset;
        long j2 = this.totalOffset;
        return (((hashCode * 31) + ((int) (j ^ (j >>> 32)))) * 31) + ((int) (j2 ^ (j2 >>> 32)));
    }

    public String toString() {
        return "DownloadProgress(task=" + this.task + ", currentOffset=" + this.currentOffset + ", totalOffset=" + this.totalOffset + ")";
    }

    public DownloadProgress(DownloadTask task, long j, long j2) {
        Intrinsics.checkParameterIsNotNull(task, "task");
        this.task = task;
        this.currentOffset = j;
        this.totalOffset = j2;
    }

    public final DownloadTask getTask() {
        return this.task;
    }

    public final long getCurrentOffset() {
        return this.currentOffset;
    }

    public final long getTotalOffset() {
        return this.totalOffset;
    }

    /* compiled from: DownloadProgress.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\t\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/liulishuo/okdownload/kotlin/DownloadProgress$Companion;", "", "()V", "UNKNOWN_PROGRESS", "", "UNKNOWN_TOTAL_OFFSET", "", "kotlin_release"}, k = 1, mv = {1, 1, 15})
    /* loaded from: classes4.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public final boolean totalUnknown() {
        return this.totalOffset == -1;
    }

    public final float progress() {
        long j = this.totalOffset;
        if (j == -1) {
            return 0.0f;
        }
        if (j == 0) {
            return this.currentOffset == 0 ? 1.0f : 0.0f;
        }
        return (((float) this.currentOffset) * 1.0f) / ((float) j);
    }
}
