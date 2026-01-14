package io.appmetrica.analytics.impl;
/* loaded from: classes5.dex */
public final class Ej implements Qa {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Tj f570a;

    public Ej(Tj tj) {
        this.f570a = tj;
    }

    @Override // io.appmetrica.analytics.impl.Qa
    public final void a(Ra ra) {
        Sj a2 = ((C0222ed) this.f570a).a();
        if (a2 != null) {
            ra.reportEvent(a2.f785a, a2.b);
        }
    }
}
