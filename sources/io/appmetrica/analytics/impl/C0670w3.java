package io.appmetrica.analytics.impl;

import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
/* renamed from: io.appmetrica.analytics.impl.w3  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public class C0670w3 implements InterfaceC0695x3 {

    /* renamed from: a  reason: collision with root package name */
    public final int f1098a;

    public C0670w3(int i) {
        this.f1098a = i;
    }

    public static InterfaceC0695x3 a(InterfaceC0695x3... interfaceC0695x3Arr) {
        return new C0670w3(b(interfaceC0695x3Arr));
    }

    public static int b(InterfaceC0695x3... interfaceC0695x3Arr) {
        int i = 0;
        for (InterfaceC0695x3 interfaceC0695x3 : interfaceC0695x3Arr) {
            if (interfaceC0695x3 != null) {
                i = interfaceC0695x3.getBytesTruncated() + i;
            }
        }
        return i;
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0695x3
    public final int getBytesTruncated() {
        return this.f1098a;
    }

    public String toString() {
        return "BytesTruncatedInfo{bytesTruncated=" + this.f1098a + AbstractJsonLexerKt.END_OBJ;
    }
}
