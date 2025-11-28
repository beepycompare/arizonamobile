package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreutils.internal.AndroidUtils;
/* renamed from: io.appmetrica.analytics.impl.x6  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0691x6 {
    public static Hf a() {
        if (AndroidUtils.isApiAchieved(28)) {
            return new Jf();
        }
        return new If();
    }
}
