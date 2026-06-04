package com.miami.game.feature.notifications;

import javax.inject.Singleton;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: notificationStateHolder.kt */
@Singleton
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\r\b\u0007\u001a\u0002\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003R\u001a\u0010\u0005\u001a\u00020\u0006X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nÊ\u0001\u0002\b\fÊ\u0001\f\b\r\u0012\b\b\u000e\u0012\u0004\b\u0003\u0010\u0000¨\u0006\u000b"}, d2 = {"Lcom/miami/game/feature/notifications/NotificationStateHolder;", "", "<init>", "()V", "Ljavax/inject/Inject;", "viewModel", "Lcom/miami/game/feature/notifications/INotificationViewModel;", "getViewModel", "()Lcom/miami/game/feature/notifications/INotificationViewModel;", "setViewModel", "(Lcom/miami/game/feature/notifications/INotificationViewModel;)V", "notifications", "Ljavax/inject/Singleton;", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes3.dex */
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
