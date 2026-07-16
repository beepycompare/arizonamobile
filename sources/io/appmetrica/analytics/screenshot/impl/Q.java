package io.appmetrica.analytics.screenshot.impl;

import io.appmetrica.analytics.coreapi.internal.data.Converter;
import io.appmetrica.analytics.protobuf.nano.MessageNano;
import kotlin.jvm.internal.DefaultConstructorMarker;
/* loaded from: classes5.dex */
public final class Q implements Converter {

    /* renamed from: a  reason: collision with root package name */
    public final F f1444a;

    public Q() {
        this(null, 1, null);
    }

    public final byte[] a(P p) {
        return MessageNano.toByteArray(this.f1444a.fromModel(p));
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    public final Object fromModel(Object obj) {
        return MessageNano.toByteArray(this.f1444a.fromModel((P) obj));
    }

    public Q(F f) {
        this.f1444a = f;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final P toModel(byte[] bArr) {
        A a2;
        try {
            a2 = (A) MessageNano.mergeFrom(new A(), bArr);
        } catch (Throwable unused) {
            a2 = new A();
        }
        return this.f1444a.toModel(a2);
    }

    public /* synthetic */ Q(F f, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? new F(null, null, null, 7, null) : f);
    }
}
