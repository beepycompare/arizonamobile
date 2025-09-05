package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.data.Converter;
import io.appmetrica.analytics.protobuf.nano.MessageNano;
/* loaded from: classes4.dex */
public final class Lb implements Converter {

    /* renamed from: a  reason: collision with root package name */
    public final C0432md f553a;

    public Lb() {
        this(new C0432md(new Xn()));
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final byte[] fromModel(Wn wn) {
        return MessageNano.toByteArray((MessageNano) this.f553a.f988a.fromModel(wn));
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    public final Object toModel(Object obj) {
        byte[] bArr = (byte[]) obj;
        throw new UnsupportedOperationException();
    }

    public Lb(C0432md c0432md) {
        this.f553a = c0432md;
    }

    public final Wn a(byte[] bArr) {
        throw new UnsupportedOperationException();
    }
}
