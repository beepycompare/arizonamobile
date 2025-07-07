package coil3.transition;

import android.content.res.ColorStateList;
import android.graphics.BlendMode;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.os.SystemClock;
import androidx.media3.extractor.text.ttml.TtmlNode;
import androidx.vectordrawable.graphics.drawable.Animatable2Compat;
import coil3.decode.DecodeUtils;
import coil3.size.Scale;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.google.firebase.remoteconfig.RemoteConfigConstants;
import java.util.ArrayList;
import java.util.List;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.math.MathKt;
import kotlin.ranges.RangesKt;
/* compiled from: CrossfadeDrawable.kt */
@Metadata(d1 = {"\u0000\u0082\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0011\u0018\u0000 Z2\u00020\u00012\u00020\u00022\u00020\u0003:\u0001ZBE\b\u0007\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0001\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0001\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b\u0012\b\b\u0002\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020&H\u0016J\b\u0010'\u001a\u00020\tH\u0016J\u0010\u0010(\u001a\u00020$2\u0006\u0010)\u001a\u00020\tH\u0016J\b\u0010*\u001a\u00020\tH\u0017J\n\u0010+\u001a\u0004\u0018\u00010,H\u0016J\u0012\u0010-\u001a\u00020$2\b\u0010.\u001a\u0004\u0018\u00010,H\u0016J\u0010\u0010/\u001a\u00020$2\u0006\u00100\u001a\u000201H\u0014J\b\u00102\u001a\u00020\u000bH\u0016J\u0010\u00103\u001a\u00020\u000b2\u0006\u0010\u001e\u001a\u000204H\u0014J\u0010\u00105\u001a\u00020\u000b2\u0006\u00106\u001a\u00020\tH\u0014J\b\u00107\u001a\u00020\tH\u0016J\b\u00108\u001a\u00020\tH\u0016J\u0018\u00109\u001a\u00020$2\u0006\u0010:\u001a\u00020\u00012\u0006\u0010;\u001a\u00020<H\u0016J\u0010\u0010=\u001a\u00020$2\u0006\u0010:\u001a\u00020\u0001H\u0016J \u0010>\u001a\u00020$2\u0006\u0010:\u001a\u00020\u00012\u0006\u0010;\u001a\u00020<2\u0006\u0010?\u001a\u00020\u001cH\u0016J\u0010\u0010@\u001a\u00020$2\u0006\u0010A\u001a\u00020\tH\u0016J\u0012\u0010B\u001a\u00020$2\b\u0010C\u001a\u0004\u0018\u00010DH\u0016J\u0012\u0010E\u001a\u00020$2\b\u0010F\u001a\u0004\u0018\u00010GH\u0016J\u0012\u0010H\u001a\u00020$2\b\u0010I\u001a\u0004\u0018\u00010JH\u0017J\b\u0010K\u001a\u00020\u000bH\u0016J\b\u0010\u0004\u001a\u00020$H\u0016J\b\u0010L\u001a\u00020$H\u0016J\u0010\u0010M\u001a\u00020$2\u0006\u0010N\u001a\u00020\u0018H\u0016J\u0010\u0010O\u001a\u00020\u000b2\u0006\u0010N\u001a\u00020\u0018H\u0016J\b\u0010P\u001a\u00020$H\u0016J\u001d\u0010Q\u001a\u00020$2\u0006\u0010R\u001a\u00020\u00012\u0006\u0010S\u001a\u000201H\u0001¢\u0006\u0002\bTJ!\u0010U\u001a\u00020\t2\b\u0010V\u001a\u0004\u0018\u00010\t2\b\u0010W\u001a\u0004\u0018\u00010\tH\u0002¢\u0006\u0002\u0010XJ\b\u0010Y\u001a\u00020$H\u0002R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\f\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0014R\u0014\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00180\u0017X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\"\u0010\u0004\u001a\u0004\u0018\u00010\u00012\b\u0010\u001f\u001a\u0004\u0018\u00010\u0001@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b \u0010!R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0001¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010!¨\u0006["}, d2 = {"Lcoil3/transition/CrossfadeDrawable;", "Landroid/graphics/drawable/Drawable;", "Landroid/graphics/drawable/Drawable$Callback;", "Landroidx/vectordrawable/graphics/drawable/Animatable2Compat;", TtmlNode.START, TtmlNode.END, "scale", "Lcoil3/size/Scale;", "durationMillis", "", "fadeStart", "", "preferExactIntrinsicSize", "<init>", "(Landroid/graphics/drawable/Drawable;Landroid/graphics/drawable/Drawable;Lcoil3/size/Scale;IZZ)V", "getScale", "()Lcoil3/size/Scale;", "getDurationMillis", "()I", "getFadeStart", "()Z", "getPreferExactIntrinsicSize", "callbacks", "", "Landroidx/vectordrawable/graphics/drawable/Animatable2Compat$AnimationCallback;", "intrinsicWidth", "intrinsicHeight", "startTimeMillis", "", "maxAlpha", RemoteConfigConstants.ResponseFieldKey.STATE, "value", "getStart", "()Landroid/graphics/drawable/Drawable;", "getEnd", "draw", "", "canvas", "Landroid/graphics/Canvas;", "getAlpha", "setAlpha", "alpha", "getOpacity", "getColorFilter", "Landroid/graphics/ColorFilter;", "setColorFilter", "colorFilter", "onBoundsChange", "bounds", "Landroid/graphics/Rect;", "isStateful", "onStateChange", "", "onLevelChange", FirebaseAnalytics.Param.LEVEL, "getIntrinsicWidth", "getIntrinsicHeight", "unscheduleDrawable", "who", "what", "Ljava/lang/Runnable;", "invalidateDrawable", "scheduleDrawable", "when", "setTint", "tintColor", "setTintList", "tint", "Landroid/content/res/ColorStateList;", "setTintMode", "tintMode", "Landroid/graphics/PorterDuff$Mode;", "setTintBlendMode", "blendMode", "Landroid/graphics/BlendMode;", "isRunning", "stop", "registerAnimationCallback", "callback", "unregisterAnimationCallback", "clearAnimationCallbacks", "updateBounds", "drawable", "targetBounds", "updateBounds$coil_core_release", "computeIntrinsicDimension", "startSize", "endSize", "(Ljava/lang/Integer;Ljava/lang/Integer;)I", "markDone", "Companion", "coil-core_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class CrossfadeDrawable extends Drawable implements Drawable.Callback, Animatable2Compat {
    public static final Companion Companion = new Companion(null);
    public static final int DEFAULT_DURATION = 200;
    private static final int STATE_DONE = 2;
    private static final int STATE_RUNNING = 1;
    private static final int STATE_START = 0;
    private final List<Animatable2Compat.AnimationCallback> callbacks;
    private final int durationMillis;
    private final Drawable end;
    private final boolean fadeStart;
    private final int intrinsicHeight;
    private final int intrinsicWidth;
    private int maxAlpha;
    private final boolean preferExactIntrinsicSize;
    private final Scale scale;
    private Drawable start;
    private long startTimeMillis;
    private int state;

    public CrossfadeDrawable(Drawable drawable, Drawable drawable2) {
        this(drawable, drawable2, null, 0, false, false, 60, null);
    }

    public CrossfadeDrawable(Drawable drawable, Drawable drawable2, Scale scale) {
        this(drawable, drawable2, scale, 0, false, false, 56, null);
    }

    public CrossfadeDrawable(Drawable drawable, Drawable drawable2, Scale scale, int i) {
        this(drawable, drawable2, scale, i, false, false, 48, null);
    }

    public CrossfadeDrawable(Drawable drawable, Drawable drawable2, Scale scale, int i, boolean z) {
        this(drawable, drawable2, scale, i, z, false, 32, null);
    }

    public /* synthetic */ CrossfadeDrawable(Drawable drawable, Drawable drawable2, Scale scale, int i, boolean z, boolean z2, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(drawable, drawable2, (i2 & 4) != 0 ? Scale.FIT : scale, (i2 & 8) != 0 ? 200 : i, (i2 & 16) != 0 ? true : z, (i2 & 32) != 0 ? false : z2);
    }

    public final Scale getScale() {
        return this.scale;
    }

    public final int getDurationMillis() {
        return this.durationMillis;
    }

    public final boolean getFadeStart() {
        return this.fadeStart;
    }

    public final boolean getPreferExactIntrinsicSize() {
        return this.preferExactIntrinsicSize;
    }

    public CrossfadeDrawable(Drawable drawable, Drawable drawable2, Scale scale, int i, boolean z, boolean z2) {
        this.scale = scale;
        this.durationMillis = i;
        this.fadeStart = z;
        this.preferExactIntrinsicSize = z2;
        this.callbacks = new ArrayList();
        this.intrinsicWidth = computeIntrinsicDimension(drawable != null ? Integer.valueOf(drawable.getIntrinsicWidth()) : null, drawable2 != null ? Integer.valueOf(drawable2.getIntrinsicWidth()) : null);
        this.intrinsicHeight = computeIntrinsicDimension(drawable != null ? Integer.valueOf(drawable.getIntrinsicHeight()) : null, drawable2 != null ? Integer.valueOf(drawable2.getIntrinsicHeight()) : null);
        this.maxAlpha = 255;
        this.start = drawable != null ? drawable.mutate() : null;
        Drawable mutate = drawable2 != null ? drawable2.mutate() : null;
        this.end = mutate;
        if (i <= 0) {
            throw new IllegalArgumentException("durationMillis must be > 0.".toString());
        }
        Drawable drawable3 = this.start;
        if (drawable3 != null) {
            drawable3.setCallback(this);
        }
        if (mutate != null) {
            mutate.setCallback(this);
        }
    }

    public final Drawable getStart() {
        return this.start;
    }

    public final Drawable getEnd() {
        return this.end;
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        int save;
        Drawable drawable;
        int i = this.state;
        if (i == 0) {
            Drawable drawable2 = this.start;
            if (drawable2 != null) {
                drawable2.setAlpha(this.maxAlpha);
                save = canvas.save();
                try {
                    drawable2.draw(canvas);
                } finally {
                }
            }
        } else if (i == 2) {
            Drawable drawable3 = this.end;
            if (drawable3 != null) {
                drawable3.setAlpha(this.maxAlpha);
                save = canvas.save();
                try {
                    drawable3.draw(canvas);
                } finally {
                }
            }
        } else {
            double uptimeMillis = (SystemClock.uptimeMillis() - this.startTimeMillis) / this.durationMillis;
            double coerceIn = RangesKt.coerceIn(uptimeMillis, (double) FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE, 1.0d);
            int i2 = this.maxAlpha;
            int i3 = (int) (coerceIn * i2);
            if (this.fadeStart) {
                i2 -= i3;
            }
            boolean z = uptimeMillis >= 1.0d;
            if (!z && (drawable = this.start) != null) {
                drawable.setAlpha(i2);
                save = canvas.save();
                try {
                    drawable.draw(canvas);
                } finally {
                }
            }
            Drawable drawable4 = this.end;
            if (drawable4 != null) {
                drawable4.setAlpha(i3);
                save = canvas.save();
                try {
                    drawable4.draw(canvas);
                } finally {
                }
            }
            if (z) {
                markDone();
            } else {
                invalidateSelf();
            }
        }
    }

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        return this.maxAlpha;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        if (i < 0 || i >= 256) {
            throw new IllegalArgumentException(("Invalid alpha: " + i).toString());
        }
        this.maxAlpha = i;
    }

    @Override // android.graphics.drawable.Drawable
    @Deprecated(message = "Deprecated in Java")
    public int getOpacity() {
        Drawable drawable = this.start;
        Drawable drawable2 = this.end;
        int i = this.state;
        if (i == 0) {
            if (drawable != null) {
                return drawable.getOpacity();
            }
            return -2;
        } else if (i == 2) {
            if (drawable2 != null) {
                return drawable2.getOpacity();
            }
            return -2;
        } else if (drawable == null || drawable2 == null) {
            if (drawable != null) {
                return drawable.getOpacity();
            }
            if (drawable2 != null) {
                return drawable2.getOpacity();
            }
            return -2;
        } else {
            return Drawable.resolveOpacity(drawable.getOpacity(), drawable2.getOpacity());
        }
    }

    @Override // android.graphics.drawable.Drawable
    public ColorFilter getColorFilter() {
        ColorFilter colorFilter;
        Drawable drawable;
        int i = this.state;
        if (i == 0) {
            Drawable drawable2 = this.start;
            if (drawable2 != null) {
                return drawable2.getColorFilter();
            }
            return null;
        } else if (i != 1) {
            if (i == 2 && (drawable = this.end) != null) {
                return drawable.getColorFilter();
            }
            return null;
        } else {
            Drawable drawable3 = this.end;
            if (drawable3 == null || (colorFilter = drawable3.getColorFilter()) == null) {
                Drawable drawable4 = this.start;
                if (drawable4 != null) {
                    return drawable4.getColorFilter();
                }
                return null;
            }
            return colorFilter;
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        Drawable drawable = this.start;
        if (drawable != null) {
            drawable.setColorFilter(colorFilter);
        }
        Drawable drawable2 = this.end;
        if (drawable2 != null) {
            drawable2.setColorFilter(colorFilter);
        }
    }

    @Override // android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect rect) {
        Drawable drawable = this.start;
        if (drawable != null) {
            updateBounds$coil_core_release(drawable, rect);
        }
        Drawable drawable2 = this.end;
        if (drawable2 != null) {
            updateBounds$coil_core_release(drawable2, rect);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        Drawable drawable = this.start;
        if (drawable != null ? drawable.isStateful() : false) {
            return true;
        }
        Drawable drawable2 = this.end;
        return drawable2 != null ? drawable2.isStateful() : false;
    }

    @Override // android.graphics.drawable.Drawable
    protected boolean onStateChange(int[] iArr) {
        Drawable drawable = this.start;
        boolean state = drawable != null ? drawable.setState(iArr) : false;
        Drawable drawable2 = this.end;
        return state || (drawable2 != null ? drawable2.setState(iArr) : false);
    }

    @Override // android.graphics.drawable.Drawable
    protected boolean onLevelChange(int i) {
        Drawable drawable = this.start;
        boolean level = drawable != null ? drawable.setLevel(i) : false;
        Drawable drawable2 = this.end;
        return level || (drawable2 != null ? drawable2.setLevel(i) : false);
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return this.intrinsicWidth;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return this.intrinsicHeight;
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void unscheduleDrawable(Drawable drawable, Runnable runnable) {
        unscheduleSelf(runnable);
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void invalidateDrawable(Drawable drawable) {
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void scheduleDrawable(Drawable drawable, Runnable runnable, long j) {
        scheduleSelf(runnable, j);
    }

    @Override // android.graphics.drawable.Drawable
    public void setTint(int i) {
        Drawable drawable = this.start;
        if (drawable != null) {
            drawable.setTint(i);
        }
        Drawable drawable2 = this.end;
        if (drawable2 != null) {
            drawable2.setTint(i);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setTintList(ColorStateList colorStateList) {
        Drawable drawable = this.start;
        if (drawable != null) {
            drawable.setTintList(colorStateList);
        }
        Drawable drawable2 = this.end;
        if (drawable2 != null) {
            drawable2.setTintList(colorStateList);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setTintMode(PorterDuff.Mode mode) {
        Drawable drawable = this.start;
        if (drawable != null) {
            drawable.setTintMode(mode);
        }
        Drawable drawable2 = this.end;
        if (drawable2 != null) {
            drawable2.setTintMode(mode);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setTintBlendMode(BlendMode blendMode) {
        Drawable drawable = this.start;
        if (drawable != null) {
            drawable.setTintBlendMode(blendMode);
        }
        Drawable drawable2 = this.end;
        if (drawable2 != null) {
            drawable2.setTintBlendMode(blendMode);
        }
    }

    @Override // android.graphics.drawable.Animatable
    public boolean isRunning() {
        return this.state == 1;
    }

    @Override // android.graphics.drawable.Animatable
    public void start() {
        Drawable drawable = this.start;
        Animatable animatable = drawable instanceof Animatable ? (Animatable) drawable : null;
        if (animatable != null) {
            animatable.start();
        }
        Drawable drawable2 = this.end;
        Animatable animatable2 = drawable2 instanceof Animatable ? (Animatable) drawable2 : null;
        if (animatable2 != null) {
            animatable2.start();
        }
        if (this.state != 0) {
            return;
        }
        this.state = 1;
        this.startTimeMillis = SystemClock.uptimeMillis();
        List<Animatable2Compat.AnimationCallback> list = this.callbacks;
        int size = list.size();
        for (int i = 0; i < size; i++) {
            list.get(i).onAnimationStart(this);
        }
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Animatable
    public void stop() {
        Drawable drawable = this.start;
        Animatable animatable = drawable instanceof Animatable ? (Animatable) drawable : null;
        if (animatable != null) {
            animatable.stop();
        }
        Drawable drawable2 = this.end;
        Animatable animatable2 = drawable2 instanceof Animatable ? (Animatable) drawable2 : null;
        if (animatable2 != null) {
            animatable2.stop();
        }
        if (this.state != 2) {
            markDone();
        }
    }

    @Override // androidx.vectordrawable.graphics.drawable.Animatable2Compat
    public void registerAnimationCallback(Animatable2Compat.AnimationCallback animationCallback) {
        this.callbacks.add(animationCallback);
    }

    @Override // androidx.vectordrawable.graphics.drawable.Animatable2Compat
    public boolean unregisterAnimationCallback(Animatable2Compat.AnimationCallback animationCallback) {
        return this.callbacks.remove(animationCallback);
    }

    @Override // androidx.vectordrawable.graphics.drawable.Animatable2Compat
    public void clearAnimationCallbacks() {
        this.callbacks.clear();
    }

    public final void updateBounds$coil_core_release(Drawable drawable, Rect rect) {
        int intrinsicWidth = drawable.getIntrinsicWidth();
        int intrinsicHeight = drawable.getIntrinsicHeight();
        if (intrinsicWidth <= 0 || intrinsicHeight <= 0) {
            drawable.setBounds(rect);
            return;
        }
        int width = rect.width();
        int height = rect.height();
        double computeSizeMultiplier = DecodeUtils.computeSizeMultiplier(intrinsicWidth, intrinsicHeight, width, height, this.scale);
        double d = 2;
        int roundToInt = MathKt.roundToInt((width - (intrinsicWidth * computeSizeMultiplier)) / d);
        int roundToInt2 = MathKt.roundToInt((height - (computeSizeMultiplier * intrinsicHeight)) / d);
        drawable.setBounds(rect.left + roundToInt, rect.top + roundToInt2, rect.right - roundToInt, rect.bottom - roundToInt2);
    }

    private final int computeIntrinsicDimension(Integer num, Integer num2) {
        if (this.preferExactIntrinsicSize || ((num == null || num.intValue() != -1) && (num2 == null || num2.intValue() != -1))) {
            return Math.max(num != null ? num.intValue() : -1, num2 != null ? num2.intValue() : -1);
        }
        return -1;
    }

    private final void markDone() {
        this.state = 2;
        this.start = null;
        List<Animatable2Compat.AnimationCallback> list = this.callbacks;
        int size = list.size();
        for (int i = 0; i < size; i++) {
            list.get(i).onAnimationEnd(this);
        }
    }

    /* compiled from: CrossfadeDrawable.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcoil3/transition/CrossfadeDrawable$Companion;", "", "<init>", "()V", "STATE_START", "", "STATE_RUNNING", "STATE_DONE", "DEFAULT_DURATION", "coil-core_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
