package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.data.Converter;
import io.appmetrica.analytics.protobuf.nano.InvalidProtocolBufferNanoException;
import io.appmetrica.analytics.protobuf.nano.MessageNano;
import kotlin.jvm.internal.DefaultConstructorMarker;
/* renamed from: io.appmetrica.analytics.impl.t7  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0598t7 implements Converter {

    /* renamed from: a  reason: collision with root package name */
    public final C0572s7 f1216a;

    public C0598t7() {
        this(null, 1, null);
    }

    public final byte[] a(C0624u7 c0624u7) {
        return MessageNano.toByteArray(this.f1216a.fromModel(c0624u7));
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    public final Object fromModel(Object obj) {
        return MessageNano.toByteArray(this.f1216a.fromModel((C0624u7) obj));
    }

    public C0598t7(C0572s7 c0572s7) {
        this.f1216a = c0572s7;
    }

    /* JADX WARN: Code restructure failed: missing block: B:4:0x000d, code lost:
        if (r2 == null) goto L2;
     */
    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final C0624u7 toModel(byte[] bArr) {
        D7 d7;
        if (bArr != null) {
            try {
                d7 = (D7) MessageNano.mergeFrom(new D7(), bArr);
            } catch (InvalidProtocolBufferNanoException unused) {
                d7 = new D7();
            }
        }
        d7 = new D7();
        return this.f1216a.toModel(d7);
    }

    public /* synthetic */ C0598t7(C0572s7 c0572s7, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? new C0572s7(null, null, 3, null) : c0572s7);
    }
}
