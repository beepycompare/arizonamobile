package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.ExternalAttribution;
import io.appmetrica.analytics.protobuf.nano.MessageNano;
import kotlin.text.Charsets;
/* loaded from: classes4.dex */
public class N2 implements ExternalAttribution {

    /* renamed from: a  reason: collision with root package name */
    public final T9 f547a;

    public N2(T9 t9) {
        this.f547a = t9;
    }

    @Override // io.appmetrica.analytics.ExternalAttribution
    public final byte[] toBytes() {
        return MessageNano.toByteArray(this.f547a);
    }

    public final String toString() {
        return "ExternalAttribution(type=`" + AbstractC0204da.a(this.f547a.f639a) + "`value=`" + new String(this.f547a.b, Charsets.UTF_8) + "`)";
    }
}
