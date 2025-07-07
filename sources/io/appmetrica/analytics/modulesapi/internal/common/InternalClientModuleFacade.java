package io.appmetrica.analytics.modulesapi.internal.common;

import io.appmetrica.analytics.modulesapi.internal.client.adrevenue.ModuleAdRevenue;
import kotlin.Metadata;
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\bH&¨\u0006\t"}, d2 = {"Lio/appmetrica/analytics/modulesapi/internal/common/InternalClientModuleFacade;", "", "reportAdRevenue", "", "moduleAdRevenue", "Lio/appmetrica/analytics/modulesapi/internal/client/adrevenue/ModuleAdRevenue;", "reportEvent", "internalModuleEvent", "Lio/appmetrica/analytics/modulesapi/internal/common/InternalModuleEvent;", "modules-api_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public interface InternalClientModuleFacade {
    void reportAdRevenue(ModuleAdRevenue moduleAdRevenue);

    void reportEvent(InternalModuleEvent internalModuleEvent);
}
