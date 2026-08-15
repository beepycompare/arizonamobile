package io.appmetrica.analytics.impl;

import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
/* renamed from: io.appmetrica.analytics.impl.q3  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public class C0523q3 implements InterfaceC0548r3 {

    /* renamed from: a  reason: collision with root package name */
    public final int f1160a;

    public C0523q3(int i) {
        this.f1160a = i;
    }

    public static InterfaceC0548r3 a(InterfaceC0548r3... interfaceC0548r3Arr) {
        return new C0523q3(b(interfaceC0548r3Arr));
    }

    public static int b(InterfaceC0548r3... interfaceC0548r3Arr) {
        int i = 0;
        for (InterfaceC0548r3 interfaceC0548r3 : interfaceC0548r3Arr) {
            if (interfaceC0548r3 != null) {
                i = interfaceC0548r3.getBytesTruncated() + i;
            }
        }
        return i;
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0548r3
    public final int getBytesTruncated() {
        return this.f1160a;
    }

    public String toString() {
        return "BytesTruncatedInfo{bytesTruncated=" + this.f1160a + AbstractJsonLexerKt.END_OBJ;
    }
}
