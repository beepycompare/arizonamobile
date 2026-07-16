package com.miami.game.core.settings.game_test;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.media3.extractor.text.ttml.TtmlNode;
import com.facebook.widget.FacebookDialog;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.miami.game.core.settings.game_test.GameTestScriptRunner;
import com.miami.game.core.settings.game_test.GameTestStep;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.ListIterator;
import java.util.Set;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.ArrayDeque;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IntIterator;
import kotlin.comparisons.ComparisonsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
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
import org.json.JSONArray;
import org.json.JSONObject;
/* compiled from: GameTestScriptRunner.kt */
@Metadata(d1 = {"\u0000Æ\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010#\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\u0007\u0018\u0000 _2\u00020\u0001:\u0004\\]^_B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0018\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\b\b\u0002\u0010\u001c\u001a\u00020\u001dJ\u0006\u0010\u001e\u001a\u00020\u0019J\u000e\u0010\u001e\u001a\u00020\u00192\u0006\u0010\u001f\u001a\u00020\u001dJ\u000e\u0010 \u001a\u00020\u00192\u0006\u0010!\u001a\u00020\fJ\u000e\u0010\"\u001a\u00020\u00192\u0006\u0010!\u001a\u00020\u000eJ\u0010\u0010#\u001a\u00020\u00192\u0006\u0010!\u001a\u00020\fH\u0002J\u0010\u0010$\u001a\u00020\u00192\u0006\u0010!\u001a\u00020\u000eH\u0002J\u001c\u0010%\u001a\u00020\u00192\f\u0010&\u001a\b\u0012\u0004\u0012\u00020(0'H\u0082@¢\u0006\u0002\u0010)J\u0016\u0010*\u001a\u00020\u00192\u0006\u0010+\u001a\u00020,H\u0082@¢\u0006\u0002\u0010-J\u0016\u0010.\u001a\u00020\u00192\u0006\u0010+\u001a\u00020/H\u0082@¢\u0006\u0002\u00100J\u0016\u00101\u001a\u00020\u00192\u0006\u0010+\u001a\u000202H\u0082@¢\u0006\u0002\u00103J\u0016\u00104\u001a\u00020\u00192\u0006\u0010+\u001a\u000205H\u0082@¢\u0006\u0002\u00106J\u0016\u00107\u001a\u00020\u00192\u0006\u0010+\u001a\u000208H\u0082@¢\u0006\u0002\u00109J(\u0010:\u001a\u00020\u00192\u0006\u0010;\u001a\u00020<2\u0006\u0010=\u001a\u00020>2\b\u0010?\u001a\u0004\u0018\u00010\u001dH\u0082@¢\u0006\u0002\u0010@J\u0018\u0010A\u001a\u0004\u0018\u00010\f2\u0006\u0010+\u001a\u000202H\u0082@¢\u0006\u0002\u00103JF\u0010A\u001a\u0004\u0018\u00010\f2\b\u0010B\u001a\u0004\u0018\u00010C2\u0006\u0010D\u001a\u00020E2\u0006\u0010F\u001a\u00020E2\u0006\u0010G\u001a\u00020\u001d2\u0012\u0010H\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020E0IH\u0082@¢\u0006\u0002\u0010JJ\u0018\u0010K\u001a\u0004\u0018\u00010\u000e2\u0006\u0010+\u001a\u000205H\u0082@¢\u0006\u0002\u00106J\u0010\u0010L\u001a\u00020\u00192\u0006\u0010M\u001a\u00020NH\u0002J\u0010\u0010O\u001a\u00020\u00192\u0006\u0010P\u001a\u00020\u001dH\u0002J\b\u0010Q\u001a\u00020\u0019H\u0002J\u0018\u0010R\u001a\u00020\u00192\u0006\u0010M\u001a\u00020N2\u0006\u0010!\u001a\u00020\fH\u0002J\u0010\u0010S\u001a\u00020\u00192\u0006\u0010T\u001a\u00020EH\u0002J\u0018\u0010U\u001a\u00020E2\u0006\u0010+\u001a\u0002052\u0006\u0010!\u001a\u00020\u000eH\u0002J\u0010\u0010V\u001a\u00020\u001d2\u0006\u0010+\u001a\u000205H\u0002J\u0010\u0010W\u001a\u00020E2\u0006\u0010!\u001a\u00020\fH\u0002J\u0018\u0010X\u001a\u00020Y2\u0006\u0010Z\u001a\u00020\u001d2\u0006\u0010[\u001a\u00020YH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000e0\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00130\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00150\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\t0\u0017X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006`"}, d2 = {"Lcom/miami/game/core/settings/game_test/GameTestScriptRunner;", "", "runtime", "Lcom/miami/game/core/settings/game_test/GameTestRuntime;", "<init>", "(Lcom/miami/game/core/settings/game_test/GameTestRuntime;)V", "scope", "Lkotlinx/coroutines/CoroutineScope;", "activeJob", "Lkotlinx/coroutines/Job;", "recentBackendEvents", "Lkotlin/collections/ArrayDeque;", "Lcom/miami/game/core/settings/game_test/GameTestBackendEvent;", "recentVisibilityEvents", "Lcom/miami/game/core/settings/game_test/GameTestVisibilityEvent;", "pendingBackendMessageWaiters", "", "Lcom/miami/game/core/settings/game_test/GameTestScriptRunner$PendingBackendMessageWaiter;", "pendingVisibilityWaiters", "Lcom/miami/game/core/settings/game_test/GameTestScriptRunner$PendingVisibilityWaiter;", "activeBackendMessageListeners", "Lcom/miami/game/core/settings/game_test/GameTestScriptRunner$ActiveBackendMessageListener;", "listenerReactionJobs", "", TtmlNode.START, "", "script", "Lcom/miami/game/core/settings/game_test/GameTestScript;", "displayName", "", FacebookDialog.COMPLETION_GESTURE_CANCEL, "reason", "onBackendMessage", "event", "onVisibility", "handleBackendMessage", "handleVisibility", "executeSteps", "steps", "", "Lcom/miami/game/core/settings/game_test/GameTestStep;", "(Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "executeLoginAndSpawn", "step", "Lcom/miami/game/core/settings/game_test/GameTestStep$LoginAndSpawn;", "(Lcom/miami/game/core/settings/game_test/GameTestStep$LoginAndSpawn;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "executeBackendMessage", "Lcom/miami/game/core/settings/game_test/GameTestStep$BackendMessage;", "(Lcom/miami/game/core/settings/game_test/GameTestStep$BackendMessage;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "executeWaitBackendMessage", "Lcom/miami/game/core/settings/game_test/GameTestStep$WaitBackendMessage;", "(Lcom/miami/game/core/settings/game_test/GameTestStep$WaitBackendMessage;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "executeWaitVisibility", "Lcom/miami/game/core/settings/game_test/GameTestStep$WaitVisibility;", "(Lcom/miami/game/core/settings/game_test/GameTestStep$WaitVisibility;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "executeBackendFixture", "Lcom/miami/game/core/settings/game_test/GameTestStep$ReplayBackendFixture;", "(Lcom/miami/game/core/settings/game_test/GameTestStep$ReplayBackendFixture;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "replayFixture", "fixture", "Lcom/miami/game/core/settings/game_test/BackendFixture;", TypedValues.AttributesType.S_TARGET, "Lcom/miami/game/core/settings/game_test/BackendReplayTarget;", "providerOverride", "(Lcom/miami/game/core/settings/game_test/BackendFixture;Lcom/miami/game/core/settings/game_test/BackendReplayTarget;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "waitForBackendMessage", "timeoutMs", "", "includePast", "", "failOnTimeout", "description", "predicate", "Lkotlin/Function1;", "(Ljava/lang/Long;ZZLjava/lang/String;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "waitForVisibility", "registerBackendMessageListener", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/miami/game/core/settings/game_test/GameTestBackendMessageListener;", "removeBackendMessageListener", "name", "clearBackendMessageListeners", "launchListenerReaction", "clearScriptRuntimeState", "clearRecentEvents", "matchesVisibility", "describeVisibilityWait", "isSpawnOfferEvent", "resolveSpawnSelectionId", "", "rawMessage", "spawnIndex", "PendingBackendMessageWaiter", "PendingVisibilityWaiter", "ActiveBackendMessageListener", "Companion", "settings"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class GameTestScriptRunner {
    private static final String AUTHORIZATION_BACKEND_NAME = "AUTHORIZATION";
    private static final int AUTHORIZATION_INIT_SUB_ID = 0;
    private static final int AUTHORIZATION_SELECT_SPAWN_CLICK_ID = 6;
    private static final int AUTHORIZATION_SELECT_SPAWN_DATA_SUB_ID = 8;
    private static final int AUTHORIZATION_SELECT_SPAWN_SUB_ID = 0;
    private static final Companion Companion = new Companion(null);
    private static final int DEFAULT_SPAWN_ID = 0;
    private static final int MAX_RECENT_BACKEND_EVENTS = 100;
    private static final int MAX_RECENT_VISIBILITY_EVENTS = 50;
    private static final String SPAWN_SELECTION_BACKEND_NAME = "SPAWN_SELECTION";
    private static final int SPAWN_SELECTION_LIST_SUB_ID = 0;
    private static final int SPAWN_SELECTION_SELECT_SUB_ID = 0;
    private static final String TAG = "GameTestScriptRunner";
    private final List<ActiveBackendMessageListener> activeBackendMessageListeners;
    private Job activeJob;
    private final Set<Job> listenerReactionJobs;
    private final List<PendingBackendMessageWaiter> pendingBackendMessageWaiters;
    private final List<PendingVisibilityWaiter> pendingVisibilityWaiters;
    private final ArrayDeque<GameTestBackendEvent> recentBackendEvents;
    private final ArrayDeque<GameTestVisibilityEvent> recentVisibilityEvents;
    private final GameTestRuntime runtime;
    private final CoroutineScope scope;

    public GameTestScriptRunner(GameTestRuntime runtime) {
        Intrinsics.checkNotNullParameter(runtime, "runtime");
        this.runtime = runtime;
        this.scope = CoroutineScopeKt.CoroutineScope(SupervisorKt.SupervisorJob$default((Job) null, 1, (Object) null).plus(Dispatchers.getMain().getImmediate()));
        this.recentBackendEvents = new ArrayDeque<>();
        this.recentVisibilityEvents = new ArrayDeque<>();
        this.pendingBackendMessageWaiters = new ArrayList();
        this.pendingVisibilityWaiters = new ArrayList();
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
        cancel("runner start reset");
        launch$default = BuildersKt__Builders_commonKt.launch$default(this.scope, null, null, new GameTestScriptRunner$start$1(this, displayName, script, null), 3, null);
        this.activeJob = launch$default;
    }

    public final void cancel() {
        cancel("unspecified");
    }

    public final void cancel(String reason) {
        Intrinsics.checkNotNullParameter(reason, "reason");
        if (this.activeJob != null) {
            this.runtime.log("Cancelling active test script: " + reason);
        }
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

    public final void onVisibility(GameTestVisibilityEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        BuildersKt__Builders_commonKt.launch$default(this.scope, Dispatchers.getMain(), null, new GameTestScriptRunner$onVisibility$1(this, event, null), 2, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void handleBackendMessage(GameTestBackendEvent gameTestBackendEvent) {
        this.recentBackendEvents.add(gameTestBackendEvent);
        while (this.recentBackendEvents.size() > 100) {
            this.recentBackendEvents.removeFirst();
        }
        ArrayList<PendingBackendMessageWaiter> arrayList = new ArrayList();
        for (Object obj : this.pendingBackendMessageWaiters) {
            if (((PendingBackendMessageWaiter) obj).getMatches().invoke(gameTestBackendEvent).booleanValue()) {
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
    public final void handleVisibility(GameTestVisibilityEvent gameTestVisibilityEvent) {
        this.recentVisibilityEvents.add(gameTestVisibilityEvent);
        while (this.recentVisibilityEvents.size() > 50) {
            this.recentVisibilityEvents.removeFirst();
        }
        ArrayList<PendingVisibilityWaiter> arrayList = new ArrayList();
        for (Object obj : this.pendingVisibilityWaiters) {
            if (((PendingVisibilityWaiter) obj).getMatches().invoke(gameTestVisibilityEvent).booleanValue()) {
                arrayList.add(obj);
            }
        }
        for (PendingVisibilityWaiter pendingVisibilityWaiter : arrayList) {
            if (this.pendingVisibilityWaiters.remove(pendingVisibilityWaiter)) {
                pendingVisibilityWaiter.getDeferred().complete(gameTestVisibilityEvent);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x00ba, code lost:
        if (executeLoginAndSpawn((com.miami.game.core.settings.game_test.GameTestStep.LoginAndSpawn) r5, r0) == r1) goto L16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x00be, code lost:
        r4 = r13;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x00fd, code lost:
        if (kotlinx.coroutines.DelayKt.delay(r6, r0) == r1) goto L16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x016a, code lost:
        if (executeBackendMessage((com.miami.game.core.settings.game_test.GameTestStep.BackendMessage) r5, r0) == r1) goto L16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x0196, code lost:
        if (executeWaitBackendMessage((com.miami.game.core.settings.game_test.GameTestStep.WaitBackendMessage) r5, r0) == r1) goto L16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:66:0x01c2, code lost:
        if (executeWaitVisibility((com.miami.game.core.settings.game_test.GameTestStep.WaitVisibility) r5, r0) == r1) goto L16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:77:0x020c, code lost:
        if (executeBackendFixture((com.miami.game.core.settings.game_test.GameTestStep.ReplayBackendFixture) r5, r0) == r1) goto L16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:90:0x026e, code lost:
        if (executeSteps(r13, r0) == r1) goto L16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:91:0x0270, code lost:
        return r1;
     */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0025  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x002d  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x004a  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0060  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0074  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x0244  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x0273  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:29:0x00bf -> B:15:0x006e). Please submit an issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:87:0x0231 -> B:88:0x0242). Please submit an issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:90:0x026e -> B:92:0x0271). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object executeSteps(List<? extends GameTestStep> list, Continuation<? super Unit> continuation) {
        GameTestScriptRunner$executeSteps$1 gameTestScriptRunner$executeSteps$1;
        List<? extends GameTestStep> list2;
        Iterator it;
        Object obj;
        Iterator it2;
        int i;
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
                switch (gameTestScriptRunner$executeSteps$1.label) {
                    case 0:
                        ResultKt.throwOnFailure(obj4);
                        List<? extends GameTestStep> list4 = list;
                        Iterator it3 = list4.iterator();
                        list2 = list;
                        it = it3;
                        obj = list4;
                        break;
                    case 1:
                    case 2:
                    case 3:
                    case 4:
                    case 5:
                    case 6:
                        GameTestStep gameTestStep2 = (GameTestStep) gameTestScriptRunner$executeSteps$1.L$4;
                        Object obj5 = gameTestScriptRunner$executeSteps$1.L$3;
                        it = (Iterator) gameTestScriptRunner$executeSteps$1.L$2;
                        obj = (Iterable) gameTestScriptRunner$executeSteps$1.L$1;
                        List<? extends GameTestStep> list5 = (List) gameTestScriptRunner$executeSteps$1.L$0;
                        ResultKt.throwOnFailure(obj4);
                        list2 = list5;
                        break;
                    case 7:
                        int i2 = gameTestScriptRunner$executeSteps$1.I$2;
                        i = gameTestScriptRunner$executeSteps$1.I$1;
                        times = gameTestScriptRunner$executeSteps$1.I$0;
                        gameTestStep = (GameTestStep) gameTestScriptRunner$executeSteps$1.L$4;
                        obj3 = gameTestScriptRunner$executeSteps$1.L$3;
                        it2 = (Iterator) gameTestScriptRunner$executeSteps$1.L$2;
                        obj2 = (Iterable) gameTestScriptRunner$executeSteps$1.L$1;
                        list3 = (List) gameTestScriptRunner$executeSteps$1.L$0;
                        ResultKt.throwOnFailure(obj4);
                        i++;
                        if (i < times) {
                            it = it2;
                            obj = obj2;
                            list2 = list3;
                            break;
                        } else {
                            List<? extends GameTestStep> steps = ((GameTestStep.Repeat) gameTestStep).getSteps();
                            gameTestScriptRunner$executeSteps$1.L$0 = SpillingKt.nullOutSpilledVariable(list3);
                            gameTestScriptRunner$executeSteps$1.L$1 = SpillingKt.nullOutSpilledVariable(obj2);
                            gameTestScriptRunner$executeSteps$1.L$2 = it2;
                            gameTestScriptRunner$executeSteps$1.L$3 = SpillingKt.nullOutSpilledVariable(obj3);
                            gameTestScriptRunner$executeSteps$1.L$4 = gameTestStep;
                            gameTestScriptRunner$executeSteps$1.I$0 = times;
                            gameTestScriptRunner$executeSteps$1.I$1 = i;
                            gameTestScriptRunner$executeSteps$1.I$2 = i;
                            gameTestScriptRunner$executeSteps$1.label = 7;
                            break;
                        }
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                while (it.hasNext()) {
                    Object next = it.next();
                    GameTestStep gameTestStep3 = (GameTestStep) next;
                    if (gameTestStep3 instanceof GameTestStep.NotifyClick) {
                        this.runtime.notifyClick((GameTestStep.NotifyClick) gameTestStep3);
                    } else if (gameTestStep3 instanceof GameTestStep.Authorize) {
                        this.runtime.authorize((GameTestStep.Authorize) gameTestStep3);
                    } else {
                        if (gameTestStep3 instanceof GameTestStep.LoginAndSpawn) {
                            gameTestScriptRunner$executeSteps$1.L$0 = SpillingKt.nullOutSpilledVariable(list2);
                            gameTestScriptRunner$executeSteps$1.L$1 = SpillingKt.nullOutSpilledVariable(obj);
                            gameTestScriptRunner$executeSteps$1.L$2 = it;
                            gameTestScriptRunner$executeSteps$1.L$3 = SpillingKt.nullOutSpilledVariable(next);
                            gameTestScriptRunner$executeSteps$1.L$4 = SpillingKt.nullOutSpilledVariable(gameTestStep3);
                            gameTestScriptRunner$executeSteps$1.label = 1;
                        } else if (gameTestStep3 instanceof GameTestStep.Chat) {
                            this.runtime.sendChat(((GameTestStep.Chat) gameTestStep3).getText());
                        } else if (gameTestStep3 instanceof GameTestStep.Sleep) {
                            long delayMs = ((GameTestStep.Sleep) gameTestStep3).getDelayMs();
                            gameTestScriptRunner$executeSteps$1.L$0 = SpillingKt.nullOutSpilledVariable(list2);
                            gameTestScriptRunner$executeSteps$1.L$1 = SpillingKt.nullOutSpilledVariable(obj);
                            gameTestScriptRunner$executeSteps$1.L$2 = it;
                            gameTestScriptRunner$executeSteps$1.L$3 = SpillingKt.nullOutSpilledVariable(next);
                            gameTestScriptRunner$executeSteps$1.L$4 = SpillingKt.nullOutSpilledVariable(gameTestStep3);
                            gameTestScriptRunner$executeSteps$1.label = 2;
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
                            gameTestScriptRunner$executeSteps$1.label = 3;
                        } else if (gameTestStep3 instanceof GameTestStep.WaitBackendMessage) {
                            gameTestScriptRunner$executeSteps$1.L$0 = SpillingKt.nullOutSpilledVariable(list2);
                            gameTestScriptRunner$executeSteps$1.L$1 = SpillingKt.nullOutSpilledVariable(obj);
                            gameTestScriptRunner$executeSteps$1.L$2 = it;
                            gameTestScriptRunner$executeSteps$1.L$3 = SpillingKt.nullOutSpilledVariable(next);
                            gameTestScriptRunner$executeSteps$1.L$4 = SpillingKt.nullOutSpilledVariable(gameTestStep3);
                            gameTestScriptRunner$executeSteps$1.label = 4;
                        } else if (gameTestStep3 instanceof GameTestStep.WaitVisibility) {
                            gameTestScriptRunner$executeSteps$1.L$0 = SpillingKt.nullOutSpilledVariable(list2);
                            gameTestScriptRunner$executeSteps$1.L$1 = SpillingKt.nullOutSpilledVariable(obj);
                            gameTestScriptRunner$executeSteps$1.L$2 = it;
                            gameTestScriptRunner$executeSteps$1.L$3 = SpillingKt.nullOutSpilledVariable(next);
                            gameTestScriptRunner$executeSteps$1.L$4 = SpillingKt.nullOutSpilledVariable(gameTestStep3);
                            gameTestScriptRunner$executeSteps$1.label = 5;
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
                            gameTestScriptRunner$executeSteps$1.label = 6;
                        } else if (gameTestStep3 instanceof GameTestStep.StartBackendTrace) {
                            this.runtime.startBackendTrace(((GameTestStep.StartBackendTrace) gameTestStep3).getTraceName());
                        } else if (gameTestStep3 instanceof GameTestStep.StartBackendValidation) {
                            this.runtime.startBackendValidation((GameTestStep.StartBackendValidation) gameTestStep3);
                        } else if (gameTestStep3 instanceof GameTestStep.Repeat) {
                            it2 = it;
                            i = 0;
                            obj2 = obj;
                            times = ((GameTestStep.Repeat) gameTestStep3).getTimes();
                            obj3 = next;
                            gameTestStep = gameTestStep3;
                            list3 = list2;
                            if (i < times) {
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
                        while (it.hasNext()) {
                        }
                    }
                }
                return Unit.INSTANCE;
            }
        }
        gameTestScriptRunner$executeSteps$1 = new GameTestScriptRunner$executeSteps$1(this, continuation);
        Object obj42 = gameTestScriptRunner$executeSteps$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (gameTestScriptRunner$executeSteps$1.label) {
        }
        while (it.hasNext()) {
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0074, code lost:
        if (waitForBackendMessage(r1, true, true, "authorization init", r5, r6) == r7) goto L31;
     */
    /* JADX WARN: Removed duplicated region for block: B:10:0x002b  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x005a  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00ae  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00b3  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00b6  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object executeLoginAndSpawn(GameTestStep.LoginAndSpawn loginAndSpawn, Continuation<? super Unit> continuation) {
        GameTestScriptRunner$executeLoginAndSpawn$1 gameTestScriptRunner$executeLoginAndSpawn$1;
        Object obj;
        Object coroutine_suspended;
        int i;
        GameTestStep.LoginAndSpawn loginAndSpawn2;
        GameTestStep.LoginAndSpawn loginAndSpawn3;
        GameTestBackendEvent gameTestBackendEvent;
        if (continuation instanceof GameTestScriptRunner$executeLoginAndSpawn$1) {
            gameTestScriptRunner$executeLoginAndSpawn$1 = (GameTestScriptRunner$executeLoginAndSpawn$1) continuation;
            if ((gameTestScriptRunner$executeLoginAndSpawn$1.label & Integer.MIN_VALUE) != 0) {
                gameTestScriptRunner$executeLoginAndSpawn$1.label -= Integer.MIN_VALUE;
                GameTestScriptRunner$executeLoginAndSpawn$1 gameTestScriptRunner$executeLoginAndSpawn$12 = gameTestScriptRunner$executeLoginAndSpawn$1;
                obj = gameTestScriptRunner$executeLoginAndSpawn$12.result;
                coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = gameTestScriptRunner$executeLoginAndSpawn$12.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    Long timeoutMs = loginAndSpawn.getTimeoutMs();
                    Function1<? super GameTestBackendEvent, Boolean> function1 = new Function1() { // from class: com.miami.game.core.settings.game_test.GameTestScriptRunner$$ExternalSyntheticLambda4
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj2) {
                            return Boolean.valueOf(GameTestScriptRunner.executeLoginAndSpawn$lambda$0((GameTestBackendEvent) obj2));
                        }
                    };
                    loginAndSpawn2 = loginAndSpawn;
                    gameTestScriptRunner$executeLoginAndSpawn$12.L$0 = loginAndSpawn2;
                    gameTestScriptRunner$executeLoginAndSpawn$12.label = 1;
                } else if (i != 1) {
                    if (i != 2) {
                        if (i == 3) {
                            String str = (String) gameTestScriptRunner$executeLoginAndSpawn$12.L$2;
                            GameTestBackendEvent gameTestBackendEvent2 = (GameTestBackendEvent) gameTestScriptRunner$executeLoginAndSpawn$12.L$1;
                            GameTestStep.LoginAndSpawn loginAndSpawn4 = (GameTestStep.LoginAndSpawn) gameTestScriptRunner$executeLoginAndSpawn$12.L$0;
                            ResultKt.throwOnFailure(obj);
                            return obj;
                        }
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    loginAndSpawn3 = (GameTestStep.LoginAndSpawn) gameTestScriptRunner$executeLoginAndSpawn$12.L$0;
                    ResultKt.throwOnFailure(obj);
                    gameTestBackendEvent = (GameTestBackendEvent) obj;
                    if (gameTestBackendEvent != null) {
                        return Unit.INSTANCE;
                    }
                    if (StringsKt.equals(gameTestBackendEvent.getBackendName(), SPAWN_SELECTION_BACKEND_NAME, true)) {
                        int resolveSpawnSelectionId = resolveSpawnSelectionId(gameTestBackendEvent.getMessage(), loginAndSpawn3.getSpawnIndex());
                        this.runtime.log("Selecting SPAWN_SELECTION item id=" + resolveSpawnSelectionId + " from " + gameTestBackendEvent.describe());
                        this.runtime.notifyClick(new GameTestStep.NotifyClick(Boxing.boxInt(gameTestBackendEvent.getBackendId()), gameTestBackendEvent.getBackendName(), resolveSpawnSelectionId, 0, null, 16, null));
                    } else {
                        this.runtime.log("Selecting AUTHORIZATION spawn index=" + loginAndSpawn3.getSpawnIndex() + " from " + gameTestBackendEvent.describe());
                        GameTestRuntime gameTestRuntime = this.runtime;
                        Integer backendId = loginAndSpawn3.getBackendId();
                        String backendName = loginAndSpawn3.getBackendName();
                        gameTestRuntime.notifyClick(new GameTestStep.NotifyClick(backendId, backendName == null ? AUTHORIZATION_BACKEND_NAME : backendName, 6, 0, String.valueOf(loginAndSpawn3.getSpawnIndex())));
                    }
                    if (loginAndSpawn3.getWaitClosed()) {
                        String str2 = StringsKt.equals(gameTestBackendEvent.getBackendName(), SPAWN_SELECTION_BACKEND_NAME, true) ? SPAWN_SELECTION_BACKEND_NAME : AUTHORIZATION_BACKEND_NAME;
                        GameTestStep.WaitVisibility waitVisibility = new GameTestStep.WaitVisibility(null, str2, false, loginAndSpawn3.getTimeoutMs(), false, true, 1, null);
                        gameTestScriptRunner$executeLoginAndSpawn$12.L$0 = SpillingKt.nullOutSpilledVariable(loginAndSpawn3);
                        gameTestScriptRunner$executeLoginAndSpawn$12.L$1 = SpillingKt.nullOutSpilledVariable(gameTestBackendEvent);
                        gameTestScriptRunner$executeLoginAndSpawn$12.L$2 = SpillingKt.nullOutSpilledVariable(str2);
                        gameTestScriptRunner$executeLoginAndSpawn$12.label = 3;
                        Object executeWaitVisibility = executeWaitVisibility(waitVisibility, gameTestScriptRunner$executeLoginAndSpawn$12);
                        return executeWaitVisibility == coroutine_suspended ? coroutine_suspended : executeWaitVisibility;
                    }
                    return Unit.INSTANCE;
                } else {
                    ResultKt.throwOnFailure(obj);
                    loginAndSpawn2 = (GameTestStep.LoginAndSpawn) gameTestScriptRunner$executeLoginAndSpawn$12.L$0;
                }
                this.runtime.authorize(new GameTestStep.Authorize(loginAndSpawn2.getBackendId(), loginAndSpawn2.getBackendName(), loginAndSpawn2.getUsername(), loginAndSpawn2.getPassword()));
                gameTestScriptRunner$executeLoginAndSpawn$12.L$0 = loginAndSpawn2;
                gameTestScriptRunner$executeLoginAndSpawn$12.label = 2;
                obj = waitForBackendMessage(loginAndSpawn2.getTimeoutMs(), true, true, "spawn offer from AUTHORIZATION or SPAWN_SELECTION", new GameTestScriptRunner$executeLoginAndSpawn$spawnEvent$1(this), gameTestScriptRunner$executeLoginAndSpawn$12);
                if (obj != coroutine_suspended) {
                    loginAndSpawn3 = loginAndSpawn2;
                    gameTestBackendEvent = (GameTestBackendEvent) obj;
                    if (gameTestBackendEvent != null) {
                    }
                }
            }
        }
        gameTestScriptRunner$executeLoginAndSpawn$1 = new GameTestScriptRunner$executeLoginAndSpawn$1(this, continuation);
        GameTestScriptRunner$executeLoginAndSpawn$1 gameTestScriptRunner$executeLoginAndSpawn$122 = gameTestScriptRunner$executeLoginAndSpawn$1;
        obj = gameTestScriptRunner$executeLoginAndSpawn$122.result;
        coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = gameTestScriptRunner$executeLoginAndSpawn$122.label;
        if (i != 0) {
        }
        this.runtime.authorize(new GameTestStep.Authorize(loginAndSpawn2.getBackendId(), loginAndSpawn2.getBackendName(), loginAndSpawn2.getUsername(), loginAndSpawn2.getPassword()));
        gameTestScriptRunner$executeLoginAndSpawn$122.L$0 = loginAndSpawn2;
        gameTestScriptRunner$executeLoginAndSpawn$122.label = 2;
        obj = waitForBackendMessage(loginAndSpawn2.getTimeoutMs(), true, true, "spawn offer from AUTHORIZATION or SPAWN_SELECTION", new GameTestScriptRunner$executeLoginAndSpawn$spawnEvent$1(this), gameTestScriptRunner$executeLoginAndSpawn$122);
        if (obj != coroutine_suspended) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final boolean executeLoginAndSpawn$lambda$0(GameTestBackendEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        return StringsKt.equals(event.getBackendName(), AUTHORIZATION_BACKEND_NAME, true) && event.getSubId() == 0;
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
    /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0036  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0048  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object executeWaitVisibility(GameTestStep.WaitVisibility waitVisibility, Continuation<? super Unit> continuation) {
        GameTestScriptRunner$executeWaitVisibility$1 gameTestScriptRunner$executeWaitVisibility$1;
        int i;
        GameTestVisibilityEvent gameTestVisibilityEvent;
        if (continuation instanceof GameTestScriptRunner$executeWaitVisibility$1) {
            gameTestScriptRunner$executeWaitVisibility$1 = (GameTestScriptRunner$executeWaitVisibility$1) continuation;
            if ((gameTestScriptRunner$executeWaitVisibility$1.label & Integer.MIN_VALUE) != 0) {
                gameTestScriptRunner$executeWaitVisibility$1.label -= Integer.MIN_VALUE;
                Object obj = gameTestScriptRunner$executeWaitVisibility$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = gameTestScriptRunner$executeWaitVisibility$1.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    gameTestScriptRunner$executeWaitVisibility$1.L$0 = waitVisibility;
                    gameTestScriptRunner$executeWaitVisibility$1.label = 1;
                    obj = waitForVisibility(waitVisibility, gameTestScriptRunner$executeWaitVisibility$1);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                } else {
                    waitVisibility = (GameTestStep.WaitVisibility) gameTestScriptRunner$executeWaitVisibility$1.L$0;
                    ResultKt.throwOnFailure(obj);
                }
                gameTestVisibilityEvent = (GameTestVisibilityEvent) obj;
                if (gameTestVisibilityEvent != null) {
                    this.runtime.log("Wait visibility matched: " + gameTestVisibilityEvent.describe() + " for " + describeVisibilityWait(waitVisibility));
                }
                return Unit.INSTANCE;
            }
        }
        gameTestScriptRunner$executeWaitVisibility$1 = new GameTestScriptRunner$executeWaitVisibility$1(this, continuation);
        Object obj2 = gameTestScriptRunner$executeWaitVisibility$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = gameTestScriptRunner$executeWaitVisibility$1.label;
        if (i != 0) {
        }
        gameTestVisibilityEvent = (GameTestVisibilityEvent) obj2;
        if (gameTestVisibilityEvent != null) {
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
    public final Object waitForBackendMessage(final GameTestStep.WaitBackendMessage waitBackendMessage, Continuation<? super GameTestBackendEvent> continuation) {
        return waitForBackendMessage(waitBackendMessage.getTimeoutMs(), waitBackendMessage.getIncludePast(), waitBackendMessage.getFailOnTimeout(), waitBackendMessage.getMatcher().describe(), new Function1() { // from class: com.miami.game.core.settings.game_test.GameTestScriptRunner$$ExternalSyntheticLambda5
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return Boolean.valueOf(GameTestScriptRunner.waitForBackendMessage$lambda$0(GameTestStep.WaitBackendMessage.this, (GameTestBackendEvent) obj));
            }
        }, continuation);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final boolean waitForBackendMessage$lambda$0(GameTestStep.WaitBackendMessage waitBackendMessage, GameTestBackendEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        return waitBackendMessage.getMatcher().matches(event);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0025  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x006f  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x010f  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x012c A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object waitForBackendMessage(Long l, boolean z, boolean z2, String str, Function1<? super GameTestBackendEvent, Boolean> function1, Continuation<? super GameTestBackendEvent> continuation) {
        GameTestScriptRunner$waitForBackendMessage$3 gameTestScriptRunner$waitForBackendMessage$3;
        int i;
        PendingBackendMessageWaiter pendingBackendMessageWaiter;
        GameTestBackendEvent gameTestBackendEvent;
        GameTestBackendEvent gameTestBackendEvent2;
        try {
            if (continuation instanceof GameTestScriptRunner$waitForBackendMessage$3) {
                gameTestScriptRunner$waitForBackendMessage$3 = (GameTestScriptRunner$waitForBackendMessage$3) continuation;
                if ((gameTestScriptRunner$waitForBackendMessage$3.label & Integer.MIN_VALUE) != 0) {
                    gameTestScriptRunner$waitForBackendMessage$3.label -= Integer.MIN_VALUE;
                    Object obj = gameTestScriptRunner$waitForBackendMessage$3.result;
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    i = gameTestScriptRunner$waitForBackendMessage$3.label;
                    if (i != 0) {
                        ResultKt.throwOnFailure(obj);
                        if (z) {
                            ArrayDeque<GameTestBackendEvent> arrayDeque = this.recentBackendEvents;
                            ListIterator<GameTestBackendEvent> listIterator = arrayDeque.listIterator(arrayDeque.size());
                            while (true) {
                                if (!listIterator.hasPrevious()) {
                                    gameTestBackendEvent = null;
                                    break;
                                }
                                gameTestBackendEvent = listIterator.previous();
                                if (function1.invoke(gameTestBackendEvent).booleanValue()) {
                                    break;
                                }
                            }
                            GameTestBackendEvent gameTestBackendEvent3 = gameTestBackendEvent;
                            if (gameTestBackendEvent3 != null) {
                                return gameTestBackendEvent3;
                            }
                        }
                        CompletableDeferred CompletableDeferred$default = CompletableDeferredKt.CompletableDeferred$default(null, 1, null);
                        PendingBackendMessageWaiter pendingBackendMessageWaiter2 = new PendingBackendMessageWaiter(str, function1, CompletableDeferred$default);
                        this.pendingBackendMessageWaiters.add(pendingBackendMessageWaiter2);
                        try {
                            if (l == null) {
                                gameTestScriptRunner$waitForBackendMessage$3.L$0 = SpillingKt.nullOutSpilledVariable(l);
                                gameTestScriptRunner$waitForBackendMessage$3.L$1 = str;
                                gameTestScriptRunner$waitForBackendMessage$3.L$2 = SpillingKt.nullOutSpilledVariable(function1);
                                gameTestScriptRunner$waitForBackendMessage$3.L$3 = SpillingKt.nullOutSpilledVariable(CompletableDeferred$default);
                                gameTestScriptRunner$waitForBackendMessage$3.L$4 = pendingBackendMessageWaiter2;
                                gameTestScriptRunner$waitForBackendMessage$3.Z$0 = z;
                                gameTestScriptRunner$waitForBackendMessage$3.Z$1 = z2;
                                gameTestScriptRunner$waitForBackendMessage$3.label = 1;
                                obj = CompletableDeferred$default.await(gameTestScriptRunner$waitForBackendMessage$3);
                                if (obj != coroutine_suspended) {
                                    pendingBackendMessageWaiter = pendingBackendMessageWaiter2;
                                    gameTestBackendEvent2 = (GameTestBackendEvent) obj;
                                }
                            } else {
                                gameTestScriptRunner$waitForBackendMessage$3.L$0 = SpillingKt.nullOutSpilledVariable(l);
                                gameTestScriptRunner$waitForBackendMessage$3.L$1 = str;
                                gameTestScriptRunner$waitForBackendMessage$3.L$2 = SpillingKt.nullOutSpilledVariable(function1);
                                gameTestScriptRunner$waitForBackendMessage$3.L$3 = SpillingKt.nullOutSpilledVariable(CompletableDeferred$default);
                                gameTestScriptRunner$waitForBackendMessage$3.L$4 = pendingBackendMessageWaiter2;
                                gameTestScriptRunner$waitForBackendMessage$3.Z$0 = z;
                                gameTestScriptRunner$waitForBackendMessage$3.Z$1 = z2;
                                gameTestScriptRunner$waitForBackendMessage$3.label = 2;
                                obj = TimeoutKt.withTimeoutOrNull(l.longValue(), new GameTestScriptRunner$waitForBackendMessage$matchedEvent$1(CompletableDeferred$default, null), gameTestScriptRunner$waitForBackendMessage$3);
                                if (obj != coroutine_suspended) {
                                    pendingBackendMessageWaiter = pendingBackendMessageWaiter2;
                                    gameTestBackendEvent2 = (GameTestBackendEvent) obj;
                                }
                            }
                            return coroutine_suspended;
                        } catch (Throwable th) {
                            th = th;
                            l = pendingBackendMessageWaiter2;
                            this.pendingBackendMessageWaiters.remove(l);
                            throw th;
                        }
                    } else if (i == 1) {
                        z2 = gameTestScriptRunner$waitForBackendMessage$3.Z$1;
                        boolean z3 = gameTestScriptRunner$waitForBackendMessage$3.Z$0;
                        pendingBackendMessageWaiter = (PendingBackendMessageWaiter) gameTestScriptRunner$waitForBackendMessage$3.L$4;
                        CompletableDeferred completableDeferred = (CompletableDeferred) gameTestScriptRunner$waitForBackendMessage$3.L$3;
                        Function1 function12 = (Function1) gameTestScriptRunner$waitForBackendMessage$3.L$2;
                        str = (String) gameTestScriptRunner$waitForBackendMessage$3.L$1;
                        Long l2 = (Long) gameTestScriptRunner$waitForBackendMessage$3.L$0;
                        ResultKt.throwOnFailure(obj);
                        gameTestBackendEvent2 = (GameTestBackendEvent) obj;
                    } else if (i != 2) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    } else {
                        z2 = gameTestScriptRunner$waitForBackendMessage$3.Z$1;
                        boolean z4 = gameTestScriptRunner$waitForBackendMessage$3.Z$0;
                        pendingBackendMessageWaiter = (PendingBackendMessageWaiter) gameTestScriptRunner$waitForBackendMessage$3.L$4;
                        CompletableDeferred completableDeferred2 = (CompletableDeferred) gameTestScriptRunner$waitForBackendMessage$3.L$3;
                        Function1 function13 = (Function1) gameTestScriptRunner$waitForBackendMessage$3.L$2;
                        str = (String) gameTestScriptRunner$waitForBackendMessage$3.L$1;
                        Long l3 = (Long) gameTestScriptRunner$waitForBackendMessage$3.L$0;
                        ResultKt.throwOnFailure(obj);
                        gameTestBackendEvent2 = (GameTestBackendEvent) obj;
                    }
                    this.pendingBackendMessageWaiters.remove(pendingBackendMessageWaiter);
                    if (gameTestBackendEvent2 != null) {
                        String str2 = "Timed out waiting for backend message: " + str;
                        if (z2) {
                            throw new IllegalStateException(str2);
                        }
                        this.runtime.log(str2);
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
        gameTestScriptRunner$waitForBackendMessage$3 = new GameTestScriptRunner$waitForBackendMessage$3(this, continuation);
        Object obj2 = gameTestScriptRunner$waitForBackendMessage$3.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = gameTestScriptRunner$waitForBackendMessage$3.label;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0025  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x005e  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0101  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0126 A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object waitForVisibility(final GameTestStep.WaitVisibility waitVisibility, Continuation<? super GameTestVisibilityEvent> continuation) {
        GameTestScriptRunner$waitForVisibility$1 gameTestScriptRunner$waitForVisibility$1;
        int i;
        GameTestStep.WaitVisibility waitVisibility2;
        PendingVisibilityWaiter pendingVisibilityWaiter;
        GameTestVisibilityEvent gameTestVisibilityEvent;
        GameTestVisibilityEvent gameTestVisibilityEvent2;
        try {
            if (continuation instanceof GameTestScriptRunner$waitForVisibility$1) {
                gameTestScriptRunner$waitForVisibility$1 = (GameTestScriptRunner$waitForVisibility$1) continuation;
                if ((gameTestScriptRunner$waitForVisibility$1.label & Integer.MIN_VALUE) != 0) {
                    gameTestScriptRunner$waitForVisibility$1.label -= Integer.MIN_VALUE;
                    Object obj = gameTestScriptRunner$waitForVisibility$1.result;
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    i = gameTestScriptRunner$waitForVisibility$1.label;
                    if (i != 0) {
                        ResultKt.throwOnFailure(obj);
                        Function1 function1 = new Function1() { // from class: com.miami.game.core.settings.game_test.GameTestScriptRunner$$ExternalSyntheticLambda2
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj2) {
                                return Boolean.valueOf(GameTestScriptRunner.waitForVisibility$lambda$0(GameTestScriptRunner.this, waitVisibility, (GameTestVisibilityEvent) obj2));
                            }
                        };
                        if (waitVisibility.getIncludePast()) {
                            ArrayDeque<GameTestVisibilityEvent> arrayDeque = this.recentVisibilityEvents;
                            ListIterator<GameTestVisibilityEvent> listIterator = arrayDeque.listIterator(arrayDeque.size());
                            while (true) {
                                if (!listIterator.hasPrevious()) {
                                    gameTestVisibilityEvent = null;
                                    break;
                                }
                                gameTestVisibilityEvent = listIterator.previous();
                                if (((Boolean) function1.invoke(gameTestVisibilityEvent)).booleanValue()) {
                                    break;
                                }
                            }
                            GameTestVisibilityEvent gameTestVisibilityEvent3 = gameTestVisibilityEvent;
                            if (gameTestVisibilityEvent3 != null) {
                                return gameTestVisibilityEvent3;
                            }
                        }
                        CompletableDeferred CompletableDeferred$default = CompletableDeferredKt.CompletableDeferred$default(null, 1, null);
                        PendingVisibilityWaiter pendingVisibilityWaiter2 = new PendingVisibilityWaiter(describeVisibilityWait(waitVisibility), function1, CompletableDeferred$default);
                        this.pendingVisibilityWaiters.add(pendingVisibilityWaiter2);
                        try {
                            if (waitVisibility.getTimeoutMs() == null) {
                                gameTestScriptRunner$waitForVisibility$1.L$0 = waitVisibility;
                                gameTestScriptRunner$waitForVisibility$1.L$1 = SpillingKt.nullOutSpilledVariable(function1);
                                gameTestScriptRunner$waitForVisibility$1.L$2 = SpillingKt.nullOutSpilledVariable(CompletableDeferred$default);
                                gameTestScriptRunner$waitForVisibility$1.L$3 = pendingVisibilityWaiter2;
                                gameTestScriptRunner$waitForVisibility$1.label = 1;
                                obj = CompletableDeferred$default.await(gameTestScriptRunner$waitForVisibility$1);
                                if (obj != coroutine_suspended) {
                                    waitVisibility2 = waitVisibility;
                                    pendingVisibilityWaiter = pendingVisibilityWaiter2;
                                    gameTestVisibilityEvent2 = (GameTestVisibilityEvent) obj;
                                }
                            } else {
                                gameTestScriptRunner$waitForVisibility$1.L$0 = waitVisibility;
                                gameTestScriptRunner$waitForVisibility$1.L$1 = SpillingKt.nullOutSpilledVariable(function1);
                                gameTestScriptRunner$waitForVisibility$1.L$2 = SpillingKt.nullOutSpilledVariable(CompletableDeferred$default);
                                gameTestScriptRunner$waitForVisibility$1.L$3 = pendingVisibilityWaiter2;
                                gameTestScriptRunner$waitForVisibility$1.label = 2;
                                obj = TimeoutKt.withTimeoutOrNull(waitVisibility.getTimeoutMs().longValue(), new GameTestScriptRunner$waitForVisibility$matchedEvent$1(CompletableDeferred$default, null), gameTestScriptRunner$waitForVisibility$1);
                                if (obj != coroutine_suspended) {
                                    waitVisibility2 = waitVisibility;
                                    pendingVisibilityWaiter = pendingVisibilityWaiter2;
                                    gameTestVisibilityEvent2 = (GameTestVisibilityEvent) obj;
                                }
                            }
                            return coroutine_suspended;
                        } catch (Throwable th) {
                            th = th;
                            waitVisibility = pendingVisibilityWaiter2;
                            this.pendingVisibilityWaiters.remove(waitVisibility);
                            throw th;
                        }
                    } else if (i == 1) {
                        pendingVisibilityWaiter = (PendingVisibilityWaiter) gameTestScriptRunner$waitForVisibility$1.L$3;
                        CompletableDeferred completableDeferred = (CompletableDeferred) gameTestScriptRunner$waitForVisibility$1.L$2;
                        Function1 function12 = (Function1) gameTestScriptRunner$waitForVisibility$1.L$1;
                        waitVisibility2 = (GameTestStep.WaitVisibility) gameTestScriptRunner$waitForVisibility$1.L$0;
                        ResultKt.throwOnFailure(obj);
                        gameTestVisibilityEvent2 = (GameTestVisibilityEvent) obj;
                    } else if (i != 2) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    } else {
                        pendingVisibilityWaiter = (PendingVisibilityWaiter) gameTestScriptRunner$waitForVisibility$1.L$3;
                        CompletableDeferred completableDeferred2 = (CompletableDeferred) gameTestScriptRunner$waitForVisibility$1.L$2;
                        Function1 function13 = (Function1) gameTestScriptRunner$waitForVisibility$1.L$1;
                        waitVisibility2 = (GameTestStep.WaitVisibility) gameTestScriptRunner$waitForVisibility$1.L$0;
                        ResultKt.throwOnFailure(obj);
                        gameTestVisibilityEvent2 = (GameTestVisibilityEvent) obj;
                    }
                    this.pendingVisibilityWaiters.remove(pendingVisibilityWaiter);
                    if (gameTestVisibilityEvent2 != null) {
                        String str = "Timed out waiting for visibility: " + describeVisibilityWait(waitVisibility2);
                        if (waitVisibility2.getFailOnTimeout()) {
                            throw new IllegalStateException(str);
                        }
                        this.runtime.log(str);
                        return gameTestVisibilityEvent2;
                    }
                    return gameTestVisibilityEvent2;
                }
            }
            if (i != 0) {
            }
            this.pendingVisibilityWaiters.remove(pendingVisibilityWaiter);
            if (gameTestVisibilityEvent2 != null) {
            }
        } catch (Throwable th2) {
            th = th2;
        }
        gameTestScriptRunner$waitForVisibility$1 = new GameTestScriptRunner$waitForVisibility$1(this, continuation);
        Object obj2 = gameTestScriptRunner$waitForVisibility$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = gameTestScriptRunner$waitForVisibility$1.label;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final boolean waitForVisibility$lambda$0(GameTestScriptRunner gameTestScriptRunner, GameTestStep.WaitVisibility waitVisibility, GameTestVisibilityEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        return gameTestScriptRunner.matchesVisibility(waitVisibility, event);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void registerBackendMessageListener(final GameTestBackendMessageListener gameTestBackendMessageListener) {
        CollectionsKt.removeAll((List) this.activeBackendMessageListeners, new Function1() { // from class: com.miami.game.core.settings.game_test.GameTestScriptRunner$$ExternalSyntheticLambda3
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
        for (PendingVisibilityWaiter pendingVisibilityWaiter : CollectionsKt.toList(this.pendingVisibilityWaiters)) {
            pendingVisibilityWaiter.getDeferred().cancel(new CancellationException("Game test script stopped"));
        }
        this.pendingVisibilityWaiters.clear();
        this.activeBackendMessageListeners.clear();
        for (Job job : CollectionsKt.toList(this.listenerReactionJobs)) {
            job.cancel(new CancellationException("Game test script stopped"));
        }
        this.listenerReactionJobs.clear();
        if (z) {
            this.recentBackendEvents.clear();
            this.recentVisibilityEvents.clear();
        }
    }

    private final boolean matchesVisibility(GameTestStep.WaitVisibility waitVisibility, GameTestVisibilityEvent gameTestVisibilityEvent) {
        if (gameTestVisibilityEvent.getVisible() != waitVisibility.getVisible()) {
            return false;
        }
        if (waitVisibility.getBackendId() != null) {
            Integer backendId = waitVisibility.getBackendId();
            int backendId2 = gameTestVisibilityEvent.getBackendId();
            if (backendId == null || backendId.intValue() != backendId2) {
                return false;
            }
        }
        String backendName = waitVisibility.getBackendName();
        return backendName == null || StringsKt.isBlank(backendName) || StringsKt.equals(waitVisibility.getBackendName(), gameTestVisibilityEvent.getBackendName(), true);
    }

    private final String describeVisibilityWait(GameTestStep.WaitVisibility waitVisibility) {
        List createListBuilder = CollectionsKt.createListBuilder();
        Integer backendId = waitVisibility.getBackendId();
        if (backendId != null) {
            createListBuilder.add("backendId=" + backendId.intValue());
        }
        String backendName = waitVisibility.getBackendName();
        if (backendName != null) {
            createListBuilder.add("backendName=" + backendName);
        }
        createListBuilder.add("visible=" + waitVisibility.getVisible());
        return CollectionsKt.joinToString$default(CollectionsKt.build(createListBuilder), null, null, null, 0, null, null, 63, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean isSpawnOfferEvent(GameTestBackendEvent gameTestBackendEvent) {
        return (StringsKt.equals(gameTestBackendEvent.getBackendName(), AUTHORIZATION_BACKEND_NAME, true) && gameTestBackendEvent.getSubId() == 8) || (StringsKt.equals(gameTestBackendEvent.getBackendName(), SPAWN_SELECTION_BACKEND_NAME, true) && gameTestBackendEvent.getSubId() == 0);
    }

    private final int resolveSpawnSelectionId(String str, int i) {
        int m9898constructorimpl;
        try {
            Result.Companion companion = Result.Companion;
            GameTestScriptRunner gameTestScriptRunner = this;
            JSONArray jSONArray = new JSONArray(str);
            IntRange until = RangesKt.until(0, jSONArray.length());
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(until, 10));
            Iterator<Integer> it = until.iterator();
            while (it.hasNext()) {
                arrayList.add(jSONArray.getJSONObject(((IntIterator) it).nextInt()));
            }
            JSONObject jSONObject = (JSONObject) CollectionsKt.getOrNull(CollectionsKt.sortedWith(arrayList, new Comparator() { // from class: com.miami.game.core.settings.game_test.GameTestScriptRunner$resolveSpawnSelectionId$lambda$0$$inlined$sortedByDescending$1
                @Override // java.util.Comparator
                public final int compare(T t, T t2) {
                    return ComparisonsKt.compareValues(Integer.valueOf(((JSONObject) t2).optInt("favorite", 0)), Integer.valueOf(((JSONObject) t).optInt("favorite", 0)));
                }
            }), i);
            m9898constructorimpl = Result.m9898constructorimpl(Integer.valueOf(jSONObject != null ? jSONObject.optInt("id") : 0));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            m9898constructorimpl = Result.m9898constructorimpl(ResultKt.createFailure(th));
        }
        Throwable m9901exceptionOrNullimpl = Result.m9901exceptionOrNullimpl(m9898constructorimpl);
        if (m9901exceptionOrNullimpl != null) {
            GameTestRuntime gameTestRuntime = this.runtime;
            String message = m9901exceptionOrNullimpl.getMessage();
            if (message == null) {
                message = "";
            }
            gameTestRuntime.log("Failed to parse SPAWN_SELECTION list, falling back to id=0: " + message);
            m9898constructorimpl = 0;
        }
        return ((Number) m9898constructorimpl).intValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: GameTestScriptRunner.kt */
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\b\n\u0002\b\u0002\b\u0082\b\u0018\u00002\u00020\u0001B1\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00060\t¢\u0006\u0004\b\n\u0010\u000bJ\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\u0015\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005HÆ\u0003J\u000f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00060\tHÆ\u0003J9\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u0014\b\u0002\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u00052\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00060\tHÆ\u0001J\u0014\u0010\u0016\u001a\u00020\u00072\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0018\u001a\u00020\u0019HÖ\u0081\u0004J\n\u0010\u001a\u001a\u00020\u0003HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u001d\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0017\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00060\t¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u001b"}, d2 = {"Lcom/miami/game/core/settings/game_test/GameTestScriptRunner$PendingBackendMessageWaiter;", "", "description", "", "matches", "Lkotlin/Function1;", "Lcom/miami/game/core/settings/game_test/GameTestBackendEvent;", "", "deferred", "Lkotlinx/coroutines/CompletableDeferred;", "<init>", "(Ljava/lang/String;Lkotlin/jvm/functions/Function1;Lkotlinx/coroutines/CompletableDeferred;)V", "getDescription", "()Ljava/lang/String;", "getMatches", "()Lkotlin/jvm/functions/Function1;", "getDeferred", "()Lkotlinx/coroutines/CompletableDeferred;", "component1", "component2", "component3", "copy", "equals", "other", "hashCode", "", "toString", "settings"}, k = 1, mv = {2, 4, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class PendingBackendMessageWaiter {
        private final CompletableDeferred<GameTestBackendEvent> deferred;
        private final String description;
        private final Function1<GameTestBackendEvent, Boolean> matches;

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ PendingBackendMessageWaiter copy$default(PendingBackendMessageWaiter pendingBackendMessageWaiter, String str, Function1 function1, CompletableDeferred completableDeferred, int i, Object obj) {
            if ((i & 1) != 0) {
                str = pendingBackendMessageWaiter.description;
            }
            if ((i & 2) != 0) {
                function1 = pendingBackendMessageWaiter.matches;
            }
            if ((i & 4) != 0) {
                completableDeferred = pendingBackendMessageWaiter.deferred;
            }
            return pendingBackendMessageWaiter.copy(str, function1, completableDeferred);
        }

        public final String component1() {
            return this.description;
        }

        public final Function1<GameTestBackendEvent, Boolean> component2() {
            return this.matches;
        }

        public final CompletableDeferred<GameTestBackendEvent> component3() {
            return this.deferred;
        }

        public final PendingBackendMessageWaiter copy(String description, Function1<? super GameTestBackendEvent, Boolean> matches, CompletableDeferred<GameTestBackendEvent> deferred) {
            Intrinsics.checkNotNullParameter(description, "description");
            Intrinsics.checkNotNullParameter(matches, "matches");
            Intrinsics.checkNotNullParameter(deferred, "deferred");
            return new PendingBackendMessageWaiter(description, matches, deferred);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof PendingBackendMessageWaiter) {
                PendingBackendMessageWaiter pendingBackendMessageWaiter = (PendingBackendMessageWaiter) obj;
                return Intrinsics.areEqual(this.description, pendingBackendMessageWaiter.description) && Intrinsics.areEqual(this.matches, pendingBackendMessageWaiter.matches) && Intrinsics.areEqual(this.deferred, pendingBackendMessageWaiter.deferred);
            }
            return false;
        }

        public int hashCode() {
            return (((this.description.hashCode() * 31) + this.matches.hashCode()) * 31) + this.deferred.hashCode();
        }

        public String toString() {
            String str = this.description;
            Function1<GameTestBackendEvent, Boolean> function1 = this.matches;
            return "PendingBackendMessageWaiter(description=" + str + ", matches=" + function1 + ", deferred=" + this.deferred + ")";
        }

        /* JADX WARN: Multi-variable type inference failed */
        public PendingBackendMessageWaiter(String description, Function1<? super GameTestBackendEvent, Boolean> matches, CompletableDeferred<GameTestBackendEvent> deferred) {
            Intrinsics.checkNotNullParameter(description, "description");
            Intrinsics.checkNotNullParameter(matches, "matches");
            Intrinsics.checkNotNullParameter(deferred, "deferred");
            this.description = description;
            this.matches = matches;
            this.deferred = deferred;
        }

        public final String getDescription() {
            return this.description;
        }

        public final Function1<GameTestBackendEvent, Boolean> getMatches() {
            return this.matches;
        }

        public final CompletableDeferred<GameTestBackendEvent> getDeferred() {
            return this.deferred;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: GameTestScriptRunner.kt */
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\b\n\u0002\b\u0002\b\u0082\b\u0018\u00002\u00020\u0001B1\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00060\t¢\u0006\u0004\b\n\u0010\u000bJ\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\u0015\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005HÆ\u0003J\u000f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00060\tHÆ\u0003J9\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u0014\b\u0002\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u00052\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00060\tHÆ\u0001J\u0014\u0010\u0016\u001a\u00020\u00072\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0018\u001a\u00020\u0019HÖ\u0081\u0004J\n\u0010\u001a\u001a\u00020\u0003HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u001d\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0017\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00060\t¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u001b"}, d2 = {"Lcom/miami/game/core/settings/game_test/GameTestScriptRunner$PendingVisibilityWaiter;", "", "description", "", "matches", "Lkotlin/Function1;", "Lcom/miami/game/core/settings/game_test/GameTestVisibilityEvent;", "", "deferred", "Lkotlinx/coroutines/CompletableDeferred;", "<init>", "(Ljava/lang/String;Lkotlin/jvm/functions/Function1;Lkotlinx/coroutines/CompletableDeferred;)V", "getDescription", "()Ljava/lang/String;", "getMatches", "()Lkotlin/jvm/functions/Function1;", "getDeferred", "()Lkotlinx/coroutines/CompletableDeferred;", "component1", "component2", "component3", "copy", "equals", "other", "hashCode", "", "toString", "settings"}, k = 1, mv = {2, 4, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class PendingVisibilityWaiter {
        private final CompletableDeferred<GameTestVisibilityEvent> deferred;
        private final String description;
        private final Function1<GameTestVisibilityEvent, Boolean> matches;

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ PendingVisibilityWaiter copy$default(PendingVisibilityWaiter pendingVisibilityWaiter, String str, Function1 function1, CompletableDeferred completableDeferred, int i, Object obj) {
            if ((i & 1) != 0) {
                str = pendingVisibilityWaiter.description;
            }
            if ((i & 2) != 0) {
                function1 = pendingVisibilityWaiter.matches;
            }
            if ((i & 4) != 0) {
                completableDeferred = pendingVisibilityWaiter.deferred;
            }
            return pendingVisibilityWaiter.copy(str, function1, completableDeferred);
        }

        public final String component1() {
            return this.description;
        }

        public final Function1<GameTestVisibilityEvent, Boolean> component2() {
            return this.matches;
        }

        public final CompletableDeferred<GameTestVisibilityEvent> component3() {
            return this.deferred;
        }

        public final PendingVisibilityWaiter copy(String description, Function1<? super GameTestVisibilityEvent, Boolean> matches, CompletableDeferred<GameTestVisibilityEvent> deferred) {
            Intrinsics.checkNotNullParameter(description, "description");
            Intrinsics.checkNotNullParameter(matches, "matches");
            Intrinsics.checkNotNullParameter(deferred, "deferred");
            return new PendingVisibilityWaiter(description, matches, deferred);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof PendingVisibilityWaiter) {
                PendingVisibilityWaiter pendingVisibilityWaiter = (PendingVisibilityWaiter) obj;
                return Intrinsics.areEqual(this.description, pendingVisibilityWaiter.description) && Intrinsics.areEqual(this.matches, pendingVisibilityWaiter.matches) && Intrinsics.areEqual(this.deferred, pendingVisibilityWaiter.deferred);
            }
            return false;
        }

        public int hashCode() {
            return (((this.description.hashCode() * 31) + this.matches.hashCode()) * 31) + this.deferred.hashCode();
        }

        public String toString() {
            String str = this.description;
            Function1<GameTestVisibilityEvent, Boolean> function1 = this.matches;
            return "PendingVisibilityWaiter(description=" + str + ", matches=" + function1 + ", deferred=" + this.deferred + ")";
        }

        /* JADX WARN: Multi-variable type inference failed */
        public PendingVisibilityWaiter(String description, Function1<? super GameTestVisibilityEvent, Boolean> matches, CompletableDeferred<GameTestVisibilityEvent> deferred) {
            Intrinsics.checkNotNullParameter(description, "description");
            Intrinsics.checkNotNullParameter(matches, "matches");
            Intrinsics.checkNotNullParameter(deferred, "deferred");
            this.description = description;
            this.matches = matches;
            this.deferred = deferred;
        }

        public final String getDescription() {
            return this.description;
        }

        public final Function1<GameTestVisibilityEvent, Boolean> getMatches() {
            return this.matches;
        }

        public final CompletableDeferred<GameTestVisibilityEvent> getDeferred() {
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
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u000b\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/miami/game/core/settings/game_test/GameTestScriptRunner$Companion;", "", "<init>", "()V", "TAG", "", "MAX_RECENT_BACKEND_EVENTS", "", "MAX_RECENT_VISIBILITY_EVENTS", "AUTHORIZATION_BACKEND_NAME", "SPAWN_SELECTION_BACKEND_NAME", "AUTHORIZATION_INIT_SUB_ID", "AUTHORIZATION_SELECT_SPAWN_DATA_SUB_ID", "AUTHORIZATION_SELECT_SPAWN_CLICK_ID", "AUTHORIZATION_SELECT_SPAWN_SUB_ID", "SPAWN_SELECTION_LIST_SUB_ID", "SPAWN_SELECTION_SELECT_SUB_ID", "DEFAULT_SPAWN_ID", "settings"}, k = 1, mv = {2, 4, 0}, xi = 48)
    /* loaded from: classes5.dex */
    private static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
