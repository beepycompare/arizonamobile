package io.appmetrica.analytics.impl;
/* renamed from: io.appmetrica.analytics.impl.sa  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0573sa extends C2 {
    public C0573sa(int i) {
        super(i);
    }

    @Override // io.appmetrica.analytics.impl.C2, io.appmetrica.analytics.impl.InterfaceC0598ta
    public final Mn a(String str) {
        int i = 0;
        if (str != null) {
            int length = str.length();
            int i2 = this.f528a;
            if (length > i2) {
                String substring = str.substring(0, i2);
                i = str.getBytes().length - substring.getBytes().length;
                str = substring;
            }
        }
        return new Mn(str, new C0109a3(i));
    }
}
