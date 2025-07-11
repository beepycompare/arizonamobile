package com.miami.game.feature.home.ui.model;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: HomeExternalUiState.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0014\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001BC\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\t\u001a\u00020\u0003¢\u0006\u0004\b\n\u0010\u000bJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003JE\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0017\u001a\u00020\u00032\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001J\t\u0010\u001b\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\fR\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\fR\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\f¨\u0006\u001c"}, d2 = {"Lcom/miami/game/feature/home/ui/model/HomeExternalUiState;", "", "isProgressDownload", "", "percentageProgress", "", "updateSize", "isCheckingFiles", "isUpdateNeeded", "isGameReady", "<init>", "(ZLjava/lang/String;Ljava/lang/String;ZZZ)V", "()Z", "getPercentageProgress", "()Ljava/lang/String;", "getUpdateSize", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "other", "hashCode", "", "toString", "home_release_web"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class HomeExternalUiState {
    public static final int $stable = 0;
    private final boolean isCheckingFiles;
    private final boolean isGameReady;
    private final boolean isProgressDownload;
    private final boolean isUpdateNeeded;
    private final String percentageProgress;
    private final String updateSize;

    public HomeExternalUiState() {
        this(false, null, null, false, false, false, 63, null);
    }

    public static /* synthetic */ HomeExternalUiState copy$default(HomeExternalUiState homeExternalUiState, boolean z, String str, String str2, boolean z2, boolean z3, boolean z4, int i, Object obj) {
        if ((i & 1) != 0) {
            z = homeExternalUiState.isProgressDownload;
        }
        if ((i & 2) != 0) {
            str = homeExternalUiState.percentageProgress;
        }
        if ((i & 4) != 0) {
            str2 = homeExternalUiState.updateSize;
        }
        if ((i & 8) != 0) {
            z2 = homeExternalUiState.isCheckingFiles;
        }
        if ((i & 16) != 0) {
            z3 = homeExternalUiState.isUpdateNeeded;
        }
        if ((i & 32) != 0) {
            z4 = homeExternalUiState.isGameReady;
        }
        boolean z5 = z3;
        boolean z6 = z4;
        return homeExternalUiState.copy(z, str, str2, z2, z5, z6);
    }

    public final boolean component1() {
        return this.isProgressDownload;
    }

    public final String component2() {
        return this.percentageProgress;
    }

    public final String component3() {
        return this.updateSize;
    }

    public final boolean component4() {
        return this.isCheckingFiles;
    }

    public final boolean component5() {
        return this.isUpdateNeeded;
    }

    public final boolean component6() {
        return this.isGameReady;
    }

    public final HomeExternalUiState copy(boolean z, String percentageProgress, String updateSize, boolean z2, boolean z3, boolean z4) {
        Intrinsics.checkNotNullParameter(percentageProgress, "percentageProgress");
        Intrinsics.checkNotNullParameter(updateSize, "updateSize");
        return new HomeExternalUiState(z, percentageProgress, updateSize, z2, z3, z4);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof HomeExternalUiState) {
            HomeExternalUiState homeExternalUiState = (HomeExternalUiState) obj;
            return this.isProgressDownload == homeExternalUiState.isProgressDownload && Intrinsics.areEqual(this.percentageProgress, homeExternalUiState.percentageProgress) && Intrinsics.areEqual(this.updateSize, homeExternalUiState.updateSize) && this.isCheckingFiles == homeExternalUiState.isCheckingFiles && this.isUpdateNeeded == homeExternalUiState.isUpdateNeeded && this.isGameReady == homeExternalUiState.isGameReady;
        }
        return false;
    }

    public int hashCode() {
        return (((((((((Boolean.hashCode(this.isProgressDownload) * 31) + this.percentageProgress.hashCode()) * 31) + this.updateSize.hashCode()) * 31) + Boolean.hashCode(this.isCheckingFiles)) * 31) + Boolean.hashCode(this.isUpdateNeeded)) * 31) + Boolean.hashCode(this.isGameReady);
    }

    public String toString() {
        boolean z = this.isProgressDownload;
        String str = this.percentageProgress;
        String str2 = this.updateSize;
        boolean z2 = this.isCheckingFiles;
        boolean z3 = this.isUpdateNeeded;
        return "HomeExternalUiState(isProgressDownload=" + z + ", percentageProgress=" + str + ", updateSize=" + str2 + ", isCheckingFiles=" + z2 + ", isUpdateNeeded=" + z3 + ", isGameReady=" + this.isGameReady + ")";
    }

    public HomeExternalUiState(boolean z, String percentageProgress, String updateSize, boolean z2, boolean z3, boolean z4) {
        Intrinsics.checkNotNullParameter(percentageProgress, "percentageProgress");
        Intrinsics.checkNotNullParameter(updateSize, "updateSize");
        this.isProgressDownload = z;
        this.percentageProgress = percentageProgress;
        this.updateSize = updateSize;
        this.isCheckingFiles = z2;
        this.isUpdateNeeded = z3;
        this.isGameReady = z4;
    }

    public /* synthetic */ HomeExternalUiState(boolean z, String str, String str2, boolean z2, boolean z3, boolean z4, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? false : z, (i & 2) != 0 ? "" : str, (i & 4) != 0 ? "" : str2, (i & 8) != 0 ? true : z2, (i & 16) != 0 ? false : z3, (i & 32) != 0 ? false : z4);
    }

    public final boolean isProgressDownload() {
        return this.isProgressDownload;
    }

    public final String getPercentageProgress() {
        return this.percentageProgress;
    }

    public final String getUpdateSize() {
        return this.updateSize;
    }

    public final boolean isCheckingFiles() {
        return this.isCheckingFiles;
    }

    public final boolean isUpdateNeeded() {
        return this.isUpdateNeeded;
    }

    public final boolean isGameReady() {
        return this.isGameReady;
    }
}
