package com.arizona.launcher.updater.archive.download;

import java.net.InetAddress;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Dns;
/* compiled from: ArchiveNetworkSecurity.kt */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0001\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0001\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u0016\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010\n\u001a\u00020\u000bH\u0016R\u000e\u0010\u0002\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000Ê\u0001\f\b\r\u0012\b\b\u000e\u0012\u0004\b\u0003\u0010\u0000¨\u0006\f"}, d2 = {"Lcom/arizona/launcher/updater/archive/download/SafeArchiveDns;", "Lokhttp3/Dns;", "delegate", "allowInsecureLoopback", "", "<init>", "(Lokhttp3/Dns;Z)V", "lookup", "", "Ljava/net/InetAddress;", "hostname", "", "app", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class SafeArchiveDns implements Dns {
    public static final int $stable = 8;
    private final boolean allowInsecureLoopback;
    private final Dns delegate;

    public SafeArchiveDns(Dns delegate, boolean z) {
        Intrinsics.checkNotNullParameter(delegate, "delegate");
        this.delegate = delegate;
        this.allowInsecureLoopback = z;
    }

    @Override // okhttp3.Dns
    public List<InetAddress> lookup(String hostname) {
        Intrinsics.checkNotNullParameter(hostname, "hostname");
        List<InetAddress> lookup = this.delegate.lookup(hostname);
        List<InetAddress> list = lookup;
        if ((list instanceof Collection) && list.isEmpty()) {
            return lookup;
        }
        for (InetAddress inetAddress : list) {
            if (ArchiveRemoteNetworkPolicy.INSTANCE.isUnsafeAddress(inetAddress) && (!this.allowInsecureLoopback || !inetAddress.isLoopbackAddress())) {
                throw new ArchiveUnsafeHostException("archive host resolved to a non-public address");
            }
        }
        return lookup;
    }
}
