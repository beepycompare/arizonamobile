package com.arkivanov.decompose;

import androidx.exifinterface.media.ExifInterface;
import com.arkivanov.essenty.backhandler.BackHandler;
import com.arkivanov.essenty.instancekeeper.InstanceKeeper;
import com.arkivanov.essenty.lifecycle.Lifecycle;
import com.arkivanov.essenty.statekeeper.StateKeeper;
import kotlin.Metadata;
/* compiled from: ComponentContextFactory.kt */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bæ\u0080\u0001\u0018\u0000*\n\b\u0000\u0010\u0001 \u0001*\u00020\u00022\u00020\u0002J.\u0010\u0003\u001a\u00028\u00002\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH¦\u0002¢\u0006\u0002\u0010\f¨\u0006\r"}, d2 = {"Lcom/arkivanov/decompose/ComponentContextFactory;", ExifInterface.GPS_DIRECTION_TRUE, "", "invoke", "lifecycle", "Lcom/arkivanov/essenty/lifecycle/Lifecycle;", "stateKeeper", "Lcom/arkivanov/essenty/statekeeper/StateKeeper;", "instanceKeeper", "Lcom/arkivanov/essenty/instancekeeper/InstanceKeeper;", "backHandler", "Lcom/arkivanov/essenty/backhandler/BackHandler;", "(Lcom/arkivanov/essenty/lifecycle/Lifecycle;Lcom/arkivanov/essenty/statekeeper/StateKeeper;Lcom/arkivanov/essenty/instancekeeper/InstanceKeeper;Lcom/arkivanov/essenty/backhandler/BackHandler;)Ljava/lang/Object;", "decompose_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes3.dex */
public interface ComponentContextFactory<T> {
    T invoke(Lifecycle lifecycle, StateKeeper stateKeeper, InstanceKeeper instanceKeeper, BackHandler backHandler);
}
