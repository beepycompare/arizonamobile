package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreutils.internal.collection.CollectionUtils;
import io.appmetrica.analytics.ecommerce.ECommerceScreen;
import java.util.List;
import java.util.Map;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
/* renamed from: io.appmetrica.analytics.impl.pj  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0515pj {

    /* renamed from: a  reason: collision with root package name */
    public final String f1004a;
    public final List b;
    public final String c;
    public final Map d;

    public C0515pj(ECommerceScreen eCommerceScreen) {
        this(eCommerceScreen.getName(), eCommerceScreen.getSearchQuery(), CollectionUtils.arrayListCopyOfNullableCollection(eCommerceScreen.getCategoriesPath()), CollectionUtils.mapCopyOfNullableMap(eCommerceScreen.getPayload()));
    }

    public final String toString() {
        return "ScreenWrapper{name='" + this.f1004a + "', categoriesPath=" + this.b + ", searchQuery='" + this.c + "', payload=" + this.d + AbstractJsonLexerKt.END_OBJ;
    }

    public C0515pj(String str, String str2, List list, Map map) {
        this.f1004a = str;
        this.b = list;
        this.c = str2;
        this.d = map;
    }
}
