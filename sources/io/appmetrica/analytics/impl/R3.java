package io.appmetrica.analytics.impl;
/* loaded from: classes5.dex */
public final class R3 extends AbstractC0347j8 {
    @Override // io.appmetrica.analytics.impl.AbstractC0347j8
    public final boolean a(I3 i3, I3 i32) {
        if (Oo.a(i32.f587a)) {
            return true;
        }
        if (Oo.a(i3.f587a)) {
            return false;
        }
        EnumC0399l8 enumC0399l8 = i3.b;
        if (enumC0399l8 == EnumC0399l8.d) {
            if (((Number) this.f1048a.a(enumC0399l8)).intValue() >= ((Number) this.f1048a.a(i32.b)).intValue()) {
                return true;
            }
        } else if (((Number) this.f1048a.a(enumC0399l8)).intValue() > ((Number) this.f1048a.a(i32.b)).intValue()) {
            return true;
        }
        return false;
    }
}
