package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.data.Converter;
import io.appmetrica.analytics.protobuf.nano.MessageNano;
/* renamed from: io.appmetrica.analytics.impl.lb  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0399lb implements Converter {

    /* renamed from: a  reason: collision with root package name */
    public final Mc f1101a;

    public C0399lb() {
        this(new Mc(new Rn()));
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final byte[] fromModel(Qn qn) {
        return MessageNano.toByteArray((MessageNano) this.f1101a.f697a.fromModel(qn));
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    public final Object toModel(Object obj) {
        byte[] bArr = (byte[]) obj;
        throw new UnsupportedOperationException();
    }

    public C0399lb(Mc mc) {
        this.f1101a = mc;
    }

    public final Qn a(byte[] bArr) {
        throw new UnsupportedOperationException();
    }
}
