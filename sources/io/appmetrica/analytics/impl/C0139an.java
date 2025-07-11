package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.modulesapi.internal.client.adrevenue.AdRevenueConstants;
import java.util.HashMap;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
/* renamed from: io.appmetrica.analytics.impl.an  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0139an extends Lambda implements Function0 {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ C0165bn f759a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0139an(C0165bn c0165bn) {
        super(0);
        this.f759a = c0165bn;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        HashMap hashMap = new HashMap();
        C0165bn c0165bn = this.f759a;
        String a2 = c0165bn.f774a.a();
        if (a2 != null) {
            String str = (String) hashMap.put(AdRevenueConstants.NATIVE_SUPPORTED_SOURCES_KEY, a2);
        }
        String a3 = c0165bn.b.a();
        if (a3 != null) {
            hashMap.put(AdRevenueConstants.PLUGIN_SUPPORTED_SOURCES_KEY, a3);
        }
        return hashMap;
    }
}
