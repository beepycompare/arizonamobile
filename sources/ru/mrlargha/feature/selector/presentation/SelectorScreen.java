package ru.mrlargha.feature.selector.presentation;

import android.app.Activity;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.SimpleItemAnimator;
import com.google.gson.JsonParseException;
import io.appmetrica.analytics.networktasks.internal.CommonUrlParts;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import ru.mrlargha.commonui.core.SAMPUIElement;
import ru.mrlargha.commonui.core.UIElementAbstractSpawner;
import ru.mrlargha.commonui.core.UIElementID;
import ru.mrlargha.commonui.utils.MapperKt;
import ru.mrlargha.commonui.utils.ui.CustomCardView;
import ru.mrlargha.commonui.utils.ui.money.MoneyElementKt;
import ru.mrlargha.feature.selector.R;
import ru.mrlargha.feature.selector.databinding.SelectorScreenBinding;
import ru.mrlargha.feature.selector.presentation.adapters.SelectorIndicatorAdapter;
import ru.mrlargha.feature.selector.presentation.adapters.SelectorInfoAdapter;
import ru.mrlargha.feature.selector.presentation.models.SelectorModel;
/* compiled from: SelectorScreen.kt */
@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0003\u0018\u00002\u00020\u0001:\u0001-B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001bH\u0016J\u0018\u0010\u001c\u001a\u00020\u00192\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u0005H\u0016J\b\u0010 \u001a\u00020\u0019H\u0002J\b\u0010!\u001a\u00020\u0019H\u0002J\b\u0010\"\u001a\u00020\u0019H\u0002J\b\u0010#\u001a\u00020\u0019H\u0002J\u0010\u0010$\u001a\u00020\u00192\u0006\u0010%\u001a\u00020&H\u0002J\f\u0010'\u001a\u00020\u0019*\u00020(H\u0002J\f\u0010)\u001a\u00020\u0019*\u00020(H\u0002J\u0016\u0010*\u001a\b\u0012\u0004\u0012\u00020\u00050+2\u0006\u0010,\u001a\u00020\u0005H\u0002R\u0016\u0010\b\u001a\n \n*\u0004\u0018\u00010\t0\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006."}, d2 = {"Lru/mrlargha/feature/selector/presentation/SelectorScreen;", "Lru/mrlargha/commonui/core/SAMPUIElement;", "targetActivity", "Landroid/app/Activity;", "backendId", "", "<init>", "(Landroid/app/Activity;I)V", "screen", "Landroid/view/View;", "kotlin.jvm.PlatformType", "binding", "Lru/mrlargha/feature/selector/databinding/SelectorScreenBinding;", "indicatorAdapter", "Lru/mrlargha/feature/selector/presentation/adapters/SelectorIndicatorAdapter;", "infoAdapter", "Lru/mrlargha/feature/selector/presentation/adapters/SelectorInfoAdapter;", "currentId", "maxId", "scope", "Lkotlinx/coroutines/CoroutineScope;", "timerJob", "Lkotlinx/coroutines/Job;", "timerCount", "setVisibility", "", "visible", "", "onBackendMessageHandled", "data", "", "subId", "initialize", "setupListeners", "startTimer", "setDefaultScreen", "setData", CommonUrlParts.MODEL, "Lru/mrlargha/feature/selector/presentation/models/SelectorModel;", "setGreenButtonType", "Lru/mrlargha/commonui/utils/ui/CustomCardView;", "setGreyButtonType", "generateIndicatorList", "", "max", "Spawner", "selector"}, k = 1, mv = {2, 3, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class SelectorScreen extends SAMPUIElement {
    private final SelectorScreenBinding binding;
    private int currentId;
    private final SelectorIndicatorAdapter indicatorAdapter;
    private final SelectorInfoAdapter infoAdapter;
    private int maxId;
    private CoroutineScope scope;
    private final View screen;
    private int timerCount;
    private Job timerJob;

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setupListeners$lambda$0$0(View view) {
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SelectorScreen(Activity targetActivity, int i) {
        super(targetActivity, i);
        Intrinsics.checkNotNullParameter(targetActivity, "targetActivity");
        View screen = targetActivity.getLayoutInflater().inflate(R.layout.selector_screen, (ViewGroup) null);
        this.screen = screen;
        SelectorScreenBinding bind = SelectorScreenBinding.bind(screen);
        Intrinsics.checkNotNullExpressionValue(bind, "bind(...)");
        this.binding = bind;
        this.indicatorAdapter = new SelectorIndicatorAdapter();
        this.infoAdapter = new SelectorInfoAdapter();
        this.currentId = -1;
        this.scope = CoroutineScopeKt.CoroutineScope(Dispatchers.getIO());
        Intrinsics.checkNotNullExpressionValue(screen, "screen");
        addViewToConstraintLayout(screen, -1, -1);
        initialize();
    }

    @Override // ru.mrlargha.commonui.core.SAMPUIElement
    public void setVisibility(boolean z) {
        super.setVisibility(z);
        if (z) {
            return;
        }
        setDefaultScreen();
    }

    private final void initialize() {
        SelectorScreenBinding selectorScreenBinding = this.binding;
        selectorScreenBinding.rvIndicators.setAdapter(this.indicatorAdapter);
        selectorScreenBinding.rvInfo.setAdapter(this.infoAdapter);
        RecyclerView.ItemAnimator itemAnimator = selectorScreenBinding.rvIndicators.getItemAnimator();
        SimpleItemAnimator simpleItemAnimator = itemAnimator instanceof SimpleItemAnimator ? (SimpleItemAnimator) itemAnimator : null;
        if (simpleItemAnimator != null) {
            simpleItemAnimator.setMoveDuration(0L);
        }
        setupListeners();
    }

    private final void setupListeners() {
        SelectorScreenBinding selectorScreenBinding = this.binding;
        selectorScreenBinding.getRoot().setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.feature.selector.presentation.SelectorScreen$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SelectorScreen.setupListeners$lambda$0$0(view);
            }
        });
        selectorScreenBinding.btnSlideLeft.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.feature.selector.presentation.SelectorScreen$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SelectorScreen.setupListeners$lambda$0$1(SelectorScreen.this, view);
            }
        });
        selectorScreenBinding.btnSlideRight.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.feature.selector.presentation.SelectorScreen$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SelectorScreen.setupListeners$lambda$0$2(SelectorScreen.this, view);
            }
        });
        selectorScreenBinding.btnDecline.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.feature.selector.presentation.SelectorScreen$$ExternalSyntheticLambda3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SelectorScreen.setupListeners$lambda$0$3(SelectorScreen.this, view);
            }
        });
        selectorScreenBinding.btnConfirm.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.feature.selector.presentation.SelectorScreen$$ExternalSyntheticLambda4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SelectorScreen.setupListeners$lambda$0$4(SelectorScreen.this, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setupListeners$lambda$0$1(SelectorScreen selectorScreen, View view) {
        int i = selectorScreen.currentId;
        if (i <= 0) {
            selectorScreen.currentId = selectorScreen.maxId;
        } else {
            selectorScreen.currentId = i - 1;
        }
        selectorScreen.indicatorAdapter.setSelectedId(selectorScreen.currentId);
        selectorScreen.startTimer();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setupListeners$lambda$0$2(SelectorScreen selectorScreen, View view) {
        int i = selectorScreen.currentId;
        if (i >= selectorScreen.maxId) {
            selectorScreen.currentId = 0;
        } else {
            selectorScreen.currentId = i + 1;
        }
        selectorScreen.indicatorAdapter.setSelectedId(selectorScreen.currentId);
        selectorScreen.startTimer();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setupListeners$lambda$0$3(SelectorScreen selectorScreen, View view) {
        SAMPUIElement.notifyClick$default(selectorScreen, selectorScreen.currentId, 2, null, 4, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setupListeners$lambda$0$4(SelectorScreen selectorScreen, View view) {
        SAMPUIElement.notifyClick$default(selectorScreen, selectorScreen.currentId, 1, null, 4, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void startTimer() {
        Job launch$default;
        Job job = this.timerJob;
        if (job != null) {
            Job.cancel$default(job, (CancellationException) null, 1, (Object) null);
        }
        launch$default = BuildersKt__Builders_commonKt.launch$default(this.scope, null, null, new SelectorScreen$startTimer$1(this, null), 3, null);
        this.timerJob = launch$default;
    }

    private final void setDefaultScreen() {
        this.currentId = -1;
        this.maxId = 0;
        Job job = this.timerJob;
        if (job != null) {
            Job.cancel$default(job, (CancellationException) null, 1, (Object) null);
        }
        this.timerJob = null;
        this.timerCount = 0;
    }

    private final void setData(SelectorModel selectorModel) {
        SelectorScreenBinding selectorScreenBinding = this.binding;
        if (this.currentId == -1) {
            this.indicatorAdapter.submitList(generateIndicatorList(selectorModel.getMaxIndex() + 1));
        }
        this.indicatorAdapter.setSelectedId(selectorModel.getCurrentIndex());
        this.currentId = selectorModel.getCurrentIndex();
        this.maxId = selectorModel.getMaxIndex();
        selectorScreenBinding.tvTitle.setText(selectorModel.getTitle());
        TextView tvTitle = selectorScreenBinding.tvTitle;
        Intrinsics.checkNotNullExpressionValue(tvTitle, "tvTitle");
        tvTitle.setVisibility(selectorModel.getTitle().length() > 0 ? 0 : 8);
        selectorScreenBinding.tvMoney.setText(MoneyElementKt.toMoneyFormattedSpannable$default(selectorModel.getPrice(), false, null, null, 7, null));
        LinearLayout moneyContainer = selectorScreenBinding.moneyContainer;
        Intrinsics.checkNotNullExpressionValue(moneyContainer, "moneyContainer");
        moneyContainer.setVisibility(selectorModel.getPrice() <= 0 ? 4 : 0);
        selectorScreenBinding.tvDecline.setText(selectorModel.getDeclineButton().getName());
        selectorScreenBinding.tvConfirm.setText(selectorModel.getConfirmButton().getName());
        if (selectorModel.getDeclineButton().getStyle() == 0) {
            CustomCardView btnDecline = selectorScreenBinding.btnDecline;
            Intrinsics.checkNotNullExpressionValue(btnDecline, "btnDecline");
            setGreyButtonType(btnDecline);
        } else {
            CustomCardView btnDecline2 = selectorScreenBinding.btnDecline;
            Intrinsics.checkNotNullExpressionValue(btnDecline2, "btnDecline");
            setGreenButtonType(btnDecline2);
        }
        int style = selectorModel.getConfirmButton().getStyle();
        CustomCardView btnConfirm = selectorScreenBinding.btnConfirm;
        Intrinsics.checkNotNullExpressionValue(btnConfirm, "btnConfirm");
        if (style == 0) {
            setGreyButtonType(btnConfirm);
        } else {
            setGreenButtonType(btnConfirm);
        }
        this.infoAdapter.submitList(selectorModel.getAdditionalInfo());
    }

    private final void setGreenButtonType(CustomCardView customCardView) {
        CustomCardView.setBackground$default(customCardView, Color.parseColor("#A8CC30"), Color.parseColor("#5D8436"), null, null, 12, null);
    }

    private final void setGreyButtonType(CustomCardView customCardView) {
        customCardView.setBackground(Color.parseColor("#4DFFFFFF"));
    }

    private final List<Integer> generateIndicatorList(int i) {
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < i; i2++) {
            arrayList.add(Integer.valueOf(i2));
        }
        return arrayList;
    }

    /* compiled from: SelectorScreen.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016R\u001a\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Lru/mrlargha/feature/selector/presentation/SelectorScreen$Spawner;", "Lru/mrlargha/commonui/core/UIElementAbstractSpawner;", "<init>", "()V", "create", "Lru/mrlargha/commonui/core/SAMPUIElement;", "targetActivity", "Landroid/app/Activity;", "backendID", "", "correctIds", "", "Lru/mrlargha/commonui/core/UIElementID;", "getCorrectIds", "()Ljava/util/Set;", "selector"}, k = 1, mv = {2, 3, 0}, xi = 48)
    /* loaded from: classes6.dex */
    public static final class Spawner extends UIElementAbstractSpawner {
        private final Set<UIElementID> correctIds = SetsKt.setOf(UIElementID.SELECTOR);

        @Override // ru.mrlargha.commonui.core.UIElementAbstractSpawner
        public SAMPUIElement create(Activity targetActivity, int i) {
            Intrinsics.checkNotNullParameter(targetActivity, "targetActivity");
            return new SelectorScreen(targetActivity, i);
        }

        @Override // ru.mrlargha.commonui.core.UIElementAbstractSpawner
        public Set<UIElementID> getCorrectIds() {
            return this.correctIds;
        }
    }

    @Override // ru.mrlargha.commonui.core.SAMPUIElement
    public void onBackendMessageHandled(String data, int i) {
        Intrinsics.checkNotNullParameter(data, "data");
        if (i == 0) {
            if (MapperKt.isJsonValid(data)) {
                setData((SelectorModel) MapperKt.getGson().fromJson(data, (Class<Object>) SelectorModel.class));
                return;
            }
            throw new JsonParseException("Json is not valid");
        }
    }
}
