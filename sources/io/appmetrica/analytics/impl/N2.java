package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.ExternalAttribution;
import io.appmetrica.analytics.protobuf.nano.MessageNano;
import kotlin.text.Charsets;
/* loaded from: classes4.dex */
public class N2 implements ExternalAttribution {

    /* renamed from: a  reason: collision with root package name */
    public final V9 f557a;

    public N2(V9 v9) {
        this.f557a = v9;
    }

    @Override // io.appmetrica.analytics.ExternalAttribution
    public final byte[] toBytes() {
        return MessageNano.toByteArray(this.f557a);
    }

    public final String toString() {
        return "ExternalAttribution(type=`" + AbstractC0255fa.a(this.f557a.f683a) + "`value=`" + new String(this.f557a.b, Charsets.UTF_8) + "`)";
    }
}
