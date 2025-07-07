package com.google.accompanist.drawablepainter;

import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.geometry.SizeKt;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.graphics.painter.ColorPainter;
import androidx.compose.ui.graphics.painter.Painter;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: DrawablePainter.kt */
@Metadata(d1 = {"\u0000 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0017\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0007¢\u0006\u0002\u0010\n\"\u001b\u0010\u0000\u001a\u00020\u00018BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0002\u0010\u0003\"\u0018\u0010\u000b\u001a\u00020\f*\u00020\t8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"MAIN_HANDLER", "Landroid/os/Handler;", "getMAIN_HANDLER", "()Landroid/os/Handler;", "MAIN_HANDLER$delegate", "Lkotlin/Lazy;", "rememberDrawablePainter", "Landroidx/compose/ui/graphics/painter/Painter;", "drawable", "Landroid/graphics/drawable/Drawable;", "(Landroid/graphics/drawable/Drawable;Landroidx/compose/runtime/Composer;I)Landroidx/compose/ui/graphics/painter/Painter;", "intrinsicSize", "Landroidx/compose/ui/geometry/Size;", "getIntrinsicSize", "(Landroid/graphics/drawable/Drawable;)J", "drawablepainter_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class DrawablePainterKt {
    private static final Lazy MAIN_HANDLER$delegate = LazyKt.lazy(LazyThreadSafetyMode.NONE, new Function0() { // from class: com.google.accompanist.drawablepainter.DrawablePainterKt$$ExternalSyntheticLambda0
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            Handler MAIN_HANDLER_delegate$lambda$0;
            MAIN_HANDLER_delegate$lambda$0 = DrawablePainterKt.MAIN_HANDLER_delegate$lambda$0();
            return MAIN_HANDLER_delegate$lambda$0;
        }
    });

    public static final /* synthetic */ long access$getIntrinsicSize(Drawable drawable) {
        return getIntrinsicSize(drawable);
    }

    public static final Handler getMAIN_HANDLER() {
        return (Handler) MAIN_HANDLER$delegate.getValue();
    }

    public static final Handler MAIN_HANDLER_delegate$lambda$0() {
        return new Handler(Looper.getMainLooper());
    }

    public static final Painter rememberDrawablePainter(Drawable drawable, Composer composer, int i) {
        DrawablePainter drawablePainter;
        composer.startReplaceGroup(1756822313);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1756822313, i, -1, "com.google.accompanist.drawablepainter.rememberDrawablePainter (DrawablePainter.kt:164)");
        }
        composer.startReplaceGroup(289266787);
        boolean changed = composer.changed(drawable);
        Object rememberedValue = composer.rememberedValue();
        if (changed || rememberedValue == Composer.Companion.getEmpty()) {
            if (drawable == null) {
                rememberedValue = EmptyPainter.INSTANCE;
            } else {
                if (drawable instanceof ColorDrawable) {
                    drawablePainter = new ColorPainter(ColorKt.Color(((ColorDrawable) drawable).getColor()), null);
                } else {
                    Drawable mutate = drawable.mutate();
                    Intrinsics.checkNotNullExpressionValue(mutate, "mutate(...)");
                    drawablePainter = new DrawablePainter(mutate);
                }
                rememberedValue = drawablePainter;
            }
            composer.updateRememberedValue(rememberedValue);
        }
        Painter painter = (Painter) rememberedValue;
        composer.endReplaceGroup();
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceGroup();
        return painter;
    }

    public static final long getIntrinsicSize(Drawable drawable) {
        if (drawable.getIntrinsicWidth() >= 0 && drawable.getIntrinsicHeight() >= 0) {
            return SizeKt.Size(drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
        }
        return Size.Companion.m3914getUnspecifiedNHjbRc();
    }
}
