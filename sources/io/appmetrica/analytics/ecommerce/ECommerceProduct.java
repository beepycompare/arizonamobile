package io.appmetrica.analytics.ecommerce;

import java.util.List;
import java.util.Map;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
/* loaded from: classes4.dex */
public class ECommerceProduct {

    /* renamed from: a  reason: collision with root package name */
    private final String f304a;
    private String b;
    private List c;
    private Map d;
    private ECommercePrice e;
    private ECommercePrice f;
    private List g;

    public ECommerceProduct(String str) {
        this.f304a = str;
    }

    public ECommercePrice getActualPrice() {
        return this.e;
    }

    public List<String> getCategoriesPath() {
        return this.c;
    }

    public String getName() {
        return this.b;
    }

    public ECommercePrice getOriginalPrice() {
        return this.f;
    }

    public Map<String, String> getPayload() {
        return this.d;
    }

    public List<String> getPromocodes() {
        return this.g;
    }

    public String getSku() {
        return this.f304a;
    }

    public ECommerceProduct setActualPrice(ECommercePrice eCommercePrice) {
        this.e = eCommercePrice;
        return this;
    }

    public ECommerceProduct setCategoriesPath(List<String> list) {
        this.c = list;
        return this;
    }

    public ECommerceProduct setName(String str) {
        this.b = str;
        return this;
    }

    public ECommerceProduct setOriginalPrice(ECommercePrice eCommercePrice) {
        this.f = eCommercePrice;
        return this;
    }

    public ECommerceProduct setPayload(Map<String, String> map) {
        this.d = map;
        return this;
    }

    public ECommerceProduct setPromocodes(List<String> list) {
        this.g = list;
        return this;
    }

    public String toString() {
        return "ECommerceProduct{sku='" + this.f304a + "', name='" + this.b + "', categoriesPath=" + this.c + ", payload=" + this.d + ", actualPrice=" + this.e + ", originalPrice=" + this.f + ", promocodes=" + this.g + AbstractJsonLexerKt.END_OBJ;
    }
}
