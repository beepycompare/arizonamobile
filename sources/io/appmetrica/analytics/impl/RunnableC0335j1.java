package io.appmetrica.analytics.impl;

import android.content.Context;
import io.appmetrica.analytics.StartupParamsCallback;
import java.util.List;
/* renamed from: io.appmetrica.analytics.impl.j1  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class RunnableC0335j1 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Context f948a;
    public final /* synthetic */ StartupParamsCallback b;
    public final /* synthetic */ List c;
    public final /* synthetic */ C0611u1 d;

    public RunnableC0335j1(C0611u1 c0611u1, Context context, StartupParamsCallback startupParamsCallback, List list) {
        this.d = c0611u1;
        this.f948a = context;
        this.b = startupParamsCallback;
        this.c = list;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C0735z0 c0735z0 = this.d.f1141a;
        Context applicationContext = this.f948a.getApplicationContext();
        c0735z0.getClass();
        C0710y0 a2 = C0710y0.a(applicationContext);
        a2.f().a(this.b, this.c);
    }
}
