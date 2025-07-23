package io.appmetrica.analytics.impl;

import java.util.List;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes4.dex */
public final class F5 implements L9 {

    /* renamed from: a  reason: collision with root package name */
    public final Q9 f430a;
    public final List b;
    public final List c;
    public final AtomicBoolean d;

    public F5(Q9 q9, List<? extends Y8> list, List<? extends Y8> list2, C0400l5 c0400l5) {
        this.f430a = q9;
        this.b = list;
        this.c = list2;
        Objects.toString(c0400l5);
        this.d = new AtomicBoolean(true);
    }

    public final boolean a() {
        List<Y8> list = this.c;
        if (!list.isEmpty() && !list.isEmpty()) {
            for (Y8 y8 : list) {
                if (!y8.b()) {
                    return false;
                }
            }
        }
        List<Y8> list2 = this.b;
        if (list2.isEmpty() || list2.isEmpty()) {
            return false;
        }
        for (Y8 y82 : list2) {
            if (y82.b()) {
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
            List<Y8> list = this.c;
            if (!list.isEmpty() && !list.isEmpty()) {
                for (Y8 y8 : list) {
                    if (!y8.b()) {
                        return;
                    }
                }
            }
            ((C0368jn) this.f430a).c();
        }
    }

    public final void e() {
        if (this.d.get() && a()) {
            ((C0368jn) this.f430a).c();
        }
    }

    public final void f() {
        if (this.d.get() && a()) {
            ((C0368jn) this.f430a).b();
        }
    }
}
