package com.arizona.launcher.updater.archive.manifest;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.google.gson.JsonParser;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: OriginalTzViceCityManifestSectionExtractor.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0001\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u0000 \u000b2\u00020\u0001:\u0001\u000bB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u0005J\u0018\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u0005H\u0002Ê\u0001\f\b\r\u0012\b\b\u000e\u0012\u0004\b\u0003\u0010\u0002¨\u0006\f"}, d2 = {"Lcom/arizona/launcher/updater/archive/manifest/OriginalTzViceCityManifestSectionExtractor;", "", "<init>", "()V", "extractOrNull", "", "fullManifestJson", "fail", "", "path", "message", "Companion", "app", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class OriginalTzViceCityManifestSectionExtractor {
    public static final int $stable = 0;
    private static final Companion Companion = new Companion(null);
    @Deprecated
    public static final String DATA_KEY = "data";
    @Deprecated
    public static final String VICE_CITY_DATA_KEY = "vicecity_data";

    public final String extractOrNull(String fullManifestJson) {
        Intrinsics.checkNotNullParameter(fullManifestJson, "fullManifestJson");
        try {
            JsonElement parseString = JsonParser.parseString(fullManifestJson);
            if (!parseString.isJsonObject()) {
                fail("root", "must be an object");
                throw new KotlinNothingValueException();
            }
            JsonObject asJsonObject = parseString.getAsJsonObject();
            JsonElement jsonElement = asJsonObject.get("data");
            if (jsonElement == null) {
                return null;
            }
            if (!jsonElement.isJsonObject()) {
                fail("root.data", "must be an object");
                throw new KotlinNothingValueException();
            }
            JsonElement jsonElement2 = jsonElement.getAsJsonObject().get(VICE_CITY_DATA_KEY);
            if (jsonElement2 == null) {
                return null;
            }
            if (!jsonElement2.isJsonArray()) {
                fail("root.data.vicecity_data", "must be an array");
                throw new KotlinNothingValueException();
            }
            JsonObject deepCopy = asJsonObject.deepCopy();
            JsonObject asJsonObject2 = deepCopy.getAsJsonObject("data");
            asJsonObject2.remove(VICE_CITY_DATA_KEY);
            asJsonObject2.add("data", jsonElement2.deepCopy());
            return deepCopy.toString();
        } catch (JsonParseException e) {
            throw new OriginalTzViceCityManifestSectionException("game manifest is not valid JSON", e);
        }
    }

    private final Void fail(String str, String str2) {
        throw new OriginalTzViceCityManifestSectionException(str + ": " + str2, null, 2, null);
    }

    /* compiled from: OriginalTzViceCityManifestSectionExtractor.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/arizona/launcher/updater/archive/manifest/OriginalTzViceCityManifestSectionExtractor$Companion;", "", "<init>", "()V", "DATA_KEY", "", "VICE_CITY_DATA_KEY", "app"}, k = 1, mv = {2, 4, 0}, xi = 48)
    /* loaded from: classes3.dex */
    private static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
