package io.appmetrica.analytics.impl;

import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
/* renamed from: io.appmetrica.analytics.impl.a3  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public class C0109a3 implements InterfaceC0135b3 {

    /* renamed from: a  reason: collision with root package name */
    public final int f896a;

    public C0109a3(int i) {
        this.f896a = i;
    }

    public static InterfaceC0135b3 a(InterfaceC0135b3... interfaceC0135b3Arr) {
        return new C0109a3(b(interfaceC0135b3Arr));
    }

    public static int b(InterfaceC0135b3... interfaceC0135b3Arr) {
        int i = 0;
        for (InterfaceC0135b3 interfaceC0135b3 : interfaceC0135b3Arr) {
            if (interfaceC0135b3 != null) {
                i = interfaceC0135b3.getBytesTruncated() + i;
            }
        }
        return i;
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0135b3
    public final int getBytesTruncated() {
        return this.f896a;
    }

    public String toString() {
        return "BytesTruncatedInfo{bytesTruncated=" + this.f896a + AbstractJsonLexerKt.END_OBJ;
    }
}
