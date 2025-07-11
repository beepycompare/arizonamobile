package io.appmetrica.analytics.screenshot.impl;

import io.appmetrica.analytics.modulesapi.internal.client.ClientContext;
import io.appmetrica.analytics.modulesapi.internal.common.InternalModuleEvent;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
/* renamed from: io.appmetrica.analytics.screenshot.impl.v  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0786v implements Q {

    /* renamed from: a  reason: collision with root package name */
    public final ClientContext f1313a;

    public C0786v(ClientContext clientContext) {
        this.f1313a = clientContext;
    }

    public final void a(String str) {
        this.f1313a.getInternalClientModuleFacade().reportEvent(InternalModuleEvent.Companion.newBuilder(4).withName("appmetrica_system_event_screenshot").withAttributes(MapsKt.mapOf(TuplesKt.to("type", str))).withCategory(InternalModuleEvent.Category.SYSTEM).build());
    }
}
