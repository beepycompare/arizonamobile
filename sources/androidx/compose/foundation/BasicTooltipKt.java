package androidx.compose.foundation;

import androidx.compose.foundation.gestures.ForEachGestureKt;
import androidx.compose.foundation.gestures.LongPressResult;
import androidx.compose.foundation.gestures.TapGestureDetectorKt;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.DisposableEffectResult;
import androidx.compose.runtime.DisposableEffectScope;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambda;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.input.pointer.AwaitPointerEventScope;
import androidx.compose.ui.input.pointer.PointerEvent;
import androidx.compose.ui.input.pointer.PointerEventPass;
import androidx.compose.ui.input.pointer.PointerInputChange;
import androidx.compose.ui.input.pointer.PointerInputEventHandler;
import androidx.compose.ui.input.pointer.PointerInputScope;
import androidx.compose.ui.input.pointer.PointerType;
import androidx.compose.ui.input.pointer.SuspendingPointerInputFilterKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.semantics.LiveRegionMode;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.window.AndroidPopup_androidKt;
import androidx.compose.ui.window.PopupPositionProvider;
import androidx.compose.ui.window.PopupProperties;
import androidx.media3.exoplayer.RendererCapabilities;
import androidx.profileinstaller.ProfileVerifier;
import com.google.android.vending.expansion.downloader.impl.DownloaderService;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.messaging.Constants;
import com.google.firebase.remoteconfig.RemoteConfigConstants;
import java.util.List;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
/* compiled from: BasicTooltip.kt */
@Metadata(d1 = {"\u0000D\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\u001ak\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0011\u0010\u0004\u001a\r\u0012\u0004\u0012\u00020\u00010\u0005¢\u0006\u0002\b\u00062\u0006\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\f2\b\b\u0002\u0010\u000e\u001a\u00020\f2\u0011\u0010\u000f\u001a\r\u0012\u0004\u0012\u00020\u00010\u0005¢\u0006\u0002\b\u0006H\u0007¢\u0006\u0002\u0010\u0010\u001aa\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0011\u0010\u0004\u001a\r\u0012\u0004\u0012\u00020\u00010\u0005¢\u0006\u0002\b\u00062\u0006\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\f2\u0011\u0010\u000f\u001a\r\u0012\u0004\u0012\u00020\u00010\u0005¢\u0006\u0002\b\u0006H\u0007¢\u0006\u0002\u0010\u0011\u001aB\u0010\u0012\u001a\u00020\u00012\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\f2\b\b\u0002\u0010\t\u001a\u00020\n2\u0011\u0010\u000f\u001a\r\u0012\u0004\u0012\u00020\u00010\u0005¢\u0006\u0002\b\u0006H\u0003¢\u0006\u0002\u0010\u0013\u001a@\u0010\u0014\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u000b\u001a\u00020\f2\u0011\u0010\u000f\u001a\r\u0012\u0004\u0012\u00020\u00010\u0005¢\u0006\u0002\b\u0006H\u0003¢\u0006\u0002\u0010\u0017\u001a\u001c\u0010\u0018\u001a\u00020\n*\u00020\n2\u0006\u0010\u0019\u001a\u00020\f2\u0006\u0010\u0007\u001a\u00020\bH\u0002\u001a,\u0010\u001a\u001a\u00020\n*\u00020\n2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u0019\u001a\u00020\f2\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0015\u001a\u00020\u0016H\u0002\u001a+\u0010\u001d\u001a\u00020\b2\b\b\u0002\u0010\u001e\u001a\u00020\f2\b\b\u0002\u0010\u001f\u001a\u00020\f2\b\b\u0002\u0010 \u001a\u00020!H\u0007¢\u0006\u0002\u0010\"\u001a&\u0010#\u001a\u00020\b2\b\b\u0002\u0010\u001e\u001a\u00020\f2\b\b\u0002\u0010\u001f\u001a\u00020\f2\b\b\u0002\u0010 \u001a\u00020!H\u0007¨\u0006$"}, d2 = {"BasicTooltipBox", "", "positionProvider", "Landroidx/compose/ui/window/PopupPositionProvider;", "tooltip", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", RemoteConfigConstants.ResponseFieldKey.STATE, "Landroidx/compose/foundation/BasicTooltipState;", "modifier", "Landroidx/compose/ui/Modifier;", "focusable", "", "enableUserInput", "propagateMinConstraints", FirebaseAnalytics.Param.CONTENT, "(Landroidx/compose/ui/window/PopupPositionProvider;Lkotlin/jvm/functions/Function2;Landroidx/compose/foundation/BasicTooltipState;Landroidx/compose/ui/Modifier;ZZZLkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "(Landroidx/compose/ui/window/PopupPositionProvider;Lkotlin/jvm/functions/Function2;Landroidx/compose/foundation/BasicTooltipState;Landroidx/compose/ui/Modifier;ZZLkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "WrappedAnchor", "(ZLandroidx/compose/foundation/BasicTooltipState;ZLandroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "TooltipPopup", "scope", "Lkotlinx/coroutines/CoroutineScope;", "(Landroidx/compose/ui/window/PopupPositionProvider;Landroidx/compose/foundation/BasicTooltipState;Lkotlinx/coroutines/CoroutineScope;ZLkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "handleGestures", "enabled", "anchorSemantics", Constants.ScionAnalytics.PARAM_LABEL, "", "rememberBasicTooltipState", "initialIsVisible", "isPersistent", "mutatorMutex", "Landroidx/compose/foundation/MutatorMutex;", "(ZZLandroidx/compose/foundation/MutatorMutex;Landroidx/compose/runtime/Composer;II)Landroidx/compose/foundation/BasicTooltipState;", "BasicTooltipState", "foundation"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes.dex */
public final class BasicTooltipKt {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit BasicTooltipBox$lambda$2(PopupPositionProvider popupPositionProvider, Function2 function2, BasicTooltipState basicTooltipState, Modifier modifier, boolean z, boolean z2, boolean z3, Function2 function22, int i, int i2, Composer composer, int i3) {
        BasicTooltipBox(popupPositionProvider, function2, basicTooltipState, modifier, z, z2, z3, function22, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit BasicTooltipBox$lambda$3(PopupPositionProvider popupPositionProvider, Function2 function2, BasicTooltipState basicTooltipState, Modifier modifier, boolean z, boolean z2, Function2 function22, int i, int i2, Composer composer, int i3) {
        BasicTooltipBox(popupPositionProvider, function2, basicTooltipState, modifier, z, z2, function22, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit TooltipPopup$lambda$2(PopupPositionProvider popupPositionProvider, BasicTooltipState basicTooltipState, CoroutineScope coroutineScope, boolean z, Function2 function2, int i, Composer composer, int i2) {
        TooltipPopup(popupPositionProvider, basicTooltipState, coroutineScope, z, function2, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit WrappedAnchor$lambda$1(boolean z, BasicTooltipState basicTooltipState, boolean z2, Modifier modifier, Function2 function2, int i, int i2, Composer composer, int i3) {
        WrappedAnchor(z, basicTooltipState, z2, modifier, function2, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Removed duplicated region for block: B:109:0x01b3  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x01c4  */
    /* JADX WARN: Removed duplicated region for block: B:114:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0068  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x006b  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0086  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0088  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00a2  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00a4  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00c1  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x00db  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x00dd  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x00e7  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void BasicTooltipBox(final PopupPositionProvider popupPositionProvider, final Function2<? super Composer, ? super Integer, Unit> function2, final BasicTooltipState basicTooltipState, Modifier modifier, boolean z, boolean z2, boolean z3, final Function2<? super Composer, ? super Integer, Unit> function22, Composer composer, final int i, final int i2) {
        final PopupPositionProvider popupPositionProvider2;
        int i3;
        Object obj;
        int i4;
        boolean z4;
        int i5;
        boolean z5;
        int i6;
        boolean z6;
        final BasicTooltipState basicTooltipState2;
        Composer composer2;
        final Modifier modifier2;
        final boolean z7;
        final boolean z8;
        ScopeUpdateScope endRestartGroup;
        Composer startRestartGroup = composer.startRestartGroup(-542290032);
        ComposerKt.sourceInformation(startRestartGroup, "C(BasicTooltipBox)N(positionProvider,tooltip,state,modifier,focusable,enableUserInput,propagateMinConstraints,content)85@3932L24,91@4136L296,86@3961L471,105@4462L35,105@4438L59:BasicTooltip.kt#71ulvw");
        if ((i & 6) == 0) {
            popupPositionProvider2 = popupPositionProvider;
            i3 = (startRestartGroup.changed(popupPositionProvider2) ? 4 : 2) | i;
        } else {
            popupPositionProvider2 = popupPositionProvider;
            i3 = i;
        }
        if ((i & 48) == 0) {
            i3 |= startRestartGroup.changedInstance(function2) ? 32 : 16;
        }
        if ((i & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
            i3 |= startRestartGroup.changed(basicTooltipState) ? 256 : 128;
        }
        int i7 = i2 & 8;
        if (i7 != 0) {
            i3 |= 3072;
        } else if ((i & 3072) == 0) {
            obj = modifier;
            i3 |= startRestartGroup.changed(obj) ? 2048 : 1024;
            i4 = i2 & 16;
            if (i4 == 0) {
                i3 |= 24576;
            } else if ((i & 24576) == 0) {
                z4 = z;
                i3 |= startRestartGroup.changed(z4) ? 16384 : 8192;
                i5 = i2 & 32;
                if (i5 != 0) {
                    i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                } else if ((196608 & i) == 0) {
                    z5 = z2;
                    i3 |= startRestartGroup.changed(z5) ? 131072 : 65536;
                    i6 = i2 & 64;
                    if (i6 == 0) {
                        i3 |= 1572864;
                    } else if ((1572864 & i) == 0) {
                        z6 = z3;
                        i3 |= startRestartGroup.changed(z6) ? 1048576 : 524288;
                        if ((i & 12582912) == 0) {
                            i3 |= startRestartGroup.changedInstance(function22) ? 8388608 : 4194304;
                        }
                        if (!startRestartGroup.shouldExecute((i3 & 4793491) != 4793490, i3 & 1)) {
                            basicTooltipState2 = basicTooltipState;
                            composer2 = startRestartGroup;
                            composer2.skipToGroupEnd();
                            modifier2 = obj;
                            z7 = z5;
                            z8 = z6;
                        } else {
                            Modifier.Companion companion = i7 != 0 ? Modifier.Companion : obj;
                            final boolean z9 = i4 != 0 ? true : z4;
                            if (i5 != 0) {
                                z5 = true;
                            }
                            if (i6 != 0) {
                                z6 = false;
                            }
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-542290032, i3, -1, "androidx.compose.foundation.BasicTooltipBox (BasicTooltip.kt:84)");
                            }
                            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 773894976, "CC(rememberCoroutineScope)N(getContext)616@28039L68:Effects.kt#9igjgp");
                            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 683736516, "CC(remember):Effects.kt#9igjgp");
                            Object rememberedValue = startRestartGroup.rememberedValue();
                            if (rememberedValue == Composer.Companion.getEmpty()) {
                                rememberedValue = EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, startRestartGroup);
                                startRestartGroup.updateRememberedValue(rememberedValue);
                            }
                            final CoroutineScope coroutineScope = (CoroutineScope) rememberedValue;
                            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                            int i8 = i3;
                            z4 = z9;
                            ComposableLambda rememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(99800901, true, new Function2() { // from class: androidx.compose.foundation.BasicTooltipKt$$ExternalSyntheticLambda0
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj2, Object obj3) {
                                    return BasicTooltipKt.BasicTooltipBox$lambda$0(BasicTooltipState.this, popupPositionProvider2, coroutineScope, z9, function2, function22, (Composer) obj2, ((Integer) obj3).intValue());
                                }
                            }, startRestartGroup, 54);
                            int i9 = ((i8 >> 15) & 14) | 24576 | ((i8 >> 3) & 112) | ((i8 >> 12) & 896) | (i8 & 7168);
                            composer2 = startRestartGroup;
                            basicTooltipState2 = basicTooltipState;
                            boolean z10 = z5;
                            boolean z11 = z6;
                            Modifier modifier3 = companion;
                            WrappedAnchor(z10, basicTooltipState2, z11, modifier3, rememberComposableLambda, composer2, i9, 0);
                            ComposerKt.sourceInformationMarkerStart(composer2, -1449650093, "CC(remember):BasicTooltip.kt#9igjgp");
                            boolean z12 = (i8 & 896) == 256;
                            Object rememberedValue2 = composer2.rememberedValue();
                            if (z12 || rememberedValue2 == Composer.Companion.getEmpty()) {
                                rememberedValue2 = new Function1() { // from class: androidx.compose.foundation.BasicTooltipKt$$ExternalSyntheticLambda2
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Object invoke(Object obj2) {
                                        DisposableEffectResult BasicTooltipBox$lambda$1$0;
                                        BasicTooltipBox$lambda$1$0 = BasicTooltipKt.BasicTooltipBox$lambda$1$0(BasicTooltipState.this, (DisposableEffectScope) obj2);
                                        return BasicTooltipBox$lambda$1$0;
                                    }
                                };
                                composer2.updateRememberedValue(rememberedValue2);
                            }
                            ComposerKt.sourceInformationMarkerEnd(composer2);
                            EffectsKt.DisposableEffect(basicTooltipState2, (Function1) rememberedValue2, composer2, (i8 >> 6) & 14);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            z7 = z10;
                            z8 = z11;
                            modifier2 = modifier3;
                        }
                        Composer composer3 = composer2;
                        final boolean z13 = z4;
                        endRestartGroup = composer3.endRestartGroup();
                        if (endRestartGroup != null) {
                            final BasicTooltipState basicTooltipState3 = basicTooltipState2;
                            endRestartGroup.updateScope(new Function2() { // from class: androidx.compose.foundation.BasicTooltipKt$$ExternalSyntheticLambda3
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj2, Object obj3) {
                                    return BasicTooltipKt.BasicTooltipBox$lambda$2(PopupPositionProvider.this, function2, basicTooltipState3, modifier2, z13, z7, z8, function22, i, i2, (Composer) obj2, ((Integer) obj3).intValue());
                                }
                            });
                            return;
                        }
                        return;
                    }
                    z6 = z3;
                    if ((i & 12582912) == 0) {
                    }
                    if (!startRestartGroup.shouldExecute((i3 & 4793491) != 4793490, i3 & 1)) {
                    }
                    Composer composer32 = composer2;
                    final boolean z132 = z4;
                    endRestartGroup = composer32.endRestartGroup();
                    if (endRestartGroup != null) {
                    }
                }
                z5 = z2;
                i6 = i2 & 64;
                if (i6 == 0) {
                }
                z6 = z3;
                if ((i & 12582912) == 0) {
                }
                if (!startRestartGroup.shouldExecute((i3 & 4793491) != 4793490, i3 & 1)) {
                }
                Composer composer322 = composer2;
                final boolean z1322 = z4;
                endRestartGroup = composer322.endRestartGroup();
                if (endRestartGroup != null) {
                }
            }
            z4 = z;
            i5 = i2 & 32;
            if (i5 != 0) {
            }
            z5 = z2;
            i6 = i2 & 64;
            if (i6 == 0) {
            }
            z6 = z3;
            if ((i & 12582912) == 0) {
            }
            if (!startRestartGroup.shouldExecute((i3 & 4793491) != 4793490, i3 & 1)) {
            }
            Composer composer3222 = composer2;
            final boolean z13222 = z4;
            endRestartGroup = composer3222.endRestartGroup();
            if (endRestartGroup != null) {
            }
        }
        obj = modifier;
        i4 = i2 & 16;
        if (i4 == 0) {
        }
        z4 = z;
        i5 = i2 & 32;
        if (i5 != 0) {
        }
        z5 = z2;
        i6 = i2 & 64;
        if (i6 == 0) {
        }
        z6 = z3;
        if ((i & 12582912) == 0) {
        }
        if (!startRestartGroup.shouldExecute((i3 & 4793491) != 4793490, i3 & 1)) {
        }
        Composer composer32222 = composer2;
        final boolean z132222 = z4;
        endRestartGroup = composer32222.endRestartGroup();
        if (endRestartGroup != null) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit BasicTooltipBox$lambda$0(BasicTooltipState basicTooltipState, PopupPositionProvider popupPositionProvider, CoroutineScope coroutineScope, boolean z, Function2 function2, Function2 function22, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C102@4417L9:BasicTooltip.kt#71ulvw");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(99800901, i, -1, "androidx.compose.foundation.BasicTooltipBox.<anonymous> (BasicTooltip.kt:92)");
            }
            if (basicTooltipState.isVisible()) {
                composer.startReplaceGroup(1051311053);
                ComposerKt.sourceInformation(composer, "93@4181L216");
                TooltipPopup(popupPositionProvider, basicTooltipState, coroutineScope, z, function2, composer, 0);
                composer.endReplaceGroup();
            } else {
                composer.startReplaceGroup(1051541693);
                composer.endReplaceGroup();
            }
            function22.invoke(composer, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX WARN: Removed duplicated region for block: B:37:0x0066  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0069  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0084  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0086  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00a0  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x00af  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x00be  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x00c1  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x00ca  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x0120  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x012e  */
    /* JADX WARN: Removed duplicated region for block: B:92:? A[RETURN, SYNTHETIC] */
    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Maintained for binary compatibility. Use version with propagateMinConstraints instead.")
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final /* synthetic */ void BasicTooltipBox(final PopupPositionProvider popupPositionProvider, final Function2 function2, final BasicTooltipState basicTooltipState, Modifier modifier, boolean z, boolean z2, final Function2 function22, Composer composer, final int i, final int i2) {
        int i3;
        final Object obj;
        int i4;
        boolean z3;
        int i5;
        Composer composer2;
        final boolean z4;
        final boolean z5;
        ScopeUpdateScope endRestartGroup;
        Composer startRestartGroup = composer.startRestartGroup(196062260);
        ComposerKt.sourceInformation(startRestartGroup, "C(BasicTooltipBox)N(positionProvider,tooltip,state,modifier,focusable,enableUserInput,content)124@4985L288:BasicTooltip.kt#71ulvw");
        if ((i & 6) == 0) {
            i3 = (startRestartGroup.changed(popupPositionProvider) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        if ((i & 48) == 0) {
            i3 |= startRestartGroup.changedInstance(function2) ? 32 : 16;
        }
        if ((i & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
            i3 |= startRestartGroup.changed(basicTooltipState) ? 256 : 128;
        }
        int i6 = i2 & 8;
        if (i6 != 0) {
            i3 |= 3072;
        } else if ((i & 3072) == 0) {
            obj = modifier;
            i3 |= startRestartGroup.changed(obj) ? 2048 : 1024;
            i4 = i2 & 16;
            if (i4 == 0) {
                i3 |= 24576;
            } else if ((i & 24576) == 0) {
                z3 = z;
                i3 |= startRestartGroup.changed(z3) ? 16384 : 8192;
                i5 = i2 & 32;
                if (i5 != 0) {
                    i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                } else if ((196608 & i) == 0) {
                    i3 |= startRestartGroup.changed(z2) ? 131072 : 65536;
                    if ((i & 1572864) == 0) {
                        i3 |= startRestartGroup.changedInstance(function22) ? 1048576 : 524288;
                    }
                    if (startRestartGroup.shouldExecute((599187 & i3) == 599186, i3 & 1)) {
                        composer2 = startRestartGroup;
                        composer2.skipToGroupEnd();
                        z4 = z3;
                        z5 = z2;
                    } else {
                        Modifier.Companion companion = i6 != 0 ? Modifier.Companion : obj;
                        boolean z6 = i4 != 0 ? true : z3;
                        boolean z7 = i5 != 0 ? true : z2;
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(196062260, i3, -1, "androidx.compose.foundation.BasicTooltipBox (BasicTooltip.kt:123)");
                        }
                        composer2 = startRestartGroup;
                        BasicTooltipBox(popupPositionProvider, function2, basicTooltipState, companion, z6, z7, false, function22, composer2, (i3 & 14) | 1572864 | (i3 & 112) | (i3 & 896) | (i3 & 7168) | (57344 & i3) | (458752 & i3) | ((i3 << 3) & 29360128), 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        obj = companion;
                        z4 = z6;
                        z5 = z7;
                    }
                    endRestartGroup = composer2.endRestartGroup();
                    if (endRestartGroup == null) {
                        endRestartGroup.updateScope(new Function2() { // from class: androidx.compose.foundation.BasicTooltipKt$$ExternalSyntheticLambda9
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj2, Object obj3) {
                                return BasicTooltipKt.BasicTooltipBox$lambda$3(PopupPositionProvider.this, function2, basicTooltipState, obj, z4, z5, function22, i, i2, (Composer) obj2, ((Integer) obj3).intValue());
                            }
                        });
                        return;
                    }
                    return;
                }
                if ((i & 1572864) == 0) {
                }
                if (startRestartGroup.shouldExecute((599187 & i3) == 599186, i3 & 1)) {
                }
                endRestartGroup = composer2.endRestartGroup();
                if (endRestartGroup == null) {
                }
            }
            z3 = z;
            i5 = i2 & 32;
            if (i5 != 0) {
            }
            if ((i & 1572864) == 0) {
            }
            if (startRestartGroup.shouldExecute((599187 & i3) == 599186, i3 & 1)) {
            }
            endRestartGroup = composer2.endRestartGroup();
            if (endRestartGroup == null) {
            }
        }
        obj = modifier;
        i4 = i2 & 16;
        if (i4 == 0) {
        }
        z3 = z;
        i5 = i2 & 32;
        if (i5 != 0) {
        }
        if ((i & 1572864) == 0) {
        }
        if (startRestartGroup.shouldExecute((599187 & i3) == 599186, i3 & 1)) {
        }
        endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup == null) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:37:0x0064  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0077  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0079  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0082  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x0196  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x01a0  */
    /* JADX WARN: Removed duplicated region for block: B:71:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static final void WrappedAnchor(final boolean z, final BasicTooltipState basicTooltipState, final boolean z2, Modifier modifier, final Function2<? super Composer, ? super Integer, Unit> function2, Composer composer, final int i, final int i2) {
        int i3;
        Modifier.Companion companion;
        ScopeUpdateScope endRestartGroup;
        Composer startRestartGroup = composer.startRestartGroup(423692761);
        ComposerKt.sourceInformation(startRestartGroup, "C(WrappedAnchor)N(enableUserInput,state,propagateMinConstraints,modifier,content)145@5547L24,146@5617L7,147@5629L272:BasicTooltip.kt#71ulvw");
        if ((i & 6) == 0) {
            i3 = (startRestartGroup.changed(z) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        if ((i & 48) == 0) {
            i3 |= startRestartGroup.changed(basicTooltipState) ? 32 : 16;
        }
        if ((i & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
            i3 |= startRestartGroup.changed(z2) ? 256 : 128;
        }
        int i4 = i2 & 8;
        if (i4 != 0) {
            i3 |= 3072;
        } else if ((i & 3072) == 0) {
            companion = modifier;
            i3 |= startRestartGroup.changed(companion) ? 2048 : 1024;
            if ((i & 24576) == 0) {
                i3 |= startRestartGroup.changedInstance(function2) ? 16384 : 8192;
            }
            if (startRestartGroup.shouldExecute((i3 & 9363) == 9362, i3 & 1)) {
                startRestartGroup.skipToGroupEnd();
            } else {
                if (i4 != 0) {
                    companion = Modifier.Companion;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(423692761, i3, -1, "androidx.compose.foundation.WrappedAnchor (BasicTooltip.kt:144)");
                }
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, 773894976, "CC(rememberCoroutineScope)N(getContext)616@28039L68:Effects.kt#9igjgp");
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, 683736516, "CC(remember):Effects.kt#9igjgp");
                Object rememberedValue = startRestartGroup.rememberedValue();
                if (rememberedValue == Composer.Companion.getEmpty()) {
                    rememberedValue = EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, startRestartGroup);
                    startRestartGroup.updateRememberedValue(rememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                Modifier anchorSemantics = anchorSemantics(handleGestures(companion, z, basicTooltipState), BasicTooltipStrings.INSTANCE.label(startRestartGroup, 6), z, basicTooltipState, (CoroutineScope) rememberedValue);
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
                MeasurePolicy maybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.getTopStart(), z2);
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1159599143, "CC(Layout)N(content,modifier,measurePolicy)81@3355L27,84@3521L415:Layout.kt#80mrfh");
                int hashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(startRestartGroup, 0));
                CompositionLocalMap currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
                Modifier materializeModifier = ComposedModifierKt.materializeModifier(startRestartGroup, anchorSemantics);
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
                Updater.m4475setimpl(m4467constructorimpl, maybeCachedBoxMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.m4475setimpl(m4467constructorimpl, currentCompositionLocalMap, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                Updater.m4475setimpl(m4467constructorimpl, Integer.valueOf(hashCode), ComposeUiNode.Companion.getSetCompositeKeyHash());
                Updater.m4473reconcileimpl(m4467constructorimpl, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
                Updater.m4475setimpl(m4467constructorimpl, materializeModifier, ComposeUiNode.Companion.getSetModifier());
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
                BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, -821868185, "C154@5886L9:BasicTooltip.kt#71ulvw");
                function2.invoke(startRestartGroup, Integer.valueOf((i3 >> 12) & 14));
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                startRestartGroup.endNode();
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
            final Modifier modifier2 = companion;
            endRestartGroup = startRestartGroup.endRestartGroup();
            if (endRestartGroup == null) {
                endRestartGroup.updateScope(new Function2() { // from class: androidx.compose.foundation.BasicTooltipKt$$ExternalSyntheticLambda1
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return BasicTooltipKt.WrappedAnchor$lambda$1(z, basicTooltipState, z2, modifier2, function2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
                return;
            }
            return;
        }
        companion = modifier;
        if ((i & 24576) == 0) {
        }
        if (startRestartGroup.shouldExecute((i3 & 9363) == 9362, i3 & 1)) {
        }
        final Modifier modifier22 = companion;
        endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup == null) {
        }
    }

    private static final void TooltipPopup(final PopupPositionProvider popupPositionProvider, final BasicTooltipState basicTooltipState, final CoroutineScope coroutineScope, final boolean z, final Function2<? super Composer, ? super Integer, Unit> function2, Composer composer, final int i) {
        Object obj;
        int i2;
        Composer startRestartGroup = composer.startRestartGroup(-1882542163);
        ComposerKt.sourceInformation(startRestartGroup, "C(TooltipPopup)N(positionProvider,state,scope,focusable,content)167@6200L13,170@6302L109,176@6480L251,168@6218L513:BasicTooltip.kt#71ulvw");
        if ((i & 6) == 0) {
            obj = popupPositionProvider;
            i2 = (startRestartGroup.changed(obj) ? 4 : 2) | i;
        } else {
            obj = popupPositionProvider;
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= startRestartGroup.changed(basicTooltipState) ? 32 : 16;
        }
        if ((i & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
            i2 |= startRestartGroup.changedInstance(coroutineScope) ? 256 : 128;
        }
        if ((i & 3072) == 0) {
            i2 |= startRestartGroup.changed(z) ? 2048 : 1024;
        }
        if ((i & 24576) == 0) {
            i2 |= startRestartGroup.changedInstance(function2) ? 16384 : 8192;
        }
        if (!startRestartGroup.shouldExecute((i2 & 9363) != 9362, i2 & 1)) {
            startRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1882542163, i2, -1, "androidx.compose.foundation.TooltipPopup (BasicTooltip.kt:166)");
            }
            final String description = BasicTooltipStrings.INSTANCE.description(startRestartGroup, 6);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -941776166, "CC(remember):BasicTooltip.kt#9igjgp");
            boolean changedInstance = startRestartGroup.changedInstance(coroutineScope) | ((i2 & 112) == 32);
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (changedInstance || rememberedValue == Composer.Companion.getEmpty()) {
                rememberedValue = new Function0() { // from class: androidx.compose.foundation.BasicTooltipKt$$ExternalSyntheticLambda5
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        Unit TooltipPopup$lambda$0$0;
                        TooltipPopup$lambda$0$0 = BasicTooltipKt.TooltipPopup$lambda$0$0(BasicTooltipState.this, coroutineScope);
                        return TooltipPopup$lambda$0$0;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            AndroidPopup_androidKt.Popup(obj, (Function0) rememberedValue, new PopupProperties(z, false, false, false, false, 30, (DefaultConstructorMarker) null), ComposableLambdaKt.rememberComposableLambda(916917707, true, new Function2() { // from class: androidx.compose.foundation.BasicTooltipKt$$ExternalSyntheticLambda6
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj2, Object obj3) {
                    return BasicTooltipKt.TooltipPopup$lambda$1(description, function2, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, startRestartGroup, 54), startRestartGroup, (i2 & 14) | 3072, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: androidx.compose.foundation.BasicTooltipKt$$ExternalSyntheticLambda7
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj2, Object obj3) {
                    return BasicTooltipKt.TooltipPopup$lambda$2(PopupPositionProvider.this, basicTooltipState, coroutineScope, z, function2, i, (Composer) obj2, ((Integer) obj3).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TooltipPopup$lambda$0$0(BasicTooltipState basicTooltipState, CoroutineScope coroutineScope) {
        if (basicTooltipState.isVisible()) {
            BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, null, new BasicTooltipKt$TooltipPopup$1$1$1(basicTooltipState, null), 3, null);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit TooltipPopup$lambda$1(final String str, Function2 function2, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C179@6553L128,177@6490L235:BasicTooltip.kt#71ulvw");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(916917707, i, -1, "androidx.compose.foundation.TooltipPopup.<anonymous> (BasicTooltip.kt:177)");
            }
            Modifier.Companion companion = Modifier.Companion;
            ComposerKt.sourceInformationMarkerStart(composer, 689623211, "CC(remember):BasicTooltip.kt#9igjgp");
            boolean changed = composer.changed(str);
            Object rememberedValue = composer.rememberedValue();
            if (changed || rememberedValue == Composer.Companion.getEmpty()) {
                rememberedValue = new Function1() { // from class: androidx.compose.foundation.BasicTooltipKt$$ExternalSyntheticLambda4
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        Unit TooltipPopup$lambda$1$0$0;
                        TooltipPopup$lambda$1$0$0 = BasicTooltipKt.TooltipPopup$lambda$1$0$0(str, (SemanticsPropertyReceiver) obj);
                        return TooltipPopup$lambda$1$0$0;
                    }
                };
                composer.updateRememberedValue(rememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            Modifier semantics$default = SemanticsModifierKt.semantics$default(companion, false, (Function1) rememberedValue, 1, null);
            ComposerKt.sourceInformationMarkerStart(composer, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
            MeasurePolicy maybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.getTopStart(), false);
            ComposerKt.sourceInformationMarkerStart(composer, -1159599143, "CC(Layout)N(content,modifier,measurePolicy)81@3355L27,84@3521L415:Layout.kt#80mrfh");
            int hashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composer, 0));
            CompositionLocalMap currentCompositionLocalMap = composer.getCurrentCompositionLocalMap();
            Modifier materializeModifier = ComposedModifierKt.materializeModifier(composer, semantics$default);
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
            ComposerKt.sourceInformationMarkerStart(composer, 1506788405, "C184@6706L9:BasicTooltip.kt#71ulvw");
            function2.invoke(composer, 0);
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
    public static final Unit TooltipPopup$lambda$1$0$0(String str, SemanticsPropertyReceiver semanticsPropertyReceiver) {
        SemanticsPropertiesKt.m7396setLiveRegionhR3wRGc(semanticsPropertyReceiver, LiveRegionMode.Companion.m7369getAssertive0phEisY());
        SemanticsPropertiesKt.setPaneTitle(semanticsPropertyReceiver, str);
        return Unit.INSTANCE;
    }

    private static final Modifier handleGestures(Modifier modifier, boolean z, final BasicTooltipState basicTooltipState) {
        return z ? SuspendingPointerInputFilterKt.pointerInput(SuspendingPointerInputFilterKt.pointerInput(modifier, basicTooltipState, new PointerInputEventHandler() { // from class: androidx.compose.foundation.BasicTooltipKt$handleGestures$1

            /* compiled from: BasicTooltip.kt */
            @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
            @DebugMetadata(c = "androidx.compose.foundation.BasicTooltipKt$handleGestures$1$1", f = "BasicTooltip.kt", i = {}, l = {DownloaderService.STATUS_WAITING_FOR_NETWORK}, m = "invokeSuspend", n = {}, s = {}, v = 1)
            /* renamed from: androidx.compose.foundation.BasicTooltipKt$handleGestures$1$1  reason: invalid class name */
            /* loaded from: classes.dex */
            static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                final /* synthetic */ BasicTooltipState $state;
                final /* synthetic */ PointerInputScope $this_pointerInput;
                private /* synthetic */ Object L$0;
                int label;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                AnonymousClass1(PointerInputScope pointerInputScope, BasicTooltipState basicTooltipState, Continuation<? super AnonymousClass1> continuation) {
                    super(2, continuation);
                    this.$this_pointerInput = pointerInputScope;
                    this.$state = basicTooltipState;
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                    AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$this_pointerInput, this.$state, continuation);
                    anonymousClass1.L$0 = obj;
                    return anonymousClass1;
                }

                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                    return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                }

                /* JADX INFO: Access modifiers changed from: package-private */
                /* compiled from: BasicTooltip.kt */
                @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
                @DebugMetadata(c = "androidx.compose.foundation.BasicTooltipKt$handleGestures$1$1$1", f = "BasicTooltip.kt", i = {0, 0, 1, 1}, l = {199, ComposerKt.compositionLocalMapKey, 208}, m = "invokeSuspend", n = {"$this$awaitEachGesture", "pass", "$this$awaitEachGesture", "pass"}, s = {"L$0", "L$1", "L$0", "L$1"}, v = 1)
                /* renamed from: androidx.compose.foundation.BasicTooltipKt$handleGestures$1$1$1  reason: invalid class name and collision with other inner class name */
                /* loaded from: classes.dex */
                public static final class C00011 extends RestrictedSuspendLambda implements Function2<AwaitPointerEventScope, Continuation<? super Unit>, Object> {
                    final /* synthetic */ CoroutineScope $$this$coroutineScope;
                    final /* synthetic */ BasicTooltipState $state;
                    private /* synthetic */ Object L$0;
                    Object L$1;
                    int label;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    C00011(CoroutineScope coroutineScope, BasicTooltipState basicTooltipState, Continuation<? super C00011> continuation) {
                        super(2, continuation);
                        this.$$this$coroutineScope = coroutineScope;
                        this.$state = basicTooltipState;
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                        C00011 c00011 = new C00011(this.$$this$coroutineScope, this.$state, continuation);
                        c00011.L$0 = obj;
                        return c00011;
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(AwaitPointerEventScope awaitPointerEventScope, Continuation<? super Unit> continuation) {
                        return ((C00011) create(awaitPointerEventScope, continuation)).invokeSuspend(Unit.INSTANCE);
                    }

                    /* JADX WARN: Code restructure failed: missing block: B:27:0x00ab, code lost:
                        if (r12 == r0) goto L21;
                     */
                    /* JADX WARN: Removed duplicated region for block: B:26:0x008a  */
                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    /*
                        Code decompiled incorrectly, please refer to instructions dump.
                    */
                    public final Object invokeSuspend(Object obj) {
                        AwaitPointerEventScope awaitPointerEventScope;
                        PointerEventPass pointerEventPass;
                        AwaitPointerEventScope awaitPointerEventScope2;
                        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                        int i = this.label;
                        if (i == 0) {
                            ResultKt.throwOnFailure(obj);
                            AwaitPointerEventScope awaitPointerEventScope3 = (AwaitPointerEventScope) this.L$0;
                            PointerEventPass pointerEventPass2 = PointerEventPass.Initial;
                            this.L$0 = awaitPointerEventScope3;
                            this.L$1 = pointerEventPass2;
                            this.label = 1;
                            obj = TapGestureDetectorKt.awaitFirstDown$default(awaitPointerEventScope3, false, pointerEventPass2, this, 1, null);
                            if (obj != coroutine_suspended) {
                                awaitPointerEventScope = awaitPointerEventScope3;
                                pointerEventPass = pointerEventPass2;
                            }
                            return coroutine_suspended;
                        } else if (i != 1) {
                            if (i != 2) {
                                if (i == 3) {
                                    ResultKt.throwOnFailure(obj);
                                    List<PointerInputChange> changes = ((PointerEvent) obj).getChanges();
                                    int size = changes.size();
                                    for (int i2 = 0; i2 < size; i2++) {
                                        changes.get(i2).consume();
                                    }
                                    return Unit.INSTANCE;
                                }
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            }
                            pointerEventPass = (PointerEventPass) this.L$1;
                            awaitPointerEventScope2 = (AwaitPointerEventScope) this.L$0;
                            ResultKt.throwOnFailure(obj);
                            if (((LongPressResult) obj) instanceof LongPressResult.Success) {
                                BuildersKt__Builders_commonKt.launch$default(this.$$this$coroutineScope, null, null, new C00021(this.$state, null), 3, null);
                                this.L$0 = null;
                                this.L$1 = null;
                                this.label = 3;
                                obj = awaitPointerEventScope2.awaitPointerEvent(pointerEventPass, this);
                            }
                            return Unit.INSTANCE;
                        } else {
                            pointerEventPass = (PointerEventPass) this.L$1;
                            awaitPointerEventScope = (AwaitPointerEventScope) this.L$0;
                            ResultKt.throwOnFailure(obj);
                        }
                        int m6688getTypeT8wyACA = ((PointerInputChange) obj).m6688getTypeT8wyACA();
                        if (PointerType.m6758equalsimpl0(m6688getTypeT8wyACA, PointerType.Companion.m6765getTouchT8wyACA()) || PointerType.m6758equalsimpl0(m6688getTypeT8wyACA, PointerType.Companion.m6764getStylusT8wyACA())) {
                            this.L$0 = awaitPointerEventScope;
                            this.L$1 = pointerEventPass;
                            this.label = 2;
                            obj = TapGestureDetectorKt.waitForLongPress(awaitPointerEventScope, pointerEventPass, this);
                            if (obj != coroutine_suspended) {
                                awaitPointerEventScope2 = awaitPointerEventScope;
                                if (((LongPressResult) obj) instanceof LongPressResult.Success) {
                                }
                            }
                            return coroutine_suspended;
                        }
                        return Unit.INSTANCE;
                    }

                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* compiled from: BasicTooltip.kt */
                    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
                    @DebugMetadata(c = "androidx.compose.foundation.BasicTooltipKt$handleGestures$1$1$1$1", f = "BasicTooltip.kt", i = {}, l = {205}, m = "invokeSuspend", n = {}, s = {}, v = 1)
                    /* renamed from: androidx.compose.foundation.BasicTooltipKt$handleGestures$1$1$1$1  reason: invalid class name and collision with other inner class name */
                    /* loaded from: classes.dex */
                    public static final class C00021 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                        final /* synthetic */ BasicTooltipState $state;
                        int label;

                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        C00021(BasicTooltipState basicTooltipState, Continuation<? super C00021> continuation) {
                            super(2, continuation);
                            this.$state = basicTooltipState;
                        }

                        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                            return new C00021(this.$state, continuation);
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                            return ((C00021) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                        }

                        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                        public final Object invokeSuspend(Object obj) {
                            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                            int i = this.label;
                            if (i == 0) {
                                ResultKt.throwOnFailure(obj);
                                this.label = 1;
                                if (this.$state.show(MutatePriority.UserInput, this) == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                            } else if (i != 1) {
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            } else {
                                ResultKt.throwOnFailure(obj);
                            }
                            return Unit.INSTANCE;
                        }
                    }
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Object invokeSuspend(Object obj) {
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    int i = this.label;
                    if (i == 0) {
                        ResultKt.throwOnFailure(obj);
                        this.label = 1;
                        if (ForEachGestureKt.awaitEachGesture(this.$this_pointerInput, new C00011((CoroutineScope) this.L$0, this.$state, null), this) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    } else if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    } else {
                        ResultKt.throwOnFailure(obj);
                    }
                    return Unit.INSTANCE;
                }
            }

            @Override // androidx.compose.ui.input.pointer.PointerInputEventHandler
            public final Object invoke(PointerInputScope pointerInputScope, Continuation<? super Unit> continuation) {
                Object coroutineScope = CoroutineScopeKt.coroutineScope(new AnonymousClass1(pointerInputScope, BasicTooltipState.this, null), continuation);
                return coroutineScope == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? coroutineScope : Unit.INSTANCE;
            }
        }), basicTooltipState, new PointerInputEventHandler() { // from class: androidx.compose.foundation.BasicTooltipKt$handleGestures$2

            /* compiled from: BasicTooltip.kt */
            @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
            @DebugMetadata(c = "androidx.compose.foundation.BasicTooltipKt$handleGestures$2$1", f = "BasicTooltip.kt", i = {}, l = {219}, m = "invokeSuspend", n = {}, s = {}, v = 1)
            /* renamed from: androidx.compose.foundation.BasicTooltipKt$handleGestures$2$1  reason: invalid class name */
            /* loaded from: classes.dex */
            static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                final /* synthetic */ BasicTooltipState $state;
                final /* synthetic */ PointerInputScope $this_pointerInput;
                private /* synthetic */ Object L$0;
                int label;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                AnonymousClass1(PointerInputScope pointerInputScope, BasicTooltipState basicTooltipState, Continuation<? super AnonymousClass1> continuation) {
                    super(2, continuation);
                    this.$this_pointerInput = pointerInputScope;
                    this.$state = basicTooltipState;
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                    AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$this_pointerInput, this.$state, continuation);
                    anonymousClass1.L$0 = obj;
                    return anonymousClass1;
                }

                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                    return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                }

                /* JADX INFO: Access modifiers changed from: package-private */
                /* compiled from: BasicTooltip.kt */
                @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
                @DebugMetadata(c = "androidx.compose.foundation.BasicTooltipKt$handleGestures$2$1$1", f = "BasicTooltip.kt", i = {0, 0}, l = {223}, m = "invokeSuspend", n = {"$this$awaitPointerEventScope", "pass"}, s = {"L$0", "L$1"}, v = 1)
                /* renamed from: androidx.compose.foundation.BasicTooltipKt$handleGestures$2$1$1  reason: invalid class name and collision with other inner class name */
                /* loaded from: classes.dex */
                public static final class C00031 extends RestrictedSuspendLambda implements Function2<AwaitPointerEventScope, Continuation<? super Unit>, Object> {
                    final /* synthetic */ CoroutineScope $$this$coroutineScope;
                    final /* synthetic */ BasicTooltipState $state;
                    private /* synthetic */ Object L$0;
                    Object L$1;
                    int label;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    C00031(CoroutineScope coroutineScope, BasicTooltipState basicTooltipState, Continuation<? super C00031> continuation) {
                        super(2, continuation);
                        this.$$this$coroutineScope = coroutineScope;
                        this.$state = basicTooltipState;
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                        C00031 c00031 = new C00031(this.$$this$coroutineScope, this.$state, continuation);
                        c00031.L$0 = obj;
                        return c00031;
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(AwaitPointerEventScope awaitPointerEventScope, Continuation<? super Unit> continuation) {
                        return ((C00031) create(awaitPointerEventScope, continuation)).invokeSuspend(Unit.INSTANCE);
                    }

                    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
                        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached
                        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:56)
                        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:30)
                        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:18)
                        */
                    /* JADX WARN: Removed duplicated region for block: B:11:0x0038 A[RETURN] */
                    /* JADX WARN: Removed duplicated region for block: B:14:0x0056  */
                    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0036 -> B:12:0x0039). Please submit an issue!!! */
                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    /*
                        Code decompiled incorrectly, please refer to instructions dump.
                    */
                    public final java.lang.Object invokeSuspend(java.lang.Object r12) {
                        /*
                            r11 = this;
                            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                            int r1 = r11.label
                            r2 = 1
                            if (r1 == 0) goto L1f
                            if (r1 != r2) goto L17
                            java.lang.Object r1 = r11.L$1
                            androidx.compose.ui.input.pointer.PointerEventPass r1 = (androidx.compose.ui.input.pointer.PointerEventPass) r1
                            java.lang.Object r3 = r11.L$0
                            androidx.compose.ui.input.pointer.AwaitPointerEventScope r3 = (androidx.compose.ui.input.pointer.AwaitPointerEventScope) r3
                            kotlin.ResultKt.throwOnFailure(r12)
                            goto L39
                        L17:
                            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
                            java.lang.String r12 = "call to 'resume' before 'invoke' with coroutine"
                            r11.<init>(r12)
                            throw r11
                        L1f:
                            kotlin.ResultKt.throwOnFailure(r12)
                            java.lang.Object r12 = r11.L$0
                            androidx.compose.ui.input.pointer.AwaitPointerEventScope r12 = (androidx.compose.ui.input.pointer.AwaitPointerEventScope) r12
                            androidx.compose.ui.input.pointer.PointerEventPass r1 = androidx.compose.ui.input.pointer.PointerEventPass.Main
                            r3 = r12
                        L29:
                            r12 = r11
                            kotlin.coroutines.Continuation r12 = (kotlin.coroutines.Continuation) r12
                            r11.L$0 = r3
                            r11.L$1 = r1
                            r11.label = r2
                            java.lang.Object r12 = r3.awaitPointerEvent(r1, r12)
                            if (r12 != r0) goto L39
                            return r0
                        L39:
                            androidx.compose.ui.input.pointer.PointerEvent r12 = (androidx.compose.ui.input.pointer.PointerEvent) r12
                            java.util.List r4 = r12.getChanges()
                            r5 = 0
                            java.lang.Object r4 = r4.get(r5)
                            androidx.compose.ui.input.pointer.PointerInputChange r4 = (androidx.compose.ui.input.pointer.PointerInputChange) r4
                            int r4 = r4.m6688getTypeT8wyACA()
                            androidx.compose.ui.input.pointer.PointerType$Companion r5 = androidx.compose.ui.input.pointer.PointerType.Companion
                            int r5 = r5.m6763getMouseT8wyACA()
                            boolean r4 = androidx.compose.ui.input.pointer.PointerType.m6758equalsimpl0(r4, r5)
                            if (r4 == 0) goto L29
                            int r12 = r12.m6618getType7fucELk()
                            androidx.compose.ui.input.pointer.PointerEventType$Companion r4 = androidx.compose.ui.input.pointer.PointerEventType.Companion
                            int r4 = r4.m6629getEnter7fucELk()
                            boolean r4 = androidx.compose.ui.input.pointer.PointerEventType.m6625equalsimpl0(r12, r4)
                            if (r4 == 0) goto L7a
                            kotlinx.coroutines.CoroutineScope r5 = r11.$$this$coroutineScope
                            androidx.compose.foundation.BasicTooltipKt$handleGestures$2$1$1$1 r12 = new androidx.compose.foundation.BasicTooltipKt$handleGestures$2$1$1$1
                            androidx.compose.foundation.BasicTooltipState r4 = r11.$state
                            r6 = 0
                            r12.<init>(r4, r6)
                            r8 = r12
                            kotlin.jvm.functions.Function2 r8 = (kotlin.jvm.functions.Function2) r8
                            r9 = 3
                            r10 = 0
                            r7 = 0
                            kotlinx.coroutines.BuildersKt.launch$default(r5, r6, r7, r8, r9, r10)
                            goto L29
                        L7a:
                            androidx.compose.ui.input.pointer.PointerEventType$Companion r4 = androidx.compose.ui.input.pointer.PointerEventType.Companion
                            int r4 = r4.m6630getExit7fucELk()
                            boolean r12 = androidx.compose.ui.input.pointer.PointerEventType.m6625equalsimpl0(r12, r4)
                            if (r12 == 0) goto L29
                            androidx.compose.foundation.BasicTooltipState r12 = r11.$state
                            r12.dismiss()
                            goto L29
                        */
                        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.BasicTooltipKt$handleGestures$2.AnonymousClass1.C00031.invokeSuspend(java.lang.Object):java.lang.Object");
                    }

                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* compiled from: BasicTooltip.kt */
                    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
                    @DebugMetadata(c = "androidx.compose.foundation.BasicTooltipKt$handleGestures$2$1$1$1", f = "BasicTooltip.kt", i = {}, l = {228}, m = "invokeSuspend", n = {}, s = {}, v = 1)
                    /* renamed from: androidx.compose.foundation.BasicTooltipKt$handleGestures$2$1$1$1  reason: invalid class name and collision with other inner class name */
                    /* loaded from: classes.dex */
                    public static final class C00041 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                        final /* synthetic */ BasicTooltipState $state;
                        int label;

                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        C00041(BasicTooltipState basicTooltipState, Continuation<? super C00041> continuation) {
                            super(2, continuation);
                            this.$state = basicTooltipState;
                        }

                        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                            return new C00041(this.$state, continuation);
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                            return ((C00041) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                        }

                        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                        public final Object invokeSuspend(Object obj) {
                            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                            int i = this.label;
                            if (i == 0) {
                                ResultKt.throwOnFailure(obj);
                                this.label = 1;
                                if (this.$state.show(MutatePriority.UserInput, this) == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                            } else if (i != 1) {
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            } else {
                                ResultKt.throwOnFailure(obj);
                            }
                            return Unit.INSTANCE;
                        }
                    }
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Object invokeSuspend(Object obj) {
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    int i = this.label;
                    if (i == 0) {
                        ResultKt.throwOnFailure(obj);
                        this.label = 1;
                        if (this.$this_pointerInput.awaitPointerEventScope(new C00031((CoroutineScope) this.L$0, this.$state, null), this) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    } else if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    } else {
                        ResultKt.throwOnFailure(obj);
                    }
                    return Unit.INSTANCE;
                }
            }

            @Override // androidx.compose.ui.input.pointer.PointerInputEventHandler
            public final Object invoke(PointerInputScope pointerInputScope, Continuation<? super Unit> continuation) {
                Object coroutineScope = CoroutineScopeKt.coroutineScope(new AnonymousClass1(pointerInputScope, BasicTooltipState.this, null), continuation);
                return coroutineScope == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? coroutineScope : Unit.INSTANCE;
            }
        }) : modifier;
    }

    private static final Modifier anchorSemantics(Modifier modifier, final String str, boolean z, final BasicTooltipState basicTooltipState, final CoroutineScope coroutineScope) {
        return z ? SemanticsModifierKt.semantics(modifier, true, new Function1() { // from class: androidx.compose.foundation.BasicTooltipKt$$ExternalSyntheticLambda10
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return BasicTooltipKt.anchorSemantics$lambda$0(str, coroutineScope, basicTooltipState, (SemanticsPropertyReceiver) obj);
            }
        }) : modifier;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit anchorSemantics$lambda$0(String str, final CoroutineScope coroutineScope, final BasicTooltipState basicTooltipState, SemanticsPropertyReceiver semanticsPropertyReceiver) {
        SemanticsPropertiesKt.onLongClick(semanticsPropertyReceiver, str, new Function0() { // from class: androidx.compose.foundation.BasicTooltipKt$$ExternalSyntheticLambda8
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                boolean anchorSemantics$lambda$0$0;
                anchorSemantics$lambda$0$0 = BasicTooltipKt.anchorSemantics$lambda$0$0(CoroutineScope.this, basicTooltipState);
                return Boolean.valueOf(anchorSemantics$lambda$0$0);
            }
        });
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean anchorSemantics$lambda$0$0(CoroutineScope coroutineScope, BasicTooltipState basicTooltipState) {
        BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, null, new BasicTooltipKt$anchorSemantics$1$1$1(basicTooltipState, null), 3, null);
        return true;
    }

    public static final BasicTooltipState rememberBasicTooltipState(boolean z, boolean z2, MutatorMutex mutatorMutex, Composer composer, int i, int i2) {
        ComposerKt.sourceInformationMarkerStart(composer, 1123859613, "C(rememberBasicTooltipState)N(initialIsVisible,isPersistent,mutatorMutex)278@10497L216:BasicTooltip.kt#71ulvw");
        if ((i2 & 1) != 0) {
            z = false;
        }
        if ((i2 & 2) != 0) {
            z2 = true;
        }
        if ((i2 & 4) != 0) {
            mutatorMutex = BasicTooltipDefaults.INSTANCE.getGlobalMutatorMutex();
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1123859613, i, -1, "androidx.compose.foundation.rememberBasicTooltipState (BasicTooltip.kt:278)");
        }
        ComposerKt.sourceInformationMarkerStart(composer, 1992303573, "CC(remember):BasicTooltip.kt#9igjgp");
        boolean z3 = ((((i & 112) ^ 48) > 32 && composer.changed(z2)) || (i & 48) == 32) | ((((i & 896) ^ RendererCapabilities.DECODER_SUPPORT_MASK) > 256 && composer.changed(mutatorMutex)) || (i & RendererCapabilities.DECODER_SUPPORT_MASK) == 256);
        Object rememberedValue = composer.rememberedValue();
        if (z3 || rememberedValue == Composer.Companion.getEmpty()) {
            rememberedValue = new BasicTooltipStateImpl(z, z2, mutatorMutex);
            composer.updateRememberedValue(rememberedValue);
        }
        BasicTooltipStateImpl basicTooltipStateImpl = (BasicTooltipStateImpl) rememberedValue;
        ComposerKt.sourceInformationMarkerEnd(composer);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return basicTooltipStateImpl;
    }

    public static /* synthetic */ BasicTooltipState BasicTooltipState$default(boolean z, boolean z2, MutatorMutex mutatorMutex, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        if ((i & 2) != 0) {
            z2 = true;
        }
        if ((i & 4) != 0) {
            mutatorMutex = BasicTooltipDefaults.INSTANCE.getGlobalMutatorMutex();
        }
        return BasicTooltipState(z, z2, mutatorMutex);
    }

    public static final BasicTooltipState BasicTooltipState(boolean z, boolean z2, MutatorMutex mutatorMutex) {
        return new BasicTooltipStateImpl(z, z2, mutatorMutex);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final DisposableEffectResult BasicTooltipBox$lambda$1$0(final BasicTooltipState basicTooltipState, DisposableEffectScope disposableEffectScope) {
        return new DisposableEffectResult() { // from class: androidx.compose.foundation.BasicTooltipKt$BasicTooltipBox$lambda$1$0$$inlined$onDispose$1
            @Override // androidx.compose.runtime.DisposableEffectResult
            public void dispose() {
                BasicTooltipState.this.onDispose();
            }
        };
    }
}
