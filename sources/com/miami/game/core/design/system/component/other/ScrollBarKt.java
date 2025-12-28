package com.miami.game.core.design.system.component.other;

import androidx.compose.foundation.ScrollState;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.DrawModifierKt;
import androidx.compose.ui.geometry.CornerRadius;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.BlendMode;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.graphics.CompositingStrategy;
import androidx.compose.ui.graphics.GraphicsLayerModifierKt;
import androidx.compose.ui.graphics.drawscope.ContentDrawScope;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.unit.Dp;
import androidx.media3.exoplayer.RendererCapabilities;
import androidx.profileinstaller.ProfileVerifier;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: ScrollBar.kt */
@Metadata(d1 = {"\u0000\"\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0007\u001aC\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\tH\u0007¢\u0006\u0004\b\u000b\u0010\f\u001a&\u0010\r\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u000e\u001a\u00020\t2\b\b\u0002\u0010\u000f\u001a\u00020\t¨\u0006\u0010"}, d2 = {"verticalColumnScrollbar", "Landroidx/compose/ui/Modifier;", "scrollState", "Landroidx/compose/foundation/ScrollState;", "width", "Landroidx/compose/ui/unit/Dp;", "showScrollBarTrack", "", "scrollBarCornerRadius", "", "endPadding", "verticalColumnScrollbar-osbwsH8", "(Landroidx/compose/ui/Modifier;Landroidx/compose/foundation/ScrollState;FZFFLandroidx/compose/runtime/Composer;II)Landroidx/compose/ui/Modifier;", "fadingTopBottomEdgesSimplified", "topFadePercentage", "bottomFadePercentage", "design-system_release"}, k = 2, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class ScrollBarKt {
    /* renamed from: verticalColumnScrollbar-osbwsH8  reason: not valid java name */
    public static final Modifier m10066verticalColumnScrollbarosbwsH8(Modifier verticalColumnScrollbar, final ScrollState scrollState, float f, boolean z, float f2, float f3, Composer composer, int i, int i2) {
        Intrinsics.checkNotNullParameter(verticalColumnScrollbar, "$this$verticalColumnScrollbar");
        Intrinsics.checkNotNullParameter(scrollState, "scrollState");
        ComposerKt.sourceInformationMarkerStart(composer, 2015743295, "C(verticalColumnScrollbar)N(scrollState,width:c#ui.unit.Dp,showScrollBarTrack,scrollBarCornerRadius,endPadding)27@975L1364:ScrollBar.kt#8aq8qr");
        final float m8258constructorimpl = (i2 & 2) != 0 ? Dp.m8258constructorimpl(4) : f;
        boolean z2 = true;
        final boolean z3 = (i2 & 4) != 0 ? true : z;
        final float f4 = (i2 & 8) != 0 ? 4.0f : f2;
        final float f5 = (i2 & 16) != 0 ? 12.0f : f3;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(2015743295, i, -1, "com.miami.game.core.design.system.component.other.verticalColumnScrollbar (ScrollBar.kt:26)");
        }
        ComposerKt.sourceInformationMarkerStart(composer, 99064979, "CC(remember):ScrollBar.kt#9igjgp");
        boolean z4 = ((((i & 112) ^ 48) > 32 && composer.changed(scrollState)) || (i & 48) == 32) | ((((i & 7168) ^ 3072) > 2048 && composer.changed(z3)) || (i & 3072) == 2048) | ((((57344 & i) ^ 24576) > 16384 && composer.changed(f4)) || (i & 24576) == 16384) | ((((458752 & i) ^ ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) > 131072 && composer.changed(f5)) || (i & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 131072);
        if ((((i & 896) ^ RendererCapabilities.DECODER_SUPPORT_MASK) <= 256 || !composer.changed(m8258constructorimpl)) && (i & RendererCapabilities.DECODER_SUPPORT_MASK) != 256) {
            z2 = false;
        }
        boolean z5 = z4 | z2;
        Object rememberedValue = composer.rememberedValue();
        if (z5 || rememberedValue == Composer.Companion.getEmpty()) {
            Function1 function1 = new Function1() { // from class: com.miami.game.core.design.system.component.other.ScrollBarKt$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    Unit verticalColumnScrollbar_osbwsH8$lambda$0$0;
                    verticalColumnScrollbar_osbwsH8$lambda$0$0 = ScrollBarKt.verticalColumnScrollbar_osbwsH8$lambda$0$0(ScrollState.this, z3, f4, f5, m8258constructorimpl, (ContentDrawScope) obj);
                    return verticalColumnScrollbar_osbwsH8$lambda$0$0;
                }
            };
            composer.updateRememberedValue(function1);
            rememberedValue = function1;
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        Modifier drawWithContent = DrawModifierKt.drawWithContent(verticalColumnScrollbar, (Function1) rememberedValue);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return drawWithContent;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit verticalColumnScrollbar_osbwsH8$lambda$0$0(ScrollState scrollState, boolean z, float f, float f2, float f3, ContentDrawScope drawWithContent) {
        char c;
        long j;
        Intrinsics.checkNotNullParameter(drawWithContent, "$this$drawWithContent");
        drawWithContent.drawContent();
        float intBitsToFloat = Float.intBitsToFloat((int) (drawWithContent.mo6005getSizeNHjbRc() & 4294967295L));
        float maxValue = scrollState.getMaxValue() + intBitsToFloat;
        if (maxValue <= intBitsToFloat) {
            return Unit.INSTANCE;
        }
        float f4 = (intBitsToFloat / maxValue) * intBitsToFloat;
        float value = (scrollState.getValue() / maxValue) * intBitsToFloat;
        if (z) {
            c = 1;
            j = 4294967295L;
            DrawScope.m6000drawRoundRectZuiqVtQ$default(drawWithContent, Brush.Companion.m5373linearGradientmHitzGk$default(Brush.Companion, CollectionsKt.listOf((Object[]) new Color[]{Color.m5414boximpl(ColorKt.Color(2570671230L)), Color.m5414boximpl(Color.Companion.m5459getTransparent0d7_KjU())}), 0L, 0L, 0, 14, (Object) null), Offset.m5171constructorimpl((Float.floatToRawIntBits(0.0f) & 4294967295L) | (Float.floatToRawIntBits(Float.intBitsToFloat((int) (drawWithContent.mo6005getSizeNHjbRc() >> 32)) - f2) << 32)), Size.m5239constructorimpl((Float.floatToRawIntBits(drawWithContent.mo464toPx0680j_4(f3)) << 32) | (Float.floatToRawIntBits(intBitsToFloat) & 4294967295L)), CornerRadius.m5133constructorimpl((Float.floatToRawIntBits(f) << 32) | (Float.floatToRawIntBits(f) & 4294967295L)), 0.0f, null, null, 0, 240, null);
        } else {
            c = 1;
            j = 4294967295L;
        }
        long m5133constructorimpl = CornerRadius.m5133constructorimpl((Float.floatToRawIntBits(f) << 32) | (Float.floatToRawIntBits(f) & j));
        Brush.Companion companion = Brush.Companion;
        Color[] colorArr = new Color[2];
        colorArr[0] = Color.m5414boximpl(ColorKt.Color(4293206357L));
        colorArr[c] = Color.m5414boximpl(ColorKt.Color(4294474909L));
        DrawScope.m6000drawRoundRectZuiqVtQ$default(drawWithContent, Brush.Companion.m5373linearGradientmHitzGk$default(companion, CollectionsKt.listOf((Object[]) colorArr), 0L, 0L, 0, 14, (Object) null), Offset.m5171constructorimpl((Float.floatToRawIntBits(Float.intBitsToFloat((int) (drawWithContent.mo6005getSizeNHjbRc() >> 32)) - f2) << 32) | (Float.floatToRawIntBits(value) & j)), Size.m5239constructorimpl((Float.floatToRawIntBits(drawWithContent.mo464toPx0680j_4(f3)) << 32) | (Float.floatToRawIntBits(f4) & j)), m5133constructorimpl, 0.0f, null, null, 0, 240, null);
        return Unit.INSTANCE;
    }

    public static /* synthetic */ Modifier fadingTopBottomEdgesSimplified$default(Modifier modifier, ScrollState scrollState, float f, float f2, int i, Object obj) {
        if ((i & 2) != 0) {
            f = 0.1f;
        }
        if ((i & 4) != 0) {
            f2 = 0.1f;
        }
        return fadingTopBottomEdgesSimplified(modifier, scrollState, f, f2);
    }

    public static final Modifier fadingTopBottomEdgesSimplified(Modifier modifier, final ScrollState scrollState, final float f, final float f2) {
        Intrinsics.checkNotNullParameter(modifier, "<this>");
        Intrinsics.checkNotNullParameter(scrollState, "scrollState");
        return DrawModifierKt.drawWithContent(GraphicsLayerModifierKt.m5591graphicsLayer_6ThJ44$default(modifier, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0L, null, false, null, 0L, 0L, CompositingStrategy.Companion.m5517getOffscreenNrFUSI(), 0, null, 458751, null), new Function1() { // from class: com.miami.game.core.design.system.component.other.ScrollBarKt$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit fadingTopBottomEdgesSimplified$lambda$0;
                fadingTopBottomEdgesSimplified$lambda$0 = ScrollBarKt.fadingTopBottomEdgesSimplified$lambda$0(ScrollState.this, f, f2, (ContentDrawScope) obj);
                return fadingTopBottomEdgesSimplified$lambda$0;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit fadingTopBottomEdgesSimplified$lambda$0(ScrollState scrollState, float f, float f2, ContentDrawScope drawWithContent) {
        Intrinsics.checkNotNullParameter(drawWithContent, "$this$drawWithContent");
        drawWithContent.drawContent();
        float intBitsToFloat = Float.intBitsToFloat((int) (drawWithContent.mo6005getSizeNHjbRc() & 4294967295L));
        if (scrollState.getMaxValue() + intBitsToFloat <= intBitsToFloat) {
            return Unit.INSTANCE;
        }
        if (f > 0.0f) {
            DrawScope.m5998drawRectAsUm42w$default(drawWithContent, Brush.Companion.m5380verticalGradient8A3gB4$default(Brush.Companion, new Pair[]{TuplesKt.to(Float.valueOf(0.0f), Color.m5414boximpl(Color.Companion.m5459getTransparent0d7_KjU())), TuplesKt.to(Float.valueOf(f), Color.m5414boximpl(Color.Companion.m5450getBlack0d7_KjU()))}, 0.0f, 0.0f, 0, 14, (Object) null), 0L, 0L, 0.0f, null, null, BlendMode.Companion.m5345getDstIn0nO6VwU(), 62, null);
        }
        if (f2 > 0.0f) {
            DrawScope.m5998drawRectAsUm42w$default(drawWithContent, Brush.Companion.m5380verticalGradient8A3gB4$default(Brush.Companion, new Pair[]{TuplesKt.to(Float.valueOf(1 - f2), Color.m5414boximpl(Color.Companion.m5450getBlack0d7_KjU())), TuplesKt.to(Float.valueOf(1.0f), Color.m5414boximpl(Color.Companion.m5459getTransparent0d7_KjU()))}, 0.0f, 0.0f, 0, 14, (Object) null), 0L, 0L, 0.0f, null, null, BlendMode.Companion.m5345getDstIn0nO6VwU(), 62, null);
        }
        return Unit.INSTANCE;
    }
}
