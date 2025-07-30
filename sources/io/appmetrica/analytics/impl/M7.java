package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.data.Converter;
import io.appmetrica.analytics.protobuf.nano.InvalidProtocolBufferNanoException;
import io.appmetrica.analytics.protobuf.nano.MessageNano;
import kotlin.jvm.internal.DefaultConstructorMarker;
/* loaded from: classes4.dex */
public final class M7 implements Converter {

    /* renamed from: a  reason: collision with root package name */
    public final L7 f546a;

    public M7() {
        this(null, 1, null);
    }

    public final byte[] a(N7 n7) {
        return MessageNano.toByteArray(this.f546a.fromModel(n7));
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    public final Object fromModel(Object obj) {
        return MessageNano.toByteArray(this.f546a.fromModel((N7) obj));
    }

    public M7(L7 l7) {
        this.f546a = l7;
    }

    /* JADX WARN: Code restructure failed: missing block: B:4:0x000d, code lost:
        if (r2 == null) goto L2;
     */
    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final N7 toModel(byte[] bArr) {
        K7 k7;
        if (bArr != null) {
            try {
                k7 = (K7) MessageNano.mergeFrom(new K7(), bArr);
            } catch (InvalidProtocolBufferNanoException unused) {
                k7 = new K7();
            }
        }
        k7 = new K7();
        return this.f546a.toModel(k7);
    }

    public /* synthetic */ M7(L7 l7, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? new L7(null, 1, null) : l7);
    }
}
