package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.ExternalAttribution;
import io.appmetrica.analytics.protobuf.nano.MessageNano;
import kotlin.text.Charsets;
/* loaded from: classes4.dex */
public class N2 implements ExternalAttribution {

    /* renamed from: a  reason: collision with root package name */
    public final V9 f558a;

    public N2(V9 v9) {
        this.f558a = v9;
    }

    @Override // io.appmetrica.analytics.ExternalAttribution
    public final byte[] toBytes() {
        return MessageNano.toByteArray(this.f558a);
    }

    public final String toString() {
        return "ExternalAttribution(type=`" + AbstractC0255fa.a(this.f558a.f684a) + "`value=`" + new String(this.f558a.b, Charsets.UTF_8) + "`)";
    }
}
