package com.arizona.launcher.util;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.util.Log;
import android.widget.Toast;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
/* compiled from: String.kt */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0014\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u0007¨\u0006\u0005"}, d2 = {"openLink", "", "", "context", "Landroid/content/Context;", "app_arizonaRelease_web"}, k = 2, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class StringKt {
    public static final void openLink(String str, Context context) {
        Uri parse;
        Intrinsics.checkNotNullParameter(str, "<this>");
        Intrinsics.checkNotNullParameter(context, "context");
        try {
            if (!StringsKt.startsWith$default(str, "http://", false, 2, (Object) null) && !StringsKt.startsWith$default(str, "https://", false, 2, (Object) null)) {
                parse = Uri.parse("http://" + str);
            } else {
                parse = Uri.parse(str);
            }
            context.startActivity(new Intent("android.intent.action.VIEW", parse));
        } catch (ActivityNotFoundException e) {
            Toast.makeText(context, "Невозможно открыть ссылку, возможно у вас не установлен браузер!", 1).show();
            Log.w("StringOpenLink", "unable to open link: " + str, e);
        }
    }
}
