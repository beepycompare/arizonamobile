package com.facebook.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.SectionIndexer;
import android.widget.TextView;
import com.facebook.FacebookException;
import com.facebook.android.R;
import com.facebook.internal.ImageDownloader;
import com.facebook.internal.ImageRequest;
import com.facebook.internal.ImageResponse;
import com.facebook.model.GraphObject;
import java.net.URI;
import java.net.URISyntaxException;
import java.text.Collator;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public class GraphObjectAdapter<T extends GraphObject> extends BaseAdapter implements SectionIndexer {
    private static /* synthetic */ int[] $SWITCH_TABLE$com$facebook$widget$GraphObjectAdapter$SectionAndItem$Type = null;
    static final /* synthetic */ boolean $assertionsDisabled = true;
    private static final int ACTIVITY_CIRCLE_VIEW_TYPE = 2;
    private static final int DISPLAY_SECTIONS_THRESHOLD = 1;
    private static final int GRAPH_OBJECT_VIEW_TYPE = 1;
    private static final int HEADER_VIEW_TYPE = 0;
    private static final String ID = "id";
    private static final int MAX_PREFETCHED_PICTURES = 20;
    private static final String NAME = "name";
    private static final String PICTURE = "picture";
    private Context context;
    private GraphObjectCursor<T> cursor;
    private DataNeededListener dataNeededListener;
    private boolean displaySections;
    private Filter<T> filter;
    private String groupByField;
    private final LayoutInflater inflater;
    private OnErrorListener onErrorListener;
    private boolean showCheckbox;
    private boolean showPicture;
    private List<String> sortFields;
    private final Map<String, ImageRequest> pendingRequests = new HashMap();
    private List<String> sectionKeys = new ArrayList();
    private Map<String, ArrayList<T>> graphObjectsBySection = new HashMap();
    private Map<String, T> graphObjectsById = new HashMap();
    private Map<String, ImageResponse> prefetchedPictureCache = new HashMap();
    private ArrayList<String> prefetchedProfilePictureIds = new ArrayList<>();

    /* loaded from: classes3.dex */
    public interface DataNeededListener {
        void onDataNeeded();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public interface Filter<T> {
        boolean includeItem(T t);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public interface ItemPicture extends GraphObject {
        ItemPictureData getData();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public interface ItemPictureData extends GraphObject {
        String getUrl();
    }

    /* loaded from: classes3.dex */
    public interface OnErrorListener {
        void onError(GraphObjectAdapter<?> graphObjectAdapter, FacebookException facebookException);
    }

    /* loaded from: classes3.dex */
    public static class SectionAndItem<T extends GraphObject> {
        public T graphObject;
        public String sectionKey;

        /* loaded from: classes3.dex */
        public enum Type {
            GRAPH_OBJECT,
            SECTION_HEADER,
            ACTIVITY_CIRCLE;

            /* renamed from: values  reason: to resolve conflict with enum method */
            public static Type[] valuesCustom() {
                Type[] valuesCustom = values();
                int length = valuesCustom.length;
                Type[] typeArr = new Type[length];
                System.arraycopy(valuesCustom, 0, typeArr, 0, length);
                return typeArr;
            }
        }

        public SectionAndItem(String str, T t) {
            this.sectionKey = str;
            this.graphObject = t;
        }

        public Type getType() {
            return this.sectionKey == null ? Type.ACTIVITY_CIRCLE : this.graphObject == null ? Type.SECTION_HEADER : Type.GRAPH_OBJECT;
        }
    }

    static /* synthetic */ int[] $SWITCH_TABLE$com$facebook$widget$GraphObjectAdapter$SectionAndItem$Type() {
        int[] iArr = $SWITCH_TABLE$com$facebook$widget$GraphObjectAdapter$SectionAndItem$Type;
        if (iArr != null) {
            return iArr;
        }
        int[] iArr2 = new int[SectionAndItem.Type.valuesCustom().length];
        try {
            iArr2[SectionAndItem.Type.ACTIVITY_CIRCLE.ordinal()] = 3;
        } catch (NoSuchFieldError unused) {
        }
        try {
            iArr2[SectionAndItem.Type.GRAPH_OBJECT.ordinal()] = 1;
        } catch (NoSuchFieldError unused2) {
        }
        try {
            iArr2[SectionAndItem.Type.SECTION_HEADER.ordinal()] = 2;
        } catch (NoSuchFieldError unused3) {
        }
        $SWITCH_TABLE$com$facebook$widget$GraphObjectAdapter$SectionAndItem$Type = iArr2;
        return iArr2;
    }

    public GraphObjectAdapter(Context context) {
        this.context = context;
        this.inflater = LayoutInflater.from(context);
    }

    private void callOnErrorListener(Exception exc) {
        if (this.onErrorListener != null) {
            if (!(exc instanceof FacebookException)) {
                exc = new FacebookException(exc);
            }
            this.onErrorListener.onError(this, (FacebookException) exc);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int compareGraphObjects(GraphObject graphObject, GraphObject graphObject2, Collection<String> collection, Collator collator) {
        for (String str : collection) {
            String str2 = (String) graphObject.getProperty(str);
            String str3 = (String) graphObject2.getProperty(str);
            if (str2 != null && str3 != null) {
                int compare = collator.compare(str2, str3);
                if (compare != 0) {
                    return compare;
                }
            } else if (str2 != null || str3 != null) {
                return str2 == null ? -1 : 1;
            }
        }
        return 0;
    }

    private void downloadProfilePicture(final String str, URI uri, final ImageView imageView) {
        if (uri == null) {
            return;
        }
        boolean z = imageView == null;
        if (z || !uri.equals(imageView.getTag())) {
            if (!z) {
                imageView.setTag(str);
                imageView.setImageResource(getDefaultPicture());
            }
            ImageRequest build = new ImageRequest.Builder(this.context.getApplicationContext(), uri).setCallerTag(this).setCallback(new ImageRequest.Callback() { // from class: com.facebook.widget.GraphObjectAdapter.2
                @Override // com.facebook.internal.ImageRequest.Callback
                public void onCompleted(ImageResponse imageResponse) {
                    GraphObjectAdapter.this.processImageResponse(imageResponse, str, imageView);
                }
            }).build();
            this.pendingRequests.put(str, build);
            ImageDownloader.downloadAsync(build);
        }
    }

    private View getActivityCircleView(View view, ViewGroup viewGroup) {
        if (view == null) {
            view = this.inflater.inflate(R.layout.com_facebook_picker_activity_circle_row, (ViewGroup) null);
        }
        ((ProgressBar) view.findViewById(R.id.com_facebook_picker_row_activity_circle)).setVisibility(0);
        return view;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void processImageResponse(ImageResponse imageResponse, String str, ImageView imageView) {
        this.pendingRequests.remove(str);
        if (imageResponse.getError() != null) {
            callOnErrorListener(imageResponse.getError());
        }
        if (imageView == null) {
            if (imageResponse.getBitmap() != null) {
                if (this.prefetchedPictureCache.size() >= 20) {
                    this.prefetchedPictureCache.remove(this.prefetchedProfilePictureIds.remove(0));
                }
                this.prefetchedPictureCache.put(str, imageResponse);
            }
        } else if (str.equals(imageView.getTag())) {
            Exception error = imageResponse.getError();
            Bitmap bitmap = imageResponse.getBitmap();
            if (error != null || bitmap == null) {
                return;
            }
            imageView.setImageBitmap(bitmap);
            imageView.setTag(imageResponse.getRequest().getImageUri());
        }
    }

    private void rebuildSections() {
        this.sectionKeys = new ArrayList();
        this.graphObjectsBySection = new HashMap();
        this.graphObjectsById = new HashMap();
        boolean z = false;
        this.displaySections = false;
        GraphObjectCursor<T> graphObjectCursor = this.cursor;
        if (graphObjectCursor == null || graphObjectCursor.getCount() == 0) {
            return;
        }
        this.cursor.moveToFirst();
        int i = 0;
        do {
            T graphObject = this.cursor.getGraphObject();
            if (filterIncludesItem(graphObject)) {
                i++;
                String sectionKeyOfGraphObject = getSectionKeyOfGraphObject(graphObject);
                if (!this.graphObjectsBySection.containsKey(sectionKeyOfGraphObject)) {
                    this.sectionKeys.add(sectionKeyOfGraphObject);
                    this.graphObjectsBySection.put(sectionKeyOfGraphObject, new ArrayList<>());
                }
                this.graphObjectsBySection.get(sectionKeyOfGraphObject).add(graphObject);
                this.graphObjectsById.put(getIdOfGraphObject(graphObject), graphObject);
            }
        } while (this.cursor.moveToNext());
        if (this.sortFields != null) {
            final Collator collator = Collator.getInstance();
            for (ArrayList<T> arrayList : this.graphObjectsBySection.values()) {
                Collections.sort(arrayList, new Comparator<GraphObject>() { // from class: com.facebook.widget.GraphObjectAdapter.1
                    @Override // java.util.Comparator
                    public int compare(GraphObject graphObject2, GraphObject graphObject3) {
                        return GraphObjectAdapter.compareGraphObjects(graphObject2, graphObject3, GraphObjectAdapter.this.sortFields, collator);
                    }
                });
            }
        }
        Collections.sort(this.sectionKeys, Collator.getInstance());
        if (this.sectionKeys.size() > 1 && i > 1) {
            z = true;
        }
        this.displaySections = z;
    }

    private boolean shouldShowActivityCircleCell() {
        GraphObjectCursor<T> graphObjectCursor = this.cursor;
        return (graphObjectCursor == null || !graphObjectCursor.areMoreObjectsAvailable() || this.dataNeededListener == null || isEmpty()) ? false : true;
    }

    @Override // android.widget.BaseAdapter, android.widget.ListAdapter
    public boolean areAllItemsEnabled() {
        return this.displaySections;
    }

    public boolean changeCursor(GraphObjectCursor<T> graphObjectCursor) {
        GraphObjectCursor<T> graphObjectCursor2 = this.cursor;
        if (graphObjectCursor2 == graphObjectCursor) {
            return false;
        }
        if (graphObjectCursor2 != null) {
            graphObjectCursor2.close();
        }
        this.cursor = graphObjectCursor;
        rebuildAndNotify();
        return true;
    }

    protected View createGraphObjectView(T t) {
        View inflate = this.inflater.inflate(getGraphObjectRowLayoutId(t), (ViewGroup) null);
        ViewStub viewStub = (ViewStub) inflate.findViewById(R.id.com_facebook_picker_checkbox_stub);
        if (viewStub != null) {
            if (getShowCheckbox()) {
                updateCheckboxState((CheckBox) viewStub.inflate(), false);
            } else {
                viewStub.setVisibility(8);
            }
        }
        ViewStub viewStub2 = (ViewStub) inflate.findViewById(R.id.com_facebook_picker_profile_pic_stub);
        if (getShowPicture()) {
            ((ImageView) viewStub2.inflate()).setVisibility(0);
            return inflate;
        }
        viewStub2.setVisibility(8);
        return inflate;
    }

    boolean filterIncludesItem(T t) {
        Filter<T> filter = this.filter;
        return filter == null || filter.includeItem(t);
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.sectionKeys.size() == 0) {
            return 0;
        }
        int size = this.displaySections ? this.sectionKeys.size() : 0;
        for (ArrayList<T> arrayList : this.graphObjectsBySection.values()) {
            size += arrayList.size();
        }
        return shouldShowActivityCircleCell() ? size + 1 : size;
    }

    public GraphObjectCursor<T> getCursor() {
        return this.cursor;
    }

    public DataNeededListener getDataNeededListener() {
        return this.dataNeededListener;
    }

    protected int getDefaultPicture() {
        return R.drawable.com_facebook_profile_default_icon;
    }

    Filter<T> getFilter() {
        return this.filter;
    }

    protected int getGraphObjectRowLayoutId(T t) {
        return R.layout.com_facebook_picker_list_row;
    }

    protected View getGraphObjectView(T t, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = createGraphObjectView(t);
        }
        populateGraphObjectView(view, t);
        return view;
    }

    public List<T> getGraphObjectsById(Collection<String> collection) {
        HashSet<String> hashSet = new HashSet();
        hashSet.addAll(collection);
        ArrayList arrayList = new ArrayList(hashSet.size());
        for (String str : hashSet) {
            T t = this.graphObjectsById.get(str);
            if (t != null) {
                arrayList.add(t);
            }
        }
        return arrayList;
    }

    public String getGroupByField() {
        return this.groupByField;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String getIdOfGraphObject(T t) {
        if (t.asMap().containsKey("id")) {
            Object property = t.getProperty("id");
            if (property instanceof String) {
                return (String) property;
            }
        }
        throw new FacebookException("Received an object without an ID.");
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        SectionAndItem<T> sectionAndItem = getSectionAndItem(i);
        if (sectionAndItem.getType() == SectionAndItem.Type.GRAPH_OBJECT) {
            return sectionAndItem.graphObject;
        }
        return null;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        String idOfGraphObject;
        SectionAndItem<T> sectionAndItem = getSectionAndItem(i);
        if (sectionAndItem == null || sectionAndItem.graphObject == null || (idOfGraphObject = getIdOfGraphObject(sectionAndItem.graphObject)) == null) {
            return 0L;
        }
        return Long.parseLong(idOfGraphObject);
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        int i2 = $SWITCH_TABLE$com$facebook$widget$GraphObjectAdapter$SectionAndItem$Type()[getSectionAndItem(i).getType().ordinal()];
        if (i2 != 1) {
            if (i2 != 2) {
                if (i2 == 3) {
                    return 2;
                }
                throw new FacebookException("Unexpected type of section and item.");
            }
            return 0;
        }
        return 1;
    }

    public OnErrorListener getOnErrorListener() {
        return this.onErrorListener;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String getPictureFieldSpecifier() {
        ImageView imageView = (ImageView) createGraphObjectView(null).findViewById(R.id.com_facebook_picker_image);
        if (imageView == null) {
            return null;
        }
        ViewGroup.LayoutParams layoutParams = imageView.getLayoutParams();
        return String.format("picture.height(%d).width(%d)", Integer.valueOf(layoutParams.height), Integer.valueOf(layoutParams.width));
    }

    protected URI getPictureUriOfGraphObject(T t) {
        ItemPictureData data;
        Object property = t.getProperty(PICTURE);
        String url = property instanceof String ? (String) property : (!(property instanceof JSONObject) || (data = ((ItemPicture) GraphObject.Factory.create((JSONObject) property).cast(ItemPicture.class)).getData()) == null) ? null : data.getUrl();
        if (url != null) {
            try {
                return new URI(url);
            } catch (URISyntaxException unused) {
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getPosition(String str, T t) {
        Iterator<String> it = this.sectionKeys.iterator();
        boolean z = false;
        int i = 0;
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            String next = it.next();
            if (this.displaySections) {
                i++;
            }
            if (next.equals(str)) {
                z = true;
                break;
            }
            i += this.graphObjectsBySection.get(next).size();
        }
        if (z) {
            if (t == null) {
                return i - (this.displaySections ? 1 : 0);
            }
            Iterator<T> it2 = this.graphObjectsBySection.get(str).iterator();
            while (it2.hasNext()) {
                if (GraphObject.Factory.hasSameId(it2.next(), t)) {
                    return i;
                }
                i++;
            }
            return -1;
        }
        return -1;
    }

    @Override // android.widget.SectionIndexer
    public int getPositionForSection(int i) {
        int max;
        if (!this.displaySections || (max = Math.max(0, Math.min(i, this.sectionKeys.size() - 1))) >= this.sectionKeys.size()) {
            return 0;
        }
        return getPosition(this.sectionKeys.get(max), null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Multi-variable type inference failed */
    public SectionAndItem<T> getSectionAndItem(int i) {
        T t;
        String str;
        T t2 = (T) false;
        if (this.sectionKeys.size() == 0) {
            return null;
        }
        if (this.displaySections) {
            for (String str2 : this.sectionKeys) {
                int i2 = i - 1;
                if (i != 0) {
                    ArrayList<T> arrayList = this.graphObjectsBySection.get(str2);
                    if (i2 < arrayList.size()) {
                        t2 = arrayList.get(i2);
                    } else {
                        i = i2 - arrayList.size();
                    }
                }
                t = t2;
                str = (T) str2;
            }
            t = null;
            str = t2;
        } else {
            String str3 = this.sectionKeys.get(0);
            ArrayList<T> arrayList2 = this.graphObjectsBySection.get(str3);
            if (i < 0 || i >= arrayList2.size()) {
                if ($assertionsDisabled || (this.dataNeededListener != null && this.cursor.areMoreObjectsAvailable())) {
                    return new SectionAndItem<>(null, null);
                }
                throw new AssertionError();
            }
            t = this.graphObjectsBySection.get(str3).get(i);
            str = (T) str3;
        }
        if (str != 0) {
            return new SectionAndItem<>(str, t);
        }
        throw new IndexOutOfBoundsException("position");
    }

    @Override // android.widget.SectionIndexer
    public int getSectionForPosition(int i) {
        SectionAndItem<T> sectionAndItem = getSectionAndItem(i);
        if (sectionAndItem == null || sectionAndItem.getType() == SectionAndItem.Type.ACTIVITY_CIRCLE) {
            return 0;
        }
        return Math.max(0, Math.min(this.sectionKeys.indexOf(sectionAndItem.sectionKey), this.sectionKeys.size() - 1));
    }

    protected View getSectionHeaderView(String str, View view, ViewGroup viewGroup) {
        TextView textView = (TextView) view;
        if (textView == null) {
            textView = (TextView) this.inflater.inflate(R.layout.com_facebook_picker_list_section_header, (ViewGroup) null);
        }
        textView.setText(str);
        return textView;
    }

    protected String getSectionKeyOfGraphObject(T t) {
        String str;
        String str2 = this.groupByField;
        if (str2 != null) {
            str = (String) t.getProperty(str2);
            if (str != null && str.length() > 0) {
                str = str.substring(0, 1).toUpperCase();
            }
        } else {
            str = null;
        }
        return str != null ? str : "";
    }

    @Override // android.widget.SectionIndexer
    public Object[] getSections() {
        return this.displaySections ? this.sectionKeys.toArray() : new Object[0];
    }

    public boolean getShowCheckbox() {
        return this.showCheckbox;
    }

    public boolean getShowPicture() {
        return this.showPicture;
    }

    public List<String> getSortFields() {
        return this.sortFields;
    }

    protected CharSequence getSubTitleOfGraphObject(T t) {
        return null;
    }

    protected CharSequence getTitleOfGraphObject(T t) {
        return (String) t.getProperty("name");
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        SectionAndItem<T> sectionAndItem = getSectionAndItem(i);
        int i2 = $SWITCH_TABLE$com$facebook$widget$GraphObjectAdapter$SectionAndItem$Type()[sectionAndItem.getType().ordinal()];
        if (i2 != 1) {
            if (i2 != 2) {
                if (i2 == 3) {
                    if ($assertionsDisabled || (this.cursor.areMoreObjectsAvailable() && this.dataNeededListener != null)) {
                        this.dataNeededListener.onDataNeeded();
                        return getActivityCircleView(view, viewGroup);
                    }
                    throw new AssertionError();
                }
                throw new FacebookException("Unexpected type of section and item.");
            }
            return getSectionHeaderView(sectionAndItem.sectionKey, view, viewGroup);
        }
        return getGraphObjectView(sectionAndItem.graphObject, view, viewGroup);
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return 3;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public boolean hasStableIds() {
        return true;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public boolean isEmpty() {
        return this.sectionKeys.size() == 0;
    }

    @Override // android.widget.BaseAdapter, android.widget.ListAdapter
    public boolean isEnabled(int i) {
        return getSectionAndItem(i).getType() == SectionAndItem.Type.GRAPH_OBJECT;
    }

    boolean isGraphObjectSelected(String str) {
        return false;
    }

    protected void populateGraphObjectView(View view, T t) {
        URI pictureUriOfGraphObject;
        int i;
        String idOfGraphObject = getIdOfGraphObject(t);
        view.setTag(idOfGraphObject);
        CharSequence titleOfGraphObject = getTitleOfGraphObject(t);
        TextView textView = (TextView) view.findViewById(R.id.com_facebook_picker_title);
        if (textView != null) {
            textView.setText(titleOfGraphObject, TextView.BufferType.SPANNABLE);
        }
        CharSequence subTitleOfGraphObject = getSubTitleOfGraphObject(t);
        TextView textView2 = (TextView) view.findViewById(R.id.picker_subtitle);
        if (textView2 != null) {
            if (subTitleOfGraphObject != null) {
                textView2.setText(subTitleOfGraphObject, TextView.BufferType.SPANNABLE);
                i = 0;
            } else {
                i = 8;
            }
            textView2.setVisibility(i);
        }
        if (getShowCheckbox()) {
            updateCheckboxState((CheckBox) view.findViewById(R.id.com_facebook_picker_checkbox), isGraphObjectSelected(idOfGraphObject));
        }
        if (!getShowPicture() || (pictureUriOfGraphObject = getPictureUriOfGraphObject(t)) == null) {
            return;
        }
        ImageView imageView = (ImageView) view.findViewById(R.id.com_facebook_picker_image);
        if (!this.prefetchedPictureCache.containsKey(idOfGraphObject)) {
            downloadProfilePicture(idOfGraphObject, pictureUriOfGraphObject, imageView);
            return;
        }
        ImageResponse imageResponse = this.prefetchedPictureCache.get(idOfGraphObject);
        imageView.setImageBitmap(imageResponse.getBitmap());
        imageView.setTag(imageResponse.getRequest().getImageUri());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void prioritizeViewRange(int i, int i2, int i3) {
        if (i2 < i || this.sectionKeys.size() == 0) {
            return;
        }
        for (int i4 = i2; i4 >= 0; i4--) {
            SectionAndItem sectionAndItem = getSectionAndItem(i4);
            if (sectionAndItem.graphObject != null) {
                ImageRequest imageRequest = this.pendingRequests.get(getIdOfGraphObject(sectionAndItem.graphObject));
                if (imageRequest != null) {
                    ImageDownloader.prioritizeRequest(imageRequest);
                }
            }
        }
        int min = Math.min(i3 + i2, getCount() - 1);
        ArrayList arrayList = new ArrayList();
        for (int max = Math.max(0, i - i3); max < i; max++) {
            SectionAndItem sectionAndItem2 = getSectionAndItem(max);
            if (sectionAndItem2.graphObject != null) {
                arrayList.add(sectionAndItem2.graphObject);
            }
        }
        while (true) {
            i2++;
            if (i2 > min) {
                break;
            }
            SectionAndItem sectionAndItem3 = getSectionAndItem(i2);
            if (sectionAndItem3.graphObject != null) {
                arrayList.add(sectionAndItem3.graphObject);
            }
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            GraphObject graphObject = (GraphObject) it.next();
            URI pictureUriOfGraphObject = getPictureUriOfGraphObject(graphObject);
            String idOfGraphObject = getIdOfGraphObject(graphObject);
            boolean remove = this.prefetchedProfilePictureIds.remove(idOfGraphObject);
            this.prefetchedProfilePictureIds.add(idOfGraphObject);
            if (!remove) {
                downloadProfilePicture(idOfGraphObject, pictureUriOfGraphObject, null);
            }
        }
    }

    public void rebuildAndNotify() {
        rebuildSections();
        notifyDataSetChanged();
    }

    public void setDataNeededListener(DataNeededListener dataNeededListener) {
        this.dataNeededListener = dataNeededListener;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setFilter(Filter<T> filter) {
        this.filter = filter;
    }

    public void setGroupByField(String str) {
        this.groupByField = str;
    }

    public void setOnErrorListener(OnErrorListener onErrorListener) {
        this.onErrorListener = onErrorListener;
    }

    public void setShowCheckbox(boolean z) {
        this.showCheckbox = z;
    }

    public void setShowPicture(boolean z) {
        this.showPicture = z;
    }

    public void setSortFields(List<String> list) {
        this.sortFields = list;
    }

    void updateCheckboxState(CheckBox checkBox, boolean z) {
    }
}
