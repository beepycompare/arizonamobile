package io.appmetrica.analytics.impl;

import androidx.fragment.app.FragmentTransaction;
/* renamed from: io.appmetrica.analytics.impl.wk  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0689wk implements Dg {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ C0715xk f1274a;

    public C0689wk(C0715xk c0715xk) {
        this.f1274a = c0715xk;
    }

    @Override // io.appmetrica.analytics.impl.Dg
    public final void a(Lg lg) {
        Bg a2 = lg.a();
        if (a2 != null && !this.f1274a.b()) {
            try {
                C0235f6 c0235f6 = new C0235f6("", "", 0);
                c0235f6.setValueBytes(a2.a());
                Db db = Db.EVENT_TYPE_UNDEFINED;
                c0235f6.d = FragmentTransaction.TRANSIT_FRAGMENT_OPEN;
                this.f1274a.f1022a.a(c0235f6);
                C0715xk.b(this.f1274a);
            } catch (Throwable unused) {
            }
        }
    }
}
