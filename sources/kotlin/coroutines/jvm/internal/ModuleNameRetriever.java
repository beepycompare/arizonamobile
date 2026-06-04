package kotlin.coroutines.jvm.internal;

import java.lang.reflect.Method;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: DebugMetadata.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bÀ\u0002\u0018\u00002\u00020\u0001:\u0001\fB\t\bB¢\u0006\u0004\b\u0002\u0010\u0003J\u001c\u0010\u0007\u001a\u0004\u0018\u00010\b2\u000e\u0010\t\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\nH\u0086\u0080\u0004J\u001a\u0010\u000b\u001a\u00020\u00052\u000e\u0010\t\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\nH\u0082\u0080\u0004R\u000f\u0010\u0004\u001a\u00020\u0005X\u0082\u0084\b¢\u0006\u0002\n\u0000R\u0011\u0010\u0006\u001a\u0004\u0018\u00010\u0005X\u0082\u008e\b¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lkotlin/coroutines/jvm/internal/ModuleNameRetriever;", "", "<init>", "()V", "notOnJava9", "Lkotlin/coroutines/jvm/internal/ModuleNameRetriever$Cache;", "cache", "getModuleName", "", "continuation", "Lkotlin/coroutines/Continuation;", "buildCache", "Cache", "kotlin-stdlib"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class ModuleNameRetriever {
    private static Cache cache;
    public static final ModuleNameRetriever INSTANCE = new ModuleNameRetriever();
    private static final Cache notOnJava9 = new Cache(null, null, null);

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: DebugMetadata.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\u00020\u0001B'\bF\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0006\u0010\u0007R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0084\b\u0092\u0002\u0002\b\b¢\u0006\u0002\n\u0000R\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0084\b\u0092\u0002\u0002\b\b¢\u0006\u0002\n\u0000R\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0084\b\u0092\u0002\u0002\b\b¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lkotlin/coroutines/jvm/internal/ModuleNameRetriever$Cache;", "", "getModuleMethod", "Ljava/lang/reflect/Method;", "getDescriptorMethod", "nameMethod", "<init>", "(Ljava/lang/reflect/Method;Ljava/lang/reflect/Method;Ljava/lang/reflect/Method;)V", "Lkotlin/jvm/JvmField;", "kotlin-stdlib"}, k = 1, mv = {2, 4, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Cache {
        public final Method getDescriptorMethod;
        public final Method getModuleMethod;
        public final Method nameMethod;

        public Cache(Method method, Method method2, Method method3) {
            this.getModuleMethod = method;
            this.getDescriptorMethod = method2;
            this.nameMethod = method3;
        }
    }

    private ModuleNameRetriever() {
    }

    public final String getModuleName(Continuation<Object> continuation) {
        Method method;
        Object invoke;
        Method method2;
        Object invoke2;
        Intrinsics.checkNotNullParameter(continuation, "continuation");
        Cache cache2 = cache;
        if (cache2 == null) {
            cache2 = buildCache(continuation);
        }
        if (cache2 != notOnJava9 && (method = cache2.getModuleMethod) != null && (invoke = method.invoke(continuation.getClass(), new Object[0])) != null && (method2 = cache2.getDescriptorMethod) != null && (invoke2 = method2.invoke(invoke, new Object[0])) != null) {
            Method method3 = cache2.nameMethod;
            Object invoke3 = method3 != null ? method3.invoke(invoke2, new Object[0]) : null;
            if (invoke3 instanceof String) {
                return (String) invoke3;
            }
        }
        return null;
    }

    private final Cache buildCache(Continuation<Object> continuation) {
        try {
            Cache cache2 = new Cache(Class.class.getDeclaredMethod("getModule", new Class[0]), continuation.getClass().getClassLoader().loadClass("java.lang.Module").getDeclaredMethod("getDescriptor", new Class[0]), continuation.getClass().getClassLoader().loadClass("java.lang.module.ModuleDescriptor").getDeclaredMethod("name", new Class[0]));
            cache = cache2;
            return cache2;
        } catch (Exception unused) {
            Cache cache3 = notOnJava9;
            cache = cache3;
            return cache3;
        }
    }
}
