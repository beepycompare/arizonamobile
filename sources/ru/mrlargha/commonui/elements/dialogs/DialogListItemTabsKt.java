package ru.mrlargha.commonui.elements.dialogs;

import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.MatchResult;
import kotlin.text.Regex;
import kotlin.text.RegexOption;
import kotlin.text.StringsKt;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import ru.mrlargha.commonui.utils.MapperKt;
/* compiled from: DialogListItemTabs.kt */
@Metadata(d1 = {"\u0000.\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a \u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0001H\u0000\u001a\u001a\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u0001H\u0000\u001a(\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\tH\u0000\"\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u0013\u001a\u00020\tX\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0014\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0015\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"resolveDialogListItemTabResponse", "", "confirmed", "", "tabCount", "selectedIndex", "parseDialogListItemTabs", "Lru/mrlargha/commonui/elements/dialogs/DialogListItemTabsContent;", "source", "", "maxTabs", "resolveInfoDialogContent", "Lru/mrlargha/commonui/elements/dialogs/ResolvedInfoDialogContent;", "caption", "info", "leftButtonText", "rightButtonText", "LIST_ITEM_TABS_REGEX", "Lkotlin/text/Regex;", "TAB_SEPARATOR", "DEFAULT_MAX_TABS", "NO_LIST_ITEM", "CommonUI"}, k = 2, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class DialogListItemTabsKt {
    private static final int DEFAULT_MAX_TABS = 2;
    private static final Regex LIST_ITEM_TABS_REGEX = new Regex("\\[\\[\\s*listitemTabs\\s*:\\s*titles\\s*=\\s*([^\\]]*)\\]\\]", RegexOption.IGNORE_CASE);
    private static final int NO_LIST_ITEM = -1;
    private static final String TAB_SEPARATOR = ";";

    public static final int resolveDialogListItemTabResponse(boolean z, int i, int i2) {
        int intValue = Integer.valueOf(i2).intValue();
        Integer num = (!z || intValue < 0 || intValue >= i) ? null : null;
        if (num != null) {
            return num.intValue();
        }
        return -1;
    }

    public static /* synthetic */ DialogListItemTabsContent parseDialogListItemTabs$default(String str, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = 2;
        }
        return parseDialogListItemTabs(str, i);
    }

    public static final DialogListItemTabsContent parseDialogListItemTabs(String source, int i) {
        Intrinsics.checkNotNullParameter(source, "source");
        String str = source;
        MatchResult find$default = Regex.find$default(LIST_ITEM_TABS_REGEX, str, 0, 2, null);
        if (find$default == null) {
            return new DialogListItemTabsContent(source, CollectionsKt.emptyList());
        }
        String str2 = (String) CollectionsKt.getOrNull(find$default.getGroupValues(), 1);
        if (str2 == null) {
            str2 = "";
        }
        List<String> split$default = StringsKt.split$default((CharSequence) str2, new String[]{TAB_SEPARATOR}, false, 0, 6, (Object) null);
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(split$default, 10));
        for (String str3 : split$default) {
            arrayList.add(StringsKt.trim((CharSequence) str3).toString());
        }
        ArrayList arrayList2 = new ArrayList();
        for (Object obj : arrayList) {
            if (!StringsKt.isBlank((String) obj)) {
                arrayList2.add(obj);
            }
        }
        return new DialogListItemTabsContent(StringsKt.trim((CharSequence) LIST_ITEM_TABS_REGEX.replace(str, "")).toString(), CollectionsKt.take(arrayList2, RangesKt.coerceAtLeast(i, 0)));
    }

    public static final ResolvedInfoDialogContent resolveInfoDialogContent(String caption, String info, String leftButtonText, String rightButtonText) {
        Intrinsics.checkNotNullParameter(caption, "caption");
        Intrinsics.checkNotNullParameter(info, "info");
        Intrinsics.checkNotNullParameter(leftButtonText, "leftButtonText");
        Intrinsics.checkNotNullParameter(rightButtonText, "rightButtonText");
        InfoDialogPayload infoDialogPayload = (InfoDialogPayload) ((!MapperKt.isJsonValid(info) || Intrinsics.areEqual(info, AbstractJsonLexerKt.NULL) || Intrinsics.areEqual(info, "{}") || info.length() == 0) ? null : MapperKt.getGson().fromJson(info, (Class<Object>) InfoDialogPayload.class));
        if (infoDialogPayload == null || !infoDialogPayload.hasStructuredContent()) {
            return new ResolvedInfoDialogContent(caption, info, leftButtonText, rightButtonText);
        }
        String header = infoDialogPayload.getHeader();
        if (!StringsKt.isBlank(header)) {
            caption = header;
        }
        String str = caption;
        String body = infoDialogPayload.getBody();
        String primaryButton = infoDialogPayload.getPrimaryButton();
        if (!StringsKt.isBlank(primaryButton)) {
            leftButtonText = primaryButton;
        }
        String str2 = leftButtonText;
        String secondaryButton = infoDialogPayload.getSecondaryButton();
        if (!StringsKt.isBlank(secondaryButton)) {
            rightButtonText = secondaryButton;
        }
        return new ResolvedInfoDialogContent(str, body, str2, rightButtonText);
    }
}
