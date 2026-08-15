package com.arizona.launcher.updater.archive.manifest;

import androidx.collection.SieveCacheKt;
import androidx.media3.extractor.text.ttml.TtmlNode;
import com.arizona.launcher.updater.archive.model.ArchiveEntryMetadata;
import com.arizona.launcher.updater.archive.model.ArchiveGpu;
import com.arizona.launcher.updater.archive.model.ArchiveManifest;
import com.arizona.launcher.updater.archive.model.ArchivePackage;
import com.arizona.launcher.updater.archive.model.ArchivePackageType;
import com.google.firebase.remoteconfig.RemoteConfigConstants;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.google.gson.JsonParser;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
/* compiled from: ArchiveManifestParser.kt */
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\u0001\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u0000 #2\u00020\u0001:\u0001#B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tJ\u0018\u0010\n\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\b\u001a\u00020\tH\u0002J\u001e\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0007H\u0002J\u001e\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00140\u000e2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0015\u001a\u00020\u0007H\u0002J\u0014\u0010\u0016\u001a\u00020\u0007*\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0007H\u0002J\u0014\u0010\u0019\u001a\u00020\u001a*\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0007H\u0002J\u0014\u0010\u001b\u001a\u00020\u0017*\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0007H\u0002J\u0014\u0010\u001c\u001a\u00020\u0011*\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0007H\u0002J\u0014\u0010\u001d\u001a\u00020\u0017*\u00020\f2\u0006\u0010\u001e\u001a\u00020\u0007H\u0002J\u0014\u0010\u001f\u001a\u00020\u0011*\u00020\f2\u0006\u0010\u001e\u001a\u00020\u0007H\u0002J\u0018\u0010 \u001a\u00020!2\u0006\u0010\u001e\u001a\u00020\u00072\u0006\u0010\"\u001a\u00020\u0007H\u0002Ê\u0001\f\b%\u0012\b\b&\u0012\u0004\b\u0003\u0010\u0002¨\u0006$"}, d2 = {"Lcom/arizona/launcher/updater/archive/manifest/ArchiveManifestParser;", "", "<init>", "()V", "parseOrNull", "Lcom/arizona/launcher/updater/archive/model/ArchiveManifest;", "json", "", "selectedGpu", "Lcom/arizona/launcher/updater/archive/model/ArchiveGpu;", "parseArchiveUpdater", "element", "Lcom/google/gson/JsonElement;", "parsePackageSet", "", "Lcom/arizona/launcher/updater/archive/model/ArchivePackage;", "array", "Lcom/google/gson/JsonArray;", "wireGpu", "parseEntries", "Lcom/arizona/launcher/updater/archive/model/ArchiveEntryMetadata;", "packagePath", "requiredString", "Lcom/google/gson/JsonObject;", "name", "requiredWholeLong", "", "requiredObject", "requiredArray", "requireObject", "path", "requireArray", "fail", "", "message", "Companion", "app", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class ArchiveManifestParser {
    public static final int $stable = 0;
    @Deprecated
    public static final String ARCHIVE_UPDATER_KEY = "archiveUpdater";
    private static final Companion Companion = new Companion(null);
    private static final Regex WHOLE_NUMBER = new Regex("0|[1-9][0-9]*");

    public final ArchiveManifest parseOrNull(String json, ArchiveGpu selectedGpu) {
        Intrinsics.checkNotNullParameter(json, "json");
        Intrinsics.checkNotNullParameter(selectedGpu, "selectedGpu");
        try {
            JsonElement parseString = JsonParser.parseString(json);
            Intrinsics.checkNotNull(parseString);
            JsonObject requireObject = requireObject(parseString, "root");
            if (requireObject.has(ARCHIVE_UPDATER_KEY)) {
                try {
                    JsonElement jsonElement = requireObject.get(ARCHIVE_UPDATER_KEY);
                    Intrinsics.checkNotNullExpressionValue(jsonElement, "get(...)");
                    return parseArchiveUpdater(jsonElement, selectedGpu);
                } catch (ArchiveManifestException e) {
                    throw e;
                } catch (IllegalArgumentException e2) {
                    String message = e2.getMessage();
                    if (message == null) {
                        message = "archiveUpdater manifest is invalid";
                    }
                    throw new ArchiveManifestException(message, e2);
                }
            }
            return null;
        } catch (JsonParseException e3) {
            throw new ArchiveManifestException("game manifest is not valid JSON", e3);
        }
    }

    private final ArchiveManifest parseArchiveUpdater(JsonElement jsonElement, ArchiveGpu archiveGpu) {
        JsonObject requireObject = requireObject(jsonElement, ARCHIVE_UPDATER_KEY);
        long requiredWholeLong = requiredWholeLong(requireObject, "schemaVersion");
        if (requiredWholeLong > SieveCacheKt.NodeLinkMask) {
            fail("archiveUpdater.schemaVersion", "value is too large");
            throw new KotlinNothingValueException();
        }
        int i = (int) requiredWholeLong;
        String requiredString = requiredString(requireObject, "manifestVersion");
        JsonObject requiredObject = requiredObject(requireObject, "packageSets");
        if (requiredObject.entrySet().isEmpty()) {
            fail("archiveUpdater.packageSets", "must not be empty");
            throw new KotlinNothingValueException();
        }
        Set<Map.Entry<String, JsonElement>> entrySet = requiredObject.entrySet();
        Intrinsics.checkNotNullExpressionValue(entrySet, "entrySet(...)");
        Iterator<T> it = entrySet.iterator();
        List<ArchivePackage> list = null;
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            Intrinsics.checkNotNull(entry);
            String str = (String) entry.getKey();
            JsonElement jsonElement2 = (JsonElement) entry.getValue();
            ArchiveGpu.Companion companion = ArchiveGpu.Companion;
            Intrinsics.checkNotNull(str);
            ArchiveGpu fromWireName = companion.fromWireName(str);
            if (fromWireName == null) {
                fail("archiveUpdater.packageSets." + str, "unknown GPU package set");
                throw new KotlinNothingValueException();
            }
            Intrinsics.checkNotNull(jsonElement2);
            List<ArchivePackage> parsePackageSet = parsePackageSet(requireArray(jsonElement2, "archiveUpdater.packageSets." + str), str);
            new ArchiveManifest(i, requiredString, fromWireName, parsePackageSet);
            if (fromWireName == archiveGpu) {
                list = parsePackageSet;
            }
        }
        if (list == null) {
            fail("archiveUpdater.packageSets." + archiveGpu.getWireName(), "selected GPU package set is missing");
            throw new KotlinNothingValueException();
        }
        return new ArchiveManifest(i, requiredString, archiveGpu, list);
    }

    private final List<ArchivePackage> parsePackageSet(JsonArray jsonArray, String str) {
        if (jsonArray.size() == 0) {
            fail("archiveUpdater.packageSets." + str, "must not be empty");
            throw new KotlinNothingValueException();
        }
        JsonArray jsonArray2 = jsonArray;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(jsonArray2, 10));
        int i = 0;
        for (JsonElement jsonElement : jsonArray2) {
            int i2 = i + 1;
            if (i < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            JsonElement jsonElement2 = jsonElement;
            String str2 = "archiveUpdater.packageSets." + str + "[" + i + "]";
            Intrinsics.checkNotNull(jsonElement2);
            JsonObject requireObject = requireObject(jsonElement2, str2);
            ArchivePackageType fromWireName = ArchivePackageType.Companion.fromWireName(requiredString(requireObject, "type"));
            if (fromWireName == null) {
                fail(str2 + ".type", "unsupported package type");
                throw new KotlinNothingValueException();
            }
            arrayList.add(new ArchivePackage(requiredString(requireObject, TtmlNode.ATTR_ID), fromWireName, requiredString(requireObject, "url"), requiredWholeLong(requireObject, "archiveSize"), requiredWholeLong(requireObject, "installedSize"), requiredWholeLong(requireObject, "crc32"), requireObject.has(RemoteConfigConstants.ResponseFieldKey.ENTRIES) ? parseEntries(requiredArray(requireObject, RemoteConfigConstants.ResponseFieldKey.ENTRIES), str2) : null));
            i = i2;
        }
        return arrayList;
    }

    private final List<ArchiveEntryMetadata> parseEntries(JsonArray jsonArray, String str) {
        if (jsonArray.size() == 0) {
            fail(str + ".entries", "must not be empty when present");
            throw new KotlinNothingValueException();
        }
        JsonArray jsonArray2 = jsonArray;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(jsonArray2, 10));
        int i = 0;
        for (JsonElement jsonElement : jsonArray2) {
            int i2 = i + 1;
            if (i < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            JsonElement jsonElement2 = jsonElement;
            Intrinsics.checkNotNull(jsonElement2);
            JsonObject requireObject = requireObject(jsonElement2, str + ".entries[" + i + "]");
            arrayList.add(new ArchiveEntryMetadata(requiredString(requireObject, "path"), requiredWholeLong(requireObject, "size"), requiredWholeLong(requireObject, "crc32")));
            i = i2;
        }
        return arrayList;
    }

    private final String requiredString(JsonObject jsonObject, String str) {
        JsonElement jsonElement = jsonObject.get(str);
        if (jsonElement == null) {
            fail(str, "required field is missing");
            throw new KotlinNothingValueException();
        } else if (!jsonElement.isJsonPrimitive() || !jsonElement.getAsJsonPrimitive().isString()) {
            fail(str, "must be a string");
            throw new KotlinNothingValueException();
        } else {
            String asString = jsonElement.getAsString();
            Intrinsics.checkNotNullExpressionValue(asString, "getAsString(...)");
            return asString;
        }
    }

    private final long requiredWholeLong(JsonObject jsonObject, String str) {
        JsonElement jsonElement = jsonObject.get(str);
        if (jsonElement == null) {
            fail(str, "required field is missing");
            throw new KotlinNothingValueException();
        } else if (!jsonElement.isJsonPrimitive() || !jsonElement.getAsJsonPrimitive().isNumber()) {
            fail(str, "must be a numeric integer");
            throw new KotlinNothingValueException();
        } else {
            String asString = jsonElement.getAsJsonPrimitive().getAsString();
            Regex regex = WHOLE_NUMBER;
            Intrinsics.checkNotNull(asString);
            if (!regex.matches(asString)) {
                fail(str, "must be a nonnegative base-10 integer");
                throw new KotlinNothingValueException();
            }
            Long longOrNull = StringsKt.toLongOrNull(asString);
            if (longOrNull != null) {
                return longOrNull.longValue();
            }
            fail(str, "numeric value is too large");
            throw new KotlinNothingValueException();
        }
    }

    private final JsonObject requiredObject(JsonObject jsonObject, String str) {
        JsonElement jsonElement = jsonObject.get(str);
        if (jsonElement != null) {
            return requireObject(jsonElement, str);
        }
        fail(str, "required field is missing");
        throw new KotlinNothingValueException();
    }

    private final JsonArray requiredArray(JsonObject jsonObject, String str) {
        JsonElement jsonElement = jsonObject.get(str);
        if (jsonElement != null) {
            return requireArray(jsonElement, str);
        }
        fail(str, "required field is missing");
        throw new KotlinNothingValueException();
    }

    private final JsonObject requireObject(JsonElement jsonElement, String str) {
        if (!jsonElement.isJsonObject()) {
            fail(str, "must be an object");
            throw new KotlinNothingValueException();
        }
        JsonObject asJsonObject = jsonElement.getAsJsonObject();
        Intrinsics.checkNotNullExpressionValue(asJsonObject, "getAsJsonObject(...)");
        return asJsonObject;
    }

    private final JsonArray requireArray(JsonElement jsonElement, String str) {
        if (!jsonElement.isJsonArray()) {
            fail(str, "must be an array");
            throw new KotlinNothingValueException();
        }
        JsonArray asJsonArray = jsonElement.getAsJsonArray();
        Intrinsics.checkNotNullExpressionValue(asJsonArray, "getAsJsonArray(...)");
        return asJsonArray;
    }

    private final Void fail(String str, String str2) {
        throw new ArchiveManifestException(str + ": " + str2, null, 2, null);
    }

    /* compiled from: ArchiveManifestParser.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/arizona/launcher/updater/archive/manifest/ArchiveManifestParser$Companion;", "", "<init>", "()V", "ARCHIVE_UPDATER_KEY", "", "WHOLE_NUMBER", "Lkotlin/text/Regex;", "getWHOLE_NUMBER", "()Lkotlin/text/Regex;", "app"}, k = 1, mv = {2, 4, 0}, xi = 48)
    /* loaded from: classes3.dex */
    private static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final Regex getWHOLE_NUMBER() {
            return ArchiveManifestParser.WHOLE_NUMBER;
        }
    }
}
