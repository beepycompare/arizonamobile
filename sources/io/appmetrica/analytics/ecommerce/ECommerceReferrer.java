package io.appmetrica.analytics.ecommerce;

import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
/* loaded from: classes3.dex */
public class ECommerceReferrer {

    /* renamed from: a  reason: collision with root package name */
    private String f435a;
    private String b;
    private ECommerceScreen c;

    public String getIdentifier() {
        return this.b;
    }

    public ECommerceScreen getScreen() {
        return this.c;
    }

    public String getType() {
        return this.f435a;
    }

    public ECommerceReferrer setIdentifier(String str) {
        this.b = str;
        return this;
    }

    public ECommerceReferrer setScreen(ECommerceScreen eCommerceScreen) {
        this.c = eCommerceScreen;
        return this;
    }

    public ECommerceReferrer setType(String str) {
        this.f435a = str;
        return this;
    }

    public String toString() {
        return "ECommerceReferrer{type='" + this.f435a + "', identifier='" + this.b + "', screen=" + this.c + AbstractJsonLexerKt.END_OBJ;
    }
}
