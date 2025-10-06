package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.modulesapi.internal.client.adrevenue.AdRevenueConstants;
import java.util.HashMap;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
/* renamed from: io.appmetrica.analytics.impl.mn  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0443mn extends Lambda implements Function0 {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ C0469nn f997a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0443mn(C0469nn c0469nn) {
        super(0);
        this.f997a = c0469nn;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        HashMap hashMap = new HashMap();
        C0469nn c0469nn = this.f997a;
        String a2 = c0469nn.f1010a.a();
        if (a2 != null) {
            String str = (String) hashMap.put(AdRevenueConstants.NATIVE_SUPPORTED_SOURCES_KEY, a2);
        }
        String a3 = c0469nn.b.a();
        if (a3 != null) {
            hashMap.put(AdRevenueConstants.PLUGIN_SUPPORTED_SOURCES_KEY, a3);
        }
        return hashMap;
    }
}
