package com.miami.game.feature.settings.ui.model;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: SettingsVmState.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\b\n\u0002\b\u0003\b\u0087\b\u0018\u0000 \u00152\u00020\u0001:\u0001\u0015B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0006HÆ\u0003J'\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00032\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0006HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0016"}, d2 = {"Lcom/miami/game/feature/settings/ui/model/SettingsVmState;", "", "isProgress", "", "isProgressDownload", "percentageProgress", "", "<init>", "(ZZLjava/lang/String;)V", "()Z", "getPercentageProgress", "()Ljava/lang/String;", "component1", "component2", "component3", "copy", "equals", "other", "hashCode", "", "toString", "Companion", "settings_release_web"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class SettingsVmState {
    public static final int $stable = 0;
    public static final Companion Companion = new Companion(null);
    private final boolean isProgress;
    private final boolean isProgressDownload;
    private final String percentageProgress;

    public static /* synthetic */ SettingsVmState copy$default(SettingsVmState settingsVmState, boolean z, boolean z2, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            z = settingsVmState.isProgress;
        }
        if ((i & 2) != 0) {
            z2 = settingsVmState.isProgressDownload;
        }
        if ((i & 4) != 0) {
            str = settingsVmState.percentageProgress;
        }
        return settingsVmState.copy(z, z2, str);
    }

    public final boolean component1() {
        return this.isProgress;
    }

    public final boolean component2() {
        return this.isProgressDownload;
    }

    public final String component3() {
        return this.percentageProgress;
    }

    public final SettingsVmState copy(boolean z, boolean z2, String percentageProgress) {
        Intrinsics.checkNotNullParameter(percentageProgress, "percentageProgress");
        return new SettingsVmState(z, z2, percentageProgress);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof SettingsVmState) {
            SettingsVmState settingsVmState = (SettingsVmState) obj;
            return this.isProgress == settingsVmState.isProgress && this.isProgressDownload == settingsVmState.isProgressDownload && Intrinsics.areEqual(this.percentageProgress, settingsVmState.percentageProgress);
        }
        return false;
    }

    public int hashCode() {
        return (((Boolean.hashCode(this.isProgress) * 31) + Boolean.hashCode(this.isProgressDownload)) * 31) + this.percentageProgress.hashCode();
    }

    public String toString() {
        boolean z = this.isProgress;
        boolean z2 = this.isProgressDownload;
        return "SettingsVmState(isProgress=" + z + ", isProgressDownload=" + z2 + ", percentageProgress=" + this.percentageProgress + ")";
    }

    public SettingsVmState(boolean z, boolean z2, String percentageProgress) {
        Intrinsics.checkNotNullParameter(percentageProgress, "percentageProgress");
        this.isProgress = z;
        this.isProgressDownload = z2;
        this.percentageProgress = percentageProgress;
    }

    public final boolean isProgress() {
        return this.isProgress;
    }

    public final boolean isProgressDownload() {
        return this.isProgressDownload;
    }

    public final String getPercentageProgress() {
        return this.percentageProgress;
    }

    /* compiled from: SettingsVmState.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0004\u001a\u00020\u0005¨\u0006\u0006"}, d2 = {"Lcom/miami/game/feature/settings/ui/model/SettingsVmState$Companion;", "", "<init>", "()V", "initial", "Lcom/miami/game/feature/settings/ui/model/SettingsVmState;", "settings_release_web"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final SettingsVmState initial() {
            return new SettingsVmState(false, false, "0");
        }
    }
}
