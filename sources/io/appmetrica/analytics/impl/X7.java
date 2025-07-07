package io.appmetrica.analytics.impl;

import android.content.Context;
import io.appmetrica.analytics.coreapi.internal.servicecomponents.ServiceComponentsInitializer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import kotlin.collections.CollectionsKt;
/* loaded from: classes4.dex */
public final class X7 implements ServiceComponentsInitializer {

    /* renamed from: a  reason: collision with root package name */
    public final List f701a = CollectionsKt.listOf((Object[]) new String[]{"io.appmetrica.analytics.remotepermissions.internal.RemotePermissionsModuleEntryPoint", "io.appmetrica.analytics.apphud.internal.ApphudServiceModuleEntryPoint", "io.appmetrica.analytics.screenshot.internal.ScreenshotServiceModuleEntryPoint"});

    @Override // io.appmetrica.analytics.coreapi.internal.servicecomponents.ServiceComponentsInitializer
    public final void onCreate(Context context) {
        C0414ld c0414ld = Ga.F.s;
        List<String> list = this.f701a;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        for (String str : list) {
            arrayList.add(new J5(str));
        }
        Object[] array = arrayList.toArray(new J5[0]);
        if (array != null) {
            J5[] j5Arr = (J5[]) array;
            InterfaceC0389kd[] interfaceC0389kdArr = (InterfaceC0389kd[]) Arrays.copyOf(j5Arr, j5Arr.length);
            synchronized (c0414ld) {
                CollectionsKt.addAll(c0414ld.f921a, interfaceC0389kdArr);
            }
            Ga.F.s.a(new C0292gf(context, "io.appmetrica.analytics.modules.ads", "lsm"));
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
    }
}
