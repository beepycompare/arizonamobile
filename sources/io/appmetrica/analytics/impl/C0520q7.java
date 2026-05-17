package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.data.Converter;
import io.appmetrica.analytics.protobuf.nano.InvalidProtocolBufferNanoException;
import io.appmetrica.analytics.protobuf.nano.MessageNano;
import kotlin.jvm.internal.DefaultConstructorMarker;
/* renamed from: io.appmetrica.analytics.impl.q7  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0520q7 implements Converter {

    /* renamed from: a  reason: collision with root package name */
    public final C0495p7 f1190a;

    public C0520q7() {
        this(null, 1, null);
    }

    public final byte[] a(C0544r7 c0544r7) {
        return MessageNano.toByteArray(this.f1190a.fromModel(c0544r7));
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    public final Object fromModel(Object obj) {
        return MessageNano.toByteArray(this.f1190a.fromModel((C0544r7) obj));
    }

    public C0520q7(C0495p7 c0495p7) {
        this.f1190a = c0495p7;
    }

    /* JADX WARN: Code restructure failed: missing block: B:4:0x000d, code lost:
        if (r2 == null) goto L2;
     */
    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final C0544r7 toModel(byte[] bArr) {
        C0470o7 c0470o7;
        if (bArr != null) {
            try {
                c0470o7 = (C0470o7) MessageNano.mergeFrom(new C0470o7(), bArr);
            } catch (InvalidProtocolBufferNanoException unused) {
                c0470o7 = new C0470o7();
            }
        }
        c0470o7 = new C0470o7();
        return this.f1190a.toModel(c0470o7);
    }

    public /* synthetic */ C0520q7(C0495p7 c0495p7, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? new C0495p7(null, 1, null) : c0495p7);
    }
}
