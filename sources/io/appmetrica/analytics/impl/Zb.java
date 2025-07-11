package io.appmetrica.analytics.impl;

import java.util.HashMap;
/* loaded from: classes4.dex */
public final class Zb implements InterfaceC0495p2 {

    /* renamed from: a  reason: collision with root package name */
    public final H4 f735a;

    public Zb(H4 h4) {
        this.f735a = h4;
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0495p2
    public final Zn a(Xn xn, Zn zn) {
        int i = xn.b;
        int i2 = this.f735a.f455a;
        if (i == i2) {
            if (((Zn) ((HashMap) xn.f712a.get(zn.b)).get(new String(zn.f745a))) != null) {
                ((HashMap) xn.f712a.get(zn.b)).put(new String(zn.f745a), zn);
                return zn;
            }
        } else if (i < i2) {
            ((HashMap) xn.f712a.get(zn.b)).put(new String(zn.f745a), zn);
            xn.b++;
        }
        return zn;
    }
}
