package io.appmetrica.analytics.impl;

import android.content.Context;
import android.os.Bundle;
/* renamed from: io.appmetrica.analytics.impl.mh  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class RunnableC0427mh implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final Context f1096a;
    public final Q5 b;
    public final Bundle c;
    public final C0131b4 d;

    public RunnableC0427mh(Context context, Q5 q5, Bundle bundle, C0131b4 c0131b4) {
        this.f1096a = context;
        this.b = q5;
        this.c = bundle;
        this.d = c0131b4;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            I3 a2 = I3.a(this.f1096a, this.c);
            if (a2 == null) {
                return;
            }
            Q3 a3 = Q3.a(a2);
            C0249fj v = C0470oa.I.v();
            v.a(a2.b.getAppVersion(), a2.b.getAppBuildNumber());
            v.a(a2.b.getDeviceType());
            C0514q4 c0514q4 = new C0514q4(new C0123am(a2), new C0489p4(a2.b, AbstractC0293hb.c(a2.f601a.f515a.getAsString("PROCESS_CFG_CLIDS"))), a2.f601a.b);
            this.d.a(a3, c0514q4).a(this.b, c0514q4);
        } catch (Throwable th) {
            Rj rj = AbstractC0504pj.f1154a;
            rj.getClass();
            rj.a(new C0529qj("Exception during processing event with type: " + this.b.d + " (" + this.b.e + "): " + th.getMessage(), th));
        }
    }
}
