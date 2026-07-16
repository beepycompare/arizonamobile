package io.appmetrica.analytics.impl;

import android.content.Context;
import io.appmetrica.analytics.StartupParamsCallback;
import java.util.List;
/* renamed from: io.appmetrica.analytics.impl.k1  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class RunnableC0366k1 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Context f1062a;
    public final /* synthetic */ StartupParamsCallback b;
    public final /* synthetic */ List c;
    public final /* synthetic */ C0651v1 d;

    public RunnableC0366k1(C0651v1 c0651v1, Context context, StartupParamsCallback startupParamsCallback, List list) {
        this.d = c0651v1;
        this.f1062a = context;
        this.b = startupParamsCallback;
        this.c = list;
    }

    @Override // java.lang.Runnable
    public final void run() {
        B0 b0 = this.d.f1243a;
        Context applicationContext = this.f1062a.getApplicationContext();
        b0.getClass();
        A0 a2 = A0.a(applicationContext);
        a2.f().a(this.b, this.c);
    }
}
