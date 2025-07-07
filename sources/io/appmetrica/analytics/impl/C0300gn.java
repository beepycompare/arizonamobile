package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.networktasks.internal.NetworkServiceLocator;
import io.appmetrica.analytics.networktasks.internal.NetworkTask;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicBoolean;
/* renamed from: io.appmetrica.analytics.impl.gn  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public class C0300gn implements InterfaceC0521pk, N9 {

    /* renamed from: a  reason: collision with root package name */
    public final Xa f858a;
    public final Hl b;
    public final AtomicBoolean c = new AtomicBoolean(false);

    public C0300gn(Xa xa, Hl hl) {
        this.f858a = xa;
        this.b = hl;
        Objects.toString(xa.b());
    }

    public void a() {
    }

    public final void b() {
        if (this.c.get()) {
            return;
        }
        g();
    }

    public final void c() {
        if (this.c.get()) {
            return;
        }
        f();
        a();
    }

    public final Xa d() {
        return this.f858a;
    }

    public final boolean e() {
        return this.c.get();
    }

    public void f() {
        this.b.a();
    }

    public void g() {
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0521pk
    public final void onCreate() {
        this.c.compareAndSet(true, false);
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0521pk
    public final void onDestroy() {
        if (this.c.compareAndSet(false, true)) {
            a();
        }
    }

    public final void a(NetworkTask networkTask) {
        Ga.F.getClass();
        NetworkServiceLocator.getInstance().getNetworkCore().startTask(networkTask);
    }
}
