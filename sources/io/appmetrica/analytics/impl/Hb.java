package io.appmetrica.analytics.impl;

import java.util.HashMap;
/* loaded from: classes5.dex */
public final class Hb implements InterfaceC0362k2 {

    /* renamed from: a  reason: collision with root package name */
    public final C0440n4 f504a;

    public Hb(C0440n4 c0440n4) {
        this.f504a = c0440n4;
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0362k2
    public final C0281go a(C0229eo c0229eo, C0281go c0281go) {
        int i = c0229eo.b;
        int i2 = this.f504a.f1022a;
        if (i == i2) {
            if (((C0281go) ((HashMap) c0229eo.f877a.get(c0281go.b)).get(new String(c0281go.f913a))) != null) {
                ((HashMap) c0229eo.f877a.get(c0281go.b)).put(new String(c0281go.f913a), c0281go);
                return c0281go;
            }
        } else if (i < i2) {
            ((HashMap) c0229eo.f877a.get(c0281go.b)).put(new String(c0281go.f913a), c0281go);
            c0229eo.b++;
        }
        return c0281go;
    }
}
