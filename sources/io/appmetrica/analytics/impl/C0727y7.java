package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.data.Converter;
import io.appmetrica.analytics.protobuf.nano.InvalidProtocolBufferNanoException;
import io.appmetrica.analytics.protobuf.nano.MessageNano;
import kotlin.jvm.internal.DefaultConstructorMarker;
/* renamed from: io.appmetrica.analytics.impl.y7  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0727y7 implements Converter {

    /* renamed from: a  reason: collision with root package name */
    public final C0702x7 f1149a;

    public C0727y7() {
        this(null, 1, null);
    }

    public final byte[] a(C0752z7 c0752z7) {
        return MessageNano.toByteArray(this.f1149a.fromModel(c0752z7));
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    public final Object fromModel(Object obj) {
        return MessageNano.toByteArray(this.f1149a.fromModel((C0752z7) obj));
    }

    public C0727y7(C0702x7 c0702x7) {
        this.f1149a = c0702x7;
    }

    /* JADX WARN: Code restructure failed: missing block: B:4:0x000d, code lost:
        if (r2 == null) goto L2;
     */
    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final C0752z7 toModel(byte[] bArr) {
        I7 i7;
        if (bArr != null) {
            try {
                i7 = (I7) MessageNano.mergeFrom(new I7(), bArr);
            } catch (InvalidProtocolBufferNanoException unused) {
                i7 = new I7();
            }
        }
        i7 = new I7();
        return this.f1149a.toModel(i7);
    }

    public /* synthetic */ C0727y7(C0702x7 c0702x7, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? new C0702x7(null, null, 3, null) : c0702x7);
    }
}
