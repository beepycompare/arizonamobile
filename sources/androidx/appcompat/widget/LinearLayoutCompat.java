package androidx.appcompat.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.inspector.InspectionCompanion;
import android.view.inspector.PropertyMapper;
import android.view.inspector.PropertyReader;
import android.widget.LinearLayout;
import androidx.appcompat.R;
import androidx.core.view.GravityCompat;
import androidx.core.view.InputDeviceCompat;
import androidx.core.view.ViewCompat;
import androidx.media3.extractor.text.ttml.TtmlNode;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.HashSet;
import java.util.Set;
import java.util.function.IntFunction;
/* loaded from: classes.dex */
public class LinearLayoutCompat extends ViewGroup {
    private static final String ACCESSIBILITY_CLASS_NAME = "androidx.appcompat.widget.LinearLayoutCompat";
    public static final int HORIZONTAL = 0;
    private static final int INDEX_BOTTOM = 2;
    private static final int INDEX_CENTER_VERTICAL = 0;
    private static final int INDEX_FILL = 3;
    private static final int INDEX_TOP = 1;
    public static final int SHOW_DIVIDER_BEGINNING = 1;
    public static final int SHOW_DIVIDER_END = 4;
    public static final int SHOW_DIVIDER_MIDDLE = 2;
    public static final int SHOW_DIVIDER_NONE = 0;
    public static final int VERTICAL = 1;
    private static final int VERTICAL_GRAVITY_COUNT = 4;
    private boolean mBaselineAligned;
    private int mBaselineAlignedChildIndex;
    private int mBaselineChildTop;
    private Drawable mDivider;
    private int mDividerHeight;
    private int mDividerPadding;
    private int mDividerWidth;
    private int mGravity;
    private int[] mMaxAscent;
    private int[] mMaxDescent;
    private int mOrientation;
    private int mShowDividers;
    private int mTotalLength;
    private boolean mUseLargestChild;
    private float mWeightSum;

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes.dex */
    public @interface DividerMode {
    }

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes.dex */
    public @interface OrientationMode {
    }

    int getChildrenSkipCount(View view, int i) {
        return 0;
    }

    int getLocationOffset(View view) {
        return 0;
    }

    int getNextLocationOffset(View view) {
        return 0;
    }

    int measureNullChild(int i) {
        return 0;
    }

    @Override // android.view.ViewGroup
    public boolean shouldDelayChildPressedState() {
        return false;
    }

    /* loaded from: classes.dex */
    public final class InspectionCompanion implements android.view.inspector.InspectionCompanion<LinearLayoutCompat> {
        private int mBaselineAlignedChildIndexId;
        private int mBaselineAlignedId;
        private int mDividerId;
        private int mDividerPaddingId;
        private int mGravityId;
        private int mMeasureWithLargestChildId;
        private int mOrientationId;
        private boolean mPropertiesMapped = false;
        private int mShowDividersId;
        private int mWeightSumId;

        @Override // android.view.inspector.InspectionCompanion
        public void mapProperties(PropertyMapper propertyMapper) {
            this.mBaselineAlignedId = propertyMapper.mapBoolean("baselineAligned", 16843046);
            this.mBaselineAlignedChildIndexId = propertyMapper.mapInt("baselineAlignedChildIndex", 16843047);
            this.mGravityId = propertyMapper.mapGravity("gravity", 16842927);
            this.mOrientationId = propertyMapper.mapIntEnum("orientation", 16842948, new IntFunction<String>() { // from class: androidx.appcompat.widget.LinearLayoutCompat.InspectionCompanion.1
                @Override // java.util.function.IntFunction
                public String apply(int i) {
                    if (i != 0) {
                        if (i == 1) {
                            return "vertical";
                        }
                        return String.valueOf(i);
                    }
                    return "horizontal";
                }
            });
            this.mWeightSumId = propertyMapper.mapFloat("weightSum", 16843048);
            this.mDividerId = propertyMapper.mapObject("divider", R.attr.divider);
            this.mDividerPaddingId = propertyMapper.mapInt("dividerPadding", R.attr.dividerPadding);
            this.mMeasureWithLargestChildId = propertyMapper.mapBoolean("measureWithLargestChild", R.attr.measureWithLargestChild);
            this.mShowDividersId = propertyMapper.mapIntFlag("showDividers", R.attr.showDividers, new IntFunction<Set<String>>() { // from class: androidx.appcompat.widget.LinearLayoutCompat.InspectionCompanion.2
                @Override // java.util.function.IntFunction
                public Set<String> apply(int i) {
                    HashSet hashSet = new HashSet();
                    if (i == 0) {
                        hashSet.add("none");
                    }
                    if (i == 1) {
                        hashSet.add("beginning");
                    }
                    if (i == 2) {
                        hashSet.add("middle");
                    }
                    if (i == 4) {
                        hashSet.add(TtmlNode.END);
                    }
                    return hashSet;
                }
            });
            this.mPropertiesMapped = true;
        }

        @Override // android.view.inspector.InspectionCompanion
        public void readProperties(LinearLayoutCompat linearLayoutCompat, PropertyReader propertyReader) {
            if (!this.mPropertiesMapped) {
                throw new InspectionCompanion.UninitializedPropertyMapException();
            }
            propertyReader.readBoolean(this.mBaselineAlignedId, linearLayoutCompat.isBaselineAligned());
            propertyReader.readInt(this.mBaselineAlignedChildIndexId, linearLayoutCompat.getBaselineAlignedChildIndex());
            propertyReader.readGravity(this.mGravityId, linearLayoutCompat.getGravity());
            propertyReader.readIntEnum(this.mOrientationId, linearLayoutCompat.getOrientation());
            propertyReader.readFloat(this.mWeightSumId, linearLayoutCompat.getWeightSum());
            propertyReader.readObject(this.mDividerId, linearLayoutCompat.getDividerDrawable());
            propertyReader.readInt(this.mDividerPaddingId, linearLayoutCompat.getDividerPadding());
            propertyReader.readBoolean(this.mMeasureWithLargestChildId, linearLayoutCompat.isMeasureWithLargestChildEnabled());
            propertyReader.readIntFlag(this.mShowDividersId, linearLayoutCompat.getShowDividers());
        }
    }

    public LinearLayoutCompat(Context context) {
        this(context, null);
    }

    public LinearLayoutCompat(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public LinearLayoutCompat(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mBaselineAligned = true;
        this.mBaselineAlignedChildIndex = -1;
        this.mBaselineChildTop = 0;
        this.mGravity = 8388659;
        TintTypedArray obtainStyledAttributes = TintTypedArray.obtainStyledAttributes(context, attributeSet, R.styleable.LinearLayoutCompat, i, 0);
        ViewCompat.saveAttributeDataForStyleable(this, context, R.styleable.LinearLayoutCompat, attributeSet, obtainStyledAttributes.getWrappedTypeArray(), i, 0);
        int i2 = obtainStyledAttributes.getInt(R.styleable.LinearLayoutCompat_android_orientation, -1);
        if (i2 >= 0) {
            setOrientation(i2);
        }
        int i3 = obtainStyledAttributes.getInt(R.styleable.LinearLayoutCompat_android_gravity, -1);
        if (i3 >= 0) {
            setGravity(i3);
        }
        boolean z = obtainStyledAttributes.getBoolean(R.styleable.LinearLayoutCompat_android_baselineAligned, true);
        if (!z) {
            setBaselineAligned(z);
        }
        this.mWeightSum = obtainStyledAttributes.getFloat(R.styleable.LinearLayoutCompat_android_weightSum, -1.0f);
        this.mBaselineAlignedChildIndex = obtainStyledAttributes.getInt(R.styleable.LinearLayoutCompat_android_baselineAlignedChildIndex, -1);
        this.mUseLargestChild = obtainStyledAttributes.getBoolean(R.styleable.LinearLayoutCompat_measureWithLargestChild, false);
        setDividerDrawable(obtainStyledAttributes.getDrawable(R.styleable.LinearLayoutCompat_divider));
        this.mShowDividers = obtainStyledAttributes.getInt(R.styleable.LinearLayoutCompat_showDividers, 0);
        this.mDividerPadding = obtainStyledAttributes.getDimensionPixelSize(R.styleable.LinearLayoutCompat_dividerPadding, 0);
        obtainStyledAttributes.recycle();
    }

    public void setShowDividers(int i) {
        if (i != this.mShowDividers) {
            requestLayout();
        }
        this.mShowDividers = i;
    }

    public int getShowDividers() {
        return this.mShowDividers;
    }

    public Drawable getDividerDrawable() {
        return this.mDivider;
    }

    public void setDividerDrawable(Drawable drawable) {
        if (drawable == this.mDivider) {
            return;
        }
        this.mDivider = drawable;
        if (drawable != null) {
            this.mDividerWidth = drawable.getIntrinsicWidth();
            this.mDividerHeight = drawable.getIntrinsicHeight();
        } else {
            this.mDividerWidth = 0;
            this.mDividerHeight = 0;
        }
        setWillNotDraw(drawable == null);
        requestLayout();
    }

    public void setDividerPadding(int i) {
        this.mDividerPadding = i;
    }

    public int getDividerPadding() {
        return this.mDividerPadding;
    }

    public int getDividerWidth() {
        return this.mDividerWidth;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        if (this.mDivider == null) {
            return;
        }
        if (this.mOrientation == 1) {
            drawDividersVertical(canvas);
        } else {
            drawDividersHorizontal(canvas);
        }
    }

    void drawDividersVertical(Canvas canvas) {
        int bottom;
        int virtualChildCount = getVirtualChildCount();
        for (int i = 0; i < virtualChildCount; i++) {
            View virtualChildAt = getVirtualChildAt(i);
            if (virtualChildAt != null && virtualChildAt.getVisibility() != 8 && hasDividerBeforeChildAt(i)) {
                drawHorizontalDivider(canvas, (virtualChildAt.getTop() - ((LayoutParams) virtualChildAt.getLayoutParams()).topMargin) - this.mDividerHeight);
            }
        }
        if (hasDividerBeforeChildAt(virtualChildCount)) {
            View virtualChildAt2 = getVirtualChildAt(virtualChildCount - 1);
            if (virtualChildAt2 == null) {
                bottom = (getHeight() - getPaddingBottom()) - this.mDividerHeight;
            } else {
                bottom = virtualChildAt2.getBottom() + ((LayoutParams) virtualChildAt2.getLayoutParams()).bottomMargin;
            }
            drawHorizontalDivider(canvas, bottom);
        }
    }

    void drawDividersHorizontal(Canvas canvas) {
        int right;
        int left;
        int i;
        int left2;
        int virtualChildCount = getVirtualChildCount();
        boolean isLayoutRtl = ViewUtils.isLayoutRtl(this);
        for (int i2 = 0; i2 < virtualChildCount; i2++) {
            View virtualChildAt = getVirtualChildAt(i2);
            if (virtualChildAt != null && virtualChildAt.getVisibility() != 8 && hasDividerBeforeChildAt(i2)) {
                LayoutParams layoutParams = (LayoutParams) virtualChildAt.getLayoutParams();
                if (isLayoutRtl) {
                    left2 = virtualChildAt.getRight() + layoutParams.rightMargin;
                } else {
                    left2 = (virtualChildAt.getLeft() - layoutParams.leftMargin) - this.mDividerWidth;
                }
                drawVerticalDivider(canvas, left2);
            }
        }
        if (hasDividerBeforeChildAt(virtualChildCount)) {
            View virtualChildAt2 = getVirtualChildAt(virtualChildCount - 1);
            if (virtualChildAt2 != null) {
                LayoutParams layoutParams2 = (LayoutParams) virtualChildAt2.getLayoutParams();
                if (isLayoutRtl) {
                    left = virtualChildAt2.getLeft() - layoutParams2.leftMargin;
                    i = this.mDividerWidth;
                    right = left - i;
                } else {
                    right = virtualChildAt2.getRight() + layoutParams2.rightMargin;
                }
            } else if (isLayoutRtl) {
                right = getPaddingLeft();
            } else {
                left = getWidth() - getPaddingRight();
                i = this.mDividerWidth;
                right = left - i;
            }
            drawVerticalDivider(canvas, right);
        }
    }

    void drawHorizontalDivider(Canvas canvas, int i) {
        this.mDivider.setBounds(getPaddingLeft() + this.mDividerPadding, i, (getWidth() - getPaddingRight()) - this.mDividerPadding, this.mDividerHeight + i);
        this.mDivider.draw(canvas);
    }

    void drawVerticalDivider(Canvas canvas, int i) {
        this.mDivider.setBounds(i, getPaddingTop() + this.mDividerPadding, this.mDividerWidth + i, (getHeight() - getPaddingBottom()) - this.mDividerPadding);
        this.mDivider.draw(canvas);
    }

    public boolean isBaselineAligned() {
        return this.mBaselineAligned;
    }

    public void setBaselineAligned(boolean z) {
        this.mBaselineAligned = z;
    }

    public boolean isMeasureWithLargestChildEnabled() {
        return this.mUseLargestChild;
    }

    public void setMeasureWithLargestChildEnabled(boolean z) {
        this.mUseLargestChild = z;
    }

    @Override // android.view.View
    public int getBaseline() {
        int i;
        if (this.mBaselineAlignedChildIndex < 0) {
            return super.getBaseline();
        }
        int childCount = getChildCount();
        int i2 = this.mBaselineAlignedChildIndex;
        if (childCount <= i2) {
            throw new RuntimeException("mBaselineAlignedChildIndex of LinearLayout set to an index that is out of bounds.");
        }
        View childAt = getChildAt(i2);
        int baseline = childAt.getBaseline();
        if (baseline == -1) {
            if (this.mBaselineAlignedChildIndex == 0) {
                return -1;
            }
            throw new RuntimeException("mBaselineAlignedChildIndex of LinearLayout points to a View that doesn't know how to get its baseline.");
        }
        int i3 = this.mBaselineChildTop;
        if (this.mOrientation == 1 && (i = this.mGravity & 112) != 48) {
            if (i == 16) {
                i3 += ((((getBottom() - getTop()) - getPaddingTop()) - getPaddingBottom()) - this.mTotalLength) / 2;
            } else if (i == 80) {
                i3 = ((getBottom() - getTop()) - getPaddingBottom()) - this.mTotalLength;
            }
        }
        return i3 + ((LayoutParams) childAt.getLayoutParams()).topMargin + baseline;
    }

    public int getBaselineAlignedChildIndex() {
        return this.mBaselineAlignedChildIndex;
    }

    public void setBaselineAlignedChildIndex(int i) {
        if (i < 0 || i >= getChildCount()) {
            throw new IllegalArgumentException("base aligned child index out of range (0, " + getChildCount() + ")");
        }
        this.mBaselineAlignedChildIndex = i;
    }

    View getVirtualChildAt(int i) {
        return getChildAt(i);
    }

    int getVirtualChildCount() {
        return getChildCount();
    }

    public float getWeightSum() {
        return this.mWeightSum;
    }

    public void setWeightSum(float f) {
        this.mWeightSum = Math.max(0.0f, f);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public void onMeasure(int i, int i2) {
        if (this.mOrientation == 1) {
            measureVertical(i, i2);
        } else {
            measureHorizontal(i, i2);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean hasDividerBeforeChildAt(int i) {
        if (i == 0) {
            return (this.mShowDividers & 1) != 0;
        }
        int childCount = getChildCount();
        int i2 = this.mShowDividers;
        if (i == childCount) {
            return (i2 & 4) != 0;
        }
        if ((i2 & 2) != 0) {
            for (int i3 = i - 1; i3 >= 0; i3--) {
                if (getChildAt(i3).getVisibility() != 8) {
                    return true;
                }
            }
        }
        return false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:145:0x0306, code lost:
        if (r13.width == (-1)) goto L157;
     */
    /* JADX WARN: Removed duplicated region for block: B:64:0x0168  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x0171  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    void measureVertical(int i, int i2) {
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        int i11;
        float f;
        int i12;
        boolean z;
        int i13;
        int i14;
        View view;
        int i15;
        int i16;
        boolean z2;
        int max;
        int i17;
        int i18;
        int i19;
        this.mTotalLength = 0;
        int virtualChildCount = getVirtualChildCount();
        int mode = View.MeasureSpec.getMode(i);
        int mode2 = View.MeasureSpec.getMode(i2);
        int i20 = this.mBaselineAlignedChildIndex;
        boolean z3 = this.mUseLargestChild;
        int i21 = 0;
        int i22 = 0;
        int i23 = 0;
        int i24 = 0;
        int i25 = 0;
        int i26 = 0;
        boolean z4 = false;
        boolean z5 = false;
        float f2 = 0.0f;
        boolean z6 = true;
        while (true) {
            int i27 = 8;
            if (i21 < virtualChildCount) {
                float f3 = f2;
                View virtualChildAt = getVirtualChildAt(i21);
                if (virtualChildAt == null) {
                    this.mTotalLength += measureNullChild(i21);
                } else if (virtualChildAt.getVisibility() == 8) {
                    i21 += getChildrenSkipCount(virtualChildAt, i21);
                } else {
                    if (hasDividerBeforeChildAt(i21)) {
                        this.mTotalLength += this.mDividerHeight;
                    }
                    LayoutParams layoutParams = (LayoutParams) virtualChildAt.getLayoutParams();
                    float f4 = f3 + layoutParams.weight;
                    if (mode2 == 1073741824 && layoutParams.height == 0 && layoutParams.weight > 0.0f) {
                        int i28 = this.mTotalLength;
                        this.mTotalLength = Math.max(i28, layoutParams.topMargin + i28 + layoutParams.bottomMargin);
                        i12 = virtualChildCount;
                        z = z3;
                        f = f4;
                        z4 = true;
                        view = virtualChildAt;
                        i14 = i22;
                        i13 = i25;
                        i15 = mode2;
                        i16 = i24;
                    } else {
                        if (layoutParams.height != 0 || layoutParams.weight <= 0.0f) {
                            i9 = Integer.MIN_VALUE;
                        } else {
                            layoutParams.height = -2;
                            i9 = 0;
                        }
                        if (f4 == 0.0f) {
                            int i29 = i25;
                            i11 = this.mTotalLength;
                            i10 = i29;
                        } else {
                            i10 = i25;
                            i11 = 0;
                        }
                        int i30 = i23;
                        f = f4;
                        i12 = virtualChildCount;
                        z = z3;
                        i13 = i10;
                        i14 = i22;
                        view = virtualChildAt;
                        i15 = mode2;
                        i16 = i24;
                        measureChildBeforeLayout(view, i21, i, 0, i2, i11);
                        if (i9 != Integer.MIN_VALUE) {
                            layoutParams.height = i9;
                        }
                        int measuredHeight = view.getMeasuredHeight();
                        int i31 = this.mTotalLength;
                        this.mTotalLength = Math.max(i31, i31 + measuredHeight + layoutParams.topMargin + layoutParams.bottomMargin + getNextLocationOffset(view));
                        i23 = z ? Math.max(measuredHeight, i30) : i30;
                    }
                    if (i20 >= 0 && i20 == i21 + 1) {
                        this.mBaselineChildTop = this.mTotalLength;
                    }
                    if (i21 < i20 && layoutParams.weight > 0.0f) {
                        throw new RuntimeException("A child of LinearLayout with index less than mBaselineAlignedChildIndex has weight > 0, which won't work.  Either remove the weight, or don't set mBaselineAlignedChildIndex.");
                    }
                    if (mode == 1073741824 || layoutParams.width != -1) {
                        z2 = false;
                    } else {
                        z2 = true;
                        z5 = true;
                    }
                    int i32 = layoutParams.leftMargin + layoutParams.rightMargin;
                    int measuredWidth = view.getMeasuredWidth() + i32;
                    max = Math.max(i16, measuredWidth);
                    i17 = i23;
                    int combineMeasuredStates = View.combineMeasuredStates(i13, view.getMeasuredState());
                    if (z6) {
                        i18 = combineMeasuredStates;
                        if (layoutParams.width == -1) {
                            z6 = true;
                            if (layoutParams.weight <= 0.0f) {
                                if (!z2) {
                                    i32 = measuredWidth;
                                }
                                i19 = Math.max(i14, i32);
                            } else {
                                if (!z2) {
                                    i32 = measuredWidth;
                                }
                                i26 = Math.max(i26, i32);
                                i19 = i14;
                            }
                            i21 += getChildrenSkipCount(view, i21);
                            f2 = f;
                            i25 = i18;
                            i21++;
                            i22 = i19;
                            i24 = max;
                            i23 = i17;
                            mode2 = i15;
                            z3 = z;
                            virtualChildCount = i12;
                        }
                    } else {
                        i18 = combineMeasuredStates;
                    }
                    z6 = false;
                    if (layoutParams.weight <= 0.0f) {
                    }
                    i21 += getChildrenSkipCount(view, i21);
                    f2 = f;
                    i25 = i18;
                    i21++;
                    i22 = i19;
                    i24 = max;
                    i23 = i17;
                    mode2 = i15;
                    z3 = z;
                    virtualChildCount = i12;
                }
                i17 = i23;
                i12 = virtualChildCount;
                i15 = mode2;
                z = z3;
                f2 = f3;
                i19 = i22;
                max = i24;
                i21++;
                i22 = i19;
                i24 = max;
                i23 = i17;
                mode2 = i15;
                z3 = z;
                virtualChildCount = i12;
            } else {
                float f5 = f2;
                int i33 = i23;
                int i34 = virtualChildCount;
                int i35 = mode2;
                boolean z7 = z3;
                int i36 = i22;
                int i37 = i24;
                int i38 = i25;
                if (this.mTotalLength > 0) {
                    i3 = i34;
                    if (hasDividerBeforeChildAt(i3)) {
                        this.mTotalLength += this.mDividerHeight;
                    }
                } else {
                    i3 = i34;
                }
                int i39 = i35;
                if (z7 && (i39 == Integer.MIN_VALUE || i39 == 0)) {
                    this.mTotalLength = 0;
                    int i40 = 0;
                    while (i40 < i3) {
                        View virtualChildAt2 = getVirtualChildAt(i40);
                        if (virtualChildAt2 == null) {
                            this.mTotalLength += measureNullChild(i40);
                        } else if (virtualChildAt2.getVisibility() == i27) {
                            i40 += getChildrenSkipCount(virtualChildAt2, i40);
                        } else {
                            LayoutParams layoutParams2 = (LayoutParams) virtualChildAt2.getLayoutParams();
                            int i41 = this.mTotalLength;
                            this.mTotalLength = Math.max(i41, i41 + i33 + layoutParams2.topMargin + layoutParams2.bottomMargin + getNextLocationOffset(virtualChildAt2));
                        }
                        i40++;
                        i27 = 8;
                    }
                }
                int paddingTop = this.mTotalLength + getPaddingTop() + getPaddingBottom();
                this.mTotalLength = paddingTop;
                int resolveSizeAndState = View.resolveSizeAndState(Math.max(paddingTop, getSuggestedMinimumHeight()), i2, 0);
                int i42 = (16777215 & resolveSizeAndState) - this.mTotalLength;
                if (z4 || (i42 != 0 && f5 > 0.0f)) {
                    float f6 = this.mWeightSum;
                    if (f6 > 0.0f) {
                        f5 = f6;
                    }
                    this.mTotalLength = 0;
                    int i43 = i42;
                    int i44 = 0;
                    while (i44 < i3) {
                        View virtualChildAt3 = getVirtualChildAt(i44);
                        if (virtualChildAt3.getVisibility() == 8) {
                            i6 = i39;
                            i5 = i44;
                        } else {
                            LayoutParams layoutParams3 = (LayoutParams) virtualChildAt3.getLayoutParams();
                            float f7 = layoutParams3.weight;
                            if (f7 > 0.0f) {
                                int i45 = (int) ((i43 * f7) / f5);
                                f5 -= f7;
                                i43 -= i45;
                                i5 = i44;
                                int childMeasureSpec = getChildMeasureSpec(i, getPaddingLeft() + getPaddingRight() + layoutParams3.leftMargin + layoutParams3.rightMargin, layoutParams3.width);
                                if (layoutParams3.height == 0) {
                                    i8 = 1073741824;
                                    if (i39 == 1073741824) {
                                        if (i45 <= 0) {
                                            i45 = 0;
                                        }
                                        virtualChildAt3.measure(childMeasureSpec, View.MeasureSpec.makeMeasureSpec(i45, 1073741824));
                                        i38 = View.combineMeasuredStates(i38, virtualChildAt3.getMeasuredState() & InputDeviceCompat.SOURCE_ANY);
                                    }
                                } else {
                                    i8 = 1073741824;
                                }
                                int measuredHeight2 = virtualChildAt3.getMeasuredHeight() + i45;
                                if (measuredHeight2 < 0) {
                                    measuredHeight2 = 0;
                                }
                                virtualChildAt3.measure(childMeasureSpec, View.MeasureSpec.makeMeasureSpec(measuredHeight2, i8));
                                i38 = View.combineMeasuredStates(i38, virtualChildAt3.getMeasuredState() & InputDeviceCompat.SOURCE_ANY);
                            } else {
                                i5 = i44;
                            }
                            int i46 = layoutParams3.leftMargin + layoutParams3.rightMargin;
                            int measuredWidth2 = virtualChildAt3.getMeasuredWidth() + i46;
                            i37 = Math.max(i37, measuredWidth2);
                            if (mode != 1073741824) {
                                i6 = i39;
                                i7 = -1;
                            } else {
                                i6 = i39;
                                i7 = -1;
                            }
                            i46 = measuredWidth2;
                            int max2 = Math.max(i26, i46);
                            boolean z8 = z6 && layoutParams3.width == i7;
                            int i47 = this.mTotalLength;
                            this.mTotalLength = Math.max(i47, virtualChildAt3.getMeasuredHeight() + i47 + layoutParams3.topMargin + layoutParams3.bottomMargin + getNextLocationOffset(virtualChildAt3));
                            i26 = max2;
                            z6 = z8;
                        }
                        i44 = i5 + 1;
                        i39 = i6;
                    }
                    this.mTotalLength += getPaddingTop() + getPaddingBottom();
                    i4 = i26;
                } else {
                    i4 = Math.max(i26, i36);
                    if (z7 && i39 != 1073741824) {
                        for (int i48 = 0; i48 < i3; i48++) {
                            View virtualChildAt4 = getVirtualChildAt(i48);
                            if (virtualChildAt4 != null && virtualChildAt4.getVisibility() != 8 && ((LayoutParams) virtualChildAt4.getLayoutParams()).weight > 0.0f) {
                                virtualChildAt4.measure(View.MeasureSpec.makeMeasureSpec(virtualChildAt4.getMeasuredWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(i33, 1073741824));
                            }
                        }
                    }
                }
                if (!z6 && mode != 1073741824) {
                    i37 = i4;
                }
                setMeasuredDimension(View.resolveSizeAndState(Math.max(i37 + getPaddingLeft() + getPaddingRight(), getSuggestedMinimumWidth()), i, i38), resolveSizeAndState);
                if (z5) {
                    forceUniformWidth(i3, i2);
                    return;
                }
                return;
            }
        }
    }

    private void forceUniformWidth(int i, int i2) {
        LinearLayoutCompat linearLayoutCompat;
        int i3;
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 1073741824);
        int i4 = 0;
        while (i4 < i) {
            View virtualChildAt = this.getVirtualChildAt(i4);
            if (virtualChildAt.getVisibility() != 8) {
                LayoutParams layoutParams = (LayoutParams) virtualChildAt.getLayoutParams();
                if (layoutParams.width == -1) {
                    int i5 = layoutParams.height;
                    layoutParams.height = virtualChildAt.getMeasuredHeight();
                    linearLayoutCompat = this;
                    i3 = i2;
                    linearLayoutCompat.measureChildWithMargins(virtualChildAt, makeMeasureSpec, 0, i3, 0);
                    layoutParams.height = i5;
                    i4++;
                    this = linearLayoutCompat;
                    i2 = i3;
                }
            }
            linearLayoutCompat = this;
            i3 = i2;
            i4++;
            this = linearLayoutCompat;
            i2 = i3;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:205:0x0453  */
    /* JADX WARN: Removed duplicated region for block: B:206:0x0456  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    void measureHorizontal(int i, int i2) {
        int i3;
        int i4;
        float f;
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        boolean z;
        int baseline;
        int i11;
        float f2;
        char c;
        int i12;
        boolean z2;
        int i13;
        int i14;
        int i15;
        int[] iArr;
        int i16;
        int i17;
        boolean z3;
        int[] iArr2;
        View view;
        boolean z4;
        boolean z5;
        int baseline2;
        this.mTotalLength = 0;
        int virtualChildCount = getVirtualChildCount();
        int mode = View.MeasureSpec.getMode(i);
        int mode2 = View.MeasureSpec.getMode(i2);
        if (this.mMaxAscent == null || this.mMaxDescent == null) {
            this.mMaxAscent = new int[4];
            this.mMaxDescent = new int[4];
        }
        int[] iArr3 = this.mMaxAscent;
        int[] iArr4 = this.mMaxDescent;
        iArr3[3] = -1;
        iArr3[2] = -1;
        iArr3[1] = -1;
        iArr3[0] = -1;
        iArr4[3] = -1;
        iArr4[2] = -1;
        iArr4[1] = -1;
        iArr4[0] = -1;
        boolean z6 = this.mBaselineAligned;
        boolean z7 = this.mUseLargestChild;
        int i18 = 1073741824;
        boolean z8 = mode == 1073741824;
        boolean z9 = z7;
        int i19 = 0;
        int i20 = 0;
        int i21 = 0;
        boolean z10 = false;
        int i22 = 0;
        boolean z11 = false;
        boolean z12 = true;
        float f3 = 0.0f;
        int i23 = 0;
        int i24 = 0;
        while (true) {
            i3 = i20;
            if (i19 >= virtualChildCount) {
                break;
            }
            boolean z13 = z6;
            View virtualChildAt = getVirtualChildAt(i19);
            if (virtualChildAt == null) {
                this.mTotalLength += measureNullChild(i19);
            } else if (virtualChildAt.getVisibility() == 8) {
                i19 += getChildrenSkipCount(virtualChildAt, i19);
            } else {
                if (hasDividerBeforeChildAt(i19)) {
                    this.mTotalLength += this.mDividerWidth;
                }
                LayoutParams layoutParams = (LayoutParams) virtualChildAt.getLayoutParams();
                float f4 = f3 + layoutParams.weight;
                if (mode == i18 && layoutParams.width == 0 && layoutParams.weight > 0.0f) {
                    int i25 = this.mTotalLength;
                    if (z8) {
                        this.mTotalLength = i25 + layoutParams.leftMargin + layoutParams.rightMargin;
                    } else {
                        this.mTotalLength = Math.max(i25, layoutParams.leftMargin + i25 + layoutParams.rightMargin);
                    }
                    if (z13) {
                        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
                        virtualChildAt.measure(makeMeasureSpec, makeMeasureSpec);
                        i14 = virtualChildCount;
                        i15 = mode;
                        iArr = iArr3;
                        iArr2 = iArr4;
                    } else {
                        i14 = virtualChildCount;
                        i15 = mode;
                        iArr = iArr3;
                        iArr2 = iArr4;
                        z10 = true;
                    }
                    i16 = i3;
                    i17 = 1073741824;
                    z3 = z9;
                    view = virtualChildAt;
                } else {
                    if (layoutParams.width != 0 || layoutParams.weight <= 0.0f) {
                        c = 65534;
                        i12 = Integer.MIN_VALUE;
                    } else {
                        c = 65534;
                        layoutParams.width = -2;
                        i12 = 0;
                    }
                    if (f4 == 0.0f) {
                        z2 = z9;
                        i13 = this.mTotalLength;
                    } else {
                        z2 = z9;
                        i13 = 0;
                    }
                    i14 = virtualChildCount;
                    i15 = mode;
                    iArr = iArr3;
                    i16 = i3;
                    i17 = 1073741824;
                    z3 = z2;
                    iArr2 = iArr4;
                    int i26 = i12;
                    measureChildBeforeLayout(virtualChildAt, i19, i, i13, i2, 0);
                    view = virtualChildAt;
                    if (i26 != Integer.MIN_VALUE) {
                        layoutParams.width = i26;
                    }
                    int measuredWidth = view.getMeasuredWidth();
                    int i27 = this.mTotalLength;
                    if (z8) {
                        this.mTotalLength = i27 + layoutParams.leftMargin + measuredWidth + layoutParams.rightMargin + getNextLocationOffset(view);
                    } else {
                        this.mTotalLength = Math.max(i27, i27 + measuredWidth + layoutParams.leftMargin + layoutParams.rightMargin + getNextLocationOffset(view));
                    }
                    if (z3) {
                        i21 = Math.max(measuredWidth, i21);
                    }
                }
                if (mode2 == i17 || layoutParams.height != -1) {
                    z4 = false;
                } else {
                    z4 = true;
                    z11 = true;
                }
                int i28 = layoutParams.topMargin + layoutParams.bottomMargin;
                int measuredHeight = view.getMeasuredHeight() + i28;
                i22 = View.combineMeasuredStates(i22, view.getMeasuredState());
                if (!z13 || (baseline2 = view.getBaseline()) == -1) {
                    z5 = z4;
                } else {
                    int i29 = ((((layoutParams.gravity < 0 ? this.mGravity : layoutParams.gravity) & 112) >> 4) & (-2)) >> 1;
                    z5 = z4;
                    iArr[i29] = Math.max(iArr[i29], baseline2);
                    iArr2[i29] = Math.max(iArr2[i29], measuredHeight - baseline2);
                }
                int max = Math.max(i16, measuredHeight);
                z12 = z12 && layoutParams.height == -1;
                if (layoutParams.weight > 0.0f) {
                    if (!z5) {
                        i28 = measuredHeight;
                    }
                    i24 = Math.max(i24, i28);
                } else {
                    if (!z5) {
                        i28 = measuredHeight;
                    }
                    i23 = Math.max(i23, i28);
                }
                i19 += getChildrenSkipCount(view, i19);
                i20 = max;
                f3 = f4;
                i19++;
                z9 = z3;
                iArr4 = iArr2;
                z6 = z13;
                mode = i15;
                iArr3 = iArr;
                virtualChildCount = i14;
                i18 = 1073741824;
            }
            i14 = virtualChildCount;
            i15 = mode;
            iArr = iArr3;
            iArr2 = iArr4;
            i20 = i3;
            z3 = z9;
            i19++;
            z9 = z3;
            iArr4 = iArr2;
            z6 = z13;
            mode = i15;
            iArr3 = iArr;
            virtualChildCount = i14;
            i18 = 1073741824;
        }
        boolean z14 = z6;
        int i30 = virtualChildCount;
        int i31 = mode;
        int[] iArr5 = iArr3;
        int[] iArr6 = iArr4;
        int i32 = i22;
        boolean z15 = z9;
        if (this.mTotalLength > 0) {
            i4 = i30;
            if (hasDividerBeforeChildAt(i4)) {
                this.mTotalLength += this.mDividerWidth;
            }
        } else {
            i4 = i30;
        }
        int i33 = iArr5[1];
        int max2 = (i33 == -1 && iArr5[0] == -1 && iArr5[2] == -1 && iArr5[3] == -1) ? i3 : Math.max(i3, Math.max(iArr5[3], Math.max(iArr5[0], Math.max(i33, iArr5[2]))) + Math.max(iArr6[3], Math.max(iArr6[0], Math.max(iArr6[1], iArr6[2]))));
        if (z15) {
            i5 = i31;
            if (i5 == Integer.MIN_VALUE || i5 == 0) {
                this.mTotalLength = 0;
                int i34 = 0;
                while (i34 < i4) {
                    View virtualChildAt2 = getVirtualChildAt(i34);
                    if (virtualChildAt2 == null) {
                        this.mTotalLength += measureNullChild(i34);
                    } else if (virtualChildAt2.getVisibility() == 8) {
                        i34 += getChildrenSkipCount(virtualChildAt2, i34);
                    } else {
                        LayoutParams layoutParams2 = (LayoutParams) virtualChildAt2.getLayoutParams();
                        int i35 = this.mTotalLength;
                        if (z8) {
                            f2 = f3;
                            this.mTotalLength = i35 + layoutParams2.leftMargin + i21 + layoutParams2.rightMargin + getNextLocationOffset(virtualChildAt2);
                        } else {
                            f2 = f3;
                            this.mTotalLength = Math.max(i35, i35 + i21 + layoutParams2.leftMargin + layoutParams2.rightMargin + getNextLocationOffset(virtualChildAt2));
                        }
                        i34++;
                        f3 = f2;
                    }
                    f2 = f3;
                    i34++;
                    f3 = f2;
                }
            }
            f = f3;
        } else {
            f = f3;
            i5 = i31;
        }
        int paddingLeft = this.mTotalLength + getPaddingLeft() + getPaddingRight();
        this.mTotalLength = paddingLeft;
        int resolveSizeAndState = View.resolveSizeAndState(Math.max(paddingLeft, getSuggestedMinimumWidth()), i, 0);
        int i36 = (16777215 & resolveSizeAndState) - this.mTotalLength;
        if (z10 || (i36 != 0 && f > 0.0f)) {
            float f5 = this.mWeightSum;
            if (f5 > 0.0f) {
                f = f5;
            }
            iArr5[3] = -1;
            iArr5[2] = -1;
            iArr5[1] = -1;
            iArr5[0] = -1;
            iArr6[3] = -1;
            iArr6[2] = -1;
            iArr6[1] = -1;
            iArr6[0] = -1;
            this.mTotalLength = 0;
            max2 = -1;
            int i37 = 0;
            while (i37 < i4) {
                View virtualChildAt3 = getVirtualChildAt(i37);
                if (virtualChildAt3 == null || virtualChildAt3.getVisibility() == 8) {
                    i9 = resolveSizeAndState;
                } else {
                    LayoutParams layoutParams3 = (LayoutParams) virtualChildAt3.getLayoutParams();
                    float f6 = layoutParams3.weight;
                    if (f6 > 0.0f) {
                        int i38 = (int) ((i36 * f6) / f);
                        f -= f6;
                        i36 -= i38;
                        i9 = resolveSizeAndState;
                        int childMeasureSpec = getChildMeasureSpec(i2, getPaddingTop() + getPaddingBottom() + layoutParams3.topMargin + layoutParams3.bottomMargin, layoutParams3.height);
                        if (layoutParams3.width == 0) {
                            i11 = 1073741824;
                            if (i5 == 1073741824) {
                                if (i38 <= 0) {
                                    i38 = 0;
                                }
                                virtualChildAt3.measure(View.MeasureSpec.makeMeasureSpec(i38, 1073741824), childMeasureSpec);
                                i32 = View.combineMeasuredStates(i32, virtualChildAt3.getMeasuredState() & (-16777216));
                            }
                        } else {
                            i11 = 1073741824;
                        }
                        int measuredWidth2 = virtualChildAt3.getMeasuredWidth() + i38;
                        if (measuredWidth2 < 0) {
                            measuredWidth2 = 0;
                        }
                        virtualChildAt3.measure(View.MeasureSpec.makeMeasureSpec(measuredWidth2, i11), childMeasureSpec);
                        i32 = View.combineMeasuredStates(i32, virtualChildAt3.getMeasuredState() & (-16777216));
                    } else {
                        i9 = resolveSizeAndState;
                    }
                    int i39 = this.mTotalLength;
                    if (z8) {
                        this.mTotalLength = i39 + virtualChildAt3.getMeasuredWidth() + layoutParams3.leftMargin + layoutParams3.rightMargin + getNextLocationOffset(virtualChildAt3);
                    } else {
                        this.mTotalLength = Math.max(i39, virtualChildAt3.getMeasuredWidth() + i39 + layoutParams3.leftMargin + layoutParams3.rightMargin + getNextLocationOffset(virtualChildAt3));
                    }
                    boolean z16 = mode2 != 1073741824 && layoutParams3.height == -1;
                    int i40 = layoutParams3.topMargin + layoutParams3.bottomMargin;
                    int measuredHeight2 = virtualChildAt3.getMeasuredHeight() + i40;
                    max2 = Math.max(max2, measuredHeight2);
                    if (!z16) {
                        i40 = measuredHeight2;
                    }
                    int max3 = Math.max(i23, i40);
                    if (z12) {
                        i10 = -1;
                        if (layoutParams3.height == -1) {
                            z = true;
                            if (z14 && (baseline = virtualChildAt3.getBaseline()) != i10) {
                                int i41 = ((((layoutParams3.gravity >= 0 ? this.mGravity : layoutParams3.gravity) & 112) >> 4) & (-2)) >> 1;
                                iArr5[i41] = Math.max(iArr5[i41], baseline);
                                iArr6[i41] = Math.max(iArr6[i41], measuredHeight2 - baseline);
                            }
                            i23 = max3;
                            z12 = z;
                        }
                    } else {
                        i10 = -1;
                    }
                    z = false;
                    if (z14) {
                        int i412 = ((((layoutParams3.gravity >= 0 ? this.mGravity : layoutParams3.gravity) & 112) >> 4) & (-2)) >> 1;
                        iArr5[i412] = Math.max(iArr5[i412], baseline);
                        iArr6[i412] = Math.max(iArr6[i412], measuredHeight2 - baseline);
                    }
                    i23 = max3;
                    z12 = z;
                }
                i37++;
                resolveSizeAndState = i9;
            }
            i6 = resolveSizeAndState;
            i7 = -16777216;
            this.mTotalLength += getPaddingLeft() + getPaddingRight();
            int i42 = iArr5[1];
            if (i42 != -1 || iArr5[0] != -1 || iArr5[2] != -1 || iArr5[3] != -1) {
                max2 = Math.max(max2, Math.max(iArr5[3], Math.max(iArr5[0], Math.max(i42, iArr5[2]))) + Math.max(iArr6[3], Math.max(iArr6[0], Math.max(iArr6[1], iArr6[2]))));
            }
            i8 = i23;
        } else {
            i8 = Math.max(i23, i24);
            if (z15 && i5 != 1073741824) {
                for (int i43 = 0; i43 < i4; i43++) {
                    View virtualChildAt4 = getVirtualChildAt(i43);
                    if (virtualChildAt4 != null && virtualChildAt4.getVisibility() != 8 && ((LayoutParams) virtualChildAt4.getLayoutParams()).weight > 0.0f) {
                        virtualChildAt4.measure(View.MeasureSpec.makeMeasureSpec(i21, 1073741824), View.MeasureSpec.makeMeasureSpec(virtualChildAt4.getMeasuredHeight(), 1073741824));
                    }
                }
            }
            i6 = resolveSizeAndState;
            i7 = -16777216;
        }
        int i44 = i32;
        if (!z12 && mode2 != 1073741824) {
            max2 = i8;
        }
        setMeasuredDimension(i6 | (i44 & i7), View.resolveSizeAndState(Math.max(max2 + getPaddingTop() + getPaddingBottom(), getSuggestedMinimumHeight()), i2, i44 << 16));
        if (z11) {
            forceUniformHeight(i4, i);
        }
    }

    private void forceUniformHeight(int i, int i2) {
        LinearLayoutCompat linearLayoutCompat;
        int i3;
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(getMeasuredHeight(), 1073741824);
        int i4 = 0;
        while (i4 < i) {
            View virtualChildAt = this.getVirtualChildAt(i4);
            if (virtualChildAt.getVisibility() != 8) {
                LayoutParams layoutParams = (LayoutParams) virtualChildAt.getLayoutParams();
                if (layoutParams.height == -1) {
                    int i5 = layoutParams.width;
                    layoutParams.width = virtualChildAt.getMeasuredWidth();
                    linearLayoutCompat = this;
                    i3 = i2;
                    linearLayoutCompat.measureChildWithMargins(virtualChildAt, i3, 0, makeMeasureSpec, 0);
                    layoutParams.width = i5;
                    i4++;
                    this = linearLayoutCompat;
                    i2 = i3;
                }
            }
            linearLayoutCompat = this;
            i3 = i2;
            i4++;
            this = linearLayoutCompat;
            i2 = i3;
        }
    }

    void measureChildBeforeLayout(View view, int i, int i2, int i3, int i4, int i5) {
        measureChildWithMargins(view, i2, i3, i4, i5);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        if (this.mOrientation == 1) {
            layoutVertical(i, i2, i3, i4);
        } else {
            layoutHorizontal(i, i2, i3, i4);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x0097  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    void layoutVertical(int i, int i2, int i3, int i4) {
        int paddingTop;
        int i5;
        int i6;
        int i7;
        LinearLayoutCompat linearLayoutCompat;
        int paddingLeft = getPaddingLeft();
        int i8 = i3 - i;
        int paddingRight = i8 - getPaddingRight();
        int paddingRight2 = (i8 - paddingLeft) - getPaddingRight();
        int virtualChildCount = getVirtualChildCount();
        int i9 = this.mGravity;
        int i10 = i9 & 112;
        int i11 = i9 & GravityCompat.RELATIVE_HORIZONTAL_GRAVITY_MASK;
        if (i10 == 16) {
            paddingTop = getPaddingTop() + (((i4 - i2) - this.mTotalLength) / 2);
        } else if (i10 == 80) {
            paddingTop = ((getPaddingTop() + i4) - i2) - this.mTotalLength;
        } else {
            paddingTop = getPaddingTop();
        }
        int i12 = 0;
        while (i12 < virtualChildCount) {
            View virtualChildAt = this.getVirtualChildAt(i12);
            if (virtualChildAt == null) {
                paddingTop += this.measureNullChild(i12);
            } else if (virtualChildAt.getVisibility() != 8) {
                int measuredWidth = virtualChildAt.getMeasuredWidth();
                int measuredHeight = virtualChildAt.getMeasuredHeight();
                LayoutParams layoutParams = (LayoutParams) virtualChildAt.getLayoutParams();
                int i13 = layoutParams.gravity;
                if (i13 < 0) {
                    i13 = i11;
                }
                int absoluteGravity = GravityCompat.getAbsoluteGravity(i13, this.getLayoutDirection()) & 7;
                if (absoluteGravity == 1) {
                    i5 = ((paddingRight2 - measuredWidth) / 2) + paddingLeft + layoutParams.leftMargin;
                    i6 = layoutParams.rightMargin;
                } else if (absoluteGravity == 5) {
                    i5 = paddingRight - measuredWidth;
                    i6 = layoutParams.rightMargin;
                } else {
                    i7 = layoutParams.leftMargin + paddingLeft;
                    int i14 = i7;
                    if (this.hasDividerBeforeChildAt(i12)) {
                        paddingTop += this.mDividerHeight;
                    }
                    int i15 = paddingTop + layoutParams.topMargin;
                    linearLayoutCompat = this;
                    linearLayoutCompat.setChildFrame(virtualChildAt, i14, i15 + this.getLocationOffset(virtualChildAt), measuredWidth, measuredHeight);
                    paddingTop = i15 + measuredHeight + layoutParams.bottomMargin + linearLayoutCompat.getNextLocationOffset(virtualChildAt);
                    i12 += linearLayoutCompat.getChildrenSkipCount(virtualChildAt, i12);
                    i12++;
                    this = linearLayoutCompat;
                }
                i7 = i5 - i6;
                int i142 = i7;
                if (this.hasDividerBeforeChildAt(i12)) {
                }
                int i152 = paddingTop + layoutParams.topMargin;
                linearLayoutCompat = this;
                linearLayoutCompat.setChildFrame(virtualChildAt, i142, i152 + this.getLocationOffset(virtualChildAt), measuredWidth, measuredHeight);
                paddingTop = i152 + measuredHeight + layoutParams.bottomMargin + linearLayoutCompat.getNextLocationOffset(virtualChildAt);
                i12 += linearLayoutCompat.getChildrenSkipCount(virtualChildAt, i12);
                i12++;
                this = linearLayoutCompat;
            }
            linearLayoutCompat = this;
            i12++;
            this = linearLayoutCompat;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x00b6  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00bf  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00ec  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00ff  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0104  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    void layoutHorizontal(int i, int i2, int i3, int i4) {
        int paddingLeft;
        int i5;
        int i6;
        char c;
        char c2;
        int i7;
        int i8;
        int i9;
        int i10;
        int i11;
        int i12;
        int i13;
        int i14;
        boolean isLayoutRtl = ViewUtils.isLayoutRtl(this);
        int paddingTop = getPaddingTop();
        int i15 = i4 - i2;
        int paddingBottom = i15 - getPaddingBottom();
        int paddingBottom2 = (i15 - paddingTop) - getPaddingBottom();
        int virtualChildCount = getVirtualChildCount();
        int i16 = this.mGravity;
        int i17 = i16 & 112;
        boolean z = this.mBaselineAligned;
        int[] iArr = this.mMaxAscent;
        int[] iArr2 = this.mMaxDescent;
        int absoluteGravity = GravityCompat.getAbsoluteGravity(8388615 & i16, getLayoutDirection());
        char c3 = 2;
        char c4 = 1;
        if (absoluteGravity == 1) {
            paddingLeft = getPaddingLeft() + (((i3 - i) - this.mTotalLength) / 2);
        } else if (absoluteGravity == 5) {
            paddingLeft = ((getPaddingLeft() + i3) - i) - this.mTotalLength;
        } else {
            paddingLeft = getPaddingLeft();
        }
        if (isLayoutRtl) {
            i5 = virtualChildCount - 1;
            i6 = -1;
        } else {
            i5 = 0;
            i6 = 1;
        }
        int i18 = 0;
        while (i18 < virtualChildCount) {
            int i19 = i5 + (i6 * i18);
            int i20 = i18;
            View virtualChildAt = getVirtualChildAt(i19);
            if (virtualChildAt == null) {
                paddingLeft += measureNullChild(i19);
                i8 = i20;
                i7 = paddingTop;
                c = c3;
                c2 = c4;
            } else {
                c = c3;
                c2 = c4;
                if (virtualChildAt.getVisibility() != 8) {
                    int measuredWidth = virtualChildAt.getMeasuredWidth();
                    int measuredHeight = virtualChildAt.getMeasuredHeight();
                    LayoutParams layoutParams = (LayoutParams) virtualChildAt.getLayoutParams();
                    int i21 = paddingLeft;
                    if (z) {
                        i9 = measuredHeight;
                        if (layoutParams.height != -1) {
                            i10 = virtualChildAt.getBaseline();
                            i11 = layoutParams.gravity;
                            if (i11 < 0) {
                                i11 = i17;
                            }
                            i12 = i11 & 112;
                            i7 = paddingTop;
                            if (i12 != 16) {
                                i13 = i7 + ((paddingBottom2 - i9) / 2) + layoutParams.topMargin;
                                i14 = layoutParams.bottomMargin;
                            } else {
                                if (i12 == 48) {
                                    i13 = i7 + layoutParams.topMargin;
                                    if (i10 != -1) {
                                        i13 += iArr[c2] - i10;
                                    }
                                } else if (i12 != 80) {
                                    i13 = i7;
                                } else {
                                    i13 = (paddingBottom - i9) - layoutParams.bottomMargin;
                                    if (i10 != -1) {
                                        i14 = iArr2[c] - (virtualChildAt.getMeasuredHeight() - i10);
                                    }
                                }
                                int i22 = layoutParams.leftMargin + (hasDividerBeforeChildAt(i19) ? i21 + this.mDividerWidth : i21);
                                setChildFrame(virtualChildAt, getLocationOffset(virtualChildAt) + i22, i13, measuredWidth, i9);
                                i8 = getChildrenSkipCount(virtualChildAt, i19) + i20;
                                paddingLeft = i22 + layoutParams.rightMargin + measuredWidth + getNextLocationOffset(virtualChildAt);
                            }
                            i13 -= i14;
                            int i222 = layoutParams.leftMargin + (hasDividerBeforeChildAt(i19) ? i21 + this.mDividerWidth : i21);
                            setChildFrame(virtualChildAt, getLocationOffset(virtualChildAt) + i222, i13, measuredWidth, i9);
                            i8 = getChildrenSkipCount(virtualChildAt, i19) + i20;
                            paddingLeft = i222 + layoutParams.rightMargin + measuredWidth + getNextLocationOffset(virtualChildAt);
                        }
                    } else {
                        i9 = measuredHeight;
                    }
                    i10 = -1;
                    i11 = layoutParams.gravity;
                    if (i11 < 0) {
                    }
                    i12 = i11 & 112;
                    i7 = paddingTop;
                    if (i12 != 16) {
                    }
                    i13 -= i14;
                    int i2222 = layoutParams.leftMargin + (hasDividerBeforeChildAt(i19) ? i21 + this.mDividerWidth : i21);
                    setChildFrame(virtualChildAt, getLocationOffset(virtualChildAt) + i2222, i13, measuredWidth, i9);
                    i8 = getChildrenSkipCount(virtualChildAt, i19) + i20;
                    paddingLeft = i2222 + layoutParams.rightMargin + measuredWidth + getNextLocationOffset(virtualChildAt);
                } else {
                    i7 = paddingTop;
                    i8 = i20;
                }
            }
            i18 = i8 + 1;
            c3 = c;
            c4 = c2;
            paddingTop = i7;
        }
    }

    private void setChildFrame(View view, int i, int i2, int i3, int i4) {
        view.layout(i, i2, i3 + i, i4 + i2);
    }

    public void setOrientation(int i) {
        if (this.mOrientation != i) {
            this.mOrientation = i;
            requestLayout();
        }
    }

    public int getOrientation() {
        return this.mOrientation;
    }

    public void setGravity(int i) {
        if (this.mGravity != i) {
            if ((8388615 & i) == 0) {
                i |= GravityCompat.START;
            }
            if ((i & 112) == 0) {
                i |= 48;
            }
            this.mGravity = i;
            requestLayout();
        }
    }

    public int getGravity() {
        return this.mGravity;
    }

    public void setHorizontalGravity(int i) {
        int i2 = i & GravityCompat.RELATIVE_HORIZONTAL_GRAVITY_MASK;
        int i3 = this.mGravity;
        if ((8388615 & i3) != i2) {
            this.mGravity = i2 | ((-8388616) & i3);
            requestLayout();
        }
    }

    public void setVerticalGravity(int i) {
        int i2 = i & 112;
        int i3 = this.mGravity;
        if ((i3 & 112) != i2) {
            this.mGravity = i2 | (i3 & (-113));
            requestLayout();
        }
    }

    @Override // android.view.ViewGroup
    public LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup
    public LayoutParams generateDefaultLayoutParams() {
        int i = this.mOrientation;
        if (i == 0) {
            return new LayoutParams(-2, -2);
        }
        if (i == 1) {
            return new LayoutParams(-1, -2);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup
    public LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        if (layoutParams instanceof LayoutParams) {
            return new LayoutParams((ViewGroup.MarginLayoutParams) ((LayoutParams) layoutParams));
        }
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            return new LayoutParams((ViewGroup.MarginLayoutParams) layoutParams);
        }
        return new LayoutParams(layoutParams);
    }

    @Override // android.view.ViewGroup
    protected boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof LayoutParams;
    }

    @Override // android.view.View
    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setClassName(ACCESSIBILITY_CLASS_NAME);
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName(ACCESSIBILITY_CLASS_NAME);
    }

    /* loaded from: classes.dex */
    public static class LayoutParams extends LinearLayout.LayoutParams {
        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public LayoutParams(int i, int i2) {
            super(i, i2);
        }

        public LayoutParams(int i, int i2, float f) {
            super(i, i2, f);
        }

        public LayoutParams(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }

        public LayoutParams(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
        }
    }
}
