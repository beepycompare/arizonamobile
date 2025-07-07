package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.data.Converter;
import io.appmetrica.analytics.protobuf.nano.InvalidProtocolBufferNanoException;
import io.appmetrica.analytics.protobuf.nano.MessageNano;
import kotlin.jvm.internal.DefaultConstructorMarker;
/* renamed from: io.appmetrica.analytics.impl.v7  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0657v7 implements Converter {

    /* renamed from: a  reason: collision with root package name */
    public final C0632u7 f1086a;

    public C0657v7() {
        this(null, 1, null);
    }

    public final byte[] a(C0682w7 c0682w7) {
        return MessageNano.toByteArray(this.f1086a.fromModel(c0682w7));
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    public final Object fromModel(Object obj) {
        return MessageNano.toByteArray(this.f1086a.fromModel((C0682w7) obj));
    }

    public C0657v7(C0632u7 c0632u7) {
        this.f1086a = c0632u7;
    }

    /* JADX WARN: Code restructure failed: missing block: B:4:0x000d, code lost:
        if (r2 == null) goto L2;
     */
    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final C0682w7 toModel(byte[] bArr) {
        F7 f7;
        if (bArr != null) {
            try {
                f7 = (F7) MessageNano.mergeFrom(new F7(), bArr);
            } catch (InvalidProtocolBufferNanoException unused) {
                f7 = new F7();
            }
        }
        f7 = new F7();
        return this.f1086a.toModel(f7);
    }

    public /* synthetic */ C0657v7(C0632u7 c0632u7, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? new C0632u7(null, null, 3, null) : c0632u7);
    }
}
