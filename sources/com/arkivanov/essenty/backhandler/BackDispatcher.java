package com.arkivanov.essenty.backhandler;

import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
/* compiled from: BackDispatcher.kt */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J+\u0010\u0005\u001a\u00020\u00062!\u0010\u0007\u001a\u001d\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u0002\u0012\u0004\u0012\u00020\u00060\bH&J+\u0010\u000b\u001a\u00020\u00062!\u0010\u0007\u001a\u001d\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u0002\u0012\u0004\u0012\u00020\u00060\bH&J\b\u0010\f\u001a\u00020\u0003H&J\u0010\u0010\r\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u000fH&J\u0010\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u000fH&J\b\u0010\u0011\u001a\u00020\u0006H&R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0002\u0010\u0004¨\u0006\u0012"}, d2 = {"Lcom/arkivanov/essenty/backhandler/BackDispatcher;", "Lcom/arkivanov/essenty/backhandler/BackHandler;", "isEnabled", "", "()Z", "addEnabledChangedListener", "", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "removeEnabledChangedListener", "back", "startPredictiveBack", "backEvent", "Lcom/arkivanov/essenty/backhandler/BackEvent;", "progressPredictiveBack", "cancelPredictiveBack", "back-handler_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes3.dex */
public interface BackDispatcher extends BackHandler {
    void addEnabledChangedListener(Function1<? super Boolean, Unit> function1);

    boolean back();

    void cancelPredictiveBack();

    boolean isEnabled();

    void progressPredictiveBack(BackEvent backEvent);

    void removeEnabledChangedListener(Function1<? super Boolean, Unit> function1);

    boolean startPredictiveBack(BackEvent backEvent);
}
