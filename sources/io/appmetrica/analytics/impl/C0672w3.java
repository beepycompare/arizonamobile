package io.appmetrica.analytics.impl;

import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
/* renamed from: io.appmetrica.analytics.impl.w3  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public class C0672w3 implements InterfaceC0697x3 {

    /* renamed from: a  reason: collision with root package name */
    public final int f1112a;

    public C0672w3(int i) {
        this.f1112a = i;
    }

    public static InterfaceC0697x3 a(InterfaceC0697x3... interfaceC0697x3Arr) {
        return new C0672w3(b(interfaceC0697x3Arr));
    }

    public static int b(InterfaceC0697x3... interfaceC0697x3Arr) {
        int i = 0;
        for (InterfaceC0697x3 interfaceC0697x3 : interfaceC0697x3Arr) {
            if (interfaceC0697x3 != null) {
                i = interfaceC0697x3.getBytesTruncated() + i;
            }
        }
        return i;
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0697x3
    public final int getBytesTruncated() {
        return this.f1112a;
    }

    public String toString() {
        return "BytesTruncatedInfo{bytesTruncated=" + this.f1112a + AbstractJsonLexerKt.END_OBJ;
    }
}
