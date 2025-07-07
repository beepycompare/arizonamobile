package androidx.privacysandbox.ads.adservices.adselection;

import android.content.Context;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: AdSelectionManagerApi33Ext4Impl.kt */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004¨\u0006\u0005"}, d2 = {"Landroidx/privacysandbox/ads/adservices/adselection/AdSelectionManagerApi33Ext4Impl;", "Landroidx/privacysandbox/ads/adservices/adselection/AdSelectionManagerImplCommon;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "ads-adservices_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class AdSelectionManagerApi33Ext4Impl extends AdSelectionManagerImplCommon {
    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public AdSelectionManagerApi33Ext4Impl(Context context) {
        super((android.adservices.adselection.AdSelectionManager) r2);
        Intrinsics.checkNotNullParameter(context, "context");
        Object systemService = context.getSystemService(android.adservices.adselection.AdSelectionManager.class);
        Intrinsics.checkNotNullExpressionValue(systemService, "context.getSystemService…ctionManager::class.java)");
    }
}
