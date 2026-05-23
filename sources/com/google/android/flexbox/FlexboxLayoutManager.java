package com.google.android.flexbox;

import android.content.Context;
import android.graphics.PointF;
import android.graphics.Rect;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.LinearSmoothScroller;
import androidx.recyclerview.widget.OrientationHelper;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.flexbox.FlexboxHelper;
import java.util.ArrayList;
import java.util.List;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
/* loaded from: classes4.dex */
public class FlexboxLayoutManager extends RecyclerView.LayoutManager implements FlexContainer, RecyclerView.SmoothScroller.ScrollVectorProvider {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final boolean DEBUG = false;
    private static final String TAG = "FlexboxLayoutManager";
    private static final Rect TEMP_RECT = new Rect();
    private int mAlignItems;
    private AnchorInfo mAnchorInfo;
    private final Context mContext;
    private int mDirtyPosition;
    private int mFlexDirection;
    private List<FlexLine> mFlexLines;
    private FlexboxHelper.FlexLinesResult mFlexLinesResult;
    private int mFlexWrap;
    private final FlexboxHelper mFlexboxHelper;
    private boolean mFromBottomToTop;
    private boolean mIsRtl;
    private int mJustifyContent;
    private int mLastHeight;
    private int mLastWidth;
    private LayoutState mLayoutState;
    private int mMaxLine;
    private OrientationHelper mOrientationHelper;
    private View mParent;
    private SavedState mPendingSavedState;
    private int mPendingScrollPosition;
    private int mPendingScrollPositionOffset;
    private boolean mRecycleChildrenOnDetach;
    private RecyclerView.Recycler mRecycler;
    private RecyclerView.State mState;
    private OrientationHelper mSubOrientationHelper;
    private SparseArray<View> mViewCache;

    @Override // com.google.android.flexbox.FlexContainer
    public int getAlignContent() {
        return 5;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public boolean isAutoMeasureEnabled() {
        return true;
    }

    @Override // com.google.android.flexbox.FlexContainer
    public void onNewFlexLineAdded(FlexLine flexLine) {
    }

    public FlexboxLayoutManager(Context context) {
        this(context, 0, 1);
    }

    public FlexboxLayoutManager(Context context, int flexDirection) {
        this(context, flexDirection, 1);
    }

    public FlexboxLayoutManager(Context context, int flexDirection, int flexWrap) {
        this.mMaxLine = -1;
        this.mFlexLines = new ArrayList();
        this.mFlexboxHelper = new FlexboxHelper(this);
        this.mAnchorInfo = new AnchorInfo();
        this.mPendingScrollPosition = -1;
        this.mPendingScrollPositionOffset = Integer.MIN_VALUE;
        this.mLastWidth = Integer.MIN_VALUE;
        this.mLastHeight = Integer.MIN_VALUE;
        this.mViewCache = new SparseArray<>();
        this.mDirtyPosition = -1;
        this.mFlexLinesResult = new FlexboxHelper.FlexLinesResult();
        setFlexDirection(flexDirection);
        setFlexWrap(flexWrap);
        setAlignItems(4);
        this.mContext = context;
    }

    public FlexboxLayoutManager(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        this.mMaxLine = -1;
        this.mFlexLines = new ArrayList();
        this.mFlexboxHelper = new FlexboxHelper(this);
        this.mAnchorInfo = new AnchorInfo();
        this.mPendingScrollPosition = -1;
        this.mPendingScrollPositionOffset = Integer.MIN_VALUE;
        this.mLastWidth = Integer.MIN_VALUE;
        this.mLastHeight = Integer.MIN_VALUE;
        this.mViewCache = new SparseArray<>();
        this.mDirtyPosition = -1;
        this.mFlexLinesResult = new FlexboxHelper.FlexLinesResult();
        RecyclerView.LayoutManager.Properties properties = getProperties(context, attrs, defStyleAttr, defStyleRes);
        int i = properties.orientation;
        if (i != 0) {
            if (i == 1) {
                if (properties.reverseLayout) {
                    setFlexDirection(3);
                } else {
                    setFlexDirection(2);
                }
            }
        } else if (properties.reverseLayout) {
            setFlexDirection(1);
        } else {
            setFlexDirection(0);
        }
        setFlexWrap(1);
        setAlignItems(4);
        this.mContext = context;
    }

    @Override // com.google.android.flexbox.FlexContainer
    public int getFlexDirection() {
        return this.mFlexDirection;
    }

    @Override // com.google.android.flexbox.FlexContainer
    public void setFlexDirection(int flexDirection) {
        if (this.mFlexDirection != flexDirection) {
            removeAllViews();
            this.mFlexDirection = flexDirection;
            this.mOrientationHelper = null;
            this.mSubOrientationHelper = null;
            clearFlexLines();
            requestLayout();
        }
    }

    @Override // com.google.android.flexbox.FlexContainer
    public int getFlexWrap() {
        return this.mFlexWrap;
    }

    @Override // com.google.android.flexbox.FlexContainer
    public void setFlexWrap(int flexWrap) {
        if (flexWrap == 2) {
            throw new UnsupportedOperationException("wrap_reverse is not supported in FlexboxLayoutManager");
        }
        int i = this.mFlexWrap;
        if (i != flexWrap) {
            if (i == 0 || flexWrap == 0) {
                removeAllViews();
                clearFlexLines();
            }
            this.mFlexWrap = flexWrap;
            this.mOrientationHelper = null;
            this.mSubOrientationHelper = null;
            requestLayout();
        }
    }

    @Override // com.google.android.flexbox.FlexContainer
    public int getJustifyContent() {
        return this.mJustifyContent;
    }

    @Override // com.google.android.flexbox.FlexContainer
    public void setJustifyContent(int justifyContent) {
        if (this.mJustifyContent != justifyContent) {
            this.mJustifyContent = justifyContent;
            requestLayout();
        }
    }

    @Override // com.google.android.flexbox.FlexContainer
    public int getAlignItems() {
        return this.mAlignItems;
    }

    @Override // com.google.android.flexbox.FlexContainer
    public void setAlignItems(int alignItems) {
        int i = this.mAlignItems;
        if (i != alignItems) {
            if (i == 4 || alignItems == 4) {
                removeAllViews();
                clearFlexLines();
            }
            this.mAlignItems = alignItems;
            requestLayout();
        }
    }

    @Override // com.google.android.flexbox.FlexContainer
    public void setAlignContent(int alignContent) {
        throw new UnsupportedOperationException("Setting the alignContent in the FlexboxLayoutManager is not supported. Use FlexboxLayout if you need to use this attribute.");
    }

    @Override // com.google.android.flexbox.FlexContainer
    public int getMaxLine() {
        return this.mMaxLine;
    }

    @Override // com.google.android.flexbox.FlexContainer
    public void setMaxLine(int maxLine) {
        if (this.mMaxLine != maxLine) {
            this.mMaxLine = maxLine;
            requestLayout();
        }
    }

    @Override // com.google.android.flexbox.FlexContainer
    public List<FlexLine> getFlexLines() {
        ArrayList arrayList = new ArrayList(this.mFlexLines.size());
        int size = this.mFlexLines.size();
        for (int i = 0; i < size; i++) {
            FlexLine flexLine = this.mFlexLines.get(i);
            if (flexLine.getItemCount() != 0) {
                arrayList.add(flexLine);
            }
        }
        return arrayList;
    }

    @Override // com.google.android.flexbox.FlexContainer
    public int getDecorationLengthMainAxis(View view, int index, int indexInFlexLine) {
        int topDecorationHeight;
        int bottomDecorationHeight;
        if (isMainAxisDirectionHorizontal()) {
            topDecorationHeight = getLeftDecorationWidth(view);
            bottomDecorationHeight = getRightDecorationWidth(view);
        } else {
            topDecorationHeight = getTopDecorationHeight(view);
            bottomDecorationHeight = getBottomDecorationHeight(view);
        }
        return topDecorationHeight + bottomDecorationHeight;
    }

    @Override // com.google.android.flexbox.FlexContainer
    public int getDecorationLengthCrossAxis(View view) {
        int leftDecorationWidth;
        int rightDecorationWidth;
        if (isMainAxisDirectionHorizontal()) {
            leftDecorationWidth = getTopDecorationHeight(view);
            rightDecorationWidth = getBottomDecorationHeight(view);
        } else {
            leftDecorationWidth = getLeftDecorationWidth(view);
            rightDecorationWidth = getRightDecorationWidth(view);
        }
        return leftDecorationWidth + rightDecorationWidth;
    }

    @Override // com.google.android.flexbox.FlexContainer
    public void onNewFlexItemAdded(View view, int index, int indexInFlexLine, FlexLine flexLine) {
        calculateItemDecorationsForChild(view, TEMP_RECT);
        if (isMainAxisDirectionHorizontal()) {
            int leftDecorationWidth = getLeftDecorationWidth(view) + getRightDecorationWidth(view);
            flexLine.mMainSize += leftDecorationWidth;
            flexLine.mDividerLengthInMainSize += leftDecorationWidth;
            return;
        }
        int topDecorationHeight = getTopDecorationHeight(view) + getBottomDecorationHeight(view);
        flexLine.mMainSize += topDecorationHeight;
        flexLine.mDividerLengthInMainSize += topDecorationHeight;
    }

    @Override // com.google.android.flexbox.FlexContainer
    public int getFlexItemCount() {
        return this.mState.getItemCount();
    }

    @Override // com.google.android.flexbox.FlexContainer
    public View getFlexItemAt(int index) {
        View view = this.mViewCache.get(index);
        return view != null ? view : this.mRecycler.getViewForPosition(index);
    }

    @Override // com.google.android.flexbox.FlexContainer
    public View getReorderedFlexItemAt(int index) {
        return getFlexItemAt(index);
    }

    @Override // com.google.android.flexbox.FlexContainer
    public int getChildWidthMeasureSpec(int widthSpec, int padding, int childDimension) {
        return getChildMeasureSpec(getWidth(), getWidthMode(), padding, childDimension, canScrollHorizontally());
    }

    @Override // com.google.android.flexbox.FlexContainer
    public int getChildHeightMeasureSpec(int heightSpec, int padding, int childDimension) {
        return getChildMeasureSpec(getHeight(), getHeightMode(), padding, childDimension, canScrollVertically());
    }

    @Override // com.google.android.flexbox.FlexContainer
    public int getLargestMainSize() {
        if (this.mFlexLines.size() == 0) {
            return 0;
        }
        int size = this.mFlexLines.size();
        int i = Integer.MIN_VALUE;
        for (int i2 = 0; i2 < size; i2++) {
            i = Math.max(i, this.mFlexLines.get(i2).mMainSize);
        }
        return i;
    }

    @Override // com.google.android.flexbox.FlexContainer
    public int getSumOfCrossSize() {
        int size = this.mFlexLines.size();
        int i = 0;
        for (int i2 = 0; i2 < size; i2++) {
            i += this.mFlexLines.get(i2).mCrossSize;
        }
        return i;
    }

    @Override // com.google.android.flexbox.FlexContainer
    public void setFlexLines(List<FlexLine> flexLines) {
        this.mFlexLines = flexLines;
    }

    @Override // com.google.android.flexbox.FlexContainer
    public List<FlexLine> getFlexLinesInternal() {
        return this.mFlexLines;
    }

    @Override // com.google.android.flexbox.FlexContainer
    public void updateViewCache(int position, View view) {
        this.mViewCache.put(position, view);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.SmoothScroller.ScrollVectorProvider
    public PointF computeScrollVectorForPosition(int targetPosition) {
        View childAt;
        if (getChildCount() == 0 || (childAt = getChildAt(0)) == null) {
            return null;
        }
        int i = targetPosition < getPosition(childAt) ? -1 : 1;
        if (isMainAxisDirectionHorizontal()) {
            return new PointF(0.0f, i);
        }
        return new PointF(i, 0.0f);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public RecyclerView.LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams(-2, -2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public RecyclerView.LayoutParams generateLayoutParams(Context c, AttributeSet attrs) {
        return new LayoutParams(c, attrs);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public boolean checkLayoutParams(RecyclerView.LayoutParams lp) {
        return lp instanceof LayoutParams;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onAdapterChanged(RecyclerView.Adapter oldAdapter, RecyclerView.Adapter newAdapter) {
        removeAllViews();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public Parcelable onSaveInstanceState() {
        if (this.mPendingSavedState != null) {
            return new SavedState(this.mPendingSavedState);
        }
        SavedState savedState = new SavedState();
        if (getChildCount() > 0) {
            View childClosestToStart = getChildClosestToStart();
            savedState.mAnchorPosition = getPosition(childClosestToStart);
            savedState.mAnchorOffset = this.mOrientationHelper.getDecoratedStart(childClosestToStart) - this.mOrientationHelper.getStartAfterPadding();
            return savedState;
        }
        savedState.invalidateAnchor();
        return savedState;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onRestoreInstanceState(Parcelable state) {
        if (state instanceof SavedState) {
            this.mPendingSavedState = (SavedState) state;
            requestLayout();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onItemsAdded(RecyclerView recyclerView, int positionStart, int itemCount) {
        super.onItemsAdded(recyclerView, positionStart, itemCount);
        updateDirtyPosition(positionStart);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onItemsUpdated(RecyclerView recyclerView, int positionStart, int itemCount, Object payload) {
        super.onItemsUpdated(recyclerView, positionStart, itemCount, payload);
        updateDirtyPosition(positionStart);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onItemsUpdated(RecyclerView recyclerView, int positionStart, int itemCount) {
        super.onItemsUpdated(recyclerView, positionStart, itemCount);
        updateDirtyPosition(positionStart);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onItemsRemoved(RecyclerView recyclerView, int positionStart, int itemCount) {
        super.onItemsRemoved(recyclerView, positionStart, itemCount);
        updateDirtyPosition(positionStart);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onItemsMoved(RecyclerView recyclerView, int from, int to, int itemCount) {
        super.onItemsMoved(recyclerView, from, to, itemCount);
        updateDirtyPosition(Math.min(from, to));
    }

    private void updateDirtyPosition(int positionStart) {
        if (positionStart >= findLastVisibleItemPosition()) {
            return;
        }
        int childCount = getChildCount();
        this.mFlexboxHelper.ensureMeasureSpecCache(childCount);
        this.mFlexboxHelper.ensureMeasuredSizeCache(childCount);
        this.mFlexboxHelper.ensureIndexToFlexLine(childCount);
        if (positionStart >= this.mFlexboxHelper.mIndexToFlexLine.length) {
            return;
        }
        this.mDirtyPosition = positionStart;
        View childClosestToStart = getChildClosestToStart();
        if (childClosestToStart == null) {
            return;
        }
        this.mPendingScrollPosition = getPosition(childClosestToStart);
        if (!isMainAxisDirectionHorizontal() && this.mIsRtl) {
            this.mPendingScrollPositionOffset = this.mOrientationHelper.getDecoratedEnd(childClosestToStart) + this.mOrientationHelper.getEndPadding();
        } else {
            this.mPendingScrollPositionOffset = this.mOrientationHelper.getDecoratedStart(childClosestToStart) - this.mOrientationHelper.getStartAfterPadding();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onLayoutChildren(RecyclerView.Recycler recycler, RecyclerView.State state) {
        int i;
        int i2;
        this.mRecycler = recycler;
        this.mState = state;
        int itemCount = state.getItemCount();
        if (itemCount == 0 && state.isPreLayout()) {
            return;
        }
        resolveLayoutDirection();
        ensureOrientationHelper();
        ensureLayoutState();
        this.mFlexboxHelper.ensureMeasureSpecCache(itemCount);
        this.mFlexboxHelper.ensureMeasuredSizeCache(itemCount);
        this.mFlexboxHelper.ensureIndexToFlexLine(itemCount);
        this.mLayoutState.mShouldRecycle = false;
        SavedState savedState = this.mPendingSavedState;
        if (savedState != null && savedState.hasValidAnchor(itemCount)) {
            this.mPendingScrollPosition = this.mPendingSavedState.mAnchorPosition;
        }
        if (!this.mAnchorInfo.mValid || this.mPendingScrollPosition != -1 || this.mPendingSavedState != null) {
            this.mAnchorInfo.reset();
            updateAnchorInfoForLayout(state, this.mAnchorInfo);
            this.mAnchorInfo.mValid = true;
        }
        detachAndScrapAttachedViews(recycler);
        boolean z = this.mAnchorInfo.mLayoutFromEnd;
        AnchorInfo anchorInfo = this.mAnchorInfo;
        if (z) {
            updateLayoutStateToFillStart(anchorInfo, false, true);
        } else {
            updateLayoutStateToFillEnd(anchorInfo, false, true);
        }
        updateFlexLines(itemCount);
        fill(recycler, state, this.mLayoutState);
        boolean z2 = this.mAnchorInfo.mLayoutFromEnd;
        LayoutState layoutState = this.mLayoutState;
        if (z2) {
            i2 = layoutState.mOffset;
            updateLayoutStateToFillEnd(this.mAnchorInfo, true, false);
            fill(recycler, state, this.mLayoutState);
            i = this.mLayoutState.mOffset;
        } else {
            i = layoutState.mOffset;
            updateLayoutStateToFillStart(this.mAnchorInfo, true, false);
            fill(recycler, state, this.mLayoutState);
            i2 = this.mLayoutState.mOffset;
        }
        if (getChildCount() > 0) {
            if (this.mAnchorInfo.mLayoutFromEnd) {
                fixLayoutStartGap(i2 + fixLayoutEndGap(i, recycler, state, true), recycler, state, false);
            } else {
                fixLayoutEndGap(i + fixLayoutStartGap(i2, recycler, state, true), recycler, state, false);
            }
        }
    }

    private int fixLayoutStartGap(int startOffset, RecyclerView.Recycler recycler, RecyclerView.State state, boolean canOffsetChildren) {
        int i;
        int startAfterPadding;
        if (!isMainAxisDirectionHorizontal() && this.mIsRtl) {
            int endAfterPadding = this.mOrientationHelper.getEndAfterPadding() - startOffset;
            if (endAfterPadding <= 0) {
                return 0;
            }
            i = handleScrollingMainOrientation(-endAfterPadding, recycler, state);
        } else {
            int startAfterPadding2 = startOffset - this.mOrientationHelper.getStartAfterPadding();
            if (startAfterPadding2 <= 0) {
                return 0;
            }
            i = -handleScrollingMainOrientation(startAfterPadding2, recycler, state);
        }
        int i2 = startOffset + i;
        if (!canOffsetChildren || (startAfterPadding = i2 - this.mOrientationHelper.getStartAfterPadding()) <= 0) {
            return i;
        }
        this.mOrientationHelper.offsetChildren(-startAfterPadding);
        return i - startAfterPadding;
    }

    private int fixLayoutEndGap(int endOffset, RecyclerView.Recycler recycler, RecyclerView.State state, boolean canOffsetChildren) {
        int i;
        int endAfterPadding;
        if (!isMainAxisDirectionHorizontal() && this.mIsRtl) {
            int startAfterPadding = endOffset - this.mOrientationHelper.getStartAfterPadding();
            if (startAfterPadding <= 0) {
                return 0;
            }
            i = handleScrollingMainOrientation(startAfterPadding, recycler, state);
        } else {
            int endAfterPadding2 = this.mOrientationHelper.getEndAfterPadding() - endOffset;
            if (endAfterPadding2 <= 0) {
                return 0;
            }
            i = -handleScrollingMainOrientation(-endAfterPadding2, recycler, state);
        }
        int i2 = endOffset + i;
        if (!canOffsetChildren || (endAfterPadding = this.mOrientationHelper.getEndAfterPadding() - i2) <= 0) {
            return i;
        }
        this.mOrientationHelper.offsetChildren(endAfterPadding);
        return endAfterPadding + i;
    }

    private void updateFlexLines(int childCount) {
        int i;
        int i2;
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(getWidth(), getWidthMode());
        int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(getHeight(), getHeightMode());
        int width = getWidth();
        int height = getHeight();
        boolean z = true;
        if (isMainAxisDirectionHorizontal()) {
            int i3 = this.mLastWidth;
            if (i3 == Integer.MIN_VALUE || i3 == width) {
                z = false;
            }
            i = this.mLayoutState.mInfinite ? this.mContext.getResources().getDisplayMetrics().heightPixels : this.mLayoutState.mAvailable;
        } else {
            int i4 = this.mLastHeight;
            if (i4 == Integer.MIN_VALUE || i4 == height) {
                z = false;
            }
            i = this.mLayoutState.mInfinite ? this.mContext.getResources().getDisplayMetrics().widthPixels : this.mLayoutState.mAvailable;
        }
        int i5 = i;
        this.mLastWidth = width;
        this.mLastHeight = height;
        int i6 = this.mDirtyPosition;
        if (i6 != -1 || (this.mPendingScrollPosition == -1 && !z)) {
            AnchorInfo anchorInfo = this.mAnchorInfo;
            int min = i6 != -1 ? Math.min(i6, anchorInfo.mPosition) : anchorInfo.mPosition;
            this.mFlexLinesResult.reset();
            boolean isMainAxisDirectionHorizontal = isMainAxisDirectionHorizontal();
            List<FlexLine> list = this.mFlexLines;
            if (isMainAxisDirectionHorizontal) {
                int size = list.size();
                FlexboxHelper flexboxHelper = this.mFlexboxHelper;
                if (size > 0) {
                    flexboxHelper.clearFlexLines(this.mFlexLines, min);
                    this.mFlexboxHelper.calculateFlexLines(this.mFlexLinesResult, makeMeasureSpec, makeMeasureSpec2, i5, min, this.mAnchorInfo.mPosition, this.mFlexLines);
                    i2 = min;
                    this.mFlexLines = this.mFlexLinesResult.mFlexLines;
                    this.mFlexboxHelper.determineMainSize(makeMeasureSpec, makeMeasureSpec2, i2);
                    this.mFlexboxHelper.stretchViews(i2);
                }
                i2 = min;
                flexboxHelper.ensureIndexToFlexLine(childCount);
                this.mFlexboxHelper.calculateHorizontalFlexLines(this.mFlexLinesResult, makeMeasureSpec, makeMeasureSpec2, i5, 0, this.mFlexLines);
                this.mFlexLines = this.mFlexLinesResult.mFlexLines;
                this.mFlexboxHelper.determineMainSize(makeMeasureSpec, makeMeasureSpec2, i2);
                this.mFlexboxHelper.stretchViews(i2);
            }
            i2 = min;
            int size2 = list.size();
            FlexboxHelper flexboxHelper2 = this.mFlexboxHelper;
            if (size2 > 0) {
                flexboxHelper2.clearFlexLines(this.mFlexLines, i2);
                min = i2;
                this.mFlexboxHelper.calculateFlexLines(this.mFlexLinesResult, makeMeasureSpec2, makeMeasureSpec, i5, min, this.mAnchorInfo.mPosition, this.mFlexLines);
                makeMeasureSpec2 = makeMeasureSpec2;
                makeMeasureSpec = makeMeasureSpec;
                i2 = min;
                this.mFlexLines = this.mFlexLinesResult.mFlexLines;
                this.mFlexboxHelper.determineMainSize(makeMeasureSpec, makeMeasureSpec2, i2);
                this.mFlexboxHelper.stretchViews(i2);
            }
            flexboxHelper2.ensureIndexToFlexLine(childCount);
            this.mFlexboxHelper.calculateVerticalFlexLines(this.mFlexLinesResult, makeMeasureSpec, makeMeasureSpec2, i5, 0, this.mFlexLines);
            this.mFlexLines = this.mFlexLinesResult.mFlexLines;
            this.mFlexboxHelper.determineMainSize(makeMeasureSpec, makeMeasureSpec2, i2);
            this.mFlexboxHelper.stretchViews(i2);
        } else if (this.mAnchorInfo.mLayoutFromEnd) {
        } else {
            this.mFlexLines.clear();
            this.mFlexLinesResult.reset();
            boolean isMainAxisDirectionHorizontal2 = isMainAxisDirectionHorizontal();
            FlexboxHelper flexboxHelper3 = this.mFlexboxHelper;
            if (isMainAxisDirectionHorizontal2) {
                flexboxHelper3.calculateHorizontalFlexLinesToIndex(this.mFlexLinesResult, makeMeasureSpec, makeMeasureSpec2, i5, this.mAnchorInfo.mPosition, this.mFlexLines);
            } else {
                flexboxHelper3.calculateVerticalFlexLinesToIndex(this.mFlexLinesResult, makeMeasureSpec, makeMeasureSpec2, i5, this.mAnchorInfo.mPosition, this.mFlexLines);
            }
            this.mFlexLines = this.mFlexLinesResult.mFlexLines;
            this.mFlexboxHelper.determineMainSize(makeMeasureSpec, makeMeasureSpec2);
            this.mFlexboxHelper.stretchViews();
            this.mAnchorInfo.mFlexLinePosition = this.mFlexboxHelper.mIndexToFlexLine[this.mAnchorInfo.mPosition];
            this.mLayoutState.mFlexLinePosition = this.mAnchorInfo.mFlexLinePosition;
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onLayoutCompleted(RecyclerView.State state) {
        super.onLayoutCompleted(state);
        this.mPendingSavedState = null;
        this.mPendingScrollPosition = -1;
        this.mPendingScrollPositionOffset = Integer.MIN_VALUE;
        this.mDirtyPosition = -1;
        this.mAnchorInfo.reset();
        this.mViewCache.clear();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean isLayoutRtl() {
        return this.mIsRtl;
    }

    private void resolveLayoutDirection() {
        int layoutDirection = getLayoutDirection();
        int i = this.mFlexDirection;
        if (i == 0) {
            this.mIsRtl = layoutDirection == 1;
            this.mFromBottomToTop = this.mFlexWrap == 2;
        } else if (i == 1) {
            this.mIsRtl = layoutDirection != 1;
            this.mFromBottomToTop = this.mFlexWrap == 2;
        } else if (i == 2) {
            boolean z = layoutDirection == 1;
            this.mIsRtl = z;
            if (this.mFlexWrap == 2) {
                this.mIsRtl = !z;
            }
            this.mFromBottomToTop = false;
        } else if (i == 3) {
            boolean z2 = layoutDirection == 1;
            this.mIsRtl = z2;
            if (this.mFlexWrap == 2) {
                this.mIsRtl = !z2;
            }
            this.mFromBottomToTop = true;
        } else {
            this.mIsRtl = false;
            this.mFromBottomToTop = false;
        }
    }

    private void updateAnchorInfoForLayout(RecyclerView.State state, AnchorInfo anchorInfo) {
        if (updateAnchorFromPendingState(state, anchorInfo, this.mPendingSavedState) || updateAnchorFromChildren(state, anchorInfo)) {
            return;
        }
        anchorInfo.assignCoordinateFromPadding();
        anchorInfo.mPosition = 0;
        anchorInfo.mFlexLinePosition = 0;
    }

    private boolean updateAnchorFromPendingState(RecyclerView.State state, AnchorInfo anchorInfo, SavedState savedState) {
        int i;
        View childAt;
        int decoratedStart;
        if (!state.isPreLayout() && (i = this.mPendingScrollPosition) != -1) {
            if (i < 0 || i >= state.getItemCount()) {
                this.mPendingScrollPosition = -1;
                this.mPendingScrollPositionOffset = Integer.MIN_VALUE;
            } else {
                anchorInfo.mPosition = this.mPendingScrollPosition;
                anchorInfo.mFlexLinePosition = this.mFlexboxHelper.mIndexToFlexLine[anchorInfo.mPosition];
                SavedState savedState2 = this.mPendingSavedState;
                if (savedState2 == null || !savedState2.hasValidAnchor(state.getItemCount())) {
                    if (this.mPendingScrollPositionOffset == Integer.MIN_VALUE) {
                        View findViewByPosition = findViewByPosition(this.mPendingScrollPosition);
                        if (findViewByPosition != null) {
                            if (this.mOrientationHelper.getDecoratedMeasurement(findViewByPosition) <= this.mOrientationHelper.getTotalSpace()) {
                                int decoratedStart2 = this.mOrientationHelper.getDecoratedStart(findViewByPosition) - this.mOrientationHelper.getStartAfterPadding();
                                OrientationHelper orientationHelper = this.mOrientationHelper;
                                if (decoratedStart2 >= 0) {
                                    if (orientationHelper.getEndAfterPadding() - this.mOrientationHelper.getDecoratedEnd(findViewByPosition) < 0) {
                                        anchorInfo.mCoordinate = this.mOrientationHelper.getEndAfterPadding();
                                        anchorInfo.mLayoutFromEnd = true;
                                        return true;
                                    }
                                    boolean z = anchorInfo.mLayoutFromEnd;
                                    OrientationHelper orientationHelper2 = this.mOrientationHelper;
                                    if (z) {
                                        decoratedStart = orientationHelper2.getDecoratedEnd(findViewByPosition) + this.mOrientationHelper.getTotalSpaceChange();
                                    } else {
                                        decoratedStart = orientationHelper2.getDecoratedStart(findViewByPosition);
                                    }
                                    anchorInfo.mCoordinate = decoratedStart;
                                } else {
                                    anchorInfo.mCoordinate = orientationHelper.getStartAfterPadding();
                                    anchorInfo.mLayoutFromEnd = false;
                                    return true;
                                }
                            } else {
                                anchorInfo.assignCoordinateFromPadding();
                                return true;
                            }
                        } else {
                            if (getChildCount() > 0 && (childAt = getChildAt(0)) != null) {
                                anchorInfo.mLayoutFromEnd = this.mPendingScrollPosition < getPosition(childAt);
                            }
                            anchorInfo.assignCoordinateFromPadding();
                        }
                        return true;
                    }
                    if (isMainAxisDirectionHorizontal() || !this.mIsRtl) {
                        anchorInfo.mCoordinate = this.mOrientationHelper.getStartAfterPadding() + this.mPendingScrollPositionOffset;
                    } else {
                        anchorInfo.mCoordinate = this.mPendingScrollPositionOffset - this.mOrientationHelper.getEndPadding();
                    }
                    return true;
                }
                anchorInfo.mCoordinate = this.mOrientationHelper.getStartAfterPadding() + savedState.mAnchorOffset;
                anchorInfo.mAssignedFromSavedState = true;
                anchorInfo.mFlexLinePosition = -1;
                return true;
            }
        }
        return false;
    }

    private boolean updateAnchorFromChildren(RecyclerView.State state, AnchorInfo anchorInfo) {
        View findFirstReferenceChild;
        int startAfterPadding;
        if (getChildCount() == 0) {
            return false;
        }
        if (anchorInfo.mLayoutFromEnd) {
            findFirstReferenceChild = findLastReferenceChild(state.getItemCount());
        } else {
            findFirstReferenceChild = findFirstReferenceChild(state.getItemCount());
        }
        if (findFirstReferenceChild != null) {
            anchorInfo.assignFromView(findFirstReferenceChild);
            if (state.isPreLayout() || !supportsPredictiveItemAnimations()) {
                return true;
            }
            if (this.mOrientationHelper.getDecoratedStart(findFirstReferenceChild) >= this.mOrientationHelper.getEndAfterPadding() || this.mOrientationHelper.getDecoratedEnd(findFirstReferenceChild) < this.mOrientationHelper.getStartAfterPadding()) {
                boolean z = anchorInfo.mLayoutFromEnd;
                OrientationHelper orientationHelper = this.mOrientationHelper;
                if (z) {
                    startAfterPadding = orientationHelper.getEndAfterPadding();
                } else {
                    startAfterPadding = orientationHelper.getStartAfterPadding();
                }
                anchorInfo.mCoordinate = startAfterPadding;
                return true;
            }
            return true;
        }
        return false;
    }

    private View findFirstReferenceChild(int itemCount) {
        View findReferenceChild = findReferenceChild(0, getChildCount(), itemCount);
        if (findReferenceChild == null) {
            return null;
        }
        int i = this.mFlexboxHelper.mIndexToFlexLine[getPosition(findReferenceChild)];
        if (i == -1) {
            return null;
        }
        return findFirstReferenceViewInLine(findReferenceChild, this.mFlexLines.get(i));
    }

    private View findLastReferenceChild(int itemCount) {
        View findReferenceChild = findReferenceChild(getChildCount() - 1, -1, itemCount);
        if (findReferenceChild == null) {
            return null;
        }
        return findLastReferenceViewInLine(findReferenceChild, this.mFlexLines.get(this.mFlexboxHelper.mIndexToFlexLine[getPosition(findReferenceChild)]));
    }

    private View findReferenceChild(int start, int end, int itemCount) {
        int position;
        ensureOrientationHelper();
        ensureLayoutState();
        int startAfterPadding = this.mOrientationHelper.getStartAfterPadding();
        int endAfterPadding = this.mOrientationHelper.getEndAfterPadding();
        int i = end > start ? 1 : -1;
        View view = null;
        View view2 = null;
        while (start != end) {
            View childAt = getChildAt(start);
            if (childAt != null && (position = getPosition(childAt)) >= 0 && position < itemCount) {
                if (((RecyclerView.LayoutParams) childAt.getLayoutParams()).isItemRemoved()) {
                    if (view2 == null) {
                        view2 = childAt;
                    }
                } else if (this.mOrientationHelper.getDecoratedStart(childAt) >= startAfterPadding && this.mOrientationHelper.getDecoratedEnd(childAt) <= endAfterPadding) {
                    return childAt;
                } else {
                    if (view == null) {
                        view = childAt;
                    }
                }
            }
            start += i;
        }
        return view != null ? view : view2;
    }

    private View getChildClosestToStart() {
        return getChildAt(0);
    }

    private int fill(RecyclerView.Recycler recycler, RecyclerView.State state, LayoutState layoutState) {
        if (layoutState.mScrollingOffset != Integer.MIN_VALUE) {
            if (layoutState.mAvailable < 0) {
                LayoutState.access$2012(layoutState, layoutState.mAvailable);
            }
            recycleByLayoutState(recycler, layoutState);
        }
        int i = layoutState.mAvailable;
        int i2 = layoutState.mAvailable;
        boolean isMainAxisDirectionHorizontal = isMainAxisDirectionHorizontal();
        int i3 = 0;
        while (true) {
            if ((i2 > 0 || this.mLayoutState.mInfinite) && layoutState.hasMore(state, this.mFlexLines)) {
                FlexLine flexLine = this.mFlexLines.get(layoutState.mFlexLinePosition);
                layoutState.mPosition = flexLine.mFirstIndex;
                i3 += layoutFlexLine(flexLine, layoutState);
                if (isMainAxisDirectionHorizontal || !this.mIsRtl) {
                    LayoutState.access$1012(layoutState, flexLine.getCrossSize() * layoutState.mLayoutDirection);
                } else {
                    LayoutState.access$1020(layoutState, flexLine.getCrossSize() * layoutState.mLayoutDirection);
                }
                i2 -= flexLine.getCrossSize();
            }
        }
        LayoutState.access$1220(layoutState, i3);
        if (layoutState.mScrollingOffset != Integer.MIN_VALUE) {
            LayoutState.access$2012(layoutState, i3);
            if (layoutState.mAvailable < 0) {
                LayoutState.access$2012(layoutState, layoutState.mAvailable);
            }
            recycleByLayoutState(recycler, layoutState);
        }
        return i - layoutState.mAvailable;
    }

    private void recycleByLayoutState(RecyclerView.Recycler recycler, LayoutState layoutState) {
        if (layoutState.mShouldRecycle) {
            if (layoutState.mLayoutDirection == -1) {
                recycleFlexLinesFromEnd(recycler, layoutState);
            } else {
                recycleFlexLinesFromStart(recycler, layoutState);
            }
        }
    }

    private void recycleFlexLinesFromStart(RecyclerView.Recycler recycler, LayoutState layoutState) {
        int childCount;
        View childAt;
        if (layoutState.mScrollingOffset < 0 || (childCount = getChildCount()) == 0 || (childAt = getChildAt(0)) == null) {
            return;
        }
        int i = this.mFlexboxHelper.mIndexToFlexLine[getPosition(childAt)];
        int i2 = -1;
        if (i == -1) {
            return;
        }
        FlexLine flexLine = this.mFlexLines.get(i);
        int i3 = 0;
        while (true) {
            if (i3 >= childCount) {
                break;
            }
            View childAt2 = getChildAt(i3);
            if (childAt2 != null) {
                if (!canViewBeRecycledFromStart(childAt2, layoutState.mScrollingOffset)) {
                    break;
                } else if (flexLine.mLastIndex != getPosition(childAt2)) {
                    continue;
                } else if (i >= this.mFlexLines.size() - 1) {
                    i2 = i3;
                    break;
                } else {
                    i += layoutState.mLayoutDirection;
                    flexLine = this.mFlexLines.get(i);
                    i2 = i3;
                }
            }
            i3++;
        }
        recycleChildren(recycler, 0, i2);
    }

    private boolean canViewBeRecycledFromStart(View view, int scrollingOffset) {
        return (isMainAxisDirectionHorizontal() || !this.mIsRtl) ? this.mOrientationHelper.getDecoratedEnd(view) <= scrollingOffset : this.mOrientationHelper.getEnd() - this.mOrientationHelper.getDecoratedStart(view) <= scrollingOffset;
    }

    private void recycleFlexLinesFromEnd(RecyclerView.Recycler recycler, LayoutState layoutState) {
        int childCount;
        int i;
        View childAt;
        int i2;
        if (layoutState.mScrollingOffset < 0 || (childCount = getChildCount()) == 0 || (childAt = getChildAt(childCount - 1)) == null || (i2 = this.mFlexboxHelper.mIndexToFlexLine[getPosition(childAt)]) == -1) {
            return;
        }
        FlexLine flexLine = this.mFlexLines.get(i2);
        int i3 = i;
        while (true) {
            if (i3 < 0) {
                break;
            }
            View childAt2 = getChildAt(i3);
            if (childAt2 != null) {
                if (!canViewBeRecycledFromEnd(childAt2, layoutState.mScrollingOffset)) {
                    break;
                } else if (flexLine.mFirstIndex != getPosition(childAt2)) {
                    continue;
                } else if (i2 <= 0) {
                    childCount = i3;
                    break;
                } else {
                    i2 += layoutState.mLayoutDirection;
                    flexLine = this.mFlexLines.get(i2);
                    childCount = i3;
                }
            }
            i3--;
        }
        recycleChildren(recycler, childCount, i);
    }

    private boolean canViewBeRecycledFromEnd(View view, int scrollingOffset) {
        return (isMainAxisDirectionHorizontal() || !this.mIsRtl) ? this.mOrientationHelper.getDecoratedStart(view) >= this.mOrientationHelper.getEnd() - scrollingOffset : this.mOrientationHelper.getDecoratedEnd(view) <= scrollingOffset;
    }

    private void recycleChildren(RecyclerView.Recycler recycler, int startIndex, int endIndex) {
        while (endIndex >= startIndex) {
            removeAndRecycleViewAt(endIndex, recycler);
            endIndex--;
        }
    }

    private int layoutFlexLine(FlexLine flexLine, LayoutState layoutState) {
        if (isMainAxisDirectionHorizontal()) {
            return layoutFlexLineMainAxisHorizontal(flexLine, layoutState);
        }
        return layoutFlexLineMainAxisVertical(flexLine, layoutState);
    }

    /* JADX WARN: Removed duplicated region for block: B:40:0x00d5  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private int layoutFlexLineMainAxisHorizontal(FlexLine flexLine, LayoutState layoutState) {
        float f;
        float f2;
        float f3;
        int itemCount;
        int i;
        LayoutParams layoutParams;
        FlexLine flexLine2 = flexLine;
        int paddingLeft = getPaddingLeft();
        int paddingRight = getPaddingRight();
        int width = getWidth();
        int i2 = layoutState.mOffset;
        if (layoutState.mLayoutDirection == -1) {
            i2 -= flexLine2.mCrossSize;
        }
        int i3 = i2;
        int i4 = layoutState.mPosition;
        int i5 = this.mJustifyContent;
        if (i5 == 0) {
            f = paddingLeft;
            f2 = width - paddingRight;
        } else if (i5 == 1) {
            float f4 = (width - flexLine2.mMainSize) + paddingRight;
            f2 = flexLine2.mMainSize - paddingLeft;
            f = f4;
        } else if (i5 == 2) {
            f = paddingLeft + ((width - flexLine2.mMainSize) / 2.0f);
            f2 = (width - paddingRight) - ((width - flexLine2.mMainSize) / 2.0f);
        } else {
            if (i5 == 3) {
                f = paddingLeft;
                f3 = (width - flexLine2.mMainSize) / (flexLine2.mItemCount != 1 ? flexLine2.mItemCount - 1 : 1.0f);
                f2 = width - paddingRight;
            } else if (i5 == 4) {
                f3 = flexLine2.mItemCount != 0 ? (width - flexLine2.mMainSize) / flexLine2.mItemCount : 0.0f;
                float f5 = f3 / 2.0f;
                f = paddingLeft + f5;
                f2 = (width - paddingRight) - f5;
            } else if (i5 == 5) {
                f3 = flexLine2.mItemCount != 0 ? (width - flexLine2.mMainSize) / (flexLine2.mItemCount + 1) : 0.0f;
                f = paddingLeft + f3;
                f2 = (width - paddingRight) - f3;
            } else {
                throw new IllegalStateException("Invalid justifyContent is set: " + this.mJustifyContent);
            }
            float f6 = f - this.mAnchorInfo.mPerpendicularCoordinate;
            float f7 = f2 - this.mAnchorInfo.mPerpendicularCoordinate;
            float max = Math.max(f3, 0.0f);
            itemCount = flexLine2.getItemCount();
            int i6 = 0;
            i = i4;
            while (i < i4 + itemCount) {
                float f8 = f7;
                View flexItemAt = getFlexItemAt(i);
                if (flexItemAt == null) {
                    f7 = f8;
                } else {
                    if (layoutState.mLayoutDirection == 1) {
                        calculateItemDecorationsForChild(flexItemAt, TEMP_RECT);
                        addView(flexItemAt);
                    } else {
                        calculateItemDecorationsForChild(flexItemAt, TEMP_RECT);
                        addView(flexItemAt, i6);
                        i6++;
                    }
                    int i7 = i6;
                    long j = this.mFlexboxHelper.mMeasureSpecCache[i];
                    int extractLowerInt = this.mFlexboxHelper.extractLowerInt(j);
                    int extractHigherInt = this.mFlexboxHelper.extractHigherInt(j);
                    if (shouldMeasureChild(flexItemAt, extractLowerInt, extractHigherInt, (LayoutParams) flexItemAt.getLayoutParams())) {
                        flexItemAt.measure(extractLowerInt, extractHigherInt);
                    }
                    float leftDecorationWidth = f6 + layoutParams.leftMargin + getLeftDecorationWidth(flexItemAt);
                    float rightDecorationWidth = f8 - (layoutParams.rightMargin + getRightDecorationWidth(flexItemAt));
                    int topDecorationHeight = i3 + getTopDecorationHeight(flexItemAt);
                    boolean z = this.mIsRtl;
                    FlexboxHelper flexboxHelper = this.mFlexboxHelper;
                    if (z) {
                        flexboxHelper.layoutSingleChildHorizontal(flexItemAt, flexLine2, Math.round(rightDecorationWidth) - flexItemAt.getMeasuredWidth(), topDecorationHeight, Math.round(rightDecorationWidth), flexItemAt.getMeasuredHeight() + topDecorationHeight);
                    } else {
                        flexboxHelper.layoutSingleChildHorizontal(flexItemAt, flexLine, Math.round(leftDecorationWidth), topDecorationHeight, flexItemAt.getMeasuredWidth() + Math.round(leftDecorationWidth), topDecorationHeight + flexItemAt.getMeasuredHeight());
                    }
                    i6 = i7;
                    f6 = leftDecorationWidth + flexItemAt.getMeasuredWidth() + layoutParams.rightMargin + getRightDecorationWidth(flexItemAt) + max;
                    f7 = rightDecorationWidth - (((flexItemAt.getMeasuredWidth() + layoutParams.leftMargin) + getLeftDecorationWidth(flexItemAt)) + max);
                }
                i++;
                flexLine2 = flexLine;
            }
            LayoutState.access$1512(layoutState, this.mLayoutState.mLayoutDirection);
            return flexLine.getCrossSize();
        }
        f3 = 0.0f;
        float f62 = f - this.mAnchorInfo.mPerpendicularCoordinate;
        float f72 = f2 - this.mAnchorInfo.mPerpendicularCoordinate;
        float max2 = Math.max(f3, 0.0f);
        itemCount = flexLine2.getItemCount();
        int i62 = 0;
        i = i4;
        while (i < i4 + itemCount) {
        }
        LayoutState.access$1512(layoutState, this.mLayoutState.mLayoutDirection);
        return flexLine.getCrossSize();
    }

    /* JADX WARN: Removed duplicated region for block: B:40:0x00dd  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private int layoutFlexLineMainAxisVertical(FlexLine flexLine, LayoutState layoutState) {
        float f;
        float f2;
        float f3;
        int itemCount;
        int i;
        LayoutParams layoutParams;
        boolean z;
        FlexLine flexLine2 = flexLine;
        int paddingTop = getPaddingTop();
        int paddingBottom = getPaddingBottom();
        int height = getHeight();
        int i2 = layoutState.mOffset;
        int i3 = layoutState.mOffset;
        if (layoutState.mLayoutDirection == -1) {
            i2 -= flexLine2.mCrossSize;
            i3 += flexLine2.mCrossSize;
        }
        int i4 = i2;
        int i5 = i3;
        int i6 = layoutState.mPosition;
        int i7 = this.mJustifyContent;
        boolean z2 = true;
        if (i7 == 0) {
            f = paddingTop;
            f2 = height - paddingBottom;
        } else if (i7 == 1) {
            float f4 = (height - flexLine2.mMainSize) + paddingBottom;
            f2 = flexLine2.mMainSize - paddingTop;
            f = f4;
        } else if (i7 == 2) {
            f = paddingTop + ((height - flexLine2.mMainSize) / 2.0f);
            f2 = (height - paddingBottom) - ((height - flexLine2.mMainSize) / 2.0f);
        } else {
            if (i7 == 3) {
                f = paddingTop;
                f3 = (height - flexLine2.mMainSize) / (flexLine2.mItemCount != 1 ? flexLine2.mItemCount - 1 : 1.0f);
                f2 = height - paddingBottom;
            } else if (i7 == 4) {
                f3 = flexLine2.mItemCount != 0 ? (height - flexLine2.mMainSize) / flexLine2.mItemCount : 0.0f;
                float f5 = f3 / 2.0f;
                f = paddingTop + f5;
                f2 = (height - paddingBottom) - f5;
            } else if (i7 == 5) {
                f3 = flexLine2.mItemCount != 0 ? (height - flexLine2.mMainSize) / (flexLine2.mItemCount + 1) : 0.0f;
                f = paddingTop + f3;
                f2 = (height - paddingBottom) - f3;
            } else {
                throw new IllegalStateException("Invalid justifyContent is set: " + this.mJustifyContent);
            }
            float f6 = f - this.mAnchorInfo.mPerpendicularCoordinate;
            float f7 = f2 - this.mAnchorInfo.mPerpendicularCoordinate;
            float max = Math.max(f3, 0.0f);
            itemCount = flexLine2.getItemCount();
            int i8 = 0;
            i = i6;
            while (i < i6 + itemCount) {
                float f8 = f7;
                View flexItemAt = getFlexItemAt(i);
                if (flexItemAt == null) {
                    f7 = f8;
                    z = z2;
                } else {
                    long j = this.mFlexboxHelper.mMeasureSpecCache[i];
                    int extractLowerInt = this.mFlexboxHelper.extractLowerInt(j);
                    int extractHigherInt = this.mFlexboxHelper.extractHigherInt(j);
                    if (shouldMeasureChild(flexItemAt, extractLowerInt, extractHigherInt, (LayoutParams) flexItemAt.getLayoutParams())) {
                        flexItemAt.measure(extractLowerInt, extractHigherInt);
                    }
                    float topDecorationHeight = f6 + layoutParams.topMargin + getTopDecorationHeight(flexItemAt);
                    float bottomDecorationHeight = f8 - (layoutParams.rightMargin + getBottomDecorationHeight(flexItemAt));
                    if (layoutState.mLayoutDirection == 1) {
                        calculateItemDecorationsForChild(flexItemAt, TEMP_RECT);
                        addView(flexItemAt);
                    } else {
                        calculateItemDecorationsForChild(flexItemAt, TEMP_RECT);
                        addView(flexItemAt, i8);
                        i8++;
                    }
                    int i9 = i8;
                    int leftDecorationWidth = getLeftDecorationWidth(flexItemAt) + i4;
                    int rightDecorationWidth = i5 - getRightDecorationWidth(flexItemAt);
                    boolean z3 = this.mIsRtl;
                    boolean z4 = this.mFromBottomToTop;
                    if (z3) {
                        FlexboxHelper flexboxHelper = this.mFlexboxHelper;
                        if (z4) {
                            z = true;
                            flexboxHelper.layoutSingleChildVertical(flexItemAt, flexLine2, z3, rightDecorationWidth - flexItemAt.getMeasuredWidth(), Math.round(bottomDecorationHeight) - flexItemAt.getMeasuredHeight(), rightDecorationWidth, Math.round(bottomDecorationHeight));
                        } else {
                            z = true;
                            flexboxHelper.layoutSingleChildVertical(flexItemAt, flexLine, z3, rightDecorationWidth - flexItemAt.getMeasuredWidth(), Math.round(topDecorationHeight), rightDecorationWidth, flexItemAt.getMeasuredHeight() + Math.round(topDecorationHeight));
                        }
                    } else {
                        z = true;
                        FlexboxHelper flexboxHelper2 = this.mFlexboxHelper;
                        if (z4) {
                            flexboxHelper2.layoutSingleChildVertical(flexItemAt, flexLine, z3, leftDecorationWidth, Math.round(bottomDecorationHeight) - flexItemAt.getMeasuredHeight(), leftDecorationWidth + flexItemAt.getMeasuredWidth(), Math.round(bottomDecorationHeight));
                        } else {
                            flexboxHelper2.layoutSingleChildVertical(flexItemAt, flexLine, z3, leftDecorationWidth, Math.round(topDecorationHeight), leftDecorationWidth + flexItemAt.getMeasuredWidth(), flexItemAt.getMeasuredHeight() + Math.round(topDecorationHeight));
                        }
                    }
                    i8 = i9;
                    f6 = topDecorationHeight + flexItemAt.getMeasuredHeight() + layoutParams.topMargin + getBottomDecorationHeight(flexItemAt) + max;
                    f7 = bottomDecorationHeight - (((flexItemAt.getMeasuredHeight() + layoutParams.bottomMargin) + getTopDecorationHeight(flexItemAt)) + max);
                }
                i++;
                flexLine2 = flexLine;
                z2 = z;
            }
            LayoutState.access$1512(layoutState, this.mLayoutState.mLayoutDirection);
            return flexLine.getCrossSize();
        }
        f3 = 0.0f;
        float f62 = f - this.mAnchorInfo.mPerpendicularCoordinate;
        float f72 = f2 - this.mAnchorInfo.mPerpendicularCoordinate;
        float max2 = Math.max(f3, 0.0f);
        itemCount = flexLine2.getItemCount();
        int i82 = 0;
        i = i6;
        while (i < i6 + itemCount) {
        }
        LayoutState.access$1512(layoutState, this.mLayoutState.mLayoutDirection);
        return flexLine.getCrossSize();
    }

    @Override // com.google.android.flexbox.FlexContainer
    public boolean isMainAxisDirectionHorizontal() {
        int i = this.mFlexDirection;
        return i == 0 || i == 1;
    }

    private void updateLayoutStateToFillEnd(AnchorInfo anchorInfo, boolean fromNextLine, boolean considerInfinite) {
        if (considerInfinite) {
            resolveInfiniteAmount();
        } else {
            this.mLayoutState.mInfinite = false;
        }
        if (!isMainAxisDirectionHorizontal() && this.mIsRtl) {
            this.mLayoutState.mAvailable = anchorInfo.mCoordinate - getPaddingRight();
        } else {
            this.mLayoutState.mAvailable = this.mOrientationHelper.getEndAfterPadding() - anchorInfo.mCoordinate;
        }
        this.mLayoutState.mPosition = anchorInfo.mPosition;
        this.mLayoutState.mItemDirection = 1;
        this.mLayoutState.mLayoutDirection = 1;
        this.mLayoutState.mOffset = anchorInfo.mCoordinate;
        this.mLayoutState.mScrollingOffset = Integer.MIN_VALUE;
        this.mLayoutState.mFlexLinePosition = anchorInfo.mFlexLinePosition;
        if (!fromNextLine || this.mFlexLines.size() <= 1 || anchorInfo.mFlexLinePosition < 0 || anchorInfo.mFlexLinePosition >= this.mFlexLines.size() - 1) {
            return;
        }
        LayoutState.access$1508(this.mLayoutState);
        LayoutState.access$2212(this.mLayoutState, this.mFlexLines.get(anchorInfo.mFlexLinePosition).getItemCount());
    }

    private void updateLayoutStateToFillStart(AnchorInfo anchorInfo, boolean fromPreviousLine, boolean considerInfinite) {
        if (considerInfinite) {
            resolveInfiniteAmount();
        } else {
            this.mLayoutState.mInfinite = false;
        }
        if (!isMainAxisDirectionHorizontal() && this.mIsRtl) {
            this.mLayoutState.mAvailable = (this.mParent.getWidth() - anchorInfo.mCoordinate) - this.mOrientationHelper.getStartAfterPadding();
        } else {
            this.mLayoutState.mAvailable = anchorInfo.mCoordinate - this.mOrientationHelper.getStartAfterPadding();
        }
        this.mLayoutState.mPosition = anchorInfo.mPosition;
        this.mLayoutState.mItemDirection = 1;
        this.mLayoutState.mLayoutDirection = -1;
        this.mLayoutState.mOffset = anchorInfo.mCoordinate;
        this.mLayoutState.mScrollingOffset = Integer.MIN_VALUE;
        this.mLayoutState.mFlexLinePosition = anchorInfo.mFlexLinePosition;
        if (!fromPreviousLine || anchorInfo.mFlexLinePosition <= 0 || this.mFlexLines.size() <= anchorInfo.mFlexLinePosition) {
            return;
        }
        LayoutState.access$1510(this.mLayoutState);
        LayoutState.access$2220(this.mLayoutState, this.mFlexLines.get(anchorInfo.mFlexLinePosition).getItemCount());
    }

    private void resolveInfiniteAmount() {
        int widthMode;
        if (isMainAxisDirectionHorizontal()) {
            widthMode = getHeightMode();
        } else {
            widthMode = getWidthMode();
        }
        this.mLayoutState.mInfinite = widthMode == 0 || widthMode == Integer.MIN_VALUE;
    }

    private void ensureOrientationHelper() {
        if (this.mOrientationHelper != null) {
            return;
        }
        boolean isMainAxisDirectionHorizontal = isMainAxisDirectionHorizontal();
        int i = this.mFlexWrap;
        if (isMainAxisDirectionHorizontal) {
            if (i == 0) {
                this.mOrientationHelper = OrientationHelper.createHorizontalHelper(this);
                this.mSubOrientationHelper = OrientationHelper.createVerticalHelper(this);
                return;
            }
            this.mOrientationHelper = OrientationHelper.createVerticalHelper(this);
            this.mSubOrientationHelper = OrientationHelper.createHorizontalHelper(this);
        } else if (i == 0) {
            this.mOrientationHelper = OrientationHelper.createVerticalHelper(this);
            this.mSubOrientationHelper = OrientationHelper.createHorizontalHelper(this);
        } else {
            this.mOrientationHelper = OrientationHelper.createHorizontalHelper(this);
            this.mSubOrientationHelper = OrientationHelper.createVerticalHelper(this);
        }
    }

    private void ensureLayoutState() {
        if (this.mLayoutState == null) {
            this.mLayoutState = new LayoutState();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void scrollToPosition(int position) {
        this.mPendingScrollPosition = position;
        this.mPendingScrollPositionOffset = Integer.MIN_VALUE;
        SavedState savedState = this.mPendingSavedState;
        if (savedState != null) {
            savedState.invalidateAnchor();
        }
        requestLayout();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void smoothScrollToPosition(RecyclerView recyclerView, RecyclerView.State state, int position) {
        LinearSmoothScroller linearSmoothScroller = new LinearSmoothScroller(recyclerView.getContext());
        linearSmoothScroller.setTargetPosition(position);
        startSmoothScroll(linearSmoothScroller);
    }

    public boolean getRecycleChildrenOnDetach() {
        return this.mRecycleChildrenOnDetach;
    }

    public void setRecycleChildrenOnDetach(boolean recycleChildrenOnDetach) {
        this.mRecycleChildrenOnDetach = recycleChildrenOnDetach;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onAttachedToWindow(RecyclerView recyclerView) {
        super.onAttachedToWindow(recyclerView);
        this.mParent = (View) recyclerView.getParent();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onDetachedFromWindow(RecyclerView view, RecyclerView.Recycler recycler) {
        super.onDetachedFromWindow(view, recycler);
        if (this.mRecycleChildrenOnDetach) {
            removeAndRecycleAllViews(recycler);
            recycler.clear();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public boolean canScrollHorizontally() {
        if (this.mFlexWrap == 0) {
            return isMainAxisDirectionHorizontal();
        }
        if (isMainAxisDirectionHorizontal()) {
            int width = getWidth();
            View view = this.mParent;
            return width > (view != null ? view.getWidth() : 0);
        }
        return true;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public boolean canScrollVertically() {
        if (this.mFlexWrap == 0) {
            return !isMainAxisDirectionHorizontal();
        }
        if (!isMainAxisDirectionHorizontal()) {
            int height = getHeight();
            View view = this.mParent;
            if (height <= (view != null ? view.getHeight() : 0)) {
                return false;
            }
        }
        return true;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int scrollHorizontallyBy(int dx, RecyclerView.Recycler recycler, RecyclerView.State state) {
        if (!isMainAxisDirectionHorizontal() || this.mFlexWrap == 0) {
            int handleScrollingMainOrientation = handleScrollingMainOrientation(dx, recycler, state);
            this.mViewCache.clear();
            return handleScrollingMainOrientation;
        }
        int handleScrollingSubOrientation = handleScrollingSubOrientation(dx);
        AnchorInfo.access$2412(this.mAnchorInfo, handleScrollingSubOrientation);
        this.mSubOrientationHelper.offsetChildren(-handleScrollingSubOrientation);
        return handleScrollingSubOrientation;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int scrollVerticallyBy(int dy, RecyclerView.Recycler recycler, RecyclerView.State state) {
        if (isMainAxisDirectionHorizontal() || (this.mFlexWrap == 0 && !isMainAxisDirectionHorizontal())) {
            int handleScrollingMainOrientation = handleScrollingMainOrientation(dy, recycler, state);
            this.mViewCache.clear();
            return handleScrollingMainOrientation;
        }
        int handleScrollingSubOrientation = handleScrollingSubOrientation(dy);
        AnchorInfo.access$2412(this.mAnchorInfo, handleScrollingSubOrientation);
        this.mSubOrientationHelper.offsetChildren(-handleScrollingSubOrientation);
        return handleScrollingSubOrientation;
    }

    private int handleScrollingMainOrientation(int delta, RecyclerView.Recycler recycler, RecyclerView.State state) {
        if (getChildCount() == 0 || delta == 0) {
            return 0;
        }
        ensureOrientationHelper();
        int i = 1;
        this.mLayoutState.mShouldRecycle = true;
        boolean z = !isMainAxisDirectionHorizontal() && this.mIsRtl;
        if (!z ? delta <= 0 : delta >= 0) {
            i = -1;
        }
        int abs = Math.abs(delta);
        updateLayoutState(i, abs);
        int fill = this.mLayoutState.mScrollingOffset + fill(recycler, state, this.mLayoutState);
        if (fill < 0) {
            return 0;
        }
        if (z) {
            if (abs > fill) {
                delta = (-i) * fill;
            }
        } else if (abs > fill) {
            delta = i * fill;
        }
        this.mOrientationHelper.offsetChildren(-delta);
        this.mLayoutState.mLastScrollDelta = delta;
        return delta;
    }

    private int handleScrollingSubOrientation(int delta) {
        if (getChildCount() == 0 || delta == 0) {
            return 0;
        }
        ensureOrientationHelper();
        boolean isMainAxisDirectionHorizontal = isMainAxisDirectionHorizontal();
        View view = this.mParent;
        int width = isMainAxisDirectionHorizontal ? view.getWidth() : view.getHeight();
        int width2 = isMainAxisDirectionHorizontal ? getWidth() : getHeight();
        if (getLayoutDirection() == 1) {
            int abs = Math.abs(delta);
            AnchorInfo anchorInfo = this.mAnchorInfo;
            if (delta < 0) {
                return -Math.min((width2 + anchorInfo.mPerpendicularCoordinate) - width, abs);
            }
            if (anchorInfo.mPerpendicularCoordinate + delta > 0) {
                return -this.mAnchorInfo.mPerpendicularCoordinate;
            }
        } else {
            AnchorInfo anchorInfo2 = this.mAnchorInfo;
            if (delta > 0) {
                return Math.min((width2 - anchorInfo2.mPerpendicularCoordinate) - width, delta);
            }
            if (anchorInfo2.mPerpendicularCoordinate + delta < 0) {
                return -this.mAnchorInfo.mPerpendicularCoordinate;
            }
        }
        return delta;
    }

    private void updateLayoutState(int layoutDirection, int absDelta) {
        this.mLayoutState.mLayoutDirection = layoutDirection;
        boolean isMainAxisDirectionHorizontal = isMainAxisDirectionHorizontal();
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(getWidth(), getWidthMode());
        int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(getHeight(), getHeightMode());
        boolean z = !isMainAxisDirectionHorizontal && this.mIsRtl;
        if (layoutDirection == 1) {
            View childAt = getChildAt(getChildCount() - 1);
            if (childAt == null) {
                return;
            }
            this.mLayoutState.mOffset = this.mOrientationHelper.getDecoratedEnd(childAt);
            int position = getPosition(childAt);
            View findLastReferenceViewInLine = findLastReferenceViewInLine(childAt, this.mFlexLines.get(this.mFlexboxHelper.mIndexToFlexLine[position]));
            this.mLayoutState.mItemDirection = 1;
            LayoutState layoutState = this.mLayoutState;
            layoutState.mPosition = position + layoutState.mItemDirection;
            int length = this.mFlexboxHelper.mIndexToFlexLine.length;
            int i = this.mLayoutState.mPosition;
            LayoutState layoutState2 = this.mLayoutState;
            if (length <= i) {
                layoutState2.mFlexLinePosition = -1;
            } else {
                layoutState2.mFlexLinePosition = this.mFlexboxHelper.mIndexToFlexLine[this.mLayoutState.mPosition];
            }
            LayoutState layoutState3 = this.mLayoutState;
            if (z) {
                layoutState3.mOffset = this.mOrientationHelper.getDecoratedStart(findLastReferenceViewInLine);
                this.mLayoutState.mScrollingOffset = (-this.mOrientationHelper.getDecoratedStart(findLastReferenceViewInLine)) + this.mOrientationHelper.getStartAfterPadding();
                LayoutState layoutState4 = this.mLayoutState;
                layoutState4.mScrollingOffset = Math.max(layoutState4.mScrollingOffset, 0);
            } else {
                layoutState3.mOffset = this.mOrientationHelper.getDecoratedEnd(findLastReferenceViewInLine);
                this.mLayoutState.mScrollingOffset = this.mOrientationHelper.getDecoratedEnd(findLastReferenceViewInLine) - this.mOrientationHelper.getEndAfterPadding();
            }
            if ((this.mLayoutState.mFlexLinePosition == -1 || this.mLayoutState.mFlexLinePosition > this.mFlexLines.size() - 1) && this.mLayoutState.mPosition <= getFlexItemCount()) {
                int i2 = absDelta - this.mLayoutState.mScrollingOffset;
                this.mFlexLinesResult.reset();
                if (i2 > 0) {
                    FlexboxHelper flexboxHelper = this.mFlexboxHelper;
                    if (isMainAxisDirectionHorizontal) {
                        flexboxHelper.calculateHorizontalFlexLines(this.mFlexLinesResult, makeMeasureSpec, makeMeasureSpec2, i2, this.mLayoutState.mPosition, this.mFlexLines);
                    } else {
                        flexboxHelper.calculateVerticalFlexLines(this.mFlexLinesResult, makeMeasureSpec, makeMeasureSpec2, i2, this.mLayoutState.mPosition, this.mFlexLines);
                    }
                    this.mFlexboxHelper.determineMainSize(makeMeasureSpec, makeMeasureSpec2, this.mLayoutState.mPosition);
                    this.mFlexboxHelper.stretchViews(this.mLayoutState.mPosition);
                }
            }
        } else {
            View childAt2 = getChildAt(0);
            if (childAt2 == null) {
                return;
            }
            this.mLayoutState.mOffset = this.mOrientationHelper.getDecoratedStart(childAt2);
            int position2 = getPosition(childAt2);
            View findFirstReferenceViewInLine = findFirstReferenceViewInLine(childAt2, this.mFlexLines.get(this.mFlexboxHelper.mIndexToFlexLine[position2]));
            this.mLayoutState.mItemDirection = 1;
            int i3 = this.mFlexboxHelper.mIndexToFlexLine[position2];
            if (i3 == -1) {
                i3 = 0;
            }
            if (i3 > 0) {
                this.mLayoutState.mPosition = position2 - this.mFlexLines.get(i3 - 1).getItemCount();
            } else {
                this.mLayoutState.mPosition = -1;
            }
            this.mLayoutState.mFlexLinePosition = i3 > 0 ? i3 - 1 : 0;
            LayoutState layoutState5 = this.mLayoutState;
            if (z) {
                layoutState5.mOffset = this.mOrientationHelper.getDecoratedEnd(findFirstReferenceViewInLine);
                this.mLayoutState.mScrollingOffset = this.mOrientationHelper.getDecoratedEnd(findFirstReferenceViewInLine) - this.mOrientationHelper.getEndAfterPadding();
                LayoutState layoutState6 = this.mLayoutState;
                layoutState6.mScrollingOffset = Math.max(layoutState6.mScrollingOffset, 0);
            } else {
                layoutState5.mOffset = this.mOrientationHelper.getDecoratedStart(findFirstReferenceViewInLine);
                this.mLayoutState.mScrollingOffset = (-this.mOrientationHelper.getDecoratedStart(findFirstReferenceViewInLine)) + this.mOrientationHelper.getStartAfterPadding();
            }
        }
        LayoutState layoutState7 = this.mLayoutState;
        layoutState7.mAvailable = absDelta - layoutState7.mScrollingOffset;
    }

    private View findFirstReferenceViewInLine(View firstView, FlexLine firstVisibleLine) {
        boolean isMainAxisDirectionHorizontal = isMainAxisDirectionHorizontal();
        int i = firstVisibleLine.mItemCount;
        for (int i2 = 1; i2 < i; i2++) {
            View childAt = getChildAt(i2);
            if (childAt != null && childAt.getVisibility() != 8) {
                if (this.mIsRtl && !isMainAxisDirectionHorizontal) {
                    if (this.mOrientationHelper.getDecoratedEnd(firstView) >= this.mOrientationHelper.getDecoratedEnd(childAt)) {
                    }
                    firstView = childAt;
                } else {
                    if (this.mOrientationHelper.getDecoratedStart(firstView) <= this.mOrientationHelper.getDecoratedStart(childAt)) {
                    }
                    firstView = childAt;
                }
            }
        }
        return firstView;
    }

    private View findLastReferenceViewInLine(View lastView, FlexLine lastVisibleLine) {
        boolean isMainAxisDirectionHorizontal = isMainAxisDirectionHorizontal();
        int childCount = (getChildCount() - lastVisibleLine.mItemCount) - 1;
        for (int childCount2 = getChildCount() - 2; childCount2 > childCount; childCount2--) {
            View childAt = getChildAt(childCount2);
            if (childAt != null && childAt.getVisibility() != 8) {
                if (this.mIsRtl && !isMainAxisDirectionHorizontal) {
                    if (this.mOrientationHelper.getDecoratedStart(lastView) <= this.mOrientationHelper.getDecoratedStart(childAt)) {
                    }
                    lastView = childAt;
                } else {
                    if (this.mOrientationHelper.getDecoratedEnd(lastView) >= this.mOrientationHelper.getDecoratedEnd(childAt)) {
                    }
                    lastView = childAt;
                }
            }
        }
        return lastView;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int computeHorizontalScrollExtent(RecyclerView.State state) {
        return computeScrollExtent(state);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int computeVerticalScrollExtent(RecyclerView.State state) {
        return computeScrollExtent(state);
    }

    private int computeScrollExtent(RecyclerView.State state) {
        if (getChildCount() == 0) {
            return 0;
        }
        int itemCount = state.getItemCount();
        ensureOrientationHelper();
        View findFirstReferenceChild = findFirstReferenceChild(itemCount);
        View findLastReferenceChild = findLastReferenceChild(itemCount);
        if (state.getItemCount() == 0 || findFirstReferenceChild == null || findLastReferenceChild == null) {
            return 0;
        }
        return Math.min(this.mOrientationHelper.getTotalSpace(), this.mOrientationHelper.getDecoratedEnd(findLastReferenceChild) - this.mOrientationHelper.getDecoratedStart(findFirstReferenceChild));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int computeHorizontalScrollOffset(RecyclerView.State state) {
        return computeScrollOffset(state);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int computeVerticalScrollOffset(RecyclerView.State state) {
        return computeScrollOffset(state);
    }

    private int computeScrollOffset(RecyclerView.State state) {
        if (getChildCount() == 0) {
            return 0;
        }
        int itemCount = state.getItemCount();
        View findFirstReferenceChild = findFirstReferenceChild(itemCount);
        View findLastReferenceChild = findLastReferenceChild(itemCount);
        if (state.getItemCount() != 0 && findFirstReferenceChild != null && findLastReferenceChild != null) {
            int position = getPosition(findFirstReferenceChild);
            int position2 = getPosition(findLastReferenceChild);
            int abs = Math.abs(this.mOrientationHelper.getDecoratedEnd(findLastReferenceChild) - this.mOrientationHelper.getDecoratedStart(findFirstReferenceChild));
            int i = this.mFlexboxHelper.mIndexToFlexLine[position];
            if (i != 0 && i != -1) {
                return Math.round((i * (abs / ((this.mFlexboxHelper.mIndexToFlexLine[position2] - i) + 1))) + (this.mOrientationHelper.getStartAfterPadding() - this.mOrientationHelper.getDecoratedStart(findFirstReferenceChild)));
            }
        }
        return 0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int computeHorizontalScrollRange(RecyclerView.State state) {
        return computeScrollRange(state);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int computeVerticalScrollRange(RecyclerView.State state) {
        return computeScrollRange(state);
    }

    private int computeScrollRange(RecyclerView.State state) {
        if (getChildCount() == 0) {
            return 0;
        }
        int itemCount = state.getItemCount();
        View findFirstReferenceChild = findFirstReferenceChild(itemCount);
        View findLastReferenceChild = findLastReferenceChild(itemCount);
        if (state.getItemCount() == 0 || findFirstReferenceChild == null || findLastReferenceChild == null) {
            return 0;
        }
        int findFirstVisibleItemPosition = findFirstVisibleItemPosition();
        return (int) ((Math.abs(this.mOrientationHelper.getDecoratedEnd(findLastReferenceChild) - this.mOrientationHelper.getDecoratedStart(findFirstReferenceChild)) / ((findLastVisibleItemPosition() - findFirstVisibleItemPosition) + 1)) * state.getItemCount());
    }

    private boolean shouldMeasureChild(View child, int widthSpec, int heightSpec, RecyclerView.LayoutParams lp) {
        return (!child.isLayoutRequested() && isMeasurementCacheEnabled() && isMeasurementUpToDate(child.getWidth(), widthSpec, lp.width) && isMeasurementUpToDate(child.getHeight(), heightSpec, lp.height)) ? false : true;
    }

    private static boolean isMeasurementUpToDate(int childSize, int spec, int dimension) {
        int mode = View.MeasureSpec.getMode(spec);
        int size = View.MeasureSpec.getSize(spec);
        if (dimension <= 0 || childSize == dimension) {
            if (mode == Integer.MIN_VALUE) {
                return size >= childSize;
            } else if (mode != 0) {
                return mode == 1073741824 && size == childSize;
            } else {
                return true;
            }
        }
        return false;
    }

    private void clearFlexLines() {
        this.mFlexLines.clear();
        this.mAnchorInfo.reset();
        this.mAnchorInfo.mPerpendicularCoordinate = 0;
    }

    private int getChildLeft(View view) {
        return getDecoratedLeft(view) - ((RecyclerView.LayoutParams) view.getLayoutParams()).leftMargin;
    }

    private int getChildRight(View view) {
        return getDecoratedRight(view) + ((RecyclerView.LayoutParams) view.getLayoutParams()).rightMargin;
    }

    private int getChildTop(View view) {
        return getDecoratedTop(view) - ((RecyclerView.LayoutParams) view.getLayoutParams()).topMargin;
    }

    private int getChildBottom(View view) {
        return getDecoratedBottom(view) + ((RecyclerView.LayoutParams) view.getLayoutParams()).bottomMargin;
    }

    private boolean isViewVisible(View view, boolean completelyVisible) {
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        int width = getWidth() - getPaddingRight();
        int height = getHeight() - getPaddingBottom();
        int childLeft = getChildLeft(view);
        int childTop = getChildTop(view);
        int childRight = getChildRight(view);
        int childBottom = getChildBottom(view);
        return completelyVisible ? (paddingLeft <= childLeft && width >= childRight) && (paddingTop <= childTop && height >= childBottom) : (childLeft >= width || childRight >= paddingLeft) && (childTop >= height || childBottom >= paddingTop);
    }

    public int findFirstVisibleItemPosition() {
        View findOneVisibleChild = findOneVisibleChild(0, getChildCount(), false);
        if (findOneVisibleChild == null) {
            return -1;
        }
        return getPosition(findOneVisibleChild);
    }

    public int findFirstCompletelyVisibleItemPosition() {
        View findOneVisibleChild = findOneVisibleChild(0, getChildCount(), true);
        if (findOneVisibleChild == null) {
            return -1;
        }
        return getPosition(findOneVisibleChild);
    }

    public int findLastVisibleItemPosition() {
        View findOneVisibleChild = findOneVisibleChild(getChildCount() - 1, -1, false);
        if (findOneVisibleChild == null) {
            return -1;
        }
        return getPosition(findOneVisibleChild);
    }

    public int findLastCompletelyVisibleItemPosition() {
        View findOneVisibleChild = findOneVisibleChild(getChildCount() - 1, -1, true);
        if (findOneVisibleChild == null) {
            return -1;
        }
        return getPosition(findOneVisibleChild);
    }

    private View findOneVisibleChild(int fromIndex, int toIndex, boolean completelyVisible) {
        int i = toIndex > fromIndex ? 1 : -1;
        while (fromIndex != toIndex) {
            View childAt = getChildAt(fromIndex);
            if (isViewVisible(childAt, completelyVisible)) {
                return childAt;
            }
            fromIndex += i;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getPositionToFlexLineIndex(int position) {
        return this.mFlexboxHelper.mIndexToFlexLine[position];
    }

    /* loaded from: classes4.dex */
    public static class LayoutParams extends RecyclerView.LayoutParams implements FlexItem {
        public static final Parcelable.Creator<LayoutParams> CREATOR = new Parcelable.Creator<LayoutParams>() { // from class: com.google.android.flexbox.FlexboxLayoutManager.LayoutParams.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public LayoutParams createFromParcel(Parcel source) {
                return new LayoutParams(source);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public LayoutParams[] newArray(int size) {
                return new LayoutParams[size];
            }
        };
        private int mAlignSelf;
        private float mFlexBasisPercent;
        private float mFlexGrow;
        private float mFlexShrink;
        private int mMaxHeight;
        private int mMaxWidth;
        private int mMinHeight;
        private int mMinWidth;
        private boolean mWrapBefore;

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // com.google.android.flexbox.FlexItem
        public int getOrder() {
            return 1;
        }

        @Override // com.google.android.flexbox.FlexItem
        public int getWidth() {
            return this.width;
        }

        @Override // com.google.android.flexbox.FlexItem
        public void setWidth(int width) {
            this.width = width;
        }

        @Override // com.google.android.flexbox.FlexItem
        public int getHeight() {
            return this.height;
        }

        @Override // com.google.android.flexbox.FlexItem
        public void setHeight(int height) {
            this.height = height;
        }

        @Override // com.google.android.flexbox.FlexItem
        public float getFlexGrow() {
            return this.mFlexGrow;
        }

        @Override // com.google.android.flexbox.FlexItem
        public void setFlexGrow(float flexGrow) {
            this.mFlexGrow = flexGrow;
        }

        @Override // com.google.android.flexbox.FlexItem
        public float getFlexShrink() {
            return this.mFlexShrink;
        }

        @Override // com.google.android.flexbox.FlexItem
        public void setFlexShrink(float flexShrink) {
            this.mFlexShrink = flexShrink;
        }

        @Override // com.google.android.flexbox.FlexItem
        public int getAlignSelf() {
            return this.mAlignSelf;
        }

        @Override // com.google.android.flexbox.FlexItem
        public void setAlignSelf(int alignSelf) {
            this.mAlignSelf = alignSelf;
        }

        @Override // com.google.android.flexbox.FlexItem
        public int getMinWidth() {
            return this.mMinWidth;
        }

        @Override // com.google.android.flexbox.FlexItem
        public void setMinWidth(int minWidth) {
            this.mMinWidth = minWidth;
        }

        @Override // com.google.android.flexbox.FlexItem
        public int getMinHeight() {
            return this.mMinHeight;
        }

        @Override // com.google.android.flexbox.FlexItem
        public void setMinHeight(int minHeight) {
            this.mMinHeight = minHeight;
        }

        @Override // com.google.android.flexbox.FlexItem
        public int getMaxWidth() {
            return this.mMaxWidth;
        }

        @Override // com.google.android.flexbox.FlexItem
        public void setMaxWidth(int maxWidth) {
            this.mMaxWidth = maxWidth;
        }

        @Override // com.google.android.flexbox.FlexItem
        public int getMaxHeight() {
            return this.mMaxHeight;
        }

        @Override // com.google.android.flexbox.FlexItem
        public void setMaxHeight(int maxHeight) {
            this.mMaxHeight = maxHeight;
        }

        @Override // com.google.android.flexbox.FlexItem
        public boolean isWrapBefore() {
            return this.mWrapBefore;
        }

        @Override // com.google.android.flexbox.FlexItem
        public void setWrapBefore(boolean wrapBefore) {
            this.mWrapBefore = wrapBefore;
        }

        @Override // com.google.android.flexbox.FlexItem
        public float getFlexBasisPercent() {
            return this.mFlexBasisPercent;
        }

        @Override // com.google.android.flexbox.FlexItem
        public void setFlexBasisPercent(float flexBasisPercent) {
            this.mFlexBasisPercent = flexBasisPercent;
        }

        @Override // com.google.android.flexbox.FlexItem
        public int getMarginLeft() {
            return this.leftMargin;
        }

        @Override // com.google.android.flexbox.FlexItem
        public int getMarginTop() {
            return this.topMargin;
        }

        @Override // com.google.android.flexbox.FlexItem
        public int getMarginRight() {
            return this.rightMargin;
        }

        @Override // com.google.android.flexbox.FlexItem
        public int getMarginBottom() {
            return this.bottomMargin;
        }

        public LayoutParams(Context c, AttributeSet attrs) {
            super(c, attrs);
            this.mFlexGrow = 0.0f;
            this.mFlexShrink = 1.0f;
            this.mAlignSelf = -1;
            this.mFlexBasisPercent = -1.0f;
            this.mMaxWidth = 16777215;
            this.mMaxHeight = 16777215;
        }

        public LayoutParams(int width, int height) {
            super(width, height);
            this.mFlexGrow = 0.0f;
            this.mFlexShrink = 1.0f;
            this.mAlignSelf = -1;
            this.mFlexBasisPercent = -1.0f;
            this.mMaxWidth = 16777215;
            this.mMaxHeight = 16777215;
        }

        public LayoutParams(ViewGroup.MarginLayoutParams source) {
            super(source);
            this.mFlexGrow = 0.0f;
            this.mFlexShrink = 1.0f;
            this.mAlignSelf = -1;
            this.mFlexBasisPercent = -1.0f;
            this.mMaxWidth = 16777215;
            this.mMaxHeight = 16777215;
        }

        public LayoutParams(ViewGroup.LayoutParams source) {
            super(source);
            this.mFlexGrow = 0.0f;
            this.mFlexShrink = 1.0f;
            this.mAlignSelf = -1;
            this.mFlexBasisPercent = -1.0f;
            this.mMaxWidth = 16777215;
            this.mMaxHeight = 16777215;
        }

        public LayoutParams(RecyclerView.LayoutParams source) {
            super(source);
            this.mFlexGrow = 0.0f;
            this.mFlexShrink = 1.0f;
            this.mAlignSelf = -1;
            this.mFlexBasisPercent = -1.0f;
            this.mMaxWidth = 16777215;
            this.mMaxHeight = 16777215;
        }

        public LayoutParams(LayoutParams source) {
            super((RecyclerView.LayoutParams) source);
            this.mFlexGrow = 0.0f;
            this.mFlexShrink = 1.0f;
            this.mAlignSelf = -1;
            this.mFlexBasisPercent = -1.0f;
            this.mMaxWidth = 16777215;
            this.mMaxHeight = 16777215;
            this.mFlexGrow = source.mFlexGrow;
            this.mFlexShrink = source.mFlexShrink;
            this.mAlignSelf = source.mAlignSelf;
            this.mFlexBasisPercent = source.mFlexBasisPercent;
            this.mMinWidth = source.mMinWidth;
            this.mMinHeight = source.mMinHeight;
            this.mMaxWidth = source.mMaxWidth;
            this.mMaxHeight = source.mMaxHeight;
            this.mWrapBefore = source.mWrapBefore;
        }

        @Override // com.google.android.flexbox.FlexItem
        public void setOrder(int order) {
            throw new UnsupportedOperationException("Setting the order in the FlexboxLayoutManager is not supported. Use FlexboxLayout if you need to reorder using the attribute.");
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeFloat(this.mFlexGrow);
            dest.writeFloat(this.mFlexShrink);
            dest.writeInt(this.mAlignSelf);
            dest.writeFloat(this.mFlexBasisPercent);
            dest.writeInt(this.mMinWidth);
            dest.writeInt(this.mMinHeight);
            dest.writeInt(this.mMaxWidth);
            dest.writeInt(this.mMaxHeight);
            dest.writeByte(this.mWrapBefore ? (byte) 1 : (byte) 0);
            dest.writeInt(this.bottomMargin);
            dest.writeInt(this.leftMargin);
            dest.writeInt(this.rightMargin);
            dest.writeInt(this.topMargin);
            dest.writeInt(this.height);
            dest.writeInt(this.width);
        }

        protected LayoutParams(Parcel in) {
            super(-2, -2);
            this.mFlexGrow = 0.0f;
            this.mFlexShrink = 1.0f;
            this.mAlignSelf = -1;
            this.mFlexBasisPercent = -1.0f;
            this.mMaxWidth = 16777215;
            this.mMaxHeight = 16777215;
            this.mFlexGrow = in.readFloat();
            this.mFlexShrink = in.readFloat();
            this.mAlignSelf = in.readInt();
            this.mFlexBasisPercent = in.readFloat();
            this.mMinWidth = in.readInt();
            this.mMinHeight = in.readInt();
            this.mMaxWidth = in.readInt();
            this.mMaxHeight = in.readInt();
            this.mWrapBefore = in.readByte() != 0;
            this.bottomMargin = in.readInt();
            this.leftMargin = in.readInt();
            this.rightMargin = in.readInt();
            this.topMargin = in.readInt();
            this.height = in.readInt();
            this.width = in.readInt();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public class AnchorInfo {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        private boolean mAssignedFromSavedState;
        private int mCoordinate;
        private int mFlexLinePosition;
        private boolean mLayoutFromEnd;
        private int mPerpendicularCoordinate;
        private int mPosition;
        private boolean mValid;

        private AnchorInfo() {
            this.mPerpendicularCoordinate = 0;
        }

        static /* synthetic */ int access$2412(AnchorInfo anchorInfo, int i) {
            int i2 = anchorInfo.mPerpendicularCoordinate + i;
            anchorInfo.mPerpendicularCoordinate = i2;
            return i2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void reset() {
            this.mPosition = -1;
            this.mFlexLinePosition = -1;
            this.mCoordinate = Integer.MIN_VALUE;
            this.mValid = false;
            this.mAssignedFromSavedState = false;
            boolean isMainAxisDirectionHorizontal = FlexboxLayoutManager.this.isMainAxisDirectionHorizontal();
            FlexboxLayoutManager flexboxLayoutManager = FlexboxLayoutManager.this;
            if (isMainAxisDirectionHorizontal) {
                int i = flexboxLayoutManager.mFlexWrap;
                FlexboxLayoutManager flexboxLayoutManager2 = FlexboxLayoutManager.this;
                if (i == 0) {
                    this.mLayoutFromEnd = flexboxLayoutManager2.mFlexDirection == 1;
                    return;
                } else {
                    this.mLayoutFromEnd = flexboxLayoutManager2.mFlexWrap == 2;
                    return;
                }
            }
            int i2 = flexboxLayoutManager.mFlexWrap;
            FlexboxLayoutManager flexboxLayoutManager3 = FlexboxLayoutManager.this;
            if (i2 == 0) {
                this.mLayoutFromEnd = flexboxLayoutManager3.mFlexDirection == 3;
            } else {
                this.mLayoutFromEnd = flexboxLayoutManager3.mFlexWrap == 2;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void assignCoordinateFromPadding() {
            if (!FlexboxLayoutManager.this.isMainAxisDirectionHorizontal() && FlexboxLayoutManager.this.mIsRtl) {
                boolean z = this.mLayoutFromEnd;
                FlexboxLayoutManager flexboxLayoutManager = FlexboxLayoutManager.this;
                this.mCoordinate = z ? flexboxLayoutManager.mOrientationHelper.getEndAfterPadding() : flexboxLayoutManager.getWidth() - FlexboxLayoutManager.this.mOrientationHelper.getStartAfterPadding();
                return;
            }
            boolean z2 = this.mLayoutFromEnd;
            FlexboxLayoutManager flexboxLayoutManager2 = FlexboxLayoutManager.this;
            this.mCoordinate = z2 ? flexboxLayoutManager2.mOrientationHelper.getEndAfterPadding() : flexboxLayoutManager2.mOrientationHelper.getStartAfterPadding();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void assignFromView(View anchor) {
            int i = FlexboxLayoutManager.this.mFlexWrap;
            FlexboxLayoutManager flexboxLayoutManager = FlexboxLayoutManager.this;
            OrientationHelper orientationHelper = i == 0 ? flexboxLayoutManager.mSubOrientationHelper : flexboxLayoutManager.mOrientationHelper;
            if (!FlexboxLayoutManager.this.isMainAxisDirectionHorizontal() && FlexboxLayoutManager.this.mIsRtl) {
                if (this.mLayoutFromEnd) {
                    this.mCoordinate = orientationHelper.getDecoratedStart(anchor) + orientationHelper.getTotalSpaceChange();
                } else {
                    this.mCoordinate = orientationHelper.getDecoratedEnd(anchor);
                }
            } else if (this.mLayoutFromEnd) {
                this.mCoordinate = orientationHelper.getDecoratedEnd(anchor) + orientationHelper.getTotalSpaceChange();
            } else {
                this.mCoordinate = orientationHelper.getDecoratedStart(anchor);
            }
            this.mPosition = FlexboxLayoutManager.this.getPosition(anchor);
            this.mAssignedFromSavedState = false;
            int[] iArr = FlexboxLayoutManager.this.mFlexboxHelper.mIndexToFlexLine;
            int i2 = this.mPosition;
            if (i2 == -1) {
                i2 = 0;
            }
            int i3 = iArr[i2];
            this.mFlexLinePosition = i3 != -1 ? i3 : 0;
            if (FlexboxLayoutManager.this.mFlexLines.size() > this.mFlexLinePosition) {
                this.mPosition = ((FlexLine) FlexboxLayoutManager.this.mFlexLines.get(this.mFlexLinePosition)).mFirstIndex;
            }
        }

        public String toString() {
            return "AnchorInfo{mPosition=" + this.mPosition + ", mFlexLinePosition=" + this.mFlexLinePosition + ", mCoordinate=" + this.mCoordinate + ", mPerpendicularCoordinate=" + this.mPerpendicularCoordinate + ", mLayoutFromEnd=" + this.mLayoutFromEnd + ", mValid=" + this.mValid + ", mAssignedFromSavedState=" + this.mAssignedFromSavedState + AbstractJsonLexerKt.END_OBJ;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public static class LayoutState {
        private static final int ITEM_DIRECTION_TAIL = 1;
        private static final int LAYOUT_END = 1;
        private static final int LAYOUT_START = -1;
        private static final int SCROLLING_OFFSET_NaN = Integer.MIN_VALUE;
        private int mAvailable;
        private int mFlexLinePosition;
        private boolean mInfinite;
        private int mItemDirection;
        private int mLastScrollDelta;
        private int mLayoutDirection;
        private int mOffset;
        private int mPosition;
        private int mScrollingOffset;
        private boolean mShouldRecycle;

        private LayoutState() {
            this.mItemDirection = 1;
            this.mLayoutDirection = 1;
        }

        static /* synthetic */ int access$1012(LayoutState layoutState, int i) {
            int i2 = layoutState.mOffset + i;
            layoutState.mOffset = i2;
            return i2;
        }

        static /* synthetic */ int access$1020(LayoutState layoutState, int i) {
            int i2 = layoutState.mOffset - i;
            layoutState.mOffset = i2;
            return i2;
        }

        static /* synthetic */ int access$1220(LayoutState layoutState, int i) {
            int i2 = layoutState.mAvailable - i;
            layoutState.mAvailable = i2;
            return i2;
        }

        static /* synthetic */ int access$1508(LayoutState layoutState) {
            int i = layoutState.mFlexLinePosition;
            layoutState.mFlexLinePosition = i + 1;
            return i;
        }

        static /* synthetic */ int access$1510(LayoutState layoutState) {
            int i = layoutState.mFlexLinePosition;
            layoutState.mFlexLinePosition = i - 1;
            return i;
        }

        static /* synthetic */ int access$1512(LayoutState layoutState, int i) {
            int i2 = layoutState.mFlexLinePosition + i;
            layoutState.mFlexLinePosition = i2;
            return i2;
        }

        static /* synthetic */ int access$2012(LayoutState layoutState, int i) {
            int i2 = layoutState.mScrollingOffset + i;
            layoutState.mScrollingOffset = i2;
            return i2;
        }

        static /* synthetic */ int access$2212(LayoutState layoutState, int i) {
            int i2 = layoutState.mPosition + i;
            layoutState.mPosition = i2;
            return i2;
        }

        static /* synthetic */ int access$2220(LayoutState layoutState, int i) {
            int i2 = layoutState.mPosition - i;
            layoutState.mPosition = i2;
            return i2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public boolean hasMore(RecyclerView.State state, List<FlexLine> flexLines) {
            int i;
            int i2 = this.mPosition;
            return i2 >= 0 && i2 < state.getItemCount() && (i = this.mFlexLinePosition) >= 0 && i < flexLines.size();
        }

        public String toString() {
            return "LayoutState{mAvailable=" + this.mAvailable + ", mFlexLinePosition=" + this.mFlexLinePosition + ", mPosition=" + this.mPosition + ", mOffset=" + this.mOffset + ", mScrollingOffset=" + this.mScrollingOffset + ", mLastScrollDelta=" + this.mLastScrollDelta + ", mItemDirection=" + this.mItemDirection + ", mLayoutDirection=" + this.mLayoutDirection + AbstractJsonLexerKt.END_OBJ;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public static class SavedState implements Parcelable {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator<SavedState>() { // from class: com.google.android.flexbox.FlexboxLayoutManager.SavedState.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public SavedState createFromParcel(Parcel source) {
                return new SavedState(source);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public SavedState[] newArray(int size) {
                return new SavedState[size];
            }
        };
        private int mAnchorOffset;
        private int mAnchorPosition;

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeInt(this.mAnchorPosition);
            dest.writeInt(this.mAnchorOffset);
        }

        SavedState() {
        }

        private SavedState(Parcel in) {
            this.mAnchorPosition = in.readInt();
            this.mAnchorOffset = in.readInt();
        }

        private SavedState(SavedState savedState) {
            this.mAnchorPosition = savedState.mAnchorPosition;
            this.mAnchorOffset = savedState.mAnchorOffset;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void invalidateAnchor() {
            this.mAnchorPosition = -1;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public boolean hasValidAnchor(int itemCount) {
            int i = this.mAnchorPosition;
            return i >= 0 && i < itemCount;
        }

        public String toString() {
            return "SavedState{mAnchorPosition=" + this.mAnchorPosition + ", mAnchorOffset=" + this.mAnchorOffset + AbstractJsonLexerKt.END_OBJ;
        }
    }
}
