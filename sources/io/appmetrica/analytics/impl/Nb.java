package io.appmetrica.analytics.impl;

import java.util.HashMap;
/* loaded from: classes5.dex */
public final class Nb implements InterfaceC0562s2 {

    /* renamed from: a  reason: collision with root package name */
    public final C0589t4 f604a;

    public Nb(C0589t4 c0589t4) {
        this.f604a = c0589t4;
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0562s2
    public final C0307ho a(C0255fo c0255fo, C0307ho c0307ho) {
        int i = c0255fo.b;
        int i2 = this.f604a.f1125a;
        if (i == i2) {
            if (((C0307ho) ((HashMap) c0255fo.f882a.get(c0307ho.b)).get(new String(c0307ho.f919a))) != null) {
                ((HashMap) c0255fo.f882a.get(c0307ho.b)).put(new String(c0307ho.f919a), c0307ho);
                return c0307ho;
            }
        } else if (i < i2) {
            ((HashMap) c0255fo.f882a.get(c0307ho.b)).put(new String(c0307ho.f919a), c0307ho);
            c0255fo.b++;
        }
        return c0307ho;
    }
}
