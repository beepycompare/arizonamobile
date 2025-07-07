package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.data.Converter;
import io.appmetrica.analytics.protobuf.nano.InvalidProtocolBufferNanoException;
import io.appmetrica.analytics.protobuf.nano.MessageNano;
import kotlin.jvm.internal.DefaultConstructorMarker;
/* loaded from: classes4.dex */
public final class J7 implements Converter {

    /* renamed from: a  reason: collision with root package name */
    public final I7 f488a;

    public J7() {
        this(null, 1, null);
    }

    public final byte[] a(K7 k7) {
        return MessageNano.toByteArray(this.f488a.fromModel(k7));
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    public final Object fromModel(Object obj) {
        return MessageNano.toByteArray(this.f488a.fromModel((K7) obj));
    }

    public J7(I7 i7) {
        this.f488a = i7;
    }

    /* JADX WARN: Code restructure failed: missing block: B:4:0x000d, code lost:
        if (r2 == null) goto L2;
     */
    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final K7 toModel(byte[] bArr) {
        H7 h7;
        if (bArr != null) {
            try {
                h7 = (H7) MessageNano.mergeFrom(new H7(), bArr);
            } catch (InvalidProtocolBufferNanoException unused) {
                h7 = new H7();
            }
        }
        h7 = new H7();
        return this.f488a.toModel(h7);
    }

    public /* synthetic */ J7(I7 i7, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? new I7(null, 1, null) : i7);
    }
}
