package io.appmetrica.analytics.impl;

import android.content.Context;
import android.os.Bundle;
/* renamed from: io.appmetrica.analytics.impl.mh  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class RunnableC0428mh implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final Context f1013a;
    public final Q5 b;
    public final Bundle c;
    public final C0132b4 d;

    public RunnableC0428mh(Context context, Q5 q5, Bundle bundle, C0132b4 c0132b4) {
        this.f1013a = context;
        this.b = q5;
        this.c = bundle;
        this.d = c0132b4;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            I3 a2 = I3.a(this.f1013a, this.c);
            if (a2 == null) {
                return;
            }
            Q3 a3 = Q3.a(a2);
            C0250fj v = C0471oa.I.v();
            v.a(a2.b.getAppVersion(), a2.b.getAppBuildNumber());
            v.a(a2.b.getDeviceType());
            C0515q4 c0515q4 = new C0515q4(new C0124am(a2), new C0490p4(a2.b, AbstractC0294hb.c(a2.f518a.f432a.getAsString("PROCESS_CFG_CLIDS"))), a2.f518a.b);
            this.d.a(a3, c0515q4).a(this.b, c0515q4);
        } catch (Throwable th) {
            Rj rj = AbstractC0505pj.f1071a;
            rj.getClass();
            rj.a(new C0530qj("Exception during processing event with type: " + this.b.d + " (" + this.b.e + "): " + th.getMessage(), th));
        }
    }
}
