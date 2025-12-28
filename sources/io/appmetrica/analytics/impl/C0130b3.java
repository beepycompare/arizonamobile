package io.appmetrica.analytics.impl;

import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
/* renamed from: io.appmetrica.analytics.impl.b3  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public class C0130b3 implements InterfaceC0156c3 {

    /* renamed from: a  reason: collision with root package name */
    public final int f907a;

    public C0130b3(int i) {
        this.f907a = i;
    }

    public static InterfaceC0156c3 a(InterfaceC0156c3... interfaceC0156c3Arr) {
        return new C0130b3(b(interfaceC0156c3Arr));
    }

    public static int b(InterfaceC0156c3... interfaceC0156c3Arr) {
        int i = 0;
        for (InterfaceC0156c3 interfaceC0156c3 : interfaceC0156c3Arr) {
            if (interfaceC0156c3 != null) {
                i = interfaceC0156c3.getBytesTruncated() + i;
            }
        }
        return i;
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0156c3
    public final int getBytesTruncated() {
        return this.f907a;
    }

    public String toString() {
        return "BytesTruncatedInfo{bytesTruncated=" + this.f907a + AbstractJsonLexerKt.END_OBJ;
    }
}
