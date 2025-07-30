package io.appmetrica.analytics.impl;
/* loaded from: classes4.dex */
public final class W3 extends AbstractC0378k8 {
    @Override // io.appmetrica.analytics.impl.AbstractC0378k8
    public final boolean a(N3 n3, N3 n32) {
        if (io.a(n32.f559a)) {
            return true;
        }
        if (io.a(n3.f559a)) {
            return false;
        }
        EnumC0403l8 enumC0403l8 = n3.b;
        if (enumC0403l8 == EnumC0403l8.c) {
            if (((Number) this.f924a.a(enumC0403l8)).intValue() >= ((Number) this.f924a.a(n32.b)).intValue()) {
                return true;
            }
        } else if (((Number) this.f924a.a(enumC0403l8)).intValue() > ((Number) this.f924a.a(n32.b)).intValue()) {
            return true;
        }
        return false;
    }
}
