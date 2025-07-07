package io.appmetrica.analytics.impl;

import java.util.List;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes4.dex */
public final class D5 implements I9 {

    /* renamed from: a  reason: collision with root package name */
    public final N9 f383a;
    public final List b;
    public final List c;
    public final AtomicBoolean d;

    public D5(N9 n9, List<? extends V8> list, List<? extends V8> list2, C0406l5 c0406l5) {
        this.f383a = n9;
        this.b = list;
        this.c = list2;
        Objects.toString(c0406l5);
        this.d = new AtomicBoolean(true);
    }

    public final boolean a() {
        List<V8> list = this.c;
        if (!list.isEmpty() && !list.isEmpty()) {
            for (V8 v8 : list) {
                if (!v8.b()) {
                    return false;
                }
            }
        }
        List<V8> list2 = this.b;
        if (list2.isEmpty() || list2.isEmpty()) {
            return false;
        }
        for (V8 v82 : list2) {
            if (v82.b()) {
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
            List<V8> list = this.c;
            if (!list.isEmpty() && !list.isEmpty()) {
                for (V8 v8 : list) {
                    if (!v8.b()) {
                        return;
                    }
                }
            }
            ((C0300gn) this.f383a).c();
        }
    }

    public final void e() {
        if (this.d.get() && a()) {
            ((C0300gn) this.f383a).c();
        }
    }

    public final void f() {
        if (this.d.get() && a()) {
            ((C0300gn) this.f383a).b();
        }
    }
}
