package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.data.Converter;
import io.appmetrica.analytics.protobuf.nano.InvalidProtocolBufferNanoException;
import io.appmetrica.analytics.protobuf.nano.MessageNano;
import kotlin.jvm.internal.DefaultConstructorMarker;
/* renamed from: io.appmetrica.analytics.impl.d7  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0187d7 implements Converter {

    /* renamed from: a  reason: collision with root package name */
    public final C0161c7 f844a;

    public C0187d7() {
        this(null, 1, null);
    }

    public final byte[] a(C0212e7 c0212e7) {
        return MessageNano.toByteArray(this.f844a.fromModel(c0212e7));
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    public final Object fromModel(Object obj) {
        return MessageNano.toByteArray(this.f844a.fromModel((C0212e7) obj));
    }

    public C0187d7(C0161c7 c0161c7) {
        this.f844a = c0161c7;
    }

    /* JADX WARN: Code restructure failed: missing block: B:4:0x000d, code lost:
        if (r2 == null) goto L2;
     */
    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final C0212e7 toModel(byte[] bArr) {
        C0443n7 c0443n7;
        if (bArr != null) {
            try {
                c0443n7 = (C0443n7) MessageNano.mergeFrom(new C0443n7(), bArr);
            } catch (InvalidProtocolBufferNanoException unused) {
                c0443n7 = new C0443n7();
            }
        }
        c0443n7 = new C0443n7();
        return this.f844a.toModel(c0443n7);
    }

    public /* synthetic */ C0187d7(C0161c7 c0161c7, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? new C0161c7(null, null, 3, null) : c0161c7);
    }
}
