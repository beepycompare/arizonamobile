package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.ExternalAttribution;
import io.appmetrica.analytics.protobuf.nano.MessageNano;
import kotlin.text.Charsets;
/* loaded from: classes5.dex */
public class C2 implements ExternalAttribution {

    /* renamed from: a  reason: collision with root package name */
    public final B9 f420a;

    public C2(B9 b9) {
        this.f420a = b9;
    }

    @Override // io.appmetrica.analytics.ExternalAttribution
    public final byte[] toBytes() {
        return MessageNano.toByteArray(this.f420a);
    }

    public final String toString() {
        return "ExternalAttribution(type=`" + L9.a(this.f420a.f408a) + "`value=`" + new String(this.f420a.b, Charsets.UTF_8) + "`)";
    }
}
