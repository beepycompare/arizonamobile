package com.google.firebase.sessions;

import com.google.android.datatransport.TransportFactory;
import com.google.firebase.sessions.dagger.internal.Factory;
import javax.inject.Provider;
/* loaded from: classes4.dex */
public final class EventGDTLogger_Factory implements Factory<EventGDTLogger> {
    private final Provider<com.google.firebase.inject.Provider<TransportFactory>> transportFactoryProvider;

    public EventGDTLogger_Factory(Provider<com.google.firebase.inject.Provider<TransportFactory>> provider) {
        this.transportFactoryProvider = provider;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public EventGDTLogger get() {
        return newInstance(this.transportFactoryProvider.get());
    }

    public static EventGDTLogger_Factory create(Provider<com.google.firebase.inject.Provider<TransportFactory>> provider) {
        return new EventGDTLogger_Factory(provider);
    }

    public static EventGDTLogger newInstance(com.google.firebase.inject.Provider<TransportFactory> provider) {
        return new EventGDTLogger(provider);
    }
}
