package io.appmetrica.analytics.impl;
/* loaded from: classes5.dex */
public final class R3 extends AbstractC0340j8 {
    @Override // io.appmetrica.analytics.impl.AbstractC0340j8
    public final boolean a(I3 i3, I3 i32) {
        if (Oo.a(i32.f592a)) {
            return true;
        }
        if (Oo.a(i3.f592a)) {
            return false;
        }
        EnumC0392l8 enumC0392l8 = i3.b;
        if (enumC0392l8 == EnumC0392l8.d) {
            if (((Number) this.f1053a.a(enumC0392l8)).intValue() >= ((Number) this.f1053a.a(i32.b)).intValue()) {
                return true;
            }
        } else if (((Number) this.f1053a.a(enumC0392l8)).intValue() > ((Number) this.f1053a.a(i32.b)).intValue()) {
            return true;
        }
        return false;
    }
}
