package com.arizona.launcher;

import com.arizona.launcher.updater.apk.LauncherApkProgress;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: LauncherUpdateLifecyclePolicy.kt */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0081\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0014\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0012\u001a\u00020\u0013HÖ\u0081\u0004J\n\u0010\u0014\u001a\u00020\u0015HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bÊ\u0001\f\b\u0017\u0012\b\b\u0018\u0012\u0004\b\u0003\u0010\u0000¨\u0006\u0016"}, d2 = {"Lcom/arizona/launcher/LauncherProgressDispatch;", "", "token", "", "progress", "Lcom/arizona/launcher/updater/apk/LauncherApkProgress;", "<init>", "(JLcom/arizona/launcher/updater/apk/LauncherApkProgress;)V", "getToken", "()J", "getProgress", "()Lcom/arizona/launcher/updater/apk/LauncherApkProgress;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "app", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class LauncherProgressDispatch {
    public static final int $stable = LauncherApkProgress.$stable;
    private final LauncherApkProgress progress;
    private final long token;

    public static /* synthetic */ LauncherProgressDispatch copy$default(LauncherProgressDispatch launcherProgressDispatch, long j, LauncherApkProgress launcherApkProgress, int i, Object obj) {
        if ((i & 1) != 0) {
            j = launcherProgressDispatch.token;
        }
        if ((i & 2) != 0) {
            launcherApkProgress = launcherProgressDispatch.progress;
        }
        return launcherProgressDispatch.copy(j, launcherApkProgress);
    }

    public final long component1() {
        return this.token;
    }

    public final LauncherApkProgress component2() {
        return this.progress;
    }

    public final LauncherProgressDispatch copy(long j, LauncherApkProgress progress) {
        Intrinsics.checkNotNullParameter(progress, "progress");
        return new LauncherProgressDispatch(j, progress);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof LauncherProgressDispatch) {
            LauncherProgressDispatch launcherProgressDispatch = (LauncherProgressDispatch) obj;
            return this.token == launcherProgressDispatch.token && Intrinsics.areEqual(this.progress, launcherProgressDispatch.progress);
        }
        return false;
    }

    public int hashCode() {
        return (Long.hashCode(this.token) * 31) + this.progress.hashCode();
    }

    public String toString() {
        long j = this.token;
        return "LauncherProgressDispatch(token=" + j + ", progress=" + this.progress + ")";
    }

    public LauncherProgressDispatch(long j, LauncherApkProgress progress) {
        Intrinsics.checkNotNullParameter(progress, "progress");
        this.token = j;
        this.progress = progress;
    }

    public final long getToken() {
        return this.token;
    }

    public final LauncherApkProgress getProgress() {
        return this.progress;
    }
}
