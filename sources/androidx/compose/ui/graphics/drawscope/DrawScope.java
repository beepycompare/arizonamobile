package androidx.compose.ui.graphics.drawscope;

import androidx.compose.ui.geometry.CornerRadius;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.geometry.SizeKt;
import androidx.compose.ui.graphics.BlendMode;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.Canvas;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.FilterQuality;
import androidx.compose.ui.graphics.ImageBitmap;
import androidx.compose.ui.graphics.Path;
import androidx.compose.ui.graphics.PathEffect;
import androidx.compose.ui.graphics.StrokeCap;
import androidx.compose.ui.graphics.layer.GraphicsLayer;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.DpRect;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.IntSizeKt;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.media3.extractor.text.ttml.TtmlNode;
import java.util.List;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
/* compiled from: DrawScope.kt */
@DrawScopeMarker
@Metadata(d1 = {"\u0000¾\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bg\u0018\u0000 u2\u00020\u0001:\u0001uJp\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020\u00192\b\b\u0002\u0010\u001a\u001a\u00020\u00032\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0003\u0010\u001b\u001a\u00020\u00162\b\b\u0002\u0010\u001c\u001a\u00020\u001d2\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\b\b\u0002\u0010 \u001a\u00020!H&ø\u0001\u0000¢\u0006\u0004\b\"\u0010#Jp\u0010\u0011\u001a\u00020\u00122\u0006\u0010$\u001a\u00020%2\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020\u00192\b\b\u0002\u0010\u001a\u001a\u00020\u00032\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0003\u0010\u001b\u001a\u00020\u00162\b\b\u0002\u0010\u001c\u001a\u00020\u001d2\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\b\b\u0002\u0010 \u001a\u00020!H&ø\u0001\u0000¢\u0006\u0004\b&\u0010'JX\u0010(\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\b\b\u0002\u0010)\u001a\u00020\u00162\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0003\u0010\u001b\u001a\u00020\u00162\b\b\u0002\u0010\u001c\u001a\u00020\u001d2\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\b\b\u0002\u0010 \u001a\u00020!H&ø\u0001\u0000¢\u0006\u0004\b*\u0010+JX\u0010(\u001a\u00020\u00122\u0006\u0010$\u001a\u00020%2\b\b\u0002\u0010)\u001a\u00020\u00162\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0003\u0010\u001b\u001a\u00020\u00162\b\b\u0002\u0010\u001c\u001a\u00020\u001d2\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\b\b\u0002\u0010 \u001a\u00020!H&ø\u0001\u0000¢\u0006\u0004\b,\u0010-JN\u0010.\u001a\u00020\u00122\u0006\u0010/\u001a\u0002002\b\b\u0002\u0010\u001a\u001a\u00020\u00032\b\b\u0003\u0010\u001b\u001a\u00020\u00162\b\b\u0002\u0010\u001c\u001a\u00020\u001d2\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\b\b\u0002\u0010 \u001a\u00020!H&ø\u0001\u0000¢\u0006\u0004\b1\u00102Jl\u0010.\u001a\u00020\u00122\u0006\u0010/\u001a\u0002002\b\b\u0002\u00103\u001a\u0002042\b\b\u0002\u00105\u001a\u0002062\b\b\u0002\u00107\u001a\u0002042\b\b\u0002\u00108\u001a\u0002062\b\b\u0003\u0010\u001b\u001a\u00020\u00162\b\b\u0002\u0010\u001c\u001a\u00020\u001d2\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\b\b\u0002\u0010 \u001a\u00020!H'ø\u0001\u0000¢\u0006\u0004\b9\u0010:Jv\u0010.\u001a\u00020\u00122\u0006\u0010/\u001a\u0002002\b\b\u0002\u00103\u001a\u0002042\b\b\u0002\u00105\u001a\u0002062\b\b\u0002\u00107\u001a\u0002042\b\b\u0002\u00108\u001a\u0002062\b\b\u0003\u0010\u001b\u001a\u00020\u00162\b\b\u0002\u0010\u001c\u001a\u00020\u001d2\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\b\b\u0002\u0010 \u001a\u00020!2\b\b\u0002\u0010;\u001a\u00020<H\u0016ø\u0001\u0000¢\u0006\u0004\b=\u0010>Jj\u0010?\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010@\u001a\u00020\u00032\u0006\u0010A\u001a\u00020\u00032\b\b\u0002\u0010B\u001a\u00020\u00162\b\b\u0002\u0010C\u001a\u00020D2\n\b\u0002\u0010E\u001a\u0004\u0018\u00010F2\b\b\u0003\u0010\u001b\u001a\u00020\u00162\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\b\b\u0002\u0010 \u001a\u00020!H&ø\u0001\u0000¢\u0006\u0004\bG\u0010HJj\u0010?\u001a\u00020\u00122\u0006\u0010$\u001a\u00020%2\u0006\u0010@\u001a\u00020\u00032\u0006\u0010A\u001a\u00020\u00032\b\b\u0002\u0010B\u001a\u00020\u00162\b\b\u0002\u0010C\u001a\u00020D2\n\b\u0002\u0010E\u001a\u0004\u0018\u00010F2\b\b\u0003\u0010\u001b\u001a\u00020\u00162\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\b\b\u0002\u0010 \u001a\u00020!H&ø\u0001\u0000¢\u0006\u0004\bI\u0010JJX\u0010K\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\b\b\u0002\u0010\u001a\u001a\u00020\u00032\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0003\u0010\u001b\u001a\u00020\u00162\b\b\u0002\u0010\u001c\u001a\u00020\u001d2\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\b\b\u0002\u0010 \u001a\u00020!H&ø\u0001\u0000¢\u0006\u0004\bL\u0010MJX\u0010K\u001a\u00020\u00122\u0006\u0010$\u001a\u00020%2\b\b\u0002\u0010\u001a\u001a\u00020\u00032\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0003\u0010\u001b\u001a\u00020\u00162\b\b\u0002\u0010\u001c\u001a\u00020\u001d2\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\b\b\u0002\u0010 \u001a\u00020!H&ø\u0001\u0000¢\u0006\u0004\bN\u0010OJL\u0010P\u001a\u00020\u00122\u0006\u0010Q\u001a\u00020R2\u0006\u0010\u0013\u001a\u00020\u00142\b\b\u0003\u0010\u001b\u001a\u00020\u00162\b\b\u0002\u0010\u001c\u001a\u00020\u001d2\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\b\b\u0002\u0010 \u001a\u00020!H&ø\u0001\u0000¢\u0006\u0004\bS\u0010TJL\u0010P\u001a\u00020\u00122\u0006\u0010Q\u001a\u00020R2\u0006\u0010$\u001a\u00020%2\b\b\u0003\u0010\u001b\u001a\u00020\u00162\b\b\u0002\u0010\u001c\u001a\u00020\u001d2\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\b\b\u0002\u0010 \u001a\u00020!H&ø\u0001\u0000¢\u0006\u0004\bU\u0010VJp\u0010W\u001a\u00020\u00122\f\u0010X\u001a\b\u0012\u0004\u0012\u00020\u00030Y2\u0006\u0010Z\u001a\u00020[2\u0006\u0010\u0013\u001a\u00020\u00142\b\b\u0002\u0010B\u001a\u00020\u00162\b\b\u0002\u0010C\u001a\u00020D2\n\b\u0002\u0010E\u001a\u0004\u0018\u00010F2\b\b\u0003\u0010\u001b\u001a\u00020\u00162\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\b\b\u0002\u0010 \u001a\u00020!H&ø\u0001\u0000¢\u0006\u0004\b\\\u0010]Jp\u0010W\u001a\u00020\u00122\f\u0010X\u001a\b\u0012\u0004\u0012\u00020\u00030Y2\u0006\u0010Z\u001a\u00020[2\u0006\u0010$\u001a\u00020%2\b\b\u0002\u0010B\u001a\u00020\u00162\b\b\u0002\u0010C\u001a\u00020D2\n\b\u0002\u0010E\u001a\u0004\u0018\u00010F2\b\b\u0003\u0010\u001b\u001a\u00020\u00162\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\b\b\u0002\u0010 \u001a\u00020!H&ø\u0001\u0000¢\u0006\u0004\b^\u0010_JX\u0010`\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\b\b\u0002\u0010\u001a\u001a\u00020\u00032\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0003\u0010\u001b\u001a\u00020\u00162\b\b\u0002\u0010\u001c\u001a\u00020\u001d2\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\b\b\u0002\u0010 \u001a\u00020!H&ø\u0001\u0000¢\u0006\u0004\ba\u0010MJX\u0010`\u001a\u00020\u00122\u0006\u0010$\u001a\u00020%2\b\b\u0002\u0010\u001a\u001a\u00020\u00032\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0003\u0010\u001b\u001a\u00020\u00162\b\b\u0002\u0010\u001c\u001a\u00020\u001d2\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\b\b\u0002\u0010 \u001a\u00020!H&ø\u0001\u0000¢\u0006\u0004\bb\u0010OJb\u0010c\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\b\b\u0002\u0010\u001a\u001a\u00020\u00032\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010d\u001a\u00020e2\b\b\u0003\u0010\u001b\u001a\u00020\u00162\b\b\u0002\u0010\u001c\u001a\u00020\u001d2\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\b\b\u0002\u0010 \u001a\u00020!H&ø\u0001\u0000¢\u0006\u0004\bf\u0010gJb\u0010c\u001a\u00020\u00122\u0006\u0010$\u001a\u00020%2\b\b\u0002\u0010\u001a\u001a\u00020\u00032\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010d\u001a\u00020e2\b\b\u0002\u0010\u001c\u001a\u00020\u001d2\b\b\u0003\u0010\u001b\u001a\u00020\u00162\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\b\b\u0002\u0010 \u001a\u00020!H&ø\u0001\u0000¢\u0006\u0004\bh\u0010iJ\u001e\u0010j\u001a\u00020\u000f*\u00020\u000f2\u0006\u0010k\u001a\u00020\u0003H\u0002ø\u0001\u0000¢\u0006\u0004\bl\u0010mJ9\u0010n\u001a\u00020\u0012*\u00020o2\b\b\u0002\u0010\u000e\u001a\u0002062\u0017\u0010p\u001a\u0013\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00120q¢\u0006\u0002\brH\u0016ø\u0001\u0000¢\u0006\u0004\bs\u0010tR\u001a\u0010\u0002\u001a\u00020\u00038VX\u0096\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0012\u0010\u0006\u001a\u00020\u0007X¦\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0012\u0010\n\u001a\u00020\u000bX¦\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\rR\u001a\u0010\u000e\u001a\u00020\u000f8VX\u0096\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0005ø\u0001\u0002\u0082\u0002\u0011\n\u0005\b¡\u001e0\u0001\n\u0002\b!\n\u0004\b!0\u0001¨\u0006vÀ\u0006\u0003"}, d2 = {"Landroidx/compose/ui/graphics/drawscope/DrawScope;", "Landroidx/compose/ui/unit/Density;", TtmlNode.CENTER, "Landroidx/compose/ui/geometry/Offset;", "getCenter-F1C5BW0", "()J", "drawContext", "Landroidx/compose/ui/graphics/drawscope/DrawContext;", "getDrawContext", "()Landroidx/compose/ui/graphics/drawscope/DrawContext;", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "getLayoutDirection", "()Landroidx/compose/ui/unit/LayoutDirection;", "size", "Landroidx/compose/ui/geometry/Size;", "getSize-NH-jbRc", "drawArc", "", "brush", "Landroidx/compose/ui/graphics/Brush;", "startAngle", "", "sweepAngle", "useCenter", "", "topLeft", "alpha", "style", "Landroidx/compose/ui/graphics/drawscope/DrawStyle;", "colorFilter", "Landroidx/compose/ui/graphics/ColorFilter;", "blendMode", "Landroidx/compose/ui/graphics/BlendMode;", "drawArc-illE91I", "(Landroidx/compose/ui/graphics/Brush;FFZJJFLandroidx/compose/ui/graphics/drawscope/DrawStyle;Landroidx/compose/ui/graphics/ColorFilter;I)V", "color", "Landroidx/compose/ui/graphics/Color;", "drawArc-yD3GUKo", "(JFFZJJFLandroidx/compose/ui/graphics/drawscope/DrawStyle;Landroidx/compose/ui/graphics/ColorFilter;I)V", "drawCircle", "radius", "drawCircle-V9BoPsw", "(Landroidx/compose/ui/graphics/Brush;FJFLandroidx/compose/ui/graphics/drawscope/DrawStyle;Landroidx/compose/ui/graphics/ColorFilter;I)V", "drawCircle-VaOC9Bg", "(JFJFLandroidx/compose/ui/graphics/drawscope/DrawStyle;Landroidx/compose/ui/graphics/ColorFilter;I)V", "drawImage", "image", "Landroidx/compose/ui/graphics/ImageBitmap;", "drawImage-gbVJVH8", "(Landroidx/compose/ui/graphics/ImageBitmap;JFLandroidx/compose/ui/graphics/drawscope/DrawStyle;Landroidx/compose/ui/graphics/ColorFilter;I)V", "srcOffset", "Landroidx/compose/ui/unit/IntOffset;", "srcSize", "Landroidx/compose/ui/unit/IntSize;", "dstOffset", "dstSize", "drawImage-9jGpkUE", "(Landroidx/compose/ui/graphics/ImageBitmap;JJJJFLandroidx/compose/ui/graphics/drawscope/DrawStyle;Landroidx/compose/ui/graphics/ColorFilter;I)V", "filterQuality", "Landroidx/compose/ui/graphics/FilterQuality;", "drawImage-AZ2fEMs", "(Landroidx/compose/ui/graphics/ImageBitmap;JJJJFLandroidx/compose/ui/graphics/drawscope/DrawStyle;Landroidx/compose/ui/graphics/ColorFilter;II)V", "drawLine", TtmlNode.START, TtmlNode.END, "strokeWidth", "cap", "Landroidx/compose/ui/graphics/StrokeCap;", "pathEffect", "Landroidx/compose/ui/graphics/PathEffect;", "drawLine-1RTmtNc", "(Landroidx/compose/ui/graphics/Brush;JJFILandroidx/compose/ui/graphics/PathEffect;FLandroidx/compose/ui/graphics/ColorFilter;I)V", "drawLine-NGM6Ib0", "(JJJFILandroidx/compose/ui/graphics/PathEffect;FLandroidx/compose/ui/graphics/ColorFilter;I)V", "drawOval", "drawOval-AsUm42w", "(Landroidx/compose/ui/graphics/Brush;JJFLandroidx/compose/ui/graphics/drawscope/DrawStyle;Landroidx/compose/ui/graphics/ColorFilter;I)V", "drawOval-n-J9OG0", "(JJJFLandroidx/compose/ui/graphics/drawscope/DrawStyle;Landroidx/compose/ui/graphics/ColorFilter;I)V", "drawPath", "path", "Landroidx/compose/ui/graphics/Path;", "drawPath-GBMwjPU", "(Landroidx/compose/ui/graphics/Path;Landroidx/compose/ui/graphics/Brush;FLandroidx/compose/ui/graphics/drawscope/DrawStyle;Landroidx/compose/ui/graphics/ColorFilter;I)V", "drawPath-LG529CI", "(Landroidx/compose/ui/graphics/Path;JFLandroidx/compose/ui/graphics/drawscope/DrawStyle;Landroidx/compose/ui/graphics/ColorFilter;I)V", "drawPoints", "points", "", "pointMode", "Landroidx/compose/ui/graphics/PointMode;", "drawPoints-Gsft0Ws", "(Ljava/util/List;ILandroidx/compose/ui/graphics/Brush;FILandroidx/compose/ui/graphics/PathEffect;FLandroidx/compose/ui/graphics/ColorFilter;I)V", "drawPoints-F8ZwMP8", "(Ljava/util/List;IJFILandroidx/compose/ui/graphics/PathEffect;FLandroidx/compose/ui/graphics/ColorFilter;I)V", "drawRect", "drawRect-AsUm42w", "drawRect-n-J9OG0", "drawRoundRect", "cornerRadius", "Landroidx/compose/ui/geometry/CornerRadius;", "drawRoundRect-ZuiqVtQ", "(Landroidx/compose/ui/graphics/Brush;JJJFLandroidx/compose/ui/graphics/drawscope/DrawStyle;Landroidx/compose/ui/graphics/ColorFilter;I)V", "drawRoundRect-u-Aw5IA", "(JJJJLandroidx/compose/ui/graphics/drawscope/DrawStyle;FLandroidx/compose/ui/graphics/ColorFilter;I)V", "offsetSize", TypedValues.CycleType.S_WAVE_OFFSET, "offsetSize-PENXr5M", "(JJ)J", "record", "Landroidx/compose/ui/graphics/layer/GraphicsLayer;", "block", "Lkotlin/Function1;", "Lkotlin/ExtensionFunctionType;", "record-JVtK1S4", "(Landroidx/compose/ui/graphics/layer/GraphicsLayer;JLkotlin/jvm/functions/Function1;)V", "Companion", "ui-graphics_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes.dex */
public interface DrawScope extends Density {
    public static final Companion Companion = Companion.$$INSTANCE;

    /* renamed from: drawArc-illE91I */
    void mo4537drawArcillE91I(Brush brush, float f, float f2, boolean z, long j, long j2, float f3, DrawStyle drawStyle, ColorFilter colorFilter, int i);

    /* renamed from: drawArc-yD3GUKo */
    void mo4538drawArcyD3GUKo(long j, float f, float f2, boolean z, long j2, long j3, float f3, DrawStyle drawStyle, ColorFilter colorFilter, int i);

    /* renamed from: drawCircle-V9BoPsw */
    void mo4539drawCircleV9BoPsw(Brush brush, float f, long j, float f2, DrawStyle drawStyle, ColorFilter colorFilter, int i);

    /* renamed from: drawCircle-VaOC9Bg */
    void mo4540drawCircleVaOC9Bg(long j, float f, long j2, float f2, DrawStyle drawStyle, ColorFilter colorFilter, int i);

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Prefer usage of drawImage that consumes an optional FilterQuality parameter", replaceWith = @ReplaceWith(expression = "drawImage(image, srcOffset, srcSize, dstOffset, dstSize, alpha, style, colorFilter, blendMode, FilterQuality.Low)", imports = {"androidx.compose.ui.graphics.drawscope", "androidx.compose.ui.graphics.FilterQuality"}))
    /* renamed from: drawImage-9jGpkUE */
    /* synthetic */ void mo4541drawImage9jGpkUE(ImageBitmap imageBitmap, long j, long j2, long j3, long j4, float f, DrawStyle drawStyle, ColorFilter colorFilter, int i);

    /* renamed from: drawImage-gbVJVH8 */
    void mo4543drawImagegbVJVH8(ImageBitmap imageBitmap, long j, float f, DrawStyle drawStyle, ColorFilter colorFilter, int i);

    /* renamed from: drawLine-1RTmtNc */
    void mo4544drawLine1RTmtNc(Brush brush, long j, long j2, float f, int i, PathEffect pathEffect, float f2, ColorFilter colorFilter, int i2);

    /* renamed from: drawLine-NGM6Ib0 */
    void mo4545drawLineNGM6Ib0(long j, long j2, long j3, float f, int i, PathEffect pathEffect, float f2, ColorFilter colorFilter, int i2);

    /* renamed from: drawOval-AsUm42w */
    void mo4546drawOvalAsUm42w(Brush brush, long j, long j2, float f, DrawStyle drawStyle, ColorFilter colorFilter, int i);

    /* renamed from: drawOval-n-J9OG0 */
    void mo4547drawOvalnJ9OG0(long j, long j2, long j3, float f, DrawStyle drawStyle, ColorFilter colorFilter, int i);

    /* renamed from: drawPath-GBMwjPU */
    void mo4548drawPathGBMwjPU(Path path, Brush brush, float f, DrawStyle drawStyle, ColorFilter colorFilter, int i);

    /* renamed from: drawPath-LG529CI */
    void mo4549drawPathLG529CI(Path path, long j, float f, DrawStyle drawStyle, ColorFilter colorFilter, int i);

    /* renamed from: drawPoints-F8ZwMP8 */
    void mo4550drawPointsF8ZwMP8(List<Offset> list, int i, long j, float f, int i2, PathEffect pathEffect, float f2, ColorFilter colorFilter, int i3);

    /* renamed from: drawPoints-Gsft0Ws */
    void mo4551drawPointsGsft0Ws(List<Offset> list, int i, Brush brush, float f, int i2, PathEffect pathEffect, float f2, ColorFilter colorFilter, int i3);

    /* renamed from: drawRect-AsUm42w */
    void mo4552drawRectAsUm42w(Brush brush, long j, long j2, float f, DrawStyle drawStyle, ColorFilter colorFilter, int i);

    /* renamed from: drawRect-n-J9OG0 */
    void mo4553drawRectnJ9OG0(long j, long j2, long j3, float f, DrawStyle drawStyle, ColorFilter colorFilter, int i);

    /* renamed from: drawRoundRect-ZuiqVtQ */
    void mo4554drawRoundRectZuiqVtQ(Brush brush, long j, long j2, long j3, float f, DrawStyle drawStyle, ColorFilter colorFilter, int i);

    /* renamed from: drawRoundRect-u-Aw5IA */
    void mo4555drawRoundRectuAw5IA(long j, long j2, long j3, long j4, DrawStyle drawStyle, float f, ColorFilter colorFilter, int i);

    DrawContext getDrawContext();

    LayoutDirection getLayoutDirection();

    /* compiled from: DrawScope.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    /* loaded from: classes.dex */
    public static final class DefaultImpls {
        @Deprecated
        /* renamed from: roundToPx--R2X_6o  reason: not valid java name */
        public static int m4668roundToPxR2X_6o(DrawScope drawScope, long j) {
            return DrawScope.super.mo382roundToPxR2X_6o(j);
        }

        @Deprecated
        /* renamed from: roundToPx-0680j_4  reason: not valid java name */
        public static int m4669roundToPx0680j_4(DrawScope drawScope, float f) {
            return DrawScope.super.mo383roundToPx0680j_4(f);
        }

        @Deprecated
        /* renamed from: toDp-GaN1DYA  reason: not valid java name */
        public static float m4670toDpGaN1DYA(DrawScope drawScope, long j) {
            return DrawScope.super.mo384toDpGaN1DYA(j);
        }

        @Deprecated
        /* renamed from: toDp-u2uoSUM  reason: not valid java name */
        public static float m4671toDpu2uoSUM(DrawScope drawScope, float f) {
            return DrawScope.super.mo385toDpu2uoSUM(f);
        }

        @Deprecated
        /* renamed from: toDp-u2uoSUM  reason: not valid java name */
        public static float m4672toDpu2uoSUM(DrawScope drawScope, int i) {
            return DrawScope.super.mo386toDpu2uoSUM(i);
        }

        @Deprecated
        /* renamed from: toDpSize-k-rfVVM  reason: not valid java name */
        public static long m4673toDpSizekrfVVM(DrawScope drawScope, long j) {
            return DrawScope.super.mo387toDpSizekrfVVM(j);
        }

        @Deprecated
        /* renamed from: toPx--R2X_6o  reason: not valid java name */
        public static float m4674toPxR2X_6o(DrawScope drawScope, long j) {
            return DrawScope.super.mo388toPxR2X_6o(j);
        }

        @Deprecated
        /* renamed from: toPx-0680j_4  reason: not valid java name */
        public static float m4675toPx0680j_4(DrawScope drawScope, float f) {
            return DrawScope.super.mo389toPx0680j_4(f);
        }

        @Deprecated
        public static Rect toRect(DrawScope drawScope, DpRect dpRect) {
            return DrawScope.super.toRect(dpRect);
        }

        @Deprecated
        /* renamed from: toSize-XkaWNTQ  reason: not valid java name */
        public static long m4676toSizeXkaWNTQ(DrawScope drawScope, long j) {
            return DrawScope.super.mo390toSizeXkaWNTQ(j);
        }

        @Deprecated
        /* renamed from: toSp-0xMU5do  reason: not valid java name */
        public static long m4677toSp0xMU5do(DrawScope drawScope, float f) {
            return DrawScope.super.mo391toSp0xMU5do(f);
        }

        @Deprecated
        /* renamed from: toSp-kPz2Gy4  reason: not valid java name */
        public static long m4678toSpkPz2Gy4(DrawScope drawScope, float f) {
            return DrawScope.super.mo392toSpkPz2Gy4(f);
        }

        @Deprecated
        /* renamed from: toSp-kPz2Gy4  reason: not valid java name */
        public static long m4679toSpkPz2Gy4(DrawScope drawScope, int i) {
            return DrawScope.super.mo393toSpkPz2Gy4(i);
        }

        @Deprecated
        /* renamed from: getCenter-F1C5BW0  reason: not valid java name */
        public static long m4664getCenterF1C5BW0(DrawScope drawScope) {
            return DrawScope.super.mo4639getCenterF1C5BW0();
        }

        @Deprecated
        /* renamed from: getSize-NH-jbRc  reason: not valid java name */
        public static long m4665getSizeNHjbRc(DrawScope drawScope) {
            return DrawScope.super.mo4640getSizeNHjbRc();
        }

        @Deprecated
        /* renamed from: drawImage-AZ2fEMs  reason: not valid java name */
        public static void m4649drawImageAZ2fEMs(DrawScope drawScope, ImageBitmap imageBitmap, long j, long j2, long j3, long j4, float f, DrawStyle drawStyle, ColorFilter colorFilter, int i, int i2) {
            DrawScope.super.mo4542drawImageAZ2fEMs(imageBitmap, j, j2, j3, j4, f, drawStyle, colorFilter, i, i2);
        }

        @Deprecated
        /* renamed from: record-JVtK1S4  reason: not valid java name */
        public static void m4666recordJVtK1S4(DrawScope drawScope, GraphicsLayer graphicsLayer, long j, Function1<? super DrawScope, Unit> function1) {
            DrawScope.super.mo4641recordJVtK1S4(graphicsLayer, j, function1);
        }
    }

    /* renamed from: getCenter-F1C5BW0  reason: not valid java name */
    default long mo4639getCenterF1C5BW0() {
        return SizeKt.m3916getCenteruvyYCjk(getDrawContext().mo4561getSizeNHjbRc());
    }

    /* renamed from: getSize-NH-jbRc  reason: not valid java name */
    default long mo4640getSizeNHjbRc() {
        return getDrawContext().mo4561getSizeNHjbRc();
    }

    /* renamed from: drawLine-1RTmtNc$default  reason: not valid java name */
    static /* synthetic */ void m4625drawLine1RTmtNc$default(DrawScope drawScope, Brush brush, long j, long j2, float f, int i, PathEffect pathEffect, float f2, ColorFilter colorFilter, int i2, int i3, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: drawLine-1RTmtNc");
        }
        drawScope.mo4544drawLine1RTmtNc(brush, j, j2, (i3 & 8) != 0 ? 0.0f : f, (i3 & 16) != 0 ? Stroke.Companion.m4711getDefaultCapKaPHkGw() : i, (i3 & 32) != 0 ? null : pathEffect, (i3 & 64) != 0 ? 1.0f : f2, (i3 & 128) != 0 ? null : colorFilter, (i3 & 256) != 0 ? Companion.m4642getDefaultBlendMode0nO6VwU() : i2);
    }

    /* renamed from: drawLine-NGM6Ib0$default  reason: not valid java name */
    static /* synthetic */ void m4626drawLineNGM6Ib0$default(DrawScope drawScope, long j, long j2, long j3, float f, int i, PathEffect pathEffect, float f2, ColorFilter colorFilter, int i2, int i3, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: drawLine-NGM6Ib0");
        }
        drawScope.mo4545drawLineNGM6Ib0(j, j2, j3, (i3 & 8) != 0 ? 0.0f : f, (i3 & 16) != 0 ? Stroke.Companion.m4711getDefaultCapKaPHkGw() : i, (i3 & 32) != 0 ? null : pathEffect, (i3 & 64) != 0 ? 1.0f : f2, (i3 & 128) != 0 ? null : colorFilter, (i3 & 256) != 0 ? Companion.m4642getDefaultBlendMode0nO6VwU() : i2);
    }

    /* renamed from: drawRect-AsUm42w$default  reason: not valid java name */
    static /* synthetic */ void m4633drawRectAsUm42w$default(DrawScope drawScope, Brush brush, long j, long j2, float f, DrawStyle drawStyle, ColorFilter colorFilter, int i, int i2, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: drawRect-AsUm42w");
        }
        long m3853getZeroF1C5BW0 = (i2 & 2) != 0 ? Offset.Companion.m3853getZeroF1C5BW0() : j;
        drawScope.mo4552drawRectAsUm42w(brush, m3853getZeroF1C5BW0, (i2 & 4) != 0 ? drawScope.m4637offsetSizePENXr5M(drawScope.mo4640getSizeNHjbRc(), m3853getZeroF1C5BW0) : j2, (i2 & 8) != 0 ? 1.0f : f, (i2 & 16) != 0 ? Fill.INSTANCE : drawStyle, (i2 & 32) != 0 ? null : colorFilter, (i2 & 64) != 0 ? Companion.m4642getDefaultBlendMode0nO6VwU() : i);
    }

    /* renamed from: drawRect-n-J9OG0$default  reason: not valid java name */
    static /* synthetic */ void m4634drawRectnJ9OG0$default(DrawScope drawScope, long j, long j2, long j3, float f, DrawStyle drawStyle, ColorFilter colorFilter, int i, int i2, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: drawRect-n-J9OG0");
        }
        long m3853getZeroF1C5BW0 = (i2 & 2) != 0 ? Offset.Companion.m3853getZeroF1C5BW0() : j2;
        drawScope.mo4553drawRectnJ9OG0(j, m3853getZeroF1C5BW0, (i2 & 4) != 0 ? drawScope.m4637offsetSizePENXr5M(drawScope.mo4640getSizeNHjbRc(), m3853getZeroF1C5BW0) : j3, (i2 & 8) != 0 ? 1.0f : f, (i2 & 16) != 0 ? Fill.INSTANCE : drawStyle, (i2 & 32) != 0 ? null : colorFilter, (i2 & 64) != 0 ? Companion.m4642getDefaultBlendMode0nO6VwU() : i);
    }

    /* renamed from: drawImage-gbVJVH8$default  reason: not valid java name */
    static /* synthetic */ void m4624drawImagegbVJVH8$default(DrawScope drawScope, ImageBitmap imageBitmap, long j, float f, DrawStyle drawStyle, ColorFilter colorFilter, int i, int i2, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: drawImage-gbVJVH8");
        }
        drawScope.mo4543drawImagegbVJVH8(imageBitmap, (i2 & 2) != 0 ? Offset.Companion.m3853getZeroF1C5BW0() : j, (i2 & 4) != 0 ? 1.0f : f, (i2 & 8) != 0 ? Fill.INSTANCE : drawStyle, (i2 & 16) != 0 ? null : colorFilter, (i2 & 32) != 0 ? Companion.m4642getDefaultBlendMode0nO6VwU() : i);
    }

    /* renamed from: drawImage-9jGpkUE$default  reason: not valid java name */
    static /* synthetic */ void m4622drawImage9jGpkUE$default(DrawScope drawScope, ImageBitmap imageBitmap, long j, long j2, long j3, long j4, float f, DrawStyle drawStyle, ColorFilter colorFilter, int i, int i2, Object obj) {
        long j5;
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: drawImage-9jGpkUE");
        }
        long m6823getZeronOccac = (i2 & 2) != 0 ? IntOffset.Companion.m6823getZeronOccac() : j;
        if ((i2 & 4) != 0) {
            j5 = IntSize.m6850constructorimpl((imageBitmap.getHeight() & 4294967295L) | (imageBitmap.getWidth() << 32));
        } else {
            j5 = j2;
        }
        drawScope.mo4541drawImage9jGpkUE(imageBitmap, m6823getZeronOccac, j5, (i2 & 8) != 0 ? IntOffset.Companion.m6823getZeronOccac() : j3, (i2 & 16) != 0 ? j5 : j4, (i2 & 32) != 0 ? 1.0f : f, (i2 & 64) != 0 ? Fill.INSTANCE : drawStyle, (i2 & 128) != 0 ? null : colorFilter, (i2 & 256) != 0 ? Companion.m4642getDefaultBlendMode0nO6VwU() : i);
    }

    /* renamed from: drawImage-AZ2fEMs$default  reason: not valid java name */
    static /* synthetic */ void m4623drawImageAZ2fEMs$default(DrawScope drawScope, ImageBitmap imageBitmap, long j, long j2, long j3, long j4, float f, DrawStyle drawStyle, ColorFilter colorFilter, int i, int i2, int i3, Object obj) {
        long j5;
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: drawImage-AZ2fEMs");
        }
        long m6823getZeronOccac = (i3 & 2) != 0 ? IntOffset.Companion.m6823getZeronOccac() : j;
        if ((i3 & 4) != 0) {
            j5 = IntSize.m6850constructorimpl((imageBitmap.getHeight() & 4294967295L) | (imageBitmap.getWidth() << 32));
        } else {
            j5 = j2;
        }
        drawScope.mo4542drawImageAZ2fEMs(imageBitmap, m6823getZeronOccac, j5, (i3 & 8) != 0 ? IntOffset.Companion.m6823getZeronOccac() : j3, (i3 & 16) != 0 ? j5 : j4, (i3 & 32) != 0 ? 1.0f : f, (i3 & 64) != 0 ? Fill.INSTANCE : drawStyle, (i3 & 128) != 0 ? null : colorFilter, (i3 & 256) != 0 ? Companion.m4642getDefaultBlendMode0nO6VwU() : i, (i3 & 512) != 0 ? Companion.m4643getDefaultFilterQualityfv9h1I() : i2);
    }

    /* renamed from: drawImage-AZ2fEMs */
    default void mo4542drawImageAZ2fEMs(ImageBitmap imageBitmap, long j, long j2, long j3, long j4, float f, DrawStyle drawStyle, ColorFilter colorFilter, int i, int i2) {
        m4623drawImageAZ2fEMs$default(this, imageBitmap, j, j2, j3, j4, f, drawStyle, colorFilter, i, 0, 512, null);
    }

    /* renamed from: drawRoundRect-ZuiqVtQ$default  reason: not valid java name */
    static /* synthetic */ void m4635drawRoundRectZuiqVtQ$default(DrawScope drawScope, Brush brush, long j, long j2, long j3, float f, DrawStyle drawStyle, ColorFilter colorFilter, int i, int i2, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: drawRoundRect-ZuiqVtQ");
        }
        long m3853getZeroF1C5BW0 = (i2 & 2) != 0 ? Offset.Companion.m3853getZeroF1C5BW0() : j;
        drawScope.mo4554drawRoundRectZuiqVtQ(brush, m3853getZeroF1C5BW0, (i2 & 4) != 0 ? drawScope.m4637offsetSizePENXr5M(drawScope.mo4640getSizeNHjbRc(), m3853getZeroF1C5BW0) : j2, (i2 & 8) != 0 ? CornerRadius.Companion.m3809getZerokKHJgLs() : j3, (i2 & 16) != 0 ? 1.0f : f, (i2 & 32) != 0 ? Fill.INSTANCE : drawStyle, (i2 & 64) != 0 ? null : colorFilter, (i2 & 128) != 0 ? Companion.m4642getDefaultBlendMode0nO6VwU() : i);
    }

    /* renamed from: drawRoundRect-u-Aw5IA$default  reason: not valid java name */
    static /* synthetic */ void m4636drawRoundRectuAw5IA$default(DrawScope drawScope, long j, long j2, long j3, long j4, DrawStyle drawStyle, float f, ColorFilter colorFilter, int i, int i2, Object obj) {
        DrawScope drawScope2;
        long j5;
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: drawRoundRect-u-Aw5IA");
        }
        long m3853getZeroF1C5BW0 = (i2 & 2) != 0 ? Offset.Companion.m3853getZeroF1C5BW0() : j2;
        if ((i2 & 4) != 0) {
            drawScope2 = drawScope;
            j5 = drawScope2.m4637offsetSizePENXr5M(drawScope.mo4640getSizeNHjbRc(), m3853getZeroF1C5BW0);
        } else {
            drawScope2 = drawScope;
            j5 = j3;
        }
        drawScope2.mo4555drawRoundRectuAw5IA(j, m3853getZeroF1C5BW0, j5, (i2 & 8) != 0 ? CornerRadius.Companion.m3809getZerokKHJgLs() : j4, (i2 & 16) != 0 ? Fill.INSTANCE : drawStyle, (i2 & 32) != 0 ? 1.0f : f, (i2 & 64) != 0 ? null : colorFilter, (i2 & 128) != 0 ? Companion.m4642getDefaultBlendMode0nO6VwU() : i);
    }

    /* renamed from: drawCircle-V9BoPsw$default  reason: not valid java name */
    static /* synthetic */ void m4620drawCircleV9BoPsw$default(DrawScope drawScope, Brush brush, float f, long j, float f2, DrawStyle drawStyle, ColorFilter colorFilter, int i, int i2, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: drawCircle-V9BoPsw");
        }
        drawScope.mo4539drawCircleV9BoPsw(brush, (i2 & 2) != 0 ? Size.m3905getMinDimensionimpl(drawScope.mo4640getSizeNHjbRc()) / 2.0f : f, (i2 & 4) != 0 ? drawScope.mo4639getCenterF1C5BW0() : j, (i2 & 8) != 0 ? 1.0f : f2, (i2 & 16) != 0 ? Fill.INSTANCE : drawStyle, (i2 & 32) != 0 ? null : colorFilter, (i2 & 64) != 0 ? Companion.m4642getDefaultBlendMode0nO6VwU() : i);
    }

    /* renamed from: drawCircle-VaOC9Bg$default  reason: not valid java name */
    static /* synthetic */ void m4621drawCircleVaOC9Bg$default(DrawScope drawScope, long j, float f, long j2, float f2, DrawStyle drawStyle, ColorFilter colorFilter, int i, int i2, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: drawCircle-VaOC9Bg");
        }
        if ((i2 & 2) != 0) {
            f = Size.m3905getMinDimensionimpl(drawScope.mo4640getSizeNHjbRc()) / 2.0f;
        }
        drawScope.mo4540drawCircleVaOC9Bg(j, f, (i2 & 4) != 0 ? drawScope.mo4639getCenterF1C5BW0() : j2, (i2 & 8) != 0 ? 1.0f : f2, (i2 & 16) != 0 ? Fill.INSTANCE : drawStyle, (i2 & 32) != 0 ? null : colorFilter, (i2 & 64) != 0 ? Companion.m4642getDefaultBlendMode0nO6VwU() : i);
    }

    /* renamed from: drawOval-AsUm42w$default  reason: not valid java name */
    static /* synthetic */ void m4627drawOvalAsUm42w$default(DrawScope drawScope, Brush brush, long j, long j2, float f, DrawStyle drawStyle, ColorFilter colorFilter, int i, int i2, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: drawOval-AsUm42w");
        }
        long m3853getZeroF1C5BW0 = (i2 & 2) != 0 ? Offset.Companion.m3853getZeroF1C5BW0() : j;
        drawScope.mo4546drawOvalAsUm42w(brush, m3853getZeroF1C5BW0, (i2 & 4) != 0 ? drawScope.m4637offsetSizePENXr5M(drawScope.mo4640getSizeNHjbRc(), m3853getZeroF1C5BW0) : j2, (i2 & 8) != 0 ? 1.0f : f, (i2 & 16) != 0 ? Fill.INSTANCE : drawStyle, (i2 & 32) != 0 ? null : colorFilter, (i2 & 64) != 0 ? Companion.m4642getDefaultBlendMode0nO6VwU() : i);
    }

    /* renamed from: drawOval-n-J9OG0$default  reason: not valid java name */
    static /* synthetic */ void m4628drawOvalnJ9OG0$default(DrawScope drawScope, long j, long j2, long j3, float f, DrawStyle drawStyle, ColorFilter colorFilter, int i, int i2, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: drawOval-n-J9OG0");
        }
        long m3853getZeroF1C5BW0 = (i2 & 2) != 0 ? Offset.Companion.m3853getZeroF1C5BW0() : j2;
        drawScope.mo4547drawOvalnJ9OG0(j, m3853getZeroF1C5BW0, (i2 & 4) != 0 ? drawScope.m4637offsetSizePENXr5M(drawScope.mo4640getSizeNHjbRc(), m3853getZeroF1C5BW0) : j3, (i2 & 8) != 0 ? 1.0f : f, (i2 & 16) != 0 ? Fill.INSTANCE : drawStyle, (i2 & 32) != 0 ? null : colorFilter, (i2 & 64) != 0 ? Companion.m4642getDefaultBlendMode0nO6VwU() : i);
    }

    /* renamed from: drawArc-illE91I$default  reason: not valid java name */
    static /* synthetic */ void m4618drawArcillE91I$default(DrawScope drawScope, Brush brush, float f, float f2, boolean z, long j, long j2, float f3, DrawStyle drawStyle, ColorFilter colorFilter, int i, int i2, Object obj) {
        DrawScope drawScope2;
        long j3;
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: drawArc-illE91I");
        }
        long m3853getZeroF1C5BW0 = (i2 & 16) != 0 ? Offset.Companion.m3853getZeroF1C5BW0() : j;
        if ((i2 & 32) != 0) {
            drawScope2 = drawScope;
            j3 = drawScope2.m4637offsetSizePENXr5M(drawScope.mo4640getSizeNHjbRc(), m3853getZeroF1C5BW0);
        } else {
            drawScope2 = drawScope;
            j3 = j2;
        }
        drawScope2.mo4537drawArcillE91I(brush, f, f2, z, m3853getZeroF1C5BW0, j3, (i2 & 64) != 0 ? 1.0f : f3, (i2 & 128) != 0 ? Fill.INSTANCE : drawStyle, (i2 & 256) != 0 ? null : colorFilter, (i2 & 512) != 0 ? Companion.m4642getDefaultBlendMode0nO6VwU() : i);
    }

    /* renamed from: drawArc-yD3GUKo$default  reason: not valid java name */
    static /* synthetic */ void m4619drawArcyD3GUKo$default(DrawScope drawScope, long j, float f, float f2, boolean z, long j2, long j3, float f3, DrawStyle drawStyle, ColorFilter colorFilter, int i, int i2, Object obj) {
        DrawScope drawScope2;
        long j4;
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: drawArc-yD3GUKo");
        }
        long m3853getZeroF1C5BW0 = (i2 & 16) != 0 ? Offset.Companion.m3853getZeroF1C5BW0() : j2;
        if ((i2 & 32) != 0) {
            drawScope2 = drawScope;
            j4 = drawScope2.m4637offsetSizePENXr5M(drawScope.mo4640getSizeNHjbRc(), m3853getZeroF1C5BW0);
        } else {
            drawScope2 = drawScope;
            j4 = j3;
        }
        drawScope2.mo4538drawArcyD3GUKo(j, f, f2, z, m3853getZeroF1C5BW0, j4, (i2 & 64) != 0 ? 1.0f : f3, (i2 & 128) != 0 ? Fill.INSTANCE : drawStyle, (i2 & 256) != 0 ? null : colorFilter, (i2 & 512) != 0 ? Companion.m4642getDefaultBlendMode0nO6VwU() : i);
    }

    /* renamed from: drawPath-LG529CI$default  reason: not valid java name */
    static /* synthetic */ void m4630drawPathLG529CI$default(DrawScope drawScope, Path path, long j, float f, DrawStyle drawStyle, ColorFilter colorFilter, int i, int i2, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: drawPath-LG529CI");
        }
        if ((i2 & 4) != 0) {
            f = 1.0f;
        }
        float f2 = f;
        if ((i2 & 8) != 0) {
            drawStyle = Fill.INSTANCE;
        }
        DrawStyle drawStyle2 = drawStyle;
        if ((i2 & 16) != 0) {
            colorFilter = null;
        }
        drawScope.mo4549drawPathLG529CI(path, j, f2, drawStyle2, colorFilter, (i2 & 32) != 0 ? Companion.m4642getDefaultBlendMode0nO6VwU() : i);
    }

    /* renamed from: drawPath-GBMwjPU$default  reason: not valid java name */
    static /* synthetic */ void m4629drawPathGBMwjPU$default(DrawScope drawScope, Path path, Brush brush, float f, DrawStyle drawStyle, ColorFilter colorFilter, int i, int i2, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: drawPath-GBMwjPU");
        }
        if ((i2 & 4) != 0) {
            f = 1.0f;
        }
        float f2 = f;
        if ((i2 & 8) != 0) {
            drawStyle = Fill.INSTANCE;
        }
        DrawStyle drawStyle2 = drawStyle;
        if ((i2 & 16) != 0) {
            colorFilter = null;
        }
        ColorFilter colorFilter2 = colorFilter;
        if ((i2 & 32) != 0) {
            i = Companion.m4642getDefaultBlendMode0nO6VwU();
        }
        drawScope.mo4548drawPathGBMwjPU(path, brush, f2, drawStyle2, colorFilter2, i);
    }

    /* renamed from: drawPoints-F8ZwMP8$default  reason: not valid java name */
    static /* synthetic */ void m4631drawPointsF8ZwMP8$default(DrawScope drawScope, List list, int i, long j, float f, int i2, PathEffect pathEffect, float f2, ColorFilter colorFilter, int i3, int i4, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: drawPoints-F8ZwMP8");
        }
        drawScope.mo4550drawPointsF8ZwMP8(list, i, j, (i4 & 8) != 0 ? 0.0f : f, (i4 & 16) != 0 ? StrokeCap.Companion.m4432getButtKaPHkGw() : i2, (i4 & 32) != 0 ? null : pathEffect, (i4 & 64) != 0 ? 1.0f : f2, (i4 & 128) != 0 ? null : colorFilter, (i4 & 256) != 0 ? Companion.m4642getDefaultBlendMode0nO6VwU() : i3);
    }

    /* renamed from: drawPoints-Gsft0Ws$default  reason: not valid java name */
    static /* synthetic */ void m4632drawPointsGsft0Ws$default(DrawScope drawScope, List list, int i, Brush brush, float f, int i2, PathEffect pathEffect, float f2, ColorFilter colorFilter, int i3, int i4, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: drawPoints-Gsft0Ws");
        }
        drawScope.mo4551drawPointsGsft0Ws(list, i, brush, (i4 & 8) != 0 ? 0.0f : f, (i4 & 16) != 0 ? StrokeCap.Companion.m4432getButtKaPHkGw() : i2, (i4 & 32) != 0 ? null : pathEffect, (i4 & 64) != 0 ? 1.0f : f2, (i4 & 128) != 0 ? null : colorFilter, (i4 & 256) != 0 ? Companion.m4642getDefaultBlendMode0nO6VwU() : i3);
    }

    /* renamed from: record-JVtK1S4$default  reason: not valid java name */
    static /* synthetic */ void m4638recordJVtK1S4$default(DrawScope drawScope, GraphicsLayer graphicsLayer, long j, Function1 function1, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: record-JVtK1S4");
        }
        if ((i & 1) != 0) {
            j = IntSizeKt.m6866toIntSizeuvyYCjk(drawScope.mo4640getSizeNHjbRc());
        }
        drawScope.mo4641recordJVtK1S4(graphicsLayer, j, function1);
    }

    /* renamed from: record-JVtK1S4  reason: not valid java name */
    default void mo4641recordJVtK1S4(GraphicsLayer graphicsLayer, long j, final Function1<? super DrawScope, Unit> function1) {
        graphicsLayer.m4734recordmLhObY(this, getLayoutDirection(), j, new Function1<DrawScope, Unit>() { // from class: androidx.compose.ui.graphics.drawscope.DrawScope$record$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(DrawScope drawScope) {
                invoke2(drawScope);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(DrawScope drawScope) {
                DrawScope drawScope2 = DrawScope.this;
                Density density = drawScope.getDrawContext().getDensity();
                LayoutDirection layoutDirection = drawScope.getDrawContext().getLayoutDirection();
                Canvas canvas = drawScope.getDrawContext().getCanvas();
                long mo4561getSizeNHjbRc = drawScope.getDrawContext().mo4561getSizeNHjbRc();
                GraphicsLayer graphicsLayer2 = drawScope.getDrawContext().getGraphicsLayer();
                Function1<DrawScope, Unit> function12 = function1;
                Density density2 = drawScope2.getDrawContext().getDensity();
                LayoutDirection layoutDirection2 = drawScope2.getDrawContext().getLayoutDirection();
                Canvas canvas2 = drawScope2.getDrawContext().getCanvas();
                long mo4561getSizeNHjbRc2 = drawScope2.getDrawContext().mo4561getSizeNHjbRc();
                GraphicsLayer graphicsLayer3 = drawScope2.getDrawContext().getGraphicsLayer();
                DrawContext drawContext = drawScope2.getDrawContext();
                drawContext.setDensity(density);
                drawContext.setLayoutDirection(layoutDirection);
                drawContext.setCanvas(canvas);
                drawContext.mo4562setSizeuvyYCjk(mo4561getSizeNHjbRc);
                drawContext.setGraphicsLayer(graphicsLayer2);
                canvas.save();
                try {
                    function12.invoke(drawScope2);
                } finally {
                    canvas.restore();
                    DrawContext drawContext2 = drawScope2.getDrawContext();
                    drawContext2.setDensity(density2);
                    drawContext2.setLayoutDirection(layoutDirection2);
                    drawContext2.setCanvas(canvas2);
                    drawContext2.mo4562setSizeuvyYCjk(mo4561getSizeNHjbRc2);
                    drawContext2.setGraphicsLayer(graphicsLayer3);
                }
            }
        });
    }

    /* compiled from: DrawScope.kt */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0019\u0010\u0003\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u0005\u0010\u0006R\u0019\u0010\b\u001a\u00020\tø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\n\u0010\u0006\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u000b"}, d2 = {"Landroidx/compose/ui/graphics/drawscope/DrawScope$Companion;", "", "()V", "DefaultBlendMode", "Landroidx/compose/ui/graphics/BlendMode;", "getDefaultBlendMode-0nO6VwU", "()I", "I", "DefaultFilterQuality", "Landroidx/compose/ui/graphics/FilterQuality;", "getDefaultFilterQuality-f-v9h1I", "ui-graphics_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* loaded from: classes.dex */
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();
        private static final int DefaultBlendMode = BlendMode.Companion.m4020getSrcOver0nO6VwU();
        private static final int DefaultFilterQuality = FilterQuality.Companion.m4178getLowfv9h1I();

        private Companion() {
        }

        /* renamed from: getDefaultBlendMode-0nO6VwU  reason: not valid java name */
        public final int m4642getDefaultBlendMode0nO6VwU() {
            return DefaultBlendMode;
        }

        /* renamed from: getDefaultFilterQuality-f-v9h1I  reason: not valid java name */
        public final int m4643getDefaultFilterQualityfv9h1I() {
            return DefaultFilterQuality;
        }
    }

    /* renamed from: offsetSize-PENXr5M  reason: not valid java name */
    private default long m4637offsetSizePENXr5M(long j, long j2) {
        return Size.m3897constructorimpl((Float.floatToRawIntBits(Float.intBitsToFloat((int) (j >> 32)) - Float.intBitsToFloat((int) (j2 >> 32))) << 32) | (Float.floatToRawIntBits(Float.intBitsToFloat((int) (j & 4294967295L)) - Float.intBitsToFloat((int) (j2 & 4294967295L))) & 4294967295L));
    }
}
