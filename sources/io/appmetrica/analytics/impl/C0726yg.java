package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.ecommerce.ECommerceReferrer;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
/* renamed from: io.appmetrica.analytics.impl.yg  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0726yg {

    /* renamed from: a  reason: collision with root package name */
    public final String f1220a;
    public final String b;
    public final C0199dj c;

    public C0726yg(ECommerceReferrer eCommerceReferrer) {
        this(eCommerceReferrer.getType(), eCommerceReferrer.getIdentifier(), eCommerceReferrer.getScreen() == null ? null : new C0199dj(eCommerceReferrer.getScreen()));
    }

    public final String toString() {
        return "ReferrerWrapper{type='" + this.f1220a + "', identifier='" + this.b + "', screen=" + this.c + AbstractJsonLexerKt.END_OBJ;
    }

    public C0726yg(String str, String str2, C0199dj c0199dj) {
        this.f1220a = str;
        this.b = str2;
        this.c = c0199dj;
    }
}
