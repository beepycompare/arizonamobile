package io.appmetrica.analytics.impl;

import java.util.List;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes4.dex */
public final class F5 implements N9 {

    /* renamed from: a  reason: collision with root package name */
    public final S9 f427a;
    public final List b;
    public final List c;
    public final AtomicBoolean d;

    public F5(S9 s9, List<? extends InterfaceC0118a9> list, List<? extends InterfaceC0118a9> list2, C0398l5 c0398l5) {
        this.f427a = s9;
        this.b = list;
        this.c = list2;
        Objects.toString(c0398l5);
        this.d = new AtomicBoolean(true);
    }

    public final boolean a() {
        List<InterfaceC0118a9> list = this.c;
        if (!list.isEmpty() && !list.isEmpty()) {
            for (InterfaceC0118a9 interfaceC0118a9 : list) {
                if (!interfaceC0118a9.b()) {
                    return false;
                }
            }
        }
        List<InterfaceC0118a9> list2 = this.b;
        if (list2.isEmpty() || list2.isEmpty()) {
            return false;
        }
        for (InterfaceC0118a9 interfaceC0118a92 : list2) {
            if (interfaceC0118a92.b()) {
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
            List<InterfaceC0118a9> list = this.c;
            if (!list.isEmpty() && !list.isEmpty()) {
                for (InterfaceC0118a9 interfaceC0118a9 : list) {
                    if (!interfaceC0118a9.b()) {
                        return;
                    }
                }
            }
            ((C0491on) this.f427a).c();
        }
    }

    public final void e() {
        if (this.d.get() && a()) {
            ((C0491on) this.f427a).c();
        }
    }

    public final void f() {
        if (this.d.get() && a()) {
            ((C0491on) this.f427a).b();
        }
    }
}
