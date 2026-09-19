package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.data.Converter;
import io.appmetrica.analytics.protobuf.nano.MessageNano;
/* loaded from: classes5.dex */
public final class Nb implements Converter {

    /* renamed from: a  reason: collision with root package name */
    public final C0454nd f684a;

    public Nb() {
        this(new C0454nd(new C0646uo()));
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final byte[] fromModel(C0620to c0620to) {
        return MessageNano.toByteArray((MessageNano) this.f684a.f1116a.fromModel(c0620to));
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    public final Object toModel(Object obj) {
        byte[] bArr = (byte[]) obj;
        throw new UnsupportedOperationException();
    }

    public Nb(C0454nd c0454nd) {
        this.f684a = c0454nd;
    }

    public final C0620to a(byte[] bArr) {
        throw new UnsupportedOperationException();
    }
}
