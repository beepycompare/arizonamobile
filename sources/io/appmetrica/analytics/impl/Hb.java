package io.appmetrica.analytics.impl;

import java.util.HashMap;
/* loaded from: classes5.dex */
public final class Hb implements InterfaceC0361k2 {

    /* renamed from: a  reason: collision with root package name */
    public final C0439n4 f601a;

    public Hb(C0439n4 c0439n4) {
        this.f601a = c0439n4;
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0361k2
    public final C0280go a(C0228eo c0228eo, C0280go c0280go) {
        int i = c0228eo.b;
        int i2 = this.f601a.f1119a;
        if (i == i2) {
            if (((C0280go) ((HashMap) c0228eo.f974a.get(c0280go.b)).get(new String(c0280go.f1010a))) != null) {
                ((HashMap) c0228eo.f974a.get(c0280go.b)).put(new String(c0280go.f1010a), c0280go);
                return c0280go;
            }
        } else if (i < i2) {
            ((HashMap) c0228eo.f974a.get(c0280go.b)).put(new String(c0280go.f1010a), c0280go);
            c0228eo.b++;
        }
        return c0280go;
    }
}
