package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.servicecomponents.ActivationBarrierCallback;
import java.util.concurrent.TimeUnit;
/* loaded from: classes5.dex */
public final class Pe implements Bc, ActivationBarrierCallback {

    /* renamed from: a  reason: collision with root package name */
    public final InterfaceC0719y9 f636a;
    public final Ac b;
    public final Ac c;

    public Pe(InterfaceC0719y9 interfaceC0719y9, Vg vg, C0639v4 c0639v4, C0143bf c0143bf) {
        this.f636a = interfaceC0719y9;
        Ac ac = new Ac(vg, c0639v4, c0143bf);
        this.b = ac;
        this.c = ac;
        if (ac.b()) {
            return;
        }
        C0620ua.k().a().subscribe(TimeUnit.SECONDS.toMillis(O7.f618a.longValue()), C0620ua.k().x().e(), this);
    }

    @Override // io.appmetrica.analytics.impl.Bc
    public final K8 a() {
        return this.c;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.servicecomponents.ActivationBarrierCallback
    public final void onWaitFinished() {
        this.b.a();
        ((C0540r5) this.f636a.a()).e();
    }
}
