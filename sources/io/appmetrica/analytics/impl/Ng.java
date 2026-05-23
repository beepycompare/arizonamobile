package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.ecommerce.ECommerceReferrer;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
/* loaded from: classes5.dex */
public final class Ng {

    /* renamed from: a  reason: collision with root package name */
    public final String f685a;
    public final String b;
    public final Dj c;

    public Ng(ECommerceReferrer eCommerceReferrer) {
        this(eCommerceReferrer.getType(), eCommerceReferrer.getIdentifier(), eCommerceReferrer.getScreen() == null ? null : new Dj(eCommerceReferrer.getScreen()));
    }

    public final String toString() {
        return "ReferrerWrapper{type='" + this.f685a + "', identifier='" + this.b + "', screen=" + this.c + AbstractJsonLexerKt.END_OBJ;
    }

    public Ng(String str, String str2, Dj dj) {
        this.f685a = str;
        this.b = str2;
        this.c = dj;
    }
}
