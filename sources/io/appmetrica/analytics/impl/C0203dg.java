package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreutils.internal.collection.CollectionUtils;
import io.appmetrica.analytics.ecommerce.ECommerceProduct;
import java.util.List;
import java.util.Map;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
/* renamed from: io.appmetrica.analytics.impl.dg  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0203dg {

    /* renamed from: a  reason: collision with root package name */
    public final String f841a;
    public final String b;
    public final List c;
    public final Map d;
    public final Tf e;
    public final Tf f;
    public final List g;

    public C0203dg(ECommerceProduct eCommerceProduct) {
        this(eCommerceProduct.getSku(), eCommerceProduct.getName(), CollectionUtils.arrayListCopyOfNullableCollection(eCommerceProduct.getCategoriesPath()), CollectionUtils.mapCopyOfNullableMap(eCommerceProduct.getPayload()), eCommerceProduct.getActualPrice() == null ? null : new Tf(eCommerceProduct.getActualPrice()), eCommerceProduct.getOriginalPrice() != null ? new Tf(eCommerceProduct.getOriginalPrice()) : null, CollectionUtils.arrayListCopyOfNullableCollection(eCommerceProduct.getPromocodes()));
    }

    public final String toString() {
        return "ProductWrapper{sku='" + this.f841a + "', name='" + this.b + "', categoriesPath=" + this.c + ", payload=" + this.d + ", actualPrice=" + this.e + ", originalPrice=" + this.f + ", promocodes=" + this.g + AbstractJsonLexerKt.END_OBJ;
    }

    public C0203dg(String str, String str2, List list, Map map, Tf tf, Tf tf2, List list2) {
        this.f841a = str;
        this.b = str2;
        this.c = list;
        this.d = map;
        this.e = tf;
        this.f = tf2;
        this.g = list2;
    }
}
