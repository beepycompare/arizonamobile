package com.miami.game.core.external.navigation;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import androidx.media3.common.MimeTypes;
import com.google.firebase.remoteconfig.RemoteConfigConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import timber.log.Timber;
/* compiled from: ExternalNavigationActivityExtensions.kt */
@Metadata(d1 = {"\u0000\"\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\f\u001a\u0014\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u001a\u0012\u0010\u0005\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0007\u001a\u001e\u0010\b\u001a\u00020\t*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\n\u001a\u00020\tH\u0002\u001a\u001a\u0010\u000b\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\f\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u0007\u001a\u001e\u0010\u000e\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u00042\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0007\u001a\u0014\u0010\u0011\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u0007H\u0002\u001a\u0012\u0010\u0013\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u0007¨\u0006\u0015"}, d2 = {"openUri", "", "Landroid/app/Activity;", "uri", "Landroid/net/Uri;", "sendText", "text", "", "browse", "", "newTask", "shareImageUri", "fileUri", "description", "openDeeplink", "deeplinkUri", "defaultPackageName", "openGooglePlayByPackageName", RemoteConfigConstants.RequestFieldKey.PACKAGE_NAME, "dialPhoneNumber", "phone", "external-navigation_release_web"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class ExternalNavigationActivityExtensionsKt {
    public static final void openUri(Activity activity, Uri uri) {
        Intrinsics.checkNotNullParameter(activity, "<this>");
        if (uri != null) {
            browse$default(activity, uri, false, 2, null);
        } else {
            Timber.Forest.e(new OpenBrowserNonFatalException("Error opening browser, uri is null"));
        }
    }

    public static final void sendText(Activity activity, String text) {
        Intrinsics.checkNotNullParameter(activity, "<this>");
        Intrinsics.checkNotNullParameter(text, "text");
        Intent intent = new Intent("android.intent.action.SEND");
        intent.putExtra("android.intent.extra.TEXT", text);
        intent.setType("text/plain");
        try {
            activity.startActivity(intent);
        } catch (ActivityNotFoundException e) {
            Timber.Forest.e(new ShareTextNonFatalException("Error sharing text [" + text + "]", e));
        }
    }

    static /* synthetic */ boolean browse$default(Activity activity, Uri uri, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        return browse(activity, uri, z);
    }

    private static final boolean browse(Activity activity, Uri uri, boolean z) {
        try {
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.setData(uri);
            if (z) {
                intent.addFlags(268435456);
            }
            activity.startActivity(intent);
            return true;
        } catch (ActivityNotFoundException e) {
            Timber.Forest.e(new OpenBrowserNonFatalException("Error opening uri [" + uri + "], newTask: [" + z + "]", e));
            return false;
        }
    }

    public static final void shareImageUri(Activity activity, Uri fileUri, String description) {
        Intrinsics.checkNotNullParameter(activity, "<this>");
        Intrinsics.checkNotNullParameter(fileUri, "fileUri");
        Intrinsics.checkNotNullParameter(description, "description");
        Intent intent = new Intent("android.intent.action.SEND");
        intent.setType(MimeTypes.IMAGE_PNG);
        intent.putExtra("android.intent.extra.STREAM", fileUri);
        intent.putExtra("android.intent.extra.TEXT", description);
        try {
            activity.startActivity(Intent.createChooser(intent, description));
        } catch (ActivityNotFoundException e) {
            Timber.Forest.e(new ShareImageNonFatalException("Error sharing image with link [" + fileUri + "]", e));
        }
    }

    public static /* synthetic */ void openDeeplink$default(Activity activity, Uri uri, String str, int i, Object obj) {
        if ((i & 2) != 0) {
            str = null;
        }
        openDeeplink(activity, uri, str);
    }

    public static final void openDeeplink(Activity activity, Uri deeplinkUri, String str) {
        Intrinsics.checkNotNullParameter(activity, "<this>");
        Intrinsics.checkNotNullParameter(deeplinkUri, "deeplinkUri");
        if (browse$default(activity, deeplinkUri, false, 2, null) || str == null) {
            return;
        }
        openGooglePlayByPackageName(activity, str);
    }

    private static final void openGooglePlayByPackageName(Activity activity, String str) {
        Intent intent = new Intent("android.intent.action.VIEW", Uri.parse("market://details?id=" + str));
        intent.addFlags(1208483840);
        try {
            activity.startActivity(intent);
        } catch (ActivityNotFoundException e) {
            Timber.Forest.e(new OpenGooglePlayNonFatalException("Error opening Google Play with package [" + str + "]", e));
            activity.startActivity(new Intent("android.intent.action.VIEW", Uri.parse("http://play.google.com/store/apps/details?id=" + str)));
        }
    }

    public static final void dialPhoneNumber(Activity activity, String phone) {
        Intrinsics.checkNotNullParameter(activity, "<this>");
        Intrinsics.checkNotNullParameter(phone, "phone");
        if (phone.length() == 0) {
            return;
        }
        try {
            Uri parse = Uri.parse("tel:" + phone);
            if (parse != null) {
                Intent intent = new Intent("android.intent.action.DIAL", parse);
                intent.putExtra("com.android.browser.application_id", activity.getPackageName());
                activity.startActivity(intent);
            }
        } catch (Exception e) {
            Timber.Forest.e(new DialPhoneNonFatalException("Error dialing number", e));
        }
    }
}
