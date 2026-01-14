package io.appmetrica.analytics.screenshot.impl;

import java.util.List;
/* loaded from: classes5.dex */
public final class V {

    /* renamed from: a  reason: collision with root package name */
    public final List f1457a;

    public V(InterfaceC0770i interfaceC0770i) {
        this.f1457a = interfaceC0770i.a();
    }

    public final void a(C0773l c0773l) {
        for (T t : this.f1457a) {
            C0774m c0774m = null;
            if (c0773l != null) {
                C0773l c0773l2 = Boolean.valueOf(c0773l.f1478a).booleanValue() ? c0773l : null;
                if (c0773l2 != null) {
                    c0774m = c0773l2.b;
                }
            }
            t.a(c0774m);
        }
    }
}
