package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.ecommerce.ECommerceReferrer;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
/* renamed from: io.appmetrica.analytics.impl.xg  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0703xg {

    /* renamed from: a  reason: collision with root package name */
    public final String f1312a;
    public final String b;
    public final C0176cj c;

    public C0703xg(ECommerceReferrer eCommerceReferrer) {
        this(eCommerceReferrer.getType(), eCommerceReferrer.getIdentifier(), eCommerceReferrer.getScreen() == null ? null : new C0176cj(eCommerceReferrer.getScreen()));
    }

    public final String toString() {
        return "ReferrerWrapper{type='" + this.f1312a + "', identifier='" + this.b + "', screen=" + this.c + AbstractJsonLexerKt.END_OBJ;
    }

    public C0703xg(String str, String str2, C0176cj c0176cj) {
        this.f1312a = str;
        this.b = str2;
        this.c = c0176cj;
    }
}
