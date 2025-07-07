package com.arizona.common.ui;

import android.content.Context;
import android.graphics.Matrix;
import android.util.AttributeSet;
import android.widget.ImageView;
import androidx.appcompat.widget.AppCompatImageView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: TopScaleImageView.kt */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\u001b\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\u0004\u0010\bB#\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u0004\u0010\u000bJ\u000e\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\rJ\b\u0010\u0011\u001a\u00020\u000fH\u0002J(\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\n2\u0006\u0010\u0015\u001a\u00020\n2\u0006\u0010\u0016\u001a\u00020\n2\u0006\u0010\u0017\u001a\u00020\nH\u0014R\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lcom/arizona/common/ui/TopScaleImageView;", "Landroidx/appcompat/widget/AppCompatImageView;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyle", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "usedScaleFactor", "", "setScale", "", "scale", "setup", "setFrame", "", "frameLeft", "frameTop", "frameRight", "frameBottom", "CommonLibs_release_web"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class TopScaleImageView extends AppCompatImageView {
    private float usedScaleFactor;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TopScaleImageView(Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        this.usedScaleFactor = 0.7f;
        setup();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TopScaleImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        this.usedScaleFactor = 0.7f;
        setup();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TopScaleImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        this.usedScaleFactor = 0.7f;
        setup();
    }

    public final void setScale(float f) {
        this.usedScaleFactor = f;
    }

    private final void setup() {
        setScaleType(ImageView.ScaleType.MATRIX);
        this.usedScaleFactor *= getContext().getResources().getDisplayMetrics().density;
    }

    @Override // android.widget.ImageView
    protected boolean setFrame(int i, int i2, int i3, int i4) {
        if (getDrawable() == null) {
            return super.setFrame(i, i2, i3, i4);
        }
        float f = i3 - i;
        float f2 = i4 - i2;
        float intrinsicWidth = getDrawable().getIntrinsicWidth();
        float intrinsicHeight = getDrawable().getIntrinsicHeight();
        if (f > intrinsicWidth || f2 > intrinsicHeight) {
            this.usedScaleFactor = (float) Math.max(f / intrinsicWidth, f2 / intrinsicHeight);
        }
        float f3 = intrinsicWidth * this.usedScaleFactor;
        Matrix imageMatrix = getImageMatrix();
        float f4 = this.usedScaleFactor;
        imageMatrix.setScale(f4, f4, 0.0f, 0.0f);
        imageMatrix.postTranslate((f - f3) / 2, 0.0f);
        setImageMatrix(imageMatrix);
        return super.setFrame(i, i2, i3, i4);
    }
}
