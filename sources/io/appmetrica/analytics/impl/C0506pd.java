package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.modulesapi.internal.common.ModulePreferences;
import io.appmetrica.analytics.modulesapi.internal.service.event.ModuleEventServiceHandlerContext;
import io.appmetrica.analytics.modulesapi.internal.service.event.ModuleEventServiceHandlerReporter;
/* renamed from: io.appmetrica.analytics.impl.pd  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0506pd implements ModuleEventServiceHandlerContext {

    /* renamed from: a  reason: collision with root package name */
    public final ModulePreferences f990a;
    public final ModulePreferences b;
    public final ModuleEventServiceHandlerReporter c;

    public C0506pd(ModulePreferences modulePreferences, ModulePreferences modulePreferences2, ModuleEventServiceHandlerReporter moduleEventServiceHandlerReporter) {
        this.f990a = modulePreferences;
        this.b = modulePreferences2;
        this.c = moduleEventServiceHandlerReporter;
    }

    @Override // io.appmetrica.analytics.modulesapi.internal.service.event.ModuleEventServiceHandlerContext
    public final ModuleEventServiceHandlerReporter getEventReporter() {
        return this.c;
    }

    @Override // io.appmetrica.analytics.modulesapi.internal.service.event.ModuleEventServiceHandlerContext
    public final ModulePreferences getLegacyModulePreferences() {
        return this.b;
    }

    @Override // io.appmetrica.analytics.modulesapi.internal.service.event.ModuleEventServiceHandlerContext
    public final ModulePreferences getModulePreferences() {
        return this.f990a;
    }
}
