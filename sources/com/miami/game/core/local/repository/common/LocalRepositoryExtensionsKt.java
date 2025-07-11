package com.miami.game.core.local.repository.common;

import androidx.exifinterface.media.ExifInterface;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: LocalRepositoryExtensions.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\u001a\u0011\u0010\u0000\u001a\u00020\u0001\"\u0006\b\u0000\u0010\u0002\u0018\u0001H\u0086\b\u001a.\u0010\u0003\u001a\u0004\u0018\u0001H\u0002\"\n\b\u0000\u0010\u0002\u0018\u0001*\u00020\u0004*\b\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010\u0007\u001a\u00020\u0006H\u0086H¢\u0006\u0002\u0010\b\u001a.\u0010\t\u001a\u0004\u0018\u0001H\n\"\n\b\u0000\u0010\n\u0018\u0001*\u00020\u0004*\b\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010\u0007\u001a\u00020\u0006H\u0086H¢\u0006\u0002\u0010\b¨\u0006\u000b"}, d2 = {"getType", "Ljava/lang/reflect/Type;", ExifInterface.GPS_DIRECTION_TRUE, "get", "", "Lcom/miami/game/core/local/repository/common/IKeyValueRepository;", "", "key", "(Lcom/miami/game/core/local/repository/common/IKeyValueRepository;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getSuspend", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "local-repository_release_web"}, k = 2, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class LocalRepositoryExtensionsKt {
    public static final /* synthetic */ <T> Type getType() {
        Intrinsics.needClassReification();
        Type type = new TypeToken<T>() { // from class: com.miami.game.core.local.repository.common.LocalRepositoryExtensionsKt$getType$1
        }.getType();
        Intrinsics.checkNotNullExpressionValue(type, "getType(...)");
        return type;
    }

    /*  JADX ERROR: IndexOutOfBoundsException in pass: MarkMethodsForInline
        java.lang.IndexOutOfBoundsException: Index: 0
        	at java.base/java.util.Collections$EmptyList.get(Collections.java:4586)
        	at jadx.core.dex.nodes.InsnNode.getArg(InsnNode.java:104)
        	at jadx.core.dex.visitors.MarkMethodsForInline.isSyntheticAccessPattern(MarkMethodsForInline.java:117)
        	at jadx.core.dex.visitors.MarkMethodsForInline.inlineMth(MarkMethodsForInline.java:86)
        	at jadx.core.dex.visitors.MarkMethodsForInline.process(MarkMethodsForInline.java:53)
        	at jadx.core.dex.visitors.MarkMethodsForInline.visit(MarkMethodsForInline.java:37)
        */
    public static final /* synthetic */ <V> java.lang.Object getSuspend(com.miami.game.core.local.repository.common.IKeyValueRepository<java.lang.String> r3, java.lang.String r4, kotlin.coroutines.Continuation<? super V> r5) {
        /*
            kotlinx.coroutines.CoroutineDispatcher r0 = kotlinx.coroutines.Dispatchers.getIO()
            kotlin.coroutines.CoroutineContext r0 = (kotlin.coroutines.CoroutineContext) r0
            kotlin.jvm.internal.Intrinsics.needClassReification()
            com.miami.game.core.local.repository.common.LocalRepositoryExtensionsKt$getSuspend$2 r1 = new com.miami.game.core.local.repository.common.LocalRepositoryExtensionsKt$getSuspend$2
            r2 = 0
            r1.<init>(r3, r4, r2)
            kotlin.jvm.functions.Function2 r1 = (kotlin.jvm.functions.Function2) r1
            java.lang.Object r3 = kotlinx.coroutines.BuildersKt.withContext(r0, r1, r5)
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.miami.game.core.local.repository.common.LocalRepositoryExtensionsKt.getSuspend(com.miami.game.core.local.repository.common.IKeyValueRepository, java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final /* synthetic */ <T> Object get(IKeyValueRepository<String> iKeyValueRepository, String str, Continuation<? super T> continuation) {
        Intrinsics.needClassReification();
        Type type = new TypeToken<T>() { // from class: com.miami.game.core.local.repository.common.LocalRepositoryExtensionsKt$get$$inlined$getType$1
        }.getType();
        Intrinsics.checkNotNullExpressionValue(type, "getType(...)");
        return iKeyValueRepository.get(str, type, continuation);
    }
}
