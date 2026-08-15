package com.google.android.material.button;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.Layout;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.inspector.InspectionCompanion;
import android.view.inspector.PropertyMapper;
import android.view.inspector.PropertyReader;
import android.widget.Button;
import android.widget.Checkable;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.appcompat.widget.AppCompatButton;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.view.GravityCompat;
import androidx.customview.view.AbsSavedState;
import androidx.dynamicanimation.animation.FloatPropertyCompat;
import androidx.dynamicanimation.animation.SpringAnimation;
import androidx.dynamicanimation.animation.SpringForce;
import com.google.android.material.R;
import com.google.android.material.internal.ThemeEnforcement;
import com.google.android.material.internal.ViewUtils;
import com.google.android.material.motion.MotionUtils;
import com.google.android.material.resources.MaterialResources;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.MaterialShapeUtils;
import com.google.android.material.shape.ShapeAppearance;
import com.google.android.material.shape.ShapeAppearanceModel;
import com.google.android.material.shape.Shapeable;
import com.google.android.material.shape.StateListShapeAppearanceModel;
import com.google.android.material.shape.StateListSizeChange;
import com.google.android.material.theme.overlay.MaterialThemeOverlay;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Iterator;
import java.util.LinkedHashSet;
/* loaded from: classes4.dex */
public class MaterialButton extends AppCompatButton implements Checkable, Shapeable {
    public static final int ICON_GRAVITY_END = 3;
    public static final int ICON_GRAVITY_START = 1;
    public static final int ICON_GRAVITY_TEXT_END = 4;
    public static final int ICON_GRAVITY_TEXT_START = 2;
    public static final int ICON_GRAVITY_TEXT_TOP = 32;
    public static final int ICON_GRAVITY_TOP = 16;
    private static final String LOG_TAG = "MaterialButton";
    private static final float OPTICAL_CENTER_RATIO = 0.11f;
    private static final int UNSET = Integer.MIN_VALUE;
    private String accessibilityClassName;
    int allowedWidthDecrease;
    private boolean broadcasting;
    private boolean checked;
    private float displayedWidthDecrease;
    private float displayedWidthIncrease;
    private Drawable icon;
    private int iconGravity;
    private int iconLeft;
    private int iconPadding;
    private int iconSize;
    private ColorStateList iconTint;
    private PorterDuff.Mode iconTintMode;
    private int iconTop;
    private boolean isInHorizontalButtonGroup;
    private final MaterialButtonHelper materialButtonHelper;
    private final LinkedHashSet<OnCheckedChangeListener> onCheckedChangeListeners;
    private OnPressedChangeListener onPressedChangeListenerInternal;
    private boolean opticalCenterEnabled;
    private int opticalCenterShift;
    private int orientation;
    private LinearLayout.LayoutParams originalLayoutParams;
    private int originalPaddingEnd;
    private int originalPaddingStart;
    private float originalWidth;
    private Drawable secondaryIcon;
    private int secondaryIconGravity;
    private int secondaryIconLeft;
    private ColorStateList secondaryIconTint;
    private PorterDuff.Mode secondaryIconTintMode;
    private int secondaryIconTop;
    StateListSizeChange sizeChange;
    private boolean stopNullSecondaryIconUpdate;
    private WidthChangeDirection widthChangeDirection;
    int widthChangeMax;
    private SpringAnimation widthIncreaseSpringAnimation;
    private static final int[] CHECKABLE_STATE_SET = {16842911};
    private static final int[] CHECKED_STATE_SET = {16842912};
    private static final int DEF_STYLE_RES = R.style.Widget_MaterialComponents_Button;
    private static final int MATERIAL_SIZE_OVERLAY_ATTR = R.attr.materialSizeOverlay;
    private static final FloatPropertyCompat<MaterialButton> WIDTH_INCREASE = new FloatPropertyCompat<MaterialButton>("widthIncrease") { // from class: com.google.android.material.button.MaterialButton.1
        @Override // androidx.dynamicanimation.animation.FloatPropertyCompat
        public float getValue(MaterialButton materialButton) {
            return materialButton.getDisplayedWidthIncrease();
        }

        @Override // androidx.dynamicanimation.animation.FloatPropertyCompat
        public void setValue(MaterialButton materialButton, float f) {
            materialButton.setDisplayedWidthIncrease(f);
        }
    };

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes4.dex */
    public @interface IconGravity {
    }

    /* loaded from: classes4.dex */
    public interface OnCheckedChangeListener {
        void onCheckedChanged(MaterialButton materialButton, boolean z);
    }

    /* loaded from: classes4.dex */
    interface OnPressedChangeListener {
        void onPressedChanged(MaterialButton materialButton, boolean z);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public enum WidthChangeDirection {
        NONE,
        START,
        END,
        BOTH
    }

    /* loaded from: classes.dex */
    public final class InspectionCompanion implements android.view.inspector.InspectionCompanion<MaterialButton> {
        private int mIconPaddingId;
        private boolean mPropertiesMapped = false;

        @Override // android.view.inspector.InspectionCompanion
        public void mapProperties(PropertyMapper propertyMapper) {
            this.mIconPaddingId = propertyMapper.mapInt("iconPadding", R.attr.iconPadding);
            this.mPropertiesMapped = true;
        }

        @Override // android.view.inspector.InspectionCompanion
        public void readProperties(MaterialButton materialButton, PropertyReader propertyReader) {
            if (!this.mPropertiesMapped) {
                throw new InspectionCompanion.UninitializedPropertyMapException();
            }
            propertyReader.readInt(this.mIconPaddingId, materialButton.getIconPadding());
        }
    }

    public MaterialButton(Context context) {
        this(context, null);
    }

    public MaterialButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.materialButtonStyle);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public MaterialButton(Context context, AttributeSet attributeSet, int i) {
        super(MaterialThemeOverlay.wrap(context, attributeSet, i, r4, new int[]{MATERIAL_SIZE_OVERLAY_ATTR}), attributeSet, i);
        ColorStateList colorStateList;
        int i2 = DEF_STYLE_RES;
        this.onCheckedChangeListeners = new LinkedHashSet<>();
        this.checked = false;
        this.broadcasting = false;
        this.orientation = Integer.MIN_VALUE;
        this.originalWidth = -2.14748365E9f;
        this.originalPaddingStart = Integer.MIN_VALUE;
        this.originalPaddingEnd = Integer.MIN_VALUE;
        this.allowedWidthDecrease = Integer.MIN_VALUE;
        this.widthChangeDirection = WidthChangeDirection.BOTH;
        Context context2 = getContext();
        TypedArray obtainStyledAttributes = ThemeEnforcement.obtainStyledAttributes(context2, attributeSet, R.styleable.MaterialButton, i, i2, new int[0]);
        this.iconPadding = obtainStyledAttributes.getDimensionPixelSize(R.styleable.MaterialButton_iconPadding, 0);
        this.iconTintMode = ViewUtils.parseTintMode(obtainStyledAttributes.getInt(R.styleable.MaterialButton_iconTintMode, -1), PorterDuff.Mode.SRC_IN);
        this.iconTint = MaterialResources.getColorStateList(getContext(), obtainStyledAttributes, R.styleable.MaterialButton_iconTint);
        this.icon = MaterialResources.getDrawable(getContext(), obtainStyledAttributes, R.styleable.MaterialButton_icon);
        this.iconGravity = obtainStyledAttributes.getInteger(R.styleable.MaterialButton_iconGravity, 1);
        this.iconSize = obtainStyledAttributes.getDimensionPixelSize(R.styleable.MaterialButton_iconSize, 0);
        this.secondaryIconTintMode = ViewUtils.parseTintMode(obtainStyledAttributes.getInt(R.styleable.MaterialButton_secondaryIconTintMode, -1), PorterDuff.Mode.SRC_IN);
        if (obtainStyledAttributes.hasValue(R.styleable.MaterialButton_secondaryIconTint)) {
            colorStateList = MaterialResources.getColorStateList(getContext(), obtainStyledAttributes, R.styleable.MaterialButton_secondaryIconTint);
        } else {
            colorStateList = this.iconTint;
        }
        this.secondaryIconTint = colorStateList;
        this.secondaryIconGravity = obtainStyledAttributes.getInteger(R.styleable.MaterialButton_secondaryIconGravity, 3);
        Drawable drawable = MaterialResources.getDrawable(getContext(), obtainStyledAttributes, R.styleable.MaterialButton_secondaryIcon);
        this.secondaryIcon = drawable;
        this.stopNullSecondaryIconUpdate = drawable == null;
        ShapeAppearance create = StateListShapeAppearanceModel.create(context2, obtainStyledAttributes, R.styleable.MaterialButton_shapeAppearance);
        create = create == null ? ShapeAppearanceModel.builder(context2, attributeSet, i, i2).build() : create;
        boolean z = obtainStyledAttributes.getBoolean(R.styleable.MaterialButton_opticalCenterEnabled, false);
        MaterialButtonHelper materialButtonHelper = new MaterialButtonHelper(this, create);
        this.materialButtonHelper = materialButtonHelper;
        materialButtonHelper.loadFromAttributes(obtainStyledAttributes);
        setCheckedInternal(obtainStyledAttributes.getBoolean(R.styleable.MaterialButton_android_checked, false));
        if (create instanceof StateListShapeAppearanceModel) {
            materialButtonHelper.setCornerSpringForce(createSpringForce());
        }
        setOpticalCenterEnabled(z);
        obtainStyledAttributes.recycle();
        setCompoundDrawablePadding(this.iconPadding);
        updateIcon(this.icon != null);
        updateSecondaryIcon(this.secondaryIcon != null);
    }

    private void initializeSizeAnimation() {
        SpringAnimation springAnimation = new SpringAnimation(this, WIDTH_INCREASE);
        this.widthIncreaseSpringAnimation = springAnimation;
        springAnimation.setSpring(createSpringForce());
    }

    private SpringForce createSpringForce() {
        return MotionUtils.resolveThemeSpringForce(getContext(), R.attr.motionSpringFastSpatial, R.style.Motion_Material3_Spring_Standard_Fast_Spatial);
    }

    private boolean maybeRunAfterWidthAnimation(final Runnable runnable) {
        SpringAnimation springAnimation = this.widthIncreaseSpringAnimation;
        if (springAnimation == null || !springAnimation.isRunning()) {
            return false;
        }
        post(new Runnable() { // from class: com.google.android.material.button.MaterialButton$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                MaterialButton.this.m9530x69e9bdf6(runnable);
            }
        });
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$maybeRunAfterWidthAnimation$0$com-google-android-material-button-MaterialButton  reason: not valid java name */
    public /* synthetic */ void m9530x69e9bdf6(Runnable runnable) {
        runnable.run();
        recoverOriginalLayoutParams();
        requestLayout();
    }

    String getA11yClassName() {
        if (TextUtils.isEmpty(this.accessibilityClassName)) {
            return (isCheckable() ? CompoundButton.class : Button.class).getName();
        }
        return this.accessibilityClassName;
    }

    public void setA11yClassName(String str) {
        this.accessibilityClassName = str;
    }

    @Override // androidx.appcompat.widget.AppCompatButton, android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName(getA11yClassName());
        accessibilityNodeInfo.setCheckable(isCheckable());
        accessibilityNodeInfo.setChecked(isChecked());
        accessibilityNodeInfo.setClickable(isClickable());
    }

    @Override // androidx.appcompat.widget.AppCompatButton, android.view.View
    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setClassName(getA11yClassName());
        accessibilityEvent.setChecked(isChecked());
    }

    @Override // android.widget.TextView, android.view.View
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.checked = this.checked;
        return savedState;
    }

    @Override // android.widget.TextView, android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        setChecked(savedState.checked);
    }

    @Override // androidx.appcompat.widget.AppCompatButton, androidx.core.view.TintableBackgroundView
    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        if (isUsingOriginalBackground()) {
            this.materialButtonHelper.setSupportBackgroundTintList(colorStateList);
        } else {
            super.setSupportBackgroundTintList(colorStateList);
        }
    }

    @Override // androidx.appcompat.widget.AppCompatButton, androidx.core.view.TintableBackgroundView
    public ColorStateList getSupportBackgroundTintList() {
        if (isUsingOriginalBackground()) {
            return this.materialButtonHelper.getSupportBackgroundTintList();
        }
        return super.getSupportBackgroundTintList();
    }

    @Override // androidx.appcompat.widget.AppCompatButton, androidx.core.view.TintableBackgroundView
    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        if (isUsingOriginalBackground()) {
            this.materialButtonHelper.setSupportBackgroundTintMode(mode);
        } else {
            super.setSupportBackgroundTintMode(mode);
        }
    }

    @Override // androidx.appcompat.widget.AppCompatButton, androidx.core.view.TintableBackgroundView
    public PorterDuff.Mode getSupportBackgroundTintMode() {
        if (isUsingOriginalBackground()) {
            return this.materialButtonHelper.getSupportBackgroundTintMode();
        }
        return super.getSupportBackgroundTintMode();
    }

    @Override // android.view.View
    public void setBackgroundTintList(ColorStateList colorStateList) {
        setSupportBackgroundTintList(colorStateList);
    }

    @Override // android.view.View
    public ColorStateList getBackgroundTintList() {
        return getSupportBackgroundTintList();
    }

    @Override // android.view.View
    public void setBackgroundTintMode(PorterDuff.Mode mode) {
        setSupportBackgroundTintMode(mode);
    }

    @Override // android.view.View
    public PorterDuff.Mode getBackgroundTintMode() {
        return getSupportBackgroundTintMode();
    }

    @Override // android.view.View
    public void setBackgroundColor(int i) {
        if (isUsingOriginalBackground()) {
            this.materialButtonHelper.setBackgroundColor(i);
        } else {
            super.setBackgroundColor(i);
        }
    }

    @Override // android.view.View
    public void setBackground(Drawable drawable) {
        setBackgroundDrawable(drawable);
    }

    @Override // androidx.appcompat.widget.AppCompatButton, android.view.View
    public void setBackgroundResource(int i) {
        setBackgroundDrawable(i != 0 ? AppCompatResources.getDrawable(getContext(), i) : null);
    }

    @Override // androidx.appcompat.widget.AppCompatButton, android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        if (isUsingOriginalBackground()) {
            if (drawable != getBackground()) {
                Log.w(LOG_TAG, "MaterialButton manages its own background to control elevation, shape, color and states. Consider using backgroundTint, shapeAppearance and other attributes where available. A custom background will ignore these attributes and you should consider handling interaction states such as pressed, focused and disabled");
                this.materialButtonHelper.setBackgroundOverwritten();
                super.setBackgroundDrawable(drawable);
                return;
            }
            getBackground().setState(drawable.getState());
            return;
        }
        super.setBackgroundDrawable(drawable);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.appcompat.widget.AppCompatButton, android.widget.TextView, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int i5;
        super.onLayout(z, i, i2, i3, i4);
        updateIconPosition(getMeasuredWidth(), getMeasuredHeight());
        updateSecondaryIconPosition(getMeasuredWidth(), getMeasuredHeight());
        int i6 = getResources().getConfiguration().orientation;
        if (this.orientation != i6) {
            this.orientation = i6;
            this.originalWidth = -2.14748365E9f;
        }
        if (this.originalWidth == -2.14748365E9f) {
            this.originalWidth = getMeasuredWidth();
            if (this.originalLayoutParams == null && (getParent() instanceof MaterialButtonGroup) && ((MaterialButtonGroup) getParent()).getButtonSizeChange() != null) {
                this.originalLayoutParams = (LinearLayout.LayoutParams) getLayoutParams();
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.originalLayoutParams);
                layoutParams.width = (int) this.originalWidth;
                setLayoutParams(layoutParams);
            }
        }
        if (this.allowedWidthDecrease == Integer.MIN_VALUE) {
            if (this.icon == null) {
                i5 = 0;
            } else {
                int iconPadding = getIconPadding();
                int i7 = this.iconSize;
                if (i7 == 0) {
                    i7 = this.icon.getIntrinsicWidth();
                }
                i5 = iconPadding + i7;
            }
            this.allowedWidthDecrease = (getMeasuredWidth() - getTextLayoutWidth()) - i5;
        }
        if (this.originalPaddingStart == Integer.MIN_VALUE) {
            this.originalPaddingStart = getPaddingStart();
        }
        if (this.originalPaddingEnd == Integer.MIN_VALUE) {
            this.originalPaddingEnd = getPaddingEnd();
        }
        this.isInHorizontalButtonGroup = isInHorizontalButtonGroup();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void recoverOriginalLayoutParams() {
        LinearLayout.LayoutParams layoutParams = this.originalLayoutParams;
        if (layoutParams != null) {
            setLayoutParams(layoutParams);
            this.originalLayoutParams = null;
            this.originalWidth = -2.14748365E9f;
        }
    }

    @Override // android.widget.TextView
    public void setWidth(int i) {
        this.originalWidth = -2.14748365E9f;
        super.setWidth(i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.appcompat.widget.AppCompatButton, android.widget.TextView
    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        super.onTextChanged(charSequence, i, i2, i3);
        updateIconPosition(getMeasuredWidth(), getMeasuredHeight());
        updateSecondaryIconPosition(getMeasuredWidth(), getMeasuredHeight());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.widget.TextView, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (isUsingOriginalBackground()) {
            MaterialShapeUtils.setParentAbsoluteElevation(this, this.materialButtonHelper.getMaterialShapeDrawable());
        }
    }

    @Override // android.view.View
    public void setElevation(float f) {
        super.setElevation(f);
        if (isUsingOriginalBackground()) {
            this.materialButtonHelper.getMaterialShapeDrawable().setElevation(f);
        }
    }

    @Override // android.view.View
    public void refreshDrawableState() {
        super.refreshDrawableState();
        if (this.icon != null) {
            if (this.icon.setState(getDrawableState())) {
                invalidate();
            }
        }
    }

    @Override // android.widget.TextView
    public void setText(CharSequence charSequence, TextView.BufferType bufferType) {
        this.originalWidth = -2.14748365E9f;
        super.setText(charSequence, bufferType);
    }

    @Override // androidx.appcompat.widget.AppCompatButton, android.widget.TextView
    public void setTextAppearance(Context context, int i) {
        this.originalWidth = -2.14748365E9f;
        super.setTextAppearance(context, i);
    }

    @Override // androidx.appcompat.widget.AppCompatButton, android.widget.TextView
    public void setTextSize(int i, float f) {
        this.originalWidth = -2.14748365E9f;
        super.setTextSize(i, f);
    }

    @Override // android.view.View
    public void setTextAlignment(int i) {
        super.setTextAlignment(i);
        updateIconPosition(getMeasuredWidth(), getMeasuredHeight());
        updateSecondaryIconPosition(getMeasuredWidth(), getMeasuredHeight());
    }

    private Layout.Alignment getGravityTextAlignment() {
        int gravity = getGravity() & GravityCompat.RELATIVE_HORIZONTAL_GRAVITY_MASK;
        if (gravity != 1) {
            if (gravity == 5 || gravity == 8388613) {
                return Layout.Alignment.ALIGN_OPPOSITE;
            }
            return Layout.Alignment.ALIGN_NORMAL;
        }
        return Layout.Alignment.ALIGN_CENTER;
    }

    private Layout.Alignment getActualTextAlignment() {
        int textAlignment = getTextAlignment();
        if (textAlignment != 1) {
            if (textAlignment == 6 || textAlignment == 3) {
                return Layout.Alignment.ALIGN_OPPOSITE;
            }
            if (textAlignment == 4) {
                return Layout.Alignment.ALIGN_CENTER;
            }
            return Layout.Alignment.ALIGN_NORMAL;
        }
        return getGravityTextAlignment();
    }

    private void updateIconPosition(int i, int i2) {
        if (this.icon == null || getLayout() == null) {
            return;
        }
        if (isIconStart() || isIconEnd()) {
            this.iconTop = 0;
            if (canUpdateWithoutTextAlignment(this.iconGravity)) {
                this.iconLeft = 0;
                updateIcon(false);
                return;
            }
            int iconLeft = getIconLeft(i, this.iconGravity);
            if (this.iconLeft != iconLeft) {
                this.iconLeft = iconLeft;
                updateIcon(false);
            }
        } else if (isIconTop()) {
            this.iconLeft = 0;
            if (this.iconGravity == 16) {
                this.iconTop = 0;
                updateIcon(false);
                return;
            }
            int i3 = this.iconSize;
            if (i3 == 0) {
                i3 = this.icon.getIntrinsicHeight();
            }
            int iconTop = getIconTop(i2, i3);
            if (this.iconTop != iconTop) {
                this.iconTop = iconTop;
                updateIcon(false);
            }
        }
    }

    private void updateSecondaryIconPosition(int i, int i2) {
        if (this.secondaryIcon == null || getLayout() == null) {
            return;
        }
        if (isSecondaryIconStart() || isSecondaryIconEnd()) {
            this.secondaryIconTop = 0;
            if (canUpdateWithoutTextAlignment(this.secondaryIconGravity)) {
                this.secondaryIconLeft = 0;
                updateSecondaryIcon(false);
                return;
            }
            int iconLeft = getIconLeft(i, this.secondaryIconGravity);
            if (this.secondaryIconLeft != iconLeft) {
                this.secondaryIconLeft = iconLeft;
                updateSecondaryIcon(false);
            }
        } else if (isSecondaryIconTop()) {
            this.secondaryIconLeft = 0;
            if (this.secondaryIconGravity == 16) {
                this.secondaryIconTop = 0;
                updateSecondaryIcon(false);
                return;
            }
            int i3 = this.iconSize;
            if (i3 == 0) {
                i3 = this.secondaryIcon.getIntrinsicHeight();
            }
            int iconTop = getIconTop(i2, i3);
            if (this.secondaryIconTop != iconTop) {
                this.secondaryIconTop = iconTop;
                updateSecondaryIcon(false);
            }
        }
    }

    private boolean canUpdateWithoutTextAlignment(int i) {
        Layout.Alignment actualTextAlignment = getActualTextAlignment();
        return i == 1 || i == 3 || (i == 2 && actualTextAlignment == Layout.Alignment.ALIGN_NORMAL) || (i == 4 && actualTextAlignment == Layout.Alignment.ALIGN_OPPOSITE);
    }

    private int getIconLeft(int i, int i2) {
        int i3;
        int i4;
        Drawable drawable = this.icon;
        if (drawable != null) {
            i3 = this.iconSize;
            if (i3 == 0) {
                i3 = drawable.getIntrinsicWidth();
            }
        } else {
            i3 = 0;
        }
        Drawable drawable2 = this.secondaryIcon;
        if (drawable2 != null) {
            i4 = this.iconSize;
            if (i4 == 0) {
                i4 = drawable2.getIntrinsicWidth();
            }
        } else {
            i4 = 0;
        }
        int textLayoutWidth = (((((i - getTextLayoutWidth()) - getPaddingEnd()) - i3) - i4) - this.iconPadding) - getPaddingStart();
        if (getActualTextAlignment() == Layout.Alignment.ALIGN_CENTER) {
            textLayoutWidth /= 2;
        }
        return isLayoutRTL() != (i2 == 4) ? -textLayoutWidth : textLayoutWidth;
    }

    private int getIconTop(int i, int i2) {
        return Math.max(0, (((((i - getTextHeight()) - getPaddingTop()) - i2) - this.iconPadding) - getPaddingBottom()) / 2);
    }

    private int getTextLayoutWidth() {
        int lineCount = getLineCount();
        float f = 0.0f;
        for (int i = 0; i < lineCount; i++) {
            f = Math.max(f, getLayout().getLineWidth(i));
        }
        return (int) Math.ceil(f);
    }

    private int getTextHeight() {
        if (getLineCount() > 1) {
            return getLayout().getHeight();
        }
        TextPaint paint = getPaint();
        String obj = getText().toString();
        if (getTransformationMethod() != null) {
            obj = getTransformationMethod().getTransformation(obj, this).toString();
        }
        Rect rect = new Rect();
        paint.getTextBounds(obj, 0, obj.length(), rect);
        return Math.min(rect.height(), getLayout().getHeight());
    }

    private boolean isLayoutRTL() {
        return getLayoutDirection() == 1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setInternalBackground(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
    }

    @Override // android.widget.TextView
    public void setCompoundDrawablePadding(int i) {
        if (getCompoundDrawablePadding() != i) {
            this.originalWidth = -2.14748365E9f;
        }
        super.setCompoundDrawablePadding(i);
    }

    public void setIconPadding(int i) {
        if (this.iconPadding != i) {
            this.iconPadding = i;
            setCompoundDrawablePadding(i);
        }
    }

    public int getIconPadding() {
        return this.iconPadding;
    }

    /* renamed from: setIconSize */
    public void m9532xc9d1887c(final int i) {
        if (i < 0) {
            throw new IllegalArgumentException("iconSize cannot be less than 0");
        }
        if (this.iconSize == i || maybeRunAfterWidthAnimation(new Runnable() { // from class: com.google.android.material.button.MaterialButton$$ExternalSyntheticLambda3
            @Override // java.lang.Runnable
            public final void run() {
                MaterialButton.this.m9532xc9d1887c(i);
            }
        })) {
            return;
        }
        this.originalWidth = -2.14748365E9f;
        this.iconSize = i;
        updateIcon(true);
        updateSecondaryIcon(true);
    }

    public int getIconSize() {
        return this.iconSize;
    }

    /* renamed from: setIcon */
    public void m9535x11712a47(final Drawable drawable) {
        if (this.icon == drawable || maybeRunAfterWidthAnimation(new Runnable() { // from class: com.google.android.material.button.MaterialButton$$ExternalSyntheticLambda2
            @Override // java.lang.Runnable
            public final void run() {
                MaterialButton.this.m9531x85a2f9c(drawable);
            }
        })) {
            return;
        }
        this.originalWidth = -2.14748365E9f;
        this.icon = drawable;
        updateIcon(true);
        updateIconPosition(getMeasuredWidth(), getMeasuredHeight());
    }

    public void setIconResource(int i) {
        m9535x11712a47(i != 0 ? AppCompatResources.getDrawable(getContext(), i) : null);
    }

    public Drawable getIcon() {
        return this.icon;
    }

    public void setIconTint(ColorStateList colorStateList) {
        if (this.iconTint != colorStateList) {
            this.iconTint = colorStateList;
            updateIcon(false);
        }
    }

    public void setIconTintResource(int i) {
        setIconTint(AppCompatResources.getColorStateList(getContext(), i));
    }

    public ColorStateList getIconTint() {
        return this.iconTint;
    }

    public void setIconTintMode(PorterDuff.Mode mode) {
        if (this.iconTintMode != mode) {
            this.iconTintMode = mode;
            updateIcon(false);
        }
    }

    public PorterDuff.Mode getIconTintMode() {
        return this.iconTintMode;
    }

    public void setSecondaryIcon(final Drawable drawable) {
        if (this.secondaryIcon == drawable || maybeRunAfterWidthAnimation(new Runnable() { // from class: com.google.android.material.button.MaterialButton$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                MaterialButton.this.m9535x11712a47(drawable);
            }
        })) {
            return;
        }
        this.originalWidth = -2.14748365E9f;
        this.secondaryIcon = drawable;
        this.stopNullSecondaryIconUpdate = false;
        updateSecondaryIcon(true);
        updateSecondaryIconPosition(getMeasuredWidth(), getMeasuredHeight());
    }

    public void setSecondaryIconResource(int i) {
        setSecondaryIcon(i != 0 ? AppCompatResources.getDrawable(getContext(), i) : null);
    }

    public Drawable getSecondaryIcon() {
        return this.secondaryIcon;
    }

    public void setSecondaryIconTint(ColorStateList colorStateList) {
        if (this.secondaryIconTint != colorStateList) {
            this.secondaryIconTint = colorStateList;
            updateSecondaryIcon(false);
        }
    }

    public void setSecondaryIconTintResource(int i) {
        setSecondaryIconTint(AppCompatResources.getColorStateList(getContext(), i));
    }

    public ColorStateList getSecondaryIconTint() {
        return this.secondaryIconTint;
    }

    public void setSecondaryIconTintMode(PorterDuff.Mode mode) {
        if (this.secondaryIconTintMode != mode) {
            this.secondaryIconTintMode = mode;
            updateSecondaryIcon(false);
        }
    }

    public PorterDuff.Mode getSecondaryIconTintMode() {
        return this.secondaryIconTintMode;
    }

    private void updateIcon(boolean z) {
        Drawable drawable = this.icon;
        if (drawable != null) {
            Drawable mutate = DrawableCompat.wrap(drawable).mutate();
            this.icon = mutate;
            mutate.setTintList(this.iconTint);
            PorterDuff.Mode mode = this.iconTintMode;
            if (mode != null) {
                this.icon.setTintMode(mode);
            }
            int i = this.iconSize;
            if (i == 0) {
                i = this.icon.getIntrinsicWidth();
            }
            int i2 = this.iconSize;
            if (i2 == 0) {
                i2 = this.icon.getIntrinsicHeight();
            }
            Drawable drawable2 = this.icon;
            int i3 = this.iconLeft;
            int i4 = this.iconTop;
            drawable2.setBounds(i3, i4, i + i3, i2 + i4);
            this.icon.setVisible(true, z);
        }
        validateIconGravity();
        if (this.icon == null && this.secondaryIcon != null && areIconsGravitySameAlignment()) {
            return;
        }
        Drawable[] compoundDrawablesRelative = getCompoundDrawablesRelative();
        boolean z2 = (isIconStart() && compoundDrawablesRelative[0] != this.icon) || (isIconEnd() && compoundDrawablesRelative[2] != this.icon) || (isIconTop() && compoundDrawablesRelative[1] != this.icon);
        if (z || z2) {
            if (isIconStart()) {
                setCompoundDrawablesRelative(this.icon, getUpdatedIconFor(1), getUpdatedIconFor(2), null);
            } else if (isIconEnd()) {
                setCompoundDrawablesRelative(getUpdatedIconFor(0), getUpdatedIconFor(1), this.icon, null);
            } else if (isIconTop()) {
                setCompoundDrawablesRelative(getUpdatedIconFor(0), this.icon, getUpdatedIconFor(2), null);
            }
        }
    }

    private void validateIconGravity() {
        if (this.icon != null && this.secondaryIcon != null && areIconsGravitySameAlignment()) {
            throw new IllegalArgumentException("iconGravity cannot have the same alignment as secondaryIconGravity");
        }
    }

    private boolean areIconsGravitySameAlignment() {
        if (isIconStart() && isSecondaryIconStart()) {
            return true;
        }
        if (isIconEnd() && isSecondaryIconEnd()) {
            return true;
        }
        return isIconTop() && isSecondaryIconTop();
    }

    private Drawable getUpdatedIconFor(int i) {
        if (i == 0) {
            if (this.secondaryIcon == null || !isSecondaryIconStart()) {
                return null;
            }
            return this.secondaryIcon;
        } else if (i == 1) {
            if (this.secondaryIcon == null || !isSecondaryIconTop()) {
                return null;
            }
            return this.secondaryIcon;
        } else if (i == 2 && this.secondaryIcon != null && isSecondaryIconEnd()) {
            return this.secondaryIcon;
        } else {
            return null;
        }
    }

    private boolean isIconStart() {
        int i = this.iconGravity;
        return i == 1 || i == 2;
    }

    private boolean isIconEnd() {
        int i = this.iconGravity;
        return i == 3 || i == 4;
    }

    private boolean isIconTop() {
        int i = this.iconGravity;
        return i == 16 || i == 32;
    }

    private boolean isSecondaryIconStart() {
        int i = this.secondaryIconGravity;
        return i == 1 || i == 2;
    }

    private boolean isSecondaryIconEnd() {
        int i = this.secondaryIconGravity;
        return i == 3 || i == 4;
    }

    private boolean isSecondaryIconTop() {
        int i = this.secondaryIconGravity;
        return i == 16 || i == 32;
    }

    private void updateSecondaryIcon(boolean z) {
        Drawable drawable = this.secondaryIcon;
        if (drawable != null) {
            Drawable mutate = DrawableCompat.wrap(drawable).mutate();
            this.secondaryIcon = mutate;
            mutate.setTintList(this.secondaryIconTint);
            PorterDuff.Mode mode = this.secondaryIconTintMode;
            if (mode != null) {
                this.secondaryIcon.setTintMode(mode);
            }
            int i = this.iconSize;
            if (i == 0) {
                i = this.secondaryIcon.getIntrinsicWidth();
            }
            int i2 = this.iconSize;
            if (i2 == 0) {
                i2 = this.secondaryIcon.getIntrinsicHeight();
            }
            Drawable drawable2 = this.secondaryIcon;
            int i3 = this.secondaryIconLeft;
            int i4 = this.secondaryIconTop;
            drawable2.setBounds(i3, i4, i + i3, i2 + i4);
            this.secondaryIcon.setVisible(true, z);
        }
        validateSecondaryIconGravity();
        if (this.secondaryIcon == null) {
            if (this.stopNullSecondaryIconUpdate) {
                return;
            }
            if (this.icon != null && areIconsGravitySameAlignment()) {
                return;
            }
        }
        Drawable[] compoundDrawablesRelative = getCompoundDrawablesRelative();
        boolean z2 = (isSecondaryIconStart() && compoundDrawablesRelative[0] != this.secondaryIcon) || (isSecondaryIconEnd() && compoundDrawablesRelative[2] != this.secondaryIcon) || (isSecondaryIconTop() && compoundDrawablesRelative[1] != this.secondaryIcon);
        if (z || z2) {
            if (isSecondaryIconStart()) {
                setCompoundDrawablesRelative(this.secondaryIcon, getUpdatedSecondaryIconFor(1), getUpdatedSecondaryIconFor(2), null);
            } else if (isSecondaryIconEnd()) {
                setCompoundDrawablesRelative(getUpdatedSecondaryIconFor(0), getUpdatedSecondaryIconFor(1), this.secondaryIcon, null);
            } else if (isSecondaryIconTop()) {
                setCompoundDrawablesRelative(getUpdatedSecondaryIconFor(0), this.secondaryIcon, getUpdatedSecondaryIconFor(2), null);
            }
        }
    }

    private void validateSecondaryIconGravity() {
        if (this.secondaryIcon != null && this.icon != null && areIconsGravitySameAlignment()) {
            throw new IllegalArgumentException("secondaryIconGravity cannot have the same alignment as iconGravity");
        }
    }

    private Drawable getUpdatedSecondaryIconFor(int i) {
        if (i == 0) {
            if (this.icon == null || !isIconStart()) {
                return null;
            }
            return this.icon;
        } else if (i == 1) {
            if (this.icon == null || !isIconEnd()) {
                return null;
            }
            return this.icon;
        } else if (i == 2 && this.icon != null && isIconEnd()) {
            return this.icon;
        } else {
            return null;
        }
    }

    public void setRippleColor(ColorStateList colorStateList) {
        if (isUsingOriginalBackground()) {
            this.materialButtonHelper.setRippleColor(colorStateList);
        }
    }

    public void setRippleColorResource(int i) {
        if (isUsingOriginalBackground()) {
            setRippleColor(AppCompatResources.getColorStateList(getContext(), i));
        }
    }

    public ColorStateList getRippleColor() {
        if (isUsingOriginalBackground()) {
            return this.materialButtonHelper.getRippleColor();
        }
        return null;
    }

    public void setStrokeColor(ColorStateList colorStateList) {
        if (isUsingOriginalBackground()) {
            this.materialButtonHelper.setStrokeColor(colorStateList);
        }
    }

    public void setStrokeColorResource(int i) {
        if (isUsingOriginalBackground()) {
            setStrokeColor(AppCompatResources.getColorStateList(getContext(), i));
        }
    }

    public ColorStateList getStrokeColor() {
        if (isUsingOriginalBackground()) {
            return this.materialButtonHelper.getStrokeColor();
        }
        return null;
    }

    public void setStrokeWidth(int i) {
        if (isUsingOriginalBackground()) {
            this.materialButtonHelper.setStrokeWidth(i);
        }
    }

    public void setStrokeWidthResource(int i) {
        if (isUsingOriginalBackground()) {
            setStrokeWidth(getResources().getDimensionPixelSize(i));
        }
    }

    public int getStrokeWidth() {
        if (isUsingOriginalBackground()) {
            return this.materialButtonHelper.getStrokeWidth();
        }
        return 0;
    }

    public void setCornerRadius(int i) {
        if (isUsingOriginalBackground()) {
            this.materialButtonHelper.setCornerRadius(i);
        }
    }

    public void setCornerRadiusResource(int i) {
        if (isUsingOriginalBackground()) {
            setCornerRadius(getResources().getDimensionPixelSize(i));
        }
    }

    public int getCornerRadius() {
        if (isUsingOriginalBackground()) {
            return this.materialButtonHelper.getCornerRadius();
        }
        return 0;
    }

    public int getIconGravity() {
        return this.iconGravity;
    }

    public void setIconGravity(int i) {
        if (this.iconGravity != i) {
            validateIconGravity();
            this.iconGravity = i;
            updateIconPosition(getMeasuredWidth(), getMeasuredHeight());
        }
    }

    public int getSecondaryIconGravity() {
        return this.secondaryIconGravity;
    }

    public void setSecondaryIconGravity(int i) {
        if (this.secondaryIconGravity != i) {
            validateSecondaryIconGravity();
            this.secondaryIconGravity = i;
            updateSecondaryIconPosition(getMeasuredWidth(), getMeasuredHeight());
        }
    }

    public void setInsetBottom(int i) {
        this.materialButtonHelper.setInsetBottom(i);
    }

    public int getInsetBottom() {
        return this.materialButtonHelper.getInsetBottom();
    }

    public void setInsetTop(int i) {
        this.materialButtonHelper.setInsetTop(i);
    }

    public int getInsetTop() {
        return this.materialButtonHelper.getInsetTop();
    }

    public void setInsetLeft(int i) {
        this.materialButtonHelper.setInsetLeft(i);
    }

    public int getInsetLeft() {
        return this.materialButtonHelper.getInsetLeft();
    }

    public void setInsetRight(int i) {
        this.materialButtonHelper.setInsetRight(i);
    }

    public int getInsetRight() {
        return this.materialButtonHelper.getInsetRight();
    }

    @Override // android.widget.TextView, android.view.View
    protected int[] onCreateDrawableState(int i) {
        int[] onCreateDrawableState = super.onCreateDrawableState(i + 2);
        if (isCheckable()) {
            mergeDrawableStates(onCreateDrawableState, CHECKABLE_STATE_SET);
        }
        if (isChecked()) {
            mergeDrawableStates(onCreateDrawableState, CHECKED_STATE_SET);
        }
        return onCreateDrawableState;
    }

    public void addOnCheckedChangeListener(OnCheckedChangeListener onCheckedChangeListener) {
        this.onCheckedChangeListeners.add(onCheckedChangeListener);
    }

    public void removeOnCheckedChangeListener(OnCheckedChangeListener onCheckedChangeListener) {
        this.onCheckedChangeListeners.remove(onCheckedChangeListener);
    }

    public void clearOnCheckedChangeListeners() {
        this.onCheckedChangeListeners.clear();
    }

    @Override // android.widget.Checkable
    public void setChecked(boolean z) {
        setCheckedInternal(z);
    }

    private void setCheckedInternal(boolean z) {
        if (!isCheckable() || this.checked == z) {
            return;
        }
        this.checked = z;
        refreshDrawableState();
        if (getParent() instanceof MaterialButtonToggleGroup) {
            ((MaterialButtonToggleGroup) getParent()).onButtonCheckedStateChanged(this, this.checked);
        }
        if (this.broadcasting) {
            return;
        }
        this.broadcasting = true;
        Iterator<OnCheckedChangeListener> it = this.onCheckedChangeListeners.iterator();
        while (it.hasNext()) {
            it.next().onCheckedChanged(this, this.checked);
        }
        this.broadcasting = false;
    }

    @Override // android.widget.Checkable
    public boolean isChecked() {
        return this.checked;
    }

    @Override // android.widget.Checkable
    public void toggle() {
        setChecked(!this.checked);
    }

    @Override // android.view.View
    public boolean performClick() {
        boolean z;
        if (isEnabled() && this.materialButtonHelper.isToggleCheckedStateOnClick()) {
            toggle();
            z = true;
        } else {
            z = false;
        }
        boolean performClick = super.performClick();
        if (z && !performClick) {
            playSoundEffect(0);
        }
        return performClick;
    }

    public boolean isToggleCheckedStateOnClick() {
        return this.materialButtonHelper.isToggleCheckedStateOnClick();
    }

    public void setToggleCheckedStateOnClick(boolean z) {
        this.materialButtonHelper.setToggleCheckedStateOnClick(z);
    }

    public boolean isCheckable() {
        MaterialButtonHelper materialButtonHelper = this.materialButtonHelper;
        return materialButtonHelper != null && materialButtonHelper.isCheckable();
    }

    public void setCheckable(boolean z) {
        if (isUsingOriginalBackground()) {
            this.materialButtonHelper.setCheckable(z);
        }
    }

    @Override // com.google.android.material.shape.Shapeable
    public void setShapeAppearanceModel(ShapeAppearanceModel shapeAppearanceModel) {
        if (isUsingOriginalBackground()) {
            this.materialButtonHelper.setShapeAppearance(shapeAppearanceModel);
            return;
        }
        throw new IllegalStateException("Attempted to set ShapeAppearanceModel on a MaterialButton which has an overwritten background.");
    }

    @Override // com.google.android.material.shape.Shapeable
    public ShapeAppearanceModel getShapeAppearanceModel() {
        if (isUsingOriginalBackground()) {
            return this.materialButtonHelper.getShapeAppearanceModel();
        }
        throw new IllegalStateException("Attempted to get ShapeAppearanceModel from a MaterialButton which has an overwritten background.");
    }

    public void setShapeAppearance(ShapeAppearance shapeAppearance) {
        if (isUsingOriginalBackground()) {
            if (this.materialButtonHelper.getCornerSpringForce() == null && shapeAppearance.isStateful()) {
                this.materialButtonHelper.setCornerSpringForce(createSpringForce());
            }
            this.materialButtonHelper.setShapeAppearance(shapeAppearance);
            return;
        }
        throw new IllegalStateException("Attempted to set ShapeAppearance on a MaterialButton which has an overwritten background.");
    }

    public ShapeAppearance getShapeAppearance() {
        if (isUsingOriginalBackground()) {
            return this.materialButtonHelper.getShapeAppearance();
        }
        throw new IllegalStateException("Attempted to get ShapeAppearance from a MaterialButton which has an overwritten background.");
    }

    public void setCornerSpringForce(SpringForce springForce) {
        this.materialButtonHelper.setCornerSpringForce(springForce);
    }

    public SpringForce getCornerSpringForce() {
        return this.materialButtonHelper.getCornerSpringForce();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setOnPressedChangeListenerInternal(OnPressedChangeListener onPressedChangeListener) {
        this.onPressedChangeListenerInternal = onPressedChangeListener;
    }

    @Override // android.view.View
    public void setPressed(boolean z) {
        OnPressedChangeListener onPressedChangeListener = this.onPressedChangeListenerInternal;
        if (onPressedChangeListener != null) {
            onPressedChangeListener.onPressedChanged(this, z);
        }
        super.setPressed(z);
        maybeAnimateSize(false);
    }

    private boolean isUsingOriginalBackground() {
        MaterialButtonHelper materialButtonHelper = this.materialButtonHelper;
        return (materialButtonHelper == null || materialButtonHelper.isBackgroundOverwritten()) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setShouldDrawSurfaceColorStroke(boolean z) {
        if (isUsingOriginalBackground()) {
            this.materialButtonHelper.setShouldDrawSurfaceColorStroke(z);
        }
    }

    private void maybeAnimateSize(boolean z) {
        if (this.sizeChange == null) {
            return;
        }
        if (this.widthIncreaseSpringAnimation == null) {
            initializeSizeAnimation();
        }
        if (this.isInHorizontalButtonGroup) {
            this.widthIncreaseSpringAnimation.animateToFinalPosition(Math.min(calculateEffectiveWidthChangeMax(), this.sizeChange.getSizeChangeForState(getDrawableState()).widthChange.getChange(getWidth())));
            if (z) {
                this.widthIncreaseSpringAnimation.skipToEnd();
            }
        }
    }

    private int calculateEffectiveWidthChangeMax() {
        int ordinal = this.widthChangeDirection.ordinal();
        if (ordinal == 1 || ordinal == 2) {
            return this.widthChangeMax / 2;
        }
        if (ordinal != 3) {
            return 0;
        }
        return this.widthChangeMax;
    }

    private boolean isInHorizontalButtonGroup() {
        return (getParent() instanceof MaterialButtonGroup) && ((MaterialButtonGroup) getParent()).getOrientation() == 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setSizeChange(StateListSizeChange stateListSizeChange) {
        if (this.sizeChange != stateListSizeChange) {
            this.sizeChange = stateListSizeChange;
            maybeAnimateSize(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setWidthChangeMax(int i) {
        if (this.widthChangeMax != i) {
            this.widthChangeMax = i;
            maybeAnimateSize(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setWidthChangeDirection(WidthChangeDirection widthChangeDirection) {
        if (this.widthChangeDirection != widthChangeDirection) {
            this.widthChangeDirection = widthChangeDirection;
            maybeAnimateSize(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getAllowedWidthDecrease() {
        return this.allowedWidthDecrease;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public float getDisplayedWidthIncrease() {
        return this.displayedWidthIncrease;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setDisplayedWidthIncrease(float f) {
        if (this.displayedWidthIncrease != f) {
            this.displayedWidthIncrease = f;
            updatePaddingsAndSizeForWidthAnimation();
            invalidate();
            if (getParent() instanceof MaterialButtonGroup) {
                ((MaterialButtonGroup) getParent()).onButtonWidthChanged(this, (int) this.displayedWidthIncrease);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setDisplayedWidthDecrease(int i) {
        this.displayedWidthDecrease = Math.min(i, this.allowedWidthDecrease);
        updatePaddingsAndSizeForWidthAnimation();
        invalidate();
    }

    public void setOpticalCenterEnabled(boolean z) {
        if (this.opticalCenterEnabled != z) {
            this.opticalCenterEnabled = z;
            MaterialButtonHelper materialButtonHelper = this.materialButtonHelper;
            if (z) {
                materialButtonHelper.setCornerSizeChangeListener(new MaterialShapeDrawable.OnCornerSizeChangeListener() { // from class: com.google.android.material.button.MaterialButton$$ExternalSyntheticLambda4
                    @Override // com.google.android.material.shape.MaterialShapeDrawable.OnCornerSizeChangeListener
                    public final void onCornerSizeChange(float f) {
                        MaterialButton.this.m9533x6fa58539(f);
                    }
                });
            } else {
                materialButtonHelper.setCornerSizeChangeListener(null);
            }
            post(new Runnable() { // from class: com.google.android.material.button.MaterialButton$$ExternalSyntheticLambda5
                @Override // java.lang.Runnable
                public final void run() {
                    MaterialButton.this.m9534xb330a2fa();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$setOpticalCenterEnabled$4$com-google-android-material-button-MaterialButton  reason: not valid java name */
    public /* synthetic */ void m9533x6fa58539(float f) {
        int i = (int) (f * 0.11f);
        if (this.opticalCenterShift != i) {
            this.opticalCenterShift = i;
            updatePaddingsAndSizeForWidthAnimation();
            invalidate();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$setOpticalCenterEnabled$5$com-google-android-material-button-MaterialButton  reason: not valid java name */
    public /* synthetic */ void m9534xb330a2fa() {
        this.opticalCenterShift = getOpticalCenterShift();
        updatePaddingsAndSizeForWidthAnimation();
        invalidate();
    }

    public boolean isOpticalCenterEnabled() {
        return this.opticalCenterEnabled;
    }

    private void updatePaddingsAndSizeForWidthAnimation() {
        int i = (int) (this.displayedWidthIncrease - this.displayedWidthDecrease);
        boolean isLayoutRTL = isLayoutRTL();
        int i2 = this.opticalCenterShift;
        if (isLayoutRTL) {
            i2 = -i2;
        }
        int i3 = (i / 2) + i2;
        if (getLayoutParams() != null) {
            getLayoutParams().width = (int) (this.originalWidth + i);
        }
        setPaddingRelative(this.originalPaddingStart + i3, getPaddingTop(), (this.originalPaddingEnd + i) - i3, getPaddingBottom());
    }

    private int getOpticalCenterShift() {
        MaterialShapeDrawable materialShapeDrawable;
        if (this.opticalCenterEnabled && this.isInHorizontalButtonGroup && (materialShapeDrawable = this.materialButtonHelper.getMaterialShapeDrawable()) != null) {
            return (int) (materialShapeDrawable.getCornerSizeDiffX() * 0.11f);
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.ClassLoaderCreator<SavedState>() { // from class: com.google.android.material.button.MaterialButton.SavedState.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.ClassLoaderCreator
            public SavedState createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new SavedState(parcel, classLoader);
            }

            @Override // android.os.Parcelable.Creator
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel, null);
            }

            @Override // android.os.Parcelable.Creator
            public SavedState[] newArray(int i) {
                return new SavedState[i];
            }
        };
        boolean checked;

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        public SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            if (classLoader == null) {
                getClass().getClassLoader();
            }
            readFromParcel(parcel);
        }

        @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.checked ? 1 : 0);
        }

        private void readFromParcel(Parcel parcel) {
            this.checked = parcel.readInt() == 1;
        }
    }
}
