package ru.mrlargha.commonui.elements.dialogs;

import androidx.media3.extractor.text.ttml.TtmlNode;
import androidx.navigation.compose.DialogNavigator;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.crashlytics.internal.metadata.UserMetadata;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.miami.game.core.connection.resolver.FirebaseConfigHelper;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.sequences.SequencesKt;
import kotlin.text.Regex;
import kotlin.text.RegexOption;
import kotlin.text.StringsKt;
import ru.mrlargha.commonui.R;
import ru.mrlargha.commonui.elements.bank.BankTaxVisualType;
import ru.mrlargha.commonui.elements.bank.BankTaxVisualTypeKt;
import ru.mrlargha.commonui.utils.emoji.ChatEmoji;
import ru.mrlargha.commonui.utils.ui.money.MoneyFormatter;
/* compiled from: DialogBankTaxPayment.kt */
@Metadata(d1 = {"\u0000b\n\u0000\n\u0002\u0010\r\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\f\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0002\u001a*\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00062\b\b\u0002\u0010\t\u001a\u00020\u0006H\u0000\u001a\u001e\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u000b2\b\u0010\r\u001a\u0004\u0018\u00010\u000bH\u0002\u001a\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000fH\u0000\u001a\u0010\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u000fH\u0000\u001a$\u0010\u0012\u001a\u00020\u00062\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00150\u00142\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0017H\u0000\u001a\u000e\u0010\u0018\u001a\u0004\u0018\u00010\u0019*\u00020\u0006H\u0002\u001a\u000e\u0010\u001a\u001a\u0004\u0018\u00010\u000b*\u00020\u0019H\u0002\u001a\f\u0010\u001b\u001a\u00020\u001c*\u00020\u000bH\u0002\u001a\u0012\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014*\u00020\u000bH\u0002\u001a\u0012\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00190\u0014*\u00020\u0019H\u0002\u001a'\u0010\u001f\u001a\u0004\u0018\u00010\u0006*\u00020\u000b2\u0012\u0010 \u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00060!\"\u00020\u0006H\u0002¢\u0006\u0002\u0010\"\u001a'\u0010#\u001a\u0004\u0018\u00010\u000f*\u00020\u000b2\u0012\u0010 \u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00060!\"\u00020\u0006H\u0002¢\u0006\u0002\u0010$\u001a'\u0010%\u001a\u0004\u0018\u00010\u0002*\u00020\u000b2\u0012\u0010 \u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00060!\"\u00020\u0006H\u0002¢\u0006\u0002\u0010&\u001a\f\u0010'\u001a\u00020\u0006*\u00020\u0006H\u0002\"\u000e\u0010(\u001a\u00020)X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010*\u001a\u00020)X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010+\u001a\u00020,X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010-\u001a\u00020\u000fX\u0082T¢\u0006\u0002\n\u0000¨\u0006."}, d2 = {"toDialogBankTaxPaymentMoneyText", "", "", "parseDialogBankTaxPaymentModel", "Lru/mrlargha/commonui/elements/dialogs/DialogBankTaxPaymentModel;", "caption", "", "infoData", "leftButtonText", "hintInput", "mergeTaxPaymentPayloadObjects", "Lcom/google/gson/JsonObject;", "primary", "fallback", "resolveDialogBankTaxPaymentTitleRes", "", "type", "resolveTaxPaymentImageUrl", "buildDialogBankTaxPaymentSelectedIdsPayload", "taxList", "", "Lru/mrlargha/commonui/elements/dialogs/DialogBankTaxPaymentInfo;", "selectedIds", "", "parseJsonElement", "Lcom/google/gson/JsonElement;", "resolveTaxPaymentPayloadObject", "hasTaxPaymentFields", "", "taxListValue", "taxListElements", "stringValue", UserMetadata.KEYDATA_FILENAME, "", "(Lcom/google/gson/JsonObject;[Ljava/lang/String;)Ljava/lang/String;", "intValue", "(Lcom/google/gson/JsonObject;[Ljava/lang/String;)Ljava/lang/Integer;", "longValue", "(Lcom/google/gson/JsonObject;[Ljava/lang/String;)Ljava/lang/Long;", "normalizeTaxPaymentMoneyTokens", "LEGACY_TAX_MONEY_TOKEN_REGEX", "Lkotlin/text/Regex;", "TAX_INFO_TOKEN_REGEX", "TAX_PAYMENT_GSON", "Lcom/google/gson/Gson;", "TAX_TYPE_LEGAL_FINE", "CommonUI"}, k = 2, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class DialogBankTaxPaymentKt {
    private static final Regex LEGACY_TAX_MONEY_TOKEN_REGEX = new Regex(":(?:m|kk|k):", RegexOption.IGNORE_CASE);
    private static final Regex TAX_INFO_TOKEN_REGEX = new Regex(":info:", RegexOption.IGNORE_CASE);
    private static final Gson TAX_PAYMENT_GSON = new Gson();
    private static final int TAX_TYPE_LEGAL_FINE = 0;

    /* compiled from: DialogBankTaxPayment.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    /* loaded from: classes6.dex */
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[BankTaxVisualType.values().length];
            try {
                iArr[BankTaxVisualType.LEGAL_FINE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[BankTaxVisualType.COMMUNAL.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[BankTaxVisualType.PRIVATE_ORGANIZATION.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[BankTaxVisualType.SOCIAL_HOUSING.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[BankTaxVisualType.VEHICLE_RESTORATION.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[BankTaxVisualType.HOTEL_ROOM_LEASE.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr[BankTaxVisualType.HOME.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                iArr[BankTaxVisualType.BUSINESS.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                iArr[BankTaxVisualType.FAMILY_APARTMENT.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                iArr[BankTaxVisualType.UNKNOWN.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public static final /* synthetic */ CharSequence access$toDialogBankTaxPaymentMoneyText(long j) {
        return toDialogBankTaxPaymentMoneyText(j);
    }

    public static final CharSequence toDialogBankTaxPaymentMoneyText(long j) {
        return ChatEmoji.toSpannable$default(ChatEmoji.INSTANCE, MoneyFormatter.format$default(MoneyFormatter.INSTANCE, j, false, null, null, 14, null), 0.8f, null, 2, null);
    }

    public static /* synthetic */ DialogBankTaxPaymentModel parseDialogBankTaxPaymentModel$default(String str, String str2, String str3, String str4, int i, Object obj) {
        if ((i & 8) != 0) {
            str4 = "";
        }
        return parseDialogBankTaxPaymentModel(str, str2, str3, str4);
    }

    public static final DialogBankTaxPaymentModel parseDialogBankTaxPaymentModel(String caption, String infoData, String leftButtonText, String hintInput) {
        Intrinsics.checkNotNullParameter(caption, "caption");
        Intrinsics.checkNotNullParameter(infoData, "infoData");
        Intrinsics.checkNotNullParameter(leftButtonText, "leftButtonText");
        Intrinsics.checkNotNullParameter(hintInput, "hintInput");
        JsonElement parseJsonElement = parseJsonElement(infoData);
        JsonObject resolveTaxPaymentPayloadObject = parseJsonElement != null ? resolveTaxPaymentPayloadObject(parseJsonElement) : null;
        JsonElement parseJsonElement2 = parseJsonElement(hintInput);
        JsonObject mergeTaxPaymentPayloadObjects = mergeTaxPaymentPayloadObjects(resolveTaxPaymentPayloadObject, parseJsonElement2 != null ? resolveTaxPaymentPayloadObject(parseJsonElement2) : null);
        if (mergeTaxPaymentPayloadObjects == null) {
            return new DialogBankTaxPaymentModel(0, caption, 0, null, infoData, leftButtonText, null, 77, null);
        }
        Integer intValue = intValue(mergeTaxPaymentPayloadObjects, "type");
        int intValue2 = intValue != null ? intValue.intValue() : 9;
        String stringValue = stringValue(mergeTaxPaymentPayloadObjects, "header");
        if (stringValue == null) {
            stringValue = "";
        }
        String str = stringValue;
        if (StringsKt.isBlank(str)) {
            str = caption;
        }
        String str2 = str;
        Integer intValue3 = intValue(mergeTaxPaymentPayloadObjects, "addType");
        int intValue4 = intValue3 != null ? intValue3.intValue() : 0;
        String str3 = infoData;
        List<DialogBankTaxPaymentInfo> taxListValue = taxListValue(mergeTaxPaymentPayloadObjects);
        String stringValue2 = stringValue(mergeTaxPaymentPayloadObjects, TtmlNode.TAG_BODY);
        if (stringValue2 == null) {
            stringValue2 = "";
        }
        String str4 = stringValue2;
        if (StringsKt.isBlank(str4)) {
            if (resolveTaxPaymentPayloadObject != null) {
                str3 = null;
            }
            str4 = str3 == null ? "" : str3;
        }
        String str5 = str4;
        String stringValue3 = stringValue(mergeTaxPaymentPayloadObjects, "primaryButton");
        if (stringValue3 == null) {
            stringValue3 = "";
        }
        String str6 = stringValue3;
        if (StringsKt.isBlank(str6)) {
            str6 = leftButtonText;
        }
        String str7 = str6;
        String stringValue4 = stringValue(mergeTaxPaymentPayloadObjects, "additionalInfo");
        return new DialogBankTaxPaymentModel(intValue2, str2, intValue4, taxListValue, str5, str7, stringValue4 == null ? "" : stringValue4);
    }

    private static final JsonObject mergeTaxPaymentPayloadObjects(JsonObject jsonObject, JsonObject jsonObject2) {
        if (jsonObject == null) {
            return jsonObject2;
        }
        if (jsonObject2 == null) {
            return jsonObject;
        }
        JsonObject jsonObject3 = new JsonObject();
        Set<Map.Entry<String, JsonElement>> entrySet = jsonObject2.entrySet();
        Intrinsics.checkNotNullExpressionValue(entrySet, "entrySet(...)");
        Iterator<T> it = entrySet.iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            Intrinsics.checkNotNull(entry);
            jsonObject3.add((String) entry.getKey(), (JsonElement) entry.getValue());
        }
        Set<Map.Entry<String, JsonElement>> entrySet2 = jsonObject.entrySet();
        Intrinsics.checkNotNullExpressionValue(entrySet2, "entrySet(...)");
        Iterator<T> it2 = entrySet2.iterator();
        while (it2.hasNext()) {
            Map.Entry entry2 = (Map.Entry) it2.next();
            Intrinsics.checkNotNull(entry2);
            jsonObject3.add((String) entry2.getKey(), (JsonElement) entry2.getValue());
        }
        return jsonObject3;
    }

    public static final int resolveDialogBankTaxPaymentTitleRes(int i) {
        switch (WhenMappings.$EnumSwitchMapping$0[BankTaxVisualType.Companion.fromBackendType(i).ordinal()]) {
            case 1:
                return R.string.dialog_bank_tax_payment_legal_fine_title;
            case 2:
                return R.string.dialog_bank_tax_payment_communal_title;
            case 3:
                return R.string.dialog_bank_tax_payment_private_org_title;
            case 4:
                return R.string.dialog_bank_tax_payment_social_housing_title;
            case 5:
                return R.string.dialog_bank_tax_payment_vehicle_restoration_title;
            case 6:
                return R.string.dialog_bank_tax_payment_hotel_lease_title;
            case 7:
                return R.string.dialog_bank_tax_payment_home_title;
            case 8:
                return R.string.dialog_bank_tax_payment_business_title;
            case 9:
                return R.string.dialog_bank_tax_payment_family_apartment_title;
            case 10:
                return R.string.dialog_bank_tax_payment_title;
            default:
                throw new NoWhenBranchMatchedException();
        }
    }

    public static final String resolveTaxPaymentImageUrl(int i) {
        String resolveBankTaxAssetPath = BankTaxVisualTypeKt.resolveBankTaxAssetPath(i);
        if (StringsKt.isBlank(resolveBankTaxAssetPath)) {
            return "";
        }
        return FirebaseConfigHelper.getProjectResourceUrl$default(FirebaseConfigHelper.INSTANCE, false, 1, null) + resolveBankTaxAssetPath;
    }

    public static final String buildDialogBankTaxPaymentSelectedIdsPayload(List<DialogBankTaxPaymentInfo> taxList, Set<Integer> selectedIds) {
        Intrinsics.checkNotNullParameter(taxList, "taxList");
        Intrinsics.checkNotNullParameter(selectedIds, "selectedIds");
        ArrayList arrayList = new ArrayList();
        for (DialogBankTaxPaymentInfo dialogBankTaxPaymentInfo : taxList) {
            Integer valueOf = Integer.valueOf(dialogBankTaxPaymentInfo.getId());
            if (!selectedIds.contains(Integer.valueOf(valueOf.intValue()))) {
                valueOf = null;
            }
            if (valueOf != null) {
                arrayList.add(valueOf);
            }
        }
        String json = TAX_PAYMENT_GSON.toJson(arrayList);
        Intrinsics.checkNotNullExpressionValue(json, "toJson(...)");
        return json;
    }

    private static final JsonElement parseJsonElement(String str) {
        Object m9898constructorimpl;
        try {
            Result.Companion companion = Result.Companion;
            m9898constructorimpl = Result.m9898constructorimpl(JsonParser.parseString(str));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            m9898constructorimpl = Result.m9898constructorimpl(ResultKt.createFailure(th));
        }
        if (Result.m9904isFailureimpl(m9898constructorimpl)) {
            m9898constructorimpl = null;
        }
        return (JsonElement) m9898constructorimpl;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static final JsonObject resolveTaxPaymentPayloadObject(JsonElement jsonElement) {
        final JsonObject asJsonObject;
        JsonObject jsonObject = null;
        if (!jsonElement.isJsonObject()) {
            jsonElement = null;
        }
        if (jsonElement != null && (asJsonObject = jsonElement.getAsJsonObject()) != null) {
            if (!hasTaxPaymentFields(asJsonObject)) {
                Iterator it = SequencesKt.mapNotNull(SequencesKt.sequenceOf((Object[]) new String[]{"data", "payload", DialogNavigator.NAME}), new Function1() { // from class: ru.mrlargha.commonui.elements.dialogs.DialogBankTaxPaymentKt$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return DialogBankTaxPaymentKt.resolveTaxPaymentPayloadObject$lambda$1(JsonObject.this, (String) obj);
                    }
                }).iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    Object next = it.next();
                    if (hasTaxPaymentFields((JsonObject) next)) {
                        jsonObject = next;
                        break;
                    }
                }
                jsonObject = jsonObject;
                if (jsonObject == null) {
                }
            }
            return asJsonObject;
        }
        return jsonObject;
    }

    public static final JsonObject resolveTaxPaymentPayloadObject$lambda$1(JsonObject jsonObject, String key) {
        Intrinsics.checkNotNullParameter(key, "key");
        JsonElement jsonElement = jsonObject.get(key);
        if (jsonElement != null) {
            if (!jsonElement.isJsonObject()) {
                jsonElement = null;
            }
            if (jsonElement != null) {
                return jsonElement.getAsJsonObject();
            }
        }
        return null;
    }

    private static final boolean hasTaxPaymentFields(JsonObject jsonObject) {
        return jsonObject.has("taxList") || jsonObject.has("addType") || jsonObject.has("primaryButton") || jsonObject.has("additionalInfo");
    }

    private static final List<DialogBankTaxPaymentInfo> taxListValue(JsonObject jsonObject) {
        JsonObject asJsonObject;
        Integer intValue;
        JsonElement jsonElement = (JsonElement) SequencesKt.firstOrNull(SequencesKt.mapNotNull(SequencesKt.sequenceOf((Object[]) new String[]{"taxList", "taxes", "items"}), new DialogBankTaxPaymentKt$taxListValue$source$1(jsonObject)));
        if (jsonElement == null) {
            return CollectionsKt.emptyList();
        }
        ArrayList arrayList = new ArrayList();
        for (JsonElement jsonElement2 : taxListElements(jsonElement)) {
            DialogBankTaxPaymentInfo dialogBankTaxPaymentInfo = null;
            if (!jsonElement2.isJsonObject()) {
                jsonElement2 = null;
            }
            if (jsonElement2 != null && (asJsonObject = jsonElement2.getAsJsonObject()) != null && (intValue = intValue(asJsonObject, "id")) != null) {
                int intValue2 = intValue.intValue();
                String stringValue = stringValue(asJsonObject, "name", "title");
                if (stringValue == null) {
                    stringValue = "";
                }
                Long longValue = longValue(asJsonObject, FirebaseAnalytics.Param.TAX, "amount", "value");
                dialogBankTaxPaymentInfo = new DialogBankTaxPaymentInfo(intValue2, stringValue, longValue != null ? RangesKt.coerceAtLeast(longValue.longValue(), 0L) : 0L);
            }
            if (dialogBankTaxPaymentInfo != null) {
                arrayList.add(dialogBankTaxPaymentInfo);
            }
        }
        return arrayList;
    }

    private static final List<JsonElement> taxListElements(JsonElement jsonElement) {
        if (jsonElement.isJsonPrimitive() && jsonElement.getAsJsonPrimitive().isString()) {
            String asString = jsonElement.getAsString();
            Intrinsics.checkNotNullExpressionValue(asString, "getAsString(...)");
            JsonElement parseJsonElement = parseJsonElement(asString);
            if (parseJsonElement != null) {
                jsonElement = parseJsonElement;
            }
        }
        if (jsonElement.isJsonArray()) {
            JsonArray asJsonArray = jsonElement.getAsJsonArray();
            Intrinsics.checkNotNullExpressionValue(asJsonArray, "getAsJsonArray(...)");
            return CollectionsKt.toList(asJsonArray);
        } else if (jsonElement.isJsonObject()) {
            JsonObject asJsonObject = jsonElement.getAsJsonObject();
            if (asJsonObject.has("id")) {
                return CollectionsKt.listOf(asJsonObject);
            }
            Set<Map.Entry<String, JsonElement>> entrySet = asJsonObject.entrySet();
            Intrinsics.checkNotNullExpressionValue(entrySet, "entrySet(...)");
            Set<Map.Entry<String, JsonElement>> set = entrySet;
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(set, 10));
            Iterator<T> it = set.iterator();
            while (it.hasNext()) {
                arrayList.add((JsonElement) ((Map.Entry) it.next()).getValue());
            }
            return arrayList;
        } else {
            return CollectionsKt.emptyList();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static final String stringValue(JsonObject jsonObject, String... strArr) {
        String str;
        String str2;
        int length = strArr.length;
        int i = 0;
        while (true) {
            if (i < length) {
                JsonElement jsonElement = jsonObject.get(strArr[i]);
                if (jsonElement != null) {
                    if (jsonElement.isJsonNull()) {
                        jsonElement = null;
                    }
                    if (jsonElement != null) {
                        try {
                            Result.Companion companion = Result.Companion;
                            str2 = Result.m9898constructorimpl(jsonElement.getAsString());
                        } catch (Throwable th) {
                            Result.Companion companion2 = Result.Companion;
                            str2 = Result.m9898constructorimpl(ResultKt.createFailure(th));
                        }
                        str = Result.m9904isFailureimpl(str2) ? null : str2;
                    }
                }
                if (str != null) {
                    break;
                }
                i++;
            } else {
                break;
            }
        }
        return str;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static final Integer intValue(JsonObject jsonObject, String... strArr) {
        Integer num;
        Integer num2;
        int length = strArr.length;
        int i = 0;
        while (true) {
            if (i < length) {
                JsonElement jsonElement = jsonObject.get(strArr[i]);
                if (jsonElement != null) {
                    if (jsonElement.isJsonNull()) {
                        jsonElement = null;
                    }
                    if (jsonElement != null) {
                        try {
                            Result.Companion companion = Result.Companion;
                            num2 = Result.m9898constructorimpl(Integer.valueOf(jsonElement.getAsInt()));
                        } catch (Throwable th) {
                            Result.Companion companion2 = Result.Companion;
                            num2 = Result.m9898constructorimpl(ResultKt.createFailure(th));
                        }
                        num = Result.m9904isFailureimpl(num2) ? null : num2;
                    }
                }
                if (num != null) {
                    break;
                }
                i++;
            } else {
                break;
            }
        }
        return num;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static final Long longValue(JsonObject jsonObject, String... strArr) {
        Long l;
        Long l2;
        int length = strArr.length;
        int i = 0;
        while (true) {
            if (i < length) {
                JsonElement jsonElement = jsonObject.get(strArr[i]);
                if (jsonElement != null) {
                    if (jsonElement.isJsonNull()) {
                        jsonElement = null;
                    }
                    if (jsonElement != null) {
                        try {
                            Result.Companion companion = Result.Companion;
                            l2 = Result.m9898constructorimpl(Long.valueOf(jsonElement.getAsLong()));
                        } catch (Throwable th) {
                            Result.Companion companion2 = Result.Companion;
                            l2 = Result.m9898constructorimpl(ResultKt.createFailure(th));
                        }
                        l = Result.m9904isFailureimpl(l2) ? null : l2;
                    }
                }
                if (l != null) {
                    break;
                }
                i++;
            } else {
                break;
            }
        }
        return l;
    }

    public static final String normalizeTaxPaymentMoneyTokens(String str) {
        return StringsKt.trim((CharSequence) TAX_INFO_TOKEN_REGEX.replace(LEGACY_TAX_MONEY_TOKEN_REGEX.replace(str, ":cash:"), "")).toString();
    }
}
