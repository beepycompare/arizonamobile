package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.ExternalAttribution;
import io.appmetrica.analytics.protobuf.nano.MessageNano;
import kotlin.text.Charsets;
/* loaded from: classes4.dex */
public class Q2 implements ExternalAttribution {

    /* renamed from: a  reason: collision with root package name */
    public final C0119aa f633a;

    public Q2(C0119aa c0119aa) {
        this.f633a = c0119aa;
    }

    @Override // io.appmetrica.analytics.ExternalAttribution
    public final byte[] toBytes() {
        return MessageNano.toByteArray(this.f633a);
    }

    public final String toString() {
        return "ExternalAttribution(type=`" + AbstractC0377ka.a(this.f633a.f790a) + "`value=`" + new String(this.f633a.b, Charsets.UTF_8) + "`)";
    }
}
