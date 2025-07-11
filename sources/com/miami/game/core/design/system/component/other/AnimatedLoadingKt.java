package com.miami.game.core.design.system.component.other;

import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.EasingKt;
import androidx.compose.animation.core.InfiniteRepeatableSpec;
import androidx.compose.animation.core.InfiniteTransition;
import androidx.compose.animation.core.InfiniteTransitionKt;
import androidx.compose.animation.core.RepeatMode;
import androidx.compose.foundation.ImageKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.material3.MenuKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.State;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.RotateKt;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.layout.ContentScale;
import androidx.compose.ui.res.PainterResources_androidKt;
import androidx.compose.ui.unit.Dp;
import androidx.constraintlayout.motion.widget.Key;
import androidx.media3.exoplayer.RendererCapabilities;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import ru.ayagroup.android.core.design.system.R;
/* compiled from: AnimatedLoading.kt */
@Metadata(d1 = {"\u0000 \n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0007\u001a+\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007H\u0007¢\u0006\u0004\b\b\u0010\t¨\u0006\n²\u0006\n\u0010\u000b\u001a\u00020\fX\u008a\u0084\u0002"}, d2 = {"AnimatedLoading", "", "isChecking", "", "width", "Landroidx/compose/ui/unit/Dp;", "modifier", "Landroidx/compose/ui/Modifier;", "AnimatedLoading-uFdPcIQ", "(ZFLandroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "design-system_release_web", Key.ROTATION, ""}, k = 2, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class AnimatedLoadingKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AnimatedLoading_uFdPcIQ$lambda$1(boolean z, float f, Modifier modifier, int i, int i2, Composer composer, int i3) {
        m8316AnimatedLoadinguFdPcIQ(z, f, modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x0043  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0046  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0063  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0065  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x006e  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0120  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x012b  */
    /* JADX WARN: Removed duplicated region for block: B:60:? A[RETURN, SYNTHETIC] */
    /* renamed from: AnimatedLoading-uFdPcIQ  reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void m8316AnimatedLoadinguFdPcIQ(final boolean z, float f, Modifier modifier, Composer composer, final int i, final int i2) {
        int i3;
        float f2;
        int i4;
        Object obj;
        final float f3;
        final Modifier modifier2;
        ScopeUpdateScope endRestartGroup;
        Modifier modifier3;
        Composer startRestartGroup = composer.startRestartGroup(-113788150);
        ComposerKt.sourceInformation(startRestartGroup, "C(AnimatedLoading)P(!1,2:c#ui.unit.Dp):AnimatedLoading.kt#8aq8qr");
        if ((i & 6) == 0) {
            i3 = (startRestartGroup.changed(z) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        int i5 = i2 & 2;
        if (i5 != 0) {
            i3 |= 48;
        } else if ((i & 48) == 0) {
            f2 = f;
            i3 |= startRestartGroup.changed(f2) ? 32 : 16;
            i4 = i2 & 4;
            if (i4 == 0) {
                i3 |= RendererCapabilities.DECODER_SUPPORT_MASK;
            } else if ((i & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
                obj = modifier;
                i3 |= startRestartGroup.changed(obj) ? 256 : 128;
                if (!startRestartGroup.shouldExecute((i3 & 147) != 146, i3 & 1)) {
                    startRestartGroup.skipToGroupEnd();
                    f3 = f2;
                    modifier2 = obj;
                } else {
                    float m6684constructorimpl = i5 != 0 ? Dp.m6684constructorimpl(60) : f2;
                    Modifier.Companion companion = i4 != 0 ? Modifier.Companion : obj;
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-113788150, i3, -1, "com.miami.game.core.design.system.component.other.AnimatedLoading (AnimatedLoading.kt:21)");
                    }
                    if (z) {
                        startRestartGroup.startReplaceGroup(-1133432296);
                        ComposerKt.sourceInformation(startRestartGroup, "23@1004L28,24@1076L418,39@1629L84,35@1503L260");
                        modifier3 = companion;
                        ImageKt.Image(PainterResources_androidKt.painterResource(R.drawable.loading_animated_icon, startRestartGroup, 0), (String) null, RotateKt.rotate(SizeKt.m790width3ABfNKs(companion, m6684constructorimpl), AnimatedLoading_uFdPcIQ$lambda$0(InfiniteTransitionKt.animateFloat(InfiniteTransitionKt.rememberInfiniteTransition(null, startRestartGroup, 0, 1), 0.0f, 360.0f, AnimationSpecKt.m147infiniteRepeatable9IiC70o$default(AnimationSpecKt.tween$default(1000, 0, EasingKt.getLinearEasing(), 2, null), RepeatMode.Restart, 0L, 4, null), null, startRestartGroup, InfiniteTransition.$stable | 432 | (InfiniteRepeatableSpec.$stable << 9), 8))), (Alignment) null, (ContentScale) null, 0.0f, (ColorFilter) null, startRestartGroup, 48, (int) MenuKt.InTransitionDuration);
                        startRestartGroup = startRestartGroup;
                        startRestartGroup.endReplaceGroup();
                    } else {
                        modifier3 = companion;
                        startRestartGroup.startReplaceGroup(-1132647469);
                        ComposerKt.sourceInformation(startRestartGroup, "47@1793L53");
                        SpacerKt.Spacer(SizeKt.m790width3ABfNKs(Modifier.Companion, Dp.m6684constructorimpl(60)), startRestartGroup, 6);
                        startRestartGroup.endReplaceGroup();
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier2 = modifier3;
                    f3 = m6684constructorimpl;
                }
                endRestartGroup = startRestartGroup.endRestartGroup();
                if (endRestartGroup != null) {
                    endRestartGroup.updateScope(new Function2() { // from class: com.miami.game.core.design.system.component.other.AnimatedLoadingKt$$ExternalSyntheticLambda0
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj2, Object obj3) {
                            Unit AnimatedLoading_uFdPcIQ$lambda$1;
                            AnimatedLoading_uFdPcIQ$lambda$1 = AnimatedLoadingKt.AnimatedLoading_uFdPcIQ$lambda$1(z, f3, modifier2, i, i2, (Composer) obj2, ((Integer) obj3).intValue());
                            return AnimatedLoading_uFdPcIQ$lambda$1;
                        }
                    });
                    return;
                }
                return;
            }
            obj = modifier;
            if (!startRestartGroup.shouldExecute((i3 & 147) != 146, i3 & 1)) {
            }
            endRestartGroup = startRestartGroup.endRestartGroup();
            if (endRestartGroup != null) {
            }
        }
        f2 = f;
        i4 = i2 & 4;
        if (i4 == 0) {
        }
        obj = modifier;
        if (!startRestartGroup.shouldExecute((i3 & 147) != 146, i3 & 1)) {
        }
        endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
        }
    }

    private static final float AnimatedLoading_uFdPcIQ$lambda$0(State<Float> state) {
        return state.getValue().floatValue();
    }
}
