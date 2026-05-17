package io.appmetrica.analytics.impl;
/* loaded from: classes5.dex */
public final class Ej implements Qa {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Tj f574a;

    public Ej(Tj tj) {
        this.f574a = tj;
    }

    @Override // io.appmetrica.analytics.impl.Qa
    public final void a(Ra ra) {
        Sj a2 = ((C0221ed) this.f574a).a();
        if (a2 != null) {
            ra.reportEvent(a2.f789a, a2.b);
        }
    }
}
