package io.appmetrica.analytics.impl;
/* loaded from: classes4.dex */
public final class W3 extends AbstractC0302h8 {
    @Override // io.appmetrica.analytics.impl.AbstractC0302h8
    public final boolean a(N3 n3, N3 n32) {
        if (fo.a(n32.f548a)) {
            return true;
        }
        if (fo.a(n3.f548a)) {
            return false;
        }
        EnumC0327i8 enumC0327i8 = n3.b;
        if (enumC0327i8 == EnumC0327i8.c) {
            if (((Number) this.f865a.a(enumC0327i8)).intValue() >= ((Number) this.f865a.a(n32.b)).intValue()) {
                return true;
            }
        } else if (((Number) this.f865a.a(enumC0327i8)).intValue() > ((Number) this.f865a.a(n32.b)).intValue()) {
            return true;
        }
        return false;
    }
}
