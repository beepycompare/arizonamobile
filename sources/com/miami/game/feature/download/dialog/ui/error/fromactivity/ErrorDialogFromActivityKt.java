package com.miami.game.feature.download.dialog.ui.error.fromactivity;

import androidx.activity.compose.BackHandlerKt;
import androidx.compose.foundation.ImageKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxScope;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.material3.MaterialTheme;
import androidx.compose.material3.MenuKt;
import androidx.compose.material3.TextKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.layout.ContentScale;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.res.PainterResources_androidKt;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.unit.Dp;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.compose.FlowExtKt;
import androidx.media3.exoplayer.RendererCapabilities;
import androidx.media3.extractor.WavUtil;
import com.miami.game.core.design.system.component.button.DialogButtonKt;
import com.miami.game.core.design.system.component.dialog_frame.DialogDescriptionTextKt;
import com.miami.game.core.design.system.component.dialog_frame.DialogFrameKt;
import com.miami.game.core.drawable.resources.R;
import com.miami.game.feature.download.dialog.ui.error.ErrorDialogComponent;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: ErrorDialogFromActivity.kt */
@Metadata(d1 = {"\u0000\u001e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a7\u0010\u0000\u001a\u00020\u00012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00010\u00052\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00010\u0005H\u0007¢\u0006\u0002\u0010\u0007\u001a?\u0010\b\u001a\u00020\u00012\u0006\u0010\t\u001a\u00020\n2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00010\u00052\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00010\u00052\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00010\u0005H\u0001¢\u0006\u0002\u0010\u000e¨\u0006\u000f²\u0006\n\u0010\t\u001a\u00020\nX\u008a\u0084\u0002"}, d2 = {"ErrorDialogFromActivityRoute", "", "component", "Lcom/miami/game/feature/download/dialog/ui/error/ErrorDialogComponent;", "onBackClick", "Lkotlin/Function0;", "onRetry", "(Lcom/miami/game/feature/download/dialog/ui/error/ErrorDialogComponent;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;II)V", "ErrorDialogFromActivityScreen", "uiState", "Lcom/miami/game/feature/download/dialog/ui/error/fromactivity/ErrorDialogExternalUiState;", "onConfirm", "onDismiss", "onClose", "(Lcom/miami/game/feature/download/dialog/ui/error/fromactivity/ErrorDialogExternalUiState;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)V", "dialogs_release_web"}, k = 2, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class ErrorDialogFromActivityKt {

    /* compiled from: ErrorDialogFromActivity.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public static final /* synthetic */ class WhenMappings {
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
    public static final Unit ErrorDialogFromActivityScreen$lambda$12(ErrorDialogExternalUiState errorDialogExternalUiState, Function0 function0, Function0 function02, Function0 function03, int i, Composer composer, int i2) {
        ErrorDialogFromActivityScreen(errorDialogExternalUiState, function0, function02, function03, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    public static final void ErrorDialogFromActivityRoute(ErrorDialogComponent errorDialogComponent, final Function0<Unit> onBackClick, Function0<Unit> function0, Composer composer, final int i, final int i2) {
        int i3;
        Composer composer2;
        final ErrorDialogComponent errorDialogComponent2;
        final Function0<Unit> function02;
        Function0<Unit> function03;
        Intrinsics.checkNotNullParameter(onBackClick, "onBackClick");
        Composer startRestartGroup = composer.startRestartGroup(-1201710095);
        ComposerKt.sourceInformation(startRestartGroup, "C(ErrorDialogFromActivityRoute)30@1432L2,32@1443L33,34@1536L29,36@1571L223:ErrorDialogFromActivity.kt#11d4x");
        if ((i & 48) == 0) {
            i3 = i | (startRestartGroup.changedInstance(onBackClick) ? 32 : 16);
        } else {
            i3 = i;
        }
        if (!startRestartGroup.shouldExecute((i3 & 17) != 16, i3 & 1)) {
            composer2 = startRestartGroup;
            composer2.skipToGroupEnd();
            errorDialogComponent2 = errorDialogComponent;
            function02 = function0;
        } else {
            ErrorDialogComponent errorDialogComponent3 = (i2 & 1) != 0 ? null : errorDialogComponent;
            if ((i2 & 4) != 0) {
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, 502805971, "CC(remember):ErrorDialogFromActivity.kt#9igjgp");
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
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                function03 = (Function0) rememberedValue;
            } else {
                function03 = function0;
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
            function02 = function03;
        }
        ScopeUpdateScope endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: com.miami.game.feature.download.dialog.ui.error.fromactivity.ErrorDialogFromActivityKt$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit ErrorDialogFromActivityRoute$lambda$3;
                    ErrorDialogFromActivityRoute$lambda$3 = ErrorDialogFromActivityKt.ErrorDialogFromActivityRoute$lambda$3(ErrorDialogComponent.this, onBackClick, function02, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    return ErrorDialogFromActivityRoute$lambda$3;
                }
            });
        }
    }

    public static final void ErrorDialogFromActivityScreen(final ErrorDialogExternalUiState uiState, final Function0<Unit> onConfirm, final Function0<Unit> onDismiss, final Function0<Unit> onClose, Composer composer, final int i) {
        int i2;
        Composer composer2;
        long Color;
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
        if (!startRestartGroup.shouldExecute((i3 & 1171) != 1170, i3 & 1)) {
            composer2 = startRestartGroup;
            composer2.skipToGroupEnd();
        } else {
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
            final long j = Color;
            composer2 = startRestartGroup;
            DialogFrameKt.DialogFrame(num2, onClose, ComposableLambdaKt.rememberComposableLambda(-210437023, true, new Function2() { // from class: com.miami.game.feature.download.dialog.ui.error.fromactivity.ErrorDialogFromActivityKt$$ExternalSyntheticLambda6
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit ErrorDialogFromActivityScreen$lambda$11;
                    ErrorDialogFromActivityScreen$lambda$11 = ErrorDialogFromActivityKt.ErrorDialogFromActivityScreen$lambda$11(ErrorDialogExternalUiState.this, j, onDismiss, onConfirm, (Composer) obj, ((Integer) obj2).intValue());
                    return ErrorDialogFromActivityScreen$lambda$11;
                }
            }, startRestartGroup, 54), composer2, ((i3 >> 6) & 112) | RendererCapabilities.DECODER_SUPPORT_MASK, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: com.miami.game.feature.download.dialog.ui.error.fromactivity.ErrorDialogFromActivityKt$$ExternalSyntheticLambda7
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit ErrorDialogFromActivityScreen$lambda$12;
                    ErrorDialogFromActivityScreen$lambda$12 = ErrorDialogFromActivityKt.ErrorDialogFromActivityScreen$lambda$12(ErrorDialogExternalUiState.this, onConfirm, onDismiss, onClose, i, (Composer) obj, ((Integer) obj2).intValue());
                    return ErrorDialogFromActivityScreen$lambda$12;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ErrorDialogFromActivityScreen$lambda$11(final ErrorDialogExternalUiState errorDialogExternalUiState, long j, final Function0 function0, final Function0 function02, Composer composer, int i) {
        int i2;
        ComposerKt.sourceInformation(composer, "C74@2689L10,74@2662L114,96@3414L54,94@3394L186,103@3589L42,104@3640L710:ErrorDialogFromActivity.kt#11d4x");
        if (composer.shouldExecute((i & 3) != 2, i & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-210437023, i, -1, "com.miami.game.feature.download.dialog.ui.error.fromactivity.ErrorDialogFromActivityScreen.<anonymous> (ErrorDialogFromActivity.kt:74)");
            }
            TextKt.m2497Text4IGK_g(errorDialogExternalUiState.getTitle(), (Modifier) null, j, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, MaterialTheme.INSTANCE.getTypography(composer, MaterialTheme.$stable).getBodyMedium(), composer, 0, 0, 65530);
            int i3 = WhenMappings.$EnumSwitchMapping$0[errorDialogExternalUiState.getType().ordinal()];
            if (i3 == 1) {
                i2 = R.drawable.dialog_frame_check_files_error;
            } else if (i3 == 2) {
                i2 = R.drawable.dialog_frame_check_files_error;
            } else if (i3 == 3) {
                i2 = R.drawable.dialog_frame_download_image;
            } else if (i3 == 4) {
                i2 = R.drawable.dialog_frame_no_network_icon;
            } else if (i3 != 5) {
                throw new NoWhenBranchMatchedException();
            } else {
                i2 = R.drawable.check_files_success_icon;
            }
            ImageKt.Image(PainterResources_androidKt.painterResource(i2, composer, 0), (String) null, SizeKt.m785size3ABfNKs(Modifier.Companion, Dp.m6684constructorimpl(96)), (Alignment) null, (ContentScale) null, 0.0f, (ColorFilter) null, composer, 432, (int) MenuKt.InTransitionDuration);
            DialogDescriptionTextKt.DialogDescriptionText(errorDialogExternalUiState.getDescription(), composer, 0);
            ComposerKt.sourceInformationMarkerStart(composer, 693286680, "CC(Row)P(2,1,3)99@5124L58,100@5187L130:Row.kt#2w3rfo");
            MeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), Alignment.Companion.getTop(), composer, 0);
            ComposerKt.sourceInformationMarkerStart(composer, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer, 0);
            CompositionLocalMap currentCompositionLocalMap = composer.getCurrentCompositionLocalMap();
            Modifier materializeModifier = ComposedModifierKt.materializeModifier(composer, Modifier.Companion);
            Function0<ComposeUiNode> constructor = ComposeUiNode.Companion.getConstructor();
            ComposerKt.sourceInformationMarkerStart(composer, -692256719, "CC(ReusableComposeNode)P(1,2)355@14017L9:Composables.kt#9igjgp");
            if (!(composer.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composer.startReusableNode();
            if (composer.getInserting()) {
                composer.createNode(constructor);
            } else {
                composer.useNode();
            }
            Composer m3520constructorimpl = Updater.m3520constructorimpl(composer);
            Updater.m3527setimpl(m3520constructorimpl, rowMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.m3527setimpl(m3520constructorimpl, currentCompositionLocalMap, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.Companion.getSetCompositeKeyHash();
            if (m3520constructorimpl.getInserting() || !Intrinsics.areEqual(m3520constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                m3520constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                m3520constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            }
            Updater.m3527setimpl(m3520constructorimpl, materializeModifier, ComposeUiNode.Companion.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composer, -407735110, "C101@5232L9:Row.kt#2w3rfo");
            RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composer, -2001654796, "C:ErrorDialogFromActivity.kt#11d4x");
            if (errorDialogExternalUiState.getNegativeText().length() == 0) {
                composer.startReplaceGroup(-2005305667);
            } else {
                composer.startReplaceGroup(-2001630028);
                ComposerKt.sourceInformation(composer, "106@3738L51,108@3791L187,106@3713L265");
                ComposerKt.sourceInformationMarkerStart(composer, 628169080, "CC(remember):ErrorDialogFromActivity.kt#9igjgp");
                boolean changed = composer.changed(function0);
                Object rememberedValue = composer.rememberedValue();
                if (changed || rememberedValue == Composer.Companion.getEmpty()) {
                    rememberedValue = new Function0() { // from class: com.miami.game.feature.download.dialog.ui.error.fromactivity.ErrorDialogFromActivityKt$$ExternalSyntheticLambda2
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            Unit ErrorDialogFromActivityScreen$lambda$11$lambda$10$lambda$5$lambda$4;
                            ErrorDialogFromActivityScreen$lambda$11$lambda$10$lambda$5$lambda$4 = ErrorDialogFromActivityKt.ErrorDialogFromActivityScreen$lambda$11$lambda$10$lambda$5$lambda$4(Function0.this);
                            return ErrorDialogFromActivityScreen$lambda$11$lambda$10$lambda$5$lambda$4;
                        }
                    };
                    composer.updateRememberedValue(rememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd(composer);
                DialogButtonKt.DialogButtonNo((Function0) rememberedValue, ComposableLambdaKt.rememberComposableLambda(-1469251392, true, new Function3() { // from class: com.miami.game.feature.download.dialog.ui.error.fromactivity.ErrorDialogFromActivityKt$$ExternalSyntheticLambda3
                    @Override // kotlin.jvm.functions.Function3
                    public final Object invoke(Object obj, Object obj2, Object obj3) {
                        Unit ErrorDialogFromActivityScreen$lambda$11$lambda$10$lambda$6;
                        ErrorDialogFromActivityScreen$lambda$11$lambda$10$lambda$6 = ErrorDialogFromActivityKt.ErrorDialogFromActivityScreen$lambda$11$lambda$10$lambda$6(ErrorDialogExternalUiState.this, (BoxScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                        return ErrorDialogFromActivityScreen$lambda$11$lambda$10$lambda$6;
                    }
                }, composer, 54), composer, 48);
            }
            composer.endReplaceGroup();
            if (errorDialogExternalUiState.getPositiveText().length() == 0) {
                composer.startReplaceGroup(-2005305667);
                composer.endReplaceGroup();
            } else {
                composer.startReplaceGroup(-2001285773);
                ComposerKt.sourceInformation(composer, "116@4086L51,118@4139L187,116@4060L266");
                ComposerKt.sourceInformationMarkerStart(composer, 628180216, "CC(remember):ErrorDialogFromActivity.kt#9igjgp");
                boolean changed2 = composer.changed(function02);
                Object rememberedValue2 = composer.rememberedValue();
                if (changed2 || rememberedValue2 == Composer.Companion.getEmpty()) {
                    rememberedValue2 = new Function0() { // from class: com.miami.game.feature.download.dialog.ui.error.fromactivity.ErrorDialogFromActivityKt$$ExternalSyntheticLambda4
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            Unit ErrorDialogFromActivityScreen$lambda$11$lambda$10$lambda$8$lambda$7;
                            ErrorDialogFromActivityScreen$lambda$11$lambda$10$lambda$8$lambda$7 = ErrorDialogFromActivityKt.ErrorDialogFromActivityScreen$lambda$11$lambda$10$lambda$8$lambda$7(Function0.this);
                            return ErrorDialogFromActivityScreen$lambda$11$lambda$10$lambda$8$lambda$7;
                        }
                    };
                    composer.updateRememberedValue(rememberedValue2);
                }
                ComposerKt.sourceInformationMarkerEnd(composer);
                DialogButtonKt.DialogButtonYes((Function0) rememberedValue2, false, ComposableLambdaKt.rememberComposableLambda(1442369824, true, new Function3() { // from class: com.miami.game.feature.download.dialog.ui.error.fromactivity.ErrorDialogFromActivityKt$$ExternalSyntheticLambda5
                    @Override // kotlin.jvm.functions.Function3
                    public final Object invoke(Object obj, Object obj2, Object obj3) {
                        Unit ErrorDialogFromActivityScreen$lambda$11$lambda$10$lambda$9;
                        ErrorDialogFromActivityScreen$lambda$11$lambda$10$lambda$9 = ErrorDialogFromActivityKt.ErrorDialogFromActivityScreen$lambda$11$lambda$10$lambda$9(ErrorDialogExternalUiState.this, (BoxScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                        return ErrorDialogFromActivityScreen$lambda$11$lambda$10$lambda$9;
                    }
                }, composer, 54), composer, RendererCapabilities.DECODER_SUPPORT_MASK, 2);
                composer.endReplaceGroup();
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            composer.endNode();
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ErrorDialogFromActivityScreen$lambda$11$lambda$10$lambda$5$lambda$4(Function0 function0) {
        function0.invoke();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ErrorDialogFromActivityScreen$lambda$11$lambda$10$lambda$6(ErrorDialogExternalUiState errorDialogExternalUiState, BoxScope DialogButtonNo, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(DialogButtonNo, "$this$DialogButtonNo");
        ComposerKt.sourceInformation(composer, "C110@3865L10,109@3813L147:ErrorDialogFromActivity.kt#11d4x");
        if (!composer.shouldExecute((i & 17) != 16, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1469251392, i, -1, "com.miami.game.feature.download.dialog.ui.error.fromactivity.ErrorDialogFromActivityScreen.<anonymous>.<anonymous>.<anonymous> (ErrorDialogFromActivity.kt:109)");
            }
            TextKt.m2497Text4IGK_g(errorDialogExternalUiState.getNegativeText(), (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, MaterialTheme.INSTANCE.getTypography(composer, MaterialTheme.$stable).getBodySmall(), composer, 0, 0, (int) WavUtil.TYPE_WAVE_FORMAT_EXTENSIBLE);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ErrorDialogFromActivityScreen$lambda$11$lambda$10$lambda$8$lambda$7(Function0 function0) {
        function0.invoke();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ErrorDialogFromActivityScreen$lambda$11$lambda$10$lambda$9(ErrorDialogExternalUiState errorDialogExternalUiState, BoxScope DialogButtonYes, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(DialogButtonYes, "$this$DialogButtonYes");
        ComposerKt.sourceInformation(composer, "C120@4213L10,119@4161L147:ErrorDialogFromActivity.kt#11d4x");
        if (!composer.shouldExecute((i & 17) != 16, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1442369824, i, -1, "com.miami.game.feature.download.dialog.ui.error.fromactivity.ErrorDialogFromActivityScreen.<anonymous>.<anonymous>.<anonymous> (ErrorDialogFromActivity.kt:119)");
            }
            TextKt.m2497Text4IGK_g(errorDialogExternalUiState.getPositiveText(), (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, MaterialTheme.INSTANCE.getTypography(composer, MaterialTheme.$stable).getBodySmall(), composer, 0, 0, (int) WavUtil.TYPE_WAVE_FORMAT_EXTENSIBLE);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    private static final ErrorDialogExternalUiState ErrorDialogFromActivityRoute$lambda$2(State<ErrorDialogExternalUiState> state) {
        return state.getValue();
    }
}
