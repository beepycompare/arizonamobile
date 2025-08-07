package io.appmetrica.analytics.impl;

import kotlin.text.Charsets;
/* renamed from: io.appmetrica.analytics.impl.ba  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public abstract class AbstractC0153ba {
    public static final V9 a(int i, String str) {
        byte[] bArr;
        V9 v9 = new V9();
        v9.f683a = i;
        if (str == null || (bArr = str.getBytes(Charsets.UTF_8)) == null) {
            bArr = v9.b;
        }
        v9.b = bArr;
        return v9;
    }
}
