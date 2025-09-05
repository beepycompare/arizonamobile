package io.appmetrica.analytics.impl;

import android.content.Context;
import io.appmetrica.analytics.StartupParamsCallback;
import java.util.List;
/* renamed from: io.appmetrica.analytics.impl.g1  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class RunnableC0265g1 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Context f882a;
    public final /* synthetic */ StartupParamsCallback b;
    public final /* synthetic */ List c;
    public final /* synthetic */ C0547r1 d;

    public RunnableC0265g1(C0547r1 c0547r1, Context context, StartupParamsCallback startupParamsCallback, List list) {
        this.d = c0547r1;
        this.f882a = context;
        this.b = startupParamsCallback;
        this.c = list;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C0671w0 c0671w0 = this.d.f1054a;
        Context applicationContext = this.f882a.getApplicationContext();
        c0671w0.getClass();
        C0646v0 a2 = C0646v0.a(applicationContext);
        a2.f().a(this.b, this.c);
    }
}
