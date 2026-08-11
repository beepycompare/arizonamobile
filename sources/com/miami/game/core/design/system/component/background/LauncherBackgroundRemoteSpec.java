package com.miami.game.core.design.system.component.background;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: LauncherBackgroundPolicy.kt */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0081\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0014\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0010\u001a\u00020\u0011HÖ\u0081\u0004J\n\u0010\u0012\u001a\u00020\u0003HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\bÊ\u0001\f\b\u0014\u0012\b\b\u0015\u0012\u0004\b\u0003\u0010\u0002¨\u0006\u0013"}, d2 = {"Lcom/miami/game/core/design/system/component/background/LauncherBackgroundRemoteSpec;", "", "path", "", "sha256", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "getPath", "()Ljava/lang/String;", "getSha256", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "design-system", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class LauncherBackgroundRemoteSpec {
    public static final int $stable = 0;
    private final String path;
    private final String sha256;

    public static /* synthetic */ LauncherBackgroundRemoteSpec copy$default(LauncherBackgroundRemoteSpec launcherBackgroundRemoteSpec, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = launcherBackgroundRemoteSpec.path;
        }
        if ((i & 2) != 0) {
            str2 = launcherBackgroundRemoteSpec.sha256;
        }
        return launcherBackgroundRemoteSpec.copy(str, str2);
    }

    public final String component1() {
        return this.path;
    }

    public final String component2() {
        return this.sha256;
    }

    public final LauncherBackgroundRemoteSpec copy(String path, String sha256) {
        Intrinsics.checkNotNullParameter(path, "path");
        Intrinsics.checkNotNullParameter(sha256, "sha256");
        return new LauncherBackgroundRemoteSpec(path, sha256);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof LauncherBackgroundRemoteSpec) {
            LauncherBackgroundRemoteSpec launcherBackgroundRemoteSpec = (LauncherBackgroundRemoteSpec) obj;
            return Intrinsics.areEqual(this.path, launcherBackgroundRemoteSpec.path) && Intrinsics.areEqual(this.sha256, launcherBackgroundRemoteSpec.sha256);
        }
        return false;
    }

    public int hashCode() {
        return (this.path.hashCode() * 31) + this.sha256.hashCode();
    }

    public String toString() {
        String str = this.path;
        return "LauncherBackgroundRemoteSpec(path=" + str + ", sha256=" + this.sha256 + ")";
    }

    public LauncherBackgroundRemoteSpec(String path, String sha256) {
        Intrinsics.checkNotNullParameter(path, "path");
        Intrinsics.checkNotNullParameter(sha256, "sha256");
        this.path = path;
        this.sha256 = sha256;
    }

    public final String getPath() {
        return this.path;
    }

    public final String getSha256() {
        return this.sha256;
    }
}
