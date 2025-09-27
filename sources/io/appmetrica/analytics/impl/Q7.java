package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.data.Converter;
import io.appmetrica.analytics.protobuf.nano.InvalidProtocolBufferNanoException;
import io.appmetrica.analytics.protobuf.nano.MessageNano;
import kotlin.jvm.internal.DefaultConstructorMarker;
/* loaded from: classes4.dex */
public final class Q7 implements Converter {

    /* renamed from: a  reason: collision with root package name */
    public final P7 f638a;

    public Q7() {
        this(null, 1, null);
    }

    public final byte[] a(R7 r7) {
        return MessageNano.toByteArray(this.f638a.fromModel(r7));
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    public final Object fromModel(Object obj) {
        return MessageNano.toByteArray(this.f638a.fromModel((R7) obj));
    }

    public Q7(P7 p7) {
        this.f638a = p7;
    }

    /* JADX WARN: Code restructure failed: missing block: B:4:0x000d, code lost:
        if (r2 == null) goto L2;
     */
    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final R7 toModel(byte[] bArr) {
        O7 o7;
        if (bArr != null) {
            try {
                o7 = (O7) MessageNano.mergeFrom(new O7(), bArr);
            } catch (InvalidProtocolBufferNanoException unused) {
                o7 = new O7();
            }
        }
        o7 = new O7();
        return this.f638a.toModel(o7);
    }

    public /* synthetic */ Q7(P7 p7, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? new P7(null, 1, null) : p7);
    }
}
