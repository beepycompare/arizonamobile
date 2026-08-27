package com.google.android.material.overflow;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.appcompat.widget.PopupMenu;
import androidx.appcompat.widget.TintTypedArray;
import androidx.appcompat.widget.TooltipCompat;
import com.google.android.material.R;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.button.MaterialButtonGroup;
import com.google.android.material.internal.ThemeEnforcement;
import com.google.android.material.resources.MaterialAttributes;
import com.google.android.material.theme.overlay.MaterialThemeOverlay;
import java.util.LinkedHashSet;
import java.util.Set;
/* loaded from: classes4.dex */
public class OverflowLinearLayout extends LinearLayout {
    private static final int DEF_STYLE_RES = R.style.Widget_Material3_OverflowLinearLayout;
    private final MaterialButton overflowButton;
    private boolean overflowButtonAdded;
    private final Set<View> overflowViews;

    public OverflowLinearLayout(Context context) {
        this(context, null);
    }

    public OverflowLinearLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.overflowLinearLayoutStyle);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public OverflowLinearLayout(Context context, AttributeSet attributeSet, int i) {
        super(MaterialThemeOverlay.wrap(context, attributeSet, i, r4), attributeSet, i);
        int i2 = DEF_STYLE_RES;
        this.overflowButtonAdded = false;
        this.overflowViews = new LinkedHashSet();
        Context context2 = getContext();
        TintTypedArray obtainTintedStyledAttributes = ThemeEnforcement.obtainTintedStyledAttributes(context2, attributeSet, R.styleable.OverflowLinearLayout, i, i2, new int[0]);
        Drawable drawable = obtainTintedStyledAttributes.getDrawable(R.styleable.OverflowLinearLayout_overflowButtonIcon);
        obtainTintedStyledAttributes.recycle();
        MaterialButton materialButton = (MaterialButton) LayoutInflater.from(context2).inflate(R.layout.m3_overflow_linear_layout_overflow_button, (ViewGroup) this, false);
        this.overflowButton = materialButton;
        TooltipCompat.setTooltipText(materialButton, getResources().getString(R.string.m3_overflow_linear_layout_button_tooltip_text));
        setOverflowButtonIcon(drawable);
        if (materialButton.getContentDescription() == null) {
            materialButton.setContentDescription(context2.getString(R.string.m3_overflow_linear_layout_button_content_description));
        }
        final PopupMenu popupMenu = new PopupMenu(getContext(), materialButton, 17, 0, MaterialAttributes.resolveOrThrow(this, R.attr.overflowLinearLayoutPopupMenuStyle));
        final int dimensionPixelOffset = context2.getResources().getDimensionPixelOffset(R.dimen.m3_overflow_item_icon_horizontal_padding);
        materialButton.setOnClickListener(new View.OnClickListener() { // from class: com.google.android.material.overflow.OverflowLinearLayout$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                OverflowLinearLayout.this.m9602xc4d03947(popupMenu, dimensionPixelOffset, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$new$0$com-google-android-material-overflow-OverflowLinearLayout  reason: not valid java name */
    public /* synthetic */ void m9602xc4d03947(PopupMenu popupMenu, int i, View view) {
        handleOverflowButtonClick(popupMenu, i);
    }

    public boolean isOverflowed() {
        return !this.overflowViews.isEmpty();
    }

    public Set<View> getOverflowedViews() {
        return this.overflowViews;
    }

    public void setOverflowButtonIcon(Drawable drawable) {
        this.overflowButton.m9538x11712a47(drawable);
    }

    public void setOverflowButtonIconResource(int i) {
        this.overflowButton.setIconResource(i);
    }

    public Drawable getOverflowButtonIcon() {
        return this.overflowButton.getIcon();
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        int size;
        Set<View> set;
        boolean z = getOrientation() == 0;
        int childCount = this.overflowButtonAdded ? getChildCount() - 1 : getChildCount();
        if (z) {
            size = View.MeasureSpec.getSize(i);
        } else {
            size = View.MeasureSpec.getSize(i2);
        }
        int overflowButtonSize = getOverflowButtonSize(z, this.overflowButton, i, i2);
        this.overflowButton.setVisibility(8);
        this.overflowViews.clear();
        int i3 = 0;
        int i4 = 0;
        while (true) {
            if (i3 < childCount) {
                View childAt = getChildAt(i3);
                childAt.setVisibility(0);
                i4 += getChildSize(z, childAt, i, i2);
                if (i4 + overflowButtonSize > size) {
                    this.overflowViews.add(childAt);
                }
                if (i4 > size) {
                    int i5 = i3 + 1;
                    while (true) {
                        set = this.overflowViews;
                        if (i5 >= childCount) {
                            break;
                        }
                        set.add(getChildAt(i5));
                        i5++;
                    }
                    for (View view : set) {
                        view.setVisibility(8);
                    }
                    if (!this.overflowButtonAdded) {
                        addView(this.overflowButton);
                        this.overflowButtonAdded = true;
                    }
                    this.overflowButton.setVisibility(0);
                } else {
                    i3++;
                }
            } else {
                this.overflowButton.setVisibility(8);
                this.overflowViews.clear();
                break;
            }
        }
        super.onMeasure(i, i2);
    }

    private int getChildSize(boolean z, View view, int i, int i2) {
        int measuredHeight;
        int i3;
        int minimumHeight;
        int i4;
        measureChild(view, i, i2);
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        if (z) {
            measuredHeight = view.getMeasuredWidth() + layoutParams.leftMargin;
            i3 = layoutParams.rightMargin;
        } else {
            measuredHeight = view.getMeasuredHeight() + layoutParams.topMargin;
            i3 = layoutParams.bottomMargin;
        }
        int i5 = measuredHeight + i3;
        if (i5 == 0) {
            if (z) {
                minimumHeight = view.getMinimumWidth() + layoutParams.leftMargin;
                i4 = layoutParams.rightMargin;
            } else {
                minimumHeight = view.getMinimumHeight() + layoutParams.topMargin;
                i4 = layoutParams.bottomMargin;
            }
            return minimumHeight + i4;
        }
        return i5;
    }

    private int getOverflowButtonSize(boolean z, View view, int i, int i2) {
        int measuredHeight;
        int i3;
        measureChild(view, i, i2);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) view.getLayoutParams();
        if (z) {
            measuredHeight = view.getMeasuredWidth() + layoutParams.leftMargin;
            i3 = layoutParams.rightMargin;
        } else {
            measuredHeight = view.getMeasuredHeight() + layoutParams.topMargin;
            i3 = layoutParams.bottomMargin;
        }
        return measuredHeight + i3;
    }

    private void handleOverflowButtonClick(PopupMenu popupMenu, int i) {
        int i2;
        popupMenu.getMenu().clear();
        popupMenu.setForceShowIcon(true);
        for (final View view : this.overflowViews) {
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            final MenuItem add = popupMenu.getMenu().add(MaterialButtonGroup.OverflowUtils.getMenuItemText(view, layoutParams.overflowText));
            Drawable drawable = layoutParams.overflowIcon;
            if (drawable != null) {
                i2 = i;
                add.setIcon(new InsetDrawable(drawable, i2, 0, i, 0));
            } else {
                i2 = i;
            }
            if (view instanceof MaterialButton) {
                MaterialButton materialButton = (MaterialButton) view;
                add.setCheckable(materialButton.isCheckable());
                add.setChecked(materialButton.isChecked());
            }
            add.setEnabled(view.isEnabled());
            add.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() { // from class: com.google.android.material.overflow.OverflowLinearLayout$$ExternalSyntheticLambda0
                @Override // android.view.MenuItem.OnMenuItemClickListener
                public final boolean onMenuItemClick(MenuItem menuItem) {
                    return OverflowLinearLayout.lambda$handleOverflowButtonClick$1(view, add, menuItem);
                }
            });
            i = i2;
        }
        popupMenu.show();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ boolean lambda$handleOverflowButtonClick$1(View view, MenuItem menuItem, MenuItem menuItem2) {
        view.performClick();
        if (menuItem.isCheckable()) {
            menuItem.setChecked(!menuItem.isChecked());
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.widget.LinearLayout, android.view.ViewGroup
    public LayoutParams generateDefaultLayoutParams() {
        if (getOrientation() == 0) {
            return new LayoutParams(-2, -2);
        }
        return new LayoutParams(-1, -2);
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup
    public LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.widget.LinearLayout, android.view.ViewGroup
    public LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        if (layoutParams instanceof LayoutParams) {
            return new LayoutParams(layoutParams);
        }
        if (layoutParams instanceof LinearLayout.LayoutParams) {
            return new LayoutParams((LinearLayout.LayoutParams) layoutParams);
        }
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            return new LayoutParams((ViewGroup.MarginLayoutParams) layoutParams);
        }
        return new LayoutParams(layoutParams);
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup
    protected boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof LayoutParams;
    }

    /* loaded from: classes4.dex */
    public static class LayoutParams extends LinearLayout.LayoutParams {
        public Drawable overflowIcon;
        public CharSequence overflowText;

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.overflowIcon = null;
            this.overflowText = null;
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.OverflowLinearLayout_Layout);
            this.overflowIcon = obtainStyledAttributes.getDrawable(R.styleable.OverflowLinearLayout_Layout_layout_overflowIcon);
            this.overflowText = obtainStyledAttributes.getText(R.styleable.OverflowLinearLayout_Layout_layout_overflowText);
            obtainStyledAttributes.recycle();
        }

        public LayoutParams(int i, int i2) {
            super(i, i2);
            this.overflowIcon = null;
            this.overflowText = null;
        }

        public LayoutParams(int i, int i2, float f) {
            super(i, i2, f);
            this.overflowIcon = null;
            this.overflowText = null;
        }

        public LayoutParams(int i, int i2, float f, Drawable drawable, CharSequence charSequence) {
            super(i, i2, f);
            this.overflowIcon = drawable;
            this.overflowText = charSequence;
        }

        public LayoutParams(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.overflowIcon = null;
            this.overflowText = null;
        }

        public LayoutParams(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
            this.overflowIcon = null;
            this.overflowText = null;
        }

        public LayoutParams(LinearLayout.LayoutParams layoutParams) {
            super(layoutParams);
            this.overflowIcon = null;
            this.overflowText = null;
        }

        public LayoutParams(LayoutParams layoutParams) {
            super((LinearLayout.LayoutParams) layoutParams);
            this.overflowIcon = null;
            this.overflowText = null;
            this.overflowText = layoutParams.overflowText;
            this.overflowIcon = layoutParams.overflowIcon;
        }
    }
}
