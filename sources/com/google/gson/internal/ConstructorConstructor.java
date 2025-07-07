package com.google.gson.internal;

import com.google.gson.InstanceCreator;
import com.google.gson.JsonIOException;
import com.google.gson.ReflectionAccessFilter;
import com.google.gson.internal.reflect.ReflectionHelper;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Modifier;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.EnumMap;
import java.util.EnumSet;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentSkipListMap;
/* loaded from: classes4.dex */
public final class ConstructorConstructor {
    private final Map<Type, InstanceCreator<?>> instanceCreators;
    private final List<ReflectionAccessFilter> reflectionFilters;
    private final boolean useJdkUnsafe;

    public ConstructorConstructor(Map<Type, InstanceCreator<?>> map, boolean z, List<ReflectionAccessFilter> list) {
        this.instanceCreators = map;
        this.useJdkUnsafe = z;
        this.reflectionFilters = list;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String checkInstantiable(Class<?> cls) {
        int modifiers = cls.getModifiers();
        if (Modifier.isInterface(modifiers)) {
            return "Interfaces can't be instantiated! Register an InstanceCreator or a TypeAdapter for this type. Interface name: " + cls.getName();
        }
        if (Modifier.isAbstract(modifiers)) {
            return "Abstract classes can't be instantiated! Adjust the R8 configuration or register an InstanceCreator or a TypeAdapter for this type. Class name: " + cls.getName() + "\nSee " + TroubleshootingGuide.createUrl("r8-abstract-class");
        }
        return null;
    }

    public <T> ObjectConstructor<T> get(TypeToken<T> typeToken) {
        return get(typeToken, true);
    }

    public <T> ObjectConstructor<T> get(TypeToken<T> typeToken, boolean z) {
        final Type type = typeToken.getType();
        Class<? super T> rawType = typeToken.getRawType();
        final InstanceCreator<?> instanceCreator = this.instanceCreators.get(type);
        if (instanceCreator != null) {
            return new ObjectConstructor() { // from class: com.google.gson.internal.ConstructorConstructor$$ExternalSyntheticLambda0
                @Override // com.google.gson.internal.ObjectConstructor
                public final Object construct() {
                    Object createInstance;
                    createInstance = InstanceCreator.this.createInstance(type);
                    return createInstance;
                }
            };
        }
        final InstanceCreator<?> instanceCreator2 = this.instanceCreators.get(rawType);
        if (instanceCreator2 != null) {
            return new ObjectConstructor() { // from class: com.google.gson.internal.ConstructorConstructor$$ExternalSyntheticLambda11
                @Override // com.google.gson.internal.ObjectConstructor
                public final Object construct() {
                    Object createInstance;
                    createInstance = InstanceCreator.this.createInstance(type);
                    return createInstance;
                }
            };
        }
        ObjectConstructor<T> newSpecialCollectionConstructor = newSpecialCollectionConstructor(type, rawType);
        if (newSpecialCollectionConstructor != null) {
            return newSpecialCollectionConstructor;
        }
        ReflectionAccessFilter.FilterResult filterResult = ReflectionAccessFilterHelper.getFilterResult(this.reflectionFilters, rawType);
        ObjectConstructor<T> newDefaultConstructor = newDefaultConstructor(rawType, filterResult);
        if (newDefaultConstructor != null) {
            return newDefaultConstructor;
        }
        ObjectConstructor<T> newDefaultImplementationConstructor = newDefaultImplementationConstructor(type, rawType);
        if (newDefaultImplementationConstructor != null) {
            return newDefaultImplementationConstructor;
        }
        final String checkInstantiable = checkInstantiable(rawType);
        if (checkInstantiable != null) {
            return new ObjectConstructor() { // from class: com.google.gson.internal.ConstructorConstructor$$ExternalSyntheticLambda13
                @Override // com.google.gson.internal.ObjectConstructor
                public final Object construct() {
                    return ConstructorConstructor.lambda$get$2(checkInstantiable);
                }
            };
        }
        if (!z) {
            final String str = "Unable to create instance of " + rawType + "; Register an InstanceCreator or a TypeAdapter for this type.";
            return new ObjectConstructor() { // from class: com.google.gson.internal.ConstructorConstructor$$ExternalSyntheticLambda14
                @Override // com.google.gson.internal.ObjectConstructor
                public final Object construct() {
                    return ConstructorConstructor.lambda$get$3(str);
                }
            };
        } else if (filterResult != ReflectionAccessFilter.FilterResult.ALLOW) {
            final String str2 = "Unable to create instance of " + rawType + "; ReflectionAccessFilter does not permit using reflection or Unsafe. Register an InstanceCreator or a TypeAdapter for this type or adjust the access filter to allow using reflection.";
            return new ObjectConstructor() { // from class: com.google.gson.internal.ConstructorConstructor$$ExternalSyntheticLambda15
                @Override // com.google.gson.internal.ObjectConstructor
                public final Object construct() {
                    return ConstructorConstructor.lambda$get$4(str2);
                }
            };
        } else {
            return newUnsafeAllocator(rawType);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ Object lambda$get$2(String str) {
        throw new JsonIOException(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ Object lambda$get$3(String str) {
        throw new JsonIOException(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ Object lambda$get$4(String str) {
        throw new JsonIOException(str);
    }

    private static <T> ObjectConstructor<T> newSpecialCollectionConstructor(final Type type, Class<? super T> cls) {
        if (EnumSet.class.isAssignableFrom(cls)) {
            return new ObjectConstructor() { // from class: com.google.gson.internal.ConstructorConstructor$$ExternalSyntheticLambda2
                @Override // com.google.gson.internal.ObjectConstructor
                public final Object construct() {
                    return ConstructorConstructor.lambda$newSpecialCollectionConstructor$5(type);
                }
            };
        }
        if (cls == EnumMap.class) {
            return new ObjectConstructor() { // from class: com.google.gson.internal.ConstructorConstructor$$ExternalSyntheticLambda3
                @Override // com.google.gson.internal.ObjectConstructor
                public final Object construct() {
                    return ConstructorConstructor.lambda$newSpecialCollectionConstructor$6(type);
                }
            };
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ Object lambda$newSpecialCollectionConstructor$5(Type type) {
        if (type instanceof ParameterizedType) {
            Type type2 = ((ParameterizedType) type).getActualTypeArguments()[0];
            if (type2 instanceof Class) {
                return EnumSet.noneOf((Class) type2);
            }
            throw new JsonIOException("Invalid EnumSet type: " + type.toString());
        }
        throw new JsonIOException("Invalid EnumSet type: " + type.toString());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ Object lambda$newSpecialCollectionConstructor$6(Type type) {
        if (type instanceof ParameterizedType) {
            Type type2 = ((ParameterizedType) type).getActualTypeArguments()[0];
            if (type2 instanceof Class) {
                return new EnumMap((Class) type2);
            }
            throw new JsonIOException("Invalid EnumMap type: " + type.toString());
        }
        throw new JsonIOException("Invalid EnumMap type: " + type.toString());
    }

    private static <T> ObjectConstructor<T> newDefaultConstructor(Class<? super T> cls, ReflectionAccessFilter.FilterResult filterResult) {
        final String tryMakeAccessible;
        if (Modifier.isAbstract(cls.getModifiers())) {
            return null;
        }
        try {
            final Constructor<? super T> declaredConstructor = cls.getDeclaredConstructor(new Class[0]);
            if (filterResult != ReflectionAccessFilter.FilterResult.ALLOW && (!ReflectionAccessFilterHelper.canAccess(declaredConstructor, null) || (filterResult == ReflectionAccessFilter.FilterResult.BLOCK_ALL && !Modifier.isPublic(declaredConstructor.getModifiers())))) {
                final String str = "Unable to invoke no-args constructor of " + cls + "; constructor is not accessible and ReflectionAccessFilter does not permit making it accessible. Register an InstanceCreator or a TypeAdapter for this type, change the visibility of the constructor or adjust the access filter.";
                return new ObjectConstructor() { // from class: com.google.gson.internal.ConstructorConstructor$$ExternalSyntheticLambda9
                    @Override // com.google.gson.internal.ObjectConstructor
                    public final Object construct() {
                        return ConstructorConstructor.lambda$newDefaultConstructor$7(str);
                    }
                };
            } else if (filterResult == ReflectionAccessFilter.FilterResult.ALLOW && (tryMakeAccessible = ReflectionHelper.tryMakeAccessible(declaredConstructor)) != null) {
                return new ObjectConstructor() { // from class: com.google.gson.internal.ConstructorConstructor$$ExternalSyntheticLambda10
                    @Override // com.google.gson.internal.ObjectConstructor
                    public final Object construct() {
                        return ConstructorConstructor.lambda$newDefaultConstructor$8(tryMakeAccessible);
                    }
                };
            } else {
                return new ObjectConstructor() { // from class: com.google.gson.internal.ConstructorConstructor$$ExternalSyntheticLambda12
                    @Override // com.google.gson.internal.ObjectConstructor
                    public final Object construct() {
                        return ConstructorConstructor.lambda$newDefaultConstructor$9(declaredConstructor);
                    }
                };
            }
        } catch (NoSuchMethodException unused) {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ Object lambda$newDefaultConstructor$7(String str) {
        throw new JsonIOException(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ Object lambda$newDefaultConstructor$8(String str) {
        throw new JsonIOException(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ Object lambda$newDefaultConstructor$9(Constructor constructor) {
        try {
            return constructor.newInstance(new Object[0]);
        } catch (IllegalAccessException e) {
            throw ReflectionHelper.createExceptionForUnexpectedIllegalAccess(e);
        } catch (InstantiationException e2) {
            throw new RuntimeException("Failed to invoke constructor '" + ReflectionHelper.constructorToString(constructor) + "' with no args", e2);
        } catch (InvocationTargetException e3) {
            throw new RuntimeException("Failed to invoke constructor '" + ReflectionHelper.constructorToString(constructor) + "' with no args", e3.getCause());
        }
    }

    private static <T> ObjectConstructor<T> newDefaultImplementationConstructor(Type type, Class<? super T> cls) {
        if (Collection.class.isAssignableFrom(cls)) {
            return (ObjectConstructor<T>) newCollectionConstructor(cls);
        }
        if (Map.class.isAssignableFrom(cls)) {
            return (ObjectConstructor<T>) newMapConstructor(type, cls);
        }
        return null;
    }

    private static ObjectConstructor<? extends Collection<? extends Object>> newCollectionConstructor(Class<?> cls) {
        if (cls.isAssignableFrom(ArrayList.class)) {
            return new ObjectConstructor() { // from class: com.google.gson.internal.ConstructorConstructor$$ExternalSyntheticLambda16
                @Override // com.google.gson.internal.ObjectConstructor
                public final Object construct() {
                    return ConstructorConstructor.lambda$newCollectionConstructor$10();
                }
            };
        }
        if (cls.isAssignableFrom(LinkedHashSet.class)) {
            return new ObjectConstructor() { // from class: com.google.gson.internal.ConstructorConstructor$$ExternalSyntheticLambda17
                @Override // com.google.gson.internal.ObjectConstructor
                public final Object construct() {
                    return ConstructorConstructor.lambda$newCollectionConstructor$11();
                }
            };
        }
        if (cls.isAssignableFrom(TreeSet.class)) {
            return new ObjectConstructor() { // from class: com.google.gson.internal.ConstructorConstructor$$ExternalSyntheticLambda18
                @Override // com.google.gson.internal.ObjectConstructor
                public final Object construct() {
                    return ConstructorConstructor.lambda$newCollectionConstructor$12();
                }
            };
        }
        if (cls.isAssignableFrom(ArrayDeque.class)) {
            return new ObjectConstructor() { // from class: com.google.gson.internal.ConstructorConstructor$$ExternalSyntheticLambda19
                @Override // com.google.gson.internal.ObjectConstructor
                public final Object construct() {
                    return ConstructorConstructor.lambda$newCollectionConstructor$13();
                }
            };
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ Collection lambda$newCollectionConstructor$10() {
        return new ArrayList();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ Collection lambda$newCollectionConstructor$11() {
        return new LinkedHashSet();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ Collection lambda$newCollectionConstructor$12() {
        return new TreeSet();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ Collection lambda$newCollectionConstructor$13() {
        return new ArrayDeque();
    }

    private static boolean hasStringKeyType(Type type) {
        if (type instanceof ParameterizedType) {
            Type[] actualTypeArguments = ((ParameterizedType) type).getActualTypeArguments();
            return actualTypeArguments.length != 0 && GsonTypes.getRawType(actualTypeArguments[0]) == String.class;
        }
        return true;
    }

    private static ObjectConstructor<? extends Map<? extends Object, Object>> newMapConstructor(Type type, Class<?> cls) {
        if (cls.isAssignableFrom(LinkedTreeMap.class) && hasStringKeyType(type)) {
            return new ObjectConstructor() { // from class: com.google.gson.internal.ConstructorConstructor$$ExternalSyntheticLambda4
                @Override // com.google.gson.internal.ObjectConstructor
                public final Object construct() {
                    return ConstructorConstructor.lambda$newMapConstructor$14();
                }
            };
        }
        if (cls.isAssignableFrom(LinkedHashMap.class)) {
            return new ObjectConstructor() { // from class: com.google.gson.internal.ConstructorConstructor$$ExternalSyntheticLambda5
                @Override // com.google.gson.internal.ObjectConstructor
                public final Object construct() {
                    return ConstructorConstructor.lambda$newMapConstructor$15();
                }
            };
        }
        if (cls.isAssignableFrom(TreeMap.class)) {
            return new ObjectConstructor() { // from class: com.google.gson.internal.ConstructorConstructor$$ExternalSyntheticLambda6
                @Override // com.google.gson.internal.ObjectConstructor
                public final Object construct() {
                    return ConstructorConstructor.lambda$newMapConstructor$16();
                }
            };
        }
        if (cls.isAssignableFrom(ConcurrentHashMap.class)) {
            return new ObjectConstructor() { // from class: com.google.gson.internal.ConstructorConstructor$$ExternalSyntheticLambda7
                @Override // com.google.gson.internal.ObjectConstructor
                public final Object construct() {
                    return ConstructorConstructor.lambda$newMapConstructor$17();
                }
            };
        }
        if (cls.isAssignableFrom(ConcurrentSkipListMap.class)) {
            return new ObjectConstructor() { // from class: com.google.gson.internal.ConstructorConstructor$$ExternalSyntheticLambda8
                @Override // com.google.gson.internal.ObjectConstructor
                public final Object construct() {
                    return ConstructorConstructor.lambda$newMapConstructor$18();
                }
            };
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ Map lambda$newMapConstructor$14() {
        return new LinkedTreeMap();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ Map lambda$newMapConstructor$15() {
        return new LinkedHashMap();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ Map lambda$newMapConstructor$16() {
        return new TreeMap();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ Map lambda$newMapConstructor$17() {
        return new ConcurrentHashMap();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ Map lambda$newMapConstructor$18() {
        return new ConcurrentSkipListMap();
    }

    private <T> ObjectConstructor<T> newUnsafeAllocator(final Class<? super T> cls) {
        if (this.useJdkUnsafe) {
            return new ObjectConstructor() { // from class: com.google.gson.internal.ConstructorConstructor$$ExternalSyntheticLambda20
                @Override // com.google.gson.internal.ObjectConstructor
                public final Object construct() {
                    return ConstructorConstructor.lambda$newUnsafeAllocator$19(cls);
                }
            };
        }
        final String str = "Unable to create instance of " + cls + "; usage of JDK Unsafe is disabled. Registering an InstanceCreator or a TypeAdapter for this type, adding a no-args constructor, or enabling usage of JDK Unsafe may fix this problem.";
        if (cls.getDeclaredConstructors().length == 0) {
            str = str + " Or adjust your R8 configuration to keep the no-args constructor of the class.";
        }
        return new ObjectConstructor() { // from class: com.google.gson.internal.ConstructorConstructor$$ExternalSyntheticLambda1
            @Override // com.google.gson.internal.ObjectConstructor
            public final Object construct() {
                return ConstructorConstructor.lambda$newUnsafeAllocator$20(str);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ Object lambda$newUnsafeAllocator$19(Class cls) {
        try {
            return UnsafeAllocator.INSTANCE.newInstance(cls);
        } catch (Exception e) {
            throw new RuntimeException("Unable to create instance of " + cls + ". Registering an InstanceCreator or a TypeAdapter for this type, or adding a no-args constructor may fix this problem.", e);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ Object lambda$newUnsafeAllocator$20(String str) {
        throw new JsonIOException(str);
    }

    public String toString() {
        return this.instanceCreators.toString();
    }
}
