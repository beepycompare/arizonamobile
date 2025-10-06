package io.appmetrica.analytics.impl;

import java.util.List;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes4.dex */
public final class I5 implements Q9 {

    /* renamed from: a  reason: collision with root package name */
    public final V9 f490a;
    public final List b;
    public final List c;
    public final AtomicBoolean d;

    public I5(V9 v9, List<? extends InterfaceC0197d9> list, List<? extends InterfaceC0197d9> list2, C0477o5 c0477o5) {
        this.f490a = v9;
        this.b = list;
        this.c = list2;
        Objects.toString(c0477o5);
        this.d = new AtomicBoolean(true);
    }

    public final boolean a() {
        List<InterfaceC0197d9> list = this.c;
        if (!list.isEmpty() && !list.isEmpty()) {
            for (InterfaceC0197d9 interfaceC0197d9 : list) {
                if (!interfaceC0197d9.b()) {
                    return false;
                }
            }
        }
        List<InterfaceC0197d9> list2 = this.b;
        if (list2.isEmpty() || list2.isEmpty()) {
            return false;
        }
        for (InterfaceC0197d9 interfaceC0197d92 : list2) {
            if (interfaceC0197d92.b()) {
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
            List<InterfaceC0197d9> list = this.c;
            if (!list.isEmpty() && !list.isEmpty()) {
                for (InterfaceC0197d9 interfaceC0197d9 : list) {
                    if (!interfaceC0197d9.b()) {
                        return;
                    }
                }
            }
            ((C0595sn) this.f490a).c();
        }
    }

    public final void e() {
        if (this.d.get() && a()) {
            ((C0595sn) this.f490a).c();
        }
    }

    public final void f() {
        if (this.d.get() && a()) {
            ((C0595sn) this.f490a).b();
        }
    }
}
