package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.data.Converter;
import io.appmetrica.analytics.protobuf.nano.InvalidProtocolBufferNanoException;
import io.appmetrica.analytics.protobuf.nano.MessageNano;
import kotlin.jvm.internal.DefaultConstructorMarker;
/* renamed from: io.appmetrica.analytics.impl.z7  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0749z7 implements Converter {

    /* renamed from: a  reason: collision with root package name */
    public final C0724y7 f1174a;

    public C0749z7() {
        this(null, 1, null);
    }

    public final byte[] a(A7 a7) {
        return MessageNano.toByteArray(this.f1174a.fromModel(a7));
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    public final Object fromModel(Object obj) {
        return MessageNano.toByteArray(this.f1174a.fromModel((A7) obj));
    }

    public C0749z7(C0724y7 c0724y7) {
        this.f1174a = c0724y7;
    }

    /* JADX WARN: Code restructure failed: missing block: B:4:0x000d, code lost:
        if (r2 == null) goto L2;
     */
    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final A7 toModel(byte[] bArr) {
        J7 j7;
        if (bArr != null) {
            try {
                j7 = (J7) MessageNano.mergeFrom(new J7(), bArr);
            } catch (InvalidProtocolBufferNanoException unused) {
                j7 = new J7();
            }
        }
        j7 = new J7();
        return this.f1174a.toModel(j7);
    }

    public /* synthetic */ C0749z7(C0724y7 c0724y7, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? new C0724y7(null, null, 3, null) : c0724y7);
    }
}
