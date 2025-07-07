package io.appmetrica.analytics.coreapi.internal.data;

import java.io.IOException;
/* loaded from: classes4.dex */
public interface StateSerializer<T> {
    T defaultValue();

    byte[] toByteArray(T t);

    T toState(byte[] bArr) throws IOException;
}
