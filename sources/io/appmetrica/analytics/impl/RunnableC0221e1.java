package io.appmetrica.analytics.impl;

import android.content.Context;
import io.appmetrica.analytics.StartupParamsCallback;
import java.util.List;
/* renamed from: io.appmetrica.analytics.impl.e1  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class RunnableC0221e1 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Context f823a;
    public final /* synthetic */ StartupParamsCallback b;
    public final /* synthetic */ List c;
    public final /* synthetic */ C0497p1 d;

    public RunnableC0221e1(C0497p1 c0497p1, Context context, StartupParamsCallback startupParamsCallback, List list) {
        this.d = c0497p1;
        this.f823a = context;
        this.b = startupParamsCallback;
        this.c = list;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C0620u0 c0620u0 = this.d.f994a;
        Context applicationContext = this.f823a.getApplicationContext();
        c0620u0.getClass();
        C0595t0 a2 = C0595t0.a(applicationContext);
        a2.f().a(this.b, this.c);
    }
}
