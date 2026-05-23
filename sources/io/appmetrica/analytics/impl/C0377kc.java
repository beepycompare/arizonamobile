package io.appmetrica.analytics.impl;

import android.content.res.Configuration;
import io.appmetrica.analytics.coreutils.internal.AndroidUtils;
import java.util.List;
import kotlin.collections.CollectionsKt;
/* renamed from: io.appmetrica.analytics.impl.kc  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0377kc {
    public static List a(Configuration configuration) {
        if (AndroidUtils.isApiAchieved(24)) {
            return AbstractC0403lc.a(configuration);
        }
        return CollectionsKt.listOf(AbstractC0303hf.a(configuration.locale));
    }
}
