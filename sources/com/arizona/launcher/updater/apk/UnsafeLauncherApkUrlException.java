package com.arizona.launcher.updater.apk;

import java.io.IOException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: LauncherApkNetworkSecurity.kt */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\b\u0001\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007Ê\u0001\f\b\t\u0012\b\b\n\u0012\u0004\b\u0003\u0010\u0000¨\u0006\b"}, d2 = {"Lcom/arizona/launcher/updater/apk/UnsafeLauncherApkUrlException;", "Ljava/io/IOException;", "blockedUrl", "", "<init>", "(Ljava/lang/String;)V", "getBlockedUrl", "()Ljava/lang/String;", "app", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class UnsafeLauncherApkUrlException extends IOException {
    public static final int $stable = 8;
    private final String blockedUrl;

    public final String getBlockedUrl() {
        return this.blockedUrl;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public UnsafeLauncherApkUrlException(String blockedUrl) {
        super("unsafe launcher APK URL: " + blockedUrl);
        Intrinsics.checkNotNullParameter(blockedUrl, "blockedUrl");
        this.blockedUrl = blockedUrl;
    }
}
