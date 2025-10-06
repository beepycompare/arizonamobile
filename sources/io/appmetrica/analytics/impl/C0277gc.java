package io.appmetrica.analytics.impl;

import java.util.HashMap;
/* renamed from: io.appmetrica.analytics.impl.gc  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0277gc implements InterfaceC0549r2 {

    /* renamed from: a  reason: collision with root package name */
    public final K4 f894a;

    public C0277gc(K4 k4) {
        this.f894a = k4;
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0549r2
    public final C0418lo a(C0366jo c0366jo, C0418lo c0418lo) {
        int i = c0366jo.b;
        int i2 = this.f894a.f532a;
        if (i == i2) {
            if (((C0418lo) ((HashMap) c0366jo.f944a.get(c0418lo.b)).get(new String(c0418lo.f981a))) != null) {
                ((HashMap) c0366jo.f944a.get(c0418lo.b)).put(new String(c0418lo.f981a), c0418lo);
                return c0418lo;
            }
        } else if (i < i2) {
            ((HashMap) c0366jo.f944a.get(c0418lo.b)).put(new String(c0418lo.f981a), c0418lo);
            c0366jo.b++;
        }
        return c0418lo;
    }
}
