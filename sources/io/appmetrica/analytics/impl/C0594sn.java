package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.networktasks.internal.NetworkServiceLocator;
import io.appmetrica.analytics.networktasks.internal.NetworkTask;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicBoolean;
/* renamed from: io.appmetrica.analytics.impl.sn  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public class C0594sn implements Bk, V9 {

    /* renamed from: a  reason: collision with root package name */
    public final InterfaceC0223eb f1085a;
    public final Tl b;
    public final AtomicBoolean c = new AtomicBoolean(false);

    public C0594sn(InterfaceC0223eb interfaceC0223eb, Tl tl) {
        this.f1085a = interfaceC0223eb;
        this.b = tl;
        Objects.toString(interfaceC0223eb.b());
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

    public final InterfaceC0223eb d() {
        return this.f1085a;
    }

    public final boolean e() {
        return this.c.get();
    }

    public void f() {
        this.b.a();
    }

    public void g() {
    }

    @Override // io.appmetrica.analytics.impl.Bk
    public final void onCreate() {
        this.c.compareAndSet(true, false);
    }

    @Override // io.appmetrica.analytics.impl.Bk
    public final void onDestroy() {
        if (this.c.compareAndSet(false, true)) {
            a();
        }
    }

    public final void a(NetworkTask networkTask) {
        Na.F.getClass();
        NetworkServiceLocator.getInstance().getNetworkCore().startTask(networkTask);
    }
}
