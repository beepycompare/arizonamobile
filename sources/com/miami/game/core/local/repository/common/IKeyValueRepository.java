package com.miami.game.core.local.repository.common;

import androidx.exifinterface.media.ExifInterface;
import java.lang.reflect.Type;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
/* compiled from: IKeyValueRepository.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\bf\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002J&\u0010\u0003\u001a\u00020\u0004\"\u0004\b\u0001\u0010\u00052\u0006\u0010\u0006\u001a\u00028\u00002\b\u0010\u0007\u001a\u0004\u0018\u0001H\u0005H¦@¢\u0006\u0002\u0010\bJ*\u0010\t\u001a\u0004\u0018\u0001H\u0005\"\b\b\u0001\u0010\u0005*\u00020\u00022\u0006\u0010\u0006\u001a\u00028\u00002\u0006\u0010\n\u001a\u00020\u000bH¦@¢\u0006\u0002\u0010\fJ\u0016\u0010\r\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00028\u0000H¦@¢\u0006\u0002\u0010\u000eJ\u0016\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0006\u001a\u00028\u0000H¦@¢\u0006\u0002\u0010\u000e¨\u0006\u0011"}, d2 = {"Lcom/miami/game/core/local/repository/common/IKeyValueRepository;", "K", "", "save", "", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "key", "value", "(Ljava/lang/Object;Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "get", "t", "Ljava/lang/reflect/Type;", "(Ljava/lang/Object;Ljava/lang/reflect/Type;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "remove", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "has", "", "local-repository_release_web"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes4.dex */
public interface IKeyValueRepository<K> {
    <V> Object get(K k, Type type, Continuation<? super V> continuation);

    Object has(K k, Continuation<? super Boolean> continuation);

    Object remove(K k, Continuation<? super Unit> continuation);

    <V> Object save(K k, V v, Continuation<? super Unit> continuation);
}
