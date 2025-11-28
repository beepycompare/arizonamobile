package io.appmetrica.analytics.impl;

import android.content.res.Configuration;
import io.appmetrica.analytics.coreutils.internal.AndroidUtils;
import java.util.List;
import kotlin.collections.CollectionsKt;
/* loaded from: classes5.dex */
public final class Pb {
    public static List a(Configuration configuration) {
        if (AndroidUtils.isApiAchieved(24)) {
            return Qb.a(configuration);
        }
        return CollectionsKt.listOf(Le.a(configuration.locale));
    }
}
