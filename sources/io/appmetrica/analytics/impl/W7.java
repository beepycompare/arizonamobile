package io.appmetrica.analytics.impl;

import android.content.Context;
import io.appmetrica.analytics.coreapi.internal.servicecomponents.ServiceComponentsInitializer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import kotlin.collections.CollectionsKt;
/* loaded from: classes5.dex */
public final class W7 implements ServiceComponentsInitializer {

    /* renamed from: a  reason: collision with root package name */
    public final List f820a = CollectionsKt.listOf((Object[]) new String[]{"io.appmetrica.analytics.remotepermissions.internal.RemotePermissionsModuleEntryPoint", "io.appmetrica.analytics.apphud.internal.ApphudServiceModuleEntryPoint", "io.appmetrica.analytics.adrevenue.other.internal.AdRevenueOtherServiceModuleEntryPoint", "io.appmetrica.analytics.screenshot.internal.ScreenshotServiceModuleEntryPoint", "io.appmetrica.analytics.billing.internal.BillingServiceModuleEntryPoint", "io.appmetrica.analytics.idsync.internal.IdSyncModuleEntryPoint"});

    @Override // io.appmetrica.analytics.coreapi.internal.servicecomponents.ServiceComponentsInitializer
    public final void onCreate(Context context) {
        C0585sd c0585sd = Na.I.s;
        List<String> list = this.f820a;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        for (String str : list) {
            arrayList.add(new G5(str));
        }
        G5[] g5Arr = (G5[]) arrayList.toArray(new G5[0]);
        G5[] g5Arr2 = (G5[]) Arrays.copyOf(g5Arr, g5Arr.length);
        synchronized (c0585sd) {
            CollectionsKt.addAll(c0585sd.f1196a, g5Arr2);
        }
    }
}
