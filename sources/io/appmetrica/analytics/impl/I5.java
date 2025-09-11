package io.appmetrica.analytics.impl;

import java.util.List;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes4.dex */
public final class I5 implements Q9 {

    /* renamed from: a  reason: collision with root package name */
    public final V9 f489a;
    public final List b;
    public final List c;
    public final AtomicBoolean d;

    public I5(V9 v9, List<? extends InterfaceC0196d9> list, List<? extends InterfaceC0196d9> list2, C0476o5 c0476o5) {
        this.f489a = v9;
        this.b = list;
        this.c = list2;
        Objects.toString(c0476o5);
        this.d = new AtomicBoolean(true);
    }

    public final boolean a() {
        List<InterfaceC0196d9> list = this.c;
        if (!list.isEmpty() && !list.isEmpty()) {
            for (InterfaceC0196d9 interfaceC0196d9 : list) {
                if (!interfaceC0196d9.b()) {
                    return false;
                }
            }
        }
        List<InterfaceC0196d9> list2 = this.b;
        if (list2.isEmpty() || list2.isEmpty()) {
            return false;
        }
        for (InterfaceC0196d9 interfaceC0196d92 : list2) {
            if (interfaceC0196d92.b()) {
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
            List<InterfaceC0196d9> list = this.c;
            if (!list.isEmpty() && !list.isEmpty()) {
                for (InterfaceC0196d9 interfaceC0196d9 : list) {
                    if (!interfaceC0196d9.b()) {
                        return;
                    }
                }
            }
            ((C0594sn) this.f489a).c();
        }
    }

    public final void e() {
        if (this.d.get() && a()) {
            ((C0594sn) this.f489a).c();
        }
    }

    public final void f() {
        if (this.d.get() && a()) {
            ((C0594sn) this.f489a).b();
        }
    }
}
