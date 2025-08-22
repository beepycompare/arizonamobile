package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.data.Converter;
import io.appmetrica.analytics.protobuf.nano.MessageNano;
/* loaded from: classes4.dex */
public final class Ib implements Converter {

    /* renamed from: a  reason: collision with root package name */
    public final C0354jd f495a;

    public Ib() {
        this(new C0354jd(new Tn()));
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final byte[] fromModel(Sn sn) {
        return MessageNano.toByteArray((MessageNano) this.f495a.f923a.fromModel(sn));
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    public final Object toModel(Object obj) {
        byte[] bArr = (byte[]) obj;
        throw new UnsupportedOperationException();
    }

    public Ib(C0354jd c0354jd) {
        this.f495a = c0354jd;
    }

    public final Sn a(byte[] bArr) {
        throw new UnsupportedOperationException();
    }
}
