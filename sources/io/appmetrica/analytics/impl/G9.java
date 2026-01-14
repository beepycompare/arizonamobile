package io.appmetrica.analytics.impl;

import kotlin.text.Charsets;
/* loaded from: classes5.dex */
public abstract class G9 {
    public static final A9 a(int i, String str) {
        byte[] bArr;
        A9 a9 = new A9();
        a9.f497a = i;
        if (str == null || (bArr = str.getBytes(Charsets.UTF_8)) == null) {
            bArr = a9.b;
        }
        a9.b = bArr;
        return a9;
    }
}
