package io.appmetrica.analytics.impl;
/* loaded from: classes4.dex */
public final class La extends O2 {
    public La(int i) {
        super(i);
    }

    @Override // io.appmetrica.analytics.impl.O2, io.appmetrica.analytics.impl.Ma
    public final Gn a(String str) {
        int i = 0;
        if (str != null) {
            int length = str.length();
            int i2 = this.f561a;
            if (length > i2) {
                String substring = str.substring(0, i2);
                i = str.getBytes().length - substring.getBytes().length;
                str = substring;
            }
        }
        return new Gn(str, new C0678w3(i));
    }
}
