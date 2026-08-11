package com.arizonagames.feature.arizona.bank;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonNull;
import com.google.gson.JsonObject;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import ru.mrlargha.commonui.utils.MapperKt;
/* compiled from: BankPayloadMerger.kt */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\"\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u001c\n\u0002\b\u0002\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0006J\u0018\u0010\f\u001a\u0004\u0018\u00010\r2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000b\u001a\u00020\u0006J\u000e\u0010\u000f\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0006J\u0018\u0010\u0010\u001a\u0004\u0018\u00010\r2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000b\u001a\u00020\u0006J\u000e\u0010\u0011\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0006J \u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\u0006H\u0002J(\u0010\u0018\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0019\u001a\u00020\u00062\u0006\u0010\u001a\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\u0006H\u0002J\"\u0010\u001b\u001a\u00020\u001c2\b\u0010\u0014\u001a\u0004\u0018\u00010\u001c2\u0006\u0010\u0016\u001a\u00020\u001c2\u0006\u0010\u0017\u001a\u00020\u0006H\u0002J \u0010\u001d\u001a\u00020\n2\u0006\u0010\u0017\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020\u001c2\u0006\u0010\u0016\u001a\u00020\u001cH\u0002J\u0018\u0010\u001d\u001a\u00020\n2\u0006\u0010\u0017\u001a\u00020\u00062\u0006\u0010\u0016\u001a\u00020\u001cH\u0002J\f\u0010\u001e\u001a\u00020\u0015*\u00020\u0015H\u0002J\f\u0010\u001f\u001a\u00020\n*\u00020\u0015H\u0002J\f\u0010 \u001a\u00020\n*\u00020\u0015H\u0002J\f\u0010!\u001a\u00020\n*\u00020\u0015H\u0002J\f\u0010\"\u001a\u00020\n*\u00020\u0015H\u0002J\f\u0010#\u001a\u00020\n*\u00020\u0015H\u0002J\f\u0010$\u001a\u00020\n*\u00020\u0015H\u0002J\u000e\u0010%\u001a\u0004\u0018\u00010\u0015*\u00020&H\u0002J\u000e\u0010%\u001a\u0004\u0018\u00010\u0015*\u00020\u0006H\u0002J\u000e\u0010'\u001a\u0004\u0018\u00010\u0006*\u00020\u0015H\u0002J\u0012\u0010(\u001a\u00020\u001c*\b\u0012\u0004\u0012\u00020&0)H\u0002J\u0014\u0010*\u001a\u00020\u0006*\u00020\u00062\u0006\u0010\u0019\u001a\u00020\u0006H\u0002R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006+"}, d2 = {"Lcom/arizonagames/feature/arizona/bank/BankPayloadMerger;", "", "<init>", "()V", "identityRootKeys", "", "", "rootStateRequiredKeys", "mergeByIdArrayPaths", "isLikelyPartialRootState", "", "rawUpdate", "mergeRootState", "Lcom/arizonagames/feature/arizona/bank/BankScreenPayload;", "currentPayload", "isIdentityOnlyRootState", "merge", "containsDepositSnapshotUpdate", "mergeObject", "", TypedValues.AttributesType.S_TARGET, "Lcom/google/gson/JsonObject;", "update", "path", "mergeObjectValue", "key", "updateValue", "mergeArray", "Lcom/google/gson/JsonArray;", "shouldMergeArrayById", "normalizeBankPayloadUpdate", "isRawLotteryPayload", "isPartialBankAccount", "isPartialTax", "isPartialVehicle", "isPartialCurrency", "isPartialChest", "asJsonObjectOrNull", "Lcom/google/gson/JsonElement;", "idValue", "toJsonArray", "", "appendPath", "bank"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class BankPayloadMerger {
    public static final BankPayloadMerger INSTANCE = new BankPayloadMerger();
    private static final Set<String> identityRootKeys = SetsKt.setOf((Object[]) new String[]{"name", "years", "birth"});
    private static final Set<String> rootStateRequiredKeys = SetsKt.setOf("bankAccounts");
    private static final Set<String> mergeByIdArrayPaths = SetsKt.setOf((Object[]) new String[]{"bankAccounts", "taxes.list", "vehicles", "currencies", "chests"});

    private BankPayloadMerger() {
    }

    public final boolean isLikelyPartialRootState(String rawUpdate) {
        Intrinsics.checkNotNullParameter(rawUpdate, "rawUpdate");
        JsonObject asJsonObjectOrNull = asJsonObjectOrNull(rawUpdate);
        if (asJsonObjectOrNull == null || asJsonObjectOrNull.entrySet().isEmpty() || isIdentityOnlyRootState(rawUpdate)) {
            return false;
        }
        Set<String> set = rootStateRequiredKeys;
        if (!(set instanceof Collection) || !set.isEmpty()) {
            for (String str : set) {
                if (!asJsonObjectOrNull.has(str)) {
                    return true;
                }
            }
        }
        Set<Map.Entry<String, JsonElement>> entrySet = asJsonObjectOrNull.entrySet();
        Intrinsics.checkNotNullExpressionValue(entrySet, "entrySet(...)");
        Set<Map.Entry<String, JsonElement>> set2 = entrySet;
        if ((set2 instanceof Collection) && set2.isEmpty()) {
            return false;
        }
        Iterator<T> it = set2.iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            Intrinsics.checkNotNull(entry);
            String str2 = (String) entry.getKey();
            JsonElement jsonElement = (JsonElement) entry.getValue();
            if (jsonElement.isJsonArray() && mergeByIdArrayPaths.contains(str2)) {
                BankPayloadMerger bankPayloadMerger = INSTANCE;
                Intrinsics.checkNotNull(str2);
                JsonArray asJsonArray = jsonElement.getAsJsonArray();
                Intrinsics.checkNotNullExpressionValue(asJsonArray, "getAsJsonArray(...)");
                if (bankPayloadMerger.shouldMergeArrayById(str2, asJsonArray)) {
                    return true;
                }
            }
        }
        return false;
    }

    public final BankScreenPayload mergeRootState(BankScreenPayload bankScreenPayload, String rawUpdate) {
        BankScreenPayload currentPayload = bankScreenPayload;
        Intrinsics.checkNotNullParameter(currentPayload, "currentPayload");
        Intrinsics.checkNotNullParameter(rawUpdate, "rawUpdate");
        if (isIdentityOnlyRootState(rawUpdate)) {
            currentPayload = new BankScreenPayload(null, null, null, null, null, null, null, null, null, 0L, null, null, null, null, null, null, null, null, null, null, null, null, 4194303, null);
        }
        return merge(currentPayload, rawUpdate);
    }

    public final boolean isIdentityOnlyRootState(String rawUpdate) {
        Intrinsics.checkNotNullParameter(rawUpdate, "rawUpdate");
        JsonObject asJsonObjectOrNull = asJsonObjectOrNull(rawUpdate);
        if (asJsonObjectOrNull == null) {
            return false;
        }
        Set<Map.Entry<String, JsonElement>> entrySet = asJsonObjectOrNull.entrySet();
        Intrinsics.checkNotNullExpressionValue(entrySet, "entrySet(...)");
        Set<Map.Entry<String, JsonElement>> set = entrySet;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(set, 10));
        Iterator<T> it = set.iterator();
        while (it.hasNext()) {
            arrayList.add((String) ((Map.Entry) it.next()).getKey());
        }
        Set set2 = CollectionsKt.toSet(arrayList);
        if (set2.isEmpty()) {
            return false;
        }
        Set<String> set3 = set2;
        if ((set3 instanceof Collection) && set3.isEmpty()) {
            return true;
        }
        for (String str : set3) {
            if (!identityRootKeys.contains(str)) {
                return false;
            }
        }
        return true;
    }

    public final BankScreenPayload merge(BankScreenPayload currentPayload, String rawUpdate) {
        JsonObject normalizeBankPayloadUpdate;
        Intrinsics.checkNotNullParameter(currentPayload, "currentPayload");
        Intrinsics.checkNotNullParameter(rawUpdate, "rawUpdate");
        JsonObject asJsonObjectOrNull = asJsonObjectOrNull(rawUpdate);
        if (asJsonObjectOrNull == null || (normalizeBankPayloadUpdate = normalizeBankPayloadUpdate(asJsonObjectOrNull)) == null) {
            return null;
        }
        JsonObject deepCopy = MapperKt.getGson().toJsonTree(currentPayload).getAsJsonObject().deepCopy();
        Intrinsics.checkNotNull(deepCopy);
        mergeObject(deepCopy, normalizeBankPayloadUpdate, "");
        return (BankScreenPayload) MapperKt.getGson().fromJson((JsonElement) deepCopy, (Class<Object>) BankScreenPayload.class);
    }

    public final boolean containsDepositSnapshotUpdate(String rawUpdate) {
        Intrinsics.checkNotNullParameter(rawUpdate, "rawUpdate");
        JsonObject asJsonObjectOrNull = asJsonObjectOrNull(rawUpdate);
        if (asJsonObjectOrNull == null) {
            return false;
        }
        return asJsonObjectOrNull.has("bankDeposit") || asJsonObjectOrNull.has("income");
    }

    private final void mergeObject(JsonObject jsonObject, JsonObject jsonObject2, String str) {
        for (Map.Entry<String, JsonElement> entry : jsonObject2.entrySet()) {
            Intrinsics.checkNotNull(entry);
            String key = entry.getKey();
            JsonElement value = entry.getValue();
            Intrinsics.checkNotNull(key);
            String appendPath = appendPath(str, key);
            if (value.isJsonNull()) {
                jsonObject.add(key, JsonNull.INSTANCE);
            } else if (value.isJsonObject()) {
                JsonObject asJsonObject = value.getAsJsonObject();
                Intrinsics.checkNotNullExpressionValue(asJsonObject, "getAsJsonObject(...)");
                mergeObjectValue(jsonObject, key, asJsonObject, appendPath);
            } else if (value.isJsonArray()) {
                JsonElement jsonElement = jsonObject.get(key);
                JsonArray jsonArray = null;
                if (jsonElement != null) {
                    if (!jsonElement.isJsonArray()) {
                        jsonElement = null;
                    }
                    if (jsonElement != null) {
                        jsonArray = jsonElement.getAsJsonArray();
                    }
                }
                JsonArray asJsonArray = value.getAsJsonArray();
                Intrinsics.checkNotNullExpressionValue(asJsonArray, "getAsJsonArray(...)");
                jsonObject.add(key, mergeArray(jsonArray, asJsonArray, appendPath));
            } else {
                jsonObject.add(key, value.deepCopy());
            }
        }
    }

    private final void mergeObjectValue(JsonObject jsonObject, String str, JsonObject jsonObject2, String str2) {
        if (jsonObject2.entrySet().isEmpty()) {
            jsonObject.add(str, jsonObject2.deepCopy());
            return;
        }
        JsonElement jsonElement = jsonObject.get(str);
        if (jsonElement != null && jsonElement.isJsonObject()) {
            JsonObject asJsonObject = jsonElement.getAsJsonObject();
            Intrinsics.checkNotNullExpressionValue(asJsonObject, "getAsJsonObject(...)");
            mergeObject(asJsonObject, jsonObject2, str2);
            return;
        }
        jsonObject.add(str, jsonObject2.deepCopy());
    }

    private final JsonArray mergeArray(JsonArray jsonArray, JsonArray jsonArray2, String str) {
        if (jsonArray2.size() == 0) {
            JsonArray deepCopy = jsonArray2.deepCopy();
            Intrinsics.checkNotNullExpressionValue(deepCopy, "deepCopy(...)");
            return deepCopy;
        } else if (jsonArray == null || !mergeByIdArrayPaths.contains(str) || !shouldMergeArrayById(str, jsonArray, jsonArray2)) {
            JsonArray deepCopy2 = jsonArray2.deepCopy();
            Intrinsics.checkNotNullExpressionValue(deepCopy2, "deepCopy(...)");
            return deepCopy2;
        } else {
            JsonArray<JsonElement> jsonArray3 = jsonArray;
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(jsonArray3, 10));
            for (JsonElement jsonElement : jsonArray3) {
                arrayList.add(jsonElement.deepCopy());
            }
            List mutableList = CollectionsKt.toMutableList((Collection) arrayList);
            Iterator<JsonElement> it = jsonArray2.iterator();
            Intrinsics.checkNotNullExpressionValue(it, "iterator(...)");
            while (it.hasNext()) {
                JsonElement next = it.next();
                Intrinsics.checkNotNull(next);
                JsonObject asJsonObjectOrNull = asJsonObjectOrNull(next);
                String idValue = asJsonObjectOrNull != null ? idValue(asJsonObjectOrNull) : null;
                if (asJsonObjectOrNull == null || idValue == null) {
                    JsonArray deepCopy3 = jsonArray2.deepCopy();
                    Intrinsics.checkNotNullExpressionValue(deepCopy3, "deepCopy(...)");
                    return deepCopy3;
                }
                Iterator it2 = mutableList.iterator();
                int i = 0;
                while (true) {
                    if (!it2.hasNext()) {
                        i = -1;
                        break;
                    }
                    JsonElement jsonElement2 = (JsonElement) it2.next();
                    BankPayloadMerger bankPayloadMerger = INSTANCE;
                    Intrinsics.checkNotNull(jsonElement2);
                    JsonObject asJsonObjectOrNull2 = bankPayloadMerger.asJsonObjectOrNull(jsonElement2);
                    if (Intrinsics.areEqual(asJsonObjectOrNull2 != null ? bankPayloadMerger.idValue(asJsonObjectOrNull2) : null, idValue)) {
                        break;
                    }
                    i++;
                }
                if (i >= 0) {
                    Object obj = mutableList.get(i);
                    Intrinsics.checkNotNullExpressionValue(obj, "get(...)");
                    JsonObject asJsonObjectOrNull3 = asJsonObjectOrNull((JsonElement) obj);
                    if (asJsonObjectOrNull3 == null) {
                        mutableList.set(i, asJsonObjectOrNull.deepCopy());
                    } else {
                        mergeObject(asJsonObjectOrNull3, asJsonObjectOrNull, str);
                    }
                } else {
                    mutableList.add(asJsonObjectOrNull.deepCopy());
                }
            }
            return toJsonArray(mutableList);
        }
    }

    private final boolean shouldMergeArrayById(String str, JsonArray jsonArray, JsonArray jsonArray2) {
        String str2;
        String str3;
        if (shouldMergeArrayById(str, jsonArray2)) {
            return true;
        }
        if (!Intrinsics.areEqual(str, "bankAccounts") || jsonArray.size() <= 0) {
            return false;
        }
        JsonArray jsonArray3 = jsonArray;
        if (!(jsonArray3 instanceof Collection) || !((Collection) jsonArray3).isEmpty()) {
            for (JsonElement jsonElement : jsonArray3) {
                BankPayloadMerger bankPayloadMerger = INSTANCE;
                Intrinsics.checkNotNull(jsonElement);
                JsonObject asJsonObjectOrNull = bankPayloadMerger.asJsonObjectOrNull(jsonElement);
                if (asJsonObjectOrNull != null) {
                    str2 = bankPayloadMerger.idValue(asJsonObjectOrNull);
                    continue;
                } else {
                    str2 = null;
                    continue;
                }
                if (str2 == null) {
                    return false;
                }
            }
        }
        JsonArray jsonArray4 = jsonArray2;
        if (!(jsonArray4 instanceof Collection) || !((Collection) jsonArray4).isEmpty()) {
            for (JsonElement jsonElement2 : jsonArray4) {
                BankPayloadMerger bankPayloadMerger2 = INSTANCE;
                Intrinsics.checkNotNull(jsonElement2);
                JsonObject asJsonObjectOrNull2 = bankPayloadMerger2.asJsonObjectOrNull(jsonElement2);
                if (asJsonObjectOrNull2 != null) {
                    str3 = bankPayloadMerger2.idValue(asJsonObjectOrNull2);
                    continue;
                } else {
                    str3 = null;
                    continue;
                }
                if (str3 == null) {
                    return false;
                }
            }
        }
        return true;
    }

    private final boolean shouldMergeArrayById(String str, JsonArray jsonArray) {
        switch (str.hashCode()) {
            case -1361512046:
                if (str.equals("chests")) {
                    JsonArray jsonArray2 = jsonArray;
                    if (!(jsonArray2 instanceof Collection) || !((Collection) jsonArray2).isEmpty()) {
                        for (JsonElement jsonElement : jsonArray2) {
                            BankPayloadMerger bankPayloadMerger = INSTANCE;
                            Intrinsics.checkNotNull(jsonElement);
                            JsonObject asJsonObjectOrNull = bankPayloadMerger.asJsonObjectOrNull(jsonElement);
                            if (asJsonObjectOrNull != null && bankPayloadMerger.isPartialChest(asJsonObjectOrNull)) {
                                return true;
                            }
                        }
                        break;
                    } else {
                        return false;
                    }
                }
                break;
            case -1089470353:
                if (str.equals("currencies")) {
                    JsonArray jsonArray3 = jsonArray;
                    if ((jsonArray3 instanceof Collection) && ((Collection) jsonArray3).isEmpty()) {
                        return false;
                    }
                    for (JsonElement jsonElement2 : jsonArray3) {
                        BankPayloadMerger bankPayloadMerger2 = INSTANCE;
                        Intrinsics.checkNotNull(jsonElement2);
                        JsonObject asJsonObjectOrNull2 = bankPayloadMerger2.asJsonObjectOrNull(jsonElement2);
                        if (asJsonObjectOrNull2 != null && bankPayloadMerger2.isPartialCurrency(asJsonObjectOrNull2)) {
                            return true;
                        }
                    }
                    return false;
                }
                break;
            case -783668670:
                if (str.equals("bankAccounts")) {
                    JsonArray jsonArray4 = jsonArray;
                    if ((jsonArray4 instanceof Collection) && ((Collection) jsonArray4).isEmpty()) {
                        return false;
                    }
                    for (JsonElement jsonElement3 : jsonArray4) {
                        BankPayloadMerger bankPayloadMerger3 = INSTANCE;
                        Intrinsics.checkNotNull(jsonElement3);
                        JsonObject asJsonObjectOrNull3 = bankPayloadMerger3.asJsonObjectOrNull(jsonElement3);
                        if (asJsonObjectOrNull3 != null && bankPayloadMerger3.isPartialBankAccount(asJsonObjectOrNull3)) {
                            return true;
                        }
                    }
                    return false;
                }
                break;
            case 915403731:
                if (str.equals("taxes.list")) {
                    JsonArray jsonArray5 = jsonArray;
                    if ((jsonArray5 instanceof Collection) && ((Collection) jsonArray5).isEmpty()) {
                        return false;
                    }
                    for (JsonElement jsonElement4 : jsonArray5) {
                        BankPayloadMerger bankPayloadMerger4 = INSTANCE;
                        Intrinsics.checkNotNull(jsonElement4);
                        JsonObject asJsonObjectOrNull4 = bankPayloadMerger4.asJsonObjectOrNull(jsonElement4);
                        if (asJsonObjectOrNull4 != null && bankPayloadMerger4.isPartialTax(asJsonObjectOrNull4)) {
                            return true;
                        }
                    }
                    return false;
                }
                break;
            case 2014205639:
                if (str.equals("vehicles")) {
                    JsonArray jsonArray6 = jsonArray;
                    if ((jsonArray6 instanceof Collection) && ((Collection) jsonArray6).isEmpty()) {
                        return false;
                    }
                    for (JsonElement jsonElement5 : jsonArray6) {
                        BankPayloadMerger bankPayloadMerger5 = INSTANCE;
                        Intrinsics.checkNotNull(jsonElement5);
                        JsonObject asJsonObjectOrNull5 = bankPayloadMerger5.asJsonObjectOrNull(jsonElement5);
                        if (asJsonObjectOrNull5 != null && bankPayloadMerger5.isPartialVehicle(asJsonObjectOrNull5)) {
                            return true;
                        }
                    }
                    return false;
                }
                break;
        }
        return false;
    }

    private final JsonObject normalizeBankPayloadUpdate(JsonObject jsonObject) {
        if (isRawLotteryPayload(jsonObject)) {
            JsonObject jsonObject2 = new JsonObject();
            jsonObject2.add("lottery", jsonObject.deepCopy());
            return jsonObject2;
        }
        return jsonObject;
    }

    private final boolean isRawLotteryPayload(JsonObject jsonObject) {
        if (jsonObject.has("lottery")) {
            return false;
        }
        Set of = SetsKt.setOf((Object[]) new String[]{"name", "years", "birth", "bankAccounts", "organization", "retirement", "taxes", "bankDeposit", "income", "money", "own", "currencies", "currencyHistory", "vipCard", "mobile", "vehicles", "businesses", "electric", "selectedBusiness", "selectedElectric", "chests"});
        Set<Map.Entry<String, JsonElement>> entrySet = jsonObject.entrySet();
        Intrinsics.checkNotNullExpressionValue(entrySet, "entrySet(...)");
        Set<Map.Entry<String, JsonElement>> set = entrySet;
        if (!(set instanceof Collection) || !set.isEmpty()) {
            Iterator<T> it = set.iterator();
            while (it.hasNext()) {
                if (of.contains(((Map.Entry) it.next()).getKey())) {
                    return false;
                }
            }
        }
        return jsonObject.has("visible") || jsonObject.has("activeState") || jsonObject.has("endTime") || jsonObject.has("ticketsBalance") || jsonObject.has("ticketsLeftTime") || jsonObject.has("ticketsAvailableCount") || jsonObject.has("streamUrl") || jsonObject.has("tasks") || jsonObject.has("rewards") || jsonObject.has("prizes") || jsonObject.has("rewardList");
    }

    private final boolean isPartialBankAccount(JsonObject jsonObject) {
        if (jsonObject.has("id")) {
            if (!jsonObject.has("buyCost") || jsonObject.has("money") || jsonObject.has("percents")) {
                if (jsonObject.has("money") && jsonObject.has("percents")) {
                    JsonElement jsonElement = jsonObject.get("percents");
                    Intrinsics.checkNotNullExpressionValue(jsonElement, "get(...)");
                    JsonObject asJsonObjectOrNull = asJsonObjectOrNull(jsonElement);
                    if (asJsonObjectOrNull != null && asJsonObjectOrNull.has("withdraw") && asJsonObjectOrNull.has("deposit") && asJsonObjectOrNull.has("transfer")) {
                        return false;
                    }
                }
                return true;
            }
            return false;
        }
        return true;
    }

    private final boolean isPartialTax(JsonObject jsonObject) {
        if (jsonObject.has("id") && jsonObject.has(FirebaseAnalytics.Param.TAX) && jsonObject.has("warning") && jsonObject.has("title")) {
            return (jsonObject.has("disabled") || jsonObject.has("diasabled")) ? false : true;
        }
        return true;
    }

    private final boolean isPartialVehicle(JsonObject jsonObject) {
        return (jsonObject.has("id") && jsonObject.has("name") && jsonObject.has("cost") && jsonObject.has("reason")) ? false : true;
    }

    private final boolean isPartialCurrency(JsonObject jsonObject) {
        return (jsonObject.has("id") && jsonObject.has("current") && jsonObject.has("percent") && jsonObject.has("availableMoney")) ? false : true;
    }

    private final boolean isPartialChest(JsonObject jsonObject) {
        return (jsonObject.has("id") && jsonObject.has("disabledTime") && jsonObject.has("error")) ? false : true;
    }

    private final JsonObject asJsonObjectOrNull(JsonElement jsonElement) {
        if (jsonElement.isJsonObject()) {
            return jsonElement.getAsJsonObject();
        }
        return null;
    }

    private final JsonObject asJsonObjectOrNull(String str) {
        JsonElement jsonElement;
        if (MapperKt.isJsonValid(str) && (jsonElement = (JsonElement) MapperKt.getGson().fromJson(str, (Class<Object>) JsonElement.class)) != null) {
            return asJsonObjectOrNull(jsonElement);
        }
        return null;
    }

    private final String idValue(JsonObject jsonObject) {
        JsonElement jsonElement = jsonObject.get("id");
        if (jsonElement == null || jsonElement.isJsonNull()) {
            return null;
        }
        return jsonElement.toString();
    }

    private final JsonArray toJsonArray(Iterable<? extends JsonElement> iterable) {
        JsonArray jsonArray = new JsonArray();
        for (JsonElement jsonElement : iterable) {
            jsonArray.add(jsonElement);
        }
        return jsonArray;
    }

    private final String appendPath(String str, String str2) {
        return StringsKt.isBlank(str) ? str2 : str + "." + str2;
    }
}
