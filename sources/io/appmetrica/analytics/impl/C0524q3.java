package io.appmetrica.analytics.impl;

import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
/* renamed from: io.appmetrica.analytics.impl.q3  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public class C0524q3 implements InterfaceC0549r3 {

    /* renamed from: a  reason: collision with root package name */
    public final int f1157a;

    public C0524q3(int i) {
        this.f1157a = i;
    }

    public static InterfaceC0549r3 a(InterfaceC0549r3... interfaceC0549r3Arr) {
        return new C0524q3(b(interfaceC0549r3Arr));
    }

    public static int b(InterfaceC0549r3... interfaceC0549r3Arr) {
        int i = 0;
        for (InterfaceC0549r3 interfaceC0549r3 : interfaceC0549r3Arr) {
            if (interfaceC0549r3 != null) {
                i = interfaceC0549r3.getBytesTruncated() + i;
            }
        }
        return i;
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0549r3
    public final int getBytesTruncated() {
        return this.f1157a;
    }

    public String toString() {
        return "BytesTruncatedInfo{bytesTruncated=" + this.f1157a + AbstractJsonLexerKt.END_OBJ;
    }
}
