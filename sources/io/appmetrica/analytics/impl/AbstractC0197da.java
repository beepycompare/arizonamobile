package io.appmetrica.analytics.impl;

import kotlin.text.Charsets;
/* renamed from: io.appmetrica.analytics.impl.da  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public abstract class AbstractC0197da {
    public static final X9 a(int i, String str) {
        byte[] bArr;
        X9 x9 = new X9();
        x9.f724a = i;
        if (str == null || (bArr = str.getBytes(Charsets.UTF_8)) == null) {
            bArr = x9.b;
        }
        x9.b = bArr;
        return x9;
    }
}
