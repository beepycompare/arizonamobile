package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.ExternalAttribution;
import io.appmetrica.analytics.protobuf.nano.MessageNano;
import kotlin.text.Charsets;
/* loaded from: classes5.dex */
public class O2 implements ExternalAttribution {

    /* renamed from: a  reason: collision with root package name */
    public final V9 f697a;

    public O2(V9 v9) {
        this.f697a = v9;
    }

    @Override // io.appmetrica.analytics.ExternalAttribution
    public final byte[] toBytes() {
        return MessageNano.toByteArray(this.f697a);
    }

    public final String toString() {
        return "ExternalAttribution(type=`" + AbstractC0245fa.a(this.f697a.f809a) + "`value=`" + new String(this.f697a.b, Charsets.UTF_8) + "`)";
    }
}
