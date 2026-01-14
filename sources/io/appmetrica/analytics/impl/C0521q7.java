package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.data.Converter;
import io.appmetrica.analytics.protobuf.nano.InvalidProtocolBufferNanoException;
import io.appmetrica.analytics.protobuf.nano.MessageNano;
import kotlin.jvm.internal.DefaultConstructorMarker;
/* renamed from: io.appmetrica.analytics.impl.q7  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0521q7 implements Converter {

    /* renamed from: a  reason: collision with root package name */
    public final C0496p7 f1186a;

    public C0521q7() {
        this(null, 1, null);
    }

    public final byte[] a(C0545r7 c0545r7) {
        return MessageNano.toByteArray(this.f1186a.fromModel(c0545r7));
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    public final Object fromModel(Object obj) {
        return MessageNano.toByteArray(this.f1186a.fromModel((C0545r7) obj));
    }

    public C0521q7(C0496p7 c0496p7) {
        this.f1186a = c0496p7;
    }

    /* JADX WARN: Code restructure failed: missing block: B:4:0x000d, code lost:
        if (r2 == null) goto L2;
     */
    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final C0545r7 toModel(byte[] bArr) {
        C0471o7 c0471o7;
        if (bArr != null) {
            try {
                c0471o7 = (C0471o7) MessageNano.mergeFrom(new C0471o7(), bArr);
            } catch (InvalidProtocolBufferNanoException unused) {
                c0471o7 = new C0471o7();
            }
        }
        c0471o7 = new C0471o7();
        return this.f1186a.toModel(c0471o7);
    }

    public /* synthetic */ C0521q7(C0496p7 c0496p7, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? new C0496p7(null, 1, null) : c0496p7);
    }
}
