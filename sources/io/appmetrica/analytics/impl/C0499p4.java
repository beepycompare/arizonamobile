package io.appmetrica.analytics.impl;

import android.os.Bundle;
import io.appmetrica.analytics.coreapi.internal.identifiers.SdkIdentifiers;
import io.appmetrica.analytics.modulesapi.internal.client.ModuleClientEntryPoint;
import io.appmetrica.analytics.modulesapi.internal.client.ServiceConfigExtensionConfiguration;
import io.appmetrica.analytics.modulesapi.internal.client.ServiceConfigUpdateListener;
import io.appmetrica.analytics.modulesapi.internal.client.adrevenue.AdRevenueCollector;
import io.appmetrica.analytics.modulesapi.internal.client.adrevenue.ModuleAdRevenueProcessor;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.ExceptionsKt;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
/* renamed from: io.appmetrica.analytics.impl.p4  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0499p4 {

    /* renamed from: a  reason: collision with root package name */
    public final C0473o4 f1141a = new C0473o4();
    public final CopyOnWriteArrayList b = new CopyOnWriteArrayList();
    public X5 c;

    public static void a(String str, String str2, Throwable th) {
        C0541qk c0541qk = Oj.f706a;
        Map mapOf = MapsKt.mapOf(TuplesKt.to(str, MapsKt.mapOf(TuplesKt.to(str2, ExceptionsKt.stackTraceToString(th)))));
        c0541qk.getClass();
        c0541qk.a(new C0515pk("client_module_errors", mapOf));
    }

    public final ModuleAdRevenueProcessor b() {
        C0113a6 c0113a6;
        X5 x5 = this.c;
        if (x5 == null || (c0113a6 = ((C0137b4) x5).b) == null) {
            return null;
        }
        return c0113a6.f882a;
    }

    public final void c() {
        Iterator it = this.b.iterator();
        while (it.hasNext()) {
            ModuleClientEntryPoint moduleClientEntryPoint = (ModuleClientEntryPoint) it.next();
            try {
                moduleClientEntryPoint.onActivated();
            } catch (Throwable th) {
                a(moduleClientEntryPoint.getIdentifier(), "onActivated", th);
            }
        }
    }

    public final List<String> a() {
        CopyOnWriteArrayList<ModuleClientEntryPoint> copyOnWriteArrayList = this.b;
        ArrayList arrayList = new ArrayList();
        for (ModuleClientEntryPoint moduleClientEntryPoint : copyOnWriteArrayList) {
            AdRevenueCollector adRevenueCollector = moduleClientEntryPoint.getAdRevenueCollector();
            if (adRevenueCollector != null) {
                arrayList.add(adRevenueCollector);
            }
        }
        ArrayList<AdRevenueCollector> arrayList2 = new ArrayList();
        for (Object obj : arrayList) {
            if (((AdRevenueCollector) obj).getEnabled()) {
                arrayList2.add(obj);
            }
        }
        ArrayList arrayList3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList2, 10));
        for (AdRevenueCollector adRevenueCollector2 : arrayList2) {
            arrayList3.add(adRevenueCollector2.getSourceIdentifier());
        }
        return CollectionsKt.distinct(arrayList3);
    }

    public final void a(ModuleClientEntryPoint<Object> moduleClientEntryPoint) {
        this.b.add(moduleClientEntryPoint);
    }

    public final void a(X5 x5) {
        this.c = x5;
        HashSet hashSet = new HashSet();
        Iterator it = this.b.iterator();
        while (it.hasNext()) {
            ModuleClientEntryPoint moduleClientEntryPoint = (ModuleClientEntryPoint) it.next();
            try {
                moduleClientEntryPoint.initClientSide(x5);
            } catch (Throwable th) {
                a(moduleClientEntryPoint.getIdentifier(), "initClientSide", th);
                hashSet.add(moduleClientEntryPoint);
            }
        }
        if (hashSet.isEmpty()) {
            return;
        }
        this.b.removeAll(hashSet);
    }

    public final void a(Bundle bundle, SdkIdentifiers sdkIdentifiers) {
        if (bundle == null) {
            return;
        }
        Iterator it = this.b.iterator();
        while (it.hasNext()) {
            ModuleClientEntryPoint moduleClientEntryPoint = (ModuleClientEntryPoint) it.next();
            try {
                ServiceConfigExtensionConfiguration serviceConfigExtensionConfiguration = moduleClientEntryPoint.getServiceConfigExtensionConfiguration();
                if (serviceConfigExtensionConfiguration != null) {
                    ServiceConfigUpdateListener serviceConfigUpdateListener = serviceConfigExtensionConfiguration.getServiceConfigUpdateListener();
                    C0473o4 c0473o4 = this.f1141a;
                    String identifier = moduleClientEntryPoint.getIdentifier();
                    c0473o4.getClass();
                    Bundle bundle2 = bundle.getBundle(identifier);
                    C0447n4 c0447n4 = bundle2 != null ? new C0447n4(sdkIdentifiers, serviceConfigExtensionConfiguration.getBundleConverter().fromBundle(bundle2)) : null;
                    if (c0447n4 != null) {
                        serviceConfigUpdateListener.onServiceConfigUpdated(c0447n4);
                    }
                }
            } catch (Throwable th) {
                a(moduleClientEntryPoint.getIdentifier(), "notifyModulesWithConfig", th);
            }
        }
    }
}
