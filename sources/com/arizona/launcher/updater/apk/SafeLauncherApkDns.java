package com.arizona.launcher.updater.apk;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Dns;
/* compiled from: LauncherApkNetworkSecurity.kt */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0001\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0001\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u0016\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\u0006\u0010\f\u001a\u00020\rH\u0016R\u000e\u0010\u0002\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000Ê\u0001\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\u0003\u0010\u0000¨\u0006\u000e"}, d2 = {"Lcom/arizona/launcher/updater/apk/SafeLauncherApkDns;", "Lokhttp3/Dns;", "delegate", "policy", "Lcom/arizona/launcher/updater/apk/LauncherApkNetworkPolicy;", "allowInsecureLoopback", "", "<init>", "(Lokhttp3/Dns;Lcom/arizona/launcher/updater/apk/LauncherApkNetworkPolicy;Z)V", "lookup", "", "Ljava/net/InetAddress;", "hostname", "", "app", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class SafeLauncherApkDns implements Dns {
    public static final int $stable = 8;
    private final boolean allowInsecureLoopback;
    private final Dns delegate;
    private final LauncherApkNetworkPolicy policy;

    public SafeLauncherApkDns(Dns delegate, LauncherApkNetworkPolicy policy, boolean z) {
        Intrinsics.checkNotNullParameter(delegate, "delegate");
        Intrinsics.checkNotNullParameter(policy, "policy");
        this.delegate = delegate;
        this.policy = policy;
        this.allowInsecureLoopback = z;
    }

    @Override // okhttp3.Dns
    public List<InetAddress> lookup(String hostname) {
        Intrinsics.checkNotNullParameter(hostname, "hostname");
        List<InetAddress> lookup = this.delegate.lookup(hostname);
        if (lookup.isEmpty()) {
            throw new UnknownHostException("launcher APK host has no DNS answers");
        }
        List<InetAddress> list = lookup;
        if ((list instanceof Collection) && list.isEmpty()) {
            return lookup;
        }
        for (InetAddress inetAddress : list) {
            if (this.policy.isUnsafeAddress(inetAddress) && (!this.allowInsecureLoopback || !inetAddress.isLoopbackAddress())) {
                throw new UnsafeLauncherApkHostException(hostname);
            }
        }
        return lookup;
    }
}
