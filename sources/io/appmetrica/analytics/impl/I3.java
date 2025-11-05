package io.appmetrica.analytics.impl;
/* loaded from: classes3.dex */
public final class I3 extends X7 {
    @Override // io.appmetrica.analytics.impl.X7
    public final boolean a(C0738z3 c0738z3, C0738z3 c0738z32) {
        if (no.a(c0738z32.f1224a)) {
            return true;
        }
        if (no.a(c0738z3.f1224a)) {
            return false;
        }
        Y7 y7 = c0738z3.b;
        if (y7 == Y7.c) {
            if (((Number) this.f753a.a(y7)).intValue() >= ((Number) this.f753a.a(c0738z32.b)).intValue()) {
                return true;
            }
        } else if (((Number) this.f753a.a(y7)).intValue() > ((Number) this.f753a.a(c0738z32.b)).intValue()) {
            return true;
        }
        return false;
    }
}
