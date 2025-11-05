package io.appmetrica.analytics.impl;

import android.content.Context;
import io.appmetrica.analytics.StartupParamsCallback;
import java.util.List;
/* renamed from: io.appmetrica.analytics.impl.h1  reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class RunnableC0284h1 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Context f903a;
    public final /* synthetic */ StartupParamsCallback b;
    public final /* synthetic */ List c;
    public final /* synthetic */ C0561s1 d;

    public RunnableC0284h1(C0561s1 c0561s1, Context context, StartupParamsCallback startupParamsCallback, List list) {
        this.d = c0561s1;
        this.f903a = context;
        this.b = startupParamsCallback;
        this.c = list;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C0685x0 c0685x0 = this.d.f1103a;
        Context applicationContext = this.f903a.getApplicationContext();
        c0685x0.getClass();
        C0660w0 a2 = C0660w0.a(applicationContext);
        a2.f().a(this.b, this.c);
    }
}
