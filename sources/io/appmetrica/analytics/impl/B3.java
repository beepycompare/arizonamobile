package io.appmetrica.analytics.impl;
/* loaded from: classes5.dex */
public final class B3 extends S7 {
    @Override // io.appmetrica.analytics.impl.S7
    public final boolean a(C0563s3 c0563s3, C0563s3 c0563s32) {
        if (mo.a(c0563s32.f1111a)) {
            return true;
        }
        if (mo.a(c0563s3.f1111a)) {
            return false;
        }
        T7 t7 = c0563s3.b;
        if (t7 == T7.c) {
            if (((Number) this.f674a.a(t7)).intValue() >= ((Number) this.f674a.a(c0563s32.b)).intValue()) {
                return true;
            }
        } else if (((Number) this.f674a.a(t7)).intValue() > ((Number) this.f674a.a(c0563s32.b)).intValue()) {
            return true;
        }
        return false;
    }
}
