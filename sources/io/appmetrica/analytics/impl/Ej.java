package io.appmetrica.analytics.impl;
/* loaded from: classes5.dex */
public final class Ej implements Qa {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Tj f569a;

    public Ej(Tj tj) {
        this.f569a = tj;
    }

    @Override // io.appmetrica.analytics.impl.Qa
    public final void a(Ra ra) {
        Sj a2 = ((C0221ed) this.f569a).a();
        if (a2 != null) {
            ra.reportEvent(a2.f784a, a2.b);
        }
    }
}
