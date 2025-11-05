package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.data.Converter;
import io.appmetrica.analytics.protobuf.nano.MessageNano;
/* renamed from: io.appmetrica.analytics.impl.sb  reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C0571sb implements Converter {

    /* renamed from: a  reason: collision with root package name */
    public final Tc f1111a;

    public C0571sb() {
        this(new Tc(new Tn()));
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final byte[] fromModel(Sn sn) {
        return MessageNano.toByteArray((MessageNano) this.f1111a.f704a.fromModel(sn));
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    public final Object toModel(Object obj) {
        byte[] bArr = (byte[]) obj;
        throw new UnsupportedOperationException();
    }

    public C0571sb(Tc tc) {
        this.f1111a = tc;
    }

    public final Sn a(byte[] bArr) {
        throw new UnsupportedOperationException();
    }
}
