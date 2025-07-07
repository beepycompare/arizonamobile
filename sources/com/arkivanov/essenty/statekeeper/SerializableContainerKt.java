package com.arkivanov.essenty.statekeeper;

import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.DeserializationStrategy;
import kotlinx.serialization.SerializationStrategy;
/* compiled from: SerializableContainer.kt */
@Metadata(d1 = {"\u0000 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a-\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u0001H\u00022\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0006¢\u0006\u0002\u0010\u0007\u001a'\u0010\b\u001a\u0002H\u0002\"\b\b\u0000\u0010\u0002*\u00020\u0003*\u00020\u00012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u0002H\u00020\t¢\u0006\u0002\u0010\n¨\u0006\u000b"}, d2 = {"SerializableContainer", "Lcom/arkivanov/essenty/statekeeper/SerializableContainer;", ExifInterface.GPS_DIRECTION_TRUE, "", "value", "strategy", "Lkotlinx/serialization/SerializationStrategy;", "(Ljava/lang/Object;Lkotlinx/serialization/SerializationStrategy;)Lcom/arkivanov/essenty/statekeeper/SerializableContainer;", "consumeRequired", "Lkotlinx/serialization/DeserializationStrategy;", "(Lcom/arkivanov/essenty/statekeeper/SerializableContainer;Lkotlinx/serialization/DeserializationStrategy;)Ljava/lang/Object;", "state-keeper_release"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class SerializableContainerKt {
    public static final <T> SerializableContainer SerializableContainer(T t, SerializationStrategy<? super T> strategy) {
        Intrinsics.checkNotNullParameter(strategy, "strategy");
        SerializableContainer serializableContainer = new SerializableContainer();
        serializableContainer.set(t, strategy);
        return serializableContainer;
    }

    public static final <T> T consumeRequired(SerializableContainer serializableContainer, DeserializationStrategy<? extends T> strategy) {
        Intrinsics.checkNotNullParameter(serializableContainer, "<this>");
        Intrinsics.checkNotNullParameter(strategy, "strategy");
        T t = (T) serializableContainer.consume(strategy);
        if (t != null) {
            return t;
        }
        throw new IllegalStateException("Required value was null.".toString());
    }
}
