package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.networktasks.internal.NetworkServiceLocator;
import io.appmetrica.analytics.networktasks.internal.NetworkTask;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes5.dex */
public class Mn implements Nk, P9 {

    /* renamed from: a  reason: collision with root package name */
    public final InterfaceC0273gb f670a;
    public final InterfaceC0439mm b;
    public final AtomicBoolean c = new AtomicBoolean(false);

    public Mn(InterfaceC0273gb interfaceC0273gb, InterfaceC0439mm interfaceC0439mm) {
        this.f670a = interfaceC0273gb;
        this.b = interfaceC0439mm;
        Objects.toString(interfaceC0273gb.a());
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

    public final InterfaceC0273gb d() {
        return this.f670a;
    }

    public final boolean e() {
        return this.c.get();
    }

    public void f() {
        this.b.a();
    }

    public void g() {
    }

    @Override // io.appmetrica.analytics.impl.Nk
    public final void onCreate() {
        this.c.compareAndSet(true, false);
    }

    @Override // io.appmetrica.analytics.impl.Nk
    public final void onDestroy() {
        if (this.c.compareAndSet(false, true)) {
            a();
        }
    }

    public final void a(NetworkTask networkTask) {
        Na.I.getClass();
        NetworkServiceLocator.getInstance().getNetworkCore().startTask(networkTask);
    }
}
