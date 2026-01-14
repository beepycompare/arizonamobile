package io.appmetrica.analytics.impl;

import android.os.Looper;
import java.util.Map;
/* loaded from: classes5.dex */
public final class An implements Cn {
    @Override // io.appmetrica.analytics.impl.Cn
    public final Thread a() {
        return Looper.getMainLooper().getThread();
    }

    @Override // io.appmetrica.analytics.impl.Cn
    public final StackTraceElement[] b() {
        return null;
    }

    @Override // io.appmetrica.analytics.impl.Cn
    public final Map c() {
        return Thread.getAllStackTraces();
    }
}
