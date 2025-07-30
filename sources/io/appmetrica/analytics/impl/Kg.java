package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.ecommerce.ECommerceReferrer;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
/* loaded from: classes4.dex */
public final class Kg {

    /* renamed from: a  reason: collision with root package name */
    public final String f523a;
    public final String b;
    public final C0514pj c;

    public Kg(ECommerceReferrer eCommerceReferrer) {
        this(eCommerceReferrer.getType(), eCommerceReferrer.getIdentifier(), eCommerceReferrer.getScreen() == null ? null : new C0514pj(eCommerceReferrer.getScreen()));
    }

    public final String toString() {
        return "ReferrerWrapper{type='" + this.f523a + "', identifier='" + this.b + "', screen=" + this.c + AbstractJsonLexerKt.END_OBJ;
    }

    public Kg(String str, String str2, C0514pj c0514pj) {
        this.f523a = str;
        this.b = str2;
        this.c = c0514pj;
    }
}
