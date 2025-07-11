package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.clientcomponents.ClientComponentsInitializer;
import io.appmetrica.analytics.coreutils.internal.reflection.ReflectionUtils;
/* renamed from: io.appmetrica.analytics.impl.b4  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public abstract class AbstractC0146b4 {
    public static ClientComponentsInitializer a() {
        if ("".length() > 0) {
            ReflectionUtils reflectionUtils = ReflectionUtils.INSTANCE;
            ClientComponentsInitializer clientComponentsInitializer = (ClientComponentsInitializer) ReflectionUtils.loadAndInstantiateClassWithDefaultConstructor("", ClientComponentsInitializer.class);
            if (clientComponentsInitializer != null) {
                return clientComponentsInitializer;
            }
        }
        return new U7();
    }
}
