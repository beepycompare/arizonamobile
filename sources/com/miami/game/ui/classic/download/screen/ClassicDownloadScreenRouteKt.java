package com.miami.game.ui.classic.download.screen;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import com.miami.game.feature.download.screen.ui.DownloadScreenComponent;
import com.miami.game.feature.download.screen.ui.compose.DownloadScreenKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: ClassicDownloadScreenRoute.kt */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0015\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0007¢\u0006\u0002\u0010\u0004¨\u0006\u0005"}, d2 = {"ClassicDownloadScreenRoute", "", "component", "Lcom/miami/game/feature/download/screen/ui/DownloadScreenComponent;", "(Lcom/miami/game/feature/download/screen/ui/DownloadScreenComponent;Landroidx/compose/runtime/Composer;I)V", "download-screen"}, k = 2, mv = {2, 3, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class ClassicDownloadScreenRouteKt {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit ClassicDownloadScreenRoute$lambda$0(DownloadScreenComponent downloadScreenComponent, int i, Composer composer, int i2) {
        ClassicDownloadScreenRoute(downloadScreenComponent, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    public static final void ClassicDownloadScreenRoute(final DownloadScreenComponent component, Composer composer, final int i) {
        int i2;
        Intrinsics.checkNotNullParameter(component, "component");
        Composer startRestartGroup = composer.startRestartGroup(-624615063);
        ComposerKt.sourceInformation(startRestartGroup, "C(ClassicDownloadScreenRoute)N(component)10@337L57:ClassicDownloadScreenRoute.kt#jpowgu");
        if ((i & 6) == 0) {
            i2 = ((i & 8) == 0 ? startRestartGroup.changed(component) : startRestartGroup.changedInstance(component) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if (!startRestartGroup.shouldExecute((i2 & 3) != 2, i2 & 1)) {
            startRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-624615063, i2, -1, "com.miami.game.ui.classic.download.screen.ClassicDownloadScreenRoute (ClassicDownloadScreenRoute.kt:9)");
            }
            DownloadScreenKt.DownloadScreenRoute(component, startRestartGroup, DownloadScreenComponent.$stable | (i2 & 14));
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: com.miami.game.ui.classic.download.screen.ClassicDownloadScreenRouteKt$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return ClassicDownloadScreenRouteKt.ClassicDownloadScreenRoute$lambda$0(DownloadScreenComponent.this, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }
}
