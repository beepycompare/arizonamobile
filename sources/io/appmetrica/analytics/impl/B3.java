package io.appmetrica.analytics.impl;
/* loaded from: classes5.dex */
public final class B3 extends S7 {
    @Override // io.appmetrica.analytics.impl.S7
    public final boolean a(C0562s3 c0562s3, C0562s3 c0562s32) {
        if (mo.a(c0562s32.f1194a)) {
            return true;
        }
        if (mo.a(c0562s3.f1194a)) {
            return false;
        }
        T7 t7 = c0562s3.b;
        if (t7 == T7.c) {
            if (((Number) this.f757a.a(t7)).intValue() >= ((Number) this.f757a.a(c0562s32.b)).intValue()) {
                return true;
            }
        } else if (((Number) this.f757a.a(t7)).intValue() > ((Number) this.f757a.a(c0562s32.b)).intValue()) {
            return true;
        }
        return false;
    }
}
