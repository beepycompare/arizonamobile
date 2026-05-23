package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreutils.internal.collection.CollectionUtils;
import io.appmetrica.analytics.ecommerce.ECommerceScreen;
import java.util.List;
import java.util.Map;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
/* loaded from: classes5.dex */
public final class Dj {

    /* renamed from: a  reason: collision with root package name */
    public final String f514a;
    public final List b;
    public final String c;
    public final Map d;

    public Dj(ECommerceScreen eCommerceScreen) {
        this(eCommerceScreen.getName(), eCommerceScreen.getSearchQuery(), CollectionUtils.arrayListCopyOfNullableCollection(eCommerceScreen.getCategoriesPath()), CollectionUtils.mapCopyOfNullableMap(eCommerceScreen.getPayload()));
    }

    public final String toString() {
        return "ScreenWrapper{name='" + this.f514a + "', categoriesPath=" + this.b + ", searchQuery='" + this.c + "', payload=" + this.d + AbstractJsonLexerKt.END_OBJ;
    }

    public Dj(String str, String str2, List list, Map map) {
        this.f514a = str;
        this.b = list;
        this.c = str2;
        this.d = map;
    }
}
