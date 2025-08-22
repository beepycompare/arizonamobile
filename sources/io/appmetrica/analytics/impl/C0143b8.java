package io.appmetrica.analytics.impl;

import android.content.Context;
import io.appmetrica.analytics.coreapi.internal.servicecomponents.ServiceComponentsInitializer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import kotlin.collections.CollectionsKt;
/* renamed from: io.appmetrica.analytics.impl.b8  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0143b8 implements ServiceComponentsInitializer {

    /* renamed from: a  reason: collision with root package name */
    public final List f791a = CollectionsKt.listOf((Object[]) new String[]{"io.appmetrica.analytics.remotepermissions.internal.RemotePermissionsModuleEntryPoint", "io.appmetrica.analytics.apphud.internal.ApphudServiceModuleEntryPoint", "io.appmetrica.analytics.screenshot.internal.ScreenshotServiceModuleEntryPoint"});

    @Override // io.appmetrica.analytics.coreapi.internal.servicecomponents.ServiceComponentsInitializer
    public final void onCreate(Context context) {
        C0506pd c0506pd = Ka.F.s;
        List<String> list = this.f791a;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        for (String str : list) {
            arrayList.add(new M5(str));
        }
        Object[] array = arrayList.toArray(new M5[0]);
        if (array != null) {
            M5[] m5Arr = (M5[]) array;
            InterfaceC0481od[] interfaceC0481odArr = (InterfaceC0481od[]) Arrays.copyOf(m5Arr, m5Arr.length);
            synchronized (c0506pd) {
                CollectionsKt.addAll(c0506pd.f1011a, interfaceC0481odArr);
            }
            Ka.F.s.a(new C0382kf(context, "io.appmetrica.analytics.modules.ads", "lsm"));
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
    }
}
