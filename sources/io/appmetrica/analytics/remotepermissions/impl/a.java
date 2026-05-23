package io.appmetrica.analytics.remotepermissions.impl;

import io.appmetrica.analytics.coreapi.internal.data.Converter;
import io.appmetrica.analytics.protobuf.nano.MessageNano;
import io.appmetrica.analytics.remotepermissions.internal.config.FeatureConfig;
/* loaded from: classes5.dex */
public final class a implements Converter {

    /* renamed from: a  reason: collision with root package name */
    public final b f1421a = new b();

    public final byte[] a(FeatureConfig featureConfig) {
        return MessageNano.toByteArray(this.f1421a.fromModel(featureConfig));
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    public final Object fromModel(Object obj) {
        return MessageNano.toByteArray(this.f1421a.fromModel((FeatureConfig) obj));
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final FeatureConfig toModel(byte[] bArr) {
        return this.f1421a.toModel((e) MessageNano.mergeFrom(new e(), bArr));
    }
}
