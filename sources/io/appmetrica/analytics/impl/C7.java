package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.data.Converter;
import io.appmetrica.analytics.protobuf.nano.InvalidProtocolBufferNanoException;
import io.appmetrica.analytics.protobuf.nano.MessageNano;
import kotlin.jvm.internal.DefaultConstructorMarker;
/* loaded from: classes4.dex */
public final class C7 implements Converter {

    /* renamed from: a  reason: collision with root package name */
    public final B7 f380a;

    public C7() {
        this(null, 1, null);
    }

    public final byte[] a(D7 d7) {
        return MessageNano.toByteArray(this.f380a.fromModel(d7));
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    public final Object fromModel(Object obj) {
        return MessageNano.toByteArray(this.f380a.fromModel((D7) obj));
    }

    public C7(B7 b7) {
        this.f380a = b7;
    }

    /* JADX WARN: Code restructure failed: missing block: B:4:0x000d, code lost:
        if (r2 == null) goto L2;
     */
    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final D7 toModel(byte[] bArr) {
        M7 m7;
        if (bArr != null) {
            try {
                m7 = (M7) MessageNano.mergeFrom(new M7(), bArr);
            } catch (InvalidProtocolBufferNanoException unused) {
                m7 = new M7();
            }
        }
        m7 = new M7();
        return this.f380a.toModel(m7);
    }

    public /* synthetic */ C7(B7 b7, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? new B7(null, null, 3, null) : b7);
    }
}
