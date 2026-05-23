package io.appmetrica.analytics.impl;
/* renamed from: io.appmetrica.analytics.impl.qj  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0540qj implements Hg {

    /* renamed from: a  reason: collision with root package name */
    public final Hg f1166a;

    public C0540qj(Hg hg) {
        this.f1166a = hg;
    }

    @Override // io.appmetrica.analytics.impl.Hg
    public final String a() {
        return this.f1166a.a();
    }

    @Override // io.appmetrica.analytics.impl.Hg
    public final void a(Dg dg) {
        try {
            this.f1166a.a(dg);
        } catch (Throwable th) {
            String str = "Failed to request " + this.f1166a.a() + " referrer";
            C0541qk c0541qk = Oj.f705a;
            c0541qk.getClass();
            c0541qk.a(new Pj(str, th));
            dg.a(new Jg(str, th));
        }
    }
}
