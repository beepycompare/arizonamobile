package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.data.Converter;
import io.appmetrica.analytics.protobuf.nano.MessageNano;
/* loaded from: classes5.dex */
public final class Nb implements Converter {

    /* renamed from: a  reason: collision with root package name */
    public final C0456nd f682a;

    public Nb() {
        this(new C0456nd(new C0648uo()));
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final byte[] fromModel(C0622to c0622to) {
        return MessageNano.toByteArray((MessageNano) this.f682a.f1114a.fromModel(c0622to));
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    public final Object toModel(Object obj) {
        byte[] bArr = (byte[]) obj;
        throw new UnsupportedOperationException();
    }

    public Nb(C0456nd c0456nd) {
        this.f682a = c0456nd;
    }

    public final C0622to a(byte[] bArr) {
        throw new UnsupportedOperationException();
    }
}
