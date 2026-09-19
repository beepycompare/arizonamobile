package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreutils.internal.AndroidUtils;
/* loaded from: classes5.dex */
public final class I6 {
    public static InterfaceC0199dg a() {
        if (AndroidUtils.isApiAchieved(28)) {
            return new C0250fg();
        }
        return new C0224eg();
    }
}
