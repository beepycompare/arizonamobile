package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreutils.internal.collection.CollectionUtils;
import io.appmetrica.analytics.ecommerce.ECommerceProduct;
import java.util.List;
import java.util.Map;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
/* loaded from: classes4.dex */
public final class Sf {

    /* renamed from: a  reason: collision with root package name */
    public final String f626a;
    public final String b;
    public final List c;
    public final Map d;
    public final Lf e;
    public final Lf f;
    public final List g;

    public Sf(ECommerceProduct eCommerceProduct) {
        this(eCommerceProduct.getSku(), eCommerceProduct.getName(), CollectionUtils.arrayListCopyOfNullableCollection(eCommerceProduct.getCategoriesPath()), CollectionUtils.mapCopyOfNullableMap(eCommerceProduct.getPayload()), eCommerceProduct.getActualPrice() == null ? null : new Lf(eCommerceProduct.getActualPrice()), eCommerceProduct.getOriginalPrice() != null ? new Lf(eCommerceProduct.getOriginalPrice()) : null, CollectionUtils.arrayListCopyOfNullableCollection(eCommerceProduct.getPromocodes()));
    }

    public final String toString() {
        return "ProductWrapper{sku='" + this.f626a + "', name='" + this.b + "', categoriesPath=" + this.c + ", payload=" + this.d + ", actualPrice=" + this.e + ", originalPrice=" + this.f + ", promocodes=" + this.g + AbstractJsonLexerKt.END_OBJ;
    }

    public Sf(String str, String str2, List list, Map map, Lf lf, Lf lf2, List list2) {
        this.f626a = str;
        this.b = str2;
        this.c = list;
        this.d = map;
        this.e = lf;
        this.f = lf2;
        this.g = list2;
    }
}
