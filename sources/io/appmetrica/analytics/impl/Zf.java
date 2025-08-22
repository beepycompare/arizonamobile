package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreutils.internal.collection.CollectionUtils;
import io.appmetrica.analytics.ecommerce.ECommerceProduct;
import java.util.List;
import java.util.Map;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
/* loaded from: classes4.dex */
public final class Zf {

    /* renamed from: a  reason: collision with root package name */
    public final String f759a;
    public final String b;
    public final List c;
    public final Map d;
    public final Pf e;
    public final Pf f;
    public final List g;

    public Zf(ECommerceProduct eCommerceProduct) {
        this(eCommerceProduct.getSku(), eCommerceProduct.getName(), CollectionUtils.arrayListCopyOfNullableCollection(eCommerceProduct.getCategoriesPath()), CollectionUtils.mapCopyOfNullableMap(eCommerceProduct.getPayload()), eCommerceProduct.getActualPrice() == null ? null : new Pf(eCommerceProduct.getActualPrice()), eCommerceProduct.getOriginalPrice() != null ? new Pf(eCommerceProduct.getOriginalPrice()) : null, CollectionUtils.arrayListCopyOfNullableCollection(eCommerceProduct.getPromocodes()));
    }

    public final String toString() {
        return "ProductWrapper{sku='" + this.f759a + "', name='" + this.b + "', categoriesPath=" + this.c + ", payload=" + this.d + ", actualPrice=" + this.e + ", originalPrice=" + this.f + ", promocodes=" + this.g + AbstractJsonLexerKt.END_OBJ;
    }

    public Zf(String str, String str2, List list, Map map, Pf pf, Pf pf2, List list2) {
        this.f759a = str;
        this.b = str2;
        this.c = list;
        this.d = map;
        this.e = pf;
        this.f = pf2;
        this.g = list2;
    }
}
