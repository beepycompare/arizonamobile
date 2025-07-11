package com.miami.game.core.files.updater.domain.model;

import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: FilesUpdaterState.kt */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0006\n\u0002\b!\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\b\u0018\u0000 32\u00020\u0001:\u00013Bs\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\u0006\u0010\f\u001a\u00020\n\u0012\u0006\u0010\r\u001a\u00020\u0003\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\u0006\u0010\u0010\u001a\u00020\n\u0012\u0006\u0010\u0011\u001a\u00020\n\u0012\b\b\u0002\u0010\u0012\u001a\u00020\n¢\u0006\u0004\b\u0013\u0010\u0014J\t\u0010 \u001a\u00020\u0003HÆ\u0003J\t\u0010!\u001a\u00020\u0005HÆ\u0003J\t\u0010\"\u001a\u00020\u0003HÆ\u0003J\t\u0010#\u001a\u00020\u0005HÆ\u0003J\t\u0010$\u001a\u00020\u0003HÆ\u0003J\t\u0010%\u001a\u00020\nHÆ\u0003J\t\u0010&\u001a\u00020\nHÆ\u0003J\t\u0010'\u001a\u00020\nHÆ\u0003J\t\u0010(\u001a\u00020\u0003HÆ\u0003J\t\u0010)\u001a\u00020\u000fHÆ\u0003J\t\u0010*\u001a\u00020\nHÆ\u0003J\t\u0010+\u001a\u00020\nHÆ\u0003J\t\u0010,\u001a\u00020\nHÆ\u0003J\u008b\u0001\u0010-\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\n2\b\b\u0002\u0010\f\u001a\u00020\n2\b\b\u0002\u0010\r\u001a\u00020\u00032\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\n2\b\b\u0002\u0010\u0011\u001a\u00020\n2\b\b\u0002\u0010\u0012\u001a\u00020\nHÆ\u0001J\u0013\u0010.\u001a\u00020\n2\b\u0010/\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00100\u001a\u000201HÖ\u0001J\t\u00102\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0016R\u0011\u0010\u0007\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0018R\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0016R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u001cR\u0011\u0010\u000b\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\u001cR\u0011\u0010\f\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u001cR\u0011\u0010\r\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0016R\u0011\u0010\u000e\u001a\u00020\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u0011\u0010\u0010\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u001cR\u0011\u0010\u0011\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u001cR\u0011\u0010\u0012\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u001c¨\u00064"}, d2 = {"Lcom/miami/game/core/files/updater/domain/model/FilesUpdaterState;", "", "timeRemainingSeconds", "", "timeRemainingString", "", "allDownloadSize", "downloadingStringState", "updateSize", "isCheckingFiles", "", "isUpdateNeeded", "isProgressDownload", "totalTasks", "percentageProgress", "", "isError", "isComplete", "isRepairGameSuccess", "<init>", "(JLjava/lang/String;JLjava/lang/String;JZZZJDZZZ)V", "getTimeRemainingSeconds", "()J", "getTimeRemainingString", "()Ljava/lang/String;", "getAllDownloadSize", "getDownloadingStringState", "getUpdateSize", "()Z", "getTotalTasks", "getPercentageProgress", "()D", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "copy", "equals", "other", "hashCode", "", "toString", "Companion", "files-updater_release_web"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class FilesUpdaterState {
    public static final Companion Companion = new Companion(null);
    private final long allDownloadSize;
    private final String downloadingStringState;
    private final boolean isCheckingFiles;
    private final boolean isComplete;
    private final boolean isError;
    private final boolean isProgressDownload;
    private final boolean isRepairGameSuccess;
    private final boolean isUpdateNeeded;
    private final double percentageProgress;
    private final long timeRemainingSeconds;
    private final String timeRemainingString;
    private final long totalTasks;
    private final long updateSize;

    public static /* synthetic */ FilesUpdaterState copy$default(FilesUpdaterState filesUpdaterState, long j, String str, long j2, String str2, long j3, boolean z, boolean z2, boolean z3, long j4, double d, boolean z4, boolean z5, boolean z6, int i, Object obj) {
        long j5;
        double d2;
        long j6 = (i & 1) != 0 ? filesUpdaterState.timeRemainingSeconds : j;
        String str3 = (i & 2) != 0 ? filesUpdaterState.timeRemainingString : str;
        long j7 = (i & 4) != 0 ? filesUpdaterState.allDownloadSize : j2;
        String str4 = (i & 8) != 0 ? filesUpdaterState.downloadingStringState : str2;
        long j8 = (i & 16) != 0 ? filesUpdaterState.updateSize : j3;
        boolean z7 = (i & 32) != 0 ? filesUpdaterState.isCheckingFiles : z;
        boolean z8 = (i & 64) != 0 ? filesUpdaterState.isUpdateNeeded : z2;
        boolean z9 = (i & 128) != 0 ? filesUpdaterState.isProgressDownload : z3;
        long j9 = (i & 256) != 0 ? filesUpdaterState.totalTasks : j4;
        if ((i & 512) != 0) {
            j5 = j6;
            d2 = filesUpdaterState.percentageProgress;
        } else {
            j5 = j6;
            d2 = d;
        }
        return filesUpdaterState.copy(j5, str3, j7, str4, j8, z7, z8, z9, j9, d2, (i & 1024) != 0 ? filesUpdaterState.isError : z4, (i & 2048) != 0 ? filesUpdaterState.isComplete : z5, (i & 4096) != 0 ? filesUpdaterState.isRepairGameSuccess : z6);
    }

    public final long component1() {
        return this.timeRemainingSeconds;
    }

    public final double component10() {
        return this.percentageProgress;
    }

    public final boolean component11() {
        return this.isError;
    }

    public final boolean component12() {
        return this.isComplete;
    }

    public final boolean component13() {
        return this.isRepairGameSuccess;
    }

    public final String component2() {
        return this.timeRemainingString;
    }

    public final long component3() {
        return this.allDownloadSize;
    }

    public final String component4() {
        return this.downloadingStringState;
    }

    public final long component5() {
        return this.updateSize;
    }

    public final boolean component6() {
        return this.isCheckingFiles;
    }

    public final boolean component7() {
        return this.isUpdateNeeded;
    }

    public final boolean component8() {
        return this.isProgressDownload;
    }

    public final long component9() {
        return this.totalTasks;
    }

    public final FilesUpdaterState copy(long j, String timeRemainingString, long j2, String downloadingStringState, long j3, boolean z, boolean z2, boolean z3, long j4, double d, boolean z4, boolean z5, boolean z6) {
        Intrinsics.checkNotNullParameter(timeRemainingString, "timeRemainingString");
        Intrinsics.checkNotNullParameter(downloadingStringState, "downloadingStringState");
        return new FilesUpdaterState(j, timeRemainingString, j2, downloadingStringState, j3, z, z2, z3, j4, d, z4, z5, z6);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof FilesUpdaterState) {
            FilesUpdaterState filesUpdaterState = (FilesUpdaterState) obj;
            return this.timeRemainingSeconds == filesUpdaterState.timeRemainingSeconds && Intrinsics.areEqual(this.timeRemainingString, filesUpdaterState.timeRemainingString) && this.allDownloadSize == filesUpdaterState.allDownloadSize && Intrinsics.areEqual(this.downloadingStringState, filesUpdaterState.downloadingStringState) && this.updateSize == filesUpdaterState.updateSize && this.isCheckingFiles == filesUpdaterState.isCheckingFiles && this.isUpdateNeeded == filesUpdaterState.isUpdateNeeded && this.isProgressDownload == filesUpdaterState.isProgressDownload && this.totalTasks == filesUpdaterState.totalTasks && Double.compare(this.percentageProgress, filesUpdaterState.percentageProgress) == 0 && this.isError == filesUpdaterState.isError && this.isComplete == filesUpdaterState.isComplete && this.isRepairGameSuccess == filesUpdaterState.isRepairGameSuccess;
        }
        return false;
    }

    public int hashCode() {
        return (((((((((((((((((((((((Long.hashCode(this.timeRemainingSeconds) * 31) + this.timeRemainingString.hashCode()) * 31) + Long.hashCode(this.allDownloadSize)) * 31) + this.downloadingStringState.hashCode()) * 31) + Long.hashCode(this.updateSize)) * 31) + Boolean.hashCode(this.isCheckingFiles)) * 31) + Boolean.hashCode(this.isUpdateNeeded)) * 31) + Boolean.hashCode(this.isProgressDownload)) * 31) + Long.hashCode(this.totalTasks)) * 31) + Double.hashCode(this.percentageProgress)) * 31) + Boolean.hashCode(this.isError)) * 31) + Boolean.hashCode(this.isComplete)) * 31) + Boolean.hashCode(this.isRepairGameSuccess);
    }

    public String toString() {
        long j = this.timeRemainingSeconds;
        String str = this.timeRemainingString;
        long j2 = this.allDownloadSize;
        String str2 = this.downloadingStringState;
        long j3 = this.updateSize;
        boolean z = this.isCheckingFiles;
        boolean z2 = this.isUpdateNeeded;
        boolean z3 = this.isProgressDownload;
        long j4 = this.totalTasks;
        double d = this.percentageProgress;
        boolean z4 = this.isError;
        boolean z5 = this.isComplete;
        return "FilesUpdaterState(timeRemainingSeconds=" + j + ", timeRemainingString=" + str + ", allDownloadSize=" + j2 + ", downloadingStringState=" + str2 + ", updateSize=" + j3 + ", isCheckingFiles=" + z + ", isUpdateNeeded=" + z2 + ", isProgressDownload=" + z3 + ", totalTasks=" + j4 + ", percentageProgress=" + d + ", isError=" + z4 + ", isComplete=" + z5 + ", isRepairGameSuccess=" + this.isRepairGameSuccess + ")";
    }

    public FilesUpdaterState(long j, String timeRemainingString, long j2, String downloadingStringState, long j3, boolean z, boolean z2, boolean z3, long j4, double d, boolean z4, boolean z5, boolean z6) {
        Intrinsics.checkNotNullParameter(timeRemainingString, "timeRemainingString");
        Intrinsics.checkNotNullParameter(downloadingStringState, "downloadingStringState");
        this.timeRemainingSeconds = j;
        this.timeRemainingString = timeRemainingString;
        this.allDownloadSize = j2;
        this.downloadingStringState = downloadingStringState;
        this.updateSize = j3;
        this.isCheckingFiles = z;
        this.isUpdateNeeded = z2;
        this.isProgressDownload = z3;
        this.totalTasks = j4;
        this.percentageProgress = d;
        this.isError = z4;
        this.isComplete = z5;
        this.isRepairGameSuccess = z6;
    }

    public final long getTimeRemainingSeconds() {
        return this.timeRemainingSeconds;
    }

    public final String getTimeRemainingString() {
        return this.timeRemainingString;
    }

    public final long getAllDownloadSize() {
        return this.allDownloadSize;
    }

    public /* synthetic */ FilesUpdaterState(long j, String str, long j2, String str2, long j3, boolean z, boolean z2, boolean z3, long j4, double d, boolean z4, boolean z5, boolean z6, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(j, str, j2, (i & 8) != 0 ? "" : str2, j3, z, z2, z3, j4, d, z4, z5, (i & 4096) != 0 ? false : z6);
    }

    public final String getDownloadingStringState() {
        return this.downloadingStringState;
    }

    public final long getUpdateSize() {
        return this.updateSize;
    }

    public final boolean isCheckingFiles() {
        return this.isCheckingFiles;
    }

    public final boolean isUpdateNeeded() {
        return this.isUpdateNeeded;
    }

    public final boolean isProgressDownload() {
        return this.isProgressDownload;
    }

    public final long getTotalTasks() {
        return this.totalTasks;
    }

    public final double getPercentageProgress() {
        return this.percentageProgress;
    }

    public final boolean isError() {
        return this.isError;
    }

    public final boolean isComplete() {
        return this.isComplete;
    }

    public final boolean isRepairGameSuccess() {
        return this.isRepairGameSuccess;
    }

    /* compiled from: FilesUpdaterState.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0004\u001a\u00020\u0005¨\u0006\u0006"}, d2 = {"Lcom/miami/game/core/files/updater/domain/model/FilesUpdaterState$Companion;", "", "<init>", "()V", "initial", "Lcom/miami/game/core/files/updater/domain/model/FilesUpdaterState;", "files-updater_release_web"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final FilesUpdaterState initial() {
            return new FilesUpdaterState(0L, "", 0L, null, 0L, false, false, false, 0L, FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE, false, false, false, 4104, null);
        }
    }
}
