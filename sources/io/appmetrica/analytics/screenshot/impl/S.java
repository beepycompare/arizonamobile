package io.appmetrica.analytics.screenshot.impl;

import java.util.List;
/* loaded from: classes4.dex */
public final class S {

    /* renamed from: a  reason: collision with root package name */
    public final List f1305a;

    public S(List list) {
        this.f1305a = list;
    }

    public final void a(C0781k c0781k) {
        for (P p : this.f1305a) {
            C0782l c0782l = null;
            if (c0781k != null) {
                C0781k c0781k2 = Boolean.valueOf(c0781k.f1327a).booleanValue() ? c0781k : null;
                if (c0781k2 != null) {
                    c0782l = c0781k2.b;
                }
            }
            p.a(c0782l);
        }
    }
}
