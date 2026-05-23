package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.appsetid.internal.AppSetIdRetriever;
import io.appmetrica.analytics.appsetid.internal.IAppSetIdRetriever;
import io.appmetrica.analytics.coreutils.internal.reflection.ReflectionUtils;
/* renamed from: io.appmetrica.analytics.impl.o2  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public abstract class AbstractC0471o2 {
    public static final IAppSetIdRetriever a() {
        if (ReflectionUtils.detectClassExists("com.google.android.gms.appset.AppSet")) {
            return new AppSetIdRetriever();
        }
        return new C0451n8();
    }
}
