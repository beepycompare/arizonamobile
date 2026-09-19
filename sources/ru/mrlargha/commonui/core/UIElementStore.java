package ru.mrlargha.commonui.core;

import android.app.Activity;
import android.app.ActivityManager;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.util.Log;
import androidx.exifinterface.media.ExifInterface;
import androidx.window.core.layout.WindowSizeClass;
import com.arizona.launcher.updater.archive.download.ArchiveNetworkMonitorKt;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import ru.mrlargha.commonui.core.UIElementCompanionFlowTracker;
import ru.mrlargha.commonui.core.cache.SessionHotsetEviction;
import ru.mrlargha.commonui.core.cache.SessionHotsetEvictionReason;
import ru.mrlargha.commonui.core.cache.SessionHotsetHideDecision;
import ru.mrlargha.commonui.core.cache.SessionHotsetPolicy;
import ru.mrlargha.commonui.core.cache.SessionHotsetSnapshot;
import ru.mrlargha.commonui.core.cache.UIElementCachePolicy;
import ru.mrlargha.commonui.core.cache.UIElementEvictionReason;
import ru.mrlargha.commonui.core.cache.UIElementRetentionPolicy;
/* compiled from: UIElementStore.kt */
@Metadata(d1 = {"\u0000¨\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010#\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\"\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0018\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 |2\u00020\u0001:\u0002{|B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000e\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020\bJ\u001f\u0010(\u001a\u0002H)\"\u0004\b\u0000\u0010)2\u0006\u0010*\u001a\u00020\u000bH\u0007b\u0002\b,¢\u0006\u0002\u0010+J'\u0010-\u001a\u0002H)\"\u0004\b\u0000\u0010)2\u0006\u0010*\u001a\u00020\u000b2\u0006\u0010.\u001a\u00020\u0012H\u0003b\u0002\b,¢\u0006\u0002\u0010/J\u000e\u00100\u001a\u00020\u00122\u0006\u0010*\u001a\u00020\u000bJ\u000e\u00101\u001a\u00020\u00122\u0006\u0010*\u001a\u00020\u000bJ\b\u00102\u001a\u0004\u0018\u00010\u000bJ\u0006\u00103\u001a\u00020\u0012J\u0010\u00104\u001a\u0004\u0018\u0001052\u0006\u0010*\u001a\u00020\u000bJ\u0016\u00106\u001a\u0004\u0018\u0001052\u0006\u0010*\u001a\u00020\u000bH\u0007b\u0002\b,J\u0016\u00107\u001a\u0004\u0018\u0001052\u0006\u0010*\u001a\u00020\u000bH\u0007b\u0002\b,J$\u00108\u001a\u00020\u00122\u0006\u0010*\u001a\u00020\u000b2\u0006\u00109\u001a\u00020:2\u0006\u0010;\u001a\u00020\"H\u0007b\u0002\b,J$\u0010<\u001a\u00020\u00122\u0006\u0010*\u001a\u00020\u000b2\u0006\u00109\u001a\u00020:2\u0006\u0010;\u001a\u00020\"H\u0003b\u0002\b,J$\u0010=\u001a\u00020\u00122\u0006\u0010*\u001a\u00020\u000b2\u0006\u00109\u001a\u00020:2\u0006\u0010;\u001a\u00020\"H\u0007b\u0002\b,J(\u0010>\u001a\u00020\u00122\u0006\u0010*\u001a\u00020\u000b2\u0006\u00109\u001a\u00020:2\u0006\u0010;\u001a\u00020\"2\u0006\u0010?\u001a\u00020\u0012H\u0002J\u0010\u0010@\u001a\u00020&2\u0006\u0010*\u001a\u00020\u000bH\u0002J\u0010\u0010A\u001a\u00020&2\u0006\u0010*\u001a\u00020\u000bH\u0002J\u000e\u0010B\u001a\u0002052\u0006\u0010*\u001a\u00020\u000bJ\u001c\u0010C\u001a\u00020\u00122\u0006\u0010*\u001a\u00020\u000b2\u0006\u0010D\u001a\u00020\u0012H\u0007b\u0002\b,J\u0014\u0010E\u001a\u00020&2\u0006\u0010*\u001a\u00020\u000bH\u0007b\u0002\b,J\u0014\u0010E\u001a\u00020&2\u0006\u0010F\u001a\u000205H\u0007b\u0002\b,J\f\u0010G\u001a\u00020\"H\u0007b\u0002\b,J\f\u0010H\u001a\u00020&H\u0007b\u0002\b,J\f\u0010I\u001a\u00020&H\u0007b\u0002\b,J\u0018\u0010J\u001a\u00020&2\u0006\u0010*\u001a\u00020\u000b2\u0006\u0010K\u001a\u00020\fH\u0002J(\u0010L\u001a\u00020\u00122\u0006\u0010*\u001a\u00020\u000b2\u0006\u0010K\u001a\u00020\f2\u0006\u0010D\u001a\u00020\u00122\u0006\u0010M\u001a\u00020\u0012H\u0002J*\u0010N\u001a\u00020&2\u0006\u0010*\u001a\u00020\u000b2\u0006\u0010K\u001a\u00020\f2\u0006\u0010O\u001a\u00020\u00122\b\b\u0002\u0010P\u001a\u00020\u0012H\u0002J \u0010Q\u001a\u00020&2\u0006\u0010*\u001a\u00020\u000b2\u0006\u0010K\u001a\u00020\f2\u0006\u0010P\u001a\u00020\u0012H\u0002J\u0018\u0010R\u001a\u00020&2\u0006\u0010*\u001a\u00020\u000b2\u0006\u0010S\u001a\u00020\u001fH\u0002J\b\u0010T\u001a\u00020&H\u0002J\u0010\u0010U\u001a\u00020&2\u0006\u0010*\u001a\u00020\u000bH\u0002J\u0018\u0010V\u001a\u00020&2\u0006\u0010*\u001a\u00020\u000b2\u0006\u0010K\u001a\u00020\fH\u0002J\u0010\u0010W\u001a\u00020&2\u0006\u0010*\u001a\u00020\u000bH\u0002J\u0018\u0010X\u001a\u00020&2\u0006\u0010*\u001a\u00020\u000b2\u0006\u0010K\u001a\u00020\fH\u0002J\u0018\u0010Y\u001a\u00020&2\u0006\u0010*\u001a\u00020\u000b2\u0006\u0010Z\u001a\u00020\fH\u0002J\u001c\u0010[\u001a\u00020\"2\u0012\u0010\\\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0^0]H\u0002J\u0010\u0010_\u001a\u00020\"2\u0006\u0010`\u001a\u00020aH\u0002J1\u0010b\u001a\u00020\u00122\u0006\u0010*\u001a\u00020\u000b2\u0006\u0010Z\u001a\u00020\f2\u0006\u0010`\u001a\u00020a2\n\b\u0002\u0010c\u001a\u0004\u0018\u00010\u001fH\u0002¢\u0006\u0002\u0010dJ\u001a\u0010e\u001a\u00020&2\u0006\u0010*\u001a\u00020\u000b2\b\u0010Z\u001a\u0004\u0018\u00010\fH\u0002J\u0018\u0010f\u001a\u00020\u00122\u0006\u0010*\u001a\u00020\u000b2\u0006\u0010Z\u001a\u00020\fH\u0002J\u0010\u0010g\u001a\u00020&2\u0006\u0010K\u001a\u00020\fH\u0002J\u0010\u0010h\u001a\u00020&2\u0006\u0010K\u001a\u00020\fH\u0002J \u0010i\u001a\u00020&2\u0006\u0010K\u001a\u00020\f2\u0006\u0010`\u001a\u00020a2\u0006\u0010j\u001a\u00020\u0012H\u0002J\u0018\u0010k\u001a\u00020\u00122\u0006\u0010*\u001a\u00020\u000b2\u0006\u0010K\u001a\u00020\fH\u0002J\u0018\u0010l\u001a\u00020\u00122\u0006\u0010*\u001a\u00020\u000b2\u0006\u0010K\u001a\u00020\fH\u0002J \u0010m\u001a\u00020\u00122\u0006\u0010*\u001a\u00020\u000b2\u0006\u0010K\u001a\u00020\f2\u0006\u0010`\u001a\u00020aH\u0002J\b\u0010n\u001a\u00020\u0012H\u0002J\b\u0010o\u001a\u00020&H\u0002J\b\u0010p\u001a\u00020&H\u0002J\b\u0010q\u001a\u00020&H\u0002J\u0010\u0010r\u001a\u00020&2\u0006\u0010*\u001a\u00020\u000bH\u0002J\b\u0010s\u001a\u00020&H\u0002J\u0018\u0010t\u001a\u00020&2\u0006\u0010u\u001a\u00020:2\u0006\u0010v\u001a\u00020\"H\u0002J\b\u0010w\u001a\u00020\u001fH\u0002J\b\u0010x\u001a\u00020\u001fH\u0002J\f\u0010y\u001a\u00020a*\u00020zH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f0\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000e0\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00120\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0018X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u001aX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u001cX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u001fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010!\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\"0\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010#\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006}"}, d2 = {"Lru/mrlargha/commonui/core/UIElementStore;", "", "targetActivity", "Landroid/app/Activity;", "<init>", "(Landroid/app/Activity;)V", "factories", "", "Lru/mrlargha/commonui/core/UIElementFactory;", "uiElementsMap", "", "Lru/mrlargha/commonui/core/UIElementID;", "Lru/mrlargha/commonui/core/UIElementStore$CacheEntry;", "pendingDisposals", "Ljava/lang/Runnable;", "evictedElementIds", "", "desiredVisibilityById", "", "companionFlowTracker", "Lru/mrlargha/commonui/core/UIElementCompanionFlowTracker;", "cachePolicy", "Lru/mrlargha/commonui/core/cache/UIElementCachePolicy;", "sessionHotset", "Lru/mrlargha/commonui/core/cache/SessionHotsetPolicy;", "mainHandler", "Landroid/os/Handler;", "memoryInfo", "Landroid/app/ActivityManager$MemoryInfo;", "maintenanceRunnable", "nextEntryToken", "", "isHostDestroyed", "inFlightDepthById", "", "pendingCompanionFlowTimeout", "maintenanceScheduled", "addFactory", "", "factory", "getOrCreate", ExifInterface.GPS_DIRECTION_TRUE, "elementID", "(Lru/mrlargha/commonui/core/UIElementID;)Ljava/lang/Object;", "Landroidx/annotation/MainThread;", "getOrCreateInternal", "backendPayloadInFlight", "(Lru/mrlargha/commonui/core/UIElementID;Z)Ljava/lang/Object;", "isElementExist", "isElementVisible", "getInventoryCompanionPayloadTarget", "isHostActive", "getExisting", "Lru/mrlargha/commonui/core/SAMPUIElement;", "getForBackendMessage", "getForPassiveBackendMessage", "deliverBackendMessage", "data", "", "subId", "deliverBackendMessageStartingOpenFlow", "deliverPassiveBackendMessage", "deliverBackendMessageInternal", "passive", "beginInFlight", "finishInFlight", "getOrCreateDefault", "setElementVisibility", "visible", "removeElement", "element", "trimHiddenElements", "onHostResumed", "clearForHostDestroy", "attachObservers", "entry", "handleVisibilityChanged", "forceShow", "enterHiddenState", "isUserTransition", "mustAdmit", "admitToIdleCache", "schedulePendingCompanionFlowTimeout", "pendingGeneration", "cancelPendingCompanionFlowTimeout", "resolveCompanionFlow", "leaveHiddenState", "reconcileHiddenEntry", "withdrawFromIdleCache", "scheduleDisposeOnHide", "expectedEntry", "processPolicyEvictions", "evictions", "", "Lru/mrlargha/commonui/core/cache/SessionHotsetEviction;", "evictAllSafeIdle", "reason", "Lru/mrlargha/commonui/core/cache/UIElementEvictionReason;", "evictExactEntry", "hiddenRetainedMs", "(Lru/mrlargha/commonui/core/UIElementID;Lru/mrlargha/commonui/core/UIElementStore$CacheEntry;Lru/mrlargha/commonui/core/cache/UIElementEvictionReason;Ljava/lang/Long;)Z", "removeElementInternal", "removeExactEntry", "invokeHiddenHook", "invokeShownHook", "disposeEntry", "notifyBackendHidden", "isIdleCacheEligible", "isProtectedFromAutomaticEviction", "canAutomaticallyEvict", "isUnderMemoryPressure", "runMaintenance", "scheduleMaintenance", "cancelMaintenance", "cancelPendingDisposal", "cancelAllPendingDisposals", "logHotsetSummary", "trigger", "evictedCount", "nextToken", "nowMs", "toStoreReason", "Lru/mrlargha/commonui/core/cache/SessionHotsetEvictionReason;", "CacheEntry", "Companion", "CommonUI"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class UIElementStore {
    public static final Companion Companion = new Companion(null);
    private static final long MAINTENANCE_PRESSURE_INTERVAL_MS = 30000;
    private static final long MIN_HEADROOM_BYTES = 16777216;
    private static final long MISSING_ENTRY_TOKEN = Long.MIN_VALUE;
    private static final long PENDING_OPEN_TIMEOUT_MS = 30000;
    private static final String TAG = "UIElementStore";
    private final UIElementCachePolicy cachePolicy;
    private final UIElementCompanionFlowTracker<UIElementID> companionFlowTracker;
    private final Map<UIElementID, Boolean> desiredVisibilityById;
    private final Set<UIElementID> evictedElementIds;
    private final List<UIElementFactory> factories;
    private final Map<UIElementID, Integer> inFlightDepthById;
    private boolean isHostDestroyed;
    private final Handler mainHandler;
    private final Runnable maintenanceRunnable;
    private boolean maintenanceScheduled;
    private final ActivityManager.MemoryInfo memoryInfo;
    private long nextEntryToken;
    private Runnable pendingCompanionFlowTimeout;
    private final Map<UIElementID, Runnable> pendingDisposals;
    private final SessionHotsetPolicy<UIElementID> sessionHotset;
    private final Activity targetActivity;
    private final Map<UIElementID, CacheEntry> uiElementsMap;

    /* compiled from: UIElementStore.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    /* loaded from: classes6.dex */
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;

        static {
            int[] iArr = new int[UIElementRetentionPolicy.values().length];
            try {
                iArr[UIElementRetentionPolicy.PINNED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[UIElementRetentionPolicy.DISPOSE_ON_HIDE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[UIElementRetentionPolicy.SESSION_HOTSET.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
            int[] iArr2 = new int[SessionHotsetEvictionReason.values().length];
            try {
                iArr2[SessionHotsetEvictionReason.TTL.ordinal()] = 1;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr2[SessionHotsetEvictionReason.CAPACITY.ordinal()] = 2;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr2[SessionHotsetEvictionReason.MEMORY_PRESSURE.ordinal()] = 3;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr2[SessionHotsetEvictionReason.EXPLICIT.ordinal()] = 4;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                iArr2[SessionHotsetEvictionReason.REPLACED.ordinal()] = 5;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                iArr2[SessionHotsetEvictionReason.HOST_DESTROY.ordinal()] = 6;
            } catch (NoSuchFieldError unused9) {
            }
            $EnumSwitchMapping$1 = iArr2;
        }
    }

    public UIElementStore(Activity targetActivity) {
        Intrinsics.checkNotNullParameter(targetActivity, "targetActivity");
        this.targetActivity = targetActivity;
        this.factories = new ArrayList();
        this.uiElementsMap = new LinkedHashMap();
        this.pendingDisposals = new LinkedHashMap();
        this.evictedElementIds = new LinkedHashSet();
        this.desiredVisibilityById = new LinkedHashMap();
        this.companionFlowTracker = new UIElementCompanionFlowTracker<>();
        this.cachePolicy = new UIElementCachePolicy(null, null, 3, null);
        this.sessionHotset = new SessionHotsetPolicy<>(0, 0L, 3, null);
        this.mainHandler = new Handler(Looper.getMainLooper());
        this.memoryInfo = new ActivityManager.MemoryInfo();
        this.maintenanceRunnable = new Runnable() { // from class: ru.mrlargha.commonui.core.UIElementStore$$ExternalSyntheticLambda3
            @Override // java.lang.Runnable
            public final void run() {
                UIElementStore.this.runMaintenance();
            }
        };
        this.inFlightDepthById = new LinkedHashMap();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: UIElementStore.kt */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b0\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0082\b\u0018\u00002\u00020\u0001Bm\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\f\u001a\u00020\t\u0012\b\b\u0002\u0010\r\u001a\u00020\t\u0012\b\b\u0002\u0010\u000e\u001a\u00020\t\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0010\u0010\u0011J\t\u0010*\u001a\u00020\u0003HÆ\u0003J\t\u0010+\u001a\u00020\u0005HÆ\u0003J\t\u0010,\u001a\u00020\u0003HÆ\u0003J\t\u0010-\u001a\u00020\u0003HÆ\u0003J\t\u0010.\u001a\u00020\tHÆ\u0003J\t\u0010/\u001a\u00020\u0003HÆ\u0003J\t\u00100\u001a\u00020\u0003HÆ\u0003J\t\u00101\u001a\u00020\tHÆ\u0003J\t\u00102\u001a\u00020\tHÆ\u0003J\t\u00103\u001a\u00020\tHÆ\u0003J\u0010\u00104\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010&J~\u00105\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\u00032\b\b\u0002\u0010\f\u001a\u00020\t2\b\b\u0002\u0010\r\u001a\u00020\t2\b\b\u0002\u0010\u000e\u001a\u00020\t2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u00106J\u0014\u00107\u001a\u00020\t2\b\u00108\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u00109\u001a\u00020:HÖ\u0081\u0004J\n\u0010;\u001a\u00020<HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0013R\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0013R\u001a\u0010\b\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u001a\u0010\n\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0013\"\u0004\b\u001d\u0010\u001eR\u001a\u0010\u000b\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u0013\"\u0004\b \u0010\u001eR\u001a\u0010\f\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\u0019\"\u0004\b!\u0010\u001bR\u001a\u0010\r\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u0019\"\u0004\b\"\u0010\u001bR\u001a\u0010\u000e\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\u0019\"\u0004\b$\u0010\u001bR\u001e\u0010\u000f\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0002\u0010)\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(¨\u0006="}, d2 = {"Lru/mrlargha/commonui/core/UIElementStore$CacheEntry;", "", "token", "", "element", "Lru/mrlargha/commonui/core/SAMPUIElement;", "createdAtMs", "creationDurationMs", "logicalVisible", "", "visibilityCallbackVersion", "logicalTransitionVersion", "isInHiddenCache", "isHiddenHookApplied", "hasCompletedShow", "actualHiddenAtMs", "<init>", "(JLru/mrlargha/commonui/core/SAMPUIElement;JJZJJZZZLjava/lang/Long;)V", "getToken", "()J", "getElement", "()Lru/mrlargha/commonui/core/SAMPUIElement;", "getCreatedAtMs", "getCreationDurationMs", "getLogicalVisible", "()Z", "setLogicalVisible", "(Z)V", "getVisibilityCallbackVersion", "setVisibilityCallbackVersion", "(J)V", "getLogicalTransitionVersion", "setLogicalTransitionVersion", "setInHiddenCache", "setHiddenHookApplied", "getHasCompletedShow", "setHasCompletedShow", "getActualHiddenAtMs", "()Ljava/lang/Long;", "setActualHiddenAtMs", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "copy", "(JLru/mrlargha/commonui/core/SAMPUIElement;JJZJJZZZLjava/lang/Long;)Lru/mrlargha/commonui/core/UIElementStore$CacheEntry;", "equals", "other", "hashCode", "", "toString", "", "CommonUI"}, k = 1, mv = {2, 4, 0}, xi = 48)
    /* loaded from: classes6.dex */
    public static final class CacheEntry {
        private Long actualHiddenAtMs;
        private final long createdAtMs;
        private final long creationDurationMs;
        private final SAMPUIElement element;
        private boolean hasCompletedShow;
        private boolean isHiddenHookApplied;
        private boolean isInHiddenCache;
        private long logicalTransitionVersion;
        private boolean logicalVisible;
        private final long token;
        private long visibilityCallbackVersion;

        public static /* synthetic */ CacheEntry copy$default(CacheEntry cacheEntry, long j, SAMPUIElement sAMPUIElement, long j2, long j3, boolean z, long j4, long j5, boolean z2, boolean z3, boolean z4, Long l, int i, Object obj) {
            long j6 = (i & 1) != 0 ? cacheEntry.token : j;
            return cacheEntry.copy(j6, (i & 2) != 0 ? cacheEntry.element : sAMPUIElement, (i & 4) != 0 ? cacheEntry.createdAtMs : j2, (i & 8) != 0 ? cacheEntry.creationDurationMs : j3, (i & 16) != 0 ? cacheEntry.logicalVisible : z, (i & 32) != 0 ? cacheEntry.visibilityCallbackVersion : j4, (i & 64) != 0 ? cacheEntry.logicalTransitionVersion : j5, (i & 128) != 0 ? cacheEntry.isInHiddenCache : z2, (i & 256) != 0 ? cacheEntry.isHiddenHookApplied : z3, (i & 512) != 0 ? cacheEntry.hasCompletedShow : z4, (i & 1024) != 0 ? cacheEntry.actualHiddenAtMs : l);
        }

        public final long component1() {
            return this.token;
        }

        public final boolean component10() {
            return this.hasCompletedShow;
        }

        public final Long component11() {
            return this.actualHiddenAtMs;
        }

        public final SAMPUIElement component2() {
            return this.element;
        }

        public final long component3() {
            return this.createdAtMs;
        }

        public final long component4() {
            return this.creationDurationMs;
        }

        public final boolean component5() {
            return this.logicalVisible;
        }

        public final long component6() {
            return this.visibilityCallbackVersion;
        }

        public final long component7() {
            return this.logicalTransitionVersion;
        }

        public final boolean component8() {
            return this.isInHiddenCache;
        }

        public final boolean component9() {
            return this.isHiddenHookApplied;
        }

        public final CacheEntry copy(long j, SAMPUIElement element, long j2, long j3, boolean z, long j4, long j5, boolean z2, boolean z3, boolean z4, Long l) {
            Intrinsics.checkNotNullParameter(element, "element");
            return new CacheEntry(j, element, j2, j3, z, j4, j5, z2, z3, z4, l);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof CacheEntry) {
                CacheEntry cacheEntry = (CacheEntry) obj;
                return this.token == cacheEntry.token && Intrinsics.areEqual(this.element, cacheEntry.element) && this.createdAtMs == cacheEntry.createdAtMs && this.creationDurationMs == cacheEntry.creationDurationMs && this.logicalVisible == cacheEntry.logicalVisible && this.visibilityCallbackVersion == cacheEntry.visibilityCallbackVersion && this.logicalTransitionVersion == cacheEntry.logicalTransitionVersion && this.isInHiddenCache == cacheEntry.isInHiddenCache && this.isHiddenHookApplied == cacheEntry.isHiddenHookApplied && this.hasCompletedShow == cacheEntry.hasCompletedShow && Intrinsics.areEqual(this.actualHiddenAtMs, cacheEntry.actualHiddenAtMs);
            }
            return false;
        }

        public int hashCode() {
            int hashCode = ((((((((((((((((((Long.hashCode(this.token) * 31) + this.element.hashCode()) * 31) + Long.hashCode(this.createdAtMs)) * 31) + Long.hashCode(this.creationDurationMs)) * 31) + Boolean.hashCode(this.logicalVisible)) * 31) + Long.hashCode(this.visibilityCallbackVersion)) * 31) + Long.hashCode(this.logicalTransitionVersion)) * 31) + Boolean.hashCode(this.isInHiddenCache)) * 31) + Boolean.hashCode(this.isHiddenHookApplied)) * 31) + Boolean.hashCode(this.hasCompletedShow)) * 31;
            Long l = this.actualHiddenAtMs;
            return hashCode + (l == null ? 0 : l.hashCode());
        }

        public String toString() {
            long j = this.token;
            SAMPUIElement sAMPUIElement = this.element;
            long j2 = this.createdAtMs;
            long j3 = this.creationDurationMs;
            boolean z = this.logicalVisible;
            long j4 = this.visibilityCallbackVersion;
            long j5 = this.logicalTransitionVersion;
            boolean z2 = this.isInHiddenCache;
            boolean z3 = this.isHiddenHookApplied;
            boolean z4 = this.hasCompletedShow;
            return "CacheEntry(token=" + j + ", element=" + sAMPUIElement + ", createdAtMs=" + j2 + ", creationDurationMs=" + j3 + ", logicalVisible=" + z + ", visibilityCallbackVersion=" + j4 + ", logicalTransitionVersion=" + j5 + ", isInHiddenCache=" + z2 + ", isHiddenHookApplied=" + z3 + ", hasCompletedShow=" + z4 + ", actualHiddenAtMs=" + this.actualHiddenAtMs + ")";
        }

        public CacheEntry(long j, SAMPUIElement element, long j2, long j3, boolean z, long j4, long j5, boolean z2, boolean z3, boolean z4, Long l) {
            Intrinsics.checkNotNullParameter(element, "element");
            this.token = j;
            this.element = element;
            this.createdAtMs = j2;
            this.creationDurationMs = j3;
            this.logicalVisible = z;
            this.visibilityCallbackVersion = j4;
            this.logicalTransitionVersion = j5;
            this.isInHiddenCache = z2;
            this.isHiddenHookApplied = z3;
            this.hasCompletedShow = z4;
            this.actualHiddenAtMs = l;
        }

        public /* synthetic */ CacheEntry(long j, SAMPUIElement sAMPUIElement, long j2, long j3, boolean z, long j4, long j5, boolean z2, boolean z3, boolean z4, Long l, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(j, sAMPUIElement, j2, j3, z, (i & 32) != 0 ? 0L : j4, (i & 64) != 0 ? 0L : j5, (i & 128) != 0 ? false : z2, (i & 256) != 0 ? false : z3, (i & 512) != 0 ? false : z4, (i & 1024) != 0 ? null : l);
        }

        public final long getToken() {
            return this.token;
        }

        public final SAMPUIElement getElement() {
            return this.element;
        }

        public final long getCreatedAtMs() {
            return this.createdAtMs;
        }

        public final long getCreationDurationMs() {
            return this.creationDurationMs;
        }

        public final boolean getLogicalVisible() {
            return this.logicalVisible;
        }

        public final void setLogicalVisible(boolean z) {
            this.logicalVisible = z;
        }

        public final long getVisibilityCallbackVersion() {
            return this.visibilityCallbackVersion;
        }

        public final void setVisibilityCallbackVersion(long j) {
            this.visibilityCallbackVersion = j;
        }

        public final long getLogicalTransitionVersion() {
            return this.logicalTransitionVersion;
        }

        public final void setLogicalTransitionVersion(long j) {
            this.logicalTransitionVersion = j;
        }

        public final boolean isInHiddenCache() {
            return this.isInHiddenCache;
        }

        public final void setInHiddenCache(boolean z) {
            this.isInHiddenCache = z;
        }

        public final boolean isHiddenHookApplied() {
            return this.isHiddenHookApplied;
        }

        public final void setHiddenHookApplied(boolean z) {
            this.isHiddenHookApplied = z;
        }

        public final boolean getHasCompletedShow() {
            return this.hasCompletedShow;
        }

        public final void setHasCompletedShow(boolean z) {
            this.hasCompletedShow = z;
        }

        public final Long getActualHiddenAtMs() {
            return this.actualHiddenAtMs;
        }

        public final void setActualHiddenAtMs(Long l) {
            this.actualHiddenAtMs = l;
        }
    }

    public final void addFactory(UIElementFactory factory) {
        Intrinsics.checkNotNullParameter(factory, "factory");
        this.factories.add(factory);
    }

    public final <T> T getOrCreate(UIElementID elementID) {
        Intrinsics.checkNotNullParameter(elementID, "elementID");
        return (T) getOrCreateInternal(elementID, false);
    }

    private final <T> T getOrCreateInternal(UIElementID uIElementID, boolean z) {
        Long l;
        SAMPUIElement sAMPUIElement;
        if (this.isHostDestroyed) {
            throw new IllegalStateException(("Cannot create " + uIElementID + " after the UI host was destroyed").toString());
        }
        CacheEntry cacheEntry = this.uiElementsMap.get(uIElementID);
        if (cacheEntry != null) {
            return (T) cacheEntry.getElement();
        }
        beginInFlight(uIElementID);
        try {
            if (isUnderMemoryPressure()) {
                trimHiddenElements();
            }
            Log.d(TAG, "getOrCreate: unable to find view with id: " + uIElementID + ", creating...");
            long nowMs = nowMs();
            Iterator<UIElementFactory> it = this.factories.iterator();
            while (true) {
                l = null;
                if (!it.hasNext()) {
                    sAMPUIElement = null;
                    break;
                }
                try {
                    sAMPUIElement = it.next().create(uIElementID, this.targetActivity);
                } catch (Exception e) {
                    Log.e(TAG, "getOrCreate: unable to create view with id: " + uIElementID, e);
                }
                if (sAMPUIElement != null) {
                    break;
                }
            }
            if (sAMPUIElement == null) {
                throw new IllegalArgumentException("Unable to create element " + uIElementID + " - unable to find a suitable element spawner");
            }
            long nowMs2 = nowMs();
            Boolean bool = this.desiredVisibilityById.get(uIElementID);
            boolean booleanValue = bool != null ? bool.booleanValue() : sAMPUIElement.isOnScreen();
            if (Intrinsics.areEqual((Object) bool, (Object) false)) {
                sAMPUIElement.applyStoreVisibilitySilently$CommonUI(false);
            }
            long nextToken = nextToken();
            long j = nowMs2 - nowMs;
            if (!booleanValue && !sAMPUIElement.isOnScreen()) {
                l = Long.valueOf(nowMs2);
            }
            Long l2 = l;
            SAMPUIElement sAMPUIElement2 = sAMPUIElement;
            CacheEntry cacheEntry2 = new CacheEntry(nextToken, sAMPUIElement2, nowMs2, j, booleanValue, 0L, 0L, false, false, booleanValue, l2, WindowSizeClass.HEIGHT_DP_MEDIUM_LOWER_BOUND, null);
            this.uiElementsMap.put(uIElementID, cacheEntry2);
            attachObservers(uIElementID, cacheEntry2);
            if (!booleanValue) {
                enterHiddenState(uIElementID, cacheEntry2, false, z);
            }
            if (isUnderMemoryPressure()) {
                trimHiddenElements();
            }
            boolean remove = this.evictedElementIds.remove(uIElementID);
            Log.i(TAG, "hotsetEvent id=" + uIElementID + " event=CREATE token=" + cacheEntry2.getToken() + " creationMs=" + cacheEntry2.getCreationDurationMs() + " recreatedAfterEviction=" + remove + " requestedVisibility=" + bool + " initialVisible=" + booleanValue + " storeSize=" + this.uiElementsMap.size());
            return (T) sAMPUIElement2;
        } finally {
            finishInFlight(uIElementID);
        }
    }

    public final boolean isElementExist(UIElementID elementID) {
        Intrinsics.checkNotNullParameter(elementID, "elementID");
        return this.uiElementsMap.get(elementID) != null;
    }

    public final boolean isElementVisible(UIElementID elementID) {
        Intrinsics.checkNotNullParameter(elementID, "elementID");
        CacheEntry cacheEntry = this.uiElementsMap.get(elementID);
        return cacheEntry != null && cacheEntry.getLogicalVisible() && !Intrinsics.areEqual((Object) this.desiredVisibilityById.get(elementID), (Object) false) && cacheEntry.getElement().isOnScreen();
    }

    public final UIElementID getInventoryCompanionPayloadTarget() {
        return this.companionFlowTracker.companionPayloadTarget(new UIElementStore$getInventoryCompanionPayloadTarget$1(this));
    }

    public final boolean isHostActive() {
        return !this.isHostDestroyed;
    }

    public final SAMPUIElement getExisting(UIElementID elementID) {
        CacheEntry cacheEntry;
        Intrinsics.checkNotNullParameter(elementID, "elementID");
        if (this.isHostDestroyed || (cacheEntry = this.uiElementsMap.get(elementID)) == null) {
            return null;
        }
        return cacheEntry.getElement();
    }

    public final SAMPUIElement getForBackendMessage(UIElementID elementID) {
        Intrinsics.checkNotNullParameter(elementID, "elementID");
        if (this.isHostDestroyed) {
            return null;
        }
        return (SAMPUIElement) getOrCreateInternal(elementID, true);
    }

    public final SAMPUIElement getForPassiveBackendMessage(UIElementID elementID) {
        Intrinsics.checkNotNullParameter(elementID, "elementID");
        if (this.isHostDestroyed) {
            return null;
        }
        if (Intrinsics.areEqual((Object) this.desiredVisibilityById.get(elementID), (Object) false) && !isElementExist(elementID)) {
            Log.d(TAG, "hotsetEvent id=" + elementID + " event=SKIP_PASSIVE_PAYLOAD");
            return null;
        }
        return (SAMPUIElement) getOrCreateInternal(elementID, true);
    }

    public final boolean deliverBackendMessage(UIElementID elementID, String data, int i) {
        Intrinsics.checkNotNullParameter(elementID, "elementID");
        Intrinsics.checkNotNullParameter(data, "data");
        if (UIElementCompanionFlowPolicy.INSTANCE.startsPendingOpen(elementID, i)) {
            return deliverBackendMessageStartingOpenFlow(elementID, data, i);
        }
        return deliverBackendMessageInternal(elementID, data, i, false);
    }

    private final boolean deliverBackendMessageStartingOpenFlow(UIElementID uIElementID, String str, int i) {
        if (this.isHostDestroyed) {
            return false;
        }
        UIElementID pendingOpenKey = this.companionFlowTracker.pendingOpenKey();
        if (pendingOpenKey != null) {
            beginInFlight(pendingOpenKey);
        }
        UIElementCompanionFlowTracker.PendingOpen<UIElementID> beginPendingOpen = this.companionFlowTracker.beginPendingOpen(uIElementID);
        CacheEntry cacheEntry = this.uiElementsMap.get(uIElementID);
        if (cacheEntry != null) {
            withdrawFromIdleCache(uIElementID, cacheEntry);
        }
        try {
            boolean deliverBackendMessageInternal = deliverBackendMessageInternal(uIElementID, str, i, false);
            UIElementCompanionFlowTracker<UIElementID> uIElementCompanionFlowTracker = this.companionFlowTracker;
            if (!deliverBackendMessageInternal) {
                uIElementCompanionFlowTracker.rollbackPendingOpen(uIElementID, beginPendingOpen);
                reconcileHiddenEntry(uIElementID);
            } else if (uIElementCompanionFlowTracker.isPendingOpen(uIElementID, beginPendingOpen.getGeneration())) {
                schedulePendingCompanionFlowTimeout(uIElementID, beginPendingOpen.getGeneration());
            }
            return deliverBackendMessageInternal;
        } finally {
        }
    }

    public final boolean deliverPassiveBackendMessage(UIElementID elementID, String data, int i) {
        Intrinsics.checkNotNullParameter(elementID, "elementID");
        Intrinsics.checkNotNullParameter(data, "data");
        return deliverBackendMessageInternal(elementID, data, i, true);
    }

    private final boolean deliverBackendMessageInternal(UIElementID uIElementID, String str, int i, boolean z) {
        if (this.isHostDestroyed) {
            return false;
        }
        if (z && Intrinsics.areEqual((Object) this.desiredVisibilityById.get(uIElementID), (Object) false) && !isElementExist(uIElementID)) {
            Log.d(TAG, "hotsetEvent id=" + uIElementID + " event=SKIP_PASSIVE_PAYLOAD");
            return false;
        }
        beginInFlight(uIElementID);
        try {
            ((SAMPUIElement) getOrCreateInternal(uIElementID, true)).onBackendMessage(str, i);
            return true;
        } finally {
            finishInFlight(uIElementID);
        }
    }

    private final void beginInFlight(UIElementID uIElementID) {
        Map<UIElementID, Integer> map = this.inFlightDepthById;
        Integer num = map.get(uIElementID);
        map.put(uIElementID, Integer.valueOf((num != null ? num.intValue() : 0) + 1));
    }

    private final void finishInFlight(final UIElementID uIElementID) {
        Integer num = this.inFlightDepthById.get(uIElementID);
        if (num != null) {
            int intValue = num.intValue();
            Map<UIElementID, Integer> map = this.inFlightDepthById;
            if (intValue > 1) {
                map.put(uIElementID, Integer.valueOf(intValue - 1));
                return;
            }
            map.remove(uIElementID);
            final CacheEntry cacheEntry = this.uiElementsMap.get(uIElementID);
            if (cacheEntry == null || cacheEntry.isInHiddenCache() || cacheEntry.getLogicalVisible() || this.cachePolicy.retentionFor(uIElementID) == UIElementRetentionPolicy.PINNED) {
                return;
            }
            this.mainHandler.post(new Runnable() { // from class: ru.mrlargha.commonui.core.UIElementStore$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    UIElementStore.finishInFlight$lambda$0(UIElementStore.this, uIElementID, cacheEntry);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final void finishInFlight$lambda$0(UIElementStore uIElementStore, UIElementID uIElementID, CacheEntry cacheEntry) {
        if (uIElementStore.isHostDestroyed || uIElementStore.uiElementsMap.get(uIElementID) != cacheEntry) {
            return;
        }
        uIElementStore.reconcileHiddenEntry(uIElementID);
    }

    public final SAMPUIElement getOrCreateDefault(UIElementID elementID) {
        Intrinsics.checkNotNullParameter(elementID, "elementID");
        return (SAMPUIElement) getOrCreate(elementID);
    }

    public final boolean setElementVisibility(UIElementID elementID, boolean z) {
        SAMPUIElement existing;
        Intrinsics.checkNotNullParameter(elementID, "elementID");
        if (this.isHostDestroyed) {
            Log.w(TAG, "Ignoring visibility=" + z + " for " + elementID + " after host destroy");
            return false;
        }
        Boolean bool = this.desiredVisibilityById.get(elementID);
        this.desiredVisibilityById.put(elementID, Boolean.valueOf(z));
        if (!z) {
            resolveCompanionFlow(elementID);
        }
        if (z) {
            existing = getOrCreateDefault(elementID);
        } else {
            existing = getExisting(elementID);
            if (existing == null) {
                return false;
            }
        }
        CacheEntry cacheEntry = this.uiElementsMap.get(elementID);
        if (cacheEntry != null) {
            if (cacheEntry.getElement() != existing) {
                cacheEntry = null;
            }
            if (cacheEntry != null) {
                if (!z && Intrinsics.areEqual((Object) bool, (Object) false) && !cacheEntry.getLogicalVisible() && !existing.isOnScreen()) {
                    reconcileHiddenEntry(elementID);
                    return true;
                }
                long visibilityCallbackVersion = cacheEntry.getVisibilityCallbackVersion();
                long logicalTransitionVersion = cacheEntry.getLogicalTransitionVersion();
                existing.setVisibility(z);
                if (this.uiElementsMap.get(elementID) == cacheEntry && cacheEntry.getVisibilityCallbackVersion() == visibilityCallbackVersion) {
                    handleVisibilityChanged(elementID, cacheEntry, z, false);
                }
                if (z && !Intrinsics.areEqual((Object) bool, (Object) true) && this.uiElementsMap.get(elementID) == cacheEntry && cacheEntry.getLogicalTransitionVersion() == logicalTransitionVersion) {
                    handleVisibilityChanged(elementID, cacheEntry, true, true);
                }
                return true;
            }
        }
        return false;
    }

    public final void removeElement(UIElementID elementID) {
        Intrinsics.checkNotNullParameter(elementID, "elementID");
        removeElementInternal(elementID, this.uiElementsMap.get(elementID));
    }

    public final void removeElement(SAMPUIElement element) {
        Object obj;
        Intrinsics.checkNotNullParameter(element, "element");
        Iterator<T> it = this.uiElementsMap.entrySet().iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            if (((CacheEntry) ((Map.Entry) obj).getValue()).getElement() == element) {
                break;
            }
        }
        Map.Entry entry = (Map.Entry) obj;
        if (entry == null) {
            return;
        }
        removeElementInternal((UIElementID) entry.getKey(), (CacheEntry) entry.getValue());
    }

    public final int trimHiddenElements() {
        if (this.isHostDestroyed) {
            return 0;
        }
        int evictAllSafeIdle = evictAllSafeIdle(UIElementEvictionReason.MEMORY_PRESSURE);
        logHotsetSummary("MEMORY_PRESSURE", evictAllSafeIdle);
        return evictAllSafeIdle;
    }

    public final void onHostResumed() {
        if (this.isHostDestroyed) {
            return;
        }
        runMaintenance();
    }

    public final void clearForHostDestroy() {
        if (this.isHostDestroyed) {
            return;
        }
        this.isHostDestroyed = true;
        cancelAllPendingDisposals();
        cancelPendingCompanionFlowTimeout();
        cancelMaintenance();
        logHotsetSummary("HOST_DESTROY", 0);
        this.sessionHotset.clearSession();
        List<CacheEntry> list = CollectionsKt.toList(this.uiElementsMap.values());
        this.uiElementsMap.clear();
        this.desiredVisibilityById.clear();
        this.companionFlowTracker.clear();
        this.evictedElementIds.clear();
        this.inFlightDepthById.clear();
        for (CacheEntry cacheEntry : list) {
            disposeEntry(cacheEntry, UIElementEvictionReason.HOST_DESTROY, false);
        }
        Log.i(TAG, "hotsetEvent event=HOST_DESTROY disposed=" + list.size());
    }

    private final void attachObservers(final UIElementID uIElementID, final CacheEntry cacheEntry) {
        cacheEntry.getElement().setVisibilityChangeObserver$CommonUI(new Function1() { // from class: ru.mrlargha.commonui.core.UIElementStore$$ExternalSyntheticLambda5
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return UIElementStore.attachObservers$lambda$0(UIElementStore.this, uIElementID, cacheEntry, ((Boolean) obj).booleanValue());
            }
        });
        cacheEntry.getElement().setCacheRemovalBlockedChangeObserver$CommonUI(new Function1() { // from class: ru.mrlargha.commonui.core.UIElementStore$$ExternalSyntheticLambda6
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return UIElementStore.attachObservers$lambda$1(UIElementStore.this, uIElementID, cacheEntry, ((Boolean) obj).booleanValue());
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x0026, code lost:
        if (kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r4.desiredVisibilityById.get(r5), (java.lang.Object) true) == false) goto L10;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Unit attachObservers$lambda$0(UIElementStore uIElementStore, UIElementID uIElementID, CacheEntry cacheEntry, boolean z) {
        if (uIElementStore.uiElementsMap.get(uIElementID) != cacheEntry) {
            return Unit.INSTANCE;
        }
        cacheEntry.setVisibilityCallbackVersion(cacheEntry.getVisibilityCallbackVersion() + 1);
        boolean z2 = z;
        uIElementStore.handleVisibilityChanged(uIElementID, cacheEntry, z, z2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit attachObservers$lambda$1(final UIElementStore uIElementStore, final UIElementID uIElementID, final CacheEntry cacheEntry, boolean z) {
        if (uIElementStore.uiElementsMap.get(uIElementID) != cacheEntry) {
            return Unit.INSTANCE;
        }
        if (z) {
            uIElementStore.withdrawFromIdleCache(uIElementID, cacheEntry);
        } else {
            uIElementStore.mainHandler.post(new Runnable() { // from class: ru.mrlargha.commonui.core.UIElementStore$$ExternalSyntheticLambda4
                @Override // java.lang.Runnable
                public final void run() {
                    UIElementStore.attachObservers$lambda$1$0(UIElementStore.this, uIElementID, cacheEntry);
                }
            });
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void attachObservers$lambda$1$0(UIElementStore uIElementStore, UIElementID uIElementID, CacheEntry cacheEntry) {
        if (uIElementStore.isHostDestroyed || uIElementStore.uiElementsMap.get(uIElementID) != cacheEntry) {
            return;
        }
        uIElementStore.reconcileHiddenEntry(uIElementID);
    }

    private final boolean handleVisibilityChanged(UIElementID uIElementID, CacheEntry cacheEntry, boolean z, boolean z2) {
        boolean z3 = false;
        if (this.uiElementsMap.get(uIElementID) != cacheEntry) {
            return false;
        }
        if (UIElementCompanionFlowPolicy.INSTANCE.isTarget(uIElementID)) {
            UIElementID pendingOpenKey = this.companionFlowTracker.pendingOpenKey();
            if (this.companionFlowTracker.onVisibilityChanged(uIElementID, z)) {
                cancelPendingCompanionFlowTimeout();
                if (pendingOpenKey != null && pendingOpenKey != uIElementID) {
                    reconcileHiddenEntry(pendingOpenKey);
                }
            }
        }
        this.desiredVisibilityById.put(uIElementID, Boolean.valueOf(z));
        if (z) {
            if (cacheEntry.getLogicalVisible() && !z2) {
                z3 = true;
            }
            if (!z3) {
                cacheEntry.setLogicalVisible(true);
                cacheEntry.setLogicalTransitionVersion(cacheEntry.getLogicalTransitionVersion() + 1);
            }
            cacheEntry.setHasCompletedShow(true);
            cacheEntry.setActualHiddenAtMs(null);
            leaveHiddenState(uIElementID, cacheEntry);
            return !z3;
        }
        boolean logicalVisible = cacheEntry.getLogicalVisible();
        if (logicalVisible) {
            cacheEntry.setLogicalVisible(false);
            cacheEntry.setLogicalTransitionVersion(cacheEntry.getLogicalTransitionVersion() + 1);
        } else {
            cacheEntry.setLogicalVisible(false);
        }
        if (cacheEntry.getElement().isOnScreen()) {
            withdrawFromIdleCache(uIElementID, cacheEntry);
            return logicalVisible;
        }
        if (cacheEntry.getActualHiddenAtMs() == null) {
            cacheEntry.setActualHiddenAtMs(Long.valueOf(nowMs()));
        }
        enterHiddenState$default(this, uIElementID, cacheEntry, cacheEntry.getHasCompletedShow(), false, 8, null);
        return true;
    }

    static /* synthetic */ void enterHiddenState$default(UIElementStore uIElementStore, UIElementID uIElementID, CacheEntry cacheEntry, boolean z, boolean z2, int i, Object obj) {
        if ((i & 8) != 0) {
            z2 = uIElementStore.inFlightDepthById.containsKey(uIElementID);
        }
        uIElementStore.enterHiddenState(uIElementID, cacheEntry, z, z2);
    }

    private final void enterHiddenState(UIElementID uIElementID, CacheEntry cacheEntry, boolean z, boolean z2) {
        cancelPendingDisposal(uIElementID);
        int i = WhenMappings.$EnumSwitchMapping$0[this.cachePolicy.retentionFor(uIElementID).ordinal()];
        if (i == 1) {
            withdrawFromIdleCache(uIElementID, cacheEntry);
        } else if (i == 2) {
            withdrawFromIdleCache(uIElementID, cacheEntry);
            if (isProtectedFromAutomaticEviction(uIElementID, cacheEntry)) {
                return;
            }
            scheduleDisposeOnHide(uIElementID, cacheEntry);
        } else if (i != 3) {
            throw new NoWhenBranchMatchedException();
        } else {
            if (z && !cacheEntry.isHiddenHookApplied()) {
                cacheEntry.setHiddenHookApplied(true);
                invokeHiddenHook(cacheEntry);
                if (this.uiElementsMap.get(uIElementID) != cacheEntry) {
                    return;
                }
            }
            if (!isIdleCacheEligible(uIElementID, cacheEntry)) {
                withdrawFromIdleCache(uIElementID, cacheEntry);
                return;
            }
            admitToIdleCache(uIElementID, cacheEntry, z2);
            if (this.uiElementsMap.get(uIElementID) == cacheEntry && isUnderMemoryPressure()) {
                trimHiddenElements();
            }
        }
    }

    private final void admitToIdleCache(UIElementID uIElementID, CacheEntry cacheEntry, boolean z) {
        long nowMs;
        Long actualHiddenAtMs = cacheEntry.getActualHiddenAtMs();
        if (actualHiddenAtMs != null) {
            nowMs = actualHiddenAtMs.longValue();
        } else {
            nowMs = nowMs();
            cacheEntry.setActualHiddenAtMs(Long.valueOf(nowMs));
        }
        SessionHotsetHideDecision<UIElementID> onHidden = this.sessionHotset.onHidden(uIElementID, cacheEntry.getToken(), nowMs(), nowMs, z);
        processPolicyEvictions(onHidden.getEvictions());
        if (this.uiElementsMap.get(uIElementID) == cacheEntry) {
            cacheEntry.setInHiddenCache(onHidden.getAdmitted());
        }
        scheduleMaintenance();
        if (this.uiElementsMap.get(uIElementID) != cacheEntry) {
            return;
        }
        SessionHotsetSnapshot snapshot = this.sessionHotset.snapshot();
        long token = cacheEntry.getToken();
        long ttlMs = onHidden.getTtlMs();
        boolean admitted = onHidden.getAdmitted();
        boolean duplicate = onHidden.getDuplicate();
        int hiddenEntries = snapshot.getHiddenEntries();
        Log.i(TAG, "hotsetEvent id=" + uIElementID + " event=HIDE token=" + token + " ttlMs=" + ttlMs + " admitted=" + admitted + " duplicate=" + duplicate + " hidden=" + hiddenEntries + "/" + snapshot.getMaxHiddenEntries());
    }

    private final void schedulePendingCompanionFlowTimeout(final UIElementID uIElementID, final long j) {
        cancelPendingCompanionFlowTimeout();
        Runnable runnable = new Runnable() { // from class: ru.mrlargha.commonui.core.UIElementStore$$ExternalSyntheticLambda2
            @Override // java.lang.Runnable
            public final void run() {
                UIElementStore.schedulePendingCompanionFlowTimeout$lambda$0(UIElementStore.this, uIElementID, j);
            }
        };
        this.pendingCompanionFlowTimeout = runnable;
        this.mainHandler.postDelayed(runnable, ArchiveNetworkMonitorKt.ARCHIVE_NETWORK_RECONNECT_TIMEOUT_MS);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final void schedulePendingCompanionFlowTimeout$lambda$0(UIElementStore uIElementStore, UIElementID uIElementID, long j) {
        uIElementStore.pendingCompanionFlowTimeout = null;
        if (uIElementStore.companionFlowTracker.expirePendingOpen(uIElementID, j)) {
            Log.w(TAG, "hotsetEvent id=" + uIElementID + " event=PENDING_OPEN_TIMEOUT timeoutMs=30000");
            uIElementStore.reconcileHiddenEntry(uIElementID);
        }
    }

    private final void cancelPendingCompanionFlowTimeout() {
        Runnable runnable = this.pendingCompanionFlowTimeout;
        if (runnable != null) {
            this.mainHandler.removeCallbacks(runnable);
        }
        this.pendingCompanionFlowTimeout = null;
    }

    private final void resolveCompanionFlow(UIElementID uIElementID) {
        if (this.companionFlowTracker.resolve(uIElementID)) {
            cancelPendingCompanionFlowTimeout();
        }
    }

    private final void leaveHiddenState(UIElementID uIElementID, CacheEntry cacheEntry) {
        cancelPendingDisposal(uIElementID);
        UIElementRetentionPolicy retentionFor = this.cachePolicy.retentionFor(uIElementID);
        UIElementRetentionPolicy uIElementRetentionPolicy = UIElementRetentionPolicy.SESSION_HOTSET;
        SessionHotsetPolicy<UIElementID> sessionHotsetPolicy = this.sessionHotset;
        if (retentionFor == uIElementRetentionPolicy) {
            processPolicyEvictions(sessionHotsetPolicy.onVisible(uIElementID, cacheEntry.getToken(), nowMs()).getEvictions());
        } else {
            sessionHotsetPolicy.dropHidden(uIElementID, cacheEntry.getToken());
        }
        boolean isHiddenHookApplied = cacheEntry.isHiddenHookApplied();
        cacheEntry.setInHiddenCache(false);
        cacheEntry.setHiddenHookApplied(false);
        cacheEntry.setActualHiddenAtMs(null);
        if (isHiddenHookApplied) {
            invokeShownHook(cacheEntry);
        }
        scheduleMaintenance();
    }

    private final void reconcileHiddenEntry(UIElementID uIElementID) {
        CacheEntry cacheEntry;
        if (this.isHostDestroyed || (cacheEntry = this.uiElementsMap.get(uIElementID)) == null) {
            return;
        }
        if (cacheEntry.getLogicalVisible()) {
            leaveHiddenState(uIElementID, cacheEntry);
        } else if (cacheEntry.getElement().isOnScreen()) {
            withdrawFromIdleCache(uIElementID, cacheEntry);
        } else {
            if (cacheEntry.getActualHiddenAtMs() == null) {
                cacheEntry.setActualHiddenAtMs(Long.valueOf(nowMs()));
            }
            enterHiddenState$default(this, uIElementID, cacheEntry, cacheEntry.getHasCompletedShow(), false, 8, null);
        }
    }

    private final void withdrawFromIdleCache(UIElementID uIElementID, CacheEntry cacheEntry) {
        if (this.sessionHotset.dropHidden(uIElementID, cacheEntry.getToken()) || cacheEntry.isInHiddenCache()) {
            cacheEntry.setInHiddenCache(false);
            scheduleMaintenance();
        }
    }

    private final void scheduleDisposeOnHide(final UIElementID uIElementID, final CacheEntry cacheEntry) {
        cancelPendingDisposal(uIElementID);
        Runnable runnable = new Runnable() { // from class: ru.mrlargha.commonui.core.UIElementStore$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                UIElementStore.scheduleDisposeOnHide$lambda$0(UIElementStore.this, uIElementID, cacheEntry);
            }
        };
        this.pendingDisposals.put(uIElementID, runnable);
        this.mainHandler.post(runnable);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final void scheduleDisposeOnHide$lambda$0(UIElementStore uIElementStore, UIElementID uIElementID, CacheEntry cacheEntry) {
        uIElementStore.pendingDisposals.remove(uIElementID);
        if (uIElementStore.uiElementsMap.get(uIElementID) != cacheEntry || cacheEntry.getLogicalVisible() || uIElementStore.isProtectedFromAutomaticEviction(uIElementID, cacheEntry)) {
            return;
        }
        evictExactEntry$default(uIElementStore, uIElementID, cacheEntry, UIElementEvictionReason.HIDE_TIMEOUT, null, 8, null);
    }

    private final int processPolicyEvictions(List<SessionHotsetEviction<UIElementID>> list) {
        Iterator<T> it = list.iterator();
        int i = 0;
        while (it.hasNext()) {
            SessionHotsetEviction sessionHotsetEviction = (SessionHotsetEviction) it.next();
            CacheEntry cacheEntry = this.uiElementsMap.get(sessionHotsetEviction.getKey());
            if (cacheEntry != null && cacheEntry.getToken() == sessionHotsetEviction.getEntryToken()) {
                UIElementEvictionReason storeReason = toStoreReason(sessionHotsetEviction.getReason());
                if (!canAutomaticallyEvict((UIElementID) sessionHotsetEviction.getKey(), cacheEntry, storeReason)) {
                    Log.w(TAG, "hotsetEvent id=" + sessionHotsetEviction.getKey() + " event=SKIP_PROTECTED_EVICTION token=" + cacheEntry.getToken() + " reason=" + sessionHotsetEviction.getReason());
                    cacheEntry.setInHiddenCache(false);
                } else if (evictExactEntry((UIElementID) sessionHotsetEviction.getKey(), cacheEntry, storeReason, Long.valueOf(sessionHotsetEviction.getRetainedMs()))) {
                    i++;
                }
            }
        }
        return i;
    }

    private final int evictAllSafeIdle(UIElementEvictionReason uIElementEvictionReason) {
        UIElementStore uIElementStore;
        UIElementEvictionReason uIElementEvictionReason2;
        ArrayList arrayList = new ArrayList();
        for (Object obj : this.uiElementsMap.entrySet()) {
            Map.Entry entry = (Map.Entry) obj;
            if (canAutomaticallyEvict((UIElementID) entry.getKey(), (CacheEntry) entry.getValue(), uIElementEvictionReason)) {
                arrayList.add(obj);
            }
        }
        ArrayList<Map.Entry> arrayList2 = arrayList;
        ArrayList<Pair> arrayList3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList2, 10));
        for (Map.Entry entry2 : arrayList2) {
            arrayList3.add(TuplesKt.to(entry2.getKey(), entry2.getValue()));
        }
        int i = 0;
        for (Pair pair : arrayList3) {
            UIElementID uIElementID = (UIElementID) pair.component1();
            CacheEntry cacheEntry = (CacheEntry) pair.component2();
            if (this.uiElementsMap.get(uIElementID) == cacheEntry && this.canAutomaticallyEvict(uIElementID, cacheEntry, uIElementEvictionReason)) {
                uIElementStore = this;
                uIElementEvictionReason2 = uIElementEvictionReason;
                if (evictExactEntry$default(uIElementStore, uIElementID, cacheEntry, uIElementEvictionReason2, null, 8, null)) {
                    i++;
                }
            } else {
                uIElementStore = this;
                uIElementEvictionReason2 = uIElementEvictionReason;
            }
            this = uIElementStore;
            uIElementEvictionReason = uIElementEvictionReason2;
        }
        this.scheduleMaintenance();
        return i;
    }

    static /* synthetic */ boolean evictExactEntry$default(UIElementStore uIElementStore, UIElementID uIElementID, CacheEntry cacheEntry, UIElementEvictionReason uIElementEvictionReason, Long l, int i, Object obj) {
        if ((i & 8) != 0) {
            l = null;
        }
        return uIElementStore.evictExactEntry(uIElementID, cacheEntry, uIElementEvictionReason, l);
    }

    private final boolean evictExactEntry(UIElementID uIElementID, CacheEntry cacheEntry, UIElementEvictionReason uIElementEvictionReason, Long l) {
        if ((uIElementEvictionReason == UIElementEvictionReason.EXPLICIT || uIElementEvictionReason == UIElementEvictionReason.HOST_DESTROY || canAutomaticallyEvict(uIElementID, cacheEntry, uIElementEvictionReason)) && removeExactEntry(uIElementID, cacheEntry)) {
            this.sessionHotset.dropHidden(uIElementID, cacheEntry.getToken());
            this.evictedElementIds.add(uIElementID);
            disposeEntry(cacheEntry, uIElementEvictionReason, false);
            SessionHotsetSnapshot snapshot = this.sessionHotset.snapshot();
            long token = cacheEntry.getToken();
            long nowMs = nowMs() - cacheEntry.getCreatedAtMs();
            Object obj = l;
            if (l == null) {
                obj = "unknown";
            }
            int hiddenEntries = snapshot.getHiddenEntries();
            int maxHiddenEntries = snapshot.getMaxHiddenEntries();
            Log.i(TAG, "hotsetEvent id=" + uIElementID + " event=EVICT token=" + token + " reason=" + uIElementEvictionReason + " ageMs=" + nowMs + " hiddenRetainedMs=" + obj + " hidden=" + hiddenEntries + "/" + maxHiddenEntries + " storeSize=" + this.uiElementsMap.size());
            return true;
        }
        return false;
    }

    private final void removeElementInternal(UIElementID uIElementID, CacheEntry cacheEntry) {
        UIElementID uIElementID2;
        this.desiredVisibilityById.put(uIElementID, false);
        resolveCompanionFlow(uIElementID);
        cancelPendingDisposal(uIElementID);
        if (this.cachePolicy.retentionFor(uIElementID) == UIElementRetentionPolicy.SESSION_HOTSET) {
            SessionHotsetPolicy<UIElementID> sessionHotsetPolicy = this.sessionHotset;
            long token = cacheEntry != null ? cacheEntry.getToken() : Long.MIN_VALUE;
            uIElementID2 = uIElementID;
            ArrayList arrayList = new ArrayList();
            for (Object obj : sessionHotsetPolicy.onExternalEviction(uIElementID2, token, SessionHotsetEvictionReason.EXPLICIT, nowMs())) {
                SessionHotsetEviction sessionHotsetEviction = (SessionHotsetEviction) obj;
                if (sessionHotsetEviction.getKey() != uIElementID2 || cacheEntry == null || sessionHotsetEviction.getEntryToken() != cacheEntry.getToken()) {
                    arrayList.add(obj);
                }
            }
            processPolicyEvictions(arrayList);
        } else {
            uIElementID2 = uIElementID;
            if (cacheEntry != null) {
                this.sessionHotset.dropHidden(uIElementID2, cacheEntry.getToken());
            }
        }
        if (cacheEntry == null || !removeExactEntry(uIElementID2, cacheEntry)) {
            return;
        }
        disposeEntry(cacheEntry, UIElementEvictionReason.EXPLICIT, true);
        Log.i(TAG, "hotsetEvent id=" + uIElementID2 + " event=EXPLICIT_REMOVE token=" + cacheEntry.getToken());
    }

    private final boolean removeExactEntry(UIElementID uIElementID, CacheEntry cacheEntry) {
        if (this.uiElementsMap.get(uIElementID) != cacheEntry) {
            return false;
        }
        this.uiElementsMap.remove(uIElementID);
        resolveCompanionFlow(uIElementID);
        cancelPendingDisposal(uIElementID);
        return true;
    }

    private final void invokeHiddenHook(CacheEntry cacheEntry) {
        try {
            cacheEntry.getElement().onEnterHiddenCache();
        } catch (Exception e) {
            Log.e(TAG, "Hidden-cache hook failed for backendId=" + cacheEntry.getElement().getBackendID(), e);
        }
    }

    private final void invokeShownHook(CacheEntry cacheEntry) {
        try {
            cacheEntry.getElement().onLeaveHiddenCache();
        } catch (Exception e) {
            Log.e(TAG, "Cache-reuse hook failed for backendId=" + cacheEntry.getElement().getBackendID(), e);
        }
    }

    private final void disposeEntry(CacheEntry cacheEntry, UIElementEvictionReason uIElementEvictionReason, boolean z) {
        if (z && cacheEntry.getElement().isOnScreen()) {
            try {
                cacheEntry.getElement().setVisibility(false);
            } catch (Exception e) {
                Log.e(TAG, "Dispose hide failed for backendId=" + cacheEntry.getElement().getBackendID(), e);
            }
        }
        cacheEntry.getElement().setVisibilityChangeObserver$CommonUI(null);
        cacheEntry.getElement().setCacheRemovalBlockedChangeObserver$CommonUI(null);
        cacheEntry.setInHiddenCache(false);
        cacheEntry.setHiddenHookApplied(false);
        cacheEntry.setActualHiddenAtMs(null);
        try {
            cacheEntry.getElement().onRemovedFromStore(uIElementEvictionReason);
        } catch (Exception e2) {
            Log.e(TAG, "Dispose hook failed for backendId=" + cacheEntry.getElement().getBackendID(), e2);
        }
        try {
            cacheEntry.getElement().detachFromLayoutSilently$CommonUI();
        } catch (Exception e3) {
            Log.e(TAG, "Detach failed for backendId=" + cacheEntry.getElement().getBackendID(), e3);
        }
    }

    private final boolean isIdleCacheEligible(UIElementID uIElementID, CacheEntry cacheEntry) {
        return (this.cachePolicy.retentionFor(uIElementID) != UIElementRetentionPolicy.SESSION_HOTSET || cacheEntry.getLogicalVisible() || cacheEntry.getElement().isOnScreen() || cacheEntry.getElement().isCacheRemovalBlocked$CommonUI() || this.companionFlowTracker.isPendingOpen(uIElementID)) ? false : true;
    }

    private final boolean isProtectedFromAutomaticEviction(UIElementID uIElementID, CacheEntry cacheEntry) {
        return cacheEntry.getLogicalVisible() || cacheEntry.getElement().isOnScreen() || cacheEntry.getElement().isCacheRemovalBlocked$CommonUI() || this.companionFlowTracker.isPendingOpen(uIElementID) || this.inFlightDepthById.containsKey(uIElementID);
    }

    private final boolean canAutomaticallyEvict(UIElementID uIElementID, CacheEntry cacheEntry, UIElementEvictionReason uIElementEvictionReason) {
        return this.cachePolicy.canEvict(uIElementID, uIElementEvictionReason) && !isProtectedFromAutomaticEviction(uIElementID, cacheEntry);
    }

    private final boolean isUnderMemoryPressure() {
        Runtime runtime = Runtime.getRuntime();
        if (runtime.maxMemory() - (runtime.totalMemory() - runtime.freeMemory()) < Math.max((long) MIN_HEADROOM_BYTES, runtime.maxMemory() / 10)) {
            return true;
        }
        Object systemService = this.targetActivity.getSystemService("activity");
        ActivityManager activityManager = systemService instanceof ActivityManager ? (ActivityManager) systemService : null;
        if (activityManager == null) {
            return false;
        }
        activityManager.getMemoryInfo(this.memoryInfo);
        return this.memoryInfo.lowMemory;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void runMaintenance() {
        this.maintenanceScheduled = false;
        if (this.isHostDestroyed) {
            return;
        }
        processPolicyEvictions(this.sessionHotset.sweepExpired(nowMs()));
        if (isUnderMemoryPressure()) {
            trimHiddenElements();
        }
        scheduleMaintenance();
    }

    private final void scheduleMaintenance() {
        if (this.isHostDestroyed) {
            return;
        }
        cancelMaintenance();
        if (this.sessionHotset.snapshot().getHiddenEntries() <= 0) {
            return;
        }
        long nowMs = nowMs();
        Long nextExpiryAtMs = this.sessionHotset.nextExpiryAtMs();
        this.mainHandler.postDelayed(this.maintenanceRunnable, Math.min(RangesKt.coerceAtLeast((nextExpiryAtMs != null ? nextExpiryAtMs.longValue() : nowMs + ArchiveNetworkMonitorKt.ARCHIVE_NETWORK_RECONNECT_TIMEOUT_MS) - nowMs, 0L), (long) ArchiveNetworkMonitorKt.ARCHIVE_NETWORK_RECONNECT_TIMEOUT_MS));
        this.maintenanceScheduled = true;
    }

    private final void cancelMaintenance() {
        boolean z = this.maintenanceScheduled;
        Handler handler = this.mainHandler;
        if (!z) {
            handler.removeCallbacks(this.maintenanceRunnable);
            return;
        }
        handler.removeCallbacks(this.maintenanceRunnable);
        this.maintenanceScheduled = false;
    }

    private final void cancelPendingDisposal(UIElementID uIElementID) {
        Runnable remove = this.pendingDisposals.remove(uIElementID);
        if (remove != null) {
            this.mainHandler.removeCallbacks(remove);
        }
    }

    private final void cancelAllPendingDisposals() {
        Handler handler = this.mainHandler;
        for (Runnable runnable : this.pendingDisposals.values()) {
            handler.removeCallbacks(runnable);
        }
        this.pendingDisposals.clear();
    }

    private final void logHotsetSummary(String str, int i) {
        SessionHotsetSnapshot snapshot = this.sessionHotset.snapshot();
        int hiddenEntries = snapshot.getHiddenEntries();
        int maxHiddenEntries = snapshot.getMaxHiddenEntries();
        int peakHiddenEntries = snapshot.getPeakHiddenEntries();
        Log.i(TAG, "hotsetSummary trigger=" + str + " evicted=" + i + " hidden=" + hiddenEntries + "/" + maxHiddenEntries + " peak=" + peakHiddenEntries + " storeSize=" + this.uiElementsMap.size());
    }

    private final long nextToken() {
        long j = this.nextEntryToken + 1;
        this.nextEntryToken = j;
        return j;
    }

    private final long nowMs() {
        return SystemClock.elapsedRealtime();
    }

    private final UIElementEvictionReason toStoreReason(SessionHotsetEvictionReason sessionHotsetEvictionReason) {
        switch (WhenMappings.$EnumSwitchMapping$1[sessionHotsetEvictionReason.ordinal()]) {
            case 1:
                return UIElementEvictionReason.HIDE_TIMEOUT;
            case 2:
                return UIElementEvictionReason.CAPACITY;
            case 3:
                return UIElementEvictionReason.MEMORY_PRESSURE;
            case 4:
            case 5:
                return UIElementEvictionReason.EXPLICIT;
            case 6:
                return UIElementEvictionReason.HOST_DESTROY;
            default:
                throw new NoWhenBranchMatchedException();
        }
    }

    /* compiled from: UIElementStore.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lru/mrlargha/commonui/core/UIElementStore$Companion;", "", "<init>", "()V", "TAG", "", "MISSING_ENTRY_TOKEN", "", "PENDING_OPEN_TIMEOUT_MS", "MAINTENANCE_PRESSURE_INTERVAL_MS", "MIN_HEADROOM_BYTES", "CommonUI"}, k = 1, mv = {2, 4, 0}, xi = 48)
    /* loaded from: classes6.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
