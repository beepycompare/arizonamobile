package com.arkivanov.decompose.router.children;

import androidx.exifinterface.media.ExifInterface;
import com.arkivanov.decompose.router.children.ChildItem;
import com.arkivanov.essenty.instancekeeper.InstanceKeeperDispatcher;
import com.arkivanov.essenty.statekeeper.SerializableContainer;
import kotlin.Metadata;
/* compiled from: ChildItemFactory.kt */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b`\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u0002*\n\b\u0001\u0010\u0003 \u0001*\u00020\u00022\u00020\u0002J:\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00052\u0006\u0010\u0006\u001a\u00028\u00002\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\nH¦\u0002¢\u0006\u0002\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/arkivanov/decompose/router/children/ChildItemFactory;", "C", "", ExifInterface.GPS_DIRECTION_TRUE, "invoke", "Lcom/arkivanov/decompose/router/children/ChildItem$Created;", "configuration", "savedState", "Lcom/arkivanov/essenty/statekeeper/SerializableContainer;", "instanceKeeperDispatcher", "Lcom/arkivanov/essenty/instancekeeper/InstanceKeeperDispatcher;", "(Ljava/lang/Object;Lcom/arkivanov/essenty/statekeeper/SerializableContainer;Lcom/arkivanov/essenty/instancekeeper/InstanceKeeperDispatcher;)Lcom/arkivanov/decompose/router/children/ChildItem$Created;", "decompose_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes3.dex */
public interface ChildItemFactory<C, T> {
    ChildItem.Created<C, T> invoke(C c, SerializableContainer serializableContainer, InstanceKeeperDispatcher instanceKeeperDispatcher);

    /* compiled from: ChildItemFactory.kt */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class DefaultImpls {
        public static /* synthetic */ ChildItem.Created invoke$default(ChildItemFactory childItemFactory, Object obj, SerializableContainer serializableContainer, InstanceKeeperDispatcher instanceKeeperDispatcher, int i, Object obj2) {
            if (obj2 == null) {
                if ((i & 2) != 0) {
                    serializableContainer = null;
                }
                if ((i & 4) != 0) {
                    instanceKeeperDispatcher = null;
                }
                return childItemFactory.invoke(obj, serializableContainer, instanceKeeperDispatcher);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: invoke");
        }
    }
}
