package io.appmetrica.analytics.screenshot.impl;

import java.util.List;
/* loaded from: classes4.dex */
public final class S {

    /* renamed from: a  reason: collision with root package name */
    public final List f1285a;

    public S(List list) {
        this.f1285a = list;
    }

    public final void a(C0779k c0779k) {
        for (P p : this.f1285a) {
            C0780l c0780l = null;
            if (c0779k != null) {
                C0779k c0779k2 = Boolean.valueOf(c0779k.f1307a).booleanValue() ? c0779k : null;
                if (c0779k2 != null) {
                    c0780l = c0779k2.b;
                }
            }
            p.a(c0780l);
        }
    }
}
