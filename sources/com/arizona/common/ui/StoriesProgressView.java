package com.arizona.common.ui;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import com.arizona.common.R;
import com.arizona.common.ui.PausableProgressBar;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class StoriesProgressView extends LinearLayout {
    private static final String TAG = "StoriesProgressView";
    private final LinearLayout.LayoutParams PROGRESS_BAR_LAYOUT_PARAM;
    private final LinearLayout.LayoutParams SPACE_LAYOUT_PARAM;
    private int current;
    boolean isComplete;
    private boolean isReverseStart;
    private boolean isSkipStart;
    private final List<PausableProgressBar> progressBars;
    private int storiesCount;
    private StoriesListener storiesListener;

    /* loaded from: classes3.dex */
    public interface StoriesListener {
        void onComplete();

        void onNext();

        void onPrev();
    }

    public StoriesProgressView(Context context) {
        this(context, null);
    }

    public StoriesProgressView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.PROGRESS_BAR_LAYOUT_PARAM = new LinearLayout.LayoutParams(0, -2, 1.0f);
        this.SPACE_LAYOUT_PARAM = new LinearLayout.LayoutParams(5, -2);
        this.progressBars = new ArrayList();
        this.storiesCount = -1;
        this.current = -1;
        init(context, attributeSet);
    }

    public StoriesProgressView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.PROGRESS_BAR_LAYOUT_PARAM = new LinearLayout.LayoutParams(0, -2, 1.0f);
        this.SPACE_LAYOUT_PARAM = new LinearLayout.LayoutParams(5, -2);
        this.progressBars = new ArrayList();
        this.storiesCount = -1;
        this.current = -1;
        init(context, attributeSet);
    }

    public StoriesProgressView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.PROGRESS_BAR_LAYOUT_PARAM = new LinearLayout.LayoutParams(0, -2, 1.0f);
        this.SPACE_LAYOUT_PARAM = new LinearLayout.LayoutParams(5, -2);
        this.progressBars = new ArrayList();
        this.storiesCount = -1;
        this.current = -1;
        init(context, attributeSet);
    }

    private void init(Context context, AttributeSet attributeSet) {
        setOrientation(0);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.StoriesProgressView);
        this.storiesCount = obtainStyledAttributes.getInt(R.styleable.StoriesProgressView_progressCount, 0);
        obtainStyledAttributes.recycle();
        bindViews();
    }

    private void bindViews() {
        this.progressBars.clear();
        removeAllViews();
        int i = 0;
        while (i < this.storiesCount) {
            PausableProgressBar createProgressBar = createProgressBar();
            this.progressBars.add(createProgressBar);
            addView(createProgressBar);
            i++;
            if (i < this.storiesCount) {
                addView(createSpace());
            }
        }
    }

    private PausableProgressBar createProgressBar() {
        PausableProgressBar pausableProgressBar = new PausableProgressBar(getContext());
        pausableProgressBar.setLayoutParams(this.PROGRESS_BAR_LAYOUT_PARAM);
        return pausableProgressBar;
    }

    private View createSpace() {
        View view = new View(getContext());
        view.setLayoutParams(this.SPACE_LAYOUT_PARAM);
        return view;
    }

    public void setStoriesCount(int i) {
        this.storiesCount = i;
        bindViews();
    }

    public void setStoriesListener(StoriesListener storiesListener) {
        this.storiesListener = storiesListener;
    }

    public void skip() {
        int i;
        if (this.isSkipStart || this.isReverseStart || this.isComplete || (i = this.current) < 0) {
            return;
        }
        this.isSkipStart = true;
        this.progressBars.get(i).setMax();
    }

    public void reverse() {
        int i;
        if (this.isSkipStart || this.isReverseStart || this.isComplete || (i = this.current) < 0) {
            return;
        }
        this.isReverseStart = true;
        this.progressBars.get(i).setMin();
    }

    public void setStoryDuration(long j) {
        for (int i = 0; i < this.progressBars.size(); i++) {
            this.progressBars.get(i).setDuration(j);
            this.progressBars.get(i).setCallback(callback(i));
        }
    }

    public void setStoriesCountWithDurations(long[] jArr) {
        this.storiesCount = jArr.length;
        bindViews();
        for (int i = 0; i < this.progressBars.size(); i++) {
            this.progressBars.get(i).setDuration(jArr[i]);
            this.progressBars.get(i).setCallback(callback(i));
        }
    }

    private PausableProgressBar.Callback callback(final int i) {
        return new PausableProgressBar.Callback() { // from class: com.arizona.common.ui.StoriesProgressView.1
            @Override // com.arizona.common.ui.PausableProgressBar.Callback
            public void onStartProgress() {
                StoriesProgressView.this.current = i;
            }

            @Override // com.arizona.common.ui.PausableProgressBar.Callback
            public void onFinishProgress() {
                boolean z = StoriesProgressView.this.isReverseStart;
                StoriesProgressView storiesProgressView = StoriesProgressView.this;
                if (z) {
                    if (storiesProgressView.storiesListener != null) {
                        StoriesProgressView.this.storiesListener.onPrev();
                    }
                    int i2 = StoriesProgressView.this.current - 1;
                    StoriesProgressView storiesProgressView2 = StoriesProgressView.this;
                    if (i2 >= 0) {
                        ((PausableProgressBar) storiesProgressView2.progressBars.get(StoriesProgressView.this.current - 1)).setMinWithoutCallback();
                        List list = StoriesProgressView.this.progressBars;
                        StoriesProgressView storiesProgressView3 = StoriesProgressView.this;
                        int i3 = storiesProgressView3.current - 1;
                        storiesProgressView3.current = i3;
                        ((PausableProgressBar) list.get(i3)).startProgress();
                    } else {
                        ((PausableProgressBar) storiesProgressView2.progressBars.get(StoriesProgressView.this.current)).startProgress();
                    }
                    StoriesProgressView.this.isReverseStart = false;
                    return;
                }
                int i4 = storiesProgressView.current + 1;
                int size = StoriesProgressView.this.progressBars.size() - 1;
                StoriesProgressView storiesProgressView4 = StoriesProgressView.this;
                if (i4 <= size) {
                    if (storiesProgressView4.storiesListener != null) {
                        StoriesProgressView.this.storiesListener.onNext();
                    }
                    ((PausableProgressBar) StoriesProgressView.this.progressBars.get(i4)).startProgress();
                } else {
                    storiesProgressView4.isComplete = true;
                    if (StoriesProgressView.this.storiesListener != null) {
                        StoriesProgressView.this.storiesListener.onComplete();
                    }
                }
                StoriesProgressView.this.isSkipStart = false;
            }
        };
    }

    public void startStories() {
        this.progressBars.get(0).startProgress();
    }

    public void startStories(int i) {
        int i2 = 0;
        while (true) {
            List<PausableProgressBar> list = this.progressBars;
            if (i2 < i) {
                list.get(i2).setMaxWithoutCallback();
                i2++;
            } else {
                list.get(i).startProgress();
                return;
            }
        }
    }

    public void destroy() {
        for (PausableProgressBar pausableProgressBar : this.progressBars) {
            pausableProgressBar.clear();
        }
    }

    public void pause() {
        int i = this.current;
        if (i < 0) {
            return;
        }
        try {
            this.progressBars.get(i).pauseProgress();
        } catch (IndexOutOfBoundsException e) {
            Log.w(TAG, "pause: out of bounds ", e);
        }
    }

    public void resume() {
        int i = this.current;
        if (i < 0) {
            return;
        }
        try {
            this.progressBars.get(i).resumeProgress();
        } catch (IndexOutOfBoundsException e) {
            Log.w(TAG, "resume: out of bounds ", e);
        }
    }
}
