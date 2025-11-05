package io.appmetrica.analytics.impl;

import kotlin.text.Charsets;
/* loaded from: classes3.dex */
public abstract class N9 {
    public static final H9 a(int i, String str) {
        byte[] bArr;
        H9 h9 = new H9();
        h9.f504a = i;
        if (str == null || (bArr = str.getBytes(Charsets.UTF_8)) == null) {
            bArr = h9.b;
        }
        h9.b = bArr;
        return h9;
    }
}
