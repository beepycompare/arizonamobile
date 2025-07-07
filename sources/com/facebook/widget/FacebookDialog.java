package com.facebook.widget;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.fragment.app.Fragment;
import com.facebook.FacebookException;
import com.facebook.FacebookGraphObjectException;
import com.facebook.NativeAppCallAttachmentStore;
import com.facebook.NativeAppCallContentProvider;
import com.facebook.internal.NativeProtocol;
import com.facebook.internal.Utility;
import com.facebook.internal.Validate;
import com.facebook.model.GraphObject;
import com.facebook.model.GraphObjectList;
import com.facebook.model.OpenGraphAction;
import com.facebook.model.OpenGraphObject;
import java.util.ArrayList;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class FacebookDialog {
    public static final String COMPLETION_GESTURE_CANCEL = "cancel";
    private static final String EXTRA_DIALOG_COMPLETE_KEY = "com.facebook.platform.extra.DID_COMPLETE";
    private static final String EXTRA_DIALOG_COMPLETION_GESTURE_KEY = "com.facebook.platform.extra.COMPLETION_GESTURE";
    private static final String EXTRA_DIALOG_COMPLETION_ID_KEY = "com.facebook.platform.extra.POST_ID";
    private static final int MIN_NATIVE_SHARE_PROTOCOL_VERSION = 20130618;
    private static NativeAppCallAttachmentStore attachmentStore;
    private Activity activity;
    private PendingCall appCall;
    private Fragment fragment;
    private OnPresentCallback onPresentCallback;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public static abstract class Builder<CONCRETE extends Builder<?>> {
        protected final Activity activity;
        protected final PendingCall appCall;
        protected final String applicationId;
        protected String applicationName;
        protected Fragment fragment;

        Builder(Activity activity) {
            Validate.notNull(activity, "activity");
            this.activity = activity;
            this.applicationId = Utility.getMetadataApplicationId(activity);
            this.appCall = new PendingCall((int) NativeProtocol.DIALOG_REQUEST_CODE);
        }

        public FacebookDialog build() {
            validate();
            Bundle bundle = new Bundle();
            putExtra(bundle, NativeProtocol.EXTRA_APPLICATION_ID, this.applicationId);
            putExtra(bundle, NativeProtocol.EXTRA_APPLICATION_NAME, this.applicationName);
            Intent handleBuild = handleBuild(bundle);
            if (handleBuild != null) {
                this.appCall.setRequestIntent(handleBuild);
                return new FacebookDialog(this.activity, this.fragment, this.appCall, getOnPresentCallback(), null);
            }
            throw new FacebookException("Unable to create Intent; this likely means the Facebook app is not installed.");
        }

        public boolean canPresent() {
            return handleCanPresent();
        }

        OnPresentCallback getOnPresentCallback() {
            return null;
        }

        abstract Intent handleBuild(Bundle bundle);

        boolean handleCanPresent() {
            return FacebookDialog.getProtocolVersionForNativeDialog(this.activity, 20130618) != -1;
        }

        void putExtra(Bundle bundle, String str, String str2) {
            if (str2 != null) {
                bundle.putString(str, str2);
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        public CONCRETE setApplicationName(String str) {
            this.applicationName = str;
            return this;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public CONCRETE setFragment(Fragment fragment) {
            this.fragment = fragment;
            return this;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public CONCRETE setRequestCode(int i) {
            this.appCall.setRequestCode(i);
            return this;
        }

        void validate() {
        }
    }

    /* loaded from: classes3.dex */
    public interface Callback {
        void onComplete(PendingCall pendingCall, Bundle bundle);

        void onError(PendingCall pendingCall, Exception exc, Bundle bundle);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public interface DialogFeature {
        int getMinVersion();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public interface OnPresentCallback {
        void onPresent(Context context) throws Exception;
    }

    /* loaded from: classes3.dex */
    public static class OpenGraphActionDialogBuilder extends Builder<OpenGraphActionDialogBuilder> {
        private OpenGraphAction action;
        private String actionType;
        private boolean dataErrorsFatal;
        private HashMap<String, Bitmap> imageAttachments;
        private String previewPropertyName;

        public OpenGraphActionDialogBuilder(Activity activity, OpenGraphAction openGraphAction, String str, String str2) {
            super(activity);
            Validate.notNull(openGraphAction, "action");
            Validate.notNullOrEmpty(str, "actionType");
            Validate.notNullOrEmpty(str2, "previewPropertyName");
            if (openGraphAction.getProperty(str2) == null) {
                throw new IllegalArgumentException("A property named \"" + str2 + "\" was not found on the action.  The name of the preview property must match the name of an action property.");
            }
            this.action = openGraphAction;
            this.actionType = str;
            this.previewPropertyName = str2;
        }

        private OpenGraphActionDialogBuilder addImageAttachment(String str, Bitmap bitmap) {
            if (this.imageAttachments == null) {
                this.imageAttachments = new HashMap<>();
            }
            this.imageAttachments.put(str, bitmap);
            return this;
        }

        private List<String> addImageAttachments(List<Bitmap> list) {
            ArrayList arrayList = new ArrayList();
            for (Bitmap bitmap : list) {
                String uuid = UUID.randomUUID().toString();
                addImageAttachment(uuid, bitmap);
                arrayList.add(NativeAppCallContentProvider.getAttachmentUrl(this.applicationId, this.appCall.getCallId(), uuid));
            }
            return arrayList;
        }

        private JSONObject flattenChildrenOfGraphObject(JSONObject jSONObject) {
            try {
                JSONObject jSONObject2 = new JSONObject(jSONObject.toString());
                Iterator<String> keys = jSONObject2.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    if (!next.equalsIgnoreCase("image")) {
                        jSONObject2.put(next, flattenObject(jSONObject2.get(next)));
                    }
                }
                return jSONObject2;
            } catch (JSONException e) {
                throw new FacebookException(e);
            }
        }

        private Object flattenObject(Object obj) throws JSONException {
            if (obj == null) {
                return null;
            }
            if (obj instanceof JSONObject) {
                JSONObject jSONObject = (JSONObject) obj;
                if (!jSONObject.optBoolean(NativeProtocol.OPEN_GRAPH_CREATE_OBJECT_KEY)) {
                    if (jSONObject.has("id")) {
                        return jSONObject.getString("id");
                    }
                    if (jSONObject.has("url")) {
                        return jSONObject.getString("url");
                    }
                }
            } else if (obj instanceof JSONArray) {
                JSONArray jSONArray = (JSONArray) obj;
                JSONArray jSONArray2 = new JSONArray();
                int length = jSONArray.length();
                for (int i = 0; i < length; i++) {
                    jSONArray2.put(flattenObject(jSONArray.get(i)));
                }
                return jSONArray2;
            }
            return obj;
        }

        @Override // com.facebook.widget.FacebookDialog.Builder
        public /* bridge */ /* synthetic */ FacebookDialog build() {
            return super.build();
        }

        @Override // com.facebook.widget.FacebookDialog.Builder
        public /* bridge */ /* synthetic */ boolean canPresent() {
            return super.canPresent();
        }

        List<String> getImageAttachmentNames() {
            return new ArrayList(this.imageAttachments.keySet());
        }

        @Override // com.facebook.widget.FacebookDialog.Builder
        OnPresentCallback getOnPresentCallback() {
            return new OnPresentCallback() { // from class: com.facebook.widget.FacebookDialog.OpenGraphActionDialogBuilder.1
                @Override // com.facebook.widget.FacebookDialog.OnPresentCallback
                public void onPresent(Context context) throws Exception {
                    if (OpenGraphActionDialogBuilder.this.imageAttachments == null || OpenGraphActionDialogBuilder.this.imageAttachments.size() <= 0) {
                        return;
                    }
                    FacebookDialog.access$2().addAttachmentsForCall(context, OpenGraphActionDialogBuilder.this.appCall.getCallId(), OpenGraphActionDialogBuilder.this.imageAttachments);
                }
            };
        }

        @Override // com.facebook.widget.FacebookDialog.Builder
        Intent handleBuild(Bundle bundle) {
            putExtra(bundle, NativeProtocol.EXTRA_PREVIEW_PROPERTY_NAME, this.previewPropertyName);
            putExtra(bundle, NativeProtocol.EXTRA_ACTION_TYPE, this.actionType);
            bundle.putBoolean(NativeProtocol.EXTRA_DATA_FAILURES_FATAL, this.dataErrorsFatal);
            putExtra(bundle, NativeProtocol.EXTRA_ACTION, flattenChildrenOfGraphObject(this.action.getInnerJSONObject()).toString());
            return NativeProtocol.createPlatformActivityIntent(this.activity, NativeProtocol.ACTION_OGACTIONPUBLISH_DIALOG, FacebookDialog.getProtocolVersionForNativeDialog(this.activity, 20130618), bundle);
        }

        @Override // com.facebook.widget.FacebookDialog.Builder
        boolean handleCanPresent() {
            return FacebookDialog.canPresentOpenGraphActionDialog(this.activity, OpenGraphActionDialogFeature.OG_ACTION_DIALOG);
        }

        /* JADX WARN: Type inference failed for: r1v1, types: [com.facebook.widget.FacebookDialog$Builder, com.facebook.widget.FacebookDialog$OpenGraphActionDialogBuilder] */
        @Override // com.facebook.widget.FacebookDialog.Builder
        public /* bridge */ /* synthetic */ OpenGraphActionDialogBuilder setApplicationName(String str) {
            return super.setApplicationName(str);
        }

        public OpenGraphActionDialogBuilder setDataErrorsFatal(boolean z) {
            this.dataErrorsFatal = z;
            return this;
        }

        /* JADX WARN: Type inference failed for: r1v1, types: [com.facebook.widget.FacebookDialog$Builder, com.facebook.widget.FacebookDialog$OpenGraphActionDialogBuilder] */
        @Override // com.facebook.widget.FacebookDialog.Builder
        public /* bridge */ /* synthetic */ OpenGraphActionDialogBuilder setFragment(Fragment fragment) {
            return super.setFragment(fragment);
        }

        public OpenGraphActionDialogBuilder setImageAttachmentsForAction(List<Bitmap> list) {
            return setImageAttachmentsForAction(list, false);
        }

        public OpenGraphActionDialogBuilder setImageAttachmentsForAction(List<Bitmap> list, boolean z) {
            Validate.containsNoNulls(list, "bitmaps");
            if (this.action != null) {
                List<String> addImageAttachments = addImageAttachments(list);
                if (!z) {
                    this.action.setImageUrls(addImageAttachments);
                    return this;
                }
                ArrayList arrayList = new ArrayList(addImageAttachments.size());
                for (String str : addImageAttachments) {
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.put("url", str);
                        jSONObject.put(NativeProtocol.IMAGE_USER_GENERATED_KEY, true);
                        arrayList.add(jSONObject);
                    } catch (JSONException e) {
                        throw new FacebookException("Unable to attach images", e);
                    }
                }
                this.action.setImage(arrayList);
                return this;
            }
            throw new FacebookException("Can not set attachments prior to setting action.");
        }

        public OpenGraphActionDialogBuilder setImageAttachmentsForObject(String str, List<Bitmap> list) {
            return setImageAttachmentsForObject(str, list, false);
        }

        public OpenGraphActionDialogBuilder setImageAttachmentsForObject(String str, List<Bitmap> list, boolean z) {
            Validate.notNull(str, "objectProperty");
            Validate.containsNoNulls(list, "bitmaps");
            OpenGraphAction openGraphAction = this.action;
            if (openGraphAction != null) {
                try {
                    OpenGraphObject openGraphObject = (OpenGraphObject) openGraphAction.getPropertyAs(str, OpenGraphObject.class);
                    if (openGraphObject == null) {
                        throw new IllegalArgumentException("Action does not contain a property" + str);
                    }
                    List<String> addImageAttachments = addImageAttachments(list);
                    if (!z) {
                        openGraphObject.setImageUrls(addImageAttachments);
                        return this;
                    }
                    GraphObjectList<GraphObject> createList = GraphObject.Factory.createList(GraphObject.class);
                    for (String str2 : addImageAttachments) {
                        GraphObject create = GraphObject.Factory.create();
                        create.setProperty("url", str2);
                        create.setProperty(NativeProtocol.IMAGE_USER_GENERATED_KEY, true);
                        createList.add(create);
                    }
                    openGraphObject.setImage(createList);
                    return this;
                } catch (FacebookGraphObjectException unused) {
                    throw new IllegalArgumentException("Property " + str + " is not a graph object.");
                }
            }
            throw new FacebookException("Can not set attachments prior to setting action.");
        }

        /* JADX WARN: Type inference failed for: r1v1, types: [com.facebook.widget.FacebookDialog$Builder, com.facebook.widget.FacebookDialog$OpenGraphActionDialogBuilder] */
        @Override // com.facebook.widget.FacebookDialog.Builder
        public /* bridge */ /* synthetic */ OpenGraphActionDialogBuilder setRequestCode(int i) {
            return super.setRequestCode(i);
        }
    }

    /* loaded from: classes3.dex */
    public enum OpenGraphActionDialogFeature implements DialogFeature {
        OG_ACTION_DIALOG(20130618);
        
        private int minVersion;

        OpenGraphActionDialogFeature(int i) {
            this.minVersion = i;
        }

        /* renamed from: values  reason: to resolve conflict with enum method */
        public static OpenGraphActionDialogFeature[] valuesCustom() {
            OpenGraphActionDialogFeature[] valuesCustom = values();
            int length = valuesCustom.length;
            OpenGraphActionDialogFeature[] openGraphActionDialogFeatureArr = new OpenGraphActionDialogFeature[length];
            System.arraycopy(valuesCustom, 0, openGraphActionDialogFeatureArr, 0, length);
            return openGraphActionDialogFeatureArr;
        }

        @Override // com.facebook.widget.FacebookDialog.DialogFeature
        public int getMinVersion() {
            return this.minVersion;
        }
    }

    /* loaded from: classes3.dex */
    public static class PendingCall implements Parcelable {
        public static final Parcelable.Creator<PendingCall> CREATOR = new Parcelable.Creator<PendingCall>() { // from class: com.facebook.widget.FacebookDialog.PendingCall.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public PendingCall createFromParcel(Parcel parcel) {
                return new PendingCall(parcel, null);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public PendingCall[] newArray(int i) {
                return new PendingCall[i];
            }
        };
        private UUID callId;
        private int requestCode;
        private Intent requestIntent;

        public PendingCall(int i) {
            this.callId = UUID.randomUUID();
            this.requestCode = i;
        }

        private PendingCall(Parcel parcel) {
            this.callId = UUID.fromString(parcel.readString());
            this.requestIntent = (Intent) parcel.readParcelable(null);
            this.requestCode = parcel.readInt();
        }

        /* synthetic */ PendingCall(Parcel parcel, PendingCall pendingCall) {
            this(parcel);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setRequestCode(int i) {
            this.requestCode = i;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setRequestIntent(Intent intent) {
            this.requestIntent = intent;
            intent.putExtra(NativeProtocol.EXTRA_PROTOCOL_CALL_ID, this.callId.toString());
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public UUID getCallId() {
            return this.callId;
        }

        public int getRequestCode() {
            return this.requestCode;
        }

        public Intent getRequestIntent() {
            return this.requestIntent;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeString(this.callId.toString());
            parcel.writeParcelable(this.requestIntent, 0);
            parcel.writeInt(this.requestCode);
        }
    }

    /* loaded from: classes3.dex */
    public static class ShareDialogBuilder extends Builder<ShareDialogBuilder> {
        private String caption;
        private boolean dataErrorsFatal;
        private String description;
        private ArrayList<String> friends;
        private String link;
        private String name;
        private String picture;
        private String place;
        private String ref;

        public ShareDialogBuilder(Activity activity) {
            super(activity);
        }

        @Override // com.facebook.widget.FacebookDialog.Builder
        public /* bridge */ /* synthetic */ FacebookDialog build() {
            return super.build();
        }

        @Override // com.facebook.widget.FacebookDialog.Builder
        public /* bridge */ /* synthetic */ boolean canPresent() {
            return super.canPresent();
        }

        @Override // com.facebook.widget.FacebookDialog.Builder
        Intent handleBuild(Bundle bundle) {
            putExtra(bundle, NativeProtocol.EXTRA_APPLICATION_ID, this.applicationId);
            putExtra(bundle, NativeProtocol.EXTRA_APPLICATION_NAME, this.applicationName);
            putExtra(bundle, NativeProtocol.EXTRA_TITLE, this.name);
            putExtra(bundle, NativeProtocol.EXTRA_SUBTITLE, this.caption);
            putExtra(bundle, NativeProtocol.EXTRA_DESCRIPTION, this.description);
            putExtra(bundle, NativeProtocol.EXTRA_LINK, this.link);
            putExtra(bundle, NativeProtocol.EXTRA_IMAGE, this.picture);
            putExtra(bundle, NativeProtocol.EXTRA_PLACE_TAG, this.place);
            putExtra(bundle, NativeProtocol.EXTRA_TITLE, this.name);
            putExtra(bundle, NativeProtocol.EXTRA_REF, this.ref);
            bundle.putBoolean(NativeProtocol.EXTRA_DATA_FAILURES_FATAL, this.dataErrorsFatal);
            if (!Utility.isNullOrEmpty(this.friends)) {
                bundle.putStringArrayList(NativeProtocol.EXTRA_FRIEND_TAGS, this.friends);
            }
            return NativeProtocol.createPlatformActivityIntent(this.activity, NativeProtocol.ACTION_FEED_DIALOG, FacebookDialog.getProtocolVersionForNativeDialog(this.activity, 20130618), bundle);
        }

        @Override // com.facebook.widget.FacebookDialog.Builder
        boolean handleCanPresent() {
            return FacebookDialog.canPresentShareDialog(this.activity, ShareDialogFeature.SHARE_DIALOG);
        }

        /* JADX WARN: Type inference failed for: r1v1, types: [com.facebook.widget.FacebookDialog$ShareDialogBuilder, com.facebook.widget.FacebookDialog$Builder] */
        @Override // com.facebook.widget.FacebookDialog.Builder
        public /* bridge */ /* synthetic */ ShareDialogBuilder setApplicationName(String str) {
            return super.setApplicationName(str);
        }

        public ShareDialogBuilder setCaption(String str) {
            this.caption = str;
            return this;
        }

        public ShareDialogBuilder setDataErrorsFatal(boolean z) {
            this.dataErrorsFatal = z;
            return this;
        }

        public ShareDialogBuilder setDescription(String str) {
            this.description = str;
            return this;
        }

        /* JADX WARN: Type inference failed for: r1v1, types: [com.facebook.widget.FacebookDialog$ShareDialogBuilder, com.facebook.widget.FacebookDialog$Builder] */
        @Override // com.facebook.widget.FacebookDialog.Builder
        public /* bridge */ /* synthetic */ ShareDialogBuilder setFragment(Fragment fragment) {
            return super.setFragment(fragment);
        }

        public ShareDialogBuilder setFriends(List<String> list) {
            this.friends = new ArrayList<>(list);
            return this;
        }

        public ShareDialogBuilder setLink(String str) {
            this.link = str;
            return this;
        }

        public ShareDialogBuilder setName(String str) {
            this.name = str;
            return this;
        }

        public ShareDialogBuilder setPicture(String str) {
            this.picture = str;
            return this;
        }

        public ShareDialogBuilder setPlace(String str) {
            this.place = str;
            return this;
        }

        public ShareDialogBuilder setRef(String str) {
            this.ref = str;
            return this;
        }

        /* JADX WARN: Type inference failed for: r1v1, types: [com.facebook.widget.FacebookDialog$ShareDialogBuilder, com.facebook.widget.FacebookDialog$Builder] */
        @Override // com.facebook.widget.FacebookDialog.Builder
        public /* bridge */ /* synthetic */ ShareDialogBuilder setRequestCode(int i) {
            return super.setRequestCode(i);
        }
    }

    /* loaded from: classes3.dex */
    public enum ShareDialogFeature implements DialogFeature {
        SHARE_DIALOG(20130618);
        
        private int minVersion;

        ShareDialogFeature(int i) {
            this.minVersion = i;
        }

        /* renamed from: values  reason: to resolve conflict with enum method */
        public static ShareDialogFeature[] valuesCustom() {
            ShareDialogFeature[] valuesCustom = values();
            int length = valuesCustom.length;
            ShareDialogFeature[] shareDialogFeatureArr = new ShareDialogFeature[length];
            System.arraycopy(valuesCustom, 0, shareDialogFeatureArr, 0, length);
            return shareDialogFeatureArr;
        }

        @Override // com.facebook.widget.FacebookDialog.DialogFeature
        public int getMinVersion() {
            return this.minVersion;
        }
    }

    private FacebookDialog(Activity activity, Fragment fragment, PendingCall pendingCall, OnPresentCallback onPresentCallback) {
        this.activity = activity;
        this.fragment = fragment;
        this.appCall = pendingCall;
        this.onPresentCallback = onPresentCallback;
    }

    /* synthetic */ FacebookDialog(Activity activity, Fragment fragment, PendingCall pendingCall, OnPresentCallback onPresentCallback, FacebookDialog facebookDialog) {
        this(activity, fragment, pendingCall, onPresentCallback);
    }

    static /* synthetic */ NativeAppCallAttachmentStore access$2() {
        return getAttachmentStore();
    }

    public static boolean canPresentOpenGraphActionDialog(Context context, OpenGraphActionDialogFeature... openGraphActionDialogFeatureArr) {
        return handleCanPresent(context, EnumSet.of(OpenGraphActionDialogFeature.OG_ACTION_DIALOG, openGraphActionDialogFeatureArr));
    }

    public static boolean canPresentShareDialog(Context context, ShareDialogFeature... shareDialogFeatureArr) {
        return handleCanPresent(context, EnumSet.of(ShareDialogFeature.SHARE_DIALOG, shareDialogFeatureArr));
    }

    private static NativeAppCallAttachmentStore getAttachmentStore() {
        if (attachmentStore == null) {
            attachmentStore = new NativeAppCallAttachmentStore();
        }
        return attachmentStore;
    }

    private static int getMinVersionForFeatures(Iterable<? extends DialogFeature> iterable) {
        int i = Integer.MIN_VALUE;
        for (DialogFeature dialogFeature : iterable) {
            i = Math.max(i, dialogFeature.getMinVersion());
        }
        return i;
    }

    public static String getNativeDialogCompletionGesture(Bundle bundle) {
        return bundle.getString(EXTRA_DIALOG_COMPLETION_GESTURE_KEY);
    }

    public static boolean getNativeDialogDidComplete(Bundle bundle) {
        return bundle.getBoolean(EXTRA_DIALOG_COMPLETE_KEY, false);
    }

    public static String getNativeDialogPostId(Bundle bundle) {
        return bundle.getString(EXTRA_DIALOG_COMPLETION_ID_KEY);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int getProtocolVersionForNativeDialog(Context context, Integer num) {
        return NativeProtocol.getLatestAvailableProtocolVersion(context, num.intValue());
    }

    public static boolean handleActivityResult(Context context, PendingCall pendingCall, int i, Intent intent, Callback callback) {
        if (i != pendingCall.getRequestCode()) {
            return false;
        }
        NativeAppCallAttachmentStore nativeAppCallAttachmentStore = attachmentStore;
        if (nativeAppCallAttachmentStore != null) {
            nativeAppCallAttachmentStore.cleanupAttachmentsForCall(context, pendingCall.getCallId());
        }
        if (callback != null) {
            if (NativeProtocol.isErrorResult(intent)) {
                callback.onError(pendingCall, NativeProtocol.getErrorFromResult(intent), intent.getExtras());
                return true;
            }
            callback.onComplete(pendingCall, intent.getExtras());
            return true;
        }
        return true;
    }

    private static boolean handleCanPresent(Context context, Iterable<? extends DialogFeature> iterable) {
        return getProtocolVersionForNativeDialog(context, Integer.valueOf(getMinVersionForFeatures(iterable))) != -1;
    }

    public PendingCall present() {
        OnPresentCallback onPresentCallback = this.onPresentCallback;
        if (onPresentCallback != null) {
            try {
                onPresentCallback.onPresent(this.activity);
            } catch (Exception e) {
                throw new FacebookException(e);
            }
        }
        Fragment fragment = this.fragment;
        if (fragment != null) {
            fragment.startActivityForResult(this.appCall.getRequestIntent(), this.appCall.getRequestCode());
        } else {
            this.activity.startActivityForResult(this.appCall.getRequestIntent(), this.appCall.getRequestCode());
        }
        return this.appCall;
    }
}
