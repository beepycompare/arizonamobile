package com.miami.game.feature.settings.ui.compose;

import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.BorderKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScope;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.lazy.LazyDslKt;
import androidx.compose.foundation.lazy.LazyItemScope;
import androidx.compose.foundation.lazy.LazyListScope;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.foundation.text.KeyboardActions;
import androidx.compose.foundation.text.KeyboardOptions;
import androidx.compose.material3.AndroidAlertDialog_androidKt;
import androidx.compose.material3.ButtonKt;
import androidx.compose.material3.MaterialTheme;
import androidx.compose.material3.OutlinedTextFieldKt;
import androidx.compose.material3.TextFieldColors;
import androidx.compose.material3.TextKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.composer.linkbuffer.GroupFlagsKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.runtime.saveable.RememberSaveableKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.input.VisualTransformation;
import androidx.compose.ui.text.style.TextOverflow;
import androidx.compose.ui.unit.Dp;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.media3.exoplayer.RendererCapabilities;
import com.miami.game.core.design.system.component.scaling_button.ScalingButtonKt;
import com.miami.game.core.settings.game_test.GameTestSavedScript;
import com.miami.game.ui.theme.TypeKt;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
/* compiled from: DebugGameTestScriptCard.kt */
@Metadata(d1 = {"\u0000D\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\u001aÛ\u0001\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\b\u0010\t\u001a\u0004\u0018\u00010\u00032\u0006\u0010\n\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u00032\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00010\u000f2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00010\u000f2\u0012\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\u00122\u0012\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\u00122\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00010\u000f2\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00010\u000f2\u0012\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\u0012H\u0007b\u0002\b\u0018b\f\b\u0019\u0012\b\b\u001a\u0012\u0004\b\b(\u001b¢\u0006\u0002\u0010\u0017\u001a?\u0010\u001c\u001a\u00020\u00012\u0006\u0010\u001d\u001a\u00020\u00032\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00010\u000f2\b\b\u0002\u0010\u001f\u001a\u00020 H\u0003b\u0002\b\u0018b\f\b\u0019\u0012\b\b\u001a\u0012\u0004\b\b(\u001b¢\u0006\u0002\u0010!¨\u0006\"²\u0006\n\u0010#\u001a\u00020\u0005X\u008a\u008e\u0002²\u0006\n\u0010$\u001a\u00020\u0005X\u008a\u008e\u0002²\u0006\n\u0010%\u001a\u00020\u0005X\u008a\u008e\u0002²\u0006\n\u0010&\u001a\u00020\u0003X\u008a\u008e\u0002²\u0006\n\u0010'\u001a\u00020\u0003X\u008a\u008e\u0002"}, d2 = {"DebugGameTestScriptCard", "", "activeScriptName", "", "isImported", "", "importedScripts", "", "Lcom/miami/game/core/settings/game_test/GameTestSavedScript;", "activeImportedScriptFileName", "screenshotPullPath", "screenshotButtonEnabled", "logShareButtonEnabled", "screenshotDeviceDir", "onImportGameTestScript", "Lkotlin/Function0;", "onUseBundledGameTestScript", "onSelectImportedGameTestScript", "Lkotlin/Function1;", "onUpdateScreenshotPullPath", "onToggleScreenshotButton", "onToggleLogShareButton", "onUpdateScreenshotDeviceDir", "(Ljava/lang/String;ZLjava/util/List;Ljava/lang/String;Ljava/lang/String;ZZLjava/lang/String;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)V", "Landroidx/compose/runtime/Composable;", "Landroidx/compose/runtime/ComposableTarget;", "applier", "androidx.compose.ui.UiComposable", "DebugGameTestScriptButton", "text", "onClick", "modifier", "Landroidx/compose/ui/Modifier;", "(Ljava/lang/String;Lkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "settings", "isPullPathDialogVisible", "isDeviceDirDialogVisible", "isScriptListDialogVisible", "pullPathDraft", "deviceDirDraft"}, k = 2, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class DebugGameTestScriptCardKt {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit DebugGameTestScriptButton$lambda$1(String str, Function0 function0, Modifier modifier, int i, int i2, Composer composer, int i3) {
        DebugGameTestScriptButton(str, function0, modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit DebugGameTestScriptCard$lambda$27(String str, boolean z, List list, String str2, String str3, boolean z2, boolean z3, String str4, Function0 function0, Function0 function02, Function1 function1, Function1 function12, Function0 function03, Function0 function04, Function1 function13, int i, int i2, Composer composer, int i3) {
        DebugGameTestScriptCard(str, z, list, str2, str3, z2, z3, str4, function0, function02, function1, function12, function03, function04, function13, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), RecomposeScopeImplKt.updateChangedFlags(i2));
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code restructure failed: missing block: B:143:0x0259, code lost:
        if (r2 == androidx.compose.runtime.Composer.Companion.getEmpty()) goto L214;
     */
    /* JADX WARN: Code restructure failed: missing block: B:154:0x029a, code lost:
        if (r0 == androidx.compose.runtime.Composer.Companion.getEmpty()) goto L211;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void DebugGameTestScriptCard(final String activeScriptName, final boolean z, final List<GameTestSavedScript> importedScripts, final String str, final String screenshotPullPath, boolean z2, boolean z3, final String screenshotDeviceDir, final Function0<Unit> onImportGameTestScript, final Function0<Unit> onUseBundledGameTestScript, final Function1<? super String, Unit> onSelectImportedGameTestScript, final Function1<? super String, Unit> onUpdateScreenshotPullPath, Function0<Unit> function0, Function0<Unit> onToggleLogShareButton, final Function1<? super String, Unit> onUpdateScreenshotDeviceDir, Composer composer, final int i, final int i2) {
        int i3;
        int i4;
        boolean z4;
        final String str2;
        boolean z5;
        final String str3;
        final Function0<Unit> function02;
        Composer composer2;
        int i5;
        int i6;
        int i7;
        final MutableState mutableState;
        final MutableState mutableState2;
        final MutableState mutableState3;
        long j;
        Composer composer3;
        final MutableState mutableState4;
        MutableState mutableStateOf$default;
        MutableState mutableStateOf$default2;
        Function0<Unit> onToggleScreenshotButton = function0;
        Intrinsics.checkNotNullParameter(activeScriptName, "activeScriptName");
        Intrinsics.checkNotNullParameter(importedScripts, "importedScripts");
        Intrinsics.checkNotNullParameter(screenshotPullPath, "screenshotPullPath");
        Intrinsics.checkNotNullParameter(screenshotDeviceDir, "screenshotDeviceDir");
        Intrinsics.checkNotNullParameter(onImportGameTestScript, "onImportGameTestScript");
        Intrinsics.checkNotNullParameter(onUseBundledGameTestScript, "onUseBundledGameTestScript");
        Intrinsics.checkNotNullParameter(onSelectImportedGameTestScript, "onSelectImportedGameTestScript");
        Intrinsics.checkNotNullParameter(onUpdateScreenshotPullPath, "onUpdateScreenshotPullPath");
        Intrinsics.checkNotNullParameter(onToggleScreenshotButton, "onToggleScreenshotButton");
        Intrinsics.checkNotNullParameter(onToggleLogShareButton, "onToggleLogShareButton");
        Intrinsics.checkNotNullParameter(onUpdateScreenshotDeviceDir, "onUpdateScreenshotDeviceDir");
        Composer startRestartGroup = composer.startRestartGroup(-92541994);
        ComposerKt.sourceInformation(startRestartGroup, "C(DebugGameTestScriptCard)N(activeScriptName,isImported,importedScripts,activeImportedScriptFileName,screenshotPullPath,screenshotButtonEnabled,logShareButtonEnabled,screenshotDeviceDir,onImportGameTestScript,onUseBundledGameTestScript,onSelectImportedGameTestScript,onUpdateScreenshotPullPath,onToggleScreenshotButton,onToggleLogShareButton,onUpdateScreenshotDeviceDir)53@2251L34,54@2322L34,55@2394L34,56@2491L38,56@2454L75,57@2594L39,57@2556L77,59@2639L3605:DebugGameTestScriptCard.kt#1gr92h");
        if ((i & 6) == 0) {
            i3 = i | (startRestartGroup.changed(activeScriptName) ? 4 : 2);
        } else {
            i3 = i;
        }
        if ((i & 48) == 0) {
            i3 |= startRestartGroup.changed(z) ? 32 : 16;
        }
        if ((i & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
            i3 |= (i & 512) == 0 ? startRestartGroup.changed(importedScripts) : startRestartGroup.changedInstance(importedScripts) ? 256 : 128;
        }
        if ((i & 3072) == 0) {
            i3 |= startRestartGroup.changed(str) ? 2048 : 1024;
        }
        if ((i & 24576) == 0) {
            i3 |= startRestartGroup.changed(screenshotPullPath) ? 16384 : 8192;
        }
        if ((196608 & i) == 0) {
            i3 |= startRestartGroup.changed(z2) ? 131072 : 65536;
        }
        if ((1572864 & i) == 0) {
            i3 |= startRestartGroup.changed(z3) ? 1048576 : 524288;
        }
        if ((12582912 & i) == 0) {
            i3 |= startRestartGroup.changed(screenshotDeviceDir) ? 8388608 : 4194304;
        }
        if ((100663296 & i) == 0) {
            i3 |= startRestartGroup.changedInstance(onImportGameTestScript) ? 67108864 : GroupFlagsKt.HasAuxSlotFlag;
        }
        if ((805306368 & i) == 0) {
            i3 |= startRestartGroup.changedInstance(onUseBundledGameTestScript) ? 536870912 : 268435456;
        }
        int i8 = i3;
        if ((i2 & 6) == 0) {
            i4 = i2 | (startRestartGroup.changedInstance(onSelectImportedGameTestScript) ? 4 : 2);
        } else {
            i4 = i2;
        }
        if ((i2 & 48) == 0) {
            i4 |= startRestartGroup.changedInstance(onUpdateScreenshotPullPath) ? 32 : 16;
        }
        if ((i2 & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
            i4 |= startRestartGroup.changedInstance(onToggleScreenshotButton) ? 256 : 128;
        }
        if ((i2 & 3072) == 0) {
            i4 |= startRestartGroup.changedInstance(onToggleLogShareButton) ? 2048 : 1024;
        }
        if ((i2 & 24576) == 0) {
            i4 |= startRestartGroup.changedInstance(onUpdateScreenshotDeviceDir) ? 16384 : 8192;
        }
        int i9 = i4;
        if (!startRestartGroup.shouldExecute(((i8 & 306783379) == 306783378 && (i9 & 9363) == 9362) ? false : true, i8 & 1)) {
            z4 = z2;
            str2 = screenshotPullPath;
            z5 = z3;
            str3 = screenshotDeviceDir;
            function02 = onToggleLogShareButton;
            composer2 = startRestartGroup;
            composer2.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-92541994, i8, i9, "com.miami.game.feature.settings.ui.compose.DebugGameTestScriptCard (DebugGameTestScriptCard.kt:52)");
            }
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1261478584, "CC(remember):DebugGameTestScriptCard.kt#9igjgp");
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (rememberedValue == Composer.Companion.getEmpty()) {
                rememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, null, 2, null);
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            MutableState mutableState5 = (MutableState) rememberedValue;
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1261480856, "CC(remember):DebugGameTestScriptCard.kt#9igjgp");
            Object rememberedValue2 = startRestartGroup.rememberedValue();
            if (rememberedValue2 == Composer.Companion.getEmpty()) {
                mutableStateOf$default2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, null, 2, null);
                startRestartGroup.updateRememberedValue(mutableStateOf$default2);
                rememberedValue2 = mutableStateOf$default2;
            }
            MutableState mutableState6 = (MutableState) rememberedValue2;
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1261483160, "CC(remember):DebugGameTestScriptCard.kt#9igjgp");
            Object rememberedValue3 = startRestartGroup.rememberedValue();
            if (rememberedValue3 == Composer.Companion.getEmpty()) {
                i5 = i8;
                mutableStateOf$default = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, null, 2, null);
                startRestartGroup.updateRememberedValue(mutableStateOf$default);
                rememberedValue3 = mutableStateOf$default;
            } else {
                i5 = i8;
            }
            MutableState mutableState7 = (MutableState) rememberedValue3;
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            Object[] objArr = {screenshotPullPath};
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1261486268, "CC(remember):DebugGameTestScriptCard.kt#9igjgp");
            int i10 = i5 & 57344;
            boolean z6 = i10 == 16384;
            Object rememberedValue4 = startRestartGroup.rememberedValue();
            if (z6) {
                i6 = i10;
            } else {
                i6 = i10;
            }
            rememberedValue4 = new Function0() { // from class: com.miami.game.feature.settings.ui.compose.DebugGameTestScriptCardKt$$ExternalSyntheticLambda22
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    MutableState mutableStateOf$default3;
                    mutableStateOf$default3 = SnapshotStateKt.mutableStateOf$default(screenshotPullPath, null, 2, null);
                    return mutableStateOf$default3;
                }
            };
            startRestartGroup.updateRememberedValue(rememberedValue4);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            final MutableState mutableState8 = (MutableState) RememberSaveableKt.rememberSaveable(objArr, (Function0) rememberedValue4, startRestartGroup, 0);
            Object[] objArr2 = {screenshotDeviceDir};
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1261489565, "CC(remember):DebugGameTestScriptCard.kt#9igjgp");
            int i11 = i5 & 29360128;
            boolean z7 = i11 == 8388608;
            Object rememberedValue5 = startRestartGroup.rememberedValue();
            if (z7) {
                i7 = i11;
            } else {
                i7 = i11;
            }
            rememberedValue5 = new Function0() { // from class: com.miami.game.feature.settings.ui.compose.DebugGameTestScriptCardKt$$ExternalSyntheticLambda2
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    MutableState mutableStateOf$default3;
                    mutableStateOf$default3 = SnapshotStateKt.mutableStateOf$default(screenshotDeviceDir, null, 2, null);
                    return mutableStateOf$default3;
                }
            };
            startRestartGroup.updateRememberedValue(rememberedValue5);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            final MutableState mutableState9 = (MutableState) RememberSaveableKt.rememberSaveable(objArr2, (Function0) rememberedValue5, startRestartGroup, 0);
            Modifier m1051paddingVpY3zN4 = PaddingKt.m1051paddingVpY3zN4(BorderKt.m301borderziNgDLE(BackgroundKt.m287backgroundbw27NRU(SizeKt.m1122width3ABfNKs(Modifier.Companion, Dp.m8160constructorimpl(532.0f)), ColorKt.Color(3205437478L), RoundedCornerShapeKt.m1380RoundedCornerShape0680j_4(Dp.m8160constructorimpl(8.0f))), Dp.m8160constructorimpl(1.0f), Brush.Companion.m5297linearGradientmHitzGk$default(Brush.Companion, CollectionsKt.listOf((Object[]) new Color[]{Color.m5338boximpl(Color.m5347copywmQWz5c$default(Color.Companion.m5385getWhite0d7_KjU(), 0.1f, 0.0f, 0.0f, 0.0f, 14, null)), Color.m5338boximpl(Color.m5347copywmQWz5c$default(Color.Companion.m5385getWhite0d7_KjU(), 0.1f, 0.0f, 0.0f, 0.0f, 14, null)), Color.m5338boximpl(Color.m5347copywmQWz5c$default(Color.Companion.m5374getBlack0d7_KjU(), 0.2f, 0.0f, 0.0f, 0.0f, 14, null))}), 0L, 0L, 0, 14, (Object) null), RoundedCornerShapeKt.m1380RoundedCornerShape0680j_4(Dp.m8160constructorimpl(8.0f))), Dp.m8160constructorimpl(20.0f), Dp.m8160constructorimpl(18.0f));
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
            MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.m742spacedBy0680j_4(Dp.m8160constructorimpl(12.0f)), Alignment.Companion.getStart(), startRestartGroup, 6);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1159599143, "CC(Layout)N(content,modifier,measurePolicy)81@3355L27,84@3521L415:Layout.kt#80mrfh");
            int hashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(startRestartGroup, 0));
            CompositionLocalMap currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier materializeModifier = ComposedModifierKt.materializeModifier(startRestartGroup, m1051paddingVpY3zN4);
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
            Updater.m4475setimpl(m4467constructorimpl, columnMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.m4475setimpl(m4467constructorimpl, currentCompositionLocalMap, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.m4475setimpl(m4467constructorimpl, Integer.valueOf(hashCode), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.m4473reconcileimpl(m4467constructorimpl, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.m4475setimpl(m4467constructorimpl, materializeModifier, ComposeUiNode.Companion.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1154720116, "C80@3407L27,84@3623L10,85@3668L13,81@3443L248,90@3810L10,91@3855L13,87@3700L250,98@4115L10,99@4160L13,95@3959L296,106@4480L10,107@4525L13,103@4264L356,111@4629L157,116@4795L159,121@4963L525,138@5588L36,136@5497L185,143@5787L113,141@5691L267,151@6064L116,149@5967L271:DebugGameTestScriptCard.kt#1gr92h");
            TextSettingsKt.TextSettings("TEST SCRIPT", null, startRestartGroup, 6, 2);
            TextKt.m3157TextNvy7gAk("Source: ".concat(z ? "IMPORTED FILE" : "PROJECT SCRIPT"), null, Color.m5347copywmQWz5c$default(Color.Companion.m5385getWhite0d7_KjU(), 0.75f, 0.0f, 0.0f, 0.0f, 14, null), null, TypeKt.m9869dpToSp8Feqmps(Dp.m8160constructorimpl(14.0f), startRestartGroup, 6), null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, MaterialTheme.INSTANCE.getTypography(startRestartGroup, 6).getBodySmall(), startRestartGroup, RendererCapabilities.DECODER_SUPPORT_MASK, 0, 131050);
            int i12 = i6;
            int i13 = i7;
            TextKt.m3157TextNvy7gAk(activeScriptName, null, Color.Companion.m5385getWhite0d7_KjU(), null, TypeKt.m9869dpToSp8Feqmps(Dp.m8160constructorimpl(16.0f), startRestartGroup, 6), null, null, null, 0L, null, null, 0L, TextOverflow.Companion.m8096getEllipsisgIe3tQ8(), false, 1, 0, null, MaterialTheme.INSTANCE.getTypography(startRestartGroup, 6).getBodySmall(), startRestartGroup, (i5 & 14) | RendererCapabilities.DECODER_SUPPORT_MASK, 24960, 110570);
            str2 = screenshotPullPath;
            TextKt.m3157TextNvy7gAk("Screenshot pull dir: " + str2, null, Color.m5347copywmQWz5c$default(Color.Companion.m5385getWhite0d7_KjU(), 0.75f, 0.0f, 0.0f, 0.0f, 14, null), null, TypeKt.m9869dpToSp8Feqmps(Dp.m8160constructorimpl(14.0f), startRestartGroup, 6), null, null, null, 0L, null, null, 0L, TextOverflow.Companion.m8096getEllipsisgIe3tQ8(), false, 2, 0, null, MaterialTheme.INSTANCE.getTypography(startRestartGroup, 6).getBodySmall(), startRestartGroup, RendererCapabilities.DECODER_SUPPORT_MASK, 24960, 110570);
            str3 = screenshotDeviceDir;
            String str4 = str3;
            if (StringsKt.isBlank(str4)) {
                str4 = "app sandbox / files/game-test-screenshots";
            }
            TextKt.m3157TextNvy7gAk("Phone screenshot dir: " + ((Object) str4), null, Color.m5347copywmQWz5c$default(Color.Companion.m5385getWhite0d7_KjU(), 0.75f, 0.0f, 0.0f, 0.0f, 14, null), null, TypeKt.m9869dpToSp8Feqmps(Dp.m8160constructorimpl(14.0f), startRestartGroup, 6), null, null, null, 0L, null, null, 0L, TextOverflow.Companion.m8096getEllipsisgIe3tQ8(), false, 2, 0, null, MaterialTheme.INSTANCE.getTypography(startRestartGroup, 6).getBodySmall(), startRestartGroup, RendererCapabilities.DECODER_SUPPORT_MASK, 24960, 110570);
            z4 = z2;
            onToggleScreenshotButton = function0;
            SwitchButtonKt.SwitchButton("SCREENSHOT BUTTON", onToggleScreenshotButton, z4, startRestartGroup, ((i9 >> 3) & 112) | 6 | ((i5 >> 9) & 896));
            z5 = z3;
            function02 = onToggleLogShareButton;
            SwitchButtonKt.SwitchButton("LOG SHARE BUTTON (2 MB)", function02, z5, startRestartGroup, ((i9 >> 6) & 112) | 6 | ((i5 >> 12) & 896));
            Modifier fillMaxWidth$default = SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, null);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
            MeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.m742spacedBy0680j_4(Dp.m8160constructorimpl(12.0f)), Alignment.Companion.getTop(), startRestartGroup, 6);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1159599143, "CC(Layout)N(content,modifier,measurePolicy)81@3355L27,84@3521L415:Layout.kt#80mrfh");
            int hashCode2 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(startRestartGroup, 0));
            CompositionLocalMap currentCompositionLocalMap2 = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier materializeModifier2 = ComposedModifierKt.materializeModifier(startRestartGroup, fillMaxWidth$default);
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
            Updater.m4475setimpl(m4467constructorimpl2, rowMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.m4475setimpl(m4467constructorimpl2, currentCompositionLocalMap2, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.m4475setimpl(m4467constructorimpl2, Integer.valueOf(hashCode2), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.m4473reconcileimpl(m4467constructorimpl2, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.m4475setimpl(m4467constructorimpl2, materializeModifier2, ComposeUiNode.Companion.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
            RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 255834577, "C125@5104L175,130@5292L186:DebugGameTestScriptCard.kt#1gr92h");
            DebugGameTestScriptButton("IMPORT FILE", onImportGameTestScript, RowScope.weight$default(rowScopeInstance, Modifier.Companion, 1.0f, false, 2, null), startRestartGroup, ((i5 >> 21) & 112) | 6, 0);
            DebugGameTestScriptButton("USE PROJECT SCRIPT", onUseBundledGameTestScript, RowScope.weight$default(rowScopeInstance, Modifier.Companion, 1.0f, false, 2, null), startRestartGroup, ((i5 >> 24) & 112) | 6, 0);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            startRestartGroup.endNode();
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -932515292, "CC(remember):DebugGameTestScriptCard.kt#9igjgp");
            Object rememberedValue6 = startRestartGroup.rememberedValue();
            if (rememberedValue6 == Composer.Companion.getEmpty()) {
                mutableState = mutableState7;
                rememberedValue6 = new Function0() { // from class: com.miami.game.feature.settings.ui.compose.DebugGameTestScriptCardKt$$ExternalSyntheticLambda3
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        Unit DebugGameTestScriptCard$lambda$15$2$0;
                        DebugGameTestScriptCard$lambda$15$2$0 = DebugGameTestScriptCardKt.DebugGameTestScriptCard$lambda$15$2$0(MutableState.this);
                        return DebugGameTestScriptCard$lambda$15$2$0;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue6);
            } else {
                mutableState = mutableState7;
            }
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            DebugGameTestScriptButton("SELECT SAVED SCRIPT", (Function0) rememberedValue6, SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, null), startRestartGroup, 438, 0);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -932508847, "CC(remember):DebugGameTestScriptCard.kt#9igjgp");
            boolean changed = startRestartGroup.changed(mutableState8) | (i12 == 16384);
            Object rememberedValue7 = startRestartGroup.rememberedValue();
            if (changed || rememberedValue7 == Composer.Companion.getEmpty()) {
                mutableState2 = mutableState5;
                rememberedValue7 = new Function0() { // from class: com.miami.game.feature.settings.ui.compose.DebugGameTestScriptCardKt$$ExternalSyntheticLambda4
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        Unit DebugGameTestScriptCard$lambda$15$3$0;
                        DebugGameTestScriptCard$lambda$15$3$0 = DebugGameTestScriptCardKt.DebugGameTestScriptCard$lambda$15$3$0(str2, mutableState8, mutableState2);
                        return DebugGameTestScriptCard$lambda$15$3$0;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue7);
            } else {
                mutableState2 = mutableState5;
            }
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            MutableState mutableState10 = mutableState2;
            DebugGameTestScriptButton("EDIT SCREENSHOT PULL DIR", (Function0) rememberedValue7, SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, null), startRestartGroup, 390, 0);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -932499980, "CC(remember):DebugGameTestScriptCard.kt#9igjgp");
            boolean changed2 = startRestartGroup.changed(mutableState9) | (i13 == 8388608);
            Object rememberedValue8 = startRestartGroup.rememberedValue();
            if (changed2 || rememberedValue8 == Composer.Companion.getEmpty()) {
                mutableState3 = mutableState6;
                rememberedValue8 = new Function0() { // from class: com.miami.game.feature.settings.ui.compose.DebugGameTestScriptCardKt$$ExternalSyntheticLambda5
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        Unit DebugGameTestScriptCard$lambda$15$4$0;
                        DebugGameTestScriptCard$lambda$15$4$0 = DebugGameTestScriptCardKt.DebugGameTestScriptCard$lambda$15$4$0(str3, mutableState9, mutableState3);
                        return DebugGameTestScriptCard$lambda$15$4$0;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue8);
            } else {
                mutableState3 = mutableState6;
            }
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            final MutableState mutableState11 = mutableState3;
            DebugGameTestScriptButton("EDIT PHONE SCREENSHOT DIR", (Function0) rememberedValue8, SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, null), startRestartGroup, 390, 0);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            startRestartGroup.endNode();
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            if (DebugGameTestScriptCard$lambda$1(mutableState10)) {
                startRestartGroup.startReplaceGroup(455173710);
                ComposerKt.sourceInformation(startRestartGroup, "161@6333L35,179@6960L297,189@7287L189,168@6562L368,160@6289L1246");
                long Color = ColorKt.Color(4279244838L);
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1261609209, "CC(remember):DebugGameTestScriptCard.kt#9igjgp");
                Object rememberedValue9 = startRestartGroup.rememberedValue();
                if (rememberedValue9 == Composer.Companion.getEmpty()) {
                    mutableState4 = mutableState10;
                    rememberedValue9 = new Function0() { // from class: com.miami.game.feature.settings.ui.compose.DebugGameTestScriptCardKt$$ExternalSyntheticLambda6
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            Unit DebugGameTestScriptCard$lambda$16$0;
                            DebugGameTestScriptCard$lambda$16$0 = DebugGameTestScriptCardKt.DebugGameTestScriptCard$lambda$16$0(MutableState.this);
                            return DebugGameTestScriptCard$lambda$16$0;
                        }
                    };
                    startRestartGroup.updateRememberedValue(rememberedValue9);
                } else {
                    mutableState4 = mutableState10;
                }
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                j = 4279244838L;
                AndroidAlertDialog_androidKt.m2150AlertDialogOix01E0((Function0) rememberedValue9, ComposableLambdaKt.rememberComposableLambda(-1059270621, true, new Function2() { // from class: com.miami.game.feature.settings.ui.compose.DebugGameTestScriptCardKt$$ExternalSyntheticLambda7
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return DebugGameTestScriptCardKt.DebugGameTestScriptCard$lambda$17(Function1.this, mutableState8, mutableState4, (Composer) obj, ((Integer) obj2).intValue());
                    }
                }, startRestartGroup, 54), null, ComposableLambdaKt.rememberComposableLambda(-2081294939, true, new Function2() { // from class: com.miami.game.feature.settings.ui.compose.DebugGameTestScriptCardKt$$ExternalSyntheticLambda8
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return DebugGameTestScriptCardKt.DebugGameTestScriptCard$lambda$18(MutableState.this, (Composer) obj, ((Integer) obj2).intValue());
                    }
                }, startRestartGroup, 54), null, ComposableSingletons$DebugGameTestScriptCardKt.INSTANCE.getLambda$1191648039$settings(), ComposableLambdaKt.rememberComposableLambda(680635880, true, new Function2() { // from class: com.miami.game.feature.settings.ui.compose.DebugGameTestScriptCardKt$$ExternalSyntheticLambda9
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return DebugGameTestScriptCardKt.DebugGameTestScriptCard$lambda$19(MutableState.this, (Composer) obj, ((Integer) obj2).intValue());
                    }
                }, startRestartGroup, 54), null, Color, 0L, 0L, 0L, 0.0f, null, startRestartGroup, 102435894, 0, 16020);
                startRestartGroup.endReplaceGroup();
            } else {
                j = 4279244838L;
                startRestartGroup.startReplaceGroup(456377068);
                startRestartGroup.endReplaceGroup();
            }
            if (DebugGameTestScriptCard$lambda$4(mutableState11)) {
                startRestartGroup.startReplaceGroup(456478097);
                ComposerKt.sourceInformation(startRestartGroup, "202@7631L36,230@8795L300,240@9125L190,209@7862L903,201@7587L1787");
                long Color2 = ColorKt.Color(j);
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1261650746, "CC(remember):DebugGameTestScriptCard.kt#9igjgp");
                Object rememberedValue10 = startRestartGroup.rememberedValue();
                if (rememberedValue10 == Composer.Companion.getEmpty()) {
                    rememberedValue10 = new Function0() { // from class: com.miami.game.feature.settings.ui.compose.DebugGameTestScriptCardKt$$ExternalSyntheticLambda10
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            Unit DebugGameTestScriptCard$lambda$20$0;
                            DebugGameTestScriptCard$lambda$20$0 = DebugGameTestScriptCardKt.DebugGameTestScriptCard$lambda$20$0(MutableState.this);
                            return DebugGameTestScriptCard$lambda$20$0;
                        }
                    };
                    startRestartGroup.updateRememberedValue(rememberedValue10);
                }
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                AndroidAlertDialog_androidKt.m2150AlertDialogOix01E0((Function0) rememberedValue10, ComposableLambdaKt.rememberComposableLambda(-203474804, true, new Function2() { // from class: com.miami.game.feature.settings.ui.compose.DebugGameTestScriptCardKt$$ExternalSyntheticLambda23
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return DebugGameTestScriptCardKt.DebugGameTestScriptCard$lambda$21(Function1.this, mutableState9, mutableState11, (Composer) obj, ((Integer) obj2).intValue());
                    }
                }, startRestartGroup, 54), null, ComposableLambdaKt.rememberComposableLambda(1178666382, true, new Function2() { // from class: com.miami.game.feature.settings.ui.compose.DebugGameTestScriptCardKt$$ExternalSyntheticLambda24
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return DebugGameTestScriptCardKt.DebugGameTestScriptCard$lambda$22(MutableState.this, (Composer) obj, ((Integer) obj2).intValue());
                    }
                }, startRestartGroup, 54), null, ComposableSingletons$DebugGameTestScriptCardKt.INSTANCE.m9842getLambda$1734159728$settings(), ComposableLambdaKt.rememberComposableLambda(1104394513, true, new Function2() { // from class: com.miami.game.feature.settings.ui.compose.DebugGameTestScriptCardKt$$ExternalSyntheticLambda25
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return DebugGameTestScriptCardKt.DebugGameTestScriptCard$lambda$23(MutableState.this, (Composer) obj, ((Integer) obj2).intValue());
                    }
                }, startRestartGroup, 54), null, Color2, 0L, 0L, 0L, 0.0f, null, startRestartGroup, 102435894, 0, 16020);
                composer3 = startRestartGroup;
                composer3.endReplaceGroup();
            } else {
                composer3 = startRestartGroup;
                composer3.startReplaceGroup(458201356);
                composer3.endReplaceGroup();
            }
            if (DebugGameTestScriptCard$lambda$7(mutableState)) {
                composer3.startReplaceGroup(458341910);
                ComposerKt.sourceInformation(composer3, "253@9471L37,311@12208L190,260@9695L2451,252@9427L3030");
                long Color3 = ColorKt.Color(j);
                ComposerKt.sourceInformationMarkerStart(composer3, 1261709627, "CC(remember):DebugGameTestScriptCard.kt#9igjgp");
                Object rememberedValue11 = composer3.rememberedValue();
                if (rememberedValue11 == Composer.Companion.getEmpty()) {
                    rememberedValue11 = new Function0() { // from class: com.miami.game.feature.settings.ui.compose.DebugGameTestScriptCardKt$$ExternalSyntheticLambda26
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            Unit DebugGameTestScriptCard$lambda$24$0;
                            DebugGameTestScriptCard$lambda$24$0 = DebugGameTestScriptCardKt.DebugGameTestScriptCard$lambda$24$0(MutableState.this);
                            return DebugGameTestScriptCard$lambda$24$0;
                        }
                    };
                    composer3.updateRememberedValue(rememberedValue11);
                }
                ComposerKt.sourceInformationMarkerEnd(composer3);
                final MutableState mutableState12 = mutableState;
                Composer composer4 = composer3;
                AndroidAlertDialog_androidKt.m2150AlertDialogOix01E0((Function0) rememberedValue11, ComposableSingletons$DebugGameTestScriptCardKt.INSTANCE.getLambda$967733867$settings(), null, ComposableLambdaKt.rememberComposableLambda(-1945092243, true, new Function2() { // from class: com.miami.game.feature.settings.ui.compose.DebugGameTestScriptCardKt$$ExternalSyntheticLambda27
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return DebugGameTestScriptCardKt.DebugGameTestScriptCard$lambda$25(MutableState.this, (Composer) obj, ((Integer) obj2).intValue());
                    }
                }, composer3, 54), null, ComposableSingletons$DebugGameTestScriptCardKt.INSTANCE.m9847getLambda$562951057$settings(), ComposableLambdaKt.rememberComposableLambda(-2019364112, true, new Function2() { // from class: com.miami.game.feature.settings.ui.compose.DebugGameTestScriptCardKt$$ExternalSyntheticLambda28
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return DebugGameTestScriptCardKt.DebugGameTestScriptCard$lambda$26(z, onUseBundledGameTestScript, importedScripts, str, onSelectImportedGameTestScript, mutableState12, (Composer) obj, ((Integer) obj2).intValue());
                    }
                }, composer3, 54), null, Color3, 0L, 0L, 0L, 0.0f, null, composer4, 102435894, 0, 16020);
                composer2 = composer4;
                composer2.endReplaceGroup();
            } else {
                composer2 = composer3;
                composer2.startReplaceGroup(461259692);
                composer2.endReplaceGroup();
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
            final String str5 = str2;
            final boolean z8 = z4;
            final boolean z9 = z5;
            final Function0<Unit> function03 = onToggleScreenshotButton;
            endRestartGroup.updateScope(new Function2() { // from class: com.miami.game.feature.settings.ui.compose.DebugGameTestScriptCardKt$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return DebugGameTestScriptCardKt.DebugGameTestScriptCard$lambda$27(activeScriptName, z, importedScripts, str, str5, z8, z9, str3, onImportGameTestScript, onUseBundledGameTestScript, onSelectImportedGameTestScript, onUpdateScreenshotPullPath, function03, function02, onUpdateScreenshotDeviceDir, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    private static final boolean DebugGameTestScriptCard$lambda$1(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    private static final void DebugGameTestScriptCard$lambda$2(MutableState<Boolean> mutableState, boolean z) {
        mutableState.setValue(Boolean.valueOf(z));
    }

    private static final boolean DebugGameTestScriptCard$lambda$4(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    private static final void DebugGameTestScriptCard$lambda$5(MutableState<Boolean> mutableState, boolean z) {
        mutableState.setValue(Boolean.valueOf(z));
    }

    private static final boolean DebugGameTestScriptCard$lambda$7(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void DebugGameTestScriptCard$lambda$8(MutableState<Boolean> mutableState, boolean z) {
        mutableState.setValue(Boolean.valueOf(z));
    }

    private static final String DebugGameTestScriptCard$lambda$10(MutableState<String> mutableState) {
        return mutableState.getValue();
    }

    private static final String DebugGameTestScriptCard$lambda$13(MutableState<String> mutableState) {
        return mutableState.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit DebugGameTestScriptCard$lambda$15$2$0(MutableState mutableState) {
        DebugGameTestScriptCard$lambda$8(mutableState, true);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit DebugGameTestScriptCard$lambda$15$3$0(String str, MutableState mutableState, MutableState mutableState2) {
        mutableState.setValue(str);
        DebugGameTestScriptCard$lambda$2(mutableState2, true);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit DebugGameTestScriptCard$lambda$15$4$0(String str, MutableState mutableState, MutableState mutableState2) {
        mutableState.setValue(str);
        DebugGameTestScriptCard$lambda$5(mutableState2, true);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit DebugGameTestScriptCard$lambda$16$0(MutableState mutableState) {
        DebugGameTestScriptCard$lambda$2(mutableState, false);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit DebugGameTestScriptCard$lambda$19(final MutableState mutableState, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C171@6678L22,169@6580L336:DebugGameTestScriptCard.kt#1gr92h");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(680635880, i, -1, "com.miami.game.feature.settings.ui.compose.DebugGameTestScriptCard.<anonymous> (DebugGameTestScriptCard.kt:169)");
            }
            String DebugGameTestScriptCard$lambda$10 = DebugGameTestScriptCard$lambda$10(mutableState);
            Modifier fillMaxWidth$default = SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, null);
            ComposerKt.sourceInformationMarkerStart(composer, 1256055422, "CC(remember):DebugGameTestScriptCard.kt#9igjgp");
            boolean changed = composer.changed(mutableState);
            Object rememberedValue = composer.rememberedValue();
            if (changed || rememberedValue == Composer.Companion.getEmpty()) {
                rememberedValue = new Function1() { // from class: com.miami.game.feature.settings.ui.compose.DebugGameTestScriptCardKt$$ExternalSyntheticLambda21
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        Unit DebugGameTestScriptCard$lambda$19$0$0;
                        DebugGameTestScriptCard$lambda$19$0$0 = DebugGameTestScriptCardKt.DebugGameTestScriptCard$lambda$19$0$0(MutableState.this, (String) obj);
                        return DebugGameTestScriptCard$lambda$19$0$0;
                    }
                };
                composer.updateRememberedValue(rememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            OutlinedTextFieldKt.OutlinedTextField(DebugGameTestScriptCard$lambda$10, (Function1<? super String, Unit>) rememberedValue, fillMaxWidth$default, false, false, (TextStyle) null, (Function2<? super Composer, ? super Integer, Unit>) ComposableSingletons$DebugGameTestScriptCardKt.INSTANCE.m9845getLambda$1963712254$settings(), (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, false, (VisualTransformation) null, (KeyboardOptions) null, (KeyboardActions) null, true, 0, 0, (MutableInteractionSource) null, (Shape) null, (TextFieldColors) null, composer, 1573248, 12582912, 0, 8257464);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit DebugGameTestScriptCard$lambda$19$0$0(MutableState mutableState, String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        mutableState.setValue(it);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit DebugGameTestScriptCard$lambda$17(final Function1 function1, final MutableState mutableState, final MutableState mutableState2, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C181@7020L145,180@6978L265:DebugGameTestScriptCard.kt#1gr92h");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1059270621, i, -1, "com.miami.game.feature.settings.ui.compose.DebugGameTestScriptCard.<anonymous> (DebugGameTestScriptCard.kt:180)");
            }
            ComposerKt.sourceInformationMarkerStart(composer, -51815564, "CC(remember):DebugGameTestScriptCard.kt#9igjgp");
            boolean changed = composer.changed(function1) | composer.changed(mutableState);
            Object rememberedValue = composer.rememberedValue();
            if (changed || rememberedValue == Composer.Companion.getEmpty()) {
                rememberedValue = new Function0() { // from class: com.miami.game.feature.settings.ui.compose.DebugGameTestScriptCardKt$$ExternalSyntheticLambda13
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        Unit DebugGameTestScriptCard$lambda$17$0$0;
                        DebugGameTestScriptCard$lambda$17$0$0 = DebugGameTestScriptCardKt.DebugGameTestScriptCard$lambda$17$0$0(Function1.this, mutableState, mutableState2);
                        return DebugGameTestScriptCard$lambda$17$0$0;
                    }
                };
                composer.updateRememberedValue(rememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            ButtonKt.TextButton((Function0) rememberedValue, null, false, null, null, null, null, null, null, ComposableSingletons$DebugGameTestScriptCardKt.INSTANCE.m9843getLambda$1804383392$settings(), composer, 805306368, TypedValues.PositionType.TYPE_POSITION_TYPE);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit DebugGameTestScriptCard$lambda$17$0$0(Function1 function1, MutableState mutableState, MutableState mutableState2) {
        function1.invoke(DebugGameTestScriptCard$lambda$10(mutableState));
        DebugGameTestScriptCard$lambda$2(mutableState2, false);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit DebugGameTestScriptCard$lambda$18(final MutableState mutableState, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C191@7347L35,190@7305L157:DebugGameTestScriptCard.kt#1gr92h");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-2081294939, i, -1, "com.miami.game.feature.settings.ui.compose.DebugGameTestScriptCard.<anonymous> (DebugGameTestScriptCard.kt:190)");
            }
            ComposerKt.sourceInformationMarkerStart(composer, 1330325512, "CC(remember):DebugGameTestScriptCard.kt#9igjgp");
            Object rememberedValue = composer.rememberedValue();
            if (rememberedValue == Composer.Companion.getEmpty()) {
                rememberedValue = new Function0() { // from class: com.miami.game.feature.settings.ui.compose.DebugGameTestScriptCardKt$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        Unit DebugGameTestScriptCard$lambda$18$0$0;
                        DebugGameTestScriptCard$lambda$18$0$0 = DebugGameTestScriptCardKt.DebugGameTestScriptCard$lambda$18$0$0(MutableState.this);
                        return DebugGameTestScriptCard$lambda$18$0$0;
                    }
                };
                composer.updateRememberedValue(rememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            ButtonKt.TextButton((Function0) rememberedValue, null, false, null, null, null, null, null, null, ComposableSingletons$DebugGameTestScriptCardKt.INSTANCE.getLambda$1468559586$settings(), composer, 805306374, TypedValues.PositionType.TYPE_POSITION_TYPE);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit DebugGameTestScriptCard$lambda$18$0$0(MutableState mutableState) {
        DebugGameTestScriptCard$lambda$2(mutableState, false);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit DebugGameTestScriptCard$lambda$20$0(MutableState mutableState) {
        DebugGameTestScriptCard$lambda$5(mutableState, false);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit DebugGameTestScriptCard$lambda$23(final MutableState mutableState, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C210@7880L871:DebugGameTestScriptCard.kt#1gr92h");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1104394513, i, -1, "com.miami.game.feature.settings.ui.compose.DebugGameTestScriptCard.<anonymous> (DebugGameTestScriptCard.kt:210)");
            }
            ComposerKt.sourceInformationMarkerStart(composer, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
            MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.m742spacedBy0680j_4(Dp.m8160constructorimpl(8.0f)), Alignment.Companion.getStart(), composer, 6);
            ComposerKt.sourceInformationMarkerStart(composer, -1159599143, "CC(Layout)N(content,modifier,measurePolicy)81@3355L27,84@3521L415:Layout.kt#80mrfh");
            int hashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composer, 0));
            CompositionLocalMap currentCompositionLocalMap = composer.getCurrentCompositionLocalMap();
            Modifier materializeModifier = ComposedModifierKt.materializeModifier(composer, Modifier.Companion);
            Function0<ComposeUiNode> constructor = ComposeUiNode.Companion.getConstructor();
            ComposerKt.sourceInformationMarkerStart(composer, -553112988, "CC(ReusableComposeNode)N(factory,update,content)410@16187L9:Composables.kt#9igjgp");
            if (!(composer.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composer.startReusableNode();
            if (composer.getInserting()) {
                composer.createNode(constructor);
            } else {
                composer.useNode();
            }
            Composer m4467constructorimpl = Updater.m4467constructorimpl(composer);
            Updater.m4475setimpl(m4467constructorimpl, columnMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.m4475setimpl(m4467constructorimpl, currentCompositionLocalMap, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.m4475setimpl(m4467constructorimpl, Integer.valueOf(hashCode), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.m4473reconcileimpl(m4467constructorimpl, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.m4475setimpl(m4467constructorimpl, materializeModifier, ComposeUiNode.Companion.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composer, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composer, 1507062012, "C216@8250L10,217@8307L13,213@7997L345,221@8470L23,219@8363L370:DebugGameTestScriptCard.kt#1gr92h");
            TextKt.m3157TextNvy7gAk("Empty value keeps the default app sandbox folder. Relative paths are saved inside app external files.", null, Color.m5347copywmQWz5c$default(Color.Companion.m5385getWhite0d7_KjU(), 0.75f, 0.0f, 0.0f, 0.0f, 14, null), null, TypeKt.m9869dpToSp8Feqmps(Dp.m8160constructorimpl(12.0f), composer, 6), null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, MaterialTheme.INSTANCE.getTypography(composer, 6).getBodySmall(), composer, 390, 0, 131050);
            String DebugGameTestScriptCard$lambda$13 = DebugGameTestScriptCard$lambda$13(mutableState);
            Modifier fillMaxWidth$default = SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, null);
            ComposerKt.sourceInformationMarkerStart(composer, -505560002, "CC(remember):DebugGameTestScriptCard.kt#9igjgp");
            boolean changed = composer.changed(mutableState);
            Object rememberedValue = composer.rememberedValue();
            if (changed || rememberedValue == Composer.Companion.getEmpty()) {
                rememberedValue = new Function1() { // from class: com.miami.game.feature.settings.ui.compose.DebugGameTestScriptCardKt$$ExternalSyntheticLambda14
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        Unit DebugGameTestScriptCard$lambda$23$0$0$0;
                        DebugGameTestScriptCard$lambda$23$0$0$0 = DebugGameTestScriptCardKt.DebugGameTestScriptCard$lambda$23$0$0$0(MutableState.this, (String) obj);
                        return DebugGameTestScriptCard$lambda$23$0$0$0;
                    }
                };
                composer.updateRememberedValue(rememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            OutlinedTextFieldKt.OutlinedTextField(DebugGameTestScriptCard$lambda$13, (Function1<? super String, Unit>) rememberedValue, fillMaxWidth$default, false, false, (TextStyle) null, (Function2<? super Composer, ? super Integer, Unit>) ComposableSingletons$DebugGameTestScriptCardKt.INSTANCE.m9846getLambda$335067231$settings(), (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, false, (VisualTransformation) null, (KeyboardOptions) null, (KeyboardActions) null, true, 0, 0, (MutableInteractionSource) null, (Shape) null, (TextFieldColors) null, composer, 1573248, 12582912, 0, 8257464);
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            composer.endNode();
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit DebugGameTestScriptCard$lambda$23$0$0$0(MutableState mutableState, String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        mutableState.setValue(it);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit DebugGameTestScriptCard$lambda$21(final Function1 function1, final MutableState mutableState, final MutableState mutableState2, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C232@8855L148,231@8813L268:DebugGameTestScriptCard.kt#1gr92h");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-203474804, i, -1, "com.miami.game.feature.settings.ui.compose.DebugGameTestScriptCard.<anonymous> (DebugGameTestScriptCard.kt:231)");
            }
            ComposerKt.sourceInformationMarkerStart(composer, 2029211040, "CC(remember):DebugGameTestScriptCard.kt#9igjgp");
            boolean changed = composer.changed(function1) | composer.changed(mutableState);
            Object rememberedValue = composer.rememberedValue();
            if (changed || rememberedValue == Composer.Companion.getEmpty()) {
                rememberedValue = new Function0() { // from class: com.miami.game.feature.settings.ui.compose.DebugGameTestScriptCardKt$$ExternalSyntheticLambda12
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        Unit DebugGameTestScriptCard$lambda$21$0$0;
                        DebugGameTestScriptCard$lambda$21$0$0 = DebugGameTestScriptCardKt.DebugGameTestScriptCard$lambda$21$0$0(Function1.this, mutableState, mutableState2);
                        return DebugGameTestScriptCard$lambda$21$0$0;
                    }
                };
                composer.updateRememberedValue(rememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            ButtonKt.TextButton((Function0) rememberedValue, null, false, null, null, null, null, null, null, ComposableSingletons$DebugGameTestScriptCardKt.INSTANCE.getLambda$1002690697$settings(), composer, 805306368, TypedValues.PositionType.TYPE_POSITION_TYPE);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit DebugGameTestScriptCard$lambda$21$0$0(Function1 function1, MutableState mutableState, MutableState mutableState2) {
        function1.invoke(DebugGameTestScriptCard$lambda$13(mutableState));
        DebugGameTestScriptCard$lambda$5(mutableState2, false);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit DebugGameTestScriptCard$lambda$22(final MutableState mutableState, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C242@9185L36,241@9143L158:DebugGameTestScriptCard.kt#1gr92h");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1178666382, i, -1, "com.miami.game.feature.settings.ui.compose.DebugGameTestScriptCard.<anonymous> (DebugGameTestScriptCard.kt:241)");
            }
            ComposerKt.sourceInformationMarkerStart(composer, -1172971086, "CC(remember):DebugGameTestScriptCard.kt#9igjgp");
            Object rememberedValue = composer.rememberedValue();
            if (rememberedValue == Composer.Companion.getEmpty()) {
                rememberedValue = new Function0() { // from class: com.miami.game.feature.settings.ui.compose.DebugGameTestScriptCardKt$$ExternalSyntheticLambda11
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        Unit DebugGameTestScriptCard$lambda$22$0$0;
                        DebugGameTestScriptCard$lambda$22$0$0 = DebugGameTestScriptCardKt.DebugGameTestScriptCard$lambda$22$0$0(MutableState.this);
                        return DebugGameTestScriptCard$lambda$22$0$0;
                    }
                };
                composer.updateRememberedValue(rememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            ButtonKt.TextButton((Function0) rememberedValue, null, false, null, null, null, null, null, null, ComposableSingletons$DebugGameTestScriptCardKt.INSTANCE.m9844getLambda$1910135413$settings(), composer, 805306374, TypedValues.PositionType.TYPE_POSITION_TYPE);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit DebugGameTestScriptCard$lambda$22$0$0(MutableState mutableState) {
        DebugGameTestScriptCard$lambda$5(mutableState, false);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit DebugGameTestScriptCard$lambda$24$0(MutableState mutableState) {
        DebugGameTestScriptCard$lambda$8(mutableState, false);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit DebugGameTestScriptCard$lambda$26(final boolean z, final Function0 function0, final List list, final String str, final Function1 function1, MutableState mutableState, Composer composer, int i) {
        final MutableState mutableState2;
        ComposerKt.sourceInformation(composer, "C261@9713L2419:DebugGameTestScriptCard.kt#1gr92h");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-2019364112, i, -1, "com.miami.game.feature.settings.ui.compose.DebugGameTestScriptCard.<anonymous> (DebugGameTestScriptCard.kt:261)");
            }
            Arrangement.HorizontalOrVertical m742spacedBy0680j_4 = Arrangement.INSTANCE.m742spacedBy0680j_4(Dp.m8160constructorimpl(8.0f));
            Modifier fillMaxWidth$default = SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, null);
            ComposerKt.sourceInformationMarkerStart(composer, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
            MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(m742spacedBy0680j_4, Alignment.Companion.getStart(), composer, 6);
            ComposerKt.sourceInformationMarkerStart(composer, -1159599143, "CC(Layout)N(content,modifier,measurePolicy)81@3355L27,84@3521L415:Layout.kt#80mrfh");
            int hashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composer, 0));
            CompositionLocalMap currentCompositionLocalMap = composer.getCurrentCompositionLocalMap();
            Modifier materializeModifier = ComposedModifierKt.materializeModifier(composer, fillMaxWidth$default);
            Function0<ComposeUiNode> constructor = ComposeUiNode.Companion.getConstructor();
            ComposerKt.sourceInformationMarkerStart(composer, -553112988, "CC(ReusableComposeNode)N(factory,update,content)410@16187L9:Composables.kt#9igjgp");
            if (!(composer.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composer.startReusableNode();
            if (composer.getInserting()) {
                composer.createNode(constructor);
            } else {
                composer.useNode();
            }
            Composer m4467constructorimpl = Updater.m4467constructorimpl(composer);
            Updater.m4475setimpl(m4467constructorimpl, columnMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.m4475setimpl(m4467constructorimpl, currentCompositionLocalMap, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.m4475setimpl(m4467constructorimpl, Integer.valueOf(hashCode), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.m4473reconcileimpl(m4467constructorimpl, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.m4475setimpl(m4467constructorimpl, materializeModifier, ComposeUiNode.Companion.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composer, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composer, 670313321, "C267@10043L146,265@9886L385:DebugGameTestScriptCard.kt#1gr92h");
            String str2 = z ? "PROJECT SCRIPT" : "ACTIVE - PROJECT SCRIPT";
            ComposerKt.sourceInformationMarkerStart(composer, -255468712, "CC(remember):DebugGameTestScriptCard.kt#9igjgp");
            boolean changed = composer.changed(function0);
            Object rememberedValue = composer.rememberedValue();
            if (changed || rememberedValue == Composer.Companion.getEmpty()) {
                mutableState2 = mutableState;
                rememberedValue = new Function0() { // from class: com.miami.game.feature.settings.ui.compose.DebugGameTestScriptCardKt$$ExternalSyntheticLambda16
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        Unit DebugGameTestScriptCard$lambda$26$0$0$0;
                        DebugGameTestScriptCard$lambda$26$0$0$0 = DebugGameTestScriptCardKt.DebugGameTestScriptCard$lambda$26$0$0$0(Function0.this, mutableState2);
                        return DebugGameTestScriptCard$lambda$26$0$0$0;
                    }
                };
                composer.updateRememberedValue(rememberedValue);
            } else {
                mutableState2 = mutableState;
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            DebugGameTestScriptButton(str2, (Function0) rememberedValue, SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, null), composer, RendererCapabilities.DECODER_SUPPORT_MASK, 0);
            if (list.isEmpty()) {
                composer.startReplaceGroup(670713375);
                ComposerKt.sourceInformation(composer, "277@10566L10,278@10627L13,274@10349L317");
                TextKt.m3157TextNvy7gAk("No saved imported scripts yet. Use IMPORT FILE first.", null, Color.m5347copywmQWz5c$default(Color.Companion.m5385getWhite0d7_KjU(), 0.75f, 0.0f, 0.0f, 0.0f, 14, null), null, TypeKt.m9869dpToSp8Feqmps(Dp.m8160constructorimpl(13.0f), composer, 6), null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, MaterialTheme.INSTANCE.getTypography(composer, 6).getBodySmall(), composer, 390, 0, 131050);
                composer.endReplaceGroup();
            } else {
                composer.startReplaceGroup(671089808);
                ComposerKt.sourceInformation(composer, "286@10988L1104,281@10720L1372");
                Modifier m1105heightInVpY3zN4$default = SizeKt.m1105heightInVpY3zN4$default(SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, null), 0.0f, Dp.m8160constructorimpl(260.0f), 1, null);
                Arrangement.HorizontalOrVertical m742spacedBy0680j_42 = Arrangement.INSTANCE.m742spacedBy0680j_4(Dp.m8160constructorimpl(8.0f));
                ComposerKt.sourceInformationMarkerStart(composer, -255437514, "CC(remember):DebugGameTestScriptCard.kt#9igjgp");
                boolean changedInstance = composer.changedInstance(list) | composer.changed(z) | composer.changed(str) | composer.changed(function1);
                Object rememberedValue2 = composer.rememberedValue();
                if (changedInstance || rememberedValue2 == Composer.Companion.getEmpty()) {
                    final MutableState mutableState3 = mutableState2;
                    Function1 function12 = new Function1() { // from class: com.miami.game.feature.settings.ui.compose.DebugGameTestScriptCardKt$$ExternalSyntheticLambda17
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            Unit DebugGameTestScriptCard$lambda$26$0$1$0;
                            DebugGameTestScriptCard$lambda$26$0$1$0 = DebugGameTestScriptCardKt.DebugGameTestScriptCard$lambda$26$0$1$0(list, z, str, function1, mutableState3, (LazyListScope) obj);
                            return DebugGameTestScriptCard$lambda$26$0$1$0;
                        }
                    };
                    composer.updateRememberedValue(function12);
                    rememberedValue2 = function12;
                }
                ComposerKt.sourceInformationMarkerEnd(composer);
                LazyDslKt.LazyColumn(m1105heightInVpY3zN4$default, null, null, false, m742spacedBy0680j_42, null, null, false, null, (Function1) rememberedValue2, composer, 24582, 494);
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
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit DebugGameTestScriptCard$lambda$26$0$0$0(Function0 function0, MutableState mutableState) {
        function0.invoke();
        DebugGameTestScriptCard$lambda$8(mutableState, false);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit DebugGameTestScriptCard$lambda$26$0$1$0(final List list, final boolean z, final String str, final Function1 function1, final MutableState mutableState, LazyListScope LazyColumn) {
        Intrinsics.checkNotNullParameter(LazyColumn, "$this$LazyColumn");
        final Function1 function12 = new Function1() { // from class: com.miami.game.feature.settings.ui.compose.DebugGameTestScriptCardKt$$ExternalSyntheticLambda20
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Object DebugGameTestScriptCard$lambda$26$0$1$0$0;
                DebugGameTestScriptCard$lambda$26$0$1$0$0 = DebugGameTestScriptCardKt.DebugGameTestScriptCard$lambda$26$0$1$0$0((GameTestSavedScript) obj);
                return DebugGameTestScriptCard$lambda$26$0$1$0$0;
            }
        };
        final DebugGameTestScriptCardKt$DebugGameTestScriptCard$lambda$26$0$1$0$$inlined$items$default$1 debugGameTestScriptCardKt$DebugGameTestScriptCard$lambda$26$0$1$0$$inlined$items$default$1 = new Function1() { // from class: com.miami.game.feature.settings.ui.compose.DebugGameTestScriptCardKt$DebugGameTestScriptCard$lambda$26$0$1$0$$inlined$items$default$1
            @Override // kotlin.jvm.functions.Function1
            public final Void invoke(GameTestSavedScript gameTestSavedScript) {
                return null;
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                return invoke((GameTestSavedScript) obj);
            }
        };
        LazyColumn.items(list.size(), new Function1<Integer, Object>() { // from class: com.miami.game.feature.settings.ui.compose.DebugGameTestScriptCardKt$DebugGameTestScriptCard$lambda$26$0$1$0$$inlined$items$default$2
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Integer num) {
                return invoke(num.intValue());
            }

            public final Object invoke(int i) {
                return Function1.this.invoke(list.get(i));
            }
        }, new Function1<Integer, Object>() { // from class: com.miami.game.feature.settings.ui.compose.DebugGameTestScriptCardKt$DebugGameTestScriptCard$lambda$26$0$1$0$$inlined$items$default$3
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Integer num) {
                return invoke(num.intValue());
            }

            public final Object invoke(int i) {
                return Function1.this.invoke(list.get(i));
            }
        }, ComposableLambdaKt.composableLambdaInstance(802480018, true, new Function4<LazyItemScope, Integer, Composer, Integer, Unit>() { // from class: com.miami.game.feature.settings.ui.compose.DebugGameTestScriptCardKt$DebugGameTestScriptCard$lambda$26$0$1$0$$inlined$items$default$4
            @Override // kotlin.jvm.functions.Function4
            public /* bridge */ /* synthetic */ Unit invoke(LazyItemScope lazyItemScope, Integer num, Composer composer, Integer num2) {
                invoke(lazyItemScope, num.intValue(), composer, num2.intValue());
                return Unit.INSTANCE;
            }

            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Type inference failed for: r11v0, types: [androidx.compose.runtime.Composer] */
            /* JADX WARN: Type inference failed for: r12v13 */
            public final void invoke(LazyItemScope lazyItemScope, int i, Composer composer, int i2) {
                int i3;
                ComposerKt.sourceInformation(composer, "CN(it)178@8834L22:LazyDsl.kt#428nma");
                if ((i2 & 6) == 0) {
                    i3 = (composer.changed(lazyItemScope) ? 4 : 2) | i2;
                } else {
                    i3 = i2;
                }
                if ((i2 & 48) == 0) {
                    i3 |= composer.changed(i) ? 32 : 16;
                }
                if (!composer.shouldExecute((i3 & 147) != 146, i3 & 1)) {
                    composer.skipToGroupEnd();
                    return;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(802480018, i3, -1, "androidx.compose.foundation.lazy.items.<anonymous> (LazyDsl.kt:178)");
                }
                final GameTestSavedScript gameTestSavedScript = (GameTestSavedScript) list.get(i);
                composer.startReplaceGroup(-1433544240);
                ComposerKt.sourceInformation(composer, "CN(script)*299@11729L201,293@11375L661:DebugGameTestScriptCard.kt#1gr92h");
                String displayName = (z && Intrinsics.areEqual(str, gameTestSavedScript.getFileName())) ? "ACTIVE - " + gameTestSavedScript.getDisplayName() : gameTestSavedScript.getDisplayName();
                ComposerKt.sourceInformationMarkerStart(composer, 1754887504, "CC(remember):DebugGameTestScriptCard.kt#9igjgp");
                boolean changed = composer.changed(function1) | composer.changedInstance(gameTestSavedScript);
                Object rememberedValue = composer.rememberedValue();
                if (changed || rememberedValue == Composer.Companion.getEmpty()) {
                    final Function1 function13 = function1;
                    final MutableState mutableState2 = mutableState;
                    rememberedValue = (Function0) new Function0<Unit>() { // from class: com.miami.game.feature.settings.ui.compose.DebugGameTestScriptCardKt$DebugGameTestScriptCard$12$1$2$1$2$1$1
                        @Override // kotlin.jvm.functions.Function0
                        public /* bridge */ /* synthetic */ Unit invoke() {
                            invoke2();
                            return Unit.INSTANCE;
                        }

                        /* renamed from: invoke  reason: avoid collision after fix types in other method */
                        public final void invoke2() {
                            function13.invoke(gameTestSavedScript.getFileName());
                            DebugGameTestScriptCardKt.DebugGameTestScriptCard$lambda$8(mutableState2, false);
                        }
                    };
                    composer.updateRememberedValue(rememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd(composer);
                DebugGameTestScriptCardKt.DebugGameTestScriptButton(displayName, rememberedValue, SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, null), composer, RendererCapabilities.DECODER_SUPPORT_MASK, 0);
                composer.endReplaceGroup();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
        }));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object DebugGameTestScriptCard$lambda$26$0$1$0$0(GameTestSavedScript script) {
        Intrinsics.checkNotNullParameter(script, "script");
        return script.getFileName();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit DebugGameTestScriptCard$lambda$25(final MutableState mutableState, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C313@12268L37,312@12226L158:DebugGameTestScriptCard.kt#1gr92h");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1945092243, i, -1, "com.miami.game.feature.settings.ui.compose.DebugGameTestScriptCard.<anonymous> (DebugGameTestScriptCard.kt:312)");
            }
            ComposerKt.sourceInformationMarkerStart(composer, -922869806, "CC(remember):DebugGameTestScriptCard.kt#9igjgp");
            Object rememberedValue = composer.rememberedValue();
            if (rememberedValue == Composer.Companion.getEmpty()) {
                rememberedValue = new Function0() { // from class: com.miami.game.feature.settings.ui.compose.DebugGameTestScriptCardKt$$ExternalSyntheticLambda15
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        Unit DebugGameTestScriptCard$lambda$25$0$0;
                        DebugGameTestScriptCard$lambda$25$0$0 = DebugGameTestScriptCardKt.DebugGameTestScriptCard$lambda$25$0$0(MutableState.this);
                        return DebugGameTestScriptCard$lambda$25$0$0;
                    }
                };
                composer.updateRememberedValue(rememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            ButtonKt.TextButton((Function0) rememberedValue, null, false, null, null, null, null, null, null, ComposableSingletons$DebugGameTestScriptCardKt.INSTANCE.m9848getLambda$738926742$settings(), composer, 805306374, TypedValues.PositionType.TYPE_POSITION_TYPE);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit DebugGameTestScriptCard$lambda$25$0$0(MutableState mutableState) {
        DebugGameTestScriptCard$lambda$8(mutableState, false);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void DebugGameTestScriptButton(final String str, Function0<Unit> function0, Modifier modifier, Composer composer, final int i, final int i2) {
        int i3;
        Function0<Unit> function02;
        final Modifier modifier2;
        Composer startRestartGroup = composer.startRestartGroup(-1270247305);
        ComposerKt.sourceInformation(startRestartGroup, "C(DebugGameTestScriptButton)N(text,onClick,modifier)329@12658L1131,329@12604L1185:DebugGameTestScriptCard.kt#1gr92h");
        if ((i & 6) == 0) {
            i3 = (startRestartGroup.changed(str) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        if ((i & 48) == 0) {
            i3 |= startRestartGroup.changedInstance(function0) ? 32 : 16;
        }
        int i4 = i2 & 4;
        if (i4 != 0) {
            i3 |= RendererCapabilities.DECODER_SUPPORT_MASK;
        } else if ((i & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
            i3 |= startRestartGroup.changed(modifier) ? 256 : 128;
        }
        if (!startRestartGroup.shouldExecute((i3 & 147) != 146, i3 & 1)) {
            function02 = function0;
            startRestartGroup.skipToGroupEnd();
            modifier2 = modifier;
        } else {
            if (i4 != 0) {
                modifier = Modifier.Companion;
            }
            Modifier modifier3 = modifier;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1270247305, i3, -1, "com.miami.game.feature.settings.ui.compose.DebugGameTestScriptButton (DebugGameTestScriptCard.kt:328)");
            }
            int i5 = i3 >> 3;
            function02 = function0;
            ScalingButtonKt.ScalingButton(function02, modifier3, ComposableLambdaKt.rememberComposableLambda(-1077844372, true, new Function3() { // from class: com.miami.game.feature.settings.ui.compose.DebugGameTestScriptCardKt$$ExternalSyntheticLambda18
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return DebugGameTestScriptCardKt.DebugGameTestScriptButton$lambda$0(str, (BoxScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, startRestartGroup, 54), startRestartGroup, (i5 & 14) | RendererCapabilities.DECODER_SUPPORT_MASK | (i5 & 112), 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier2 = modifier3;
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            final Function0<Unit> function03 = function02;
            endRestartGroup.updateScope(new Function2() { // from class: com.miami.game.feature.settings.ui.compose.DebugGameTestScriptCardKt$$ExternalSyntheticLambda19
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return DebugGameTestScriptCardKt.DebugGameTestScriptButton$lambda$1(str, function03, modifier2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit DebugGameTestScriptButton$lambda$0(String str, BoxScope ScalingButton, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(ScalingButton, "$this$ScalingButton");
        ComposerKt.sourceInformation(composer, "C330@12668L1115:DebugGameTestScriptCard.kt#1gr92h");
        if (!composer.shouldExecute((i & 17) != 16, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1077844372, i, -1, "com.miami.game.feature.settings.ui.compose.DebugGameTestScriptButton.<anonymous> (DebugGameTestScriptCard.kt:330)");
            }
            Modifier m1051paddingVpY3zN4 = PaddingKt.m1051paddingVpY3zN4(BorderKt.m301borderziNgDLE(BackgroundKt.m287backgroundbw27NRU(SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, null), ColorKt.Color(2568298285L), RoundedCornerShapeKt.m1380RoundedCornerShape0680j_4(Dp.m8160constructorimpl(8.0f))), Dp.m8160constructorimpl(1.0f), Brush.Companion.m5297linearGradientmHitzGk$default(Brush.Companion, CollectionsKt.listOf((Object[]) new Color[]{Color.m5338boximpl(Color.m5347copywmQWz5c$default(Color.Companion.m5385getWhite0d7_KjU(), 0.08f, 0.0f, 0.0f, 0.0f, 14, null)), Color.m5338boximpl(Color.m5347copywmQWz5c$default(Color.Companion.m5385getWhite0d7_KjU(), 0.04f, 0.0f, 0.0f, 0.0f, 14, null)), Color.m5338boximpl(Color.m5347copywmQWz5c$default(Color.Companion.m5374getBlack0d7_KjU(), 0.25f, 0.0f, 0.0f, 0.0f, 14, null))}), 0L, 0L, 0, 14, (Object) null), RoundedCornerShapeKt.m1380RoundedCornerShape0680j_4(Dp.m8160constructorimpl(8.0f))), Dp.m8160constructorimpl(16.0f), Dp.m8160constructorimpl(14.0f));
            Alignment center = Alignment.Companion.getCenter();
            ComposerKt.sourceInformationMarkerStart(composer, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
            MeasurePolicy maybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(center, false);
            ComposerKt.sourceInformationMarkerStart(composer, -1159599143, "CC(Layout)N(content,modifier,measurePolicy)81@3355L27,84@3521L415:Layout.kt#80mrfh");
            int hashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composer, 0));
            CompositionLocalMap currentCompositionLocalMap = composer.getCurrentCompositionLocalMap();
            Modifier materializeModifier = ComposedModifierKt.materializeModifier(composer, m1051paddingVpY3zN4);
            Function0<ComposeUiNode> constructor = ComposeUiNode.Companion.getConstructor();
            ComposerKt.sourceInformationMarkerStart(composer, -553112988, "CC(ReusableComposeNode)N(factory,update,content)410@16187L9:Composables.kt#9igjgp");
            if (!(composer.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composer.startReusableNode();
            if (composer.getInserting()) {
                composer.createNode(constructor);
            } else {
                composer.useNode();
            }
            Composer m4467constructorimpl = Updater.m4467constructorimpl(composer);
            Updater.m4475setimpl(m4467constructorimpl, maybeCachedBoxMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.m4475setimpl(m4467constructorimpl, currentCompositionLocalMap, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.m4475setimpl(m4467constructorimpl, Integer.valueOf(hashCode), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.m4473reconcileimpl(m4467constructorimpl, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.m4475setimpl(m4467constructorimpl, materializeModifier, ComposeUiNode.Companion.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composer, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composer, -972985017, "C354@13617L10,355@13666L13,351@13507L266:DebugGameTestScriptCard.kt#1gr92h");
            TextKt.m3157TextNvy7gAk(str, null, Color.Companion.m5385getWhite0d7_KjU(), null, TypeKt.m9869dpToSp8Feqmps(Dp.m8160constructorimpl(14.0f), composer, 6), null, null, null, 0L, null, null, 0L, TextOverflow.Companion.m8096getEllipsisgIe3tQ8(), false, 1, 0, null, MaterialTheme.INSTANCE.getTypography(composer, 6).getBodySmall(), composer, RendererCapabilities.DECODER_SUPPORT_MASK, 24960, 110570);
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            composer.endNode();
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }
}
