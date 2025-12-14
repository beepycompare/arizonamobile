package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.data.Converter;
import io.appmetrica.analytics.protobuf.nano.InvalidProtocolBufferNanoException;
import io.appmetrica.analytics.protobuf.nano.MessageNano;
import kotlin.jvm.internal.DefaultConstructorMarker;
/* renamed from: io.appmetrica.analytics.impl.d7  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0186d7 implements Converter {

    /* renamed from: a  reason: collision with root package name */
    public final C0160c7 f941a;

    public C0186d7() {
        this(null, 1, null);
    }

    public final byte[] a(C0211e7 c0211e7) {
        return MessageNano.toByteArray(this.f941a.fromModel(c0211e7));
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    public final Object fromModel(Object obj) {
        return MessageNano.toByteArray(this.f941a.fromModel((C0211e7) obj));
    }

    public C0186d7(C0160c7 c0160c7) {
        this.f941a = c0160c7;
    }

    /* JADX WARN: Code restructure failed: missing block: B:4:0x000d, code lost:
        if (r2 == null) goto L2;
     */
    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final C0211e7 toModel(byte[] bArr) {
        C0442n7 c0442n7;
        if (bArr != null) {
            try {
                c0442n7 = (C0442n7) MessageNano.mergeFrom(new C0442n7(), bArr);
            } catch (InvalidProtocolBufferNanoException unused) {
                c0442n7 = new C0442n7();
            }
        }
        c0442n7 = new C0442n7();
        return this.f941a.toModel(c0442n7);
    }

    public /* synthetic */ C0186d7(C0160c7 c0160c7, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? new C0160c7(null, null, 3, null) : c0160c7);
    }
}
