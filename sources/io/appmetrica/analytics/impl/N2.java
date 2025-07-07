package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.ExternalAttribution;
import io.appmetrica.analytics.protobuf.nano.MessageNano;
import kotlin.text.Charsets;
/* loaded from: classes4.dex */
public class N2 implements ExternalAttribution {

    /* renamed from: a  reason: collision with root package name */
    public final T9 f546a;

    public N2(T9 t9) {
        this.f546a = t9;
    }

    @Override // io.appmetrica.analytics.ExternalAttribution
    public final byte[] toBytes() {
        return MessageNano.toByteArray(this.f546a);
    }

    public final String toString() {
        return "ExternalAttribution(type=`" + AbstractC0212da.a(this.f546a.f638a) + "`value=`" + new String(this.f546a.b, Charsets.UTF_8) + "`)";
    }
}
