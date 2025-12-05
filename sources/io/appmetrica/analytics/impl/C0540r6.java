package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreutils.internal.AndroidUtils;
/* renamed from: io.appmetrica.analytics.impl.r6  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0540r6 {
    public static Df a() {
        if (AndroidUtils.isApiAchieved(28)) {
            return new Ff();
        }
        return new Ef();
    }
}
