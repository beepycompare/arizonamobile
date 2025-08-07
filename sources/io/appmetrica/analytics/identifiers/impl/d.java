package io.appmetrica.analytics.identifiers.impl;

import com.adjust.sdk.Constants;
import java.util.Map;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
/* loaded from: classes4.dex */
public final class d {

    /* renamed from: a  reason: collision with root package name */
    public final Map f315a;

    public d(Map map) {
        this.f315a = map;
    }

    public /* synthetic */ d() {
        this(MapsKt.mapOf(TuplesKt.to(Constants.REFERRER_API_GOOGLE, new h()), TuplesKt.to("huawei", new j()), TuplesKt.to("yandex", new q())));
    }
}
