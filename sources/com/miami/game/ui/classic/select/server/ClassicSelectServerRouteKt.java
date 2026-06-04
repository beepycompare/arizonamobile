package com.miami.game.ui.classic.select.server;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import com.miami.game.feature.select.server.ui.SelectServerComponent;
import com.miami.game.feature.select.server.ui.compose.SelectServerScreenKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: ClassicSelectServerRoute.kt */
@Metadata(d1 = {"\u0000 \n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a5\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0007b\u0002\b\u0007b\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n¢\u0006\u0002\u0010\u0006¨\u0006\u000b"}, d2 = {"ClassicSelectServerRoute", "", "navigateHome", "Lkotlin/Function0;", "component", "Lcom/miami/game/feature/select/server/ui/SelectServerComponent;", "(Lkotlin/jvm/functions/Function0;Lcom/miami/game/feature/select/server/ui/SelectServerComponent;Landroidx/compose/runtime/Composer;I)V", "Landroidx/compose/runtime/Composable;", "Landroidx/compose/runtime/ComposableTarget;", "applier", "androidx.compose.ui.UiComposable", "select-server"}, k = 2, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class ClassicSelectServerRouteKt {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit ClassicSelectServerRoute$lambda$0(Function0 function0, SelectServerComponent selectServerComponent, int i, Composer composer, int i2) {
        ClassicSelectServerRoute(function0, selectServerComponent, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    public static final void ClassicSelectServerRoute(final Function0<Unit> navigateHome, final SelectServerComponent component, Composer composer, final int i) {
        int i2;
        Intrinsics.checkNotNullParameter(navigateHome, "navigateHome");
        Intrinsics.checkNotNullParameter(component, "component");
        Composer startRestartGroup = composer.startRestartGroup(-1655078169);
        ComposerKt.sourceInformation(startRestartGroup, "C(ClassicSelectServerRoute)N(navigateHome,component)11@353L92:ClassicSelectServerRoute.kt#4okj3z");
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
                ComposerKt.traceEventStart(-1655078169, i2, -1, "com.miami.game.ui.classic.select.server.ClassicSelectServerRoute (ClassicSelectServerRoute.kt:10)");
            }
            SelectServerScreenKt.SelectServerRoute(navigateHome, component, startRestartGroup, (i2 & 14) | (SelectServerComponent.$stable << 3) | (i2 & 112));
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: com.miami.game.ui.classic.select.server.ClassicSelectServerRouteKt$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return ClassicSelectServerRouteKt.ClassicSelectServerRoute$lambda$0(Function0.this, component, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }
}
