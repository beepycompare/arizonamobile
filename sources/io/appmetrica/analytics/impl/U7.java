package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.clientcomponents.ClientComponentsInitializer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import kotlin.collections.CollectionsKt;
/* loaded from: classes4.dex */
public final class U7 implements ClientComponentsInitializer {

    /* renamed from: a  reason: collision with root package name */
    public final List f655a = CollectionsKt.listOf((Object[]) new String[]{"io.appmetrica.analytics.adrevenue.admob.v23.internal.AdMobClientModuleEntryPoint", "io.appmetrica.analytics.adrevenue.applovin.v12.internal.AppLovinClientModuleEntryPoint", "io.appmetrica.analytics.adrevenue.fyber.v3.internal.FyberClientModuleEntryPoint", "io.appmetrica.analytics.adrevenue.ironsource.v7.internal.IronSourceClientModuleEntryPoint", "io.appmetrica.analytics.apphud.internal.ApphudClientModuleEntryPoint", "io.appmetrica.analytics.screenshot.internal.ScreenshotClientModuleEntryPoint", "io.appmetrica.analytics.reporterextension.internal.ReporterExtensionClientModuleEntryPoint"});

    @Override // io.appmetrica.analytics.coreapi.internal.clientcomponents.ClientComponentsInitializer
    public final void onCreate() {
        if (C0696x4.l().f1117a.c()) {
            C0406ld c0406ld = C0696x4.l().m;
            List<String> list = this.f655a;
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
            for (String str : list) {
                arrayList.add(new J5(str));
            }
            Object[] array = arrayList.toArray(new J5[0]);
            if (array != null) {
                J5[] j5Arr = (J5[]) array;
                InterfaceC0381kd[] interfaceC0381kdArr = (InterfaceC0381kd[]) Arrays.copyOf(j5Arr, j5Arr.length);
                synchronized (c0406ld) {
                    CollectionsKt.addAll(c0406ld.f922a, interfaceC0381kdArr);
                }
                return;
            }
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        }
    }
}
