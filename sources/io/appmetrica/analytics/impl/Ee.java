package io.appmetrica.analytics.impl;
/* loaded from: classes5.dex */
public final class Ee implements Hg {

    /* renamed from: a  reason: collision with root package name */
    public final String f534a;
    public final String b;

    public Ee(String str) {
        this.f534a = str;
        this.b = str == null ? "<unknown-package-installer>" : str;
    }

    @Override // io.appmetrica.analytics.impl.Hg
    public final String a() {
        return this.b;
    }

    @Override // io.appmetrica.analytics.impl.Hg
    public final void a(Dg dg) {
        dg.a(new Jg("Package installer " + this.f534a + " is not supported", null, 2, null));
    }
}
