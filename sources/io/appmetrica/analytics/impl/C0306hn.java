package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.modulesapi.internal.client.adrevenue.AdRevenueConstants;
import java.util.HashMap;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
/* renamed from: io.appmetrica.analytics.impl.hn  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0306hn extends Lambda implements Function0 {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ C0331in f918a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0306hn(C0331in c0331in) {
        super(0);
        this.f918a = c0331in;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        HashMap hashMap = new HashMap();
        C0331in c0331in = this.f918a;
        String a2 = c0331in.f940a.a();
        if (a2 != null) {
            String str = (String) hashMap.put(AdRevenueConstants.NATIVE_SUPPORTED_SOURCES_KEY, a2);
        }
        String a3 = c0331in.b.a();
        if (a3 != null) {
            hashMap.put(AdRevenueConstants.PLUGIN_SUPPORTED_SOURCES_KEY, a3);
        }
        return hashMap;
    }
}
