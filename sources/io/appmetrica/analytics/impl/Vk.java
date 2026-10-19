package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.servicecomponents.ServiceModuleCounterReport;
/* loaded from: classes5.dex */
public final class Vk {
    public static C0235f6 a(ServiceModuleCounterReport serviceModuleCounterReport) {
        String value;
        C0235f6 c0235f6 = new C0235f6("", "", 0);
        c0235f6.d = serviceModuleCounterReport.getType();
        String name = serviceModuleCounterReport.getName();
        if (name != null) {
            c0235f6.f980a = name;
        }
        if (serviceModuleCounterReport.getValueBytes() == null && (value = serviceModuleCounterReport.getValue()) != null) {
            c0235f6.b = value;
        }
        byte[] valueBytes = serviceModuleCounterReport.getValueBytes();
        if (valueBytes != null) {
            c0235f6.setValueBytes(valueBytes);
        }
        return c0235f6;
    }
}
