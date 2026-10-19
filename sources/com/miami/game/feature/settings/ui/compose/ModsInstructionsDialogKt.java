package com.miami.game.feature.settings.ui.compose;

import androidx.activity.compose.BackHandlerKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxScope;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.material3.MaterialTheme;
import androidx.compose.material3.TextKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.runtime.saveable.RememberSaveableKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Shadow;
import androidx.compose.ui.graphics.drawscope.DrawStyle;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.PlatformSpanStyle;
import androidx.compose.ui.text.SpanStyle;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontSynthesis;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.font.GenericFontFamily;
import androidx.compose.ui.text.intl.LocaleList;
import androidx.compose.ui.text.style.BaselineShift;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.text.style.TextGeometricTransform;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.TextUnitKt;
import androidx.media3.exoplayer.RendererCapabilities;
import androidx.media3.extractor.text.ttml.TtmlNode;
import com.miami.game.core.design.system.component.button.DialogButtonKt;
import com.miami.game.core.design.system.component.button.DialogCloseButtonKt;
import com.miami.game.core.design.system.component.dialog_frame.DialogFrameKt;
import com.miami.game.ui.classic.settings.R;
import com.miami.game.ui.theme.TypeKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
/* compiled from: ModsInstructionsDialog.kt */
@Metadata(d1 = {"\u0000:\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001aU\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00010\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00010\u00052\u0010\b\u0002\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0005H\u0001b\u0002\b\tb\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\f¢\u0006\u0002\u0010\b\u001a'\u0010\r\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0003b\u0002\b\tb\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\f¢\u0006\u0002\u0010\u000e\u001a5\u0010\u000f\u001a\u00020\u00012\f\b\u0001\u0010\u0010\u001a\u00020\u0011:\u0002\b\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0003b\u0002\b\tb\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\f¢\u0006\u0002\u0010\u0015\u001a5\u0010\u000f\u001a\u00020\u00012\f\b\u0001\u0010\u0010\u001a\u00020\u0011:\u0002\b\u00122\u0006\u0010\u0013\u001a\u00020\u0016H\u0003b\u0002\b\tb\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\f¢\u0006\u0002\u0010\u0017¨\u0006\u0018²\u0006\n\u0010\u0019\u001a\u00020\u0003X\u008a\u008e\u0002"}, d2 = {"ModsInstructionsDialog", "", "isArizona", "", "onConfirm", "Lkotlin/Function0;", "onDismiss", "onDebugMode", "(ZLkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;II)V", "Landroidx/compose/runtime/Composable;", "Landroidx/compose/runtime/ComposableTarget;", "applier", "androidx.compose.ui.UiComposable", "ModsStructureExample", "(ZLandroidx/compose/runtime/Composer;I)V", "ModsInstructionParagraph", "title", "", "Landroidx/annotation/StringRes;", TtmlNode.TAG_BODY, "", "(ILjava/lang/String;Landroidx/compose/runtime/Composer;I)V", "Landroidx/compose/ui/text/AnnotatedString;", "(ILandroidx/compose/ui/text/AnnotatedString;Landroidx/compose/runtime/Composer;I)V", "settings", "showStructure"}, k = 2, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class ModsInstructionsDialogKt {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit ModsInstructionParagraph$lambda$0(int i, String str, int i2, Composer composer, int i3) {
        ModsInstructionParagraph(i, str, composer, RecomposeScopeImplKt.updateChangedFlags(i2 | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit ModsInstructionParagraph$lambda$2(int i, AnnotatedString annotatedString, int i2, Composer composer, int i3) {
        ModsInstructionParagraph(i, annotatedString, composer, RecomposeScopeImplKt.updateChangedFlags(i2 | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit ModsInstructionsDialog$lambda$6(boolean z, Function0 function0, Function0 function02, Function0 function03, int i, int i2, Composer composer, int i3) {
        ModsInstructionsDialog(z, function0, function02, function03, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit ModsStructureExample$lambda$2(boolean z, int i, Composer composer, int i2) {
        ModsStructureExample(z, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    public static final void ModsInstructionsDialog(final boolean z, final Function0<Unit> onConfirm, final Function0<Unit> onDismiss, Function0<Unit> function0, Composer composer, final int i, final int i2) {
        int i3;
        Function0<Unit> function02;
        Intrinsics.checkNotNullParameter(onConfirm, "onConfirm");
        Intrinsics.checkNotNullParameter(onDismiss, "onDismiss");
        Composer startRestartGroup = composer.startRestartGroup(-1701077541);
        ComposerKt.sourceInformation(startRestartGroup, "C(ModsInstructionsDialog)N(isArizona,onConfirm,onDismiss,onDebugMode)48@2097L25,48@2080L42,49@2139L73,49@2127L85:ModsInstructionsDialog.kt#1gr92h");
        if ((i & 6) == 0) {
            i3 = (startRestartGroup.changed(z) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        if ((i & 48) == 0) {
            i3 |= startRestartGroup.changedInstance(onConfirm) ? 32 : 16;
        }
        if ((i & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
            i3 |= startRestartGroup.changedInstance(onDismiss) ? 256 : 128;
        }
        int i4 = i2 & 8;
        if (i4 != 0) {
            i3 |= 3072;
        } else if ((i & 3072) == 0) {
            i3 |= startRestartGroup.changedInstance(function0) ? 2048 : 1024;
        }
        if (!startRestartGroup.shouldExecute((i3 & 1171) != 1170, i3 & 1)) {
            startRestartGroup.skipToGroupEnd();
            function02 = function0;
        } else {
            final Function0<Unit> function03 = i4 != 0 ? null : function0;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1701077541, i3, -1, "com.miami.game.feature.settings.ui.compose.ModsInstructionsDialog (ModsInstructionsDialog.kt:47)");
            }
            Object[] objArr = new Object[0];
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1647029012, "CC(remember):ModsInstructionsDialog.kt#9igjgp");
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (rememberedValue == Composer.Companion.getEmpty()) {
                rememberedValue = new Function0() { // from class: com.miami.game.feature.settings.ui.compose.ModsInstructionsDialogKt$$ExternalSyntheticLambda6
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        MutableState ModsInstructionsDialog$lambda$0$0;
                        ModsInstructionsDialog$lambda$0$0 = ModsInstructionsDialogKt.ModsInstructionsDialog$lambda$0$0();
                        return ModsInstructionsDialog$lambda$0$0;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            final MutableState mutableState = (MutableState) RememberSaveableKt.rememberSaveable(objArr, (Function0) rememberedValue, startRestartGroup, 48);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1647030404, "CC(remember):ModsInstructionsDialog.kt#9igjgp");
            boolean changed = startRestartGroup.changed(mutableState) | ((i3 & 896) == 256);
            Object rememberedValue2 = startRestartGroup.rememberedValue();
            if (changed || rememberedValue2 == Composer.Companion.getEmpty()) {
                rememberedValue2 = new Function0() { // from class: com.miami.game.feature.settings.ui.compose.ModsInstructionsDialogKt$$ExternalSyntheticLambda7
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        Unit ModsInstructionsDialog$lambda$3$0;
                        ModsInstructionsDialog$lambda$3$0 = ModsInstructionsDialogKt.ModsInstructionsDialog$lambda$3$0(Function0.this, mutableState);
                        return ModsInstructionsDialog$lambda$3$0;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue2);
            }
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            BackHandlerKt.BackHandler(false, (Function0) rememberedValue2, startRestartGroup, 0, 1);
            startRestartGroup.startMovableGroup(1647039612, Boolean.valueOf(ModsInstructionsDialog$lambda$1(mutableState)));
            ComposerKt.sourceInformation(startRestartGroup, "57@2398L594,71@3004L3574,55@2324L4254");
            DialogFrameKt.DialogFrame(null, onDismiss, ComposableLambdaKt.rememberComposableLambda(662519885, true, new Function3() { // from class: com.miami.game.feature.settings.ui.compose.ModsInstructionsDialogKt$$ExternalSyntheticLambda8
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return ModsInstructionsDialogKt.ModsInstructionsDialog$lambda$4(Function0.this, mutableState, (BoxScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, startRestartGroup, 54), ComposableLambdaKt.rememberComposableLambda(972855927, true, new Function2() { // from class: com.miami.game.feature.settings.ui.compose.ModsInstructionsDialogKt$$ExternalSyntheticLambda9
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return ModsInstructionsDialogKt.ModsInstructionsDialog$lambda$5(MutableState.this, z, onConfirm, function03, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, startRestartGroup, 54), startRestartGroup, ((i3 >> 3) & 112) | 3456, 1);
            startRestartGroup.endMovableGroup();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            function02 = function03;
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            final Function0<Unit> function04 = function02;
            endRestartGroup.updateScope(new Function2() { // from class: com.miami.game.feature.settings.ui.compose.ModsInstructionsDialogKt$$ExternalSyntheticLambda10
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return ModsInstructionsDialogKt.ModsInstructionsDialog$lambda$6(z, onConfirm, onDismiss, function04, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final MutableState ModsInstructionsDialog$lambda$0$0() {
        MutableState mutableStateOf$default;
        mutableStateOf$default = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, null, 2, null);
        return mutableStateOf$default;
    }

    private static final boolean ModsInstructionsDialog$lambda$1(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    private static final void ModsInstructionsDialog$lambda$2(MutableState<Boolean> mutableState, boolean z) {
        mutableState.setValue(Boolean.valueOf(z));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ModsInstructionsDialog$lambda$3$0(Function0 function0, MutableState mutableState) {
        if (ModsInstructionsDialog$lambda$1(mutableState)) {
            ModsInstructionsDialog$lambda$2(mutableState, false);
        } else {
            function0.invoke();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit ModsInstructionsDialog$lambda$4(Function0 function0, MutableState mutableState, BoxScope DialogFrame, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(DialogFrame, "$this$DialogFrame");
        ComposerKt.sourceInformation(composer, "C:ModsInstructionsDialog.kt#1gr92h");
        if ((i & 6) == 0) {
            i |= composer.changed(DialogFrame) ? 4 : 2;
        }
        if (!composer.shouldExecute((i & 19) != 18, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(662519885, i, -1, "com.miami.game.feature.settings.ui.compose.ModsInstructionsDialog.<anonymous>.<anonymous> (ModsInstructionsDialog.kt:58)");
            }
            if (!ModsInstructionsDialog$lambda$1(mutableState)) {
                composer.startReplaceGroup(1755223415);
                ComposerKt.sourceInformation(composer, "59@2481L48,66@2851L41,60@2550L410");
                final String stringResource = StringResources_androidKt.stringResource(R.string.mods_instructions_close, composer, 0);
                Modifier m1122width3ABfNKs = SizeKt.m1122width3ABfNKs(SizeKt.m1103height3ABfNKs(PaddingKt.m1054paddingqDBjuR0$default(DialogFrame.align(Modifier.Companion, Alignment.Companion.getTopEnd()), 0.0f, Dp.m8160constructorimpl(8.0f), Dp.m8160constructorimpl(8.0f), 0.0f, 9, null), Dp.m8160constructorimpl(40.0f)), Dp.m8160constructorimpl(50.0f));
                ComposerKt.sourceInformationMarkerStart(composer, 1026464214, "CC(remember):ModsInstructionsDialog.kt#9igjgp");
                boolean changed = composer.changed(stringResource);
                Object rememberedValue = composer.rememberedValue();
                if (changed || rememberedValue == Composer.Companion.getEmpty()) {
                    rememberedValue = new Function1() { // from class: com.miami.game.feature.settings.ui.compose.ModsInstructionsDialogKt$$ExternalSyntheticLambda2
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            Unit ModsInstructionsDialog$lambda$4$0$0;
                            ModsInstructionsDialog$lambda$4$0$0 = ModsInstructionsDialogKt.ModsInstructionsDialog$lambda$4$0$0(stringResource, (SemanticsPropertyReceiver) obj);
                            return ModsInstructionsDialog$lambda$4$0$0;
                        }
                    };
                    composer.updateRememberedValue(rememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd(composer);
                DialogCloseButtonKt.DialogCloseButton(SemanticsModifierKt.semantics$default(m1122width3ABfNKs, false, (Function1) rememberedValue, 1, null), function0, composer, 0, 0);
                composer.endReplaceGroup();
            } else {
                composer.startReplaceGroup(1755744277);
                composer.endReplaceGroup();
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ModsInstructionsDialog$lambda$4$0$0(String str, SemanticsPropertyReceiver semantics) {
        Intrinsics.checkNotNullParameter(semantics, "$this$semantics");
        SemanticsPropertiesKt.setContentDescription(semantics, str);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit ModsInstructionsDialog$lambda$5(final MutableState mutableState, boolean z, Function0 function0, Function0 function02, Composer composer, int i) {
        int i2;
        String str;
        String str2;
        ComposerKt.sourceInformation(composer, "C73@3047L140,76@3235L13,77@3288L10,78@3338L13,79@3382L13,80@3435L11,72@3018L451,82@3482L1186:ModsInstructionsDialog.kt#1gr92h");
        if (composer.shouldExecute((i & 3) != 2, i & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(972855927, i, -1, "com.miami.game.feature.settings.ui.compose.ModsInstructionsDialog.<anonymous>.<anonymous> (ModsInstructionsDialog.kt:72)");
            }
            String stringResource = StringResources_androidKt.stringResource(ModsInstructionsDialog$lambda$1(mutableState) ? R.string.mods_structure_title : R.string.mods_instructions_title, composer, 0);
            Modifier.Companion companion = Modifier.Companion;
            ComposerKt.sourceInformationMarkerStart(composer, -1388317276, "CC(remember):ModsInstructionsDialog.kt#9igjgp");
            Object rememberedValue = composer.rememberedValue();
            if (rememberedValue == Composer.Companion.getEmpty()) {
                rememberedValue = new Function1() { // from class: com.miami.game.feature.settings.ui.compose.ModsInstructionsDialogKt$$ExternalSyntheticLambda3
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        Unit ModsInstructionsDialog$lambda$5$0$0;
                        ModsInstructionsDialog$lambda$5$0$0 = ModsInstructionsDialogKt.ModsInstructionsDialog$lambda$5$0$0((SemanticsPropertyReceiver) obj);
                        return ModsInstructionsDialog$lambda$5$0$0;
                    }
                };
                composer.updateRememberedValue(rememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            TextKt.m3157TextNvy7gAk(stringResource, SemanticsModifierKt.semantics$default(companion, false, (Function1) rememberedValue, 1, null), MaterialTheme.INSTANCE.getColorScheme(composer, 6).m2322getPrimary0d7_KjU(), null, TypeKt.m9923dpToSp8Feqmps(Dp.m8160constructorimpl(36.0f), composer, 6), null, null, null, 0L, null, null, TypeKt.m9923dpToSp8Feqmps(Dp.m8160constructorimpl(40.0f), composer, 6), 0, false, 0, 0, null, MaterialTheme.INSTANCE.getTypography(composer, 6).getBodyMedium(), composer, 0, 0, 129000);
            Composer composer2 = composer;
            Modifier m1052paddingVpY3zN4$default = PaddingKt.m1052paddingVpY3zN4$default(SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, null), Dp.m8160constructorimpl(28.0f), 0.0f, 2, null);
            ComposerKt.sourceInformationMarkerStart(composer2, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
            MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.m742spacedBy0680j_4(Dp.m8160constructorimpl(8.0f)), Alignment.Companion.getStart(), composer2, 6);
            ComposerKt.sourceInformationMarkerStart(composer2, -1159599143, "CC(Layout)N(content,modifier,measurePolicy)81@3355L27,84@3521L415:Layout.kt#80mrfh");
            int hashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composer2, 0));
            CompositionLocalMap currentCompositionLocalMap = composer2.getCurrentCompositionLocalMap();
            Modifier materializeModifier = ComposedModifierKt.materializeModifier(composer2, m1052paddingVpY3zN4$default);
            Function0<ComposeUiNode> constructor = ComposeUiNode.Companion.getConstructor();
            ComposerKt.sourceInformationMarkerStart(composer2, -553112988, "CC(ReusableComposeNode)N(factory,update,content)410@16187L9:Composables.kt#9igjgp");
            if (!(composer2.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composer2.startReusableNode();
            if (composer2.getInserting()) {
                composer2.createNode(constructor);
            } else {
                composer2.useNode();
            }
            Composer m4467constructorimpl = Updater.m4467constructorimpl(composer2);
            Updater.m4475setimpl(m4467constructorimpl, columnMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.m4475setimpl(m4467constructorimpl, currentCompositionLocalMap, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.m4475setimpl(m4467constructorimpl, Integer.valueOf(hashCode), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.m4473reconcileimpl(m4467constructorimpl, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.m4475setimpl(m4467constructorimpl, materializeModifier, ComposeUiNode.Companion.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composer2, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composer2, 86045190, "C:ModsInstructionsDialog.kt#1gr92h");
            if (ModsInstructionsDialog$lambda$1(mutableState)) {
                composer2.startReplaceGroup(86037346);
                ComposerKt.sourceInformation(composer2, "89@3751L43");
                ModsStructureExample(z, composer2, 0);
                composer2.endReplaceGroup();
                str = "CC(Layout)N(content,modifier,measurePolicy)81@3355L27,84@3521L415:Layout.kt#80mrfh";
                i2 = 0;
                str2 = "CC(ReusableComposeNode)N(factory,update,content)410@16187L9:Composables.kt#9igjgp";
            } else {
                composer2.startReplaceGroup(86148977);
                ComposerKt.sourceInformation(composer2, "92@3877L49,93@3974L10,94@4034L13,95@4086L13,91@3840L346,100@4339L51,98@4207L206,104@4564L49,102@4434L202");
                i2 = 0;
                str = "CC(Layout)N(content,modifier,measurePolicy)81@3355L27,84@3521L415:Layout.kt#80mrfh";
                str2 = "CC(ReusableComposeNode)N(factory,update,content)410@16187L9:Composables.kt#9igjgp";
                TextKt.m3157TextNvy7gAk(StringResources_androidKt.stringResource(R.string.mods_instructions_folder, composer2, 0), null, Color.m5347copywmQWz5c$default(Color.Companion.m5385getWhite0d7_KjU(), 0.8f, 0.0f, 0.0f, 0.0f, 14, null), null, TypeKt.m9923dpToSp8Feqmps(Dp.m8160constructorimpl(16.0f), composer2, 6), null, null, null, 0L, null, null, TypeKt.m9923dpToSp8Feqmps(Dp.m8160constructorimpl(18.0f), composer2, 6), 0, false, 0, 0, null, MaterialTheme.INSTANCE.getTypography(composer2, 6).getDisplaySmall(), composer, RendererCapabilities.DECODER_SUPPORT_MASK, 0, 129002);
                composer2 = composer;
                ModsInstructionParagraph(R.string.mods_instructions_textures_title, StringResources_androidKt.stringResource(R.string.mods_instructions_textures, composer2, 0), composer2, 0);
                ModsInstructionParagraph(R.string.mods_instructions_repair_title, StringResources_androidKt.stringResource(R.string.mods_instructions_repair, composer2, 0), composer2, 0);
                composer2.endReplaceGroup();
            }
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            composer2.endNode();
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            if (ModsInstructionsDialog$lambda$1(mutableState)) {
                composer2.startReplaceGroup(-86699146);
                ComposerKt.sourceInformation(composer2, "109@4743L25,109@4718L309");
                ComposerKt.sourceInformationMarkerStart(composer2, -1388269008, "CC(remember):ModsInstructionsDialog.kt#9igjgp");
                boolean changed = composer2.changed(mutableState);
                Object rememberedValue2 = composer2.rememberedValue();
                if (changed || rememberedValue2 == Composer.Companion.getEmpty()) {
                    rememberedValue2 = new Function0() { // from class: com.miami.game.feature.settings.ui.compose.ModsInstructionsDialogKt$$ExternalSyntheticLambda4
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            Unit ModsInstructionsDialog$lambda$5$2$0;
                            ModsInstructionsDialog$lambda$5$2$0 = ModsInstructionsDialogKt.ModsInstructionsDialog$lambda$5$2$0(MutableState.this);
                            return ModsInstructionsDialog$lambda$5$2$0;
                        }
                    };
                    composer2.updateRememberedValue(rememberedValue2);
                }
                ComposerKt.sourceInformationMarkerEnd(composer2);
                DialogButtonKt.DialogButtonNo((Function0) rememberedValue2, ComposableSingletons$ModsInstructionsDialogKt.INSTANCE.m9890getLambda$160609614$settings(), composer2, 48);
                composer2.endReplaceGroup();
            } else {
                composer2.startReplaceGroup(-86318342);
                ComposerKt.sourceInformation(composer2, "117@5065L1489");
                Modifier m1052paddingVpY3zN4$default2 = PaddingKt.m1052paddingVpY3zN4$default(SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, null), Dp.m8160constructorimpl(12.0f), 0.0f, 2, null);
                Arrangement.Horizontal m743spacedByD5KLDUw = Arrangement.INSTANCE.m743spacedByD5KLDUw(Dp.m8160constructorimpl(8.0f), Alignment.Companion.getCenterHorizontally());
                Alignment.Vertical centerVertically = Alignment.Companion.getCenterVertically();
                ComposerKt.sourceInformationMarkerStart(composer2, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
                MeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(m743spacedByD5KLDUw, centerVertically, composer2, 54);
                ComposerKt.sourceInformationMarkerStart(composer2, -1159599143, str);
                int hashCode2 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composer2, i2));
                CompositionLocalMap currentCompositionLocalMap2 = composer2.getCurrentCompositionLocalMap();
                Modifier materializeModifier2 = ComposedModifierKt.materializeModifier(composer2, m1052paddingVpY3zN4$default2);
                Function0<ComposeUiNode> constructor2 = ComposeUiNode.Companion.getConstructor();
                ComposerKt.sourceInformationMarkerStart(composer2, -553112988, str2);
                if (!(composer2.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                composer2.startReusableNode();
                if (composer2.getInserting()) {
                    composer2.createNode(constructor2);
                } else {
                    composer2.useNode();
                }
                Composer m4467constructorimpl2 = Updater.m4467constructorimpl(composer2);
                Updater.m4475setimpl(m4467constructorimpl2, rowMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.m4475setimpl(m4467constructorimpl2, currentCompositionLocalMap2, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                Updater.m4475setimpl(m4467constructorimpl2, Integer.valueOf(hashCode2), ComposeUiNode.Companion.getSetCompositeKeyHash());
                Updater.m4473reconcileimpl(m4467constructorimpl2, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
                Updater.m4475setimpl(m4467constructorimpl2, materializeModifier2, ComposeUiNode.Companion.getSetModifier());
                ComposerKt.sourceInformationMarkerStart(composer2, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
                RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(composer2, -161695408, "C122@5389L24,122@5364L332,129@5717L326:ModsInstructionsDialog.kt#1gr92h");
                ComposerKt.sourceInformationMarkerStart(composer2, -5216329, "CC(remember):ModsInstructionsDialog.kt#9igjgp");
                boolean changed2 = composer2.changed(mutableState);
                Object rememberedValue3 = composer2.rememberedValue();
                if (changed2 || rememberedValue3 == Composer.Companion.getEmpty()) {
                    rememberedValue3 = new Function0() { // from class: com.miami.game.feature.settings.ui.compose.ModsInstructionsDialogKt$$ExternalSyntheticLambda5
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            Unit ModsInstructionsDialog$lambda$5$3$0$0;
                            ModsInstructionsDialog$lambda$5$3$0$0 = ModsInstructionsDialogKt.ModsInstructionsDialog$lambda$5$3$0$0(MutableState.this);
                            return ModsInstructionsDialog$lambda$5$3$0$0;
                        }
                    };
                    composer2.updateRememberedValue(rememberedValue3);
                }
                ComposerKt.sourceInformationMarkerEnd(composer2);
                DialogButtonKt.DialogButtonNo((Function0) rememberedValue3, ComposableSingletons$ModsInstructionsDialogKt.INSTANCE.m9892getLambda$70836385$settings(), composer2, 48);
                DialogButtonKt.DialogButtonYes(function0, false, ComposableSingletons$ModsInstructionsDialogKt.INSTANCE.m9891getLambda$1983831800$settings(), composer2, RendererCapabilities.DECODER_SUPPORT_MASK, 2);
                if (function02 != null) {
                    composer2.startReplaceGroup(-160998684);
                    ComposerKt.sourceInformation(composer2, "137@6115L399");
                    DialogButtonKt.DialogButtonYes(function02, false, ComposableSingletons$ModsInstructionsDialogKt.INSTANCE.getLambda$1244585443$settings(), composer2, RendererCapabilities.DECODER_SUPPORT_MASK, 2);
                    composer2.endReplaceGroup();
                } else {
                    composer2.startReplaceGroup(-160569117);
                    composer2.endReplaceGroup();
                }
                ComposerKt.sourceInformationMarkerEnd(composer2);
                ComposerKt.sourceInformationMarkerEnd(composer2);
                composer2.endNode();
                ComposerKt.sourceInformationMarkerEnd(composer2);
                ComposerKt.sourceInformationMarkerEnd(composer2);
                ComposerKt.sourceInformationMarkerEnd(composer2);
                composer2.endReplaceGroup();
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ModsInstructionsDialog$lambda$5$0$0(SemanticsPropertyReceiver semantics) {
        Intrinsics.checkNotNullParameter(semantics, "$this$semantics");
        SemanticsPropertiesKt.heading(semantics);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ModsInstructionsDialog$lambda$5$2$0(MutableState mutableState) {
        ModsInstructionsDialog$lambda$2(mutableState, false);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ModsInstructionsDialog$lambda$5$3$0$0(MutableState mutableState) {
        ModsInstructionsDialog$lambda$2(mutableState, true);
        return Unit.INSTANCE;
    }

    private static final void ModsStructureExample(final boolean z, Composer composer, final int i) {
        int i2;
        Composer startRestartGroup = composer.startRestartGroup(-1018080043);
        ComposerKt.sourceInformation(startRestartGroup, "C(ModsStructureExample)N(isArizona)154@6679L45,155@6747L52,156@6838L11,164@7166L1349:ModsInstructionsDialog.kt#1gr92h");
        if ((i & 6) == 0) {
            i2 = i | (startRestartGroup.changed(z) ? 4 : 2);
        } else {
            i2 = i;
        }
        if (!startRestartGroup.shouldExecute((i2 & 3) != 2, i2 & 1)) {
            startRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1018080043, i2, -1, "com.miami.game.feature.settings.ui.compose.ModsStructureExample (ModsInstructionsDialog.kt:153)");
            }
            String stringResource = StringResources_androidKt.stringResource(R.string.mods_structure_paths, startRestartGroup, 0);
            String stringResource2 = StringResources_androidKt.stringResource(R.string.mods_structure_not_archives, startRestartGroup, 0);
            long m2322getPrimary0d7_KjU = MaterialTheme.INSTANCE.getColorScheme(startRestartGroup, 6).m2322getPrimary0d7_KjU();
            AnnotatedString.Builder builder = new AnnotatedString.Builder(0, 1, null);
            builder.append(StringsKt.substringBefore$default(stringResource, "%1$s", (String) null, 2, (Object) null));
            int pushStyle = builder.pushStyle(new SpanStyle(m2322getPrimary0d7_KjU, 0L, (FontWeight) null, (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, TextDecoration.Companion.getUnderline(), (Shadow) null, (PlatformSpanStyle) null, (DrawStyle) null, 61438, (DefaultConstructorMarker) null));
            try {
                builder.append(stringResource2);
                Unit unit = Unit.INSTANCE;
                builder.pop(pushStyle);
                builder.append(StringsKt.substringAfter$default(stringResource, "%1$s", (String) null, 2, (Object) null));
                AnnotatedString annotatedString = builder.toAnnotatedString();
                Modifier fillMaxWidth$default = SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, null);
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
                MeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.m742spacedBy0680j_4(Dp.m8160constructorimpl(16.0f)), Alignment.Companion.getTop(), startRestartGroup, 6);
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1159599143, "CC(Layout)N(content,modifier,measurePolicy)81@3355L27,84@3521L415:Layout.kt#80mrfh");
                int hashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(startRestartGroup, 0));
                CompositionLocalMap currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
                Modifier materializeModifier = ComposedModifierKt.materializeModifier(startRestartGroup, fillMaxWidth$default);
                Function0<ComposeUiNode> constructor = ComposeUiNode.Companion.getConstructor();
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, -553112988, "CC(ReusableComposeNode)N(factory,update,content)410@16187L9:Composables.kt#9igjgp");
                if (!(startRestartGroup.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                startRestartGroup.startReusableNode();
                if (startRestartGroup.getInserting()) {
                    startRestartGroup.createNode(constructor);
                } else {
                    startRestartGroup.useNode();
                }
                Composer m4467constructorimpl = Updater.m4467constructorimpl(startRestartGroup);
                Updater.m4475setimpl(m4467constructorimpl, rowMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.m4475setimpl(m4467constructorimpl, currentCompositionLocalMap, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                Updater.m4475setimpl(m4467constructorimpl, Integer.valueOf(hashCode), ComposeUiNode.Companion.getSetCompositeKeyHash());
                Updater.m4473reconcileimpl(m4467constructorimpl, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
                Updater.m4475setimpl(m4467constructorimpl, materializeModifier, ComposeUiNode.Companion.getSetModifier());
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
                RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, 894810953, "C171@7451L55,169@7317L204,175@7640L13,176@7680L13,168@7292L479,180@7780L729:ModsInstructionsDialog.kt#1gr92h");
                String stringResource3 = StringResources_androidKt.stringResource(z ? R.string.mods_structure_tree : R.string.mods_structure_rodina_tree, new Object[]{StringResources_androidKt.stringResource(R.string.mods_structure_selected_folder, startRestartGroup, 0)}, startRestartGroup, 0);
                Modifier weight$default = RowScope.weight$default(rowScopeInstance, Modifier.Companion, 0.56f, false, 2, null);
                GenericFontFamily monospace = FontFamily.Companion.getMonospace();
                TextKt.m3157TextNvy7gAk(stringResource3, weight$default, Color.Companion.m5385getWhite0d7_KjU(), null, TypeKt.m9923dpToSp8Feqmps(Dp.m8160constructorimpl(14.0f), startRestartGroup, 6), null, null, monospace, TextUnitKt.getSp(0), null, null, TypeKt.m9923dpToSp8Feqmps(Dp.m8160constructorimpl(18.0f), startRestartGroup, 6), 0, false, 0, 0, null, null, startRestartGroup, 100663680, 0, 259688);
                startRestartGroup = startRestartGroup;
                Modifier weight$default2 = RowScope.weight$default(rowScopeInstance, Modifier.Companion, 0.44f, false, 2, null);
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
                MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.m742spacedBy0680j_4(Dp.m8160constructorimpl(8.0f)), Alignment.Companion.getStart(), startRestartGroup, 6);
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1159599143, "CC(Layout)N(content,modifier,measurePolicy)81@3355L27,84@3521L415:Layout.kt#80mrfh");
                int hashCode2 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(startRestartGroup, 0));
                CompositionLocalMap currentCompositionLocalMap2 = startRestartGroup.getCurrentCompositionLocalMap();
                Modifier materializeModifier2 = ComposedModifierKt.materializeModifier(startRestartGroup, weight$default2);
                Function0<ComposeUiNode> constructor2 = ComposeUiNode.Companion.getConstructor();
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, -553112988, "CC(ReusableComposeNode)N(factory,update,content)410@16187L9:Composables.kt#9igjgp");
                if (!(startRestartGroup.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                startRestartGroup.startReusableNode();
                if (startRestartGroup.getInserting()) {
                    startRestartGroup.createNode(constructor2);
                } else {
                    startRestartGroup.useNode();
                }
                Composer m4467constructorimpl2 = Updater.m4467constructorimpl(startRestartGroup);
                Updater.m4475setimpl(m4467constructorimpl2, columnMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.m4475setimpl(m4467constructorimpl2, currentCompositionLocalMap2, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                Updater.m4475setimpl(m4467constructorimpl2, Integer.valueOf(hashCode2), ComposeUiNode.Companion.getSetCompositeKeyHash());
                Updater.m4473reconcileimpl(m4467constructorimpl2, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
                Updater.m4475setimpl(m4467constructorimpl2, materializeModifier2, ComposeUiNode.Companion.getSetModifier());
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
                ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, 239025714, "C186@8091L48,184@7921L233,190@8281L49,188@8167L178,192@8358L141:ModsInstructionsDialog.kt#1gr92h");
                ModsInstructionParagraph(z ? R.string.mods_structure_infernus_title : R.string.mods_structure_rodina_title, StringResources_androidKt.stringResource(R.string.mods_structure_infernus, startRestartGroup, 0), startRestartGroup, 0);
                ModsInstructionParagraph(R.string.mods_structure_timecycle_title, StringResources_androidKt.stringResource(R.string.mods_structure_timecycle, startRestartGroup, 0), startRestartGroup, 0);
                ModsInstructionParagraph(R.string.mods_structure_paths_title, annotatedString, startRestartGroup, 0);
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                startRestartGroup.endNode();
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                startRestartGroup.endNode();
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            } catch (Throwable th) {
                builder.pop(pushStyle);
                throw th;
            }
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: com.miami.game.feature.settings.ui.compose.ModsInstructionsDialogKt$$ExternalSyntheticLambda11
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return ModsInstructionsDialogKt.ModsStructureExample$lambda$2(z, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    private static final void ModsInstructionParagraph(final int i, final String str, Composer composer, final int i2) {
        int i3;
        Composer startRestartGroup = composer.startRestartGroup(1377950484);
        ComposerKt.sourceInformation(startRestartGroup, "C(ModsInstructionParagraph)N(title,body)202@8611L69:ModsInstructionsDialog.kt#1gr92h");
        if ((i2 & 6) == 0) {
            i3 = (startRestartGroup.changed(i) ? 4 : 2) | i2;
        } else {
            i3 = i2;
        }
        if ((i2 & 48) == 0) {
            i3 |= startRestartGroup.changed(str) ? 32 : 16;
        }
        if (!startRestartGroup.shouldExecute((i3 & 19) != 18, i3 & 1)) {
            startRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1377950484, i3, -1, "com.miami.game.feature.settings.ui.compose.ModsInstructionParagraph (ModsInstructionsDialog.kt:201)");
            }
            ModsInstructionParagraph(i, new AnnotatedString(str, null, 2, null), startRestartGroup, i3 & 14);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: com.miami.game.feature.settings.ui.compose.ModsInstructionsDialogKt$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return ModsInstructionsDialogKt.ModsInstructionParagraph$lambda$0(i, str, i2, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    private static final void ModsInstructionParagraph(final int i, final AnnotatedString annotatedString, Composer composer, final int i2) {
        int i3;
        Composer composer2;
        Composer startRestartGroup = composer.startRestartGroup(-1649778712);
        ComposerKt.sourceInformation(startRestartGroup, "C(ModsInstructionParagraph)N(title,body)220@9194L10,221@9238L13,222@9274L13,207@8785L557:ModsInstructionsDialog.kt#1gr92h");
        if ((i2 & 6) == 0) {
            i3 = (startRestartGroup.changed(i) ? 4 : 2) | i2;
        } else {
            i3 = i2;
        }
        if ((i2 & 48) == 0) {
            i3 |= startRestartGroup.changed(annotatedString) ? 32 : 16;
        }
        if (!startRestartGroup.shouldExecute((i3 & 19) != 18, i3 & 1)) {
            composer2 = startRestartGroup;
            composer2.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1649778712, i3, -1, "com.miami.game.feature.settings.ui.compose.ModsInstructionParagraph (ModsInstructionsDialog.kt:206)");
            }
            startRestartGroup.startReplaceGroup(-594406388);
            ComposerKt.sourceInformation(startRestartGroup, "*210@8882L10,212@8981L13");
            AnnotatedString.Builder builder = new AnnotatedString.Builder(0, 1, null);
            startRestartGroup.startReplaceGroup(-594405362);
            ComposerKt.sourceInformation(startRestartGroup, "*215@9067L21");
            int pushStyle = builder.pushStyle(TextStyle.m7621copyp1EtxEg$default(MaterialTheme.INSTANCE.getTypography(startRestartGroup, 6).getBodySmall(), Color.Companion.m5385getWhite0d7_KjU(), TypeKt.m9923dpToSp8Feqmps(Dp.m8160constructorimpl(16.0f), startRestartGroup, 6), null, null, null, null, null, 0L, null, null, null, 0L, null, null, null, 0, 0, 0L, null, null, null, 0, 0, null, 16777212, null).toSpanStyle());
            try {
                builder.append(StringResources_androidKt.stringResource(i, startRestartGroup, i3 & 14));
                Unit unit = Unit.INSTANCE;
                builder.pop(pushStyle);
                startRestartGroup.endReplaceGroup();
                builder.append(" ");
                builder.append(annotatedString);
                AnnotatedString annotatedString2 = builder.toAnnotatedString();
                startRestartGroup.endReplaceGroup();
                TextStyle displaySmall = MaterialTheme.INSTANCE.getTypography(startRestartGroup, 6).getDisplaySmall();
                composer2 = startRestartGroup;
                TextKt.m3158TextZ58ophY(annotatedString2, null, Color.m5347copywmQWz5c$default(Color.Companion.m5385getWhite0d7_KjU(), 0.8f, 0.0f, 0.0f, 0.0f, 14, null), null, TypeKt.m9923dpToSp8Feqmps(Dp.m8160constructorimpl(16.0f), startRestartGroup, 6), null, null, null, 0L, null, null, TypeKt.m9923dpToSp8Feqmps(Dp.m8160constructorimpl(18.0f), startRestartGroup, 6), 0, false, 0, 0, null, null, displaySmall, composer2, RendererCapabilities.DECODER_SUPPORT_MASK, 0, 260074);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            } catch (Throwable th) {
                builder.pop(pushStyle);
                throw th;
            }
        }
        ScopeUpdateScope endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: com.miami.game.feature.settings.ui.compose.ModsInstructionsDialogKt$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return ModsInstructionsDialogKt.ModsInstructionParagraph$lambda$2(i, annotatedString, i2, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }
}
