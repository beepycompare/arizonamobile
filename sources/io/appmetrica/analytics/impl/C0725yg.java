package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.ecommerce.ECommerceReferrer;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
/* renamed from: io.appmetrica.analytics.impl.yg  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0725yg {

    /* renamed from: a  reason: collision with root package name */
    public final String f1303a;
    public final String b;
    public final C0198dj c;

    public C0725yg(ECommerceReferrer eCommerceReferrer) {
        this(eCommerceReferrer.getType(), eCommerceReferrer.getIdentifier(), eCommerceReferrer.getScreen() == null ? null : new C0198dj(eCommerceReferrer.getScreen()));
    }

    public final String toString() {
        return "ReferrerWrapper{type='" + this.f1303a + "', identifier='" + this.b + "', screen=" + this.c + AbstractJsonLexerKt.END_OBJ;
    }

    public C0725yg(String str, String str2, C0198dj c0198dj) {
        this.f1303a = str;
        this.b = str2;
        this.c = c0198dj;
    }
}
