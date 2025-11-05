package io.appmetrica.analytics.impl;

import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
/* renamed from: io.appmetrica.analytics.impl.i3  reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public class C0312i3 implements InterfaceC0337j3 {

    /* renamed from: a  reason: collision with root package name */
    public final int f923a;

    public C0312i3(int i) {
        this.f923a = i;
    }

    public static InterfaceC0337j3 a(InterfaceC0337j3... interfaceC0337j3Arr) {
        return new C0312i3(b(interfaceC0337j3Arr));
    }

    public static int b(InterfaceC0337j3... interfaceC0337j3Arr) {
        int i = 0;
        for (InterfaceC0337j3 interfaceC0337j3 : interfaceC0337j3Arr) {
            if (interfaceC0337j3 != null) {
                i = interfaceC0337j3.getBytesTruncated() + i;
            }
        }
        return i;
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0337j3
    public final int getBytesTruncated() {
        return this.f923a;
    }

    public String toString() {
        return "BytesTruncatedInfo{bytesTruncated=" + this.f923a + AbstractJsonLexerKt.END_OBJ;
    }
}
