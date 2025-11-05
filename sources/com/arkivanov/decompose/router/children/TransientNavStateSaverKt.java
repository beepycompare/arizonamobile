package com.arkivanov.decompose.router.children;

import androidx.exifinterface.media.ExifInterface;
import com.arkivanov.essenty.statekeeper.SerializableContainer;
import com.arkivanov.essenty.statekeeper.SerializableContainerKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: TransientNavStateSaver.kt */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\u001a\u0018\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003H\u0007¨\u0006\u0004"}, d2 = {"transientNavStateSaver", "Lcom/arkivanov/decompose/router/children/NavStateSaver;", ExifInterface.GPS_DIRECTION_TRUE, "", "decompose_release"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class TransientNavStateSaverKt {
    public static final <T> NavStateSaver<T> transientNavStateSaver() {
        return new NavStateSaver<T>() { // from class: com.arkivanov.decompose.router.children.TransientNavStateSaverKt$transientNavStateSaver$$inlined$NavStateSaver$1
            @Override // com.arkivanov.decompose.router.children.NavStateSaver
            public SerializableContainer saveState(T state) {
                Intrinsics.checkNotNullParameter(state, "state");
                return SerializableContainerKt.SerializableContainer(new TransientSavedState(state), TransientSavedState.Companion.serializer());
            }

            @Override // com.arkivanov.decompose.router.children.NavStateSaver
            public T restoreState(SerializableContainer container) {
                Intrinsics.checkNotNullParameter(container, "container");
                TransientSavedState transientSavedState = (TransientSavedState) container.consume(TransientSavedState.Companion.serializer());
                if (transientSavedState != null) {
                    return (T) transientSavedState.getValue();
                }
                return null;
            }
        };
    }
}
