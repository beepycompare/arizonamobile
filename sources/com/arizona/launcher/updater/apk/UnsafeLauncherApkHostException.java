package com.arizona.launcher.updater.apk;

import java.net.UnknownHostException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: LauncherApkNetworkSecurity.kt */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\b\u0001\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007Ê\u0001\f\b\t\u0012\b\b\n\u0012\u0004\b\u0003\u0010\u0000¨\u0006\b"}, d2 = {"Lcom/arizona/launcher/updater/apk/UnsafeLauncherApkHostException;", "Ljava/net/UnknownHostException;", "blockedHost", "", "<init>", "(Ljava/lang/String;)V", "getBlockedHost", "()Ljava/lang/String;", "app", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class UnsafeLauncherApkHostException extends UnknownHostException {
    public static final int $stable = 8;
    private final String blockedHost;

    public final String getBlockedHost() {
        return this.blockedHost;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public UnsafeLauncherApkHostException(String blockedHost) {
        super("launcher APK host resolved to a non-public address: " + blockedHost);
        Intrinsics.checkNotNullParameter(blockedHost, "blockedHost");
        this.blockedHost = blockedHost;
    }
}
