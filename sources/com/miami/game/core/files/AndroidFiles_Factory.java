package com.miami.game.core.files;

import android.content.Context;
import dagger.internal.Factory;
import dagger.internal.Provider;
/* loaded from: classes4.dex */
public final class AndroidFiles_Factory implements Factory<AndroidFiles> {
    private final Provider<Context> applicationContextProvider;

    public AndroidFiles_Factory(Provider<Context> provider) {
        this.applicationContextProvider = provider;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public AndroidFiles get() {
        return newInstance(this.applicationContextProvider.get());
    }

    public static AndroidFiles_Factory create(Provider<Context> provider) {
        return new AndroidFiles_Factory(provider);
    }

    public static AndroidFiles newInstance(Context context) {
        return new AndroidFiles(context);
    }
}
