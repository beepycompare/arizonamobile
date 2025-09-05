package io.appmetrica.analytics.impl;

import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
/* renamed from: io.appmetrica.analytics.impl.z3  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public class C0749z3 implements A3 {

    /* renamed from: a  reason: collision with root package name */
    public final int f1177a;

    public C0749z3(int i) {
        this.f1177a = i;
    }

    public static A3 a(A3... a3Arr) {
        return new C0749z3(b(a3Arr));
    }

    public static int b(A3... a3Arr) {
        int i = 0;
        for (A3 a3 : a3Arr) {
            if (a3 != null) {
                i = a3.getBytesTruncated() + i;
            }
        }
        return i;
    }

    @Override // io.appmetrica.analytics.impl.A3
    public final int getBytesTruncated() {
        return this.f1177a;
    }

    public String toString() {
        return "BytesTruncatedInfo{bytesTruncated=" + this.f1177a + AbstractJsonLexerKt.END_OBJ;
    }
}
