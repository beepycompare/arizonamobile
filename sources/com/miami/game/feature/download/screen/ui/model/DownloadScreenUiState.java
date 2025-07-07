package com.miami.game.feature.download.screen.ui.model;

import android.net.Uri;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.miami.game.feature.download.screen.R;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: DownloadScreenUiState.kt */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b \b\u0087\b\u0018\u0000 02\u00020\u0001:\u00010Bi\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\t\u001a\u00020\n\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\u0006\u0010\r\u001a\u00020\u0007\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0007\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0007\u0012\u0006\u0010\u0010\u001a\u00020\u0011¢\u0006\u0004\b\u0012\u0010\u0013J\t\u0010 \u001a\u00020\u0003HÆ\u0003J\t\u0010!\u001a\u00020\u0003HÆ\u0003J\t\u0010\"\u001a\u00020\u0003HÆ\u0003J\t\u0010#\u001a\u00020\u0007HÆ\u0003J\t\u0010$\u001a\u00020\u0007HÆ\u0003J\t\u0010%\u001a\u00020\nHÆ\u0003J\u000b\u0010&\u001a\u0004\u0018\u00010\fHÆ\u0003J\t\u0010'\u001a\u00020\u0007HÆ\u0003J\t\u0010(\u001a\u00020\u0007HÆ\u0003J\t\u0010)\u001a\u00020\u0007HÆ\u0003J\t\u0010*\u001a\u00020\u0011HÆ\u0003Jy\u0010+\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f2\b\b\u0002\u0010\r\u001a\u00020\u00072\b\b\u0002\u0010\u000e\u001a\u00020\u00072\b\b\u0002\u0010\u000f\u001a\u00020\u00072\b\b\u0002\u0010\u0010\u001a\u00020\u0011HÆ\u0001J\u0013\u0010,\u001a\u00020\u00072\b\u0010-\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010.\u001a\u00020\u0011HÖ\u0001J\t\u0010/\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0015R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0015R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0018R\u0011\u0010\b\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0018R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0013\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0011\u0010\r\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0018R\u0011\u0010\u000e\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u0018R\u0011\u0010\u000f\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0018R\u0011\u0010\u0010\u001a\u00020\u0011¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001f¨\u00061"}, d2 = {"Lcom/miami/game/feature/download/screen/ui/model/DownloadScreenUiState;", "", "textDownload", "", "timeRemainingString", "downloadingStringState", "isChechingFiles", "", "isDownload", "percentageProgress", "", "videoUri", "Landroid/net/Uri;", "soundOn", "isDialogVisible", "isLauncherUpdate", "launcherUpdateRes", "", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZZDLandroid/net/Uri;ZZZI)V", "getTextDownload", "()Ljava/lang/String;", "getTimeRemainingString", "getDownloadingStringState", "()Z", "getPercentageProgress", "()D", "getVideoUri", "()Landroid/net/Uri;", "getSoundOn", "getLauncherUpdateRes", "()I", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "copy", "equals", "other", "hashCode", "toString", "Companion", "download-screen_release_web"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class DownloadScreenUiState {
    public static final int $stable = 0;
    public static final Companion Companion = new Companion(null);
    private final String downloadingStringState;
    private final boolean isChechingFiles;
    private final boolean isDialogVisible;
    private final boolean isDownload;
    private final boolean isLauncherUpdate;
    private final int launcherUpdateRes;
    private final double percentageProgress;
    private final boolean soundOn;
    private final String textDownload;
    private final String timeRemainingString;
    private final Uri videoUri;

    public static /* synthetic */ DownloadScreenUiState copy$default(DownloadScreenUiState downloadScreenUiState, String str, String str2, String str3, boolean z, boolean z2, double d, Uri uri, boolean z3, boolean z4, boolean z5, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = downloadScreenUiState.textDownload;
        }
        if ((i2 & 2) != 0) {
            str2 = downloadScreenUiState.timeRemainingString;
        }
        if ((i2 & 4) != 0) {
            str3 = downloadScreenUiState.downloadingStringState;
        }
        if ((i2 & 8) != 0) {
            z = downloadScreenUiState.isChechingFiles;
        }
        if ((i2 & 16) != 0) {
            z2 = downloadScreenUiState.isDownload;
        }
        if ((i2 & 32) != 0) {
            d = downloadScreenUiState.percentageProgress;
        }
        if ((i2 & 64) != 0) {
            uri = downloadScreenUiState.videoUri;
        }
        if ((i2 & 128) != 0) {
            z3 = downloadScreenUiState.soundOn;
        }
        if ((i2 & 256) != 0) {
            z4 = downloadScreenUiState.isDialogVisible;
        }
        if ((i2 & 512) != 0) {
            z5 = downloadScreenUiState.isLauncherUpdate;
        }
        if ((i2 & 1024) != 0) {
            i = downloadScreenUiState.launcherUpdateRes;
        }
        int i3 = i;
        boolean z6 = z4;
        Uri uri2 = uri;
        double d2 = d;
        boolean z7 = z;
        boolean z8 = z2;
        String str4 = str3;
        return downloadScreenUiState.copy(str, str2, str4, z7, z8, d2, uri2, z3, z6, z5, i3);
    }

    public final String component1() {
        return this.textDownload;
    }

    public final boolean component10() {
        return this.isLauncherUpdate;
    }

    public final int component11() {
        return this.launcherUpdateRes;
    }

    public final String component2() {
        return this.timeRemainingString;
    }

    public final String component3() {
        return this.downloadingStringState;
    }

    public final boolean component4() {
        return this.isChechingFiles;
    }

    public final boolean component5() {
        return this.isDownload;
    }

    public final double component6() {
        return this.percentageProgress;
    }

    public final Uri component7() {
        return this.videoUri;
    }

    public final boolean component8() {
        return this.soundOn;
    }

    public final boolean component9() {
        return this.isDialogVisible;
    }

    public final DownloadScreenUiState copy(String textDownload, String timeRemainingString, String downloadingStringState, boolean z, boolean z2, double d, Uri uri, boolean z3, boolean z4, boolean z5, int i) {
        Intrinsics.checkNotNullParameter(textDownload, "textDownload");
        Intrinsics.checkNotNullParameter(timeRemainingString, "timeRemainingString");
        Intrinsics.checkNotNullParameter(downloadingStringState, "downloadingStringState");
        return new DownloadScreenUiState(textDownload, timeRemainingString, downloadingStringState, z, z2, d, uri, z3, z4, z5, i);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof DownloadScreenUiState) {
            DownloadScreenUiState downloadScreenUiState = (DownloadScreenUiState) obj;
            return Intrinsics.areEqual(this.textDownload, downloadScreenUiState.textDownload) && Intrinsics.areEqual(this.timeRemainingString, downloadScreenUiState.timeRemainingString) && Intrinsics.areEqual(this.downloadingStringState, downloadScreenUiState.downloadingStringState) && this.isChechingFiles == downloadScreenUiState.isChechingFiles && this.isDownload == downloadScreenUiState.isDownload && Double.compare(this.percentageProgress, downloadScreenUiState.percentageProgress) == 0 && Intrinsics.areEqual(this.videoUri, downloadScreenUiState.videoUri) && this.soundOn == downloadScreenUiState.soundOn && this.isDialogVisible == downloadScreenUiState.isDialogVisible && this.isLauncherUpdate == downloadScreenUiState.isLauncherUpdate && this.launcherUpdateRes == downloadScreenUiState.launcherUpdateRes;
        }
        return false;
    }

    public int hashCode() {
        int hashCode = ((((((((((this.textDownload.hashCode() * 31) + this.timeRemainingString.hashCode()) * 31) + this.downloadingStringState.hashCode()) * 31) + Boolean.hashCode(this.isChechingFiles)) * 31) + Boolean.hashCode(this.isDownload)) * 31) + Double.hashCode(this.percentageProgress)) * 31;
        Uri uri = this.videoUri;
        return ((((((((hashCode + (uri == null ? 0 : uri.hashCode())) * 31) + Boolean.hashCode(this.soundOn)) * 31) + Boolean.hashCode(this.isDialogVisible)) * 31) + Boolean.hashCode(this.isLauncherUpdate)) * 31) + Integer.hashCode(this.launcherUpdateRes);
    }

    public String toString() {
        String str = this.textDownload;
        String str2 = this.timeRemainingString;
        String str3 = this.downloadingStringState;
        boolean z = this.isChechingFiles;
        boolean z2 = this.isDownload;
        double d = this.percentageProgress;
        Uri uri = this.videoUri;
        boolean z3 = this.soundOn;
        boolean z4 = this.isDialogVisible;
        boolean z5 = this.isLauncherUpdate;
        return "DownloadScreenUiState(textDownload=" + str + ", timeRemainingString=" + str2 + ", downloadingStringState=" + str3 + ", isChechingFiles=" + z + ", isDownload=" + z2 + ", percentageProgress=" + d + ", videoUri=" + uri + ", soundOn=" + z3 + ", isDialogVisible=" + z4 + ", isLauncherUpdate=" + z5 + ", launcherUpdateRes=" + this.launcherUpdateRes + ")";
    }

    public DownloadScreenUiState(String textDownload, String timeRemainingString, String downloadingStringState, boolean z, boolean z2, double d, Uri uri, boolean z3, boolean z4, boolean z5, int i) {
        Intrinsics.checkNotNullParameter(textDownload, "textDownload");
        Intrinsics.checkNotNullParameter(timeRemainingString, "timeRemainingString");
        Intrinsics.checkNotNullParameter(downloadingStringState, "downloadingStringState");
        this.textDownload = textDownload;
        this.timeRemainingString = timeRemainingString;
        this.downloadingStringState = downloadingStringState;
        this.isChechingFiles = z;
        this.isDownload = z2;
        this.percentageProgress = d;
        this.videoUri = uri;
        this.soundOn = z3;
        this.isDialogVisible = z4;
        this.isLauncherUpdate = z5;
        this.launcherUpdateRes = i;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public /* synthetic */ DownloadScreenUiState(String str, String str2, String str3, boolean z, boolean z2, double d, Uri uri, boolean z3, boolean z4, boolean z5, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, str3, z, z2, d, uri, z3, z4, r13, r14);
        int i3;
        boolean z6;
        str2 = (i2 & 2) != 0 ? "" : str2;
        str3 = (i2 & 4) != 0 ? "" : str3;
        z4 = (i2 & 256) != 0 ? false : z4;
        if ((i2 & 512) != 0) {
            i3 = i;
            z6 = false;
        } else {
            i3 = i;
            z6 = z5;
        }
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

    public final boolean isChechingFiles() {
        return this.isChechingFiles;
    }

    public final boolean isDownload() {
        return this.isDownload;
    }

    public final double getPercentageProgress() {
        return this.percentageProgress;
    }

    public final Uri getVideoUri() {
        return this.videoUri;
    }

    public final boolean getSoundOn() {
        return this.soundOn;
    }

    public final boolean isDialogVisible() {
        return this.isDialogVisible;
    }

    public final boolean isLauncherUpdate() {
        return this.isLauncherUpdate;
    }

    public final int getLauncherUpdateRes() {
        return this.launcherUpdateRes;
    }

    /* compiled from: DownloadScreenUiState.kt */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\t¨\u0006\n"}, d2 = {"Lcom/miami/game/feature/download/screen/ui/model/DownloadScreenUiState$Companion;", "", "<init>", "()V", "initial", "Lcom/miami/game/feature/download/screen/ui/model/DownloadScreenUiState;", "videoUri", "Landroid/net/Uri;", "isArizona", "", "download-screen_release_web"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final DownloadScreenUiState initial(Uri uri, boolean z) {
            return new DownloadScreenUiState("Проверка файлов..", null, null, false, false, FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE, uri, true, false, false, z ? R.drawable.arizona_launcher_update : R.drawable.rodina_launcher_update, 774, null);
        }
    }
}
