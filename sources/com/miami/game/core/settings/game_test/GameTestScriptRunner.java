package com.miami.game.core.settings.game_test;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.media3.extractor.text.ttml.TtmlNode;
import com.facebook.widget.FacebookDialog;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.miami.game.core.settings.game_test.GameTestScriptRunner;
import com.miami.game.core.settings.game_test.GameTestStep;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.ListIterator;
import java.util.Set;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.ArrayDeque;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CompletableDeferred;
import kotlinx.coroutines.CompletableDeferredKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;
import kotlinx.coroutines.TimeoutKt;
/* compiled from: GameTestScriptRunner.kt */
@Metadata(d1 = {"\u0000\u0094\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010#\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u0000 A2\u00020\u0001:\u0003?@AB\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0018\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\b\b\u0002\u0010\u0018\u001a\u00020\u0019J\u0006\u0010\u001a\u001a\u00020\u0015J\u000e\u0010\u001b\u001a\u00020\u00152\u0006\u0010\u001c\u001a\u00020\fJ\u0010\u0010\u001d\u001a\u00020\u00152\u0006\u0010\u001c\u001a\u00020\fH\u0002J\u001c\u0010\u001e\u001a\u00020\u00152\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020!0 H\u0082@¢\u0006\u0002\u0010\"J\u0016\u0010#\u001a\u00020\u00152\u0006\u0010$\u001a\u00020%H\u0082@¢\u0006\u0002\u0010&J\u0016\u0010'\u001a\u00020\u00152\u0006\u0010$\u001a\u00020(H\u0082@¢\u0006\u0002\u0010)J\u0016\u0010*\u001a\u00020\u00152\u0006\u0010$\u001a\u00020+H\u0082@¢\u0006\u0002\u0010,J(\u0010-\u001a\u00020\u00152\u0006\u0010.\u001a\u00020/2\u0006\u00100\u001a\u0002012\b\u00102\u001a\u0004\u0018\u00010\u0019H\u0082@¢\u0006\u0002\u00103J\u0018\u00104\u001a\u0004\u0018\u00010\f2\u0006\u0010$\u001a\u00020(H\u0082@¢\u0006\u0002\u0010)J\u0010\u00105\u001a\u00020\u00152\u0006\u00106\u001a\u000207H\u0002J\u0010\u00108\u001a\u00020\u00152\u0006\u00109\u001a\u00020\u0019H\u0002J\b\u0010:\u001a\u00020\u0015H\u0002J\u0018\u0010;\u001a\u00020\u00152\u0006\u00106\u001a\u0002072\u0006\u0010\u001c\u001a\u00020\fH\u0002J\u0010\u0010<\u001a\u00020\u00152\u0006\u0010=\u001a\u00020>H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00110\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\t0\u0013X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006B"}, d2 = {"Lcom/miami/game/core/settings/game_test/GameTestScriptRunner;", "", "runtime", "Lcom/miami/game/core/settings/game_test/GameTestRuntime;", "<init>", "(Lcom/miami/game/core/settings/game_test/GameTestRuntime;)V", "scope", "Lkotlinx/coroutines/CoroutineScope;", "activeJob", "Lkotlinx/coroutines/Job;", "recentBackendEvents", "Lkotlin/collections/ArrayDeque;", "Lcom/miami/game/core/settings/game_test/GameTestBackendEvent;", "pendingBackendMessageWaiters", "", "Lcom/miami/game/core/settings/game_test/GameTestScriptRunner$PendingBackendMessageWaiter;", "activeBackendMessageListeners", "Lcom/miami/game/core/settings/game_test/GameTestScriptRunner$ActiveBackendMessageListener;", "listenerReactionJobs", "", TtmlNode.START, "", "script", "Lcom/miami/game/core/settings/game_test/GameTestScript;", "displayName", "", FacebookDialog.COMPLETION_GESTURE_CANCEL, "onBackendMessage", "event", "handleBackendMessage", "executeSteps", "steps", "", "Lcom/miami/game/core/settings/game_test/GameTestStep;", "(Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "executeBackendMessage", "step", "Lcom/miami/game/core/settings/game_test/GameTestStep$BackendMessage;", "(Lcom/miami/game/core/settings/game_test/GameTestStep$BackendMessage;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "executeWaitBackendMessage", "Lcom/miami/game/core/settings/game_test/GameTestStep$WaitBackendMessage;", "(Lcom/miami/game/core/settings/game_test/GameTestStep$WaitBackendMessage;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "executeBackendFixture", "Lcom/miami/game/core/settings/game_test/GameTestStep$ReplayBackendFixture;", "(Lcom/miami/game/core/settings/game_test/GameTestStep$ReplayBackendFixture;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "replayFixture", "fixture", "Lcom/miami/game/core/settings/game_test/BackendFixture;", TypedValues.AttributesType.S_TARGET, "Lcom/miami/game/core/settings/game_test/BackendReplayTarget;", "providerOverride", "(Lcom/miami/game/core/settings/game_test/BackendFixture;Lcom/miami/game/core/settings/game_test/BackendReplayTarget;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "waitForBackendMessage", "registerBackendMessageListener", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/miami/game/core/settings/game_test/GameTestBackendMessageListener;", "removeBackendMessageListener", "name", "clearBackendMessageListeners", "launchListenerReaction", "clearScriptRuntimeState", "clearRecentEvents", "", "PendingBackendMessageWaiter", "ActiveBackendMessageListener", "Companion", "settings"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class GameTestScriptRunner {
    private static final Companion Companion = new Companion(null);
    private static final int MAX_RECENT_BACKEND_EVENTS = 100;
    private static final String TAG = "GameTestScriptRunner";
    private final List<ActiveBackendMessageListener> activeBackendMessageListeners;
    private Job activeJob;
    private final Set<Job> listenerReactionJobs;
    private final List<PendingBackendMessageWaiter> pendingBackendMessageWaiters;
    private final ArrayDeque<GameTestBackendEvent> recentBackendEvents;
    private final GameTestRuntime runtime;
    private final CoroutineScope scope;

    public GameTestScriptRunner(GameTestRuntime runtime) {
        Intrinsics.checkNotNullParameter(runtime, "runtime");
        this.runtime = runtime;
        this.scope = CoroutineScopeKt.CoroutineScope(SupervisorKt.SupervisorJob$default((Job) null, 1, (Object) null).plus(Dispatchers.getMain().getImmediate()));
        this.recentBackendEvents = new ArrayDeque<>();
        this.pendingBackendMessageWaiters = new ArrayList();
        this.activeBackendMessageListeners = new ArrayList();
        this.listenerReactionJobs = new LinkedHashSet();
    }

    public static /* synthetic */ void start$default(GameTestScriptRunner gameTestScriptRunner, GameTestScript gameTestScript, String str, int i, Object obj) {
        if ((i & 2) != 0) {
            str = gameTestScript.getName();
        }
        gameTestScriptRunner.start(gameTestScript, str);
    }

    public final void start(GameTestScript script, String displayName) {
        Job launch$default;
        Intrinsics.checkNotNullParameter(script, "script");
        Intrinsics.checkNotNullParameter(displayName, "displayName");
        cancel();
        launch$default = BuildersKt__Builders_commonKt.launch$default(this.scope, null, null, new GameTestScriptRunner$start$1(this, displayName, script, null), 3, null);
        this.activeJob = launch$default;
    }

    public final void cancel() {
        Job job = this.activeJob;
        if (job != null) {
            Job.cancel$default(job, (CancellationException) null, 1, (Object) null);
        }
        this.activeJob = null;
        clearScriptRuntimeState(true);
    }

    public final void onBackendMessage(GameTestBackendEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        BuildersKt__Builders_commonKt.launch$default(this.scope, Dispatchers.getMain(), null, new GameTestScriptRunner$onBackendMessage$1(this, event, null), 2, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void handleBackendMessage(GameTestBackendEvent gameTestBackendEvent) {
        this.recentBackendEvents.add(gameTestBackendEvent);
        while (this.recentBackendEvents.size() > 100) {
            this.recentBackendEvents.removeFirst();
        }
        ArrayList<PendingBackendMessageWaiter> arrayList = new ArrayList();
        for (Object obj : this.pendingBackendMessageWaiters) {
            if (((PendingBackendMessageWaiter) obj).getMatcher().matches(gameTestBackendEvent)) {
                arrayList.add(obj);
            }
        }
        for (PendingBackendMessageWaiter pendingBackendMessageWaiter : arrayList) {
            if (this.pendingBackendMessageWaiters.remove(pendingBackendMessageWaiter)) {
                pendingBackendMessageWaiter.getDeferred().complete(gameTestBackendEvent);
            }
        }
        ArrayList<ActiveBackendMessageListener> arrayList2 = new ArrayList();
        for (Object obj2 : this.activeBackendMessageListeners) {
            if (((ActiveBackendMessageListener) obj2).getListener().getMatcher().matches(gameTestBackendEvent)) {
                arrayList2.add(obj2);
            }
        }
        for (ActiveBackendMessageListener activeBackendMessageListener : arrayList2) {
            if (this.activeBackendMessageListeners.contains(activeBackendMessageListener)) {
                if (activeBackendMessageListener.getListener().getOnce()) {
                    this.activeBackendMessageListeners.remove(activeBackendMessageListener);
                }
                launchListenerReaction(activeBackendMessageListener.getListener(), gameTestBackendEvent);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x00d5, code lost:
        if (kotlinx.coroutines.DelayKt.delay(r13, r2) == r3) goto L18;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x00d9, code lost:
        r11 = r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x0145, code lost:
        if (executeBackendMessage((com.miami.game.core.settings.game_test.GameTestStep.BackendMessage) r12, r2) == r3) goto L18;
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x0170, code lost:
        if (executeWaitBackendMessage((com.miami.game.core.settings.game_test.GameTestStep.WaitBackendMessage) r12, r2) == r3) goto L18;
     */
    /* JADX WARN: Code restructure failed: missing block: B:69:0x01b9, code lost:
        if (executeBackendFixture((com.miami.game.core.settings.game_test.GameTestStep.ReplayBackendFixture) r12, r2) == r3) goto L18;
     */
    /* JADX WARN: Code restructure failed: missing block: B:82:0x021a, code lost:
        if (executeSteps(r1, r2) == r3) goto L18;
     */
    /* JADX WARN: Code restructure failed: missing block: B:83:0x021c, code lost:
        return r3;
     */
    /* JADX WARN: Removed duplicated region for block: B:104:0x0272  */
    /* JADX WARN: Removed duplicated region for block: B:10:0x002c  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0071  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0085  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x01f1  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x0220  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:100:0x0266 -> B:101:0x0269). Please submit an issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:24:0x0090 -> B:101:0x0269). Please submit an issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:27:0x009d -> B:101:0x0269). Please submit an issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:34:0x00da -> B:101:0x0269). Please submit an issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:37:0x00e1 -> B:101:0x0269). Please submit an issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:40:0x00ee -> B:101:0x0269). Please submit an issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:43:0x00fb -> B:101:0x0269). Please submit an issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:46:0x0108 -> B:101:0x0269). Please submit an issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:49:0x0115 -> B:101:0x0269). Please submit an issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:62:0x0178 -> B:101:0x0269). Please submit an issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:65:0x0187 -> B:101:0x0269). Please submit an issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:73:0x01c0 -> B:101:0x0269). Please submit an issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:76:0x01d1 -> B:101:0x0269). Please submit an issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:79:0x01de -> B:80:0x01ef). Please submit an issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:82:0x021a -> B:84:0x021d). Please submit an issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:88:0x0228 -> B:101:0x0269). Please submit an issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:91:0x023c -> B:101:0x0269). Please submit an issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:94:0x024a -> B:101:0x0269). Please submit an issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:97:0x0258 -> B:101:0x0269). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object executeSteps(List<? extends GameTestStep> list, Continuation<? super Unit> continuation) {
        GameTestScriptRunner$executeSteps$1 gameTestScriptRunner$executeSteps$1;
        int i;
        Iterator it;
        Object obj;
        List<? extends GameTestStep> list2;
        Iterator it2;
        int i2;
        Object obj2;
        int times;
        Object obj3;
        GameTestStep gameTestStep;
        List<? extends GameTestStep> list3;
        if (continuation instanceof GameTestScriptRunner$executeSteps$1) {
            gameTestScriptRunner$executeSteps$1 = (GameTestScriptRunner$executeSteps$1) continuation;
            if ((gameTestScriptRunner$executeSteps$1.label & Integer.MIN_VALUE) != 0) {
                gameTestScriptRunner$executeSteps$1.label -= Integer.MIN_VALUE;
                Object obj4 = gameTestScriptRunner$executeSteps$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = gameTestScriptRunner$executeSteps$1.label;
                int i3 = 4;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj4);
                    List<? extends GameTestStep> list4 = list;
                    it = list4.iterator();
                    obj = list4;
                    list2 = list;
                    if (it.hasNext()) {
                    }
                } else if (i == 1 || i == 2 || i == 3 || i == 4) {
                    GameTestStep gameTestStep2 = (GameTestStep) gameTestScriptRunner$executeSteps$1.L$4;
                    Object obj5 = gameTestScriptRunner$executeSteps$1.L$3;
                    it = (Iterator) gameTestScriptRunner$executeSteps$1.L$2;
                    obj = (Iterable) gameTestScriptRunner$executeSteps$1.L$1;
                    List<? extends GameTestStep> list5 = (List) gameTestScriptRunner$executeSteps$1.L$0;
                    ResultKt.throwOnFailure(obj4);
                    list2 = list5;
                    i3 = 4;
                    if (it.hasNext()) {
                        Object next = it.next();
                        GameTestStep gameTestStep3 = (GameTestStep) next;
                        if (gameTestStep3 instanceof GameTestStep.NotifyClick) {
                            this.runtime.notifyClick((GameTestStep.NotifyClick) gameTestStep3);
                        } else if (gameTestStep3 instanceof GameTestStep.Chat) {
                            this.runtime.sendChat(((GameTestStep.Chat) gameTestStep3).getText());
                        } else {
                            if (gameTestStep3 instanceof GameTestStep.Sleep) {
                                long delayMs = ((GameTestStep.Sleep) gameTestStep3).getDelayMs();
                                gameTestScriptRunner$executeSteps$1.L$0 = SpillingKt.nullOutSpilledVariable(list2);
                                gameTestScriptRunner$executeSteps$1.L$1 = SpillingKt.nullOutSpilledVariable(obj);
                                gameTestScriptRunner$executeSteps$1.L$2 = it;
                                gameTestScriptRunner$executeSteps$1.L$3 = SpillingKt.nullOutSpilledVariable(next);
                                gameTestScriptRunner$executeSteps$1.L$4 = SpillingKt.nullOutSpilledVariable(gameTestStep3);
                                gameTestScriptRunner$executeSteps$1.label = 1;
                            } else if (gameTestStep3 instanceof GameTestStep.Tap) {
                                this.runtime.tap((GameTestStep.Tap) gameTestStep3);
                            } else if (gameTestStep3 instanceof GameTestStep.Swipe) {
                                this.runtime.swipe((GameTestStep.Swipe) gameTestStep3);
                            } else if (gameTestStep3 instanceof GameTestStep.Screenshot) {
                                this.runtime.captureScreenshot((GameTestStep.Screenshot) gameTestStep3);
                            } else if (gameTestStep3 instanceof GameTestStep.ShowUi) {
                                this.runtime.showUi((GameTestStep.ShowUi) gameTestStep3);
                            } else if (gameTestStep3 instanceof GameTestStep.HideUi) {
                                this.runtime.hideUi((GameTestStep.HideUi) gameTestStep3);
                            } else if (gameTestStep3 instanceof GameTestStep.BackendMessage) {
                                gameTestScriptRunner$executeSteps$1.L$0 = SpillingKt.nullOutSpilledVariable(list2);
                                gameTestScriptRunner$executeSteps$1.L$1 = SpillingKt.nullOutSpilledVariable(obj);
                                gameTestScriptRunner$executeSteps$1.L$2 = it;
                                gameTestScriptRunner$executeSteps$1.L$3 = SpillingKt.nullOutSpilledVariable(next);
                                gameTestScriptRunner$executeSteps$1.L$4 = SpillingKt.nullOutSpilledVariable(gameTestStep3);
                                gameTestScriptRunner$executeSteps$1.label = 2;
                            } else if (gameTestStep3 instanceof GameTestStep.WaitBackendMessage) {
                                gameTestScriptRunner$executeSteps$1.L$0 = SpillingKt.nullOutSpilledVariable(list2);
                                gameTestScriptRunner$executeSteps$1.L$1 = SpillingKt.nullOutSpilledVariable(obj);
                                gameTestScriptRunner$executeSteps$1.L$2 = it;
                                gameTestScriptRunner$executeSteps$1.L$3 = SpillingKt.nullOutSpilledVariable(next);
                                gameTestScriptRunner$executeSteps$1.L$4 = SpillingKt.nullOutSpilledVariable(gameTestStep3);
                                gameTestScriptRunner$executeSteps$1.label = 3;
                            } else if (gameTestStep3 instanceof GameTestStep.AddBackendMessageListener) {
                                registerBackendMessageListener(((GameTestStep.AddBackendMessageListener) gameTestStep3).getListener());
                            } else if (gameTestStep3 instanceof GameTestStep.RemoveBackendMessageListener) {
                                removeBackendMessageListener(((GameTestStep.RemoveBackendMessageListener) gameTestStep3).getName());
                            } else if (gameTestStep3 instanceof GameTestStep.ReplayBackendFixture) {
                                gameTestScriptRunner$executeSteps$1.L$0 = SpillingKt.nullOutSpilledVariable(list2);
                                gameTestScriptRunner$executeSteps$1.L$1 = SpillingKt.nullOutSpilledVariable(obj);
                                gameTestScriptRunner$executeSteps$1.L$2 = it;
                                gameTestScriptRunner$executeSteps$1.L$3 = SpillingKt.nullOutSpilledVariable(next);
                                gameTestScriptRunner$executeSteps$1.L$4 = SpillingKt.nullOutSpilledVariable(gameTestStep3);
                                gameTestScriptRunner$executeSteps$1.label = i3;
                            } else if (gameTestStep3 instanceof GameTestStep.StartBackendTrace) {
                                this.runtime.startBackendTrace(((GameTestStep.StartBackendTrace) gameTestStep3).getTraceName());
                            } else if (gameTestStep3 instanceof GameTestStep.StartBackendValidation) {
                                this.runtime.startBackendValidation((GameTestStep.StartBackendValidation) gameTestStep3);
                            } else if (gameTestStep3 instanceof GameTestStep.Repeat) {
                                it2 = it;
                                i2 = 0;
                                obj2 = obj;
                                times = ((GameTestStep.Repeat) gameTestStep3).getTimes();
                                obj3 = next;
                                gameTestStep = gameTestStep3;
                                list3 = list2;
                                if (i2 >= times) {
                                    List<? extends GameTestStep> steps = ((GameTestStep.Repeat) gameTestStep).getSteps();
                                    gameTestScriptRunner$executeSteps$1.L$0 = SpillingKt.nullOutSpilledVariable(list3);
                                    gameTestScriptRunner$executeSteps$1.L$1 = SpillingKt.nullOutSpilledVariable(obj2);
                                    gameTestScriptRunner$executeSteps$1.L$2 = it2;
                                    gameTestScriptRunner$executeSteps$1.L$3 = SpillingKt.nullOutSpilledVariable(obj3);
                                    gameTestScriptRunner$executeSteps$1.L$4 = gameTestStep;
                                    gameTestScriptRunner$executeSteps$1.I$0 = times;
                                    gameTestScriptRunner$executeSteps$1.I$1 = i2;
                                    gameTestScriptRunner$executeSteps$1.I$2 = i2;
                                    gameTestScriptRunner$executeSteps$1.label = 5;
                                } else {
                                    it = it2;
                                    obj = obj2;
                                    list2 = list3;
                                }
                            } else if (gameTestStep3 instanceof GameTestStep.Log) {
                                this.runtime.log(((GameTestStep.Log) gameTestStep3).getMessage());
                            } else if (Intrinsics.areEqual(gameTestStep3, GameTestStep.CloseAll.INSTANCE)) {
                                this.runtime.closeAll();
                            } else if (Intrinsics.areEqual(gameTestStep3, GameTestStep.StopBackendTrace.INSTANCE)) {
                                this.runtime.stopBackendTrace();
                            } else if (Intrinsics.areEqual(gameTestStep3, GameTestStep.StopBackendValidation.INSTANCE)) {
                                this.runtime.stopBackendValidation();
                            } else if (!Intrinsics.areEqual(gameTestStep3, GameTestStep.ClearBackendMessageListeners.INSTANCE)) {
                                throw new NoWhenBranchMatchedException();
                            } else {
                                clearBackendMessageListeners();
                            }
                            list2 = list5;
                        }
                        i3 = 4;
                        if (it.hasNext()) {
                            return Unit.INSTANCE;
                        }
                    }
                } else if (i != 5) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                } else {
                    int i4 = gameTestScriptRunner$executeSteps$1.I$2;
                    i2 = gameTestScriptRunner$executeSteps$1.I$1;
                    times = gameTestScriptRunner$executeSteps$1.I$0;
                    gameTestStep = (GameTestStep) gameTestScriptRunner$executeSteps$1.L$4;
                    obj3 = gameTestScriptRunner$executeSteps$1.L$3;
                    it2 = (Iterator) gameTestScriptRunner$executeSteps$1.L$2;
                    obj2 = (Iterable) gameTestScriptRunner$executeSteps$1.L$1;
                    list3 = (List) gameTestScriptRunner$executeSteps$1.L$0;
                    ResultKt.throwOnFailure(obj4);
                    i2++;
                    if (i2 >= times) {
                    }
                }
            }
        }
        gameTestScriptRunner$executeSteps$1 = new GameTestScriptRunner$executeSteps$1(this, continuation);
        Object obj42 = gameTestScriptRunner$executeSteps$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = gameTestScriptRunner$executeSteps$1.label;
        int i32 = 4;
        if (i != 0) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object executeBackendMessage(GameTestStep.BackendMessage backendMessage, Continuation<? super Unit> continuation) {
        return replayFixture(new BackendFixture("inline_backend_message", backendMessage.getProvider(), null, CollectionsKt.listOf(new BackendFixtureEvent(backendMessage.getBackendId(), backendMessage.getBackendName(), backendMessage.getSubId(), backendMessage.getMessage(), 0L, 16, null)), 4, null), backendMessage.getTarget(), backendMessage.getProvider(), continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0036  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0048  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object executeWaitBackendMessage(GameTestStep.WaitBackendMessage waitBackendMessage, Continuation<? super Unit> continuation) {
        GameTestScriptRunner$executeWaitBackendMessage$1 gameTestScriptRunner$executeWaitBackendMessage$1;
        int i;
        GameTestBackendEvent gameTestBackendEvent;
        if (continuation instanceof GameTestScriptRunner$executeWaitBackendMessage$1) {
            gameTestScriptRunner$executeWaitBackendMessage$1 = (GameTestScriptRunner$executeWaitBackendMessage$1) continuation;
            if ((gameTestScriptRunner$executeWaitBackendMessage$1.label & Integer.MIN_VALUE) != 0) {
                gameTestScriptRunner$executeWaitBackendMessage$1.label -= Integer.MIN_VALUE;
                Object obj = gameTestScriptRunner$executeWaitBackendMessage$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = gameTestScriptRunner$executeWaitBackendMessage$1.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    gameTestScriptRunner$executeWaitBackendMessage$1.L$0 = waitBackendMessage;
                    gameTestScriptRunner$executeWaitBackendMessage$1.label = 1;
                    obj = waitForBackendMessage(waitBackendMessage, gameTestScriptRunner$executeWaitBackendMessage$1);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                } else {
                    waitBackendMessage = (GameTestStep.WaitBackendMessage) gameTestScriptRunner$executeWaitBackendMessage$1.L$0;
                    ResultKt.throwOnFailure(obj);
                }
                gameTestBackendEvent = (GameTestBackendEvent) obj;
                if (gameTestBackendEvent != null) {
                    this.runtime.log("Wait backend message matched: " + gameTestBackendEvent.describe() + " for " + waitBackendMessage.getMatcher().describe());
                }
                return Unit.INSTANCE;
            }
        }
        gameTestScriptRunner$executeWaitBackendMessage$1 = new GameTestScriptRunner$executeWaitBackendMessage$1(this, continuation);
        Object obj2 = gameTestScriptRunner$executeWaitBackendMessage$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = gameTestScriptRunner$executeWaitBackendMessage$1.label;
        if (i != 0) {
        }
        gameTestBackendEvent = (GameTestBackendEvent) obj2;
        if (gameTestBackendEvent != null) {
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object executeBackendFixture(GameTestStep.ReplayBackendFixture replayBackendFixture, Continuation<? super Unit> continuation) {
        return replayFixture(this.runtime.loadBackendFixture(replayBackendFixture), replayBackendFixture.getTarget(), replayBackendFixture.getProvider(), continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x004d  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0085  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00d9  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:29:0x0094 -> B:35:0x00d3). Please submit an issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:33:0x00c5 -> B:34:0x00cc). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object replayFixture(BackendFixture backendFixture, BackendReplayTarget backendReplayTarget, String str, Continuation<? super Unit> continuation) {
        GameTestScriptRunner$replayFixture$1 gameTestScriptRunner$replayFixture$1;
        int i;
        BackendReplayTarget backendReplayTarget2;
        Iterator it;
        GameTestScriptRunner$replayFixture$1 gameTestScriptRunner$replayFixture$12;
        Object obj;
        String str2;
        if (continuation instanceof GameTestScriptRunner$replayFixture$1) {
            gameTestScriptRunner$replayFixture$1 = (GameTestScriptRunner$replayFixture$1) continuation;
            if ((gameTestScriptRunner$replayFixture$1.label & Integer.MIN_VALUE) != 0) {
                gameTestScriptRunner$replayFixture$1.label -= Integer.MIN_VALUE;
                Object obj2 = gameTestScriptRunner$replayFixture$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = gameTestScriptRunner$replayFixture$1.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj2);
                    if (backendReplayTarget.getIncludesValidator()) {
                        this.runtime.validateBackendFixture(backendFixture, str);
                    }
                    if (!backendReplayTarget.getIncludesUi()) {
                        return Unit.INSTANCE;
                    }
                    if (this.runtime.previewBackendFixture(backendFixture, str)) {
                        return Unit.INSTANCE;
                    }
                    List<BackendFixtureEvent> events = backendFixture.getEvents();
                    backendReplayTarget2 = backendReplayTarget;
                    it = events.iterator();
                    gameTestScriptRunner$replayFixture$12 = gameTestScriptRunner$replayFixture$1;
                    obj = events;
                    str2 = str;
                    if (it.hasNext()) {
                    }
                } else if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                } else {
                    BackendFixtureEvent backendFixtureEvent = (BackendFixtureEvent) gameTestScriptRunner$replayFixture$1.L$6;
                    Object obj3 = gameTestScriptRunner$replayFixture$1.L$5;
                    it = (Iterator) gameTestScriptRunner$replayFixture$1.L$4;
                    Object obj4 = (Iterable) gameTestScriptRunner$replayFixture$1.L$3;
                    String str3 = (String) gameTestScriptRunner$replayFixture$1.L$2;
                    BackendReplayTarget backendReplayTarget3 = (BackendReplayTarget) gameTestScriptRunner$replayFixture$1.L$1;
                    BackendFixture backendFixture2 = (BackendFixture) gameTestScriptRunner$replayFixture$1.L$0;
                    ResultKt.throwOnFailure(obj2);
                    BackendFixture backendFixture3 = backendFixture2;
                    BackendFixtureEvent backendFixtureEvent2 = backendFixtureEvent;
                    backendFixture = backendFixture3;
                    str2 = str3;
                    gameTestScriptRunner$replayFixture$12 = gameTestScriptRunner$replayFixture$1;
                    obj = obj4;
                    backendReplayTarget2 = backendReplayTarget3;
                    this.runtime.dispatchBackendEvent(backendFixtureEvent2);
                    if (it.hasNext()) {
                        Object next = it.next();
                        backendFixtureEvent2 = (BackendFixtureEvent) next;
                        if (backendFixtureEvent2.getDelayMs() > 0) {
                            long delayMs = backendFixtureEvent2.getDelayMs();
                            gameTestScriptRunner$replayFixture$12.L$0 = SpillingKt.nullOutSpilledVariable(backendFixture);
                            gameTestScriptRunner$replayFixture$12.L$1 = SpillingKt.nullOutSpilledVariable(backendReplayTarget2);
                            gameTestScriptRunner$replayFixture$12.L$2 = SpillingKt.nullOutSpilledVariable(str2);
                            gameTestScriptRunner$replayFixture$12.L$3 = SpillingKt.nullOutSpilledVariable(obj);
                            gameTestScriptRunner$replayFixture$12.L$4 = it;
                            gameTestScriptRunner$replayFixture$12.L$5 = SpillingKt.nullOutSpilledVariable(next);
                            gameTestScriptRunner$replayFixture$12.L$6 = backendFixtureEvent2;
                            gameTestScriptRunner$replayFixture$12.label = 1;
                            if (DelayKt.delay(delayMs, gameTestScriptRunner$replayFixture$12) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            backendFixture2 = backendFixture;
                            backendFixtureEvent = backendFixtureEvent2;
                            backendReplayTarget3 = backendReplayTarget2;
                            obj4 = obj;
                            gameTestScriptRunner$replayFixture$1 = gameTestScriptRunner$replayFixture$12;
                            str3 = str2;
                            BackendFixture backendFixture32 = backendFixture2;
                            BackendFixtureEvent backendFixtureEvent22 = backendFixtureEvent;
                            backendFixture = backendFixture32;
                            str2 = str3;
                            gameTestScriptRunner$replayFixture$12 = gameTestScriptRunner$replayFixture$1;
                            obj = obj4;
                            backendReplayTarget2 = backendReplayTarget3;
                        }
                        this.runtime.dispatchBackendEvent(backendFixtureEvent22);
                        if (it.hasNext()) {
                            return Unit.INSTANCE;
                        }
                    }
                }
            }
        }
        gameTestScriptRunner$replayFixture$1 = new GameTestScriptRunner$replayFixture$1(this, continuation);
        Object obj22 = gameTestScriptRunner$replayFixture$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = gameTestScriptRunner$replayFixture$1.label;
        if (i != 0) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0025  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0055  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00e8  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0111 A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object waitForBackendMessage(GameTestStep.WaitBackendMessage waitBackendMessage, Continuation<? super GameTestBackendEvent> continuation) {
        GameTestScriptRunner$waitForBackendMessage$1 gameTestScriptRunner$waitForBackendMessage$1;
        int i;
        GameTestStep.WaitBackendMessage waitBackendMessage2;
        PendingBackendMessageWaiter pendingBackendMessageWaiter;
        GameTestBackendEvent gameTestBackendEvent;
        GameTestBackendEvent gameTestBackendEvent2;
        try {
            if (continuation instanceof GameTestScriptRunner$waitForBackendMessage$1) {
                gameTestScriptRunner$waitForBackendMessage$1 = (GameTestScriptRunner$waitForBackendMessage$1) continuation;
                if ((gameTestScriptRunner$waitForBackendMessage$1.label & Integer.MIN_VALUE) != 0) {
                    gameTestScriptRunner$waitForBackendMessage$1.label -= Integer.MIN_VALUE;
                    Object obj = gameTestScriptRunner$waitForBackendMessage$1.result;
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    i = gameTestScriptRunner$waitForBackendMessage$1.label;
                    if (i != 0) {
                        ResultKt.throwOnFailure(obj);
                        if (waitBackendMessage.getIncludePast()) {
                            ArrayDeque<GameTestBackendEvent> arrayDeque = this.recentBackendEvents;
                            ListIterator<GameTestBackendEvent> listIterator = arrayDeque.listIterator(arrayDeque.size());
                            while (true) {
                                if (!listIterator.hasPrevious()) {
                                    gameTestBackendEvent = null;
                                    break;
                                }
                                gameTestBackendEvent = listIterator.previous();
                                if (waitBackendMessage.getMatcher().matches(gameTestBackendEvent)) {
                                    break;
                                }
                            }
                            GameTestBackendEvent gameTestBackendEvent3 = gameTestBackendEvent;
                            if (gameTestBackendEvent3 != null) {
                                return gameTestBackendEvent3;
                            }
                        }
                        CompletableDeferred CompletableDeferred$default = CompletableDeferredKt.CompletableDeferred$default(null, 1, null);
                        PendingBackendMessageWaiter pendingBackendMessageWaiter2 = new PendingBackendMessageWaiter(waitBackendMessage.getMatcher(), CompletableDeferred$default);
                        this.pendingBackendMessageWaiters.add(pendingBackendMessageWaiter2);
                        try {
                            if (waitBackendMessage.getTimeoutMs() == null) {
                                gameTestScriptRunner$waitForBackendMessage$1.L$0 = waitBackendMessage;
                                gameTestScriptRunner$waitForBackendMessage$1.L$1 = SpillingKt.nullOutSpilledVariable(CompletableDeferred$default);
                                gameTestScriptRunner$waitForBackendMessage$1.L$2 = pendingBackendMessageWaiter2;
                                gameTestScriptRunner$waitForBackendMessage$1.label = 1;
                                obj = CompletableDeferred$default.await(gameTestScriptRunner$waitForBackendMessage$1);
                                if (obj != coroutine_suspended) {
                                    waitBackendMessage2 = waitBackendMessage;
                                    pendingBackendMessageWaiter = pendingBackendMessageWaiter2;
                                    gameTestBackendEvent2 = (GameTestBackendEvent) obj;
                                }
                            } else {
                                gameTestScriptRunner$waitForBackendMessage$1.L$0 = waitBackendMessage;
                                gameTestScriptRunner$waitForBackendMessage$1.L$1 = SpillingKt.nullOutSpilledVariable(CompletableDeferred$default);
                                gameTestScriptRunner$waitForBackendMessage$1.L$2 = pendingBackendMessageWaiter2;
                                gameTestScriptRunner$waitForBackendMessage$1.label = 2;
                                obj = TimeoutKt.withTimeoutOrNull(waitBackendMessage.getTimeoutMs().longValue(), new GameTestScriptRunner$waitForBackendMessage$matchedEvent$1(CompletableDeferred$default, null), gameTestScriptRunner$waitForBackendMessage$1);
                                if (obj != coroutine_suspended) {
                                    waitBackendMessage2 = waitBackendMessage;
                                    pendingBackendMessageWaiter = pendingBackendMessageWaiter2;
                                    gameTestBackendEvent2 = (GameTestBackendEvent) obj;
                                }
                            }
                            return coroutine_suspended;
                        } catch (Throwable th) {
                            th = th;
                            waitBackendMessage = pendingBackendMessageWaiter2;
                            this.pendingBackendMessageWaiters.remove(waitBackendMessage);
                            throw th;
                        }
                    } else if (i == 1) {
                        pendingBackendMessageWaiter = (PendingBackendMessageWaiter) gameTestScriptRunner$waitForBackendMessage$1.L$2;
                        CompletableDeferred completableDeferred = (CompletableDeferred) gameTestScriptRunner$waitForBackendMessage$1.L$1;
                        waitBackendMessage2 = (GameTestStep.WaitBackendMessage) gameTestScriptRunner$waitForBackendMessage$1.L$0;
                        ResultKt.throwOnFailure(obj);
                        gameTestBackendEvent2 = (GameTestBackendEvent) obj;
                    } else if (i != 2) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    } else {
                        pendingBackendMessageWaiter = (PendingBackendMessageWaiter) gameTestScriptRunner$waitForBackendMessage$1.L$2;
                        CompletableDeferred completableDeferred2 = (CompletableDeferred) gameTestScriptRunner$waitForBackendMessage$1.L$1;
                        waitBackendMessage2 = (GameTestStep.WaitBackendMessage) gameTestScriptRunner$waitForBackendMessage$1.L$0;
                        ResultKt.throwOnFailure(obj);
                        gameTestBackendEvent2 = (GameTestBackendEvent) obj;
                    }
                    this.pendingBackendMessageWaiters.remove(pendingBackendMessageWaiter);
                    if (gameTestBackendEvent2 != null) {
                        String str = "Timed out waiting for backend message: " + waitBackendMessage2.getMatcher().describe();
                        if (waitBackendMessage2.getFailOnTimeout()) {
                            throw new IllegalStateException(str);
                        }
                        this.runtime.log(str);
                        return gameTestBackendEvent2;
                    }
                    return gameTestBackendEvent2;
                }
            }
            if (i != 0) {
            }
            this.pendingBackendMessageWaiters.remove(pendingBackendMessageWaiter);
            if (gameTestBackendEvent2 != null) {
            }
        } catch (Throwable th2) {
            th = th2;
        }
        gameTestScriptRunner$waitForBackendMessage$1 = new GameTestScriptRunner$waitForBackendMessage$1(this, continuation);
        Object obj2 = gameTestScriptRunner$waitForBackendMessage$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = gameTestScriptRunner$waitForBackendMessage$1.label;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void registerBackendMessageListener(final GameTestBackendMessageListener gameTestBackendMessageListener) {
        CollectionsKt.removeAll((List) this.activeBackendMessageListeners, new Function1() { // from class: com.miami.game.core.settings.game_test.GameTestScriptRunner$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return Boolean.valueOf(GameTestScriptRunner.registerBackendMessageListener$lambda$0(GameTestBackendMessageListener.this, (GameTestScriptRunner.ActiveBackendMessageListener) obj));
            }
        });
        this.activeBackendMessageListeners.add(new ActiveBackendMessageListener(gameTestBackendMessageListener));
        GameTestRuntime gameTestRuntime = this.runtime;
        String name = gameTestBackendMessageListener.getName();
        gameTestRuntime.log("Backend listener '" + name + "' registered: " + gameTestBackendMessageListener.getMatcher().describe());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final boolean registerBackendMessageListener$lambda$0(GameTestBackendMessageListener gameTestBackendMessageListener, ActiveBackendMessageListener activeListener) {
        Intrinsics.checkNotNullParameter(activeListener, "activeListener");
        return Intrinsics.areEqual(activeListener.getListener().getName(), gameTestBackendMessageListener.getName());
    }

    private final void removeBackendMessageListener(final String str) {
        boolean removeAll = CollectionsKt.removeAll((List) this.activeBackendMessageListeners, new Function1() { // from class: com.miami.game.core.settings.game_test.GameTestScriptRunner$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return Boolean.valueOf(GameTestScriptRunner.removeBackendMessageListener$lambda$0(str, (GameTestScriptRunner.ActiveBackendMessageListener) obj));
            }
        });
        GameTestRuntime gameTestRuntime = this.runtime;
        if (removeAll) {
            gameTestRuntime.log("Backend listener '" + str + "' removed");
        } else {
            gameTestRuntime.log("Backend listener '" + str + "' was not registered");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final boolean removeBackendMessageListener$lambda$0(String str, ActiveBackendMessageListener activeListener) {
        Intrinsics.checkNotNullParameter(activeListener, "activeListener");
        return Intrinsics.areEqual(activeListener.getListener().getName(), str);
    }

    private final void clearBackendMessageListeners() {
        if (this.activeBackendMessageListeners.isEmpty()) {
            return;
        }
        this.activeBackendMessageListeners.clear();
        this.runtime.log("Backend listeners cleared");
    }

    private final void launchListenerReaction(GameTestBackendMessageListener gameTestBackendMessageListener, GameTestBackendEvent gameTestBackendEvent) {
        final Job launch$default;
        Job job = this.activeJob;
        if (job == null || !job.isActive()) {
            return;
        }
        launch$default = BuildersKt__Builders_commonKt.launch$default(this.scope, null, null, new GameTestScriptRunner$launchListenerReaction$job$1(this, gameTestBackendMessageListener, gameTestBackendEvent, null), 3, null);
        this.listenerReactionJobs.add(launch$default);
        launch$default.invokeOnCompletion(new Function1() { // from class: com.miami.game.core.settings.game_test.GameTestScriptRunner$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return GameTestScriptRunner.launchListenerReaction$lambda$0(GameTestScriptRunner.this, launch$default, (Throwable) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit launchListenerReaction$lambda$0(GameTestScriptRunner gameTestScriptRunner, Job job, Throwable th) {
        gameTestScriptRunner.listenerReactionJobs.remove(job);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void clearScriptRuntimeState(boolean z) {
        for (PendingBackendMessageWaiter pendingBackendMessageWaiter : CollectionsKt.toList(this.pendingBackendMessageWaiters)) {
            pendingBackendMessageWaiter.getDeferred().cancel(new CancellationException("Game test script stopped"));
        }
        this.pendingBackendMessageWaiters.clear();
        this.activeBackendMessageListeners.clear();
        for (Job job : CollectionsKt.toList(this.listenerReactionJobs)) {
            job.cancel(new CancellationException("Game test script stopped"));
        }
        this.listenerReactionJobs.clear();
        if (z) {
            this.recentBackendEvents.clear();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: GameTestScriptRunner.kt */
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0082\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J#\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0001J\u0014\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0013\u001a\u00020\u0014HÖ\u0081\u0004J\n\u0010\u0015\u001a\u00020\u0016HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0017"}, d2 = {"Lcom/miami/game/core/settings/game_test/GameTestScriptRunner$PendingBackendMessageWaiter;", "", "matcher", "Lcom/miami/game/core/settings/game_test/BackendMessageMatcher;", "deferred", "Lkotlinx/coroutines/CompletableDeferred;", "Lcom/miami/game/core/settings/game_test/GameTestBackendEvent;", "<init>", "(Lcom/miami/game/core/settings/game_test/BackendMessageMatcher;Lkotlinx/coroutines/CompletableDeferred;)V", "getMatcher", "()Lcom/miami/game/core/settings/game_test/BackendMessageMatcher;", "getDeferred", "()Lkotlinx/coroutines/CompletableDeferred;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "settings"}, k = 1, mv = {2, 4, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class PendingBackendMessageWaiter {
        private final CompletableDeferred<GameTestBackendEvent> deferred;
        private final BackendMessageMatcher matcher;

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ PendingBackendMessageWaiter copy$default(PendingBackendMessageWaiter pendingBackendMessageWaiter, BackendMessageMatcher backendMessageMatcher, CompletableDeferred completableDeferred, int i, Object obj) {
            if ((i & 1) != 0) {
                backendMessageMatcher = pendingBackendMessageWaiter.matcher;
            }
            if ((i & 2) != 0) {
                completableDeferred = pendingBackendMessageWaiter.deferred;
            }
            return pendingBackendMessageWaiter.copy(backendMessageMatcher, completableDeferred);
        }

        public final BackendMessageMatcher component1() {
            return this.matcher;
        }

        public final CompletableDeferred<GameTestBackendEvent> component2() {
            return this.deferred;
        }

        public final PendingBackendMessageWaiter copy(BackendMessageMatcher matcher, CompletableDeferred<GameTestBackendEvent> deferred) {
            Intrinsics.checkNotNullParameter(matcher, "matcher");
            Intrinsics.checkNotNullParameter(deferred, "deferred");
            return new PendingBackendMessageWaiter(matcher, deferred);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof PendingBackendMessageWaiter) {
                PendingBackendMessageWaiter pendingBackendMessageWaiter = (PendingBackendMessageWaiter) obj;
                return Intrinsics.areEqual(this.matcher, pendingBackendMessageWaiter.matcher) && Intrinsics.areEqual(this.deferred, pendingBackendMessageWaiter.deferred);
            }
            return false;
        }

        public int hashCode() {
            return (this.matcher.hashCode() * 31) + this.deferred.hashCode();
        }

        public String toString() {
            BackendMessageMatcher backendMessageMatcher = this.matcher;
            return "PendingBackendMessageWaiter(matcher=" + backendMessageMatcher + ", deferred=" + this.deferred + ")";
        }

        public PendingBackendMessageWaiter(BackendMessageMatcher matcher, CompletableDeferred<GameTestBackendEvent> deferred) {
            Intrinsics.checkNotNullParameter(matcher, "matcher");
            Intrinsics.checkNotNullParameter(deferred, "deferred");
            this.matcher = matcher;
            this.deferred = deferred;
        }

        public final BackendMessageMatcher getMatcher() {
            return this.matcher;
        }

        public final CompletableDeferred<GameTestBackendEvent> getDeferred() {
            return this.deferred;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: GameTestScriptRunner.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0082\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0014\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\r\u001a\u00020\u000eHÖ\u0081\u0004J\n\u0010\u000f\u001a\u00020\u0010HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lcom/miami/game/core/settings/game_test/GameTestScriptRunner$ActiveBackendMessageListener;", "", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/miami/game/core/settings/game_test/GameTestBackendMessageListener;", "<init>", "(Lcom/miami/game/core/settings/game_test/GameTestBackendMessageListener;)V", "getListener", "()Lcom/miami/game/core/settings/game_test/GameTestBackendMessageListener;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "", "settings"}, k = 1, mv = {2, 4, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class ActiveBackendMessageListener {
        private final GameTestBackendMessageListener listener;

        public static /* synthetic */ ActiveBackendMessageListener copy$default(ActiveBackendMessageListener activeBackendMessageListener, GameTestBackendMessageListener gameTestBackendMessageListener, int i, Object obj) {
            if ((i & 1) != 0) {
                gameTestBackendMessageListener = activeBackendMessageListener.listener;
            }
            return activeBackendMessageListener.copy(gameTestBackendMessageListener);
        }

        public final GameTestBackendMessageListener component1() {
            return this.listener;
        }

        public final ActiveBackendMessageListener copy(GameTestBackendMessageListener listener) {
            Intrinsics.checkNotNullParameter(listener, "listener");
            return new ActiveBackendMessageListener(listener);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof ActiveBackendMessageListener) && Intrinsics.areEqual(this.listener, ((ActiveBackendMessageListener) obj).listener);
        }

        public int hashCode() {
            return this.listener.hashCode();
        }

        public String toString() {
            return "ActiveBackendMessageListener(listener=" + this.listener + ")";
        }

        public ActiveBackendMessageListener(GameTestBackendMessageListener listener) {
            Intrinsics.checkNotNullParameter(listener, "listener");
            this.listener = listener;
        }

        public final GameTestBackendMessageListener getListener() {
            return this.listener;
        }
    }

    /* compiled from: GameTestScriptRunner.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/miami/game/core/settings/game_test/GameTestScriptRunner$Companion;", "", "<init>", "()V", "TAG", "", "MAX_RECENT_BACKEND_EVENTS", "", "settings"}, k = 1, mv = {2, 4, 0}, xi = 48)
    /* loaded from: classes5.dex */
    private static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
