package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.data.Converter;
import io.appmetrica.analytics.protobuf.nano.MessageNano;
/* loaded from: classes4.dex */
public final class Eb implements Converter {

    /* renamed from: a  reason: collision with root package name */
    public final C0257fd f407a;

    public Eb() {
        this(new C0257fd(new Ln()));
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final byte[] fromModel(Kn kn) {
        return MessageNano.toByteArray((MessageNano) this.f407a.f837a.fromModel(kn));
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    public final Object toModel(Object obj) {
        byte[] bArr = (byte[]) obj;
        throw new UnsupportedOperationException();
    }

    public Eb(C0257fd c0257fd) {
        this.f407a = c0257fd;
    }

    public final Kn a(byte[] bArr) {
        throw new UnsupportedOperationException();
    }
}
