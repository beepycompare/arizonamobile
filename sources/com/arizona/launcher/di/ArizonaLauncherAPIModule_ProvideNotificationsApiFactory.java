package com.arizona.launcher.di;

import com.arizona.launcher.data.repository.notifications.NotificationsAPI;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
/* loaded from: classes3.dex */
public final class ArizonaLauncherAPIModule_ProvideNotificationsApiFactory implements Factory<NotificationsAPI> {
    private final ArizonaLauncherAPIModule module;

    public ArizonaLauncherAPIModule_ProvideNotificationsApiFactory(ArizonaLauncherAPIModule module) {
        this.module = module;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public NotificationsAPI get() {
        return provideNotificationsApi(this.module);
    }

    public static ArizonaLauncherAPIModule_ProvideNotificationsApiFactory create(ArizonaLauncherAPIModule module) {
        return new ArizonaLauncherAPIModule_ProvideNotificationsApiFactory(module);
    }

    public static NotificationsAPI provideNotificationsApi(ArizonaLauncherAPIModule instance) {
        return (NotificationsAPI) Preconditions.checkNotNullFromProvides(instance.provideNotificationsApi());
    }
}
