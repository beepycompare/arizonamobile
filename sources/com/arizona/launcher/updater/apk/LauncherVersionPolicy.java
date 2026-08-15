package com.arizona.launcher.updater.apk;

import com.arizona.launcher.updater.apk.LauncherVersionDecision;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.JsonPrimitive;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
/* compiled from: LauncherUpdatePolicies.kt */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\bÁ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\u0007J\u0013\u0010\f\u001a\u0004\u0018\u00010\t*\u00020\rH\u0002¢\u0006\u0002\u0010\u000eJ\f\u0010\u000f\u001a\u00020\u0007*\u00020\rH\u0002R\u000e\u0010\u0010\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000Ê\u0001\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\u0003\u0010\u0002¨\u0006\u0011"}, d2 = {"Lcom/arizona/launcher/updater/apk/LauncherVersionPolicy;", "", "<init>", "()V", "decide", "Lcom/arizona/launcher/updater/apk/LauncherVersionDecision;", "metadataBody", "", "installedVersionCode", "", "installedVersionName", "buildType", "toLegacyJsonIntOrNull", "Lcom/google/gson/JsonElement;", "(Lcom/google/gson/JsonElement;)Ljava/lang/Integer;", "toLegacyJsonString", "STAGING_BUILD_TYPE", "app", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class LauncherVersionPolicy {
    public static final int $stable = 0;
    public static final LauncherVersionPolicy INSTANCE = new LauncherVersionPolicy();
    private static final String STAGING_BUILD_TYPE = "staging";

    private LauncherVersionPolicy() {
    }

    public final LauncherVersionDecision decide(String metadataBody, int i, String installedVersionName, String buildType) {
        JsonObject asJsonObject;
        Integer legacyJsonIntOrNull;
        String str;
        JsonElement jsonElement;
        Intrinsics.checkNotNullParameter(metadataBody, "metadataBody");
        Intrinsics.checkNotNullParameter(installedVersionName, "installedVersionName");
        Intrinsics.checkNotNullParameter(buildType, "buildType");
        try {
            JsonElement parseString = JsonParser.parseString(metadataBody);
            String str2 = null;
            if (!parseString.isJsonObject()) {
                parseString = null;
            }
            if (parseString == null || (asJsonObject = parseString.getAsJsonObject()) == null) {
                return LauncherVersionDecision.InvalidMetadata.INSTANCE;
            }
            JsonElement jsonElement2 = asJsonObject.get("launcherVersion");
            if (jsonElement2 != null && (legacyJsonIntOrNull = toLegacyJsonIntOrNull(jsonElement2)) != null) {
                int intValue = legacyJsonIntOrNull.intValue();
                boolean z = true;
                if (intValue > i) {
                    return new LauncherVersionDecision.Valid(true, intValue, null);
                }
                if (Intrinsics.areEqual(buildType, STAGING_BUILD_TYPE) && (jsonElement = asJsonObject.get("launcherVersionName")) != null) {
                    str2 = toLegacyJsonString(jsonElement);
                }
                return new LauncherVersionDecision.Valid((!Intrinsics.areEqual(buildType, STAGING_BUILD_TYPE) || (str = str2) == null || str.length() == 0 || Intrinsics.areEqual(str2, installedVersionName)) ? false : false, intValue, str2);
            }
            return LauncherVersionDecision.InvalidMetadata.INSTANCE;
        } catch (RuntimeException unused) {
            return LauncherVersionDecision.InvalidMetadata.INSTANCE;
        }
    }

    private final Integer toLegacyJsonIntOrNull(JsonElement jsonElement) {
        if (jsonElement.isJsonPrimitive()) {
            JsonPrimitive asJsonPrimitive = jsonElement.getAsJsonPrimitive();
            if (asJsonPrimitive.isString()) {
                String asString = asJsonPrimitive.getAsString();
                Intrinsics.checkNotNullExpressionValue(asString, "getAsString(...)");
                Double doubleOrNull = StringsKt.toDoubleOrNull(asString);
                if (doubleOrNull != null) {
                    return Integer.valueOf((int) doubleOrNull.doubleValue());
                }
                return null;
            }
            if (asJsonPrimitive.isNumber()) {
                String asString2 = asJsonPrimitive.getAsString();
                Intrinsics.checkNotNull(asString2);
                if (StringsKt.indexOfAny$default((CharSequence) asString2, new char[]{'.', 'e', 'E'}, 0, false, 6, (Object) null) >= 0) {
                    Double doubleOrNull2 = StringsKt.toDoubleOrNull(asString2);
                    if (doubleOrNull2 != null) {
                        return Integer.valueOf((int) doubleOrNull2.doubleValue());
                    }
                    return null;
                }
                Long longOrNull = StringsKt.toLongOrNull(asString2);
                if (longOrNull != null) {
                    return Integer.valueOf((int) longOrNull.longValue());
                }
                Double doubleOrNull3 = StringsKt.toDoubleOrNull(asString2);
                if (doubleOrNull3 != null) {
                    return Integer.valueOf((int) doubleOrNull3.doubleValue());
                }
            }
            return null;
        }
        return null;
    }

    private final String toLegacyJsonString(JsonElement jsonElement) {
        String jsonElement2;
        String str;
        if (jsonElement.isJsonPrimitive() && jsonElement.getAsJsonPrimitive().isString()) {
            jsonElement2 = jsonElement.getAsString();
            str = "getAsString(...)";
        } else {
            jsonElement2 = jsonElement.toString();
            str = "toString(...)";
        }
        Intrinsics.checkNotNullExpressionValue(jsonElement2, str);
        return jsonElement2;
    }
}
