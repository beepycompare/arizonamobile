package io.appmetrica.analytics.impl;

import java.util.HashMap;
/* renamed from: io.appmetrica.analytics.impl.bc  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0155bc implements InterfaceC0498p2 {

    /* renamed from: a  reason: collision with root package name */
    public final H4 f781a;

    public C0155bc(H4 h4) {
        this.f781a = h4;
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0498p2
    public final C0193co a(C0141ao c0141ao, C0193co c0193co) {
        int i = c0141ao.b;
        int i2 = this.f781a.f464a;
        if (i == i2) {
            if (((C0193co) ((HashMap) c0141ao.f773a.get(c0193co.b)).get(new String(c0193co.f805a))) != null) {
                ((HashMap) c0141ao.f773a.get(c0193co.b)).put(new String(c0193co.f805a), c0193co);
                return c0193co;
            }
        } else if (i < i2) {
            ((HashMap) c0141ao.f773a.get(c0193co.b)).put(new String(c0193co.f805a), c0193co);
            c0141ao.b++;
        }
        return c0193co;
    }
}
