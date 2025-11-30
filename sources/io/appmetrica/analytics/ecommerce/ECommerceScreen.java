package io.appmetrica.analytics.ecommerce;

import java.util.List;
import java.util.Map;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
/* loaded from: classes3.dex */
public class ECommerceScreen {

    /* renamed from: a  reason: collision with root package name */
    private String f339a;
    private List b;
    private String c;
    private Map d;

    public List<String> getCategoriesPath() {
        return this.b;
    }

    public String getName() {
        return this.f339a;
    }

    public Map<String, String> getPayload() {
        return this.d;
    }

    public String getSearchQuery() {
        return this.c;
    }

    public ECommerceScreen setCategoriesPath(List<String> list) {
        this.b = list;
        return this;
    }

    public ECommerceScreen setName(String str) {
        this.f339a = str;
        return this;
    }

    public ECommerceScreen setPayload(Map<String, String> map) {
        this.d = map;
        return this;
    }

    public ECommerceScreen setSearchQuery(String str) {
        this.c = str;
        return this;
    }

    public String toString() {
        return "ECommerceScreen{name='" + this.f339a + "', categoriesPath=" + this.b + ", searchQuery='" + this.c + "', payload=" + this.d + AbstractJsonLexerKt.END_OBJ;
    }
}
