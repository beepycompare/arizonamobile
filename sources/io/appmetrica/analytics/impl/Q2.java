package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.ExternalAttribution;
import io.appmetrica.analytics.protobuf.nano.MessageNano;
import kotlin.text.Charsets;
/* loaded from: classes4.dex */
public class Q2 implements ExternalAttribution {

    /* renamed from: a  reason: collision with root package name */
    public final C0120aa f634a;

    public Q2(C0120aa c0120aa) {
        this.f634a = c0120aa;
    }

    @Override // io.appmetrica.analytics.ExternalAttribution
    public final byte[] toBytes() {
        return MessageNano.toByteArray(this.f634a);
    }

    public final String toString() {
        return "ExternalAttribution(type=`" + AbstractC0378ka.a(this.f634a.f791a) + "`value=`" + new String(this.f634a.b, Charsets.UTF_8) + "`)";
    }
}
