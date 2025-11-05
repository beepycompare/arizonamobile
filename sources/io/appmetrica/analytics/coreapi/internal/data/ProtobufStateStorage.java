package io.appmetrica.analytics.coreapi.internal.data;
/* loaded from: classes2.dex */
public interface ProtobufStateStorage<T> {
    void delete();

    T read();

    void save(T t);
}
