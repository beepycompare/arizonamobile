package io.appmetrica.analytics.screenshot.impl;

import java.util.List;
/* loaded from: classes4.dex */
public final class S {

    /* renamed from: a  reason: collision with root package name */
    public final List f1304a;

    public S(List list) {
        this.f1304a = list;
    }

    public final void a(C0780k c0780k) {
        for (P p : this.f1304a) {
            C0781l c0781l = null;
            if (c0780k != null) {
                C0780k c0780k2 = Boolean.valueOf(c0780k.f1326a).booleanValue() ? c0780k : null;
                if (c0780k2 != null) {
                    c0781l = c0780k2.b;
                }
            }
            p.a(c0781l);
        }
    }
}
