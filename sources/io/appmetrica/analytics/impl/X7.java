package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.clientcomponents.ClientComponentsInitializer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import kotlin.collections.CollectionsKt;
/* loaded from: classes4.dex */
public final class X7 implements ClientComponentsInitializer {

    /* renamed from: a  reason: collision with root package name */
    public final List f714a = CollectionsKt.listOf((Object[]) new String[]{"io.appmetrica.analytics.adrevenue.admob.v23.internal.AdMobClientModuleEntryPoint", "io.appmetrica.analytics.adrevenue.applovin.v12.internal.AppLovinClientModuleEntryPoint", "io.appmetrica.analytics.adrevenue.fyber.v3.internal.FyberClientModuleEntryPoint", "io.appmetrica.analytics.adrevenue.ironsource.v7.internal.IronSourceClientModuleEntryPoint", "io.appmetrica.analytics.apphud.internal.ApphudClientModuleEntryPoint", "io.appmetrica.analytics.screenshot.internal.ScreenshotClientModuleEntryPoint", "io.appmetrica.analytics.reporterextension.internal.ReporterExtensionClientModuleEntryPoint"});

    @Override // io.appmetrica.analytics.coreapi.internal.clientcomponents.ClientComponentsInitializer
    public final void onCreate() {
        if (C0699x4.l().f1129a.c()) {
            C0459nd c0459nd = C0699x4.l().m;
            List<String> list = this.f714a;
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
            for (String str : list) {
                arrayList.add(new M5(str));
            }
            Object[] array = arrayList.toArray(new M5[0]);
            if (array != null) {
                M5[] m5Arr = (M5[]) array;
                InterfaceC0434md[] interfaceC0434mdArr = (InterfaceC0434md[]) Arrays.copyOf(m5Arr, m5Arr.length);
                synchronized (c0459nd) {
                    CollectionsKt.addAll(c0459nd.f968a, interfaceC0434mdArr);
                }
                return;
            }
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        }
    }
}
