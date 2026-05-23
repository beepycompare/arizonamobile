package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.servicecomponents.ServiceComponentsInitializer;
import io.appmetrica.analytics.coreutils.internal.reflection.ReflectionUtils;
/* loaded from: classes5.dex */
public abstract class Dk {
    public static ServiceComponentsInitializer a() {
        if ("".length() > 0) {
            ReflectionUtils reflectionUtils = ReflectionUtils.INSTANCE;
            ServiceComponentsInitializer serviceComponentsInitializer = (ServiceComponentsInitializer) ReflectionUtils.loadAndInstantiateClassWithDefaultConstructor("", ServiceComponentsInitializer.class);
            if (serviceComponentsInitializer != null) {
                return serviceComponentsInitializer;
            }
        }
        return new W7();
    }
}
