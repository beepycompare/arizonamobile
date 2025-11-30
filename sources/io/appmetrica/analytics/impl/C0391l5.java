package io.appmetrica.analytics.impl;

import java.util.List;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicBoolean;
/* renamed from: io.appmetrica.analytics.impl.l5  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0391l5 implements InterfaceC0544r9 {

    /* renamed from: a  reason: collision with root package name */
    public final InterfaceC0669w9 f987a;
    public final List b;
    public final List c;
    public final AtomicBoolean d;

    public C0391l5(InterfaceC0669w9 interfaceC0669w9, List<? extends G8> list, List<? extends G8> list2, R4 r4) {
        this.f987a = interfaceC0669w9;
        this.b = list;
        this.c = list2;
        Objects.toString(r4);
        this.d = new AtomicBoolean(true);
    }

    public final boolean a() {
        List<G8> list = this.c;
        if (!list.isEmpty() && !list.isEmpty()) {
            for (G8 g8 : list) {
                if (!g8.b()) {
                    return false;
                }
            }
        }
        List<G8> list2 = this.b;
        if (list2.isEmpty() || list2.isEmpty()) {
            return false;
        }
        for (G8 g82 : list2) {
            if (g82.b()) {
                return true;
            }
        }
        return false;
    }

    public final void b() {
        this.d.set(false);
    }

    public final void c() {
        this.d.set(true);
    }

    public final void d() {
        if (this.d.get()) {
            List<G8> list = this.c;
            if (!list.isEmpty() && !list.isEmpty()) {
                for (G8 g8 : list) {
                    if (!g8.b()) {
                        return;
                    }
                }
            }
            ((C0434mn) this.f987a).c();
        }
    }

    public final void e() {
        if (this.d.get() && a()) {
            ((C0434mn) this.f987a).c();
        }
    }

    public final void f() {
        if (this.d.get() && a()) {
            ((C0434mn) this.f987a).b();
        }
    }
}
