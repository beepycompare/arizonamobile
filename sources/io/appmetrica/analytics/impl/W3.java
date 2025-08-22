package io.appmetrica.analytics.impl;
/* loaded from: classes4.dex */
public final class W3 extends AbstractC0426m8 {
    @Override // io.appmetrica.analytics.impl.AbstractC0426m8
    public final boolean a(N3 n3, N3 n32) {
        if (no.a(n32.f572a)) {
            return true;
        }
        if (no.a(n3.f572a)) {
            return false;
        }
        EnumC0451n8 enumC0451n8 = n3.b;
        if (enumC0451n8 == EnumC0451n8.c) {
            if (((Number) this.f965a.a(enumC0451n8)).intValue() >= ((Number) this.f965a.a(n32.b)).intValue()) {
                return true;
            }
        } else if (((Number) this.f965a.a(enumC0451n8)).intValue() > ((Number) this.f965a.a(n32.b)).intValue()) {
            return true;
        }
        return false;
    }
}
