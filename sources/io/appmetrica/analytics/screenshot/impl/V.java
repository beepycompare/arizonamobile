package io.appmetrica.analytics.screenshot.impl;

import java.util.List;
/* loaded from: classes5.dex */
public final class V {

    /* renamed from: a  reason: collision with root package name */
    public final List f1348a;

    public V(InterfaceC0767i interfaceC0767i) {
        this.f1348a = interfaceC0767i.a();
    }

    public final void a(C0770l c0770l) {
        for (T t : this.f1348a) {
            C0771m c0771m = null;
            if (c0770l != null) {
                C0770l c0770l2 = Boolean.valueOf(c0770l.f1369a).booleanValue() ? c0770l : null;
                if (c0770l2 != null) {
                    c0771m = c0770l2.b;
                }
            }
            t.a(c0771m);
        }
    }
}
