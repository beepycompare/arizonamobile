package io.appmetrica.analytics.impl;

import android.os.Looper;
import java.util.Map;
/* loaded from: classes4.dex */
public final class Gn implements In {
    @Override // io.appmetrica.analytics.impl.In
    public final Thread a() {
        return Looper.getMainLooper().getThread();
    }

    @Override // io.appmetrica.analytics.impl.In
    public final StackTraceElement[] b() {
        return null;
    }

    @Override // io.appmetrica.analytics.impl.In
    public final Map c() {
        return Thread.getAllStackTraces();
    }
}
