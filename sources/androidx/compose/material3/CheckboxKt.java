package androidx.compose.material3;

import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.AnimationVector1D;
import androidx.compose.animation.core.FiniteAnimationSpec;
import androidx.compose.animation.core.SnapSpec;
import androidx.compose.animation.core.Transition;
import androidx.compose.animation.core.TransitionKt;
import androidx.compose.animation.core.TwoWayConverter;
import androidx.compose.animation.core.VectorConvertersKt;
import androidx.compose.foundation.CanvasKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.selection.ToggleableKt;
import androidx.compose.material3.tokens.CheckboxTokens;
import androidx.compose.material3.tokens.MotionSchemeKeyTokens;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.State;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.CornerRadius;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.StrokeCap;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.drawscope.Fill;
import androidx.compose.ui.graphics.drawscope.Stroke;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.semantics.Role;
import androidx.compose.ui.state.ToggleableState;
import androidx.compose.ui.state.ToggleableStateKt;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.util.MathHelpersKt;
import androidx.media3.exoplayer.RendererCapabilities;
import androidx.profileinstaller.ProfileVerifier;
import com.google.firebase.remoteconfig.RemoteConfigConstants;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.FloatCompanionObject;
import okhttp3.internal.ws.WebSocketProtocol;
/* compiled from: Checkbox.kt */
@Metadata(d1 = {"\u0000l\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u001aU\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0014\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0007¢\u0006\u0002\u0010\r\u001ae\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0014\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u00052\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000f2\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0007¢\u0006\u0002\u0010\u0011\u001aO\u0010\u0012\u001a\u00020\u00012\u0006\u0010\u0013\u001a\u00020\u00142\u000e\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u00162\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0007¢\u0006\u0002\u0010\u0017\u001a_\u0010\u0012\u001a\u00020\u00012\u0006\u0010\u0013\u001a\u00020\u00142\u000e\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u00162\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000f2\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0007¢\u0006\u0002\u0010\u0018\u001a=\u0010\u0019\u001a\u00020\u00012\u0006\u0010\b\u001a\u00020\u00032\u0006\u0010\u001a\u001a\u00020\u00142\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000fH\u0003¢\u0006\u0002\u0010\u001b\u001a3\u0010\u001c\u001a\u00020\u0001*\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u001f2\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020\u000fH\u0002¢\u0006\u0004\b$\u0010%\u001a;\u0010&\u001a\u00020\u0001*\u00020\u001d2\u0006\u0010'\u001a\u00020\u001f2\u0006\u0010(\u001a\u00020\"2\u0006\u0010)\u001a\u00020\"2\u0006\u0010#\u001a\u00020\u000f2\u0006\u0010*\u001a\u00020+H\u0002¢\u0006\u0004\b,\u0010-\"\u000e\u0010.\u001a\u00020/X\u0082T¢\u0006\u0002\n\u0000\"\u0010\u00100\u001a\u000201X\u0082\u0004¢\u0006\u0004\n\u0002\u00102\"\u0010\u00103\u001a\u000201X\u0082\u0004¢\u0006\u0004\n\u0002\u00102\"\u0010\u00104\u001a\u000201X\u0082\u0004¢\u0006\u0004\n\u0002\u00102¨\u00065"}, d2 = {"Checkbox", "", "checked", "", "onCheckedChange", "Lkotlin/Function1;", "modifier", "Landroidx/compose/ui/Modifier;", "enabled", "colors", "Landroidx/compose/material3/CheckboxColors;", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "(ZLkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;ZLandroidx/compose/material3/CheckboxColors;Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/runtime/Composer;II)V", "checkmarkStroke", "Landroidx/compose/ui/graphics/drawscope/Stroke;", "outlineStroke", "(ZLkotlin/jvm/functions/Function1;Landroidx/compose/ui/graphics/drawscope/Stroke;Landroidx/compose/ui/graphics/drawscope/Stroke;Landroidx/compose/ui/Modifier;ZLandroidx/compose/material3/CheckboxColors;Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/runtime/Composer;II)V", "TriStateCheckbox", RemoteConfigConstants.ResponseFieldKey.STATE, "Landroidx/compose/ui/state/ToggleableState;", "onClick", "Lkotlin/Function0;", "(Landroidx/compose/ui/state/ToggleableState;Lkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;ZLandroidx/compose/material3/CheckboxColors;Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/runtime/Composer;II)V", "(Landroidx/compose/ui/state/ToggleableState;Lkotlin/jvm/functions/Function0;Landroidx/compose/ui/graphics/drawscope/Stroke;Landroidx/compose/ui/graphics/drawscope/Stroke;Landroidx/compose/ui/Modifier;ZLandroidx/compose/material3/CheckboxColors;Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/runtime/Composer;II)V", "CheckboxImpl", "value", "(ZLandroidx/compose/ui/state/ToggleableState;Landroidx/compose/ui/Modifier;Landroidx/compose/material3/CheckboxColors;Landroidx/compose/ui/graphics/drawscope/Stroke;Landroidx/compose/ui/graphics/drawscope/Stroke;Landroidx/compose/runtime/Composer;I)V", "drawBox", "Landroidx/compose/ui/graphics/drawscope/DrawScope;", "boxColor", "Landroidx/compose/ui/graphics/Color;", "borderColor", "radius", "", "stroke", "drawBox-1wkBAMs", "(Landroidx/compose/ui/graphics/drawscope/DrawScope;JJFLandroidx/compose/ui/graphics/drawscope/Stroke;)V", "drawCheck", "checkColor", "checkFraction", "crossCenterGravitation", "drawingCache", "Landroidx/compose/material3/CheckDrawingCache;", "drawCheck-3IgeMak", "(Landroidx/compose/ui/graphics/drawscope/DrawScope;JFFLandroidx/compose/ui/graphics/drawscope/Stroke;Landroidx/compose/material3/CheckDrawingCache;)V", "SnapAnimationDelay", "", "CheckboxDefaultPadding", "Landroidx/compose/ui/unit/Dp;", "F", "CheckboxSize", "RadiusSize", "material3"}, k = 2, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public final class CheckboxKt {
    private static final float CheckboxDefaultPadding = Dp.m7555constructorimpl(2.0f);
    private static final float CheckboxSize = Dp.m7555constructorimpl(20.0f);
    private static final float RadiusSize = Dp.m7555constructorimpl(2.0f);
    private static final int SnapAnimationDelay = 100;

    /* compiled from: Checkbox.kt */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    /* loaded from: classes.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[ToggleableState.values().length];
            try {
                iArr[ToggleableState.On.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[ToggleableState.Off.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[ToggleableState.Indeterminate.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit Checkbox$lambda$3(boolean z, Function1 function1, Modifier modifier, boolean z2, CheckboxColors checkboxColors, MutableInteractionSource mutableInteractionSource, int i, int i2, Composer composer, int i3) {
        Checkbox(z, function1, modifier, z2, checkboxColors, mutableInteractionSource, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit Checkbox$lambda$6(boolean z, Function1 function1, Stroke stroke, Stroke stroke2, Modifier modifier, boolean z2, CheckboxColors checkboxColors, MutableInteractionSource mutableInteractionSource, int i, int i2, Composer composer, int i3) {
        Checkbox(z, function1, stroke, stroke2, modifier, z2, checkboxColors, mutableInteractionSource, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit CheckboxImpl$lambda$15(boolean z, ToggleableState toggleableState, Modifier modifier, CheckboxColors checkboxColors, Stroke stroke, Stroke stroke2, int i, Composer composer, int i2) {
        CheckboxImpl(z, toggleableState, modifier, checkboxColors, stroke, stroke2, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit TriStateCheckbox$lambda$8(ToggleableState toggleableState, Function0 function0, Modifier modifier, boolean z, CheckboxColors checkboxColors, MutableInteractionSource mutableInteractionSource, int i, int i2, Composer composer, int i3) {
        TriStateCheckbox(toggleableState, function0, modifier, z, checkboxColors, mutableInteractionSource, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit TriStateCheckbox$lambda$9(ToggleableState toggleableState, Function0 function0, Stroke stroke, Stroke stroke2, Modifier modifier, boolean z, CheckboxColors checkboxColors, MutableInteractionSource mutableInteractionSource, int i, int i2, Composer composer, int i3) {
        TriStateCheckbox(toggleableState, function0, stroke, stroke2, modifier, z, checkboxColors, mutableInteractionSource, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Removed duplicated region for block: B:110:0x0193  */
    /* JADX WARN: Removed duplicated region for block: B:113:0x01d6  */
    /* JADX WARN: Removed duplicated region for block: B:115:0x01de  */
    /* JADX WARN: Removed duplicated region for block: B:118:0x01ed  */
    /* JADX WARN: Removed duplicated region for block: B:120:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0063  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0066  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x007f  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0094  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x009c  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x009e  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00bf  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00c2  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x00cc  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x011a  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x014d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void Checkbox(final boolean z, final Function1<? super Boolean, Unit> function1, Modifier modifier, boolean z2, CheckboxColors checkboxColors, MutableInteractionSource mutableInteractionSource, Composer composer, final int i, final int i2) {
        int i3;
        Modifier.Companion companion;
        int i4;
        boolean z3;
        Object obj;
        int i5;
        Object obj2;
        Composer composer2;
        final Modifier modifier2;
        final boolean z4;
        final CheckboxColors checkboxColors2;
        final MutableInteractionSource mutableInteractionSource2;
        ScopeUpdateScope endRestartGroup;
        boolean z5;
        CheckboxColors checkboxColors3;
        MutableInteractionSource mutableInteractionSource3;
        Function0 function0;
        int i6;
        Composer startRestartGroup = composer.startRestartGroup(-1406741137);
        ComposerKt.sourceInformation(startRestartGroup, "C(Checkbox)N(checked,onCheckedChange,modifier,enabled,colors,interactionSource)98@4432L7,99@4492L493:Checkbox.kt#uh7d8r");
        if ((i2 & 1) != 0) {
            i3 = i | 6;
        } else if ((i & 6) == 0) {
            i3 = (startRestartGroup.changed(z) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        if ((i2 & 2) != 0) {
            i3 |= 48;
        } else if ((i & 48) == 0) {
            i3 |= startRestartGroup.changedInstance(function1) ? 32 : 16;
        }
        int i7 = i2 & 4;
        if (i7 != 0) {
            i3 |= RendererCapabilities.DECODER_SUPPORT_MASK;
        } else if ((i & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
            companion = modifier;
            i3 |= startRestartGroup.changed(companion) ? 256 : 128;
            i4 = i2 & 8;
            if (i4 == 0) {
                i3 |= 3072;
            } else if ((i & 3072) == 0) {
                z3 = z2;
                i3 |= startRestartGroup.changed(z3) ? 2048 : 1024;
                if ((i & 24576) == 0) {
                    if ((i2 & 16) == 0) {
                        obj = checkboxColors;
                        if (startRestartGroup.changed(obj)) {
                            i6 = 16384;
                            i3 |= i6;
                        }
                    } else {
                        obj = checkboxColors;
                    }
                    i6 = 8192;
                    i3 |= i6;
                } else {
                    obj = checkboxColors;
                }
                i5 = i2 & 32;
                if (i5 != 0) {
                    i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                } else if ((196608 & i) == 0) {
                    obj2 = mutableInteractionSource;
                    i3 |= startRestartGroup.changed(obj2) ? 131072 : 65536;
                    if (!startRestartGroup.shouldExecute((74899 & i3) == 74898, i3 & 1)) {
                        startRestartGroup.startDefaults();
                        ComposerKt.sourceInformation(startRestartGroup, "95@4319L8");
                        if ((i & 1) == 0 || startRestartGroup.getDefaultsInvalid()) {
                            if (i7 != 0) {
                                companion = Modifier.Companion;
                            }
                            if (i4 != 0) {
                                z3 = true;
                            }
                            if ((i2 & 16) != 0) {
                                i3 &= -57345;
                                obj = CheckboxDefaults.INSTANCE.colors(startRestartGroup, 6);
                            }
                            if (i5 != 0) {
                                z5 = z3;
                                checkboxColors3 = obj;
                                mutableInteractionSource3 = null;
                                Modifier modifier3 = companion;
                                startRestartGroup.endDefaults();
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(-1406741137, i3, -1, "androidx.compose.material3.Checkbox (Checkbox.kt:97)");
                                }
                                ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                                Object consume = startRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
                                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                                float floor = (float) Math.floor(((Density) consume).mo405toPx0680j_4(CheckboxDefaults.INSTANCE.m1804getStrokeWidthD9Ej5fM()));
                                ToggleableState ToggleableState = ToggleableStateKt.ToggleableState(z);
                                if (function1 == null) {
                                    startRestartGroup.startReplaceGroup(2066152950);
                                    ComposerKt.sourceInformation(startRestartGroup, "103@4629L29");
                                    ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1036481964, "CC(remember):Checkbox.kt#9igjgp");
                                    boolean z6 = ((i3 & 112) == 32) | ((i3 & 14) == 4);
                                    Object rememberedValue = startRestartGroup.rememberedValue();
                                    if (z6 || rememberedValue == Composer.Companion.getEmpty()) {
                                        rememberedValue = new Function0() { // from class: androidx.compose.material3.CheckboxKt$$ExternalSyntheticLambda6
                                            @Override // kotlin.jvm.functions.Function0
                                            public final Object invoke() {
                                                return CheckboxKt.Checkbox$lambda$2$lambda$1(Function1.this, z);
                                            }
                                        };
                                        startRestartGroup.updateRememberedValue(rememberedValue);
                                    }
                                    ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                                    startRestartGroup.endReplaceGroup();
                                    function0 = (Function0) rememberedValue;
                                } else {
                                    startRestartGroup.startReplaceGroup(2066218639);
                                    startRestartGroup.endReplaceGroup();
                                    function0 = null;
                                }
                                composer2 = startRestartGroup;
                                TriStateCheckbox(ToggleableState, function0, new Stroke(floor, 0.0f, StrokeCap.Companion.m5148getSquareKaPHkGw(), 0, null, 26, null), new Stroke(floor, 0.0f, 0, 0, null, 30, null), modifier3, z5, checkboxColors3, mutableInteractionSource3, composer2, (i3 << 6) & 33546240, 0);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                                modifier2 = modifier3;
                                z4 = z5;
                                checkboxColors2 = checkboxColors3;
                                mutableInteractionSource2 = mutableInteractionSource3;
                            }
                        } else {
                            startRestartGroup.skipToGroupEnd();
                            if ((i2 & 16) != 0) {
                                i3 &= -57345;
                            }
                        }
                        z5 = z3;
                        mutableInteractionSource3 = obj2;
                        checkboxColors3 = obj;
                        Modifier modifier32 = companion;
                        startRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                        }
                        ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                        Object consume2 = startRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
                        ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                        float floor2 = (float) Math.floor(((Density) consume2).mo405toPx0680j_4(CheckboxDefaults.INSTANCE.m1804getStrokeWidthD9Ej5fM()));
                        ToggleableState ToggleableState2 = ToggleableStateKt.ToggleableState(z);
                        if (function1 == null) {
                        }
                        composer2 = startRestartGroup;
                        TriStateCheckbox(ToggleableState2, function0, new Stroke(floor2, 0.0f, StrokeCap.Companion.m5148getSquareKaPHkGw(), 0, null, 26, null), new Stroke(floor2, 0.0f, 0, 0, null, 30, null), modifier32, z5, checkboxColors3, mutableInteractionSource3, composer2, (i3 << 6) & 33546240, 0);
                        if (ComposerKt.isTraceInProgress()) {
                        }
                        modifier2 = modifier32;
                        z4 = z5;
                        checkboxColors2 = checkboxColors3;
                        mutableInteractionSource2 = mutableInteractionSource3;
                    } else {
                        composer2 = startRestartGroup;
                        composer2.skipToGroupEnd();
                        modifier2 = companion;
                        z4 = z3;
                        checkboxColors2 = obj;
                        mutableInteractionSource2 = obj2;
                    }
                    endRestartGroup = composer2.endRestartGroup();
                    if (endRestartGroup == null) {
                        endRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.CheckboxKt$$ExternalSyntheticLambda7
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj3, Object obj4) {
                                return CheckboxKt.Checkbox$lambda$3(z, function1, modifier2, z4, checkboxColors2, mutableInteractionSource2, i, i2, (Composer) obj3, ((Integer) obj4).intValue());
                            }
                        });
                        return;
                    }
                    return;
                }
                obj2 = mutableInteractionSource;
                if (!startRestartGroup.shouldExecute((74899 & i3) == 74898, i3 & 1)) {
                }
                endRestartGroup = composer2.endRestartGroup();
                if (endRestartGroup == null) {
                }
            }
            z3 = z2;
            if ((i & 24576) == 0) {
            }
            i5 = i2 & 32;
            if (i5 != 0) {
            }
            obj2 = mutableInteractionSource;
            if (!startRestartGroup.shouldExecute((74899 & i3) == 74898, i3 & 1)) {
            }
            endRestartGroup = composer2.endRestartGroup();
            if (endRestartGroup == null) {
            }
        }
        companion = modifier;
        i4 = i2 & 8;
        if (i4 == 0) {
        }
        z3 = z2;
        if ((i & 24576) == 0) {
        }
        i5 = i2 & 32;
        if (i5 != 0) {
        }
        obj2 = mutableInteractionSource;
        if (!startRestartGroup.shouldExecute((74899 & i3) == 74898, i3 & 1)) {
        }
        endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup == null) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit Checkbox$lambda$2$lambda$1(Function1 function1, boolean z) {
        function1.invoke(Boolean.valueOf(!z));
        return Unit.INSTANCE;
    }

    /* JADX WARN: Removed duplicated region for block: B:116:0x0170  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x017c  */
    /* JADX WARN: Removed duplicated region for block: B:132:0x01c0  */
    /* JADX WARN: Removed duplicated region for block: B:135:0x01dc  */
    /* JADX WARN: Removed duplicated region for block: B:137:0x01e7  */
    /* JADX WARN: Removed duplicated region for block: B:140:0x01f6  */
    /* JADX WARN: Removed duplicated region for block: B:142:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:56:0x009c  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x009e  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x00b7  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x00cd  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x00d5  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x00da  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x00fd  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x0100  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x010a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void Checkbox(final boolean z, final Function1<? super Boolean, Unit> function1, final Stroke stroke, final Stroke stroke2, Modifier modifier, boolean z2, CheckboxColors checkboxColors, MutableInteractionSource mutableInteractionSource, Composer composer, final int i, final int i2) {
        int i3;
        Stroke stroke3;
        Stroke stroke4;
        Modifier.Companion companion;
        int i4;
        boolean z3;
        Object obj;
        int i5;
        Object obj2;
        int i6;
        Composer composer2;
        final Modifier modifier2;
        final boolean z4;
        final MutableInteractionSource mutableInteractionSource2;
        final CheckboxColors checkboxColors2;
        ScopeUpdateScope endRestartGroup;
        int i7;
        MutableInteractionSource mutableInteractionSource3;
        CheckboxColors checkboxColors3;
        boolean z5;
        int i8;
        int i9;
        int i10;
        Composer startRestartGroup = composer.startRestartGroup(534932591);
        ComposerKt.sourceInformation(startRestartGroup, "C(Checkbox)N(checked,onCheckedChange,checkmarkStroke,outlineStroke,modifier,enabled,colors,interactionSource)162@7424L439:Checkbox.kt#uh7d8r");
        if ((i2 & 1) != 0) {
            i3 = i | 6;
        } else if ((i & 6) == 0) {
            i3 = (startRestartGroup.changed(z) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        if ((i2 & 2) != 0) {
            i3 |= 48;
        } else if ((i & 48) == 0) {
            i3 |= startRestartGroup.changedInstance(function1) ? 32 : 16;
        }
        if ((i2 & 4) != 0) {
            i3 |= RendererCapabilities.DECODER_SUPPORT_MASK;
            stroke3 = stroke;
        } else {
            stroke3 = stroke;
            if ((i & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
                i3 |= startRestartGroup.changedInstance(stroke3) ? 256 : 128;
            }
        }
        if ((i2 & 8) != 0) {
            i3 |= 3072;
            stroke4 = stroke2;
        } else {
            stroke4 = stroke2;
            if ((i & 3072) == 0) {
                i3 |= startRestartGroup.changedInstance(stroke4) ? 2048 : 1024;
            }
        }
        int i11 = i2 & 16;
        if (i11 != 0) {
            i3 |= 24576;
        } else if ((i & 24576) == 0) {
            companion = modifier;
            i3 |= startRestartGroup.changed(companion) ? 16384 : 8192;
            i4 = i2 & 32;
            if (i4 == 0) {
                i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
            } else if ((196608 & i) == 0) {
                z3 = z2;
                i3 |= startRestartGroup.changed(z3) ? 131072 : 65536;
                if ((1572864 & i) == 0) {
                    if ((i2 & 64) == 0) {
                        obj = checkboxColors;
                        if (startRestartGroup.changed(obj)) {
                            i10 = 1048576;
                            i3 |= i10;
                        }
                    } else {
                        obj = checkboxColors;
                    }
                    i10 = 524288;
                    i3 |= i10;
                } else {
                    obj = checkboxColors;
                }
                i5 = i2 & 128;
                if (i5 != 0) {
                    i3 |= 12582912;
                    obj2 = mutableInteractionSource;
                } else {
                    obj2 = mutableInteractionSource;
                    if ((i & 12582912) == 0) {
                        i3 |= startRestartGroup.changed(obj2) ? 8388608 : 4194304;
                    }
                }
                i6 = i3;
                if (startRestartGroup.shouldExecute((i3 & 4793491) != 4793490, i6 & 1)) {
                    startRestartGroup.startDefaults();
                    ComposerKt.sourceInformation(startRestartGroup, "159@7349L8");
                    Function0 function0 = null;
                    if ((i & 1) == 0 || startRestartGroup.getDefaultsInvalid()) {
                        if (i11 != 0) {
                            companion = Modifier.Companion;
                        }
                        if (i4 != 0) {
                            z3 = true;
                        }
                        if ((i2 & 64) != 0) {
                            i7 = i6 & (-3670017);
                            obj = CheckboxDefaults.INSTANCE.colors(startRestartGroup, 6);
                        } else {
                            i7 = i6;
                        }
                        if (i5 != 0) {
                            mutableInteractionSource3 = null;
                            z5 = z3;
                            checkboxColors3 = obj;
                            i9 = 32;
                            i8 = 534932591;
                            Modifier modifier3 = companion;
                            startRestartGroup.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(i8, i7, -1, "androidx.compose.material3.Checkbox (Checkbox.kt:161)");
                            }
                            ToggleableState ToggleableState = ToggleableStateKt.ToggleableState(z);
                            if (function1 != null) {
                                startRestartGroup.startReplaceGroup(1848599606);
                                ComposerKt.sourceInformation(startRestartGroup, "166@7561L29");
                                ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1325840532, "CC(remember):Checkbox.kt#9igjgp");
                                boolean z6 = ((i7 & 112) == i9) | ((i7 & 14) == 4);
                                Object rememberedValue = startRestartGroup.rememberedValue();
                                if (z6 || rememberedValue == Composer.Companion.getEmpty()) {
                                    rememberedValue = new Function0() { // from class: androidx.compose.material3.CheckboxKt$$ExternalSyntheticLambda3
                                        @Override // kotlin.jvm.functions.Function0
                                        public final Object invoke() {
                                            return CheckboxKt.Checkbox$lambda$5$lambda$4(Function1.this, z);
                                        }
                                    };
                                    startRestartGroup.updateRememberedValue(rememberedValue);
                                }
                                function0 = (Function0) rememberedValue;
                                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                                startRestartGroup.endReplaceGroup();
                            } else {
                                startRestartGroup.startReplaceGroup(1848665295);
                                startRestartGroup.endReplaceGroup();
                            }
                            composer2 = startRestartGroup;
                            TriStateCheckbox(ToggleableState, function0, stroke3, stroke4, modifier3, z5, checkboxColors3, mutableInteractionSource3, composer2, i7 & 33554304, 0);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            modifier2 = modifier3;
                            z4 = z5;
                            checkboxColors2 = checkboxColors3;
                            mutableInteractionSource2 = mutableInteractionSource3;
                        }
                    } else {
                        startRestartGroup.skipToGroupEnd();
                        if ((i2 & 64) != 0) {
                            i7 = i6 & (-3670017);
                        } else {
                            mutableInteractionSource3 = obj2;
                            z5 = z3;
                            i7 = i6;
                            i9 = 32;
                            i8 = 534932591;
                            checkboxColors3 = obj;
                            Modifier modifier32 = companion;
                            startRestartGroup.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                            }
                            ToggleableState ToggleableState2 = ToggleableStateKt.ToggleableState(z);
                            if (function1 != null) {
                            }
                            composer2 = startRestartGroup;
                            TriStateCheckbox(ToggleableState2, function0, stroke3, stroke4, modifier32, z5, checkboxColors3, mutableInteractionSource3, composer2, i7 & 33554304, 0);
                            if (ComposerKt.isTraceInProgress()) {
                            }
                            modifier2 = modifier32;
                            z4 = z5;
                            checkboxColors2 = checkboxColors3;
                            mutableInteractionSource2 = mutableInteractionSource3;
                        }
                    }
                    mutableInteractionSource3 = obj2;
                    z5 = z3;
                    checkboxColors3 = obj;
                    i9 = 32;
                    i8 = 534932591;
                    Modifier modifier322 = companion;
                    startRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    ToggleableState ToggleableState22 = ToggleableStateKt.ToggleableState(z);
                    if (function1 != null) {
                    }
                    composer2 = startRestartGroup;
                    TriStateCheckbox(ToggleableState22, function0, stroke3, stroke4, modifier322, z5, checkboxColors3, mutableInteractionSource3, composer2, i7 & 33554304, 0);
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    modifier2 = modifier322;
                    z4 = z5;
                    checkboxColors2 = checkboxColors3;
                    mutableInteractionSource2 = mutableInteractionSource3;
                } else {
                    composer2 = startRestartGroup;
                    composer2.skipToGroupEnd();
                    modifier2 = companion;
                    z4 = z3;
                    mutableInteractionSource2 = obj2;
                    checkboxColors2 = obj;
                }
                endRestartGroup = composer2.endRestartGroup();
                if (endRestartGroup != null) {
                    endRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.CheckboxKt$$ExternalSyntheticLambda4
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj3, Object obj4) {
                            return CheckboxKt.Checkbox$lambda$6(z, function1, stroke, stroke2, modifier2, z4, checkboxColors2, mutableInteractionSource2, i, i2, (Composer) obj3, ((Integer) obj4).intValue());
                        }
                    });
                    return;
                }
                return;
            }
            z3 = z2;
            if ((1572864 & i) == 0) {
            }
            i5 = i2 & 128;
            if (i5 != 0) {
            }
            i6 = i3;
            if (startRestartGroup.shouldExecute((i3 & 4793491) != 4793490, i6 & 1)) {
            }
            endRestartGroup = composer2.endRestartGroup();
            if (endRestartGroup != null) {
            }
        }
        companion = modifier;
        i4 = i2 & 32;
        if (i4 == 0) {
        }
        z3 = z2;
        if ((1572864 & i) == 0) {
        }
        i5 = i2 & 128;
        if (i5 != 0) {
        }
        i6 = i3;
        if (startRestartGroup.shouldExecute((i3 & 4793491) != 4793490, i6 & 1)) {
        }
        endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit Checkbox$lambda$5$lambda$4(Function1 function1, boolean z) {
        function1.invoke(Boolean.valueOf(!z));
        return Unit.INSTANCE;
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x0197  */
    /* JADX WARN: Removed duplicated region for block: B:102:0x019f  */
    /* JADX WARN: Removed duplicated region for block: B:105:0x01ae  */
    /* JADX WARN: Removed duplicated region for block: B:107:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x006a  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x006d  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0086  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x009b  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00a3  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00a5  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00c3  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00c5  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x00ce  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x0122  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void TriStateCheckbox(final ToggleableState toggleableState, final Function0<Unit> function0, Modifier modifier, boolean z, CheckboxColors checkboxColors, MutableInteractionSource mutableInteractionSource, Composer composer, final int i, final int i2) {
        int i3;
        Function0<Unit> function02;
        Object obj;
        int i4;
        boolean z2;
        Object obj2;
        int i5;
        Object obj3;
        Composer composer2;
        final Modifier modifier2;
        final boolean z3;
        final CheckboxColors checkboxColors2;
        final MutableInteractionSource mutableInteractionSource2;
        ScopeUpdateScope endRestartGroup;
        Modifier modifier3;
        boolean z4;
        int i6;
        CheckboxColors checkboxColors3;
        MutableInteractionSource mutableInteractionSource3;
        int i7;
        Composer startRestartGroup = composer.startRestartGroup(-1608358065);
        ComposerKt.sourceInformation(startRestartGroup, "C(TriStateCheckbox)N(state,onClick,modifier,enabled,colors,interactionSource)215@9923L7,216@9983L337:Checkbox.kt#uh7d8r");
        if ((i2 & 1) != 0) {
            i3 = i | 6;
        } else if ((i & 6) == 0) {
            i3 = (startRestartGroup.changed(toggleableState.ordinal()) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        if ((i2 & 2) != 0) {
            i3 |= 48;
            function02 = function0;
        } else {
            function02 = function0;
            if ((i & 48) == 0) {
                i3 |= startRestartGroup.changedInstance(function02) ? 32 : 16;
            }
        }
        int i8 = i2 & 4;
        if (i8 != 0) {
            i3 |= RendererCapabilities.DECODER_SUPPORT_MASK;
        } else if ((i & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
            obj = modifier;
            i3 |= startRestartGroup.changed(obj) ? 256 : 128;
            i4 = i2 & 8;
            if (i4 == 0) {
                i3 |= 3072;
            } else if ((i & 3072) == 0) {
                z2 = z;
                i3 |= startRestartGroup.changed(z2) ? 2048 : 1024;
                if ((i & 24576) == 0) {
                    if ((i2 & 16) == 0) {
                        obj2 = checkboxColors;
                        if (startRestartGroup.changed(obj2)) {
                            i7 = 16384;
                            i3 |= i7;
                        }
                    } else {
                        obj2 = checkboxColors;
                    }
                    i7 = 8192;
                    i3 |= i7;
                } else {
                    obj2 = checkboxColors;
                }
                i5 = i2 & 32;
                if (i5 != 0) {
                    i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                } else if ((196608 & i) == 0) {
                    obj3 = mutableInteractionSource;
                    i3 |= startRestartGroup.changed(obj3) ? 131072 : 65536;
                    if (!startRestartGroup.shouldExecute((74899 & i3) == 74898, i3 & 1)) {
                        startRestartGroup.startDefaults();
                        ComposerKt.sourceInformation(startRestartGroup, "212@9810L8");
                        if ((i & 1) != 0 && !startRestartGroup.getDefaultsInvalid()) {
                            startRestartGroup.skipToGroupEnd();
                            if ((i2 & 16) != 0) {
                                i3 &= -57345;
                            }
                            modifier3 = obj;
                            z4 = z2;
                            checkboxColors3 = obj2;
                            i6 = 6;
                        } else {
                            Modifier.Companion companion = i8 != 0 ? Modifier.Companion : obj;
                            boolean z5 = i4 == 0 ? z2 : true;
                            if ((i2 & 16) != 0) {
                                i3 &= -57345;
                                obj2 = CheckboxDefaults.INSTANCE.colors(startRestartGroup, 6);
                            }
                            if (i5 != 0) {
                                modifier3 = companion;
                                z4 = z5;
                                i6 = 6;
                                mutableInteractionSource3 = null;
                                checkboxColors3 = obj2;
                                startRestartGroup.endDefaults();
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(-1608358065, i3, -1, "androidx.compose.material3.TriStateCheckbox (Checkbox.kt:214)");
                                }
                                ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                                Object consume = startRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
                                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                                float floor = (float) Math.floor(((Density) consume).mo405toPx0680j_4(CheckboxDefaults.INSTANCE.m1804getStrokeWidthD9Ej5fM()));
                                Stroke stroke = new Stroke(floor, 0.0f, StrokeCap.Companion.m5148getSquareKaPHkGw(), 0, null, 26, null);
                                Stroke stroke2 = new Stroke(floor, 0.0f, 0, 0, null, 30, null);
                                int i9 = i3 & WebSocketProtocol.PAYLOAD_SHORT;
                                int i10 = i3 << i6;
                                composer2 = startRestartGroup;
                                TriStateCheckbox(toggleableState, function02, stroke, stroke2, modifier3, z4, checkboxColors3, mutableInteractionSource3, composer2, i9 | (57344 & i10) | (458752 & i10) | (3670016 & i10) | (i10 & 29360128), 0);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                                modifier2 = modifier3;
                                z3 = z4;
                                checkboxColors2 = checkboxColors3;
                                mutableInteractionSource2 = mutableInteractionSource3;
                            } else {
                                modifier3 = companion;
                                z4 = z5;
                                i6 = 6;
                                checkboxColors3 = obj2;
                            }
                        }
                        mutableInteractionSource3 = obj3;
                        startRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                        }
                        ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                        Object consume2 = startRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
                        ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                        float floor2 = (float) Math.floor(((Density) consume2).mo405toPx0680j_4(CheckboxDefaults.INSTANCE.m1804getStrokeWidthD9Ej5fM()));
                        Stroke stroke3 = new Stroke(floor2, 0.0f, StrokeCap.Companion.m5148getSquareKaPHkGw(), 0, null, 26, null);
                        Stroke stroke22 = new Stroke(floor2, 0.0f, 0, 0, null, 30, null);
                        int i92 = i3 & WebSocketProtocol.PAYLOAD_SHORT;
                        int i102 = i3 << i6;
                        composer2 = startRestartGroup;
                        TriStateCheckbox(toggleableState, function02, stroke3, stroke22, modifier3, z4, checkboxColors3, mutableInteractionSource3, composer2, i92 | (57344 & i102) | (458752 & i102) | (3670016 & i102) | (i102 & 29360128), 0);
                        if (ComposerKt.isTraceInProgress()) {
                        }
                        modifier2 = modifier3;
                        z3 = z4;
                        checkboxColors2 = checkboxColors3;
                        mutableInteractionSource2 = mutableInteractionSource3;
                    } else {
                        composer2 = startRestartGroup;
                        composer2.skipToGroupEnd();
                        modifier2 = obj;
                        z3 = z2;
                        checkboxColors2 = obj2;
                        mutableInteractionSource2 = obj3;
                    }
                    endRestartGroup = composer2.endRestartGroup();
                    if (endRestartGroup == null) {
                        endRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.CheckboxKt$$ExternalSyntheticLambda5
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj4, Object obj5) {
                                return CheckboxKt.TriStateCheckbox$lambda$8(ToggleableState.this, function0, modifier2, z3, checkboxColors2, mutableInteractionSource2, i, i2, (Composer) obj4, ((Integer) obj5).intValue());
                            }
                        });
                        return;
                    }
                    return;
                }
                obj3 = mutableInteractionSource;
                if (!startRestartGroup.shouldExecute((74899 & i3) == 74898, i3 & 1)) {
                }
                endRestartGroup = composer2.endRestartGroup();
                if (endRestartGroup == null) {
                }
            }
            z2 = z;
            if ((i & 24576) == 0) {
            }
            i5 = i2 & 32;
            if (i5 != 0) {
            }
            obj3 = mutableInteractionSource;
            if (!startRestartGroup.shouldExecute((74899 & i3) == 74898, i3 & 1)) {
            }
            endRestartGroup = composer2.endRestartGroup();
            if (endRestartGroup == null) {
            }
        }
        obj = modifier;
        i4 = i2 & 8;
        if (i4 == 0) {
        }
        z2 = z;
        if ((i & 24576) == 0) {
        }
        i5 = i2 & 32;
        if (i5 != 0) {
        }
        obj3 = mutableInteractionSource;
        if (!startRestartGroup.shouldExecute((74899 & i3) == 74898, i3 & 1)) {
        }
        endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup == null) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:116:0x015c  */
    /* JADX WARN: Removed duplicated region for block: B:118:0x0167  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x019c  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x01a4  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x01ad  */
    /* JADX WARN: Removed duplicated region for block: B:125:0x01e7  */
    /* JADX WARN: Removed duplicated region for block: B:127:0x01f1  */
    /* JADX WARN: Removed duplicated region for block: B:130:0x01ff  */
    /* JADX WARN: Removed duplicated region for block: B:132:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:56:0x00a2  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x00a4  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x00bd  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x00d2  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x00da  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x00dc  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x00fb  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x00fe  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x0107  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void TriStateCheckbox(final ToggleableState toggleableState, final Function0<Unit> function0, final Stroke stroke, final Stroke stroke2, Modifier modifier, boolean z, CheckboxColors checkboxColors, MutableInteractionSource mutableInteractionSource, Composer composer, final int i, final int i2) {
        int i3;
        Object obj;
        Object obj2;
        Object obj3;
        int i4;
        boolean z2;
        Object obj4;
        int i5;
        Object obj5;
        final boolean z3;
        Composer composer2;
        final CheckboxColors checkboxColors2;
        final MutableInteractionSource mutableInteractionSource2;
        final Modifier modifier2;
        ScopeUpdateScope endRestartGroup;
        CheckboxColors checkboxColors3;
        MutableInteractionSource mutableInteractionSource3;
        Modifier modifier3;
        int i6;
        boolean z4;
        MutableInteractionSource mutableInteractionSource4;
        Modifier.Companion companion;
        Modifier.Companion companion2;
        int i7;
        Composer startRestartGroup = composer.startRestartGroup(-406243761);
        ComposerKt.sourceInformation(startRestartGroup, "C(TriStateCheckbox)N(state,onClick,checkmarkStroke,outlineStroke,modifier,enabled,colors,interactionSource)289@13489L543:Checkbox.kt#uh7d8r");
        if ((i2 & 1) != 0) {
            i3 = i | 6;
        } else if ((i & 6) == 0) {
            i3 = (startRestartGroup.changed(toggleableState.ordinal()) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        if ((i2 & 2) != 0) {
            i3 |= 48;
        } else if ((i & 48) == 0) {
            i3 |= startRestartGroup.changedInstance(function0) ? 32 : 16;
        }
        if ((i2 & 4) != 0) {
            i3 |= RendererCapabilities.DECODER_SUPPORT_MASK;
            obj = stroke;
        } else {
            obj = stroke;
            if ((i & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
                i3 |= startRestartGroup.changedInstance(obj) ? 256 : 128;
            }
        }
        if ((i2 & 8) != 0) {
            i3 |= 3072;
            obj2 = stroke2;
        } else {
            obj2 = stroke2;
            if ((i & 3072) == 0) {
                i3 |= startRestartGroup.changedInstance(obj2) ? 2048 : 1024;
            }
        }
        int i8 = i2 & 16;
        if (i8 != 0) {
            i3 |= 24576;
        } else if ((i & 24576) == 0) {
            obj3 = modifier;
            i3 |= startRestartGroup.changed(obj3) ? 16384 : 8192;
            i4 = i2 & 32;
            if (i4 == 0) {
                i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
            } else if ((196608 & i) == 0) {
                z2 = z;
                i3 |= startRestartGroup.changed(z2) ? 131072 : 65536;
                if ((1572864 & i) == 0) {
                    if ((i2 & 64) == 0) {
                        obj4 = checkboxColors;
                        if (startRestartGroup.changed(obj4)) {
                            i7 = 1048576;
                            i3 |= i7;
                        }
                    } else {
                        obj4 = checkboxColors;
                    }
                    i7 = 524288;
                    i3 |= i7;
                } else {
                    obj4 = checkboxColors;
                }
                i5 = i2 & 128;
                if (i5 != 0) {
                    i3 |= 12582912;
                } else if ((12582912 & i) == 0) {
                    obj5 = mutableInteractionSource;
                    i3 |= startRestartGroup.changed(obj5) ? 8388608 : 4194304;
                    if (!startRestartGroup.shouldExecute((4793491 & i3) == 4793490, i3 & 1)) {
                        startRestartGroup.startDefaults();
                        ComposerKt.sourceInformation(startRestartGroup, "273@12959L8");
                        if ((i & 1) != 0 && !startRestartGroup.getDefaultsInvalid()) {
                            startRestartGroup.skipToGroupEnd();
                            if ((i2 & 64) != 0) {
                                i3 &= -3670017;
                            }
                            checkboxColors3 = obj4;
                            mutableInteractionSource3 = obj5;
                            i6 = i3;
                            modifier3 = obj3;
                        } else {
                            Modifier.Companion companion3 = i8 != 0 ? Modifier.Companion : obj3;
                            if (i4 != 0) {
                                z2 = true;
                            }
                            if ((i2 & 64) != 0) {
                                i3 &= -3670017;
                                obj4 = CheckboxDefaults.INSTANCE.colors(startRestartGroup, 6);
                            }
                            if (i5 != 0) {
                                mutableInteractionSource3 = null;
                                i6 = i3;
                                z4 = z2;
                                checkboxColors3 = obj4;
                                modifier3 = companion3;
                                startRestartGroup.endDefaults();
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(-406243761, i6, -1, "androidx.compose.material3.TriStateCheckbox (Checkbox.kt:275)");
                                }
                                if (function0 == null) {
                                    boolean z5 = z4;
                                    companion = ToggleableKt.m1101triStateToggleableO2vRcR0(Modifier.Companion, toggleableState, mutableInteractionSource3, RippleKt.m2402rippleH2RKhps$default(false, Dp.m7555constructorimpl(CheckboxTokens.INSTANCE.m3193getStateLayerSizeD9Ej5fM() / 2.0f), 0L, 4, null), z5, Role.m6767boximpl(Role.Companion.m6776getCheckboxo7Vup1c()), function0);
                                    mutableInteractionSource4 = mutableInteractionSource3;
                                    z4 = z5;
                                } else {
                                    mutableInteractionSource4 = mutableInteractionSource3;
                                    companion = Modifier.Companion;
                                }
                                if (function0 == null) {
                                    companion2 = InteractiveComponentSizeKt.minimumInteractiveComponentSize(Modifier.Companion);
                                } else {
                                    companion2 = Modifier.Companion;
                                }
                                int i9 = i6 << 6;
                                CheckboxColors checkboxColors4 = checkboxColors3;
                                CheckboxImpl(z4, toggleableState, PaddingKt.m818padding3ABfNKs(modifier3.then(companion2).then(companion), CheckboxDefaultPadding), checkboxColors4, obj, obj2, startRestartGroup, ((i6 >> 15) & 14) | ((i6 << 3) & 112) | ((i6 >> 9) & 7168) | (57344 & i9) | (i9 & 458752));
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                                z3 = z4;
                                composer2 = startRestartGroup;
                                modifier2 = modifier3;
                                mutableInteractionSource2 = mutableInteractionSource4;
                                checkboxColors2 = checkboxColors4;
                            } else {
                                checkboxColors3 = obj4;
                                mutableInteractionSource3 = obj5;
                                modifier3 = companion3;
                                i6 = i3;
                            }
                        }
                        z4 = z2;
                        startRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                        }
                        if (function0 == null) {
                        }
                        if (function0 == null) {
                        }
                        int i92 = i6 << 6;
                        CheckboxColors checkboxColors42 = checkboxColors3;
                        CheckboxImpl(z4, toggleableState, PaddingKt.m818padding3ABfNKs(modifier3.then(companion2).then(companion), CheckboxDefaultPadding), checkboxColors42, obj, obj2, startRestartGroup, ((i6 >> 15) & 14) | ((i6 << 3) & 112) | ((i6 >> 9) & 7168) | (57344 & i92) | (i92 & 458752));
                        if (ComposerKt.isTraceInProgress()) {
                        }
                        z3 = z4;
                        composer2 = startRestartGroup;
                        modifier2 = modifier3;
                        mutableInteractionSource2 = mutableInteractionSource4;
                        checkboxColors2 = checkboxColors42;
                    } else {
                        startRestartGroup.skipToGroupEnd();
                        z3 = z2;
                        composer2 = startRestartGroup;
                        checkboxColors2 = obj4;
                        mutableInteractionSource2 = obj5;
                        modifier2 = obj3;
                    }
                    endRestartGroup = composer2.endRestartGroup();
                    if (endRestartGroup == null) {
                        endRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.CheckboxKt$$ExternalSyntheticLambda2
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj6, Object obj7) {
                                return CheckboxKt.TriStateCheckbox$lambda$9(ToggleableState.this, function0, stroke, stroke2, modifier2, z3, checkboxColors2, mutableInteractionSource2, i, i2, (Composer) obj6, ((Integer) obj7).intValue());
                            }
                        });
                        return;
                    }
                    return;
                }
                obj5 = mutableInteractionSource;
                if (!startRestartGroup.shouldExecute((4793491 & i3) == 4793490, i3 & 1)) {
                }
                endRestartGroup = composer2.endRestartGroup();
                if (endRestartGroup == null) {
                }
            }
            z2 = z;
            if ((1572864 & i) == 0) {
            }
            i5 = i2 & 128;
            if (i5 != 0) {
            }
            obj5 = mutableInteractionSource;
            if (!startRestartGroup.shouldExecute((4793491 & i3) == 4793490, i3 & 1)) {
            }
            endRestartGroup = composer2.endRestartGroup();
            if (endRestartGroup == null) {
            }
        }
        obj3 = modifier;
        i4 = i2 & 32;
        if (i4 == 0) {
        }
        z2 = z;
        if ((1572864 & i) == 0) {
        }
        i5 = i2 & 128;
        if (i5 != 0) {
        }
        obj5 = mutableInteractionSource;
        if (!startRestartGroup.shouldExecute((4793491 & i3) == 4793490, i3 & 1)) {
        }
        endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup == null) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:104:0x01fe  */
    /* JADX WARN: Removed duplicated region for block: B:107:0x021a  */
    /* JADX WARN: Removed duplicated region for block: B:110:0x022a  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x0240  */
    /* JADX WARN: Removed duplicated region for block: B:123:0x0284  */
    /* JADX WARN: Removed duplicated region for block: B:126:0x02f4  */
    /* JADX WARN: Removed duplicated region for block: B:131:0x0314  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x0120  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x013f  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x0149  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x0158  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x016f  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x01d8  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x01e8  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static final void CheckboxImpl(final boolean z, final ToggleableState toggleableState, final Modifier modifier, final CheckboxColors checkboxColors, final Stroke stroke, final Stroke stroke2, Composer composer, final int i) {
        int i2;
        Composer composer2;
        int i3;
        int i4;
        float f;
        Float f2;
        ToggleableState toggleableState2;
        int i5;
        float f3;
        int i6;
        float f4;
        int i7;
        float f5;
        Object rememberedValue;
        boolean changed;
        Object rememberedValue2;
        Composer startRestartGroup = composer.startRestartGroup(-891330208);
        ComposerKt.sourceInformation(startRestartGroup, "C(CheckboxImpl)N(enabled,value,modifier,colors,checkmarkStroke,outlineStroke)402@18923L23,403@19015L14,405@19077L608,423@19752L594,439@20368L32,440@20429L21,441@20477L24,442@20531L27,443@20641L476,443@20563L554:Checkbox.kt#uh7d8r");
        if ((i & 6) == 0) {
            i2 = (startRestartGroup.changed(z) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= startRestartGroup.changed(toggleableState.ordinal()) ? 32 : 16;
        }
        if ((i & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
            i2 |= startRestartGroup.changed(modifier) ? 256 : 128;
        }
        if ((i & 3072) == 0) {
            i2 |= startRestartGroup.changed(checkboxColors) ? 2048 : 1024;
        }
        if ((i & 24576) == 0) {
            i2 |= startRestartGroup.changedInstance(stroke) ? 16384 : 8192;
        }
        if ((196608 & i) == 0) {
            i2 |= startRestartGroup.changedInstance(stroke2) ? 131072 : 65536;
        }
        if (!startRestartGroup.shouldExecute((74899 & i2) != 74898, i2 & 1)) {
            composer2 = startRestartGroup;
            composer2.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-891330208, i2, -1, "androidx.compose.material3.CheckboxImpl (Checkbox.kt:401)");
            }
            int i8 = i2 >> 3;
            int i9 = i8 & 14;
            Transition updateTransition = TransitionKt.updateTransition(toggleableState, (String) null, startRestartGroup, i9, 2);
            final FiniteAnimationSpec value = MotionSchemeKt.value(MotionSchemeKeyTokens.DefaultSpatial, startRestartGroup, 6);
            Function3<Transition.Segment<ToggleableState>, Composer, Integer, FiniteAnimationSpec<Float>> function3 = new Function3<Transition.Segment<ToggleableState>, Composer, Integer, FiniteAnimationSpec<Float>>() { // from class: androidx.compose.material3.CheckboxKt$CheckboxImpl$checkDrawFraction$1
                @Override // kotlin.jvm.functions.Function3
                public /* bridge */ /* synthetic */ FiniteAnimationSpec<Float> invoke(Transition.Segment<ToggleableState> segment, Composer composer3, Integer num) {
                    return invoke(segment, composer3, num.intValue());
                }

                public final FiniteAnimationSpec<Float> invoke(Transition.Segment<ToggleableState> segment, Composer composer3, int i10) {
                    SnapSpec snap;
                    composer3.startReplaceGroup(1780794470);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1780794470, i10, -1, "androidx.compose.material3.CheckboxImpl.<anonymous> (Checkbox.kt:407)");
                    }
                    if (segment.getInitialState() == ToggleableState.Off) {
                        snap = value;
                    } else {
                        snap = segment.getTargetState() == ToggleableState.Off ? AnimationSpecKt.snap(100) : value;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    composer3.endReplaceGroup();
                    return snap;
                }
            };
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1338768149, "CC(animateFloat)P(2)1924@81822L78:Transition.kt#pdpnli");
            TwoWayConverter<Float, AnimationVector1D> vectorConverter = VectorConvertersKt.getVectorConverter(FloatCompanionObject.INSTANCE);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -142660079, "CC(animateValue)P(3,2)1833@77788L32,1834@77843L31,1835@77899L23,1837@77935L89:Transition.kt#pdpnli");
            ToggleableState toggleableState3 = (ToggleableState) updateTransition.getCurrentState();
            startRestartGroup.startReplaceGroup(-768316570);
            ComposerKt.sourceInformation(startRestartGroup, "CN(it):Checkbox.kt#uh7d8r");
            if (ComposerKt.isTraceInProgress()) {
                i3 = i2;
                i4 = i9;
                ComposerKt.traceEventStart(-768316570, 0, -1, "androidx.compose.material3.CheckboxImpl.<anonymous> (Checkbox.kt:415)");
            } else {
                i3 = i2;
                i4 = i9;
            }
            int i10 = WhenMappings.$EnumSwitchMapping$0[toggleableState3.ordinal()];
            if (i10 != 1) {
                if (i10 == 2) {
                    f = 0.0f;
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    startRestartGroup.endReplaceGroup();
                    Float valueOf = Float.valueOf(f);
                    ToggleableState toggleableState4 = (ToggleableState) updateTransition.getTargetState();
                    startRestartGroup.startReplaceGroup(-768316570);
                    ComposerKt.sourceInformation(startRestartGroup, "CN(it):Checkbox.kt#uh7d8r");
                    if (ComposerKt.isTraceInProgress()) {
                        f2 = valueOf;
                        toggleableState2 = toggleableState4;
                    } else {
                        f2 = valueOf;
                        toggleableState2 = toggleableState4;
                        ComposerKt.traceEventStart(-768316570, 0, -1, "androidx.compose.material3.CheckboxImpl.<anonymous> (Checkbox.kt:415)");
                    }
                    i5 = WhenMappings.$EnumSwitchMapping$0[toggleableState2.ordinal()];
                    if (i5 != 1) {
                        if (i5 == 2) {
                            f3 = 0.0f;
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            startRestartGroup.endReplaceGroup();
                            final State createTransitionAnimation = TransitionKt.createTransitionAnimation(updateTransition, f2, Float.valueOf(f3), function3.invoke(updateTransition.getSegment(), startRestartGroup, 0), vectorConverter, "FloatAnimation", startRestartGroup, 0);
                            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                            Function3<Transition.Segment<ToggleableState>, Composer, Integer, FiniteAnimationSpec<Float>> function32 = new Function3<Transition.Segment<ToggleableState>, Composer, Integer, FiniteAnimationSpec<Float>>() { // from class: androidx.compose.material3.CheckboxKt$CheckboxImpl$checkCenterGravitationShiftFraction$1
                                @Override // kotlin.jvm.functions.Function3
                                public /* bridge */ /* synthetic */ FiniteAnimationSpec<Float> invoke(Transition.Segment<ToggleableState> segment, Composer composer3, Integer num) {
                                    return invoke(segment, composer3, num.intValue());
                                }

                                public final FiniteAnimationSpec<Float> invoke(Transition.Segment<ToggleableState> segment, Composer composer3, int i11) {
                                    SnapSpec snap;
                                    composer3.startReplaceGroup(630790831);
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(630790831, i11, -1, "androidx.compose.material3.CheckboxImpl.<anonymous> (Checkbox.kt:425)");
                                    }
                                    if (segment.getInitialState() == ToggleableState.Off) {
                                        snap = AnimationSpecKt.snap$default(0, 1, null);
                                    } else {
                                        snap = segment.getTargetState() == ToggleableState.Off ? AnimationSpecKt.snap(100) : value;
                                    }
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                    }
                                    composer3.endReplaceGroup();
                                    return snap;
                                }
                            };
                            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1338768149, "CC(animateFloat)P(2)1924@81822L78:Transition.kt#pdpnli");
                            TwoWayConverter<Float, AnimationVector1D> vectorConverter2 = VectorConvertersKt.getVectorConverter(FloatCompanionObject.INSTANCE);
                            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -142660079, "CC(animateValue)P(3,2)1833@77788L32,1834@77843L31,1835@77899L23,1837@77935L89:Transition.kt#pdpnli");
                            ToggleableState toggleableState5 = (ToggleableState) updateTransition.getCurrentState();
                            startRestartGroup.startReplaceGroup(1840054703);
                            ComposerKt.sourceInformation(startRestartGroup, "CN(it):Checkbox.kt#uh7d8r");
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(1840054703, 0, -1, "androidx.compose.material3.CheckboxImpl.<anonymous> (Checkbox.kt:433)");
                            }
                            i6 = WhenMappings.$EnumSwitchMapping$0[toggleableState5.ordinal()];
                            if (i6 != 1 || i6 == 2) {
                                f4 = 0.0f;
                            } else if (i6 != 3) {
                                throw new NoWhenBranchMatchedException();
                            } else {
                                f4 = 1.0f;
                            }
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            startRestartGroup.endReplaceGroup();
                            Float valueOf2 = Float.valueOf(f4);
                            ToggleableState toggleableState6 = (ToggleableState) updateTransition.getTargetState();
                            startRestartGroup.startReplaceGroup(1840054703);
                            ComposerKt.sourceInformation(startRestartGroup, "CN(it):Checkbox.kt#uh7d8r");
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(1840054703, 0, -1, "androidx.compose.material3.CheckboxImpl.<anonymous> (Checkbox.kt:433)");
                            }
                            i7 = WhenMappings.$EnumSwitchMapping$0[toggleableState6.ordinal()];
                            if (i7 != 1 || i7 == 2) {
                                f5 = 0.0f;
                            } else if (i7 != 3) {
                                throw new NoWhenBranchMatchedException();
                            } else {
                                f5 = 1.0f;
                            }
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            startRestartGroup.endReplaceGroup();
                            final State createTransitionAnimation2 = TransitionKt.createTransitionAnimation(updateTransition, valueOf2, Float.valueOf(f5), function32.invoke(updateTransition.getSegment(), startRestartGroup, 0), vectorConverter2, "FloatAnimation", startRestartGroup, 0);
                            composer2 = startRestartGroup;
                            ComposerKt.sourceInformationMarkerEnd(composer2);
                            ComposerKt.sourceInformationMarkerEnd(composer2);
                            ComposerKt.sourceInformationMarkerStart(composer2, -1869784640, "CC(remember):Checkbox.kt#9igjgp");
                            rememberedValue = composer2.rememberedValue();
                            if (rememberedValue == Composer.Companion.getEmpty()) {
                                CheckDrawingCache checkDrawingCache = new CheckDrawingCache(null, null, null, 7, null);
                                composer2.updateRememberedValue(checkDrawingCache);
                                rememberedValue = checkDrawingCache;
                            }
                            final CheckDrawingCache checkDrawingCache2 = (CheckDrawingCache) rememberedValue;
                            ComposerKt.sourceInformationMarkerEnd(composer2);
                            final State<Color> checkmarkColor$material3 = checkboxColors.checkmarkColor$material3(toggleableState, composer2, i4 | ((i3 >> 6) & 112));
                            int i11 = (i8 & 896) | (i3 & WebSocketProtocol.PAYLOAD_SHORT);
                            final State<Color> boxColor$material3 = checkboxColors.boxColor$material3(z, toggleableState, composer2, i11);
                            final State<Color> borderColor$material3 = checkboxColors.borderColor$material3(z, toggleableState, composer2, i11);
                            Modifier m856requiredSize3ABfNKs = SizeKt.m856requiredSize3ABfNKs(SizeKt.wrapContentSize$default(modifier, Alignment.Companion.getCenter(), false, 2, null), CheckboxSize);
                            ComposerKt.sourceInformationMarkerStart(composer2, -1869775460, "CC(remember):Checkbox.kt#9igjgp");
                            changed = composer2.changed(boxColor$material3) | composer2.changed(borderColor$material3) | composer2.changedInstance(stroke2) | composer2.changed(checkmarkColor$material3) | composer2.changed(createTransitionAnimation) | composer2.changed(createTransitionAnimation2) | composer2.changedInstance(stroke);
                            rememberedValue2 = composer2.rememberedValue();
                            if (!changed || rememberedValue2 == Composer.Companion.getEmpty()) {
                                Function1 function1 = new Function1() { // from class: androidx.compose.material3.CheckboxKt$$ExternalSyntheticLambda0
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Object invoke(Object obj) {
                                        return CheckboxKt.CheckboxImpl$lambda$14$lambda$13(State.this, borderColor$material3, stroke2, checkmarkColor$material3, createTransitionAnimation, createTransitionAnimation2, stroke, checkDrawingCache2, (DrawScope) obj);
                                    }
                                };
                                composer2.updateRememberedValue(function1);
                                rememberedValue2 = function1;
                            }
                            ComposerKt.sourceInformationMarkerEnd(composer2);
                            CanvasKt.Canvas(m856requiredSize3ABfNKs, (Function1) rememberedValue2, composer2, 0);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                        } else if (i5 != 3) {
                            throw new NoWhenBranchMatchedException();
                        }
                    }
                    f3 = 1.0f;
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    startRestartGroup.endReplaceGroup();
                    final State createTransitionAnimation3 = TransitionKt.createTransitionAnimation(updateTransition, f2, Float.valueOf(f3), function3.invoke(updateTransition.getSegment(), startRestartGroup, 0), vectorConverter, "FloatAnimation", startRestartGroup, 0);
                    ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                    Function3<Transition.Segment<ToggleableState>, Composer, Integer, FiniteAnimationSpec<Float>> function322 = new Function3<Transition.Segment<ToggleableState>, Composer, Integer, FiniteAnimationSpec<Float>>() { // from class: androidx.compose.material3.CheckboxKt$CheckboxImpl$checkCenterGravitationShiftFraction$1
                        @Override // kotlin.jvm.functions.Function3
                        public /* bridge */ /* synthetic */ FiniteAnimationSpec<Float> invoke(Transition.Segment<ToggleableState> segment, Composer composer3, Integer num) {
                            return invoke(segment, composer3, num.intValue());
                        }

                        public final FiniteAnimationSpec<Float> invoke(Transition.Segment<ToggleableState> segment, Composer composer3, int i112) {
                            SnapSpec snap;
                            composer3.startReplaceGroup(630790831);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(630790831, i112, -1, "androidx.compose.material3.CheckboxImpl.<anonymous> (Checkbox.kt:425)");
                            }
                            if (segment.getInitialState() == ToggleableState.Off) {
                                snap = AnimationSpecKt.snap$default(0, 1, null);
                            } else {
                                snap = segment.getTargetState() == ToggleableState.Off ? AnimationSpecKt.snap(100) : value;
                            }
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            composer3.endReplaceGroup();
                            return snap;
                        }
                    };
                    ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1338768149, "CC(animateFloat)P(2)1924@81822L78:Transition.kt#pdpnli");
                    TwoWayConverter<Float, AnimationVector1D> vectorConverter22 = VectorConvertersKt.getVectorConverter(FloatCompanionObject.INSTANCE);
                    ComposerKt.sourceInformationMarkerStart(startRestartGroup, -142660079, "CC(animateValue)P(3,2)1833@77788L32,1834@77843L31,1835@77899L23,1837@77935L89:Transition.kt#pdpnli");
                    ToggleableState toggleableState52 = (ToggleableState) updateTransition.getCurrentState();
                    startRestartGroup.startReplaceGroup(1840054703);
                    ComposerKt.sourceInformation(startRestartGroup, "CN(it):Checkbox.kt#uh7d8r");
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    i6 = WhenMappings.$EnumSwitchMapping$0[toggleableState52.ordinal()];
                    if (i6 != 1) {
                    }
                    f4 = 0.0f;
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    startRestartGroup.endReplaceGroup();
                    Float valueOf22 = Float.valueOf(f4);
                    ToggleableState toggleableState62 = (ToggleableState) updateTransition.getTargetState();
                    startRestartGroup.startReplaceGroup(1840054703);
                    ComposerKt.sourceInformation(startRestartGroup, "CN(it):Checkbox.kt#uh7d8r");
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    i7 = WhenMappings.$EnumSwitchMapping$0[toggleableState62.ordinal()];
                    if (i7 != 1) {
                    }
                    f5 = 0.0f;
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    startRestartGroup.endReplaceGroup();
                    final State createTransitionAnimation22 = TransitionKt.createTransitionAnimation(updateTransition, valueOf22, Float.valueOf(f5), function322.invoke(updateTransition.getSegment(), startRestartGroup, 0), vectorConverter22, "FloatAnimation", startRestartGroup, 0);
                    composer2 = startRestartGroup;
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    ComposerKt.sourceInformationMarkerStart(composer2, -1869784640, "CC(remember):Checkbox.kt#9igjgp");
                    rememberedValue = composer2.rememberedValue();
                    if (rememberedValue == Composer.Companion.getEmpty()) {
                    }
                    final CheckDrawingCache checkDrawingCache22 = (CheckDrawingCache) rememberedValue;
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    final State checkmarkColor$material32 = checkboxColors.checkmarkColor$material3(toggleableState, composer2, i4 | ((i3 >> 6) & 112));
                    int i112 = (i8 & 896) | (i3 & WebSocketProtocol.PAYLOAD_SHORT);
                    final State boxColor$material32 = checkboxColors.boxColor$material3(z, toggleableState, composer2, i112);
                    final State borderColor$material32 = checkboxColors.borderColor$material3(z, toggleableState, composer2, i112);
                    Modifier m856requiredSize3ABfNKs2 = SizeKt.m856requiredSize3ABfNKs(SizeKt.wrapContentSize$default(modifier, Alignment.Companion.getCenter(), false, 2, null), CheckboxSize);
                    ComposerKt.sourceInformationMarkerStart(composer2, -1869775460, "CC(remember):Checkbox.kt#9igjgp");
                    changed = composer2.changed(boxColor$material32) | composer2.changed(borderColor$material32) | composer2.changedInstance(stroke2) | composer2.changed(checkmarkColor$material32) | composer2.changed(createTransitionAnimation3) | composer2.changed(createTransitionAnimation22) | composer2.changedInstance(stroke);
                    rememberedValue2 = composer2.rememberedValue();
                    if (!changed) {
                    }
                    Function1 function12 = new Function1() { // from class: androidx.compose.material3.CheckboxKt$$ExternalSyntheticLambda0
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return CheckboxKt.CheckboxImpl$lambda$14$lambda$13(State.this, borderColor$material32, stroke2, checkmarkColor$material32, createTransitionAnimation3, createTransitionAnimation22, stroke, checkDrawingCache22, (DrawScope) obj);
                        }
                    };
                    composer2.updateRememberedValue(function12);
                    rememberedValue2 = function12;
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    CanvasKt.Canvas(m856requiredSize3ABfNKs2, (Function1) rememberedValue2, composer2, 0);
                    if (ComposerKt.isTraceInProgress()) {
                    }
                } else if (i10 != 3) {
                    throw new NoWhenBranchMatchedException();
                }
            }
            f = 1.0f;
            if (ComposerKt.isTraceInProgress()) {
            }
            startRestartGroup.endReplaceGroup();
            Float valueOf3 = Float.valueOf(f);
            ToggleableState toggleableState42 = (ToggleableState) updateTransition.getTargetState();
            startRestartGroup.startReplaceGroup(-768316570);
            ComposerKt.sourceInformation(startRestartGroup, "CN(it):Checkbox.kt#uh7d8r");
            if (ComposerKt.isTraceInProgress()) {
            }
            i5 = WhenMappings.$EnumSwitchMapping$0[toggleableState2.ordinal()];
            if (i5 != 1) {
            }
            f3 = 1.0f;
            if (ComposerKt.isTraceInProgress()) {
            }
            startRestartGroup.endReplaceGroup();
            final State createTransitionAnimation32 = TransitionKt.createTransitionAnimation(updateTransition, f2, Float.valueOf(f3), function3.invoke(updateTransition.getSegment(), startRestartGroup, 0), vectorConverter, "FloatAnimation", startRestartGroup, 0);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            Function3<Transition.Segment<ToggleableState>, Composer, Integer, FiniteAnimationSpec<Float>> function3222 = new Function3<Transition.Segment<ToggleableState>, Composer, Integer, FiniteAnimationSpec<Float>>() { // from class: androidx.compose.material3.CheckboxKt$CheckboxImpl$checkCenterGravitationShiftFraction$1
                @Override // kotlin.jvm.functions.Function3
                public /* bridge */ /* synthetic */ FiniteAnimationSpec<Float> invoke(Transition.Segment<ToggleableState> segment, Composer composer3, Integer num) {
                    return invoke(segment, composer3, num.intValue());
                }

                public final FiniteAnimationSpec<Float> invoke(Transition.Segment<ToggleableState> segment, Composer composer3, int i1122) {
                    SnapSpec snap;
                    composer3.startReplaceGroup(630790831);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(630790831, i1122, -1, "androidx.compose.material3.CheckboxImpl.<anonymous> (Checkbox.kt:425)");
                    }
                    if (segment.getInitialState() == ToggleableState.Off) {
                        snap = AnimationSpecKt.snap$default(0, 1, null);
                    } else {
                        snap = segment.getTargetState() == ToggleableState.Off ? AnimationSpecKt.snap(100) : value;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    composer3.endReplaceGroup();
                    return snap;
                }
            };
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1338768149, "CC(animateFloat)P(2)1924@81822L78:Transition.kt#pdpnli");
            TwoWayConverter<Float, AnimationVector1D> vectorConverter222 = VectorConvertersKt.getVectorConverter(FloatCompanionObject.INSTANCE);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -142660079, "CC(animateValue)P(3,2)1833@77788L32,1834@77843L31,1835@77899L23,1837@77935L89:Transition.kt#pdpnli");
            ToggleableState toggleableState522 = (ToggleableState) updateTransition.getCurrentState();
            startRestartGroup.startReplaceGroup(1840054703);
            ComposerKt.sourceInformation(startRestartGroup, "CN(it):Checkbox.kt#uh7d8r");
            if (ComposerKt.isTraceInProgress()) {
            }
            i6 = WhenMappings.$EnumSwitchMapping$0[toggleableState522.ordinal()];
            if (i6 != 1) {
            }
            f4 = 0.0f;
            if (ComposerKt.isTraceInProgress()) {
            }
            startRestartGroup.endReplaceGroup();
            Float valueOf222 = Float.valueOf(f4);
            ToggleableState toggleableState622 = (ToggleableState) updateTransition.getTargetState();
            startRestartGroup.startReplaceGroup(1840054703);
            ComposerKt.sourceInformation(startRestartGroup, "CN(it):Checkbox.kt#uh7d8r");
            if (ComposerKt.isTraceInProgress()) {
            }
            i7 = WhenMappings.$EnumSwitchMapping$0[toggleableState622.ordinal()];
            if (i7 != 1) {
            }
            f5 = 0.0f;
            if (ComposerKt.isTraceInProgress()) {
            }
            startRestartGroup.endReplaceGroup();
            final State createTransitionAnimation222 = TransitionKt.createTransitionAnimation(updateTransition, valueOf222, Float.valueOf(f5), function3222.invoke(updateTransition.getSegment(), startRestartGroup, 0), vectorConverter222, "FloatAnimation", startRestartGroup, 0);
            composer2 = startRestartGroup;
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerStart(composer2, -1869784640, "CC(remember):Checkbox.kt#9igjgp");
            rememberedValue = composer2.rememberedValue();
            if (rememberedValue == Composer.Companion.getEmpty()) {
            }
            final CheckDrawingCache checkDrawingCache222 = (CheckDrawingCache) rememberedValue;
            ComposerKt.sourceInformationMarkerEnd(composer2);
            final State checkmarkColor$material322 = checkboxColors.checkmarkColor$material3(toggleableState, composer2, i4 | ((i3 >> 6) & 112));
            int i1122 = (i8 & 896) | (i3 & WebSocketProtocol.PAYLOAD_SHORT);
            final State boxColor$material322 = checkboxColors.boxColor$material3(z, toggleableState, composer2, i1122);
            final State borderColor$material322 = checkboxColors.borderColor$material3(z, toggleableState, composer2, i1122);
            Modifier m856requiredSize3ABfNKs22 = SizeKt.m856requiredSize3ABfNKs(SizeKt.wrapContentSize$default(modifier, Alignment.Companion.getCenter(), false, 2, null), CheckboxSize);
            ComposerKt.sourceInformationMarkerStart(composer2, -1869775460, "CC(remember):Checkbox.kt#9igjgp");
            changed = composer2.changed(boxColor$material322) | composer2.changed(borderColor$material322) | composer2.changedInstance(stroke2) | composer2.changed(checkmarkColor$material322) | composer2.changed(createTransitionAnimation32) | composer2.changed(createTransitionAnimation222) | composer2.changedInstance(stroke);
            rememberedValue2 = composer2.rememberedValue();
            if (!changed) {
            }
            Function1 function122 = new Function1() { // from class: androidx.compose.material3.CheckboxKt$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return CheckboxKt.CheckboxImpl$lambda$14$lambda$13(State.this, borderColor$material322, stroke2, checkmarkColor$material322, createTransitionAnimation32, createTransitionAnimation222, stroke, checkDrawingCache222, (DrawScope) obj);
                }
            };
            composer2.updateRememberedValue(function122);
            rememberedValue2 = function122;
            ComposerKt.sourceInformationMarkerEnd(composer2);
            CanvasKt.Canvas(m856requiredSize3ABfNKs22, (Function1) rememberedValue2, composer2, 0);
            if (ComposerKt.isTraceInProgress()) {
            }
        }
        ScopeUpdateScope endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.CheckboxKt$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return CheckboxKt.CheckboxImpl$lambda$15(z, toggleableState, modifier, checkboxColors, stroke, stroke2, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit CheckboxImpl$lambda$14$lambda$13(State state, State state2, Stroke stroke, State state3, State state4, State state5, Stroke stroke2, CheckDrawingCache checkDrawingCache, DrawScope drawScope) {
        m1805drawBox1wkBAMs(drawScope, ((Color) state.getValue()).m4782unboximpl(), ((Color) state2.getValue()).m4782unboximpl(), drawScope.mo405toPx0680j_4(RadiusSize), stroke);
        m1806drawCheck3IgeMak(drawScope, ((Color) state3.getValue()).m4782unboximpl(), ((Number) state4.getValue()).floatValue(), ((Number) state5.getValue()).floatValue(), stroke2, checkDrawingCache);
        return Unit.INSTANCE;
    }

    /* renamed from: drawBox-1wkBAMs  reason: not valid java name */
    private static final void m1805drawBox1wkBAMs(DrawScope drawScope, long j, long j2, float f, Stroke stroke) {
        float width = stroke.getWidth() / 2.0f;
        float intBitsToFloat = Float.intBitsToFloat((int) (drawScope.mo5346getSizeNHjbRc() >> 32));
        if (Color.m4773equalsimpl0(j, j2)) {
            DrawScope.m5342drawRoundRectuAw5IA$default(drawScope, j, 0L, Size.m4587constructorimpl((Float.floatToRawIntBits(intBitsToFloat) << 32) | (Float.floatToRawIntBits(intBitsToFloat) & 4294967295L)), CornerRadius.m4481constructorimpl((Float.floatToRawIntBits(f) << 32) | (Float.floatToRawIntBits(f) & 4294967295L)), Fill.INSTANCE, 0.0f, null, 0, 226, null);
            return;
        }
        float width2 = stroke.getWidth();
        float width3 = stroke.getWidth();
        long m4519constructorimpl = Offset.m4519constructorimpl((Float.floatToRawIntBits(width2) << 32) | (Float.floatToRawIntBits(width3) & 4294967295L));
        long m4587constructorimpl = Size.m4587constructorimpl((Float.floatToRawIntBits(intBitsToFloat - (stroke.getWidth() * 2.0f)) << 32) | (Float.floatToRawIntBits(intBitsToFloat - (stroke.getWidth() * 2.0f)) & 4294967295L));
        float max = Math.max(0.0f, f - stroke.getWidth());
        DrawScope.m5342drawRoundRectuAw5IA$default(drawScope, j, m4519constructorimpl, m4587constructorimpl, CornerRadius.m4481constructorimpl((Float.floatToRawIntBits(max) << 32) | (Float.floatToRawIntBits(max) & 4294967295L)), Fill.INSTANCE, 0.0f, null, 0, 224, null);
        float f2 = f - width;
        DrawScope.m5342drawRoundRectuAw5IA$default(drawScope, j2, Offset.m4519constructorimpl((Float.floatToRawIntBits(width) << 32) | (Float.floatToRawIntBits(width) & 4294967295L)), Size.m4587constructorimpl((Float.floatToRawIntBits(intBitsToFloat - stroke.getWidth()) & 4294967295L) | (Float.floatToRawIntBits(intBitsToFloat - stroke.getWidth()) << 32)), CornerRadius.m4481constructorimpl((Float.floatToRawIntBits(f2) << 32) | (Float.floatToRawIntBits(f2) & 4294967295L)), stroke, 0.0f, null, 0, 224, null);
    }

    /* renamed from: drawCheck-3IgeMak  reason: not valid java name */
    private static final void m1806drawCheck3IgeMak(DrawScope drawScope, long j, float f, float f2, Stroke stroke, CheckDrawingCache checkDrawingCache) {
        float intBitsToFloat = Float.intBitsToFloat((int) (drawScope.mo5346getSizeNHjbRc() >> 32));
        float lerp = MathHelpersKt.lerp(0.4f, 0.5f, f2);
        float lerp2 = MathHelpersKt.lerp(0.7f, 0.5f, f2);
        float lerp3 = MathHelpersKt.lerp(0.5f, 0.5f, f2);
        float lerp4 = MathHelpersKt.lerp(0.3f, 0.5f, f2);
        checkDrawingCache.getCheckPath().rewind();
        checkDrawingCache.getCheckPath().moveTo(0.2f * intBitsToFloat, lerp3 * intBitsToFloat);
        checkDrawingCache.getCheckPath().lineTo(lerp * intBitsToFloat, lerp2 * intBitsToFloat);
        checkDrawingCache.getCheckPath().lineTo(0.8f * intBitsToFloat, intBitsToFloat * lerp4);
        checkDrawingCache.getPathMeasure().setPath(checkDrawingCache.getCheckPath(), false);
        checkDrawingCache.getPathToDraw().rewind();
        checkDrawingCache.getPathMeasure().getSegment(0.0f, checkDrawingCache.getPathMeasure().getLength() * f, checkDrawingCache.getPathToDraw(), true);
        DrawScope.m5336drawPathLG529CI$default(drawScope, checkDrawingCache.getPathToDraw(), j, 0.0f, stroke, null, 0, 52, null);
    }
}
