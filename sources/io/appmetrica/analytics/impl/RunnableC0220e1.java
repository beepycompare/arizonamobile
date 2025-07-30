package io.appmetrica.analytics.impl;

import android.content.Context;
import io.appmetrica.analytics.StartupParamsCallback;
import java.util.List;
/* renamed from: io.appmetrica.analytics.impl.e1  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class RunnableC0220e1 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Context f824a;
    public final /* synthetic */ StartupParamsCallback b;
    public final /* synthetic */ List c;
    public final /* synthetic */ C0496p1 d;

    public RunnableC0220e1(C0496p1 c0496p1, Context context, StartupParamsCallback startupParamsCallback, List list) {
        this.d = c0496p1;
        this.f824a = context;
        this.b = startupParamsCallback;
        this.c = list;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C0619u0 c0619u0 = this.d.f995a;
        Context applicationContext = this.f824a.getApplicationContext();
        c0619u0.getClass();
        C0594t0 a2 = C0594t0.a(applicationContext);
        a2.f().a(this.b, this.c);
    }
}
