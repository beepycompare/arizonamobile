package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.data.Converter;
import io.appmetrica.analytics.protobuf.nano.MessageNano;
/* loaded from: classes4.dex */
public final class Eb implements Converter {

    /* renamed from: a  reason: collision with root package name */
    public final C0265fd f406a;

    public Eb() {
        this(new C0265fd(new Ln()));
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final byte[] fromModel(Kn kn) {
        return MessageNano.toByteArray((MessageNano) this.f406a.f836a.fromModel(kn));
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    public final Object toModel(Object obj) {
        byte[] bArr = (byte[]) obj;
        throw new UnsupportedOperationException();
    }

    public Eb(C0265fd c0265fd) {
        this.f406a = c0265fd;
    }

    public final Kn a(byte[] bArr) {
        throw new UnsupportedOperationException();
    }
}
