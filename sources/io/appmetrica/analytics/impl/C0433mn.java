package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.networktasks.internal.NetworkServiceLocator;
import io.appmetrica.analytics.networktasks.internal.NetworkTask;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicBoolean;
/* renamed from: io.appmetrica.analytics.impl.mn  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public class C0433mn implements InterfaceC0430mk, InterfaceC0668w9 {

    /* renamed from: a  reason: collision with root package name */
    public final Fa f1099a;
    public final Ll b;
    public final AtomicBoolean c = new AtomicBoolean(false);

    public C0433mn(Fa fa, Ll ll) {
        this.f1099a = fa;
        this.b = ll;
        Objects.toString(fa.b());
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

    public final Fa d() {
        return this.f1099a;
    }

    public final boolean e() {
        return this.c.get();
    }

    public void f() {
        this.b.a();
    }

    public void g() {
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0430mk
    public final void onCreate() {
        this.c.compareAndSet(true, false);
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0430mk
    public final void onDestroy() {
        if (this.c.compareAndSet(false, true)) {
            a();
        }
    }

    public final void a(NetworkTask networkTask) {
        C0470oa.I.getClass();
        NetworkServiceLocator.getInstance().getNetworkCore().startTask(networkTask);
    }
}
