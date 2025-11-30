package io.appmetrica.analytics.impl;

import android.os.Looper;
import java.util.Map;
/* loaded from: classes5.dex */
public final class Bn implements Dn {
    @Override // io.appmetrica.analytics.impl.Dn
    public final Thread a() {
        return Looper.getMainLooper().getThread();
    }

    @Override // io.appmetrica.analytics.impl.Dn
    public final StackTraceElement[] b() {
        return null;
    }

    @Override // io.appmetrica.analytics.impl.Dn
    public final Map c() {
        return Thread.getAllStackTraces();
    }
}
