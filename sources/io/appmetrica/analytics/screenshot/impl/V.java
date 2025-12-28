package io.appmetrica.analytics.screenshot.impl;

import java.util.List;
/* loaded from: classes5.dex */
public final class V {

    /* renamed from: a  reason: collision with root package name */
    public final List f1448a;

    public V(InterfaceC0766i interfaceC0766i) {
        this.f1448a = interfaceC0766i.a();
    }

    public final void a(C0769l c0769l) {
        for (T t : this.f1448a) {
            C0770m c0770m = null;
            if (c0769l != null) {
                C0769l c0769l2 = Boolean.valueOf(c0769l.f1469a).booleanValue() ? c0769l : null;
                if (c0769l2 != null) {
                    c0770m = c0769l2.b;
                }
            }
            t.a(c0770m);
        }
    }
}
