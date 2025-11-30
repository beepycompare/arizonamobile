package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreutils.internal.collection.CollectionUtils;
import io.appmetrica.analytics.ecommerce.ECommerceScreen;
import java.util.List;
import java.util.Map;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
/* renamed from: io.appmetrica.analytics.impl.dj  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0199dj {

    /* renamed from: a  reason: collision with root package name */
    public final String f854a;
    public final List b;
    public final String c;
    public final Map d;

    public C0199dj(ECommerceScreen eCommerceScreen) {
        this(eCommerceScreen.getName(), eCommerceScreen.getSearchQuery(), CollectionUtils.arrayListCopyOfNullableCollection(eCommerceScreen.getCategoriesPath()), CollectionUtils.mapCopyOfNullableMap(eCommerceScreen.getPayload()));
    }

    public final String toString() {
        return "ScreenWrapper{name='" + this.f854a + "', categoriesPath=" + this.b + ", searchQuery='" + this.c + "', payload=" + this.d + AbstractJsonLexerKt.END_OBJ;
    }

    public C0199dj(String str, String str2, List list, Map map) {
        this.f854a = str;
        this.b = list;
        this.c = str2;
        this.d = map;
    }
}
