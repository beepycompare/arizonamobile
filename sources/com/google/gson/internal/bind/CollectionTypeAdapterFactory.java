package com.google.gson.internal.bind;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.internal.ConstructorConstructor;
import com.google.gson.internal.GsonTypes;
import com.google.gson.internal.ObjectConstructor;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.Collection;
/* loaded from: classes4.dex */
public final class CollectionTypeAdapterFactory implements TypeAdapterFactory {
    private final ConstructorConstructor constructorConstructor;

    public CollectionTypeAdapterFactory(ConstructorConstructor constructorConstructor) {
        this.constructorConstructor = constructorConstructor;
    }

    @Override // com.google.gson.TypeAdapterFactory
    public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> typeToken) {
        Type type = typeToken.getType();
        Class<? super T> rawType = typeToken.getRawType();
        if (Collection.class.isAssignableFrom(rawType)) {
            Type collectionElementType = GsonTypes.getCollectionElementType(type, rawType);
            return new Adapter(new TypeAdapterRuntimeTypeWrapper(gson, gson.getAdapter(TypeToken.get(collectionElementType)), collectionElementType), this.constructorConstructor.get(typeToken, false));
        }
        return null;
    }

    /* loaded from: classes4.dex */
    private static final class Adapter<E> extends TypeAdapter<Collection<E>> {
        private final ObjectConstructor<? extends Collection<E>> constructor;
        private final TypeAdapter<E> elementTypeAdapter;

        @Override // com.google.gson.TypeAdapter
        public /* bridge */ /* synthetic */ void write(JsonWriter jsonWriter, Object obj) throws IOException {
            write(jsonWriter, (Collection) ((Collection) obj));
        }

        public Adapter(TypeAdapter<E> typeAdapter, ObjectConstructor<? extends Collection<E>> objectConstructor) {
            this.elementTypeAdapter = typeAdapter;
            this.constructor = objectConstructor;
        }

        @Override // com.google.gson.TypeAdapter
        public Collection<E> read(JsonReader jsonReader) throws IOException {
            if (jsonReader.peek() == JsonToken.NULL) {
                jsonReader.nextNull();
                return null;
            }
            Collection<E> construct = this.constructor.construct();
            jsonReader.beginArray();
            while (jsonReader.hasNext()) {
                construct.add(this.elementTypeAdapter.read(jsonReader));
            }
            jsonReader.endArray();
            return construct;
        }

        public void write(JsonWriter jsonWriter, Collection<E> collection) throws IOException {
            if (collection == null) {
                jsonWriter.nullValue();
                return;
            }
            jsonWriter.beginArray();
            for (E e : collection) {
                this.elementTypeAdapter.write(jsonWriter, e);
            }
            jsonWriter.endArray();
        }
    }
}
