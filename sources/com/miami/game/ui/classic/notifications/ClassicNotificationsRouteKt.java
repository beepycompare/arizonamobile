package com.miami.game.ui.classic.notifications;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import com.miami.game.feature.notifications.presentation.NotificationsComponent;
import com.miami.game.feature.notifications.presentation.NotificationsScreentKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: ClassicNotificationsRoute.kt */
@Metadata(d1 = {"\u0000 \n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a5\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0007b\u0002\b\u0007b\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n¢\u0006\u0002\u0010\u0006¨\u0006\u000b"}, d2 = {"ClassicNotificationsRoute", "", "navigateHome", "Lkotlin/Function0;", "component", "Lcom/miami/game/feature/notifications/presentation/NotificationsComponent;", "(Lkotlin/jvm/functions/Function0;Lcom/miami/game/feature/notifications/presentation/NotificationsComponent;Landroidx/compose/runtime/Composer;I)V", "Landroidx/compose/runtime/Composable;", "Landroidx/compose/runtime/ComposableTarget;", "applier", "androidx.compose.ui.UiComposable", "notifications"}, k = 2, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class ClassicNotificationsRouteKt {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit ClassicNotificationsRoute$lambda$0(Function0 function0, NotificationsComponent notificationsComponent, int i, Composer composer, int i2) {
        ClassicNotificationsRoute(function0, notificationsComponent, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    public static final void ClassicNotificationsRoute(final Function0<Unit> navigateHome, final NotificationsComponent component, Composer composer, final int i) {
        int i2;
        Intrinsics.checkNotNullParameter(navigateHome, "navigateHome");
        Intrinsics.checkNotNullParameter(component, "component");
        Composer startRestartGroup = composer.startRestartGroup(-229410261);
        ComposerKt.sourceInformation(startRestartGroup, "C(ClassicNotificationsRoute)N(navigateHome,component)11@371L95:ClassicNotificationsRoute.kt#b0dzuc");
        if ((i & 6) == 0) {
            i2 = (startRestartGroup.changedInstance(navigateHome) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= (i & 64) == 0 ? startRestartGroup.changed(component) : startRestartGroup.changedInstance(component) ? 32 : 16;
        }
        if (!startRestartGroup.shouldExecute((i2 & 19) != 18, i2 & 1)) {
            startRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-229410261, i2, -1, "com.miami.game.ui.classic.notifications.ClassicNotificationsRoute (ClassicNotificationsRoute.kt:10)");
            }
            NotificationsScreentKt.NotificationsScreent(navigateHome, component, startRestartGroup, (i2 & 14) | (NotificationsComponent.$stable << 3) | (i2 & 112));
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: com.miami.game.ui.classic.notifications.ClassicNotificationsRouteKt$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return ClassicNotificationsRouteKt.ClassicNotificationsRoute$lambda$0(Function0.this, component, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }
}
