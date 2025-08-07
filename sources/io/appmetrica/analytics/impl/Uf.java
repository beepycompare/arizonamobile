package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreutils.internal.collection.CollectionUtils;
import io.appmetrica.analytics.ecommerce.ECommerceProduct;
import java.util.List;
import java.util.Map;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
/* loaded from: classes4.dex */
public final class Uf {

    /* renamed from: a  reason: collision with root package name */
    public final String f671a;
    public final String b;
    public final List c;
    public final Map d;
    public final Nf e;
    public final Nf f;
    public final List g;

    public Uf(ECommerceProduct eCommerceProduct) {
        this(eCommerceProduct.getSku(), eCommerceProduct.getName(), CollectionUtils.arrayListCopyOfNullableCollection(eCommerceProduct.getCategoriesPath()), CollectionUtils.mapCopyOfNullableMap(eCommerceProduct.getPayload()), eCommerceProduct.getActualPrice() == null ? null : new Nf(eCommerceProduct.getActualPrice()), eCommerceProduct.getOriginalPrice() != null ? new Nf(eCommerceProduct.getOriginalPrice()) : null, CollectionUtils.arrayListCopyOfNullableCollection(eCommerceProduct.getPromocodes()));
    }

    public final String toString() {
        return "ProductWrapper{sku='" + this.f671a + "', name='" + this.b + "', categoriesPath=" + this.c + ", payload=" + this.d + ", actualPrice=" + this.e + ", originalPrice=" + this.f + ", promocodes=" + this.g + AbstractJsonLexerKt.END_OBJ;
    }

    public Uf(String str, String str2, List list, Map map, Nf nf, Nf nf2, List list2) {
        this.f671a = str;
        this.b = str2;
        this.c = list;
        this.d = map;
        this.e = nf;
        this.f = nf2;
        this.g = list2;
    }
}
