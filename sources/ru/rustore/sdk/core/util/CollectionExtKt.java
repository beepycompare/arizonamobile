package ru.rustore.sdk.core.util;

import android.content.ComponentName;
import android.content.pm.ResolveInfo;
import com.google.firebase.remoteconfig.RemoteConfigConstants;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: CollectionExt.kt */
@Metadata(d1 = {"\u0000\u0018\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\u001a\u001c\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u0004\u001a\u00020\u0005H\u0007\u001a\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u0001*\b\u0012\u0004\u0012\u00020\u00030\u0002\u001a\u0012\u0010\u0007\u001a\u0004\u0018\u00010\u0001*\b\u0012\u0004\u0012\u00020\u00030\u0002\u001a\u001c\u0010\b\u001a\u0004\u0018\u00010\u0001*\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u0004\u001a\u00020\u0005H\u0007¨\u0006\t"}, d2 = {"findActivityComponentName", "Landroid/content/ComponentName;", "", "Landroid/content/pm/ResolveInfo;", RemoteConfigConstants.RequestFieldKey.PACKAGE_NAME, "", "findRuStoreActivityComponentName", "findRuStoreServiceComponentName", "findServiceComponentName", "sdk-public-core_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class CollectionExtKt {
    public static final ComponentName findRuStoreServiceComponentName(List<? extends ResolveInfo> list) {
        Intrinsics.checkNotNullParameter(list, "<this>");
        return findServiceComponentName(list, "ru.vk.store");
    }

    public static final ComponentName findRuStoreActivityComponentName(List<? extends ResolveInfo> list) {
        Intrinsics.checkNotNullParameter(list, "<this>");
        return findActivityComponentName(list, "ru.vk.store");
    }

    public static final ComponentName findServiceComponentName(List<? extends ResolveInfo> list, String packageName) {
        Object obj;
        Intrinsics.checkNotNullParameter(list, "<this>");
        Intrinsics.checkNotNullParameter(packageName, "packageName");
        Iterator<T> it = list.iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            if (((ResolveInfo) obj).serviceInfo.packageName.equals(packageName)) {
                break;
            }
        }
        ResolveInfo resolveInfo = (ResolveInfo) obj;
        if (resolveInfo != null) {
            return new ComponentName(resolveInfo.serviceInfo.packageName, resolveInfo.serviceInfo.name);
        }
        return null;
    }

    public static final ComponentName findActivityComponentName(List<? extends ResolveInfo> list, String packageName) {
        Object obj;
        Intrinsics.checkNotNullParameter(list, "<this>");
        Intrinsics.checkNotNullParameter(packageName, "packageName");
        Iterator<T> it = list.iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            if (((ResolveInfo) obj).activityInfo.packageName.equals(packageName)) {
                break;
            }
        }
        ResolveInfo resolveInfo = (ResolveInfo) obj;
        if (resolveInfo != null) {
            return new ComponentName(resolveInfo.activityInfo.packageName, resolveInfo.activityInfo.name);
        }
        return null;
    }
}
