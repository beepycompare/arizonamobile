package com.arkivanov.decompose.router.children;

import androidx.exifinterface.media.ExifInterface;
import com.arkivanov.essenty.statekeeper.SerializableContainer;
import com.arkivanov.essenty.statekeeper.SerializableContainerKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
/* compiled from: NavStateSaver.kt */
@Metadata(d1 = {"\u0000 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u001aL\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u00032\u0016\b\u0004\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u0002H\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u00052\u0016\b\u0004\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u0001H\u00020\u0005H\u0087\bø\u0001\u0000\u001a&\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u00032\f\u0010\b\u001a\b\u0012\u0004\u0012\u0002H\u00020\tH\u0007\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\n"}, d2 = {"NavStateSaver", "Lcom/arkivanov/decompose/router/children/NavStateSaver;", ExifInterface.GPS_DIRECTION_TRUE, "", "save", "Lkotlin/Function1;", "Lcom/arkivanov/essenty/statekeeper/SerializableContainer;", "restore", "serializer", "Lkotlinx/serialization/KSerializer;", "decompose_release"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class NavStateSaverKt {
    public static final <T> NavStateSaver<T> NavStateSaver(final Function1<? super T, SerializableContainer> save, final Function1<? super SerializableContainer, ? extends T> restore) {
        Intrinsics.checkNotNullParameter(save, "save");
        Intrinsics.checkNotNullParameter(restore, "restore");
        return new NavStateSaver<T>() { // from class: com.arkivanov.decompose.router.children.NavStateSaverKt$NavStateSaver$1
            @Override // com.arkivanov.decompose.router.children.NavStateSaver
            public SerializableContainer saveState(T state) {
                Intrinsics.checkNotNullParameter(state, "state");
                return save.invoke(state);
            }

            @Override // com.arkivanov.decompose.router.children.NavStateSaver
            public T restoreState(SerializableContainer container) {
                Intrinsics.checkNotNullParameter(container, "container");
                return restore.invoke(container);
            }
        };
    }

    public static final <T> NavStateSaver<T> NavStateSaver(final KSerializer<T> serializer) {
        Intrinsics.checkNotNullParameter(serializer, "serializer");
        return new NavStateSaver<T>() { // from class: com.arkivanov.decompose.router.children.NavStateSaverKt$NavStateSaver$$inlined$NavStateSaver$1
            @Override // com.arkivanov.decompose.router.children.NavStateSaver
            public SerializableContainer saveState(T state) {
                Intrinsics.checkNotNullParameter(state, "state");
                return SerializableContainerKt.SerializableContainer(state, KSerializer.this);
            }

            @Override // com.arkivanov.decompose.router.children.NavStateSaver
            public T restoreState(SerializableContainer container) {
                Intrinsics.checkNotNullParameter(container, "container");
                return (T) container.consume(serializer);
            }
        };
    }
}
