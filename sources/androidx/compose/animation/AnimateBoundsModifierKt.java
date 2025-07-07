package androidx.compose.animation;

import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.FiniteAnimationSpec;
import androidx.compose.animation.core.VisibilityThresholdsKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.layout.LookaheadScope;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.IntSize;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
/* compiled from: AnimateBoundsModifier.kt */
@Metadata(d1 = {"\u0000\u001e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\u001a2\u0010\u0004\u001a\u00020\u0005*\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00052\b\b\u0002\u0010\t\u001a\u00020\u00012\b\b\u0002\u0010\n\u001a\u00020\u000bH\u0007\"\u0014\u0010\u0000\u001a\u00020\u0001X\u0082\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u0002\u0010\u0003¨\u0006\f"}, d2 = {"DefaultBoundsTransform", "Landroidx/compose/animation/BoundsTransform;", "getDefaultBoundsTransform$annotations", "()V", "animateBounds", "Landroidx/compose/ui/Modifier;", "lookaheadScope", "Landroidx/compose/ui/layout/LookaheadScope;", "modifier", "boundsTransform", "animateMotionFrameOfReference", "", "animation_release"}, k = 2, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes.dex */
public final class AnimateBoundsModifierKt {
    private static final BoundsTransform DefaultBoundsTransform = new BoundsTransform() { // from class: androidx.compose.animation.AnimateBoundsModifierKt$$ExternalSyntheticLambda0
        @Override // androidx.compose.animation.BoundsTransform
        public final FiniteAnimationSpec transform(Rect rect, Rect rect2) {
            FiniteAnimationSpec DefaultBoundsTransform$lambda$0;
            DefaultBoundsTransform$lambda$0 = AnimateBoundsModifierKt.DefaultBoundsTransform$lambda$0(rect, rect2);
            return DefaultBoundsTransform$lambda$0;
        }
    };

    private static /* synthetic */ void getDefaultBoundsTransform$annotations() {
    }

    public static /* synthetic */ Modifier animateBounds$default(Modifier modifier, LookaheadScope lookaheadScope, Modifier modifier2, BoundsTransform boundsTransform, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            modifier2 = Modifier.Companion;
        }
        if ((i & 4) != 0) {
            boundsTransform = DefaultBoundsTransform;
        }
        if ((i & 8) != 0) {
            z = false;
        }
        return animateBounds(modifier, lookaheadScope, modifier2, boundsTransform, z);
    }

    public static final Modifier animateBounds(Modifier modifier, LookaheadScope lookaheadScope, Modifier modifier2, BoundsTransform boundsTransform, boolean z) {
        return modifier.then(new BoundsAnimationElement(lookaheadScope, boundsTransform, new Function2<IntSize, Constraints, Constraints>() { // from class: androidx.compose.animation.AnimateBoundsModifierKt$animateBounds$1
            /* renamed from: invoke-2pbfIzA  reason: not valid java name */
            public final long m38invoke2pbfIzA(long j, long j2) {
                return j2;
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Constraints invoke(IntSize intSize, Constraints constraints) {
                return Constraints.m6624boximpl(m38invoke2pbfIzA(intSize.m6859unboximpl(), constraints.m6643unboximpl()));
            }
        }, z)).then(modifier2).then(new BoundsAnimationElement(lookaheadScope, boundsTransform, new Function2<IntSize, Constraints, Constraints>() { // from class: androidx.compose.animation.AnimateBoundsModifierKt$animateBounds$2
            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Constraints invoke(IntSize intSize, Constraints constraints) {
                return Constraints.m6624boximpl(m39invoke2pbfIzA(intSize.m6859unboximpl(), constraints.m6643unboximpl()));
            }

            /* renamed from: invoke-2pbfIzA  reason: not valid java name */
            public final long m39invoke2pbfIzA(long j, long j2) {
                return Constraints.Companion.m6647fixedJhjzzOo((int) (j >> 32), (int) (j & 4294967295L));
            }
        }, z));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final FiniteAnimationSpec DefaultBoundsTransform$lambda$0(Rect rect, Rect rect2) {
        return AnimationSpecKt.spring(1.0f, 400.0f, VisibilityThresholdsKt.getVisibilityThreshold(Rect.Companion));
    }
}
