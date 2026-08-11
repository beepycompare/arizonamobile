package ru.mrlargha.feature.battle_pass_view;

import android.graphics.Color;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
/* compiled from: RewardItemAdapter.kt */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u001a\u0013\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\u0000¢\u0006\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"toBackendColorOrNull", "", "", "(Ljava/lang/String;)Ljava/lang/Integer;", "battle-pass-view"}, k = 2, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class RewardItemAdapterKt {
    public static final Integer toBackendColorOrNull(String str) {
        Object m9915constructorimpl;
        Intrinsics.checkNotNullParameter(str, "<this>");
        try {
            Result.Companion companion = Result.Companion;
            String obj = StringsKt.trim((CharSequence) str).toString();
            if (obj.length() == 9 && StringsKt.startsWith$default((CharSequence) obj, '#', false, 2, (Object) null)) {
                String substring = obj.substring(7, 9);
                Intrinsics.checkNotNullExpressionValue(substring, "substring(...)");
                String substring2 = obj.substring(1, 7);
                Intrinsics.checkNotNullExpressionValue(substring2, "substring(...)");
                obj = "#" + substring + substring2;
            }
            m9915constructorimpl = Result.m9915constructorimpl(Integer.valueOf(Color.parseColor(obj)));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            m9915constructorimpl = Result.m9915constructorimpl(ResultKt.createFailure(th));
        }
        return Result.m9921isFailureimpl(m9915constructorimpl) ? null : m9915constructorimpl;
    }
}
