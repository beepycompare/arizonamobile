package ru.mrlargha.feature.arizona.cases;

import android.content.Context;
import android.widget.ImageView;
import com.miami.game.core.connection.resolver.FirebaseConfigHelper;
import com.squareup.picasso.Picasso;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: CasesResponse.kt */
@Metadata(d1 = {"\u0000\"\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\u000e\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003\u001a\u0012\u0010\n\u001a\u00020\u000b*\u00020\f2\u0006\u0010\r\u001a\u00020\u0001\"\u001a\u0010\u0004\u001a\u00020\u0005X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t\"\u000e\u0010\u000e\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u000f\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"caseTimeConverter", "", "unixTime", "", "appContext", "Landroid/content/Context;", "getAppContext", "()Landroid/content/Context;", "setAppContext", "(Landroid/content/Context;)V", "getCaseImageUrl", "", "Landroid/widget/ImageView;", "imageIc", "ITEM_FOLDER_NAME", CasesResponseKt.CASES_TAG, "cases"}, k = 2, mv = {2, 3, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class CasesResponseKt {
    public static final String CASES_TAG = "CASES_TAG";
    public static final String ITEM_FOLDER_NAME = "items";
    public static Context appContext;

    public static final String caseTimeConverter(long j) {
        if (j == 0) {
            return "";
        }
        Date date = new Date(j * 1000);
        String string = getAppContext().getString(R.string.cases_available_until, new SimpleDateFormat("HH:mm dd.MM.yyyy", Locale.getDefault()).format(date));
        Intrinsics.checkNotNull(string);
        return string;
    }

    public static final Context getAppContext() {
        Context context = appContext;
        if (context != null) {
            return context;
        }
        Intrinsics.throwUninitializedPropertyAccessException("appContext");
        return null;
    }

    public static final void setAppContext(Context context) {
        Intrinsics.checkNotNullParameter(context, "<set-?>");
        appContext = context;
    }

    public static final void getCaseImageUrl(ImageView imageView, String imageIc) {
        Intrinsics.checkNotNullParameter(imageView, "<this>");
        Intrinsics.checkNotNullParameter(imageIc, "imageIc");
        Picasso.get().load(FirebaseConfigHelper.getProjectResourceUrl$default(FirebaseConfigHelper.INSTANCE, false, 1, null) + "/assets/images/donate/" + imageIc).into(imageView);
    }
}
