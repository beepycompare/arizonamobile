package androidx.compose.ui.contentcapture;

import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.LongSparseArray;
import android.view.View;
import android.view.autofill.AutofillId;
import android.view.translation.TranslationRequestValue;
import android.view.translation.TranslationResponseValue;
import android.view.translation.ViewTranslationRequest;
import android.view.translation.ViewTranslationResponse;
import androidx.collection.IntObjectMap;
import androidx.collection.IntObjectMapKt;
import androidx.collection.MutableIntObjectMap;
import androidx.collection.MutableScatterMap;
import androidx.compose.ui.contentcapture.AndroidContentCaptureManager;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.internal.InlineClassHelperKt;
import androidx.compose.ui.node.Owner;
import androidx.compose.ui.platform.AndroidComposeView;
import androidx.compose.ui.platform.AndroidComposeViewAccessibilityDelegateCompat;
import androidx.compose.ui.platform.SemanticsNodeCopy;
import androidx.compose.ui.platform.SemanticsNodeWithAdjustedBounds;
import androidx.compose.ui.platform.SemanticsUtils_androidKt;
import androidx.compose.ui.platform.coreshims.AutofillIdCompat;
import androidx.compose.ui.platform.coreshims.ContentCaptureSessionCompat;
import androidx.compose.ui.platform.coreshims.ViewCompatShims;
import androidx.compose.ui.platform.coreshims.ViewStructureCompat;
import androidx.compose.ui.semantics.AccessibilityAction;
import androidx.compose.ui.semantics.Role;
import androidx.compose.ui.semantics.SemanticsActions;
import androidx.compose.ui.semantics.SemanticsConfiguration;
import androidx.compose.ui.semantics.SemanticsConfigurationKt;
import androidx.compose.ui.semantics.SemanticsNode;
import androidx.compose.ui.semantics.SemanticsProperties;
import androidx.compose.ui.semantics.SemanticsPropertyKey;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.TextLayoutInput;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.unit.TextUnit;
import androidx.compose.ui.util.ListUtilsKt;
import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.DefaultLifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.channels.ChannelIterator;
import kotlinx.coroutines.channels.ChannelKt;
/* compiled from: AndroidContentCaptureManager.android.kt */
@Metadata(d1 = {"\u0000Ú\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u0016\n\u0000\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0000\u0018\u0000 \u0082\u00012\u00020\u00012\u00020\u00022\u00020\u0003:\u0006\u0082\u0001\u0083\u0001\u0084\u0001B\u001d\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u000e\u0010\u0006\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0007¢\u0006\u0002\u0010\tJ\u0010\u00109\u001a\u00020\u000eH\u0080@¢\u0006\u0004\b:\u0010;J\u001a\u0010<\u001a\u00020\u000e2\u0006\u0010=\u001a\u00020>2\b\u0010?\u001a\u0004\u0018\u00010@H\u0002J\u0010\u0010A\u001a\u00020\u000e2\u0006\u0010=\u001a\u00020>H\u0002J\u0016\u0010B\u001a\u00020\u000e2\f\u0010C\u001a\b\u0012\u0004\u0012\u00020\u001f0\u001eH\u0002J\b\u0010D\u001a\u00020\u000eH\u0002J\b\u0010E\u001a\u00020\u000eH\u0002J\b\u0010F\u001a\u00020\u000eH\u0002J\b\u0010G\u001a\u00020\u000eH\u0002J\r\u0010H\u001a\u00020\u000eH\u0000¢\u0006\u0002\bIJ-\u0010J\u001a\u00020\u000e2\u0006\u0010K\u001a\u00020L2\u0006\u0010M\u001a\u00020N2\u000e\u0010O\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010Q0PH\u0001¢\u0006\u0002\bRJ\r\u0010S\u001a\u00020\u000eH\u0000¢\u0006\u0002\bTJ\r\u0010U\u001a\u00020\u000eH\u0000¢\u0006\u0002\bVJ\r\u0010W\u001a\u00020\u000eH\u0000¢\u0006\u0002\bXJ\r\u0010Y\u001a\u00020\u000eH\u0000¢\u0006\u0002\bZJ\u0010\u0010[\u001a\u00020\u000e2\u0006\u0010\\\u001a\u00020]H\u0016J\u0010\u0010^\u001a\u00020\u000e2\u0006\u0010\\\u001a\u00020]H\u0016J\u0010\u0010_\u001a\u00020\u000e2\u0006\u0010`\u001a\u00020aH\u0016J\u0010\u0010b\u001a\u00020\u000e2\u0006\u0010`\u001a\u00020aH\u0016J%\u0010c\u001a\u00020\u000e2\u0006\u0010d\u001a\u00020\u00002\u000e\u0010e\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010g0fH\u0001¢\u0006\u0002\bhJ\u0018\u0010i\u001a\u00020\u000e2\u0006\u0010j\u001a\u00020k2\u0006\u0010l\u001a\u000203H\u0002J\b\u0010m\u001a\u00020\u000eH\u0002J\u0018\u0010n\u001a\u00020\u000e2\u0006\u0010o\u001a\u00020>2\u0006\u0010p\u001a\u00020qH\u0002J\b\u0010r\u001a\u00020\u000eH\u0002J\u0018\u0010s\u001a\u00020\u000e2\u0006\u0010t\u001a\u00020>2\u0006\u0010u\u001a\u00020kH\u0002J\u0010\u0010v\u001a\u00020\u000e2\u0006\u0010u\u001a\u00020kH\u0002J\b\u0010w\u001a\u00020\u000eH\u0002J\u0010\u0010x\u001a\u00020\u000e2\u0006\u0010u\u001a\u00020kH\u0002JG\u0010y\u001a\u00020\u000e\"\u0004\b\u0000\u0010z*\b\u0012\u0004\u0012\u0002Hz0{2\u0018\u0010|\u001a\u0014\u0012\u0004\u0012\u00020>\u0012\u0004\u0012\u0002Hz\u0012\u0004\u0012\u00020\u000e0}2\u0012\u0010~\u001a\u000e\u0012\u0004\u0012\u0002Hz\u0012\u0004\u0012\u00020\u00130\u007fH\u0082\bJ'\u0010\u0080\u0001\u001a\u00020\u000e*\u00020k2\u0018\u0010|\u001a\u0014\u0012\u0004\u0012\u00020>\u0012\u0004\u0012\u00020k\u0012\u0004\u0012\u00020\u000e0}H\u0002J\u0017\u0010\u0081\u0001\u001a\u0004\u0018\u00010@*\u00020k2\u0006\u0010t\u001a\u00020>H\u0002R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R&\u0010\u0016\u001a\u0004\u0018\u00010\b8\u0000@\u0000X\u0081\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\"\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001f0\u001e8@X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\u000e\u0010$\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010&\u001a\u00020'X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b(\u0010)R\u0014\u0010*\u001a\u00020\u00138@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b+\u0010,R\"\u0010\u0006\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b-\u0010.\"\u0004\b/\u00100R\u0014\u00101\u001a\b\u0012\u0004\u0012\u00020302X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00104\u001a\u000203X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00105\u001a\u000206X\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b7\u00108¨\u0006\u0085\u0001"}, d2 = {"Landroidx/compose/ui/contentcapture/AndroidContentCaptureManager;", "Landroidx/compose/ui/contentcapture/ContentCaptureManager;", "Landroidx/lifecycle/DefaultLifecycleObserver;", "Landroid/view/View$OnAttachStateChangeListener;", "view", "Landroidx/compose/ui/platform/AndroidComposeView;", "onContentCaptureSession", "Lkotlin/Function0;", "Landroidx/compose/ui/platform/coreshims/ContentCaptureSessionCompat;", "(Landroidx/compose/ui/platform/AndroidComposeView;Lkotlin/jvm/functions/Function0;)V", "SendRecurringContentCaptureEventsIntervalMillis", "", "boundsUpdateChannel", "Lkotlinx/coroutines/channels/Channel;", "", "bufferedEvents", "", "Landroidx/compose/ui/contentcapture/ContentCaptureEvent;", "checkingForSemanticsChanges", "", "contentCaptureChangeChecker", "Ljava/lang/Runnable;", "contentCaptureSession", "getContentCaptureSession$ui_release$annotations", "()V", "getContentCaptureSession$ui_release", "()Landroidx/compose/ui/platform/coreshims/ContentCaptureSessionCompat;", "setContentCaptureSession$ui_release", "(Landroidx/compose/ui/platform/coreshims/ContentCaptureSessionCompat;)V", "currentSemanticsNodes", "Landroidx/collection/IntObjectMap;", "Landroidx/compose/ui/platform/SemanticsNodeWithAdjustedBounds;", "getCurrentSemanticsNodes$ui_release", "()Landroidx/collection/IntObjectMap;", "setCurrentSemanticsNodes$ui_release", "(Landroidx/collection/IntObjectMap;)V", "currentSemanticsNodesInvalidated", "currentSemanticsNodesSnapshotTimestampMillis", "handler", "Landroid/os/Handler;", "getHandler$ui_release", "()Landroid/os/Handler;", "isEnabled", "isEnabled$ui_release", "()Z", "getOnContentCaptureSession", "()Lkotlin/jvm/functions/Function0;", "setOnContentCaptureSession", "(Lkotlin/jvm/functions/Function0;)V", "previousSemanticsNodes", "Landroidx/collection/MutableIntObjectMap;", "Landroidx/compose/ui/platform/SemanticsNodeCopy;", "previousSemanticsRoot", "translateStatus", "Landroidx/compose/ui/contentcapture/AndroidContentCaptureManager$TranslateStatus;", "getView", "()Landroidx/compose/ui/platform/AndroidComposeView;", "boundsUpdatesEventLoop", "boundsUpdatesEventLoop$ui_release", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "bufferContentCaptureViewAppeared", "virtualId", "", "viewStructure", "Landroidx/compose/ui/platform/coreshims/ViewStructureCompat;", "bufferContentCaptureViewDisappeared", "checkForContentCapturePropertyChanges", "newSemanticsNodes", "clearTranslatedText", "hideTranslatedText", "notifyContentCaptureChanges", "notifySubtreeStateChangeIfNeeded", "onClearTranslation", "onClearTranslation$ui_release", "onCreateVirtualViewTranslationRequests", "virtualIds", "", "supportedFormats", "", "requestsCollector", "Ljava/util/function/Consumer;", "Landroid/view/translation/ViewTranslationRequest;", "onCreateVirtualViewTranslationRequests$ui_release", "onHideTranslation", "onHideTranslation$ui_release", "onLayoutChange", "onLayoutChange$ui_release", "onSemanticsChange", "onSemanticsChange$ui_release", "onShowTranslation", "onShowTranslation$ui_release", "onStart", "owner", "Landroidx/lifecycle/LifecycleOwner;", "onStop", "onViewAttachedToWindow", "v", "Landroid/view/View;", "onViewDetachedFromWindow", "onVirtualViewTranslationResponses", "contentCaptureManager", "response", "Landroid/util/LongSparseArray;", "Landroid/view/translation/ViewTranslationResponse;", "onVirtualViewTranslationResponses$ui_release", "sendContentCaptureAppearEvents", "newNode", "Landroidx/compose/ui/semantics/SemanticsNode;", "oldNode", "sendContentCaptureDisappearEvents", "sendContentCaptureTextUpdateEvent", "id", "newText", "", "showTranslatedText", "updateBuffersOnAppeared", FirebaseAnalytics.Param.INDEX, "node", "updateBuffersOnDisappeared", "updateSemanticsCopy", "updateTranslationOnAppeared", "fastForEachIndexedWithFilter", ExifInterface.GPS_DIRECTION_TRUE, "", "action", "Lkotlin/Function2;", "predicate", "Lkotlin/Function1;", "fastForEachReplacedVisibleChildren", "toViewStructure", "Companion", "TranslateStatus", "ViewTranslationHelperMethods", "ui_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes.dex */
public final class AndroidContentCaptureManager implements ContentCaptureManager, DefaultLifecycleObserver, View.OnAttachStateChangeListener {
    public static final String VIEW_STRUCTURE_BUNDLE_KEY_ADDITIONAL_INDEX = "android.view.ViewStructure.extra.EXTRA_VIEW_NODE_INDEX";
    public static final String VIEW_STRUCTURE_BUNDLE_KEY_TIMESTAMP = "android.view.contentcapture.EventTimestamp";
    private boolean checkingForSemanticsChanges;
    private ContentCaptureSessionCompat contentCaptureSession;
    private long currentSemanticsNodesSnapshotTimestampMillis;
    private Function0<? extends ContentCaptureSessionCompat> onContentCaptureSession;
    private SemanticsNodeCopy previousSemanticsRoot;
    private final AndroidComposeView view;
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;
    private final List<ContentCaptureEvent> bufferedEvents = new ArrayList();
    private long SendRecurringContentCaptureEventsIntervalMillis = 100;
    private TranslateStatus translateStatus = TranslateStatus.SHOW_ORIGINAL;
    private boolean currentSemanticsNodesInvalidated = true;
    private final Channel<Unit> boundsUpdateChannel = ChannelKt.Channel$default(1, null, null, 6, null);
    private final Handler handler = new Handler(Looper.getMainLooper());
    private IntObjectMap<SemanticsNodeWithAdjustedBounds> currentSemanticsNodes = IntObjectMapKt.intObjectMapOf();
    private MutableIntObjectMap<SemanticsNodeCopy> previousSemanticsNodes = IntObjectMapKt.mutableIntObjectMapOf();
    private final Runnable contentCaptureChangeChecker = new Runnable() { // from class: androidx.compose.ui.contentcapture.AndroidContentCaptureManager$$ExternalSyntheticLambda0
        @Override // java.lang.Runnable
        public final void run() {
            AndroidContentCaptureManager.contentCaptureChangeChecker$lambda$0(AndroidContentCaptureManager.this);
        }
    };

    /* compiled from: AndroidContentCaptureManager.android.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    /* loaded from: classes.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[ContentCaptureEventType.values().length];
            try {
                iArr[ContentCaptureEventType.VIEW_APPEAR.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[ContentCaptureEventType.VIEW_DISAPPEAR.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public static /* synthetic */ void getContentCaptureSession$ui_release$annotations() {
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewAttachedToWindow(View view) {
    }

    public AndroidContentCaptureManager(AndroidComposeView androidComposeView, Function0<? extends ContentCaptureSessionCompat> function0) {
        this.view = androidComposeView;
        this.onContentCaptureSession = function0;
        this.previousSemanticsRoot = new SemanticsNodeCopy(androidComposeView.getSemanticsOwner().getUnmergedRootSemanticsNode(), IntObjectMapKt.intObjectMapOf());
    }

    public final AndroidComposeView getView() {
        return this.view;
    }

    public final Function0<ContentCaptureSessionCompat> getOnContentCaptureSession() {
        return this.onContentCaptureSession;
    }

    public final void setOnContentCaptureSession(Function0<? extends ContentCaptureSessionCompat> function0) {
        this.onContentCaptureSession = function0;
    }

    public final ContentCaptureSessionCompat getContentCaptureSession$ui_release() {
        return this.contentCaptureSession;
    }

    public final void setContentCaptureSession$ui_release(ContentCaptureSessionCompat contentCaptureSessionCompat) {
        this.contentCaptureSession = contentCaptureSessionCompat;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* compiled from: AndroidContentCaptureManager.android.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0082\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Landroidx/compose/ui/contentcapture/AndroidContentCaptureManager$TranslateStatus;", "", "(Ljava/lang/String;I)V", "SHOW_ORIGINAL", "SHOW_TRANSLATED", "ui_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* loaded from: classes.dex */
    public static final class TranslateStatus {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ TranslateStatus[] $VALUES;
        public static final TranslateStatus SHOW_ORIGINAL = new TranslateStatus("SHOW_ORIGINAL", 0);
        public static final TranslateStatus SHOW_TRANSLATED = new TranslateStatus("SHOW_TRANSLATED", 1);

        private static final /* synthetic */ TranslateStatus[] $values() {
            return new TranslateStatus[]{SHOW_ORIGINAL, SHOW_TRANSLATED};
        }

        public static EnumEntries<TranslateStatus> getEntries() {
            return $ENTRIES;
        }

        public static TranslateStatus valueOf(String str) {
            return (TranslateStatus) Enum.valueOf(TranslateStatus.class, str);
        }

        public static TranslateStatus[] values() {
            return (TranslateStatus[]) $VALUES.clone();
        }

        private TranslateStatus(String str, int i) {
        }

        static {
            TranslateStatus[] $values = $values();
            $VALUES = $values;
            $ENTRIES = EnumEntriesKt.enumEntries($values);
        }
    }

    public final Handler getHandler$ui_release() {
        return this.handler;
    }

    public final void setCurrentSemanticsNodes$ui_release(IntObjectMap<SemanticsNodeWithAdjustedBounds> intObjectMap) {
        this.currentSemanticsNodes = intObjectMap;
    }

    public final IntObjectMap<SemanticsNodeWithAdjustedBounds> getCurrentSemanticsNodes$ui_release() {
        if (this.currentSemanticsNodesInvalidated) {
            this.currentSemanticsNodesInvalidated = false;
            this.currentSemanticsNodes = SemanticsUtils_androidKt.getAllUncoveredSemanticsNodesToIntObjectMap(this.view.getSemanticsOwner());
            this.currentSemanticsNodesSnapshotTimestampMillis = System.currentTimeMillis();
        }
        return this.currentSemanticsNodes;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void contentCaptureChangeChecker$lambda$0(AndroidContentCaptureManager androidContentCaptureManager) {
        if (androidContentCaptureManager.isEnabled$ui_release()) {
            Owner.measureAndLayout$default(androidContentCaptureManager.view, false, 1, null);
            androidContentCaptureManager.sendContentCaptureDisappearEvents();
            androidContentCaptureManager.sendContentCaptureAppearEvents(androidContentCaptureManager.view.getSemanticsOwner().getUnmergedRootSemanticsNode(), androidContentCaptureManager.previousSemanticsRoot);
            androidContentCaptureManager.checkForContentCapturePropertyChanges(androidContentCaptureManager.getCurrentSemanticsNodes$ui_release());
            androidContentCaptureManager.updateSemanticsCopy();
            androidContentCaptureManager.checkingForSemanticsChanges = false;
        }
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewDetachedFromWindow(View view) {
        this.handler.removeCallbacks(this.contentCaptureChangeChecker);
        this.contentCaptureSession = null;
    }

    public final boolean isEnabled$ui_release() {
        return ContentCaptureManager.Companion.isEnabled() && this.contentCaptureSession != null;
    }

    @Override // androidx.lifecycle.DefaultLifecycleObserver
    public void onStart(LifecycleOwner lifecycleOwner) {
        this.contentCaptureSession = this.onContentCaptureSession.invoke();
        updateBuffersOnAppeared(-1, this.view.getSemanticsOwner().getUnmergedRootSemanticsNode());
        notifyContentCaptureChanges();
    }

    @Override // androidx.lifecycle.DefaultLifecycleObserver
    public void onStop(LifecycleOwner lifecycleOwner) {
        updateBuffersOnDisappeared(this.view.getSemanticsOwner().getUnmergedRootSemanticsNode());
        notifyContentCaptureChanges();
        this.contentCaptureSession = null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:31:0x0093, code lost:
        if (kotlinx.coroutines.DelayKt.delay(r6, r0) == r1) goto L28;
     */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0025  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x004b  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0062  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x006e  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0096  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:31:0x0093 -> B:13:0x0034). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object boundsUpdatesEventLoop$ui_release(Continuation<? super Unit> continuation) {
        AndroidContentCaptureManager$boundsUpdatesEventLoop$1 androidContentCaptureManager$boundsUpdatesEventLoop$1;
        int i;
        ChannelIterator<Unit> it;
        AndroidContentCaptureManager androidContentCaptureManager;
        AndroidContentCaptureManager androidContentCaptureManager2;
        ChannelIterator<Unit> channelIterator;
        Object hasNext;
        if (continuation instanceof AndroidContentCaptureManager$boundsUpdatesEventLoop$1) {
            androidContentCaptureManager$boundsUpdatesEventLoop$1 = (AndroidContentCaptureManager$boundsUpdatesEventLoop$1) continuation;
            if ((androidContentCaptureManager$boundsUpdatesEventLoop$1.label & Integer.MIN_VALUE) != 0) {
                androidContentCaptureManager$boundsUpdatesEventLoop$1.label -= Integer.MIN_VALUE;
                Object obj = androidContentCaptureManager$boundsUpdatesEventLoop$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = androidContentCaptureManager$boundsUpdatesEventLoop$1.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    it = this.boundsUpdateChannel.iterator();
                    androidContentCaptureManager = this;
                    androidContentCaptureManager$boundsUpdatesEventLoop$1.L$0 = androidContentCaptureManager;
                    androidContentCaptureManager$boundsUpdatesEventLoop$1.L$1 = it;
                    androidContentCaptureManager$boundsUpdatesEventLoop$1.label = 1;
                    hasNext = it.hasNext(androidContentCaptureManager$boundsUpdatesEventLoop$1);
                    if (hasNext != coroutine_suspended) {
                    }
                    return coroutine_suspended;
                } else if (i != 1) {
                    if (i == 2) {
                        channelIterator = (ChannelIterator) androidContentCaptureManager$boundsUpdatesEventLoop$1.L$1;
                        androidContentCaptureManager2 = (AndroidContentCaptureManager) androidContentCaptureManager$boundsUpdatesEventLoop$1.L$0;
                        ResultKt.throwOnFailure(obj);
                        it = channelIterator;
                        androidContentCaptureManager = androidContentCaptureManager2;
                        androidContentCaptureManager$boundsUpdatesEventLoop$1.L$0 = androidContentCaptureManager;
                        androidContentCaptureManager$boundsUpdatesEventLoop$1.L$1 = it;
                        androidContentCaptureManager$boundsUpdatesEventLoop$1.label = 1;
                        hasNext = it.hasNext(androidContentCaptureManager$boundsUpdatesEventLoop$1);
                        if (hasNext != coroutine_suspended) {
                            AndroidContentCaptureManager androidContentCaptureManager3 = androidContentCaptureManager;
                            channelIterator = it;
                            obj = hasNext;
                            androidContentCaptureManager2 = androidContentCaptureManager3;
                            if (!((Boolean) obj).booleanValue()) {
                                channelIterator.next();
                                if (androidContentCaptureManager2.isEnabled$ui_release()) {
                                    androidContentCaptureManager2.notifyContentCaptureChanges();
                                }
                                if (!androidContentCaptureManager2.checkingForSemanticsChanges) {
                                    androidContentCaptureManager2.checkingForSemanticsChanges = true;
                                    androidContentCaptureManager2.handler.post(androidContentCaptureManager2.contentCaptureChangeChecker);
                                }
                                long j = androidContentCaptureManager2.SendRecurringContentCaptureEventsIntervalMillis;
                                androidContentCaptureManager$boundsUpdatesEventLoop$1.L$0 = androidContentCaptureManager2;
                                androidContentCaptureManager$boundsUpdatesEventLoop$1.L$1 = channelIterator;
                                androidContentCaptureManager$boundsUpdatesEventLoop$1.label = 2;
                            } else {
                                return Unit.INSTANCE;
                            }
                        }
                        return coroutine_suspended;
                    }
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                } else {
                    channelIterator = (ChannelIterator) androidContentCaptureManager$boundsUpdatesEventLoop$1.L$1;
                    androidContentCaptureManager2 = (AndroidContentCaptureManager) androidContentCaptureManager$boundsUpdatesEventLoop$1.L$0;
                    ResultKt.throwOnFailure(obj);
                    if (!((Boolean) obj).booleanValue()) {
                    }
                }
            }
        }
        androidContentCaptureManager$boundsUpdatesEventLoop$1 = new AndroidContentCaptureManager$boundsUpdatesEventLoop$1(this, continuation);
        Object obj2 = androidContentCaptureManager$boundsUpdatesEventLoop$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = androidContentCaptureManager$boundsUpdatesEventLoop$1.label;
        if (i != 0) {
        }
    }

    public final void onSemanticsChange$ui_release() {
        this.currentSemanticsNodesInvalidated = true;
        if (!isEnabled$ui_release() || this.checkingForSemanticsChanges) {
            return;
        }
        this.checkingForSemanticsChanges = true;
        this.handler.post(this.contentCaptureChangeChecker);
    }

    public final void onLayoutChange$ui_release() {
        this.currentSemanticsNodesInvalidated = true;
        if (isEnabled$ui_release()) {
            notifySubtreeStateChangeIfNeeded();
        }
    }

    private final void sendContentCaptureDisappearEvents() {
        MutableIntObjectMap<SemanticsNodeCopy> mutableIntObjectMap = this.previousSemanticsNodes;
        int[] iArr = mutableIntObjectMap.keys;
        long[] jArr = mutableIntObjectMap.metadata;
        int length = jArr.length - 2;
        if (length < 0) {
            return;
        }
        int i = 0;
        while (true) {
            long j = jArr[i];
            if ((((~j) << 7) & j & (-9187201950435737472L)) != -9187201950435737472L) {
                int i2 = 8 - ((~(i - length)) >>> 31);
                for (int i3 = 0; i3 < i2; i3++) {
                    if ((255 & j) < 128) {
                        int i4 = iArr[(i << 3) + i3];
                        if (!getCurrentSemanticsNodes$ui_release().containsKey(i4)) {
                            bufferContentCaptureViewDisappeared(i4);
                            notifySubtreeStateChangeIfNeeded();
                        }
                    }
                    j >>= 8;
                }
                if (i2 != 8) {
                    return;
                }
            }
            if (i == length) {
                return;
            }
            i++;
        }
    }

    private final void sendContentCaptureAppearEvents(SemanticsNode semanticsNode, final SemanticsNodeCopy semanticsNodeCopy) {
        fastForEachReplacedVisibleChildren(semanticsNode, new Function2<Integer, SemanticsNode, Unit>() { // from class: androidx.compose.ui.contentcapture.AndroidContentCaptureManager$sendContentCaptureAppearEvents$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(Integer num, SemanticsNode semanticsNode2) {
                invoke(num.intValue(), semanticsNode2);
                return Unit.INSTANCE;
            }

            public final void invoke(int i, SemanticsNode semanticsNode2) {
                if (SemanticsNodeCopy.this.getChildren().contains(semanticsNode2.getId())) {
                    return;
                }
                this.updateBuffersOnAppeared(i, semanticsNode2);
                this.notifySubtreeStateChangeIfNeeded();
            }
        });
        List<SemanticsNode> replacedChildren$ui_release = semanticsNode.getReplacedChildren$ui_release();
        int size = replacedChildren$ui_release.size();
        for (int i = 0; i < size; i++) {
            SemanticsNode semanticsNode2 = replacedChildren$ui_release.get(i);
            if (getCurrentSemanticsNodes$ui_release().containsKey(semanticsNode2.getId()) && this.previousSemanticsNodes.containsKey(semanticsNode2.getId())) {
                SemanticsNodeCopy semanticsNodeCopy2 = this.previousSemanticsNodes.get(semanticsNode2.getId());
                if (semanticsNodeCopy2 != null) {
                    sendContentCaptureAppearEvents(semanticsNode2, semanticsNodeCopy2);
                } else {
                    InlineClassHelperKt.throwIllegalStateExceptionForNullCheck("node not present in pruned tree before this change");
                    throw new KotlinNothingValueException();
                }
            }
        }
    }

    private final void sendContentCaptureTextUpdateEvent(int i, String str) {
        ContentCaptureSessionCompat contentCaptureSessionCompat;
        if (Build.VERSION.SDK_INT >= 29 && (contentCaptureSessionCompat = this.contentCaptureSession) != null) {
            AutofillId newAutofillId = contentCaptureSessionCompat.newAutofillId(i);
            if (newAutofillId != null) {
                contentCaptureSessionCompat.notifyViewTextChanged(newAutofillId, str);
            } else {
                InlineClassHelperKt.throwIllegalStateExceptionForNullCheck("Invalid content capture ID");
                throw new KotlinNothingValueException();
            }
        }
    }

    private final void updateSemanticsCopy() {
        this.previousSemanticsNodes.clear();
        IntObjectMap<SemanticsNodeWithAdjustedBounds> currentSemanticsNodes$ui_release = getCurrentSemanticsNodes$ui_release();
        int[] iArr = currentSemanticsNodes$ui_release.keys;
        Object[] objArr = currentSemanticsNodes$ui_release.values;
        long[] jArr = currentSemanticsNodes$ui_release.metadata;
        int length = jArr.length - 2;
        if (length >= 0) {
            int i = 0;
            while (true) {
                long j = jArr[i];
                if ((((~j) << 7) & j & (-9187201950435737472L)) != -9187201950435737472L) {
                    int i2 = 8 - ((~(i - length)) >>> 31);
                    for (int i3 = 0; i3 < i2; i3++) {
                        if ((255 & j) < 128) {
                            int i4 = (i << 3) + i3;
                            this.previousSemanticsNodes.set(iArr[i4], new SemanticsNodeCopy(((SemanticsNodeWithAdjustedBounds) objArr[i4]).getSemanticsNode(), getCurrentSemanticsNodes$ui_release()));
                        }
                        j >>= 8;
                    }
                    if (i2 != 8) {
                        break;
                    }
                }
                if (i == length) {
                    break;
                }
                i++;
            }
        }
        this.previousSemanticsRoot = new SemanticsNodeCopy(this.view.getSemanticsOwner().getUnmergedRootSemanticsNode(), getCurrentSemanticsNodes$ui_release());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void notifySubtreeStateChangeIfNeeded() {
        this.boundsUpdateChannel.mo7544trySendJP2dKIU(Unit.INSTANCE);
    }

    private final ViewStructureCompat toViewStructure(SemanticsNode semanticsNode, int i) {
        AutofillIdCompat autofillId;
        AutofillId autofillId2;
        String m5885toLegacyClassNameV4PA4sw;
        ContentCaptureSessionCompat contentCaptureSessionCompat = this.contentCaptureSession;
        if (contentCaptureSessionCompat == null || Build.VERSION.SDK_INT < 29 || (autofillId = ViewCompatShims.getAutofillId(this.view)) == null) {
            return null;
        }
        SemanticsNode parent = semanticsNode.getParent();
        if (parent != null) {
            autofillId2 = contentCaptureSessionCompat.newAutofillId(parent.getId());
            if (autofillId2 == null) {
                return null;
            }
        } else {
            autofillId2 = autofillId.toAutofillId();
        }
        ViewStructureCompat newVirtualViewStructure = contentCaptureSessionCompat.newVirtualViewStructure(autofillId2, semanticsNode.getId());
        if (newVirtualViewStructure == null) {
            return null;
        }
        SemanticsConfiguration unmergedConfig$ui_release = semanticsNode.getUnmergedConfig$ui_release();
        if (unmergedConfig$ui_release.contains(SemanticsProperties.INSTANCE.getPassword())) {
            return null;
        }
        Bundle extras = newVirtualViewStructure.getExtras();
        if (extras != null) {
            extras.putLong(VIEW_STRUCTURE_BUNDLE_KEY_TIMESTAMP, this.currentSemanticsNodesSnapshotTimestampMillis);
            extras.putInt(VIEW_STRUCTURE_BUNDLE_KEY_ADDITIONAL_INDEX, i);
        }
        String str = (String) SemanticsConfigurationKt.getOrNull(unmergedConfig$ui_release, SemanticsProperties.INSTANCE.getTestTag());
        if (str != null) {
            newVirtualViewStructure.setId(semanticsNode.getId(), null, null, str);
        }
        Boolean bool = (Boolean) SemanticsConfigurationKt.getOrNull(unmergedConfig$ui_release, SemanticsProperties.INSTANCE.getIsTraversalGroup());
        if (bool != null) {
            bool.booleanValue();
            newVirtualViewStructure.setClassName("android.widget.ViewGroup");
        }
        List list = (List) SemanticsConfigurationKt.getOrNull(unmergedConfig$ui_release, SemanticsProperties.INSTANCE.getText());
        if (list != null) {
            newVirtualViewStructure.setClassName(AndroidComposeViewAccessibilityDelegateCompat.TextClassName);
            newVirtualViewStructure.setText(ListUtilsKt.fastJoinToString$default(list, "\n", null, null, 0, null, null, 62, null));
        }
        AnnotatedString annotatedString = (AnnotatedString) SemanticsConfigurationKt.getOrNull(unmergedConfig$ui_release, SemanticsProperties.INSTANCE.getEditableText());
        if (annotatedString != null) {
            newVirtualViewStructure.setClassName(AndroidComposeViewAccessibilityDelegateCompat.TextFieldClassName);
            newVirtualViewStructure.setText(annotatedString);
        }
        List list2 = (List) SemanticsConfigurationKt.getOrNull(unmergedConfig$ui_release, SemanticsProperties.INSTANCE.getContentDescription());
        if (list2 != null) {
            newVirtualViewStructure.setContentDescription(ListUtilsKt.fastJoinToString$default(list2, "\n", null, null, 0, null, null, 62, null));
        }
        Role role = (Role) SemanticsConfigurationKt.getOrNull(unmergedConfig$ui_release, SemanticsProperties.INSTANCE.getRole());
        if (role != null && (m5885toLegacyClassNameV4PA4sw = SemanticsUtils_androidKt.m5885toLegacyClassNameV4PA4sw(role.m5910unboximpl())) != null) {
            newVirtualViewStructure.setClassName(m5885toLegacyClassNameV4PA4sw);
        }
        TextLayoutResult textLayoutResult = SemanticsUtils_androidKt.getTextLayoutResult(unmergedConfig$ui_release);
        if (textLayoutResult != null) {
            TextLayoutInput layoutInput = textLayoutResult.getLayoutInput();
            newVirtualViewStructure.setTextStyle(TextUnit.m6878getValueimpl(layoutInput.getStyle().m6178getFontSizeXSAIIZE()) * layoutInput.getDensity().getDensity() * layoutInput.getDensity().getFontScale(), 0, 0, 0);
        }
        Rect boundsInParent$ui_release = semanticsNode.getBoundsInParent$ui_release();
        newVirtualViewStructure.setDimens((int) boundsInParent$ui_release.getLeft(), (int) boundsInParent$ui_release.getTop(), 0, 0, (int) (boundsInParent$ui_release.getRight() - boundsInParent$ui_release.getLeft()), (int) (boundsInParent$ui_release.getBottom() - boundsInParent$ui_release.getTop()));
        return newVirtualViewStructure;
    }

    private final void fastForEachReplacedVisibleChildren(SemanticsNode semanticsNode, Function2<? super Integer, ? super SemanticsNode, Unit> function2) {
        List<SemanticsNode> replacedChildren$ui_release = semanticsNode.getReplacedChildren$ui_release();
        int size = replacedChildren$ui_release.size();
        int i = 0;
        for (int i2 = 0; i2 < size; i2++) {
            SemanticsNode semanticsNode2 = replacedChildren$ui_release.get(i2);
            if (getCurrentSemanticsNodes$ui_release().containsKey(semanticsNode2.getId())) {
                function2.invoke(Integer.valueOf(i), semanticsNode2);
                i++;
            }
        }
    }

    private final <T> void fastForEachIndexedWithFilter(List<? extends T> list, Function2<? super Integer, ? super T, Unit> function2, Function1<? super T, Boolean> function1) {
        int size = list.size();
        int i = 0;
        for (int i2 = 0; i2 < size; i2++) {
            Object obj = (T) list.get(i2);
            if (function1.invoke(obj).booleanValue()) {
                function2.invoke(Integer.valueOf(i), obj);
                i++;
            }
        }
    }

    private final void bufferContentCaptureViewAppeared(int i, ViewStructureCompat viewStructureCompat) {
        if (viewStructureCompat == null) {
            return;
        }
        this.bufferedEvents.add(new ContentCaptureEvent(i, this.currentSemanticsNodesSnapshotTimestampMillis, ContentCaptureEventType.VIEW_APPEAR, viewStructureCompat));
    }

    private final void bufferContentCaptureViewDisappeared(int i) {
        this.bufferedEvents.add(new ContentCaptureEvent(i, this.currentSemanticsNodesSnapshotTimestampMillis, ContentCaptureEventType.VIEW_DISAPPEAR, null));
    }

    private final void notifyContentCaptureChanges() {
        AutofillId newAutofillId;
        ContentCaptureSessionCompat contentCaptureSessionCompat = this.contentCaptureSession;
        if (contentCaptureSessionCompat == null || Build.VERSION.SDK_INT < 29 || this.bufferedEvents.isEmpty()) {
            return;
        }
        List<ContentCaptureEvent> list = this.bufferedEvents;
        int size = list.size();
        for (int i = 0; i < size; i++) {
            ContentCaptureEvent contentCaptureEvent = list.get(i);
            int i2 = WhenMappings.$EnumSwitchMapping$0[contentCaptureEvent.getType().ordinal()];
            if (i2 == 1) {
                ViewStructureCompat structureCompat = contentCaptureEvent.getStructureCompat();
                if (structureCompat != null) {
                    contentCaptureSessionCompat.notifyViewAppeared(structureCompat.toViewStructure());
                }
            } else if (i2 == 2 && (newAutofillId = contentCaptureSessionCompat.newAutofillId(contentCaptureEvent.getId())) != null) {
                contentCaptureSessionCompat.notifyViewDisappeared(newAutofillId);
            }
        }
        contentCaptureSessionCompat.flush();
        this.bufferedEvents.clear();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updateBuffersOnAppeared(int i, SemanticsNode semanticsNode) {
        if (isEnabled$ui_release()) {
            updateTranslationOnAppeared(semanticsNode);
            bufferContentCaptureViewAppeared(semanticsNode.getId(), toViewStructure(semanticsNode, i));
            fastForEachReplacedVisibleChildren(semanticsNode, new Function2<Integer, SemanticsNode, Unit>() { // from class: androidx.compose.ui.contentcapture.AndroidContentCaptureManager$updateBuffersOnAppeared$1
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Integer num, SemanticsNode semanticsNode2) {
                    invoke(num.intValue(), semanticsNode2);
                    return Unit.INSTANCE;
                }

                public final void invoke(int i2, SemanticsNode semanticsNode2) {
                    AndroidContentCaptureManager.this.updateBuffersOnAppeared(i2, semanticsNode2);
                }
            });
        }
    }

    private final void updateBuffersOnDisappeared(SemanticsNode semanticsNode) {
        if (isEnabled$ui_release()) {
            bufferContentCaptureViewDisappeared(semanticsNode.getId());
            List<SemanticsNode> replacedChildren$ui_release = semanticsNode.getReplacedChildren$ui_release();
            int size = replacedChildren$ui_release.size();
            for (int i = 0; i < size; i++) {
                updateBuffersOnDisappeared(replacedChildren$ui_release.get(i));
            }
        }
    }

    private final void updateTranslationOnAppeared(SemanticsNode semanticsNode) {
        AccessibilityAction accessibilityAction;
        Function1 function1;
        Function1 function12;
        SemanticsConfiguration unmergedConfig$ui_release = semanticsNode.getUnmergedConfig$ui_release();
        Boolean bool = (Boolean) SemanticsConfigurationKt.getOrNull(unmergedConfig$ui_release, SemanticsProperties.INSTANCE.getIsShowingTextSubstitution());
        if (this.translateStatus == TranslateStatus.SHOW_ORIGINAL && Intrinsics.areEqual((Object) bool, (Object) true)) {
            AccessibilityAction accessibilityAction2 = (AccessibilityAction) SemanticsConfigurationKt.getOrNull(unmergedConfig$ui_release, SemanticsActions.INSTANCE.getShowTextSubstitution());
            if (accessibilityAction2 == null || (function12 = (Function1) accessibilityAction2.getAction()) == null) {
                return;
            }
            Boolean bool2 = (Boolean) function12.invoke(false);
        } else if (this.translateStatus != TranslateStatus.SHOW_TRANSLATED || !Intrinsics.areEqual((Object) bool, (Object) false) || (accessibilityAction = (AccessibilityAction) SemanticsConfigurationKt.getOrNull(unmergedConfig$ui_release, SemanticsActions.INSTANCE.getShowTextSubstitution())) == null || (function1 = (Function1) accessibilityAction.getAction()) == null) {
        } else {
            Boolean bool3 = (Boolean) function1.invoke(true);
        }
    }

    public final void onShowTranslation$ui_release() {
        this.translateStatus = TranslateStatus.SHOW_TRANSLATED;
        showTranslatedText();
    }

    public final void onHideTranslation$ui_release() {
        this.translateStatus = TranslateStatus.SHOW_ORIGINAL;
        hideTranslatedText();
    }

    public final void onClearTranslation$ui_release() {
        this.translateStatus = TranslateStatus.SHOW_ORIGINAL;
        clearTranslatedText();
    }

    private final void showTranslatedText() {
        AccessibilityAction accessibilityAction;
        Function1 function1;
        IntObjectMap<SemanticsNodeWithAdjustedBounds> currentSemanticsNodes$ui_release = getCurrentSemanticsNodes$ui_release();
        Object[] objArr = currentSemanticsNodes$ui_release.values;
        long[] jArr = currentSemanticsNodes$ui_release.metadata;
        int length = jArr.length - 2;
        if (length < 0) {
            return;
        }
        int i = 0;
        while (true) {
            long j = jArr[i];
            if ((((~j) << 7) & j & (-9187201950435737472L)) != -9187201950435737472L) {
                int i2 = 8 - ((~(i - length)) >>> 31);
                for (int i3 = 0; i3 < i2; i3++) {
                    if ((255 & j) < 128) {
                        SemanticsConfiguration unmergedConfig$ui_release = ((SemanticsNodeWithAdjustedBounds) objArr[(i << 3) + i3]).getSemanticsNode().getUnmergedConfig$ui_release();
                        if (Intrinsics.areEqual(SemanticsConfigurationKt.getOrNull(unmergedConfig$ui_release, SemanticsProperties.INSTANCE.getIsShowingTextSubstitution()), (Object) false) && (accessibilityAction = (AccessibilityAction) SemanticsConfigurationKt.getOrNull(unmergedConfig$ui_release, SemanticsActions.INSTANCE.getShowTextSubstitution())) != null && (function1 = (Function1) accessibilityAction.getAction()) != null) {
                            Boolean bool = (Boolean) function1.invoke(true);
                        }
                    }
                    j >>= 8;
                }
                if (i2 != 8) {
                    return;
                }
            }
            if (i == length) {
                return;
            }
            i++;
        }
    }

    private final void hideTranslatedText() {
        AccessibilityAction accessibilityAction;
        Function1 function1;
        IntObjectMap<SemanticsNodeWithAdjustedBounds> currentSemanticsNodes$ui_release = getCurrentSemanticsNodes$ui_release();
        Object[] objArr = currentSemanticsNodes$ui_release.values;
        long[] jArr = currentSemanticsNodes$ui_release.metadata;
        int length = jArr.length - 2;
        if (length < 0) {
            return;
        }
        int i = 0;
        while (true) {
            long j = jArr[i];
            if ((((~j) << 7) & j & (-9187201950435737472L)) != -9187201950435737472L) {
                int i2 = 8 - ((~(i - length)) >>> 31);
                for (int i3 = 0; i3 < i2; i3++) {
                    if ((255 & j) < 128) {
                        SemanticsConfiguration unmergedConfig$ui_release = ((SemanticsNodeWithAdjustedBounds) objArr[(i << 3) + i3]).getSemanticsNode().getUnmergedConfig$ui_release();
                        if (Intrinsics.areEqual(SemanticsConfigurationKt.getOrNull(unmergedConfig$ui_release, SemanticsProperties.INSTANCE.getIsShowingTextSubstitution()), (Object) true) && (accessibilityAction = (AccessibilityAction) SemanticsConfigurationKt.getOrNull(unmergedConfig$ui_release, SemanticsActions.INSTANCE.getShowTextSubstitution())) != null && (function1 = (Function1) accessibilityAction.getAction()) != null) {
                            Boolean bool = (Boolean) function1.invoke(false);
                        }
                    }
                    j >>= 8;
                }
                if (i2 != 8) {
                    return;
                }
            }
            if (i == length) {
                return;
            }
            i++;
        }
    }

    private final void clearTranslatedText() {
        AccessibilityAction accessibilityAction;
        Function0 function0;
        IntObjectMap<SemanticsNodeWithAdjustedBounds> currentSemanticsNodes$ui_release = getCurrentSemanticsNodes$ui_release();
        Object[] objArr = currentSemanticsNodes$ui_release.values;
        long[] jArr = currentSemanticsNodes$ui_release.metadata;
        int length = jArr.length - 2;
        if (length < 0) {
            return;
        }
        int i = 0;
        while (true) {
            long j = jArr[i];
            if ((((~j) << 7) & j & (-9187201950435737472L)) != -9187201950435737472L) {
                int i2 = 8 - ((~(i - length)) >>> 31);
                for (int i3 = 0; i3 < i2; i3++) {
                    if ((255 & j) < 128) {
                        SemanticsConfiguration unmergedConfig$ui_release = ((SemanticsNodeWithAdjustedBounds) objArr[(i << 3) + i3]).getSemanticsNode().getUnmergedConfig$ui_release();
                        if (SemanticsConfigurationKt.getOrNull(unmergedConfig$ui_release, SemanticsProperties.INSTANCE.getIsShowingTextSubstitution()) != null && (accessibilityAction = (AccessibilityAction) SemanticsConfigurationKt.getOrNull(unmergedConfig$ui_release, SemanticsActions.INSTANCE.getClearTextSubstitution())) != null && (function0 = (Function0) accessibilityAction.getAction()) != null) {
                            Boolean bool = (Boolean) function0.invoke();
                        }
                    }
                    j >>= 8;
                }
                if (i2 != 8) {
                    return;
                }
            }
            if (i == length) {
                return;
            }
            i++;
        }
    }

    /* compiled from: AndroidContentCaptureManager.android.kt */
    @Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0016\n\u0000\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÃ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J \u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u000e\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\t0\bH\u0002J0\u0010\n\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u000e\u0010\u000f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00110\u0010H\u0007J \u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u000e\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\t0\bH\u0007¨\u0006\u0013"}, d2 = {"Landroidx/compose/ui/contentcapture/AndroidContentCaptureManager$ViewTranslationHelperMethods;", "", "()V", "doTranslation", "", "contentCaptureManager", "Landroidx/compose/ui/contentcapture/AndroidContentCaptureManager;", "response", "Landroid/util/LongSparseArray;", "Landroid/view/translation/ViewTranslationResponse;", "onCreateVirtualViewTranslationRequests", "virtualIds", "", "supportedFormats", "", "requestsCollector", "Ljava/util/function/Consumer;", "Landroid/view/translation/ViewTranslationRequest;", "onVirtualViewTranslationResponses", "ui_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* loaded from: classes.dex */
    private static final class ViewTranslationHelperMethods {
        public static final ViewTranslationHelperMethods INSTANCE = new ViewTranslationHelperMethods();

        private ViewTranslationHelperMethods() {
        }

        public final void onVirtualViewTranslationResponses(final AndroidContentCaptureManager androidContentCaptureManager, final LongSparseArray<ViewTranslationResponse> longSparseArray) {
            if (Build.VERSION.SDK_INT < 31) {
                return;
            }
            if (Intrinsics.areEqual(Looper.getMainLooper().getThread(), Thread.currentThread())) {
                doTranslation(androidContentCaptureManager, longSparseArray);
            } else {
                androidContentCaptureManager.getView().post(new Runnable() { // from class: androidx.compose.ui.contentcapture.AndroidContentCaptureManager$ViewTranslationHelperMethods$$ExternalSyntheticLambda0
                    @Override // java.lang.Runnable
                    public final void run() {
                        AndroidContentCaptureManager.ViewTranslationHelperMethods.onVirtualViewTranslationResponses$lambda$1(AndroidContentCaptureManager.this, longSparseArray);
                    }
                });
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void onVirtualViewTranslationResponses$lambda$1(AndroidContentCaptureManager androidContentCaptureManager, LongSparseArray longSparseArray) {
            INSTANCE.doTranslation(androidContentCaptureManager, longSparseArray);
        }

        private final void doTranslation(AndroidContentCaptureManager androidContentCaptureManager, LongSparseArray<ViewTranslationResponse> longSparseArray) {
            TranslationResponseValue value;
            CharSequence text;
            SemanticsNodeWithAdjustedBounds semanticsNodeWithAdjustedBounds;
            SemanticsNode semanticsNode;
            AccessibilityAction accessibilityAction;
            Function1 function1;
            int size = longSparseArray.size();
            for (int i = 0; i < size; i++) {
                long keyAt = longSparseArray.keyAt(i);
                ViewTranslationResponse viewTranslationResponse = longSparseArray.get(keyAt);
                if (viewTranslationResponse != null && (value = viewTranslationResponse.getValue("android:text")) != null && (text = value.getText()) != null && (semanticsNodeWithAdjustedBounds = androidContentCaptureManager.getCurrentSemanticsNodes$ui_release().get((int) keyAt)) != null && (semanticsNode = semanticsNodeWithAdjustedBounds.getSemanticsNode()) != null && (accessibilityAction = (AccessibilityAction) SemanticsConfigurationKt.getOrNull(semanticsNode.getUnmergedConfig$ui_release(), SemanticsActions.INSTANCE.getSetTextSubstitution())) != null && (function1 = (Function1) accessibilityAction.getAction()) != null) {
                    Boolean bool = (Boolean) function1.invoke(new AnnotatedString(text.toString(), null, 2, null));
                }
            }
        }

        public final void onCreateVirtualViewTranslationRequests(AndroidContentCaptureManager androidContentCaptureManager, long[] jArr, int[] iArr, Consumer<ViewTranslationRequest> consumer) {
            SemanticsNode semanticsNode;
            String fastJoinToString$default;
            for (long j : jArr) {
                SemanticsNodeWithAdjustedBounds semanticsNodeWithAdjustedBounds = androidContentCaptureManager.getCurrentSemanticsNodes$ui_release().get((int) j);
                if (semanticsNodeWithAdjustedBounds != null && (semanticsNode = semanticsNodeWithAdjustedBounds.getSemanticsNode()) != null) {
                    ViewTranslationRequest.Builder builder = new ViewTranslationRequest.Builder(androidContentCaptureManager.getView().getAutofillId(), semanticsNode.getId());
                    List list = (List) SemanticsConfigurationKt.getOrNull(semanticsNode.getUnmergedConfig$ui_release(), SemanticsProperties.INSTANCE.getText());
                    if (list != null && (fastJoinToString$default = ListUtilsKt.fastJoinToString$default(list, "\n", null, null, 0, null, null, 62, null)) != null) {
                        builder.setValue("android:text", TranslationRequestValue.forText(new AnnotatedString(fastJoinToString$default, null, 2, null)));
                        consumer.accept(builder.build());
                    }
                }
            }
        }
    }

    public final void onCreateVirtualViewTranslationRequests$ui_release(long[] jArr, int[] iArr, Consumer<ViewTranslationRequest> consumer) {
        ViewTranslationHelperMethods.INSTANCE.onCreateVirtualViewTranslationRequests(this, jArr, iArr, consumer);
    }

    public final void onVirtualViewTranslationResponses$ui_release(AndroidContentCaptureManager androidContentCaptureManager, LongSparseArray<ViewTranslationResponse> longSparseArray) {
        ViewTranslationHelperMethods.INSTANCE.onVirtualViewTranslationResponses(androidContentCaptureManager, longSparseArray);
    }

    /* compiled from: AndroidContentCaptureManager.android.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Landroidx/compose/ui/contentcapture/AndroidContentCaptureManager$Companion;", "", "()V", "VIEW_STRUCTURE_BUNDLE_KEY_ADDITIONAL_INDEX", "", "VIEW_STRUCTURE_BUNDLE_KEY_TIMESTAMP", "ui_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* loaded from: classes.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    private final void checkForContentCapturePropertyChanges(IntObjectMap<SemanticsNodeWithAdjustedBounds> intObjectMap) {
        int[] iArr;
        long[] jArr;
        int[] iArr2;
        long[] jArr2;
        long j;
        char c;
        long j2;
        int i;
        SemanticsNode semanticsNode;
        int i2;
        SemanticsNode semanticsNode2;
        long j3;
        int i3;
        long[] jArr3;
        IntObjectMap<SemanticsNodeWithAdjustedBounds> intObjectMap2 = intObjectMap;
        int[] iArr3 = intObjectMap2.keys;
        long[] jArr4 = intObjectMap2.metadata;
        int length = jArr4.length - 2;
        if (length < 0) {
            return;
        }
        int i4 = 0;
        while (true) {
            long j4 = jArr4[i4];
            char c2 = 7;
            long j5 = -9187201950435737472L;
            if ((((~j4) << 7) & j4 & (-9187201950435737472L)) != -9187201950435737472L) {
                int i5 = 8;
                int i6 = 8 - ((~(i4 - length)) >>> 31);
                int i7 = 0;
                while (i7 < i6) {
                    if ((j4 & 255) < 128) {
                        int i8 = iArr3[(i4 << 3) + i7];
                        c = c2;
                        SemanticsNodeCopy semanticsNodeCopy = this.previousSemanticsNodes.get(i8);
                        SemanticsNodeWithAdjustedBounds semanticsNodeWithAdjustedBounds = intObjectMap2.get(i8);
                        SemanticsNode semanticsNode3 = semanticsNodeWithAdjustedBounds != null ? semanticsNodeWithAdjustedBounds.getSemanticsNode() : null;
                        if (semanticsNode3 == null) {
                            InlineClassHelperKt.throwIllegalStateExceptionForNullCheck("no value for specified key");
                            throw new KotlinNothingValueException();
                        }
                        if (semanticsNodeCopy == null) {
                            MutableScatterMap<SemanticsPropertyKey<?>, Object> props$ui_release = semanticsNode3.getUnmergedConfig$ui_release().getProps$ui_release();
                            j2 = j5;
                            Object[] objArr = props$ui_release.keys;
                            long[] jArr5 = props$ui_release.metadata;
                            int length2 = jArr5.length - 2;
                            if (length2 >= 0) {
                                int i9 = 0;
                                int i10 = i5;
                                while (true) {
                                    long j6 = jArr5[i9];
                                    iArr2 = iArr3;
                                    if ((((~j6) << c) & j6 & j2) != j2) {
                                        int i11 = 8 - ((~(i9 - length2)) >>> 31);
                                        int i12 = 0;
                                        while (i12 < i11) {
                                            if ((j6 & 255) < 128) {
                                                i3 = i12;
                                                jArr3 = jArr4;
                                                if (Intrinsics.areEqual((SemanticsPropertyKey) objArr[(i9 << 3) + i12], SemanticsProperties.INSTANCE.getText())) {
                                                    List list = (List) SemanticsConfigurationKt.getOrNull(semanticsNode3.getUnmergedConfig$ui_release(), SemanticsProperties.INSTANCE.getText());
                                                    sendContentCaptureTextUpdateEvent(semanticsNode3.getId(), String.valueOf(list != null ? (AnnotatedString) CollectionsKt.firstOrNull((List<? extends Object>) list) : null));
                                                }
                                            } else {
                                                i3 = i12;
                                                jArr3 = jArr4;
                                            }
                                            j6 >>= i10;
                                            i12 = i3 + 1;
                                            jArr4 = jArr3;
                                        }
                                        jArr2 = jArr4;
                                        if (i11 != i10) {
                                            break;
                                        }
                                    } else {
                                        jArr2 = jArr4;
                                    }
                                    if (i9 == length2) {
                                        break;
                                    }
                                    i9++;
                                    iArr3 = iArr2;
                                    jArr4 = jArr2;
                                    i10 = 8;
                                }
                            } else {
                                iArr2 = iArr3;
                                jArr2 = jArr4;
                            }
                        } else {
                            iArr2 = iArr3;
                            jArr2 = jArr4;
                            j2 = j5;
                            MutableScatterMap<SemanticsPropertyKey<?>, Object> props$ui_release2 = semanticsNode3.getUnmergedConfig$ui_release().getProps$ui_release();
                            Object[] objArr2 = props$ui_release2.keys;
                            long[] jArr6 = props$ui_release2.metadata;
                            int length3 = jArr6.length - 2;
                            if (length3 >= 0) {
                                int i13 = 0;
                                while (true) {
                                    long j7 = jArr6[i13];
                                    long[] jArr7 = jArr6;
                                    Object[] objArr3 = objArr2;
                                    if ((((~j7) << c) & j7 & j2) != j2) {
                                        int i14 = 8 - ((~(i13 - length3)) >>> 31);
                                        int i15 = 0;
                                        while (i15 < i14) {
                                            if ((j7 & 255) < 128) {
                                                i2 = i15;
                                                semanticsNode2 = semanticsNode3;
                                                if (Intrinsics.areEqual((SemanticsPropertyKey) objArr3[(i13 << 3) + i15], SemanticsProperties.INSTANCE.getText())) {
                                                    List list2 = (List) SemanticsConfigurationKt.getOrNull(semanticsNodeCopy.getUnmergedConfig(), SemanticsProperties.INSTANCE.getText());
                                                    AnnotatedString annotatedString = list2 != null ? (AnnotatedString) CollectionsKt.firstOrNull((List<? extends Object>) list2) : null;
                                                    j3 = j4;
                                                    List list3 = (List) SemanticsConfigurationKt.getOrNull(semanticsNode2.getUnmergedConfig$ui_release(), SemanticsProperties.INSTANCE.getText());
                                                    AnnotatedString annotatedString2 = list3 != null ? (AnnotatedString) CollectionsKt.firstOrNull((List<? extends Object>) list3) : null;
                                                    if (!Intrinsics.areEqual(annotatedString, annotatedString2)) {
                                                        sendContentCaptureTextUpdateEvent(semanticsNode2.getId(), String.valueOf(annotatedString2));
                                                    }
                                                    j7 >>= 8;
                                                    i15 = i2 + 1;
                                                    semanticsNode3 = semanticsNode2;
                                                    j4 = j3;
                                                }
                                            } else {
                                                i2 = i15;
                                                semanticsNode2 = semanticsNode3;
                                            }
                                            j3 = j4;
                                            j7 >>= 8;
                                            i15 = i2 + 1;
                                            semanticsNode3 = semanticsNode2;
                                            j4 = j3;
                                        }
                                        semanticsNode = semanticsNode3;
                                        j = j4;
                                        if (i14 != 8) {
                                            break;
                                        }
                                    } else {
                                        semanticsNode = semanticsNode3;
                                        j = j4;
                                    }
                                    if (i13 == length3) {
                                        break;
                                    }
                                    i13++;
                                    objArr2 = objArr3;
                                    jArr6 = jArr7;
                                    semanticsNode3 = semanticsNode;
                                    j4 = j;
                                }
                                i = 8;
                            }
                        }
                        j = j4;
                        i = 8;
                    } else {
                        iArr2 = iArr3;
                        jArr2 = jArr4;
                        j = j4;
                        c = c2;
                        j2 = j5;
                        i = i5;
                    }
                    j4 = j >> i;
                    i7++;
                    intObjectMap2 = intObjectMap;
                    i5 = i;
                    c2 = c;
                    j5 = j2;
                    iArr3 = iArr2;
                    jArr4 = jArr2;
                }
                iArr = iArr3;
                jArr = jArr4;
                if (i6 != i5) {
                    return;
                }
            } else {
                iArr = iArr3;
                jArr = jArr4;
            }
            if (i4 == length) {
                return;
            }
            i4++;
            intObjectMap2 = intObjectMap;
            iArr3 = iArr;
            jArr4 = jArr;
        }
    }
}
