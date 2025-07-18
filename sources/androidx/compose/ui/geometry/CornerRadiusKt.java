package androidx.compose.ui.geometry;

import androidx.compose.ui.util.MathHelpersKt;
import androidx.media3.extractor.text.ttml.TtmlNode;
import kotlin.Metadata;
/* compiled from: CornerRadius.kt */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\t\u001a \u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003H\u0087\b¢\u0006\u0002\u0010\u0005\u001a*\u0010\u0006\u001a\u00020\u00012\u0006\u0010\u0007\u001a\u00020\u00012\u0006\u0010\b\u001a\u00020\u00012\u0006\u0010\t\u001a\u00020\u0003H\u0007ø\u0001\u0000¢\u0006\u0004\b\n\u0010\u000b\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\f"}, d2 = {"CornerRadius", "Landroidx/compose/ui/geometry/CornerRadius;", "x", "", "y", "(FF)J", "lerp", TtmlNode.START, "stop", "fraction", "lerp-3Ry4LBc", "(JJF)J", "ui-geometry_release"}, k = 2, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes.dex */
public final class CornerRadiusKt {
    public static final long CornerRadius(float f, float f2) {
        return CornerRadius.m3791constructorimpl((Float.floatToRawIntBits(f2) & 4294967295L) | (Float.floatToRawIntBits(f) << 32));
    }

    public static /* synthetic */ long CornerRadius$default(float f, float f2, int i, Object obj) {
        if ((i & 2) != 0) {
            f2 = f;
        }
        return CornerRadius.m3791constructorimpl((Float.floatToRawIntBits(f2) & 4294967295L) | (Float.floatToRawIntBits(f) << 32));
    }

    /* renamed from: lerp-3Ry4LBc  reason: not valid java name */
    public static final long m3810lerp3Ry4LBc(long j, long j2, float f) {
        return CornerRadius.m3791constructorimpl((Float.floatToRawIntBits(MathHelpersKt.lerp(Float.intBitsToFloat((int) (j >> 32)), Float.intBitsToFloat((int) (j2 >> 32)), f)) << 32) | (Float.floatToRawIntBits(MathHelpersKt.lerp(Float.intBitsToFloat((int) (j & 4294967295L)), Float.intBitsToFloat((int) (j2 & 4294967295L)), f)) & 4294967295L));
    }
}
