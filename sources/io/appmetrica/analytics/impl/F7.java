package io.appmetrica.analytics.impl;

import android.content.Context;
import io.appmetrica.analytics.coreapi.internal.servicecomponents.ServiceComponentsInitializer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import kotlin.collections.CollectionsKt;
/* loaded from: classes5.dex */
public final class F7 implements ServiceComponentsInitializer {

    /* renamed from: a  reason: collision with root package name */
    public final List f572a = CollectionsKt.listOf((Object[]) new String[]{"io.appmetrica.analytics.remotepermissions.internal.RemotePermissionsModuleEntryPoint", "io.appmetrica.analytics.apphud.internal.ApphudServiceModuleEntryPoint", "io.appmetrica.analytics.screenshot.internal.ScreenshotServiceModuleEntryPoint", "io.appmetrica.analytics.billing.internal.BillingServiceModuleEntryPoint", "io.appmetrica.analytics.idsync.internal.IdSyncModuleEntryPoint"});

    @Override // io.appmetrica.analytics.coreapi.internal.servicecomponents.ServiceComponentsInitializer
    public final void onCreate(Context context) {
        Tc tc = C0470oa.I.s;
        List<String> list = this.f572a;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        for (String str : list) {
            arrayList.add(new C0539r5(str));
        }
        Object[] array = arrayList.toArray(new C0539r5[0]);
        if (array != null) {
            C0539r5[] c0539r5Arr = (C0539r5[]) array;
            Sc[] scArr = (Sc[]) Arrays.copyOf(c0539r5Arr, c0539r5Arr.length);
            synchronized (tc) {
                CollectionsKt.addAll(tc.f789a, scArr);
            }
            C0470oa.I.s.a(new Ve(context, "io.appmetrica.analytics.modules.ads", "lsm"));
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
    }
}
