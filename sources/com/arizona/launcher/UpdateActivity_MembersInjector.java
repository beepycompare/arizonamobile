package com.arizona.launcher;

import com.miami.game.feature.download.screen.ui.DownloadScreenComponent;
import dagger.MembersInjector;
import dagger.internal.Provider;
/* loaded from: classes3.dex */
public final class UpdateActivity_MembersInjector implements MembersInjector<UpdateActivity> {
    private final Provider<DownloadScreenComponent.Factory> rootFactoryProvider;

    public UpdateActivity_MembersInjector(Provider<DownloadScreenComponent.Factory> rootFactoryProvider) {
        this.rootFactoryProvider = rootFactoryProvider;
    }

    public static MembersInjector<UpdateActivity> create(Provider<DownloadScreenComponent.Factory> rootFactoryProvider) {
        return new UpdateActivity_MembersInjector(rootFactoryProvider);
    }

    @Override // dagger.MembersInjector
    public void injectMembers(UpdateActivity instance) {
        injectRootFactory(instance, this.rootFactoryProvider.get());
    }

    public static void injectRootFactory(UpdateActivity instance, DownloadScreenComponent.Factory rootFactory) {
        instance.rootFactory = rootFactory;
    }
}
