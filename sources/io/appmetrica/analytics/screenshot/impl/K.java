package io.appmetrica.analytics.screenshot.impl;

import io.appmetrica.analytics.coreapi.internal.data.Converter;
import io.appmetrica.analytics.protobuf.nano.MessageNano;
import kotlin.jvm.internal.DefaultConstructorMarker;
/* loaded from: classes5.dex */
public final class K implements Converter {

    /* renamed from: a  reason: collision with root package name */
    public final M f1449a;

    public K() {
        this(null, 1, null);
    }

    public final byte[] a(J j) {
        return MessageNano.toByteArray(this.f1449a.fromModel(j));
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    public final Object fromModel(Object obj) {
        return MessageNano.toByteArray(this.f1449a.fromModel((J) obj));
    }

    public K(M m) {
        this.f1449a = m;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final J toModel(byte[] bArr) {
        S s;
        try {
            s = (S) MessageNano.mergeFrom(new S(), bArr);
        } catch (Throwable unused) {
            s = new S();
        }
        return this.f1449a.toModel(s);
    }

    public /* synthetic */ K(M m, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? new M(null, 1, null) : m);
    }
}
