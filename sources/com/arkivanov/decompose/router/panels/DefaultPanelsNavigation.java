package com.arkivanov.decompose.router.panels;

import com.arkivanov.decompose.Cancellation;
import com.arkivanov.decompose.Relay;
import com.arkivanov.decompose.router.panels.PanelsNavigation;
import com.google.android.vending.expansion.downloader.DownloaderClientMarshaller;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: DefaultPanelsNavigation.kt */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u0002*\b\b\u0001\u0010\u0003*\u00020\u0002*\b\b\u0002\u0010\u0004*\u00020\u00022\u0014\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u0003\u0012\u0004\u0012\u0002H\u00040\u0005B\u0007¢\u0006\u0004\b\u0006\u0010\u0007J.\u0010\u000b\u001a\u00020\f2$\u0010\r\u001a \u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\n\u0012\u0004\u0012\u00020\u000f0\u000eH\u0016J\u009c\u0001\u0010\u0010\u001a\u00020\u000f26\u0010\u0011\u001a2\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\u0012\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\u00120\u000e2Z\u0010\u0013\u001aV\u0012%\u0012#\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\u0012¢\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\u0017\u0012%\u0012#\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\u0012¢\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\u0018\u0012\u0004\u0012\u00020\u000f0\u0014H\u0016R&\u0010\b\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\n0\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Lcom/arkivanov/decompose/router/panels/DefaultPanelsNavigation;", "MC", "", "DC", "EC", "Lcom/arkivanov/decompose/router/panels/PanelsNavigation;", "<init>", "()V", "relay", "Lcom/arkivanov/decompose/Relay;", "Lcom/arkivanov/decompose/router/panels/PanelsNavigation$Event;", "subscribe", "Lcom/arkivanov/decompose/Cancellation;", "observer", "Lkotlin/Function1;", "", "navigate", "transformer", "Lcom/arkivanov/decompose/router/panels/Panels;", "onComplete", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", DownloaderClientMarshaller.PARAM_NEW_STATE, "oldState", "decompose_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class DefaultPanelsNavigation<MC, DC, EC> implements PanelsNavigation<MC, DC, EC> {
    private final Relay<PanelsNavigation.Event<MC, DC, EC>> relay = new Relay<>();

    @Override // com.arkivanov.decompose.router.children.NavigationSource
    public Cancellation subscribe(Function1<? super PanelsNavigation.Event<MC, DC, EC>, Unit> observer) {
        Intrinsics.checkNotNullParameter(observer, "observer");
        return this.relay.subscribe(observer);
    }

    @Override // com.arkivanov.decompose.router.panels.PanelsNavigator
    public void navigate(Function1<? super Panels<? extends MC, ? extends DC, ? extends EC>, ? extends Panels<? extends MC, ? extends DC, ? extends EC>> transformer, Function2<? super Panels<? extends MC, ? extends DC, ? extends EC>, ? super Panels<? extends MC, ? extends DC, ? extends EC>, Unit> onComplete) {
        Intrinsics.checkNotNullParameter(transformer, "transformer");
        Intrinsics.checkNotNullParameter(onComplete, "onComplete");
        this.relay.accept(new PanelsNavigation.Event<>(transformer, onComplete));
    }
}
