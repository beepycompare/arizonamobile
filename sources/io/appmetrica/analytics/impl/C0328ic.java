package io.appmetrica.analytics.impl;

import android.content.res.Configuration;
import io.appmetrica.analytics.coreutils.internal.AndroidUtils;
import java.util.List;
import kotlin.collections.CollectionsKt;
/* renamed from: io.appmetrica.analytics.impl.ic  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0328ic {
    public static List a(Configuration configuration) {
        if (AndroidUtils.isApiAchieved(24)) {
            return AbstractC0353jc.a(configuration);
        }
        return CollectionsKt.listOf(AbstractC0124af.a(configuration.locale));
    }
}
