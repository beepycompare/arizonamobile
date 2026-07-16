package io.appmetrica.analytics.impl;

import java.util.List;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes5.dex */
public final class A5 implements K9 {

    /* renamed from: a  reason: collision with root package name */
    public final P9 f453a;
    public final List b;
    public final List c;
    public final AtomicBoolean d;

    public A5(P9 p9, List<? extends Z8> list, List<? extends Z8> list2, C0267g5 c0267g5) {
        this.f453a = p9;
        this.b = list;
        this.c = list2;
        Objects.toString(c0267g5);
        this.d = new AtomicBoolean(true);
    }

    public final boolean a() {
        List<Z8> list = this.c;
        if (!list.isEmpty() && !list.isEmpty()) {
            for (Z8 z8 : list) {
                if (!z8.b()) {
                    return false;
                }
            }
        }
        List<Z8> list2 = this.b;
        if (list2.isEmpty() || list2.isEmpty()) {
            return false;
        }
        for (Z8 z82 : list2) {
            if (z82.b()) {
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
            List<Z8> list = this.c;
            if (!list.isEmpty() && !list.isEmpty()) {
                for (Z8 z8 : list) {
                    if (!z8.b()) {
                        return;
                    }
                }
            }
            ((Mn) this.f453a).c();
        }
    }

    public final void e() {
        if (this.d.get() && a()) {
            ((Mn) this.f453a).c();
        }
    }

    public final void f() {
        if (this.d.get() && a()) {
            ((Mn) this.f453a).b();
        }
    }
}
