package ru.mrlargha.commonui.utils;

import com.squareup.picasso.RequestCreator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
/* compiled from: PicassoLoadSafe.kt */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u001a\u0014\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004¨\u0006\u0005"}, d2 = {"loadSafe", "Lcom/squareup/picasso/RequestCreator;", "Lcom/squareup/picasso/Picasso;", "path", "", "CommonUI"}, k = 2, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class PicassoLoadSafeKt {
    public static final RequestCreator loadSafe(com.squareup.picasso.Picasso picasso, String str) {
        Intrinsics.checkNotNullParameter(picasso, "<this>");
        String str2 = str;
        RequestCreator load = picasso.load((str2 == null || StringsKt.isBlank(str2)) ? null : null);
        Intrinsics.checkNotNullExpressionValue(load, "load(...)");
        return load;
    }
}
