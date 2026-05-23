package io.appmetrica.analytics.impl;

import android.os.Looper;
import java.util.Map;
/* renamed from: io.appmetrica.analytics.impl.do  reason: invalid class name */
/* loaded from: classes5.dex */
public final class Cdo implements InterfaceC0260fo {
    @Override // io.appmetrica.analytics.impl.InterfaceC0260fo
    public final Thread a() {
        return Looper.getMainLooper().getThread();
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0260fo
    public final StackTraceElement[] b() {
        return null;
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0260fo
    public final Map c() {
        return Thread.getAllStackTraces();
    }
}
