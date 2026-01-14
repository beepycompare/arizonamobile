package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreutils.internal.AndroidUtils;
/* renamed from: io.appmetrica.analytics.impl.q6  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0520q6 {
    public static Cf a() {
        if (AndroidUtils.isApiAchieved(28)) {
            return new Ef();
        }
        return new Df();
    }
}
