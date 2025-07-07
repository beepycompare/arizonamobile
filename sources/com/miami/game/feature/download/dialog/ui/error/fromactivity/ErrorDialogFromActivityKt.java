package com.miami.game.feature.download.dialog.ui.error.fromactivity;

import androidx.activity.compose.BackHandlerKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.State;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.graphics.ColorKt;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.compose.FlowExtKt;
import androidx.media3.exoplayer.RendererCapabilities;
import com.miami.game.core.design.system.component.dialog_frame.DialogFrameKt;
import com.miami.game.core.drawable.resources.R;
import com.miami.game.feature.download.dialog.ui.error.ErrorDialogComponent;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: ErrorDialogFromActivity.kt */
@Metadata(d1 = {"\u0000\u001e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a7\u0010\u0000\u001a\u00020\u00012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00010\u00052\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00010\u0005H\u0007¢\u0006\u0002\u0010\u0007\u001a?\u0010\b\u001a\u00020\u00012\u0006\u0010\t\u001a\u00020\n2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00010\u00052\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00010\u00052\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00010\u0005H\u0001¢\u0006\u0002\u0010\u000e¨\u0006\u000f²\u0006\n\u0010\t\u001a\u00020\nX\u008a\u0084\u0002"}, d2 = {"ErrorDialogFromActivityRoute", "", "component", "Lcom/miami/game/feature/download/dialog/ui/error/ErrorDialogComponent;", "onBackClick", "Lkotlin/Function0;", "onRetry", "(Lcom/miami/game/feature/download/dialog/ui/error/ErrorDialogComponent;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;II)V", "ErrorDialogFromActivityScreen", "uiState", "Lcom/miami/game/feature/download/dialog/ui/error/fromactivity/ErrorDialogExternalUiState;", "onConfirm", "onDismiss", "onClose", "(Lcom/miami/game/feature/download/dialog/ui/error/fromactivity/ErrorDialogExternalUiState;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)V", "dialogs_release_web"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class ErrorDialogFromActivityKt {

    /* compiled from: ErrorDialogFromActivity.kt */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[ErrorDialogType.values().length];
            try {
                iArr[ErrorDialogType.Base.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[ErrorDialogType.Alert.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[ErrorDialogType.Download.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[ErrorDialogType.ConnectionError.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[ErrorDialogType.Repair.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ErrorDialogFromActivityRoute$lambda$3(ErrorDialogComponent errorDialogComponent, Function0 function0, Function0 function02, int i, int i2, Composer composer, int i3) {
        ErrorDialogFromActivityRoute(errorDialogComponent, function0, function02, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ErrorDialogFromActivityScreen$lambda$4(ErrorDialogExternalUiState errorDialogExternalUiState, Function0 function0, Function0 function02, Function0 function03, int i, Composer composer, int i2) {
        ErrorDialogFromActivityScreen(errorDialogExternalUiState, function0, function02, function03, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    public static final void ErrorDialogFromActivityRoute(ErrorDialogComponent errorDialogComponent, final Function0<Unit> onBackClick, Function0<Unit> function0, Composer composer, final int i, final int i2) {
        int i3;
        Function0<Unit> function02;
        Composer composer2;
        final ErrorDialogComponent errorDialogComponent2;
        final Function0<Unit> function03;
        Intrinsics.checkNotNullParameter(onBackClick, "onBackClick");
        Composer startRestartGroup = composer.startRestartGroup(-1201710095);
        ComposerKt.sourceInformation(startRestartGroup, "C(ErrorDialogFromActivityRoute)30@1432L2,32@1443L33,34@1536L29,36@1571L223:ErrorDialogFromActivity.kt#11d4x");
        if ((i2 & 2) != 0) {
            i3 = i | 48;
        } else if ((i & 48) == 0) {
            i3 = i | (startRestartGroup.changedInstance(onBackClick) ? 32 : 16);
        } else {
            i3 = i;
        }
        if ((i3 & 17) != 16 || !startRestartGroup.getSkipping()) {
            ErrorDialogComponent errorDialogComponent3 = (i2 & 1) != 0 ? null : errorDialogComponent;
            if ((i2 & 4) != 0) {
                startRestartGroup.startReplaceGroup(1849434622);
                ComposerKt.sourceInformation(startRestartGroup, "CC(remember):ErrorDialogFromActivity.kt#9igjgp");
                Object rememberedValue = startRestartGroup.rememberedValue();
                if (rememberedValue == Composer.Companion.getEmpty()) {
                    rememberedValue = new Function0() { // from class: com.miami.game.feature.download.dialog.ui.error.fromactivity.ErrorDialogFromActivityKt$$ExternalSyntheticLambda0
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            Unit unit;
                            unit = Unit.INSTANCE;
                            return unit;
                        }
                    };
                    startRestartGroup.updateRememberedValue(rememberedValue);
                }
                startRestartGroup.endReplaceGroup();
                function02 = (Function0) rememberedValue;
            } else {
                function02 = function0;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1201710095, i3, -1, "com.miami.game.feature.download.dialog.ui.error.fromactivity.ErrorDialogFromActivityRoute (ErrorDialogFromActivity.kt:31)");
            }
            BackHandlerKt.BackHandler(false, onBackClick, startRestartGroup, i3 & 112, 1);
            composer2 = startRestartGroup;
            ErrorDialogFromActivityScreen(ErrorDialogFromActivityRoute$lambda$2(FlowExtKt.collectAsStateWithLifecycle(ErrorDialogExternalUiStateHolder.INSTANCE.getState(), (LifecycleOwner) null, (Lifecycle.State) null, (CoroutineContext) null, composer2, 0, 7)), ErrorDialogExternalUiStateHolder.INSTANCE.getOnPositive(), ErrorDialogExternalUiStateHolder.INSTANCE.getOnNegative(), onBackClick, composer2, (i3 << 6) & 7168);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            errorDialogComponent2 = errorDialogComponent3;
            function03 = function02;
        } else {
            startRestartGroup.skipToGroupEnd();
            errorDialogComponent2 = errorDialogComponent;
            function03 = function0;
            composer2 = startRestartGroup;
        }
        ScopeUpdateScope endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: com.miami.game.feature.download.dialog.ui.error.fromactivity.ErrorDialogFromActivityKt$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit ErrorDialogFromActivityRoute$lambda$3;
                    ErrorDialogFromActivityRoute$lambda$3 = ErrorDialogFromActivityKt.ErrorDialogFromActivityRoute$lambda$3(ErrorDialogComponent.this, onBackClick, function03, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    return ErrorDialogFromActivityRoute$lambda$3;
                }
            });
        }
    }

    public static final void ErrorDialogFromActivityScreen(final ErrorDialogExternalUiState uiState, final Function0<Unit> onConfirm, final Function0<Unit> onDismiss, final Function0<Unit> onClose, Composer composer, final int i) {
        int i2;
        long Color;
        Composer composer2;
        Intrinsics.checkNotNullParameter(uiState, "uiState");
        Intrinsics.checkNotNullParameter(onConfirm, "onConfirm");
        Intrinsics.checkNotNullParameter(onDismiss, "onDismiss");
        Intrinsics.checkNotNullParameter(onClose, "onClose");
        Composer startRestartGroup = composer.startRestartGroup(-2064150151);
        ComposerKt.sourceInformation(startRestartGroup, "C(ErrorDialogFromActivityScreen)P(3,1,2)73@2652L1705,73@2620L1737:ErrorDialogFromActivity.kt#11d4x");
        if ((i & 6) == 0) {
            i2 = (startRestartGroup.changed(uiState) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= startRestartGroup.changedInstance(onConfirm) ? 32 : 16;
        }
        if ((i & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
            i2 |= startRestartGroup.changedInstance(onDismiss) ? 256 : 128;
        }
        if ((i & 3072) == 0) {
            i2 |= startRestartGroup.changedInstance(onClose) ? 2048 : 1024;
        }
        int i3 = i2;
        if ((i3 & 1171) != 1170 || !startRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-2064150151, i3, -1, "com.miami.game.feature.download.dialog.ui.error.fromactivity.ErrorDialogFromActivityScreen (ErrorDialogFromActivity.kt:51)");
            }
            int i4 = WhenMappings.$EnumSwitchMapping$0[uiState.getType().ordinal()];
            Integer num = null;
            if (i4 != 1 && i4 != 2) {
                if (i4 == 3) {
                    num = Integer.valueOf(R.drawable.dialog_frame_background_download_icon);
                } else if (i4 == 4) {
                    num = Integer.valueOf(R.drawable.dialog_frame_no_network_background_icon);
                }
            }
            Integer num2 = num;
            if (WhenMappings.$EnumSwitchMapping$0[uiState.getType().ordinal()] == 5) {
                Color = ColorKt.Color(4293066608L);
            } else {
                Color = ColorKt.Color(4293205330L);
            }
            composer2 = startRestartGroup;
            DialogFrameKt.DialogFrame(num2, onClose, ComposableLambdaKt.rememberComposableLambda(-210437023, true, new ErrorDialogFromActivityKt$ErrorDialogFromActivityScreen$1(uiState, Color, onDismiss, onConfirm), startRestartGroup, 54), composer2, ((i3 >> 6) & 112) | RendererCapabilities.DECODER_SUPPORT_MASK, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            startRestartGroup.skipToGroupEnd();
            composer2 = startRestartGroup;
        }
        ScopeUpdateScope endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: com.miami.game.feature.download.dialog.ui.error.fromactivity.ErrorDialogFromActivityKt$$ExternalSyntheticLambda2
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit ErrorDialogFromActivityScreen$lambda$4;
                    ErrorDialogFromActivityScreen$lambda$4 = ErrorDialogFromActivityKt.ErrorDialogFromActivityScreen$lambda$4(ErrorDialogExternalUiState.this, onConfirm, onDismiss, onClose, i, (Composer) obj, ((Integer) obj2).intValue());
                    return ErrorDialogFromActivityScreen$lambda$4;
                }
            });
        }
    }

    private static final ErrorDialogExternalUiState ErrorDialogFromActivityRoute$lambda$2(State<ErrorDialogExternalUiState> state) {
        return state.getValue();
    }
}
