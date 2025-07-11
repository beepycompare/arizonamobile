package ru.mrlargha.commonui.core;

import android.app.Activity;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: UIElementFactory.kt */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b&\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\f\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u000eR\u001d\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\u000f"}, d2 = {"Lru/mrlargha/commonui/core/UIElementFactory;", "", "<init>", "()V", "spawnerMap", "", "Lru/mrlargha/commonui/core/UIElementID;", "Lru/mrlargha/commonui/core/UIElementAbstractSpawner;", "getSpawnerMap", "()Ljava/util/Map;", "create", "Lru/mrlargha/commonui/core/SAMPUIElement;", "uiElementID", "targetActivity", "Landroid/app/Activity;", "CommonUI_release_web"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public abstract class UIElementFactory {
    private final Map<UIElementID, UIElementAbstractSpawner> spawnerMap = new LinkedHashMap();

    public final Map<UIElementID, UIElementAbstractSpawner> getSpawnerMap() {
        return this.spawnerMap;
    }

    public final SAMPUIElement create(UIElementID uiElementID, Activity targetActivity) {
        Intrinsics.checkNotNullParameter(uiElementID, "uiElementID");
        Intrinsics.checkNotNullParameter(targetActivity, "targetActivity");
        UIElementAbstractSpawner uIElementAbstractSpawner = this.spawnerMap.get(uiElementID);
        if (uIElementAbstractSpawner != null) {
            return uIElementAbstractSpawner.create(targetActivity, uiElementID.getId());
        }
        return null;
    }
}
