package io.appmetrica.analytics.impl;

import androidx.fragment.app.FragmentTransaction;
/* renamed from: io.appmetrica.analytics.impl.wk  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0696wk implements Dg {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ C0722xk f1271a;

    public C0696wk(C0722xk c0722xk) {
        this.f1271a = c0722xk;
    }

    @Override // io.appmetrica.analytics.impl.Dg
    public final void a(Lg lg) {
        Bg a2 = lg.a();
        if (a2 != null && !this.f1271a.b()) {
            try {
                C0242f6 c0242f6 = new C0242f6("", "", 0);
                c0242f6.setValueBytes(a2.a());
                Db db = Db.EVENT_TYPE_UNDEFINED;
                c0242f6.d = FragmentTransaction.TRANSIT_FRAGMENT_OPEN;
                this.f1271a.f1019a.a(c0242f6);
                C0722xk.b(this.f1271a);
            } catch (Throwable unused) {
            }
        }
    }
}
