package ru.mrlargha.commonui.elements.donate.presentation.pages;

import android.app.Activity;
import android.graphics.drawable.ColorDrawable;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewParent;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.media3.extractor.text.ttml.TtmlNode;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.google.firebase.remoteconfig.RemoteConfigConstants;
import io.appmetrica.analytics.networktasks.internal.CommonUrlParts;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import ru.mrlargha.commonui.R;
import ru.mrlargha.commonui.databinding.DonatePayPassBinding;
import ru.mrlargha.commonui.databinding.DonatePayPassTooltipBinding;
import ru.mrlargha.commonui.elements.donate.presentation.DonateOnItemCompleteListeners;
import ru.mrlargha.commonui.elements.donate.presentation.adapters.DonatePayPassAdapter;
import ru.mrlargha.commonui.elements.donate.presentation.adapters.DonatePayPassColumn;
import ru.mrlargha.commonui.elements.donate.presentation.adapters.DonatePayPassProgressFill;
import ru.mrlargha.commonui.elements.donate.presentation.models.DonatePayPassDynamicState;
import ru.mrlargha.commonui.elements.donate.presentation.models.DonatePayPassLevel;
import ru.mrlargha.commonui.elements.donate.presentation.models.DonatePayPassReward;
import ru.mrlargha.commonui.elements.donate.presentation.models.DonatePayPassState;
import ru.mrlargha.commonui.elements.donate.presentation.models.DonatePayPassStateKt;
import ru.mrlargha.commonui.elements.donate.presentation.models.DonatePayPassTierStatus;
import ru.mrlargha.commonui.utils.ui.CustomCardView;
/* compiled from: DonatePayPass.kt */
@Metadata(d1 = {"\u0000\u0098\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0010\t\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\r\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0012*\u0002*-\u0018\u0000 R2\u00020\u0001:\u0001RB?\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0016\b\u0002\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b¢\u0006\u0004\b\r\u0010\u000eJ\u0018\u0010/\u001a\u00020\f2\u0006\u00100\u001a\u00020\u00032\u0006\u00101\u001a\u000202H\u0016J\u000e\u00103\u001a\u00020\f2\u0006\u00101\u001a\u000202J\u0014\u00104\u001a\u00020\f2\f\u00105\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001aJ\b\u00106\u001a\u00020\fH\u0002J\u0006\u00107\u001a\u00020\fJ\u0006\u00108\u001a\u00020\fJ\b\u00109\u001a\u00020\fH\u0016J\u0010\u0010:\u001a\u00020\f2\u0006\u0010;\u001a\u00020\u001fH\u0002J\b\u0010<\u001a\u00020\fH\u0002J\u0010\u0010=\u001a\u00020\f2\u0006\u0010;\u001a\u00020\u001fH\u0002J\u0018\u0010>\u001a\u00020?2\u0006\u0010@\u001a\u00020A2\u0006\u0010B\u001a\u00020AH\u0002J\b\u0010C\u001a\u00020\fH\u0002J\b\u0010D\u001a\u00020\fH\u0002J\u0010\u0010E\u001a\u0002022\u0006\u0010F\u001a\u00020\u0018H\u0002J\u0010\u0010G\u001a\u00020\f2\u0006\u0010;\u001a\u00020\u001fH\u0002J\u0010\u0010H\u001a\u00020\f2\u0006\u0010I\u001a\u00020\u0003H\u0002J\u0010\u0010J\u001a\u00020!2\u0006\u0010I\u001a\u00020\u0003H\u0002J\b\u0010K\u001a\u00020\fH\u0002J\b\u0010L\u001a\u00020\fH\u0002J \u0010M\u001a\u00020\f2\u0006\u0010N\u001a\u00020&2\u0006\u0010O\u001a\u0002022\u0006\u0010P\u001a\u000202H\u0002J\b\u0010Q\u001a\u00020\fH\u0002R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u001c\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\f\u0018\u00010\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0011\u001a\n \u0013*\u0004\u0018\u00010\u00120\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00180\u0017X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u001dX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u001fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020!X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020!X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010#\u001a\u0004\u0018\u00010$X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010%\u001a\u0004\u0018\u00010&X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020(X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010)\u001a\u00020*X\u0082\u0004¢\u0006\u0004\n\u0002\u0010+R\u0010\u0010,\u001a\u00020-X\u0082\u0004¢\u0006\u0004\n\u0002\u0010.¨\u0006S"}, d2 = {"Lru/mrlargha/commonui/elements/donate/presentation/pages/DonatePayPass;", "Lru/mrlargha/commonui/elements/donate/presentation/pages/DonatePage;", "backendId", "", "targetActivity", "Landroid/app/Activity;", "onItemCompleteListeners", "Lru/mrlargha/commonui/elements/donate/presentation/DonateOnItemCompleteListeners;", "binding", "Lru/mrlargha/commonui/databinding/DonatePayPassBinding;", "onClaimLevel", "Lkotlin/Function1;", "", "<init>", "(ILandroid/app/Activity;Lru/mrlargha/commonui/elements/donate/presentation/DonateOnItemCompleteListeners;Lru/mrlargha/commonui/databinding/DonatePayPassBinding;Lkotlin/jvm/functions/Function1;)V", "getBinding", "()Lru/mrlargha/commonui/databinding/DonatePayPassBinding;", "inflater", "Landroid/view/LayoutInflater;", "kotlin.jvm.PlatformType", "mainHandler", "Landroid/os/Handler;", "pendingUntil", "", "", "catalog", "", "Lru/mrlargha/commonui/elements/donate/presentation/models/DonatePayPassLevel;", "dynamic", "Lru/mrlargha/commonui/elements/donate/presentation/models/DonatePayPassDynamicState;", RemoteConfigConstants.ResponseFieldKey.STATE, "Lru/mrlargha/commonui/elements/donate/presentation/models/DonatePayPassState;", "seasonExpiredBound", "", "pageSelected", "tooltipPopup", "Landroid/widget/PopupWindow;", "tooltipAnchor", "Landroid/view/View;", "tiersAdapter", "Lru/mrlargha/commonui/elements/donate/presentation/adapters/DonatePayPassAdapter;", "countdownRunnable", "ru/mrlargha/commonui/elements/donate/presentation/pages/DonatePayPass$countdownRunnable$1", "Lru/mrlargha/commonui/elements/donate/presentation/pages/DonatePayPass$countdownRunnable$1;", "pendingTimeoutRunnable", "ru/mrlargha/commonui/elements/donate/presentation/pages/DonatePayPass$pendingTimeoutRunnable$1", "Lru/mrlargha/commonui/elements/donate/presentation/pages/DonatePayPass$pendingTimeoutRunnable$1;", "onBackendMessage", "subId", "data", "", "applyFullState", "applyCatalog", "levels", "publishResolved", "onPageSelected", "onHidden", "stopPendingWork", "bindState", CommonUrlParts.MODEL, "bindEmptyHeader", "bindHeader", "formatProgressText", "", "totalMoney", "", "maxMoney", "startCountdown", "bindTimer", "formatSeasonRemaining", "remainingMs", "bindTiers", "claimLevel", TtmlNode.ATTR_ID, "isPending", "schedulePendingTimeout", "showLocalInfo", "showTooltip", "anchor", "title", "description", "dismissTooltip", "Companion", "CommonUI"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class DonatePayPass extends DonatePage {
    @Deprecated
    public static final long COUNTDOWN_INTERVAL_MS = 1000;
    private static final Companion Companion = new Companion(null);
    @Deprecated
    public static final int GOLD = -16640;
    @Deprecated
    public static final int MUTED_WHITE = -2130706433;
    @Deprecated
    public static final long PENDING_TIMEOUT_MS = 10000;
    private final DonatePayPassBinding binding;
    private List<DonatePayPassLevel> catalog;
    private final DonatePayPass$countdownRunnable$1 countdownRunnable;
    private DonatePayPassDynamicState dynamic;
    private final LayoutInflater inflater;
    private final Handler mainHandler;
    private final Function1<Integer, Unit> onClaimLevel;
    private boolean pageSelected;
    private final DonatePayPass$pendingTimeoutRunnable$1 pendingTimeoutRunnable;
    private final Map<Integer, Long> pendingUntil;
    private boolean seasonExpiredBound;
    private DonatePayPassState state;
    private final DonatePayPassAdapter tiersAdapter;
    private View tooltipAnchor;
    private PopupWindow tooltipPopup;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v4, types: [ru.mrlargha.commonui.elements.donate.presentation.pages.DonatePayPass$countdownRunnable$1] */
    /* JADX WARN: Type inference failed for: r5v5, types: [ru.mrlargha.commonui.elements.donate.presentation.pages.DonatePayPass$pendingTimeoutRunnable$1] */
    public DonatePayPass(int i, Activity targetActivity, DonateOnItemCompleteListeners onItemCompleteListeners, DonatePayPassBinding binding, Function1<? super Integer, Unit> function1) {
        super(i, targetActivity, onItemCompleteListeners);
        Intrinsics.checkNotNullParameter(targetActivity, "targetActivity");
        Intrinsics.checkNotNullParameter(onItemCompleteListeners, "onItemCompleteListeners");
        Intrinsics.checkNotNullParameter(binding, "binding");
        this.binding = binding;
        this.onClaimLevel = function1;
        Activity activity = targetActivity;
        this.inflater = LayoutInflater.from(activity);
        this.mainHandler = new Handler(Looper.getMainLooper());
        this.pendingUntil = new LinkedHashMap();
        this.catalog = CollectionsKt.emptyList();
        DonatePayPassAdapter donatePayPassAdapter = new DonatePayPassAdapter(function1 != 0 ? new Function1() { // from class: ru.mrlargha.commonui.elements.donate.presentation.pages.DonatePayPass$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit tiersAdapter$lambda$0$0;
                tiersAdapter$lambda$0$0 = DonatePayPass.tiersAdapter$lambda$0$0(DonatePayPass.this, ((Integer) obj).intValue());
                return tiersAdapter$lambda$0$0;
            }
        } : null, new Function3() { // from class: ru.mrlargha.commonui.elements.donate.presentation.pages.DonatePayPass$$ExternalSyntheticLambda3
            @Override // kotlin.jvm.functions.Function3
            public final Object invoke(Object obj, Object obj2, Object obj3) {
                return DonatePayPass.tiersAdapter$lambda$1(DonatePayPass.this, (View) obj, (String) obj2, (String) obj3);
            }
        }, new Function1() { // from class: ru.mrlargha.commonui.elements.donate.presentation.pages.DonatePayPass$$ExternalSyntheticLambda4
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return DonatePayPass.tiersAdapter$lambda$2(DonatePayPass.this, (View) obj);
            }
        });
        this.tiersAdapter = donatePayPassAdapter;
        this.countdownRunnable = new Runnable() { // from class: ru.mrlargha.commonui.elements.donate.presentation.pages.DonatePayPass$countdownRunnable$1
            @Override // java.lang.Runnable
            public void run() {
                boolean z;
                DonatePayPassState donatePayPassState;
                Handler handler;
                z = DonatePayPass.this.pageSelected;
                if (z) {
                    DonatePayPass.this.bindTimer();
                    donatePayPassState = DonatePayPass.this.state;
                    if (donatePayPassState == null || DonatePayPassState.isSeasonExpired$default(donatePayPassState, 0L, 1, null)) {
                        return;
                    }
                    handler = DonatePayPass.this.mainHandler;
                    handler.postDelayed(this, 1000L);
                }
            }
        };
        this.pendingTimeoutRunnable = new Runnable() { // from class: ru.mrlargha.commonui.elements.donate.presentation.pages.DonatePayPass$pendingTimeoutRunnable$1
            /* JADX WARN: Code restructure failed: missing block: B:17:0x007c, code lost:
                r0 = r7.this$0.state;
             */
            @Override // java.lang.Runnable
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public void run() {
                Map map;
                boolean z;
                DonatePayPassState donatePayPassState;
                Map map2;
                long elapsedRealtime = SystemClock.elapsedRealtime();
                map = DonatePayPass.this.pendingUntil;
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                for (Map.Entry entry : map.entrySet()) {
                    if (((Number) entry.getValue()).longValue() <= elapsedRealtime) {
                        linkedHashMap.put(entry.getKey(), entry.getValue());
                    }
                }
                List<Number> list = CollectionsKt.toList(linkedHashMap.keySet());
                if (list.isEmpty()) {
                    return;
                }
                DonatePayPass donatePayPass = DonatePayPass.this;
                for (Number number : list) {
                    int intValue = number.intValue();
                    map2 = donatePayPass.pendingUntil;
                    map2.remove(Integer.valueOf(intValue));
                }
                z = DonatePayPass.this.pageSelected;
                if (z && donatePayPassState != null) {
                    DonatePayPass.this.bindTiers(donatePayPassState);
                }
                DonatePayPass.this.schedulePendingTimeout();
            }
        };
        RecyclerView recyclerView = binding.paypassTiers;
        recyclerView.setLayoutManager(new LinearLayoutManager(activity, 0, false));
        recyclerView.setAdapter(donatePayPassAdapter);
        recyclerView.setItemAnimator(null);
        recyclerView.setNestedScrollingEnabled(false);
        binding.paypassInfoButton.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.commonui.elements.donate.presentation.pages.DonatePayPass$$ExternalSyntheticLambda5
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DonatePayPass.this.showLocalInfo();
            }
        });
        binding.getRoot().addOnAttachStateChangeListener(new View.OnAttachStateChangeListener() { // from class: ru.mrlargha.commonui.elements.donate.presentation.pages.DonatePayPass.3
            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewAttachedToWindow(View v) {
                Intrinsics.checkNotNullParameter(v, "v");
            }

            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewDetachedFromWindow(View v) {
                Intrinsics.checkNotNullParameter(v, "v");
                DonatePayPass.this.onHidden();
            }
        });
    }

    public /* synthetic */ DonatePayPass(int i, Activity activity, DonateOnItemCompleteListeners donateOnItemCompleteListeners, DonatePayPassBinding donatePayPassBinding, Function1 function1, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, activity, donateOnItemCompleteListeners, donatePayPassBinding, (i2 & 16) != 0 ? null : function1);
    }

    public final DonatePayPassBinding getBinding() {
        return this.binding;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit tiersAdapter$lambda$0$0(DonatePayPass donatePayPass, int i) {
        donatePayPass.claimLevel(i);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit tiersAdapter$lambda$1(DonatePayPass donatePayPass, View anchor, String title, String body) {
        Intrinsics.checkNotNullParameter(anchor, "anchor");
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(body, "body");
        donatePayPass.showTooltip(anchor, title, body);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit tiersAdapter$lambda$2(DonatePayPass donatePayPass, View root) {
        Intrinsics.checkNotNullParameter(root, "root");
        View view = donatePayPass.tooltipAnchor;
        if (view != null && (root == view || Companion.isDescendant(root, view))) {
            donatePayPass.dismissTooltip();
        }
        return Unit.INSTANCE;
    }

    @Override // ru.mrlargha.commonui.elements.donate.presentation.pages.DonatePage
    public void onBackendMessage(int i, String data) {
        Intrinsics.checkNotNullParameter(data, "data");
        applyFullState(data);
    }

    public final void applyFullState(String data) {
        Intrinsics.checkNotNullParameter(data, "data");
        DonatePayPassDynamicState parseDonatePayPassDynamicState = DonatePayPassStateKt.parseDonatePayPassDynamicState(data);
        if (parseDonatePayPassDynamicState == null) {
            return;
        }
        this.pendingUntil.clear();
        this.mainHandler.removeCallbacks(this.pendingTimeoutRunnable);
        this.dynamic = parseDonatePayPassDynamicState;
        publishResolved();
    }

    public final void applyCatalog(List<DonatePayPassLevel> levels) {
        Intrinsics.checkNotNullParameter(levels, "levels");
        this.catalog = levels;
        publishResolved();
    }

    private final void publishResolved() {
        DonatePayPassState resolvePayPassState = DonatePayPassStateKt.resolvePayPassState(this.catalog, this.dynamic);
        this.state = resolvePayPassState;
        if (resolvePayPassState == null) {
            this.seasonExpiredBound = false;
            if (this.pageSelected) {
                bindEmptyHeader();
                return;
            }
            return;
        }
        this.seasonExpiredBound = DonatePayPassState.isSeasonExpired$default(resolvePayPassState, 0L, 1, null);
        if (this.pageSelected) {
            bindState(resolvePayPassState);
            getOnItemCompleteListeners().itemReadyToShow();
        }
    }

    public final void onPageSelected() {
        this.pageSelected = true;
        getOnItemCompleteListeners().itemReadyToShow();
        DonatePayPassState donatePayPassState = this.state;
        if (donatePayPassState != null) {
            bindState(donatePayPassState);
        } else {
            bindEmptyHeader();
        }
    }

    public final void onHidden() {
        this.pageSelected = false;
        this.pendingUntil.clear();
        this.mainHandler.removeCallbacks(this.countdownRunnable);
        this.mainHandler.removeCallbacks(this.pendingTimeoutRunnable);
        dismissTooltip();
    }

    @Override // ru.mrlargha.commonui.elements.donate.presentation.pages.DonatePage
    public void stopPendingWork() {
        onHidden();
        this.catalog = CollectionsKt.emptyList();
        this.dynamic = null;
        this.state = null;
        this.seasonExpiredBound = false;
        this.tiersAdapter.submitList(CollectionsKt.emptyList());
        bindEmptyHeader();
    }

    private final void bindState(DonatePayPassState donatePayPassState) {
        bindHeader(donatePayPassState);
        bindTimer();
        startCountdown();
        boolean isEmpty = donatePayPassState.getRewards().isEmpty();
        RecyclerView paypassTiers = this.binding.paypassTiers;
        Intrinsics.checkNotNullExpressionValue(paypassTiers, "paypassTiers");
        paypassTiers.setVisibility(isEmpty ? 8 : 0);
        TextView paypassEmpty = this.binding.paypassEmpty;
        Intrinsics.checkNotNullExpressionValue(paypassEmpty, "paypassEmpty");
        paypassEmpty.setVisibility(isEmpty ? 0 : 8);
        if (isEmpty) {
            dismissTooltip();
            this.tiersAdapter.submitList(CollectionsKt.emptyList());
            return;
        }
        bindTiers(donatePayPassState);
    }

    private final void bindEmptyHeader() {
        DonatePayPassBinding donatePayPassBinding = this.binding;
        donatePayPassBinding.paypassProgressValue.setText(formatProgressText(FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE, FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE));
        donatePayPassBinding.paypassTimerValue.setText(getTargetActivity().getString(R.string.donate_paypass_timer_zero));
        RecyclerView paypassTiers = donatePayPassBinding.paypassTiers;
        Intrinsics.checkNotNullExpressionValue(paypassTiers, "paypassTiers");
        paypassTiers.setVisibility(8);
        TextView paypassEmpty = donatePayPassBinding.paypassEmpty;
        Intrinsics.checkNotNullExpressionValue(paypassEmpty, "paypassEmpty");
        paypassEmpty.setVisibility(0);
        this.tiersAdapter.submitList(CollectionsKt.emptyList());
    }

    private final void bindHeader(DonatePayPassState donatePayPassState) {
        this.binding.paypassProgressValue.setText(formatProgressText(donatePayPassState.getTotalMoney(), donatePayPassState.getMaxMoney()));
    }

    private final CharSequence formatProgressText(double d, double d2) {
        String string = getTargetActivity().getString(R.string.donate_paypass_ruble);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        String string2 = getTargetActivity().getString(R.string.donate_paypass_progress_value, new Object[]{DonatePayPassStateKt.formatPayPassMoney(d) + " " + string, DonatePayPassStateKt.formatPayPassMoney(d2) + " " + string});
        Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
        String str = string2;
        SpannableString spannableString = new SpannableString(str);
        int indexOf$default = StringsKt.indexOf$default((CharSequence) str, '/', 0, false, 6, (Object) null);
        spannableString.setSpan(new ForegroundColorSpan(-16640), 0, indexOf$default >= 0 ? indexOf$default : string2.length(), 33);
        if (indexOf$default >= 0) {
            spannableString.setSpan(new ForegroundColorSpan((int) MUTED_WHITE), indexOf$default, string2.length(), 33);
        }
        return spannableString;
    }

    private final void startCountdown() {
        DonatePayPassState donatePayPassState;
        this.mainHandler.removeCallbacks(this.countdownRunnable);
        if (!this.pageSelected || (donatePayPassState = this.state) == null || DonatePayPassState.isSeasonExpired$default(donatePayPassState, 0L, 1, null)) {
            return;
        }
        this.mainHandler.postDelayed(this.countdownRunnable, 1000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void bindTimer() {
        DonatePayPassState donatePayPassState = this.state;
        if (donatePayPassState == null) {
            return;
        }
        long remainingSeasonMs$default = DonatePayPassState.remainingSeasonMs$default(donatePayPassState, 0L, 1, null);
        this.binding.paypassTimerValue.setText(formatSeasonRemaining(remainingSeasonMs$default));
        if (remainingSeasonMs$default <= 0) {
            this.mainHandler.removeCallbacks(this.countdownRunnable);
            if (this.seasonExpiredBound) {
                return;
            }
            this.seasonExpiredBound = true;
            if (donatePayPassState.getRewards().isEmpty()) {
                return;
            }
            bindTiers(donatePayPassState);
        }
    }

    private final String formatSeasonRemaining(long j) {
        if (j <= 0) {
            String string = getTargetActivity().getString(R.string.donate_paypass_timer_zero);
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
            return string;
        }
        long days = TimeUnit.MILLISECONDS.toDays(j);
        long hours = TimeUnit.MILLISECONDS.toHours(j) % 24;
        long minutes = TimeUnit.MILLISECONDS.toMinutes(j) % 60;
        if (days > 0) {
            String string2 = getTargetActivity().getString(R.string.donate_paypass_timer_days_hours, new Object[]{Long.valueOf(days), Long.valueOf(hours)});
            Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
            return string2;
        } else if (hours > 0) {
            String string3 = getTargetActivity().getString(R.string.donate_paypass_timer_hours_minutes, new Object[]{Long.valueOf(hours), Long.valueOf(minutes)});
            Intrinsics.checkNotNullExpressionValue(string3, "getString(...)");
            return string3;
        } else {
            String string4 = getTargetActivity().getString(R.string.donate_paypass_timer_minutes, new Object[]{Long.valueOf(minutes)});
            Intrinsics.checkNotNullExpressionValue(string4, "getString(...)");
            return string4;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void bindTiers(DonatePayPassState donatePayPassState) {
        int i;
        DonatePayPassProgressFill donatePayPassProgressFill;
        dismissTooltip();
        boolean isSeasonExpired$default = DonatePayPassState.isSeasonExpired$default(donatePayPassState, 0L, 1, null);
        List<DonatePayPassReward> rewards = donatePayPassState.getRewards();
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(rewards, 10));
        Iterator<T> it = rewards.iterator();
        while (true) {
            boolean z = false;
            if (!it.hasNext()) {
                break;
            }
            DonatePayPassReward donatePayPassReward = (DonatePayPassReward) it.next();
            if (donatePayPassReward.getCanClaim() || donatePayPassReward.getStatus() == DonatePayPassTierStatus.RECEIVED) {
                z = true;
            }
            arrayList.add(Boolean.valueOf(z));
        }
        ArrayList arrayList2 = arrayList;
        ListIterator listIterator = arrayList2.listIterator(arrayList2.size());
        while (true) {
            if (listIterator.hasPrevious()) {
                if (((Boolean) listIterator.previous()).booleanValue()) {
                    i = listIterator.nextIndex();
                    break;
                }
            } else {
                i = -1;
                break;
            }
        }
        int lastIndex = CollectionsKt.getLastIndex(donatePayPassState.getRewards());
        List<DonatePayPassReward> rewards2 = donatePayPassState.getRewards();
        ArrayList arrayList3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(rewards2, 10));
        int i2 = 0;
        for (Object obj : rewards2) {
            int i3 = i2 + 1;
            if (i2 < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            DonatePayPassReward donatePayPassReward2 = (DonatePayPassReward) obj;
            if (i < 0 || i >= donatePayPassState.getRewards().size()) {
                donatePayPassProgressFill = DonatePayPassProgressFill.NONE;
            } else if (i2 < i) {
                donatePayPassProgressFill = DonatePayPassProgressFill.FULL;
            } else if (i2 == i) {
                donatePayPassProgressFill = DonatePayPassProgressFill.TO_CENTER;
            } else {
                donatePayPassProgressFill = DonatePayPassProgressFill.NONE;
            }
            arrayList3.add(new DonatePayPassColumn(donatePayPassReward2, i2 == 0, i2 == lastIndex, ((Boolean) arrayList2.get(i2)).booleanValue(), donatePayPassProgressFill, isPending(donatePayPassReward2.getId()), isSeasonExpired$default));
            i2 = i3;
        }
        this.tiersAdapter.submitList(arrayList3);
    }

    private final void claimLevel(int i) {
        Object obj;
        Function1<Integer, Unit> function1;
        DonatePayPassState donatePayPassState = this.state;
        if (donatePayPassState == null) {
            return;
        }
        Iterator<T> it = donatePayPassState.getRewards().iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            if (((DonatePayPassReward) obj).getId() == i) {
                break;
            }
        }
        DonatePayPassReward donatePayPassReward = (DonatePayPassReward) obj;
        if (donatePayPassReward == null || !donatePayPassReward.getCanClaim() || DonatePayPassState.isSeasonExpired$default(donatePayPassState, 0L, 1, null) || isPending(i) || (function1 = this.onClaimLevel) == null) {
            return;
        }
        this.pendingUntil.put(Integer.valueOf(i), Long.valueOf(SystemClock.elapsedRealtime() + 10000));
        schedulePendingTimeout();
        bindTiers(donatePayPassState);
        function1.invoke(Integer.valueOf(i));
    }

    private final boolean isPending(int i) {
        Long l = this.pendingUntil.get(Integer.valueOf(i));
        if (l != null) {
            if (l.longValue() <= SystemClock.elapsedRealtime()) {
                this.pendingUntil.remove(Integer.valueOf(i));
                return false;
            }
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void schedulePendingTimeout() {
        this.mainHandler.removeCallbacks(this.pendingTimeoutRunnable);
        Long l = (Long) CollectionsKt.minOrNull((Iterable<? extends Comparable>) this.pendingUntil.values());
        if (l != null) {
            this.mainHandler.postDelayed(this.pendingTimeoutRunnable, RangesKt.coerceAtLeast(l.longValue() - SystemClock.elapsedRealtime(), 0L));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void showLocalInfo() {
        CustomCardView paypassInfoButton = this.binding.paypassInfoButton;
        Intrinsics.checkNotNullExpressionValue(paypassInfoButton, "paypassInfoButton");
        String string = getTargetActivity().getString(R.string.donate_paypass_info_title);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        String string2 = getTargetActivity().getString(R.string.donate_paypass_info_text);
        Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
        showTooltip(paypassInfoButton, string, string2);
    }

    private final void showTooltip(View view, String str, String str2) {
        if (view.isAttachedToWindow()) {
            dismissTooltip();
            DonatePayPassTooltipBinding inflate = DonatePayPassTooltipBinding.inflate(this.inflater);
            Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
            TextView paypassTooltipTitle = inflate.paypassTooltipTitle;
            Intrinsics.checkNotNullExpressionValue(paypassTooltipTitle, "paypassTooltipTitle");
            String str3 = str;
            paypassTooltipTitle.setVisibility(StringsKt.isBlank(str3) ? 8 : 0);
            inflate.paypassTooltipTitle.setText(str3);
            TextView paypassTooltipDescription = inflate.paypassTooltipDescription;
            Intrinsics.checkNotNullExpressionValue(paypassTooltipDescription, "paypassTooltipDescription");
            String str4 = str2;
            paypassTooltipDescription.setVisibility(StringsKt.isBlank(str4) ? 8 : 0);
            inflate.paypassTooltipDescription.setText(str4);
            inflate.getRoot().measure(View.MeasureSpec.makeMeasureSpec(getTargetActivity().getResources().getDisplayMetrics().widthPixels, Integer.MIN_VALUE), View.MeasureSpec.makeMeasureSpec(0, 0));
            final PopupWindow popupWindow = new PopupWindow((View) inflate.getRoot(), -2, -2, true);
            popupWindow.setBackgroundDrawable(new ColorDrawable(0));
            popupWindow.setOutsideTouchable(true);
            popupWindow.setElevation(getTargetActivity().getResources().getDimension(R.dimen._2sdp));
            inflate.getRoot().setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.commonui.elements.donate.presentation.pages.DonatePayPass$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    popupWindow.dismiss();
                }
            });
            popupWindow.setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: ru.mrlargha.commonui.elements.donate.presentation.pages.DonatePayPass$$ExternalSyntheticLambda1
                @Override // android.widget.PopupWindow.OnDismissListener
                public final void onDismiss() {
                    DonatePayPass.showTooltip$lambda$2(DonatePayPass.this, popupWindow);
                }
            });
            this.tooltipPopup = popupWindow;
            this.tooltipAnchor = view;
            popupWindow.showAsDropDown(view, (view.getWidth() - inflate.getRoot().getMeasuredWidth()) / 2, -(view.getHeight() + inflate.getRoot().getMeasuredHeight() + getTargetActivity().getResources().getDimensionPixelSize(R.dimen._4sdp)), 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final void showTooltip$lambda$2(DonatePayPass donatePayPass, PopupWindow popupWindow) {
        if (donatePayPass.tooltipPopup == popupWindow) {
            donatePayPass.tooltipPopup = null;
            donatePayPass.tooltipAnchor = null;
        }
    }

    private final void dismissTooltip() {
        PopupWindow popupWindow = this.tooltipPopup;
        if (popupWindow != null) {
            popupWindow.dismiss();
        }
        this.tooltipPopup = null;
        this.tooltipAnchor = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: DonatePayPass.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\rR\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bX\u0086T¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lru/mrlargha/commonui/elements/donate/presentation/pages/DonatePayPass$Companion;", "", "<init>", "()V", "COUNTDOWN_INTERVAL_MS", "", "PENDING_TIMEOUT_MS", "GOLD", "", "MUTED_WHITE", "isDescendant", "", "root", "Landroid/view/View;", "child", "CommonUI"}, k = 1, mv = {2, 4, 0}, xi = 48)
    /* loaded from: classes6.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final boolean isDescendant(View root, View child) {
            Intrinsics.checkNotNullParameter(root, "root");
            Intrinsics.checkNotNullParameter(child, "child");
            while (child != null) {
                if (child == root) {
                    return true;
                }
                ViewParent parent = child.getParent();
                child = parent instanceof View ? (View) parent : null;
            }
            return false;
        }
    }
}
