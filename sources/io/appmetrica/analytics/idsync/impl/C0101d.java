package io.appmetrica.analytics.idsync.impl;

import io.appmetrica.analytics.coreapi.internal.data.Converter;
import io.appmetrica.analytics.idsync.internal.model.IdSyncConfig;
import io.appmetrica.analytics.protobuf.nano.MessageNano;
/* renamed from: io.appmetrica.analytics.idsync.impl.d  reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C0101d implements Converter {

    /* renamed from: a  reason: collision with root package name */
    public final C0102e f466a;

    public C0101d(C0102e c0102e) {
        this.f466a = c0102e;
    }

    public final byte[] a(IdSyncConfig idSyncConfig) {
        return MessageNano.toByteArray(this.f466a.fromModel(idSyncConfig));
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    public final Object fromModel(Object obj) {
        return MessageNano.toByteArray(this.f466a.fromModel((IdSyncConfig) obj));
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final IdSyncConfig toModel(byte[] bArr) {
        return this.f466a.toModel((m) MessageNano.mergeFrom(new m(), bArr));
    }
}
