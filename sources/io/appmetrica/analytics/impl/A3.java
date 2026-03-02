package io.appmetrica.analytics.impl;
/* loaded from: classes5.dex */
public final class A3 extends R7 {
    @Override // io.appmetrica.analytics.impl.R7
    public final boolean a(C0540r3 c0540r3, C0540r3 c0540r32) {
        if (lo.a(c0540r32.f1199a)) {
            return true;
        }
        if (lo.a(c0540r3.f1199a)) {
            return false;
        }
        S7 s7 = c0540r3.b;
        if (s7 == S7.c) {
            if (((Number) this.f762a.a(s7)).intValue() >= ((Number) this.f762a.a(c0540r32.b)).intValue()) {
                return true;
            }
        } else if (((Number) this.f762a.a(s7)).intValue() > ((Number) this.f762a.a(c0540r32.b)).intValue()) {
            return true;
        }
        return false;
    }
}
