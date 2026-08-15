package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.data.Converter;
import io.appmetrica.analytics.protobuf.nano.MessageNano;
/* loaded from: classes5.dex */
public final class Nb implements Converter {

    /* renamed from: a  reason: collision with root package name */
    public final C0455nd f684a;

    public Nb() {
        this(new C0455nd(new C0647uo()));
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final byte[] fromModel(C0621to c0621to) {
        return MessageNano.toByteArray((MessageNano) this.f684a.f1116a.fromModel(c0621to));
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    public final Object toModel(Object obj) {
        byte[] bArr = (byte[]) obj;
        throw new UnsupportedOperationException();
    }

    public Nb(C0455nd c0455nd) {
        this.f684a = c0455nd;
    }

    public final C0621to a(byte[] bArr) {
        throw new UnsupportedOperationException();
    }
}
