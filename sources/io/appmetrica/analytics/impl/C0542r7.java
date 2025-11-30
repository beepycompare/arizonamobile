package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.data.Converter;
import io.appmetrica.analytics.protobuf.nano.InvalidProtocolBufferNanoException;
import io.appmetrica.analytics.protobuf.nano.MessageNano;
import kotlin.jvm.internal.DefaultConstructorMarker;
/* renamed from: io.appmetrica.analytics.impl.r7  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0542r7 implements Converter {

    /* renamed from: a  reason: collision with root package name */
    public final C0518q7 f1098a;

    public C0542r7() {
        this(null, 1, null);
    }

    public final byte[] a(C0567s7 c0567s7) {
        return MessageNano.toByteArray(this.f1098a.fromModel(c0567s7));
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    public final Object fromModel(Object obj) {
        return MessageNano.toByteArray(this.f1098a.fromModel((C0567s7) obj));
    }

    public C0542r7(C0518q7 c0518q7) {
        this.f1098a = c0518q7;
    }

    /* JADX WARN: Code restructure failed: missing block: B:4:0x000d, code lost:
        if (r2 == null) goto L2;
     */
    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final C0567s7 toModel(byte[] bArr) {
        C0493p7 c0493p7;
        if (bArr != null) {
            try {
                c0493p7 = (C0493p7) MessageNano.mergeFrom(new C0493p7(), bArr);
            } catch (InvalidProtocolBufferNanoException unused) {
                c0493p7 = new C0493p7();
            }
        }
        c0493p7 = new C0493p7();
        return this.f1098a.toModel(c0493p7);
    }

    public /* synthetic */ C0542r7(C0518q7 c0518q7, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? new C0518q7(null, 1, null) : c0518q7);
    }
}
