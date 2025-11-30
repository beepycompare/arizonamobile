package io.appmetrica.analytics.impl;

import kotlin.text.Charsets;
/* loaded from: classes5.dex */
public abstract class H9 {
    public static final B9 a(int i, String str) {
        byte[] bArr;
        B9 b9 = new B9();
        b9.f408a = i;
        if (str == null || (bArr = str.getBytes(Charsets.UTF_8)) == null) {
            bArr = b9.b;
        }
        b9.b = bArr;
        return b9;
    }
}
