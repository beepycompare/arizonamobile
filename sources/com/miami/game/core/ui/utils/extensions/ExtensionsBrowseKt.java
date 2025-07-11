package com.miami.game.core.ui.utils.extensions;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
/* compiled from: ExtensionsBrowse.kt */
@Metadata(d1 = {"\u0000$\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\f\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002\u001a\u0012\u0010\u0003\u001a\u00020\u0004*\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0001\u001a\u0012\u0010\u0003\u001a\u00020\u0004*\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0002\u001a\u001c\u0010\u0007\u001a\u00020\b*\u00020\t2\u0006\u0010\u0006\u001a\u00020\u00012\b\b\u0002\u0010\n\u001a\u00020\b¨\u0006\u000b"}, d2 = {"toUriOrNull", "Landroid/net/Uri;", "", "openUri", "", "Landroid/app/Activity;", "uri", "browse", "", "Landroid/content/Context;", "newTask", "ui-utils_release_web"}, k = 2, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class ExtensionsBrowseKt {
    public static final Uri toUriOrNull(String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        if (StringsKt.isBlank(str)) {
            str = null;
        }
        if (str != null) {
            return Uri.parse(str);
        }
        return null;
    }

    public static final void openUri(Activity activity, Uri uri) {
        Intrinsics.checkNotNullParameter(activity, "<this>");
        Intrinsics.checkNotNullParameter(uri, "uri");
        browse$default(activity, uri, false, 2, null);
    }

    public static final void openUri(Activity activity, String uri) {
        Intrinsics.checkNotNullParameter(activity, "<this>");
        Intrinsics.checkNotNullParameter(uri, "uri");
        Uri uriOrNull = toUriOrNull(uri);
        if (uriOrNull != null) {
            openUri(activity, uriOrNull);
        }
    }

    public static /* synthetic */ boolean browse$default(Context context, Uri uri, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        return browse(context, uri, z);
    }

    public static final boolean browse(Context context, Uri uri, boolean z) {
        Intrinsics.checkNotNullParameter(context, "<this>");
        Intrinsics.checkNotNullParameter(uri, "uri");
        try {
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.setData(uri);
            if (z) {
                intent.addFlags(268435456);
            }
            context.startActivity(intent);
            return true;
        } catch (ActivityNotFoundException e) {
            e.printStackTrace();
            return false;
        }
    }
}
