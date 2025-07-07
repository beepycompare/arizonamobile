package io.appmetrica.analytics.impl;

import java.util.HashMap;
/* loaded from: classes4.dex */
public final class Zb implements InterfaceC0503p2 {

    /* renamed from: a  reason: collision with root package name */
    public final H4 f734a;

    public Zb(H4 h4) {
        this.f734a = h4;
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0503p2
    public final Zn a(Xn xn, Zn zn) {
        int i = xn.b;
        int i2 = this.f734a.f454a;
        if (i == i2) {
            if (((Zn) ((HashMap) xn.f711a.get(zn.b)).get(new String(zn.f744a))) != null) {
                ((HashMap) xn.f711a.get(zn.b)).put(new String(zn.f744a), zn);
                return zn;
            }
        } else if (i < i2) {
            ((HashMap) xn.f711a.get(zn.b)).put(new String(zn.f744a), zn);
            xn.b++;
        }
        return zn;
    }
}
