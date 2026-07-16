package ru.mrlargha.commonui.elements.dialogs;

import androidx.media3.extractor.text.ttml.TtmlNode;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.SequencesKt;
import kotlin.text.StringsKt;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import ru.mrlargha.commonui.utils.MapperKt;
/* compiled from: DialogBankHistory.kt */
@Metadata(d1 = {"\u0000>\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\t\n\u0000\u001a\u0018\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\tH\u0002\u001a\u0016\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\f2\u0006\u0010\u000e\u001a\u00020\tH\u0002\u001a\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\tH\u0002\u001a\u0012\u0010\u0012\u001a\u0004\u0018\u00010\r2\u0006\u0010\u0011\u001a\u00020\tH\u0002\u001a\u0016\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00150\u00142\u0006\u0010\u0016\u001a\u00020\u0001H\u0002\u001a\f\u0010!\u001a\u00020\"*\u00020\"H\u0002\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0004\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0005\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0017\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0018\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0019\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u001a\u001a\u00020\tX\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u001b\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u001c\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u001d\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u001e\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u001f\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010 \u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000¨\u0006#"}, d2 = {"OPERATION_WITHDRAW", "", "OPERATION_DEPOSIT", "OPERATION_TOPUP", "OPERATION_TRANSFER", "OPERATION_INDEXATION", "buildPayload", "Lru/mrlargha/commonui/elements/dialogs/DialogBankHistoryModel;", "caption", "", "infoData", "parseRows", "", "Lru/mrlargha/commonui/elements/dialogs/DialogBankHistoryRow;", TtmlNode.TAG_BODY, "isHeaderLine", "", "line", "parseRow", "resolveAllowedTabs", "", "Lru/mrlargha/commonui/elements/dialogs/DialogBankHistoryTab;", "addType", "HISTORY_TYPE_DEPOSIT", "HISTORY_TYPE_ORGANIZATION", "UNKNOWN_OPERATION", "COLUMN_SEPARATOR", "ID_COLUMN", "OPERATION_TYPE_COLUMN", "COMMISSION_COLUMN", "TARGET_COLUMN", "AMOUNT_COLUMN", "DATE_COLUMN", "absSafe", "", "CommonUI"}, k = 2, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class DialogBankHistoryKt {
    private static final int AMOUNT_COLUMN = 4;
    private static final String COLUMN_SEPARATOR = "\t";
    private static final int COMMISSION_COLUMN = 2;
    private static final int DATE_COLUMN = 5;
    private static final int HISTORY_TYPE_DEPOSIT = 1;
    private static final int HISTORY_TYPE_ORGANIZATION = 2;
    private static final int ID_COLUMN = 0;
    private static final int OPERATION_DEPOSIT = 1;
    private static final int OPERATION_INDEXATION = 4;
    private static final int OPERATION_TOPUP = 2;
    private static final int OPERATION_TRANSFER = 3;
    private static final int OPERATION_TYPE_COLUMN = 1;
    private static final int OPERATION_WITHDRAW = 0;
    private static final int TARGET_COLUMN = 3;
    private static final int UNKNOWN_OPERATION = -1;

    /* JADX INFO: Access modifiers changed from: private */
    public static final List<DialogBankHistoryRow> parseRows(String str) {
        List<String> list = SequencesKt.toList(SequencesKt.filter(SequencesKt.map(StringsKt.lineSequence(str), new Function1() { // from class: ru.mrlargha.commonui.elements.dialogs.DialogBankHistoryKt$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return DialogBankHistoryKt.parseRows$lambda$0((String) obj);
            }
        }), new Function1() { // from class: ru.mrlargha.commonui.elements.dialogs.DialogBankHistoryKt$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return Boolean.valueOf(DialogBankHistoryKt.parseRows$lambda$1((String) obj));
            }
        }));
        if (list.isEmpty()) {
            return CollectionsKt.emptyList();
        }
        if (isHeaderLine((String) CollectionsKt.first((List<? extends Object>) list))) {
            list = CollectionsKt.drop(list, 1);
        }
        ArrayList arrayList = new ArrayList();
        for (String str2 : list) {
            DialogBankHistoryRow parseRow = parseRow(str2);
            if (parseRow != null) {
                arrayList.add(parseRow);
            }
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final String parseRows$lambda$0(String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return StringsKt.trim((CharSequence) it).toString();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final boolean parseRows$lambda$1(String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return !StringsKt.isBlank(it);
    }

    private static final boolean isHeaderLine(String str) {
        String obj;
        String str2 = (String) CollectionsKt.getOrNull(StringsKt.split$default((CharSequence) str, new String[]{COLUMN_SEPARATOR}, false, 0, 6, (Object) null), 1);
        return ((str2 == null || (obj = StringsKt.trim((CharSequence) str2).toString()) == null) ? null : StringsKt.toIntOrNull(obj)) == null;
    }

    private static final DialogBankHistoryRow parseRow(String str) {
        String obj;
        Integer intOrNull;
        List split$default = StringsKt.split$default((CharSequence) str, new String[]{COLUMN_SEPARATOR}, false, 0, 6, (Object) null);
        if (split$default.size() <= 1) {
            return null;
        }
        String str2 = (String) CollectionsKt.getOrNull(split$default, 0);
        String obj2 = str2 != null ? StringsKt.trim((CharSequence) str2).toString() : null;
        String str3 = obj2 == null ? "" : obj2;
        String str4 = (String) CollectionsKt.getOrNull(split$default, 1);
        int intValue = (str4 == null || (obj = StringsKt.trim((CharSequence) str4).toString()) == null || (intOrNull = StringsKt.toIntOrNull(obj)) == null) ? -1 : intOrNull.intValue();
        String str5 = (String) CollectionsKt.getOrNull(split$default, 2);
        String obj3 = str5 != null ? StringsKt.trim((CharSequence) str5).toString() : null;
        String str6 = obj3 == null ? "" : obj3;
        String str7 = (String) CollectionsKt.getOrNull(split$default, 3);
        String obj4 = str7 != null ? StringsKt.trim((CharSequence) str7).toString() : null;
        String str8 = obj4 == null ? "" : obj4;
        String str9 = (String) CollectionsKt.getOrNull(split$default, 4);
        String obj5 = str9 != null ? StringsKt.trim((CharSequence) str9).toString() : null;
        String str10 = obj5 == null ? "" : obj5;
        String str11 = (String) CollectionsKt.getOrNull(split$default, 5);
        String obj6 = str11 != null ? StringsKt.trim((CharSequence) str11).toString() : null;
        return new DialogBankHistoryRow(str3, intValue, str6, str8, str10, obj6 == null ? "" : obj6);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Set<DialogBankHistoryTab> resolveAllowedTabs(int i) {
        return (i == 1 || i == 2) ? SetsKt.setOf((Object[]) new DialogBankHistoryTab[]{DialogBankHistoryTab.DEPOSIT, DialogBankHistoryTab.WITHDRAW}) : SetsKt.setOf((Object[]) new DialogBankHistoryTab[]{DialogBankHistoryTab.DEPOSIT, DialogBankHistoryTab.TRANSFER, DialogBankHistoryTab.WITHDRAW});
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final long absSafe(long j) {
        if (j == Long.MIN_VALUE) {
            return Long.MAX_VALUE;
        }
        return Math.abs(j);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final DialogBankHistoryModel buildPayload(String str, String str2) {
        DialogBankHistoryModel dialogBankHistoryModel = (DialogBankHistoryModel) ((!MapperKt.isJsonValid(str2) || Intrinsics.areEqual(str2, AbstractJsonLexerKt.NULL) || Intrinsics.areEqual(str2, "{}") || str2.length() == 0) ? null : MapperKt.getGson().fromJson(str2, (Class<Object>) DialogBankHistoryModel.class));
        if (dialogBankHistoryModel != null) {
            String header = dialogBankHistoryModel.getHeader();
            if (StringsKt.isBlank(header)) {
                header = str;
            }
            DialogBankHistoryModel copy$default = DialogBankHistoryModel.copy$default(dialogBankHistoryModel, 0, header, 0, null, 13, null);
            if (copy$default != null) {
                return copy$default;
            }
        }
        return new DialogBankHistoryModel(0, str, 0, str2, 5, null);
    }
}
