package androidx.compose.ui.graphics.shadow;

import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.graphics.Interpolatable;
import androidx.compose.ui.unit.DpKt;
import androidx.compose.ui.util.MathHelpersKt;
import androidx.media3.exoplayer.upstream.CmcdData;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: Shadow.kt */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0002\u001a \u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u0005H\u0000\u001a$\u0010\u0006\u001a\u0004\u0018\u00010\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u00012\b\u0010\u0003\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0004\u001a\u00020\u0005¨\u0006\u0007"}, d2 = {"lerpNonNull", "Landroidx/compose/ui/graphics/shadow/Shadow;", CmcdData.OBJECT_TYPE_AUDIO_ONLY, "b", "t", "", "lerp", "ui-graphics"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class ShadowKt {
    public static final Shadow lerpNonNull(Shadow shadow, Shadow shadow2, float f) {
        float m8203lerpMdfbLM = DpKt.m8203lerpMdfbLM(shadow.m6068getRadiusD9Ej5fM(), shadow2.m6068getRadiusD9Ej5fM(), f);
        float m8203lerpMdfbLM2 = DpKt.m8203lerpMdfbLM(shadow.m6069getSpreadD9Ej5fM(), shadow2.m6069getSpreadD9Ej5fM(), f);
        long m8204lerpxhh869w = DpKt.m8204lerpxhh869w(shadow.m6067getOffsetRKDOV3M(), shadow2.m6067getOffsetRKDOV3M(), f);
        long m5399lerpjxsXWHM = ColorKt.m5399lerpjxsXWHM(shadow.m6066getColor0d7_KjU(), shadow2.m6066getColor0d7_KjU(), f);
        Object lerp = Interpolatable.Companion.lerp(shadow.getBrush(), shadow2.getBrush(), f);
        return new Shadow(m8203lerpMdfbLM, m8203lerpMdfbLM2, m8204lerpxhh869w, m5399lerpjxsXWHM, lerp instanceof Brush ? (Brush) lerp : null, MathHelpersKt.lerp(shadow.getAlpha(), shadow2.getAlpha(), f), f < 0.5f ? shadow.m6065getBlendMode0nO6VwU() : shadow2.m6065getBlendMode0nO6VwU(), (DefaultConstructorMarker) null);
    }

    public static final Shadow lerp(Shadow shadow, Shadow shadow2, float f) {
        if (shadow == null && shadow2 == null) {
            return null;
        }
        if (shadow != null) {
            return shadow2 == null ? lerpNonNull(shadow, shadow.transparentCopy$ui_graphics(), f) : lerpNonNull(shadow, shadow2, f);
        }
        Intrinsics.checkNotNull(shadow2);
        return lerpNonNull(shadow2.transparentCopy$ui_graphics(), shadow2, f);
    }
}
