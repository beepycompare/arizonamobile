package io.appmetrica.analytics.impl;
/* renamed from: io.appmetrica.analytics.impl.qj  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0538qj implements Hg {

    /* renamed from: a  reason: collision with root package name */
    public final Hg f1169a;

    public C0538qj(Hg hg) {
        this.f1169a = hg;
    }

    @Override // io.appmetrica.analytics.impl.Hg
    public final String a() {
        return this.f1169a.a();
    }

    @Override // io.appmetrica.analytics.impl.Hg
    public final void a(Dg dg) {
        try {
            this.f1169a.a(dg);
        } catch (Throwable th) {
            String str = "Failed to request " + this.f1169a.a() + " referrer";
            C0539qk c0539qk = Oj.f708a;
            c0539qk.getClass();
            c0539qk.a(new Pj(str, th));
            dg.a(new Jg(str, th));
        }
    }
}
