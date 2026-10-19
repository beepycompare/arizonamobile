package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreutils.internal.AndroidUtils;
/* loaded from: classes5.dex */
public final class I6 {
    public static InterfaceC0194dg a() {
        if (AndroidUtils.isApiAchieved(28)) {
            return new C0245fg();
        }
        return new C0219eg();
    }
}
