package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.modulesapi.internal.client.adrevenue.AdRevenueConstants;
import java.util.HashMap;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
/* renamed from: io.appmetrica.analytics.impl.en  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0232en extends Lambda implements Function0 {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ C0258fn f985a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0232en(C0258fn c0258fn) {
        super(0);
        this.f985a = c0258fn;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        HashMap hashMap = new HashMap();
        C0258fn c0258fn = this.f985a;
        String a2 = c0258fn.f1001a.a();
        if (a2 != null) {
            String str = (String) hashMap.put(AdRevenueConstants.NATIVE_SUPPORTED_SOURCES_KEY, a2);
        }
        String a3 = c0258fn.b.a();
        if (a3 != null) {
            hashMap.put(AdRevenueConstants.PLUGIN_SUPPORTED_SOURCES_KEY, a3);
        }
        return hashMap;
    }
}
