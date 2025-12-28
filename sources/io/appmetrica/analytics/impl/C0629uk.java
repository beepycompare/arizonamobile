package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.servicecomponents.ServiceModuleCounterReport;
/* renamed from: io.appmetrica.analytics.impl.uk  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0629uk {
    public static Q5 a(ServiceModuleCounterReport serviceModuleCounterReport) {
        String value;
        Q5 q5 = new Q5("", "", 0);
        q5.d = serviceModuleCounterReport.getType();
        String name = serviceModuleCounterReport.getName();
        if (name != null) {
            q5.f746a = name;
        }
        if (serviceModuleCounterReport.getValueBytes() == null && (value = serviceModuleCounterReport.getValue()) != null) {
            q5.b = value;
        }
        byte[] valueBytes = serviceModuleCounterReport.getValueBytes();
        if (valueBytes != null) {
            q5.setValueBytes(valueBytes);
        }
        return q5;
    }
}
