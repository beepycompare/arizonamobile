package com.arizona.launcher.updater.apk;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: LauncherUpdateController.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\b\u0081\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0005HÆ\u0003J1\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u0005HÆ\u0001J\u0014\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0018\u001a\u00020\u0003HÖ\u0081\u0004J\n\u0010\u0019\u001a\u00020\u0005HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0011\u0010\u0007\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\rÊ\u0001\f\b\u001b\u0012\b\b\u001c\u0012\u0004\b\u0003\u0010\u0002¨\u0006\u001a"}, d2 = {"Lcom/arizona/launcher/updater/apk/LauncherUpdateConfig;", "", "installedVersionCode", "", "installedVersionName", "", "buildType", "flavor", "<init>", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getInstalledVersionCode", "()I", "getInstalledVersionName", "()Ljava/lang/String;", "getBuildType", "getFlavor", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "toString", "app", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class LauncherUpdateConfig {
    public static final int $stable = 0;
    private final String buildType;
    private final String flavor;
    private final int installedVersionCode;
    private final String installedVersionName;

    public static /* synthetic */ LauncherUpdateConfig copy$default(LauncherUpdateConfig launcherUpdateConfig, int i, String str, String str2, String str3, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = launcherUpdateConfig.installedVersionCode;
        }
        if ((i2 & 2) != 0) {
            str = launcherUpdateConfig.installedVersionName;
        }
        if ((i2 & 4) != 0) {
            str2 = launcherUpdateConfig.buildType;
        }
        if ((i2 & 8) != 0) {
            str3 = launcherUpdateConfig.flavor;
        }
        return launcherUpdateConfig.copy(i, str, str2, str3);
    }

    public final int component1() {
        return this.installedVersionCode;
    }

    public final String component2() {
        return this.installedVersionName;
    }

    public final String component3() {
        return this.buildType;
    }

    public final String component4() {
        return this.flavor;
    }

    public final LauncherUpdateConfig copy(int i, String installedVersionName, String buildType, String flavor) {
        Intrinsics.checkNotNullParameter(installedVersionName, "installedVersionName");
        Intrinsics.checkNotNullParameter(buildType, "buildType");
        Intrinsics.checkNotNullParameter(flavor, "flavor");
        return new LauncherUpdateConfig(i, installedVersionName, buildType, flavor);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof LauncherUpdateConfig) {
            LauncherUpdateConfig launcherUpdateConfig = (LauncherUpdateConfig) obj;
            return this.installedVersionCode == launcherUpdateConfig.installedVersionCode && Intrinsics.areEqual(this.installedVersionName, launcherUpdateConfig.installedVersionName) && Intrinsics.areEqual(this.buildType, launcherUpdateConfig.buildType) && Intrinsics.areEqual(this.flavor, launcherUpdateConfig.flavor);
        }
        return false;
    }

    public int hashCode() {
        return (((((Integer.hashCode(this.installedVersionCode) * 31) + this.installedVersionName.hashCode()) * 31) + this.buildType.hashCode()) * 31) + this.flavor.hashCode();
    }

    public String toString() {
        int i = this.installedVersionCode;
        String str = this.installedVersionName;
        String str2 = this.buildType;
        return "LauncherUpdateConfig(installedVersionCode=" + i + ", installedVersionName=" + str + ", buildType=" + str2 + ", flavor=" + this.flavor + ")";
    }

    public LauncherUpdateConfig(int i, String installedVersionName, String buildType, String flavor) {
        Intrinsics.checkNotNullParameter(installedVersionName, "installedVersionName");
        Intrinsics.checkNotNullParameter(buildType, "buildType");
        Intrinsics.checkNotNullParameter(flavor, "flavor");
        this.installedVersionCode = i;
        this.installedVersionName = installedVersionName;
        this.buildType = buildType;
        this.flavor = flavor;
    }

    public final int getInstalledVersionCode() {
        return this.installedVersionCode;
    }

    public final String getInstalledVersionName() {
        return this.installedVersionName;
    }

    public final String getBuildType() {
        return this.buildType;
    }

    public final String getFlavor() {
        return this.flavor;
    }
}
