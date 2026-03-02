package androidx.compose.material3.internal;

import android.view.View;
import androidx.compose.material3.ContentColorKt;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionContext;
import androidx.compose.runtime.DisposableEffectResult;
import androidx.compose.runtime.DisposableEffectScope;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.runtime.saveable.RememberSaveableKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.compose.ui.window.DialogProperties;
import androidx.compose.ui.window.SecureFlagPolicy;
import androidx.media3.exoplayer.RendererCapabilities;
import androidx.profileinstaller.ProfileVerifier;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
/* compiled from: BasicEdgeToEdgeDialog.android.kt */
@Metadata(d1 = {"\u0000:\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a\\\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\t2\u0017\u0010\u000b\u001a\u0013\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u00010\f¢\u0006\u0002\b\u000eH\u0001¢\u0006\u0002\u0010\u000f\u001a\u0014\u0010\u0010\u001a\u00020\t*\u00020\u00112\u0006\u0010\u0012\u001a\u00020\tH\u0000¨\u0006\u0013²\u0006\u001b\u0010\u0014\u001a\u0013\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u00010\f¢\u0006\u0002\b\u000eX\u008a\u0084\u0002²\u0006\u0010\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00010\u0003X\u008a\u0084\u0002²\u0006\n\u0010\u0016\u001a\u00020\tX\u008a\u0084\u0002"}, d2 = {"BasicEdgeToEdgeDialog", "", "onDismissRequest", "Lkotlin/Function0;", "modifier", "Landroidx/compose/ui/Modifier;", "properties", "Landroidx/compose/ui/window/DialogProperties;", "lightStatusBars", "", "lightNavigationBars", FirebaseAnalytics.Param.CONTENT, "Lkotlin/Function1;", "Landroidx/compose/material3/internal/PredictiveBackState;", "Landroidx/compose/runtime/Composable;", "(Lkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;Landroidx/compose/ui/window/DialogProperties;ZZLkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "shouldApplySecureFlag", "Landroidx/compose/ui/window/SecureFlagPolicy;", "isSecureFlagSetOnParent", "material3", "currentContent", "currentOnDismissRequest", "currentDismissOnBackPress"}, k = 2, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public final class BasicEdgeToEdgeDialog_androidKt {

    /* compiled from: BasicEdgeToEdgeDialog.android.kt */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    /* loaded from: classes.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[SecureFlagPolicy.values().length];
            try {
                iArr[SecureFlagPolicy.SecureOff.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[SecureFlagPolicy.SecureOn.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[SecureFlagPolicy.Inherit.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit BasicEdgeToEdgeDialog$lambda$12(Function0 function0, Modifier modifier, DialogProperties dialogProperties, boolean z, boolean z2, Function3 function3, int i, int i2, Composer composer, int i3) {
        BasicEdgeToEdgeDialog(function0, modifier, dialogProperties, z, z2, function3, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Removed duplicated region for block: B:158:0x0307  */
    /* JADX WARN: Removed duplicated region for block: B:161:0x0314  */
    /* JADX WARN: Removed duplicated region for block: B:163:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x004b  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x004e  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0067  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x007c  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0082  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0098  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00a0  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00a3  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00bf  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00c1  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x00ca  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void BasicEdgeToEdgeDialog(final Function0<Unit> function0, Modifier modifier, DialogProperties dialogProperties, boolean z, boolean z2, final Function3<? super PredictiveBackState, ? super Composer, ? super Integer, Unit> function3, Composer composer, final int i, final int i2) {
        int i3;
        Object obj;
        int i4;
        Object obj2;
        boolean z3;
        boolean z4;
        final Modifier modifier2;
        final DialogProperties dialogProperties2;
        ScopeUpdateScope endRestartGroup;
        Modifier modifier3;
        int i5;
        DialogProperties dialogProperties3;
        DialogProperties dialogProperties4;
        int i6;
        boolean z5;
        DialogWrapper dialogWrapper;
        int i7;
        int i8;
        Composer startRestartGroup = composer.startRestartGroup(814581409);
        ComposerKt.sourceInformation(startRestartGroup, "C(BasicEdgeToEdgeDialog)N(onDismissRequest,modifier,properties,lightStatusBars,lightNavigationBars,content)91@3820L7,92@3859L7,93@3914L7,94@3944L28,95@4009L21,95@3992L38,97@4058L29,98@4123L38,99@4199L51,102@4277L1031,128@5339L129,128@5314L154,137@5485L285,137@5474L296:BasicEdgeToEdgeDialog.android.kt#mqatfk");
        if ((i2 & 1) != 0) {
            i3 = i | 6;
        } else if ((i & 6) == 0) {
            i3 = (startRestartGroup.changedInstance(function0) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        int i9 = i2 & 2;
        if (i9 != 0) {
            i3 |= 48;
        } else if ((i & 48) == 0) {
            obj = modifier;
            i3 |= startRestartGroup.changed(obj) ? 32 : 16;
            i4 = i2 & 4;
            if (i4 == 0) {
                i3 |= RendererCapabilities.DECODER_SUPPORT_MASK;
            } else if ((i & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
                obj2 = dialogProperties;
                i3 |= startRestartGroup.changed(obj2) ? 256 : 128;
                if ((i & 3072) == 0) {
                    if ((i2 & 8) == 0) {
                        z3 = z;
                        if (startRestartGroup.changed(z3)) {
                            i8 = 2048;
                            i3 |= i8;
                        }
                    } else {
                        z3 = z;
                    }
                    i8 = 1024;
                    i3 |= i8;
                } else {
                    z3 = z;
                }
                if ((i & 24576) == 0) {
                    if ((i2 & 16) == 0) {
                        z4 = z2;
                        if (startRestartGroup.changed(z4)) {
                            i7 = 16384;
                            i3 |= i7;
                        }
                    } else {
                        z4 = z2;
                    }
                    i7 = 8192;
                    i3 |= i7;
                } else {
                    z4 = z2;
                }
                if ((i2 & 32) != 0) {
                    i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                } else if ((i & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                    i3 |= startRestartGroup.changedInstance(function3) ? 131072 : 65536;
                }
                if (startRestartGroup.shouldExecute((i3 & 74899) != 74898, i3 & 1)) {
                    startRestartGroup.startDefaults();
                    ComposerKt.sourceInformation(startRestartGroup, "37@1426L7,39@1507L7");
                    if ((i & 1) == 0 || startRestartGroup.getDefaultsInvalid()) {
                        Modifier.Companion companion = i9 != 0 ? Modifier.Companion : obj;
                        DialogProperties dialogProperties5 = i4 != 0 ? new DialogProperties(false, false, false, 7, (DefaultConstructorMarker) null) : obj2;
                        if ((i2 & 8) != 0) {
                            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                            Object consume = startRestartGroup.consume(ContentColorKt.getLocalContentColor());
                            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                            i3 &= -7169;
                            z3 = ColorKt.m4824luminance8_81llA(((Color) consume).m4782unboximpl()) < 0.5f;
                        }
                        if ((i2 & 16) != 0) {
                            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                            Object consume2 = startRestartGroup.consume(ContentColorKt.getLocalContentColor());
                            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                            i3 &= -57345;
                            modifier3 = companion;
                            z4 = ColorKt.m4824luminance8_81llA(((Color) consume2).m4782unboximpl()) < 0.5f;
                        } else {
                            modifier3 = companion;
                        }
                        i5 = i3;
                        dialogProperties3 = dialogProperties5;
                    } else {
                        startRestartGroup.skipToGroupEnd();
                        if ((i2 & 8) != 0) {
                            i3 &= -7169;
                        }
                        if ((i2 & 16) != 0) {
                            i3 &= -57345;
                        }
                        i5 = i3;
                        modifier3 = obj;
                        dialogProperties3 = obj2;
                    }
                    startRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(814581409, i5, -1, "androidx.compose.material3.internal.BasicEdgeToEdgeDialog (BasicEdgeToEdgeDialog.android.kt:90)");
                    }
                    ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                    Object consume3 = startRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalView());
                    ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                    View view = (View) consume3;
                    ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                    Object consume4 = startRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
                    ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                    Density density = (Density) consume4;
                    ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                    Object consume5 = startRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection());
                    ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                    final LayoutDirection layoutDirection = (LayoutDirection) consume5;
                    CompositionContext rememberCompositionContext = ComposablesKt.rememberCompositionContext(startRestartGroup, 0);
                    Object[] objArr = new Object[0];
                    ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1128701718, "CC(remember):BasicEdgeToEdgeDialog.android.kt#9igjgp");
                    Object rememberedValue = startRestartGroup.rememberedValue();
                    DialogProperties dialogProperties6 = dialogProperties3;
                    if (rememberedValue == Composer.Companion.getEmpty()) {
                        rememberedValue = new Function0() { // from class: androidx.compose.material3.internal.BasicEdgeToEdgeDialog_androidKt$$ExternalSyntheticLambda0
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                UUID randomUUID;
                                randomUUID = UUID.randomUUID();
                                return randomUUID;
                            }
                        };
                        startRestartGroup.updateRememberedValue(rememberedValue);
                    }
                    ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                    UUID uuid = (UUID) RememberSaveableKt.rememberSaveable(objArr, (Function0) rememberedValue, startRestartGroup, 48);
                    State rememberUpdatedState = SnapshotStateKt.rememberUpdatedState(function3, startRestartGroup, (i5 >> 15) & 14);
                    int i10 = i5 & 14;
                    State rememberUpdatedState2 = SnapshotStateKt.rememberUpdatedState(function0, startRestartGroup, i10);
                    State rememberUpdatedState3 = SnapshotStateKt.rememberUpdatedState(Boolean.valueOf(dialogProperties6.getDismissOnBackPress()), startRestartGroup, 0);
                    ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1128711304, "CC(remember):BasicEdgeToEdgeDialog.android.kt#9igjgp");
                    boolean changed = startRestartGroup.changed(view) | startRestartGroup.changed(density);
                    Object rememberedValue2 = startRestartGroup.rememberedValue();
                    if (changed || rememberedValue2 == Composer.Companion.getEmpty()) {
                        dialogProperties4 = dialogProperties6;
                        i6 = i5;
                        DialogWrapper dialogWrapper2 = new DialogWrapper(function0, dialogProperties4, view, layoutDirection, density, uuid, z3, z4);
                        z5 = true;
                        dialogWrapper2.setContent(rememberCompositionContext, ComposableLambdaKt.composableLambdaInstance(-635938462, true, new BasicEdgeToEdgeDialog_androidKt$BasicEdgeToEdgeDialog$dialog$1$1$1(modifier3, rememberUpdatedState3, rememberUpdatedState2, rememberUpdatedState)));
                        startRestartGroup.updateRememberedValue(dialogWrapper2);
                        dialogWrapper = dialogWrapper2;
                    } else {
                        dialogProperties4 = dialogProperties6;
                        i6 = i5;
                        z5 = true;
                        dialogWrapper = rememberedValue2;
                    }
                    final DialogWrapper dialogWrapper3 = (DialogWrapper) dialogWrapper;
                    ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                    ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1128744386, "CC(remember):BasicEdgeToEdgeDialog.android.kt#9igjgp");
                    boolean changedInstance = startRestartGroup.changedInstance(dialogWrapper3);
                    Object rememberedValue3 = startRestartGroup.rememberedValue();
                    if (changedInstance || rememberedValue3 == Composer.Companion.getEmpty()) {
                        rememberedValue3 = new Function1() { // from class: androidx.compose.material3.internal.BasicEdgeToEdgeDialog_androidKt$$ExternalSyntheticLambda1
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj3) {
                                return BasicEdgeToEdgeDialog_androidKt.BasicEdgeToEdgeDialog$lambda$9$lambda$8(DialogWrapper.this, (DisposableEffectScope) obj3);
                            }
                        };
                        startRestartGroup.updateRememberedValue(rememberedValue3);
                    }
                    ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                    EffectsKt.DisposableEffect(dialogWrapper3, (Function1) rememberedValue3, startRestartGroup, 0);
                    ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1128749214, "CC(remember):BasicEdgeToEdgeDialog.android.kt#9igjgp");
                    int i11 = i6;
                    boolean changedInstance2 = startRestartGroup.changedInstance(dialogWrapper3) | (i10 == 4 ? z5 : false) | ((i11 & 896) == 256 ? z5 : false) | startRestartGroup.changed(layoutDirection.ordinal()) | (((((i11 & 7168) ^ 3072) <= 2048 || !startRestartGroup.changed(z3)) && (i11 & 3072) != 2048) ? false : z5) | (((((57344 & i11) ^ 24576) <= 16384 || !startRestartGroup.changed(z4)) && (i11 & 24576) != 16384) ? false : z5);
                    Object rememberedValue4 = startRestartGroup.rememberedValue();
                    if (changedInstance2 || rememberedValue4 == Composer.Companion.getEmpty()) {
                        final DialogProperties dialogProperties7 = dialogProperties4;
                        final boolean z6 = z3;
                        final boolean z7 = z4;
                        Function0 function02 = new Function0() { // from class: androidx.compose.material3.internal.BasicEdgeToEdgeDialog_androidKt$$ExternalSyntheticLambda2
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return BasicEdgeToEdgeDialog_androidKt.BasicEdgeToEdgeDialog$lambda$11$lambda$10(DialogWrapper.this, function0, dialogProperties7, layoutDirection, z6, z7);
                            }
                        };
                        dialogProperties4 = dialogProperties7;
                        startRestartGroup.updateRememberedValue(function02);
                        rememberedValue4 = function02;
                    }
                    ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                    EffectsKt.SideEffect((Function0) rememberedValue4, startRestartGroup, 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    dialogProperties2 = dialogProperties4;
                    modifier2 = modifier3;
                } else {
                    startRestartGroup.skipToGroupEnd();
                    modifier2 = obj;
                    dialogProperties2 = obj2;
                }
                final boolean z8 = z3;
                final boolean z9 = z4;
                endRestartGroup = startRestartGroup.endRestartGroup();
                if (endRestartGroup != null) {
                    endRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.internal.BasicEdgeToEdgeDialog_androidKt$$ExternalSyntheticLambda3
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj3, Object obj4) {
                            return BasicEdgeToEdgeDialog_androidKt.BasicEdgeToEdgeDialog$lambda$12(Function0.this, modifier2, dialogProperties2, z8, z9, function3, i, i2, (Composer) obj3, ((Integer) obj4).intValue());
                        }
                    });
                    return;
                }
                return;
            }
            obj2 = dialogProperties;
            if ((i & 3072) == 0) {
            }
            if ((i & 24576) == 0) {
            }
            if ((i2 & 32) != 0) {
            }
            if (startRestartGroup.shouldExecute((i3 & 74899) != 74898, i3 & 1)) {
            }
            final boolean z82 = z3;
            final boolean z92 = z4;
            endRestartGroup = startRestartGroup.endRestartGroup();
            if (endRestartGroup != null) {
            }
        }
        obj = modifier;
        i4 = i2 & 4;
        if (i4 == 0) {
        }
        obj2 = dialogProperties;
        if ((i & 3072) == 0) {
        }
        if ((i & 24576) == 0) {
        }
        if ((i2 & 32) != 0) {
        }
        if (startRestartGroup.shouldExecute((i3 & 74899) != 74898, i3 & 1)) {
        }
        final boolean z822 = z3;
        final boolean z922 = z4;
        endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final DisposableEffectResult BasicEdgeToEdgeDialog$lambda$9$lambda$8(final DialogWrapper dialogWrapper, DisposableEffectScope disposableEffectScope) {
        dialogWrapper.show();
        return new DisposableEffectResult() { // from class: androidx.compose.material3.internal.BasicEdgeToEdgeDialog_androidKt$BasicEdgeToEdgeDialog$lambda$9$lambda$8$$inlined$onDispose$1
            @Override // androidx.compose.runtime.DisposableEffectResult
            public void dispose() {
                DialogWrapper.this.dismiss();
                DialogWrapper.this.disposeComposition();
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit BasicEdgeToEdgeDialog$lambda$11$lambda$10(DialogWrapper dialogWrapper, Function0 function0, DialogProperties dialogProperties, LayoutDirection layoutDirection, boolean z, boolean z2) {
        dialogWrapper.updateParameters(function0, dialogProperties, layoutDirection, z, z2);
        return Unit.INSTANCE;
    }

    public static final boolean shouldApplySecureFlag(SecureFlagPolicy secureFlagPolicy, boolean z) {
        int i = WhenMappings.$EnumSwitchMapping$0[secureFlagPolicy.ordinal()];
        if (i != 1) {
            if (i != 2) {
                if (i == 3) {
                    return z;
                }
                throw new NoWhenBranchMatchedException();
            }
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Function3<PredictiveBackState, Composer, Integer, Unit> BasicEdgeToEdgeDialog$lambda$2(State<? extends Function3<? super PredictiveBackState, ? super Composer, ? super Integer, Unit>> state) {
        return (Function3) state.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Function0<Unit> BasicEdgeToEdgeDialog$lambda$3(State<? extends Function0<Unit>> state) {
        return state.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean BasicEdgeToEdgeDialog$lambda$4(State<Boolean> state) {
        return state.getValue().booleanValue();
    }
}
