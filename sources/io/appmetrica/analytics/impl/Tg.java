package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.ecommerce.ECommerceReferrer;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
/* loaded from: classes4.dex */
public final class Tg {

    /* renamed from: a  reason: collision with root package name */
    public final String f687a;
    public final String b;
    public final C0741yj c;

    public Tg(ECommerceReferrer eCommerceReferrer) {
        this(eCommerceReferrer.getType(), eCommerceReferrer.getIdentifier(), eCommerceReferrer.getScreen() == null ? null : new C0741yj(eCommerceReferrer.getScreen()));
    }

    public final String toString() {
        return "ReferrerWrapper{type='" + this.f687a + "', identifier='" + this.b + "', screen=" + this.c + AbstractJsonLexerKt.END_OBJ;
    }

    public Tg(String str, String str2, C0741yj c0741yj) {
        this.f687a = str;
        this.b = str2;
        this.c = c0741yj;
    }
}
