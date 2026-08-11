package com.arizonagames.feature.arizona.bank;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonPrimitive;
import java.lang.reflect.Type;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
/* compiled from: BankContract.kt */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J+\u0010\u0005\u001a\u00020\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016¢\u0006\u0002\u0010\f¨\u0006\r"}, d2 = {"Lcom/arizonagames/feature/arizona/bank/BankBooleanJsonAdapter;", "Lcom/google/gson/JsonDeserializer;", "", "<init>", "()V", "deserialize", "json", "Lcom/google/gson/JsonElement;", "typeOfT", "Ljava/lang/reflect/Type;", "context", "Lcom/google/gson/JsonDeserializationContext;", "(Lcom/google/gson/JsonElement;Ljava/lang/reflect/Type;Lcom/google/gson/JsonDeserializationContext;)Ljava/lang/Boolean;", "bank"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class BankBooleanJsonAdapter implements JsonDeserializer<Boolean> {
    /* JADX WARN: Can't rename method to resolve collision */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0033, code lost:
        if (r1.getAsInt() != 0) goto L23;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x005e, code lost:
        if (kotlin.text.StringsKt.equals(r1, "true", true) == false) goto L16;
     */
    @Override // com.google.gson.JsonDeserializer
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Boolean deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) {
        JsonPrimitive asJsonPrimitive;
        boolean z = false;
        if (jsonElement != null) {
            if (jsonElement.isJsonNull()) {
                jsonElement = null;
            }
            if (jsonElement != null) {
                JsonElement jsonElement2 = jsonElement.isJsonPrimitive() ? jsonElement : null;
                if (jsonElement2 != null && (asJsonPrimitive = jsonElement2.getAsJsonPrimitive()) != null) {
                    if (asJsonPrimitive.isBoolean()) {
                        z = asJsonPrimitive.getAsBoolean();
                    } else if (!asJsonPrimitive.isNumber()) {
                        if (asJsonPrimitive.isString()) {
                            String asString = asJsonPrimitive.getAsString();
                            Intrinsics.checkNotNullExpressionValue(asString, "getAsString(...)");
                            String obj = StringsKt.trim((CharSequence) asString).toString();
                            if (!Intrinsics.areEqual(obj, "1")) {
                            }
                            z = true;
                        }
                    }
                    return Boolean.valueOf(z);
                }
            }
        }
        return false;
    }
}
