package io.appmetrica.analytics.impl;
/* loaded from: classes5.dex */
public final class R3 extends AbstractC0346j8 {
    @Override // io.appmetrica.analytics.impl.AbstractC0346j8
    public final boolean a(I3 i3, I3 i32) {
        if (Oo.a(i32.f589a)) {
            return true;
        }
        if (Oo.a(i3.f589a)) {
            return false;
        }
        EnumC0398l8 enumC0398l8 = i3.b;
        if (enumC0398l8 == EnumC0398l8.d) {
            if (((Number) this.f1050a.a(enumC0398l8)).intValue() >= ((Number) this.f1050a.a(i32.b)).intValue()) {
                return true;
            }
        } else if (((Number) this.f1050a.a(enumC0398l8)).intValue() > ((Number) this.f1050a.a(i32.b)).intValue()) {
            return true;
        }
        return false;
    }
}
