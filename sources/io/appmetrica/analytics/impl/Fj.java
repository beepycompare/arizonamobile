package io.appmetrica.analytics.impl;
/* loaded from: classes5.dex */
public final class Fj implements Ra {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Uj f481a;

    public Fj(Uj uj) {
        this.f481a = uj;
    }

    @Override // io.appmetrica.analytics.impl.Ra
    public final void a(Sa sa) {
        Tj a2 = ((C0244fd) this.f481a).a();
        if (a2 != null) {
            sa.reportEvent(a2.f696a, a2.b);
        }
    }
}
