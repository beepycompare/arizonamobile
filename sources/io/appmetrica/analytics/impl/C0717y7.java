package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.data.Converter;
import io.appmetrica.analytics.protobuf.nano.InvalidProtocolBufferNanoException;
import io.appmetrica.analytics.protobuf.nano.MessageNano;
import kotlin.jvm.internal.DefaultConstructorMarker;
/* renamed from: io.appmetrica.analytics.impl.y7  reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C0717y7 implements Converter {

    /* renamed from: a  reason: collision with root package name */
    public final C0692x7 f1211a;

    public C0717y7() {
        this(null, 1, null);
    }

    public final byte[] a(C0742z7 c0742z7) {
        return MessageNano.toByteArray(this.f1211a.fromModel(c0742z7));
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    public final Object fromModel(Object obj) {
        return MessageNano.toByteArray(this.f1211a.fromModel((C0742z7) obj));
    }

    public C0717y7(C0692x7 c0692x7) {
        this.f1211a = c0692x7;
    }

    /* JADX WARN: Code restructure failed: missing block: B:4:0x000d, code lost:
        if (r2 == null) goto L2;
     */
    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final C0742z7 toModel(byte[] bArr) {
        C0667w7 c0667w7;
        if (bArr != null) {
            try {
                c0667w7 = (C0667w7) MessageNano.mergeFrom(new C0667w7(), bArr);
            } catch (InvalidProtocolBufferNanoException unused) {
                c0667w7 = new C0667w7();
            }
        }
        c0667w7 = new C0667w7();
        return this.f1211a.toModel(c0667w7);
    }

    public /* synthetic */ C0717y7(C0692x7 c0692x7, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? new C0692x7(null, 1, null) : c0692x7);
    }
}
