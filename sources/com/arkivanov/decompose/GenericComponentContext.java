package com.arkivanov.decompose;

import androidx.exifinterface.media.ExifInterface;
import com.arkivanov.essenty.backhandler.BackHandlerOwner;
import com.arkivanov.essenty.instancekeeper.InstanceKeeperOwner;
import com.arkivanov.essenty.lifecycle.LifecycleOwner;
import com.arkivanov.essenty.statekeeper.StateKeeperOwner;
import kotlin.Metadata;
/* compiled from: GenericComponentContext.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u0000*\n\b\u0000\u0010\u0001 \u0001*\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u00052\u00020\u00062\b\u0012\u0004\u0012\u0002H\u00010\u0007¨\u0006\b"}, d2 = {"Lcom/arkivanov/decompose/GenericComponentContext;", ExifInterface.GPS_DIRECTION_TRUE, "", "Lcom/arkivanov/essenty/lifecycle/LifecycleOwner;", "Lcom/arkivanov/essenty/statekeeper/StateKeeperOwner;", "Lcom/arkivanov/essenty/instancekeeper/InstanceKeeperOwner;", "Lcom/arkivanov/essenty/backhandler/BackHandlerOwner;", "Lcom/arkivanov/decompose/ComponentContextFactoryOwner;", "decompose_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes3.dex */
public interface GenericComponentContext<T> extends LifecycleOwner, StateKeeperOwner, InstanceKeeperOwner, BackHandlerOwner, ComponentContextFactoryOwner<T> {
}
