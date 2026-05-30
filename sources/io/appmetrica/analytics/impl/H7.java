package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.data.Converter;
import io.appmetrica.analytics.protobuf.nano.InvalidProtocolBufferNanoException;
import io.appmetrica.analytics.protobuf.nano.MessageNano;
import kotlin.jvm.internal.DefaultConstructorMarker;
/* loaded from: classes5.dex */
public final class H7 implements Converter {

    /* renamed from: a  reason: collision with root package name */
    public final G7 f574a;

    public H7() {
        this(null, 1, null);
    }

    public final byte[] a(I7 i7) {
        return MessageNano.toByteArray(this.f574a.fromModel(i7));
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    public final Object fromModel(Object obj) {
        return MessageNano.toByteArray(this.f574a.fromModel((I7) obj));
    }

    public H7(G7 g7) {
        this.f574a = g7;
    }

    /* JADX WARN: Code restructure failed: missing block: B:4:0x000d, code lost:
        if (r2 == null) goto L2;
     */
    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final I7 toModel(byte[] bArr) {
        F7 f7;
        if (bArr != null) {
            try {
                f7 = (F7) MessageNano.mergeFrom(new F7(), bArr);
            } catch (InvalidProtocolBufferNanoException unused) {
                f7 = new F7();
            }
        }
        f7 = new F7();
        return this.f574a.toModel(f7);
    }

    public /* synthetic */ H7(G7 g7, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? new G7(null, 1, null) : g7);
    }
}
