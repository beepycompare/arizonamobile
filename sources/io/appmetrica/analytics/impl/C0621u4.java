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
/* renamed from: io.appmetrica.analytics.impl.u4  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0621u4 {
    public InterfaceC0122a6 c;

    /* renamed from: a  reason: collision with root package name */
    public final C0596t4 f1067a = new C0596t4();
    public final CopyOnWriteArrayList b = new CopyOnWriteArrayList();
    public final CopyOnWriteArrayList d = new CopyOnWriteArrayList();

    public static void a(String str, String str2, Throwable th) {
        Zj zj = AbstractC0736yj.f1149a;
        Map mapOf = MapsKt.mapOf(TuplesKt.to(str, MapsKt.mapOf(TuplesKt.to(str2, ExceptionsKt.stackTraceToString(th)))));
        zj.getClass();
        zj.a(new Yj("client_module_errors", mapOf));
    }

    public final ModuleAdRevenueProcessor b() {
        C0200d6 c0200d6;
        InterfaceC0122a6 interfaceC0122a6 = this.c;
        if (interfaceC0122a6 == null || (c0200d6 = ((C0273g4) interfaceC0122a6).b) == null) {
            return null;
        }
        return c0200d6.f799a;
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
        CopyOnWriteArrayList copyOnWriteArrayList = this.d;
        CopyOnWriteArrayList copyOnWriteArrayList2 = this.b;
        ArrayList arrayList = new ArrayList();
        Iterator it2 = copyOnWriteArrayList2.iterator();
        while (it2.hasNext()) {
            AdRevenueCollector adRevenueCollector = ((ModuleClientEntryPoint) it2.next()).getAdRevenueCollector();
            if (adRevenueCollector != null) {
                arrayList.add(adRevenueCollector);
            }
        }
        ArrayList arrayList2 = new ArrayList();
        Iterator it3 = arrayList.iterator();
        while (it3.hasNext()) {
            Object next = it3.next();
            if (((AdRevenueCollector) next).getEnabled()) {
                arrayList2.add(next);
            }
        }
        ArrayList arrayList3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList2, 10));
        Iterator it4 = arrayList2.iterator();
        while (it4.hasNext()) {
            arrayList3.add(((AdRevenueCollector) it4.next()).getSourceIdentifier());
        }
        copyOnWriteArrayList.addAll(arrayList3);
    }

    public final List<String> a() {
        return this.d;
    }

    public final void a(ModuleClientEntryPoint<Object> moduleClientEntryPoint) {
        this.b.add(moduleClientEntryPoint);
    }

    public final void a(InterfaceC0122a6 interfaceC0122a6) {
        this.c = interfaceC0122a6;
        HashSet hashSet = new HashSet();
        Iterator it = this.b.iterator();
        while (it.hasNext()) {
            ModuleClientEntryPoint moduleClientEntryPoint = (ModuleClientEntryPoint) it.next();
            try {
                moduleClientEntryPoint.initClientSide(interfaceC0122a6);
            } catch (Throwable th) {
                a(moduleClientEntryPoint.getIdentifier(), "initClientSide", th);
                hashSet.add(moduleClientEntryPoint);
            }
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
                    C0596t4 c0596t4 = this.f1067a;
                    String identifier = moduleClientEntryPoint.getIdentifier();
                    c0596t4.getClass();
                    Bundle bundle2 = bundle.getBundle(identifier);
                    C0571s4 c0571s4 = bundle2 != null ? new C0571s4(sdkIdentifiers, serviceConfigExtensionConfiguration.getBundleConverter().fromBundle(bundle2)) : null;
                    if (c0571s4 != null) {
                        serviceConfigUpdateListener.onServiceConfigUpdated(c0571s4);
                    }
                }
            } catch (Throwable th) {
                a(moduleClientEntryPoint.getIdentifier(), "notifyModulesWithConfig", th);
            }
        }
    }
}
