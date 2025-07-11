package io.appmetrica.analytics.screenshot.impl;

import java.util.List;
/* loaded from: classes4.dex */
public final class S {

    /* renamed from: a  reason: collision with root package name */
    public final List f1282a;

    public S(List list) {
        this.f1282a = list;
    }

    public final void a(C0776k c0776k) {
        for (P p : this.f1282a) {
            C0777l c0777l = null;
            if (c0776k != null) {
                C0776k c0776k2 = Boolean.valueOf(c0776k.f1304a).booleanValue() ? c0776k : null;
                if (c0776k2 != null) {
                    c0777l = c0776k2.b;
                }
            }
            p.a(c0777l);
        }
    }
}
