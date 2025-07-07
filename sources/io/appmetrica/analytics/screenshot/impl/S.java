package io.appmetrica.analytics.screenshot.impl;

import java.util.List;
/* loaded from: classes4.dex */
public final class S {

    /* renamed from: a  reason: collision with root package name */
    public final List f1281a;

    public S(List list) {
        this.f1281a = list;
    }

    public final void a(C0784k c0784k) {
        for (P p : this.f1281a) {
            C0785l c0785l = null;
            if (c0784k != null) {
                C0784k c0784k2 = Boolean.valueOf(c0784k.f1303a).booleanValue() ? c0784k : null;
                if (c0784k2 != null) {
                    c0785l = c0784k2.b;
                }
            }
            p.a(c0785l);
        }
    }
}
