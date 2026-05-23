package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.system.NetworkType;
import io.appmetrica.analytics.coreutils.internal.AndroidUtils;
/* renamed from: io.appmetrica.analytics.impl.ef  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0225ef extends C0223ed {
    public C0225ef(NetworkType networkType) {
        super(networkType);
        a(1, NetworkType.WIFI);
        a(0, NetworkType.CELL);
        a(3, NetworkType.ETHERNET);
        a(2, NetworkType.BLUETOOTH);
        a(4, NetworkType.VPN);
        if (AndroidUtils.isApiAchieved(27)) {
            a(6, NetworkType.LOWPAN);
        }
        if (AndroidUtils.isApiAchieved(26)) {
            a(5, NetworkType.WIFI_AWARE);
        }
    }
}
