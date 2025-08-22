package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreutils.internal.AndroidUtils;
/* loaded from: classes4.dex */
public final class M6 {
    public static Sf a() {
        if (AndroidUtils.isApiAchieved(28)) {
            return new Uf();
        }
        return new Tf();
    }
}
