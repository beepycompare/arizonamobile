package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreutils.internal.AndroidUtils;
/* loaded from: classes4.dex */
public final class Qe extends Yc {
    public Qe() {
        super(Te.UNDEFINED);
        a(1, Te.WIFI);
        a(0, Te.CELL);
        a(3, Te.ETHERNET);
        a(2, Te.BLUETOOTH);
        a(4, Te.VPN);
        if (AndroidUtils.isApiAchieved(27)) {
            a(6, Te.LOWPAN);
        }
        if (AndroidUtils.isApiAchieved(26)) {
            a(5, Te.WIFI_AWARE);
        }
    }
}
