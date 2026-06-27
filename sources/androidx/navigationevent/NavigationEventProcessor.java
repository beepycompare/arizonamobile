package androidx.navigationevent;

import androidx.navigationevent.NavigationEventTransitionState;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.ArrayDeque;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.StateFlowKt;
/* compiled from: NavigationEventProcessor.kt */
@Metadata(d1 = {"\u0000\u0080\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010#\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010!\u001a\u00020\"J\u001b\u0010#\u001a\u00020\"2\f\u0010$\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0011H\u0000¢\u0006\u0002\b%J$\u0010&\u001a\u00020\"2\u0006\u0010'\u001a\u00020(2\n\u0010$\u001a\u0006\u0012\u0002\b\u00030\u00112\b\b\u0002\u0010)\u001a\u00020\u0015J\u0012\u0010*\u001a\u00020\"2\n\u0010$\u001a\u0006\u0012\u0002\b\u00030\u0011J\u001e\u0010+\u001a\u00020\"2\u0006\u0010'\u001a\u00020(2\u0006\u0010,\u001a\u00020\u00182\u0006\u0010)\u001a\u00020\u0015J\u000e\u0010-\u001a\u00020\"2\u0006\u0010,\u001a\u00020\u0018J\"\u0010.\u001a\u00020\"2\u0006\u0010,\u001a\u00020\u00182\u0006\u0010/\u001a\u00020\u00152\n\b\u0002\u00100\u001a\u0004\u0018\u000101J\u001e\u00102\u001a\u00020\"2\u0006\u0010,\u001a\u00020\u00182\u0006\u0010/\u001a\u00020\u00152\u0006\u00100\u001a\u000201J \u00103\u001a\u00020\"2\u0006\u0010,\u001a\u00020\u00182\u0006\u0010/\u001a\u00020\u00152\b\u00104\u001a\u0004\u0018\u000105J\u0016\u00106\u001a\u00020\"2\u0006\u0010,\u001a\u00020\u00182\u0006\u0010/\u001a\u00020\u0015J\u0018\u00107\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u00112\b\b\u0002\u0010/\u001a\u00020\u0015H\u0002J'\u00108\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u00112\u0016\u00109\u001a\u0012\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0011\u0012\u0004\u0012\u00020\u001e0:H\u0082\bJ\u000e\u0010;\u001a\b\u0012\u0004\u0012\u00020=0<H\u0002R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\b¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\b¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\nR\u0018\u0010\u000f\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00110\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u0018\u0010\u0012\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00110\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0013\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0014\u001a\u00020\u0015X\u0082\u000e¢\u0006\b\n\u0000\u0012\u0004\b\u0016\u0010\u0003R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00180\u001aX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00180\u001aX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00180\u001aX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u001eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u001eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\u001eX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006>"}, d2 = {"Landroidx/navigationevent/NavigationEventProcessor;", "", "<init>", "()V", "_transitionState", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Landroidx/navigationevent/NavigationEventTransitionState;", "transitionState", "Lkotlinx/coroutines/flow/StateFlow;", "getTransitionState", "()Lkotlinx/coroutines/flow/StateFlow;", "_history", "Landroidx/navigationevent/NavigationEventHistory;", "history", "getHistory", "overlayHandlers", "Lkotlin/collections/ArrayDeque;", "Landroidx/navigationevent/NavigationEventHandler;", "defaultHandlers", "inProgressHandler", "inProgressDirection", "", "getInProgressDirection$annotations", "inProgressInput", "Landroidx/navigationevent/NavigationEventInput;", "unspecifiedInputs", "", "defaultInputs", "overlayInputs", "hasEnabledDefaultHandlers", "", "hasEnabledOverlayHandlers", "hasEnabledAnyHandlers", "refreshEnabledHandlers", "", "updateEnabledHandlerInfo", "handler", "updateEnabledHandlerInfo$navigationevent", "addHandler", "dispatcher", "Landroidx/navigationevent/NavigationEventDispatcher;", "priority", "removeHandler", "addInput", "input", "removeInput", "dispatchOnStarted", "direction", "event", "Landroidx/navigationevent/NavigationEvent;", "dispatchOnProgressed", "dispatchOnCompleted", "onBackCompletedFallback", "Landroidx/navigationevent/OnBackCompletedFallback;", "dispatchOnCancelled", "resolveEnabledHandler", "findHandler", "predicate", "Lkotlin/Function1;", "resolveCombinedBackInfo", "", "Landroidx/navigationevent/NavigationEventInfo;", "navigationevent"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class NavigationEventProcessor {
    private final MutableStateFlow<NavigationEventHistory> _history;
    private final MutableStateFlow<NavigationEventTransitionState> _transitionState;
    private final ArrayDeque<NavigationEventHandler<?>> defaultHandlers;
    private final Set<NavigationEventInput> defaultInputs;
    private boolean hasEnabledAnyHandlers;
    private boolean hasEnabledDefaultHandlers;
    private boolean hasEnabledOverlayHandlers;
    private final StateFlow<NavigationEventHistory> history;
    private int inProgressDirection;
    private NavigationEventHandler<?> inProgressHandler;
    private NavigationEventInput inProgressInput;
    private final ArrayDeque<NavigationEventHandler<?>> overlayHandlers;
    private final Set<NavigationEventInput> overlayInputs;
    private final StateFlow<NavigationEventTransitionState> transitionState;
    private final Set<NavigationEventInput> unspecifiedInputs;

    private static /* synthetic */ void getInProgressDirection$annotations() {
    }

    public NavigationEventProcessor() {
        MutableStateFlow<NavigationEventTransitionState> MutableStateFlow = StateFlowKt.MutableStateFlow(NavigationEventTransitionState.Idle.INSTANCE);
        this._transitionState = MutableStateFlow;
        this.transitionState = FlowKt.asStateFlow(MutableStateFlow);
        MutableStateFlow<NavigationEventHistory> MutableStateFlow2 = StateFlowKt.MutableStateFlow(new NavigationEventHistory());
        this._history = MutableStateFlow2;
        this.history = FlowKt.asStateFlow(MutableStateFlow2);
        this.overlayHandlers = new ArrayDeque<>();
        this.defaultHandlers = new ArrayDeque<>();
        this.unspecifiedInputs = new LinkedHashSet();
        this.defaultInputs = new LinkedHashSet();
        this.overlayInputs = new LinkedHashSet();
    }

    public final StateFlow<NavigationEventTransitionState> getTransitionState() {
        return this.transitionState;
    }

    public final StateFlow<NavigationEventHistory> getHistory() {
        return this.history;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x001f  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x004f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void refreshEnabledHandlers() {
        boolean z;
        boolean z2;
        ArrayDeque<NavigationEventHandler<?>> arrayDeque = this.overlayHandlers;
        if (!(arrayDeque instanceof Collection) || !arrayDeque.isEmpty()) {
            for (NavigationEventHandler<?> navigationEventHandler : arrayDeque) {
                if (navigationEventHandler.isBackEnabled() || navigationEventHandler.isForwardEnabled()) {
                    z = true;
                    break;
                }
                while (r0.hasNext()) {
                }
            }
        }
        z = false;
        ArrayDeque<NavigationEventHandler<?>> arrayDeque2 = this.defaultHandlers;
        if (!(arrayDeque2 instanceof Collection) || !arrayDeque2.isEmpty()) {
            for (NavigationEventHandler<?> navigationEventHandler2 : arrayDeque2) {
                if (navigationEventHandler2.isBackEnabled() || navigationEventHandler2.isForwardEnabled()) {
                    z2 = true;
                    break;
                }
                while (r1.hasNext()) {
                }
            }
        }
        z2 = false;
        boolean z3 = z || z2;
        boolean z4 = this.hasEnabledOverlayHandlers != z;
        boolean z5 = this.hasEnabledDefaultHandlers != z2;
        boolean z6 = this.hasEnabledAnyHandlers != z3;
        if (z4) {
            for (NavigationEventInput navigationEventInput : this.overlayInputs) {
                navigationEventInput.doOnHasEnabledHandlersChanged$navigationevent(z);
            }
        }
        if (z5) {
            for (NavigationEventInput navigationEventInput2 : this.defaultInputs) {
                navigationEventInput2.doOnHasEnabledHandlersChanged$navigationevent(z2);
            }
        }
        if (z6) {
            for (NavigationEventInput navigationEventInput3 : this.unspecifiedInputs) {
                navigationEventInput3.doOnHasEnabledHandlersChanged$navigationevent(z3);
            }
        }
        this.hasEnabledOverlayHandlers = z;
        this.hasEnabledDefaultHandlers = z2;
        this.hasEnabledAnyHandlers = z3;
        NavigationEventHandler<?> navigationEventHandler3 = this.inProgressHandler;
        if (navigationEventHandler3 == null) {
            navigationEventHandler3 = resolveEnabledHandler$default(this, 0, 1, null);
        }
        updateEnabledHandlerInfo$navigationevent(navigationEventHandler3);
    }

    /* JADX WARN: Type inference failed for: r1v0, types: [androidx.navigationevent.NavigationEventInfo] */
    public final void updateEnabledHandlerInfo$navigationevent(NavigationEventHandler<?> navigationEventHandler) {
        NavigationEventHistory navigationEventHistory;
        NavigationEventHandler<?> navigationEventHandler2 = this.inProgressHandler;
        if (navigationEventHandler2 == null) {
            navigationEventHandler2 = resolveEnabledHandler$default(this, 0, 1, null);
        }
        if (Intrinsics.areEqual(navigationEventHandler2, navigationEventHandler)) {
            if (navigationEventHandler2 == null) {
                navigationEventHistory = new NavigationEventHistory();
            } else {
                navigationEventHistory = new NavigationEventHistory(navigationEventHandler2.getCurrentInfo(), resolveCombinedBackInfo(), navigationEventHandler2.getForwardInfo());
            }
            if (Intrinsics.areEqual(this._history.getValue(), navigationEventHistory)) {
                return;
            }
            this._history.setValue(navigationEventHistory);
            for (NavigationEventInput navigationEventInput : this.overlayInputs) {
                navigationEventInput.doOnHistoryChanged$navigationevent(navigationEventHistory);
            }
            for (NavigationEventInput navigationEventInput2 : this.defaultInputs) {
                navigationEventInput2.doOnHistoryChanged$navigationevent(navigationEventHistory);
            }
            for (NavigationEventInput navigationEventInput3 : this.unspecifiedInputs) {
                navigationEventInput3.doOnHistoryChanged$navigationevent(navigationEventHistory);
            }
        }
    }

    public static /* synthetic */ void addHandler$default(NavigationEventProcessor navigationEventProcessor, NavigationEventDispatcher navigationEventDispatcher, NavigationEventHandler navigationEventHandler, int i, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            i = 1;
        }
        navigationEventProcessor.addHandler(navigationEventDispatcher, navigationEventHandler, i);
    }

    public final void addHandler(NavigationEventDispatcher dispatcher, NavigationEventHandler<?> handler, int i) {
        Intrinsics.checkNotNullParameter(dispatcher, "dispatcher");
        Intrinsics.checkNotNullParameter(handler, "handler");
        if (handler.getDispatcher$navigationevent() != null) {
            throw new IllegalArgumentException(("Handler '" + handler + "' is already registered with a dispatcher").toString());
        }
        if (i == 0) {
            this.overlayHandlers.addFirst(handler);
        } else if (i == 1) {
            this.defaultHandlers.addFirst(handler);
        } else {
            throw new IllegalArgumentException("Unsupported priority value: " + i);
        }
        handler.setDispatcher$navigationevent(dispatcher);
        refreshEnabledHandlers();
    }

    public final void removeHandler(NavigationEventHandler<?> handler) {
        Intrinsics.checkNotNullParameter(handler, "handler");
        if (Intrinsics.areEqual(handler, this.inProgressHandler)) {
            int i = this.inProgressDirection;
            if (i == -1) {
                handler.doOnBackCancelled$navigationevent();
            } else if (i == 1) {
                handler.doOnForwardCancelled$navigationevent();
            }
            this.inProgressHandler = null;
            this.inProgressDirection = 0;
            this.inProgressInput = null;
        }
        this.overlayHandlers.remove(handler);
        this.defaultHandlers.remove(handler);
        handler.setDispatcher$navigationevent(null);
        refreshEnabledHandlers();
    }

    public final void addInput(NavigationEventDispatcher dispatcher, NavigationEventInput input, int i) {
        Set<NavigationEventInput> set;
        boolean z;
        Intrinsics.checkNotNullParameter(dispatcher, "dispatcher");
        Intrinsics.checkNotNullParameter(input, "input");
        if (input.getDispatcher$navigationevent() != null) {
            throw new IllegalArgumentException(("Input '" + input + "' is already added to dispatcher " + input.getDispatcher$navigationevent() + '.').toString());
        }
        if (i == 0) {
            set = this.overlayInputs;
        } else if (i == 1) {
            set = this.defaultInputs;
        } else {
            set = this.unspecifiedInputs;
        }
        set.add(input);
        input.setDispatcher$navigationevent(dispatcher);
        input.doOnAdded$navigationevent(dispatcher);
        input.doOnHistoryChanged$navigationevent(this.history.getValue());
        if (i == 0) {
            z = this.hasEnabledOverlayHandlers;
        } else if (i == 1) {
            z = this.hasEnabledDefaultHandlers;
        } else {
            z = this.hasEnabledAnyHandlers;
        }
        input.doOnHasEnabledHandlersChanged$navigationevent(z);
    }

    public final void removeInput(NavigationEventInput input) {
        Intrinsics.checkNotNullParameter(input, "input");
        this.overlayInputs.remove(input);
        this.defaultInputs.remove(input);
        this.unspecifiedInputs.remove(input);
        input.setDispatcher$navigationevent(null);
        input.doOnRemoved$navigationevent();
    }

    public static /* synthetic */ void dispatchOnStarted$default(NavigationEventProcessor navigationEventProcessor, NavigationEventInput navigationEventInput, int i, NavigationEvent navigationEvent, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            navigationEvent = null;
        }
        navigationEventProcessor.dispatchOnStarted(navigationEventInput, i, navigationEvent);
    }

    public final void dispatchOnStarted(NavigationEventInput input, int i, NavigationEvent navigationEvent) {
        Intrinsics.checkNotNullParameter(input, "input");
        if (this.inProgressDirection != 0) {
            return;
        }
        NavigationEventHandler<?> resolveEnabledHandler = resolveEnabledHandler(i);
        this.inProgressHandler = resolveEnabledHandler;
        this.inProgressDirection = i;
        this.inProgressInput = input;
        if (navigationEvent != null) {
            if (i != -1) {
                if (i == 1 && resolveEnabledHandler != null) {
                    resolveEnabledHandler.doOnForwardStarted$navigationevent(navigationEvent);
                }
            } else if (resolveEnabledHandler != null) {
                resolveEnabledHandler.doOnBackStarted$navigationevent(navigationEvent);
            }
            this._transitionState.setValue(new NavigationEventTransitionState.InProgress(navigationEvent, i));
        }
    }

    public final void dispatchOnProgressed(NavigationEventInput input, int i, NavigationEvent event) {
        Intrinsics.checkNotNullParameter(input, "input");
        Intrinsics.checkNotNullParameter(event, "event");
        if (Intrinsics.areEqual(input, this.inProgressInput) && i == this.inProgressDirection) {
            NavigationEventHandler<?> navigationEventHandler = this.inProgressHandler;
            if (navigationEventHandler == null) {
                navigationEventHandler = resolveEnabledHandler(i);
            }
            if (i != -1) {
                if (i == 1 && navigationEventHandler != null) {
                    navigationEventHandler.doOnForwardProgressed$navigationevent(event);
                }
            } else if (navigationEventHandler != null) {
                navigationEventHandler.doOnBackProgressed$navigationevent(event);
            }
            this._transitionState.setValue(new NavigationEventTransitionState.InProgress(event, i));
        }
    }

    public final void dispatchOnCompleted(NavigationEventInput input, int i, OnBackCompletedFallback onBackCompletedFallback) {
        Intrinsics.checkNotNullParameter(input, "input");
        if (Intrinsics.areEqual(input, this.inProgressInput) && i == this.inProgressDirection) {
            NavigationEventHandler<?> navigationEventHandler = this.inProgressHandler;
            if (navigationEventHandler == null) {
                navigationEventHandler = resolveEnabledHandler(i);
            }
            this.inProgressHandler = null;
            this.inProgressDirection = 0;
            this.inProgressInput = null;
            if (i != -1) {
                if (i == 1 && navigationEventHandler != null) {
                    navigationEventHandler.doOnForwardCompleted$navigationevent();
                }
            } else if (navigationEventHandler != null) {
                navigationEventHandler.doOnBackCompleted$navigationevent();
            } else if (onBackCompletedFallback != null) {
                onBackCompletedFallback.onBackCompletedFallback();
            }
            this._transitionState.setValue(NavigationEventTransitionState.Idle.INSTANCE);
        }
    }

    public final void dispatchOnCancelled(NavigationEventInput input, int i) {
        Intrinsics.checkNotNullParameter(input, "input");
        if (Intrinsics.areEqual(input, this.inProgressInput) && i == this.inProgressDirection) {
            NavigationEventHandler<?> navigationEventHandler = this.inProgressHandler;
            if (navigationEventHandler == null) {
                navigationEventHandler = resolveEnabledHandler(i);
            }
            this.inProgressHandler = null;
            this.inProgressDirection = 0;
            this.inProgressInput = null;
            if (i != -1) {
                if (i == 1 && navigationEventHandler != null) {
                    navigationEventHandler.doOnForwardCancelled$navigationevent();
                }
            } else if (navigationEventHandler != null) {
                navigationEventHandler.doOnBackCancelled$navigationevent();
            }
            this._transitionState.setValue(NavigationEventTransitionState.Idle.INSTANCE);
        }
    }

    static /* synthetic */ NavigationEventHandler resolveEnabledHandler$default(NavigationEventProcessor navigationEventProcessor, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = 0;
        }
        return navigationEventProcessor.resolveEnabledHandler(i);
    }

    private final NavigationEventHandler<?> findHandler(Function1<? super NavigationEventHandler<?>, Boolean> function1) {
        NavigationEventHandler<?> navigationEventHandler;
        NavigationEventHandler<?> navigationEventHandler2;
        Iterator<NavigationEventHandler<?>> it = this.overlayHandlers.iterator();
        while (true) {
            navigationEventHandler = null;
            if (!it.hasNext()) {
                navigationEventHandler2 = null;
                break;
            }
            navigationEventHandler2 = it.next();
            if (function1.invoke(navigationEventHandler2).booleanValue()) {
                break;
            }
        }
        NavigationEventHandler<?> navigationEventHandler3 = navigationEventHandler2;
        if (navigationEventHandler3 == null) {
            Iterator<NavigationEventHandler<?>> it2 = this.defaultHandlers.iterator();
            while (true) {
                if (!it2.hasNext()) {
                    break;
                }
                NavigationEventHandler<?> next = it2.next();
                if (function1.invoke(next).booleanValue()) {
                    navigationEventHandler = next;
                    break;
                }
            }
            return navigationEventHandler;
        }
        return navigationEventHandler3;
    }

    private final List<NavigationEventInfo> resolveCombinedBackInfo() {
        ArrayList arrayList = new ArrayList();
        Iterator it = this.overlayHandlers.iterator();
        while (it.hasNext()) {
            NavigationEventHandler navigationEventHandler = (NavigationEventHandler) it.next();
            if (navigationEventHandler.isBackEnabled() && !navigationEventHandler.getBackInfo().isEmpty()) {
                arrayList.addAll(navigationEventHandler.getBackInfo());
            }
        }
        Iterator it2 = this.defaultHandlers.iterator();
        while (it2.hasNext()) {
            NavigationEventHandler navigationEventHandler2 = (NavigationEventHandler) it2.next();
            if (navigationEventHandler2.isBackEnabled() && !navigationEventHandler2.getBackInfo().isEmpty()) {
                arrayList.addAll(navigationEventHandler2.getBackInfo());
            }
        }
        return arrayList;
    }

    /* JADX WARN: Removed duplicated region for block: B:41:0x009e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final NavigationEventHandler<?> resolveEnabledHandler(int i) {
        NavigationEventHandler<?> navigationEventHandler;
        NavigationEventHandler<?> navigationEventHandler2;
        NavigationEventHandler<?> navigationEventHandler3;
        NavigationEventHandler<?> navigationEventHandler4 = null;
        if (i == -1) {
            Iterator<NavigationEventHandler<?>> it = this.overlayHandlers.iterator();
            while (true) {
                if (!it.hasNext()) {
                    navigationEventHandler = null;
                    break;
                }
                navigationEventHandler = it.next();
                if (navigationEventHandler.isBackEnabled()) {
                    break;
                }
            }
            NavigationEventHandler<?> navigationEventHandler5 = navigationEventHandler;
            if (navigationEventHandler5 == null) {
                Iterator<NavigationEventHandler<?>> it2 = this.defaultHandlers.iterator();
                while (true) {
                    if (!it2.hasNext()) {
                        break;
                    }
                    NavigationEventHandler<?> next = it2.next();
                    if (next.isBackEnabled()) {
                        navigationEventHandler4 = next;
                        break;
                    }
                }
                return navigationEventHandler4;
            }
            return navigationEventHandler5;
        } else if (i == 0) {
            Iterator<NavigationEventHandler<?>> it3 = this.overlayHandlers.iterator();
            while (true) {
                if (!it3.hasNext()) {
                    navigationEventHandler2 = null;
                    break;
                }
                navigationEventHandler2 = it3.next();
                NavigationEventHandler<?> navigationEventHandler6 = navigationEventHandler2;
                if (navigationEventHandler6.isBackEnabled()) {
                    break;
                } else if (navigationEventHandler6.isForwardEnabled()) {
                    break;
                }
            }
            NavigationEventHandler<?> navigationEventHandler7 = navigationEventHandler2;
            if (navigationEventHandler7 == null) {
                for (NavigationEventHandler<?> navigationEventHandler8 : this.defaultHandlers) {
                    NavigationEventHandler<?> navigationEventHandler9 = navigationEventHandler8;
                    if (navigationEventHandler9.isBackEnabled() || navigationEventHandler9.isForwardEnabled()) {
                        navigationEventHandler4 = navigationEventHandler8;
                        break;
                    }
                    while (r4.hasNext()) {
                    }
                }
                return navigationEventHandler4;
            }
            return navigationEventHandler7;
        } else {
            if (i != 1) {
                throw new IllegalStateException(("Unsupported direction: '" + i + "'.").toString());
            }
            Iterator<NavigationEventHandler<?>> it4 = this.overlayHandlers.iterator();
            while (true) {
                if (!it4.hasNext()) {
                    navigationEventHandler3 = null;
                    break;
                }
                navigationEventHandler3 = it4.next();
                if (navigationEventHandler3.isForwardEnabled()) {
                    break;
                }
            }
            NavigationEventHandler<?> navigationEventHandler10 = navigationEventHandler3;
            if (navigationEventHandler10 == null) {
                Iterator<NavigationEventHandler<?>> it5 = this.defaultHandlers.iterator();
                while (true) {
                    if (!it5.hasNext()) {
                        break;
                    }
                    NavigationEventHandler<?> next2 = it5.next();
                    if (next2.isForwardEnabled()) {
                        navigationEventHandler4 = next2;
                        break;
                    }
                }
                return navigationEventHandler4;
            }
            return navigationEventHandler10;
        }
    }
}
