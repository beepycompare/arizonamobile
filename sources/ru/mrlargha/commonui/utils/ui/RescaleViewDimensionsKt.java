package ru.mrlargha.commonui.utils.ui;

import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.DynamicDrawableSpan;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.ranges.RangesKt;
/* compiled from: rescaleViewDimensions.kt */
@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\u001a\u0018\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0000¨\u0006\u0006"}, d2 = {"rescaleViewDimensions", "", "root", "Landroid/view/View;", "scale", "", "CommonUI"}, k = 2, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class RescaleViewDimensionsKt {
    public static final void rescaleViewDimensions(View root, float f) {
        Intrinsics.checkNotNullParameter(root, "root");
        if (Math.abs(f) > Float.MAX_VALUE || f <= 0.0f) {
            throw new IllegalArgumentException("Failed requirement.".toString());
        }
        rescaleViewDimensions$resizeView(f, new LinkedHashSet(), root);
    }

    private static final int rescaleViewDimensions$pixels(float f, int i) {
        return MathKt.roundToInt(i * f);
    }

    private static final int rescaleViewDimensions$layoutSize(float f, int i) {
        return i > 0 ? RangesKt.coerceAtLeast(rescaleViewDimensions$pixels(f, i), 1) : i;
    }

    private static final int rescaleViewDimensions$optionalPixels(float f, int i) {
        return i >= 0 ? rescaleViewDimensions$pixels(f, i) : i;
    }

    private static final void rescaleViewDimensions$resizeDrawable(Set<Drawable> set, float f, Drawable drawable) {
        if (drawable == null || !set.add(drawable)) {
            return;
        }
        Rect bounds = drawable.getBounds();
        Intrinsics.checkNotNullExpressionValue(bounds, "getBounds(...)");
        drawable.setBounds(rescaleViewDimensions$pixels(f, bounds.left), rescaleViewDimensions$pixels(f, bounds.top), rescaleViewDimensions$pixels(f, bounds.right), rescaleViewDimensions$pixels(f, bounds.bottom));
    }

    private static final void rescaleViewDimensions$resizeView(float f, Set<Drawable> set, View view) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams != null) {
            layoutParams.width = rescaleViewDimensions$layoutSize(f, layoutParams.width);
            layoutParams.height = rescaleViewDimensions$layoutSize(f, layoutParams.height);
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                boolean isMarginRelative = marginLayoutParams.isMarginRelative();
                int marginStart = marginLayoutParams.getMarginStart();
                int marginEnd = marginLayoutParams.getMarginEnd();
                marginLayoutParams.setMargins(rescaleViewDimensions$pixels(f, marginLayoutParams.leftMargin), rescaleViewDimensions$pixels(f, marginLayoutParams.topMargin), rescaleViewDimensions$pixels(f, marginLayoutParams.rightMargin), rescaleViewDimensions$pixels(f, marginLayoutParams.bottomMargin));
                if (isMarginRelative) {
                    marginLayoutParams.setMarginStart(rescaleViewDimensions$pixels(f, marginStart));
                    marginLayoutParams.setMarginEnd(rescaleViewDimensions$pixels(f, marginEnd));
                }
            }
            if (layoutParams instanceof ConstraintLayout.LayoutParams) {
                ConstraintLayout.LayoutParams layoutParams2 = (ConstraintLayout.LayoutParams) layoutParams;
                layoutParams2.guideBegin = rescaleViewDimensions$optionalPixels(f, layoutParams2.guideBegin);
                layoutParams2.guideEnd = rescaleViewDimensions$optionalPixels(f, layoutParams2.guideEnd);
                layoutParams2.circleRadius = rescaleViewDimensions$pixels(f, layoutParams2.circleRadius);
                layoutParams2.goneLeftMargin = rescaleViewDimensions$optionalPixels(f, layoutParams2.goneLeftMargin);
                layoutParams2.goneTopMargin = rescaleViewDimensions$optionalPixels(f, layoutParams2.goneTopMargin);
                layoutParams2.goneRightMargin = rescaleViewDimensions$optionalPixels(f, layoutParams2.goneRightMargin);
                layoutParams2.goneBottomMargin = rescaleViewDimensions$optionalPixels(f, layoutParams2.goneBottomMargin);
                layoutParams2.goneStartMargin = rescaleViewDimensions$optionalPixels(f, layoutParams2.goneStartMargin);
                layoutParams2.goneEndMargin = rescaleViewDimensions$optionalPixels(f, layoutParams2.goneEndMargin);
                layoutParams2.matchConstraintMinWidth = rescaleViewDimensions$optionalPixels(f, layoutParams2.matchConstraintMinWidth);
                layoutParams2.matchConstraintMinHeight = rescaleViewDimensions$optionalPixels(f, layoutParams2.matchConstraintMinHeight);
                layoutParams2.matchConstraintMaxWidth = rescaleViewDimensions$optionalPixels(f, layoutParams2.matchConstraintMaxWidth);
                layoutParams2.matchConstraintMaxHeight = rescaleViewDimensions$optionalPixels(f, layoutParams2.matchConstraintMaxHeight);
            }
            view.setLayoutParams(layoutParams);
        }
        if (view.isPaddingRelative()) {
            view.setPaddingRelative(rescaleViewDimensions$pixels(f, view.getPaddingStart()), rescaleViewDimensions$pixels(f, view.getPaddingTop()), rescaleViewDimensions$pixels(f, view.getPaddingEnd()), rescaleViewDimensions$pixels(f, view.getPaddingBottom()));
        } else {
            view.setPadding(rescaleViewDimensions$pixels(f, view.getPaddingLeft()), rescaleViewDimensions$pixels(f, view.getPaddingTop()), rescaleViewDimensions$pixels(f, view.getPaddingRight()), rescaleViewDimensions$pixels(f, view.getPaddingBottom()));
        }
        view.setMinimumWidth(rescaleViewDimensions$layoutSize(f, view.getMinimumWidth()));
        view.setMinimumHeight(rescaleViewDimensions$layoutSize(f, view.getMinimumHeight()));
        if (view instanceof TextView) {
            TextView textView = (TextView) view;
            textView.setTextSize(0, textView.getTextSize() * f);
            textView.setLineSpacing(textView.getLineSpacingExtra() * f, textView.getLineSpacingMultiplier());
            textView.setCompoundDrawablePadding(rescaleViewDimensions$pixels(f, textView.getCompoundDrawablePadding()));
            Drawable[] compoundDrawablesRelative = textView.getCompoundDrawablesRelative();
            Intrinsics.checkNotNullExpressionValue(compoundDrawablesRelative, "getCompoundDrawablesRelative(...)");
            for (Drawable drawable : compoundDrawablesRelative) {
                rescaleViewDimensions$resizeDrawable(set, f, drawable);
            }
            textView.setCompoundDrawablesRelative(compoundDrawablesRelative[0], compoundDrawablesRelative[1], compoundDrawablesRelative[2], compoundDrawablesRelative[3]);
            CharSequence text = textView.getText();
            Spanned spanned = text instanceof Spanned ? (Spanned) text : null;
            if (spanned != null) {
                SpannableStringBuilder spannableStringBuilder = spanned instanceof Spannable ? (Spannable) spanned : null;
                if (spannableStringBuilder == null) {
                    spannableStringBuilder = new SpannableStringBuilder(spanned);
                }
                Object[] spans = spanned.getSpans(0, spanned.length(), AbsoluteSizeSpan.class);
                Intrinsics.checkNotNullExpressionValue(spans, "getSpans(...)");
                for (Object obj : spans) {
                    AbsoluteSizeSpan absoluteSizeSpan = (AbsoluteSizeSpan) obj;
                    if (!absoluteSizeSpan.getDip()) {
                        int spanStart = spanned.getSpanStart(absoluteSizeSpan);
                        int spanEnd = spanned.getSpanEnd(absoluteSizeSpan);
                        int spanFlags = spanned.getSpanFlags(absoluteSizeSpan);
                        spannableStringBuilder.removeSpan(absoluteSizeSpan);
                        spannableStringBuilder.setSpan(new AbsoluteSizeSpan(rescaleViewDimensions$layoutSize(f, absoluteSizeSpan.getSize())), spanStart, spanEnd, spanFlags);
                    }
                }
                Object[] spans2 = spanned.getSpans(0, spanned.length(), DynamicDrawableSpan.class);
                Intrinsics.checkNotNullExpressionValue(spans2, "getSpans(...)");
                for (Object obj2 : spans2) {
                    rescaleViewDimensions$resizeDrawable(set, f, ((DynamicDrawableSpan) obj2).getDrawable());
                }
                if (spannableStringBuilder != spanned) {
                    textView.setText(spannableStringBuilder);
                }
            }
        }
        if (view instanceof CustomCardView) {
            ((CustomCardView) view).rescaleDimensions$CommonUI(f);
        }
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            int childCount = viewGroup.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = viewGroup.getChildAt(i);
                Intrinsics.checkNotNullExpressionValue(childAt, "getChildAt(...)");
                rescaleViewDimensions$resizeView(f, set, childAt);
            }
        }
        view.requestLayout();
        view.invalidate();
    }
}
