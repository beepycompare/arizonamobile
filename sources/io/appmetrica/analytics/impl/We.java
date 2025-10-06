package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreutils.internal.AndroidUtils;
/* loaded from: classes4.dex */
public final class We extends C0201dd {
    public We() {
        super(Ze.UNDEFINED);
        a(1, Ze.WIFI);
        a(0, Ze.CELL);
        a(3, Ze.ETHERNET);
        a(2, Ze.BLUETOOTH);
        a(4, Ze.VPN);
        if (AndroidUtils.isApiAchieved(27)) {
            a(6, Ze.LOWPAN);
        }
        if (AndroidUtils.isApiAchieved(26)) {
            a(5, Ze.WIFI_AWARE);
        }
    }
}
