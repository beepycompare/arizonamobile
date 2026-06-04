package ru.mrlargha.feature.workshop.presentation;

import android.content.Context;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: WorkshopResponse.kt */
@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\u001a\u001a\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\f\b\u0001\u0010\u0003\u001a\u00020\u0004:\u0002\b\u0005H\u0002¨\u0006\u0006"}, d2 = {"stringOrEmpty", "", "Landroid/content/Context;", "resId", "", "Landroidx/annotation/StringRes;", "workshop"}, k = 2, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class WorkshopResponseKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final String stringOrEmpty(Context context, int i) {
        if (i == 0) {
            return "";
        }
        String string = context.getString(i);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        return string;
    }
}
