package io.appmetrica.analytics.idsync.impl;

import io.appmetrica.analytics.coreapi.internal.data.Converter;
import io.appmetrica.analytics.idsync.internal.model.IdSyncConfig;
import io.appmetrica.analytics.protobuf.nano.MessageNano;
/* renamed from: io.appmetrica.analytics.idsync.impl.d  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0102d implements Converter {

    /* renamed from: a  reason: collision with root package name */
    public final C0103e f421a;

    public C0102d(C0103e c0103e) {
        this.f421a = c0103e;
    }

    public final byte[] a(IdSyncConfig idSyncConfig) {
        return MessageNano.toByteArray(this.f421a.fromModel(idSyncConfig));
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    public final Object fromModel(Object obj) {
        return MessageNano.toByteArray(this.f421a.fromModel((IdSyncConfig) obj));
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final IdSyncConfig toModel(byte[] bArr) {
        return this.f421a.toModel((m) MessageNano.mergeFrom(new m(), bArr));
    }
}
