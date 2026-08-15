package com.arizona.launcher.updater.apk;

import com.google.firebase.messaging.Constants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: LauncherUpdatePolicies.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0081\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0014\u0010\u000e\u001a\u00020\u00052\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0010\u001a\u00020\u0011HÖ\u0081\u0004J\n\u0010\u0012\u001a\u00020\u0003HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\nÊ\u0001\f\b\u0014\u0012\b\b\u0015\u0012\u0004\b\u0003\u0010\u0002¨\u0006\u0013"}, d2 = {"Lcom/arizona/launcher/updater/apk/LauncherApkFailureClassification;", "", Constants.ScionAnalytics.PARAM_LABEL, "", "isRemoteFailure", "", "<init>", "(Ljava/lang/String;Z)V", "getLabel", "()Ljava/lang/String;", "()Z", "component1", "component2", "copy", "equals", "other", "hashCode", "", "toString", "app", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class LauncherApkFailureClassification {
    public static final int $stable = 0;
    private final boolean isRemoteFailure;
    private final String label;

    public static /* synthetic */ LauncherApkFailureClassification copy$default(LauncherApkFailureClassification launcherApkFailureClassification, String str, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            str = launcherApkFailureClassification.label;
        }
        if ((i & 2) != 0) {
            z = launcherApkFailureClassification.isRemoteFailure;
        }
        return launcherApkFailureClassification.copy(str, z);
    }

    public final String component1() {
        return this.label;
    }

    public final boolean component2() {
        return this.isRemoteFailure;
    }

    public final LauncherApkFailureClassification copy(String label, boolean z) {
        Intrinsics.checkNotNullParameter(label, "label");
        return new LauncherApkFailureClassification(label, z);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof LauncherApkFailureClassification) {
            LauncherApkFailureClassification launcherApkFailureClassification = (LauncherApkFailureClassification) obj;
            return Intrinsics.areEqual(this.label, launcherApkFailureClassification.label) && this.isRemoteFailure == launcherApkFailureClassification.isRemoteFailure;
        }
        return false;
    }

    public int hashCode() {
        return (this.label.hashCode() * 31) + Boolean.hashCode(this.isRemoteFailure);
    }

    public String toString() {
        String str = this.label;
        return "LauncherApkFailureClassification(label=" + str + ", isRemoteFailure=" + this.isRemoteFailure + ")";
    }

    public LauncherApkFailureClassification(String label, boolean z) {
        Intrinsics.checkNotNullParameter(label, "label");
        this.label = label;
        this.isRemoteFailure = z;
    }

    public final String getLabel() {
        return this.label;
    }

    public final boolean isRemoteFailure() {
        return this.isRemoteFailure;
    }
}
