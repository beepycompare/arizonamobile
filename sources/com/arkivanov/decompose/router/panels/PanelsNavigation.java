package com.arkivanov.decompose.router.panels;

import com.arkivanov.decompose.router.children.NavigationSource;
import com.arkivanov.decompose.router.panels.PanelsNavigation;
import com.google.android.vending.expansion.downloader.DownloaderClientMarshaller;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: PanelsNavigation.kt */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u0002*\b\b\u0001\u0010\u0003*\u00020\u0002*\b\b\u0002\u0010\u0004*\u00020\u00022\u0014\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u0003\u0012\u0004\u0012\u0002H\u00040\u00052\u001a\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u0003\u0012\u0004\u0012\u0002H\u00040\u00070\u0006:\u0001\b¨\u0006\t"}, d2 = {"Lcom/arkivanov/decompose/router/panels/PanelsNavigation;", "MC", "", "DC", "EC", "Lcom/arkivanov/decompose/router/panels/PanelsNavigator;", "Lcom/arkivanov/decompose/router/children/NavigationSource;", "Lcom/arkivanov/decompose/router/panels/PanelsNavigation$Event;", "Event", "decompose_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes3.dex */
public interface PanelsNavigation<MC, DC, EC> extends PanelsNavigator<MC, DC, EC>, NavigationSource<Event<MC, DC, EC>> {

    /* compiled from: PanelsNavigation.kt */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0007\u0018\u0000*\b\b\u0003\u0010\u0001*\u00020\u0002*\b\b\u0004\u0010\u0003*\u00020\u0002*\b\b\u0005\u0010\u0004*\u00020\u00022\u00020\u0002B\u009d\u0001\u00126\u0010\u0005\u001a2\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00028\u0003\u0012\u0004\u0012\u00028\u0004\u0012\u0004\u0012\u00028\u00050\u0007\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00028\u0003\u0012\u0004\u0012\u00028\u0004\u0012\u0004\u0012\u00028\u00050\u00070\u0006\u0012\\\b\u0002\u0010\b\u001aV\u0012%\u0012#\u0012\u0004\u0012\u00028\u0003\u0012\u0004\u0012\u00028\u0004\u0012\u0004\u0012\u00028\u00050\u0007¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\f\u0012%\u0012#\u0012\u0004\u0012\u00028\u0003\u0012\u0004\u0012\u00028\u0004\u0012\u0004\u0012\u00028\u00050\u0007¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\r\u0012\u0004\u0012\u00020\u000e0\t¢\u0006\u0004\b\u000f\u0010\u0010RA\u0010\u0005\u001a2\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00028\u0003\u0012\u0004\u0012\u00028\u0004\u0012\u0004\u0012\u00028\u00050\u0007\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00028\u0003\u0012\u0004\u0012\u00028\u0004\u0012\u0004\u0012\u00028\u00050\u00070\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012Re\u0010\b\u001aV\u0012%\u0012#\u0012\u0004\u0012\u00028\u0003\u0012\u0004\u0012\u00028\u0004\u0012\u0004\u0012\u00028\u00050\u0007¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\f\u0012%\u0012#\u0012\u0004\u0012\u00028\u0003\u0012\u0004\u0012\u00028\u0004\u0012\u0004\u0012\u00028\u00050\u0007¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\r\u0012\u0004\u0012\u00020\u000e0\t¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2 = {"Lcom/arkivanov/decompose/router/panels/PanelsNavigation$Event;", "MC", "", "DC", "EC", "transformer", "Lkotlin/Function1;", "Lcom/arkivanov/decompose/router/panels/Panels;", "onComplete", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", DownloaderClientMarshaller.PARAM_NEW_STATE, "oldState", "", "<init>", "(Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function2;)V", "getTransformer", "()Lkotlin/jvm/functions/Function1;", "getOnComplete", "()Lkotlin/jvm/functions/Function2;", "decompose_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class Event<MC, DC, EC> {
        private final Function2<Panels<? extends MC, ? extends DC, ? extends EC>, Panels<? extends MC, ? extends DC, ? extends EC>, Unit> onComplete;
        private final Function1<Panels<? extends MC, ? extends DC, ? extends EC>, Panels<MC, DC, EC>> transformer;

        /* JADX WARN: Multi-variable type inference failed */
        public Event(Function1<? super Panels<? extends MC, ? extends DC, ? extends EC>, ? extends Panels<? extends MC, ? extends DC, ? extends EC>> transformer, Function2<? super Panels<? extends MC, ? extends DC, ? extends EC>, ? super Panels<? extends MC, ? extends DC, ? extends EC>, Unit> onComplete) {
            Intrinsics.checkNotNullParameter(transformer, "transformer");
            Intrinsics.checkNotNullParameter(onComplete, "onComplete");
            this.transformer = transformer;
            this.onComplete = onComplete;
        }

        public final Function1<Panels<? extends MC, ? extends DC, ? extends EC>, Panels<MC, DC, EC>> getTransformer() {
            return this.transformer;
        }

        public /* synthetic */ Event(Function1 function1, Function2 function2, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(function1, (i & 2) != 0 ? new Function2() { // from class: com.arkivanov.decompose.router.panels.PanelsNavigation$Event$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit _init_$lambda$0;
                    _init_$lambda$0 = PanelsNavigation.Event._init_$lambda$0((Panels) obj, (Panels) obj2);
                    return _init_$lambda$0;
                }
            } : function2);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit _init_$lambda$0(Panels panels, Panels panels2) {
            Intrinsics.checkNotNullParameter(panels, "<unused var>");
            Intrinsics.checkNotNullParameter(panels2, "<unused var>");
            return Unit.INSTANCE;
        }

        public final Function2<Panels<? extends MC, ? extends DC, ? extends EC>, Panels<? extends MC, ? extends DC, ? extends EC>, Unit> getOnComplete() {
            return this.onComplete;
        }
    }
}
