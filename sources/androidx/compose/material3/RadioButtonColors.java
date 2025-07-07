package androidx.compose.material3;

import androidx.compose.animation.SingleValueAnimationKt;
import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.ui.graphics.Color;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
/* compiled from: RadioButton.kt */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0002\u0010\u0007J8\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0003ø\u0001\u0000¢\u0006\u0004\b\u000f\u0010\u0010J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\u0014\u001a\u00020\u0015H\u0016J%\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00030\u00172\u0006\u0010\u0018\u001a\u00020\u00122\u0006\u0010\u0019\u001a\u00020\u0012H\u0001¢\u0006\u0004\b\u001a\u0010\u001bR\u0019\u0010\u0005\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\n\u001a\u0004\b\b\u0010\tR\u0019\u0010\u0006\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\n\u001a\u0004\b\u000b\u0010\tR\u0019\u0010\u0002\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\n\u001a\u0004\b\f\u0010\tR\u0019\u0010\u0004\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\n\u001a\u0004\b\r\u0010\t\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u001c"}, d2 = {"Landroidx/compose/material3/RadioButtonColors;", "", "selectedColor", "Landroidx/compose/ui/graphics/Color;", "unselectedColor", "disabledSelectedColor", "disabledUnselectedColor", "(JJJJLkotlin/jvm/internal/DefaultConstructorMarker;)V", "getDisabledSelectedColor-0d7_KjU", "()J", "J", "getDisabledUnselectedColor-0d7_KjU", "getSelectedColor-0d7_KjU", "getUnselectedColor-0d7_KjU", "copy", "copy-jRlVdoo", "(JJJJ)Landroidx/compose/material3/RadioButtonColors;", "equals", "", "other", "hashCode", "", "radioColor", "Landroidx/compose/runtime/State;", "enabled", "selected", "radioColor$material3_release", "(ZZLandroidx/compose/runtime/Composer;I)Landroidx/compose/runtime/State;", "material3_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class RadioButtonColors {
    public static final int $stable = 0;
    private final long disabledSelectedColor;
    private final long disabledUnselectedColor;
    private final long selectedColor;
    private final long unselectedColor;

    public /* synthetic */ RadioButtonColors(long j, long j2, long j3, long j4, DefaultConstructorMarker defaultConstructorMarker) {
        this(j, j2, j3, j4);
    }

    private RadioButtonColors(long j, long j2, long j3, long j4) {
        this.selectedColor = j;
        this.unselectedColor = j2;
        this.disabledSelectedColor = j3;
        this.disabledUnselectedColor = j4;
    }

    /* renamed from: getSelectedColor-0d7_KjU  reason: not valid java name */
    public final long m2196getSelectedColor0d7_KjU() {
        return this.selectedColor;
    }

    /* renamed from: getUnselectedColor-0d7_KjU  reason: not valid java name */
    public final long m2197getUnselectedColor0d7_KjU() {
        return this.unselectedColor;
    }

    /* renamed from: getDisabledSelectedColor-0d7_KjU  reason: not valid java name */
    public final long m2194getDisabledSelectedColor0d7_KjU() {
        return this.disabledSelectedColor;
    }

    /* renamed from: getDisabledUnselectedColor-0d7_KjU  reason: not valid java name */
    public final long m2195getDisabledUnselectedColor0d7_KjU() {
        return this.disabledUnselectedColor;
    }

    /* renamed from: copy-jRlVdoo$default  reason: not valid java name */
    public static /* synthetic */ RadioButtonColors m2192copyjRlVdoo$default(RadioButtonColors radioButtonColors, long j, long j2, long j3, long j4, int i, Object obj) {
        if ((i & 1) != 0) {
            j = radioButtonColors.selectedColor;
        }
        long j5 = j;
        if ((i & 2) != 0) {
            j2 = radioButtonColors.unselectedColor;
        }
        long j6 = j2;
        if ((i & 4) != 0) {
            j3 = radioButtonColors.disabledSelectedColor;
        }
        return radioButtonColors.m2193copyjRlVdoo(j5, j6, j3, (i & 8) != 0 ? radioButtonColors.disabledUnselectedColor : j4);
    }

    /* renamed from: copy-jRlVdoo  reason: not valid java name */
    public final RadioButtonColors m2193copyjRlVdoo(long j, long j2, long j3, long j4) {
        return new RadioButtonColors(j != 16 ? j : this.selectedColor, j2 != 16 ? j2 : this.unselectedColor, j3 != 16 ? j3 : this.disabledSelectedColor, j4 != 16 ? j4 : this.disabledUnselectedColor, null);
    }

    public final State<Color> radioColor$material3_release(boolean z, boolean z2, Composer composer, int i) {
        long j;
        Composer composer2;
        State<Color> rememberUpdatedState;
        ComposerKt.sourceInformationMarkerStart(composer, -1840145292, "C(radioColor):RadioButton.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1840145292, i, -1, "androidx.compose.material3.RadioButtonColors.radioColor (RadioButton.kt:228)");
        }
        if (z && z2) {
            j = this.selectedColor;
        } else if (z && !z2) {
            j = this.unselectedColor;
        } else if (!z && z2) {
            j = this.disabledSelectedColor;
        } else {
            j = this.disabledUnselectedColor;
        }
        long j2 = j;
        if (z) {
            composer.startReplaceGroup(350067971);
            ComposerKt.sourceInformation(composer, "240@10272L75");
            composer2 = composer;
            rememberUpdatedState = SingleValueAnimationKt.m124animateColorAsStateeuL9pac(j2, AnimationSpecKt.tween$default(100, 0, null, 6, null), null, null, composer2, 48, 12);
            composer2.endReplaceGroup();
        } else {
            composer2 = composer;
            composer2.startReplaceGroup(350170674);
            ComposerKt.sourceInformation(composer2, "242@10377L28");
            rememberUpdatedState = SnapshotStateKt.rememberUpdatedState(Color.m4068boximpl(j2), composer2, 0);
            composer2.endReplaceGroup();
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer2);
        return rememberUpdatedState;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof RadioButtonColors)) {
            return false;
        }
        RadioButtonColors radioButtonColors = (RadioButtonColors) obj;
        return Color.m4079equalsimpl0(this.selectedColor, radioButtonColors.selectedColor) && Color.m4079equalsimpl0(this.unselectedColor, radioButtonColors.unselectedColor) && Color.m4079equalsimpl0(this.disabledSelectedColor, radioButtonColors.disabledSelectedColor) && Color.m4079equalsimpl0(this.disabledUnselectedColor, radioButtonColors.disabledUnselectedColor);
    }

    public int hashCode() {
        return (((((Color.m4085hashCodeimpl(this.selectedColor) * 31) + Color.m4085hashCodeimpl(this.unselectedColor)) * 31) + Color.m4085hashCodeimpl(this.disabledSelectedColor)) * 31) + Color.m4085hashCodeimpl(this.disabledUnselectedColor);
    }
}
