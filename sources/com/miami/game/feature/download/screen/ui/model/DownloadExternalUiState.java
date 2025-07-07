package com.miami.game.feature.download.screen.ui.model;

import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: DownloadExternalUiState.kt */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u001b\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001Ba\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u000b\u001a\u00020\t\u0012\b\b\u0002\u0010\f\u001a\u00020\t\u0012\b\b\u0002\u0010\r\u001a\u00020\t¢\u0006\u0004\b\u000e\u0010\u000fJ\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0007HÆ\u0003J\t\u0010\u001c\u001a\u00020\tHÆ\u0003J\t\u0010\u001d\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001e\u001a\u00020\tHÆ\u0003J\t\u0010\u001f\u001a\u00020\tHÆ\u0003J\t\u0010 \u001a\u00020\tHÆ\u0003Jc\u0010!\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\t2\b\b\u0002\u0010\f\u001a\u00020\t2\b\b\u0002\u0010\r\u001a\u00020\tHÆ\u0001J\u0013\u0010\"\u001a\u00020\t2\b\u0010#\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010$\u001a\u00020%HÖ\u0001J\t\u0010&\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0011R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0011R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0016R\u0011\u0010\n\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0011R\u0011\u0010\u000b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\u0016R\u0011\u0010\f\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u0016R\u0011\u0010\r\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u0016¨\u0006'"}, d2 = {"Lcom/miami/game/feature/download/screen/ui/model/DownloadExternalUiState;", "", "textDownload", "", "timeRemainingString", "downloadingStringState", "percentageProgress", "", "isProgressDownload", "", "updateSize", "isCheckingFiles", "isDialogVisible", "isLauncherUpdate", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;DZLjava/lang/String;ZZZ)V", "getTextDownload", "()Ljava/lang/String;", "getTimeRemainingString", "getDownloadingStringState", "getPercentageProgress", "()D", "()Z", "getUpdateSize", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "other", "hashCode", "", "toString", "download-screen_release_web"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class DownloadExternalUiState {
    public static final int $stable = 0;
    private final String downloadingStringState;
    private final boolean isCheckingFiles;
    private final boolean isDialogVisible;
    private final boolean isLauncherUpdate;
    private final boolean isProgressDownload;
    private final double percentageProgress;
    private final String textDownload;
    private final String timeRemainingString;
    private final String updateSize;

    public DownloadExternalUiState() {
        this(null, null, null, FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE, false, null, false, false, false, 511, null);
    }

    public static /* synthetic */ DownloadExternalUiState copy$default(DownloadExternalUiState downloadExternalUiState, String str, String str2, String str3, double d, boolean z, String str4, boolean z2, boolean z3, boolean z4, int i, Object obj) {
        if ((i & 1) != 0) {
            str = downloadExternalUiState.textDownload;
        }
        if ((i & 2) != 0) {
            str2 = downloadExternalUiState.timeRemainingString;
        }
        if ((i & 4) != 0) {
            str3 = downloadExternalUiState.downloadingStringState;
        }
        if ((i & 8) != 0) {
            d = downloadExternalUiState.percentageProgress;
        }
        if ((i & 16) != 0) {
            z = downloadExternalUiState.isProgressDownload;
        }
        if ((i & 32) != 0) {
            str4 = downloadExternalUiState.updateSize;
        }
        if ((i & 64) != 0) {
            z2 = downloadExternalUiState.isCheckingFiles;
        }
        if ((i & 128) != 0) {
            z3 = downloadExternalUiState.isDialogVisible;
        }
        if ((i & 256) != 0) {
            z4 = downloadExternalUiState.isLauncherUpdate;
        }
        boolean z5 = z4;
        boolean z6 = z2;
        boolean z7 = z;
        double d2 = d;
        String str5 = str3;
        return downloadExternalUiState.copy(str, str2, str5, d2, z7, str4, z6, z3, z5);
    }

    public final String component1() {
        return this.textDownload;
    }

    public final String component2() {
        return this.timeRemainingString;
    }

    public final String component3() {
        return this.downloadingStringState;
    }

    public final double component4() {
        return this.percentageProgress;
    }

    public final boolean component5() {
        return this.isProgressDownload;
    }

    public final String component6() {
        return this.updateSize;
    }

    public final boolean component7() {
        return this.isCheckingFiles;
    }

    public final boolean component8() {
        return this.isDialogVisible;
    }

    public final boolean component9() {
        return this.isLauncherUpdate;
    }

    public final DownloadExternalUiState copy(String textDownload, String timeRemainingString, String downloadingStringState, double d, boolean z, String updateSize, boolean z2, boolean z3, boolean z4) {
        Intrinsics.checkNotNullParameter(textDownload, "textDownload");
        Intrinsics.checkNotNullParameter(timeRemainingString, "timeRemainingString");
        Intrinsics.checkNotNullParameter(downloadingStringState, "downloadingStringState");
        Intrinsics.checkNotNullParameter(updateSize, "updateSize");
        return new DownloadExternalUiState(textDownload, timeRemainingString, downloadingStringState, d, z, updateSize, z2, z3, z4);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof DownloadExternalUiState) {
            DownloadExternalUiState downloadExternalUiState = (DownloadExternalUiState) obj;
            return Intrinsics.areEqual(this.textDownload, downloadExternalUiState.textDownload) && Intrinsics.areEqual(this.timeRemainingString, downloadExternalUiState.timeRemainingString) && Intrinsics.areEqual(this.downloadingStringState, downloadExternalUiState.downloadingStringState) && Double.compare(this.percentageProgress, downloadExternalUiState.percentageProgress) == 0 && this.isProgressDownload == downloadExternalUiState.isProgressDownload && Intrinsics.areEqual(this.updateSize, downloadExternalUiState.updateSize) && this.isCheckingFiles == downloadExternalUiState.isCheckingFiles && this.isDialogVisible == downloadExternalUiState.isDialogVisible && this.isLauncherUpdate == downloadExternalUiState.isLauncherUpdate;
        }
        return false;
    }

    public int hashCode() {
        return (((((((((((((((this.textDownload.hashCode() * 31) + this.timeRemainingString.hashCode()) * 31) + this.downloadingStringState.hashCode()) * 31) + Double.hashCode(this.percentageProgress)) * 31) + Boolean.hashCode(this.isProgressDownload)) * 31) + this.updateSize.hashCode()) * 31) + Boolean.hashCode(this.isCheckingFiles)) * 31) + Boolean.hashCode(this.isDialogVisible)) * 31) + Boolean.hashCode(this.isLauncherUpdate);
    }

    public String toString() {
        String str = this.textDownload;
        String str2 = this.timeRemainingString;
        String str3 = this.downloadingStringState;
        double d = this.percentageProgress;
        boolean z = this.isProgressDownload;
        String str4 = this.updateSize;
        boolean z2 = this.isCheckingFiles;
        boolean z3 = this.isDialogVisible;
        return "DownloadExternalUiState(textDownload=" + str + ", timeRemainingString=" + str2 + ", downloadingStringState=" + str3 + ", percentageProgress=" + d + ", isProgressDownload=" + z + ", updateSize=" + str4 + ", isCheckingFiles=" + z2 + ", isDialogVisible=" + z3 + ", isLauncherUpdate=" + this.isLauncherUpdate + ")";
    }

    public DownloadExternalUiState(String textDownload, String timeRemainingString, String downloadingStringState, double d, boolean z, String updateSize, boolean z2, boolean z3, boolean z4) {
        Intrinsics.checkNotNullParameter(textDownload, "textDownload");
        Intrinsics.checkNotNullParameter(timeRemainingString, "timeRemainingString");
        Intrinsics.checkNotNullParameter(downloadingStringState, "downloadingStringState");
        Intrinsics.checkNotNullParameter(updateSize, "updateSize");
        this.textDownload = textDownload;
        this.timeRemainingString = timeRemainingString;
        this.downloadingStringState = downloadingStringState;
        this.percentageProgress = d;
        this.isProgressDownload = z;
        this.updateSize = updateSize;
        this.isCheckingFiles = z2;
        this.isDialogVisible = z3;
        this.isLauncherUpdate = z4;
    }

    public /* synthetic */ DownloadExternalUiState(String str, String str2, String str3, double d, boolean z, String str4, boolean z2, boolean z3, boolean z4, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "" : str, (i & 2) != 0 ? "" : str2, (i & 4) != 0 ? "" : str3, (i & 8) != 0 ? FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE : d, (i & 16) != 0 ? false : z, (i & 32) != 0 ? "" : str4, (i & 64) != 0 ? false : z2, (i & 128) != 0 ? false : z3, (i & 256) != 0 ? false : z4);
    }

    public final String getTextDownload() {
        return this.textDownload;
    }

    public final String getTimeRemainingString() {
        return this.timeRemainingString;
    }

    public final String getDownloadingStringState() {
        return this.downloadingStringState;
    }

    public final double getPercentageProgress() {
        return this.percentageProgress;
    }

    public final boolean isProgressDownload() {
        return this.isProgressDownload;
    }

    public final String getUpdateSize() {
        return this.updateSize;
    }

    public final boolean isCheckingFiles() {
        return this.isCheckingFiles;
    }

    public final boolean isDialogVisible() {
        return this.isDialogVisible;
    }

    public final boolean isLauncherUpdate() {
        return this.isLauncherUpdate;
    }
}
