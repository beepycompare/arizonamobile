package ru.mrlargha.arizona.promo;

import android.app.Activity;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.graphics.Color;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import androidx.core.app.NotificationCompat;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonParseException;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import ru.mrlargha.commonui.core.SAMPUIElement;
import ru.mrlargha.commonui.core.UIElementAbstractSpawner;
import ru.mrlargha.commonui.core.UIElementID;
import ru.mrlargha.commonui.elements.authorization.presentation.InterfaceController;
import ru.mrlargha.commonui.utils.MapperKt;
import ru.mrlargha.feature.arizona.promo.R;
import ru.mrlargha.feature.arizona.promo.databinding.ActivationPageBinding;
import ru.mrlargha.feature.arizona.promo.databinding.LevelLockerBinding;
import ru.mrlargha.feature.arizona.promo.databinding.ManagementBinding;
import ru.mrlargha.feature.arizona.promo.databinding.PromoDetailsBinding;
import ru.mrlargha.feature.arizona.promo.databinding.PromoMainBinding;
import ru.mrlargha.feature.arizona.promo.databinding.ReferalsBinding;
import ru.mrlargha.feature.arizona.promo.databinding.TopbarBinding;
/* compiled from: PromoScreen.kt */
@Metadata(d1 = {"\u0000\u0084\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002:\u0002=>B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 H\u0016J\u0018\u0010!\u001a\u00020\u001e2\u0006\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020\u0006H\u0016J\b\u0010%\u001a\u00020\u001eH\u0002J\u0010\u0010&\u001a\u00020\u001e2\u0006\u0010'\u001a\u00020(H\u0002J\u0010\u0010)\u001a\u00020\u001e2\u0006\u0010'\u001a\u00020*H\u0002J\u0010\u0010+\u001a\u00020\u001e2\u0006\u0010'\u001a\u00020*H\u0002J\u0016\u0010,\u001a\u00020\u001e2\f\u0010\"\u001a\b\u0012\u0004\u0012\u00020(0-H\u0002J\u0010\u0010.\u001a\u00020\u001e2\u0006\u0010\"\u001a\u00020/H\u0002J\u0010\u00100\u001a\u00020\u001e2\u0006\u0010\"\u001a\u000201H\u0002J\u0010\u00102\u001a\u00020\u001e2\u0006\u0010\"\u001a\u00020\u001cH\u0002J\u0017\u00103\u001a\u00020\u001e2\b\u0010\"\u001a\u0004\u0018\u00010\u0006H\u0002¢\u0006\u0002\u00104J\u0010\u00105\u001a\u00020\u001e2\u0006\u0010\"\u001a\u00020#H\u0002J\u0010\u00106\u001a\u00020\u001e2\u0006\u0010\"\u001a\u00020\u001cH\u0002J\b\u00107\u001a\u00020\u001eH\u0002J\b\u00108\u001a\u00020\u001eH\u0002J\u0010\u00109\u001a\u00020\u001e2\u0006\u0010:\u001a\u00020;H\u0002J\u0010\u0010<\u001a\u00020\u001e2\u0006\u0010:\u001a\u00020;H\u0002R\u0016\u0010\t\u001a\n \u000b*\u0004\u0018\u00010\n0\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0015\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\u0018\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0017R\u000e\u0010\u001a\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u001cX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006?"}, d2 = {"Lru/mrlargha/arizona/promo/ArizonaPromoScreen;", "Lru/mrlargha/commonui/core/SAMPUIElement;", "Lru/mrlargha/commonui/elements/authorization/presentation/InterfaceController;", "targetActivity", "Landroid/app/Activity;", "backendID", "", "<init>", "(Landroid/app/Activity;I)V", "screen", "Landroid/view/View;", "kotlin.jvm.PlatformType", "binding", "Lru/mrlargha/feature/arizona/promo/databinding/PromoMainBinding;", "promoAdapter", "Lru/mrlargha/arizona/promo/PromoAdapter;", "promoManagementAdapter", "Lru/mrlargha/arizona/promo/ManagementItemsAdapter;", "refProgressAdapter", "Lru/mrlargha/arizona/promo/ProgressItemsAdapter;", "activateProgressAdapter", "doneColor", "getDoneColor", "()I", "undoneColor", "getUndoneColor", "activateId", "locker", "Lru/mrlargha/arizona/promo/PromoLevelLocker;", "setVisible", "", "visible", "", "onBackendMessage", "data", "", "subId", "setupNavigation", "onSelectPromoItem", "item", "Lru/mrlargha/arizona/promo/PromoItem;", "onGetActivateItem", "Lru/mrlargha/arizona/promo/PromoReward;", "onRefItem", "setActivationPage", "", "setManagementPage", "Lru/mrlargha/arizona/promo/PromoManagement;", "setRefPage", "Lru/mrlargha/arizona/promo/ReferralResponse;", "setLevelLocker", "openPromo", "(Ljava/lang/Integer;)V", "setPromo", "checkLocker", "setupAdapters", "clearAdapters", "topbarNavigation", "nav", "Lru/mrlargha/arizona/promo/ArizonaPromoScreen$Navigation;", "navigateTo", "Navigation", "Spawner", "promo_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class ArizonaPromoScreen extends SAMPUIElement implements InterfaceController {
    private int activateId;
    private final ProgressItemsAdapter activateProgressAdapter;
    private final PromoMainBinding binding;
    private final int doneColor;
    private PromoLevelLocker locker;
    private final PromoAdapter promoAdapter;
    private final ManagementItemsAdapter promoManagementAdapter;
    private final ProgressItemsAdapter refProgressAdapter;
    private final View screen;
    private final int undoneColor;

    /* compiled from: PromoScreen.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[Navigation.values().length];
            try {
                iArr[Navigation.Activate.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[Navigation.Management.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[Navigation.Referals.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    private final void clearAdapters() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setupNavigation$lambda$0$0(View view) {
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ArizonaPromoScreen(Activity targetActivity, int i) {
        super(targetActivity, i);
        Intrinsics.checkNotNullParameter(targetActivity, "targetActivity");
        View screen = targetActivity.getLayoutInflater().inflate(R.layout.promo_main, (ViewGroup) null);
        this.screen = screen;
        PromoMainBinding bind = PromoMainBinding.bind(screen);
        Intrinsics.checkNotNullExpressionValue(bind, "bind(...)");
        this.binding = bind;
        this.promoAdapter = new PromoAdapter(new Function1() { // from class: ru.mrlargha.arizona.promo.ArizonaPromoScreen$$ExternalSyntheticLambda7
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit promoAdapter$lambda$0;
                promoAdapter$lambda$0 = ArizonaPromoScreen.promoAdapter$lambda$0(ArizonaPromoScreen.this, (PromoItem) obj);
                return promoAdapter$lambda$0;
            }
        });
        this.promoManagementAdapter = new ManagementItemsAdapter();
        this.refProgressAdapter = new ProgressItemsAdapter(new Function1() { // from class: ru.mrlargha.arizona.promo.ArizonaPromoScreen$$ExternalSyntheticLambda8
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit refProgressAdapter$lambda$0;
                refProgressAdapter$lambda$0 = ArizonaPromoScreen.refProgressAdapter$lambda$0(ArizonaPromoScreen.this, (PromoReward) obj);
                return refProgressAdapter$lambda$0;
            }
        });
        this.activateProgressAdapter = new ProgressItemsAdapter(new Function1() { // from class: ru.mrlargha.arizona.promo.ArizonaPromoScreen$$ExternalSyntheticLambda9
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit activateProgressAdapter$lambda$0;
                activateProgressAdapter$lambda$0 = ArizonaPromoScreen.activateProgressAdapter$lambda$0(ArizonaPromoScreen.this, (PromoReward) obj);
                return activateProgressAdapter$lambda$0;
            }
        });
        this.doneColor = Color.parseColor("#FFBF00");
        this.undoneColor = Color.parseColor("#0D1011");
        this.activateId = -1;
        Intrinsics.checkNotNullExpressionValue(screen, "screen");
        addViewToConstraintLayout(screen, -1, -1);
        setupAdapters();
        setupNavigation();
        navigateTo(Navigation.Activate);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit promoAdapter$lambda$0(ArizonaPromoScreen arizonaPromoScreen, PromoItem it) {
        Intrinsics.checkNotNullParameter(it, "it");
        SAMPUIElement.notifyClick$default(arizonaPromoScreen, it.getId(), 17, null, 4, null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit refProgressAdapter$lambda$0(ArizonaPromoScreen arizonaPromoScreen, PromoReward it) {
        Intrinsics.checkNotNullParameter(it, "it");
        arizonaPromoScreen.onRefItem(it);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit activateProgressAdapter$lambda$0(ArizonaPromoScreen arizonaPromoScreen, PromoReward it) {
        Intrinsics.checkNotNullParameter(it, "it");
        arizonaPromoScreen.onGetActivateItem(it);
        return Unit.INSTANCE;
    }

    public final int getDoneColor() {
        return this.doneColor;
    }

    public final int getUndoneColor() {
        return this.undoneColor;
    }

    @Override // ru.mrlargha.commonui.elements.authorization.presentation.InterfaceController
    public void setVisible(boolean z) {
        clearAdapters();
        this.binding.getRoot().setVisibility(z ? 0 : 8);
        navigateTo(Navigation.Activate);
    }

    @Override // ru.mrlargha.commonui.core.SAMPUIElement
    public void onBackendMessage(String data, int i) {
        Intrinsics.checkNotNullParameter(data, "data");
        try {
            switch (i) {
                case 1:
                    setActivationPage(MapperKt.toListModel(data, PromoItem.class));
                    return;
                case 2:
                    setManagementPage((PromoManagement) MapperKt.toModel(data, PromoManagement.class));
                    return;
                case 3:
                    setRefPage((ReferralResponse) MapperKt.toModel(data, ReferralResponse.class));
                    return;
                case 4:
                    if (MapperKt.isJsonValid(data)) {
                        setLevelLocker((PromoLevelLocker) new GsonBuilder().setLenient().create().fromJson(data, (Class<Object>) PromoLevelLocker.class));
                        return;
                    }
                    throw new JsonParseException("Json is not valid");
                case 5:
                    setPromo(data);
                    return;
                case 6:
                    openPromo(StringsKt.toIntOrNull(data));
                    return;
                default:
                    return;
            }
        } catch (Exception e) {
            Log.d("promo_rodina", data + "  " + e.getMessage());
            e.printStackTrace();
            Toast.makeText(getTargetActivity().getApplicationContext(), "Ошибка в интерфейсе : " + getBackendID(), 1).show();
        }
    }

    private final void setupNavigation() {
        PromoMainBinding promoMainBinding = this.binding;
        promoMainBinding.getRoot().setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.arizona.promo.ArizonaPromoScreen$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ArizonaPromoScreen.setupNavigation$lambda$0$0(view);
            }
        });
        TopbarBinding topbarBinding = promoMainBinding.topbar;
        topbarBinding.activateCard.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.arizona.promo.ArizonaPromoScreen$$ExternalSyntheticLambda16
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ArizonaPromoScreen.setupNavigation$lambda$0$1$0(ArizonaPromoScreen.this, view);
            }
        });
        topbarBinding.managementCard.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.arizona.promo.ArizonaPromoScreen$$ExternalSyntheticLambda17
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ArizonaPromoScreen.setupNavigation$lambda$0$1$1(ArizonaPromoScreen.this, view);
            }
        });
        topbarBinding.refsCard.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.arizona.promo.ArizonaPromoScreen$$ExternalSyntheticLambda18
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ArizonaPromoScreen.setupNavigation$lambda$0$1$2(ArizonaPromoScreen.this, view);
            }
        });
        topbarBinding.close.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.arizona.promo.ArizonaPromoScreen$$ExternalSyntheticLambda19
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ArizonaPromoScreen.setupNavigation$lambda$0$1$3(ArizonaPromoScreen.this, view);
            }
        });
        final ActivationPageBinding activationPageBinding = promoMainBinding.activate;
        activationPageBinding.detailsButton.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.arizona.promo.ArizonaPromoScreen$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ArizonaPromoScreen.setupNavigation$lambda$0$2$0(ArizonaPromoScreen.this, view);
            }
        });
        activationPageBinding.sendButton.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.arizona.promo.ArizonaPromoScreen$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ArizonaPromoScreen.setupNavigation$lambda$0$2$1(ActivationPageBinding.this, this, view);
            }
        });
        activationPageBinding.editText.addTextChangedListener(new TextWatcher() { // from class: ru.mrlargha.arizona.promo.ArizonaPromoScreen$setupNavigation$1$3$3
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                Editable editable2 = editable;
                if (editable2 == null || editable2.length() == 0) {
                    ActivationPageBinding.this.sendButton.performClick();
                }
            }
        });
        ManagementBinding managementBinding = promoMainBinding.management;
        managementBinding.info.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.arizona.promo.ArizonaPromoScreen$$ExternalSyntheticLambda3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ArizonaPromoScreen.setupNavigation$lambda$0$3$0(ArizonaPromoScreen.this, view);
            }
        });
        managementBinding.edit.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.arizona.promo.ArizonaPromoScreen$$ExternalSyntheticLambda4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ArizonaPromoScreen.setupNavigation$lambda$0$3$1(ArizonaPromoScreen.this, view);
            }
        });
        managementBinding.upgrade.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.arizona.promo.ArizonaPromoScreen$$ExternalSyntheticLambda5
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ArizonaPromoScreen.setupNavigation$lambda$0$3$2(ArizonaPromoScreen.this, view);
            }
        });
        managementBinding.buttonInfo.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.arizona.promo.ArizonaPromoScreen$$ExternalSyntheticLambda11
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ArizonaPromoScreen.setupNavigation$lambda$0$3$3(ArizonaPromoScreen.this, view);
            }
        });
        this.binding.topbar.getButton.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.arizona.promo.ArizonaPromoScreen$$ExternalSyntheticLambda12
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ArizonaPromoScreen.setupNavigation$lambda$0$4(ArizonaPromoScreen.this, view);
            }
        });
        ReferalsBinding referalsBinding = promoMainBinding.referals;
        referalsBinding.info.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.arizona.promo.ArizonaPromoScreen$$ExternalSyntheticLambda13
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ArizonaPromoScreen.setupNavigation$lambda$0$5$0(ArizonaPromoScreen.this, view);
            }
        });
        referalsBinding.listRefs.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.arizona.promo.ArizonaPromoScreen$$ExternalSyntheticLambda14
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ArizonaPromoScreen.setupNavigation$lambda$0$5$1(ArizonaPromoScreen.this, view);
            }
        });
        referalsBinding.editRefs.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.arizona.promo.ArizonaPromoScreen$$ExternalSyntheticLambda15
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ArizonaPromoScreen.setupNavigation$lambda$0$5$2(ArizonaPromoScreen.this, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setupNavigation$lambda$0$1$0(ArizonaPromoScreen arizonaPromoScreen, View view) {
        arizonaPromoScreen.navigateTo(Navigation.Activate);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setupNavigation$lambda$0$1$1(ArizonaPromoScreen arizonaPromoScreen, View view) {
        arizonaPromoScreen.navigateTo(Navigation.Management);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setupNavigation$lambda$0$1$2(ArizonaPromoScreen arizonaPromoScreen, View view) {
        arizonaPromoScreen.navigateTo(Navigation.Referals);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setupNavigation$lambda$0$1$3(ArizonaPromoScreen arizonaPromoScreen, View view) {
        arizonaPromoScreen.getNotifier().setUIElementVisible(arizonaPromoScreen.getBackendID(), false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setupNavigation$lambda$0$2$0(ArizonaPromoScreen arizonaPromoScreen, View view) {
        SAMPUIElement.notifyClick$default(arizonaPromoScreen, 0, 1, null, 4, null);
        arizonaPromoScreen.navigateTo(Navigation.Referals);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setupNavigation$lambda$0$2$1(ActivationPageBinding activationPageBinding, ArizonaPromoScreen arizonaPromoScreen, View view) {
        activationPageBinding.editText.clearFocus();
        arizonaPromoScreen.notifyClick(0, 3, activationPageBinding.editText.getText().toString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setupNavigation$lambda$0$3$0(ArizonaPromoScreen arizonaPromoScreen, View view) {
        SAMPUIElement.notifyClick$default(arizonaPromoScreen, 0, 5, null, 4, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setupNavigation$lambda$0$3$1(ArizonaPromoScreen arizonaPromoScreen, View view) {
        SAMPUIElement.notifyClick$default(arizonaPromoScreen, 0, 6, null, 4, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setupNavigation$lambda$0$3$2(ArizonaPromoScreen arizonaPromoScreen, View view) {
        SAMPUIElement.notifyClick$default(arizonaPromoScreen, 0, 7, null, 4, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setupNavigation$lambda$0$3$3(ArizonaPromoScreen arizonaPromoScreen, View view) {
        SAMPUIElement.notifyClick$default(arizonaPromoScreen, 0, 16, null, 4, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setupNavigation$lambda$0$4(ArizonaPromoScreen arizonaPromoScreen, View view) {
        SAMPUIElement.notifyClick$default(arizonaPromoScreen, 0, 8, null, 4, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setupNavigation$lambda$0$5$0(ArizonaPromoScreen arizonaPromoScreen, View view) {
        SAMPUIElement.notifyClick$default(arizonaPromoScreen, 0, 10, null, 4, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setupNavigation$lambda$0$5$1(ArizonaPromoScreen arizonaPromoScreen, View view) {
        SAMPUIElement.notifyClick$default(arizonaPromoScreen, 0, 11, null, 4, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setupNavigation$lambda$0$5$2(ArizonaPromoScreen arizonaPromoScreen, View view) {
        SAMPUIElement.notifyClick$default(arizonaPromoScreen, 0, 12, null, 4, null);
    }

    private final void onSelectPromoItem(PromoItem promoItem) {
        this.activateId = promoItem.getId();
        PromoMainBinding promoMainBinding = this.binding;
        promoMainBinding.activate.getRoot().setVisibility(8);
        promoMainBinding.promoDetails.getRoot().setVisibility(0);
        PromoDetailsBinding promoDetailsBinding = promoMainBinding.promoDetails;
        promoDetailsBinding.backToActivate.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.arizona.promo.ArizonaPromoScreen$$ExternalSyntheticLambda6
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ArizonaPromoScreen.onSelectPromoItem$lambda$0$0$0(ArizonaPromoScreen.this, view);
            }
        });
        promoDetailsBinding.title.setText(promoItem.getTitle());
        this.activateProgressAdapter.addAllItems(promoItem.getRewards());
        PromoReward promoReward = (PromoReward) CollectionsKt.firstOrNull((List<? extends Object>) promoItem.getRewards());
        if (promoReward != null) {
            if (promoReward.getAvailable() == 1 || promoReward.getReceived() == 1) {
                promoDetailsBinding.viewBeforeLevel.setBackgroundColor(this.doneColor);
            } else {
                promoDetailsBinding.viewBeforeLevel.setBackgroundColor(this.undoneColor);
            }
        }
        PromoReward promoReward2 = (PromoReward) CollectionsKt.lastOrNull((List<? extends Object>) promoItem.getRewards());
        if (promoReward2 != null) {
            if (promoReward2.getAvailable() == 1 || promoReward2.getReceived() == 1) {
                promoDetailsBinding.viewAfterLevel.setBackgroundColor(this.doneColor);
            } else {
                promoDetailsBinding.viewAfterLevel.setBackgroundColor(this.undoneColor);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onSelectPromoItem$lambda$0$0$0(ArizonaPromoScreen arizonaPromoScreen, View view) {
        arizonaPromoScreen.navigateTo(Navigation.Activate);
    }

    private final void onGetActivateItem(PromoReward promoReward) {
        notifyClick(this.activateId, 2, String.valueOf(promoReward.getId()));
    }

    private final void onRefItem(PromoReward promoReward) {
        SAMPUIElement.notifyClick$default(this, promoReward.getId(), 13, null, 4, null);
    }

    private final void setActivationPage(List<PromoItem> list) {
        PromoItem promoItem;
        this.promoAdapter.addAllItems(list);
        int i = this.activateId;
        if (i <= -1 || (promoItem = (PromoItem) CollectionsKt.getOrNull(list, i)) == null) {
            return;
        }
        this.activateProgressAdapter.addAllItems(promoItem.getRewards());
    }

    private final void setManagementPage(final PromoManagement promoManagement) {
        ManagementBinding managementBinding = this.binding.management;
        managementBinding.title.setText(promoManagement.getPromo());
        managementBinding.currentLv.setText(String.valueOf(promoManagement.getCurrentLvl()));
        managementBinding.maxLv.setText("/" + promoManagement.getMaxLvl());
        managementBinding.rating.setText(String.valueOf(promoManagement.getPosition()));
        managementBinding.activation.setText(String.valueOf(promoManagement.getActivations()));
        this.promoManagementAdapter.addAllItems(promoManagement.getCurrentRewards());
        managementBinding.copy.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.arizona.promo.ArizonaPromoScreen$$ExternalSyntheticLambda10
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ArizonaPromoScreen.setManagementPage$lambda$0$0(ArizonaPromoScreen.this, promoManagement, view);
            }
        });
        this.binding.topbar.coins.setText(String.valueOf(promoManagement.getCoins()));
        PromoLevelLocker promoLevelLocker = this.locker;
        if (promoLevelLocker != null) {
            checkLocker(promoLevelLocker);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setManagementPage$lambda$0$0(ArizonaPromoScreen arizonaPromoScreen, PromoManagement promoManagement, View view) {
        Object systemService = arizonaPromoScreen.getTargetActivity().getSystemService("clipboard");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.content.ClipboardManager");
        ((ClipboardManager) systemService).setPrimaryClip(ClipData.newPlainText(NotificationCompat.CATEGORY_PROMO, promoManagement.getPromo()));
        SAMPUIElement.notifyClick$default(arizonaPromoScreen, 0, 15, null, 4, null);
    }

    private final void setRefPage(ReferralResponse referralResponse) {
        ReferalsBinding referalsBinding = this.binding.referals;
        referalsBinding.title.setText(referralResponse.getName());
        referalsBinding.header.cash.setText(String.valueOf(referralResponse.getCashBack()));
        referalsBinding.header.count.setText(String.valueOf(referralResponse.getReferralsValue()));
        this.refProgressAdapter.addAllItems(referralResponse.getReferralsRewards());
        PromoReward promoReward = (PromoReward) CollectionsKt.firstOrNull((List<? extends Object>) referralResponse.getReferralsRewards());
        if (promoReward != null) {
            if (promoReward.getAvailable() == 1 || promoReward.getReceived() == 1) {
                referalsBinding.viewBeforeLevel.setBackgroundColor(this.doneColor);
            } else {
                referalsBinding.viewBeforeLevel.setBackgroundColor(this.undoneColor);
            }
        }
        PromoReward promoReward2 = (PromoReward) CollectionsKt.lastOrNull((List<? extends Object>) referralResponse.getReferralsRewards());
        if (promoReward2 != null) {
            if (promoReward2.getAvailable() == 1 || promoReward2.getReceived() == 1) {
                referalsBinding.viewAfterLevel.setBackgroundColor(this.doneColor);
            } else {
                referalsBinding.viewAfterLevel.setBackgroundColor(this.undoneColor);
            }
        }
    }

    private final void setLevelLocker(PromoLevelLocker promoLevelLocker) {
        this.locker = promoLevelLocker;
    }

    private final void openPromo(Integer num) {
        Object obj;
        if (num == null) {
            return;
        }
        if (num.intValue() == -1) {
            navigateTo(Navigation.Activate);
            return;
        }
        Iterator<T> it = this.promoAdapter.getItemsList().iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            int id = ((PromoItem) obj).getId();
            if (num != null && id == num.intValue()) {
                break;
            }
        }
        PromoItem promoItem = (PromoItem) obj;
        if (promoItem != null) {
            onSelectPromoItem(promoItem);
        }
    }

    private final void setPromo(String str) {
        this.binding.activate.editText.setText(str);
    }

    private final void checkLocker(PromoLevelLocker promoLevelLocker) {
        if (promoLevelLocker.getAvailable() == 0) {
            this.binding.management.getRoot().setVisibility(8);
            LevelLockerBinding levelLockerBinding = this.binding.levelLocker;
            levelLockerBinding.getRoot().setVisibility(0);
            levelLockerBinding.text.setText("с " + promoLevelLocker.getMinLevel() + " уровня");
            TopbarBinding topbarBinding = this.binding.topbar;
            topbarBinding.coins.setVisibility(8);
            topbarBinding.getButton.setVisibility(8);
            topbarBinding.coinsIc.setVisibility(8);
        }
    }

    private final void setupAdapters() {
        this.binding.activate.rv.setAdapter(this.promoAdapter);
        this.binding.management.rv.setAdapter(this.promoManagementAdapter);
        this.binding.referals.rv.setAdapter(this.refProgressAdapter);
        this.binding.promoDetails.rv.setAdapter(this.activateProgressAdapter);
    }

    private final void topbarNavigation(Navigation navigation) {
        int parseColor = Color.parseColor("#0D1011");
        int parseColor2 = Color.parseColor("#1E1E1E");
        TopbarBinding topbarBinding = this.binding.topbar;
        topbarBinding.activateCard.setCardBackgroundColor(parseColor);
        topbarBinding.refsCard.setCardBackgroundColor(parseColor);
        topbarBinding.managementCard.setCardBackgroundColor(parseColor);
        topbarBinding.activateText.setTextColor(-1);
        topbarBinding.refs.setTextColor(-1);
        topbarBinding.managementText.setTextColor(-1);
        topbarBinding.coins.setVisibility(8);
        topbarBinding.getButton.setVisibility(8);
        topbarBinding.coinsIc.setVisibility(8);
        int i = WhenMappings.$EnumSwitchMapping$0[navigation.ordinal()];
        if (i == 1) {
            topbarBinding.activateCard.setCardBackgroundColor(-1);
            topbarBinding.activateText.setTextColor(parseColor2);
            SAMPUIElement.notifyClick$default(this, 0, 4, null, 4, null);
        } else if (i != 2) {
            if (i != 3) {
                return;
            }
            topbarBinding.refsCard.setCardBackgroundColor(-1);
            topbarBinding.refs.setTextColor(parseColor2);
            SAMPUIElement.notifyClick$default(this, 0, 14, null, 4, null);
        } else {
            topbarBinding.managementCard.setCardBackgroundColor(-1);
            topbarBinding.managementText.setTextColor(parseColor2);
            SAMPUIElement.notifyClick$default(this, 0, 9, null, 4, null);
            topbarBinding.coins.setVisibility(0);
            topbarBinding.getButton.setVisibility(0);
            topbarBinding.coinsIc.setVisibility(0);
        }
    }

    private final void navigateTo(Navigation navigation) {
        this.binding.activate.getRoot().setVisibility(8);
        this.binding.referals.getRoot().setVisibility(8);
        this.binding.management.getRoot().setVisibility(8);
        this.binding.promoDetails.getRoot().setVisibility(8);
        this.binding.levelLocker.getRoot().setVisibility(8);
        this.binding.topbar.navContainer.setVisibility(0);
        topbarNavigation(navigation);
        int i = WhenMappings.$EnumSwitchMapping$0[navigation.ordinal()];
        if (i == 1) {
            this.binding.activate.getRoot().setVisibility(0);
        } else if (i != 2) {
            if (i != 3) {
                throw new NoWhenBranchMatchedException();
            }
            this.binding.referals.getRoot().setVisibility(0);
        } else {
            this.binding.management.getRoot().setVisibility(0);
            PromoLevelLocker promoLevelLocker = this.locker;
            if (promoLevelLocker != null) {
                checkLocker(promoLevelLocker);
            }
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* compiled from: PromoScreen.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lru/mrlargha/arizona/promo/ArizonaPromoScreen$Navigation;", "", "<init>", "(Ljava/lang/String;I)V", "Activate", "Referals", "Management", "promo_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Navigation {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ Navigation[] $VALUES;
        public static final Navigation Activate = new Navigation("Activate", 0);
        public static final Navigation Referals = new Navigation("Referals", 1);
        public static final Navigation Management = new Navigation("Management", 2);

        private static final /* synthetic */ Navigation[] $values() {
            return new Navigation[]{Activate, Referals, Management};
        }

        public static EnumEntries<Navigation> getEntries() {
            return $ENTRIES;
        }

        public static Navigation valueOf(String str) {
            return (Navigation) Enum.valueOf(Navigation.class, str);
        }

        public static Navigation[] values() {
            return (Navigation[]) $VALUES.clone();
        }

        private Navigation(String str, int i) {
        }

        static {
            Navigation[] $values = $values();
            $VALUES = $values;
            $ENTRIES = EnumEntriesKt.enumEntries($values);
        }
    }

    /* compiled from: PromoScreen.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016R\u001a\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Lru/mrlargha/arizona/promo/ArizonaPromoScreen$Spawner;", "Lru/mrlargha/commonui/core/UIElementAbstractSpawner;", "<init>", "()V", "create", "Lru/mrlargha/commonui/core/SAMPUIElement;", "targetActivity", "Landroid/app/Activity;", "backendID", "", "correctIds", "", "Lru/mrlargha/commonui/core/UIElementID;", "getCorrectIds", "()Ljava/util/Set;", "promo_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Spawner extends UIElementAbstractSpawner {
        private final Set<UIElementID> correctIds = SetsKt.setOf((Object[]) new UIElementID[]{UIElementID.RODINA_PROMO, UIElementID.ARIZONA_PROMO});

        @Override // ru.mrlargha.commonui.core.UIElementAbstractSpawner
        public SAMPUIElement create(Activity targetActivity, int i) {
            Intrinsics.checkNotNullParameter(targetActivity, "targetActivity");
            return new ArizonaPromoScreen(targetActivity, i);
        }

        @Override // ru.mrlargha.commonui.core.UIElementAbstractSpawner
        public Set<UIElementID> getCorrectIds() {
            return this.correctIds;
        }
    }
}
