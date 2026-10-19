package io.appmetrica.analytics.adrevenue.other.impl;

import io.appmetrica.analytics.coreapi.internal.data.Converter;
import io.appmetrica.analytics.protobuf.nano.MessageNano;
import kotlin.jvm.internal.DefaultConstructorMarker;
/* loaded from: classes5.dex */
public final class k implements Converter {

    /* renamed from: a  reason: collision with root package name */
    public final b f247a;

    public k() {
        this(null, 1, null);
    }

    public final byte[] a(j jVar) {
        return MessageNano.toByteArray(this.f247a.fromModel(jVar));
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    public final Object fromModel(Object obj) {
        return MessageNano.toByteArray(this.f247a.fromModel((j) obj));
    }

    public k(b bVar) {
        this.f247a = bVar;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final j toModel(byte[] bArr) {
        c cVar;
        try {
            cVar = (c) MessageNano.mergeFrom(new c(), bArr);
        } catch (Throwable unused) {
            cVar = new c();
        }
        this.f247a.getClass();
        return new j(cVar.f241a, cVar.b);
    }

    public /* synthetic */ k(b bVar, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? new b() : bVar);
    }
}
