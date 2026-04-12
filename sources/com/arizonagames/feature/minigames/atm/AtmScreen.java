package com.arizonagames.feature.minigames.atm;

import android.app.Activity;
import android.graphics.Color;
import android.graphics.Rect;
import android.os.Handler;
import android.os.Looper;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.media3.extractor.text.ttml.TtmlNode;
import com.arizonagames.feature.minigames.atm.databinding.AtmScreenBinding;
import com.arizonagames.feature.minigames.atm.databinding.AtmScreenChickenBinding;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.ArrayList;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.random.Random;
import kotlin.ranges.RangesKt;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import ru.mrlargha.commonui.core.SAMPUIElement;
import ru.mrlargha.commonui.core.UIElementAbstractSpawner;
import ru.mrlargha.commonui.core.UIElementID;
import ru.mrlargha.commonui.utils.MapperKt;
/* compiled from: AtmScreen.kt */
@Metadata(d1 = {"\u0000\u008c\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010\u0007\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0001PB\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\u001e\u001a\u00020\u001fH\u0002J\b\u0010 \u001a\u00020\u001fH\u0002J\u0018\u0010!\u001a\u00020\u001f2\u0006\u0010\"\u001a\u00020\u00122\u0006\u0010#\u001a\u00020\u001dH\u0002J\b\u0010$\u001a\u00020\u001fH\u0002J\u0018\u0010%\u001a\u00020\u001f2\u0006\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020'H\u0002J\u0018\u0010)\u001a\u00020\u001f2\u0006\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020'H\u0002J\u0018\u0010*\u001a\u00020\u001f2\u0006\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020'H\u0002J\u0010\u0010+\u001a\u00020\u001f2\u0006\u0010\"\u001a\u00020\u0012H\u0002J\b\u0010,\u001a\u00020\u001fH\u0002J&\u0010-\u001a\u00020\u001f2\u0006\u0010\"\u001a\u00020\u00122\u0006\u0010.\u001a\u00020\u00142\f\u0010/\u001a\b\u0012\u0004\u0012\u00020\u001f00H\u0002J\u001e\u00101\u001a\u00020\u001f2\u0006\u0010.\u001a\u00020\u00142\f\u0010/\u001a\b\u0012\u0004\u0012\u00020\u001f00H\u0002J\u0010\u00102\u001a\u00020\u001f2\u0006\u0010\"\u001a\u00020\u0012H\u0002J\u0010\u00103\u001a\u00020\u001f2\u0006\u0010\"\u001a\u00020\u0012H\u0002J\u0010\u00104\u001a\u0002052\u0006\u0010\"\u001a\u00020\u0012H\u0002J\u0010\u00106\u001a\u00020\u001f2\u0006\u0010\"\u001a\u00020\u0012H\u0002J\b\u00107\u001a\u00020\u001fH\u0002J\b\u00108\u001a\u00020\u001fH\u0002J\u0010\u00109\u001a\u00020\u001f2\u0006\u0010:\u001a\u00020\u0016H\u0002J \u0010;\u001a\u00020\u001f2\u0006\u0010\"\u001a\u00020\u00122\u0006\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020'H\u0002J\b\u0010<\u001a\u00020\u001fH\u0002J\u0010\u0010=\u001a\u00020\u001f2\u0006\u0010>\u001a\u00020\u0016H\u0002J\b\u0010?\u001a\u00020\u001fH\u0002J\u001a\u0010@\u001a\u0004\u0018\u00010\u00122\u0006\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020'H\u0002J\u001c\u0010A\u001a\u000e\u0012\u0004\u0012\u00020'\u0012\u0004\u0012\u00020'0B2\u0006\u0010C\u001a\u000205H\u0002J\u0010\u0010D\u001a\u00020\u001d2\u0006\u0010E\u001a\u000205H\u0002J\b\u0010F\u001a\u00020\u001fH\u0002J\u0018\u0010G\u001a\u00020\u001f2\u0006\u0010H\u001a\u00020I2\u0006\u0010J\u001a\u00020\u0005H\u0016J\u0012\u0010K\u001a\u00020\u001f2\b\u0010H\u001a\u0004\u0018\u00010LH\u0002J\u0010\u0010M\u001a\u00020\u001f2\u0006\u0010\u0010\u001a\u00020\u0005H\u0002J\u0010\u0010N\u001a\u00020\u001f2\u0006\u0010O\u001a\u00020\u0016H\u0016R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0005X\u0082D¢\u0006\u0002\n\u0000R\u001a\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u001a0\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u001b\u001a\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u001d0\u001cX\u0082.¢\u0006\u0002\n\u0000¨\u0006Q"}, d2 = {"Lcom/arizonagames/feature/minigames/atm/AtmScreen;", "Lru/mrlargha/commonui/core/SAMPUIElement;", "targetActivity", "Landroid/app/Activity;", "backendID", "", "<init>", "(Landroid/app/Activity;I)V", "baseScreen", "Landroid/widget/FrameLayout;", "binding", "Lcom/arizonagames/feature/minigames/atm/MiniGameScreenViews;", "mainHandler", "Landroid/os/Handler;", "finishTarget", "successCount", "type", "currentDraggedNominal", "Lcom/arizonagames/feature/minigames/atm/BillNominal;", "currentDraggedBillView", "Landroid/widget/ImageView;", "isDragging", "", "maxVisibleBillsInSlot", "slotStates", "", "Lcom/arizonagames/feature/minigames/atm/SlotState;", "slotViews", "", "Lcom/arizonagames/feature/minigames/atm/SlotViews;", "setupUi", "", "setupSlotsVisual", "setupSlot", "nominal", "slot", "setupTouchHandling", "tryStartDrag", "rawX", "", "rawY", "updateDraggedPosition", "finishDrag", "onCorrectDrop", "onWrongDrop", "animateBillToSlot", "dragView", "onEnd", "Lkotlin/Function0;", "animateBillFadeOut", "animateTrayCycle", "refreshSlotBills", "getDropTargetBillView", "Landroid/view/View;", "selectSlotForNominal", "clearSelectedSlots", "updateProgress", "showStatus", FirebaseAnalytics.Param.SUCCESS, "createDragBillView", "removeDragBillView", "resetDragState", "removeView", "resetDragFlagsOnly", "findSlotUnderPoint", "getViewCenterOnScreen", "Lkotlin/Pair;", "view", "makeSlot", TtmlNode.RUBY_CONTAINER, "closeScreen", "onBackendMessage", "data", "", "subId", "setData", "Lcom/arizonagames/feature/minigames/atm/AtmData;", "setType", "setVisibility", "visible", "Spawner", "atm"}, k = 1, mv = {2, 3, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class AtmScreen extends SAMPUIElement {
    private final FrameLayout baseScreen;
    private MiniGameScreenViews binding;
    private ImageView currentDraggedBillView;
    private BillNominal currentDraggedNominal;
    private int finishTarget;
    private boolean isDragging;
    private final Handler mainHandler;
    private final int maxVisibleBillsInSlot;
    private Map<BillNominal, SlotState> slotStates;
    private Map<BillNominal, SlotViews> slotViews;
    private int successCount;
    private int type;

    /* compiled from: AtmScreen.kt */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[BillNominal.values().length];
            try {
                iArr[BillNominal.ONE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[BillNominal.TEN.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[BillNominal.FIFTY.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[BillNominal.HUNDRED.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AtmScreen(Activity targetActivity, int i) {
        super(targetActivity, i);
        Intrinsics.checkNotNullParameter(targetActivity, "targetActivity");
        View inflate = targetActivity.getLayoutInflater().inflate(R.layout.atm_screen_base_layout, (ViewGroup) null);
        Intrinsics.checkNotNull(inflate, "null cannot be cast to non-null type android.widget.FrameLayout");
        FrameLayout frameLayout = (FrameLayout) inflate;
        this.baseScreen = frameLayout;
        this.mainHandler = new Handler(Looper.getMainLooper());
        this.finishTarget = 50;
        this.maxVisibleBillsInSlot = 4;
        this.slotStates = MapsKt.mutableMapOf(TuplesKt.to(BillNominal.ONE, new SlotState(BillNominal.ONE, R.drawable.atm_slot_1, R.drawable.atm_slot_1_selected, false, 0, 24, null)), TuplesKt.to(BillNominal.TEN, new SlotState(BillNominal.TEN, R.drawable.atm_slot_2, R.drawable.atm_slot_2_selected, false, 0, 24, null)), TuplesKt.to(BillNominal.FIFTY, new SlotState(BillNominal.FIFTY, R.drawable.atm_slot_3, R.drawable.atm_slot_3_selected, false, 0, 24, null)), TuplesKt.to(BillNominal.HUNDRED, new SlotState(BillNominal.HUNDRED, R.drawable.atm_slot_4, R.drawable.atm_slot_4_selected, false, 0, 24, null)));
        addViewToConstraintLayout(frameLayout, -1, -1);
    }

    private final void setupUi() {
        setupSlotsVisual();
        updateProgress();
        MiniGameScreenViews miniGameScreenViews = this.binding;
        if (miniGameScreenViews == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            miniGameScreenViews = null;
        }
        miniGameScreenViews.getStatusText().setText("");
    }

    private final void setupSlotsVisual() {
        for (BillNominal billNominal : BillNominal.getEntries()) {
            Map<BillNominal, SlotViews> map = this.slotViews;
            if (map == null) {
                Intrinsics.throwUninitializedPropertyAccessException("slotViews");
                map = null;
            }
            setupSlot(billNominal, (SlotViews) MapsKt.getValue(map, billNominal));
        }
        clearSelectedSlots();
    }

    private final void setupSlot(BillNominal billNominal, SlotViews slotViews) {
        slotViews.getBody().setImageResource(((SlotState) MapsKt.getValue(this.slotStates, billNominal)).getDefaultDrawableRes());
        slotViews.getTray().setTranslationY(0.0f);
        for (ImageView imageView : slotViews.getBills()) {
            imageView.setImageResource(billNominal.billDrawableRes(this.type));
            imageView.setVisibility(4);
            imageView.setAlpha(1.0f);
            imageView.setScaleX(1.0f);
            imageView.setScaleY(1.0f);
        }
    }

    private final void setupTouchHandling() {
        MiniGameScreenViews miniGameScreenViews = this.binding;
        MiniGameScreenViews miniGameScreenViews2 = null;
        if (miniGameScreenViews == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            miniGameScreenViews = null;
        }
        miniGameScreenViews.getBagTouchArea().setOnTouchListener(new View.OnTouchListener() { // from class: com.arizonagames.feature.minigames.atm.AtmScreen$$ExternalSyntheticLambda11
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                return AtmScreen.setupTouchHandling$lambda$0(AtmScreen.this, view, motionEvent);
            }
        });
        MiniGameScreenViews miniGameScreenViews3 = this.binding;
        if (miniGameScreenViews3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            miniGameScreenViews2 = miniGameScreenViews3;
        }
        miniGameScreenViews2.getRoot().setOnTouchListener(new View.OnTouchListener() { // from class: com.arizonagames.feature.minigames.atm.AtmScreen$$ExternalSyntheticLambda12
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                return AtmScreen.setupTouchHandling$lambda$1(AtmScreen.this, view, motionEvent);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final boolean setupTouchHandling$lambda$0(AtmScreen atmScreen, View view, MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            atmScreen.tryStartDrag(motionEvent.getRawX(), motionEvent.getRawY());
            return true;
        }
        if (actionMasked != 1) {
            if (actionMasked == 2) {
                atmScreen.updateDraggedPosition(motionEvent.getRawX(), motionEvent.getRawY());
                return true;
            } else if (actionMasked != 3) {
                return false;
            }
        }
        atmScreen.finishDrag(motionEvent.getRawX(), motionEvent.getRawY());
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final boolean setupTouchHandling$lambda$1(AtmScreen atmScreen, View view, MotionEvent motionEvent) {
        if (atmScreen.isDragging) {
            int actionMasked = motionEvent.getActionMasked();
            if (actionMasked != 1) {
                if (actionMasked == 2) {
                    atmScreen.updateDraggedPosition(motionEvent.getRawX(), motionEvent.getRawY());
                    return true;
                } else if (actionMasked != 3) {
                    return false;
                }
            }
            atmScreen.finishDrag(motionEvent.getRawX(), motionEvent.getRawY());
            return true;
        }
        return false;
    }

    private final void tryStartDrag(float f, float f2) {
        if (this.isDragging) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (Object obj : this.slotStates.values()) {
            if (!((SlotState) obj).isBusy()) {
                arrayList.add(obj);
            }
        }
        ArrayList<SlotState> arrayList2 = arrayList;
        ArrayList arrayList3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList2, 10));
        for (SlotState slotState : arrayList2) {
            arrayList3.add(slotState.getNominal());
        }
        ArrayList arrayList4 = arrayList3;
        if (arrayList4.isEmpty()) {
            showStatus(false);
            return;
        }
        BillNominal billNominal = (BillNominal) CollectionsKt.random(arrayList4, Random.Default);
        this.currentDraggedNominal = billNominal;
        this.isDragging = true;
        createDragBillView(billNominal, f, f2);
        selectSlotForNominal(billNominal);
    }

    private final void updateDraggedPosition(float f, float f2) {
        ImageView imageView = this.currentDraggedBillView;
        if (imageView == null) {
            return;
        }
        imageView.setX(f - (imageView.getWidth() / 2.0f));
        imageView.setY(f2 - (imageView.getHeight() / 2.0f));
    }

    private final void finishDrag(float f, float f2) {
        final BillNominal billNominal = this.currentDraggedNominal;
        ImageView imageView = this.currentDraggedBillView;
        clearSelectedSlots();
        if (!this.isDragging || billNominal == null || imageView == null) {
            resetDragState(true);
            return;
        }
        BillNominal findSlotUnderPoint = findSlotUnderPoint(f, f2);
        if (findSlotUnderPoint == billNominal && !((SlotState) MapsKt.getValue(this.slotStates, findSlotUnderPoint)).isBusy()) {
            animateBillToSlot(billNominal, imageView, new Function0() { // from class: com.arizonagames.feature.minigames.atm.AtmScreen$$ExternalSyntheticLambda2
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return AtmScreen.finishDrag$lambda$0(AtmScreen.this, billNominal);
                }
            });
        } else {
            animateBillFadeOut(imageView, new Function0() { // from class: com.arizonagames.feature.minigames.atm.AtmScreen$$ExternalSyntheticLambda3
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return AtmScreen.finishDrag$lambda$1(AtmScreen.this);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit finishDrag$lambda$0(AtmScreen atmScreen, BillNominal billNominal) {
        atmScreen.onCorrectDrop(billNominal);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit finishDrag$lambda$1(AtmScreen atmScreen) {
        atmScreen.onWrongDrop();
        return Unit.INSTANCE;
    }

    private final void onCorrectDrop(BillNominal billNominal) {
        SlotState slotState = (SlotState) MapsKt.getValue(this.slotStates, billNominal);
        slotState.setBusy(true);
        slotState.setBillsCount(slotState.getBillsCount() + 1);
        refreshSlotBills(billNominal);
        this.successCount++;
        updateProgress();
        showStatus(true);
        removeDragBillView();
        resetDragFlagsOnly();
        animateTrayCycle(billNominal);
        if (this.successCount >= this.finishTarget) {
            SAMPUIElement.notifyClick$default(this, 2, 2, null, 4, null);
        }
    }

    private final void onWrongDrop() {
        showStatus(false);
        resetDragState(true);
    }

    private final void animateBillToSlot(BillNominal billNominal, ImageView imageView, final Function0<Unit> function0) {
        Pair<Float, Float> viewCenterOnScreen = getViewCenterOnScreen(getDropTargetBillView(billNominal));
        imageView.animate().x(viewCenterOnScreen.getFirst().floatValue() - (imageView.getWidth() / 2.0f)).y(viewCenterOnScreen.getSecond().floatValue() - (imageView.getHeight() / 2.0f)).scaleX(0.88f).scaleY(0.88f).setDuration(220L).setInterpolator(new DecelerateInterpolator()).withEndAction(new Runnable() { // from class: com.arizonagames.feature.minigames.atm.AtmScreen$$ExternalSyntheticLambda5
            @Override // java.lang.Runnable
            public final void run() {
                Function0.this.invoke();
            }
        }).start();
    }

    private final void animateBillFadeOut(ImageView imageView, final Function0<Unit> function0) {
        imageView.animate().alpha(0.0f).scaleX(0.82f).scaleY(0.82f).setDuration(140L).withEndAction(new Runnable() { // from class: com.arizonagames.feature.minigames.atm.AtmScreen$$ExternalSyntheticLambda6
            @Override // java.lang.Runnable
            public final void run() {
                Function0.this.invoke();
            }
        }).start();
    }

    private final void animateTrayCycle(final BillNominal billNominal) {
        Map<BillNominal, SlotViews> map = this.slotViews;
        if (map == null) {
            Intrinsics.throwUninitializedPropertyAccessException("slotViews");
            map = null;
        }
        final SlotViews slotViews = (SlotViews) MapsKt.getValue(map, billNominal);
        final SlotState slotState = (SlotState) MapsKt.getValue(this.slotStates, billNominal);
        slotViews.getTray().animate().cancel();
        slotViews.getTray().animate().translationY((-slotViews.getTray().getHeight()) * 0.88f).setDuration(320L).setInterpolator(new AccelerateDecelerateInterpolator()).withEndAction(new Runnable() { // from class: com.arizonagames.feature.minigames.atm.AtmScreen$$ExternalSyntheticLambda7
            @Override // java.lang.Runnable
            public final void run() {
                r0.mainHandler.postDelayed(new Runnable() { // from class: com.arizonagames.feature.minigames.atm.AtmScreen$$ExternalSyntheticLambda8
                    @Override // java.lang.Runnable
                    public final void run() {
                        AtmScreen.animateTrayCycle$lambda$0$0(SlotState.this, r2, r3, r4);
                    }
                }, 5000L);
            }
        }).start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void animateTrayCycle$lambda$0$0(final SlotState slotState, AtmScreen atmScreen, BillNominal billNominal, SlotViews slotViews) {
        slotState.setBillsCount(0);
        atmScreen.refreshSlotBills(billNominal);
        slotViews.getTray().animate().translationY(0.0f).setDuration(320L).setInterpolator(new AccelerateDecelerateInterpolator()).withEndAction(new Runnable() { // from class: com.arizonagames.feature.minigames.atm.AtmScreen$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                SlotState.this.setBusy(false);
            }
        }).start();
    }

    private final void refreshSlotBills(BillNominal billNominal) {
        Map<BillNominal, SlotViews> map = this.slotViews;
        if (map == null) {
            Intrinsics.throwUninitializedPropertyAccessException("slotViews");
            map = null;
        }
        int coerceAtMost = RangesKt.coerceAtMost(((SlotState) MapsKt.getValue(this.slotStates, billNominal)).getBillsCount(), this.maxVisibleBillsInSlot);
        int i = 0;
        for (Object obj : ((SlotViews) MapsKt.getValue(map, billNominal)).getBills()) {
            int i2 = i + 1;
            if (i < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            ImageView imageView = (ImageView) obj;
            if (i < coerceAtMost) {
                imageView.setImageResource(billNominal.billDrawableRes(this.type));
                imageView.setVisibility(0);
            } else {
                imageView.setVisibility(4);
            }
            i = i2;
        }
    }

    private final View getDropTargetBillView(BillNominal billNominal) {
        Map<BillNominal, SlotViews> map = this.slotViews;
        if (map == null) {
            Intrinsics.throwUninitializedPropertyAccessException("slotViews");
            map = null;
        }
        return ((SlotViews) MapsKt.getValue(map, billNominal)).getBills().get(RangesKt.coerceAtMost(((SlotState) MapsKt.getValue(this.slotStates, billNominal)).getBillsCount(), this.maxVisibleBillsInSlot - 1));
    }

    private final void selectSlotForNominal(BillNominal billNominal) {
        for (Map.Entry<BillNominal, SlotState> entry : this.slotStates.entrySet()) {
            BillNominal key = entry.getKey();
            SlotState value = entry.getValue();
            Map<BillNominal, SlotViews> map = this.slotViews;
            if (map == null) {
                Intrinsics.throwUninitializedPropertyAccessException("slotViews");
                map = null;
            }
            ((SlotViews) MapsKt.getValue(map, key)).getBody().setImageResource(key == billNominal ? value.getSelectedDrawableRes() : value.getDefaultDrawableRes());
        }
    }

    private final void clearSelectedSlots() {
        for (Map.Entry<BillNominal, SlotState> entry : this.slotStates.entrySet()) {
            BillNominal key = entry.getKey();
            SlotState value = entry.getValue();
            Map<BillNominal, SlotViews> map = this.slotViews;
            if (map == null) {
                Intrinsics.throwUninitializedPropertyAccessException("slotViews");
                map = null;
            }
            ((SlotViews) MapsKt.getValue(map, key)).getBody().setImageResource(value.getDefaultDrawableRes());
        }
    }

    private final void updateProgress() {
        MiniGameScreenViews miniGameScreenViews = this.binding;
        if (miniGameScreenViews == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            miniGameScreenViews = null;
        }
        TextView progressText = miniGameScreenViews.getProgressText();
        int i = this.successCount;
        progressText.setText(i + "/" + this.finishTarget);
    }

    private final void showStatus(boolean z) {
        int parseColor;
        if (z) {
            parseColor = Color.parseColor("#A8FF57");
        } else {
            parseColor = Color.parseColor("#FF4A4A");
        }
        SAMPUIElement.notifyClick$default(this, this.successCount, 1, null, 4, null);
        MiniGameScreenViews miniGameScreenViews = this.binding;
        MiniGameScreenViews miniGameScreenViews2 = null;
        if (miniGameScreenViews == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            miniGameScreenViews = null;
        }
        miniGameScreenViews.getBgResult().setImageResource(z ? R.drawable.atm_bg_success : R.drawable.atm_bg_error);
        MiniGameScreenViews miniGameScreenViews3 = this.binding;
        if (miniGameScreenViews3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            miniGameScreenViews3 = null;
        }
        miniGameScreenViews3.getStatusText().animate().cancel();
        MiniGameScreenViews miniGameScreenViews4 = this.binding;
        if (miniGameScreenViews4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            miniGameScreenViews4 = null;
        }
        miniGameScreenViews4.getStatusText().setText(z ? "УСПЕШНО!" : "ОШИБКА!");
        MiniGameScreenViews miniGameScreenViews5 = this.binding;
        if (miniGameScreenViews5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            miniGameScreenViews5 = null;
        }
        miniGameScreenViews5.getStatusText().setTextColor(parseColor);
        MiniGameScreenViews miniGameScreenViews6 = this.binding;
        if (miniGameScreenViews6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            miniGameScreenViews6 = null;
        }
        miniGameScreenViews6.getStatusText().setAlpha(0.0f);
        MiniGameScreenViews miniGameScreenViews7 = this.binding;
        if (miniGameScreenViews7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            miniGameScreenViews7 = null;
        }
        miniGameScreenViews7.getStatusText().setScaleX(0.92f);
        MiniGameScreenViews miniGameScreenViews8 = this.binding;
        if (miniGameScreenViews8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            miniGameScreenViews8 = null;
        }
        miniGameScreenViews8.getStatusText().setScaleY(0.92f);
        MiniGameScreenViews miniGameScreenViews9 = this.binding;
        if (miniGameScreenViews9 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            miniGameScreenViews9 = null;
        }
        miniGameScreenViews9.getStatusText().animate().alpha(1.0f).scaleX(1.0f).scaleY(1.0f).setDuration(120L).withEndAction(new Runnable() { // from class: com.arizonagames.feature.minigames.atm.AtmScreen$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                AtmScreen.showStatus$lambda$0(AtmScreen.this);
            }
        }).start();
        MiniGameScreenViews miniGameScreenViews10 = this.binding;
        if (miniGameScreenViews10 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            miniGameScreenViews2 = miniGameScreenViews10;
        }
        miniGameScreenViews2.getBgResult().animate().alpha(1.0f).scaleX(1.0f).scaleY(1.0f).setDuration(120L).withEndAction(new Runnable() { // from class: com.arizonagames.feature.minigames.atm.AtmScreen$$ExternalSyntheticLambda4
            @Override // java.lang.Runnable
            public final void run() {
                AtmScreen.showStatus$lambda$1(AtmScreen.this);
            }
        }).start();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final void showStatus$lambda$0(AtmScreen atmScreen) {
        MiniGameScreenViews miniGameScreenViews = atmScreen.binding;
        if (miniGameScreenViews == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            miniGameScreenViews = null;
        }
        miniGameScreenViews.getStatusText().animate().alpha(0.0f).setStartDelay(700L).setDuration(250L).start();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final void showStatus$lambda$1(AtmScreen atmScreen) {
        MiniGameScreenViews miniGameScreenViews = atmScreen.binding;
        if (miniGameScreenViews == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            miniGameScreenViews = null;
        }
        miniGameScreenViews.getBgResult().animate().alpha(0.0f).setStartDelay(700L).setDuration(250L).start();
    }

    private final void createDragBillView(BillNominal billNominal, final float f, final float f2) {
        FrameLayout.LayoutParams layoutParams;
        removeDragBillView();
        if (this.type == 0) {
            layoutParams = new FrameLayout.LayoutParams(getTargetActivity().getResources().getDimensionPixelSize(ru.mrlargha.commonui.R.dimen._70sdp), getTargetActivity().getResources().getDimensionPixelSize(ru.mrlargha.commonui.R.dimen._140sdp));
        } else {
            int i = WhenMappings.$EnumSwitchMapping$0[billNominal.ordinal()];
            if (i == 1) {
                layoutParams = new FrameLayout.LayoutParams(getTargetActivity().getResources().getDimensionPixelSize(ru.mrlargha.commonui.R.dimen._60sdp), getTargetActivity().getResources().getDimensionPixelSize(ru.mrlargha.commonui.R.dimen._60sdp));
            } else if (i == 2) {
                layoutParams = new FrameLayout.LayoutParams(getTargetActivity().getResources().getDimensionPixelSize(ru.mrlargha.commonui.R.dimen._50sdp), getTargetActivity().getResources().getDimensionPixelSize(ru.mrlargha.commonui.R.dimen._50sdp));
            } else if (i == 3) {
                layoutParams = new FrameLayout.LayoutParams(getTargetActivity().getResources().getDimensionPixelSize(ru.mrlargha.commonui.R.dimen._40sdp), getTargetActivity().getResources().getDimensionPixelSize(ru.mrlargha.commonui.R.dimen._40sdp));
            } else if (i != 4) {
                throw new NoWhenBranchMatchedException();
            } else {
                layoutParams = new FrameLayout.LayoutParams(getTargetActivity().getResources().getDimensionPixelSize(ru.mrlargha.commonui.R.dimen._30sdp), getTargetActivity().getResources().getDimensionPixelSize(ru.mrlargha.commonui.R.dimen._30sdp));
            }
        }
        final ImageView imageView = new ImageView(getTargetActivity());
        imageView.setImageResource(billNominal.billDrawableRes(this.type));
        imageView.setLayoutParams(layoutParams);
        imageView.setElevation(999.0f);
        imageView.setAlpha(1.0f);
        MiniGameScreenViews miniGameScreenViews = this.binding;
        if (miniGameScreenViews == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            miniGameScreenViews = null;
        }
        ImageView imageView2 = imageView;
        miniGameScreenViews.getDragLayer().addView(imageView2);
        if (imageView2.isLaidOut() && !imageView2.isLayoutRequested()) {
            imageView.setX(f - (imageView.getWidth() / 2.0f));
            imageView.setY(f2 - (imageView.getHeight() / 2.0f));
        } else {
            imageView2.addOnLayoutChangeListener(new View.OnLayoutChangeListener() { // from class: com.arizonagames.feature.minigames.atm.AtmScreen$createDragBillView$$inlined$doOnLayout$1
                @Override // android.view.View.OnLayoutChangeListener
                public void onLayoutChange(View view, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9) {
                    view.removeOnLayoutChangeListener(this);
                    ImageView imageView3 = imageView;
                    imageView3.setX(f - (imageView3.getWidth() / 2.0f));
                    ImageView imageView4 = imageView;
                    imageView4.setY(f2 - (imageView4.getHeight() / 2.0f));
                }
            });
        }
        this.currentDraggedBillView = imageView;
    }

    private final void removeDragBillView() {
        ImageView imageView = this.currentDraggedBillView;
        if (imageView != null) {
            ViewParent parent = imageView.getParent();
            ViewGroup viewGroup = parent instanceof ViewGroup ? (ViewGroup) parent : null;
            if (viewGroup != null) {
                viewGroup.removeView(imageView);
            }
        }
        this.currentDraggedBillView = null;
    }

    private final void resetDragState(boolean z) {
        this.isDragging = false;
        this.currentDraggedNominal = null;
        if (z) {
            removeDragBillView();
        }
    }

    private final void resetDragFlagsOnly() {
        this.isDragging = false;
        this.currentDraggedNominal = null;
    }

    private final BillNominal findSlotUnderPoint(float f, float f2) {
        int dimensionPixelSize = getTargetActivity().getResources().getDimensionPixelSize(ru.mrlargha.commonui.R.dimen._8sdp);
        Map<BillNominal, SlotViews> map = this.slotViews;
        if (map == null) {
            Intrinsics.throwUninitializedPropertyAccessException("slotViews");
            map = null;
        }
        for (Map.Entry<BillNominal, SlotViews> entry : map.entrySet()) {
            BillNominal key = entry.getKey();
            Rect rect = new Rect();
            entry.getValue().getContainer().getGlobalVisibleRect(rect);
            int i = -dimensionPixelSize;
            rect.inset(i, i);
            if (rect.contains(MathKt.roundToInt(f), MathKt.roundToInt(f2))) {
                return key;
            }
        }
        return null;
    }

    private final Pair<Float, Float> getViewCenterOnScreen(View view) {
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        return new Pair<>(Float.valueOf(iArr[0] + (view.getWidth() / 2.0f)), Float.valueOf(iArr[1] + (view.getHeight() / 2.0f)));
    }

    private final SlotViews makeSlot(View view) {
        View findViewById = view.findViewById(R.id.tray);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(...)");
        View findViewById2 = view.findViewById(R.id.slotBody);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(...)");
        return new SlotViews(view, findViewById, (ImageView) findViewById2, CollectionsKt.listOf(view.findViewById(R.id.slotBill1)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void closeScreen() {
        SAMPUIElement.notifyClick$default(this, 0, 0, null, 4, null);
    }

    private final void setData(AtmData atmData) {
        if (atmData == null) {
            return;
        }
        setType(atmData.getType());
        this.finishTarget = RangesKt.coerceAtLeast(atmData.getMaxCount(), 1);
        this.successCount = RangesKt.coerceAtMost(RangesKt.coerceAtLeast(atmData.getCount(), 0), this.finishTarget);
        updateProgress();
        if (this.successCount >= this.finishTarget) {
            this.mainHandler.post(new Runnable() { // from class: com.arizonagames.feature.minigames.atm.AtmScreen$$ExternalSyntheticLambda10
                @Override // java.lang.Runnable
                public final void run() {
                    AtmScreen.this.closeScreen();
                }
            });
        }
    }

    private final void setType(int i) {
        this.type = i;
        MiniGameScreenViews miniGameScreenViews = null;
        if (i == 0) {
            View inflate = getTargetActivity().getLayoutInflater().inflate(R.layout.atm_screen, (ViewGroup) null);
            AtmScreenBinding bind = AtmScreenBinding.bind(inflate);
            Intrinsics.checkNotNullExpressionValue(bind, "bind(...)");
            this.binding = new AtmMiniGameScreenViews(bind);
            this.baseScreen.removeAllViews();
            this.baseScreen.addView(inflate, -1, -1);
            this.slotStates = MapsKt.mutableMapOf(TuplesKt.to(BillNominal.ONE, new SlotState(BillNominal.ONE, R.drawable.atm_slot_1, R.drawable.atm_slot_1_selected, false, 0, 24, null)), TuplesKt.to(BillNominal.TEN, new SlotState(BillNominal.TEN, R.drawable.atm_slot_2, R.drawable.atm_slot_2_selected, false, 0, 24, null)), TuplesKt.to(BillNominal.FIFTY, new SlotState(BillNominal.FIFTY, R.drawable.atm_slot_3, R.drawable.atm_slot_3_selected, false, 0, 24, null)), TuplesKt.to(BillNominal.HUNDRED, new SlotState(BillNominal.HUNDRED, R.drawable.atm_slot_4, R.drawable.atm_slot_4_selected, false, 0, 24, null)));
        } else if (i == 1) {
            View inflate2 = getTargetActivity().getLayoutInflater().inflate(R.layout.atm_screen_chicken, (ViewGroup) null);
            AtmScreenChickenBinding bind2 = AtmScreenChickenBinding.bind(inflate2);
            Intrinsics.checkNotNullExpressionValue(bind2, "bind(...)");
            this.binding = new AtmMiniGameScreenViewsChicken(bind2);
            this.baseScreen.removeAllViews();
            this.baseScreen.addView(inflate2, -1, -1);
            this.slotStates = MapsKt.mutableMapOf(TuplesKt.to(BillNominal.ONE, new SlotState(BillNominal.ONE, R.drawable.atm_slot_chicken, R.drawable.atm_slot_selected_chicken, false, 0, 24, null)), TuplesKt.to(BillNominal.TEN, new SlotState(BillNominal.TEN, R.drawable.atm_slot_chicken, R.drawable.atm_slot_selected_chicken, false, 0, 24, null)), TuplesKt.to(BillNominal.FIFTY, new SlotState(BillNominal.FIFTY, R.drawable.atm_slot_chicken, R.drawable.atm_slot_selected_chicken, false, 0, 24, null)), TuplesKt.to(BillNominal.HUNDRED, new SlotState(BillNominal.HUNDRED, R.drawable.atm_slot_chicken, R.drawable.atm_slot_selected_chicken, false, 0, 24, null)));
        }
        Pair[] pairArr = new Pair[4];
        BillNominal billNominal = BillNominal.ONE;
        MiniGameScreenViews miniGameScreenViews2 = this.binding;
        if (miniGameScreenViews2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            miniGameScreenViews2 = null;
        }
        pairArr[0] = TuplesKt.to(billNominal, makeSlot(miniGameScreenViews2.getSlot1Container()));
        BillNominal billNominal2 = BillNominal.TEN;
        MiniGameScreenViews miniGameScreenViews3 = this.binding;
        if (miniGameScreenViews3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            miniGameScreenViews3 = null;
        }
        pairArr[1] = TuplesKt.to(billNominal2, makeSlot(miniGameScreenViews3.getSlot10Container()));
        BillNominal billNominal3 = BillNominal.FIFTY;
        MiniGameScreenViews miniGameScreenViews4 = this.binding;
        if (miniGameScreenViews4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            miniGameScreenViews4 = null;
        }
        pairArr[2] = TuplesKt.to(billNominal3, makeSlot(miniGameScreenViews4.getSlot50Container()));
        BillNominal billNominal4 = BillNominal.HUNDRED;
        MiniGameScreenViews miniGameScreenViews5 = this.binding;
        if (miniGameScreenViews5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            miniGameScreenViews5 = null;
        }
        pairArr[3] = TuplesKt.to(billNominal4, makeSlot(miniGameScreenViews5.getSlot100Container()));
        this.slotViews = MapsKt.mapOf(pairArr);
        setupUi();
        setupTouchHandling();
        MiniGameScreenViews miniGameScreenViews6 = this.binding;
        if (miniGameScreenViews6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            miniGameScreenViews = miniGameScreenViews6;
        }
        miniGameScreenViews.getClose().setOnClickListener(new View.OnClickListener() { // from class: com.arizonagames.feature.minigames.atm.AtmScreen$$ExternalSyntheticLambda9
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AtmScreen.this.closeScreen();
            }
        });
    }

    @Override // ru.mrlargha.commonui.core.SAMPUIElement
    public void setVisibility(boolean z) {
        super.setVisibility(z);
        if (z) {
            return;
        }
        clearSelectedSlots();
        resetDragState(true);
        for (SlotState slotState : this.slotStates.values()) {
            slotState.setBusy(false);
            slotState.setBillsCount(0);
        }
        for (BillNominal billNominal : BillNominal.getEntries()) {
            Map<BillNominal, SlotViews> map = this.slotViews;
            if (map == null) {
                Intrinsics.throwUninitializedPropertyAccessException("slotViews");
                map = null;
            }
            SlotViews slotViews = map.get(billNominal);
            if (slotViews != null) {
                slotViews.getTray().animate().cancel();
                slotViews.getTray().setTranslationY(0.0f);
                refreshSlotBills(billNominal);
            }
        }
        this.baseScreen.removeAllViews();
    }

    /* compiled from: AtmScreen.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016R\u001a\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Lcom/arizonagames/feature/minigames/atm/AtmScreen$Spawner;", "Lru/mrlargha/commonui/core/UIElementAbstractSpawner;", "<init>", "()V", "create", "Lru/mrlargha/commonui/core/SAMPUIElement;", "targetActivity", "Landroid/app/Activity;", "backendID", "", "correctIds", "", "Lru/mrlargha/commonui/core/UIElementID;", "getCorrectIds", "()Ljava/util/Set;", "atm"}, k = 1, mv = {2, 3, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class Spawner extends UIElementAbstractSpawner {
        private final Set<UIElementID> correctIds = SetsKt.setOf(UIElementID.ATM_MINIGAME);

        @Override // ru.mrlargha.commonui.core.UIElementAbstractSpawner
        public SAMPUIElement create(Activity targetActivity, int i) {
            Intrinsics.checkNotNullParameter(targetActivity, "targetActivity");
            return new AtmScreen(targetActivity, i);
        }

        @Override // ru.mrlargha.commonui.core.UIElementAbstractSpawner
        public Set<UIElementID> getCorrectIds() {
            return this.correctIds;
        }
    }

    @Override // ru.mrlargha.commonui.core.SAMPUIElement
    public void onBackendMessage(String data, int i) {
        Intrinsics.checkNotNullParameter(data, "data");
        if (i == 0) {
            setData((AtmData) ((!MapperKt.isJsonValid(data) || Intrinsics.areEqual(data, AbstractJsonLexerKt.NULL) || Intrinsics.areEqual(data, "{}") || data.length() == 0) ? null : MapperKt.getGson().fromJson(data, (Class<Object>) AtmData.class)));
        }
    }
}
