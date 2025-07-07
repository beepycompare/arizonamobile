package com.google.android.material.carousel;

import android.view.View;
import androidx.core.math.MathUtils;
import androidx.recyclerview.widget.RecyclerView;
/* loaded from: classes4.dex */
public class HeroCarouselStrategy extends CarouselStrategy {
    private int keylineCount = 0;
    private static final int[] SMALL_COUNTS = {1};
    private static final int[] MEDIUM_COUNTS = {0, 1};

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.material.carousel.CarouselStrategy
    public KeylineState onFirstChildMeasuredWithMargins(Carousel carousel, View view) {
        int[] iArr;
        int[] iArr2;
        int containerHeight = carousel.getContainerHeight();
        if (carousel.isHorizontal()) {
            containerHeight = carousel.getContainerWidth();
        }
        RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) view.getLayoutParams();
        float f = layoutParams.topMargin + layoutParams.bottomMargin;
        float measuredWidth = view.getMeasuredWidth() * 2;
        if (carousel.isHorizontal()) {
            f = layoutParams.leftMargin + layoutParams.rightMargin;
            measuredWidth = view.getMeasuredHeight() * 2;
        }
        float smallItemSizeMin = getSmallItemSizeMin() + f;
        float max = Math.max(getSmallItemSizeMax() + f, smallItemSizeMin);
        float f2 = containerHeight;
        float min = Math.min(measuredWidth + f, f2);
        float clamp = MathUtils.clamp((measuredWidth / 3.0f) + f, smallItemSizeMin + f, max + f);
        float f3 = (min + clamp) / 2.0f;
        int i = 0;
        int[] iArr3 = f2 < 2.0f * smallItemSizeMin ? new int[]{0} : SMALL_COUNTS;
        int max2 = (int) Math.max(1.0d, Math.floor((f2 - (CarouselStrategyHelper.maxValue(iArr) * max)) / min));
        int ceil = (((int) Math.ceil(f2 / min)) - max2) + 1;
        int[] iArr4 = new int[ceil];
        for (int i2 = 0; i2 < ceil; i2++) {
            iArr4[i2] = max2 + i2;
        }
        int i3 = carousel.getCarouselAlignment() == 1 ? 1 : 0;
        int[] doubleCounts = i3 != 0 ? doubleCounts(iArr3) : iArr3;
        if (i3 != 0) {
            iArr2 = doubleCounts(MEDIUM_COUNTS);
        } else {
            iArr2 = MEDIUM_COUNTS;
        }
        Arrangement findLowestCostArrangement = Arrangement.findLowestCostArrangement(f2, clamp, smallItemSizeMin, max, doubleCounts, f3, iArr2, min, iArr4);
        this.keylineCount = findLowestCostArrangement.getItemCount();
        if (findLowestCostArrangement.getItemCount() > carousel.getItemCount()) {
            findLowestCostArrangement = Arrangement.findLowestCostArrangement(f2, clamp, smallItemSizeMin, max, iArr3, f3, MEDIUM_COUNTS, min, iArr4);
        } else {
            i = i3;
        }
        return CarouselStrategyHelper.createKeylineState(view.getContext(), f, f2, findLowestCostArrangement, i);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.material.carousel.CarouselStrategy
    public boolean shouldRefreshKeylineState(Carousel carousel, int i) {
        if (carousel.getCarouselAlignment() == 1) {
            return (i < this.keylineCount && carousel.getItemCount() >= this.keylineCount) || (i >= this.keylineCount && carousel.getItemCount() < this.keylineCount);
        }
        return false;
    }
}
