package ru.mrlargha.commonui.utils.ui.GradientCard;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import androidx.cardview.widget.CardView;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import ru.mrlargha.commonui.R;
/* compiled from: GradientCard.kt */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0014J\b\u0010\u0011\u001a\u00020\u000eH\u0002J\u0010\u0010\u0012\u001a\u00020\u00132\u0006\u0010\f\u001a\u00020\u0007H\u0002J \u0010\u0014\u001a\u00020\u000e2\u0006\u0010\n\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\u00072\b\b\u0002\u0010\f\u001a\u00020\u0007R\u000e\u0010\n\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lru/mrlargha/commonui/utils/ui/GradientCard/GradientCardView;", "Landroidx/cardview/widget/CardView;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "startColor", "endColor", "angle", "onDraw", "", "canvas", "Landroid/graphics/Canvas;", "applyGradient", "angleToOrientation", "Landroid/graphics/drawable/GradientDrawable$Orientation;", "setGradient", "CommonUI_release_web"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class GradientCardView extends CardView {
    private int angle;
    private int endColor;
    private int startColor;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public GradientCardView(Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public GradientCardView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public /* synthetic */ GradientCardView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GradientCardView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        this.startColor = Color.parseColor("#FCD80F");
        this.endColor = Color.parseColor("#FF9112");
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, R.styleable.GradientCardView, 0, 0);
        try {
            this.startColor = obtainStyledAttributes.getColor(R.styleable.GradientCardView_gradientStartColor, this.startColor);
            this.endColor = obtainStyledAttributes.getColor(R.styleable.GradientCardView_gradientEndColor, this.endColor);
            this.angle = obtainStyledAttributes.getInt(R.styleable.GradientCardView_gradientAngle, 0);
            applyGradient();
        } finally {
            obtainStyledAttributes.recycle();
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        super.onDraw(canvas);
        applyGradient();
    }

    private final void applyGradient() {
        GradientDrawable gradientDrawable = new GradientDrawable(angleToOrientation(this.angle), new int[]{this.startColor, this.endColor});
        gradientDrawable.setCornerRadius(getRadius());
        setBackground(gradientDrawable);
    }

    private final GradientDrawable.Orientation angleToOrientation(int i) {
        if (i != 0) {
            if (i != 45) {
                if (i != 90) {
                    if (i != 135) {
                        if (i != 180) {
                            if (i != 225) {
                                if (i != 270) {
                                    if (i == 315) {
                                        return GradientDrawable.Orientation.TL_BR;
                                    }
                                    return GradientDrawable.Orientation.LEFT_RIGHT;
                                }
                                return GradientDrawable.Orientation.TOP_BOTTOM;
                            }
                            return GradientDrawable.Orientation.TR_BL;
                        }
                        return GradientDrawable.Orientation.RIGHT_LEFT;
                    }
                    return GradientDrawable.Orientation.BR_TL;
                }
                return GradientDrawable.Orientation.BOTTOM_TOP;
            }
            return GradientDrawable.Orientation.BL_TR;
        }
        return GradientDrawable.Orientation.LEFT_RIGHT;
    }

    public static /* synthetic */ void setGradient$default(GradientCardView gradientCardView, int i, int i2, int i3, int i4, Object obj) {
        if ((i4 & 4) != 0) {
            i3 = 0;
        }
        gradientCardView.setGradient(i, i2, i3);
    }

    public final void setGradient(int i, int i2, int i3) {
        this.startColor = i;
        this.endColor = i2;
        this.angle = i3;
        applyGradient();
    }
}
