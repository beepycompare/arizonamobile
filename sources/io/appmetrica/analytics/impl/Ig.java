package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.ecommerce.ECommerceReferrer;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
/* loaded from: classes4.dex */
public final class Ig {

    /* renamed from: a  reason: collision with root package name */
    public final String f477a;
    public final String b;
    public final C0437mj c;

    public Ig(ECommerceReferrer eCommerceReferrer) {
        this(eCommerceReferrer.getType(), eCommerceReferrer.getIdentifier(), eCommerceReferrer.getScreen() == null ? null : new C0437mj(eCommerceReferrer.getScreen()));
    }

    public final String toString() {
        return "ReferrerWrapper{type='" + this.f477a + "', identifier='" + this.b + "', screen=" + this.c + AbstractJsonLexerKt.END_OBJ;
    }

    public Ig(String str, String str2, C0437mj c0437mj) {
        this.f477a = str;
        this.b = str2;
        this.c = c0437mj;
    }
}
