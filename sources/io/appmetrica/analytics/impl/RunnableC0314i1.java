package io.appmetrica.analytics.impl;

import android.content.Context;
import io.appmetrica.analytics.StartupParamsCallback;
import java.util.List;
/* renamed from: io.appmetrica.analytics.impl.i1  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class RunnableC0314i1 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Context f1037a;
    public final /* synthetic */ StartupParamsCallback b;
    public final /* synthetic */ List c;
    public final /* synthetic */ C0589t1 d;

    public RunnableC0314i1(C0589t1 c0589t1, Context context, StartupParamsCallback startupParamsCallback, List list) {
        this.d = c0589t1;
        this.f1037a = context;
        this.b = startupParamsCallback;
        this.c = list;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C0738z0 c0738z0 = this.d.f1229a;
        Context applicationContext = this.f1037a.getApplicationContext();
        c0738z0.getClass();
        C0713y0 a2 = C0713y0.a(applicationContext);
        a2.f().a(this.b, this.c);
    }
}
