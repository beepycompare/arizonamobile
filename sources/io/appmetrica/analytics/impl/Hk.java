package io.appmetrica.analytics.impl;

import android.location.Location;
import android.os.Bundle;
import io.appmetrica.analytics.coreapi.internal.backport.Consumer;
import io.appmetrica.analytics.coreapi.internal.control.Toggle;
import io.appmetrica.analytics.coreapi.internal.identifiers.SdkIdentifiers;
import io.appmetrica.analytics.coreapi.internal.permission.PermissionStrategy;
import io.appmetrica.analytics.modulesapi.internal.common.AskForPermissionStrategyModuleProvider;
import io.appmetrica.analytics.modulesapi.internal.service.ClientConfigProvider;
import io.appmetrica.analytics.modulesapi.internal.service.LocationServiceExtension;
import io.appmetrica.analytics.modulesapi.internal.service.ModuleLocationSourcesServiceController;
import io.appmetrica.analytics.modulesapi.internal.service.ModuleServiceEntryPoint;
import io.appmetrica.analytics.modulesapi.internal.service.ModuleServicesDatabase;
import io.appmetrica.analytics.modulesapi.internal.service.RemoteConfigExtensionConfiguration;
import io.appmetrica.analytics.modulesapi.internal.service.ServiceContext;
import io.appmetrica.analytics.modulesapi.internal.service.event.ModuleEventServiceHandlerFactory;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.ExceptionsKt;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes4.dex */
public final class Hk implements InterfaceC0511pd, InterfaceC0619tm, AskForPermissionStrategyModuleProvider {

    /* renamed from: a  reason: collision with root package name */
    public final String f483a = "rp";
    public final CopyOnWriteArrayList b = new CopyOnWriteArrayList();
    public volatile AskForPermissionStrategyModuleProvider c = new C0118a8();

    @Override // io.appmetrica.analytics.impl.InterfaceC0619tm
    public final void a(C0494om c0494om) {
        SdkIdentifiers sdkIdentifiers = new SdkIdentifiers(c0494om.e(), c0494om.a(), c0494om.b());
        C0282gh c0282gh = new C0282gh(c0494om.c(), c0494om.d());
        for (ModuleServiceEntryPoint moduleServiceEntryPoint : this.b) {
            RemoteConfigExtensionConfiguration remoteConfigExtensionConfiguration = moduleServiceEntryPoint.getRemoteConfigExtensionConfiguration();
            if (remoteConfigExtensionConfiguration != null) {
                remoteConfigExtensionConfiguration.getRemoteConfigUpdateListener().onRemoteConfigUpdated(new Gk(sdkIdentifiers, c0282gh, c0494om.B.get(moduleServiceEntryPoint.getIdentifier())));
            }
        }
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0511pd
    public final List<ModuleServicesDatabase> b() {
        Object obj;
        HashSet hashSet = new HashSet();
        ArrayList arrayList = new ArrayList();
        CopyOnWriteArrayList copyOnWriteArrayList = this.b;
        ArrayList arrayList2 = new ArrayList();
        Iterator it = copyOnWriteArrayList.iterator();
        while (it.hasNext()) {
            ModuleServiceEntryPoint moduleServiceEntryPoint = (ModuleServiceEntryPoint) it.next();
            try {
                ModuleServicesDatabase moduleServicesDatabase = moduleServiceEntryPoint.getModuleServicesDatabase();
                obj = moduleServicesDatabase != null ? Boolean.valueOf(arrayList.add(moduleServicesDatabase)) : null;
            } catch (Throwable th) {
                hashSet.add(moduleServiceEntryPoint);
                String identifier = moduleServiceEntryPoint.getIdentifier();
                C0414lk c0414lk = Kj.f543a;
                Map mapOf = MapsKt.mapOf(TuplesKt.to(identifier, MapsKt.mapOf(TuplesKt.to("db", ExceptionsKt.stackTraceToString(th)))));
                c0414lk.getClass();
                c0414lk.a(new C0388kk("service_module_errors", mapOf));
                obj = Unit.INSTANCE;
            }
            if (obj != null) {
                arrayList2.add(obj);
            }
        }
        this.b.removeAll(hashSet);
        return arrayList;
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0511pd
    public final Map<String, C0735yd> c() {
        CopyOnWriteArrayList<ModuleServiceEntryPoint> copyOnWriteArrayList = this.b;
        ArrayList arrayList = new ArrayList();
        for (ModuleServiceEntryPoint moduleServiceEntryPoint : copyOnWriteArrayList) {
            RemoteConfigExtensionConfiguration remoteConfigExtensionConfiguration = moduleServiceEntryPoint.getRemoteConfigExtensionConfiguration();
            Pair pair = remoteConfigExtensionConfiguration != null ? TuplesKt.to(moduleServiceEntryPoint.getIdentifier(), new C0735yd(remoteConfigExtensionConfiguration)) : null;
            if (pair != null) {
                arrayList.add(pair);
            }
        }
        return MapsKt.toMap(arrayList);
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0511pd
    public final Map<String, Integer> d() {
        List emptyList;
        Map<String, Integer> blocks;
        CopyOnWriteArrayList<ModuleServiceEntryPoint> copyOnWriteArrayList = this.b;
        ArrayList arrayList = new ArrayList();
        for (ModuleServiceEntryPoint moduleServiceEntryPoint : copyOnWriteArrayList) {
            RemoteConfigExtensionConfiguration remoteConfigExtensionConfiguration = moduleServiceEntryPoint.getRemoteConfigExtensionConfiguration();
            if (remoteConfigExtensionConfiguration == null || (blocks = remoteConfigExtensionConfiguration.getBlocks()) == null || (emptyList = MapsKt.toList(blocks)) == null) {
                emptyList = CollectionsKt.emptyList();
            }
            CollectionsKt.addAll(arrayList, emptyList);
        }
        return MapsKt.toMap(arrayList);
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0511pd
    public final List<Consumer<Location>> e() {
        CopyOnWriteArrayList<ModuleServiceEntryPoint> copyOnWriteArrayList = this.b;
        ArrayList arrayList = new ArrayList();
        for (ModuleServiceEntryPoint moduleServiceEntryPoint : copyOnWriteArrayList) {
            LocationServiceExtension locationServiceExtension = moduleServiceEntryPoint.getLocationServiceExtension();
            Consumer<Location> locationConsumer = locationServiceExtension != null ? locationServiceExtension.getLocationConsumer() : null;
            if (locationConsumer != null) {
                arrayList.add(locationConsumer);
            }
        }
        return arrayList;
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0511pd
    public final ModuleLocationSourcesServiceController f() {
        ModuleLocationSourcesServiceController moduleLocationSourcesServiceController;
        Iterator it = this.b.iterator();
        do {
            moduleLocationSourcesServiceController = null;
            if (!it.hasNext()) {
                break;
            }
            LocationServiceExtension locationServiceExtension = ((ModuleServiceEntryPoint) it.next()).getLocationServiceExtension();
            if (locationServiceExtension != null) {
                moduleLocationSourcesServiceController = locationServiceExtension.getLocationSourcesController();
                continue;
            }
        } while (moduleLocationSourcesServiceController == null);
        return moduleLocationSourcesServiceController;
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0511pd
    public final Toggle g() {
        Toggle toggle;
        Iterator it = this.b.iterator();
        do {
            toggle = null;
            if (!it.hasNext()) {
                break;
            }
            LocationServiceExtension locationServiceExtension = ((ModuleServiceEntryPoint) it.next()).getLocationServiceExtension();
            if (locationServiceExtension != null) {
                toggle = locationServiceExtension.getLocationControllerAppStateToggle();
                continue;
            }
        } while (toggle == null);
        return toggle;
    }

    @Override // io.appmetrica.analytics.modulesapi.internal.common.AskForPermissionStrategyModuleProvider
    public final PermissionStrategy getAskForPermissionStrategy() {
        return this.c.getAskForPermissionStrategy();
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0511pd
    public final List<String> h() {
        List<String> emptyList;
        CopyOnWriteArrayList<ModuleServiceEntryPoint> copyOnWriteArrayList = this.b;
        ArrayList arrayList = new ArrayList();
        for (ModuleServiceEntryPoint moduleServiceEntryPoint : copyOnWriteArrayList) {
            RemoteConfigExtensionConfiguration remoteConfigExtensionConfiguration = moduleServiceEntryPoint.getRemoteConfigExtensionConfiguration();
            if (remoteConfigExtensionConfiguration == null || (emptyList = remoteConfigExtensionConfiguration.getFeatures()) == null) {
                emptyList = CollectionsKt.emptyList();
            }
            CollectionsKt.addAll(arrayList, emptyList);
        }
        return arrayList;
    }

    public final Bundle i() {
        Bundle bundle = new Bundle();
        for (ModuleServiceEntryPoint moduleServiceEntryPoint : this.b) {
            ClientConfigProvider clientConfigProvider = moduleServiceEntryPoint.getClientConfigProvider();
            Bundle configBundleForClient = clientConfigProvider != null ? clientConfigProvider.getConfigBundleForClient() : null;
            if (configBundleForClient != null) {
                bundle.putBundle(moduleServiceEntryPoint.getIdentifier(), configBundleForClient);
            }
        }
        return bundle;
    }

    public final void a(ModuleServiceEntryPoint<Object> moduleServiceEntryPoint) {
        this.b.add(moduleServiceEntryPoint);
        if (Intrinsics.areEqual(this.f483a, moduleServiceEntryPoint.getIdentifier()) && (moduleServiceEntryPoint instanceof AskForPermissionStrategyModuleProvider)) {
            this.c = (AskForPermissionStrategyModuleProvider) moduleServiceEntryPoint;
        }
    }

    public final void a(ServiceContext serviceContext, C0494om c0494om) {
        HashSet hashSet = new HashSet();
        Iterator it = this.b.iterator();
        while (it.hasNext()) {
            ModuleServiceEntryPoint moduleServiceEntryPoint = (ModuleServiceEntryPoint) it.next();
            try {
                moduleServiceEntryPoint.initServiceSide(serviceContext, new Gk(new SdkIdentifiers(c0494om.d, c0494om.f1025a, c0494om.b), new C0282gh(c0494om.v, c0494om.u), c0494om.B.get(moduleServiceEntryPoint.getIdentifier())));
                ModuleEventServiceHandlerFactory moduleEventServiceHandlerFactory = moduleServiceEntryPoint.getModuleEventServiceHandlerFactory();
                if (moduleEventServiceHandlerFactory != null) {
                    C0635ud c0635ud = Na.F.t;
                    String identifier = moduleServiceEntryPoint.getIdentifier();
                    synchronized (c0635ud) {
                        c0635ud.f1110a.put(identifier, moduleEventServiceHandlerFactory);
                    }
                }
            } catch (Throwable th) {
                String identifier2 = moduleServiceEntryPoint.getIdentifier();
                C0414lk c0414lk = Kj.f543a;
                Map mapOf = MapsKt.mapOf(TuplesKt.to(identifier2, MapsKt.mapOf(TuplesKt.to("init", ExceptionsKt.stackTraceToString(th)))));
                c0414lk.getClass();
                c0414lk.a(new C0388kk("service_module_errors", mapOf));
                hashSet.add(moduleServiceEntryPoint);
            }
        }
        this.b.removeAll(hashSet);
    }
}
