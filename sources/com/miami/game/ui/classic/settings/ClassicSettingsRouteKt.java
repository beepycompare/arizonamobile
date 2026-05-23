package com.miami.game.ui.classic.settings;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.media3.exoplayer.RendererCapabilities;
import com.miami.game.feature.settings.ui.SettingsComponent;
import com.miami.game.feature.settings.ui.compose.SettingsScreenKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: ClassicSettingsRoute.kt */
@Metadata(d1 = {"\u0000\u001e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\u001ag\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00010\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00010\u00052\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00010\u00052\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00010\u00052\u0018\u0010\t\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010\u0005\u0012\u0004\u0012\u00020\u00010\nH\u0007¢\u0006\u0002\u0010\u000b¨\u0006\f"}, d2 = {"ClassicSettingsRoute", "", "component", "Lcom/miami/game/feature/settings/ui/SettingsComponent;", "onBackClick", "Lkotlin/Function0;", "onRepairGameSuccess", "onRepairGameError", "onNavigateDownload", "onRepairGameDialog", "Lkotlin/Function1;", "(Lcom/miami/game/feature/settings/ui/SettingsComponent;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;I)V", "settings"}, k = 2, mv = {2, 3, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class ClassicSettingsRouteKt {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit ClassicSettingsRoute$lambda$0(SettingsComponent settingsComponent, Function0 function0, Function0 function02, Function0 function03, Function0 function04, Function1 function1, int i, Composer composer, int i2) {
        ClassicSettingsRoute(settingsComponent, function0, function02, function03, function04, function1, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    public static final void ClassicSettingsRoute(final SettingsComponent component, final Function0<Unit> onBackClick, final Function0<Unit> onRepairGameSuccess, final Function0<Unit> onRepairGameError, final Function0<Unit> onNavigateDownload, final Function1<? super Function0<Unit>, Unit> onRepairGameDialog, Composer composer, final int i) {
        int i2;
        Intrinsics.checkNotNullParameter(component, "component");
        Intrinsics.checkNotNullParameter(onBackClick, "onBackClick");
        Intrinsics.checkNotNullParameter(onRepairGameSuccess, "onRepairGameSuccess");
        Intrinsics.checkNotNullParameter(onRepairGameError, "onRepairGameError");
        Intrinsics.checkNotNullParameter(onNavigateDownload, "onNavigateDownload");
        Intrinsics.checkNotNullParameter(onRepairGameDialog, "onRepairGameDialog");
        Composer startRestartGroup = composer.startRestartGroup(947562262);
        ComposerKt.sourceInformation(startRestartGroup, "C(ClassicSettingsRoute)N(component,onBackClick,onRepairGameSuccess,onRepairGameError,onNavigateDownload,onRepairGameDialog)15@475L282:ClassicSettingsRoute.kt#nnusyx");
        if ((i & 6) == 0) {
            i2 = ((i & 8) == 0 ? startRestartGroup.changed(component) : startRestartGroup.changedInstance(component) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= startRestartGroup.changedInstance(onBackClick) ? 32 : 16;
        }
        if ((i & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
            i2 |= startRestartGroup.changedInstance(onRepairGameSuccess) ? 256 : 128;
        }
        if ((i & 3072) == 0) {
            i2 |= startRestartGroup.changedInstance(onRepairGameError) ? 2048 : 1024;
        }
        if ((i & 24576) == 0) {
            i2 |= startRestartGroup.changedInstance(onNavigateDownload) ? 16384 : 8192;
        }
        if ((196608 & i) == 0) {
            i2 |= startRestartGroup.changedInstance(onRepairGameDialog) ? 131072 : 65536;
        }
        if (!startRestartGroup.shouldExecute((74899 & i2) != 74898, i2 & 1)) {
            startRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(947562262, i2, -1, "com.miami.game.ui.classic.settings.ClassicSettingsRoute (ClassicSettingsRoute.kt:14)");
            }
            SettingsScreenKt.SettingsRoute(component, onBackClick, onRepairGameSuccess, onRepairGameError, onNavigateDownload, onRepairGameDialog, startRestartGroup, SettingsComponent.$stable | (i2 & 14) | (i2 & 112) | (i2 & 896) | (i2 & 7168) | (57344 & i2) | (i2 & 458752));
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: com.miami.game.ui.classic.settings.ClassicSettingsRouteKt$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return ClassicSettingsRouteKt.ClassicSettingsRoute$lambda$0(SettingsComponent.this, onBackClick, onRepairGameSuccess, onRepairGameError, onNavigateDownload, onRepairGameDialog, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }
}
