package io.appmetrica.analytics.impl;

import android.content.Context;
import io.appmetrica.analytics.coreapi.internal.servicecomponents.ServiceComponentsInitializer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import kotlin.collections.CollectionsKt;
/* loaded from: classes3.dex */
public final class M7 implements ServiceComponentsInitializer {

    /* renamed from: a  reason: collision with root package name */
    public final List f587a = CollectionsKt.listOf((Object[]) new String[]{"io.appmetrica.analytics.remotepermissions.internal.RemotePermissionsModuleEntryPoint", "io.appmetrica.analytics.apphud.internal.ApphudServiceModuleEntryPoint", "io.appmetrica.analytics.screenshot.internal.ScreenshotServiceModuleEntryPoint", "io.appmetrica.analytics.billing.internal.BillingServiceModuleEntryPoint", "io.appmetrica.analytics.idsync.internal.IdSyncModuleEntryPoint"});

    @Override // io.appmetrica.analytics.coreapi.internal.servicecomponents.ServiceComponentsInitializer
    public final void onCreate(Context context) {
        Zc zc = C0620ua.H.s;
        List<String> list = this.f587a;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        for (String str : list) {
            arrayList.add(new C0690x5(str));
        }
        Object[] array = arrayList.toArray(new C0690x5[0]);
        if (array != null) {
            C0690x5[] c0690x5Arr = (C0690x5[]) array;
            Yc[] ycArr = (Yc[]) Arrays.copyOf(c0690x5Arr, c0690x5Arr.length);
            synchronized (zc) {
                CollectionsKt.addAll(zc.f784a, ycArr);
            }
            C0620ua.H.s.a(new Ze(context, "io.appmetrica.analytics.modules.ads", "lsm"));
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
    }
}
