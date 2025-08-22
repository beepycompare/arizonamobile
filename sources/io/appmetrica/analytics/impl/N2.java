package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.ExternalAttribution;
import io.appmetrica.analytics.protobuf.nano.MessageNano;
import kotlin.text.Charsets;
/* loaded from: classes4.dex */
public class N2 implements ExternalAttribution {

    /* renamed from: a  reason: collision with root package name */
    public final X9 f571a;

    public N2(X9 x9) {
        this.f571a = x9;
    }

    @Override // io.appmetrica.analytics.ExternalAttribution
    public final byte[] toBytes() {
        return MessageNano.toByteArray(this.f571a);
    }

    public final String toString() {
        return "ExternalAttribution(type=`" + AbstractC0300ha.a(this.f571a.f724a) + "`value=`" + new String(this.f571a.b, Charsets.UTF_8) + "`)";
    }
}
