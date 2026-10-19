package com.miami.game.feature.settings.ui.compose;

import android.content.Context;
import android.content.SharedPreferences;
import android.net.Uri;
import androidx.activity.compose.ActivityResultRegistryKt;
import androidx.activity.compose.ManagedActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.material3.MaterialTheme;
import androidx.compose.material3.TextKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.DisposableEffectResult;
import androidx.compose.runtime.DisposableEffectScope;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.saveable.RememberSaveableKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.graphics.Shadow;
import androidx.compose.ui.graphics.drawscope.DrawStyle;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.PlatformSpanStyle;
import androidx.compose.ui.text.SpanStyle;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontSynthesis;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.intl.LocaleList;
import androidx.compose.ui.text.style.BaselineShift;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.text.style.TextGeometricTransform;
import androidx.compose.ui.text.style.TextOverflow;
import androidx.compose.ui.unit.Dp;
import androidx.media3.exoplayer.RendererCapabilities;
import androidx.media3.extractor.WavUtil;
import com.miami.game.core.settings.R;
import com.miami.game.core.settings.mods.ModsPreferences;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
/* compiled from: ModsSettings.kt */
@Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\u001aP\u0010\u0000\u001a\u00020\u00012\u0012\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00010\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\u0011\u0010\u0007\u001a\r\u0012\u0004\u0012\u00020\u00010\b¢\u0006\u0002\b\tH\u0001b\u0002\b\tb\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\r¢\u0006\u0002\u0010\n¨\u0006\u000e²\u0006\n\u0010\u000f\u001a\u00020\u0006X\u008a\u008e\u0002²\u0006\n\u0010\u0010\u001a\u00020\u0006X\u008a\u008e\u0002²\u0006\f\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u008a\u008e\u0002²\u0006\f\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u008a\u008e\u0002²\u0006\n\u0010\u0015\u001a\u00020\u0006X\u008a\u008e\u0002"}, d2 = {"ModsSettings", "", "onShowModsInstructions", "Lkotlin/Function1;", "Lcom/miami/game/feature/settings/ui/compose/ModsInstructionsActions;", "debugModeAvailable", "", "adjacentSetting", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "(Lkotlin/jvm/functions/Function1;ZLkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "Landroidx/compose/runtime/ComposableInferredTarget;", "scheme", "[androidx.compose.ui.UiComposable[androidx.compose.ui.UiComposable]]", "settings", "busy", "enabled", "source", "", "pickerInitialUri", "Landroid/net/Uri;", "pickerCancelled"}, k = 2, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class ModsSettingsKt {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit ModsSettings$lambda$22(Function1 function1, boolean z, Function2 function2, int i, int i2, Composer composer, int i3) {
        ModsSettings(function1, z, function2, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code restructure failed: missing block: B:40:0x0089, code lost:
        if ((r54 & 2) != 0) goto L148;
     */
    /* JADX WARN: Removed duplicated region for block: B:103:0x0335  */
    /* JADX WARN: Removed duplicated region for block: B:106:0x0341  */
    /* JADX WARN: Removed duplicated region for block: B:107:0x0345  */
    /* JADX WARN: Removed duplicated region for block: B:110:0x03e3  */
    /* JADX WARN: Removed duplicated region for block: B:113:0x03ef  */
    /* JADX WARN: Removed duplicated region for block: B:114:0x03f3  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x0461  */
    /* JADX WARN: Removed duplicated region for block: B:118:0x0463  */
    /* JADX WARN: Removed duplicated region for block: B:136:0x04d6  */
    /* JADX WARN: Removed duplicated region for block: B:151:0x05c4  */
    /* JADX WARN: Removed duplicated region for block: B:154:0x05e6  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void ModsSettings(final Function1<? super ModsInstructionsActions, Unit> onShowModsInstructions, boolean z, Function2<? super Composer, ? super Integer, Unit> function2, Composer composer, final int i, final int i2) {
        int i3;
        boolean z2;
        Composer composer2;
        final boolean z3;
        ManagedActivityResultLauncher managedActivityResultLauncher;
        boolean z4;
        boolean changedInstance;
        Context context;
        MutableState mutableState;
        String str;
        MutableState mutableState2;
        SharedPreferences sharedPreferences;
        int i4;
        int i5;
        MutableState mutableState3;
        final ManagedActivityResultLauncher managedActivityResultLauncher2;
        ModsSettingsKt$ModsSettings$2$1 modsSettingsKt$ModsSettings$2$1;
        boolean changedInstance2;
        Object rememberedValue;
        final MutableState mutableState4;
        String str2;
        int i6;
        int i7;
        Function2<? super Composer, ? super Integer, Unit> adjacentSetting = function2;
        Intrinsics.checkNotNullParameter(onShowModsInstructions, "onShowModsInstructions");
        Intrinsics.checkNotNullParameter(adjacentSetting, "adjacentSetting");
        Composer startRestartGroup = composer.startRestartGroup(-2123859257);
        ComposerKt.sourceInformation(startRestartGroup, "C(ModsSettings)N(onShowModsInstructions,debugModeAvailable,adjacentSetting)40@1622L7,41@1646L24,42@1687L34,55@2178L43,56@2241L77,57@2337L74,58@2440L377,58@2416L401,66@2863L30,66@2846L47,67@2938L25,67@2921L42,68@3059L255,68@2981L333,97@4004L131,97@3972L163,103@4140L1511:ModsSettings.kt#1gr92h");
        if ((i & 6) == 0) {
            i3 = (startRestartGroup.changedInstance(onShowModsInstructions) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        if ((i & 48) == 0) {
            if ((i2 & 2) == 0) {
                z2 = z;
                if (startRestartGroup.changed(z2)) {
                    i7 = 32;
                    i3 |= i7;
                }
            } else {
                z2 = z;
            }
            i7 = 16;
            i3 |= i7;
        } else {
            z2 = z;
        }
        if ((i & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
            i3 |= startRestartGroup.changedInstance(adjacentSetting) ? 256 : 128;
        }
        if (startRestartGroup.shouldExecute((i3 & 147) != 146, i3 & 1)) {
            startRestartGroup.startDefaults();
            ComposerKt.sourceInformation(startRestartGroup, "37@1532L7");
            if ((i & 1) == 0 || startRestartGroup.getDefaultsInvalid()) {
                if ((i2 & 2) != 0) {
                    ModsPreferences modsPreferences = ModsPreferences.INSTANCE;
                    ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                    Object consume = startRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalContext());
                    ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                    z2 = modsPreferences.hotReloadCapable((Context) consume);
                    i3 &= -113;
                }
                final boolean z5 = z2;
                startRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-2123859257, i3, -1, "com.miami.game.feature.settings.ui.compose.ModsSettings (ModsSettings.kt:39)");
                }
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                Object consume2 = startRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalContext());
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                final Context context2 = (Context) consume2;
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, 773894976, "CC(rememberCoroutineScope)N(getContext)616@28039L68:Effects.kt#9igjgp");
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, 683736516, "CC(remember):Effects.kt#9igjgp");
                Object rememberedValue2 = startRestartGroup.rememberedValue();
                if (rememberedValue2 == Composer.Companion.getEmpty()) {
                    rememberedValue2 = EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, startRestartGroup);
                    startRestartGroup.updateRememberedValue(rememberedValue2);
                }
                final CoroutineScope coroutineScope = (CoroutineScope) rememberedValue2;
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, -919270231, "CC(remember):ModsSettings.kt#9igjgp");
                Object rememberedValue3 = startRestartGroup.rememberedValue();
                if (rememberedValue3 == Composer.Companion.getEmpty()) {
                    rememberedValue3 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, null, 2, null);
                    startRestartGroup.updateRememberedValue(rememberedValue3);
                }
                final MutableState mutableState5 = (MutableState) rememberedValue3;
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, -919254510, "CC(remember):ModsSettings.kt#9igjgp");
                Object rememberedValue4 = startRestartGroup.rememberedValue();
                if (rememberedValue4 == Composer.Companion.getEmpty()) {
                    rememberedValue4 = ModsPreferences.INSTANCE.prefs(context2);
                    startRestartGroup.updateRememberedValue(rememberedValue4);
                }
                final SharedPreferences sharedPreferences2 = (SharedPreferences) rememberedValue4;
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, -919252460, "CC(remember):ModsSettings.kt#9igjgp");
                Object rememberedValue5 = startRestartGroup.rememberedValue();
                if (rememberedValue5 == Composer.Companion.getEmpty()) {
                    rememberedValue5 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.valueOf(sharedPreferences2.getBoolean(ModsPreferences.ENABLED, false)), null, 2, null);
                    startRestartGroup.updateRememberedValue(rememberedValue5);
                }
                final MutableState mutableState6 = (MutableState) rememberedValue5;
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, -919249391, "CC(remember):ModsSettings.kt#9igjgp");
                Object rememberedValue6 = startRestartGroup.rememberedValue();
                if (rememberedValue6 == Composer.Companion.getEmpty()) {
                    rememberedValue6 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(sharedPreferences2.getString(ModsPreferences.SOURCE, null), null, 2, null);
                    startRestartGroup.updateRememberedValue(rememberedValue6);
                }
                final MutableState mutableState7 = (MutableState) rememberedValue6;
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, -919245792, "CC(remember):ModsSettings.kt#9igjgp");
                boolean changedInstance3 = startRestartGroup.changedInstance(sharedPreferences2);
                Object rememberedValue7 = startRestartGroup.rememberedValue();
                if (changedInstance3 || rememberedValue7 == Composer.Companion.getEmpty()) {
                    rememberedValue7 = new Function1() { // from class: com.miami.game.feature.settings.ui.compose.ModsSettingsKt$$ExternalSyntheticLambda3
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            DisposableEffectResult ModsSettings$lambda$10$0;
                            ModsSettings$lambda$10$0 = ModsSettingsKt.ModsSettings$lambda$10$0(sharedPreferences2, mutableState6, mutableState7, (DisposableEffectScope) obj);
                            return ModsSettings$lambda$10$0;
                        }
                    };
                    startRestartGroup.updateRememberedValue(rememberedValue7);
                }
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                EffectsKt.DisposableEffect(sharedPreferences2, (Function1) rememberedValue7, startRestartGroup, 0);
                Object[] objArr = new Object[0];
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, -919232603, "CC(remember):ModsSettings.kt#9igjgp");
                Object rememberedValue8 = startRestartGroup.rememberedValue();
                if (rememberedValue8 == Composer.Companion.getEmpty()) {
                    rememberedValue8 = new Function0() { // from class: com.miami.game.feature.settings.ui.compose.ModsSettingsKt$$ExternalSyntheticLambda4
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            MutableState ModsSettings$lambda$11$0;
                            ModsSettings$lambda$11$0 = ModsSettingsKt.ModsSettings$lambda$11$0();
                            return ModsSettings$lambda$11$0;
                        }
                    };
                    startRestartGroup.updateRememberedValue(rememberedValue8);
                }
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                final MutableState mutableState8 = (MutableState) RememberSaveableKt.rememberSaveable(objArr, (Function0) rememberedValue8, startRestartGroup, 48);
                Object[] objArr2 = new Object[0];
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, -919230208, "CC(remember):ModsSettings.kt#9igjgp");
                Object rememberedValue9 = startRestartGroup.rememberedValue();
                if (rememberedValue9 == Composer.Companion.getEmpty()) {
                    rememberedValue9 = new Function0() { // from class: com.miami.game.feature.settings.ui.compose.ModsSettingsKt$$ExternalSyntheticLambda5
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            MutableState ModsSettings$lambda$14$0;
                            ModsSettings$lambda$14$0 = ModsSettingsKt.ModsSettings$lambda$14$0();
                            return ModsSettings$lambda$14$0;
                        }
                    };
                    startRestartGroup.updateRememberedValue(rememberedValue9);
                }
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                final MutableState mutableState9 = (MutableState) RememberSaveableKt.rememberSaveable(objArr2, (Function0) rememberedValue9, startRestartGroup, 48);
                ActivityResultContracts.OpenDocumentTree openDocumentTree = new ActivityResultContracts.OpenDocumentTree();
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, -919226106, "CC(remember):ModsSettings.kt#9igjgp");
                boolean changedInstance4 = startRestartGroup.changedInstance(coroutineScope) | startRestartGroup.changedInstance(context2) | startRestartGroup.changed(mutableState9);
                int i8 = i3;
                Object rememberedValue10 = startRestartGroup.rememberedValue();
                if (changedInstance4 || rememberedValue10 == Composer.Companion.getEmpty()) {
                    rememberedValue10 = new Function1() { // from class: com.miami.game.feature.settings.ui.compose.ModsSettingsKt$$ExternalSyntheticLambda6
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            Unit ModsSettings$lambda$17$0;
                            ModsSettings$lambda$17$0 = ModsSettingsKt.ModsSettings$lambda$17$0(context2, coroutineScope, mutableState5, mutableState9, (Uri) obj);
                            return ModsSettings$lambda$17$0;
                        }
                    };
                    startRestartGroup.updateRememberedValue(rememberedValue10);
                }
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                ManagedActivityResultLauncher rememberLauncherForActivityResult = ActivityResultRegistryKt.rememberLauncherForActivityResult(openDocumentTree, (Function1) rememberedValue10, startRestartGroup, 0);
                Boolean valueOf = Boolean.valueOf(ModsSettings$lambda$15(mutableState9));
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, -919195990, "CC(remember):ModsSettings.kt#9igjgp");
                int i9 = i8 & 14;
                boolean changed = (i9 == 4) | startRestartGroup.changed(mutableState9) | startRestartGroup.changed(mutableState8) | startRestartGroup.changedInstance(rememberLauncherForActivityResult);
                int i10 = (i8 & 112) ^ 48;
                if (i10 <= 32 || !startRestartGroup.changed(z5)) {
                    managedActivityResultLauncher = rememberLauncherForActivityResult;
                    if ((i8 & 48) != 32) {
                        z4 = false;
                        changedInstance = changed | z4 | startRestartGroup.changedInstance(coroutineScope) | startRestartGroup.changedInstance(context2);
                        Object rememberedValue11 = startRestartGroup.rememberedValue();
                        if (!changedInstance || rememberedValue11 == Composer.Companion.getEmpty()) {
                            context = context2;
                            mutableState = mutableState7;
                            str = "CC(remember):ModsSettings.kt#9igjgp";
                            mutableState2 = mutableState6;
                            sharedPreferences = sharedPreferences2;
                            ManagedActivityResultLauncher managedActivityResultLauncher3 = managedActivityResultLauncher;
                            i4 = i10;
                            i5 = 0;
                            ModsSettingsKt$ModsSettings$2$1 modsSettingsKt$ModsSettings$2$12 = new ModsSettingsKt$ModsSettings$2$1(mutableState9, mutableState8, onShowModsInstructions, z5, managedActivityResultLauncher3, context, coroutineScope, mutableState5, null);
                            mutableState8 = mutableState8;
                            mutableState3 = mutableState5;
                            managedActivityResultLauncher2 = managedActivityResultLauncher3;
                            coroutineScope = coroutineScope;
                            modsSettingsKt$ModsSettings$2$1 = modsSettingsKt$ModsSettings$2$12;
                            startRestartGroup.updateRememberedValue(modsSettingsKt$ModsSettings$2$1);
                        } else {
                            mutableState = mutableState7;
                            str = "CC(remember):ModsSettings.kt#9igjgp";
                            mutableState2 = mutableState6;
                            i4 = i10;
                            managedActivityResultLauncher2 = managedActivityResultLauncher;
                            i5 = 0;
                            sharedPreferences = sharedPreferences2;
                            context = context2;
                            modsSettingsKt$ModsSettings$2$1 = rememberedValue11;
                            mutableState3 = mutableState5;
                        }
                        ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                        EffectsKt.LaunchedEffect(valueOf, modsSettingsKt$ModsSettings$2$1, startRestartGroup, i5);
                        ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
                        MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.Companion.getStart(), startRestartGroup, i5);
                        ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1159599143, "CC(Layout)N(content,modifier,measurePolicy)81@3355L27,84@3521L415:Layout.kt#80mrfh");
                        int hashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(startRestartGroup, i5));
                        CompositionLocalMap currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
                        Modifier materializeModifier = ComposedModifierKt.materializeModifier(startRestartGroup, Modifier.Companion);
                        Function0<ComposeUiNode> constructor = ComposeUiNode.Companion.getConstructor();
                        final MutableState mutableState10 = mutableState3;
                        ComposerKt.sourceInformationMarkerStart(startRestartGroup, -553112988, "CC(ReusableComposeNode)N(factory,update,content)410@16187L9:Composables.kt#9igjgp");
                        if (!(startRestartGroup.getApplier() instanceof Applier)) {
                            ComposablesKt.invalidApplier();
                        }
                        startRestartGroup.startReusableNode();
                        if (!startRestartGroup.getInserting()) {
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
                        ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1758483946, "C104@4157L675:ModsSettings.kt#1gr92h");
                        ComposerKt.sourceInformationMarkerStart(startRestartGroup, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
                        MeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.m742spacedBy0680j_4(Dp.m8160constructorimpl(12.0f)), Alignment.Companion.getTop(), startRestartGroup, 6);
                        ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1159599143, "CC(Layout)N(content,modifier,measurePolicy)81@3355L27,84@3521L415:Layout.kt#80mrfh");
                        int hashCode2 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(startRestartGroup, 0));
                        CompositionLocalMap currentCompositionLocalMap2 = startRestartGroup.getCurrentCompositionLocalMap();
                        Modifier materializeModifier2 = ComposedModifierKt.materializeModifier(startRestartGroup, Modifier.Companion);
                        Function0<ComposeUiNode> constructor2 = ComposeUiNode.Companion.getConstructor();
                        ComposerKt.sourceInformationMarkerStart(startRestartGroup, -553112988, "CC(ReusableComposeNode)N(factory,update,content)410@16187L9:Composables.kt#9igjgp");
                        if (!(startRestartGroup.getApplier() instanceof Applier)) {
                            ComposablesKt.invalidApplier();
                        }
                        startRestartGroup.startReusableNode();
                        if (!startRestartGroup.getInserting()) {
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
                        ComposerKt.sourceInformationMarkerStart(startRestartGroup, -960073872, "C106@4258L41,108@4362L415,105@4228L564,119@4805L17:ModsSettings.kt#1gr92h");
                        String stringResource = StringResources_androidKt.stringResource(R.string.mods_enabled, startRestartGroup, 0);
                        boolean ModsSettings$lambda$5 = ModsSettings$lambda$5(mutableState2);
                        ComposerKt.sourceInformationMarkerStart(startRestartGroup, -30966016, str);
                        changedInstance2 = startRestartGroup.changedInstance(coroutineScope) | startRestartGroup.changedInstance(context) | startRestartGroup.changedInstance(sharedPreferences) | (i9 != 4) | startRestartGroup.changed(mutableState8) | startRestartGroup.changedInstance(managedActivityResultLauncher2) | ((i4 <= 32 && startRestartGroup.changed(z5)) || (i8 & 48) == 32);
                        rememberedValue = startRestartGroup.rememberedValue();
                        if (!changedInstance2 || rememberedValue == Composer.Companion.getEmpty()) {
                            final Context context3 = context;
                            final SharedPreferences sharedPreferences3 = sharedPreferences;
                            mutableState4 = mutableState2;
                            Function0 function0 = new Function0() { // from class: com.miami.game.feature.settings.ui.compose.ModsSettingsKt$$ExternalSyntheticLambda7
                                @Override // kotlin.jvm.functions.Function0
                                public final Object invoke() {
                                    Unit ModsSettings$lambda$21$0$0$0;
                                    ModsSettings$lambda$21$0$0$0 = ModsSettingsKt.ModsSettings$lambda$21$0$0$0(sharedPreferences3, mutableState10, mutableState4, context3, coroutineScope, onShowModsInstructions, z5, managedActivityResultLauncher2, mutableState8);
                                    return ModsSettings$lambda$21$0$0$0;
                                }
                            };
                            z5 = z5;
                            startRestartGroup.updateRememberedValue(function0);
                            rememberedValue = function0;
                        } else {
                            mutableState4 = mutableState2;
                        }
                        ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                        SwitchButtonKt.SwitchButton(stringResource, (Function0) rememberedValue, ModsSettings$lambda$5, startRestartGroup, 0);
                        adjacentSetting = function2;
                        adjacentSetting.invoke(startRestartGroup, Integer.valueOf((i8 >> 6) & 14));
                        ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                        ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                        startRestartGroup.endNode();
                        ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                        ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                        ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                        if (!ModsSettings$lambda$5(mutableState4)) {
                            startRestartGroup.startReplaceGroup(-1757814130);
                            ComposerKt.sourceInformation(startRestartGroup, "124@5030L47,135@5520L10,132@5397L238");
                            String ModsSettings$lambda$8 = ModsSettings$lambda$8(mutableState);
                            if (ModsSettings$lambda$8 != null) {
                                str2 = Uri.parse(ModsSettings$lambda$8).getLastPathSegment();
                                if (str2 == null) {
                                    str2 = "";
                                }
                            } else {
                                str2 = null;
                            }
                            if (str2 != null) {
                                i6 = 0;
                                startRestartGroup.startReplaceGroup(1744411830);
                            } else {
                                startRestartGroup.startReplaceGroup(1744414155);
                                ComposerKt.sourceInformation(startRestartGroup, "123@4956L46");
                                i6 = 0;
                                str2 = StringResources_androidKt.stringResource(R.string.mods_source_local, startRestartGroup, 0);
                            }
                            startRestartGroup.endReplaceGroup();
                            String stringResource2 = StringResources_androidKt.stringResource(R.string.mods_source_import, startRestartGroup, i6);
                            AnnotatedString.Builder builder = new AnnotatedString.Builder(i6, 1, null);
                            builder.append(StringsKt.substringBefore$default(stringResource2, "%1$s", (String) null, 2, (Object) null));
                            int pushStyle = builder.pushStyle(new SpanStyle(ColorKt.Color(4294937216L), 0L, (FontWeight) null, (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (PlatformSpanStyle) null, (DrawStyle) null, (int) WavUtil.TYPE_WAVE_FORMAT_EXTENSIBLE, (DefaultConstructorMarker) null));
                            try {
                                builder.append(str2);
                                Unit unit = Unit.INSTANCE;
                                builder.pop(pushStyle);
                                builder.append(StringsKt.substringAfter$default(stringResource2, "%1$s", (String) null, 2, (Object) null));
                                TextKt.m3158TextZ58ophY(builder.toAnnotatedString(), null, Color.Companion.m5385getWhite0d7_KjU(), null, 0L, null, null, null, 0L, null, null, 0L, TextOverflow.Companion.m8096getEllipsisgIe3tQ8(), false, 1, 0, null, null, MaterialTheme.INSTANCE.getTypography(startRestartGroup, 6).getBodySmall(), startRestartGroup, RendererCapabilities.DECODER_SUPPORT_MASK, 24960, 241658);
                                composer2 = startRestartGroup;
                                composer2.endReplaceGroup();
                            } catch (Throwable th) {
                                builder.pop(pushStyle);
                                throw th;
                            }
                        } else {
                            composer2 = startRestartGroup;
                            composer2.startReplaceGroup(-1757053979);
                            composer2.endReplaceGroup();
                        }
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        composer2.endNode();
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        z3 = z5;
                    }
                } else {
                    managedActivityResultLauncher = rememberLauncherForActivityResult;
                }
                z4 = true;
                changedInstance = changed | z4 | startRestartGroup.changedInstance(coroutineScope) | startRestartGroup.changedInstance(context2);
                Object rememberedValue112 = startRestartGroup.rememberedValue();
                if (!changedInstance) {
                }
                context = context2;
                mutableState = mutableState7;
                str = "CC(remember):ModsSettings.kt#9igjgp";
                mutableState2 = mutableState6;
                sharedPreferences = sharedPreferences2;
                ManagedActivityResultLauncher managedActivityResultLauncher32 = managedActivityResultLauncher;
                i4 = i10;
                i5 = 0;
                ModsSettingsKt$ModsSettings$2$1 modsSettingsKt$ModsSettings$2$122 = new ModsSettingsKt$ModsSettings$2$1(mutableState9, mutableState8, onShowModsInstructions, z5, managedActivityResultLauncher32, context, coroutineScope, mutableState5, null);
                mutableState8 = mutableState8;
                mutableState3 = mutableState5;
                managedActivityResultLauncher2 = managedActivityResultLauncher32;
                coroutineScope = coroutineScope;
                modsSettingsKt$ModsSettings$2$1 = modsSettingsKt$ModsSettings$2$122;
                startRestartGroup.updateRememberedValue(modsSettingsKt$ModsSettings$2$1);
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                EffectsKt.LaunchedEffect(valueOf, modsSettingsKt$ModsSettings$2$1, startRestartGroup, i5);
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
                MeasurePolicy columnMeasurePolicy2 = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.Companion.getStart(), startRestartGroup, i5);
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1159599143, "CC(Layout)N(content,modifier,measurePolicy)81@3355L27,84@3521L415:Layout.kt#80mrfh");
                int hashCode3 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(startRestartGroup, i5));
                CompositionLocalMap currentCompositionLocalMap3 = startRestartGroup.getCurrentCompositionLocalMap();
                Modifier materializeModifier3 = ComposedModifierKt.materializeModifier(startRestartGroup, Modifier.Companion);
                Function0<ComposeUiNode> constructor3 = ComposeUiNode.Companion.getConstructor();
                final MutableState mutableState102 = mutableState3;
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, -553112988, "CC(ReusableComposeNode)N(factory,update,content)410@16187L9:Composables.kt#9igjgp");
                if (!(startRestartGroup.getApplier() instanceof Applier)) {
                }
                startRestartGroup.startReusableNode();
                if (!startRestartGroup.getInserting()) {
                }
                Composer m4467constructorimpl3 = Updater.m4467constructorimpl(startRestartGroup);
                Updater.m4475setimpl(m4467constructorimpl3, columnMeasurePolicy2, ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.m4475setimpl(m4467constructorimpl3, currentCompositionLocalMap3, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                Updater.m4475setimpl(m4467constructorimpl3, Integer.valueOf(hashCode3), ComposeUiNode.Companion.getSetCompositeKeyHash());
                Updater.m4473reconcileimpl(m4467constructorimpl3, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
                Updater.m4475setimpl(m4467constructorimpl3, materializeModifier3, ComposeUiNode.Companion.getSetModifier());
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
                ColumnScopeInstance columnScopeInstance2 = ColumnScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1758483946, "C104@4157L675:ModsSettings.kt#1gr92h");
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
                MeasurePolicy rowMeasurePolicy2 = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.m742spacedBy0680j_4(Dp.m8160constructorimpl(12.0f)), Alignment.Companion.getTop(), startRestartGroup, 6);
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1159599143, "CC(Layout)N(content,modifier,measurePolicy)81@3355L27,84@3521L415:Layout.kt#80mrfh");
                int hashCode22 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(startRestartGroup, 0));
                CompositionLocalMap currentCompositionLocalMap22 = startRestartGroup.getCurrentCompositionLocalMap();
                Modifier materializeModifier22 = ComposedModifierKt.materializeModifier(startRestartGroup, Modifier.Companion);
                Function0<ComposeUiNode> constructor22 = ComposeUiNode.Companion.getConstructor();
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, -553112988, "CC(ReusableComposeNode)N(factory,update,content)410@16187L9:Composables.kt#9igjgp");
                if (!(startRestartGroup.getApplier() instanceof Applier)) {
                }
                startRestartGroup.startReusableNode();
                if (!startRestartGroup.getInserting()) {
                }
                Composer m4467constructorimpl22 = Updater.m4467constructorimpl(startRestartGroup);
                Updater.m4475setimpl(m4467constructorimpl22, rowMeasurePolicy2, ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.m4475setimpl(m4467constructorimpl22, currentCompositionLocalMap22, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                Updater.m4475setimpl(m4467constructorimpl22, Integer.valueOf(hashCode22), ComposeUiNode.Companion.getSetCompositeKeyHash());
                Updater.m4473reconcileimpl(m4467constructorimpl22, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
                Updater.m4475setimpl(m4467constructorimpl22, materializeModifier22, ComposeUiNode.Companion.getSetModifier());
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
                RowScopeInstance rowScopeInstance2 = RowScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, -960073872, "C106@4258L41,108@4362L415,105@4228L564,119@4805L17:ModsSettings.kt#1gr92h");
                String stringResource3 = StringResources_androidKt.stringResource(R.string.mods_enabled, startRestartGroup, 0);
                boolean ModsSettings$lambda$52 = ModsSettings$lambda$5(mutableState2);
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, -30966016, str);
                changedInstance2 = startRestartGroup.changedInstance(coroutineScope) | startRestartGroup.changedInstance(context) | startRestartGroup.changedInstance(sharedPreferences) | (i9 != 4) | startRestartGroup.changed(mutableState8) | startRestartGroup.changedInstance(managedActivityResultLauncher2) | ((i4 <= 32 && startRestartGroup.changed(z5)) || (i8 & 48) == 32);
                rememberedValue = startRestartGroup.rememberedValue();
                if (changedInstance2) {
                }
                final Context context32 = context;
                final SharedPreferences sharedPreferences32 = sharedPreferences;
                mutableState4 = mutableState2;
                Function0 function02 = new Function0() { // from class: com.miami.game.feature.settings.ui.compose.ModsSettingsKt$$ExternalSyntheticLambda7
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        Unit ModsSettings$lambda$21$0$0$0;
                        ModsSettings$lambda$21$0$0$0 = ModsSettingsKt.ModsSettings$lambda$21$0$0$0(sharedPreferences32, mutableState102, mutableState4, context32, coroutineScope, onShowModsInstructions, z5, managedActivityResultLauncher2, mutableState8);
                        return ModsSettings$lambda$21$0$0$0;
                    }
                };
                z5 = z5;
                startRestartGroup.updateRememberedValue(function02);
                rememberedValue = function02;
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                SwitchButtonKt.SwitchButton(stringResource3, (Function0) rememberedValue, ModsSettings$lambda$52, startRestartGroup, 0);
                adjacentSetting = function2;
                adjacentSetting.invoke(startRestartGroup, Integer.valueOf((i8 >> 6) & 14));
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                startRestartGroup.endNode();
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                if (!ModsSettings$lambda$5(mutableState4)) {
                }
                ComposerKt.sourceInformationMarkerEnd(composer2);
                ComposerKt.sourceInformationMarkerEnd(composer2);
                composer2.endNode();
                ComposerKt.sourceInformationMarkerEnd(composer2);
                ComposerKt.sourceInformationMarkerEnd(composer2);
                ComposerKt.sourceInformationMarkerEnd(composer2);
                if (ComposerKt.isTraceInProgress()) {
                }
                z3 = z5;
            } else {
                startRestartGroup.skipToGroupEnd();
            }
        } else {
            composer2 = startRestartGroup;
            composer2.skipToGroupEnd();
            z3 = z2;
        }
        ScopeUpdateScope endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
            final Function2<? super Composer, ? super Integer, Unit> function22 = adjacentSetting;
            endRestartGroup.updateScope(new Function2() { // from class: com.miami.game.feature.settings.ui.compose.ModsSettingsKt$$ExternalSyntheticLambda8
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return ModsSettingsKt.ModsSettings$lambda$22(Function1.this, z3, function22, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    private static final boolean ModsSettings$lambda$1(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ModsSettings$lambda$2(MutableState<Boolean> mutableState, boolean z) {
        mutableState.setValue(Boolean.valueOf(z));
    }

    private static final void ModsSettings$change(CoroutineScope coroutineScope, MutableState<Boolean> mutableState, Context context, Function0<Unit> function0) {
        if (ModsSettings$lambda$1(mutableState)) {
            return;
        }
        ModsSettings$lambda$2(mutableState, true);
        BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, null, new ModsSettingsKt$ModsSettings$change$1(context, function0, mutableState, null), 3, null);
    }

    private static final boolean ModsSettings$lambda$5(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    private static final void ModsSettings$lambda$6(MutableState<Boolean> mutableState, boolean z) {
        mutableState.setValue(Boolean.valueOf(z));
    }

    private static final String ModsSettings$lambda$8(MutableState<String> mutableState) {
        return mutableState.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final DisposableEffectResult ModsSettings$lambda$10$0(final SharedPreferences sharedPreferences, final MutableState mutableState, final MutableState mutableState2, DisposableEffectScope DisposableEffect) {
        Intrinsics.checkNotNullParameter(DisposableEffect, "$this$DisposableEffect");
        final SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener = new SharedPreferences.OnSharedPreferenceChangeListener() { // from class: com.miami.game.feature.settings.ui.compose.ModsSettingsKt$$ExternalSyntheticLambda9
            @Override // android.content.SharedPreferences.OnSharedPreferenceChangeListener
            public final void onSharedPreferenceChanged(SharedPreferences sharedPreferences2, String str) {
                ModsSettingsKt.ModsSettings$lambda$10$0$0(MutableState.this, mutableState2, sharedPreferences2, str);
            }
        };
        sharedPreferences.registerOnSharedPreferenceChangeListener(onSharedPreferenceChangeListener);
        return new DisposableEffectResult() { // from class: com.miami.game.feature.settings.ui.compose.ModsSettingsKt$ModsSettings$lambda$10$0$$inlined$onDispose$1
            @Override // androidx.compose.runtime.DisposableEffectResult
            public void dispose() {
                sharedPreferences.unregisterOnSharedPreferenceChangeListener(onSharedPreferenceChangeListener);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ModsSettings$lambda$10$0$0(MutableState mutableState, MutableState mutableState2, SharedPreferences sharedPreferences, String str) {
        ModsSettings$lambda$6(mutableState, sharedPreferences.getBoolean(ModsPreferences.ENABLED, false));
        mutableState2.setValue(sharedPreferences.getString(ModsPreferences.SOURCE, null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final MutableState ModsSettings$lambda$11$0() {
        MutableState mutableStateOf$default;
        mutableStateOf$default = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
        return mutableStateOf$default;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Uri ModsSettings$lambda$12(MutableState<Uri> mutableState) {
        return mutableState.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final MutableState ModsSettings$lambda$14$0() {
        MutableState mutableStateOf$default;
        mutableStateOf$default = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, null, 2, null);
        return mutableStateOf$default;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean ModsSettings$lambda$15(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ModsSettings$lambda$16(MutableState<Boolean> mutableState, boolean z) {
        mutableState.setValue(Boolean.valueOf(z));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ModsSettings$lambda$17$0(final Context context, CoroutineScope coroutineScope, MutableState mutableState, MutableState mutableState2, final Uri uri) {
        if (uri != null) {
            ModsSettings$change(coroutineScope, mutableState, context, new Function0() { // from class: com.miami.game.feature.settings.ui.compose.ModsSettingsKt$$ExternalSyntheticLambda11
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    Unit ModsSettings$lambda$17$0$0;
                    ModsSettings$lambda$17$0$0 = ModsSettingsKt.ModsSettings$lambda$17$0$0(context, uri);
                    return ModsSettings$lambda$17$0$0;
                }
            });
        } else {
            ModsSettings$lambda$16(mutableState2, true);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ModsSettings$lambda$17$0$0(Context context, Uri uri) {
        ModsPreferences.INSTANCE.selectFolder(context, uri);
        ModsPreferences.INSTANCE.setEnabled(context, true);
        return Unit.INSTANCE;
    }

    private static final void ModsSettings$selectFolder(ManagedActivityResultLauncher<Uri, Uri> managedActivityResultLauncher, MutableState<Uri> mutableState, Uri uri) {
        mutableState.setValue(uri);
        managedActivityResultLauncher.launch(uri);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ModsSettings$showInstructions(Function1<? super ModsInstructionsActions, Unit> function1, boolean z, final ManagedActivityResultLauncher<Uri, Uri> managedActivityResultLauncher, final MutableState<Uri> mutableState, final Context context, final CoroutineScope coroutineScope, final MutableState<Boolean> mutableState2, final Uri uri) {
        function1.invoke(new ModsInstructionsActions(new Function0() { // from class: com.miami.game.feature.settings.ui.compose.ModsSettingsKt$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return ModsSettingsKt.ModsSettings$showInstructions$lambda$18(uri, managedActivityResultLauncher, mutableState);
            }
        }, z ? new Function0() { // from class: com.miami.game.feature.settings.ui.compose.ModsSettingsKt$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return ModsSettingsKt.ModsSettings$showInstructions$lambda$19(context, coroutineScope, mutableState2);
            }
        } : null));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit ModsSettings$showInstructions$lambda$18(Uri uri, ManagedActivityResultLauncher managedActivityResultLauncher, MutableState mutableState) {
        ModsSettings$selectFolder(managedActivityResultLauncher, mutableState, uri);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit ModsSettings$showInstructions$lambda$19(final Context context, CoroutineScope coroutineScope, MutableState mutableState) {
        ModsSettings$change(coroutineScope, mutableState, context, new Function0() { // from class: com.miami.game.feature.settings.ui.compose.ModsSettingsKt$$ExternalSyntheticLambda10
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                Unit ModsSettings$showInstructions$lambda$19$0;
                ModsSettings$showInstructions$lambda$19$0 = ModsSettingsKt.ModsSettings$showInstructions$lambda$19$0(context);
                return ModsSettings$showInstructions$lambda$19$0;
            }
        });
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ModsSettings$showInstructions$lambda$19$0(Context context) {
        ModsPreferences.INSTANCE.selectFolder(context, null);
        ModsPreferences.INSTANCE.setEnabled(context, true);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ModsSettings$lambda$21$0$0$0(SharedPreferences sharedPreferences, MutableState mutableState, MutableState mutableState2, final Context context, CoroutineScope coroutineScope, Function1 function1, boolean z, ManagedActivityResultLauncher managedActivityResultLauncher, MutableState mutableState3) {
        if (!ModsSettings$lambda$1(mutableState)) {
            if (ModsSettings$lambda$5(mutableState2)) {
                ModsSettings$change(coroutineScope, mutableState, context, new Function0() { // from class: com.miami.game.feature.settings.ui.compose.ModsSettingsKt$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        Unit ModsSettings$lambda$21$0$0$0$0;
                        ModsSettings$lambda$21$0$0$0$0 = ModsSettingsKt.ModsSettings$lambda$21$0$0$0$0(context);
                        return ModsSettings$lambda$21$0$0$0$0;
                    }
                });
            } else {
                String string = sharedPreferences.getString(ModsPreferences.SOURCE, null);
                ModsSettings$showInstructions(function1, z, managedActivityResultLauncher, mutableState3, context, coroutineScope, mutableState, string != null ? Uri.parse(string) : null);
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ModsSettings$lambda$21$0$0$0$0(Context context) {
        ModsPreferences.INSTANCE.setEnabled(context, false);
        return Unit.INSTANCE;
    }
}
