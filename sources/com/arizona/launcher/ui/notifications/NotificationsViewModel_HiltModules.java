package com.arizona.launcher.ui.notifications;

import androidx.lifecycle.ViewModel;
import dagger.Binds;
import dagger.Module;
import dagger.Provides;
import dagger.multibindings.IntoMap;
import dagger.multibindings.LazyClassKey;
/* loaded from: classes3.dex */
public final class NotificationsViewModel_HiltModules {
    private NotificationsViewModel_HiltModules() {
    }

    @Module
    /* loaded from: classes3.dex */
    public static abstract class BindsModule {
        @LazyClassKey(NotificationsViewModel.class)
        @Binds
        @IntoMap
        public abstract ViewModel binds(NotificationsViewModel vm);

        private BindsModule() {
        }
    }

    @Module
    /* loaded from: classes3.dex */
    public static final class KeyModule {
        @Provides
        @LazyClassKey(NotificationsViewModel.class)
        @IntoMap
        public static boolean provide() {
            return true;
        }

        private KeyModule() {
        }
    }
}
