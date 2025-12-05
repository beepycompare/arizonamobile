package io.appmetrica.analytics.impl;

import android.content.Context;
import io.appmetrica.analytics.StartupParamsCallback;
import java.util.List;
/* renamed from: io.appmetrica.analytics.impl.j1  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class RunnableC0334j1 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Context f1031a;
    public final /* synthetic */ StartupParamsCallback b;
    public final /* synthetic */ List c;
    public final /* synthetic */ C0610u1 d;

    public RunnableC0334j1(C0610u1 c0610u1, Context context, StartupParamsCallback startupParamsCallback, List list) {
        this.d = c0610u1;
        this.f1031a = context;
        this.b = startupParamsCallback;
        this.c = list;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C0734z0 c0734z0 = this.d.f1224a;
        Context applicationContext = this.f1031a.getApplicationContext();
        c0734z0.getClass();
        C0709y0 a2 = C0709y0.a(applicationContext);
        a2.f().a(this.b, this.c);
    }
}
