package io.appmetrica.analytics.impl;

import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
/* renamed from: io.appmetrica.analytics.impl.w3  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public class C0673w3 implements InterfaceC0698x3 {

    /* renamed from: a  reason: collision with root package name */
    public final int f1111a;

    public C0673w3(int i) {
        this.f1111a = i;
    }

    public static InterfaceC0698x3 a(InterfaceC0698x3... interfaceC0698x3Arr) {
        return new C0673w3(b(interfaceC0698x3Arr));
    }

    public static int b(InterfaceC0698x3... interfaceC0698x3Arr) {
        int i = 0;
        for (InterfaceC0698x3 interfaceC0698x3 : interfaceC0698x3Arr) {
            if (interfaceC0698x3 != null) {
                i = interfaceC0698x3.getBytesTruncated() + i;
            }
        }
        return i;
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0698x3
    public final int getBytesTruncated() {
        return this.f1111a;
    }

    public String toString() {
        return "BytesTruncatedInfo{bytesTruncated=" + this.f1111a + AbstractJsonLexerKt.END_OBJ;
    }
}
