package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.modulesapi.internal.client.adrevenue.AdRevenueConstants;
import java.util.HashMap;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
/* loaded from: classes5.dex */
public final class Fn extends Lambda implements Function0 {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Gn f552a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Fn(Gn gn) {
        super(0);
        this.f552a = gn;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        HashMap hashMap = new HashMap();
        Gn gn = this.f552a;
        String a2 = gn.f567a.a();
        if (a2 != null) {
            String str = (String) hashMap.put(AdRevenueConstants.NATIVE_SUPPORTED_SOURCES_KEY, a2);
        }
        String a3 = gn.b.a();
        if (a3 != null) {
            hashMap.put(AdRevenueConstants.PLUGIN_SUPPORTED_SOURCES_KEY, a3);
        }
        return hashMap;
    }
}
