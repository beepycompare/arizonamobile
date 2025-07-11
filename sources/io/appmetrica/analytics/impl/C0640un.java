package io.appmetrica.analytics.impl;

import android.os.Looper;
import java.util.Map;
/* renamed from: io.appmetrica.analytics.impl.un  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0640un implements InterfaceC0690wn {
    @Override // io.appmetrica.analytics.impl.InterfaceC0690wn
    public final Thread a() {
        return Looper.getMainLooper().getThread();
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0690wn
    public final StackTraceElement[] b() {
        return null;
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0690wn
    public final Map c() {
        return Thread.getAllStackTraces();
    }
}
