package io.appmetrica.analytics.impl;

import kotlin.text.Charsets;
/* renamed from: io.appmetrica.analytics.impl.ga  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public abstract class AbstractC0274ga {
    public static final C0119aa a(int i, String str) {
        byte[] bArr;
        C0119aa c0119aa = new C0119aa();
        c0119aa.f790a = i;
        if (str == null || (bArr = str.getBytes(Charsets.UTF_8)) == null) {
            bArr = c0119aa.b;
        }
        c0119aa.b = bArr;
        return c0119aa;
    }
}
