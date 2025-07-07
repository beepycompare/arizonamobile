package com.google.gson.internal.bind;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonNull;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;
import com.google.gson.TypeAdapter;
import com.google.gson.internal.LazilyParsedNumber;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.Map;
/* loaded from: classes4.dex */
class JsonElementTypeAdapter extends TypeAdapter<JsonElement> {
    static final JsonElementTypeAdapter ADAPTER = new JsonElementTypeAdapter();

    private JsonElementTypeAdapter() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.google.gson.internal.bind.JsonElementTypeAdapter$1  reason: invalid class name */
    /* loaded from: classes4.dex */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$google$gson$stream$JsonToken;

        static {
            int[] iArr = new int[JsonToken.values().length];
            $SwitchMap$com$google$gson$stream$JsonToken = iArr;
            try {
                iArr[JsonToken.BEGIN_ARRAY.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$google$gson$stream$JsonToken[JsonToken.BEGIN_OBJECT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$google$gson$stream$JsonToken[JsonToken.STRING.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$google$gson$stream$JsonToken[JsonToken.NUMBER.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$google$gson$stream$JsonToken[JsonToken.BOOLEAN.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$com$google$gson$stream$JsonToken[JsonToken.NULL.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    private JsonElement tryBeginNesting(JsonReader jsonReader, JsonToken jsonToken) throws IOException {
        int i = AnonymousClass1.$SwitchMap$com$google$gson$stream$JsonToken[jsonToken.ordinal()];
        if (i == 1) {
            jsonReader.beginArray();
            return new JsonArray();
        } else if (i != 2) {
            return null;
        } else {
            jsonReader.beginObject();
            return new JsonObject();
        }
    }

    private JsonElement readTerminal(JsonReader jsonReader, JsonToken jsonToken) throws IOException {
        int i = AnonymousClass1.$SwitchMap$com$google$gson$stream$JsonToken[jsonToken.ordinal()];
        if (i != 3) {
            if (i != 4) {
                if (i != 5) {
                    if (i == 6) {
                        jsonReader.nextNull();
                        return JsonNull.INSTANCE;
                    }
                    throw new IllegalStateException("Unexpected token: " + jsonToken);
                }
                return new JsonPrimitive(Boolean.valueOf(jsonReader.nextBoolean()));
            }
            return new JsonPrimitive(new LazilyParsedNumber(jsonReader.nextString()));
        }
        return new JsonPrimitive(jsonReader.nextString());
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.google.gson.TypeAdapter
    public JsonElement read(JsonReader jsonReader) throws IOException {
        if (jsonReader instanceof JsonTreeReader) {
            return ((JsonTreeReader) jsonReader).nextJsonElement();
        }
        JsonToken peek = jsonReader.peek();
        JsonElement tryBeginNesting = tryBeginNesting(jsonReader, peek);
        if (tryBeginNesting == null) {
            return readTerminal(jsonReader, peek);
        }
        ArrayDeque arrayDeque = new ArrayDeque();
        while (true) {
            if (jsonReader.hasNext()) {
                String nextName = tryBeginNesting instanceof JsonObject ? jsonReader.nextName() : null;
                JsonToken peek2 = jsonReader.peek();
                JsonElement tryBeginNesting2 = tryBeginNesting(jsonReader, peek2);
                boolean z = tryBeginNesting2 != null;
                if (tryBeginNesting2 == null) {
                    tryBeginNesting2 = readTerminal(jsonReader, peek2);
                }
                if (tryBeginNesting instanceof JsonArray) {
                    ((JsonArray) tryBeginNesting).add(tryBeginNesting2);
                } else {
                    ((JsonObject) tryBeginNesting).add(nextName, tryBeginNesting2);
                }
                if (z) {
                    arrayDeque.addLast(tryBeginNesting);
                    tryBeginNesting = tryBeginNesting2;
                }
            } else {
                if (tryBeginNesting instanceof JsonArray) {
                    jsonReader.endArray();
                } else {
                    jsonReader.endObject();
                }
                if (arrayDeque.isEmpty()) {
                    return tryBeginNesting;
                }
                tryBeginNesting = (JsonElement) arrayDeque.removeLast();
            }
        }
    }

    @Override // com.google.gson.TypeAdapter
    public void write(JsonWriter jsonWriter, JsonElement jsonElement) throws IOException {
        if (jsonElement == null || jsonElement.isJsonNull()) {
            jsonWriter.nullValue();
        } else if (jsonElement.isJsonPrimitive()) {
            JsonPrimitive asJsonPrimitive = jsonElement.getAsJsonPrimitive();
            if (asJsonPrimitive.isNumber()) {
                jsonWriter.value(asJsonPrimitive.getAsNumber());
            } else if (asJsonPrimitive.isBoolean()) {
                jsonWriter.value(asJsonPrimitive.getAsBoolean());
            } else {
                jsonWriter.value(asJsonPrimitive.getAsString());
            }
        } else if (jsonElement.isJsonArray()) {
            jsonWriter.beginArray();
            Iterator<JsonElement> it = jsonElement.getAsJsonArray().iterator();
            while (it.hasNext()) {
                write(jsonWriter, it.next());
            }
            jsonWriter.endArray();
        } else if (jsonElement.isJsonObject()) {
            jsonWriter.beginObject();
            for (Map.Entry<String, JsonElement> entry : jsonElement.getAsJsonObject().entrySet()) {
                jsonWriter.name(entry.getKey());
                write(jsonWriter, entry.getValue());
            }
            jsonWriter.endObject();
        } else {
            throw new IllegalArgumentException("Couldn't write " + jsonElement.getClass());
        }
    }
}
