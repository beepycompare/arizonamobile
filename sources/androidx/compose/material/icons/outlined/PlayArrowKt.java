package androidx.compose.material.icons.outlined;

import androidx.compose.material.icons.Icons;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.SolidColor;
import androidx.compose.ui.graphics.StrokeCap;
import androidx.compose.ui.graphics.StrokeJoin;
import androidx.compose.ui.graphics.vector.ImageVector;
import androidx.compose.ui.graphics.vector.PathBuilder;
import androidx.compose.ui.graphics.vector.VectorKt;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: PlayArrow.kt */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001a\u0004\u0018\u00010\u0001X\u0082\u000e¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001a\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"_playArrow", "Landroidx/compose/ui/graphics/vector/ImageVector;", "PlayArrow", "Landroidx/compose/material/icons/Icons$Outlined;", "getPlayArrow", "(Landroidx/compose/material/icons/Icons$Outlined;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-core_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class PlayArrowKt {
    private static ImageVector _playArrow;

    public static final ImageVector getPlayArrow(Icons.Outlined outlined) {
        ImageVector.Builder m4776addPathoIyEayM;
        ImageVector imageVector = _playArrow;
        if (imageVector != null) {
            Intrinsics.checkNotNull(imageVector);
            return imageVector;
        }
        ImageVector.Builder builder = new ImageVector.Builder("Outlined.PlayArrow", Dp.m6684constructorimpl(24.0f), Dp.m6684constructorimpl(24.0f), 24.0f, 24.0f, 0L, 0, false, 96, null);
        int defaultFillType = VectorKt.getDefaultFillType();
        SolidColor solidColor = new SolidColor(Color.Companion.m4104getBlack0d7_KjU(), null);
        int m4432getButtKaPHkGw = StrokeCap.Companion.m4432getButtKaPHkGw();
        int m4442getBevelLxFBmk8 = StrokeJoin.Companion.m4442getBevelLxFBmk8();
        PathBuilder pathBuilder = new PathBuilder();
        pathBuilder.moveTo(10.0f, 8.64f);
        pathBuilder.lineTo(15.27f, 12.0f);
        pathBuilder.lineTo(10.0f, 15.36f);
        pathBuilder.verticalLineTo(8.64f);
        pathBuilder.moveTo(8.0f, 5.0f);
        pathBuilder.verticalLineToRelative(14.0f);
        pathBuilder.lineToRelative(11.0f, -7.0f);
        pathBuilder.lineTo(8.0f, 5.0f);
        pathBuilder.close();
        m4776addPathoIyEayM = builder.m4776addPathoIyEayM(pathBuilder.getNodes(), (r30 & 2) != 0 ? VectorKt.getDefaultFillType() : defaultFillType, (r30 & 4) != 0 ? "" : "", (r30 & 8) != 0 ? null : solidColor, (r30 & 16) != 0 ? 1.0f : 1.0f, (r30 & 32) == 0 ? null : null, (r30 & 64) != 0 ? 1.0f : 1.0f, (r30 & 128) != 0 ? 0.0f : 1.0f, (r30 & 256) != 0 ? VectorKt.getDefaultStrokeLineCap() : m4432getButtKaPHkGw, (r30 & 512) != 0 ? VectorKt.getDefaultStrokeLineJoin() : m4442getBevelLxFBmk8, (r30 & 1024) != 0 ? 4.0f : 1.0f, (r30 & 2048) != 0 ? 0.0f : 0.0f, (r30 & 4096) == 0 ? 0.0f : 1.0f, (r30 & 8192) != 0 ? 0.0f : 0.0f);
        ImageVector build = m4776addPathoIyEayM.build();
        _playArrow = build;
        Intrinsics.checkNotNull(build);
        return build;
    }
}
