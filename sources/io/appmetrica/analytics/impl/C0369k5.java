package io.appmetrica.analytics.impl;

import java.util.List;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicBoolean;
/* renamed from: io.appmetrica.analytics.impl.k5  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0369k5 implements InterfaceC0523q9 {

    /* renamed from: a  reason: collision with root package name */
    public final InterfaceC0647v9 f1075a;
    public final List b;
    public final List c;
    public final AtomicBoolean d;

    public C0369k5(InterfaceC0647v9 interfaceC0647v9, List<? extends F8> list, List<? extends F8> list2, Q4 q4) {
        this.f1075a = interfaceC0647v9;
        this.b = list;
        this.c = list2;
        Objects.toString(q4);
        this.d = new AtomicBoolean(true);
    }

    public final boolean a() {
        List<F8> list = this.c;
        if (!list.isEmpty() && !list.isEmpty()) {
            for (F8 f8 : list) {
                if (!f8.b()) {
                    return false;
                }
            }
        }
        List<F8> list2 = this.b;
        if (list2.isEmpty() || list2.isEmpty()) {
            return false;
        }
        for (F8 f82 : list2) {
            if (f82.b()) {
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
            List<F8> list = this.c;
            if (!list.isEmpty() && !list.isEmpty()) {
                for (F8 f8 : list) {
                    if (!f8.b()) {
                        return;
                    }
                }
            }
            ((C0412ln) this.f1075a).c();
        }
    }

    public final void e() {
        if (this.d.get() && a()) {
            ((C0412ln) this.f1075a).c();
        }
    }

    public final void f() {
        if (this.d.get() && a()) {
            ((C0412ln) this.f1075a).b();
        }
    }
}
