package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreutils.internal.AndroidUtils;
/* loaded from: classes4.dex */
public final class Se extends C0122ad {
    public Se() {
        super(Ve.UNDEFINED);
        a(1, Ve.WIFI);
        a(0, Ve.CELL);
        a(3, Ve.ETHERNET);
        a(2, Ve.BLUETOOTH);
        a(4, Ve.VPN);
        if (AndroidUtils.isApiAchieved(27)) {
            a(6, Ve.LOWPAN);
        }
        if (AndroidUtils.isApiAchieved(26)) {
            a(5, Ve.WIFI_AWARE);
        }
    }
}
