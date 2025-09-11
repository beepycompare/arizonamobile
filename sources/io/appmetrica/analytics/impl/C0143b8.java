package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.clientcomponents.ClientComponentsInitializer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import kotlin.collections.CollectionsKt;
/* renamed from: io.appmetrica.analytics.impl.b8  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0143b8 implements ClientComponentsInitializer {

    /* renamed from: a  reason: collision with root package name */
    public final List f806a = CollectionsKt.listOf((Object[]) new String[]{"io.appmetrica.analytics.adrevenue.admob.v23.internal.AdMobClientModuleEntryPoint", "io.appmetrica.analytics.adrevenue.applovin.v12.internal.AppLovinClientModuleEntryPoint", "io.appmetrica.analytics.adrevenue.fyber.v3.internal.FyberClientModuleEntryPoint", "io.appmetrica.analytics.adrevenue.ironsource.v7.internal.IronSourceClientModuleEntryPoint", "io.appmetrica.analytics.apphud.internal.ApphudClientModuleEntryPoint", "io.appmetrica.analytics.screenshot.internal.ScreenshotClientModuleEntryPoint", "io.appmetrica.analytics.reporterextension.internal.ReporterExtensionClientModuleEntryPoint"});

    @Override // io.appmetrica.analytics.coreapi.internal.clientcomponents.ClientComponentsInitializer
    public final void onCreate() {
        if (A4.l().f343a.b()) {
            C0584sd c0584sd = A4.l().m;
            List<String> list = this.f806a;
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
            for (String str : list) {
                arrayList.add(new P5(str));
            }
            Object[] array = arrayList.toArray(new P5[0]);
            if (array != null) {
                P5[] p5Arr = (P5[]) array;
                InterfaceC0559rd[] interfaceC0559rdArr = (InterfaceC0559rd[]) Arrays.copyOf(p5Arr, p5Arr.length);
                synchronized (c0584sd) {
                    CollectionsKt.addAll(c0584sd.f1081a, interfaceC0559rdArr);
                }
                return;
            }
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        }
    }
}
