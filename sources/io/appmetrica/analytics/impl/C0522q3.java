package io.appmetrica.analytics.impl;

import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
/* renamed from: io.appmetrica.analytics.impl.q3  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public class C0522q3 implements InterfaceC0547r3 {

    /* renamed from: a  reason: collision with root package name */
    public final int f1160a;

    public C0522q3(int i) {
        this.f1160a = i;
    }

    public static InterfaceC0547r3 a(InterfaceC0547r3... interfaceC0547r3Arr) {
        return new C0522q3(b(interfaceC0547r3Arr));
    }

    public static int b(InterfaceC0547r3... interfaceC0547r3Arr) {
        int i = 0;
        for (InterfaceC0547r3 interfaceC0547r3 : interfaceC0547r3Arr) {
            if (interfaceC0547r3 != null) {
                i = interfaceC0547r3.getBytesTruncated() + i;
            }
        }
        return i;
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0547r3
    public final int getBytesTruncated() {
        return this.f1160a;
    }

    public String toString() {
        return "BytesTruncatedInfo{bytesTruncated=" + this.f1160a + AbstractJsonLexerKt.END_OBJ;
    }
}
