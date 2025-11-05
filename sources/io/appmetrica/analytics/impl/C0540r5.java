package io.appmetrica.analytics.impl;

import java.util.List;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicBoolean;
/* renamed from: io.appmetrica.analytics.impl.r5  reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C0540r5 implements InterfaceC0694x9 {

    /* renamed from: a  reason: collision with root package name */
    public final C9 f1087a;
    public final List b;
    public final List c;
    public final AtomicBoolean d;

    public C0540r5(C9 c9, List<? extends K8> list, List<? extends K8> list2, X4 x4) {
        this.f1087a = c9;
        this.b = list;
        this.c = list2;
        Objects.toString(x4);
        this.d = new AtomicBoolean(true);
    }

    public final boolean a() {
        List<K8> list = this.c;
        if (!list.isEmpty() && !list.isEmpty()) {
            for (K8 k8 : list) {
                if (!k8.b()) {
                    return false;
                }
            }
        }
        List<K8> list2 = this.b;
        if (list2.isEmpty() || list2.isEmpty()) {
            return false;
        }
        for (K8 k82 : list2) {
            if (k82.b()) {
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
            List<K8> list = this.c;
            if (!list.isEmpty() && !list.isEmpty()) {
                for (K8 k8 : list) {
                    if (!k8.b()) {
                        return;
                    }
                }
            }
            ((C0484on) this.f1087a).c();
        }
    }

    public final void e() {
        if (this.d.get() && a()) {
            ((C0484on) this.f1087a).c();
        }
    }

    public final void f() {
        if (this.d.get() && a()) {
            ((C0484on) this.f1087a).b();
        }
    }
}
