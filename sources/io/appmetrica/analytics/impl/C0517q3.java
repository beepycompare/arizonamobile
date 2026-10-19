package io.appmetrica.analytics.impl;

import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
/* renamed from: io.appmetrica.analytics.impl.q3  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public class C0517q3 implements InterfaceC0542r3 {

    /* renamed from: a  reason: collision with root package name */
    public final int f1163a;

    public C0517q3(int i) {
        this.f1163a = i;
    }

    public static InterfaceC0542r3 a(InterfaceC0542r3... interfaceC0542r3Arr) {
        return new C0517q3(b(interfaceC0542r3Arr));
    }

    public static int b(InterfaceC0542r3... interfaceC0542r3Arr) {
        int i = 0;
        for (InterfaceC0542r3 interfaceC0542r3 : interfaceC0542r3Arr) {
            if (interfaceC0542r3 != null) {
                i = interfaceC0542r3.getBytesTruncated() + i;
            }
        }
        return i;
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0542r3
    public final int getBytesTruncated() {
        return this.f1163a;
    }

    public String toString() {
        return "BytesTruncatedInfo{bytesTruncated=" + this.f1163a + AbstractJsonLexerKt.END_OBJ;
    }
}
