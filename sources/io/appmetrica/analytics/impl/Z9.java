package io.appmetrica.analytics.impl;

import kotlin.text.Charsets;
/* loaded from: classes4.dex */
public abstract class Z9 {
    public static final T9 a(int i, String str) {
        byte[] bArr;
        T9 t9 = new T9();
        t9.f639a = i;
        if (str == null || (bArr = str.getBytes(Charsets.UTF_8)) == null) {
            bArr = t9.b;
        }
        t9.b = bArr;
        return t9;
    }
}
