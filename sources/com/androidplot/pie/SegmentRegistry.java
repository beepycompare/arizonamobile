package com.androidplot.pie;

import com.androidplot.SeriesRegistry;
/* loaded from: classes3.dex */
public class SegmentRegistry extends SeriesRegistry<SegmentBundle, Segment, SegmentFormatter> {
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.androidplot.SeriesRegistry
    public SegmentBundle newSeriesBundle(Segment segment, SegmentFormatter segmentFormatter) {
        return new SegmentBundle(segment, segmentFormatter);
    }
}
