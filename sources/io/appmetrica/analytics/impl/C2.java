package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.ExternalAttribution;
import io.appmetrica.analytics.protobuf.nano.MessageNano;
import kotlin.text.Charsets;
/* loaded from: classes5.dex */
public class C2 implements ExternalAttribution {

    /* renamed from: a  reason: collision with root package name */
    public final B9 f503a;

    public C2(B9 b9) {
        this.f503a = b9;
    }

    @Override // io.appmetrica.analytics.ExternalAttribution
    public final byte[] toBytes() {
        return MessageNano.toByteArray(this.f503a);
    }

    public final String toString() {
        return "ExternalAttribution(type=`" + L9.a(this.f503a.f491a) + "`value=`" + new String(this.f503a.b, Charsets.UTF_8) + "`)";
    }
}
