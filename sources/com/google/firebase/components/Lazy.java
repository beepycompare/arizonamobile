package com.google.firebase.components;

import com.google.firebase.inject.Provider;
/* loaded from: classes4.dex */
public class Lazy<T> implements Provider<T> {
    private static final Object UNINITIALIZED = new Object();
    private volatile Object instance;
    private volatile Provider<T> provider;

    Lazy(T t) {
        this.instance = UNINITIALIZED;
        this.instance = t;
    }

    public Lazy(Provider<T> provider) {
        this.instance = UNINITIALIZED;
        this.provider = provider;
    }

    @Override // com.google.firebase.inject.Provider
    public T get() {
        T t;
        T t2 = (T) this.instance;
        Object obj = UNINITIALIZED;
        if (t2 == obj) {
            synchronized (this) {
                t = (T) this.instance;
                if (t == obj) {
                    t = this.provider.get();
                    this.instance = t;
                    this.provider = null;
                }
            }
            return t;
        }
        return t2;
    }

    boolean isInitialized() {
        return this.instance != UNINITIALIZED;
    }
}
