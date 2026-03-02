package androidx.compose.material3;

import androidx.compose.animation.SingleValueAnimationKt;
import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.animation.core.FiniteAnimationSpec;
import androidx.compose.material3.tokens.MotionSchemeKeyTokens;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.state.ToggleableState;
import com.google.firebase.remoteconfig.RemoteConfigConstants;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import okhttp3.internal.ws.WebSocketProtocol;
/* compiled from: Checkbox.kt */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\b\u0007\u0018\u00002\u00020\u0001Bg\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u0003\u0012\u0006\u0010\u000b\u001a\u00020\u0003\u0012\u0006\u0010\f\u001a\u00020\u0003\u0012\u0006\u0010\r\u001a\u00020\u0003\u0012\u0006\u0010\u000e\u001a\u00020\u0003¢\u0006\u0004\b\u000f\u0010\u0010J\u0085\u0001\u0010\u001f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\u00032\b\b\u0002\u0010\f\u001a\u00020\u00032\b\b\u0002\u0010\r\u001a\u00020\u00032\b\b\u0002\u0010\u000e\u001a\u00020\u0003¢\u0006\u0004\b \u0010!J\u001d\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00030#2\u0006\u0010$\u001a\u00020%H\u0001¢\u0006\u0004\b&\u0010'J%\u0010(\u001a\b\u0012\u0004\u0012\u00020\u00030#2\u0006\u0010)\u001a\u00020*2\u0006\u0010$\u001a\u00020%H\u0001¢\u0006\u0004\b+\u0010,J%\u0010-\u001a\b\u0012\u0004\u0012\u00020\u00030#2\u0006\u0010)\u001a\u00020*2\u0006\u0010$\u001a\u00020%H\u0001¢\u0006\u0004\b.\u0010,J\u001b\u0010/\u001a\b\u0012\u0004\u0012\u00020\u0003002\u0006\u0010$\u001a\u00020%H\u0003¢\u0006\u0002\u00101J\u0013\u00102\u001a\u00020*2\b\u00103\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u00104\u001a\u000205H\u0016R\u0013\u0010\u0002\u001a\u00020\u0003¢\u0006\n\n\u0002\u0010\u0013\u001a\u0004\b\u0011\u0010\u0012R\u0013\u0010\u0004\u001a\u00020\u0003¢\u0006\n\n\u0002\u0010\u0013\u001a\u0004\b\u0014\u0010\u0012R\u0013\u0010\u0005\u001a\u00020\u0003¢\u0006\n\n\u0002\u0010\u0013\u001a\u0004\b\u0015\u0010\u0012R\u0013\u0010\u0006\u001a\u00020\u0003¢\u0006\n\n\u0002\u0010\u0013\u001a\u0004\b\u0016\u0010\u0012R\u0013\u0010\u0007\u001a\u00020\u0003¢\u0006\n\n\u0002\u0010\u0013\u001a\u0004\b\u0017\u0010\u0012R\u0013\u0010\b\u001a\u00020\u0003¢\u0006\n\n\u0002\u0010\u0013\u001a\u0004\b\u0018\u0010\u0012R\u0013\u0010\t\u001a\u00020\u0003¢\u0006\n\n\u0002\u0010\u0013\u001a\u0004\b\u0019\u0010\u0012R\u0013\u0010\n\u001a\u00020\u0003¢\u0006\n\n\u0002\u0010\u0013\u001a\u0004\b\u001a\u0010\u0012R\u0013\u0010\u000b\u001a\u00020\u0003¢\u0006\n\n\u0002\u0010\u0013\u001a\u0004\b\u001b\u0010\u0012R\u0013\u0010\f\u001a\u00020\u0003¢\u0006\n\n\u0002\u0010\u0013\u001a\u0004\b\u001c\u0010\u0012R\u0013\u0010\r\u001a\u00020\u0003¢\u0006\n\n\u0002\u0010\u0013\u001a\u0004\b\u001d\u0010\u0012R\u0013\u0010\u000e\u001a\u00020\u0003¢\u0006\n\n\u0002\u0010\u0013\u001a\u0004\b\u001e\u0010\u0012¨\u00066"}, d2 = {"Landroidx/compose/material3/CheckboxColors;", "", "checkedCheckmarkColor", "Landroidx/compose/ui/graphics/Color;", "uncheckedCheckmarkColor", "checkedBoxColor", "uncheckedBoxColor", "disabledCheckedBoxColor", "disabledUncheckedBoxColor", "disabledIndeterminateBoxColor", "checkedBorderColor", "uncheckedBorderColor", "disabledBorderColor", "disabledUncheckedBorderColor", "disabledIndeterminateBorderColor", "<init>", "(JJJJJJJJJJJJLkotlin/jvm/internal/DefaultConstructorMarker;)V", "getCheckedCheckmarkColor-0d7_KjU", "()J", "J", "getUncheckedCheckmarkColor-0d7_KjU", "getCheckedBoxColor-0d7_KjU", "getUncheckedBoxColor-0d7_KjU", "getDisabledCheckedBoxColor-0d7_KjU", "getDisabledUncheckedBoxColor-0d7_KjU", "getDisabledIndeterminateBoxColor-0d7_KjU", "getCheckedBorderColor-0d7_KjU", "getUncheckedBorderColor-0d7_KjU", "getDisabledBorderColor-0d7_KjU", "getDisabledUncheckedBorderColor-0d7_KjU", "getDisabledIndeterminateBorderColor-0d7_KjU", "copy", "copy-2qZNXz8", "(JJJJJJJJJJJJ)Landroidx/compose/material3/CheckboxColors;", "checkmarkColor", "Landroidx/compose/runtime/State;", RemoteConfigConstants.ResponseFieldKey.STATE, "Landroidx/compose/ui/state/ToggleableState;", "checkmarkColor$material3", "(Landroidx/compose/ui/state/ToggleableState;Landroidx/compose/runtime/Composer;I)Landroidx/compose/runtime/State;", "boxColor", "enabled", "", "boxColor$material3", "(ZLandroidx/compose/ui/state/ToggleableState;Landroidx/compose/runtime/Composer;I)Landroidx/compose/runtime/State;", "borderColor", "borderColor$material3", "colorAnimationSpecForState", "Landroidx/compose/animation/core/AnimationSpec;", "(Landroidx/compose/ui/state/ToggleableState;Landroidx/compose/runtime/Composer;I)Landroidx/compose/animation/core/AnimationSpec;", "equals", "other", "hashCode", "", "material3"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public final class CheckboxColors {
    public static final int $stable = 0;
    private final long checkedBorderColor;
    private final long checkedBoxColor;
    private final long checkedCheckmarkColor;
    private final long disabledBorderColor;
    private final long disabledCheckedBoxColor;
    private final long disabledIndeterminateBorderColor;
    private final long disabledIndeterminateBoxColor;
    private final long disabledUncheckedBorderColor;
    private final long disabledUncheckedBoxColor;
    private final long uncheckedBorderColor;
    private final long uncheckedBoxColor;
    private final long uncheckedCheckmarkColor;

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
                iArr[ToggleableState.Indeterminate.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[ToggleableState.Off.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public /* synthetic */ CheckboxColors(long j, long j2, long j3, long j4, long j5, long j6, long j7, long j8, long j9, long j10, long j11, long j12, DefaultConstructorMarker defaultConstructorMarker) {
        this(j, j2, j3, j4, j5, j6, j7, j8, j9, j10, j11, j12);
    }

    private CheckboxColors(long j, long j2, long j3, long j4, long j5, long j6, long j7, long j8, long j9, long j10, long j11, long j12) {
        this.checkedCheckmarkColor = j;
        this.uncheckedCheckmarkColor = j2;
        this.checkedBoxColor = j3;
        this.uncheckedBoxColor = j4;
        this.disabledCheckedBoxColor = j5;
        this.disabledUncheckedBoxColor = j6;
        this.disabledIndeterminateBoxColor = j7;
        this.checkedBorderColor = j8;
        this.uncheckedBorderColor = j9;
        this.disabledBorderColor = j10;
        this.disabledUncheckedBorderColor = j11;
        this.disabledIndeterminateBorderColor = j12;
    }

    /* renamed from: getCheckedCheckmarkColor-0d7_KjU  reason: not valid java name */
    public final long m1793getCheckedCheckmarkColor0d7_KjU() {
        return this.checkedCheckmarkColor;
    }

    /* renamed from: getUncheckedCheckmarkColor-0d7_KjU  reason: not valid java name */
    public final long m1802getUncheckedCheckmarkColor0d7_KjU() {
        return this.uncheckedCheckmarkColor;
    }

    /* renamed from: getCheckedBoxColor-0d7_KjU  reason: not valid java name */
    public final long m1792getCheckedBoxColor0d7_KjU() {
        return this.checkedBoxColor;
    }

    /* renamed from: getUncheckedBoxColor-0d7_KjU  reason: not valid java name */
    public final long m1801getUncheckedBoxColor0d7_KjU() {
        return this.uncheckedBoxColor;
    }

    /* renamed from: getDisabledCheckedBoxColor-0d7_KjU  reason: not valid java name */
    public final long m1795getDisabledCheckedBoxColor0d7_KjU() {
        return this.disabledCheckedBoxColor;
    }

    /* renamed from: getDisabledUncheckedBoxColor-0d7_KjU  reason: not valid java name */
    public final long m1799getDisabledUncheckedBoxColor0d7_KjU() {
        return this.disabledUncheckedBoxColor;
    }

    /* renamed from: getDisabledIndeterminateBoxColor-0d7_KjU  reason: not valid java name */
    public final long m1797getDisabledIndeterminateBoxColor0d7_KjU() {
        return this.disabledIndeterminateBoxColor;
    }

    /* renamed from: getCheckedBorderColor-0d7_KjU  reason: not valid java name */
    public final long m1791getCheckedBorderColor0d7_KjU() {
        return this.checkedBorderColor;
    }

    /* renamed from: getUncheckedBorderColor-0d7_KjU  reason: not valid java name */
    public final long m1800getUncheckedBorderColor0d7_KjU() {
        return this.uncheckedBorderColor;
    }

    /* renamed from: getDisabledBorderColor-0d7_KjU  reason: not valid java name */
    public final long m1794getDisabledBorderColor0d7_KjU() {
        return this.disabledBorderColor;
    }

    /* renamed from: getDisabledUncheckedBorderColor-0d7_KjU  reason: not valid java name */
    public final long m1798getDisabledUncheckedBorderColor0d7_KjU() {
        return this.disabledUncheckedBorderColor;
    }

    /* renamed from: getDisabledIndeterminateBorderColor-0d7_KjU  reason: not valid java name */
    public final long m1796getDisabledIndeterminateBorderColor0d7_KjU() {
        return this.disabledIndeterminateBorderColor;
    }

    /* renamed from: copy-2qZNXz8$default  reason: not valid java name */
    public static /* synthetic */ CheckboxColors m1789copy2qZNXz8$default(CheckboxColors checkboxColors, long j, long j2, long j3, long j4, long j5, long j6, long j7, long j8, long j9, long j10, long j11, long j12, int i, Object obj) {
        long j13;
        long j14;
        long j15 = (i & 1) != 0 ? checkboxColors.checkedCheckmarkColor : j;
        long j16 = (i & 2) != 0 ? checkboxColors.uncheckedCheckmarkColor : j2;
        long j17 = (i & 4) != 0 ? checkboxColors.checkedBoxColor : j3;
        long j18 = (i & 8) != 0 ? checkboxColors.uncheckedBoxColor : j4;
        long j19 = (i & 16) != 0 ? checkboxColors.disabledCheckedBoxColor : j5;
        long j20 = (i & 32) != 0 ? checkboxColors.disabledUncheckedBoxColor : j6;
        long j21 = (i & 64) != 0 ? checkboxColors.disabledIndeterminateBoxColor : j7;
        long j22 = j15;
        long j23 = (i & 128) != 0 ? checkboxColors.checkedBorderColor : j8;
        long j24 = (i & 256) != 0 ? checkboxColors.uncheckedBorderColor : j9;
        long j25 = (i & 512) != 0 ? checkboxColors.disabledBorderColor : j10;
        long j26 = (i & 1024) != 0 ? checkboxColors.disabledUncheckedBorderColor : j11;
        if ((i & 2048) != 0) {
            j14 = j26;
            j13 = checkboxColors.disabledIndeterminateBorderColor;
        } else {
            j13 = j12;
            j14 = j26;
        }
        return checkboxColors.m1790copy2qZNXz8(j22, j16, j17, j18, j19, j20, j21, j23, j24, j25, j14, j13);
    }

    /* renamed from: copy-2qZNXz8  reason: not valid java name */
    public final CheckboxColors m1790copy2qZNXz8(long j, long j2, long j3, long j4, long j5, long j6, long j7, long j8, long j9, long j10, long j11, long j12) {
        return new CheckboxColors(j != 16 ? j : this.checkedCheckmarkColor, j2 != 16 ? j2 : this.uncheckedCheckmarkColor, j3 != 16 ? j3 : this.checkedBoxColor, j4 != 16 ? j4 : this.uncheckedBoxColor, j5 != 16 ? j5 : this.disabledCheckedBoxColor, j6 != 16 ? j6 : this.disabledUncheckedBoxColor, j7 != 16 ? j7 : this.disabledIndeterminateBoxColor, j8 != 16 ? j8 : this.checkedBorderColor, j9 != 16 ? j9 : this.uncheckedBorderColor, j10 != 16 ? j10 : this.disabledBorderColor, j11 != 16 ? j11 : this.disabledUncheckedBorderColor, j12 != 16 ? j12 : this.disabledIndeterminateBorderColor, null);
    }

    public final State<Color> checkmarkColor$material3(ToggleableState toggleableState, Composer composer, int i) {
        long j;
        ComposerKt.sourceInformationMarkerStart(composer, -507585681, "C(checkmarkColor)N(state)614@28208L33,614@28180L62:Checkbox.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-507585681, i, -1, "androidx.compose.material3.CheckboxColors.checkmarkColor (Checkbox.kt:606)");
        }
        if (toggleableState == ToggleableState.Off) {
            j = this.uncheckedCheckmarkColor;
        } else {
            j = this.checkedCheckmarkColor;
        }
        State<Color> m134animateColorAsStateeuL9pac = SingleValueAnimationKt.m134animateColorAsStateeuL9pac(j, colorAnimationSpecForState(toggleableState, composer, i & WebSocketProtocol.PAYLOAD_SHORT), null, null, composer, 0, 12);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return m134animateColorAsStateeuL9pac;
    }

    public final State<Color> boxColor$material3(boolean z, ToggleableState toggleableState, Composer composer, int i) {
        long j;
        Composer composer2;
        State<Color> rememberUpdatedState;
        ComposerKt.sourceInformationMarkerStart(composer, 360729865, "C(boxColor)N(enabled,state):Checkbox.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(360729865, i, -1, "androidx.compose.material3.CheckboxColors.boxColor (Checkbox.kt:625)");
        }
        if (z) {
            int i2 = WhenMappings.$EnumSwitchMapping$0[toggleableState.ordinal()];
            if (i2 == 1 || i2 == 2) {
                j = this.checkedBoxColor;
            } else if (i2 != 3) {
                throw new NoWhenBranchMatchedException();
            } else {
                j = this.uncheckedBoxColor;
            }
        } else {
            int i3 = WhenMappings.$EnumSwitchMapping$0[toggleableState.ordinal()];
            if (i3 == 1) {
                j = this.disabledCheckedBoxColor;
            } else if (i3 == 2) {
                j = this.disabledIndeterminateBoxColor;
            } else if (i3 != 3) {
                throw new NoWhenBranchMatchedException();
            } else {
                j = this.disabledUncheckedBoxColor;
            }
        }
        long j2 = j;
        if (z) {
            composer.startReplaceGroup(496051715);
            ComposerKt.sourceInformation(composer, "644@29378L33,644@29350L62");
            composer2 = composer;
            rememberUpdatedState = SingleValueAnimationKt.m134animateColorAsStateeuL9pac(j2, colorAnimationSpecForState(toggleableState, composer, (i >> 3) & WebSocketProtocol.PAYLOAD_SHORT), null, null, composer2, 0, 12);
            composer2.endReplaceGroup();
        } else {
            composer2 = composer;
            composer2.startReplaceGroup(496141925);
            ComposerKt.sourceInformation(composer2, "646@29442L28");
            rememberUpdatedState = SnapshotStateKt.rememberUpdatedState(Color.m4762boximpl(j2), composer2, 0);
            composer2.endReplaceGroup();
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer2);
        return rememberUpdatedState;
    }

    public final State<Color> borderColor$material3(boolean z, ToggleableState toggleableState, Composer composer, int i) {
        long j;
        Composer composer2;
        State<Color> rememberUpdatedState;
        ComposerKt.sourceInformationMarkerStart(composer, 1009643462, "C(borderColor)N(enabled,state):Checkbox.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1009643462, i, -1, "androidx.compose.material3.CheckboxColors.borderColor (Checkbox.kt:657)");
        }
        if (z) {
            int i2 = WhenMappings.$EnumSwitchMapping$0[toggleableState.ordinal()];
            if (i2 == 1 || i2 == 2) {
                j = this.checkedBorderColor;
            } else if (i2 != 3) {
                throw new NoWhenBranchMatchedException();
            } else {
                j = this.uncheckedBorderColor;
            }
        } else {
            int i3 = WhenMappings.$EnumSwitchMapping$0[toggleableState.ordinal()];
            if (i3 == 1) {
                j = this.disabledBorderColor;
            } else if (i3 == 2) {
                j = this.disabledIndeterminateBorderColor;
            } else if (i3 != 3) {
                throw new NoWhenBranchMatchedException();
            } else {
                j = this.disabledUncheckedBorderColor;
            }
        }
        long j2 = j;
        if (z) {
            composer.startReplaceGroup(633231558);
            ComposerKt.sourceInformation(composer, "676@30610L33,676@30582L62");
            composer2 = composer;
            rememberUpdatedState = SingleValueAnimationKt.m134animateColorAsStateeuL9pac(j2, colorAnimationSpecForState(toggleableState, composer, (i >> 3) & WebSocketProtocol.PAYLOAD_SHORT), null, null, composer2, 0, 12);
            composer2.endReplaceGroup();
        } else {
            composer2 = composer;
            composer2.startReplaceGroup(633321768);
            ComposerKt.sourceInformation(composer2, "678@30674L28");
            rememberUpdatedState = SnapshotStateKt.rememberUpdatedState(Color.m4762boximpl(j2), composer2, 0);
            composer2.endReplaceGroup();
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer2);
        return rememberUpdatedState;
    }

    private final AnimationSpec<Color> colorAnimationSpecForState(ToggleableState toggleableState, Composer composer, int i) {
        FiniteAnimationSpec finiteAnimationSpec;
        ComposerKt.sourceInformationMarkerStart(composer, -1075456245, "C(colorAnimationSpecForState)N(state):Checkbox.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1075456245, i, -1, "androidx.compose.material3.CheckboxColors.colorAnimationSpecForState (Checkbox.kt:684)");
        }
        if (toggleableState == ToggleableState.Off) {
            composer.startReplaceGroup(1539262271);
            ComposerKt.sourceInformation(composer, "688@31089L7");
            FiniteAnimationSpec value = MotionSchemeKt.value(MotionSchemeKeyTokens.FastEffects, composer, 6);
            composer.endReplaceGroup();
            finiteAnimationSpec = value;
        } else {
            composer.startReplaceGroup(1539355581);
            ComposerKt.sourceInformation(composer, "691@31185L7");
            FiniteAnimationSpec value2 = MotionSchemeKt.value(MotionSchemeKeyTokens.DefaultEffects, composer, 6);
            composer.endReplaceGroup();
            finiteAnimationSpec = value2;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return finiteAnimationSpec;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof CheckboxColors)) {
            return false;
        }
        CheckboxColors checkboxColors = (CheckboxColors) obj;
        return Color.m4773equalsimpl0(this.checkedCheckmarkColor, checkboxColors.checkedCheckmarkColor) && Color.m4773equalsimpl0(this.uncheckedCheckmarkColor, checkboxColors.uncheckedCheckmarkColor) && Color.m4773equalsimpl0(this.checkedBoxColor, checkboxColors.checkedBoxColor) && Color.m4773equalsimpl0(this.uncheckedBoxColor, checkboxColors.uncheckedBoxColor) && Color.m4773equalsimpl0(this.disabledCheckedBoxColor, checkboxColors.disabledCheckedBoxColor) && Color.m4773equalsimpl0(this.disabledUncheckedBoxColor, checkboxColors.disabledUncheckedBoxColor) && Color.m4773equalsimpl0(this.disabledIndeterminateBoxColor, checkboxColors.disabledIndeterminateBoxColor) && Color.m4773equalsimpl0(this.checkedBorderColor, checkboxColors.checkedBorderColor) && Color.m4773equalsimpl0(this.uncheckedBorderColor, checkboxColors.uncheckedBorderColor) && Color.m4773equalsimpl0(this.disabledBorderColor, checkboxColors.disabledBorderColor) && Color.m4773equalsimpl0(this.disabledUncheckedBorderColor, checkboxColors.disabledUncheckedBorderColor) && Color.m4773equalsimpl0(this.disabledIndeterminateBorderColor, checkboxColors.disabledIndeterminateBorderColor);
    }

    public int hashCode() {
        return (((((((((((((((((((((Color.m4779hashCodeimpl(this.checkedCheckmarkColor) * 31) + Color.m4779hashCodeimpl(this.uncheckedCheckmarkColor)) * 31) + Color.m4779hashCodeimpl(this.checkedBoxColor)) * 31) + Color.m4779hashCodeimpl(this.uncheckedBoxColor)) * 31) + Color.m4779hashCodeimpl(this.disabledCheckedBoxColor)) * 31) + Color.m4779hashCodeimpl(this.disabledUncheckedBoxColor)) * 31) + Color.m4779hashCodeimpl(this.disabledIndeterminateBoxColor)) * 31) + Color.m4779hashCodeimpl(this.checkedBorderColor)) * 31) + Color.m4779hashCodeimpl(this.uncheckedBorderColor)) * 31) + Color.m4779hashCodeimpl(this.disabledBorderColor)) * 31) + Color.m4779hashCodeimpl(this.disabledUncheckedBorderColor)) * 31) + Color.m4779hashCodeimpl(this.disabledIndeterminateBorderColor);
    }
}
