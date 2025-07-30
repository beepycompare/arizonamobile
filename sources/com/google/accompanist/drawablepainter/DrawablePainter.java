package com.google.accompanist.drawablepainter;

import android.graphics.drawable.Animatable;
import android.graphics.drawable.AnimatedImageDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Handler;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.RememberObserver;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.AndroidCanvas_androidKt;
import androidx.compose.ui.graphics.AndroidColorFilter_androidKt;
import androidx.compose.ui.graphics.Canvas;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.painter.Painter;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.ranges.RangesKt;
/* compiled from: DrawablePainter.kt */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\b\u0010\u001f\u001a\u00020 H\u0016J\b\u0010!\u001a\u00020 H\u0016J\b\u0010\"\u001a\u00020 H\u0016J\u0010\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020&H\u0014J\u0012\u0010'\u001a\u00020$2\b\u0010(\u001a\u0004\u0018\u00010)H\u0014J\u0010\u0010*\u001a\u00020$2\u0006\u0010+\u001a\u00020,H\u0014J\f\u0010/\u001a\u00020 *\u000200H\u0014R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR+\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\n8B@BX\u0082\u008e\u0002¢\u0006\u0012\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR+\u0010\u0013\u001a\u00020\u00122\u0006\u0010\t\u001a\u00020\u00128B@BX\u0082\u008e\u0002¢\u0006\u0012\n\u0004\b\u0018\u0010\u0011\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001b\u0010\u0019\u001a\u00020\u001a8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001b\u0010\u001cR\u0014\u0010-\u001a\u00020\u00128VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b.\u0010\u0015¨\u00061"}, d2 = {"Lcom/google/accompanist/drawablepainter/DrawablePainter;", "Landroidx/compose/ui/graphics/painter/Painter;", "Landroidx/compose/runtime/RememberObserver;", "drawable", "Landroid/graphics/drawable/Drawable;", "<init>", "(Landroid/graphics/drawable/Drawable;)V", "getDrawable", "()Landroid/graphics/drawable/Drawable;", "<set-?>", "", "drawInvalidateTick", "getDrawInvalidateTick", "()I", "setDrawInvalidateTick", "(I)V", "drawInvalidateTick$delegate", "Landroidx/compose/runtime/MutableState;", "Landroidx/compose/ui/geometry/Size;", "drawableIntrinsicSize", "getDrawableIntrinsicSize-NH-jbRc", "()J", "setDrawableIntrinsicSize-uvyYCjk", "(J)V", "drawableIntrinsicSize$delegate", "callback", "Landroid/graphics/drawable/Drawable$Callback;", "getCallback", "()Landroid/graphics/drawable/Drawable$Callback;", "callback$delegate", "Lkotlin/Lazy;", "onRemembered", "", "onAbandoned", "onForgotten", "applyAlpha", "", "alpha", "", "applyColorFilter", "colorFilter", "Landroidx/compose/ui/graphics/ColorFilter;", "applyLayoutDirection", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "intrinsicSize", "getIntrinsicSize-NH-jbRc", "onDraw", "Landroidx/compose/ui/graphics/drawscope/DrawScope;", "drawablepainter_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class DrawablePainter extends Painter implements RememberObserver {
    public static final int $stable = 8;
    private final Lazy callback$delegate;
    private final MutableState drawInvalidateTick$delegate;
    private final Drawable drawable;
    private final MutableState drawableIntrinsicSize$delegate;

    /* compiled from: DrawablePainter.kt */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[LayoutDirection.values().length];
            try {
                iArr[LayoutDirection.Ltr.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[LayoutDirection.Rtl.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public final Drawable getDrawable() {
        return this.drawable;
    }

    public DrawablePainter(Drawable drawable) {
        MutableState mutableStateOf$default;
        MutableState mutableStateOf$default2;
        Intrinsics.checkNotNullParameter(drawable, "drawable");
        this.drawable = drawable;
        mutableStateOf$default = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(0, null, 2, null);
        this.drawInvalidateTick$delegate = mutableStateOf$default;
        mutableStateOf$default2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Size.m3894boximpl(DrawablePainterKt.access$getIntrinsicSize(drawable)), null, 2, null);
        this.drawableIntrinsicSize$delegate = mutableStateOf$default2;
        this.callback$delegate = LazyKt.lazy(new Function0() { // from class: com.google.accompanist.drawablepainter.DrawablePainter$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                DrawablePainter$callback$2$1 callback_delegate$lambda$0;
                callback_delegate$lambda$0 = DrawablePainter.callback_delegate$lambda$0(DrawablePainter.this);
                return callback_delegate$lambda$0;
            }
        });
        if (drawable.getIntrinsicWidth() < 0 || drawable.getIntrinsicHeight() < 0) {
            return;
        }
        drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int getDrawInvalidateTick() {
        return ((Number) this.drawInvalidateTick$delegate.getValue()).intValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setDrawInvalidateTick(int i) {
        this.drawInvalidateTick$delegate.setValue(Integer.valueOf(i));
    }

    /* renamed from: getDrawableIntrinsicSize-NH-jbRc  reason: not valid java name */
    private final long m8060getDrawableIntrinsicSizeNHjbRc() {
        return ((Size) this.drawableIntrinsicSize$delegate.getValue()).m3911unboximpl();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: setDrawableIntrinsicSize-uvyYCjk  reason: not valid java name */
    public final void m8061setDrawableIntrinsicSizeuvyYCjk(long j) {
        this.drawableIntrinsicSize$delegate.setValue(Size.m3894boximpl(j));
    }

    private final Drawable.Callback getCallback() {
        return (Drawable.Callback) this.callback$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Type inference failed for: r0v0, types: [com.google.accompanist.drawablepainter.DrawablePainter$callback$2$1] */
    public static final DrawablePainter$callback$2$1 callback_delegate$lambda$0(final DrawablePainter drawablePainter) {
        return new Drawable.Callback() { // from class: com.google.accompanist.drawablepainter.DrawablePainter$callback$2$1
            @Override // android.graphics.drawable.Drawable.Callback
            public void invalidateDrawable(Drawable d) {
                int drawInvalidateTick;
                long intrinsicSize;
                Intrinsics.checkNotNullParameter(d, "d");
                drawInvalidateTick = DrawablePainter.this.getDrawInvalidateTick();
                DrawablePainter.this.setDrawInvalidateTick(drawInvalidateTick + 1);
                DrawablePainter drawablePainter2 = DrawablePainter.this;
                intrinsicSize = DrawablePainterKt.getIntrinsicSize(drawablePainter2.getDrawable());
                drawablePainter2.m8061setDrawableIntrinsicSizeuvyYCjk(intrinsicSize);
            }

            @Override // android.graphics.drawable.Drawable.Callback
            public void scheduleDrawable(Drawable d, Runnable what, long j) {
                Handler main_handler;
                Intrinsics.checkNotNullParameter(d, "d");
                Intrinsics.checkNotNullParameter(what, "what");
                main_handler = DrawablePainterKt.getMAIN_HANDLER();
                main_handler.postAtTime(what, j);
            }

            @Override // android.graphics.drawable.Drawable.Callback
            public void unscheduleDrawable(Drawable d, Runnable what) {
                Handler main_handler;
                Intrinsics.checkNotNullParameter(d, "d");
                Intrinsics.checkNotNullParameter(what, "what");
                main_handler = DrawablePainterKt.getMAIN_HANDLER();
                main_handler.removeCallbacks(what);
            }
        };
    }

    @Override // androidx.compose.runtime.RememberObserver
    public void onRemembered() {
        this.drawable.setCallback(getCallback());
        this.drawable.setVisible(true, true);
        Drawable drawable = this.drawable;
        if (drawable instanceof Animatable) {
            ((Animatable) drawable).start();
        }
    }

    @Override // androidx.compose.runtime.RememberObserver
    public void onAbandoned() {
        onForgotten();
    }

    @Override // androidx.compose.runtime.RememberObserver
    public void onForgotten() {
        Drawable drawable = this.drawable;
        if (drawable instanceof Animatable) {
            ((Animatable) drawable).stop();
        }
        this.drawable.setVisible(false, false);
        this.drawable.setCallback(null);
    }

    @Override // androidx.compose.ui.graphics.painter.Painter
    protected boolean applyAlpha(float f) {
        this.drawable.setAlpha(RangesKt.coerceIn(MathKt.roundToInt(f * 255), 0, 255));
        return true;
    }

    @Override // androidx.compose.ui.graphics.painter.Painter
    protected boolean applyColorFilter(ColorFilter colorFilter) {
        this.drawable.setColorFilter(colorFilter != null ? AndroidColorFilter_androidKt.asAndroidColorFilter(colorFilter) : null);
        return true;
    }

    @Override // androidx.compose.ui.graphics.painter.Painter
    protected boolean applyLayoutDirection(LayoutDirection layoutDirection) {
        Intrinsics.checkNotNullParameter(layoutDirection, "layoutDirection");
        Drawable drawable = this.drawable;
        int i = WhenMappings.$EnumSwitchMapping$0[layoutDirection.ordinal()];
        int i2 = 1;
        if (i == 1) {
            i2 = 0;
        } else if (i != 2) {
            throw new NoWhenBranchMatchedException();
        }
        return drawable.setLayoutDirection(i2);
    }

    @Override // androidx.compose.ui.graphics.painter.Painter
    /* renamed from: getIntrinsicSize-NH-jbRc */
    public long mo4761getIntrinsicSizeNHjbRc() {
        return m8060getDrawableIntrinsicSizeNHjbRc();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.compose.ui.graphics.painter.Painter
    public void onDraw(DrawScope drawScope) {
        Intrinsics.checkNotNullParameter(drawScope, "<this>");
        Canvas canvas = drawScope.getDrawContext().getCanvas();
        getDrawInvalidateTick();
        try {
            canvas.save();
            if (Build.VERSION.SDK_INT >= 28 && Build.VERSION.SDK_INT < 31 && (this.drawable instanceof AnimatedImageDrawable)) {
                canvas.scale(Size.m3906getWidthimpl(drawScope.mo4640getSizeNHjbRc()) / Size.m3906getWidthimpl(mo4761getIntrinsicSizeNHjbRc()), Size.m3903getHeightimpl(drawScope.mo4640getSizeNHjbRc()) / Size.m3903getHeightimpl(mo4761getIntrinsicSizeNHjbRc()));
            } else {
                this.drawable.setBounds(0, 0, MathKt.roundToInt(Size.m3906getWidthimpl(drawScope.mo4640getSizeNHjbRc())), MathKt.roundToInt(Size.m3903getHeightimpl(drawScope.mo4640getSizeNHjbRc())));
            }
            this.drawable.draw(AndroidCanvas_androidKt.getNativeCanvas(canvas));
        } finally {
            canvas.restore();
        }
    }
}
