package io.appmetrica.analytics.impl;

import kotlin.text.Charsets;
/* renamed from: io.appmetrica.analytics.impl.ga  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public abstract class AbstractC0275ga {
    public static final C0120aa a(int i, String str) {
        byte[] bArr;
        C0120aa c0120aa = new C0120aa();
        c0120aa.f791a = i;
        if (str == null || (bArr = str.getBytes(Charsets.UTF_8)) == null) {
            bArr = c0120aa.b;
        }
        c0120aa.b = bArr;
        return c0120aa;
    }
}
