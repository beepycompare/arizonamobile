package com.google.gson;

import com.google.gson.internal.ConstructorConstructor;
import com.google.gson.internal.Excluder;
import com.google.gson.internal.Primitives;
import com.google.gson.internal.Streams;
import com.google.gson.internal.bind.JsonAdapterAnnotationTypeAdapterFactory;
import com.google.gson.internal.bind.JsonTreeReader;
import com.google.gson.internal.bind.JsonTreeWriter;
import com.google.gson.internal.bind.SerializationDelegatingTypeAdapter;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import com.google.gson.stream.MalformedJsonException;
import java.io.EOFException;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.io.Writer;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
/* loaded from: classes4.dex */
public final class Gson {
    private static final String JSON_NON_EXECUTABLE_PREFIX = ")]}'\n";
    final List<TypeAdapterFactory> builderFactories;
    final List<TypeAdapterFactory> builderHierarchyFactories;
    final boolean complexMapKeySerialization;
    private final ConstructorConstructor constructorConstructor;
    final String datePattern;
    final int dateStyle;
    final Excluder excluder;
    final List<TypeAdapterFactory> factories;
    final FieldNamingStrategy fieldNamingStrategy;
    final FormattingStyle formattingStyle;
    final boolean generateNonExecutableJson;
    final boolean htmlSafe;
    final Map<Type, InstanceCreator<?>> instanceCreators;
    private final JsonAdapterAnnotationTypeAdapterFactory jsonAdapterFactory;
    final LongSerializationPolicy longSerializationPolicy;
    final ToNumberStrategy numberToNumberStrategy;
    final ToNumberStrategy objectToNumberStrategy;
    final List<ReflectionAccessFilter> reflectionFilters;
    final boolean serializeNulls;
    final boolean serializeSpecialFloatingPointValues;
    final Strictness strictness;
    private final ThreadLocal<Map<TypeToken<?>, TypeAdapter<?>>> threadLocalAdapterResults;
    final int timeStyle;
    private final ConcurrentMap<TypeToken<?>, TypeAdapter<?>> typeTokenCache;
    final boolean useJdkUnsafe;

    public Gson() {
        this(GsonBuilder.DEFAULT);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Gson(GsonBuilder gsonBuilder) {
        this.threadLocalAdapterResults = new ThreadLocal<>();
        this.typeTokenCache = new ConcurrentHashMap();
        this.excluder = gsonBuilder.excluder;
        this.fieldNamingStrategy = gsonBuilder.fieldNamingPolicy;
        HashMap hashMap = new HashMap(gsonBuilder.instanceCreators);
        this.instanceCreators = hashMap;
        this.serializeNulls = gsonBuilder.serializeNulls;
        this.complexMapKeySerialization = gsonBuilder.complexMapKeySerialization;
        this.generateNonExecutableJson = gsonBuilder.generateNonExecutableJson;
        this.htmlSafe = gsonBuilder.escapeHtmlChars;
        this.formattingStyle = gsonBuilder.formattingStyle;
        this.strictness = gsonBuilder.strictness;
        this.serializeSpecialFloatingPointValues = gsonBuilder.serializeSpecialFloatingPointValues;
        boolean z = gsonBuilder.useJdkUnsafe;
        this.useJdkUnsafe = z;
        this.longSerializationPolicy = gsonBuilder.longSerializationPolicy;
        this.datePattern = gsonBuilder.datePattern;
        this.dateStyle = gsonBuilder.dateStyle;
        this.timeStyle = gsonBuilder.timeStyle;
        this.builderFactories = GsonBuilder.newImmutableList(gsonBuilder.factories);
        this.builderHierarchyFactories = GsonBuilder.newImmutableList(gsonBuilder.hierarchyFactories);
        this.objectToNumberStrategy = gsonBuilder.objectToNumberStrategy;
        this.numberToNumberStrategy = gsonBuilder.numberToNumberStrategy;
        List<ReflectionAccessFilter> newImmutableList = GsonBuilder.newImmutableList(gsonBuilder.reflectionFilters);
        this.reflectionFilters = newImmutableList;
        if (gsonBuilder == GsonBuilder.DEFAULT) {
            this.constructorConstructor = GsonBuilder.DEFAULT_CONSTRUCTOR_CONSTRUCTOR;
            this.jsonAdapterFactory = GsonBuilder.DEFAULT_JSON_ADAPTER_ANNOTATION_TYPE_ADAPTER_FACTORY;
            this.factories = GsonBuilder.DEFAULT_TYPE_ADAPTER_FACTORIES;
            return;
        }
        ConstructorConstructor constructorConstructor = new ConstructorConstructor(hashMap, z, newImmutableList);
        this.constructorConstructor = constructorConstructor;
        JsonAdapterAnnotationTypeAdapterFactory jsonAdapterAnnotationTypeAdapterFactory = new JsonAdapterAnnotationTypeAdapterFactory(constructorConstructor);
        this.jsonAdapterFactory = jsonAdapterAnnotationTypeAdapterFactory;
        this.factories = gsonBuilder.createFactories(constructorConstructor, jsonAdapterAnnotationTypeAdapterFactory);
    }

    public GsonBuilder newBuilder() {
        return new GsonBuilder(this);
    }

    @Deprecated
    public Excluder excluder() {
        return this.excluder;
    }

    public FieldNamingStrategy fieldNamingStrategy() {
        return this.fieldNamingStrategy;
    }

    public boolean serializeNulls() {
        return this.serializeNulls;
    }

    public boolean htmlSafe() {
        return this.htmlSafe;
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x0051, code lost:
        r2.setDelegate(r4);
        r0.put(r7, r4);
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v7, types: [java.util.Map] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public <T> TypeAdapter<T> getAdapter(TypeToken<T> typeToken) {
        boolean z;
        Objects.requireNonNull(typeToken, "type must not be null");
        TypeAdapter<T> typeAdapter = (TypeAdapter<T>) this.typeTokenCache.get(typeToken);
        if (typeAdapter != null) {
            return typeAdapter;
        }
        Map<TypeToken<?>, TypeAdapter<?>> map = this.threadLocalAdapterResults.get();
        if (map == null) {
            map = new HashMap<>();
            this.threadLocalAdapterResults.set(map);
            z = true;
        } else {
            TypeAdapter<T> typeAdapter2 = (TypeAdapter<T>) map.get(typeToken);
            if (typeAdapter2 != null) {
                return typeAdapter2;
            }
            z = false;
        }
        try {
            FutureTypeAdapter futureTypeAdapter = new FutureTypeAdapter();
            map.put(typeToken, futureTypeAdapter);
            Iterator<TypeAdapterFactory> it = this.factories.iterator();
            TypeAdapter<T> typeAdapter3 = null;
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                typeAdapter3 = it.next().create(this, typeToken);
                if (typeAdapter3 != null) {
                    break;
                }
            }
            if (typeAdapter3 != null) {
                if (z) {
                    this.typeTokenCache.putAll(map);
                }
                return typeAdapter3;
            }
            throw new IllegalArgumentException("GSON (2.14.0) cannot handle " + typeToken);
        } finally {
            if (z) {
                this.threadLocalAdapterResults.remove();
            }
        }
    }

    public <T> TypeAdapter<T> getAdapter(Class<T> cls) {
        return getAdapter(TypeToken.get((Class) cls));
    }

    public <T> TypeAdapter<T> getDelegateAdapter(TypeAdapterFactory typeAdapterFactory, TypeToken<T> typeToken) {
        Objects.requireNonNull(typeAdapterFactory, "skipPast must not be null");
        Objects.requireNonNull(typeToken, "type must not be null");
        if (this.jsonAdapterFactory.isClassJsonAdapterFactory(typeToken, typeAdapterFactory)) {
            typeAdapterFactory = this.jsonAdapterFactory;
        }
        boolean z = false;
        for (TypeAdapterFactory typeAdapterFactory2 : this.factories) {
            if (z) {
                TypeAdapter<T> create = typeAdapterFactory2.create(this, typeToken);
                if (create != null) {
                    return create;
                }
            } else if (typeAdapterFactory2 == typeAdapterFactory) {
                z = true;
            }
        }
        if (z) {
            throw new IllegalArgumentException("GSON cannot serialize or deserialize " + typeToken);
        }
        return getAdapter(typeToken);
    }

    public JsonElement toJsonTree(Object obj) {
        if (obj == null) {
            return JsonNull.INSTANCE;
        }
        return toJsonTree(obj, obj.getClass());
    }

    public JsonElement toJsonTree(Object obj, Type type) {
        JsonTreeWriter jsonTreeWriter = new JsonTreeWriter();
        toJson(obj, type, jsonTreeWriter);
        return jsonTreeWriter.get();
    }

    public String toJson(Object obj) {
        if (obj == null) {
            return toJson((JsonElement) JsonNull.INSTANCE);
        }
        return toJson(obj, obj.getClass());
    }

    public String toJson(Object obj, Type type) {
        StringBuilder sb = new StringBuilder();
        toJson(obj, type, sb);
        return sb.toString();
    }

    public void toJson(Object obj, Appendable appendable) throws JsonIOException {
        if (obj != null) {
            toJson(obj, obj.getClass(), appendable);
        } else {
            toJson((JsonElement) JsonNull.INSTANCE, appendable);
        }
    }

    public void toJson(Object obj, Type type, Appendable appendable) throws JsonIOException {
        try {
            toJson(obj, type, newJsonWriter(Streams.writerForAppendable(appendable)));
        } catch (IOException e) {
            throw new JsonIOException(e);
        }
    }

    public void toJson(Object obj, Type type, JsonWriter jsonWriter) throws JsonIOException {
        TypeAdapter adapter = getAdapter(TypeToken.get(type));
        Strictness strictness = jsonWriter.getStrictness();
        Strictness strictness2 = this.strictness;
        if (strictness2 != null) {
            jsonWriter.setStrictness(strictness2);
        } else if (jsonWriter.getStrictness() == Strictness.LEGACY_STRICT) {
            jsonWriter.setStrictness(Strictness.LENIENT);
        }
        boolean isHtmlSafe = jsonWriter.isHtmlSafe();
        boolean serializeNulls = jsonWriter.getSerializeNulls();
        jsonWriter.setHtmlSafe(this.htmlSafe);
        jsonWriter.setSerializeNulls(this.serializeNulls);
        try {
            try {
                try {
                    adapter.write(jsonWriter, obj);
                } catch (AssertionError e) {
                    throw new AssertionError("AssertionError (GSON 2.14.0): " + e.getMessage(), e);
                }
            } catch (IOException e2) {
                throw new JsonIOException(e2);
            }
        } finally {
            jsonWriter.setStrictness(strictness);
            jsonWriter.setHtmlSafe(isHtmlSafe);
            jsonWriter.setSerializeNulls(serializeNulls);
        }
    }

    public String toJson(JsonElement jsonElement) {
        StringBuilder sb = new StringBuilder();
        toJson(jsonElement, (Appendable) sb);
        return sb.toString();
    }

    public void toJson(JsonElement jsonElement, Appendable appendable) throws JsonIOException {
        try {
            toJson(jsonElement, newJsonWriter(Streams.writerForAppendable(appendable)));
        } catch (IOException e) {
            throw new JsonIOException(e);
        }
    }

    public void toJson(JsonElement jsonElement, JsonWriter jsonWriter) throws JsonIOException {
        Strictness strictness = jsonWriter.getStrictness();
        boolean isHtmlSafe = jsonWriter.isHtmlSafe();
        boolean serializeNulls = jsonWriter.getSerializeNulls();
        jsonWriter.setHtmlSafe(this.htmlSafe);
        jsonWriter.setSerializeNulls(this.serializeNulls);
        Strictness strictness2 = this.strictness;
        if (strictness2 != null) {
            jsonWriter.setStrictness(strictness2);
        } else if (jsonWriter.getStrictness() == Strictness.LEGACY_STRICT) {
            jsonWriter.setStrictness(Strictness.LENIENT);
        }
        try {
            try {
                Streams.write(jsonElement, jsonWriter);
            } catch (IOException e) {
                throw new JsonIOException(e);
            } catch (AssertionError e2) {
                throw new AssertionError("AssertionError (GSON 2.14.0): " + e2.getMessage(), e2);
            }
        } finally {
            jsonWriter.setStrictness(strictness);
            jsonWriter.setHtmlSafe(isHtmlSafe);
            jsonWriter.setSerializeNulls(serializeNulls);
        }
    }

    public JsonWriter newJsonWriter(Writer writer) throws IOException {
        if (this.generateNonExecutableJson) {
            writer.write(JSON_NON_EXECUTABLE_PREFIX);
        }
        JsonWriter jsonWriter = new JsonWriter(writer);
        jsonWriter.setFormattingStyle(this.formattingStyle);
        jsonWriter.setHtmlSafe(this.htmlSafe);
        Strictness strictness = this.strictness;
        if (strictness == null) {
            strictness = Strictness.LEGACY_STRICT;
        }
        jsonWriter.setStrictness(strictness);
        jsonWriter.setSerializeNulls(this.serializeNulls);
        return jsonWriter;
    }

    public JsonReader newJsonReader(Reader reader) {
        JsonReader jsonReader = new JsonReader(reader);
        Strictness strictness = this.strictness;
        if (strictness == null) {
            strictness = Strictness.LEGACY_STRICT;
        }
        jsonReader.setStrictness(strictness);
        return jsonReader;
    }

    public <T> T fromJson(String str, Class<T> cls) throws JsonSyntaxException {
        return (T) fromJson(str, TypeToken.get((Class) cls));
    }

    public <T> T fromJson(String str, Type type) throws JsonSyntaxException {
        return (T) fromJson(str, TypeToken.get(type));
    }

    public <T> T fromJson(String str, TypeToken<T> typeToken) throws JsonSyntaxException {
        if (str == null) {
            return null;
        }
        return (T) fromJson(new StringReader(str), typeToken);
    }

    public <T> T fromJson(Reader reader, Class<T> cls) throws JsonSyntaxException, JsonIOException {
        return (T) fromJson(reader, TypeToken.get((Class) cls));
    }

    public <T> T fromJson(Reader reader, Type type) throws JsonIOException, JsonSyntaxException {
        return (T) fromJson(reader, TypeToken.get(type));
    }

    public <T> T fromJson(Reader reader, TypeToken<T> typeToken) throws JsonIOException, JsonSyntaxException {
        JsonReader newJsonReader = newJsonReader(reader);
        T t = (T) fromJson(newJsonReader, typeToken);
        assertFullConsumption(t, newJsonReader);
        return t;
    }

    public <T> T fromJson(JsonReader jsonReader, Type type) throws JsonIOException, JsonSyntaxException {
        return (T) fromJson(jsonReader, TypeToken.get(type));
    }

    public <T> T fromJson(JsonReader jsonReader, TypeToken<T> typeToken) throws JsonIOException, JsonSyntaxException {
        boolean z;
        Strictness strictness = jsonReader.getStrictness();
        Strictness strictness2 = this.strictness;
        if (strictness2 != null) {
            jsonReader.setStrictness(strictness2);
        } else if (jsonReader.getStrictness() == Strictness.LEGACY_STRICT) {
            jsonReader.setStrictness(Strictness.LENIENT);
        }
        try {
            try {
                try {
                    try {
                        try {
                            jsonReader.peek();
                            z = false;
                            try {
                                TypeAdapter<T> adapter = getAdapter(typeToken);
                                T read = adapter.read(jsonReader);
                                Class wrap = Primitives.wrap(typeToken.getRawType());
                                if (read != null && !wrap.isInstance(read)) {
                                    throw new ClassCastException("Type adapter '" + adapter + "' returned wrong type; requested " + typeToken.getRawType() + " but got instance of " + read.getClass() + "\nVerify that the adapter was registered for the correct type.");
                                }
                                return read;
                            } catch (EOFException e) {
                                e = e;
                                if (!z) {
                                    throw new JsonSyntaxException(e);
                                }
                                jsonReader.setStrictness(strictness);
                                return null;
                            }
                        } finally {
                            jsonReader.setStrictness(strictness);
                        }
                    } catch (EOFException e2) {
                        e = e2;
                        z = true;
                    }
                } catch (IllegalStateException e3) {
                    throw new JsonSyntaxException(e3);
                }
            } catch (IOException e4) {
                throw new JsonSyntaxException(e4);
            }
        } catch (AssertionError e5) {
            throw new AssertionError("AssertionError (GSON 2.14.0): " + e5.getMessage(), e5);
        }
    }

    public <T> T fromJson(JsonElement jsonElement, Class<T> cls) throws JsonSyntaxException {
        return (T) fromJson(jsonElement, TypeToken.get((Class) cls));
    }

    public <T> T fromJson(JsonElement jsonElement, Type type) throws JsonSyntaxException {
        return (T) fromJson(jsonElement, TypeToken.get(type));
    }

    public <T> T fromJson(JsonElement jsonElement, TypeToken<T> typeToken) throws JsonSyntaxException {
        if (jsonElement == null) {
            return null;
        }
        return (T) fromJson(new JsonTreeReader(jsonElement), typeToken);
    }

    private static void assertFullConsumption(Object obj, JsonReader jsonReader) {
        if (obj != null) {
            try {
                if (jsonReader.peek() == JsonToken.END_DOCUMENT) {
                    return;
                }
                throw new JsonSyntaxException("JSON document was not fully consumed.");
            } catch (MalformedJsonException e) {
                throw new JsonSyntaxException(e);
            } catch (IOException e2) {
                throw new JsonIOException(e2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public static class FutureTypeAdapter<T> extends SerializationDelegatingTypeAdapter<T> {
        private TypeAdapter<T> delegate = null;

        FutureTypeAdapter() {
        }

        public void setDelegate(TypeAdapter<T> typeAdapter) {
            if (this.delegate != null) {
                throw new AssertionError("Delegate is already set");
            }
            this.delegate = typeAdapter;
        }

        private TypeAdapter<T> delegate() {
            TypeAdapter<T> typeAdapter = this.delegate;
            if (typeAdapter != null) {
                return typeAdapter;
            }
            throw new IllegalStateException("Adapter for type with cyclic dependency has been used before dependency has been resolved");
        }

        @Override // com.google.gson.internal.bind.SerializationDelegatingTypeAdapter
        public TypeAdapter<T> getSerializationDelegate() {
            return delegate();
        }

        @Override // com.google.gson.TypeAdapter
        public T read(JsonReader jsonReader) throws IOException {
            return delegate().read(jsonReader);
        }

        @Override // com.google.gson.TypeAdapter
        public void write(JsonWriter jsonWriter, T t) throws IOException {
            delegate().write(jsonWriter, t);
        }
    }

    public String toString() {
        return "{serializeNulls:" + this.serializeNulls + ",factories:" + this.factories + ",instanceCreators:" + this.constructorConstructor + "}";
    }
}
