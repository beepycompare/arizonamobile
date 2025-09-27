package io.appmetrica.analytics.impl;

import android.content.Context;
import io.appmetrica.analytics.coreapi.internal.servicecomponents.ServiceComponentsInitializer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import kotlin.collections.CollectionsKt;
/* renamed from: io.appmetrica.analytics.impl.e8  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0220e8 implements ServiceComponentsInitializer {

    /* renamed from: a  reason: collision with root package name */
    public final List f858a = CollectionsKt.listOf((Object[]) new String[]{"io.appmetrica.analytics.remotepermissions.internal.RemotePermissionsModuleEntryPoint", "io.appmetrica.analytics.apphud.internal.ApphudServiceModuleEntryPoint", "io.appmetrica.analytics.screenshot.internal.ScreenshotServiceModuleEntryPoint"});

    @Override // io.appmetrica.analytics.coreapi.internal.servicecomponents.ServiceComponentsInitializer
    public final void onCreate(Context context) {
        C0584sd c0584sd = Na.F.s;
        List<String> list = this.f858a;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        for (String str : list) {
            arrayList.add(new P5(str));
        }
        Object[] array = arrayList.toArray(new P5[0]);
        if (array != null) {
            P5[] p5Arr = (P5[]) array;
            InterfaceC0559rd[] interfaceC0559rdArr = (InterfaceC0559rd[]) Arrays.copyOf(p5Arr, p5Arr.length);
            synchronized (c0584sd) {
                CollectionsKt.addAll(c0584sd.f1082a, interfaceC0559rdArr);
            }
            Na.F.s.a(new C0486of(context, "io.appmetrica.analytics.modules.ads", "lsm"));
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
    }
}
