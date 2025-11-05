package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.ExternalAttribution;
import io.appmetrica.analytics.protobuf.nano.MessageNano;
import kotlin.text.Charsets;
/* loaded from: classes3.dex */
public class J2 implements ExternalAttribution {

    /* renamed from: a  reason: collision with root package name */
    public final H9 f539a;

    public J2(H9 h9) {
        this.f539a = h9;
    }

    @Override // io.appmetrica.analytics.ExternalAttribution
    public final byte[] toBytes() {
        return MessageNano.toByteArray(this.f539a);
    }

    public final String toString() {
        return "ExternalAttribution(type=`" + R9.a(this.f539a.f504a) + "`value=`" + new String(this.f539a.b, Charsets.UTF_8) + "`)";
    }
}
