package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.ecommerce.ECommerceReferrer;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
/* renamed from: io.appmetrica.analytics.impl.xg  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0704xg {

    /* renamed from: a  reason: collision with root package name */
    public final String f1307a;
    public final String b;
    public final C0177cj c;

    public C0704xg(ECommerceReferrer eCommerceReferrer) {
        this(eCommerceReferrer.getType(), eCommerceReferrer.getIdentifier(), eCommerceReferrer.getScreen() == null ? null : new C0177cj(eCommerceReferrer.getScreen()));
    }

    public final String toString() {
        return "ReferrerWrapper{type='" + this.f1307a + "', identifier='" + this.b + "', screen=" + this.c + AbstractJsonLexerKt.END_OBJ;
    }

    public C0704xg(String str, String str2, C0177cj c0177cj) {
        this.f1307a = str;
        this.b = str2;
        this.c = c0177cj;
    }
}
