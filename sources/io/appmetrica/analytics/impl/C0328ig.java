package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreutils.internal.collection.CollectionUtils;
import io.appmetrica.analytics.ecommerce.ECommerceProduct;
import java.util.List;
import java.util.Map;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
/* renamed from: io.appmetrica.analytics.impl.ig  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0328ig {

    /* renamed from: a  reason: collision with root package name */
    public final String f1035a;
    public final String b;
    public final List c;
    public final Map d;
    public final C0122ag e;
    public final C0122ag f;
    public final List g;

    public C0328ig(ECommerceProduct eCommerceProduct) {
        this(eCommerceProduct.getSku(), eCommerceProduct.getName(), CollectionUtils.arrayListCopyOfNullableCollection(eCommerceProduct.getCategoriesPath()), CollectionUtils.mapCopyOfNullableMap(eCommerceProduct.getPayload()), eCommerceProduct.getActualPrice() == null ? null : new C0122ag(eCommerceProduct.getActualPrice()), eCommerceProduct.getOriginalPrice() != null ? new C0122ag(eCommerceProduct.getOriginalPrice()) : null, CollectionUtils.arrayListCopyOfNullableCollection(eCommerceProduct.getPromocodes()));
    }

    public final String toString() {
        return "ProductWrapper{sku='" + this.f1035a + "', name='" + this.b + "', categoriesPath=" + this.c + ", payload=" + this.d + ", actualPrice=" + this.e + ", originalPrice=" + this.f + ", promocodes=" + this.g + AbstractJsonLexerKt.END_OBJ;
    }

    public C0328ig(String str, String str2, List list, Map map, C0122ag c0122ag, C0122ag c0122ag2, List list2) {
        this.f1035a = str;
        this.b = str2;
        this.c = list;
        this.d = map;
        this.e = c0122ag;
        this.f = c0122ag2;
        this.g = list2;
    }
}
