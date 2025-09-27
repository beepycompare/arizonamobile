package io.appmetrica.analytics.impl;

import java.util.HashMap;
/* renamed from: io.appmetrica.analytics.impl.gc  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0276gc implements InterfaceC0548r2 {

    /* renamed from: a  reason: collision with root package name */
    public final K4 f894a;

    public C0276gc(K4 k4) {
        this.f894a = k4;
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0548r2
    public final C0417lo a(C0365jo c0365jo, C0417lo c0417lo) {
        int i = c0365jo.b;
        int i2 = this.f894a.f532a;
        if (i == i2) {
            if (((C0417lo) ((HashMap) c0365jo.f944a.get(c0417lo.b)).get(new String(c0417lo.f981a))) != null) {
                ((HashMap) c0365jo.f944a.get(c0417lo.b)).put(new String(c0417lo.f981a), c0417lo);
                return c0417lo;
            }
        } else if (i < i2) {
            ((HashMap) c0365jo.f944a.get(c0417lo.b)).put(new String(c0417lo.f981a), c0417lo);
            c0365jo.b++;
        }
        return c0417lo;
    }
}
