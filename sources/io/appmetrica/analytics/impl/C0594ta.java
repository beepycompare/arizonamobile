package io.appmetrica.analytics.impl;
/* renamed from: io.appmetrica.analytics.impl.ta  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0594ta extends D2 {
    public C0594ta(int i) {
        super(i);
    }

    @Override // io.appmetrica.analytics.impl.D2, io.appmetrica.analytics.impl.InterfaceC0619ua
    public final Nn a(String str) {
        int i = 0;
        if (str != null) {
            int length = str.length();
            int i2 = this.f537a;
            if (length > i2) {
                String substring = str.substring(0, i2);
                i = str.getBytes().length - substring.getBytes().length;
                str = substring;
            }
        }
        return new Nn(str, new C0130b3(i));
    }
}
