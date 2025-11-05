package io.appmetrica.analytics.impl;

import android.content.Context;
import android.os.Bundle;
/* renamed from: io.appmetrica.analytics.impl.qh  reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class RunnableC0528qh implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final Context f1076a;
    public final W5 b;
    public final Bundle c;
    public final C0313i4 d;

    public RunnableC0528qh(Context context, W5 w5, Bundle bundle, C0313i4 c0313i4) {
        this.f1076a = context;
        this.b = w5;
        this.c = bundle;
        this.d = c0313i4;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            P3 a2 = P3.a(this.f1076a, this.c);
            if (a2 == null) {
                return;
            }
            X3 a3 = X3.a(a2);
            C0353jj v = C0620ua.H.v();
            v.a(a2.b.getAppVersion(), a2.b.getAppBuildNumber());
            v.a(a2.b.getDeviceType());
            C0664w4 c0664w4 = new C0664w4(new C0202dm(a2), new C0639v4(a2.b, AbstractC0447nb.c(a2.f629a.f492a.getAsString("PROCESS_CFG_CLIDS"))), a2.f629a.b);
            this.d.a(a3, c0664w4).a(this.b, c0664w4);
        } catch (Throwable th) {
            Vj vj = AbstractC0604tj.f1136a;
            vj.getClass();
            vj.a(new C0629uj("Exception during processing event with type: " + this.b.d + " (" + this.b.e + "): " + th.getMessage(), th));
        }
    }
}
