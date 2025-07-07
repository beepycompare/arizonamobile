package com.google.gson.internal.bind;

import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.google.gson.FieldNamingStrategy;
import com.google.gson.Gson;
import com.google.gson.JsonIOException;
import com.google.gson.JsonParseException;
import com.google.gson.JsonSyntaxException;
import com.google.gson.ReflectionAccessFilter;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.google.gson.internal.ConstructorConstructor;
import com.google.gson.internal.Excluder;
import com.google.gson.internal.GsonTypes;
import com.google.gson.internal.ObjectConstructor;
import com.google.gson.internal.Primitives;
import com.google.gson.internal.ReflectionAccessFilterHelper;
import com.google.gson.internal.TroubleshootingGuide;
import com.google.gson.internal.reflect.ReflectionHelper;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
/* loaded from: classes4.dex */
public final class ReflectiveTypeAdapterFactory implements TypeAdapterFactory {
    private final ConstructorConstructor constructorConstructor;
    private final Excluder excluder;
    private final FieldNamingStrategy fieldNamingPolicy;
    private final JsonAdapterAnnotationTypeAdapterFactory jsonAdapterFactory;
    private final List<ReflectionAccessFilter> reflectionFilters;

    public ReflectiveTypeAdapterFactory(ConstructorConstructor constructorConstructor, FieldNamingStrategy fieldNamingStrategy, Excluder excluder, JsonAdapterAnnotationTypeAdapterFactory jsonAdapterAnnotationTypeAdapterFactory, List<ReflectionAccessFilter> list) {
        this.constructorConstructor = constructorConstructor;
        this.fieldNamingPolicy = fieldNamingStrategy;
        this.excluder = excluder;
        this.jsonAdapterFactory = jsonAdapterAnnotationTypeAdapterFactory;
        this.reflectionFilters = list;
    }

    private boolean includeField(Field field, boolean z) {
        return !this.excluder.excludeField(field, z);
    }

    private List<String> getFieldNames(Field field) {
        String str;
        List<String> list;
        SerializedName serializedName = (SerializedName) field.getAnnotation(SerializedName.class);
        if (serializedName == null) {
            str = this.fieldNamingPolicy.translateName(field);
            list = this.fieldNamingPolicy.alternateNames(field);
        } else {
            String value = serializedName.value();
            List<String> asList = Arrays.asList(serializedName.alternate());
            str = value;
            list = asList;
        }
        if (list.isEmpty()) {
            return Collections.singletonList(str);
        }
        ArrayList arrayList = new ArrayList(list.size() + 1);
        arrayList.add(str);
        arrayList.addAll(list);
        return arrayList;
    }

    @Override // com.google.gson.TypeAdapterFactory
    public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> typeToken) {
        Class<? super T> rawType = typeToken.getRawType();
        if (Object.class.isAssignableFrom(rawType)) {
            if (ReflectionHelper.isAnonymousOrNonStaticLocal(rawType)) {
                return new TypeAdapter<T>() { // from class: com.google.gson.internal.bind.ReflectiveTypeAdapterFactory.1
                    @Override // com.google.gson.TypeAdapter
                    public T read(JsonReader jsonReader) throws IOException {
                        jsonReader.skipValue();
                        return null;
                    }

                    @Override // com.google.gson.TypeAdapter
                    public void write(JsonWriter jsonWriter, T t) throws IOException {
                        jsonWriter.nullValue();
                    }

                    public String toString() {
                        return "AnonymousOrNonStaticLocalClassAdapter";
                    }
                };
            }
            ReflectionAccessFilter.FilterResult filterResult = ReflectionAccessFilterHelper.getFilterResult(this.reflectionFilters, rawType);
            if (filterResult == ReflectionAccessFilter.FilterResult.BLOCK_ALL) {
                throw new JsonIOException("ReflectionAccessFilter does not permit using reflection for " + rawType + ". Register a TypeAdapter for this type or adjust the access filter.");
            }
            boolean z = filterResult == ReflectionAccessFilter.FilterResult.BLOCK_INACCESSIBLE;
            if (ReflectionHelper.isRecord(rawType)) {
                return new RecordAdapter(rawType, getBoundFields(gson, typeToken, rawType, z, true), z);
            }
            return new FieldReflectionAdapter(this.constructorConstructor.get(typeToken, true), getBoundFields(gson, typeToken, rawType, z, false));
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static <M extends AccessibleObject & Member> void checkAccessible(Object obj, M m) {
        if (Modifier.isStatic(m.getModifiers())) {
            obj = null;
        }
        if (ReflectionAccessFilterHelper.canAccess(m, obj)) {
            return;
        }
        throw new JsonIOException(ReflectionHelper.getAccessibleObjectDescription(m, true) + " is not accessible and ReflectionAccessFilter does not permit making it accessible. Register a TypeAdapter for the declaring type, adjust the access filter or increase the visibility of the element and its declaring type.");
    }

    private BoundField createBoundField(Gson gson, Field field, final Method method, String str, TypeToken<?> typeToken, boolean z, final boolean z2) {
        boolean z3;
        final TypeAdapter<?> typeAdapter;
        final boolean isPrimitive = Primitives.isPrimitive(typeToken.getRawType());
        int modifiers = field.getModifiers();
        final boolean z4 = true;
        if (Modifier.isStatic(modifiers) && Modifier.isFinal(modifiers)) {
            z3 = true;
        } else {
            z3 = true;
            z4 = false;
        }
        JsonAdapter jsonAdapter = (JsonAdapter) field.getAnnotation(JsonAdapter.class);
        TypeAdapter<?> typeAdapter2 = jsonAdapter != null ? this.jsonAdapterFactory.getTypeAdapter(this.constructorConstructor, gson, typeToken, jsonAdapter, false) : null;
        boolean z5 = typeAdapter2 != null ? z3 : false;
        if (typeAdapter2 == null) {
            typeAdapter2 = gson.getAdapter(typeToken);
        }
        final TypeAdapter<?> typeAdapter3 = typeAdapter2;
        if (z) {
            typeAdapter = z5 ? typeAdapter3 : new TypeAdapterRuntimeTypeWrapper<>(gson, typeAdapter3, typeToken.getType());
        } else {
            typeAdapter = typeAdapter3;
        }
        return new BoundField(str, field) { // from class: com.google.gson.internal.bind.ReflectiveTypeAdapterFactory.2
            @Override // com.google.gson.internal.bind.ReflectiveTypeAdapterFactory.BoundField
            void write(JsonWriter jsonWriter, Object obj) throws IOException, IllegalAccessException {
                Object obj2;
                if (z2) {
                    Method method2 = method;
                    if (method2 == null) {
                        ReflectiveTypeAdapterFactory.checkAccessible(obj, this.field);
                    } else {
                        ReflectiveTypeAdapterFactory.checkAccessible(obj, method2);
                    }
                }
                Method method3 = method;
                if (method3 != null) {
                    try {
                        obj2 = method3.invoke(obj, new Object[0]);
                    } catch (InvocationTargetException e) {
                        throw new JsonIOException("Accessor " + ReflectionHelper.getAccessibleObjectDescription(method, false) + " threw exception", e.getCause());
                    }
                } else {
                    obj2 = this.field.get(obj);
                }
                if (obj2 == obj) {
                    return;
                }
                jsonWriter.name(this.serializedName);
                typeAdapter.write(jsonWriter, obj2);
            }

            @Override // com.google.gson.internal.bind.ReflectiveTypeAdapterFactory.BoundField
            void readIntoArray(JsonReader jsonReader, int i, Object[] objArr) throws IOException, JsonParseException {
                Object read = typeAdapter3.read(jsonReader);
                if (read == null && isPrimitive) {
                    throw new JsonParseException("null is not allowed as value for record component '" + this.fieldName + "' of primitive type; at path " + jsonReader.getPath());
                }
                objArr[i] = read;
            }

            @Override // com.google.gson.internal.bind.ReflectiveTypeAdapterFactory.BoundField
            void readIntoField(JsonReader jsonReader, Object obj) throws IOException, IllegalAccessException {
                Object read = typeAdapter3.read(jsonReader);
                if (read == null && isPrimitive) {
                    return;
                }
                if (z2) {
                    ReflectiveTypeAdapterFactory.checkAccessible(obj, this.field);
                } else if (z4) {
                    throw new JsonIOException("Cannot set value of 'static final' " + ReflectionHelper.getAccessibleObjectDescription(this.field, false));
                }
                this.field.set(obj, read);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public static class FieldsData {
        public static final FieldsData EMPTY = new FieldsData(Collections.emptyMap(), Collections.emptyList());
        public final Map<String, BoundField> deserializedFields;
        public final List<BoundField> serializedFields;

        public FieldsData(Map<String, BoundField> map, List<BoundField> list) {
            this.deserializedFields = map;
            this.serializedFields = list;
        }
    }

    private static IllegalArgumentException createDuplicateFieldException(Class<?> cls, String str, Field field, Field field2) {
        throw new IllegalArgumentException("Class " + cls.getName() + " declares multiple JSON fields named '" + str + "'; conflict is caused by fields " + ReflectionHelper.fieldToString(field) + " and " + ReflectionHelper.fieldToString(field2) + "\nSee " + TroubleshootingGuide.createUrl("duplicate-fields"));
    }

    /* JADX WARN: Removed duplicated region for block: B:48:0x00fc  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private FieldsData getBoundFields(Gson gson, TypeToken<?> typeToken, Class<?> cls, boolean z, boolean z2) {
        boolean z3;
        TypeToken<?> typeToken2;
        boolean z4;
        String str;
        int i;
        int i2;
        BoundField boundField;
        ReflectiveTypeAdapterFactory reflectiveTypeAdapterFactory = this;
        if (cls.isInterface()) {
            return FieldsData.EMPTY;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        LinkedHashMap linkedHashMap2 = new LinkedHashMap();
        TypeToken<?> typeToken3 = typeToken;
        boolean z5 = z;
        Class<?> cls2 = cls;
        while (cls2 != Object.class) {
            Field[] declaredFields = cls2.getDeclaredFields();
            boolean z6 = true;
            boolean z7 = false;
            if (cls2 != cls && declaredFields.length > 0) {
                ReflectionAccessFilter.FilterResult filterResult = ReflectionAccessFilterHelper.getFilterResult(reflectiveTypeAdapterFactory.reflectionFilters, cls2);
                if (filterResult == ReflectionAccessFilter.FilterResult.BLOCK_ALL) {
                    throw new JsonIOException("ReflectionAccessFilter does not permit using reflection for " + cls2 + " (supertype of " + cls + "). Register a TypeAdapter for this type or adjust the access filter.");
                }
                z5 = filterResult == ReflectionAccessFilter.FilterResult.BLOCK_INACCESSIBLE;
            }
            boolean z8 = z5;
            int length = declaredFields.length;
            int i3 = 0;
            while (i3 < length) {
                int i4 = i3;
                Field field = declaredFields[i4];
                boolean includeField = reflectiveTypeAdapterFactory.includeField(field, z6);
                boolean includeField2 = reflectiveTypeAdapterFactory.includeField(field, z7);
                if (includeField || includeField2) {
                    Method method = null;
                    if (z2) {
                        if (!Modifier.isStatic(field.getModifiers())) {
                            method = ReflectionHelper.getAccessor(cls2, field);
                            if (!z8) {
                                ReflectionHelper.makeAccessible(method);
                            }
                            if (method.getAnnotation(SerializedName.class) != null && field.getAnnotation(SerializedName.class) == null) {
                                throw new JsonIOException("@SerializedName on " + ReflectionHelper.getAccessibleObjectDescription(method, z7) + " is not supported");
                            }
                        } else {
                            z3 = z7;
                            if (!z8 && method == null) {
                                ReflectionHelper.makeAccessible(field);
                            }
                            Type resolve = GsonTypes.resolve(typeToken3.getType(), cls2, field.getGenericType());
                            List<String> fieldNames = reflectiveTypeAdapterFactory.getFieldNames(field);
                            typeToken2 = typeToken3;
                            z4 = false;
                            str = fieldNames.get(0);
                            i = i4;
                            i2 = length;
                            BoundField createBoundField = reflectiveTypeAdapterFactory.createBoundField(gson, field, method, str, TypeToken.get(resolve), includeField, z8);
                            if (z3) {
                                for (String str2 : fieldNames) {
                                    BoundField boundField2 = (BoundField) linkedHashMap.put(str2, createBoundField);
                                    if (boundField2 != null) {
                                        throw createDuplicateFieldException(cls, str2, boundField2.field, field);
                                    }
                                }
                            }
                            if (includeField && (boundField = (BoundField) linkedHashMap2.put(str, createBoundField)) != null) {
                                throw createDuplicateFieldException(cls, str, boundField.field, field);
                            }
                        }
                    }
                    z3 = includeField2;
                    if (!z8) {
                        ReflectionHelper.makeAccessible(field);
                    }
                    Type resolve2 = GsonTypes.resolve(typeToken3.getType(), cls2, field.getGenericType());
                    List<String> fieldNames2 = reflectiveTypeAdapterFactory.getFieldNames(field);
                    typeToken2 = typeToken3;
                    z4 = false;
                    str = fieldNames2.get(0);
                    i = i4;
                    i2 = length;
                    BoundField createBoundField2 = reflectiveTypeAdapterFactory.createBoundField(gson, field, method, str, TypeToken.get(resolve2), includeField, z8);
                    if (z3) {
                    }
                    if (includeField) {
                        throw createDuplicateFieldException(cls, str, boundField.field, field);
                    }
                    continue;
                } else {
                    i2 = length;
                    i = i4;
                    typeToken2 = typeToken3;
                    z4 = z7;
                }
                i3 = i + 1;
                reflectiveTypeAdapterFactory = this;
                z7 = z4;
                typeToken3 = typeToken2;
                length = i2;
                z6 = true;
            }
            typeToken3 = TypeToken.get(GsonTypes.resolve(typeToken3.getType(), cls2, cls2.getGenericSuperclass()));
            cls2 = typeToken3.getRawType();
            reflectiveTypeAdapterFactory = this;
            z5 = z8;
        }
        return new FieldsData(linkedHashMap, new ArrayList(linkedHashMap2.values()));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public static abstract class BoundField {
        final Field field;
        final String fieldName;
        final String serializedName;

        abstract void readIntoArray(JsonReader jsonReader, int i, Object[] objArr) throws IOException, JsonParseException;

        abstract void readIntoField(JsonReader jsonReader, Object obj) throws IOException, IllegalAccessException;

        abstract void write(JsonWriter jsonWriter, Object obj) throws IOException, IllegalAccessException;

        protected BoundField(String str, Field field) {
            this.serializedName = str;
            this.field = field;
            this.fieldName = field.getName();
        }
    }

    /* loaded from: classes4.dex */
    public static abstract class Adapter<T, A> extends TypeAdapter<T> {
        private final FieldsData fieldsData;

        abstract A createAccumulator();

        abstract T finalize(A a2);

        abstract void readField(A a2, JsonReader jsonReader, BoundField boundField) throws IllegalAccessException, IOException;

        Adapter(FieldsData fieldsData) {
            this.fieldsData = fieldsData;
        }

        @Override // com.google.gson.TypeAdapter
        public void write(JsonWriter jsonWriter, T t) throws IOException {
            if (t == null) {
                jsonWriter.nullValue();
                return;
            }
            jsonWriter.beginObject();
            try {
                for (BoundField boundField : this.fieldsData.serializedFields) {
                    boundField.write(jsonWriter, t);
                }
                jsonWriter.endObject();
            } catch (IllegalAccessException e) {
                throw ReflectionHelper.createExceptionForUnexpectedIllegalAccess(e);
            }
        }

        @Override // com.google.gson.TypeAdapter
        public T read(JsonReader jsonReader) throws IOException {
            if (jsonReader.peek() == JsonToken.NULL) {
                jsonReader.nextNull();
                return null;
            }
            A createAccumulator = createAccumulator();
            Map<String, BoundField> map = this.fieldsData.deserializedFields;
            try {
                jsonReader.beginObject();
                while (jsonReader.hasNext()) {
                    BoundField boundField = map.get(jsonReader.nextName());
                    if (boundField == null) {
                        jsonReader.skipValue();
                    } else {
                        readField(createAccumulator, jsonReader, boundField);
                    }
                }
                jsonReader.endObject();
                return finalize(createAccumulator);
            } catch (IllegalAccessException e) {
                throw ReflectionHelper.createExceptionForUnexpectedIllegalAccess(e);
            } catch (IllegalStateException e2) {
                throw new JsonSyntaxException(e2);
            }
        }
    }

    /* loaded from: classes4.dex */
    private static final class FieldReflectionAdapter<T> extends Adapter<T, T> {
        private final ObjectConstructor<T> constructor;

        @Override // com.google.gson.internal.bind.ReflectiveTypeAdapterFactory.Adapter
        T finalize(T t) {
            return t;
        }

        FieldReflectionAdapter(ObjectConstructor<T> objectConstructor, FieldsData fieldsData) {
            super(fieldsData);
            this.constructor = objectConstructor;
        }

        @Override // com.google.gson.internal.bind.ReflectiveTypeAdapterFactory.Adapter
        T createAccumulator() {
            return this.constructor.construct();
        }

        @Override // com.google.gson.internal.bind.ReflectiveTypeAdapterFactory.Adapter
        void readField(T t, JsonReader jsonReader, BoundField boundField) throws IllegalAccessException, IOException {
            boundField.readIntoField(jsonReader, t);
        }
    }

    /* loaded from: classes4.dex */
    private static final class RecordAdapter<T> extends Adapter<T, Object[]> {
        static final Map<Class<?>, Object> PRIMITIVE_DEFAULTS = primitiveDefaults();
        private final Map<String, Integer> componentIndices;
        private final Constructor<T> constructor;
        private final Object[] constructorArgsDefaults;

        RecordAdapter(Class<T> cls, FieldsData fieldsData, boolean z) {
            super(fieldsData);
            this.componentIndices = new HashMap();
            Constructor<T> canonicalRecordConstructor = ReflectionHelper.getCanonicalRecordConstructor(cls);
            this.constructor = canonicalRecordConstructor;
            if (z) {
                ReflectiveTypeAdapterFactory.checkAccessible(null, canonicalRecordConstructor);
            } else {
                ReflectionHelper.makeAccessible(canonicalRecordConstructor);
            }
            String[] recordComponentNames = ReflectionHelper.getRecordComponentNames(cls);
            for (int i = 0; i < recordComponentNames.length; i++) {
                this.componentIndices.put(recordComponentNames[i], Integer.valueOf(i));
            }
            Class<?>[] parameterTypes = this.constructor.getParameterTypes();
            this.constructorArgsDefaults = new Object[parameterTypes.length];
            for (int i2 = 0; i2 < parameterTypes.length; i2++) {
                this.constructorArgsDefaults[i2] = PRIMITIVE_DEFAULTS.get(parameterTypes[i2]);
            }
        }

        private static Map<Class<?>, Object> primitiveDefaults() {
            HashMap hashMap = new HashMap();
            hashMap.put(Byte.TYPE, (byte) 0);
            hashMap.put(Short.TYPE, (short) 0);
            hashMap.put(Integer.TYPE, 0);
            hashMap.put(Long.TYPE, 0L);
            hashMap.put(Float.TYPE, Float.valueOf(0.0f));
            hashMap.put(Double.TYPE, Double.valueOf((double) FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE));
            hashMap.put(Character.TYPE, (char) 0);
            hashMap.put(Boolean.TYPE, false);
            return hashMap;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.gson.internal.bind.ReflectiveTypeAdapterFactory.Adapter
        public Object[] createAccumulator() {
            return (Object[]) this.constructorArgsDefaults.clone();
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.gson.internal.bind.ReflectiveTypeAdapterFactory.Adapter
        public void readField(Object[] objArr, JsonReader jsonReader, BoundField boundField) throws IOException {
            Integer num = this.componentIndices.get(boundField.fieldName);
            if (num == null) {
                throw new IllegalStateException("Could not find the index in the constructor '" + ReflectionHelper.constructorToString(this.constructor) + "' for field with name '" + boundField.fieldName + "', unable to determine which argument in the constructor the field corresponds to. This is unexpected behavior, as we expect the RecordComponents to have the same names as the fields in the Java class, and that the order of the RecordComponents is the same as the order of the canonical constructor parameters.");
            }
            boundField.readIntoArray(jsonReader, num.intValue(), objArr);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.gson.internal.bind.ReflectiveTypeAdapterFactory.Adapter
        public T finalize(Object[] objArr) {
            try {
                return this.constructor.newInstance(objArr);
            } catch (IllegalAccessException e) {
                throw ReflectionHelper.createExceptionForUnexpectedIllegalAccess(e);
            } catch (IllegalArgumentException e2) {
                e = e2;
                throw new RuntimeException("Failed to invoke constructor '" + ReflectionHelper.constructorToString(this.constructor) + "' with args " + Arrays.toString(objArr), e);
            } catch (InstantiationException e3) {
                e = e3;
                throw new RuntimeException("Failed to invoke constructor '" + ReflectionHelper.constructorToString(this.constructor) + "' with args " + Arrays.toString(objArr), e);
            } catch (InvocationTargetException e4) {
                throw new RuntimeException("Failed to invoke constructor '" + ReflectionHelper.constructorToString(this.constructor) + "' with args " + Arrays.toString(objArr), e4.getCause());
            }
        }
    }
}
