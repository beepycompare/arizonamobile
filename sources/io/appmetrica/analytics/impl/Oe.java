package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreutils.internal.AndroidUtils;
/* loaded from: classes4.dex */
public final class Oe extends Wc {
    public Oe() {
        super(Re.UNDEFINED);
        a(1, Re.WIFI);
        a(0, Re.CELL);
        a(3, Re.ETHERNET);
        a(2, Re.BLUETOOTH);
        a(4, Re.VPN);
        if (AndroidUtils.isApiAchieved(27)) {
            a(6, Re.LOWPAN);
        }
        if (AndroidUtils.isApiAchieved(26)) {
            a(5, Re.WIFI_AWARE);
        }
    }
}
