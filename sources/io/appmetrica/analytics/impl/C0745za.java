package io.appmetrica.analytics.impl;
/* renamed from: io.appmetrica.analytics.impl.za  reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C0745za extends K2 {
    public C0745za(int i) {
        super(i);
    }

    @Override // io.appmetrica.analytics.impl.K2, io.appmetrica.analytics.impl.Aa
    public final On a(String str) {
        int i = 0;
        if (str != null) {
            int length = str.length();
            int i2 = this.f554a;
            if (length > i2) {
                String substring = str.substring(0, i2);
                i = str.getBytes().length - substring.getBytes().length;
                str = substring;
            }
        }
        return new On(str, new C0312i3(i));
    }
}
