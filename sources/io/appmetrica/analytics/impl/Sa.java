package io.appmetrica.analytics.impl;
/* loaded from: classes4.dex */
public final class Sa extends R2 {
    public Sa(int i) {
        super(i);
    }

    @Override // io.appmetrica.analytics.impl.R2, io.appmetrica.analytics.impl.Ta
    public final Sn a(String str) {
        int i = 0;
        if (str != null) {
            int length = str.length();
            int i2 = this.f649a;
            if (length > i2) {
                String substring = str.substring(0, i2);
                i = str.getBytes().length - substring.getBytes().length;
                str = substring;
            }
        }
        return new Sn(str, new C0749z3(i));
    }
}
