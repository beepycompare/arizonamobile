package io.appmetrica.analytics.impl;

import java.util.HashMap;
/* loaded from: classes5.dex */
public final class Gb implements InterfaceC0339j2 {

    /* renamed from: a  reason: collision with root package name */
    public final C0417m4 f593a;

    public Gb(C0417m4 c0417m4) {
        this.f593a = c0417m4;
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0339j2
    public final C0258fo a(Cdo cdo, C0258fo c0258fo) {
        int i = cdo.b;
        int i2 = this.f593a.f1109a;
        if (i == i2) {
            if (((C0258fo) ((HashMap) cdo.f964a.get(c0258fo.b)).get(new String(c0258fo.f1001a))) != null) {
                ((HashMap) cdo.f964a.get(c0258fo.b)).put(new String(c0258fo.f1001a), c0258fo);
                return c0258fo;
            }
        } else if (i < i2) {
            ((HashMap) cdo.f964a.get(c0258fo.b)).put(new String(c0258fo.f1001a), c0258fo);
            cdo.b++;
        }
        return c0258fo;
    }
}
