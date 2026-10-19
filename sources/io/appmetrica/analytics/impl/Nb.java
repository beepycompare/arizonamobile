package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.data.Converter;
import io.appmetrica.analytics.protobuf.nano.MessageNano;
/* loaded from: classes5.dex */
public final class Nb implements Converter {

    /* renamed from: a  reason: collision with root package name */
    public final C0449nd f687a;

    public Nb() {
        this(new C0449nd(new C0641uo()));
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final byte[] fromModel(C0615to c0615to) {
        return MessageNano.toByteArray((MessageNano) this.f687a.f1119a.fromModel(c0615to));
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    public final Object toModel(Object obj) {
        byte[] bArr = (byte[]) obj;
        throw new UnsupportedOperationException();
    }

    public Nb(C0449nd c0449nd) {
        this.f687a = c0449nd;
    }

    public final C0615to a(byte[] bArr) {
        throw new UnsupportedOperationException();
    }
}
