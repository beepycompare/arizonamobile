package com.arizonagames.feature.arizona.bank;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import java.lang.reflect.Type;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: BankContract.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J&\u0010\u0005\u001a\u00020\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016¨\u0006\f"}, d2 = {"Lcom/arizonagames/feature/arizona/bank/BankSubtitleFieldJsonAdapter;", "Lcom/google/gson/JsonDeserializer;", "Lcom/arizonagames/feature/arizona/bank/BankSubtitleField;", "<init>", "()V", "deserialize", "json", "Lcom/google/gson/JsonElement;", "typeOfT", "Ljava/lang/reflect/Type;", "context", "Lcom/google/gson/JsonDeserializationContext;", "bank"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class BankSubtitleFieldJsonAdapter implements JsonDeserializer<BankSubtitleField> {
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.google.gson.JsonDeserializer
    public BankSubtitleField deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) {
        JsonObject asJsonObject;
        JsonElement jsonElement2;
        String str = null;
        if (jsonElement != null) {
            if (jsonElement.isJsonNull()) {
                jsonElement = null;
            }
            if (jsonElement != null) {
                if (jsonElement.isJsonPrimitive()) {
                    String asString = jsonElement.getAsString();
                    Intrinsics.checkNotNullExpressionValue(asString, "getAsString(...)");
                    return new BankSubtitleField(asString);
                }
                if (!jsonElement.isJsonObject()) {
                    jsonElement = null;
                }
                if (jsonElement != null && (asJsonObject = jsonElement.getAsJsonObject()) != null && (jsonElement2 = asJsonObject.get("subtitle")) != null) {
                    if (jsonElement2.isJsonNull()) {
                        jsonElement2 = null;
                    }
                    if (jsonElement2 != null) {
                        str = jsonElement2.getAsString();
                    }
                }
                if (str == null) {
                    str = "";
                }
                return new BankSubtitleField(str);
            }
        }
        return new BankSubtitleField(null, 1, null);
    }
}
