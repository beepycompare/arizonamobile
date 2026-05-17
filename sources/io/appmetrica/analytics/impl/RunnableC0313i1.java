package io.appmetrica.analytics.impl;

import android.content.Context;
import io.appmetrica.analytics.StartupParamsCallback;
import java.util.List;
/* renamed from: io.appmetrica.analytics.impl.i1  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class RunnableC0313i1 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Context f1041a;
    public final /* synthetic */ StartupParamsCallback b;
    public final /* synthetic */ List c;
    public final /* synthetic */ C0588t1 d;

    public RunnableC0313i1(C0588t1 c0588t1, Context context, StartupParamsCallback startupParamsCallback, List list) {
        this.d = c0588t1;
        this.f1041a = context;
        this.b = startupParamsCallback;
        this.c = list;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C0737z0 c0737z0 = this.d.f1233a;
        Context applicationContext = this.f1041a.getApplicationContext();
        c0737z0.getClass();
        C0712y0 a2 = C0712y0.a(applicationContext);
        a2.f().a(this.b, this.c);
    }
}
