package io.appmetrica.analytics.impl;

import android.content.Context;
import io.appmetrica.analytics.StartupParamsCallback;
import java.util.List;
/* renamed from: io.appmetrica.analytics.impl.g1  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class RunnableC0266g1 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Context f887a;
    public final /* synthetic */ StartupParamsCallback b;
    public final /* synthetic */ List c;
    public final /* synthetic */ C0548r1 d;

    public RunnableC0266g1(C0548r1 c0548r1, Context context, StartupParamsCallback startupParamsCallback, List list) {
        this.d = c0548r1;
        this.f887a = context;
        this.b = startupParamsCallback;
        this.c = list;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C0672w0 c0672w0 = this.d.f1059a;
        Context applicationContext = this.f887a.getApplicationContext();
        c0672w0.getClass();
        C0647v0 a2 = C0647v0.a(applicationContext);
        a2.f().a(this.b, this.c);
    }
}
