package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.data.Converter;
import io.appmetrica.analytics.protobuf.nano.MessageNano;
/* loaded from: classes4.dex */
public final class Gb implements Converter {

    /* renamed from: a  reason: collision with root package name */
    public final C0309hd f452a;

    public Gb() {
        this(new C0309hd(new On()));
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final byte[] fromModel(Nn nn) {
        return MessageNano.toByteArray((MessageNano) this.f452a.f883a.fromModel(nn));
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    public final Object toModel(Object obj) {
        byte[] bArr = (byte[]) obj;
        throw new UnsupportedOperationException();
    }

    public Gb(C0309hd c0309hd) {
        this.f452a = c0309hd;
    }

    public final Nn a(byte[] bArr) {
        throw new UnsupportedOperationException();
    }
}
