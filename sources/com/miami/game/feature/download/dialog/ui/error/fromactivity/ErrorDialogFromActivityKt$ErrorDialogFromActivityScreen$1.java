package com.miami.game.feature.download.dialog.ui.error.fromactivity;

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
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.ColorFilter;
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
import androidx.media3.exoplayer.RendererCapabilities;
import androidx.media3.extractor.WavUtil;
import com.miami.game.core.design.system.component.button.DialogButtonKt;
import com.miami.game.core.design.system.component.dialog_frame.DialogDescriptionTextKt;
import com.miami.game.core.drawable.resources.R;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: ErrorDialogFromActivity.kt */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes4.dex */
final class ErrorDialogFromActivityKt$ErrorDialogFromActivityScreen$1 implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ Function0<Unit> $onConfirm;
    final /* synthetic */ Function0<Unit> $onDismiss;
    final /* synthetic */ long $textColor;
    final /* synthetic */ ErrorDialogExternalUiState $uiState;

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

    /* JADX INFO: Access modifiers changed from: package-private */
    public ErrorDialogFromActivityKt$ErrorDialogFromActivityScreen$1(ErrorDialogExternalUiState errorDialogExternalUiState, long j, Function0<Unit> function0, Function0<Unit> function02) {
        this.$uiState = errorDialogExternalUiState;
        this.$textColor = j;
        this.$onDismiss = function0;
        this.$onConfirm = function02;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
        invoke(composer, num.intValue());
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit invoke$lambda$4$lambda$1$lambda$0(Function0 function0) {
        function0.invoke();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit invoke$lambda$4$lambda$3$lambda$2(Function0 function0) {
        function0.invoke();
        return Unit.INSTANCE;
    }

    public final void invoke(Composer composer, int i) {
        int i2;
        ComposerKt.sourceInformation(composer, "C74@2689L10,74@2662L114,96@3414L54,94@3394L186,103@3589L42,104@3640L710:ErrorDialogFromActivity.kt#11d4x");
        if ((i & 3) != 2 || !composer.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-210437023, i, -1, "com.miami.game.feature.download.dialog.ui.error.fromactivity.ErrorDialogFromActivityScreen.<anonymous> (ErrorDialogFromActivity.kt:74)");
            }
            TextKt.m2497Text4IGK_g(this.$uiState.getTitle(), (Modifier) null, this.$textColor, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, MaterialTheme.INSTANCE.getTypography(composer, MaterialTheme.$stable).getBodyMedium(), composer, 0, 0, 65530);
            int i3 = WhenMappings.$EnumSwitchMapping$0[this.$uiState.getType().ordinal()];
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
            DialogDescriptionTextKt.DialogDescriptionText(this.$uiState.getDescription(), composer, 0);
            final ErrorDialogExternalUiState errorDialogExternalUiState = this.$uiState;
            final Function0<Unit> function0 = this.$onDismiss;
            final Function0<Unit> function02 = this.$onConfirm;
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
            composer.startReplaceGroup(628166803);
            ComposerKt.sourceInformation(composer, "106@3738L51,108@3791L187,106@3713L265");
            if (errorDialogExternalUiState.getNegativeText().length() != 0) {
                composer.startReplaceGroup(5004770);
                ComposerKt.sourceInformation(composer, "CC(remember):ErrorDialogFromActivity.kt#9igjgp");
                boolean changed = composer.changed(function0);
                Object rememberedValue = composer.rememberedValue();
                if (changed || rememberedValue == Composer.Companion.getEmpty()) {
                    rememberedValue = new Function0() { // from class: com.miami.game.feature.download.dialog.ui.error.fromactivity.ErrorDialogFromActivityKt$ErrorDialogFromActivityScreen$1$$ExternalSyntheticLambda0
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            Unit invoke$lambda$4$lambda$1$lambda$0;
                            invoke$lambda$4$lambda$1$lambda$0 = ErrorDialogFromActivityKt$ErrorDialogFromActivityScreen$1.invoke$lambda$4$lambda$1$lambda$0(Function0.this);
                            return invoke$lambda$4$lambda$1$lambda$0;
                        }
                    };
                    composer.updateRememberedValue(rememberedValue);
                }
                composer.endReplaceGroup();
                DialogButtonKt.DialogButtonNo((Function0) rememberedValue, ComposableLambdaKt.rememberComposableLambda(-1469251392, true, new Function3<BoxScope, Composer, Integer, Unit>() { // from class: com.miami.game.feature.download.dialog.ui.error.fromactivity.ErrorDialogFromActivityKt$ErrorDialogFromActivityScreen$1$1$2
                    @Override // kotlin.jvm.functions.Function3
                    public /* bridge */ /* synthetic */ Unit invoke(BoxScope boxScope, Composer composer2, Integer num) {
                        invoke(boxScope, composer2, num.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(BoxScope DialogButtonNo, Composer composer2, int i4) {
                        Intrinsics.checkNotNullParameter(DialogButtonNo, "$this$DialogButtonNo");
                        ComposerKt.sourceInformation(composer2, "C110@3865L10,109@3813L147:ErrorDialogFromActivity.kt#11d4x");
                        if ((i4 & 17) == 16 && composer2.getSkipping()) {
                            composer2.skipToGroupEnd();
                            return;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-1469251392, i4, -1, "com.miami.game.feature.download.dialog.ui.error.fromactivity.ErrorDialogFromActivityScreen.<anonymous>.<anonymous>.<anonymous> (ErrorDialogFromActivity.kt:109)");
                        }
                        TextKt.m2497Text4IGK_g(ErrorDialogExternalUiState.this.getNegativeText(), (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, MaterialTheme.INSTANCE.getTypography(composer2, MaterialTheme.$stable).getBodySmall(), composer2, 0, 0, (int) WavUtil.TYPE_WAVE_FORMAT_EXTENSIBLE);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                    }
                }, composer, 54), composer, 48);
            }
            composer.endReplaceGroup();
            composer.startReplaceGroup(628177908);
            ComposerKt.sourceInformation(composer, "116@4086L51,118@4139L187,116@4060L266");
            if (errorDialogExternalUiState.getPositiveText().length() != 0) {
                composer.startReplaceGroup(5004770);
                ComposerKt.sourceInformation(composer, "CC(remember):ErrorDialogFromActivity.kt#9igjgp");
                boolean changed2 = composer.changed(function02);
                Object rememberedValue2 = composer.rememberedValue();
                if (changed2 || rememberedValue2 == Composer.Companion.getEmpty()) {
                    rememberedValue2 = new Function0() { // from class: com.miami.game.feature.download.dialog.ui.error.fromactivity.ErrorDialogFromActivityKt$ErrorDialogFromActivityScreen$1$$ExternalSyntheticLambda1
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            Unit invoke$lambda$4$lambda$3$lambda$2;
                            invoke$lambda$4$lambda$3$lambda$2 = ErrorDialogFromActivityKt$ErrorDialogFromActivityScreen$1.invoke$lambda$4$lambda$3$lambda$2(Function0.this);
                            return invoke$lambda$4$lambda$3$lambda$2;
                        }
                    };
                    composer.updateRememberedValue(rememberedValue2);
                }
                composer.endReplaceGroup();
                DialogButtonKt.DialogButtonYes((Function0) rememberedValue2, false, ComposableLambdaKt.rememberComposableLambda(1442369824, true, new Function3<BoxScope, Composer, Integer, Unit>() { // from class: com.miami.game.feature.download.dialog.ui.error.fromactivity.ErrorDialogFromActivityKt$ErrorDialogFromActivityScreen$1$1$4
                    @Override // kotlin.jvm.functions.Function3
                    public /* bridge */ /* synthetic */ Unit invoke(BoxScope boxScope, Composer composer2, Integer num) {
                        invoke(boxScope, composer2, num.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(BoxScope DialogButtonYes, Composer composer2, int i4) {
                        Intrinsics.checkNotNullParameter(DialogButtonYes, "$this$DialogButtonYes");
                        ComposerKt.sourceInformation(composer2, "C120@4213L10,119@4161L147:ErrorDialogFromActivity.kt#11d4x");
                        if ((i4 & 17) == 16 && composer2.getSkipping()) {
                            composer2.skipToGroupEnd();
                            return;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(1442369824, i4, -1, "com.miami.game.feature.download.dialog.ui.error.fromactivity.ErrorDialogFromActivityScreen.<anonymous>.<anonymous>.<anonymous> (ErrorDialogFromActivity.kt:119)");
                        }
                        TextKt.m2497Text4IGK_g(ErrorDialogExternalUiState.this.getPositiveText(), (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, MaterialTheme.INSTANCE.getTypography(composer2, MaterialTheme.$stable).getBodySmall(), composer2, 0, 0, (int) WavUtil.TYPE_WAVE_FORMAT_EXTENSIBLE);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                    }
                }, composer, 54), composer, RendererCapabilities.DECODER_SUPPORT_MASK, 2);
            }
            composer.endReplaceGroup();
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            composer.endNode();
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
                return;
            }
            return;
        }
        composer.skipToGroupEnd();
    }
}
