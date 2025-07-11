package ru.mrlargha.commonui.core;

import android.app.Activity;
import android.util.Log;
import androidx.exifinterface.media.ExifInterface;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
/* compiled from: UIElementStore.kt */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0005\u0018\u0000 \u00192\u00020\u0001:\u0001\u0019B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000e\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\bJ\u0019\u0010\u0010\u001a\u0002H\u0011\"\u0004\b\u0000\u0010\u00112\u0006\u0010\u0012\u001a\u00020\u000b¢\u0006\u0002\u0010\u0013J\u000e\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0012\u001a\u00020\u000bJ\u000e\u0010\u0016\u001a\u00020\f2\u0006\u0010\u0012\u001a\u00020\u000bJ\u000e\u0010\u0017\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\u000bJ\u000e\u0010\u0017\u001a\u00020\u000e2\u0006\u0010\u0018\u001a\u00020\fR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f0\nX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Lru/mrlargha/commonui/core/UIElementStore;", "", "targetActivity", "Landroid/app/Activity;", "<init>", "(Landroid/app/Activity;)V", "factories", "", "Lru/mrlargha/commonui/core/UIElementFactory;", "uiElementsMap", "", "Lru/mrlargha/commonui/core/UIElementID;", "Lru/mrlargha/commonui/core/SAMPUIElement;", "addFactory", "", "factory", "getOrCreate", ExifInterface.GPS_DIRECTION_TRUE, "elementID", "(Lru/mrlargha/commonui/core/UIElementID;)Ljava/lang/Object;", "isElementExist", "", "getOrCreateDefault", "removeElement", "element", "Companion", "CommonUI_release_web"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class UIElementStore {
    public static final Companion Companion = new Companion(null);
    private static final String TAG = "UIElementStore";
    private final List<UIElementFactory> factories;
    private final Activity targetActivity;
    private final Map<UIElementID, SAMPUIElement> uiElementsMap;

    public UIElementStore(Activity targetActivity) {
        Intrinsics.checkNotNullParameter(targetActivity, "targetActivity");
        this.targetActivity = targetActivity;
        this.factories = new ArrayList();
        this.uiElementsMap = new LinkedHashMap();
    }

    public final void addFactory(UIElementFactory factory) {
        Intrinsics.checkNotNullParameter(factory, "factory");
        this.factories.add(factory);
    }

    public final <T> T getOrCreate(UIElementID elementID) {
        Intrinsics.checkNotNullParameter(elementID, "elementID");
        Map<UIElementID, SAMPUIElement> map = this.uiElementsMap;
        T t = (T) map.get(elementID);
        if (t == null) {
            Log.d(TAG, "getOrCreate: unable to find view with id: " + elementID + ", creating...");
            T t2 = null;
            for (UIElementFactory uIElementFactory : this.factories) {
                SAMPUIElement create = uIElementFactory.create(elementID, this.targetActivity);
                if (create != null) {
                    t2 = create;
                }
            }
            if (t2 == null) {
                throw new IllegalArgumentException("Unable to create element " + elementID + " - unable to found suitable element spawner");
            }
            map.put(elementID, t2);
            return t2;
        }
        return t;
    }

    public final boolean isElementExist(UIElementID elementID) {
        Intrinsics.checkNotNullParameter(elementID, "elementID");
        return this.uiElementsMap.get(elementID) != null;
    }

    public final SAMPUIElement getOrCreateDefault(UIElementID elementID) {
        Intrinsics.checkNotNullParameter(elementID, "elementID");
        return (SAMPUIElement) getOrCreate(elementID);
    }

    public final void removeElement(UIElementID elementID) {
        Intrinsics.checkNotNullParameter(elementID, "elementID");
        SAMPUIElement sAMPUIElement = this.uiElementsMap.get(elementID);
        if (sAMPUIElement != null) {
            sAMPUIElement.removeAllChildren();
            sAMPUIElement.setVisibility(false);
            sAMPUIElement.removeFromLayout();
        }
        this.uiElementsMap.remove(elementID);
    }

    public final void removeElement(SAMPUIElement element) {
        SAMPUIElement sAMPUIElement;
        Object obj;
        Intrinsics.checkNotNullParameter(element, "element");
        Iterator<T> it = this.uiElementsMap.values().iterator();
        while (true) {
            sAMPUIElement = null;
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            if (Intrinsics.areEqual((SAMPUIElement) obj, element)) {
                break;
            }
        }
        SAMPUIElement sAMPUIElement2 = (SAMPUIElement) obj;
        if (sAMPUIElement2 != null) {
            sAMPUIElement2.removeAllChildren();
            sAMPUIElement2.setVisibility(false);
            sAMPUIElement2.removeFromLayout();
            sAMPUIElement = sAMPUIElement2;
        }
        TypeIntrinsics.asMutableCollection(this.uiElementsMap.values()).remove(sAMPUIElement);
    }

    /* compiled from: UIElementStore.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lru/mrlargha/commonui/core/UIElementStore$Companion;", "", "<init>", "()V", "TAG", "", "CommonUI_release_web"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
