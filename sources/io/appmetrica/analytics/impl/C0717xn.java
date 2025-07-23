package io.appmetrica.analytics.impl;

import android.os.Looper;
import java.util.Map;
/* renamed from: io.appmetrica.analytics.impl.xn  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0717xn implements InterfaceC0767zn {
    @Override // io.appmetrica.analytics.impl.InterfaceC0767zn
    public final Thread a() {
        return Looper.getMainLooper().getThread();
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0767zn
    public final StackTraceElement[] b() {
        return null;
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0767zn
    public final Map c() {
        return Thread.getAllStackTraces();
    }
}
