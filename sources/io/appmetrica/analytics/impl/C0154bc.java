package io.appmetrica.analytics.impl;

import java.util.HashMap;
/* renamed from: io.appmetrica.analytics.impl.bc  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0154bc implements InterfaceC0497p2 {

    /* renamed from: a  reason: collision with root package name */
    public final H4 f782a;

    public C0154bc(H4 h4) {
        this.f782a = h4;
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0497p2
    public final C0192co a(C0140ao c0140ao, C0192co c0192co) {
        int i = c0140ao.b;
        int i2 = this.f782a.f465a;
        if (i == i2) {
            if (((C0192co) ((HashMap) c0140ao.f774a.get(c0192co.b)).get(new String(c0192co.f806a))) != null) {
                ((HashMap) c0140ao.f774a.get(c0192co.b)).put(new String(c0192co.f806a), c0192co);
                return c0192co;
            }
        } else if (i < i2) {
            ((HashMap) c0140ao.f774a.get(c0192co.b)).put(new String(c0192co.f806a), c0192co);
            c0140ao.b++;
        }
        return c0192co;
    }
}
