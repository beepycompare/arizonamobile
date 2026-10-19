package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.networktasks.internal.NetworkServiceLocator;
import io.appmetrica.analytics.networktasks.internal.NetworkTask;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes5.dex */
public class Mn implements Nk, P9 {

    /* renamed from: a  reason: collision with root package name */
    public final InterfaceC0266gb f675a;
    public final InterfaceC0432mm b;
    public final AtomicBoolean c = new AtomicBoolean(false);

    public Mn(InterfaceC0266gb interfaceC0266gb, InterfaceC0432mm interfaceC0432mm) {
        this.f675a = interfaceC0266gb;
        this.b = interfaceC0432mm;
        Objects.toString(interfaceC0266gb.a());
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

    public final InterfaceC0266gb d() {
        return this.f675a;
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
