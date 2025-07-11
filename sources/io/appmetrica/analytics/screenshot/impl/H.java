package io.appmetrica.analytics.screenshot.impl;

import io.appmetrica.analytics.coreapi.internal.data.Converter;
import io.appmetrica.analytics.protobuf.nano.MessageNano;
import kotlin.jvm.internal.DefaultConstructorMarker;
/* loaded from: classes4.dex */
public final class H implements Converter {

    /* renamed from: a  reason: collision with root package name */
    public final J f1274a;

    public H() {
        this(null, 1, null);
    }

    public final byte[] a(G g) {
        return MessageNano.toByteArray(this.f1274a.fromModel(g));
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    public final Object fromModel(Object obj) {
        return MessageNano.toByteArray(this.f1274a.fromModel((G) obj));
    }

    public H(J j) {
        this.f1274a = j;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final G toModel(byte[] bArr) {
        O o;
        try {
            o = (O) MessageNano.mergeFrom(new O(), bArr);
        } catch (Throwable unused) {
            o = new O();
        }
        return this.f1274a.toModel(o);
    }

    public /* synthetic */ H(J j, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? new J(null, 1, null) : j);
    }
}
