package io.appmetrica.analytics.impl;

import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
/* renamed from: io.appmetrica.analytics.impl.a3  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public class C0108a3 implements InterfaceC0134b3 {

    /* renamed from: a  reason: collision with root package name */
    public final int f901a;

    public C0108a3(int i) {
        this.f901a = i;
    }

    public static InterfaceC0134b3 a(InterfaceC0134b3... interfaceC0134b3Arr) {
        return new C0108a3(b(interfaceC0134b3Arr));
    }

    public static int b(InterfaceC0134b3... interfaceC0134b3Arr) {
        int i = 0;
        for (InterfaceC0134b3 interfaceC0134b3 : interfaceC0134b3Arr) {
            if (interfaceC0134b3 != null) {
                i = interfaceC0134b3.getBytesTruncated() + i;
            }
        }
        return i;
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0134b3
    public final int getBytesTruncated() {
        return this.f901a;
    }

    public String toString() {
        return "BytesTruncatedInfo{bytesTruncated=" + this.f901a + AbstractJsonLexerKt.END_OBJ;
    }
}
