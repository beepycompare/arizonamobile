package com.google.gson;

import com.google.gson.internal.ConstructorConstructor;
import com.google.gson.internal.Excluder;
import com.google.gson.internal.LazilyParsedNumber;
import com.google.gson.internal.Primitives;
import com.google.gson.internal.Streams;
import com.google.gson.internal.bind.ArrayTypeAdapter;
import com.google.gson.internal.bind.CollectionTypeAdapterFactory;
import com.google.gson.internal.bind.DefaultDateTypeAdapter;
import com.google.gson.internal.bind.JsonAdapterAnnotationTypeAdapterFactory;
import com.google.gson.internal.bind.JsonTreeReader;
import com.google.gson.internal.bind.JsonTreeWriter;
import com.google.gson.internal.bind.MapTypeAdapterFactory;
import com.google.gson.internal.bind.NumberTypeAdapter;
import com.google.gson.internal.bind.ObjectTypeAdapter;
import com.google.gson.internal.bind.ReflectiveTypeAdapterFactory;
import com.google.gson.internal.bind.SerializationDelegatingTypeAdapter;
import com.google.gson.internal.bind.TypeAdapters;
import com.google.gson.internal.sql.SqlTypesSupport;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import com.google.gson.stream.MalformedJsonException;
import java.io.EOFException;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.io.StringWriter;
import java.io.Writer;
import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicLongArray;
/* loaded from: classes4.dex */
public final class Gson {
    static final boolean DEFAULT_COMPLEX_MAP_KEYS = false;
    static final boolean DEFAULT_ESCAPE_HTML = true;
    static final boolean DEFAULT_JSON_NON_EXECUTABLE = false;
    static final boolean DEFAULT_SERIALIZE_NULLS = false;
    static final boolean DEFAULT_SPECIALIZE_FLOAT_VALUES = false;
    static final Strictness DEFAULT_STRICTNESS = null;
    static final boolean DEFAULT_USE_JDK_UNSAFE = true;
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
    static final FormattingStyle DEFAULT_FORMATTING_STYLE = FormattingStyle.COMPACT;
    static final String DEFAULT_DATE_PATTERN = null;
    static final FieldNamingStrategy DEFAULT_FIELD_NAMING_STRATEGY = FieldNamingPolicy.IDENTITY;
    static final ToNumberStrategy DEFAULT_OBJECT_TO_NUMBER_STRATEGY = ToNumberPolicy.DOUBLE;
    static final ToNumberStrategy DEFAULT_NUMBER_TO_NUMBER_STRATEGY = ToNumberPolicy.LAZILY_PARSED_NUMBER;

    public Gson() {
        this(Excluder.DEFAULT, DEFAULT_FIELD_NAMING_STRATEGY, Collections.emptyMap(), false, false, false, true, DEFAULT_FORMATTING_STYLE, DEFAULT_STRICTNESS, false, true, LongSerializationPolicy.DEFAULT, DEFAULT_DATE_PATTERN, 2, 2, Collections.emptyList(), Collections.emptyList(), Collections.emptyList(), DEFAULT_OBJECT_TO_NUMBER_STRATEGY, DEFAULT_NUMBER_TO_NUMBER_STRATEGY, Collections.emptyList());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Gson(Excluder excluder, FieldNamingStrategy fieldNamingStrategy, Map<Type, InstanceCreator<?>> map, boolean z, boolean z2, boolean z3, boolean z4, FormattingStyle formattingStyle, Strictness strictness, boolean z5, boolean z6, LongSerializationPolicy longSerializationPolicy, String str, int i, int i2, List<TypeAdapterFactory> list, List<TypeAdapterFactory> list2, List<TypeAdapterFactory> list3, ToNumberStrategy toNumberStrategy, ToNumberStrategy toNumberStrategy2, List<ReflectionAccessFilter> list4) {
        this.threadLocalAdapterResults = new ThreadLocal<>();
        this.typeTokenCache = new ConcurrentHashMap();
        this.excluder = excluder;
        this.fieldNamingStrategy = fieldNamingStrategy;
        this.instanceCreators = map;
        ConstructorConstructor constructorConstructor = new ConstructorConstructor(map, z6, list4);
        this.constructorConstructor = constructorConstructor;
        this.serializeNulls = z;
        this.complexMapKeySerialization = z2;
        this.generateNonExecutableJson = z3;
        this.htmlSafe = z4;
        this.formattingStyle = formattingStyle;
        this.strictness = strictness;
        this.serializeSpecialFloatingPointValues = z5;
        this.useJdkUnsafe = z6;
        this.longSerializationPolicy = longSerializationPolicy;
        this.datePattern = str;
        this.dateStyle = i;
        this.timeStyle = i2;
        this.builderFactories = list;
        this.builderHierarchyFactories = list2;
        this.objectToNumberStrategy = toNumberStrategy;
        this.numberToNumberStrategy = toNumberStrategy2;
        this.reflectionFilters = list4;
        ArrayList arrayList = new ArrayList();
        arrayList.add(TypeAdapters.JSON_ELEMENT_FACTORY);
        arrayList.add(ObjectTypeAdapter.getFactory(toNumberStrategy));
        arrayList.add(excluder);
        arrayList.addAll(list3);
        arrayList.add(TypeAdapters.STRING_FACTORY);
        arrayList.add(TypeAdapters.INTEGER_FACTORY);
        arrayList.add(TypeAdapters.BOOLEAN_FACTORY);
        arrayList.add(TypeAdapters.BYTE_FACTORY);
        arrayList.add(TypeAdapters.SHORT_FACTORY);
        TypeAdapter<Number> longAdapter = longAdapter(longSerializationPolicy);
        arrayList.add(TypeAdapters.newFactory(Long.TYPE, Long.class, longAdapter));
        arrayList.add(TypeAdapters.newFactory(Double.TYPE, Double.class, doubleAdapter(z5)));
        arrayList.add(TypeAdapters.newFactory(Float.TYPE, Float.class, floatAdapter(z5)));
        arrayList.add(NumberTypeAdapter.getFactory(toNumberStrategy2));
        arrayList.add(TypeAdapters.ATOMIC_INTEGER_FACTORY);
        arrayList.add(TypeAdapters.ATOMIC_BOOLEAN_FACTORY);
        arrayList.add(TypeAdapters.newFactory(AtomicLong.class, atomicLongAdapter(longAdapter)));
        arrayList.add(TypeAdapters.newFactory(AtomicLongArray.class, atomicLongArrayAdapter(longAdapter)));
        arrayList.add(TypeAdapters.ATOMIC_INTEGER_ARRAY_FACTORY);
        arrayList.add(TypeAdapters.CHARACTER_FACTORY);
        arrayList.add(TypeAdapters.STRING_BUILDER_FACTORY);
        arrayList.add(TypeAdapters.STRING_BUFFER_FACTORY);
        arrayList.add(TypeAdapters.newFactory(BigDecimal.class, TypeAdapters.BIG_DECIMAL));
        arrayList.add(TypeAdapters.newFactory(BigInteger.class, TypeAdapters.BIG_INTEGER));
        arrayList.add(TypeAdapters.newFactory(LazilyParsedNumber.class, TypeAdapters.LAZILY_PARSED_NUMBER));
        arrayList.add(TypeAdapters.URL_FACTORY);
        arrayList.add(TypeAdapters.URI_FACTORY);
        arrayList.add(TypeAdapters.UUID_FACTORY);
        arrayList.add(TypeAdapters.CURRENCY_FACTORY);
        arrayList.add(TypeAdapters.LOCALE_FACTORY);
        arrayList.add(TypeAdapters.INET_ADDRESS_FACTORY);
        arrayList.add(TypeAdapters.BIT_SET_FACTORY);
        arrayList.add(DefaultDateTypeAdapter.DEFAULT_STYLE_FACTORY);
        arrayList.add(TypeAdapters.CALENDAR_FACTORY);
        if (SqlTypesSupport.SUPPORTS_SQL_TYPES) {
            arrayList.add(SqlTypesSupport.TIME_FACTORY);
            arrayList.add(SqlTypesSupport.DATE_FACTORY);
            arrayList.add(SqlTypesSupport.TIMESTAMP_FACTORY);
        }
        arrayList.add(ArrayTypeAdapter.FACTORY);
        arrayList.add(TypeAdapters.CLASS_FACTORY);
        arrayList.add(new CollectionTypeAdapterFactory(constructorConstructor));
        arrayList.add(new MapTypeAdapterFactory(constructorConstructor, z2));
        JsonAdapterAnnotationTypeAdapterFactory jsonAdapterAnnotationTypeAdapterFactory = new JsonAdapterAnnotationTypeAdapterFactory(constructorConstructor);
        this.jsonAdapterFactory = jsonAdapterAnnotationTypeAdapterFactory;
        arrayList.add(jsonAdapterAnnotationTypeAdapterFactory);
        arrayList.add(TypeAdapters.ENUM_FACTORY);
        arrayList.add(new ReflectiveTypeAdapterFactory(constructorConstructor, fieldNamingStrategy, excluder, jsonAdapterAnnotationTypeAdapterFactory, list4));
        this.factories = Collections.unmodifiableList(arrayList);
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

    private TypeAdapter<Number> doubleAdapter(boolean z) {
        if (z) {
            return TypeAdapters.DOUBLE;
        }
        return new TypeAdapter<Number>() { // from class: com.google.gson.Gson.1
            @Override // com.google.gson.TypeAdapter
            /* renamed from: read */
            public Number read2(JsonReader jsonReader) throws IOException {
                if (jsonReader.peek() == JsonToken.NULL) {
                    jsonReader.nextNull();
                    return null;
                }
                return Double.valueOf(jsonReader.nextDouble());
            }

            @Override // com.google.gson.TypeAdapter
            public void write(JsonWriter jsonWriter, Number number) throws IOException {
                if (number == null) {
                    jsonWriter.nullValue();
                    return;
                }
                double doubleValue = number.doubleValue();
                Gson.checkValidFloatingPoint(doubleValue);
                jsonWriter.value(doubleValue);
            }
        };
    }

    private TypeAdapter<Number> floatAdapter(boolean z) {
        if (z) {
            return TypeAdapters.FLOAT;
        }
        return new TypeAdapter<Number>() { // from class: com.google.gson.Gson.2
            @Override // com.google.gson.TypeAdapter
            /* renamed from: read */
            public Number read2(JsonReader jsonReader) throws IOException {
                if (jsonReader.peek() == JsonToken.NULL) {
                    jsonReader.nextNull();
                    return null;
                }
                return Float.valueOf((float) jsonReader.nextDouble());
            }

            @Override // com.google.gson.TypeAdapter
            public void write(JsonWriter jsonWriter, Number number) throws IOException {
                if (number == null) {
                    jsonWriter.nullValue();
                    return;
                }
                float floatValue = number.floatValue();
                Gson.checkValidFloatingPoint(floatValue);
                if (!(number instanceof Float)) {
                    number = Float.valueOf(floatValue);
                }
                jsonWriter.value(number);
            }
        };
    }

    static void checkValidFloatingPoint(double d) {
        if (Double.isNaN(d) || Double.isInfinite(d)) {
            throw new IllegalArgumentException(d + " is not a valid double value as per JSON specification. To override this behavior, use GsonBuilder.serializeSpecialFloatingPointValues() method.");
        }
    }

    private static TypeAdapter<Number> longAdapter(LongSerializationPolicy longSerializationPolicy) {
        if (longSerializationPolicy == LongSerializationPolicy.DEFAULT) {
            return TypeAdapters.LONG;
        }
        return new TypeAdapter<Number>() { // from class: com.google.gson.Gson.3
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.google.gson.TypeAdapter
            public Number read(JsonReader jsonReader) throws IOException {
                if (jsonReader.peek() == JsonToken.NULL) {
                    jsonReader.nextNull();
                    return null;
                }
                return Long.valueOf(jsonReader.nextLong());
            }

            @Override // com.google.gson.TypeAdapter
            public void write(JsonWriter jsonWriter, Number number) throws IOException {
                if (number == null) {
                    jsonWriter.nullValue();
                } else {
                    jsonWriter.value(number.toString());
                }
            }
        };
    }

    private static TypeAdapter<AtomicLong> atomicLongAdapter(final TypeAdapter<Number> typeAdapter) {
        return new TypeAdapter<AtomicLong>() { // from class: com.google.gson.Gson.4
            @Override // com.google.gson.TypeAdapter
            public void write(JsonWriter jsonWriter, AtomicLong atomicLong) throws IOException {
                TypeAdapter.this.write(jsonWriter, Long.valueOf(atomicLong.get()));
            }

            @Override // com.google.gson.TypeAdapter
            public AtomicLong read(JsonReader jsonReader) throws IOException {
                return new AtomicLong(((Number) TypeAdapter.this.read(jsonReader)).longValue());
            }
        }.nullSafe();
    }

    private static TypeAdapter<AtomicLongArray> atomicLongArrayAdapter(final TypeAdapter<Number> typeAdapter) {
        return new TypeAdapter<AtomicLongArray>() { // from class: com.google.gson.Gson.5
            @Override // com.google.gson.TypeAdapter
            public void write(JsonWriter jsonWriter, AtomicLongArray atomicLongArray) throws IOException {
                jsonWriter.beginArray();
                int length = atomicLongArray.length();
                for (int i = 0; i < length; i++) {
                    TypeAdapter.this.write(jsonWriter, Long.valueOf(atomicLongArray.get(i)));
                }
                jsonWriter.endArray();
            }

            @Override // com.google.gson.TypeAdapter
            public AtomicLongArray read(JsonReader jsonReader) throws IOException {
                ArrayList arrayList = new ArrayList();
                jsonReader.beginArray();
                while (jsonReader.hasNext()) {
                    arrayList.add(Long.valueOf(((Number) TypeAdapter.this.read(jsonReader)).longValue()));
                }
                jsonReader.endArray();
                int size = arrayList.size();
                AtomicLongArray atomicLongArray = new AtomicLongArray(size);
                for (int i = 0; i < size; i++) {
                    atomicLongArray.set(i, ((Long) arrayList.get(i)).longValue());
                }
                return atomicLongArray;
            }
        }.nullSafe();
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
            throw new IllegalArgumentException("GSON (2.13.1) cannot handle " + typeToken);
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
        StringWriter stringWriter = new StringWriter();
        toJson(obj, type, stringWriter);
        return stringWriter.toString();
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
                    throw new AssertionError("AssertionError (GSON 2.13.1): " + e.getMessage(), e);
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
        StringWriter stringWriter = new StringWriter();
        toJson(jsonElement, (Appendable) stringWriter);
        return stringWriter.toString();
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
                throw new AssertionError("AssertionError (GSON 2.13.1): " + e2.getMessage(), e2);
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
            throw new AssertionError("AssertionError (GSON 2.13.1): " + e5.getMessage(), e5);
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
