package ru.mrlargha.commonui.utils;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.text.SpannableString;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.google.firebase.analytics.FirebaseAnalytics;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import ru.mrlargha.commonui.R;
import ru.mrlargha.commonui.utils.ui.CustomCardView;
/* compiled from: CustomCardFieldLayout.kt */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B!\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u001a\u0002\b\b¢\u0006\u0004\b\u0006\u0010\u0007J\u001c\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0016J$\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\u0006\u0010\u001e\u001a\u00020\u00122\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0016J\u001a\u0010\u001f\u001a\u00020\u00192\u0006\u0010 \u001a\u00020\u00142\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\"R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\r\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0013\u001a\u00020\u0014X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0015\"\u0004\b\u0016\u0010\u0017¨\u0006#"}, d2 = {"Lru/mrlargha/commonui/utils/CustomCardFieldLayout;", "Landroid/widget/LinearLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "Lkotlin/jvm/JvmOverloads;", "customCardView", "Lru/mrlargha/commonui/utils/ui/CustomCardView;", "getCustomCardView", "()Lru/mrlargha/commonui/utils/ui/CustomCardView;", "textView", "Landroid/widget/TextView;", "getTextView", "()Landroid/widget/TextView;", "defaultBorderColor", "", "isInitializing", "", "()Z", "setInitializing", "(Z)V", "addView", "", "child", "Landroid/view/View;", "params", "Landroid/view/ViewGroup$LayoutParams;", FirebaseAnalytics.Param.INDEX, "setError", "showError", "errorMessage", "Landroid/text/SpannableString;", "CommonUI"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class CustomCardFieldLayout extends LinearLayout {
    private final CustomCardView customCardView;
    private int defaultBorderColor;
    private boolean isInitializing;
    private final TextView textView;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public CustomCardFieldLayout(Context context) {
        this(context, null, 2, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CustomCardFieldLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        CustomCardView customCardView = new CustomCardView(context, attributeSet);
        this.customCardView = customCardView;
        TextView textView = new TextView(context);
        this.textView = textView;
        this.isInitializing = true;
        setOrientation(1);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.CustomCardFieldLayout);
        Intrinsics.checkNotNullExpressionValue(obtainStyledAttributes, "obtainStyledAttributes(...)");
        customCardView.setLayoutParams(new LinearLayout.LayoutParams(-1, (int) obtainStyledAttributes.getDimension(R.styleable.CustomCardFieldLayout_customCardViewHeigh, customCardView.getHeight())));
        textView.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        this.defaultBorderColor = customCardView.getBorderMainColor();
        int color = obtainStyledAttributes.getColor(R.styleable.CustomCardFieldLayout_errorTextColor, Color.parseColor("#FF5A5A"));
        float dimension = obtainStyledAttributes.getDimension(R.styleable.CustomCardFieldLayout_errorTextSize, textView.getTextSize());
        String string = obtainStyledAttributes.getString(R.styleable.CustomCardFieldLayout_errorText);
        int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(R.styleable.CustomCardFieldLayout_errorTextMarginTop, 0);
        obtainStyledAttributes.recycle();
        textView.setTextColor(color);
        String str = string;
        textView.setText(str);
        textView.setTextSize(dimension / getResources().getDisplayMetrics().scaledDensity);
        textView.setVisibility((str == null || StringsKt.isBlank(str)) ? 8 : 0);
        ViewGroup.LayoutParams layoutParams = textView.getLayoutParams();
        Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
        ((LinearLayout.LayoutParams) layoutParams).topMargin = dimensionPixelSize;
        addView(customCardView);
        addView(textView);
        this.isInitializing = false;
        setError$default(this, false, null, 2, null);
    }

    public /* synthetic */ CustomCardFieldLayout(Context context, AttributeSet attributeSet, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i & 2) != 0 ? null : attributeSet);
    }

    public final CustomCardView getCustomCardView() {
        return this.customCardView;
    }

    public final TextView getTextView() {
        return this.textView;
    }

    public final boolean isInitializing() {
        return this.isInitializing;
    }

    public final void setInitializing(boolean z) {
        this.isInitializing = z;
    }

    @Override // android.view.ViewGroup, android.view.ViewManager
    public void addView(View view, ViewGroup.LayoutParams layoutParams) {
        if (this.isInitializing || view == null) {
            super.addView(view, layoutParams);
        } else {
            this.customCardView.addView(view, layoutParams);
        }
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i, ViewGroup.LayoutParams layoutParams) {
        if (this.isInitializing || view == null) {
            super.addView(view, i, layoutParams);
        } else {
            this.customCardView.addView(view, i, layoutParams);
        }
    }

    public static /* synthetic */ void setError$default(CustomCardFieldLayout customCardFieldLayout, boolean z, SpannableString spannableString, int i, Object obj) {
        if ((i & 2) != 0) {
            spannableString = null;
        }
        customCardFieldLayout.setError(z, spannableString);
    }

    public final void setError(boolean z, SpannableString spannableString) {
        TextView textView = this.textView;
        if (z) {
            textView.setVisibility(0);
            this.textView.setText(spannableString);
            return;
        }
        textView.setVisibility(8);
    }
}
