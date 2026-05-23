package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreutils.internal.collection.CollectionUtils;
import io.appmetrica.analytics.ecommerce.ECommerceProduct;
import java.util.List;
import java.util.Map;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
/* renamed from: io.appmetrica.analytics.impl.ig  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0329ig {

    /* renamed from: a  reason: collision with root package name */
    public final String f1032a;
    public final String b;
    public final List c;
    public final Map d;
    public final C0123ag e;
    public final C0123ag f;
    public final List g;

    public C0329ig(ECommerceProduct eCommerceProduct) {
        this(eCommerceProduct.getSku(), eCommerceProduct.getName(), CollectionUtils.arrayListCopyOfNullableCollection(eCommerceProduct.getCategoriesPath()), CollectionUtils.mapCopyOfNullableMap(eCommerceProduct.getPayload()), eCommerceProduct.getActualPrice() == null ? null : new C0123ag(eCommerceProduct.getActualPrice()), eCommerceProduct.getOriginalPrice() != null ? new C0123ag(eCommerceProduct.getOriginalPrice()) : null, CollectionUtils.arrayListCopyOfNullableCollection(eCommerceProduct.getPromocodes()));
    }

    public final String toString() {
        return "ProductWrapper{sku='" + this.f1032a + "', name='" + this.b + "', categoriesPath=" + this.c + ", payload=" + this.d + ", actualPrice=" + this.e + ", originalPrice=" + this.f + ", promocodes=" + this.g + AbstractJsonLexerKt.END_OBJ;
    }

    public C0329ig(String str, String str2, List list, Map map, C0123ag c0123ag, C0123ag c0123ag2, List list2) {
        this.f1032a = str;
        this.b = str2;
        this.c = list;
        this.d = map;
        this.e = c0123ag;
        this.f = c0123ag2;
        this.g = list2;
    }
}
