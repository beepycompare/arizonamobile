package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.servicecomponents.ActivationBarrierCallback;
import java.util.concurrent.TimeUnit;
/* renamed from: io.appmetrica.analytics.impl.lf  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0405lf implements Vc, ActivationBarrierCallback {

    /* renamed from: a  reason: collision with root package name */
    public final L9 f1082a;
    public final Uc b;
    public final Uc c;

    public C0405lf(L9 l9, C0278gh c0278gh, F4 f4, C0690wf c0690wf) {
        this.f1082a = l9;
        Uc uc = new Uc(c0278gh, f4, c0690wf);
        this.b = uc;
        this.c = uc;
        if (uc.b()) {
            return;
        }
        Na.k().a().subscribe(TimeUnit.SECONDS.toMillis(AbstractC0114a8.f885a.longValue()), Na.k().w().f(), this);
    }

    @Override // io.appmetrica.analytics.impl.Vc
    public final Z8 a() {
        return this.c;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.servicecomponents.ActivationBarrierCallback
    public final void onWaitFinished() {
        this.b.a();
        ((A5) this.f1082a.a()).e();
    }
}
