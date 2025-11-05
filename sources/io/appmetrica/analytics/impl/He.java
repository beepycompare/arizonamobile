package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.system.NetworkType;
/* loaded from: classes3.dex */
public final class He extends Kc {
    public He(NetworkType networkType) {
        super(networkType);
        a(1, NetworkType.WIFI);
        a(0, NetworkType.CELL);
        a(7, NetworkType.BLUETOOTH);
        a(9, NetworkType.ETHERNET);
        a(4, NetworkType.MOBILE_DUN);
        a(5, NetworkType.MOBILE_HIPRI);
        a(2, NetworkType.MOBILE_MMS);
        a(3, NetworkType.MOBILE_SUPL);
        a(6, NetworkType.WIMAX);
        a(17, NetworkType.VPN);
    }
}
