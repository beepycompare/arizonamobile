package ru.mrlargha.commonui.elements.hud.presentation;

import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: RodinaHudSubwindowEvents.kt */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\rB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\t\u001a\u00020\n2\u0006\u0010\u0006\u001a\u00020\bJ\u000e\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\u0005R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lru/mrlargha/commonui/elements/hud/presentation/RodinaHudSubwindowEvents;", "", "<init>", "()V", "battlePassRewardsBannerVisible", "", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Ljava/lang/ref/WeakReference;", "Lru/mrlargha/commonui/elements/hud/presentation/RodinaHudSubwindowEvents$Listener;", "register", "", "setBattlePassRewardsBannerVisible", "visible", "Listener", "CommonUI"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class RodinaHudSubwindowEvents {
    public static final RodinaHudSubwindowEvents INSTANCE = new RodinaHudSubwindowEvents();
    private static boolean battlePassRewardsBannerVisible;
    private static WeakReference<Listener> listener;

    /* compiled from: RodinaHudSubwindowEvents.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006À\u0006\u0003"}, d2 = {"Lru/mrlargha/commonui/elements/hud/presentation/RodinaHudSubwindowEvents$Listener;", "", "onBattlePassRewardsBannerVisibilityChanged", "", "visible", "", "CommonUI"}, k = 1, mv = {2, 4, 0}, xi = 48)
    /* loaded from: classes6.dex */
    public interface Listener {
        void onBattlePassRewardsBannerVisibilityChanged(boolean z);
    }

    private RodinaHudSubwindowEvents() {
    }

    public final void register(Listener listener2) {
        Intrinsics.checkNotNullParameter(listener2, "listener");
        listener = new WeakReference<>(listener2);
        listener2.onBattlePassRewardsBannerVisibilityChanged(battlePassRewardsBannerVisible);
    }

    public final void setBattlePassRewardsBannerVisible(boolean z) {
        if (battlePassRewardsBannerVisible == z) {
            return;
        }
        battlePassRewardsBannerVisible = z;
        WeakReference<Listener> weakReference = listener;
        Listener listener2 = weakReference != null ? weakReference.get() : null;
        if (listener2 == null) {
            listener = null;
        } else {
            listener2.onBattlePassRewardsBannerVisibilityChanged(z);
        }
    }
}
