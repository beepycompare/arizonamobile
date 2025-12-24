package ru.mrlargha.commonui.elements.hud.presentation;

import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.MatchResult;
import kotlin.text.Regex;
/* compiled from: utils.kt */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\u001a\u001e\u0010\u0000\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0002H\u0000¨\u0006\u0004"}, d2 = {"parseString", "Lkotlin/Pair;", "", "input", "CommonUI_release"}, k = 2, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class UtilsKt {
    public static final Pair<String, String> parseString(String input) {
        Intrinsics.checkNotNullParameter(input, "input");
        MatchResult matchEntire = new Regex("^\\[([^]]+)]\\s*(.*)$").matchEntire(input);
        if (matchEntire != null) {
            MatchResult.Destructured destructured = matchEntire.getDestructured();
            return TuplesKt.to(destructured.getMatch().getGroupValues().get(1), destructured.getMatch().getGroupValues().get(2));
        }
        return TuplesKt.to(null, input);
    }
}
