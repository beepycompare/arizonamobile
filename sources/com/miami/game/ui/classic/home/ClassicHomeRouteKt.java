package com.miami.game.ui.classic.home;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.media3.exoplayer.RendererCapabilities;
import com.miami.game.feature.home.ui.HomeComponent;
import com.miami.game.feature.home.ui.compose.HomeScreenKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: ClassicHomeRoute.kt */
@Metadata(d1 = {"\u0000*\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u008f\u0001\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00010\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00010\u00052\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00010\u00052\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00010\t2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00010\u00052\u001e\u0010\f\u001a\u001a\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010\u0005\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00010\r2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00010\u0005H\u0007¢\u0006\u0002\u0010\u000f¨\u0006\u0010"}, d2 = {"ClassicHomeRoute", "", "component", "Lcom/miami/game/feature/home/ui/HomeComponent;", "navigateToSettings", "Lkotlin/Function0;", "navigateToSelectServers", "navigateTooRepairGameSuccess", "navigateToDownloadDialog", "Lkotlin/Function1;", "", "navigateToDownloadScreen", "navigateToErrorDialog", "Lkotlin/Function2;", "navigateToNotification", "(Lcom/miami/game/feature/home/ui/HomeComponent;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)V", "home"}, k = 2, mv = {2, 3, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class ClassicHomeRouteKt {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit ClassicHomeRoute$lambda$0(HomeComponent homeComponent, Function0 function0, Function0 function02, Function0 function03, Function1 function1, Function0 function04, Function2 function2, Function0 function05, int i, Composer composer, int i2) {
        ClassicHomeRoute(homeComponent, function0, function02, function03, function1, function04, function2, function05, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    public static final void ClassicHomeRoute(final HomeComponent component, final Function0<Unit> navigateToSettings, final Function0<Unit> navigateToSelectServers, final Function0<Unit> navigateTooRepairGameSuccess, final Function1<? super String, Unit> navigateToDownloadDialog, final Function0<Unit> navigateToDownloadScreen, final Function2<? super Function0<Unit>, ? super String, Unit> navigateToErrorDialog, final Function0<Unit> navigateToNotification, Composer composer, final int i) {
        int i2;
        Composer composer2;
        Intrinsics.checkNotNullParameter(component, "component");
        Intrinsics.checkNotNullParameter(navigateToSettings, "navigateToSettings");
        Intrinsics.checkNotNullParameter(navigateToSelectServers, "navigateToSelectServers");
        Intrinsics.checkNotNullParameter(navigateTooRepairGameSuccess, "navigateTooRepairGameSuccess");
        Intrinsics.checkNotNullParameter(navigateToDownloadDialog, "navigateToDownloadDialog");
        Intrinsics.checkNotNullParameter(navigateToDownloadScreen, "navigateToDownloadScreen");
        Intrinsics.checkNotNullParameter(navigateToErrorDialog, "navigateToErrorDialog");
        Intrinsics.checkNotNullParameter(navigateToNotification, "navigateToNotification");
        Composer startRestartGroup = composer.startRestartGroup(-958342156);
        ComposerKt.sourceInformation(startRestartGroup, "C(ClassicHomeRoute)N(component,navigateToSettings,navigateToSelectServers,navigateTooRepairGameSuccess,navigateToDownloadDialog,navigateToDownloadScreen,navigateToErrorDialog,navigateToNotification)17@574L458:ClassicHomeRoute.kt#icyefn");
        if ((i & 6) == 0) {
            i2 = ((i & 8) == 0 ? startRestartGroup.changed(component) : startRestartGroup.changedInstance(component) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= startRestartGroup.changedInstance(navigateToSettings) ? 32 : 16;
        }
        if ((i & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
            i2 |= startRestartGroup.changedInstance(navigateToSelectServers) ? 256 : 128;
        }
        if ((i & 3072) == 0) {
            i2 |= startRestartGroup.changedInstance(navigateTooRepairGameSuccess) ? 2048 : 1024;
        }
        if ((i & 24576) == 0) {
            i2 |= startRestartGroup.changedInstance(navigateToDownloadDialog) ? 16384 : 8192;
        }
        if ((196608 & i) == 0) {
            i2 |= startRestartGroup.changedInstance(navigateToDownloadScreen) ? 131072 : 65536;
        }
        if ((1572864 & i) == 0) {
            i2 |= startRestartGroup.changedInstance(navigateToErrorDialog) ? 1048576 : 524288;
        }
        if ((12582912 & i) == 0) {
            i2 |= startRestartGroup.changedInstance(navigateToNotification) ? 8388608 : 4194304;
        }
        if (!startRestartGroup.shouldExecute((4793491 & i2) != 4793490, i2 & 1)) {
            composer2 = startRestartGroup;
            composer2.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-958342156, i2, -1, "com.miami.game.ui.classic.home.ClassicHomeRoute (ClassicHomeRoute.kt:16)");
            }
            composer2 = startRestartGroup;
            HomeScreenKt.HomeRoute(component, navigateToSettings, navigateToSelectServers, navigateTooRepairGameSuccess, navigateToDownloadDialog, navigateToDownloadScreen, navigateToErrorDialog, navigateToNotification, composer2, HomeComponent.$stable | (i2 & 14) | (i2 & 112) | (i2 & 896) | (i2 & 7168) | (57344 & i2) | (458752 & i2) | (3670016 & i2) | (i2 & 29360128));
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: com.miami.game.ui.classic.home.ClassicHomeRouteKt$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return ClassicHomeRouteKt.ClassicHomeRoute$lambda$0(HomeComponent.this, navigateToSettings, navigateToSelectServers, navigateTooRepairGameSuccess, navigateToDownloadDialog, navigateToDownloadScreen, navigateToErrorDialog, navigateToNotification, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }
}
