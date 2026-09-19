package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.servicecomponents.ServiceModuleCounterReport;
/* loaded from: classes5.dex */
public final class Vk {
    public static C0240f6 a(ServiceModuleCounterReport serviceModuleCounterReport) {
        String value;
        C0240f6 c0240f6 = new C0240f6("", "", 0);
        c0240f6.d = serviceModuleCounterReport.getType();
        String name = serviceModuleCounterReport.getName();
        if (name != null) {
            c0240f6.f977a = name;
        }
        if (serviceModuleCounterReport.getValueBytes() == null && (value = serviceModuleCounterReport.getValue()) != null) {
            c0240f6.b = value;
        }
        byte[] valueBytes = serviceModuleCounterReport.getValueBytes();
        if (valueBytes != null) {
            c0240f6.setValueBytes(valueBytes);
        }
        return c0240f6;
    }
}
