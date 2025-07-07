package com.miami.game.feature.notifications.presentation;

import com.arkivanov.decompose.ComponentContext;
import com.miami.game.core.build.config.BuildConfigRepository;
import com.miami.game.feature.notifications.NotificationStateHolder;
import dagger.internal.Provider;
/* renamed from: com.miami.game.feature.notifications.presentation.NotificationsComponent_Factory  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0120NotificationsComponent_Factory {
    private final Provider<BuildConfigRepository> buildConfigProvider;
    private final Provider<NotificationStateHolder> holderProvider;

    public C0120NotificationsComponent_Factory(Provider<BuildConfigRepository> buildConfigProvider, Provider<NotificationStateHolder> holderProvider) {
        this.buildConfigProvider = buildConfigProvider;
        this.holderProvider = holderProvider;
    }

    public NotificationsComponent get(ComponentContext componentContext) {
        return newInstance(componentContext, this.buildConfigProvider.get(), this.holderProvider.get());
    }

    public static C0120NotificationsComponent_Factory create(Provider<BuildConfigRepository> buildConfigProvider, Provider<NotificationStateHolder> holderProvider) {
        return new C0120NotificationsComponent_Factory(buildConfigProvider, holderProvider);
    }

    public static NotificationsComponent newInstance(ComponentContext componentContext, BuildConfigRepository buildConfig, NotificationStateHolder holder) {
        return new NotificationsComponent(componentContext, buildConfig, holder);
    }
}
