package ru.mrlargha.commonui.utils.progressBar;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import java.util.ArrayList;
import java.util.List;
import ru.mrlargha.commonui.R;
import ru.mrlargha.commonui.utils.progressBar.PausableProgressBar;
/* loaded from: classes5.dex */
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

    /* loaded from: classes5.dex */
    public interface StoriesListener {
        void onComplete();

        void onNext();

        void onPrev();
    }

    public StoriesProgressView(Context context) {
        this(context, null);
    }

    public StoriesProgressView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.PROGRESS_BAR_LAYOUT_PARAM = new LinearLayout.LayoutParams(0, -2, 1.0f);
        this.SPACE_LAYOUT_PARAM = new LinearLayout.LayoutParams(5, -2);
        this.progressBars = new ArrayList();
        this.storiesCount = -1;
        this.current = -1;
        init(context, attrs);
    }

    public StoriesProgressView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.PROGRESS_BAR_LAYOUT_PARAM = new LinearLayout.LayoutParams(0, -2, 1.0f);
        this.SPACE_LAYOUT_PARAM = new LinearLayout.LayoutParams(5, -2);
        this.progressBars = new ArrayList();
        this.storiesCount = -1;
        this.current = -1;
        init(context, attrs);
    }

    public StoriesProgressView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        this.PROGRESS_BAR_LAYOUT_PARAM = new LinearLayout.LayoutParams(0, -2, 1.0f);
        this.SPACE_LAYOUT_PARAM = new LinearLayout.LayoutParams(5, -2);
        this.progressBars = new ArrayList();
        this.storiesCount = -1;
        this.current = -1;
        init(context, attrs);
    }

    private void init(Context context, AttributeSet attrs) {
        setOrientation(0);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attrs, R.styleable.StoriesProgressView);
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

    public void setStoriesCount(int storiesCount) {
        this.storiesCount = storiesCount;
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

    public void setStoryDuration(long duration) {
        for (int i = 0; i < this.progressBars.size(); i++) {
            this.progressBars.get(i).setDuration(duration);
            this.progressBars.get(i).setCallback(callback(i));
        }
    }

    public void setStoriesCountWithDurations(long[] durations) {
        this.storiesCount = durations.length;
        bindViews();
        for (int i = 0; i < this.progressBars.size(); i++) {
            this.progressBars.get(i).setDuration(durations[i]);
            this.progressBars.get(i).setCallback(callback(i));
        }
    }

    private PausableProgressBar.Callback callback(final int index) {
        return new PausableProgressBar.Callback() { // from class: ru.mrlargha.commonui.utils.progressBar.StoriesProgressView.1
            @Override // ru.mrlargha.commonui.utils.progressBar.PausableProgressBar.Callback
            public void onStartProgress() {
                StoriesProgressView.this.current = index;
            }

            @Override // ru.mrlargha.commonui.utils.progressBar.PausableProgressBar.Callback
            public void onFinishProgress() {
                if (StoriesProgressView.this.isReverseStart) {
                    if (StoriesProgressView.this.storiesListener != null) {
                        StoriesProgressView.this.storiesListener.onPrev();
                    }
                    if (StoriesProgressView.this.current - 1 >= 0) {
                        ((PausableProgressBar) StoriesProgressView.this.progressBars.get(StoriesProgressView.this.current - 1)).setMinWithoutCallback();
                        List list = StoriesProgressView.this.progressBars;
                        StoriesProgressView storiesProgressView = StoriesProgressView.this;
                        int i = storiesProgressView.current - 1;
                        storiesProgressView.current = i;
                        ((PausableProgressBar) list.get(i)).startProgress();
                    } else {
                        ((PausableProgressBar) StoriesProgressView.this.progressBars.get(StoriesProgressView.this.current)).startProgress();
                    }
                    StoriesProgressView.this.isReverseStart = false;
                    return;
                }
                int i2 = StoriesProgressView.this.current + 1;
                if (i2 <= StoriesProgressView.this.progressBars.size() - 1) {
                    if (StoriesProgressView.this.storiesListener != null) {
                        StoriesProgressView.this.storiesListener.onNext();
                    }
                    ((PausableProgressBar) StoriesProgressView.this.progressBars.get(i2)).startProgress();
                } else {
                    StoriesProgressView.this.isComplete = true;
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

    public void setProgressBarsFinish(int count) {
        for (int i = 0; i < count; i++) {
            this.progressBars.get(i).setMax();
        }
    }

    public void startStories(int from) {
        for (int i = 0; i < from; i++) {
            this.progressBars.get(i).setMaxWithoutCallback();
        }
        this.progressBars.get(from).startProgress();
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
        this.progressBars.get(i).pauseProgress();
    }

    public void resume() {
        int i = this.current;
        if (i < 0) {
            return;
        }
        this.progressBars.get(i).resumeProgress();
    }
}
