package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.data.Converter;
import io.appmetrica.analytics.protobuf.nano.MessageNano;
/* renamed from: io.appmetrica.analytics.impl.mb  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0421mb implements Converter {

    /* renamed from: a  reason: collision with root package name */
    public final Nc f1107a;

    public C0421mb() {
        this(new Nc(new Sn()));
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final byte[] fromModel(Rn rn) {
        return MessageNano.toByteArray((MessageNano) this.f1107a.f702a.fromModel(rn));
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    public final Object toModel(Object obj) {
        byte[] bArr = (byte[]) obj;
        throw new UnsupportedOperationException();
    }

    public C0421mb(Nc nc) {
        this.f1107a = nc;
    }

    public final Rn a(byte[] bArr) {
        throw new UnsupportedOperationException();
    }
}
