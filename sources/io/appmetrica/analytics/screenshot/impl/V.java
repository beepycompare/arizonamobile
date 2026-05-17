package io.appmetrica.analytics.screenshot.impl;

import java.util.List;
/* loaded from: classes5.dex */
public final class V {

    /* renamed from: a  reason: collision with root package name */
    public final List f1461a;

    public V(InterfaceC0769i interfaceC0769i) {
        this.f1461a = interfaceC0769i.a();
    }

    public final void a(C0772l c0772l) {
        for (T t : this.f1461a) {
            C0773m c0773m = null;
            if (c0772l != null) {
                C0772l c0772l2 = Boolean.valueOf(c0772l.f1482a).booleanValue() ? c0772l : null;
                if (c0772l2 != null) {
                    c0773m = c0772l2.b;
                }
            }
            t.a(c0773m);
        }
    }
}
