package com.google.android.flexbox;

import android.graphics.drawable.Drawable;
import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import androidx.core.view.MarginLayoutParamsCompat;
import androidx.core.widget.CompoundButtonCompat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public class FlexboxHelper {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final int INITIAL_CAPACITY = 10;
    private static final long MEASURE_SPEC_WIDTH_MASK = 4294967295L;
    private boolean[] mChildrenFrozen;
    private final FlexContainer mFlexContainer;
    int[] mIndexToFlexLine;
    long[] mMeasureSpecCache;
    private long[] mMeasuredSizeCache;

    /* JADX INFO: Access modifiers changed from: package-private */
    public int extractHigherInt(long longValue) {
        return (int) (longValue >> 32);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int extractLowerInt(long longValue) {
        return (int) longValue;
    }

    long makeCombinedLong(int widthMeasureSpec, int heightMeasureSpec) {
        return (widthMeasureSpec & MEASURE_SPEC_WIDTH_MASK) | (heightMeasureSpec << 32);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public FlexboxHelper(FlexContainer flexContainer) {
        this.mFlexContainer = flexContainer;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int[] createReorderedIndices(View viewBeforeAdded, int indexForViewBeforeAdded, ViewGroup.LayoutParams paramsForViewBeforeAdded, SparseIntArray orderCache) {
        int flexItemCount = this.mFlexContainer.getFlexItemCount();
        List<Order> createOrders = createOrders(flexItemCount);
        Order order = new Order();
        if (viewBeforeAdded != null && (paramsForViewBeforeAdded instanceof FlexItem)) {
            order.order = ((FlexItem) paramsForViewBeforeAdded).getOrder();
        } else {
            order.order = 1;
        }
        if (indexForViewBeforeAdded == -1 || indexForViewBeforeAdded == flexItemCount) {
            order.index = flexItemCount;
        } else if (indexForViewBeforeAdded < this.mFlexContainer.getFlexItemCount()) {
            order.index = indexForViewBeforeAdded;
            while (indexForViewBeforeAdded < flexItemCount) {
                createOrders.get(indexForViewBeforeAdded).index++;
                indexForViewBeforeAdded++;
            }
        } else {
            order.index = flexItemCount;
        }
        createOrders.add(order);
        return sortOrdersIntoReorderedIndices(flexItemCount + 1, createOrders, orderCache);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int[] createReorderedIndices(SparseIntArray orderCache) {
        int flexItemCount = this.mFlexContainer.getFlexItemCount();
        return sortOrdersIntoReorderedIndices(flexItemCount, createOrders(flexItemCount), orderCache);
    }

    private List<Order> createOrders(int childCount) {
        ArrayList arrayList = new ArrayList(childCount);
        for (int i = 0; i < childCount; i++) {
            Order order = new Order();
            order.order = ((FlexItem) this.mFlexContainer.getFlexItemAt(i).getLayoutParams()).getOrder();
            order.index = i;
            arrayList.add(order);
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean isOrderChangedFromLastMeasurement(SparseIntArray orderCache) {
        int flexItemCount = this.mFlexContainer.getFlexItemCount();
        if (orderCache.size() != flexItemCount) {
            return true;
        }
        for (int i = 0; i < flexItemCount; i++) {
            View flexItemAt = this.mFlexContainer.getFlexItemAt(i);
            if (flexItemAt != null && ((FlexItem) flexItemAt.getLayoutParams()).getOrder() != orderCache.get(i)) {
                return true;
            }
        }
        return false;
    }

    private int[] sortOrdersIntoReorderedIndices(int childCount, List<Order> orders, SparseIntArray orderCache) {
        Collections.sort(orders);
        orderCache.clear();
        int[] iArr = new int[childCount];
        int i = 0;
        for (Order order : orders) {
            iArr[i] = order.index;
            orderCache.append(order.index, order.order);
            i++;
        }
        return iArr;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void calculateHorizontalFlexLines(FlexLinesResult result, int widthMeasureSpec, int heightMeasureSpec) {
        calculateFlexLines(result, widthMeasureSpec, heightMeasureSpec, Integer.MAX_VALUE, 0, -1, null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void calculateHorizontalFlexLines(FlexLinesResult result, int widthMeasureSpec, int heightMeasureSpec, int needsCalcAmount, int fromIndex, List<FlexLine> existingLines) {
        calculateFlexLines(result, widthMeasureSpec, heightMeasureSpec, needsCalcAmount, fromIndex, -1, existingLines);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void calculateHorizontalFlexLinesToIndex(FlexLinesResult result, int widthMeasureSpec, int heightMeasureSpec, int needsCalcAmount, int toIndex, List<FlexLine> existingLines) {
        calculateFlexLines(result, widthMeasureSpec, heightMeasureSpec, needsCalcAmount, 0, toIndex, existingLines);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void calculateVerticalFlexLines(FlexLinesResult result, int widthMeasureSpec, int heightMeasureSpec) {
        calculateFlexLines(result, heightMeasureSpec, widthMeasureSpec, Integer.MAX_VALUE, 0, -1, null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void calculateVerticalFlexLines(FlexLinesResult result, int widthMeasureSpec, int heightMeasureSpec, int needsCalcAmount, int fromIndex, List<FlexLine> existingLines) {
        calculateFlexLines(result, heightMeasureSpec, widthMeasureSpec, needsCalcAmount, fromIndex, -1, existingLines);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void calculateVerticalFlexLinesToIndex(FlexLinesResult result, int widthMeasureSpec, int heightMeasureSpec, int needsCalcAmount, int toIndex, List<FlexLine> existingLines) {
        calculateFlexLines(result, heightMeasureSpec, widthMeasureSpec, needsCalcAmount, 0, toIndex, existingLines);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Multi-variable type inference failed */
    public void calculateFlexLines(FlexLinesResult result, int mainMeasureSpec, int crossMeasureSpec, int needsCalcAmount, int fromIndex, int toIndex, List<FlexLine> existingLines) {
        int i;
        FlexLinesResult flexLinesResult;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        FlexLine flexLine;
        int i11;
        int i12;
        boolean z;
        int i13;
        boolean z2;
        int i14;
        int i15 = mainMeasureSpec;
        boolean isMainAxisDirectionHorizontal = this.mFlexContainer.isMainAxisDirectionHorizontal();
        int mode = View.MeasureSpec.getMode(i15);
        int size = View.MeasureSpec.getSize(i15);
        ArrayList arrayList = existingLines == null ? new ArrayList() : existingLines;
        result.mFlexLines = arrayList;
        boolean z3 = toIndex == -1;
        int paddingStartMain = getPaddingStartMain(isMainAxisDirectionHorizontal);
        int paddingEndMain = getPaddingEndMain(isMainAxisDirectionHorizontal);
        int paddingStartCross = getPaddingStartCross(isMainAxisDirectionHorizontal);
        int paddingEndCross = getPaddingEndCross(isMainAxisDirectionHorizontal);
        FlexLine flexLine2 = new FlexLine();
        int i16 = fromIndex;
        flexLine2.mFirstIndex = i16;
        int i17 = paddingStartMain + paddingEndMain;
        flexLine2.mMainSize = i17;
        int flexItemCount = this.mFlexContainer.getFlexItemCount();
        boolean z4 = z3;
        FlexLine flexLine3 = flexLine2;
        int i18 = Integer.MIN_VALUE;
        int i19 = 0;
        int i20 = 0;
        int i21 = 0;
        while (true) {
            if (i16 >= flexItemCount) {
                i = i20;
                flexLinesResult = result;
                break;
            }
            View reorderedFlexItemAt = this.mFlexContainer.getReorderedFlexItemAt(i16);
            if (reorderedFlexItemAt == null) {
                if (isLastFlexItem(i16, flexItemCount, flexLine3)) {
                    addFlexLine(arrayList, flexLine3, i16, i19);
                }
                i2 = i17;
            } else {
                i2 = i17;
                if (reorderedFlexItemAt.getVisibility() == 8) {
                    flexLine3.mGoneItemCount++;
                    flexLine3.mItemCount++;
                    if (isLastFlexItem(i16, flexItemCount, flexLine3)) {
                        addFlexLine(arrayList, flexLine3, i16, i19);
                    }
                } else {
                    if (reorderedFlexItemAt instanceof CompoundButton) {
                        evaluateMinimumSizeForCompoundButton((CompoundButton) reorderedFlexItemAt);
                    }
                    FlexItem flexItem = (FlexItem) reorderedFlexItemAt.getLayoutParams();
                    int i22 = flexItemCount;
                    if (flexItem.getAlignSelf() == 4) {
                        flexLine3.mIndicesAlignSelfStretch.add(Integer.valueOf(i16));
                    }
                    int flexItemSizeMain = getFlexItemSizeMain(flexItem, isMainAxisDirectionHorizontal);
                    if (flexItem.getFlexBasisPercent() != -1.0f && mode == 1073741824) {
                        flexItemSizeMain = Math.round(size * flexItem.getFlexBasisPercent());
                    }
                    FlexContainer flexContainer = this.mFlexContainer;
                    if (isMainAxisDirectionHorizontal) {
                        i4 = mode;
                        i7 = flexContainer.getChildWidthMeasureSpec(i15, i2 + getFlexItemMarginStartMain(flexItem, true) + getFlexItemMarginEndMain(flexItem, true), flexItemSizeMain);
                        i3 = size;
                        i5 = i19;
                        int childHeightMeasureSpec = this.mFlexContainer.getChildHeightMeasureSpec(crossMeasureSpec, paddingStartCross + paddingEndCross + getFlexItemMarginStartCross(flexItem, true) + getFlexItemMarginEndCross(flexItem, true) + i19, getFlexItemSizeCross(flexItem, true));
                        reorderedFlexItemAt.measure(i7, childHeightMeasureSpec);
                        updateMeasureCache(i16, i7, childHeightMeasureSpec, reorderedFlexItemAt);
                        i6 = 0;
                    } else {
                        i3 = size;
                        i4 = mode;
                        i5 = i19;
                        i6 = 0;
                        int childWidthMeasureSpec = flexContainer.getChildWidthMeasureSpec(crossMeasureSpec, paddingStartCross + paddingEndCross + getFlexItemMarginStartCross(flexItem, false) + getFlexItemMarginEndCross(flexItem, false) + i5, getFlexItemSizeCross(flexItem, false));
                        int childHeightMeasureSpec2 = this.mFlexContainer.getChildHeightMeasureSpec(i15, i2 + getFlexItemMarginStartMain(flexItem, false) + getFlexItemMarginEndMain(flexItem, false), flexItemSizeMain);
                        reorderedFlexItemAt.measure(childWidthMeasureSpec, childHeightMeasureSpec2);
                        updateMeasureCache(i16, childWidthMeasureSpec, childHeightMeasureSpec2, reorderedFlexItemAt);
                        i7 = childHeightMeasureSpec2;
                    }
                    this.mFlexContainer.updateViewCache(i16, reorderedFlexItemAt);
                    checkSizeConstraints(reorderedFlexItemAt, i16);
                    i20 = View.combineMeasuredStates(i20, reorderedFlexItemAt.getMeasuredState());
                    int i23 = i6;
                    i8 = i16;
                    int i24 = i7;
                    FlexLine flexLine4 = flexLine3;
                    int i25 = i21;
                    i9 = i2;
                    i10 = i5;
                    boolean z5 = isMainAxisDirectionHorizontal;
                    size = i3;
                    if (isWrapRequired(reorderedFlexItemAt, i4, size, flexLine3.mMainSize, getViewMeasuredSizeMain(reorderedFlexItemAt, isMainAxisDirectionHorizontal) + getFlexItemMarginStartMain(flexItem, isMainAxisDirectionHorizontal) + getFlexItemMarginEndMain(flexItem, isMainAxisDirectionHorizontal), flexItem, i8, i25, arrayList.size())) {
                        if (flexLine4.getItemCountNotGone() > 0) {
                            addFlexLine(arrayList, flexLine4, i8 > 0 ? i8 - 1 : i23, i10);
                            i14 = i10 + flexLine4.mCrossSize;
                        } else {
                            i14 = i10;
                        }
                        if (z5) {
                            if (flexItem.getHeight() == -1) {
                                FlexContainer flexContainer2 = this.mFlexContainer;
                                reorderedFlexItemAt.measure(i24, flexContainer2.getChildHeightMeasureSpec(crossMeasureSpec, flexContainer2.getPaddingTop() + this.mFlexContainer.getPaddingBottom() + flexItem.getMarginTop() + flexItem.getMarginBottom() + i14, flexItem.getHeight()));
                                checkSizeConstraints(reorderedFlexItemAt, i8);
                            }
                        } else if (flexItem.getWidth() == -1) {
                            FlexContainer flexContainer3 = this.mFlexContainer;
                            reorderedFlexItemAt.measure(flexContainer3.getChildWidthMeasureSpec(crossMeasureSpec, flexContainer3.getPaddingLeft() + this.mFlexContainer.getPaddingRight() + flexItem.getMarginLeft() + flexItem.getMarginRight() + i14, flexItem.getWidth()), i24);
                            checkSizeConstraints(reorderedFlexItemAt, i8);
                        }
                        FlexLine flexLine5 = new FlexLine();
                        flexLine5.mItemCount = 1;
                        flexLine5.mMainSize = i9;
                        flexLine5.mFirstIndex = i8;
                        i10 = i14;
                        i11 = i23;
                        flexLine = flexLine5;
                        i12 = Integer.MIN_VALUE;
                    } else {
                        flexLine = flexLine4;
                        flexLine.mItemCount++;
                        i11 = i25 + 1;
                        i12 = i18;
                    }
                    flexLine.mAnyItemsHaveFlexGrow = (flexLine.mAnyItemsHaveFlexGrow ? 1 : 0) | (flexItem.getFlexGrow() != 0.0f ? 1 : i23);
                    flexLine.mAnyItemsHaveFlexShrink = (flexLine.mAnyItemsHaveFlexShrink ? 1 : 0) | (flexItem.getFlexShrink() != 0.0f ? 1 : i23);
                    int[] iArr = this.mIndexToFlexLine;
                    if (iArr != null) {
                        iArr[i8] = arrayList.size();
                    }
                    z = z5;
                    flexLine.mMainSize += getViewMeasuredSizeMain(reorderedFlexItemAt, z) + getFlexItemMarginStartMain(flexItem, z) + getFlexItemMarginEndMain(flexItem, z);
                    flexLine.mTotalFlexGrow += flexItem.getFlexGrow();
                    flexLine.mTotalFlexShrink += flexItem.getFlexShrink();
                    this.mFlexContainer.onNewFlexItemAdded(reorderedFlexItemAt, i8, i11, flexLine);
                    int max = Math.max(i12, getViewMeasuredSizeCross(reorderedFlexItemAt, z) + getFlexItemMarginStartCross(flexItem, z) + getFlexItemMarginEndCross(flexItem, z) + this.mFlexContainer.getDecorationLengthCrossAxis(reorderedFlexItemAt));
                    flexLine.mCrossSize = Math.max(flexLine.mCrossSize, max);
                    if (z) {
                        if (this.mFlexContainer.getFlexWrap() != 2) {
                            flexLine.mMaxBaseline = Math.max(flexLine.mMaxBaseline, reorderedFlexItemAt.getBaseline() + flexItem.getMarginTop());
                        } else {
                            flexLine.mMaxBaseline = Math.max(flexLine.mMaxBaseline, (reorderedFlexItemAt.getMeasuredHeight() - reorderedFlexItemAt.getBaseline()) + flexItem.getMarginBottom());
                        }
                    }
                    i13 = i22;
                    if (isLastFlexItem(i8, i13, flexLine)) {
                        addFlexLine(arrayList, flexLine, i8, i10);
                        i10 += flexLine.mCrossSize;
                    }
                    if (toIndex != -1 && arrayList.size() > 0) {
                        if (arrayList.get(arrayList.size() - 1).mLastIndex >= toIndex && i8 >= toIndex && !z4) {
                            i10 = -flexLine.getCrossSize();
                            z2 = true;
                            if (i10 <= needsCalcAmount && z2) {
                                flexLinesResult = result;
                                i = i20;
                                break;
                            }
                            i18 = max;
                            z4 = z2;
                            i21 = i11;
                            int i26 = i8 + 1;
                            isMainAxisDirectionHorizontal = z;
                            flexLine3 = flexLine;
                            i17 = i9;
                            i19 = i10;
                            i15 = mainMeasureSpec;
                            flexItemCount = i13;
                            i16 = i26;
                            mode = i4;
                        }
                    }
                    z2 = z4;
                    if (i10 <= needsCalcAmount) {
                    }
                    i18 = max;
                    z4 = z2;
                    i21 = i11;
                    int i262 = i8 + 1;
                    isMainAxisDirectionHorizontal = z;
                    flexLine3 = flexLine;
                    i17 = i9;
                    i19 = i10;
                    i15 = mainMeasureSpec;
                    flexItemCount = i13;
                    i16 = i262;
                    mode = i4;
                }
            }
            i8 = i16;
            i4 = mode;
            i13 = flexItemCount;
            i10 = i19;
            z = isMainAxisDirectionHorizontal;
            i9 = i2;
            flexLine = flexLine3;
            int i2622 = i8 + 1;
            isMainAxisDirectionHorizontal = z;
            flexLine3 = flexLine;
            i17 = i9;
            i19 = i10;
            i15 = mainMeasureSpec;
            flexItemCount = i13;
            i16 = i2622;
            mode = i4;
        }
        flexLinesResult.mChildState = i;
    }

    private void evaluateMinimumSizeForCompoundButton(CompoundButton compoundButton) {
        FlexItem flexItem = (FlexItem) compoundButton.getLayoutParams();
        int minWidth = flexItem.getMinWidth();
        int minHeight = flexItem.getMinHeight();
        Drawable buttonDrawable = CompoundButtonCompat.getButtonDrawable(compoundButton);
        int minimumWidth = buttonDrawable == null ? 0 : buttonDrawable.getMinimumWidth();
        int minimumHeight = buttonDrawable != null ? buttonDrawable.getMinimumHeight() : 0;
        if (minWidth == -1) {
            minWidth = minimumWidth;
        }
        flexItem.setMinWidth(minWidth);
        if (minHeight == -1) {
            minHeight = minimumHeight;
        }
        flexItem.setMinHeight(minHeight);
    }

    private int getPaddingStartMain(boolean isMainHorizontal) {
        FlexContainer flexContainer = this.mFlexContainer;
        if (isMainHorizontal) {
            return flexContainer.getPaddingStart();
        }
        return flexContainer.getPaddingTop();
    }

    private int getPaddingEndMain(boolean isMainHorizontal) {
        FlexContainer flexContainer = this.mFlexContainer;
        if (isMainHorizontal) {
            return flexContainer.getPaddingEnd();
        }
        return flexContainer.getPaddingBottom();
    }

    private int getPaddingStartCross(boolean isMainHorizontal) {
        FlexContainer flexContainer = this.mFlexContainer;
        if (isMainHorizontal) {
            return flexContainer.getPaddingTop();
        }
        return flexContainer.getPaddingStart();
    }

    private int getPaddingEndCross(boolean isMainHorizontal) {
        FlexContainer flexContainer = this.mFlexContainer;
        if (isMainHorizontal) {
            return flexContainer.getPaddingBottom();
        }
        return flexContainer.getPaddingEnd();
    }

    private int getViewMeasuredSizeMain(View view, boolean isMainHorizontal) {
        if (isMainHorizontal) {
            return view.getMeasuredWidth();
        }
        return view.getMeasuredHeight();
    }

    private int getViewMeasuredSizeCross(View view, boolean isMainHorizontal) {
        if (isMainHorizontal) {
            return view.getMeasuredHeight();
        }
        return view.getMeasuredWidth();
    }

    private int getFlexItemSizeMain(FlexItem flexItem, boolean isMainHorizontal) {
        if (isMainHorizontal) {
            return flexItem.getWidth();
        }
        return flexItem.getHeight();
    }

    private int getFlexItemSizeCross(FlexItem flexItem, boolean isMainHorizontal) {
        if (isMainHorizontal) {
            return flexItem.getHeight();
        }
        return flexItem.getWidth();
    }

    private int getFlexItemMarginStartMain(FlexItem flexItem, boolean isMainHorizontal) {
        if (isMainHorizontal) {
            return flexItem.getMarginLeft();
        }
        return flexItem.getMarginTop();
    }

    private int getFlexItemMarginEndMain(FlexItem flexItem, boolean isMainHorizontal) {
        if (isMainHorizontal) {
            return flexItem.getMarginRight();
        }
        return flexItem.getMarginBottom();
    }

    private int getFlexItemMarginStartCross(FlexItem flexItem, boolean isMainHorizontal) {
        if (isMainHorizontal) {
            return flexItem.getMarginTop();
        }
        return flexItem.getMarginLeft();
    }

    private int getFlexItemMarginEndCross(FlexItem flexItem, boolean isMainHorizontal) {
        if (isMainHorizontal) {
            return flexItem.getMarginBottom();
        }
        return flexItem.getMarginRight();
    }

    private boolean isWrapRequired(View view, int mode, int maxSize, int currentLength, int childLength, FlexItem flexItem, int index, int indexInFlexLine, int flexLinesSize) {
        if (this.mFlexContainer.getFlexWrap() == 0) {
            return false;
        }
        if (flexItem.isWrapBefore()) {
            return true;
        }
        if (mode == 0) {
            return false;
        }
        int maxLine = this.mFlexContainer.getMaxLine();
        if (maxLine == -1 || maxLine > flexLinesSize + 1) {
            int decorationLengthMainAxis = this.mFlexContainer.getDecorationLengthMainAxis(view, index, indexInFlexLine);
            if (decorationLengthMainAxis > 0) {
                childLength += decorationLengthMainAxis;
            }
            return maxSize < currentLength + childLength;
        }
        return false;
    }

    private boolean isLastFlexItem(int childIndex, int childCount, FlexLine flexLine) {
        return childIndex == childCount - 1 && flexLine.getItemCountNotGone() != 0;
    }

    private void addFlexLine(List<FlexLine> flexLines, FlexLine flexLine, int viewIndex, int usedCrossSizeSoFar) {
        flexLine.mSumCrossSizeBefore = usedCrossSizeSoFar;
        this.mFlexContainer.onNewFlexLineAdded(flexLine);
        flexLine.mLastIndex = viewIndex;
        flexLines.add(flexLine);
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x002d  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0032  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0040  */
    /* JADX WARN: Removed duplicated region for block: B:20:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void checkSizeConstraints(View view, int index) {
        boolean z;
        FlexItem flexItem = (FlexItem) view.getLayoutParams();
        int measuredWidth = view.getMeasuredWidth();
        int measuredHeight = view.getMeasuredHeight();
        boolean z2 = true;
        if (measuredWidth < flexItem.getMinWidth()) {
            measuredWidth = flexItem.getMinWidth();
        } else if (measuredWidth > flexItem.getMaxWidth()) {
            measuredWidth = flexItem.getMaxWidth();
        } else {
            z = false;
            if (measuredHeight >= flexItem.getMinHeight()) {
                measuredHeight = flexItem.getMinHeight();
            } else if (measuredHeight > flexItem.getMaxHeight()) {
                measuredHeight = flexItem.getMaxHeight();
            } else {
                z2 = z;
            }
            if (z2) {
                return;
            }
            int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(measuredWidth, 1073741824);
            int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(measuredHeight, 1073741824);
            view.measure(makeMeasureSpec, makeMeasureSpec2);
            updateMeasureCache(index, makeMeasureSpec, makeMeasureSpec2, view);
            this.mFlexContainer.updateViewCache(index, view);
            return;
        }
        z = true;
        if (measuredHeight >= flexItem.getMinHeight()) {
        }
        if (z2) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void determineMainSize(int widthMeasureSpec, int heightMeasureSpec) {
        determineMainSize(widthMeasureSpec, heightMeasureSpec, 0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void determineMainSize(int widthMeasureSpec, int heightMeasureSpec, int fromIndex) {
        int size;
        int paddingLeft;
        int paddingRight;
        int i;
        int i2;
        ensureChildrenFrozen(this.mFlexContainer.getFlexItemCount());
        if (fromIndex >= this.mFlexContainer.getFlexItemCount()) {
            return;
        }
        int flexDirection = this.mFlexContainer.getFlexDirection();
        int flexDirection2 = this.mFlexContainer.getFlexDirection();
        if (flexDirection2 == 0 || flexDirection2 == 1) {
            int mode = View.MeasureSpec.getMode(widthMeasureSpec);
            size = View.MeasureSpec.getSize(widthMeasureSpec);
            int largestMainSize = this.mFlexContainer.getLargestMainSize();
            if (mode != 1073741824) {
                size = Math.min(largestMainSize, size);
            }
            paddingLeft = this.mFlexContainer.getPaddingLeft();
            paddingRight = this.mFlexContainer.getPaddingRight();
        } else if (flexDirection2 == 2 || flexDirection2 == 3) {
            int mode2 = View.MeasureSpec.getMode(heightMeasureSpec);
            size = View.MeasureSpec.getSize(heightMeasureSpec);
            if (mode2 != 1073741824) {
                size = this.mFlexContainer.getLargestMainSize();
            }
            paddingLeft = this.mFlexContainer.getPaddingTop();
            paddingRight = this.mFlexContainer.getPaddingBottom();
        } else {
            throw new IllegalArgumentException("Invalid flex direction: " + flexDirection);
        }
        int i3 = paddingLeft + paddingRight;
        int i4 = size;
        int[] iArr = this.mIndexToFlexLine;
        int i5 = iArr != null ? iArr[fromIndex] : 0;
        List<FlexLine> flexLinesInternal = this.mFlexContainer.getFlexLinesInternal();
        int size2 = flexLinesInternal.size();
        while (i5 < size2) {
            FlexLine flexLine = flexLinesInternal.get(i5);
            if (flexLine.mMainSize < i4 && flexLine.mAnyItemsHaveFlexGrow) {
                i = widthMeasureSpec;
                i2 = heightMeasureSpec;
                expandFlexItems(i, i2, flexLine, i4, i3, false);
            } else {
                i = widthMeasureSpec;
                i2 = heightMeasureSpec;
                if (flexLine.mMainSize > i4 && flexLine.mAnyItemsHaveFlexShrink) {
                    shrinkFlexItems(i, i2, flexLine, i4, i3, false);
                }
            }
            i5++;
            widthMeasureSpec = i;
            heightMeasureSpec = i2;
        }
    }

    private void ensureChildrenFrozen(int size) {
        boolean[] zArr = this.mChildrenFrozen;
        if (zArr == null) {
            this.mChildrenFrozen = new boolean[Math.max(size, 10)];
        } else if (zArr.length < size) {
            this.mChildrenFrozen = new boolean[Math.max(zArr.length * 2, size)];
        } else {
            Arrays.fill(zArr, false);
        }
    }

    private void expandFlexItems(int widthMeasureSpec, int heightMeasureSpec, FlexLine flexLine, int maxMainSize, int paddingAlongMainAxis, boolean calledRecursively) {
        float f;
        float f2;
        int i;
        double d;
        double d2;
        float f3 = 0.0f;
        if (flexLine.mTotalFlexGrow <= 0.0f || maxMainSize < flexLine.mMainSize) {
            return;
        }
        int i2 = flexLine.mMainSize;
        float f4 = (maxMainSize - flexLine.mMainSize) / flexLine.mTotalFlexGrow;
        flexLine.mMainSize = paddingAlongMainAxis + flexLine.mDividerLengthInMainSize;
        if (!calledRecursively) {
            flexLine.mCrossSize = Integer.MIN_VALUE;
        }
        int i3 = 0;
        float f5 = 0.0f;
        boolean z = false;
        int i4 = 0;
        while (i3 < flexLine.mItemCount) {
            int i5 = flexLine.mFirstIndex + i3;
            View reorderedFlexItemAt = this.mFlexContainer.getReorderedFlexItemAt(i5);
            if (reorderedFlexItemAt == null || reorderedFlexItemAt.getVisibility() == 8) {
                f = f3;
                f2 = f4;
            } else {
                FlexItem flexItem = (FlexItem) reorderedFlexItemAt.getLayoutParams();
                int flexDirection = this.mFlexContainer.getFlexDirection();
                f = f3;
                if (flexDirection == 0 || flexDirection == 1) {
                    f2 = f4;
                    int measuredWidth = reorderedFlexItemAt.getMeasuredWidth();
                    long[] jArr = this.mMeasuredSizeCache;
                    if (jArr != null) {
                        measuredWidth = extractLowerInt(jArr[i5]);
                    }
                    int measuredHeight = reorderedFlexItemAt.getMeasuredHeight();
                    long[] jArr2 = this.mMeasuredSizeCache;
                    if (jArr2 != null) {
                        measuredHeight = extractHigherInt(jArr2[i5]);
                    }
                    if (!this.mChildrenFrozen[i5] && flexItem.getFlexGrow() > f) {
                        float flexGrow = measuredWidth + (f2 * flexItem.getFlexGrow());
                        if (i3 == flexLine.mItemCount - 1) {
                            flexGrow += f5;
                            f5 = f;
                        }
                        int round = Math.round(flexGrow);
                        if (round > flexItem.getMaxWidth()) {
                            round = flexItem.getMaxWidth();
                            this.mChildrenFrozen[i5] = true;
                            flexLine.mTotalFlexGrow -= flexItem.getFlexGrow();
                            z = true;
                        } else {
                            f5 += flexGrow - round;
                            double d3 = f5;
                            if (d3 > 1.0d) {
                                round++;
                                d = d3 - 1.0d;
                            } else if (d3 < -1.0d) {
                                round--;
                                d = d3 + 1.0d;
                            }
                            f5 = (float) d;
                        }
                        int childHeightMeasureSpecInternal = getChildHeightMeasureSpecInternal(heightMeasureSpec, flexItem, flexLine.mSumCrossSizeBefore);
                        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(round, 1073741824);
                        reorderedFlexItemAt.measure(makeMeasureSpec, childHeightMeasureSpecInternal);
                        int measuredWidth2 = reorderedFlexItemAt.getMeasuredWidth();
                        int measuredHeight2 = reorderedFlexItemAt.getMeasuredHeight();
                        updateMeasureCache(i5, makeMeasureSpec, childHeightMeasureSpecInternal, reorderedFlexItemAt);
                        this.mFlexContainer.updateViewCache(i5, reorderedFlexItemAt);
                        measuredWidth = measuredWidth2;
                        measuredHeight = measuredHeight2;
                    }
                    int max = Math.max(i4, measuredHeight + flexItem.getMarginTop() + flexItem.getMarginBottom() + this.mFlexContainer.getDecorationLengthCrossAxis(reorderedFlexItemAt));
                    flexLine.mMainSize += measuredWidth + flexItem.getMarginLeft() + flexItem.getMarginRight();
                    i = max;
                } else {
                    int measuredHeight3 = reorderedFlexItemAt.getMeasuredHeight();
                    long[] jArr3 = this.mMeasuredSizeCache;
                    if (jArr3 != null) {
                        measuredHeight3 = extractHigherInt(jArr3[i5]);
                    }
                    int measuredWidth3 = reorderedFlexItemAt.getMeasuredWidth();
                    long[] jArr4 = this.mMeasuredSizeCache;
                    f2 = f4;
                    if (jArr4 != null) {
                        measuredWidth3 = extractLowerInt(jArr4[i5]);
                    }
                    if (!this.mChildrenFrozen[i5] && flexItem.getFlexGrow() > f) {
                        float flexGrow2 = measuredHeight3 + (f2 * flexItem.getFlexGrow());
                        if (i3 == flexLine.mItemCount - 1) {
                            flexGrow2 += f5;
                            f5 = f;
                        }
                        int round2 = Math.round(flexGrow2);
                        if (round2 > flexItem.getMaxHeight()) {
                            round2 = flexItem.getMaxHeight();
                            this.mChildrenFrozen[i5] = true;
                            flexLine.mTotalFlexGrow -= flexItem.getFlexGrow();
                            z = true;
                        } else {
                            f5 += flexGrow2 - round2;
                            double d4 = f5;
                            if (d4 > 1.0d) {
                                round2++;
                                d2 = d4 - 1.0d;
                            } else if (d4 < -1.0d) {
                                round2--;
                                d2 = d4 + 1.0d;
                            }
                            f5 = (float) d2;
                        }
                        int childWidthMeasureSpecInternal = getChildWidthMeasureSpecInternal(widthMeasureSpec, flexItem, flexLine.mSumCrossSizeBefore);
                        int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(round2, 1073741824);
                        reorderedFlexItemAt.measure(childWidthMeasureSpecInternal, makeMeasureSpec2);
                        int measuredWidth4 = reorderedFlexItemAt.getMeasuredWidth();
                        int measuredHeight4 = reorderedFlexItemAt.getMeasuredHeight();
                        updateMeasureCache(i5, childWidthMeasureSpecInternal, makeMeasureSpec2, reorderedFlexItemAt);
                        this.mFlexContainer.updateViewCache(i5, reorderedFlexItemAt);
                        measuredWidth3 = measuredWidth4;
                        measuredHeight3 = measuredHeight4;
                    }
                    i = Math.max(i4, measuredWidth3 + flexItem.getMarginLeft() + flexItem.getMarginRight() + this.mFlexContainer.getDecorationLengthCrossAxis(reorderedFlexItemAt));
                    flexLine.mMainSize += measuredHeight3 + flexItem.getMarginTop() + flexItem.getMarginBottom();
                }
                flexLine.mCrossSize = Math.max(flexLine.mCrossSize, i);
                i4 = i;
            }
            i3++;
            f4 = f2;
            f3 = f;
        }
        if (!z || i2 == flexLine.mMainSize) {
            return;
        }
        expandFlexItems(widthMeasureSpec, heightMeasureSpec, flexLine, maxMainSize, paddingAlongMainAxis, true);
    }

    private void shrinkFlexItems(int widthMeasureSpec, int heightMeasureSpec, FlexLine flexLine, int maxMainSize, int paddingAlongMainAxis, boolean calledRecursively) {
        float f;
        int i;
        int i2 = flexLine.mMainSize;
        float f2 = 0.0f;
        if (flexLine.mTotalFlexShrink <= 0.0f || maxMainSize > flexLine.mMainSize) {
            return;
        }
        float f3 = (flexLine.mMainSize - maxMainSize) / flexLine.mTotalFlexShrink;
        flexLine.mMainSize = paddingAlongMainAxis + flexLine.mDividerLengthInMainSize;
        if (!calledRecursively) {
            flexLine.mCrossSize = Integer.MIN_VALUE;
        }
        int i3 = 0;
        float f4 = 0.0f;
        boolean z = false;
        int i4 = 0;
        while (i3 < flexLine.mItemCount) {
            int i5 = flexLine.mFirstIndex + i3;
            View reorderedFlexItemAt = this.mFlexContainer.getReorderedFlexItemAt(i5);
            if (reorderedFlexItemAt == null || reorderedFlexItemAt.getVisibility() == 8) {
                f = f2;
            } else {
                FlexItem flexItem = (FlexItem) reorderedFlexItemAt.getLayoutParams();
                int flexDirection = this.mFlexContainer.getFlexDirection();
                f = f2;
                if (flexDirection == 0 || flexDirection == 1) {
                    int measuredWidth = reorderedFlexItemAt.getMeasuredWidth();
                    long[] jArr = this.mMeasuredSizeCache;
                    if (jArr != null) {
                        measuredWidth = extractLowerInt(jArr[i5]);
                    }
                    int measuredHeight = reorderedFlexItemAt.getMeasuredHeight();
                    long[] jArr2 = this.mMeasuredSizeCache;
                    if (jArr2 != null) {
                        measuredHeight = extractHigherInt(jArr2[i5]);
                    }
                    if (!this.mChildrenFrozen[i5] && flexItem.getFlexShrink() > f) {
                        float flexShrink = measuredWidth - (flexItem.getFlexShrink() * f3);
                        if (i3 == flexLine.mItemCount - 1) {
                            flexShrink += f4;
                            f4 = f;
                        }
                        int round = Math.round(flexShrink);
                        if (round < flexItem.getMinWidth()) {
                            round = flexItem.getMinWidth();
                            this.mChildrenFrozen[i5] = true;
                            flexLine.mTotalFlexShrink -= flexItem.getFlexShrink();
                            z = true;
                        } else {
                            f4 += flexShrink - round;
                            double d = f4;
                            if (d > 1.0d) {
                                round++;
                                f4 -= 1.0f;
                            } else if (d < -1.0d) {
                                round--;
                                f4 += 1.0f;
                            }
                        }
                        int childHeightMeasureSpecInternal = getChildHeightMeasureSpecInternal(heightMeasureSpec, flexItem, flexLine.mSumCrossSizeBefore);
                        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(round, 1073741824);
                        reorderedFlexItemAt.measure(makeMeasureSpec, childHeightMeasureSpecInternal);
                        int measuredWidth2 = reorderedFlexItemAt.getMeasuredWidth();
                        int measuredHeight2 = reorderedFlexItemAt.getMeasuredHeight();
                        updateMeasureCache(i5, makeMeasureSpec, childHeightMeasureSpecInternal, reorderedFlexItemAt);
                        this.mFlexContainer.updateViewCache(i5, reorderedFlexItemAt);
                        measuredWidth = measuredWidth2;
                        measuredHeight = measuredHeight2;
                    }
                    int max = Math.max(i4, measuredHeight + flexItem.getMarginTop() + flexItem.getMarginBottom() + this.mFlexContainer.getDecorationLengthCrossAxis(reorderedFlexItemAt));
                    flexLine.mMainSize += measuredWidth + flexItem.getMarginLeft() + flexItem.getMarginRight();
                    i = max;
                } else {
                    int measuredHeight3 = reorderedFlexItemAt.getMeasuredHeight();
                    long[] jArr3 = this.mMeasuredSizeCache;
                    if (jArr3 != null) {
                        measuredHeight3 = extractHigherInt(jArr3[i5]);
                    }
                    int measuredWidth3 = reorderedFlexItemAt.getMeasuredWidth();
                    long[] jArr4 = this.mMeasuredSizeCache;
                    if (jArr4 != null) {
                        measuredWidth3 = extractLowerInt(jArr4[i5]);
                    }
                    if (!this.mChildrenFrozen[i5] && flexItem.getFlexShrink() > f) {
                        float flexShrink2 = measuredHeight3 - (flexItem.getFlexShrink() * f3);
                        if (i3 == flexLine.mItemCount - 1) {
                            flexShrink2 += f4;
                            f4 = f;
                        }
                        int round2 = Math.round(flexShrink2);
                        if (round2 < flexItem.getMinHeight()) {
                            round2 = flexItem.getMinHeight();
                            this.mChildrenFrozen[i5] = true;
                            flexLine.mTotalFlexShrink -= flexItem.getFlexShrink();
                            z = true;
                        } else {
                            f4 += flexShrink2 - round2;
                            double d2 = f4;
                            if (d2 > 1.0d) {
                                round2++;
                                f4 -= 1.0f;
                            } else if (d2 < -1.0d) {
                                round2--;
                                f4 += 1.0f;
                            }
                        }
                        int childWidthMeasureSpecInternal = getChildWidthMeasureSpecInternal(widthMeasureSpec, flexItem, flexLine.mSumCrossSizeBefore);
                        int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(round2, 1073741824);
                        reorderedFlexItemAt.measure(childWidthMeasureSpecInternal, makeMeasureSpec2);
                        int measuredWidth4 = reorderedFlexItemAt.getMeasuredWidth();
                        int measuredHeight4 = reorderedFlexItemAt.getMeasuredHeight();
                        updateMeasureCache(i5, childWidthMeasureSpecInternal, makeMeasureSpec2, reorderedFlexItemAt);
                        this.mFlexContainer.updateViewCache(i5, reorderedFlexItemAt);
                        measuredWidth3 = measuredWidth4;
                        measuredHeight3 = measuredHeight4;
                    }
                    i = Math.max(i4, measuredWidth3 + flexItem.getMarginLeft() + flexItem.getMarginRight() + this.mFlexContainer.getDecorationLengthCrossAxis(reorderedFlexItemAt));
                    flexLine.mMainSize += measuredHeight3 + flexItem.getMarginTop() + flexItem.getMarginBottom();
                }
                flexLine.mCrossSize = Math.max(flexLine.mCrossSize, i);
                i4 = i;
            }
            i3++;
            f2 = f;
        }
        if (!z || i2 == flexLine.mMainSize) {
            return;
        }
        shrinkFlexItems(widthMeasureSpec, heightMeasureSpec, flexLine, maxMainSize, paddingAlongMainAxis, true);
    }

    private int getChildWidthMeasureSpecInternal(int widthMeasureSpec, FlexItem flexItem, int padding) {
        FlexContainer flexContainer = this.mFlexContainer;
        int childWidthMeasureSpec = flexContainer.getChildWidthMeasureSpec(widthMeasureSpec, flexContainer.getPaddingLeft() + this.mFlexContainer.getPaddingRight() + flexItem.getMarginLeft() + flexItem.getMarginRight() + padding, flexItem.getWidth());
        int size = View.MeasureSpec.getSize(childWidthMeasureSpec);
        if (size > flexItem.getMaxWidth()) {
            return View.MeasureSpec.makeMeasureSpec(flexItem.getMaxWidth(), View.MeasureSpec.getMode(childWidthMeasureSpec));
        }
        return size < flexItem.getMinWidth() ? View.MeasureSpec.makeMeasureSpec(flexItem.getMinWidth(), View.MeasureSpec.getMode(childWidthMeasureSpec)) : childWidthMeasureSpec;
    }

    private int getChildHeightMeasureSpecInternal(int heightMeasureSpec, FlexItem flexItem, int padding) {
        FlexContainer flexContainer = this.mFlexContainer;
        int childHeightMeasureSpec = flexContainer.getChildHeightMeasureSpec(heightMeasureSpec, flexContainer.getPaddingTop() + this.mFlexContainer.getPaddingBottom() + flexItem.getMarginTop() + flexItem.getMarginBottom() + padding, flexItem.getHeight());
        int size = View.MeasureSpec.getSize(childHeightMeasureSpec);
        if (size > flexItem.getMaxHeight()) {
            return View.MeasureSpec.makeMeasureSpec(flexItem.getMaxHeight(), View.MeasureSpec.getMode(childHeightMeasureSpec));
        }
        return size < flexItem.getMinHeight() ? View.MeasureSpec.makeMeasureSpec(flexItem.getMinHeight(), View.MeasureSpec.getMode(childHeightMeasureSpec)) : childHeightMeasureSpec;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void determineCrossSize(int widthMeasureSpec, int heightMeasureSpec, int paddingAlongCrossAxis) {
        int i;
        int i2;
        int flexDirection = this.mFlexContainer.getFlexDirection();
        if (flexDirection == 0 || flexDirection == 1) {
            int mode = View.MeasureSpec.getMode(heightMeasureSpec);
            int size = View.MeasureSpec.getSize(heightMeasureSpec);
            i = mode;
            i2 = size;
        } else if (flexDirection == 2 || flexDirection == 3) {
            i = View.MeasureSpec.getMode(widthMeasureSpec);
            i2 = View.MeasureSpec.getSize(widthMeasureSpec);
        } else {
            throw new IllegalArgumentException("Invalid flex direction: " + flexDirection);
        }
        List<FlexLine> flexLinesInternal = this.mFlexContainer.getFlexLinesInternal();
        if (i == 1073741824) {
            int sumOfCrossSize = this.mFlexContainer.getSumOfCrossSize() + paddingAlongCrossAxis;
            int i3 = 0;
            if (flexLinesInternal.size() == 1) {
                flexLinesInternal.get(0).mCrossSize = i2 - paddingAlongCrossAxis;
            } else if (flexLinesInternal.size() >= 2) {
                int alignContent = this.mFlexContainer.getAlignContent();
                if (alignContent == 1) {
                    int i4 = i2 - sumOfCrossSize;
                    FlexLine flexLine = new FlexLine();
                    flexLine.mCrossSize = i4;
                    flexLinesInternal.add(0, flexLine);
                } else if (alignContent == 2) {
                    this.mFlexContainer.setFlexLines(constructFlexLinesForAlignContentCenter(flexLinesInternal, i2, sumOfCrossSize));
                } else if (alignContent == 3) {
                    if (sumOfCrossSize >= i2) {
                        return;
                    }
                    float size2 = (i2 - sumOfCrossSize) / (flexLinesInternal.size() - 1);
                    ArrayList arrayList = new ArrayList();
                    int size3 = flexLinesInternal.size();
                    float f = 0.0f;
                    while (i3 < size3) {
                        arrayList.add(flexLinesInternal.get(i3));
                        if (i3 != flexLinesInternal.size() - 1) {
                            FlexLine flexLine2 = new FlexLine();
                            if (i3 == flexLinesInternal.size() - 2) {
                                flexLine2.mCrossSize = Math.round(f + size2);
                                f = 0.0f;
                            } else {
                                flexLine2.mCrossSize = Math.round(size2);
                            }
                            f += size2 - flexLine2.mCrossSize;
                            if (f > 1.0f) {
                                flexLine2.mCrossSize++;
                                f -= 1.0f;
                            } else if (f < -1.0f) {
                                flexLine2.mCrossSize--;
                                f += 1.0f;
                            }
                            arrayList.add(flexLine2);
                        }
                        i3++;
                    }
                    this.mFlexContainer.setFlexLines(arrayList);
                } else if (alignContent == 4) {
                    if (sumOfCrossSize >= i2) {
                        this.mFlexContainer.setFlexLines(constructFlexLinesForAlignContentCenter(flexLinesInternal, i2, sumOfCrossSize));
                        return;
                    }
                    int size4 = (i2 - sumOfCrossSize) / (flexLinesInternal.size() * 2);
                    ArrayList arrayList2 = new ArrayList();
                    FlexLine flexLine3 = new FlexLine();
                    flexLine3.mCrossSize = size4;
                    for (FlexLine flexLine4 : flexLinesInternal) {
                        arrayList2.add(flexLine3);
                        arrayList2.add(flexLine4);
                        arrayList2.add(flexLine3);
                    }
                    this.mFlexContainer.setFlexLines(arrayList2);
                } else if (alignContent == 5 && sumOfCrossSize < i2) {
                    float size5 = (i2 - sumOfCrossSize) / flexLinesInternal.size();
                    int size6 = flexLinesInternal.size();
                    float f2 = 0.0f;
                    while (i3 < size6) {
                        FlexLine flexLine5 = flexLinesInternal.get(i3);
                        float f3 = flexLine5.mCrossSize + size5;
                        if (i3 == flexLinesInternal.size() - 1) {
                            f3 += f2;
                            f2 = 0.0f;
                        }
                        int round = Math.round(f3);
                        f2 += f3 - round;
                        if (f2 > 1.0f) {
                            round++;
                            f2 -= 1.0f;
                        } else if (f2 < -1.0f) {
                            round--;
                            f2 += 1.0f;
                        }
                        flexLine5.mCrossSize = round;
                        i3++;
                    }
                }
            }
        }
    }

    private List<FlexLine> constructFlexLinesForAlignContentCenter(List<FlexLine> flexLines, int size, int totalCrossSize) {
        ArrayList arrayList = new ArrayList();
        FlexLine flexLine = new FlexLine();
        flexLine.mCrossSize = (size - totalCrossSize) / 2;
        int size2 = flexLines.size();
        for (int i = 0; i < size2; i++) {
            if (i == 0) {
                arrayList.add(flexLine);
            }
            arrayList.add(flexLines.get(i));
            if (i == flexLines.size() - 1) {
                arrayList.add(flexLine);
            }
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void stretchViews() {
        stretchViews(0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void stretchViews(int fromIndex) {
        View reorderedFlexItemAt;
        if (fromIndex >= this.mFlexContainer.getFlexItemCount()) {
            return;
        }
        int flexDirection = this.mFlexContainer.getFlexDirection();
        if (this.mFlexContainer.getAlignItems() == 4) {
            int[] iArr = this.mIndexToFlexLine;
            List<FlexLine> flexLinesInternal = this.mFlexContainer.getFlexLinesInternal();
            int size = flexLinesInternal.size();
            for (int i = iArr != null ? iArr[fromIndex] : 0; i < size; i++) {
                FlexLine flexLine = flexLinesInternal.get(i);
                int i2 = flexLine.mItemCount;
                for (int i3 = 0; i3 < i2; i3++) {
                    int i4 = flexLine.mFirstIndex + i3;
                    if (i3 < this.mFlexContainer.getFlexItemCount() && (reorderedFlexItemAt = this.mFlexContainer.getReorderedFlexItemAt(i4)) != null && reorderedFlexItemAt.getVisibility() != 8) {
                        FlexItem flexItem = (FlexItem) reorderedFlexItemAt.getLayoutParams();
                        if (flexItem.getAlignSelf() == -1 || flexItem.getAlignSelf() == 4) {
                            if (flexDirection == 0 || flexDirection == 1) {
                                stretchViewVertically(reorderedFlexItemAt, flexLine.mCrossSize, i4);
                            } else if (flexDirection == 2 || flexDirection == 3) {
                                stretchViewHorizontally(reorderedFlexItemAt, flexLine.mCrossSize, i4);
                            } else {
                                throw new IllegalArgumentException("Invalid flex direction: " + flexDirection);
                            }
                        }
                    }
                }
            }
            return;
        }
        for (FlexLine flexLine2 : this.mFlexContainer.getFlexLinesInternal()) {
            for (Integer num : flexLine2.mIndicesAlignSelfStretch) {
                View reorderedFlexItemAt2 = this.mFlexContainer.getReorderedFlexItemAt(num.intValue());
                if (flexDirection == 0 || flexDirection == 1) {
                    stretchViewVertically(reorderedFlexItemAt2, flexLine2.mCrossSize, num.intValue());
                } else if (flexDirection == 2 || flexDirection == 3) {
                    stretchViewHorizontally(reorderedFlexItemAt2, flexLine2.mCrossSize, num.intValue());
                } else {
                    throw new IllegalArgumentException("Invalid flex direction: " + flexDirection);
                }
            }
        }
    }

    private void stretchViewVertically(View view, int crossSize, int index) {
        int measuredWidth;
        FlexItem flexItem = (FlexItem) view.getLayoutParams();
        int min = Math.min(Math.max(((crossSize - flexItem.getMarginTop()) - flexItem.getMarginBottom()) - this.mFlexContainer.getDecorationLengthCrossAxis(view), flexItem.getMinHeight()), flexItem.getMaxHeight());
        long[] jArr = this.mMeasuredSizeCache;
        if (jArr != null) {
            measuredWidth = extractLowerInt(jArr[index]);
        } else {
            measuredWidth = view.getMeasuredWidth();
        }
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(measuredWidth, 1073741824);
        int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(min, 1073741824);
        view.measure(makeMeasureSpec, makeMeasureSpec2);
        updateMeasureCache(index, makeMeasureSpec, makeMeasureSpec2, view);
        this.mFlexContainer.updateViewCache(index, view);
    }

    private void stretchViewHorizontally(View view, int crossSize, int index) {
        int measuredHeight;
        FlexItem flexItem = (FlexItem) view.getLayoutParams();
        int min = Math.min(Math.max(((crossSize - flexItem.getMarginLeft()) - flexItem.getMarginRight()) - this.mFlexContainer.getDecorationLengthCrossAxis(view), flexItem.getMinWidth()), flexItem.getMaxWidth());
        long[] jArr = this.mMeasuredSizeCache;
        if (jArr != null) {
            measuredHeight = extractHigherInt(jArr[index]);
        } else {
            measuredHeight = view.getMeasuredHeight();
        }
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(measuredHeight, 1073741824);
        int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(min, 1073741824);
        view.measure(makeMeasureSpec2, makeMeasureSpec);
        updateMeasureCache(index, makeMeasureSpec2, makeMeasureSpec, view);
        this.mFlexContainer.updateViewCache(index, view);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void layoutSingleChildHorizontal(View view, FlexLine flexLine, int left, int top, int right, int bottom) {
        FlexItem flexItem = (FlexItem) view.getLayoutParams();
        int alignItems = this.mFlexContainer.getAlignItems();
        if (flexItem.getAlignSelf() != -1) {
            alignItems = flexItem.getAlignSelf();
        }
        int i = flexLine.mCrossSize;
        if (alignItems != 0) {
            if (alignItems == 1) {
                if (this.mFlexContainer.getFlexWrap() != 2) {
                    int i2 = top + i;
                    view.layout(left, (i2 - view.getMeasuredHeight()) - flexItem.getMarginBottom(), right, i2 - flexItem.getMarginBottom());
                    return;
                }
                view.layout(left, (top - i) + view.getMeasuredHeight() + flexItem.getMarginTop(), right, (bottom - i) + view.getMeasuredHeight() + flexItem.getMarginTop());
                return;
            } else if (alignItems == 2) {
                int measuredHeight = (((i - view.getMeasuredHeight()) + flexItem.getMarginTop()) - flexItem.getMarginBottom()) / 2;
                if (this.mFlexContainer.getFlexWrap() != 2) {
                    int i3 = top + measuredHeight;
                    view.layout(left, i3, right, view.getMeasuredHeight() + i3);
                    return;
                }
                int i4 = top - measuredHeight;
                view.layout(left, i4, right, view.getMeasuredHeight() + i4);
                return;
            } else if (alignItems == 3) {
                if (this.mFlexContainer.getFlexWrap() != 2) {
                    int max = Math.max(flexLine.mMaxBaseline - view.getBaseline(), flexItem.getMarginTop());
                    view.layout(left, top + max, right, bottom + max);
                    return;
                }
                int max2 = Math.max((flexLine.mMaxBaseline - view.getMeasuredHeight()) + view.getBaseline(), flexItem.getMarginBottom());
                view.layout(left, top - max2, right, bottom - max2);
                return;
            } else if (alignItems != 4) {
                return;
            }
        }
        if (this.mFlexContainer.getFlexWrap() != 2) {
            view.layout(left, top + flexItem.getMarginTop(), right, bottom + flexItem.getMarginTop());
        } else {
            view.layout(left, top - flexItem.getMarginBottom(), right, bottom - flexItem.getMarginBottom());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void layoutSingleChildVertical(View view, FlexLine flexLine, boolean isRtl, int left, int top, int right, int bottom) {
        FlexItem flexItem = (FlexItem) view.getLayoutParams();
        int alignItems = this.mFlexContainer.getAlignItems();
        if (flexItem.getAlignSelf() != -1) {
            alignItems = flexItem.getAlignSelf();
        }
        int i = flexLine.mCrossSize;
        if (alignItems != 0) {
            if (alignItems == 1) {
                if (!isRtl) {
                    view.layout(((left + i) - view.getMeasuredWidth()) - flexItem.getMarginRight(), top, ((right + i) - view.getMeasuredWidth()) - flexItem.getMarginRight(), bottom);
                    return;
                } else {
                    view.layout((left - i) + view.getMeasuredWidth() + flexItem.getMarginLeft(), top, (right - i) + view.getMeasuredWidth() + flexItem.getMarginLeft(), bottom);
                    return;
                }
            } else if (alignItems == 2) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
                int measuredWidth = (((i - view.getMeasuredWidth()) + MarginLayoutParamsCompat.getMarginStart(marginLayoutParams)) - MarginLayoutParamsCompat.getMarginEnd(marginLayoutParams)) / 2;
                if (!isRtl) {
                    view.layout(left + measuredWidth, top, right + measuredWidth, bottom);
                    return;
                } else {
                    view.layout(left - measuredWidth, top, right - measuredWidth, bottom);
                    return;
                }
            } else if (alignItems != 3 && alignItems != 4) {
                return;
            }
        }
        if (!isRtl) {
            view.layout(left + flexItem.getMarginLeft(), top, right + flexItem.getMarginLeft(), bottom);
        } else {
            view.layout(left - flexItem.getMarginRight(), top, right - flexItem.getMarginRight(), bottom);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void ensureMeasuredSizeCache(int size) {
        long[] jArr = this.mMeasuredSizeCache;
        if (jArr == null) {
            this.mMeasuredSizeCache = new long[Math.max(size, 10)];
        } else if (jArr.length < size) {
            this.mMeasuredSizeCache = Arrays.copyOf(this.mMeasuredSizeCache, Math.max(jArr.length * 2, size));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void ensureMeasureSpecCache(int size) {
        long[] jArr = this.mMeasureSpecCache;
        if (jArr == null) {
            this.mMeasureSpecCache = new long[Math.max(size, 10)];
        } else if (jArr.length < size) {
            this.mMeasureSpecCache = Arrays.copyOf(this.mMeasureSpecCache, Math.max(jArr.length * 2, size));
        }
    }

    private void updateMeasureCache(int index, int widthMeasureSpec, int heightMeasureSpec, View view) {
        long[] jArr = this.mMeasureSpecCache;
        if (jArr != null) {
            jArr[index] = makeCombinedLong(widthMeasureSpec, heightMeasureSpec);
        }
        long[] jArr2 = this.mMeasuredSizeCache;
        if (jArr2 != null) {
            jArr2[index] = makeCombinedLong(view.getMeasuredWidth(), view.getMeasuredHeight());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void ensureIndexToFlexLine(int size) {
        int[] iArr = this.mIndexToFlexLine;
        if (iArr == null) {
            this.mIndexToFlexLine = new int[Math.max(size, 10)];
        } else if (iArr.length < size) {
            this.mIndexToFlexLine = Arrays.copyOf(this.mIndexToFlexLine, Math.max(iArr.length * 2, size));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void clearFlexLines(List<FlexLine> flexLines, int fromFlexItem) {
        int i = this.mIndexToFlexLine[fromFlexItem];
        if (i == -1) {
            i = 0;
        }
        if (flexLines.size() > i) {
            flexLines.subList(i, flexLines.size()).clear();
        }
        int[] iArr = this.mIndexToFlexLine;
        int length = iArr.length - 1;
        if (fromFlexItem > length) {
            Arrays.fill(iArr, -1);
        } else {
            Arrays.fill(iArr, fromFlexItem, length, -1);
        }
        long[] jArr = this.mMeasureSpecCache;
        int length2 = jArr.length - 1;
        if (fromFlexItem > length2) {
            Arrays.fill(jArr, 0L);
        } else {
            Arrays.fill(jArr, fromFlexItem, length2, 0L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public static class Order implements Comparable<Order> {
        int index;
        int order;

        private Order() {
        }

        @Override // java.lang.Comparable
        public int compareTo(Order another) {
            int i = this.order;
            int i2 = another.order;
            return i != i2 ? i - i2 : this.index - another.index;
        }

        public String toString() {
            return "Order{order=" + this.order + ", index=" + this.index + AbstractJsonLexerKt.END_OBJ;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public static class FlexLinesResult {
        int mChildState;
        List<FlexLine> mFlexLines;

        /* JADX INFO: Access modifiers changed from: package-private */
        public void reset() {
            this.mFlexLines = null;
            this.mChildState = 0;
        }
    }
}
