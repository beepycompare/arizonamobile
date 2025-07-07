package kotlinx.serialization;

import androidx.exifinterface.media.ExifInterface;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.WildcardType;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Triple;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlinx.serialization.builtins.BuiltinSerializersKt;
import kotlinx.serialization.internal.PlatformKt;
import kotlinx.serialization.internal.PrimitivesKt;
import kotlinx.serialization.modules.SerializersModule;
import kotlinx.serialization.modules.SerializersModuleBuildersKt;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: SerializersJvm.kt */
@Metadata(d1 = {"\u0000:\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\u0014\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0004\u001a\u0016\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00012\u0006\u0010\u0003\u001a\u00020\u0004\u001a\u0018\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0004\u001a\u001a\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0001*\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0004\u001a+\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0001*\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\b\u001a\u00020\tH\u0002¢\u0006\u0002\b\n\u001a-\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0001*\u00020\u00062\n\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\f2\u0006\u0010\b\u001a\u00020\tH\u0002¢\u0006\u0002\b\r\u001aG\u0010\u000e\u001a\n\u0012\u0004\u0012\u0002H\u000f\u0018\u00010\u0001\"\b\b\u0000\u0010\u000f*\u00020\u0002*\u00020\u00062\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u0002H\u000f0\f2\u0014\u0010\u0011\u001a\u0010\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00010\u0012H\u0002¢\u0006\u0002\b\u0013\u001a)\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0001*\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00152\u0006\u0010\b\u001a\u00020\tH\u0002¢\u0006\u0002\b\u0016\u001a\u0015\u0010\u0017\u001a\u0006\u0012\u0002\b\u00030\f*\u00020\u0004H\u0002¢\u0006\u0002\b\u0018¨\u0006\u0019"}, d2 = {"serializer", "Lkotlinx/serialization/KSerializer;", "", "type", "Ljava/lang/reflect/Type;", "serializerOrNull", "Lkotlinx/serialization/modules/SerializersModule;", "serializerByJavaTypeImpl", "failOnMissingTypeArgSerializer", "", "serializerByJavaTypeImpl$SerializersKt__SerializersJvmKt", "typeSerializer", "Ljava/lang/Class;", "typeSerializer$SerializersKt__SerializersJvmKt", "reflectiveOrContextual", ExifInterface.GPS_DIRECTION_TRUE, "jClass", "typeArgumentsSerializers", "", "reflectiveOrContextual$SerializersKt__SerializersJvmKt", "genericArraySerializer", "Ljava/lang/reflect/GenericArrayType;", "genericArraySerializer$SerializersKt__SerializersJvmKt", "prettyClass", "prettyClass$SerializersKt__SerializersJvmKt", "kotlinx-serialization-core"}, k = 5, mv = {2, 0, 0}, xi = 48, xs = "kotlinx/serialization/SerializersKt")
/* loaded from: classes5.dex */
public final /* synthetic */ class SerializersKt__SerializersJvmKt {
    public static final KSerializer<Object> serializer(Type type) {
        Intrinsics.checkNotNullParameter(type, "type");
        return SerializersKt.serializer(SerializersModuleBuildersKt.EmptySerializersModule(), type);
    }

    public static final KSerializer<Object> serializerOrNull(Type type) {
        Intrinsics.checkNotNullParameter(type, "type");
        return SerializersKt.serializerOrNull(SerializersModuleBuildersKt.EmptySerializersModule(), type);
    }

    public static final KSerializer<Object> serializer(SerializersModule serializersModule, Type type) {
        Intrinsics.checkNotNullParameter(serializersModule, "<this>");
        Intrinsics.checkNotNullParameter(type, "type");
        KSerializer<Object> serializerByJavaTypeImpl$SerializersKt__SerializersJvmKt = serializerByJavaTypeImpl$SerializersKt__SerializersJvmKt(serializersModule, type, true);
        if (serializerByJavaTypeImpl$SerializersKt__SerializersJvmKt != null) {
            return serializerByJavaTypeImpl$SerializersKt__SerializersJvmKt;
        }
        PlatformKt.serializerNotRegistered(prettyClass$SerializersKt__SerializersJvmKt(type));
        throw new KotlinNothingValueException();
    }

    public static final KSerializer<Object> serializerOrNull(SerializersModule serializersModule, Type type) {
        Intrinsics.checkNotNullParameter(serializersModule, "<this>");
        Intrinsics.checkNotNullParameter(type, "type");
        return serializerByJavaTypeImpl$SerializersKt__SerializersJvmKt(serializersModule, type, false);
    }

    static /* synthetic */ KSerializer serializerByJavaTypeImpl$SerializersKt__SerializersJvmKt$default(SerializersModule serializersModule, Type type, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = true;
        }
        return serializerByJavaTypeImpl$SerializersKt__SerializersJvmKt(serializersModule, type, z);
    }

    private static final KSerializer<Object> serializerByJavaTypeImpl$SerializersKt__SerializersJvmKt(SerializersModule serializersModule, Type type, boolean z) {
        ArrayList arrayList;
        if (type instanceof GenericArrayType) {
            return genericArraySerializer$SerializersKt__SerializersJvmKt(serializersModule, (GenericArrayType) type, z);
        }
        if (type instanceof Class) {
            return typeSerializer$SerializersKt__SerializersJvmKt(serializersModule, (Class) type, z);
        }
        if (type instanceof ParameterizedType) {
            ParameterizedType parameterizedType = (ParameterizedType) type;
            Type rawType = parameterizedType.getRawType();
            Intrinsics.checkNotNull(rawType, "null cannot be cast to non-null type java.lang.Class<*>");
            Class cls = (Class) rawType;
            Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
            Intrinsics.checkNotNull(actualTypeArguments);
            if (z) {
                arrayList = new ArrayList(actualTypeArguments.length);
                for (Type type2 : actualTypeArguments) {
                    Intrinsics.checkNotNull(type2);
                    arrayList.add(SerializersKt.serializer(serializersModule, type2));
                }
            } else {
                arrayList = new ArrayList(actualTypeArguments.length);
                for (Type type3 : actualTypeArguments) {
                    Intrinsics.checkNotNull(type3);
                    KSerializer<Object> serializerOrNull = SerializersKt.serializerOrNull(serializersModule, type3);
                    if (serializerOrNull == null) {
                        return null;
                    }
                    arrayList.add(serializerOrNull);
                }
            }
            ArrayList arrayList2 = arrayList;
            if (Set.class.isAssignableFrom(cls)) {
                KSerializer<Object> SetSerializer = BuiltinSerializersKt.SetSerializer((KSerializer) arrayList2.get(0));
                Intrinsics.checkNotNull(SetSerializer, "null cannot be cast to non-null type kotlinx.serialization.KSerializer<kotlin.Any>");
                return SetSerializer;
            } else if (List.class.isAssignableFrom(cls) || Collection.class.isAssignableFrom(cls)) {
                KSerializer<Object> ListSerializer = BuiltinSerializersKt.ListSerializer((KSerializer) arrayList2.get(0));
                Intrinsics.checkNotNull(ListSerializer, "null cannot be cast to non-null type kotlinx.serialization.KSerializer<kotlin.Any>");
                return ListSerializer;
            } else if (Map.class.isAssignableFrom(cls)) {
                KSerializer<Object> MapSerializer = BuiltinSerializersKt.MapSerializer((KSerializer) arrayList2.get(0), (KSerializer) arrayList2.get(1));
                Intrinsics.checkNotNull(MapSerializer, "null cannot be cast to non-null type kotlinx.serialization.KSerializer<kotlin.Any>");
                return MapSerializer;
            } else if (Map.Entry.class.isAssignableFrom(cls)) {
                KSerializer<Object> MapEntrySerializer = BuiltinSerializersKt.MapEntrySerializer((KSerializer) arrayList2.get(0), (KSerializer) arrayList2.get(1));
                Intrinsics.checkNotNull(MapEntrySerializer, "null cannot be cast to non-null type kotlinx.serialization.KSerializer<kotlin.Any>");
                return MapEntrySerializer;
            } else if (Pair.class.isAssignableFrom(cls)) {
                KSerializer<Object> PairSerializer = BuiltinSerializersKt.PairSerializer((KSerializer) arrayList2.get(0), (KSerializer) arrayList2.get(1));
                Intrinsics.checkNotNull(PairSerializer, "null cannot be cast to non-null type kotlinx.serialization.KSerializer<kotlin.Any>");
                return PairSerializer;
            } else if (Triple.class.isAssignableFrom(cls)) {
                KSerializer<Object> TripleSerializer = BuiltinSerializersKt.TripleSerializer((KSerializer) arrayList2.get(0), (KSerializer) arrayList2.get(1), (KSerializer) arrayList2.get(2));
                Intrinsics.checkNotNull(TripleSerializer, "null cannot be cast to non-null type kotlinx.serialization.KSerializer<kotlin.Any>");
                return TripleSerializer;
            } else {
                ArrayList<KSerializer> arrayList3 = arrayList2;
                ArrayList arrayList4 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList3, 10));
                for (KSerializer kSerializer : arrayList3) {
                    Intrinsics.checkNotNull(kSerializer, "null cannot be cast to non-null type kotlinx.serialization.KSerializer<kotlin.Any?>");
                    arrayList4.add(kSerializer);
                }
                return reflectiveOrContextual$SerializersKt__SerializersJvmKt(serializersModule, cls, arrayList4);
            }
        } else if (type instanceof WildcardType) {
            Type[] upperBounds = ((WildcardType) type).getUpperBounds();
            Intrinsics.checkNotNullExpressionValue(upperBounds, "getUpperBounds(...)");
            Object first = ArraysKt.first(upperBounds);
            Intrinsics.checkNotNullExpressionValue(first, "first(...)");
            return serializerByJavaTypeImpl$SerializersKt__SerializersJvmKt$default(serializersModule, (Type) first, false, 2, null);
        } else {
            throw new IllegalArgumentException("type should be an instance of Class<?>, GenericArrayType, ParametrizedType or WildcardType, but actual argument " + type + " has type " + Reflection.getOrCreateKotlinClass(type.getClass()));
        }
    }

    private static final KSerializer<Object> typeSerializer$SerializersKt__SerializersJvmKt(SerializersModule serializersModule, Class<?> cls, boolean z) {
        KSerializer<Object> serializerOrNull;
        if (cls.isArray() && !cls.getComponentType().isPrimitive()) {
            Class<?> componentType = cls.getComponentType();
            Intrinsics.checkNotNullExpressionValue(componentType, "getComponentType(...)");
            if (z) {
                serializerOrNull = SerializersKt.serializer(serializersModule, componentType);
            } else {
                serializerOrNull = SerializersKt.serializerOrNull(serializersModule, componentType);
                if (serializerOrNull == null) {
                    return null;
                }
            }
            KClass kotlinClass = JvmClassMappingKt.getKotlinClass(componentType);
            Intrinsics.checkNotNull(kotlinClass, "null cannot be cast to non-null type kotlin.reflect.KClass<kotlin.Any>");
            KSerializer<Object> ArraySerializer = BuiltinSerializersKt.ArraySerializer(kotlinClass, serializerOrNull);
            Intrinsics.checkNotNull(ArraySerializer, "null cannot be cast to non-null type kotlinx.serialization.KSerializer<kotlin.Any>");
            return ArraySerializer;
        }
        Intrinsics.checkNotNull(cls, "null cannot be cast to non-null type java.lang.Class<kotlin.Any>");
        return reflectiveOrContextual$SerializersKt__SerializersJvmKt(serializersModule, cls, CollectionsKt.emptyList());
    }

    private static final <T> KSerializer<T> reflectiveOrContextual$SerializersKt__SerializersJvmKt(SerializersModule serializersModule, Class<T> cls, List<? extends KSerializer<Object>> list) {
        KSerializer[] kSerializerArr = (KSerializer[]) list.toArray(new KSerializer[0]);
        KSerializer<T> constructSerializerForGivenTypeArgs = PlatformKt.constructSerializerForGivenTypeArgs(cls, (KSerializer[]) Arrays.copyOf(kSerializerArr, kSerializerArr.length));
        if (constructSerializerForGivenTypeArgs != null) {
            return constructSerializerForGivenTypeArgs;
        }
        KClass<T> kotlinClass = JvmClassMappingKt.getKotlinClass(cls);
        KSerializer<T> builtinSerializerOrNull = PrimitivesKt.builtinSerializerOrNull(kotlinClass);
        if (builtinSerializerOrNull == null) {
            KSerializer<T> contextual = serializersModule.getContextual(kotlinClass, list);
            if (contextual == null) {
                if (cls.isInterface()) {
                    return new PolymorphicSerializer(JvmClassMappingKt.getKotlinClass(cls));
                }
                return null;
            }
            return contextual;
        }
        return builtinSerializerOrNull;
    }

    private static final KSerializer<Object> genericArraySerializer$SerializersKt__SerializersJvmKt(SerializersModule serializersModule, GenericArrayType genericArrayType, boolean z) {
        KSerializer<Object> serializerOrNull;
        KClass kClass;
        Type genericComponentType = genericArrayType.getGenericComponentType();
        if (genericComponentType instanceof WildcardType) {
            Type[] upperBounds = ((WildcardType) genericComponentType).getUpperBounds();
            Intrinsics.checkNotNullExpressionValue(upperBounds, "getUpperBounds(...)");
            genericComponentType = (Type) ArraysKt.first(upperBounds);
        }
        Intrinsics.checkNotNull(genericComponentType);
        if (z) {
            serializerOrNull = SerializersKt.serializer(serializersModule, genericComponentType);
        } else {
            serializerOrNull = SerializersKt.serializerOrNull(serializersModule, genericComponentType);
            if (serializerOrNull == null) {
                return null;
            }
        }
        if (genericComponentType instanceof ParameterizedType) {
            Type rawType = ((ParameterizedType) genericComponentType).getRawType();
            Intrinsics.checkNotNull(rawType, "null cannot be cast to non-null type java.lang.Class<*>");
            kClass = JvmClassMappingKt.getKotlinClass((Class) rawType);
        } else if (!(genericComponentType instanceof KClass)) {
            throw new IllegalStateException("unsupported type in GenericArray: " + Reflection.getOrCreateKotlinClass(genericComponentType.getClass()));
        } else {
            kClass = (KClass) genericComponentType;
        }
        Intrinsics.checkNotNull(kClass, "null cannot be cast to non-null type kotlin.reflect.KClass<kotlin.Any>");
        KSerializer<Object> ArraySerializer = BuiltinSerializersKt.ArraySerializer(kClass, serializerOrNull);
        Intrinsics.checkNotNull(ArraySerializer, "null cannot be cast to non-null type kotlinx.serialization.KSerializer<kotlin.Any>");
        return ArraySerializer;
    }

    private static final Class<?> prettyClass$SerializersKt__SerializersJvmKt(Type type) {
        if (type instanceof Class) {
            return (Class) type;
        }
        if (type instanceof ParameterizedType) {
            Type rawType = ((ParameterizedType) type).getRawType();
            Intrinsics.checkNotNullExpressionValue(rawType, "getRawType(...)");
            return prettyClass$SerializersKt__SerializersJvmKt(rawType);
        } else if (type instanceof WildcardType) {
            Type[] upperBounds = ((WildcardType) type).getUpperBounds();
            Intrinsics.checkNotNullExpressionValue(upperBounds, "getUpperBounds(...)");
            Object first = ArraysKt.first(upperBounds);
            Intrinsics.checkNotNullExpressionValue(first, "first(...)");
            return prettyClass$SerializersKt__SerializersJvmKt((Type) first);
        } else if (type instanceof GenericArrayType) {
            Type genericComponentType = ((GenericArrayType) type).getGenericComponentType();
            Intrinsics.checkNotNullExpressionValue(genericComponentType, "getGenericComponentType(...)");
            return prettyClass$SerializersKt__SerializersJvmKt(genericComponentType);
        } else {
            throw new IllegalArgumentException("type should be an instance of Class<?>, GenericArrayType, ParametrizedType or WildcardType, but actual argument " + type + " has type " + Reflection.getOrCreateKotlinClass(type.getClass()));
        }
    }
}
