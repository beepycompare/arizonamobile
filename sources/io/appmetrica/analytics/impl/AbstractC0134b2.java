package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.appsetid.internal.AppSetIdRetriever;
import io.appmetrica.analytics.appsetid.internal.IAppSetIdRetriever;
import io.appmetrica.analytics.coreutils.internal.reflection.ReflectionUtils;
/* renamed from: io.appmetrica.analytics.impl.b2  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public abstract class AbstractC0134b2 {
    public static final IAppSetIdRetriever a() {
        if (ReflectionUtils.detectClassExists("com.google.android.gms.appset.AppSet")) {
            return new AppSetIdRetriever();
        }
        return new U7();
    }
}
