package io.appmetrica.analytics.impl;
/* loaded from: classes4.dex */
public final class W3 extends AbstractC0310h8 {
    @Override // io.appmetrica.analytics.impl.AbstractC0310h8
    public final boolean a(N3 n3, N3 n32) {
        if (fo.a(n32.f547a)) {
            return true;
        }
        if (fo.a(n3.f547a)) {
            return false;
        }
        EnumC0335i8 enumC0335i8 = n3.b;
        if (enumC0335i8 == EnumC0335i8.c) {
            if (((Number) this.f864a.a(enumC0335i8)).intValue() >= ((Number) this.f864a.a(n32.b)).intValue()) {
                return true;
            }
        } else if (((Number) this.f864a.a(enumC0335i8)).intValue() > ((Number) this.f864a.a(n32.b)).intValue()) {
            return true;
        }
        return false;
    }
}
