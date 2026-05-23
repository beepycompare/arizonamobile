package androidx.media3.exoplayer.upstream.contentsteering;

import android.net.Uri;
import android.util.JsonReader;
import android.util.JsonToken;
import androidx.media3.common.ParserException;
import androidx.media3.exoplayer.upstream.ParsingLoadable;
import androidx.media3.exoplayer.upstream.contentsteering.SteeringManifest;
import com.google.common.collect.ImmutableList;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
/* loaded from: classes3.dex */
public final class SteeringManifestParser implements ParsingLoadable.Parser<SteeringManifest> {
    private static final String STEERING_MANIFEST_JSON_NAME_BASE_ID = "BASE-ID";
    private static final String STEERING_MANIFEST_JSON_NAME_HOST = "HOST";
    private static final String STEERING_MANIFEST_JSON_NAME_ID = "ID";
    private static final String STEERING_MANIFEST_JSON_NAME_PARAMS = "PARAMS";
    private static final String STEERING_MANIFEST_JSON_NAME_PATHWAY_CLONES = "PATHWAY-CLONES";
    private static final String STEERING_MANIFEST_JSON_NAME_PATHWAY_PRIORITY = "PATHWAY-PRIORITY";
    private static final String STEERING_MANIFEST_JSON_NAME_PER_RENDITION_URIS = "PER-RENDITION-URIS";
    private static final String STEERING_MANIFEST_JSON_NAME_PER_VARIANT_URIS = "PER-VARIANT-URIS";
    private static final String STEERING_MANIFEST_JSON_NAME_RELOAD_URI = "RELOAD-URI";
    private static final String STEERING_MANIFEST_JSON_NAME_TTL = "TTL";
    private static final String STEERING_MANIFEST_JSON_NAME_URI_REPLACEMENT = "URI-REPLACEMENT";
    private static final String STEERING_MANIFEST_JSON_NAME_VERSION = "VERSION";

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public interface StringConverter<T> {
        T convert(String str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ String lambda$parseUriReplacement$0(String str) {
        return str;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // androidx.media3.exoplayer.upstream.ParsingLoadable.Parser
    public SteeringManifest parse(Uri uri, InputStream inputStream) throws IOException {
        JsonReader jsonReader = new JsonReader(new InputStreamReader(inputStream));
        try {
            if (!jsonReader.peek().equals(JsonToken.BEGIN_OBJECT)) {
                throw ParserException.createForMalformedSteeringManifest("Steering manifest JSON should be an object at root", null);
            }
            ImmutableList.Builder builder = new ImmutableList.Builder();
            ImmutableList.Builder builder2 = new ImmutableList.Builder();
            jsonReader.beginObject();
            Uri uri2 = null;
            int i = 1;
            long j = -9223372036854775807L;
            while (jsonReader.hasNext()) {
                String nextName = jsonReader.nextName();
                if (nextName.equals(STEERING_MANIFEST_JSON_NAME_VERSION) && jsonReader.peek().equals(JsonToken.NUMBER)) {
                    i = jsonReader.nextInt();
                } else if (nextName.equals(STEERING_MANIFEST_JSON_NAME_TTL) && jsonReader.peek().equals(JsonToken.NUMBER)) {
                    j = jsonReader.nextInt() * 1000;
                } else if (nextName.equals(STEERING_MANIFEST_JSON_NAME_RELOAD_URI) && jsonReader.peek().equals(JsonToken.STRING)) {
                    uri2 = Uri.parse(jsonReader.nextString());
                } else if (nextName.equals(STEERING_MANIFEST_JSON_NAME_PATHWAY_PRIORITY) && jsonReader.peek().equals(JsonToken.BEGIN_ARRAY)) {
                    parsePathwayPriorityArray(jsonReader, builder);
                } else if (nextName.equals(STEERING_MANIFEST_JSON_NAME_PATHWAY_CLONES) && jsonReader.peek().equals(JsonToken.BEGIN_ARRAY)) {
                    parsePathwayClonesArray(jsonReader, builder2);
                } else {
                    jsonReader.skipValue();
                }
            }
            jsonReader.endObject();
            ImmutableList build = builder.build();
            if (build.isEmpty()) {
                throw ParserException.createForMalformedSteeringManifest("PATHWAY-PRIORITY field is missing", null);
            }
            SteeringManifest steeringManifest = new SteeringManifest(i, j, uri2, build, builder2.build());
            jsonReader.close();
            return steeringManifest;
        } catch (Throwable th) {
            try {
                jsonReader.close();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }

    private static SteeringManifest.PathwayClone parsePathwayClone(JsonReader jsonReader) throws IOException {
        jsonReader.beginObject();
        String str = null;
        String str2 = null;
        SteeringManifest.UriReplacement uriReplacement = null;
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            if (nextName.equals(STEERING_MANIFEST_JSON_NAME_BASE_ID) && jsonReader.peek().equals(JsonToken.STRING)) {
                str = jsonReader.nextString();
            } else if (nextName.equals(STEERING_MANIFEST_JSON_NAME_ID) && jsonReader.peek().equals(JsonToken.STRING)) {
                str2 = jsonReader.nextString();
            } else if (nextName.equals(STEERING_MANIFEST_JSON_NAME_URI_REPLACEMENT) && jsonReader.peek().equals(JsonToken.BEGIN_OBJECT)) {
                uriReplacement = parseUriReplacement(jsonReader);
            } else {
                jsonReader.skipValue();
            }
        }
        jsonReader.endObject();
        if (str != null) {
            if (str2 != null) {
                if (uriReplacement == null) {
                    throw ParserException.createForMalformedSteeringManifest("URI-REPLACEMENT field is missing in a PATHWAY-CLONE object", null);
                }
                return new SteeringManifest.PathwayClone(str, str2, uriReplacement);
            }
            throw ParserException.createForMalformedSteeringManifest("ID field is missing in a PATHWAY-CLONE object", null);
        }
        throw ParserException.createForMalformedSteeringManifest("BASE-ID field is missing in a PATHWAY-CLONE object", null);
    }

    private static SteeringManifest.UriReplacement parseUriReplacement(JsonReader jsonReader) throws IOException {
        jsonReader.beginObject();
        HashMap hashMap = new HashMap();
        HashMap hashMap2 = new HashMap();
        HashMap hashMap3 = new HashMap();
        String str = null;
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            if (nextName.equals(STEERING_MANIFEST_JSON_NAME_HOST) && jsonReader.peek().equals(JsonToken.STRING)) {
                str = jsonReader.nextString();
                if (str.isEmpty()) {
                    throw ParserException.createForMalformedSteeringManifest("The HOST string is present but empty", null);
                }
            } else if (nextName.equals(STEERING_MANIFEST_JSON_NAME_PARAMS) && jsonReader.peek().equals(JsonToken.BEGIN_OBJECT)) {
                parseMap(jsonReader, new StringConverter() { // from class: androidx.media3.exoplayer.upstream.contentsteering.SteeringManifestParser$$ExternalSyntheticLambda0
                    @Override // androidx.media3.exoplayer.upstream.contentsteering.SteeringManifestParser.StringConverter
                    public final Object convert(String str2) {
                        return SteeringManifestParser.lambda$parseUriReplacement$0(str2);
                    }
                }, hashMap);
            } else if (nextName.equals(STEERING_MANIFEST_JSON_NAME_PER_VARIANT_URIS) && jsonReader.peek().equals(JsonToken.BEGIN_OBJECT)) {
                parseMap(jsonReader, new StringConverter() { // from class: androidx.media3.exoplayer.upstream.contentsteering.SteeringManifestParser$$ExternalSyntheticLambda1
                    @Override // androidx.media3.exoplayer.upstream.contentsteering.SteeringManifestParser.StringConverter
                    public final Object convert(String str2) {
                        Uri parse;
                        parse = Uri.parse(str2);
                        return parse;
                    }
                }, hashMap2);
            } else if (nextName.equals(STEERING_MANIFEST_JSON_NAME_PER_RENDITION_URIS) && jsonReader.peek().equals(JsonToken.BEGIN_OBJECT)) {
                parseMap(jsonReader, new StringConverter() { // from class: androidx.media3.exoplayer.upstream.contentsteering.SteeringManifestParser$$ExternalSyntheticLambda1
                    @Override // androidx.media3.exoplayer.upstream.contentsteering.SteeringManifestParser.StringConverter
                    public final Object convert(String str2) {
                        Uri parse;
                        parse = Uri.parse(str2);
                        return parse;
                    }
                }, hashMap3);
            } else {
                jsonReader.skipValue();
            }
        }
        jsonReader.endObject();
        return new SteeringManifest.UriReplacement(str, hashMap, hashMap2, hashMap3);
    }

    private static void parsePathwayClonesArray(JsonReader jsonReader, ImmutableList.Builder<SteeringManifest.PathwayClone> builder) throws IOException {
        jsonReader.beginArray();
        boolean z = false;
        while (jsonReader.hasNext()) {
            if (jsonReader.peek().equals(JsonToken.BEGIN_OBJECT)) {
                builder.add((ImmutableList.Builder<SteeringManifest.PathwayClone>) parsePathwayClone(jsonReader));
                z = true;
            } else {
                jsonReader.skipValue();
            }
        }
        jsonReader.endArray();
        if (!z) {
            throw ParserException.createForMalformedSteeringManifest("The PATHWAY-CLONES array is present but empty", null);
        }
    }

    private static void parsePathwayPriorityArray(JsonReader jsonReader, ImmutableList.Builder<String> builder) throws IOException {
        HashSet hashSet = new HashSet();
        jsonReader.beginArray();
        while (jsonReader.hasNext()) {
            if (jsonReader.peek().equals(JsonToken.STRING)) {
                String nextString = jsonReader.nextString();
                if (!hashSet.add(nextString)) {
                    throw ParserException.createForMalformedSteeringManifest("The pathway ID (" + nextString + ") appears more than once in the PATHWAY-PRIORITY array", null);
                }
                builder.add((ImmutableList.Builder<String>) nextString);
            } else {
                jsonReader.skipValue();
            }
        }
        jsonReader.endArray();
        if (hashSet.isEmpty()) {
            throw ParserException.createForMalformedSteeringManifest("The PATHWAY-PRIORITY array is present but empty", null);
        }
    }

    private static <T> void parseMap(JsonReader jsonReader, StringConverter<T> stringConverter, Map<String, T> map) throws IOException {
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            if (jsonReader.peek().equals(JsonToken.STRING)) {
                map.put(nextName, stringConverter.convert(jsonReader.nextString()));
            } else {
                jsonReader.skipValue();
            }
        }
        jsonReader.endObject();
    }
}
