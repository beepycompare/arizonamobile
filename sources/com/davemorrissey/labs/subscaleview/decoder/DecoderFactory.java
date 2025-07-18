package com.davemorrissey.labs.subscaleview.decoder;

import java.lang.reflect.InvocationTargetException;
/* loaded from: classes3.dex */
public interface DecoderFactory<T> {
    T make() throws IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException;
}
