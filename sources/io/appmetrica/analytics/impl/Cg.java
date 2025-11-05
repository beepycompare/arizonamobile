package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.ecommerce.ECommerceReferrer;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
/* loaded from: classes3.dex */
public final class Cg {

    /* renamed from: a  reason: collision with root package name */
    public final String f426a;
    public final String b;
    public final C0302hj c;

    public Cg(ECommerceReferrer eCommerceReferrer) {
        this(eCommerceReferrer.getType(), eCommerceReferrer.getIdentifier(), eCommerceReferrer.getScreen() == null ? null : new C0302hj(eCommerceReferrer.getScreen()));
    }

    public final String toString() {
        return "ReferrerWrapper{type='" + this.f426a + "', identifier='" + this.b + "', screen=" + this.c + AbstractJsonLexerKt.END_OBJ;
    }

    public Cg(String str, String str2, C0302hj c0302hj) {
        this.f426a = str;
        this.b = str2;
        this.c = c0302hj;
    }
}
