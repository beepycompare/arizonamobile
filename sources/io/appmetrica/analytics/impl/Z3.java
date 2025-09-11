package io.appmetrica.analytics.impl;
/* loaded from: classes4.dex */
public final class Z3 extends AbstractC0505p8 {
    @Override // io.appmetrica.analytics.impl.AbstractC0505p8
    public final boolean a(Q3 q3, Q3 q32) {
        if (ro.a(q32.f634a)) {
            return true;
        }
        if (ro.a(q3.f634a)) {
            return false;
        }
        EnumC0530q8 enumC0530q8 = q3.b;
        if (enumC0530q8 == EnumC0530q8.c) {
            if (((Number) this.f1032a.a(enumC0530q8)).intValue() >= ((Number) this.f1032a.a(q32.b)).intValue()) {
                return true;
            }
        } else if (((Number) this.f1032a.a(enumC0530q8)).intValue() > ((Number) this.f1032a.a(q32.b)).intValue()) {
            return true;
        }
        return false;
    }
}
