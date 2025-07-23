package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.servicecomponents.ServiceComponentsInitializer;
import io.appmetrica.analytics.coreutils.internal.reflection.ReflectionUtils;
/* renamed from: io.appmetrica.analytics.impl.jk  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public abstract class AbstractC0365jk {
    public static ServiceComponentsInitializer a() {
        if ("".length() > 0) {
            ReflectionUtils reflectionUtils = ReflectionUtils.INSTANCE;
            ServiceComponentsInitializer serviceComponentsInitializer = (ServiceComponentsInitializer) ReflectionUtils.loadAndInstantiateClassWithDefaultConstructor("", ServiceComponentsInitializer.class);
            if (serviceComponentsInitializer != null) {
                return serviceComponentsInitializer;
            }
        }
        return new C0124a8();
    }
}
