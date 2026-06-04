package com.miami.game.ui.classic.dialogs;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.media3.exoplayer.RendererCapabilities;
import com.miami.game.feature.download.dialog.ui.common.CommonDialogComponent;
import com.miami.game.feature.download.dialog.ui.error.ErrorDialogComponent;
import com.miami.game.feature.download.dialog.ui.error.compose.NoNetworkErrorDialogKt;
import com.miami.game.feature.download.dialog.ui.error.fromactivity.ErrorDialogFromActivityKt;
import com.miami.game.feature.download.dialog.ui.repair.RepairGameDialogKt;
import com.miami.game.feature.download.dialog.ui.repair.RepairGameErrorKt;
import com.miami.game.feature.download.dialog.ui.repair.RepairGameSuccessKt;
import com.miami.game.feature.download.dialog.ui.setup.SetupDialogKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: ClassicDialogsRoutes.kt */
@Metadata(d1 = {"\u0000*\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\u001aC\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00010\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00010\u0005H\u0007b\u0002\b\bb\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000b¢\u0006\u0002\u0010\u0007\u001aQ\u0010\f\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\r2\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00010\u00052\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00010\u00052\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00010\u0005H\u0007b\u0002\b\bb\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000b¢\u0006\u0002\u0010\u0010\u001aC\u0010\u0011\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00010\u00052\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00010\u0005H\u0007b\u0002\b\bb\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000b¢\u0006\u0002\u0010\u0007\u001aC\u0010\u0012\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00010\u00052\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00010\u0005H\u0007b\u0002\b\bb\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000b¢\u0006\u0002\u0010\u0007\u001aC\u0010\u0013\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\r2\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00010\u00052\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00010\u0005H\u0007b\u0002\b\bb\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000b¢\u0006\u0002\u0010\u0014\u001aI\u0010\u0015\u001a\u00020\u00012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\r2\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00010\u00052\u000e\b\u0002\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00010\u0005H\u0007b\u0002\b\bb\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000b¢\u0006\u0002\u0010\u0016¨\u0006\u0017"}, d2 = {"ClassicSetupDialogRoute", "", "component", "Lcom/miami/game/feature/download/dialog/ui/common/CommonDialogComponent;", "onBackClick", "Lkotlin/Function0;", "navigateToDownloadScreen", "(Lcom/miami/game/feature/download/dialog/ui/common/CommonDialogComponent;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)V", "Landroidx/compose/runtime/Composable;", "Landroidx/compose/runtime/ComposableTarget;", "applier", "androidx.compose.ui.UiComposable", "ClassicRepairGameDialogRoute", "Lcom/miami/game/feature/download/dialog/ui/error/ErrorDialogComponent;", "onConfirm", "onRetry", "(Lcom/miami/game/feature/download/dialog/ui/error/ErrorDialogComponent;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)V", "ClassicRepairGameErrorDialogRoute", "ClassicRepairGameSuccessDialogRoute", "ClassicNoNetworkErrorDialogRoute", "(Lcom/miami/game/feature/download/dialog/ui/error/ErrorDialogComponent;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)V", "ClassicErrorDialogFromActivityRoute", "(Lcom/miami/game/feature/download/dialog/ui/error/ErrorDialogComponent;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;II)V", "dialogs"}, k = 2, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class ClassicDialogsRoutesKt {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit ClassicErrorDialogFromActivityRoute$lambda$1(ErrorDialogComponent errorDialogComponent, Function0 function0, Function0 function02, int i, int i2, Composer composer, int i3) {
        ClassicErrorDialogFromActivityRoute(errorDialogComponent, function0, function02, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit ClassicNoNetworkErrorDialogRoute$lambda$0(ErrorDialogComponent errorDialogComponent, Function0 function0, Function0 function02, int i, Composer composer, int i2) {
        ClassicNoNetworkErrorDialogRoute(errorDialogComponent, function0, function02, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit ClassicRepairGameDialogRoute$lambda$0(ErrorDialogComponent errorDialogComponent, Function0 function0, Function0 function02, Function0 function03, int i, Composer composer, int i2) {
        ClassicRepairGameDialogRoute(errorDialogComponent, function0, function02, function03, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit ClassicRepairGameErrorDialogRoute$lambda$0(CommonDialogComponent commonDialogComponent, Function0 function0, Function0 function02, int i, Composer composer, int i2) {
        ClassicRepairGameErrorDialogRoute(commonDialogComponent, function0, function02, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit ClassicRepairGameSuccessDialogRoute$lambda$0(CommonDialogComponent commonDialogComponent, Function0 function0, Function0 function02, int i, Composer composer, int i2) {
        ClassicRepairGameSuccessDialogRoute(commonDialogComponent, function0, function02, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit ClassicSetupDialogRoute$lambda$0(CommonDialogComponent commonDialogComponent, Function0 function0, Function0 function02, int i, Composer composer, int i2) {
        ClassicSetupDialogRoute(commonDialogComponent, function0, function02, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    public static final void ClassicSetupDialogRoute(final CommonDialogComponent component, final Function0<Unit> onBackClick, final Function0<Unit> navigateToDownloadScreen, Composer composer, final int i) {
        int i2;
        Intrinsics.checkNotNullParameter(component, "component");
        Intrinsics.checkNotNullParameter(onBackClick, "onBackClick");
        Intrinsics.checkNotNullParameter(navigateToDownloadScreen, "navigateToDownloadScreen");
        Composer startRestartGroup = composer.startRestartGroup(1326952576);
        ComposerKt.sourceInformation(startRestartGroup, "C(ClassicSetupDialogRoute)N(component,onBackClick,navigateToDownloadScreen)18@903L150:ClassicDialogsRoutes.kt#ufav3r");
        if ((i & 6) == 0) {
            i2 = ((i & 8) == 0 ? startRestartGroup.changed(component) : startRestartGroup.changedInstance(component) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= startRestartGroup.changedInstance(onBackClick) ? 32 : 16;
        }
        if ((i & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
            i2 |= startRestartGroup.changedInstance(navigateToDownloadScreen) ? 256 : 128;
        }
        if (!startRestartGroup.shouldExecute((i2 & 147) != 146, i2 & 1)) {
            startRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1326952576, i2, -1, "com.miami.game.ui.classic.dialogs.ClassicSetupDialogRoute (ClassicDialogsRoutes.kt:17)");
            }
            SetupDialogKt.SetupDialogRoute(component, onBackClick, navigateToDownloadScreen, startRestartGroup, CommonDialogComponent.$stable | (i2 & 14) | (i2 & 112) | (i2 & 896));
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: com.miami.game.ui.classic.dialogs.ClassicDialogsRoutesKt$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return ClassicDialogsRoutesKt.ClassicSetupDialogRoute$lambda$0(CommonDialogComponent.this, onBackClick, navigateToDownloadScreen, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    public static final void ClassicRepairGameDialogRoute(ErrorDialogComponent component, Function0<Unit> onBackClick, Function0<Unit> onConfirm, Function0<Unit> onRetry, Composer composer, final int i) {
        int i2;
        final Function0<Unit> function0;
        final Function0<Unit> function02;
        final Function0<Unit> function03;
        final ErrorDialogComponent errorDialogComponent;
        Intrinsics.checkNotNullParameter(component, "component");
        Intrinsics.checkNotNullParameter(onBackClick, "onBackClick");
        Intrinsics.checkNotNullParameter(onConfirm, "onConfirm");
        Intrinsics.checkNotNullParameter(onRetry, "onRetry");
        Composer startRestartGroup = composer.startRestartGroup(-1728959879);
        ComposerKt.sourceInformation(startRestartGroup, "C(ClassicRepairGameDialogRoute)N(component,onBackClick,onConfirm,onRetry)32@1229L152:ClassicDialogsRoutes.kt#ufav3r");
        if ((i & 6) == 0) {
            i2 = ((i & 8) == 0 ? startRestartGroup.changed(component) : startRestartGroup.changedInstance(component) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= startRestartGroup.changedInstance(onBackClick) ? 32 : 16;
        }
        if ((i & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
            i2 |= startRestartGroup.changedInstance(onConfirm) ? 256 : 128;
        }
        if ((i & 3072) == 0) {
            i2 |= startRestartGroup.changedInstance(onRetry) ? 2048 : 1024;
        }
        if (!startRestartGroup.shouldExecute((i2 & 1171) != 1170, i2 & 1)) {
            function0 = onRetry;
            function02 = onConfirm;
            function03 = onBackClick;
            errorDialogComponent = component;
            startRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1728959879, i2, -1, "com.miami.game.ui.classic.dialogs.ClassicRepairGameDialogRoute (ClassicDialogsRoutes.kt:31)");
            }
            RepairGameDialogKt.RepairGameDialogRoute(component, onBackClick, onConfirm, onRetry, startRestartGroup, ErrorDialogComponent.$stable | (i2 & 14) | (i2 & 112) | (i2 & 896) | (i2 & 7168));
            errorDialogComponent = component;
            function03 = onBackClick;
            function02 = onConfirm;
            function0 = onRetry;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: com.miami.game.ui.classic.dialogs.ClassicDialogsRoutesKt$$ExternalSyntheticLambda2
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return ClassicDialogsRoutesKt.ClassicRepairGameDialogRoute$lambda$0(ErrorDialogComponent.this, function03, function02, function0, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    public static final void ClassicRepairGameErrorDialogRoute(final CommonDialogComponent component, final Function0<Unit> onBackClick, final Function0<Unit> onConfirm, Composer composer, final int i) {
        int i2;
        Intrinsics.checkNotNullParameter(component, "component");
        Intrinsics.checkNotNullParameter(onBackClick, "onBackClick");
        Intrinsics.checkNotNullParameter(onConfirm, "onConfirm");
        Composer startRestartGroup = composer.startRestartGroup(1049868628);
        ComposerKt.sourceInformation(startRestartGroup, "C(ClassicRepairGameErrorDialogRoute)N(component,onBackClick,onConfirm)46@1538L130:ClassicDialogsRoutes.kt#ufav3r");
        if ((i & 6) == 0) {
            i2 = ((i & 8) == 0 ? startRestartGroup.changed(component) : startRestartGroup.changedInstance(component) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= startRestartGroup.changedInstance(onBackClick) ? 32 : 16;
        }
        if ((i & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
            i2 |= startRestartGroup.changedInstance(onConfirm) ? 256 : 128;
        }
        if (!startRestartGroup.shouldExecute((i2 & 147) != 146, i2 & 1)) {
            startRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1049868628, i2, -1, "com.miami.game.ui.classic.dialogs.ClassicRepairGameErrorDialogRoute (ClassicDialogsRoutes.kt:45)");
            }
            RepairGameErrorKt.RepairGameErrorDialogRoute(component, onBackClick, onConfirm, startRestartGroup, CommonDialogComponent.$stable | (i2 & 14) | (i2 & 112) | (i2 & 896));
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: com.miami.game.ui.classic.dialogs.ClassicDialogsRoutesKt$$ExternalSyntheticLambda6
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return ClassicDialogsRoutesKt.ClassicRepairGameErrorDialogRoute$lambda$0(CommonDialogComponent.this, onBackClick, onConfirm, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    public static final void ClassicRepairGameSuccessDialogRoute(final CommonDialogComponent component, final Function0<Unit> onBackClick, final Function0<Unit> onConfirm, Composer composer, final int i) {
        int i2;
        Intrinsics.checkNotNullParameter(component, "component");
        Intrinsics.checkNotNullParameter(onBackClick, "onBackClick");
        Intrinsics.checkNotNullParameter(onConfirm, "onConfirm");
        Composer startRestartGroup = composer.startRestartGroup(1847513209);
        ComposerKt.sourceInformation(startRestartGroup, "C(ClassicRepairGameSuccessDialogRoute)N(component,onBackClick,onConfirm)59@1827L132:ClassicDialogsRoutes.kt#ufav3r");
        if ((i & 6) == 0) {
            i2 = ((i & 8) == 0 ? startRestartGroup.changed(component) : startRestartGroup.changedInstance(component) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= startRestartGroup.changedInstance(onBackClick) ? 32 : 16;
        }
        if ((i & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
            i2 |= startRestartGroup.changedInstance(onConfirm) ? 256 : 128;
        }
        if (!startRestartGroup.shouldExecute((i2 & 147) != 146, i2 & 1)) {
            startRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1847513209, i2, -1, "com.miami.game.ui.classic.dialogs.ClassicRepairGameSuccessDialogRoute (ClassicDialogsRoutes.kt:58)");
            }
            RepairGameSuccessKt.RepairGameSuccessDialogRoute(component, onBackClick, onConfirm, startRestartGroup, CommonDialogComponent.$stable | (i2 & 14) | (i2 & 112) | (i2 & 896));
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: com.miami.game.ui.classic.dialogs.ClassicDialogsRoutesKt$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return ClassicDialogsRoutesKt.ClassicRepairGameSuccessDialogRoute$lambda$0(CommonDialogComponent.this, onBackClick, onConfirm, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    public static final void ClassicNoNetworkErrorDialogRoute(final ErrorDialogComponent component, final Function0<Unit> onBackClick, final Function0<Unit> onRetry, Composer composer, final int i) {
        int i2;
        Intrinsics.checkNotNullParameter(component, "component");
        Intrinsics.checkNotNullParameter(onBackClick, "onBackClick");
        Intrinsics.checkNotNullParameter(onRetry, "onRetry");
        Composer startRestartGroup = composer.startRestartGroup(1652771945);
        ComposerKt.sourceInformation(startRestartGroup, "C(ClassicNoNetworkErrorDialogRoute)N(component,onBackClick,onRetry)72@2112L125:ClassicDialogsRoutes.kt#ufav3r");
        if ((i & 6) == 0) {
            i2 = ((i & 8) == 0 ? startRestartGroup.changed(component) : startRestartGroup.changedInstance(component) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= startRestartGroup.changedInstance(onBackClick) ? 32 : 16;
        }
        if ((i & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
            i2 |= startRestartGroup.changedInstance(onRetry) ? 256 : 128;
        }
        if (!startRestartGroup.shouldExecute((i2 & 147) != 146, i2 & 1)) {
            startRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1652771945, i2, -1, "com.miami.game.ui.classic.dialogs.ClassicNoNetworkErrorDialogRoute (ClassicDialogsRoutes.kt:71)");
            }
            NoNetworkErrorDialogKt.NoNetworkErrorDialogRoute(component, onBackClick, onRetry, startRestartGroup, ErrorDialogComponent.$stable | (i2 & 14) | (i2 & 112) | (i2 & 896));
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: com.miami.game.ui.classic.dialogs.ClassicDialogsRoutesKt$$ExternalSyntheticLambda5
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return ClassicDialogsRoutesKt.ClassicNoNetworkErrorDialogRoute$lambda$0(ErrorDialogComponent.this, onBackClick, onRetry, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    public static final void ClassicErrorDialogFromActivityRoute(ErrorDialogComponent errorDialogComponent, final Function0<Unit> onBackClick, Function0<Unit> function0, Composer composer, final int i, final int i2) {
        int i3;
        final ErrorDialogComponent errorDialogComponent2;
        Composer composer2;
        final Function0<Unit> function02;
        Function0<Unit> function03;
        Intrinsics.checkNotNullParameter(onBackClick, "onBackClick");
        Composer startRestartGroup = composer.startRestartGroup(-425391289);
        ComposerKt.sourceInformation(startRestartGroup, "C(ClassicErrorDialogFromActivityRoute)N(component,onBackClick,onRetry)83@2394L2,85@2406L128:ClassicDialogsRoutes.kt#ufav3r");
        int i4 = i2 & 1;
        if (i4 != 0) {
            i3 = i | 6;
        } else if ((i & 6) == 0) {
            i3 = ((i & 8) == 0 ? startRestartGroup.changed(errorDialogComponent) : startRestartGroup.changedInstance(errorDialogComponent) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        if ((i & 48) == 0) {
            i3 |= startRestartGroup.changedInstance(onBackClick) ? 32 : 16;
        }
        int i5 = i2 & 4;
        if (i5 != 0) {
            i3 |= RendererCapabilities.DECODER_SUPPORT_MASK;
        } else if ((i & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
            i3 |= startRestartGroup.changedInstance(function0) ? 256 : 128;
        }
        if (!startRestartGroup.shouldExecute((i3 & 147) != 146, i3 & 1)) {
            startRestartGroup.skipToGroupEnd();
            errorDialogComponent2 = errorDialogComponent;
            composer2 = startRestartGroup;
            function02 = function0;
        } else {
            ErrorDialogComponent errorDialogComponent3 = i4 != 0 ? null : errorDialogComponent;
            if (i5 != 0) {
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, -779131095, "CC(remember):ClassicDialogsRoutes.kt#9igjgp");
                Object rememberedValue = startRestartGroup.rememberedValue();
                if (rememberedValue == Composer.Companion.getEmpty()) {
                    rememberedValue = new Function0() { // from class: com.miami.game.ui.classic.dialogs.ClassicDialogsRoutesKt$$ExternalSyntheticLambda3
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            Unit unit;
                            unit = Unit.INSTANCE;
                            return unit;
                        }
                    };
                    startRestartGroup.updateRememberedValue(rememberedValue);
                }
                function03 = (Function0) rememberedValue;
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            } else {
                function03 = function0;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-425391289, i3, -1, "com.miami.game.ui.classic.dialogs.ClassicErrorDialogFromActivityRoute (ClassicDialogsRoutes.kt:84)");
            }
            Function0<Unit> function04 = function03;
            ErrorDialogFromActivityKt.ErrorDialogFromActivityRoute(errorDialogComponent3, onBackClick, function04, startRestartGroup, ErrorDialogComponent.$stable | (i3 & 14) | (i3 & 112) | (i3 & 896), 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            errorDialogComponent2 = errorDialogComponent3;
            composer2 = startRestartGroup;
            function02 = function04;
        }
        ScopeUpdateScope endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: com.miami.game.ui.classic.dialogs.ClassicDialogsRoutesKt$$ExternalSyntheticLambda4
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return ClassicDialogsRoutesKt.ClassicErrorDialogFromActivityRoute$lambda$1(ErrorDialogComponent.this, onBackClick, function02, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }
}
