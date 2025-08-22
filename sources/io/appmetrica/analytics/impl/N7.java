package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.data.Converter;
import io.appmetrica.analytics.protobuf.nano.InvalidProtocolBufferNanoException;
import io.appmetrica.analytics.protobuf.nano.MessageNano;
import kotlin.jvm.internal.DefaultConstructorMarker;
/* loaded from: classes4.dex */
public final class N7 implements Converter {

    /* renamed from: a  reason: collision with root package name */
    public final M7 f575a;

    public N7() {
        this(null, 1, null);
    }

    public final byte[] a(O7 o7) {
        return MessageNano.toByteArray(this.f575a.fromModel(o7));
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    public final Object fromModel(Object obj) {
        return MessageNano.toByteArray(this.f575a.fromModel((O7) obj));
    }

    public N7(M7 m7) {
        this.f575a = m7;
    }

    /* JADX WARN: Code restructure failed: missing block: B:4:0x000d, code lost:
        if (r2 == null) goto L2;
     */
    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final O7 toModel(byte[] bArr) {
        L7 l7;
        if (bArr != null) {
            try {
                l7 = (L7) MessageNano.mergeFrom(new L7(), bArr);
            } catch (InvalidProtocolBufferNanoException unused) {
                l7 = new L7();
            }
        }
        l7 = new L7();
        return this.f575a.toModel(l7);
    }

    public /* synthetic */ N7(M7 m7, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? new M7(null, 1, null) : m7);
    }
}
