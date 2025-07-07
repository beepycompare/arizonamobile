package com.arkivanov.decompose.router.panels;

import com.google.android.vending.expansion.downloader.DownloaderClientMarshaller;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
/* compiled from: PanelsNavigator.kt */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bg\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u0002*\b\b\u0001\u0010\u0003*\u00020\u0002*\b\b\u0002\u0010\u0004*\u00020\u00022\u00020\u0002J\u009c\u0001\u0010\u0005\u001a\u00020\u000626\u0010\u0007\u001a2\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\t\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\t0\b2Z\u0010\n\u001aV\u0012%\u0012#\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\t¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000e\u0012%\u0012#\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\t¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000f\u0012\u0004\u0012\u00020\u00060\u000bH&¨\u0006\u0010"}, d2 = {"Lcom/arkivanov/decompose/router/panels/PanelsNavigator;", "MC", "", "DC", "EC", "navigate", "", "transformer", "Lkotlin/Function1;", "Lcom/arkivanov/decompose/router/panels/Panels;", "onComplete", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", DownloaderClientMarshaller.PARAM_NEW_STATE, "oldState", "decompose_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes3.dex */
public interface PanelsNavigator<MC, DC, EC> {
    void navigate(Function1<? super Panels<? extends MC, ? extends DC, ? extends EC>, ? extends Panels<? extends MC, ? extends DC, ? extends EC>> function1, Function2<? super Panels<? extends MC, ? extends DC, ? extends EC>, ? super Panels<? extends MC, ? extends DC, ? extends EC>, Unit> function2);
}
