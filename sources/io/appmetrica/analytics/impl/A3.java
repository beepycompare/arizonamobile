package io.appmetrica.analytics.impl;
/* loaded from: classes5.dex */
public final class A3 extends R7 {
    @Override // io.appmetrica.analytics.impl.R7
    public final boolean a(C0541r3 c0541r3, C0541r3 c0541r32) {
        if (lo.a(c0541r32.f1200a)) {
            return true;
        }
        if (lo.a(c0541r3.f1200a)) {
            return false;
        }
        S7 s7 = c0541r3.b;
        if (s7 == S7.c) {
            if (((Number) this.f763a.a(s7)).intValue() >= ((Number) this.f763a.a(c0541r32.b)).intValue()) {
                return true;
            }
        } else if (((Number) this.f763a.a(s7)).intValue() > ((Number) this.f763a.a(c0541r32.b)).intValue()) {
            return true;
        }
        return false;
    }
}
