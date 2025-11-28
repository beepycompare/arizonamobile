package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.data.Converter;
import io.appmetrica.analytics.protobuf.nano.InvalidProtocolBufferNanoException;
import io.appmetrica.analytics.protobuf.nano.MessageNano;
import kotlin.jvm.internal.DefaultConstructorMarker;
/* renamed from: io.appmetrica.analytics.impl.k7  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0367k7 implements Converter {

    /* renamed from: a  reason: collision with root package name */
    public final C0341j7 f968a;

    public C0367k7() {
        this(null, 1, null);
    }

    public final byte[] a(C0393l7 c0393l7) {
        return MessageNano.toByteArray(this.f968a.fromModel(c0393l7));
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    public final Object fromModel(Object obj) {
        return MessageNano.toByteArray(this.f968a.fromModel((C0393l7) obj));
    }

    public C0367k7(C0341j7 c0341j7) {
        this.f968a = c0341j7;
    }

    /* JADX WARN: Code restructure failed: missing block: B:4:0x000d, code lost:
        if (r2 == null) goto L2;
     */
    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final C0393l7 toModel(byte[] bArr) {
        C0617u7 c0617u7;
        if (bArr != null) {
            try {
                c0617u7 = (C0617u7) MessageNano.mergeFrom(new C0617u7(), bArr);
            } catch (InvalidProtocolBufferNanoException unused) {
                c0617u7 = new C0617u7();
            }
        }
        c0617u7 = new C0617u7();
        return this.f968a.toModel(c0617u7);
    }

    public /* synthetic */ C0367k7(C0341j7 c0341j7, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? new C0341j7(null, null, 3, null) : c0341j7);
    }
}
