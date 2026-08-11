package com.arizonagames.feature.arizona.bank.data;

import com.arizonagames.feature.arizona.bank.BankCurrencyHistoryInfo;
import com.arizonagames.feature.arizona.bank.BankCurrencyHistoryPayload;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import ru.mrlargha.commonui.utils.MapperKt;
/* compiled from: BankApiRepository.kt */
@Metadata(d1 = {"\u0000*\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\u001a\u0012\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0000\u001a\u0010\u0010\u0007\u001a\u0004\u0018\u00010\b*\u0004\u0018\u00010\u0006H\u0002\u001a\u000e\u0010\u0007\u001a\u0004\u0018\u00010\b*\u00020\tH\u0002\u001a\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b*\u0004\u0018\u00010\bH\u0002\"\u0016\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"currencyHistoryListType", "Ljava/lang/reflect/Type;", "kotlin.jvm.PlatformType", "parseCurrencyHistoryPayload", "Lcom/arizonagames/feature/arizona/bank/BankCurrencyHistoryPayload;", "element", "Lcom/google/gson/JsonElement;", "currencyHistoryArray", "Lcom/google/gson/JsonArray;", "Lcom/google/gson/JsonObject;", "toCurrencyHistoryList", "", "Lcom/arizonagames/feature/arizona/bank/BankCurrencyHistoryInfo;", "bank"}, k = 2, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class BankApiRepositoryKt {
    private static final Type currencyHistoryListType = new TypeToken<List<? extends BankCurrencyHistoryInfo>>() { // from class: com.arizonagames.feature.arizona.bank.data.BankApiRepositoryKt$currencyHistoryListType$1
    }.getType();

    public static final BankCurrencyHistoryPayload parseCurrencyHistoryPayload(JsonElement jsonElement) {
        return new BankCurrencyHistoryPayload(toCurrencyHistoryList(currencyHistoryArray(jsonElement)));
    }

    private static final JsonArray currencyHistoryArray(JsonElement jsonElement) {
        if (jsonElement != null) {
            if (jsonElement.isJsonNull()) {
                jsonElement = null;
            }
            if (jsonElement != null) {
                if (jsonElement.isJsonArray()) {
                    return jsonElement.getAsJsonArray();
                }
                if (jsonElement.isJsonObject()) {
                    JsonObject asJsonObject = jsonElement.getAsJsonObject();
                    Intrinsics.checkNotNullExpressionValue(asJsonObject, "getAsJsonObject(...)");
                    return currencyHistoryArray(asJsonObject);
                }
            }
        }
        return null;
    }

    private static final JsonArray currencyHistoryArray(JsonObject jsonObject) {
        for (String str : CollectionsKt.listOf((Object[]) new String[]{"currencies", "currencyHistory", "history"})) {
            JsonElement jsonElement = jsonObject.get(str);
            if (jsonElement != null && jsonElement.isJsonArray()) {
                return jsonElement.getAsJsonArray();
            }
        }
        JsonElement jsonElement2 = jsonObject.get("data");
        if (jsonElement2 == null || !jsonElement2.isJsonArray()) {
            if (jsonElement2 == null || !jsonElement2.isJsonObject()) {
                return null;
            }
            JsonObject asJsonObject = jsonElement2.getAsJsonObject();
            Intrinsics.checkNotNullExpressionValue(asJsonObject, "getAsJsonObject(...)");
            return currencyHistoryArray(asJsonObject);
        }
        return jsonElement2.getAsJsonArray();
    }

    private static final List<BankCurrencyHistoryInfo> toCurrencyHistoryList(JsonArray jsonArray) {
        if (jsonArray == null) {
            return CollectionsKt.emptyList();
        }
        Object fromJson = MapperKt.getGson().fromJson(jsonArray, currencyHistoryListType);
        Intrinsics.checkNotNullExpressionValue(fromJson, "fromJson(...)");
        return (List) fromJson;
    }
}
