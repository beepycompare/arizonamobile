package io.appmetrica.analytics.impl;
/* loaded from: classes3.dex */
public final class Jj implements Xa {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Yj f548a;

    public Jj(Yj yj) {
        this.f548a = yj;
    }

    @Override // io.appmetrica.analytics.impl.Xa
    public final void a(Ya ya) {
        Xj a2 = ((C0399ld) this.f548a).a();
        if (a2 != null) {
            ya.reportEvent(a2.f758a, a2.b);
        }
    }
}
