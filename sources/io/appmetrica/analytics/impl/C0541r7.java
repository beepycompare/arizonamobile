package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.data.Converter;
import io.appmetrica.analytics.protobuf.nano.InvalidProtocolBufferNanoException;
import io.appmetrica.analytics.protobuf.nano.MessageNano;
import kotlin.jvm.internal.DefaultConstructorMarker;
/* renamed from: io.appmetrica.analytics.impl.r7  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0541r7 implements Converter {

    /* renamed from: a  reason: collision with root package name */
    public final C0517q7 f1181a;

    public C0541r7() {
        this(null, 1, null);
    }

    public final byte[] a(C0566s7 c0566s7) {
        return MessageNano.toByteArray(this.f1181a.fromModel(c0566s7));
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    public final Object fromModel(Object obj) {
        return MessageNano.toByteArray(this.f1181a.fromModel((C0566s7) obj));
    }

    public C0541r7(C0517q7 c0517q7) {
        this.f1181a = c0517q7;
    }

    /* JADX WARN: Code restructure failed: missing block: B:4:0x000d, code lost:
        if (r2 == null) goto L2;
     */
    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final C0566s7 toModel(byte[] bArr) {
        C0492p7 c0492p7;
        if (bArr != null) {
            try {
                c0492p7 = (C0492p7) MessageNano.mergeFrom(new C0492p7(), bArr);
            } catch (InvalidProtocolBufferNanoException unused) {
                c0492p7 = new C0492p7();
            }
        }
        c0492p7 = new C0492p7();
        return this.f1181a.toModel(c0492p7);
    }

    public /* synthetic */ C0541r7(C0517q7 c0517q7, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? new C0517q7(null, 1, null) : c0517q7);
    }
}
