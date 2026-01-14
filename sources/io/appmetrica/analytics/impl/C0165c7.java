package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.data.Converter;
import io.appmetrica.analytics.protobuf.nano.InvalidProtocolBufferNanoException;
import io.appmetrica.analytics.protobuf.nano.MessageNano;
import kotlin.jvm.internal.DefaultConstructorMarker;
/* renamed from: io.appmetrica.analytics.impl.c7  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0165c7 implements Converter {

    /* renamed from: a  reason: collision with root package name */
    public final C0139b7 f932a;

    public C0165c7() {
        this(null, 1, null);
    }

    public final byte[] a(C0191d7 c0191d7) {
        return MessageNano.toByteArray(this.f932a.fromModel(c0191d7));
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    public final Object fromModel(Object obj) {
        return MessageNano.toByteArray(this.f932a.fromModel((C0191d7) obj));
    }

    public C0165c7(C0139b7 c0139b7) {
        this.f932a = c0139b7;
    }

    /* JADX WARN: Code restructure failed: missing block: B:4:0x000d, code lost:
        if (r2 == null) goto L2;
     */
    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final C0191d7 toModel(byte[] bArr) {
        C0421m7 c0421m7;
        if (bArr != null) {
            try {
                c0421m7 = (C0421m7) MessageNano.mergeFrom(new C0421m7(), bArr);
            } catch (InvalidProtocolBufferNanoException unused) {
                c0421m7 = new C0421m7();
            }
        }
        c0421m7 = new C0421m7();
        return this.f932a.toModel(c0421m7);
    }

    public /* synthetic */ C0165c7(C0139b7 c0139b7, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? new C0139b7(null, null, 3, null) : c0139b7);
    }
}
