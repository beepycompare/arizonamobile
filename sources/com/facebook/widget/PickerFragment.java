package com.facebook.widget;

import android.app.Activity;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.view.animation.AlphaAnimation;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.loader.app.LoaderManager;
import androidx.loader.content.Loader;
import com.facebook.FacebookException;
import com.facebook.Request;
import com.facebook.Session;
import com.facebook.SessionState;
import com.facebook.android.R;
import com.facebook.internal.SessionTracker;
import com.facebook.model.GraphObject;
import com.facebook.widget.GraphObjectAdapter;
import com.facebook.widget.GraphObjectPagingLoader;
import io.appmetrica.analytics.coreutils.internal.StringUtils;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
/* loaded from: classes3.dex */
public abstract class PickerFragment<T extends GraphObject> extends Fragment {
    private static final String ACTIVITY_CIRCLE_SHOW_KEY = "com.facebook.android.PickerFragment.ActivityCircleShown";
    public static final String DONE_BUTTON_TEXT_BUNDLE_KEY = "com.facebook.widget.PickerFragment.DoneButtonText";
    public static final String EXTRA_FIELDS_BUNDLE_KEY = "com.facebook.widget.PickerFragment.ExtraFields";
    private static final int PROFILE_PICTURE_PREFETCH_BUFFER = 5;
    private static final String SELECTION_BUNDLE_KEY = "com.facebook.android.PickerFragment.Selection";
    public static final String SHOW_PICTURES_BUNDLE_KEY = "com.facebook.widget.PickerFragment.ShowPictures";
    public static final String SHOW_TITLE_BAR_BUNDLE_KEY = "com.facebook.widget.PickerFragment.ShowTitleBar";
    public static final String TITLE_TEXT_BUNDLE_KEY = "com.facebook.widget.PickerFragment.TitleText";
    private ProgressBar activityCircle;
    GraphObjectAdapter<T> adapter;
    private boolean appEventsLogged;
    private Button doneButton;
    private Drawable doneButtonBackground;
    private String doneButtonText;
    private GraphObjectFilter<T> filter;
    private final Class<T> graphObjectClass;
    private final int layout;
    private ListView listView;
    private PickerFragment<T>.LoadingStrategy loadingStrategy;
    private OnDataChangedListener onDataChangedListener;
    private OnDoneButtonClickedListener onDoneButtonClickedListener;
    private OnErrorListener onErrorListener;
    private OnSelectionChangedListener onSelectionChangedListener;
    private PickerFragment<T>.SelectionStrategy selectionStrategy;
    private SessionTracker sessionTracker;
    private Drawable titleBarBackground;
    private String titleText;
    private TextView titleTextView;
    private boolean showPictures = true;
    private boolean showTitleBar = true;
    HashSet<String> extraFields = new HashSet<>();
    private AbsListView.OnScrollListener onScrollListener = new AbsListView.OnScrollListener() { // from class: com.facebook.widget.PickerFragment.1
        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            PickerFragment.this.reprioritizeDownloads();
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i) {
        }
    };

    /* loaded from: classes3.dex */
    public interface GraphObjectFilter<T> {
        boolean includeItem(T t);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public abstract class LoadingStrategy {
        protected static final int CACHED_RESULT_REFRESH_DELAY = 2000;
        protected GraphObjectAdapter<T> adapter;
        protected GraphObjectPagingLoader<T> loader;

        /* JADX INFO: Access modifiers changed from: package-private */
        public LoadingStrategy() {
        }

        public void attach(GraphObjectAdapter<T> graphObjectAdapter) {
            GraphObjectPagingLoader<T> graphObjectPagingLoader = (GraphObjectPagingLoader) PickerFragment.this.getLoaderManager().initLoader(0, null, new LoaderManager.LoaderCallbacks<SimpleGraphObjectCursor<T>>() { // from class: com.facebook.widget.PickerFragment.LoadingStrategy.1
                @Override // androidx.loader.app.LoaderManager.LoaderCallbacks
                public Loader<SimpleGraphObjectCursor<T>> onCreateLoader(int i, Bundle bundle) {
                    return LoadingStrategy.this.onCreateLoader();
                }

                public void onLoadFinished(Loader<SimpleGraphObjectCursor<T>> loader, SimpleGraphObjectCursor<T> simpleGraphObjectCursor) {
                    if (loader != LoadingStrategy.this.loader) {
                        throw new FacebookException("Received callback for unknown loader.");
                    }
                    LoadingStrategy.this.onLoadFinished((GraphObjectPagingLoader) loader, simpleGraphObjectCursor);
                }

                @Override // androidx.loader.app.LoaderManager.LoaderCallbacks
                public /* bridge */ /* synthetic */ void onLoadFinished(Loader loader, Object obj) {
                    onLoadFinished(loader, (SimpleGraphObjectCursor) ((SimpleGraphObjectCursor) obj));
                }

                @Override // androidx.loader.app.LoaderManager.LoaderCallbacks
                public void onLoaderReset(Loader<SimpleGraphObjectCursor<T>> loader) {
                    if (loader != LoadingStrategy.this.loader) {
                        throw new FacebookException("Received callback for unknown loader.");
                    }
                    LoadingStrategy.this.onLoadReset((GraphObjectPagingLoader) loader);
                }
            });
            this.loader = graphObjectPagingLoader;
            graphObjectPagingLoader.setOnErrorListener(new GraphObjectPagingLoader.OnErrorListener() { // from class: com.facebook.widget.PickerFragment.LoadingStrategy.2
                @Override // com.facebook.widget.GraphObjectPagingLoader.OnErrorListener
                public void onError(FacebookException facebookException, GraphObjectPagingLoader<?> graphObjectPagingLoader2) {
                    PickerFragment.this.hideActivityCircle();
                    if (PickerFragment.this.onErrorListener != null) {
                        PickerFragment.this.onErrorListener.onError(PickerFragment.this, facebookException);
                    }
                }
            });
            this.adapter = graphObjectAdapter;
            graphObjectAdapter.changeCursor(this.loader.getCursor());
            this.adapter.setOnErrorListener(new GraphObjectAdapter.OnErrorListener() { // from class: com.facebook.widget.PickerFragment.LoadingStrategy.3
                @Override // com.facebook.widget.GraphObjectAdapter.OnErrorListener
                public void onError(GraphObjectAdapter<?> graphObjectAdapter2, FacebookException facebookException) {
                    if (PickerFragment.this.onErrorListener != null) {
                        PickerFragment.this.onErrorListener.onError(PickerFragment.this, facebookException);
                    }
                }
            });
        }

        public void clearResults() {
            GraphObjectPagingLoader<T> graphObjectPagingLoader = this.loader;
            if (graphObjectPagingLoader != null) {
                graphObjectPagingLoader.clearResults();
            }
        }

        public void detach() {
            this.adapter.setDataNeededListener(null);
            this.adapter.setOnErrorListener(null);
            this.loader.setOnErrorListener(null);
            this.loader = null;
            this.adapter = null;
        }

        public boolean isDataPresentOrLoading() {
            return !this.adapter.isEmpty() || this.loader.isLoading();
        }

        protected GraphObjectPagingLoader<T> onCreateLoader() {
            return new GraphObjectPagingLoader<>(PickerFragment.this.getActivity(), PickerFragment.this.graphObjectClass);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        public void onLoadFinished(GraphObjectPagingLoader<T> graphObjectPagingLoader, SimpleGraphObjectCursor<T> simpleGraphObjectCursor) {
            PickerFragment.this.updateAdapter(simpleGraphObjectCursor);
        }

        protected void onLoadReset(GraphObjectPagingLoader<T> graphObjectPagingLoader) {
            this.adapter.changeCursor(null);
        }

        protected void onStartLoading(GraphObjectPagingLoader<T> graphObjectPagingLoader, Request request) {
            PickerFragment.this.displayActivityCircle();
        }

        public void startLoading(Request request) {
            GraphObjectPagingLoader<T> graphObjectPagingLoader = this.loader;
            if (graphObjectPagingLoader != null) {
                graphObjectPagingLoader.startLoading(request, true);
                onStartLoading(this.loader, request);
            }
        }
    }

    /* loaded from: classes3.dex */
    class MultiSelectionStrategy extends PickerFragment<T>.SelectionStrategy {
        private Set<String> selectedIds;

        /* JADX INFO: Access modifiers changed from: package-private */
        public MultiSelectionStrategy() {
            super();
            this.selectedIds = new HashSet();
        }

        @Override // com.facebook.widget.PickerFragment.SelectionStrategy
        public void clear() {
            this.selectedIds.clear();
        }

        @Override // com.facebook.widget.PickerFragment.SelectionStrategy
        public Collection<String> getSelectedIds() {
            return this.selectedIds;
        }

        @Override // com.facebook.widget.PickerFragment.SelectionStrategy
        boolean isEmpty() {
            return this.selectedIds.isEmpty();
        }

        @Override // com.facebook.widget.PickerFragment.SelectionStrategy
        boolean isSelected(String str) {
            return str != null && this.selectedIds.contains(str);
        }

        @Override // com.facebook.widget.PickerFragment.SelectionStrategy
        void readSelectionFromBundle(Bundle bundle, String str) {
            String string;
            if (bundle == null || (string = bundle.getString(str)) == null) {
                return;
            }
            String[] split = TextUtils.split(string, StringUtils.COMMA);
            this.selectedIds.clear();
            Collections.addAll(this.selectedIds, split);
        }

        @Override // com.facebook.widget.PickerFragment.SelectionStrategy
        void saveSelectionToBundle(Bundle bundle, String str) {
            if (this.selectedIds.isEmpty()) {
                return;
            }
            bundle.putString(str, TextUtils.join(StringUtils.COMMA, this.selectedIds));
        }

        @Override // com.facebook.widget.PickerFragment.SelectionStrategy
        boolean shouldShowCheckBoxIfUnselected() {
            return true;
        }

        @Override // com.facebook.widget.PickerFragment.SelectionStrategy
        void toggleSelection(String str) {
            if (str != null) {
                if (this.selectedIds.contains(str)) {
                    this.selectedIds.remove(str);
                } else {
                    this.selectedIds.add(str);
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public interface OnDataChangedListener {
        void onDataChanged(PickerFragment<?> pickerFragment);
    }

    /* loaded from: classes3.dex */
    public interface OnDoneButtonClickedListener {
        void onDoneButtonClicked(PickerFragment<?> pickerFragment);
    }

    /* loaded from: classes3.dex */
    public interface OnErrorListener {
        void onError(PickerFragment<?> pickerFragment, FacebookException facebookException);
    }

    /* loaded from: classes3.dex */
    public interface OnSelectionChangedListener {
        void onSelectionChanged(PickerFragment<?> pickerFragment);
    }

    /* loaded from: classes3.dex */
    abstract class PickerFragmentAdapter<U extends GraphObject> extends GraphObjectAdapter<T> {
        public PickerFragmentAdapter(Context context) {
            super(context);
        }

        @Override // com.facebook.widget.GraphObjectAdapter
        boolean isGraphObjectSelected(String str) {
            return PickerFragment.this.selectionStrategy.isSelected(str);
        }

        @Override // com.facebook.widget.GraphObjectAdapter
        void updateCheckboxState(CheckBox checkBox, boolean z) {
            checkBox.setChecked(z);
            checkBox.setVisibility((z || PickerFragment.this.selectionStrategy.shouldShowCheckBoxIfUnselected()) ? 0 : 8);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public abstract class SelectionStrategy {
        SelectionStrategy() {
        }

        abstract void clear();

        abstract Collection<String> getSelectedIds();

        abstract boolean isEmpty();

        abstract boolean isSelected(String str);

        abstract void readSelectionFromBundle(Bundle bundle, String str);

        abstract void saveSelectionToBundle(Bundle bundle, String str);

        abstract boolean shouldShowCheckBoxIfUnselected();

        abstract void toggleSelection(String str);
    }

    /* loaded from: classes3.dex */
    class SingleSelectionStrategy extends PickerFragment<T>.SelectionStrategy {
        private String selectedId;

        /* JADX INFO: Access modifiers changed from: package-private */
        public SingleSelectionStrategy() {
            super();
        }

        @Override // com.facebook.widget.PickerFragment.SelectionStrategy
        public void clear() {
            this.selectedId = null;
        }

        @Override // com.facebook.widget.PickerFragment.SelectionStrategy
        public Collection<String> getSelectedIds() {
            return Arrays.asList(this.selectedId);
        }

        @Override // com.facebook.widget.PickerFragment.SelectionStrategy
        boolean isEmpty() {
            return this.selectedId == null;
        }

        @Override // com.facebook.widget.PickerFragment.SelectionStrategy
        boolean isSelected(String str) {
            String str2 = this.selectedId;
            return (str2 == null || str == null || !str2.equals(str)) ? false : true;
        }

        @Override // com.facebook.widget.PickerFragment.SelectionStrategy
        void readSelectionFromBundle(Bundle bundle, String str) {
            if (bundle != null) {
                this.selectedId = bundle.getString(str);
            }
        }

        @Override // com.facebook.widget.PickerFragment.SelectionStrategy
        void saveSelectionToBundle(Bundle bundle, String str) {
            if (TextUtils.isEmpty(this.selectedId)) {
                return;
            }
            bundle.putString(str, this.selectedId);
        }

        @Override // com.facebook.widget.PickerFragment.SelectionStrategy
        boolean shouldShowCheckBoxIfUnselected() {
            return false;
        }

        @Override // com.facebook.widget.PickerFragment.SelectionStrategy
        void toggleSelection(String str) {
            String str2 = this.selectedId;
            if (str2 == null || !str2.equals(str)) {
                this.selectedId = str;
            } else {
                this.selectedId = null;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public PickerFragment(Class<T> cls, int i, Bundle bundle) {
        this.graphObjectClass = cls;
        this.layout = i;
        setPickerFragmentSettingsFromBundle(bundle);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearResults() {
        OnSelectionChangedListener onSelectionChangedListener;
        OnDataChangedListener onDataChangedListener;
        if (this.adapter != null) {
            boolean isEmpty = this.selectionStrategy.isEmpty();
            boolean isEmpty2 = this.adapter.isEmpty();
            this.loadingStrategy.clearResults();
            this.selectionStrategy.clear();
            this.adapter.notifyDataSetChanged();
            if (!isEmpty2 && (onDataChangedListener = this.onDataChangedListener) != null) {
                onDataChangedListener.onDataChanged(this);
            }
            if (isEmpty || (onSelectionChangedListener = this.onSelectionChangedListener) == null) {
                return;
            }
            onSelectionChangedListener.onSelectionChanged(this);
        }
    }

    private void inflateTitleBar(ViewGroup viewGroup) {
        ViewStub viewStub = (ViewStub) viewGroup.findViewById(R.id.com_facebook_picker_title_bar_stub);
        if (viewStub != null) {
            View inflate = viewStub.inflate();
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
            layoutParams.addRule(3, R.id.com_facebook_picker_title_bar);
            this.listView.setLayoutParams(layoutParams);
            Drawable drawable = this.titleBarBackground;
            if (drawable != null) {
                inflate.setBackgroundDrawable(drawable);
            }
            Button button = (Button) viewGroup.findViewById(R.id.com_facebook_picker_done_button);
            this.doneButton = button;
            if (button != null) {
                button.setOnClickListener(new View.OnClickListener() { // from class: com.facebook.widget.PickerFragment.6
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        PickerFragment.this.logAppEvents(true);
                        PickerFragment.this.appEventsLogged = true;
                        if (PickerFragment.this.onDoneButtonClickedListener != null) {
                            PickerFragment.this.onDoneButtonClickedListener.onDoneButtonClicked(PickerFragment.this);
                        }
                    }
                });
                if (getDoneButtonText() != null) {
                    this.doneButton.setText(getDoneButtonText());
                }
                Drawable drawable2 = this.doneButtonBackground;
                if (drawable2 != null) {
                    this.doneButton.setBackgroundDrawable(drawable2);
                }
            }
            TextView textView = (TextView) viewGroup.findViewById(R.id.com_facebook_picker_title);
            this.titleTextView = textView;
            if (textView == null || getTitleText() == null) {
                return;
            }
            this.titleTextView.setText(getTitleText());
        }
    }

    private void loadDataSkippingRoundTripIfCached() {
        clearResults();
        Request requestForLoadData = getRequestForLoadData(getSession());
        if (requestForLoadData != null) {
            onLoadingData();
            this.loadingStrategy.startLoading(requestForLoadData);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public void onListItemClick(ListView listView, View view, int i) {
        this.selectionStrategy.toggleSelection(this.adapter.getIdOfGraphObject((GraphObject) listView.getItemAtPosition(i)));
        this.adapter.notifyDataSetChanged();
        OnSelectionChangedListener onSelectionChangedListener = this.onSelectionChangedListener;
        if (onSelectionChangedListener != null) {
            onSelectionChangedListener.onSelectionChanged(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void reprioritizeDownloads() {
        int lastVisiblePosition = this.listView.getLastVisiblePosition();
        if (lastVisiblePosition >= 0) {
            this.adapter.prioritizeViewRange(this.listView.getFirstVisiblePosition(), lastVisiblePosition, 5);
        }
    }

    private static void setAlpha(View view, float f) {
        AlphaAnimation alphaAnimation = new AlphaAnimation(f, f);
        alphaAnimation.setDuration(0L);
        alphaAnimation.setFillAfter(true);
        view.startAnimation(alphaAnimation);
    }

    private void setPickerFragmentSettingsFromBundle(Bundle bundle) {
        if (bundle != null) {
            this.showPictures = bundle.getBoolean(SHOW_PICTURES_BUNDLE_KEY, this.showPictures);
            String string = bundle.getString(EXTRA_FIELDS_BUNDLE_KEY);
            if (string != null) {
                setExtraFields(Arrays.asList(string.split(StringUtils.COMMA)));
            }
            this.showTitleBar = bundle.getBoolean(SHOW_TITLE_BAR_BUNDLE_KEY, this.showTitleBar);
            String string2 = bundle.getString(TITLE_TEXT_BUNDLE_KEY);
            if (string2 != null) {
                this.titleText = string2;
                TextView textView = this.titleTextView;
                if (textView != null) {
                    textView.setText(string2);
                }
            }
            String string3 = bundle.getString(DONE_BUTTON_TEXT_BUNDLE_KEY);
            if (string3 != null) {
                this.doneButtonText = string3;
                Button button = this.doneButton;
                if (button != null) {
                    button.setText(string3);
                }
            }
        }
    }

    abstract PickerFragment<T>.PickerFragmentAdapter<T> createAdapter();

    abstract PickerFragment<T>.LoadingStrategy createLoadingStrategy();

    abstract PickerFragment<T>.SelectionStrategy createSelectionStrategy();

    /* JADX INFO: Access modifiers changed from: package-private */
    public void displayActivityCircle() {
        if (this.activityCircle != null) {
            layoutActivityCircle();
            this.activityCircle.setVisibility(0);
        }
    }

    boolean filterIncludesItem(T t) {
        GraphObjectFilter<T> graphObjectFilter = this.filter;
        if (graphObjectFilter != null) {
            return graphObjectFilter.includeItem(t);
        }
        return true;
    }

    String getDefaultDoneButtonText() {
        return getString(R.string.com_facebook_picker_done_button_text);
    }

    String getDefaultTitleText() {
        return null;
    }

    public String getDoneButtonText() {
        if (this.doneButtonText == null) {
            this.doneButtonText = getDefaultDoneButtonText();
        }
        return this.doneButtonText;
    }

    public Set<String> getExtraFields() {
        return new HashSet(this.extraFields);
    }

    public GraphObjectFilter<T> getFilter() {
        return this.filter;
    }

    public OnDataChangedListener getOnDataChangedListener() {
        return this.onDataChangedListener;
    }

    public OnDoneButtonClickedListener getOnDoneButtonClickedListener() {
        return this.onDoneButtonClickedListener;
    }

    public OnErrorListener getOnErrorListener() {
        return this.onErrorListener;
    }

    public OnSelectionChangedListener getOnSelectionChangedListener() {
        return this.onSelectionChangedListener;
    }

    abstract Request getRequestForLoadData(Session session);

    /* JADX INFO: Access modifiers changed from: package-private */
    public List<T> getSelectedGraphObjects() {
        return this.adapter.getGraphObjectsById(this.selectionStrategy.getSelectedIds());
    }

    public Session getSession() {
        return this.sessionTracker.getSession();
    }

    public boolean getShowPictures() {
        return this.showPictures;
    }

    public boolean getShowTitleBar() {
        return this.showTitleBar;
    }

    public String getTitleText() {
        if (this.titleText == null) {
            this.titleText = getDefaultTitleText();
        }
        return this.titleText;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void hideActivityCircle() {
        ProgressBar progressBar = this.activityCircle;
        if (progressBar != null) {
            progressBar.clearAnimation();
            this.activityCircle.setVisibility(4);
        }
    }

    void layoutActivityCircle() {
        setAlpha(this.activityCircle, !this.adapter.isEmpty() ? 0.25f : 1.0f);
    }

    public void loadData(boolean z) {
        if (z || !this.loadingStrategy.isDataPresentOrLoading()) {
            loadDataSkippingRoundTripIfCached();
        }
    }

    void logAppEvents(boolean z) {
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        this.sessionTracker = new SessionTracker(getActivity(), new Session.StatusCallback() { // from class: com.facebook.widget.PickerFragment.5
            @Override // com.facebook.Session.StatusCallback
            public void call(Session session, SessionState sessionState, Exception exc) {
                if (session.isOpened()) {
                    return;
                }
                PickerFragment.this.clearResults();
            }
        });
        setSettingsFromBundle(bundle);
        PickerFragment<T>.LoadingStrategy createLoadingStrategy = createLoadingStrategy();
        this.loadingStrategy = createLoadingStrategy;
        createLoadingStrategy.attach(this.adapter);
        PickerFragment<T>.SelectionStrategy createSelectionStrategy = createSelectionStrategy();
        this.selectionStrategy = createSelectionStrategy;
        createSelectionStrategy.readSelectionFromBundle(bundle, SELECTION_BUNDLE_KEY);
        if (this.showTitleBar) {
            inflateTitleBar((ViewGroup) getView());
        }
        if (this.activityCircle == null || bundle == null) {
            return;
        }
        if (bundle.getBoolean(ACTIVITY_CIRCLE_SHOW_KEY, false)) {
            displayActivityCircle();
        } else {
            hideActivityCircle();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        PickerFragment<T>.PickerFragmentAdapter<T> createAdapter = createAdapter();
        this.adapter = createAdapter;
        createAdapter.setFilter((GraphObjectAdapter.Filter<T>) new GraphObjectAdapter.Filter<T>() { // from class: com.facebook.widget.PickerFragment.2
            public boolean includeItem(T t) {
                return PickerFragment.this.filterIncludesItem(t);
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.facebook.widget.GraphObjectAdapter.Filter
            public /* bridge */ /* synthetic */ boolean includeItem(Object obj) {
                return includeItem((AnonymousClass2) ((GraphObject) obj));
            }
        });
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        ViewGroup viewGroup2 = (ViewGroup) layoutInflater.inflate(this.layout, viewGroup, false);
        ListView listView = (ListView) viewGroup2.findViewById(R.id.com_facebook_picker_list_view);
        this.listView = listView;
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.facebook.widget.PickerFragment.3
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                PickerFragment.this.onListItemClick((ListView) adapterView, view, i);
            }
        });
        this.listView.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.facebook.widget.PickerFragment.4
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                return false;
            }
        });
        this.listView.setOnScrollListener(this.onScrollListener);
        this.activityCircle = (ProgressBar) viewGroup2.findViewById(R.id.com_facebook_picker_activity_circle);
        setupViews(viewGroup2);
        this.listView.setAdapter((ListAdapter) this.adapter);
        return viewGroup2;
    }

    @Override // androidx.fragment.app.Fragment
    public void onDetach() {
        super.onDetach();
        this.listView.setOnScrollListener(null);
        this.listView.setAdapter((ListAdapter) null);
        this.loadingStrategy.detach();
        this.sessionTracker.stopTracking();
    }

    @Override // androidx.fragment.app.Fragment
    public void onInflate(Activity activity, AttributeSet attributeSet, Bundle bundle) {
        super.onInflate(activity, attributeSet, bundle);
        TypedArray obtainStyledAttributes = activity.obtainStyledAttributes(attributeSet, R.styleable.com_facebook_picker_fragment);
        setShowPictures(obtainStyledAttributes.getBoolean(0, this.showPictures));
        String string = obtainStyledAttributes.getString(1);
        if (string != null) {
            setExtraFields(Arrays.asList(string.split(StringUtils.COMMA)));
        }
        this.showTitleBar = obtainStyledAttributes.getBoolean(2, this.showTitleBar);
        this.titleText = obtainStyledAttributes.getString(3);
        this.doneButtonText = obtainStyledAttributes.getString(4);
        this.titleBarBackground = obtainStyledAttributes.getDrawable(5);
        this.doneButtonBackground = obtainStyledAttributes.getDrawable(6);
        obtainStyledAttributes.recycle();
    }

    void onLoadingData() {
    }

    @Override // androidx.fragment.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        saveSettingsToBundle(bundle);
        this.selectionStrategy.saveSelectionToBundle(bundle, SELECTION_BUNDLE_KEY);
        ProgressBar progressBar = this.activityCircle;
        if (progressBar != null) {
            bundle.putBoolean(ACTIVITY_CIRCLE_SHOW_KEY, progressBar.getVisibility() == 0);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onStop() {
        if (!this.appEventsLogged) {
            logAppEvents(false);
        }
        super.onStop();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void saveSettingsToBundle(Bundle bundle) {
        bundle.putBoolean(SHOW_PICTURES_BUNDLE_KEY, this.showPictures);
        if (!this.extraFields.isEmpty()) {
            bundle.putString(EXTRA_FIELDS_BUNDLE_KEY, TextUtils.join(StringUtils.COMMA, this.extraFields));
        }
        bundle.putBoolean(SHOW_TITLE_BAR_BUNDLE_KEY, this.showTitleBar);
        bundle.putString(TITLE_TEXT_BUNDLE_KEY, this.titleText);
        bundle.putString(DONE_BUTTON_TEXT_BUNDLE_KEY, this.doneButtonText);
    }

    @Override // androidx.fragment.app.Fragment
    public void setArguments(Bundle bundle) {
        super.setArguments(bundle);
        setSettingsFromBundle(bundle);
    }

    public void setDoneButtonText(String str) {
        this.doneButtonText = str;
    }

    public void setExtraFields(Collection<String> collection) {
        HashSet<String> hashSet = new HashSet<>();
        this.extraFields = hashSet;
        if (collection != null) {
            hashSet.addAll(collection);
        }
    }

    public void setFilter(GraphObjectFilter<T> graphObjectFilter) {
        this.filter = graphObjectFilter;
    }

    public void setOnDataChangedListener(OnDataChangedListener onDataChangedListener) {
        this.onDataChangedListener = onDataChangedListener;
    }

    public void setOnDoneButtonClickedListener(OnDoneButtonClickedListener onDoneButtonClickedListener) {
        this.onDoneButtonClickedListener = onDoneButtonClickedListener;
    }

    public void setOnErrorListener(OnErrorListener onErrorListener) {
        this.onErrorListener = onErrorListener;
    }

    public void setOnSelectionChangedListener(OnSelectionChangedListener onSelectionChangedListener) {
        this.onSelectionChangedListener = onSelectionChangedListener;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setSelectionStrategy(PickerFragment<T>.SelectionStrategy selectionStrategy) {
        if (selectionStrategy != this.selectionStrategy) {
            this.selectionStrategy = selectionStrategy;
            GraphObjectAdapter<T> graphObjectAdapter = this.adapter;
            if (graphObjectAdapter != null) {
                graphObjectAdapter.notifyDataSetChanged();
            }
        }
    }

    public void setSession(Session session) {
        this.sessionTracker.setSession(session);
    }

    public void setSettingsFromBundle(Bundle bundle) {
        setPickerFragmentSettingsFromBundle(bundle);
    }

    public void setShowPictures(boolean z) {
        this.showPictures = z;
    }

    public void setShowTitleBar(boolean z) {
        this.showTitleBar = z;
    }

    public void setTitleText(String str) {
        this.titleText = str;
    }

    void setupViews(ViewGroup viewGroup) {
    }

    void updateAdapter(SimpleGraphObjectCursor<T> simpleGraphObjectCursor) {
        OnDataChangedListener onDataChangedListener;
        int position;
        if (this.adapter != null) {
            View childAt = this.listView.getChildAt(1);
            int firstVisiblePosition = this.listView.getFirstVisiblePosition();
            if (firstVisiblePosition > 0) {
                firstVisiblePosition++;
            }
            GraphObjectAdapter.SectionAndItem<T> sectionAndItem = this.adapter.getSectionAndItem(firstVisiblePosition);
            int top = (childAt == null || sectionAndItem.getType() == GraphObjectAdapter.SectionAndItem.Type.ACTIVITY_CIRCLE) ? 0 : childAt.getTop();
            boolean changeCursor = this.adapter.changeCursor(simpleGraphObjectCursor);
            if (childAt != null && sectionAndItem != null && (position = this.adapter.getPosition(sectionAndItem.sectionKey, sectionAndItem.graphObject)) != -1) {
                this.listView.setSelectionFromTop(position, top);
            }
            if (!changeCursor || (onDataChangedListener = this.onDataChangedListener) == null) {
                return;
            }
            onDataChangedListener.onDataChanged(this);
        }
    }
}
