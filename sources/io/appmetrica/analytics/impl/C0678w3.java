package io.appmetrica.analytics.impl;

import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
/* renamed from: io.appmetrica.analytics.impl.w3  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public class C0678w3 implements InterfaceC0703x3 {

    /* renamed from: a  reason: collision with root package name */
    public final int f1097a;

    public C0678w3(int i) {
        this.f1097a = i;
    }

    public static InterfaceC0703x3 a(InterfaceC0703x3... interfaceC0703x3Arr) {
        return new C0678w3(b(interfaceC0703x3Arr));
    }

    public static int b(InterfaceC0703x3... interfaceC0703x3Arr) {
        int i = 0;
        for (InterfaceC0703x3 interfaceC0703x3 : interfaceC0703x3Arr) {
            if (interfaceC0703x3 != null) {
                i = interfaceC0703x3.getBytesTruncated() + i;
            }
        }
        return i;
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0703x3
    public final int getBytesTruncated() {
        return this.f1097a;
    }

    public String toString() {
        return "BytesTruncatedInfo{bytesTruncated=" + this.f1097a + AbstractJsonLexerKt.END_OBJ;
    }
}
