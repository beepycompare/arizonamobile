package io.appmetrica.analytics.impl;
/* loaded from: classes4.dex */
public final class Na extends O2 {
    public Na(int i) {
        super(i);
    }

    @Override // io.appmetrica.analytics.impl.O2, io.appmetrica.analytics.impl.Oa
    public final Jn a(String str) {
        int i = 0;
        if (str != null) {
            int length = str.length();
            int i2 = this.f570a;
            if (length > i2) {
                String substring = str.substring(0, i2);
                i = str.getBytes().length - substring.getBytes().length;
                str = substring;
            }
        }
        return new Jn(str, new C0672w3(i));
    }
}
