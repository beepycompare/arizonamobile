package io.appmetrica.analytics.impl;
/* loaded from: classes4.dex */
public final class Z3 extends AbstractC0506p8 {
    @Override // io.appmetrica.analytics.impl.AbstractC0506p8
    public final boolean a(Q3 q3, Q3 q32) {
        if (ro.a(q32.f635a)) {
            return true;
        }
        if (ro.a(q3.f635a)) {
            return false;
        }
        EnumC0531q8 enumC0531q8 = q3.b;
        if (enumC0531q8 == EnumC0531q8.c) {
            if (((Number) this.f1033a.a(enumC0531q8)).intValue() >= ((Number) this.f1033a.a(q32.b)).intValue()) {
                return true;
            }
        } else if (((Number) this.f1033a.a(enumC0531q8)).intValue() > ((Number) this.f1033a.a(q32.b)).intValue()) {
            return true;
        }
        return false;
    }
}
