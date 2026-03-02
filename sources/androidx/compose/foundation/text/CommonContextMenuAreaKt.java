package androidx.compose.foundation.text;

import androidx.compose.foundation.ComposeFoundationFlags;
import androidx.compose.foundation.contextmenu.ContextMenuAreaKt;
import androidx.compose.foundation.contextmenu.ContextMenuScope;
import androidx.compose.foundation.contextmenu.ContextMenuState;
import androidx.compose.foundation.contextmenu.ContextMenuStateKt;
import androidx.compose.foundation.text.contextmenu.internal.PlatformDefaultTextContextMenuProviders_androidKt;
import androidx.compose.foundation.text.contextmenu.modifier.TextContextMenuGesturesModifierKt;
import androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState;
import androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionStateKt;
import androidx.compose.foundation.text.selection.SelectionManager;
import androidx.compose.foundation.text.selection.SelectionManagerKt;
import androidx.compose.foundation.text.selection.TextFieldSelectionManager;
import androidx.compose.foundation.text.selection.TextFieldSelectionManagerKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.ui.Modifier;
import androidx.media3.exoplayer.RendererCapabilities;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.messaging.Constants;
import com.google.firebase.remoteconfig.RemoteConfigConstants;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
/* compiled from: CommonContextMenuArea.kt */
@Metadata(d1 = {"\u0000J\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a(\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0011\u0010\u0004\u001a\r\u0012\u0004\u0012\u00020\u00010\u0005¢\u0006\u0002\b\u0006H\u0001¢\u0006\u0002\u0010\u0007\u001a0\u0010\u0000\u001a\u00020\u00012\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0011\u0010\u0004\u001a\r\u0012\u0004\u0012\u00020\u00010\u0005¢\u0006\u0002\b\u0006H\u0001¢\u0006\u0002\u0010\f\u001a(\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\r2\u0011\u0010\u0004\u001a\r\u0012\u0004\u0012\u00020\u00010\u0005¢\u0006\u0002\b\u0006H\u0001¢\u0006\u0002\u0010\u000e\u001a5\u0010\u000f\u001a\u00020\u0001*\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\n\u001a\u00020\u000b2\u000e\b\u0004\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00010\u0005H\u0080\b\u001a\u0012\u0010\u0016\u001a\u00020\u0017*\u00020\tH\u0080@¢\u0006\u0002\u0010\u0018\u001a\u0012\u0010\u0016\u001a\u00020\u0017*\u00020\u0003H\u0080@¢\u0006\u0002\u0010\u0019¨\u0006\u001a"}, d2 = {"CommonContextMenuArea", "", "manager", "Landroidx/compose/foundation/text/selection/TextFieldSelectionManager;", FirebaseAnalytics.Param.CONTENT, "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "(Landroidx/compose/foundation/text/selection/TextFieldSelectionManager;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "selectionState", "Landroidx/compose/foundation/text/input/internal/selection/TextFieldSelectionState;", "enabled", "", "(Landroidx/compose/foundation/text/input/internal/selection/TextFieldSelectionState;ZLkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "Landroidx/compose/foundation/text/selection/SelectionManager;", "(Landroidx/compose/foundation/text/selection/SelectionManager;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "TextItem", "Landroidx/compose/foundation/contextmenu/ContextMenuScope;", RemoteConfigConstants.ResponseFieldKey.STATE, "Landroidx/compose/foundation/contextmenu/ContextMenuState;", Constants.ScionAnalytics.PARAM_LABEL, "Landroidx/compose/foundation/text/TextContextMenuItems;", "operation", "getContextMenuItemsAvailability", "Landroidx/compose/foundation/text/MenuItemsAvailability;", "(Landroidx/compose/foundation/text/input/internal/selection/TextFieldSelectionState;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "(Landroidx/compose/foundation/text/selection/TextFieldSelectionManager;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "foundation"}, k = 2, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public final class CommonContextMenuAreaKt {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit CommonContextMenuArea$lambda$11(TextFieldSelectionState textFieldSelectionState, boolean z, Function2 function2, int i, Composer composer, int i2) {
        CommonContextMenuArea(textFieldSelectionState, z, function2, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit CommonContextMenuArea$lambda$14(SelectionManager selectionManager, Function2 function2, int i, Composer composer, int i2) {
        CommonContextMenuArea(selectionManager, function2, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit CommonContextMenuArea$lambda$4(TextFieldSelectionManager textFieldSelectionManager, Function2 function2, int i, Composer composer, int i2) {
        CommonContextMenuArea(textFieldSelectionManager, function2, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r7v6 */
    public static final void CommonContextMenuArea(final TextFieldSelectionManager textFieldSelectionManager, Function2<? super Composer, ? super Integer, Unit> function2, Composer composer, final int i) {
        int i2;
        final Function2<? super Composer, ? super Integer, Unit> function22;
        Composer startRestartGroup = composer.startRestartGroup(1533506138);
        ComposerKt.sourceInformation(startRestartGroup, "C(CommonContextMenuArea)N(manager,content):CommonContextMenuArea.kt#423gt5");
        if ((i & 6) == 0) {
            i2 = (startRestartGroup.changedInstance(textFieldSelectionManager) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= startRestartGroup.changedInstance(function2) ? 32 : 16;
        }
        if (!startRestartGroup.shouldExecute((i2 & 19) != 18, i2 & 1)) {
            function22 = function2;
            startRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1533506138, i2, -1, "androidx.compose.foundation.text.CommonContextMenuArea (CommonContextMenuArea.kt:46)");
            }
            if (ComposeFoundationFlags.isNewContextMenuEnabled) {
                startRestartGroup.startReplaceGroup(-885604480);
                ComposerKt.sourceInformation(startRestartGroup, "48@2238L88");
                PlatformDefaultTextContextMenuProviders_androidKt.ProvideDefaultPlatformTextContextMenuProviders(textFieldSelectionManager.getContextMenuAreaModifier(), function2, startRestartGroup, i2 & 112, 0);
                startRestartGroup.endReplaceGroup();
                function22 = function2;
            } else {
                startRestartGroup.startReplaceGroup(-885475365);
                ComposerKt.sourceInformation(startRestartGroup, "50@2360L31,51@2421L24,52@2482L55,56@2655L17,59@2837L202,54@2587L494");
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, 525625593, "CC(remember):CommonContextMenuArea.kt#9igjgp");
                Object rememberedValue = startRestartGroup.rememberedValue();
                if (rememberedValue == Composer.Companion.getEmpty()) {
                    rememberedValue = new ContextMenuState(null, 1, null);
                    startRestartGroup.updateRememberedValue(rememberedValue);
                }
                final ContextMenuState contextMenuState = (ContextMenuState) rememberedValue;
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, 773894976, "CC(rememberCoroutineScope)N(getContext)600@27430L68:Effects.kt#9igjgp");
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, 683736516, "CC(remember):Effects.kt#9igjgp");
                Object rememberedValue2 = startRestartGroup.rememberedValue();
                if (rememberedValue2 == Composer.Companion.getEmpty()) {
                    rememberedValue2 = EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, startRestartGroup);
                    startRestartGroup.updateRememberedValue(rememberedValue2);
                }
                final CoroutineScope coroutineScope = (CoroutineScope) rememberedValue2;
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, 525629521, "CC(remember):CommonContextMenuArea.kt#9igjgp");
                Object rememberedValue3 = startRestartGroup.rememberedValue();
                if (rememberedValue3 == Composer.Companion.getEmpty()) {
                    rememberedValue3 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(MenuItemsAvailability.m1227boximpl(MenuItemsAvailability.Companion.m1240getNoneJKCFgKw()), null, 2, null);
                    startRestartGroup.updateRememberedValue(rememberedValue3);
                }
                final MutableState mutableState = (MutableState) rememberedValue3;
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, 525635019, "CC(remember):CommonContextMenuArea.kt#9igjgp");
                Object rememberedValue4 = startRestartGroup.rememberedValue();
                if (rememberedValue4 == Composer.Companion.getEmpty()) {
                    rememberedValue4 = new Function0() { // from class: androidx.compose.foundation.text.CommonContextMenuAreaKt$$ExternalSyntheticLambda0
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            Unit CommonContextMenuArea$lambda$2$0;
                            CommonContextMenuArea$lambda$2$0 = CommonContextMenuAreaKt.CommonContextMenuArea$lambda$2$0(ContextMenuState.this);
                            return CommonContextMenuArea$lambda$2$0;
                        }
                    };
                    startRestartGroup.updateRememberedValue(rememberedValue4);
                }
                Function0 function0 = (Function0) rememberedValue4;
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                Function1<ContextMenuScope, Unit> contextMenuBuilder = TextFieldSelectionManagerKt.contextMenuBuilder(textFieldSelectionManager, contextMenuState, mutableState);
                boolean enabled = textFieldSelectionManager.getEnabled();
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, 525641028, "CC(remember):CommonContextMenuArea.kt#9igjgp");
                boolean changedInstance = startRestartGroup.changedInstance(coroutineScope) | startRestartGroup.changedInstance(textFieldSelectionManager);
                Object rememberedValue5 = startRestartGroup.rememberedValue();
                if (changedInstance || rememberedValue5 == Composer.Companion.getEmpty()) {
                    rememberedValue5 = new Function0() { // from class: androidx.compose.foundation.text.CommonContextMenuAreaKt$$ExternalSyntheticLambda1
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            Unit CommonContextMenuArea$lambda$3$0;
                            CommonContextMenuArea$lambda$3$0 = CommonContextMenuAreaKt.CommonContextMenuArea$lambda$3$0(CoroutineScope.this, mutableState, textFieldSelectionManager);
                            return CommonContextMenuArea$lambda$3$0;
                        }
                    };
                    startRestartGroup.updateRememberedValue(rememberedValue5);
                }
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                function22 = function2;
                ContextMenuAreaKt.ContextMenuArea(contextMenuState, function0, contextMenuBuilder, null, enabled, rememberedValue5, function22, startRestartGroup, ((i2 << 15) & 3670016) | 54, 8);
                startRestartGroup.endReplaceGroup();
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: androidx.compose.foundation.text.CommonContextMenuAreaKt$$ExternalSyntheticLambda2
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return CommonContextMenuAreaKt.CommonContextMenuArea$lambda$4(TextFieldSelectionManager.this, function22, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit CommonContextMenuArea$lambda$2$0(ContextMenuState contextMenuState) {
        ContextMenuStateKt.close(contextMenuState);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit CommonContextMenuArea$lambda$3$0(CoroutineScope coroutineScope, MutableState mutableState, TextFieldSelectionManager textFieldSelectionManager) {
        BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, CoroutineStart.UNDISPATCHED, new CommonContextMenuAreaKt$CommonContextMenuArea$2$1$1(mutableState, textFieldSelectionManager, null), 1, null);
        return Unit.INSTANCE;
    }

    public static final void CommonContextMenuArea(final TextFieldSelectionState textFieldSelectionState, boolean z, Function2<? super Composer, ? super Integer, Unit> function2, Composer composer, final int i) {
        int i2;
        final boolean z2;
        final Function2<? super Composer, ? super Integer, Unit> function22;
        Modifier.Companion companion;
        Composer startRestartGroup = composer.startRestartGroup(-1442752422);
        ComposerKt.sourceInformation(startRestartGroup, "C(CommonContextMenuArea)N(selectionState,enabled,content):CommonContextMenuArea.kt#423gt5");
        if ((i & 6) == 0) {
            i2 = (startRestartGroup.changedInstance(textFieldSelectionState) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= startRestartGroup.changed(z) ? 32 : 16;
        }
        if ((i & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
            i2 |= startRestartGroup.changedInstance(function2) ? 256 : 128;
        }
        if (!startRestartGroup.shouldExecute((i2 & 147) != 146, i2 & 1)) {
            z2 = z;
            function22 = function2;
            startRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1442752422, i2, -1, "androidx.compose.foundation.text.CommonContextMenuArea (CommonContextMenuArea.kt:75)");
            }
            if (ComposeFoundationFlags.isNewContextMenuEnabled) {
                startRestartGroup.startReplaceGroup(-1299459355);
                ComposerKt.sourceInformation(startRestartGroup, "92@4044L65");
                if (z) {
                    startRestartGroup.startReplaceGroup(-1299415211);
                    ComposerKt.sourceInformation(startRestartGroup, "80@3501L456");
                    Modifier.Companion companion2 = Modifier.Companion;
                    ComposerKt.sourceInformationMarkerStart(startRestartGroup, 789370658, "CC(remember):CommonContextMenuArea.kt#9igjgp");
                    boolean changedInstance = startRestartGroup.changedInstance(textFieldSelectionState);
                    CommonContextMenuAreaKt$CommonContextMenuArea$modifier$1$1 rememberedValue = startRestartGroup.rememberedValue();
                    if (changedInstance || rememberedValue == Composer.Companion.getEmpty()) {
                        rememberedValue = new CommonContextMenuAreaKt$CommonContextMenuArea$modifier$1$1(textFieldSelectionState, null);
                        startRestartGroup.updateRememberedValue(rememberedValue);
                    }
                    ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                    companion = TextContextMenuGesturesModifierKt.showTextContextMenuOnSecondaryClick(companion2, (Function2) rememberedValue);
                    startRestartGroup.endReplaceGroup();
                } else {
                    startRestartGroup.startReplaceGroup(-1298836224);
                    startRestartGroup.endReplaceGroup();
                    companion = Modifier.Companion;
                }
                PlatformDefaultTextContextMenuProviders_androidKt.ProvideDefaultPlatformTextContextMenuProviders(companion, function2, startRestartGroup, (i2 >> 3) & 112, 0);
                startRestartGroup.endReplaceGroup();
                z2 = z;
                function22 = function2;
            } else {
                startRestartGroup.startReplaceGroup(-1298667367);
                ComposerKt.sourceInformation(startRestartGroup, "94@4143L31,95@4204L24,96@4265L55,101@4520L537,116@5190L17,119@5319L209,114@5122L448");
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, 789390777, "CC(remember):CommonContextMenuArea.kt#9igjgp");
                Object rememberedValue2 = startRestartGroup.rememberedValue();
                if (rememberedValue2 == Composer.Companion.getEmpty()) {
                    rememberedValue2 = new ContextMenuState(null, 1, null);
                    startRestartGroup.updateRememberedValue(rememberedValue2);
                }
                final ContextMenuState contextMenuState = (ContextMenuState) rememberedValue2;
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, 773894976, "CC(rememberCoroutineScope)N(getContext)600@27430L68:Effects.kt#9igjgp");
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, 683736516, "CC(remember):Effects.kt#9igjgp");
                Object rememberedValue3 = startRestartGroup.rememberedValue();
                if (rememberedValue3 == Composer.Companion.getEmpty()) {
                    rememberedValue3 = EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, startRestartGroup);
                    startRestartGroup.updateRememberedValue(rememberedValue3);
                }
                final CoroutineScope coroutineScope = (CoroutineScope) rememberedValue3;
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, 789394705, "CC(remember):CommonContextMenuArea.kt#9igjgp");
                Object rememberedValue4 = startRestartGroup.rememberedValue();
                if (rememberedValue4 == Composer.Companion.getEmpty()) {
                    rememberedValue4 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(MenuItemsAvailability.m1227boximpl(MenuItemsAvailability.Companion.m1240getNoneJKCFgKw()), null, 2, null);
                    startRestartGroup.updateRememberedValue(rememberedValue4);
                }
                final MutableState mutableState = (MutableState) rememberedValue4;
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                MutableState mutableState2 = mutableState;
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, 789403347, "CC(remember):CommonContextMenuArea.kt#9igjgp");
                boolean changedInstance2 = startRestartGroup.changedInstance(coroutineScope);
                Object rememberedValue5 = startRestartGroup.rememberedValue();
                if (changedInstance2 || rememberedValue5 == Composer.Companion.getEmpty()) {
                    rememberedValue5 = new Function2() { // from class: androidx.compose.foundation.text.CommonContextMenuAreaKt$$ExternalSyntheticLambda5
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            Unit CommonContextMenuArea$lambda$8$0;
                            CommonContextMenuArea$lambda$8$0 = CommonContextMenuAreaKt.CommonContextMenuArea$lambda$8$0(CoroutineScope.this, (TextFieldSelectionState) obj, (TextContextMenuItems) obj2);
                            return CommonContextMenuArea$lambda$8$0;
                        }
                    };
                    startRestartGroup.updateRememberedValue(rememberedValue5);
                }
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                Function1<ContextMenuScope, Unit> contextMenuBuilder = TextFieldSelectionStateKt.contextMenuBuilder(textFieldSelectionState, contextMenuState, mutableState2, (Function2) rememberedValue5);
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, 789424267, "CC(remember):CommonContextMenuArea.kt#9igjgp");
                Object rememberedValue6 = startRestartGroup.rememberedValue();
                if (rememberedValue6 == Composer.Companion.getEmpty()) {
                    rememberedValue6 = new Function0() { // from class: androidx.compose.foundation.text.CommonContextMenuAreaKt$$ExternalSyntheticLambda6
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            Unit CommonContextMenuArea$lambda$9$0;
                            CommonContextMenuArea$lambda$9$0 = CommonContextMenuAreaKt.CommonContextMenuArea$lambda$9$0(ContextMenuState.this);
                            return CommonContextMenuArea$lambda$9$0;
                        }
                    };
                    startRestartGroup.updateRememberedValue(rememberedValue6);
                }
                Function0 function0 = (Function0) rememberedValue6;
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, 789428587, "CC(remember):CommonContextMenuArea.kt#9igjgp");
                boolean changedInstance3 = startRestartGroup.changedInstance(coroutineScope) | startRestartGroup.changedInstance(textFieldSelectionState);
                Object rememberedValue7 = startRestartGroup.rememberedValue();
                if (changedInstance3 || rememberedValue7 == Composer.Companion.getEmpty()) {
                    rememberedValue7 = new Function0() { // from class: androidx.compose.foundation.text.CommonContextMenuAreaKt$$ExternalSyntheticLambda7
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            Unit CommonContextMenuArea$lambda$10$0;
                            CommonContextMenuArea$lambda$10$0 = CommonContextMenuAreaKt.CommonContextMenuArea$lambda$10$0(CoroutineScope.this, mutableState, textFieldSelectionState);
                            return CommonContextMenuArea$lambda$10$0;
                        }
                    };
                    startRestartGroup.updateRememberedValue(rememberedValue7);
                }
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                z2 = z;
                function22 = function2;
                ContextMenuAreaKt.ContextMenuArea(contextMenuState, function0, contextMenuBuilder, null, z2, (Function0) rememberedValue7, function22, startRestartGroup, ((i2 << 9) & 57344) | 54 | ((i2 << 12) & 3670016), 8);
                startRestartGroup.endReplaceGroup();
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: androidx.compose.foundation.text.CommonContextMenuAreaKt$$ExternalSyntheticLambda8
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return CommonContextMenuAreaKt.CommonContextMenuArea$lambda$11(TextFieldSelectionState.this, z2, function22, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit CommonContextMenuArea$lambda$8$0(CoroutineScope coroutineScope, TextFieldSelectionState textFieldSelectionState, TextContextMenuItems textContextMenuItems) {
        BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, CoroutineStart.UNDISPATCHED, new CommonContextMenuAreaKt$CommonContextMenuArea$menuBuilder$1$1$1(textContextMenuItems, textFieldSelectionState, null), 1, null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit CommonContextMenuArea$lambda$9$0(ContextMenuState contextMenuState) {
        ContextMenuStateKt.close(contextMenuState);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit CommonContextMenuArea$lambda$10$0(CoroutineScope coroutineScope, MutableState mutableState, TextFieldSelectionState textFieldSelectionState) {
        BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, CoroutineStart.UNDISPATCHED, new CommonContextMenuAreaKt$CommonContextMenuArea$5$1$1(mutableState, textFieldSelectionState, null), 1, null);
        return Unit.INSTANCE;
    }

    public static final void CommonContextMenuArea(final SelectionManager selectionManager, Function2<? super Composer, ? super Integer, Unit> function2, Composer composer, final int i) {
        int i2;
        final Function2<? super Composer, ? super Integer, Unit> function22;
        Composer startRestartGroup = composer.startRestartGroup(-614342087);
        ComposerKt.sourceInformation(startRestartGroup, "C(CommonContextMenuArea)N(manager,content):CommonContextMenuArea.kt#423gt5");
        if ((i & 6) == 0) {
            i2 = (startRestartGroup.changedInstance(selectionManager) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= startRestartGroup.changedInstance(function2) ? 32 : 16;
        }
        if (!startRestartGroup.shouldExecute((i2 & 19) != 18, i2 & 1)) {
            function22 = function2;
            startRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-614342087, i2, -1, "androidx.compose.foundation.text.CommonContextMenuArea (CommonContextMenuArea.kt:131)");
            }
            if (ComposeFoundationFlags.isNewContextMenuEnabled) {
                startRestartGroup.startReplaceGroup(-1009319487);
                ComposerKt.sourceInformation(startRestartGroup, "133@5796L88");
                PlatformDefaultTextContextMenuProviders_androidKt.ProvideDefaultPlatformTextContextMenuProviders(selectionManager.getContextMenuAreaModifier(), function2, startRestartGroup, i2 & 112, 0);
                startRestartGroup.endReplaceGroup();
                function22 = function2;
            } else {
                startRestartGroup.startReplaceGroup(-1009204043);
                ComposerKt.sourceInformation(startRestartGroup, "135@5918L31,138@6066L17,136@5998L200");
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1972217192, "CC(remember):CommonContextMenuArea.kt#9igjgp");
                Object rememberedValue = startRestartGroup.rememberedValue();
                if (rememberedValue == Composer.Companion.getEmpty()) {
                    rememberedValue = new ContextMenuState(null, 1, null);
                    startRestartGroup.updateRememberedValue(rememberedValue);
                }
                final ContextMenuState contextMenuState = (ContextMenuState) rememberedValue;
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1972212470, "CC(remember):CommonContextMenuArea.kt#9igjgp");
                Object rememberedValue2 = startRestartGroup.rememberedValue();
                if (rememberedValue2 == Composer.Companion.getEmpty()) {
                    rememberedValue2 = new Function0() { // from class: androidx.compose.foundation.text.CommonContextMenuAreaKt$$ExternalSyntheticLambda3
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            Unit CommonContextMenuArea$lambda$13$0;
                            CommonContextMenuArea$lambda$13$0 = CommonContextMenuAreaKt.CommonContextMenuArea$lambda$13$0(ContextMenuState.this);
                            return CommonContextMenuArea$lambda$13$0;
                        }
                    };
                    startRestartGroup.updateRememberedValue(rememberedValue2);
                }
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                function22 = function2;
                ContextMenuAreaKt.ContextMenuArea(contextMenuState, (Function0) rememberedValue2, SelectionManagerKt.contextMenuBuilder(selectionManager, contextMenuState), null, false, null, function22, startRestartGroup, ((i2 << 15) & 3670016) | 54, 56);
                startRestartGroup.endReplaceGroup();
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: androidx.compose.foundation.text.CommonContextMenuAreaKt$$ExternalSyntheticLambda4
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return CommonContextMenuAreaKt.CommonContextMenuArea$lambda$14(SelectionManager.this, function22, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit CommonContextMenuArea$lambda$13$0(ContextMenuState contextMenuState) {
        ContextMenuStateKt.close(contextMenuState);
        return Unit.INSTANCE;
    }

    public static final void TextItem(ContextMenuScope contextMenuScope, ContextMenuState contextMenuState, TextContextMenuItems textContextMenuItems, boolean z, Function0<Unit> function0) {
        if (z) {
            ContextMenuScope.item$default(contextMenuScope, new CommonContextMenuAreaKt$TextItem$1(textContextMenuItems), null, false, null, new CommonContextMenuAreaKt$TextItem$2(function0, contextMenuState), 14, null);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0036  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object getContextMenuItemsAvailability(TextFieldSelectionState textFieldSelectionState, Continuation<? super MenuItemsAvailability> continuation) {
        CommonContextMenuAreaKt$getContextMenuItemsAvailability$1 commonContextMenuAreaKt$getContextMenuItemsAvailability$1;
        int i;
        if (continuation instanceof CommonContextMenuAreaKt$getContextMenuItemsAvailability$1) {
            commonContextMenuAreaKt$getContextMenuItemsAvailability$1 = (CommonContextMenuAreaKt$getContextMenuItemsAvailability$1) continuation;
            if ((commonContextMenuAreaKt$getContextMenuItemsAvailability$1.label & Integer.MIN_VALUE) != 0) {
                commonContextMenuAreaKt$getContextMenuItemsAvailability$1.label -= Integer.MIN_VALUE;
                Object obj = commonContextMenuAreaKt$getContextMenuItemsAvailability$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = commonContextMenuAreaKt$getContextMenuItemsAvailability$1.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    commonContextMenuAreaKt$getContextMenuItemsAvailability$1.L$0 = textFieldSelectionState;
                    commonContextMenuAreaKt$getContextMenuItemsAvailability$1.label = 1;
                    if (textFieldSelectionState.updateClipboardEntry(commonContextMenuAreaKt$getContextMenuItemsAvailability$1) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                } else {
                    textFieldSelectionState = (TextFieldSelectionState) commonContextMenuAreaKt$getContextMenuItemsAvailability$1.L$0;
                    ResultKt.throwOnFailure(obj);
                }
                return MenuItemsAvailability.m1227boximpl(MenuItemsAvailability.m1229constructorimpl(textFieldSelectionState.canShowCopyMenuItem(), textFieldSelectionState.canShowPasteMenuItem(), textFieldSelectionState.canShowCutMenuItem(), textFieldSelectionState.canShowSelectAllMenuItem(), textFieldSelectionState.canShowAutofillMenuItem()));
            }
        }
        commonContextMenuAreaKt$getContextMenuItemsAvailability$1 = new CommonContextMenuAreaKt$getContextMenuItemsAvailability$1(continuation);
        Object obj2 = commonContextMenuAreaKt$getContextMenuItemsAvailability$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = commonContextMenuAreaKt$getContextMenuItemsAvailability$1.label;
        if (i != 0) {
        }
        return MenuItemsAvailability.m1227boximpl(MenuItemsAvailability.m1229constructorimpl(textFieldSelectionState.canShowCopyMenuItem(), textFieldSelectionState.canShowPasteMenuItem(), textFieldSelectionState.canShowCutMenuItem(), textFieldSelectionState.canShowSelectAllMenuItem(), textFieldSelectionState.canShowAutofillMenuItem()));
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0036  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object getContextMenuItemsAvailability(TextFieldSelectionManager textFieldSelectionManager, Continuation<? super MenuItemsAvailability> continuation) {
        CommonContextMenuAreaKt$getContextMenuItemsAvailability$2 commonContextMenuAreaKt$getContextMenuItemsAvailability$2;
        int i;
        if (continuation instanceof CommonContextMenuAreaKt$getContextMenuItemsAvailability$2) {
            commonContextMenuAreaKt$getContextMenuItemsAvailability$2 = (CommonContextMenuAreaKt$getContextMenuItemsAvailability$2) continuation;
            if ((commonContextMenuAreaKt$getContextMenuItemsAvailability$2.label & Integer.MIN_VALUE) != 0) {
                commonContextMenuAreaKt$getContextMenuItemsAvailability$2.label -= Integer.MIN_VALUE;
                Object obj = commonContextMenuAreaKt$getContextMenuItemsAvailability$2.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = commonContextMenuAreaKt$getContextMenuItemsAvailability$2.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    commonContextMenuAreaKt$getContextMenuItemsAvailability$2.L$0 = textFieldSelectionManager;
                    commonContextMenuAreaKt$getContextMenuItemsAvailability$2.label = 1;
                    if (textFieldSelectionManager.updateClipboardEntry$foundation(commonContextMenuAreaKt$getContextMenuItemsAvailability$2) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                } else {
                    textFieldSelectionManager = (TextFieldSelectionManager) commonContextMenuAreaKt$getContextMenuItemsAvailability$2.L$0;
                    ResultKt.throwOnFailure(obj);
                }
                return MenuItemsAvailability.m1227boximpl(MenuItemsAvailability.m1229constructorimpl(textFieldSelectionManager.canShowCopyMenuItem$foundation(), textFieldSelectionManager.canShowPasteMenuItem$foundation(), textFieldSelectionManager.canShowCutMenuItem$foundation(), textFieldSelectionManager.canShowSelectAllMenuItem$foundation(), textFieldSelectionManager.canShowAutofillMenuItem$foundation()));
            }
        }
        commonContextMenuAreaKt$getContextMenuItemsAvailability$2 = new CommonContextMenuAreaKt$getContextMenuItemsAvailability$2(continuation);
        Object obj2 = commonContextMenuAreaKt$getContextMenuItemsAvailability$2.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = commonContextMenuAreaKt$getContextMenuItemsAvailability$2.label;
        if (i != 0) {
        }
        return MenuItemsAvailability.m1227boximpl(MenuItemsAvailability.m1229constructorimpl(textFieldSelectionManager.canShowCopyMenuItem$foundation(), textFieldSelectionManager.canShowPasteMenuItem$foundation(), textFieldSelectionManager.canShowCutMenuItem$foundation(), textFieldSelectionManager.canShowSelectAllMenuItem$foundation(), textFieldSelectionManager.canShowAutofillMenuItem$foundation()));
    }
}
