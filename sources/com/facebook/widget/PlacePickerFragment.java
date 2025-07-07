package com.facebook.widget;

import android.app.Activity;
import android.content.res.TypedArray;
import android.location.Location;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ListView;
import androidx.media3.exoplayer.ExoPlayer;
import com.facebook.AppEventsLogger;
import com.facebook.FacebookException;
import com.facebook.LoggingBehavior;
import com.facebook.Request;
import com.facebook.Session;
import com.facebook.android.R;
import com.facebook.internal.AnalyticsEvents;
import com.facebook.internal.Logger;
import com.facebook.internal.Utility;
import com.facebook.model.GraphPlace;
import com.facebook.widget.GraphObjectAdapter;
import com.facebook.widget.PickerFragment;
import io.appmetrica.analytics.coreutils.internal.StringUtils;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Timer;
import java.util.TimerTask;
/* loaded from: classes3.dex */
public class PlacePickerFragment extends PickerFragment<GraphPlace> {
    private static final String CATEGORY = "category";
    public static final int DEFAULT_RADIUS_IN_METERS = 1000;
    public static final int DEFAULT_RESULTS_LIMIT = 100;
    private static final String ID = "id";
    private static final String LOCATION = "location";
    public static final String LOCATION_BUNDLE_KEY = "com.facebook.widget.PlacePickerFragment.Location";
    private static final String NAME = "name";
    public static final String RADIUS_IN_METERS_BUNDLE_KEY = "com.facebook.widget.PlacePickerFragment.RadiusInMeters";
    public static final String RESULTS_LIMIT_BUNDLE_KEY = "com.facebook.widget.PlacePickerFragment.ResultsLimit";
    public static final String SEARCH_TEXT_BUNDLE_KEY = "com.facebook.widget.PlacePickerFragment.SearchText";
    public static final String SHOW_SEARCH_BOX_BUNDLE_KEY = "com.facebook.widget.PlacePickerFragment.ShowSearchBox";
    private static final String TAG = "PlacePickerFragment";
    private static final String WERE_HERE_COUNT = "were_here_count";
    private static final int searchTextTimerDelayInMilliseconds = 2000;
    private boolean hasSearchTextChangedSinceLastQuery;
    private Location location;
    private int radiusInMeters;
    private int resultsLimit;
    private EditText searchBox;
    private String searchText;
    private Timer searchTextTimer;
    private boolean showSearchBox;

    /* loaded from: classes3.dex */
    private class AsNeededLoadingStrategy extends PickerFragment<GraphPlace>.LoadingStrategy {
        private AsNeededLoadingStrategy() {
            super();
        }

        /* synthetic */ AsNeededLoadingStrategy(PlacePickerFragment placePickerFragment, AsNeededLoadingStrategy asNeededLoadingStrategy) {
            this();
        }

        @Override // com.facebook.widget.PickerFragment.LoadingStrategy
        public void attach(GraphObjectAdapter<GraphPlace> graphObjectAdapter) {
            super.attach(graphObjectAdapter);
            this.adapter.setDataNeededListener(new GraphObjectAdapter.DataNeededListener() { // from class: com.facebook.widget.PlacePickerFragment.AsNeededLoadingStrategy.1
                @Override // com.facebook.widget.GraphObjectAdapter.DataNeededListener
                public void onDataNeeded() {
                    if (AsNeededLoadingStrategy.this.loader.isLoading()) {
                        return;
                    }
                    AsNeededLoadingStrategy.this.loader.followNextLink();
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.facebook.widget.PickerFragment.LoadingStrategy
        public void onLoadFinished(GraphObjectPagingLoader<GraphPlace> graphObjectPagingLoader, SimpleGraphObjectCursor<GraphPlace> simpleGraphObjectCursor) {
            super.onLoadFinished(graphObjectPagingLoader, simpleGraphObjectCursor);
            if (simpleGraphObjectCursor == null || graphObjectPagingLoader.isLoading()) {
                return;
            }
            PlacePickerFragment.this.hideActivityCircle();
            if (simpleGraphObjectCursor.isFromCache()) {
                graphObjectPagingLoader.refreshOriginalRequest(simpleGraphObjectCursor.areMoreObjectsAvailable() ? 2000 : 0);
            }
        }
    }

    /* loaded from: classes3.dex */
    private class SearchTextWatcher implements TextWatcher {
        private SearchTextWatcher() {
        }

        /* synthetic */ SearchTextWatcher(PlacePickerFragment placePickerFragment, SearchTextWatcher searchTextWatcher) {
            this();
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            PlacePickerFragment.this.onSearchBoxTextChanged(charSequence.toString(), false);
        }
    }

    public PlacePickerFragment() {
        this(null);
    }

    public PlacePickerFragment(Bundle bundle) {
        super(GraphPlace.class, R.layout.com_facebook_placepickerfragment, bundle);
        this.radiusInMeters = 1000;
        this.resultsLimit = 100;
        this.showSearchBox = true;
        setPlacePickerSettingsFromBundle(bundle);
    }

    private Request createRequest(Location location, int i, int i2, String str, Set<String> set, Session session) {
        Request newPlacesSearchRequest = Request.newPlacesSearchRequest(session, location, i, i2, str, null);
        HashSet hashSet = new HashSet(set);
        hashSet.addAll(Arrays.asList("id", "name", "location", CATEGORY, WERE_HERE_COUNT));
        String pictureFieldSpecifier = this.adapter.getPictureFieldSpecifier();
        if (pictureFieldSpecifier != null) {
            hashSet.add(pictureFieldSpecifier);
        }
        Bundle parameters = newPlacesSearchRequest.getParameters();
        parameters.putString("fields", TextUtils.join(StringUtils.COMMA, hashSet));
        newPlacesSearchRequest.setParameters(parameters);
        return newPlacesSearchRequest;
    }

    private Timer createSearchTextTimer() {
        Timer timer = new Timer();
        timer.schedule(new TimerTask() { // from class: com.facebook.widget.PlacePickerFragment.2
            @Override // java.util.TimerTask, java.lang.Runnable
            public void run() {
                PlacePickerFragment.this.onSearchTextTimerTriggered();
            }
        }, 0L, ExoPlayer.DEFAULT_DETACH_SURFACE_TIMEOUT_MS);
        return timer;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onSearchTextTimerTriggered() {
        if (this.hasSearchTextChangedSinceLastQuery) {
            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.facebook.widget.PlacePickerFragment.3
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        PlacePickerFragment.this.loadData(true);
                    } catch (FacebookException e) {
                        PickerFragment.OnErrorListener onErrorListener = PlacePickerFragment.this.getOnErrorListener();
                        if (onErrorListener != null) {
                            onErrorListener.onError(PlacePickerFragment.this, e);
                        } else {
                            Logger.log(LoggingBehavior.REQUESTS, PlacePickerFragment.TAG, "Error loading data : %s", e);
                        }
                    } catch (Exception e2) {
                        FacebookException facebookException = new FacebookException(e2);
                        PickerFragment.OnErrorListener onErrorListener2 = PlacePickerFragment.this.getOnErrorListener();
                        if (onErrorListener2 != null) {
                            onErrorListener2.onError(PlacePickerFragment.this, facebookException);
                        } else {
                            Logger.log(LoggingBehavior.REQUESTS, PlacePickerFragment.TAG, "Error loading data : %s", facebookException);
                        }
                    }
                }
            });
            return;
        }
        this.searchTextTimer.cancel();
        this.searchTextTimer = null;
    }

    private void setPlacePickerSettingsFromBundle(Bundle bundle) {
        if (bundle != null) {
            setRadiusInMeters(bundle.getInt(RADIUS_IN_METERS_BUNDLE_KEY, this.radiusInMeters));
            setResultsLimit(bundle.getInt(RESULTS_LIMIT_BUNDLE_KEY, this.resultsLimit));
            if (bundle.containsKey(SEARCH_TEXT_BUNDLE_KEY)) {
                setSearchText(bundle.getString(SEARCH_TEXT_BUNDLE_KEY));
            }
            if (bundle.containsKey(LOCATION_BUNDLE_KEY)) {
                setLocation((Location) bundle.getParcelable(LOCATION_BUNDLE_KEY));
            }
            this.showSearchBox = bundle.getBoolean(SHOW_SEARCH_BOX_BUNDLE_KEY, this.showSearchBox);
        }
    }

    @Override // com.facebook.widget.PickerFragment
    PickerFragment<GraphPlace>.PickerFragmentAdapter<GraphPlace> createAdapter() {
        PickerFragment<GraphPlace>.PickerFragmentAdapter<GraphPlace> pickerFragmentAdapter = new PickerFragment<GraphPlace>.PickerFragmentAdapter<GraphPlace>(this, getActivity()) { // from class: com.facebook.widget.PlacePickerFragment.1
            @Override // com.facebook.widget.GraphObjectAdapter
            protected int getDefaultPicture() {
                return R.drawable.com_facebook_place_default_icon;
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.facebook.widget.GraphObjectAdapter
            public int getGraphObjectRowLayoutId(GraphPlace graphPlace) {
                return R.layout.com_facebook_placepickerfragment_list_row;
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.facebook.widget.GraphObjectAdapter
            public CharSequence getSubTitleOfGraphObject(GraphPlace graphPlace) {
                String category = graphPlace.getCategory();
                Integer num = (Integer) graphPlace.getProperty(PlacePickerFragment.WERE_HERE_COUNT);
                if (category == null || num == null) {
                    if (category != null || num == null) {
                        if (category == null || num != null) {
                            return null;
                        }
                        return PlacePickerFragment.this.getString(R.string.com_facebook_placepicker_subtitle_catetory_only_format, category);
                    }
                    return PlacePickerFragment.this.getString(R.string.com_facebook_placepicker_subtitle_were_here_only_format, num);
                }
                return PlacePickerFragment.this.getString(R.string.com_facebook_placepicker_subtitle_format, category, num);
            }
        };
        pickerFragmentAdapter.setShowCheckbox(false);
        pickerFragmentAdapter.setShowPicture(getShowPictures());
        return pickerFragmentAdapter;
    }

    @Override // com.facebook.widget.PickerFragment
    PickerFragment<GraphPlace>.LoadingStrategy createLoadingStrategy() {
        return new AsNeededLoadingStrategy(this, null);
    }

    @Override // com.facebook.widget.PickerFragment
    PickerFragment<GraphPlace>.SelectionStrategy createSelectionStrategy() {
        return new PickerFragment.SingleSelectionStrategy();
    }

    @Override // com.facebook.widget.PickerFragment
    String getDefaultTitleText() {
        return getString(R.string.com_facebook_nearby);
    }

    public Location getLocation() {
        return this.location;
    }

    public int getRadiusInMeters() {
        return this.radiusInMeters;
    }

    @Override // com.facebook.widget.PickerFragment
    Request getRequestForLoadData(Session session) {
        return createRequest(this.location, this.radiusInMeters, this.resultsLimit, this.searchText, this.extraFields, session);
    }

    public int getResultsLimit() {
        return this.resultsLimit;
    }

    public String getSearchText() {
        return this.searchText;
    }

    public GraphPlace getSelection() {
        List<GraphPlace> selectedGraphObjects = getSelectedGraphObjects();
        if (selectedGraphObjects == null || selectedGraphObjects.isEmpty()) {
            return null;
        }
        return selectedGraphObjects.iterator().next();
    }

    @Override // com.facebook.widget.PickerFragment
    void logAppEvents(boolean z) {
        AppEventsLogger newLogger = AppEventsLogger.newLogger(getActivity(), getSession());
        Bundle bundle = new Bundle();
        bundle.putString(AnalyticsEvents.PARAMETER_DIALOG_OUTCOME, z ? AnalyticsEvents.PARAMETER_DIALOG_OUTCOME_VALUE_COMPLETED : AnalyticsEvents.PARAMETER_DIALOG_OUTCOME_VALUE_UNKNOWN);
        bundle.putInt("num_places_picked", getSelection() != null ? 1 : 0);
        newLogger.logSdkEvent(AnalyticsEvents.EVENT_PLACE_PICKER_USAGE, null, bundle);
    }

    @Override // androidx.fragment.app.Fragment
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        if (this.searchBox != null) {
            ((InputMethodManager) getActivity().getSystemService("input_method")).showSoftInput(this.searchBox, 1);
        }
    }

    @Override // com.facebook.widget.PickerFragment, androidx.fragment.app.Fragment
    public void onDetach() {
        super.onDetach();
        if (this.searchBox != null) {
            ((InputMethodManager) getActivity().getSystemService("input_method")).hideSoftInputFromWindow(this.searchBox.getWindowToken(), 0);
        }
    }

    @Override // com.facebook.widget.PickerFragment, androidx.fragment.app.Fragment
    public void onInflate(Activity activity, AttributeSet attributeSet, Bundle bundle) {
        super.onInflate(activity, attributeSet, bundle);
        TypedArray obtainStyledAttributes = activity.obtainStyledAttributes(attributeSet, R.styleable.com_facebook_place_picker_fragment);
        setRadiusInMeters(obtainStyledAttributes.getInt(0, this.radiusInMeters));
        setResultsLimit(obtainStyledAttributes.getInt(1, this.resultsLimit));
        if (obtainStyledAttributes.hasValue(1)) {
            setSearchText(obtainStyledAttributes.getString(2));
        }
        this.showSearchBox = obtainStyledAttributes.getBoolean(3, this.showSearchBox);
        obtainStyledAttributes.recycle();
    }

    @Override // com.facebook.widget.PickerFragment
    void onLoadingData() {
        this.hasSearchTextChangedSinceLastQuery = false;
    }

    public void onSearchBoxTextChanged(String str, boolean z) {
        if (z || !Utility.stringsEqualOrEmpty(this.searchText, str)) {
            if (TextUtils.isEmpty(str)) {
                str = null;
            }
            this.searchText = str;
            this.hasSearchTextChangedSinceLastQuery = true;
            if (this.searchTextTimer == null) {
                this.searchTextTimer = createSearchTextTimer();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.facebook.widget.PickerFragment
    public void saveSettingsToBundle(Bundle bundle) {
        super.saveSettingsToBundle(bundle);
        bundle.putInt(RADIUS_IN_METERS_BUNDLE_KEY, this.radiusInMeters);
        bundle.putInt(RESULTS_LIMIT_BUNDLE_KEY, this.resultsLimit);
        bundle.putString(SEARCH_TEXT_BUNDLE_KEY, this.searchText);
        bundle.putParcelable(LOCATION_BUNDLE_KEY, this.location);
        bundle.putBoolean(SHOW_SEARCH_BOX_BUNDLE_KEY, this.showSearchBox);
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public void setRadiusInMeters(int i) {
        this.radiusInMeters = i;
    }

    public void setResultsLimit(int i) {
        this.resultsLimit = i;
    }

    public void setSearchText(String str) {
        if (TextUtils.isEmpty(str)) {
            str = null;
        }
        this.searchText = str;
        EditText editText = this.searchBox;
        if (editText != null) {
            editText.setText(str);
        }
    }

    @Override // com.facebook.widget.PickerFragment
    public void setSettingsFromBundle(Bundle bundle) {
        super.setSettingsFromBundle(bundle);
        setPlacePickerSettingsFromBundle(bundle);
    }

    @Override // com.facebook.widget.PickerFragment
    void setupViews(ViewGroup viewGroup) {
        if (this.showSearchBox) {
            ListView listView = (ListView) viewGroup.findViewById(R.id.com_facebook_picker_list_view);
            listView.addHeaderView(getActivity().getLayoutInflater().inflate(R.layout.com_facebook_picker_search_box, (ViewGroup) listView, false), null, false);
            EditText editText = (EditText) viewGroup.findViewById(R.id.com_facebook_picker_search_text);
            this.searchBox = editText;
            editText.addTextChangedListener(new SearchTextWatcher(this, null));
            if (TextUtils.isEmpty(this.searchText)) {
                return;
            }
            this.searchBox.setText(this.searchText);
        }
    }
}
