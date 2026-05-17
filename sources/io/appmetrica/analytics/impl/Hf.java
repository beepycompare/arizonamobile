package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreutils.internal.collection.CollectionUtils;
import io.appmetrica.analytics.ecommerce.ECommerceProduct;
import java.util.List;
import java.util.Map;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
/* loaded from: classes5.dex */
public final class Hf {

    /* renamed from: a  reason: collision with root package name */
    public final String f618a;
    public final String b;
    public final List c;
    public final Map d;
    public final C0752zf e;
    public final C0752zf f;
    public final List g;

    public Hf(ECommerceProduct eCommerceProduct) {
        this(eCommerceProduct.getSku(), eCommerceProduct.getName(), CollectionUtils.arrayListCopyOfNullableCollection(eCommerceProduct.getCategoriesPath()), CollectionUtils.mapCopyOfNullableMap(eCommerceProduct.getPayload()), eCommerceProduct.getActualPrice() == null ? null : new C0752zf(eCommerceProduct.getActualPrice()), eCommerceProduct.getOriginalPrice() != null ? new C0752zf(eCommerceProduct.getOriginalPrice()) : null, CollectionUtils.arrayListCopyOfNullableCollection(eCommerceProduct.getPromocodes()));
    }

    public final String toString() {
        return "ProductWrapper{sku='" + this.f618a + "', name='" + this.b + "', categoriesPath=" + this.c + ", payload=" + this.d + ", actualPrice=" + this.e + ", originalPrice=" + this.f + ", promocodes=" + this.g + AbstractJsonLexerKt.END_OBJ;
    }

    public Hf(String str, String str2, List list, Map map, C0752zf c0752zf, C0752zf c0752zf2, List list2) {
        this.f618a = str;
        this.b = str2;
        this.c = list;
        this.d = map;
        this.e = c0752zf;
        this.f = c0752zf2;
        this.g = list2;
    }
}
