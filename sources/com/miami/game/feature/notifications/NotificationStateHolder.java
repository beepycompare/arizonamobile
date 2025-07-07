package com.miami.game.feature.notifications;

import javax.inject.Singleton;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: notificationStateHolder.kt */
@Singleton
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\t\b\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/miami/game/feature/notifications/NotificationStateHolder;", "", "<init>", "()V", "viewModel", "Lcom/miami/game/feature/notifications/INotificationViewModel;", "getViewModel", "()Lcom/miami/game/feature/notifications/INotificationViewModel;", "setViewModel", "(Lcom/miami/game/feature/notifications/INotificationViewModel;)V", "notifications_release_web"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class NotificationStateHolder {
    public static final int $stable = 8;
    public INotificationViewModel viewModel;

    public final INotificationViewModel getViewModel() {
        INotificationViewModel iNotificationViewModel = this.viewModel;
        if (iNotificationViewModel != null) {
            return iNotificationViewModel;
        }
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        return null;
    }

    public final void setViewModel(INotificationViewModel iNotificationViewModel) {
        Intrinsics.checkNotNullParameter(iNotificationViewModel, "<set-?>");
        this.viewModel = iNotificationViewModel;
    }
}
