package ru.mrlargha.feature.arizona.cases;

import android.widget.ImageView;
import com.miami.game.core.connection.resolver.FirebaseConfigHelper;
import com.squareup.picasso.Picasso;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: CasesResponse.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\u000e\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003\u001a\u0012\u0010\u0004\u001a\u00020\u0005*\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0001\"\u000e\u0010\b\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\t\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"caseTimeConverter", "", "unixTime", "", "getCaseImageUrl", "", "Landroid/widget/ImageView;", "imageIc", "ITEM_FOLDER_NAME", CasesResponseKt.CASES_TAG, "cases_release"}, k = 2, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class CasesResponseKt {
    public static final String CASES_TAG = "CASES_TAG";
    public static final String ITEM_FOLDER_NAME = "items";

    public static final String caseTimeConverter(long j) {
        if (j == 0) {
            return "";
        }
        return "Доступен до " + new SimpleDateFormat("HH:mm dd.MM.yyyy", Locale.getDefault()).format(new Date(j * 1000));
    }

    public static final void getCaseImageUrl(ImageView imageView, String imageIc) {
        Intrinsics.checkNotNullParameter(imageView, "<this>");
        Intrinsics.checkNotNullParameter(imageIc, "imageIc");
        Picasso.get().load(FirebaseConfigHelper.INSTANCE.getResourceUrl() + "/projects/arizona-rp/assets/images/donate/" + imageIc).into(imageView);
    }
}
