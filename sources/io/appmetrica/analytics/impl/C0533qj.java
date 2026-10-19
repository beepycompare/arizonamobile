package io.appmetrica.analytics.impl;
/* renamed from: io.appmetrica.analytics.impl.qj  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0533qj implements Hg {

    /* renamed from: a  reason: collision with root package name */
    public final Hg f1172a;

    public C0533qj(Hg hg) {
        this.f1172a = hg;
    }

    @Override // io.appmetrica.analytics.impl.Hg
    public final String a() {
        return this.f1172a.a();
    }

    @Override // io.appmetrica.analytics.impl.Hg
    public final void a(Dg dg) {
        try {
            this.f1172a.a(dg);
        } catch (Throwable th) {
            String str = "Failed to request " + this.f1172a.a() + " referrer";
            C0534qk c0534qk = Oj.f711a;
            c0534qk.getClass();
            c0534qk.a(new Pj(str, th));
            dg.a(new Jg(str, th));
        }
    }
}
