package com.arkivanov.decompose.router.children;

import androidx.core.app.NotificationCompat;
import androidx.exifinterface.media.ExifInterface;
import com.arkivanov.decompose.Child;
import com.arkivanov.decompose.router.children.NavState;
import com.arkivanov.decompose.value.MutableValue;
import com.arkivanov.decompose.value.MutableValueBuilderKt;
import com.google.android.vending.expansion.downloader.DownloaderClientMarshaller;
import com.google.firebase.remoteconfig.RemoteConfigConstants;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: ChildrenFactory.kt */
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\b\u0002\u0018\u0000*\n\b\u0000\u0010\u0001 \u0001*\u00020\u0002*\b\b\u0001\u0010\u0003*\u00020\u0002*\n\b\u0002\u0010\u0004 \u0000*\u00020\u0002*\u000e\b\u0003\u0010\u0005*\b\u0012\u0004\u0012\u0002H\u00010\u0006*\b\b\u0004\u0010\u0007*\u00020\u00022\u00020\u0002Bê\u0002\u0012\u0018\u0010\b\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00030\t\u0012H\u0010\n\u001aD\u0012\u0013\u0012\u00118\u0003¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000e\u0012%\u0012#\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00100\u000f¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u0011\u0012\u0004\u0012\u00028\u00040\u000b\u00126\u0010\u0012\u001a2\u0012\u0013\u0012\u00118\u0003¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000e\u0012\u0013\u0012\u00118\u0002¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u0013\u0012\u0004\u0012\u00028\u00030\u000b\u0012M\u0010\u0014\u001aI\u0012\u0013\u0012\u00118\u0003¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u0016\u0012\u0015\u0012\u0013\u0018\u00018\u0003¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u0017\u0012\u0013\u0012\u00110\u0018¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u0019\u0012\u0004\u0012\u00020\u001a0\u0015\u0012K\u0010\u001b\u001aG\u0012\u0013\u0012\u00118\u0002¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u0013\u0012\u0013\u0012\u00118\u0003¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u0016\u0012\u0013\u0012\u00118\u0003¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u0017\u0012\u0004\u0012\u00020\u001a0\u0015\u0012)\u0010\u001c\u001a%\u0012\u0013\u0012\u00118\u0003¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000e\u0012\f\u0012\n\u0012\u0004\u0012\u00028\u0003\u0018\u00010\u001e0\u001d¢\u0006\u0004\b\u001f\u0010 J\u0013\u0010%\u001a\u00020\u001a2\u0006\u0010\u0013\u001a\u00028\u0002¢\u0006\u0002\u0010&J\u0006\u0010'\u001a\u00020\u001aJ\u001d\u0010(\u001a\u00020\u001a2\u0006\u0010\u0016\u001a\u00028\u00032\u0006\u0010\u0017\u001a\u00028\u0003H\u0002¢\u0006\u0002\u0010)R \u0010\b\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00030\tX\u0082\u0004¢\u0006\u0002\n\u0000RP\u0010\n\u001aD\u0012\u0013\u0012\u00118\u0003¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000e\u0012%\u0012#\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00100\u000f¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u0011\u0012\u0004\u0012\u00028\u00040\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R>\u0010\u0012\u001a2\u0012\u0013\u0012\u00118\u0003¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000e\u0012\u0013\u0012\u00118\u0002¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u0013\u0012\u0004\u0012\u00028\u00030\u000bX\u0082\u0004¢\u0006\u0002\n\u0000RU\u0010\u0014\u001aI\u0012\u0013\u0012\u00118\u0003¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u0016\u0012\u0015\u0012\u0013\u0018\u00018\u0003¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u0017\u0012\u0013\u0012\u00110\u0018¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u0019\u0012\u0004\u0012\u00020\u001a0\u0015X\u0082\u0004¢\u0006\u0002\n\u0000RS\u0010\u001b\u001aG\u0012\u0013\u0012\u00118\u0002¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u0013\u0012\u0013\u0012\u00118\u0003¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u0016\u0012\u0013\u0012\u00118\u0003¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u0017\u0012\u0004\u0012\u00020\u001a0\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R1\u0010\u001c\u001a%\u0012\u0013\u0012\u00118\u0003¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000e\u0012\f\u0012\n\u0012\u0004\u0012\u00028\u0003\u0018\u00010\u001e0\u001dX\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u000e\u001a\b\u0012\u0004\u0012\u00028\u00040!¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010#R\u0016\u0010$\u001a\n\u0012\u0004\u0012\u00028\u0003\u0018\u00010\u001eX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006*"}, d2 = {"Lcom/arkivanov/decompose/router/children/Holder;", "C", "", ExifInterface.GPS_DIRECTION_TRUE, ExifInterface.LONGITUDE_EAST, "N", "Lcom/arkivanov/decompose/router/children/NavState;", ExifInterface.LATITUDE_SOUTH, "navigator", "Lcom/arkivanov/decompose/router/children/ChildrenNavigator;", "stateMapper", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", RemoteConfigConstants.ResponseFieldKey.STATE, "", "Lcom/arkivanov/decompose/Child;", "children", "navTransformer", NotificationCompat.CATEGORY_EVENT, "onStateChanged", "Lkotlin/Function3;", DownloaderClientMarshaller.PARAM_NEW_STATE, "oldState", "", "isBackEnabled", "", "onEventComplete", "backTransformer", "Lkotlin/Function1;", "Lkotlin/Function0;", "<init>", "(Lcom/arkivanov/decompose/router/children/ChildrenNavigator;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function1;)V", "Lcom/arkivanov/decompose/value/MutableValue;", "getState", "()Lcom/arkivanov/decompose/value/MutableValue;", "bt", "navigate", "(Ljava/lang/Object;)V", "back", "onAfterNavigate", "(Lcom/arkivanov/decompose/router/children/NavState;Lcom/arkivanov/decompose/router/children/NavState;)V", "decompose_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes3.dex */
final class Holder<C, T, E, N extends NavState<? extends C>, S> {
    private final Function1<N, Function0<N>> backTransformer;
    private Function0<? extends N> bt;
    private final Function2<N, E, N> navTransformer;
    private final ChildrenNavigator<C, T, N> navigator;
    private final Function3<E, N, N, Unit> onEventComplete;
    private final Function3<N, N, Boolean, Unit> onStateChanged;
    private final MutableValue<S> state;
    private final Function2<N, List<? extends Child<? extends C, ? extends T>>, S> stateMapper;

    /* JADX WARN: Multi-variable type inference failed */
    public Holder(ChildrenNavigator<? extends C, ? extends T, N> navigator, Function2<? super N, ? super List<? extends Child<? extends C, ? extends T>>, ? extends S> stateMapper, Function2<? super N, ? super E, ? extends N> navTransformer, Function3<? super N, ? super N, ? super Boolean, Unit> onStateChanged, Function3<? super E, ? super N, ? super N, Unit> onEventComplete, Function1<? super N, ? extends Function0<? extends N>> backTransformer) {
        Intrinsics.checkNotNullParameter(navigator, "navigator");
        Intrinsics.checkNotNullParameter(stateMapper, "stateMapper");
        Intrinsics.checkNotNullParameter(navTransformer, "navTransformer");
        Intrinsics.checkNotNullParameter(onStateChanged, "onStateChanged");
        Intrinsics.checkNotNullParameter(onEventComplete, "onEventComplete");
        Intrinsics.checkNotNullParameter(backTransformer, "backTransformer");
        this.navigator = navigator;
        this.stateMapper = stateMapper;
        this.navTransformer = navTransformer;
        this.onStateChanged = onStateChanged;
        this.onEventComplete = onEventComplete;
        this.backTransformer = backTransformer;
        this.state = MutableValueBuilderKt.MutableValue(stateMapper.invoke(navigator.getNavState(), navigator.getChildren()));
        this.bt = (Function0) backTransformer.invoke(navigator.getNavState());
        onStateChanged.invoke(navigator.getNavState(), null, Boolean.valueOf(this.bt != null));
    }

    public final MutableValue<S> getState() {
        return this.state;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void navigate(E event) {
        Intrinsics.checkNotNullParameter(event, "event");
        N navState = this.navigator.getNavState();
        ChildrenNavigator<C, T, N> childrenNavigator = this.navigator;
        childrenNavigator.navigate(this.navTransformer.invoke(childrenNavigator.getNavState(), event));
        N navState2 = this.navigator.getNavState();
        onAfterNavigate(navState2, navState);
        this.onEventComplete.invoke(event, navState2, navState);
    }

    public final void back() {
        N invoke;
        Function0<? extends N> function0 = this.bt;
        if (function0 == null || (invoke = function0.invoke()) == null) {
            return;
        }
        N navState = this.navigator.getNavState();
        this.navigator.navigate(invoke);
        onAfterNavigate(this.navigator.getNavState(), navState);
    }

    private final void onAfterNavigate(N n, N n2) {
        this.bt = this.backTransformer.invoke(n);
        this.state.setValue(this.stateMapper.invoke(n, this.navigator.getChildren()));
        this.onStateChanged.invoke(n, n2, Boolean.valueOf(this.bt != null));
    }
}
