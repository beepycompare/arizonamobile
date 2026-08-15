package com.arizona.launcher.updater.archive.manifest;

import coil3.util.UtilsKt;
import com.arizona.launcher.updater.archive.manifest.OriginalTzArchiveManifestParser;
import com.arizona.launcher.updater.archive.model.ArchiveGpu;
import com.arizona.launcher.updater.archive.model.ArchiveModelRules;
import com.google.android.vending.expansion.downloader.Constants;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.google.gson.JsonParser;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.net.URI;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
/* compiled from: OriginalTzArchiveManifestParser.kt */
@Metadata(d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010%\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0001\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u0000 12\u00020\u0001:\u000201B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tJ\u0018\u0010\n\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\b\u001a\u00020\tH\u0002J4\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020\u00072\u0012\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070\u0013H\u0002J\u0018\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u000f\u001a\u00020\f2\u0006\u0010\u0011\u001a\u00020\u0007H\u0002J,\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020\u00072\u0012\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070\u0013H\u0002J\u0018\u0010\u0019\u001a\u00020\u00072\u0006\u0010\u001a\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020\u0007H\u0002J\u0010\u0010\u001b\u001a\u00020\u00072\u0006\u0010\u0018\u001a\u00020\u0007H\u0002J\u0010\u0010\u001c\u001a\u00020\u00072\u0006\u0010\u0018\u001a\u00020\u0007H\u0002J\u001e\u0010\u001d\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020 0\u001fH\u0002J\u0014\u0010!\u001a\u00020\u0017*\u00020\"2\u0006\u0010\u001a\u001a\u00020\u0007H\u0002J\u001c\u0010#\u001a\u00020\u0007*\u00020\f2\u0006\u0010$\u001a\u00020\u00072\u0006\u0010%\u001a\u00020\u0007H\u0002J\u001c\u0010&\u001a\u00020\u0015*\u00020\f2\u0006\u0010$\u001a\u00020\u00072\u0006\u0010%\u001a\u00020\u0007H\u0002J\u001c\u0010'\u001a\u00020\f*\u00020\f2\u0006\u0010$\u001a\u00020\u00072\u0006\u0010%\u001a\u00020\u0007H\u0002J\u001c\u0010(\u001a\u00020)*\u00020\f2\u0006\u0010$\u001a\u00020\u00072\u0006\u0010%\u001a\u00020\u0007H\u0002J\u0014\u0010*\u001a\u00020\f*\u00020+2\u0006\u0010%\u001a\u00020\u0007H\u0002J\u0014\u0010,\u001a\u00020)*\u00020+2\u0006\u0010%\u001a\u00020\u0007H\u0002J\u0018\u0010-\u001a\u00020.2\u0006\u0010%\u001a\u00020\u00072\u0006\u0010/\u001a\u00020\u0007H\u0002Ê\u0001\f\b3\u0012\b\b4\u0012\u0004\b\u0003\u0010\u0002¨\u00062"}, d2 = {"Lcom/arizona/launcher/updater/archive/manifest/OriginalTzArchiveManifestParser;", "", "<init>", "()V", "parse", "Lcom/arizona/launcher/updater/archive/manifest/OriginalTzArchiveManifestDescriptor;", "json", "", "selectedGpu", "Lcom/arizona/launcher/updater/archive/model/ArchiveGpu;", "parseRoot", "root", "Lcom/google/gson/JsonObject;", "parseNode", "Lcom/arizona/launcher/updater/archive/manifest/OriginalTzArchiveManifestParser$ParsedNode;", "node", "parentPath", "jsonPath", "seenPaths", "", "parseChecksum", "", "registerSourcePath", "", "sourcePath", "safeSegment", "value", "mirrorRelativeUrl", "deterministicPackageId", "deterministicManifestVersion", "packages", "", "Lcom/arizona/launcher/updater/archive/manifest/OriginalTzArchivePackageDescriptor;", "writeLengthPrefixed", "Ljava/io/DataOutputStream;", "requiredString", "name", "path", "requiredWholeLong", "requiredObject", "requiredArray", "Lcom/google/gson/JsonArray;", "requireObject", "Lcom/google/gson/JsonElement;", "requireArray", "fail", "", "message", "ParsedNode", "Companion", "app", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class OriginalTzArchiveManifestParser {
    public static final int $stable = 0;
    @Deprecated
    public static final String FILES_ROOT = "files";
    @Deprecated
    public static final int ID_DIGEST_LENGTH = 16;
    @Deprecated
    public static final String MANIFEST_VERSION_DOMAIN = "arizona-original-tz-archive-manifest-v1";
    @Deprecated
    public static final String MANIFEST_VERSION_PREFIX = "original-tz-v1-";
    @Deprecated
    public static final int MAX_PACKAGE_ID_LENGTH = 96;
    @Deprecated
    public static final String PACKAGE_ID_PREFIX = "tz-";
    @Deprecated
    public static final String ZIP_SUFFIX = ".zip";
    private static final Companion Companion = new Companion(null);
    private static final Regex WHOLE_NUMBER = new Regex("0|[1-9][0-9]*");
    private static final Regex MD5_HEX = new Regex("[0-9a-fA-F]{32}");
    private static final Regex NON_ID_CHARACTERS = new Regex("[^a-z0-9._-]+");
    private static final Comparator<OriginalTzArchivePackageDescriptor> PACKAGE_ORDER = ComparisonsKt.compareBy(new Function1() { // from class: com.arizona.launcher.updater.archive.manifest.OriginalTzArchiveManifestParser$$ExternalSyntheticLambda0
        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Object obj) {
            return OriginalTzArchiveManifestParser.PACKAGE_ORDER$lambda$0((OriginalTzArchivePackageDescriptor) obj);
        }
    }, new Function1() { // from class: com.arizona.launcher.updater.archive.manifest.OriginalTzArchiveManifestParser$$ExternalSyntheticLambda1
        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Object obj) {
            return OriginalTzArchiveManifestParser.PACKAGE_ORDER$lambda$1((OriginalTzArchivePackageDescriptor) obj);
        }
    });

    public final OriginalTzArchiveManifestDescriptor parse(String json, ArchiveGpu selectedGpu) {
        Intrinsics.checkNotNullParameter(json, "json");
        Intrinsics.checkNotNullParameter(selectedGpu, "selectedGpu");
        try {
            JsonElement parseString = JsonParser.parseString(json);
            Intrinsics.checkNotNull(parseString);
            try {
                return parseRoot(requireObject(parseString, "root"), selectedGpu);
            } catch (OriginalTzArchiveManifestException e) {
                throw e;
            } catch (ArithmeticException e2) {
                throw new OriginalTzArchiveManifestException("original-TZ archive manifest size total overflows Long", e2);
            } catch (IllegalArgumentException e3) {
                String message = e3.getMessage();
                if (message == null) {
                    message = "original-TZ archive manifest is invalid";
                }
                throw new OriginalTzArchiveManifestException(message, e3);
            }
        } catch (JsonParseException e4) {
            throw new OriginalTzArchiveManifestException("game manifest is not valid JSON", e4);
        }
    }

    private final OriginalTzArchiveManifestDescriptor parseRoot(JsonObject jsonObject, ArchiveGpu archiveGpu) {
        if (jsonObject.has(ArchiveManifestParser.ARCHIVE_UPDATER_KEY)) {
            fail("root.archiveUpdater", "v2 sibling is not an original-TZ archive-only manifest");
            throw new KotlinNothingValueException();
        }
        JsonObject requiredObject = requiredObject(jsonObject, "data", "root.data");
        JsonArray requiredArray = requiredArray(requiredObject, "data", "root.data.data");
        if (requiredArray.size() != 1) {
            fail("root.data.data", "must contain exactly one files root");
            throw new KotlinNothingValueException();
        }
        if (requiredObject.has("obb")) {
            JsonElement jsonElement = requiredObject.get("obb");
            Intrinsics.checkNotNullExpressionValue(jsonElement, "get(...)");
            if (requireArray(jsonElement, "root.data.obb").size() != 0) {
                fail("root.data.obb", "must be empty");
                throw new KotlinNothingValueException();
            }
        }
        JsonElement jsonElement2 = requiredArray.get(0);
        Intrinsics.checkNotNullExpressionValue(jsonElement2, "get(...)");
        JsonObject requireObject = requireObject(jsonElement2, "root.data.data[0]");
        if (!Intrinsics.areEqual(requiredString(requireObject, "type", "root.data.data[0].type"), "dir")) {
            fail("root.data.data[0].type", "must be dir");
            throw new KotlinNothingValueException();
        } else if (!Intrinsics.areEqual(requiredString(requireObject, "name", "root.data.data[0].name"), FILES_ROOT)) {
            fail("root.data.data[0].name", "must be files");
            throw new KotlinNothingValueException();
        } else {
            List<OriginalTzArchivePackageDescriptor> sortedWith = CollectionsKt.sortedWith(parseNode(requireObject, "", "root.data.data[0]", new LinkedHashMap()).getPackages(), PACKAGE_ORDER);
            if (sortedWith.isEmpty()) {
                fail("root.data.data[0].data", "must contain at least one ZIP package");
                throw new KotlinNothingValueException();
            }
            HashSet hashSet = new HashSet();
            for (OriginalTzArchivePackageDescriptor originalTzArchivePackageDescriptor : sortedWith) {
                if (!hashSet.add(originalTzArchivePackageDescriptor.getId())) {
                    fail("root.data.data[0]", "deterministic package id collision: " + originalTzArchivePackageDescriptor.getId());
                    throw new KotlinNothingValueException();
                }
            }
            String deterministicManifestVersion = deterministicManifestVersion(archiveGpu, sortedWith);
            ArchiveModelRules.INSTANCE.requireManifestVersion(deterministicManifestVersion);
            return new OriginalTzArchiveManifestDescriptor(archiveGpu, deterministicManifestVersion, sortedWith);
        }
    }

    private final ParsedNode parseNode(JsonObject jsonObject, String str, String str2, Map<String, String> map) {
        String safeSegment = safeSegment(requiredString(jsonObject, "name", str2 + ".name"), str2 + ".name");
        String str3 = str.length() == 0 ? safeSegment : str + "/" + safeSegment;
        registerSourcePath(str3, str2, map);
        String requiredString = requiredString(jsonObject, "type", str2 + ".type");
        long requiredWholeLong = requiredWholeLong(jsonObject, "size", str2 + ".size");
        int i = 0;
        if (Intrinsics.areEqual(requiredString, "dir")) {
            if (jsonObject.has("crc32") || jsonObject.has("hash")) {
                fail(str2, "directory must not contain a checksum");
                throw new KotlinNothingValueException();
            }
            JsonArray requiredArray = requiredArray(jsonObject, "data", str2 + ".data");
            if (requiredArray.size() == 0) {
                fail(str2 + ".data", "directory must not be empty");
                throw new KotlinNothingValueException();
            }
            ArrayList arrayList = new ArrayList();
            int size = requiredArray.size();
            long j = 0;
            while (i < size) {
                JsonElement jsonElement = requiredArray.get(i);
                Intrinsics.checkNotNullExpressionValue(jsonElement, "get(...)");
                JsonArray jsonArray = requiredArray;
                ParsedNode parseNode = parseNode(requireObject(jsonElement, str2 + ".data[" + i + "]"), str3, str2 + ".data[" + i + "]", map);
                j = Math.addExact(j, parseNode.getDeclaredSize());
                CollectionsKt.addAll(arrayList, parseNode.getPackages());
                i++;
                requiredArray = jsonArray;
            }
            if (requiredWholeLong != j) {
                fail(str2 + ".size", "must equal child leaf sum " + j + ", got " + requiredWholeLong);
                throw new KotlinNothingValueException();
            }
            return new ParsedNode(requiredWholeLong, arrayList);
        } else if (Intrinsics.areEqual(requiredString, UtilsKt.SCHEME_FILE)) {
            if (jsonObject.has("data")) {
                fail(str2 + ".data", "file must not contain child data");
                throw new KotlinNothingValueException();
            }
            Locale ROOT = Locale.ROOT;
            Intrinsics.checkNotNullExpressionValue(ROOT, "ROOT");
            String lowerCase = safeSegment.toLowerCase(ROOT);
            Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
            if (!StringsKt.endsWith$default(lowerCase, ZIP_SUFFIX, false, 2, (Object) null)) {
                fail(str2 + ".name", "archive-only leaf must end with .zip");
                throw new KotlinNothingValueException();
            } else if (requiredWholeLong <= 0 || requiredWholeLong >= ArchiveModelRules.MAX_ARCHIVE_SIZE_EXCLUSIVE) {
                fail(str2 + ".size", "must be in 1..499999999");
                throw new KotlinNothingValueException();
            } else {
                if (jsonObject.has("date_change")) {
                    requiredWholeLong(jsonObject, "date_change", str2 + ".date_change");
                }
                long parseChecksum = parseChecksum(jsonObject, str2);
                String deterministicPackageId = deterministicPackageId(str3);
                String mirrorRelativeUrl = mirrorRelativeUrl(str3);
                ArchiveModelRules.INSTANCE.requirePackageId(deterministicPackageId);
                ArchiveModelRules.INSTANCE.requirePackageUrl(mirrorRelativeUrl);
                return new ParsedNode(requiredWholeLong, CollectionsKt.listOf(new OriginalTzArchivePackageDescriptor(deterministicPackageId, str3, mirrorRelativeUrl, requiredWholeLong, parseChecksum)));
            }
        } else {
            fail(str2 + ".type", "must be dir or file");
            throw new KotlinNothingValueException();
        }
    }

    private final long parseChecksum(JsonObject jsonObject, String str) {
        Long l;
        boolean has = jsonObject.has("crc32");
        boolean has2 = jsonObject.has("hash");
        if (!has && !has2) {
            fail(str, "ZIP leaf must contain numeric crc32 or numeric hash");
            throw new KotlinNothingValueException();
        }
        Long l2 = null;
        if (has) {
            l = Long.valueOf(requiredWholeLong(jsonObject, "crc32", str + ".crc32"));
            ArchiveModelRules.INSTANCE.requireUnsignedCrc32(l.longValue());
        } else {
            l = null;
        }
        if (has2) {
            JsonElement jsonElement = jsonObject.get("hash");
            if (!jsonElement.isJsonPrimitive() || !jsonElement.getAsJsonPrimitive().isString()) {
                l2 = Long.valueOf(requiredWholeLong(jsonObject, "hash", str + ".hash"));
                ArchiveModelRules.INSTANCE.requireUnsignedCrc32(l2.longValue());
            } else {
                String asString = jsonElement.getAsString();
                Regex regex = MD5_HEX;
                Intrinsics.checkNotNull(asString);
                if (!regex.matches(asString)) {
                    fail(str + ".hash", "must be a 32-character hexadecimal MD5");
                    throw new KotlinNothingValueException();
                } else if (l == null) {
                    fail(str + ".crc32", "numeric crc32 is required when hash is MD5");
                    throw new KotlinNothingValueException();
                }
            }
        }
        if (l != null && l2 != null && !Intrinsics.areEqual(l, l2)) {
            fail(str, "crc32 and numeric hash must match when both are present");
            throw new KotlinNothingValueException();
        } else if (l != null) {
            return l.longValue();
        } else {
            if (l2 != null) {
                return l2.longValue();
            }
            throw new IllegalStateException("checksum presence checked above".toString());
        }
    }

    private final void registerSourcePath(String str, String str2, Map<String, String> map) {
        Locale ROOT = Locale.ROOT;
        Intrinsics.checkNotNullExpressionValue(ROOT, "ROOT");
        String lowerCase = str.toLowerCase(ROOT);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
        String putIfAbsent = map.putIfAbsent(lowerCase, str);
        if (putIfAbsent == null) {
            return;
        }
        fail(str2, "duplicate or case-colliding source path '" + str + "' and '" + putIfAbsent + "'");
        throw new KotlinNothingValueException();
    }

    private final String safeSegment(String str, String str2) {
        String str3 = str;
        if (!StringsKt.isBlank(str3) && Intrinsics.areEqual(str, StringsKt.trim((CharSequence) str3).toString()) && !Intrinsics.areEqual(str, ".") && !Intrinsics.areEqual(str, "..")) {
            if (!StringsKt.contains$default((CharSequence) str3, '/', false, 2, (Object) null) && !StringsKt.contains$default((CharSequence) str3, (char) AbstractJsonLexerKt.STRING_ESC, false, 2, (Object) null)) {
                for (int i = 0; i < str3.length(); i++) {
                    if (!Character.isISOControl(str3.charAt(i))) {
                    }
                }
                return str;
            }
        }
        fail(str2, "contains an unsafe path segment");
        throw new KotlinNothingValueException();
    }

    private final String mirrorRelativeUrl(String str) {
        try {
            String rawPath = new URI(null, null, "data/" + str, null).getRawPath();
            Intrinsics.checkNotNull(rawPath);
            return rawPath;
        } catch (Exception e) {
            throw new OriginalTzArchiveManifestException("unable to encode package URL for '" + str + "'", e);
        }
    }

    private final String deterministicPackageId(String str) {
        String dropLast = StringsKt.dropLast(str, 4);
        Locale ROOT = Locale.ROOT;
        Intrinsics.checkNotNullExpressionValue(ROOT, "ROOT");
        String lowerCase = dropLast.toLowerCase(ROOT);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
        String trim = StringsKt.trim(NON_ID_CHARACTERS.replace(lowerCase, Constants.FILENAME_SEQUENCE_SEPARATOR), '-', '.', '_');
        if (trim.length() == 0) {
            trim = "archive";
        }
        Companion companion = Companion;
        Charset UTF_8 = StandardCharsets.UTF_8;
        Intrinsics.checkNotNullExpressionValue(UTF_8, "UTF_8");
        byte[] bytes = str.getBytes(UTF_8);
        Intrinsics.checkNotNullExpressionValue(bytes, "getBytes(...)");
        String take = StringsKt.take(companion.sha256Hex(bytes), 16);
        String trimEnd = StringsKt.trimEnd(StringsKt.take(trim, 92 - take.length()), '-', '.', '_');
        return PACKAGE_ID_PREFIX + (trimEnd.length() != 0 ? trimEnd : "archive") + Constants.FILENAME_SEQUENCE_SEPARATOR + take;
    }

    private final String deterministicManifestVersion(ArchiveGpu archiveGpu, List<OriginalTzArchivePackageDescriptor> list) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);
        try {
            DataOutputStream dataOutputStream2 = dataOutputStream;
            writeLengthPrefixed(dataOutputStream2, MANIFEST_VERSION_DOMAIN);
            writeLengthPrefixed(dataOutputStream2, archiveGpu.getWireName());
            dataOutputStream2.writeInt(list.size());
            for (OriginalTzArchivePackageDescriptor originalTzArchivePackageDescriptor : list) {
                writeLengthPrefixed(dataOutputStream2, originalTzArchivePackageDescriptor.getSourcePath());
                dataOutputStream2.writeLong(originalTzArchivePackageDescriptor.getArchiveSize());
                dataOutputStream2.writeLong(originalTzArchivePackageDescriptor.getCrc32());
            }
            Unit unit = Unit.INSTANCE;
            CloseableKt.closeFinally(dataOutputStream, null);
            Companion companion = Companion;
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            Intrinsics.checkNotNullExpressionValue(byteArray, "toByteArray(...)");
            return MANIFEST_VERSION_PREFIX + companion.sha256Hex(byteArray);
        } finally {
        }
    }

    private final void writeLengthPrefixed(DataOutputStream dataOutputStream, String str) {
        Charset UTF_8 = StandardCharsets.UTF_8;
        Intrinsics.checkNotNullExpressionValue(UTF_8, "UTF_8");
        byte[] bytes = str.getBytes(UTF_8);
        Intrinsics.checkNotNullExpressionValue(bytes, "getBytes(...)");
        dataOutputStream.writeInt(bytes.length);
        dataOutputStream.write(bytes);
    }

    private final String requiredString(JsonObject jsonObject, String str, String str2) {
        JsonElement jsonElement = jsonObject.get(str);
        if (jsonElement == null) {
            fail(str2, "required field is missing");
            throw new KotlinNothingValueException();
        } else if (!jsonElement.isJsonPrimitive() || !jsonElement.getAsJsonPrimitive().isString()) {
            fail(str2, "must be a string");
            throw new KotlinNothingValueException();
        } else {
            String asString = jsonElement.getAsString();
            Intrinsics.checkNotNullExpressionValue(asString, "getAsString(...)");
            return asString;
        }
    }

    private final long requiredWholeLong(JsonObject jsonObject, String str, String str2) {
        JsonElement jsonElement = jsonObject.get(str);
        if (jsonElement == null) {
            fail(str2, "required field is missing");
            throw new KotlinNothingValueException();
        } else if (!jsonElement.isJsonPrimitive() || !jsonElement.getAsJsonPrimitive().isNumber()) {
            fail(str2, "must be a numeric integer");
            throw new KotlinNothingValueException();
        } else {
            String asString = jsonElement.getAsJsonPrimitive().getAsString();
            Regex regex = WHOLE_NUMBER;
            Intrinsics.checkNotNull(asString);
            if (!regex.matches(asString)) {
                fail(str2, "must be a nonnegative base-10 integer");
                throw new KotlinNothingValueException();
            }
            Long longOrNull = StringsKt.toLongOrNull(asString);
            if (longOrNull != null) {
                return longOrNull.longValue();
            }
            fail(str2, "numeric value is too large");
            throw new KotlinNothingValueException();
        }
    }

    private final JsonObject requiredObject(JsonObject jsonObject, String str, String str2) {
        JsonElement jsonElement = jsonObject.get(str);
        if (jsonElement != null) {
            return requireObject(jsonElement, str2);
        }
        fail(str2, "required field is missing");
        throw new KotlinNothingValueException();
    }

    private final JsonArray requiredArray(JsonObject jsonObject, String str, String str2) {
        JsonElement jsonElement = jsonObject.get(str);
        if (jsonElement != null) {
            return requireArray(jsonElement, str2);
        }
        fail(str2, "required field is missing");
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
        throw new OriginalTzArchiveManifestException(str + ": " + str2, null, 2, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: OriginalTzArchiveManifestParser.kt */
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0082\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J#\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0001J\u0014\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0013\u001a\u00020\u0014HÖ\u0081\u0004J\n\u0010\u0015\u001a\u00020\u0016HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0017"}, d2 = {"Lcom/arizona/launcher/updater/archive/manifest/OriginalTzArchiveManifestParser$ParsedNode;", "", "declaredSize", "", "packages", "", "Lcom/arizona/launcher/updater/archive/manifest/OriginalTzArchivePackageDescriptor;", "<init>", "(JLjava/util/List;)V", "getDeclaredSize", "()J", "getPackages", "()Ljava/util/List;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "app"}, k = 1, mv = {2, 4, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class ParsedNode {
        private final long declaredSize;
        private final List<OriginalTzArchivePackageDescriptor> packages;

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ ParsedNode copy$default(ParsedNode parsedNode, long j, List list, int i, Object obj) {
            if ((i & 1) != 0) {
                j = parsedNode.declaredSize;
            }
            if ((i & 2) != 0) {
                list = parsedNode.packages;
            }
            return parsedNode.copy(j, list);
        }

        public final long component1() {
            return this.declaredSize;
        }

        public final List<OriginalTzArchivePackageDescriptor> component2() {
            return this.packages;
        }

        public final ParsedNode copy(long j, List<OriginalTzArchivePackageDescriptor> packages) {
            Intrinsics.checkNotNullParameter(packages, "packages");
            return new ParsedNode(j, packages);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof ParsedNode) {
                ParsedNode parsedNode = (ParsedNode) obj;
                return this.declaredSize == parsedNode.declaredSize && Intrinsics.areEqual(this.packages, parsedNode.packages);
            }
            return false;
        }

        public int hashCode() {
            return (Long.hashCode(this.declaredSize) * 31) + this.packages.hashCode();
        }

        public String toString() {
            long j = this.declaredSize;
            return "ParsedNode(declaredSize=" + j + ", packages=" + this.packages + ")";
        }

        public ParsedNode(long j, List<OriginalTzArchivePackageDescriptor> packages) {
            Intrinsics.checkNotNullParameter(packages, "packages");
            this.declaredSize = j;
            this.packages = packages;
        }

        public final long getDeclaredSize() {
            return this.declaredSize;
        }

        public final List<OriginalTzArchivePackageDescriptor> getPackages() {
            return this.packages;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: OriginalTzArchiveManifestParser.kt */
    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0012\n\u0000\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u001b\u001a\u00020\u00052\u0006\u0010\u001c\u001a\u00020\u001dR\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\tX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u0011\u0010\r\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0011\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0010R\u0011\u0010\u0013\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0010R!\u0010\u0015\u001a\u0012\u0012\u0004\u0012\u00020\u00170\u0016j\b\u0012\u0004\u0012\u00020\u0017`\u0018¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001a¨\u0006\u001e"}, d2 = {"Lcom/arizona/launcher/updater/archive/manifest/OriginalTzArchiveManifestParser$Companion;", "", "<init>", "()V", "FILES_ROOT", "", "ZIP_SUFFIX", "PACKAGE_ID_PREFIX", "MAX_PACKAGE_ID_LENGTH", "", "ID_DIGEST_LENGTH", "MANIFEST_VERSION_DOMAIN", "MANIFEST_VERSION_PREFIX", "WHOLE_NUMBER", "Lkotlin/text/Regex;", "getWHOLE_NUMBER", "()Lkotlin/text/Regex;", "MD5_HEX", "getMD5_HEX", "NON_ID_CHARACTERS", "getNON_ID_CHARACTERS", "PACKAGE_ORDER", "Ljava/util/Comparator;", "Lcom/arizona/launcher/updater/archive/manifest/OriginalTzArchivePackageDescriptor;", "Lkotlin/Comparator;", "getPACKAGE_ORDER", "()Ljava/util/Comparator;", "sha256Hex", "bytes", "", "app"}, k = 1, mv = {2, 4, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final Regex getWHOLE_NUMBER() {
            return OriginalTzArchiveManifestParser.WHOLE_NUMBER;
        }

        public final Regex getMD5_HEX() {
            return OriginalTzArchiveManifestParser.MD5_HEX;
        }

        public final Regex getNON_ID_CHARACTERS() {
            return OriginalTzArchiveManifestParser.NON_ID_CHARACTERS;
        }

        public final Comparator<OriginalTzArchivePackageDescriptor> getPACKAGE_ORDER() {
            return OriginalTzArchiveManifestParser.PACKAGE_ORDER;
        }

        public final String sha256Hex(byte[] bytes) {
            Intrinsics.checkNotNullParameter(bytes, "bytes");
            byte[] digest = MessageDigest.getInstance("SHA-256").digest(bytes);
            Intrinsics.checkNotNullExpressionValue(digest, "digest(...)");
            return ArraysKt.joinToString$default(digest, (CharSequence) "", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, new Function1() { // from class: com.arizona.launcher.updater.archive.manifest.OriginalTzArchiveManifestParser$Companion$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return OriginalTzArchiveManifestParser.Companion.sha256Hex$lambda$0(((Byte) obj).byteValue());
                }
            }, 30, (Object) null);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public static final CharSequence sha256Hex$lambda$0(byte b) {
            String format = String.format("%02x", Arrays.copyOf(new Object[]{Integer.valueOf(b & 255)}, 1));
            Intrinsics.checkNotNullExpressionValue(format, "format(...)");
            return format;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Comparable PACKAGE_ORDER$lambda$0(OriginalTzArchivePackageDescriptor it) {
        Intrinsics.checkNotNullParameter(it, "it");
        String sourcePath = it.getSourcePath();
        Locale ROOT = Locale.ROOT;
        Intrinsics.checkNotNullExpressionValue(ROOT, "ROOT");
        String lowerCase = sourcePath.toLowerCase(ROOT);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
        return lowerCase;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Comparable PACKAGE_ORDER$lambda$1(OriginalTzArchivePackageDescriptor it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return it.getSourcePath();
    }
}
