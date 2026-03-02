package io.appmetrica.analytics.impl;

import android.location.Location;
import io.appmetrica.analytics.coreapi.internal.backport.Consumer;
import io.appmetrica.analytics.coreapi.internal.control.Toggle;
import io.appmetrica.analytics.modulesapi.internal.service.ModuleLocationSourcesServiceController;
import io.appmetrica.analytics.modulesapi.internal.service.ModuleServicesDatabase;
import java.util.List;
import java.util.Map;
/* loaded from: classes5.dex */
public interface Pc extends InterfaceC0476od {
    List<ModuleServicesDatabase> b();

    /* synthetic */ Map c();

    /* synthetic */ Map d();

    List<Consumer<Location>> e();

    ModuleLocationSourcesServiceController f();

    Toggle g();

    /* synthetic */ List h();
}
