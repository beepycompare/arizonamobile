package io.appmetrica.analytics.impl;

import java.util.HashMap;
/* loaded from: classes5.dex */
public final class Gb implements InterfaceC0340j2 {

    /* renamed from: a  reason: collision with root package name */
    public final C0418m4 f593a;

    public Gb(C0418m4 c0418m4) {
        this.f593a = c0418m4;
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0340j2
    public final C0259fo a(Cdo cdo, C0259fo c0259fo) {
        int i = cdo.b;
        int i2 = this.f593a.f1109a;
        if (i == i2) {
            if (((C0259fo) ((HashMap) cdo.f964a.get(c0259fo.b)).get(new String(c0259fo.f1001a))) != null) {
                ((HashMap) cdo.f964a.get(c0259fo.b)).put(new String(c0259fo.f1001a), c0259fo);
                return c0259fo;
            }
        } else if (i < i2) {
            ((HashMap) cdo.f964a.get(c0259fo.b)).put(new String(c0259fo.f1001a), c0259fo);
            cdo.b++;
        }
        return c0259fo;
    }
}
