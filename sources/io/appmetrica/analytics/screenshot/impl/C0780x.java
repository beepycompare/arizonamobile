package io.appmetrica.analytics.screenshot.impl;

import io.appmetrica.analytics.modulesapi.internal.client.ClientContext;
import io.appmetrica.analytics.modulesapi.internal.common.InternalModuleEvent;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
/* renamed from: io.appmetrica.analytics.screenshot.impl.x  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0780x implements U {

    /* renamed from: a  reason: collision with root package name */
    public final ClientContext f1479a;

    public C0780x(ClientContext clientContext) {
        this.f1479a = clientContext;
    }

    public final void a(String str) {
        this.f1479a.getInternalClientModuleFacade().reportEvent(InternalModuleEvent.Companion.newBuilder(4).withName("appmetrica_system_event_screenshot").withAttributes(MapsKt.mapOf(TuplesKt.to("type", str))).withCategory(InternalModuleEvent.Category.SYSTEM).build());
    }
}
