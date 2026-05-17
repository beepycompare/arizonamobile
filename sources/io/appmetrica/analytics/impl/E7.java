package io.appmetrica.analytics.impl;

import android.content.Context;
import io.appmetrica.analytics.coreapi.internal.servicecomponents.ServiceComponentsInitializer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import kotlin.collections.CollectionsKt;
/* loaded from: classes5.dex */
public final class E7 implements ServiceComponentsInitializer {

    /* renamed from: a  reason: collision with root package name */
    public final List f568a = CollectionsKt.listOf((Object[]) new String[]{"io.appmetrica.analytics.remotepermissions.internal.RemotePermissionsModuleEntryPoint", "io.appmetrica.analytics.apphud.internal.ApphudServiceModuleEntryPoint", "io.appmetrica.analytics.screenshot.internal.ScreenshotServiceModuleEntryPoint", "io.appmetrica.analytics.billing.internal.BillingServiceModuleEntryPoint", "io.appmetrica.analytics.idsync.internal.IdSyncModuleEntryPoint"});

    @Override // io.appmetrica.analytics.coreapi.internal.servicecomponents.ServiceComponentsInitializer
    public final void onCreate(Context context) {
        Sc sc = C0448na.I.s;
        List<String> list = this.f568a;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        for (String str : list) {
            arrayList.add(new C0518q5(str));
        }
        Object[] array = arrayList.toArray(new C0518q5[0]);
        if (array != null) {
            C0518q5[] c0518q5Arr = (C0518q5[]) array;
            Rc[] rcArr = (Rc[]) Arrays.copyOf(c0518q5Arr, c0518q5Arr.length);
            synchronized (sc) {
                CollectionsKt.addAll(sc.f785a, rcArr);
            }
            C0448na.I.s.a(new Ue(context, "io.appmetrica.analytics.modules.ads", "lsm"));
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
    }
}
