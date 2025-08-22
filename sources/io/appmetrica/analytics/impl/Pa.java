package io.appmetrica.analytics.impl;
/* loaded from: classes4.dex */
public final class Pa extends O2 {
    public Pa(int i) {
        super(i);
    }

    @Override // io.appmetrica.analytics.impl.O2, io.appmetrica.analytics.impl.Qa
    public final On a(String str) {
        int i = 0;
        if (str != null) {
            int length = str.length();
            int i2 = this.f584a;
            if (length > i2) {
                String substring = str.substring(0, i2);
                i = str.getBytes().length - substring.getBytes().length;
                str = substring;
            }
        }
        return new On(str, new C0670w3(i));
    }
}
