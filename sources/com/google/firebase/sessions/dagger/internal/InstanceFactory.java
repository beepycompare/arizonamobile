package com.google.firebase.sessions.dagger.internal;

import com.google.firebase.sessions.dagger.Lazy;
/* loaded from: classes4.dex */
public final class InstanceFactory<T> implements Factory<T>, Lazy<T> {
    private static final InstanceFactory<Object> NULL_INSTANCE_FACTORY = new InstanceFactory<>(null);
    private final T instance;

    public static <T> Factory<T> create(T t) {
        return new InstanceFactory(Preconditions.checkNotNull(t, "instance cannot be null"));
    }

    public static <T> Factory<T> createNullable(T t) {
        if (t == null) {
            return nullInstanceFactory();
        }
        return new InstanceFactory(t);
    }

    private static <T> InstanceFactory<T> nullInstanceFactory() {
        return (InstanceFactory<T>) NULL_INSTANCE_FACTORY;
    }

    private InstanceFactory(T t) {
        this.instance = t;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public T get() {
        return this.instance;
    }
}
