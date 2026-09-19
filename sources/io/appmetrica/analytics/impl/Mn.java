package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.networktasks.internal.NetworkServiceLocator;
import io.appmetrica.analytics.networktasks.internal.NetworkTask;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes5.dex */
public class Mn implements Nk, P9 {

    /* renamed from: a  reason: collision with root package name */
    public final InterfaceC0271gb f672a;
    public final InterfaceC0437mm b;
    public final AtomicBoolean c = new AtomicBoolean(false);

    public Mn(InterfaceC0271gb interfaceC0271gb, InterfaceC0437mm interfaceC0437mm) {
        this.f672a = interfaceC0271gb;
        this.b = interfaceC0437mm;
        Objects.toString(interfaceC0271gb.a());
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

    public final InterfaceC0271gb d() {
        return this.f672a;
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
