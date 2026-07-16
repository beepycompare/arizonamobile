package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.clientcomponents.ClientComponentsInitializer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import kotlin.collections.CollectionsKt;
/* loaded from: classes5.dex */
public final class T7 implements ClientComponentsInitializer {

    /* renamed from: a  reason: collision with root package name */
    public final List f775a = CollectionsKt.listOf((Object[]) new String[]{"io.appmetrica.analytics.adrevenue.admob.v23.internal.AdMobClientModuleEntryPoint", "io.appmetrica.analytics.adrevenue.applovin.v12.internal.AppLovinClientModuleEntryPoint", "io.appmetrica.analytics.adrevenue.fyber.v3.internal.FyberClientModuleEntryPoint", "io.appmetrica.analytics.adrevenue.ironsource.v7.internal.IronSourceClientModuleEntryPoint", "io.appmetrica.analytics.adrevenue.ironsource.v9.internal.IronSourceV9ClientModuleEntryPoint", "io.appmetrica.analytics.adrevenue.other.internal.AdRevenueOtherClientModuleEntryPoint", "io.appmetrica.analytics.apphud.internal.ApphudClientModuleEntryPoint", "io.appmetrica.analytics.screenshot.internal.ScreenshotClientModuleEntryPoint", "io.appmetrica.analytics.reporterextension.internal.ReporterExtensionClientModuleEntryPoint"});

    @Override // io.appmetrica.analytics.coreapi.internal.clientcomponents.ClientComponentsInitializer
    public final void onCreate() {
        if (C0576s4.l().f1194a.b()) {
            C0585sd c0585sd = C0576s4.l().m;
            List<String> list = this.f775a;
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
            for (String str : list) {
                arrayList.add(new G5(str));
            }
            G5[] g5Arr = (G5[]) arrayList.toArray(new G5[0]);
            G5[] g5Arr2 = (G5[]) Arrays.copyOf(g5Arr, g5Arr.length);
            synchronized (c0585sd) {
                CollectionsKt.addAll(c0585sd.f1199a, g5Arr2);
            }
        }
    }
}
