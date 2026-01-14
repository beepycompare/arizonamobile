package io.appmetrica.analytics.impl;

import android.content.res.Configuration;
import io.appmetrica.analytics.coreutils.internal.AndroidUtils;
import java.util.List;
import kotlin.collections.CollectionsKt;
/* loaded from: classes5.dex */
public final class Ib {
    public static List a(Configuration configuration) {
        if (AndroidUtils.isApiAchieved(24)) {
            return Jb.a(configuration);
        }
        return CollectionsKt.listOf(Ge.a(configuration.locale));
    }
}
