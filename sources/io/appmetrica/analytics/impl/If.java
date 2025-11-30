package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreutils.internal.collection.CollectionUtils;
import io.appmetrica.analytics.ecommerce.ECommerceProduct;
import java.util.List;
import java.util.Map;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
/* loaded from: classes5.dex */
public final class If {

    /* renamed from: a  reason: collision with root package name */
    public final String f524a;
    public final String b;
    public final List c;
    public final Map d;
    public final Af e;
    public final Af f;
    public final List g;

    public If(ECommerceProduct eCommerceProduct) {
        this(eCommerceProduct.getSku(), eCommerceProduct.getName(), CollectionUtils.arrayListCopyOfNullableCollection(eCommerceProduct.getCategoriesPath()), CollectionUtils.mapCopyOfNullableMap(eCommerceProduct.getPayload()), eCommerceProduct.getActualPrice() == null ? null : new Af(eCommerceProduct.getActualPrice()), eCommerceProduct.getOriginalPrice() != null ? new Af(eCommerceProduct.getOriginalPrice()) : null, CollectionUtils.arrayListCopyOfNullableCollection(eCommerceProduct.getPromocodes()));
    }

    public final String toString() {
        return "ProductWrapper{sku='" + this.f524a + "', name='" + this.b + "', categoriesPath=" + this.c + ", payload=" + this.d + ", actualPrice=" + this.e + ", originalPrice=" + this.f + ", promocodes=" + this.g + AbstractJsonLexerKt.END_OBJ;
    }

    public If(String str, String str2, List list, Map map, Af af, Af af2, List list2) {
        this.f524a = str;
        this.b = str2;
        this.c = list;
        this.d = map;
        this.e = af;
        this.f = af2;
        this.g = list2;
    }
}
