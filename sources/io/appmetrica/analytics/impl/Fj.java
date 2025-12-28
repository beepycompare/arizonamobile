package io.appmetrica.analytics.impl;
/* loaded from: classes5.dex */
public final class Fj implements Ra {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Uj f579a;

    public Fj(Uj uj) {
        this.f579a = uj;
    }

    @Override // io.appmetrica.analytics.impl.Ra
    public final void a(Sa sa) {
        Tj a2 = ((C0243fd) this.f579a).a();
        if (a2 != null) {
            sa.reportEvent(a2.f794a, a2.b);
        }
    }
}
