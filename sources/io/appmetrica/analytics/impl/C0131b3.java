package io.appmetrica.analytics.impl;

import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
/* renamed from: io.appmetrica.analytics.impl.b3  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public class C0131b3 implements InterfaceC0157c3 {

    /* renamed from: a  reason: collision with root package name */
    public final int f809a;

    public C0131b3(int i) {
        this.f809a = i;
    }

    public static InterfaceC0157c3 a(InterfaceC0157c3... interfaceC0157c3Arr) {
        return new C0131b3(b(interfaceC0157c3Arr));
    }

    public static int b(InterfaceC0157c3... interfaceC0157c3Arr) {
        int i = 0;
        for (InterfaceC0157c3 interfaceC0157c3 : interfaceC0157c3Arr) {
            if (interfaceC0157c3 != null) {
                i = interfaceC0157c3.getBytesTruncated() + i;
            }
        }
        return i;
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0157c3
    public final int getBytesTruncated() {
        return this.f809a;
    }

    public String toString() {
        return "BytesTruncatedInfo{bytesTruncated=" + this.f809a + AbstractJsonLexerKt.END_OBJ;
    }
}
