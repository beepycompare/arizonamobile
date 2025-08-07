package io.appmetrica.analytics.impl;
/* loaded from: classes4.dex */
public final class W3 extends AbstractC0379k8 {
    @Override // io.appmetrica.analytics.impl.AbstractC0379k8
    public final boolean a(N3 n3, N3 n32) {
        if (io.a(n32.f558a)) {
            return true;
        }
        if (io.a(n3.f558a)) {
            return false;
        }
        EnumC0404l8 enumC0404l8 = n3.b;
        if (enumC0404l8 == EnumC0404l8.c) {
            if (((Number) this.f923a.a(enumC0404l8)).intValue() >= ((Number) this.f923a.a(n32.b)).intValue()) {
                return true;
            }
        } else if (((Number) this.f923a.a(enumC0404l8)).intValue() > ((Number) this.f923a.a(n32.b)).intValue()) {
            return true;
        }
        return false;
    }
}
