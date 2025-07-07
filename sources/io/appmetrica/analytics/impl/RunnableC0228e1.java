package io.appmetrica.analytics.impl;

import android.content.Context;
import io.appmetrica.analytics.StartupParamsCallback;
import java.util.List;
/* renamed from: io.appmetrica.analytics.impl.e1  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class RunnableC0228e1 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Context f813a;
    public final /* synthetic */ StartupParamsCallback b;
    public final /* synthetic */ List c;
    public final /* synthetic */ C0502p1 d;

    public RunnableC0228e1(C0502p1 c0502p1, Context context, StartupParamsCallback startupParamsCallback, List list) {
        this.d = c0502p1;
        this.f813a = context;
        this.b = startupParamsCallback;
        this.c = list;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C0625u0 c0625u0 = this.d.f983a;
        Context applicationContext = this.f813a.getApplicationContext();
        c0625u0.getClass();
        C0600t0 a2 = C0600t0.a(applicationContext);
        a2.f().a(this.b, this.c);
    }
}
