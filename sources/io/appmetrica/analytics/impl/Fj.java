package io.appmetrica.analytics.impl;
/* loaded from: classes5.dex */
public final class Fj implements Ra {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Uj f578a;

    public Fj(Uj uj) {
        this.f578a = uj;
    }

    @Override // io.appmetrica.analytics.impl.Ra
    public final void a(Sa sa) {
        Tj a2 = ((C0243fd) this.f578a).a();
        if (a2 != null) {
            sa.reportEvent(a2.f793a, a2.b);
        }
    }
}
