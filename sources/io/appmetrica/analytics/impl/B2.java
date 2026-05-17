package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.ExternalAttribution;
import io.appmetrica.analytics.protobuf.nano.MessageNano;
import kotlin.text.Charsets;
/* loaded from: classes5.dex */
public class B2 implements ExternalAttribution {

    /* renamed from: a  reason: collision with root package name */
    public final A9 f513a;

    public B2(A9 a9) {
        this.f513a = a9;
    }

    @Override // io.appmetrica.analytics.ExternalAttribution
    public final byte[] toBytes() {
        return MessageNano.toByteArray(this.f513a);
    }

    public final String toString() {
        return "ExternalAttribution(type=`" + K9.a(this.f513a.f501a) + "`value=`" + new String(this.f513a.b, Charsets.UTF_8) + "`)";
    }
}
