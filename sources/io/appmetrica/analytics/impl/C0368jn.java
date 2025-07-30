package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.networktasks.internal.NetworkServiceLocator;
import io.appmetrica.analytics.networktasks.internal.NetworkTask;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicBoolean;
/* renamed from: io.appmetrica.analytics.impl.jn  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public class C0368jn implements InterfaceC0589sk, Q9 {

    /* renamed from: a  reason: collision with root package name */
    public final Za f919a;
    public final Kl b;
    public final AtomicBoolean c = new AtomicBoolean(false);

    public C0368jn(Za za, Kl kl) {
        this.f919a = za;
        this.b = kl;
        Objects.toString(za.b());
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

    public final Za d() {
        return this.f919a;
    }

    public final boolean e() {
        return this.c.get();
    }

    public void f() {
        this.b.a();
    }

    public void g() {
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0589sk
    public final void onCreate() {
        this.c.compareAndSet(true, false);
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0589sk
    public final void onDestroy() {
        if (this.c.compareAndSet(false, true)) {
            a();
        }
    }

    public final void a(NetworkTask networkTask) {
        Ia.F.getClass();
        NetworkServiceLocator.getInstance().getNetworkCore().startTask(networkTask);
    }
}
