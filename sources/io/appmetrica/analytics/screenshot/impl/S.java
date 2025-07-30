package io.appmetrica.analytics.screenshot.impl;

import java.util.List;
/* loaded from: classes4.dex */
public final class S {

    /* renamed from: a  reason: collision with root package name */
    public final List f1286a;

    public S(List list) {
        this.f1286a = list;
    }

    public final void a(C0778k c0778k) {
        for (P p : this.f1286a) {
            C0779l c0779l = null;
            if (c0778k != null) {
                C0778k c0778k2 = Boolean.valueOf(c0778k.f1308a).booleanValue() ? c0778k : null;
                if (c0778k2 != null) {
                    c0779l = c0778k2.b;
                }
            }
            p.a(c0779l);
        }
    }
}
