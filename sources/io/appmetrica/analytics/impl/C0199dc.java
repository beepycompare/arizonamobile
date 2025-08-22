package io.appmetrica.analytics.impl;

import java.util.HashMap;
/* renamed from: io.appmetrica.analytics.impl.dc  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0199dc implements InterfaceC0495p2 {

    /* renamed from: a  reason: collision with root package name */
    public final H4 f828a;

    public C0199dc(H4 h4) {
        this.f828a = h4;
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0495p2
    public final C0314ho a(C0262fo c0262fo, C0314ho c0314ho) {
        int i = c0262fo.b;
        int i2 = this.f828a.f469a;
        if (i == i2) {
            if (((C0314ho) ((HashMap) c0262fo.f860a.get(c0314ho.b)).get(new String(c0314ho.f896a))) != null) {
                ((HashMap) c0262fo.f860a.get(c0314ho.b)).put(new String(c0314ho.f896a), c0314ho);
                return c0314ho;
            }
        } else if (i < i2) {
            ((HashMap) c0262fo.f860a.get(c0314ho.b)).put(new String(c0314ho.f896a), c0314ho);
            c0262fo.b++;
        }
        return c0314ho;
    }
}
