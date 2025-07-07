package com.arkivanov.essenty.backhandler;

import androidx.activity.OnBackPressedCallback;
import androidx.activity.OnBackPressedDispatcher;
import androidx.activity.OnBackPressedDispatcherOwner;
import androidx.lifecycle.LifecycleOwner;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: AndroidBackHandler.kt */
@Metadata(d1 = {"\u0000$\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\u000e\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003\u001a\u0016\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005\u001a\n\u0010\u0006\u001a\u00020\u0001*\u00020\u0007\u001a\n\u0010\b\u001a\u00020\t*\u00020\n¨\u0006\u000b"}, d2 = {"BackHandler", "Lcom/arkivanov/essenty/backhandler/BackHandler;", "onBackPressedDispatcher", "Landroidx/activity/OnBackPressedDispatcher;", "lifecycleOwner", "Landroidx/lifecycle/LifecycleOwner;", "backHandler", "Landroidx/activity/OnBackPressedDispatcherOwner;", "connectOnBackPressedCallback", "Landroidx/activity/OnBackPressedCallback;", "Lcom/arkivanov/essenty/backhandler/BackDispatcher;", "back-handler_release"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class AndroidBackHandlerKt {
    public static final BackHandler BackHandler(OnBackPressedDispatcher onBackPressedDispatcher) {
        Intrinsics.checkNotNullParameter(onBackPressedDispatcher, "onBackPressedDispatcher");
        BackDispatcher BackDispatcher = BackDispatcherKt.BackDispatcher();
        onBackPressedDispatcher.addCallback(connectOnBackPressedCallback(BackDispatcher));
        return BackDispatcher;
    }

    public static final BackHandler BackHandler(OnBackPressedDispatcher onBackPressedDispatcher, LifecycleOwner lifecycleOwner) {
        Intrinsics.checkNotNullParameter(onBackPressedDispatcher, "onBackPressedDispatcher");
        Intrinsics.checkNotNullParameter(lifecycleOwner, "lifecycleOwner");
        BackDispatcher BackDispatcher = BackDispatcherKt.BackDispatcher();
        onBackPressedDispatcher.addCallback(lifecycleOwner, connectOnBackPressedCallback(BackDispatcher));
        return BackDispatcher;
    }

    public static final BackHandler backHandler(OnBackPressedDispatcherOwner onBackPressedDispatcherOwner) {
        Intrinsics.checkNotNullParameter(onBackPressedDispatcherOwner, "<this>");
        return BackHandler(onBackPressedDispatcherOwner.getOnBackPressedDispatcher());
    }

    public static final OnBackPressedCallback connectOnBackPressedCallback(BackDispatcher backDispatcher) {
        Intrinsics.checkNotNullParameter(backDispatcher, "<this>");
        return new OnBackPressedCallbackAdapter(backDispatcher);
    }
}
