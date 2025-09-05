package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreutils.internal.AndroidUtils;
/* loaded from: classes4.dex */
public final class P6 {
    public static Wf a() {
        if (AndroidUtils.isApiAchieved(28)) {
            return new Yf();
        }
        return new Xf();
    }
}
